package com.bytedance.ee.bear.document.comment.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.ui.n;
import du5.b;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.text.StringEscapeUtils;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ShowCardsJsData extends Result {
    public static final String ID_GLOBAL = "-1";

    @JSONField(name = "cancel_highlight")
    private boolean cancelHighlight;
    private List<Card> cards;

    @JSONField(name = "cur_comment_pos")
    private Float curCommentPos;
    private String cur_comment_id;
    private String cur_reply_id;

    @JSONField(name = "focus_card")
    private boolean focusCard;
    private String from;
    private List<Card> globalComments;
    private boolean isInPicture;
    public Per permission;
    private int position;
    private StatsExtra statsExtra;
    private String tmpCommentId;
    private String token;

    public static class StatsExtra implements Serializable {
        public String clickFrom;
        public long clickTime;

        public StatsExtra() {
        }
    }

    public Integer getCurCommentPos() {
        Float r0 = this.curCommentPos;
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(n.d(r0.intValue()));
    }

    public boolean hasCards() {
        List<Card> r0 = this.cards;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L7;
        return true;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("ShowCardsJsData{, cur_comment_id='");
        r0.append(this.cur_comment_id);
        r0.append("', tmpCommentId=");
        r0.append(b.f(this.tmpCommentId));
        r0.append(", cards.size=");
        List<Card> r1 = this.cards;
        if (r1 != null) goto L5;
        Integer r2 = null;
    L6:
        r0.append(r2);
        r0.append(", isInPicture=");
        r0.append(this.isInPicture);
        r0.append(", cancelHighlight=");
        r0.append(this.cancelHighlight);
        r0.append(", curCommentPos=");
        r0.append(this.curCommentPos);
        r0.append(", permission = ");
        r0.append(this.permission);
        r0.append(", cards=");
        r0.append(this.cards);
        r0.append('}');
        return r0.toString();
    L5:
        r2 = Integer.valueOf(r1.size());
        goto L6
    }

    public ShowCardsJsData() {
        this.focusCard = true;
        this.cancelHighlight = false;
        this.from = "";
        this.position = -1;
        this.permission = new Per();
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public String getCur_comment_id() {
        return this.cur_comment_id;
    }

    public String getCur_reply_id() {
        return this.cur_reply_id;
    }

    public String getFrom() {
        return this.from;
    }

    public List<Card> getGlobalComments() {
        return this.globalComments;
    }

    public int getPosition() {
        return this.position;
    }

    public StatsExtra getStatsExtra() {
        return this.statsExtra;
    }

    public String getTmpCommentId() {
        return this.tmpCommentId;
    }

    public String getToken() {
        return this.token;
    }

    public boolean isCancelHighlight() {
        return this.cancelHighlight;
    }

    public boolean isFocusCard() {
        return this.focusCard;
    }

    public boolean isInPicture() {
        return this.isInPicture;
    }

    public static String decodeString(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L9;
    L8:
        return r4;
    L9:
        return StringEscapeUtils.unescapeXml(r4);
    L6:
        e = move-exception;
        a.e("Comment#ShowCardsJsData", "parse exception!", e, false);
        goto L8
    }

    public void setCancelHighlight(boolean r1) {
        this.cancelHighlight = r1;
    }

    public void setCards(List<Card> r1) {
        this.cards = r1;
    }

    public void setCurCommentPos(Float r1) {
        this.curCommentPos = r1;
    }

    public void setCur_comment_id(String r1) {
        this.cur_comment_id = r1;
    }

    public void setCur_reply_id(String r1) {
        this.cur_reply_id = r1;
    }

    public void setFocusCard(boolean r1) {
        this.focusCard = r1;
    }

    public void setFrom(String r1) {
        this.from = r1;
    }

    public void setGlobalComments(List<Card> r1) {
        this.globalComments = r1;
    }

    public void setInPicture(boolean r1) {
        this.isInPicture = r1;
    }

    public void setPosition(int r1) {
        this.position = r1;
    }

    public void setStatsExtra(StatsExtra r1) {
        this.statsExtra = r1;
    }

    public void setTmpCommentId(String r1) {
        this.tmpCommentId = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }
}
