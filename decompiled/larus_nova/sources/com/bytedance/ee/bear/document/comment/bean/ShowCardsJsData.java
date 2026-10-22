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

/* JADX INFO: loaded from: classes16.dex */
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
        Float r100 = this.curCommentPos;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(n.d(r100.intValue()));
    }

    public boolean hasCards() {
        List<Card> r100 = this.cards;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L7;
        return true;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("ShowCardsJsData{, cur_comment_id='");
        r100.append(this.cur_comment_id);
        r100.append("', tmpCommentId=");
        r100.append(b.f(this.tmpCommentId));
        r100.append(", cards.size=");
        List<Card> r101 = this.cards;
        if (r101 != null) goto L5;
        Integer r102 = null;
    L6:
        r100.append(r102);
        r100.append(", isInPicture=");
        r100.append(this.isInPicture);
        r100.append(", cancelHighlight=");
        r100.append(this.cancelHighlight);
        r100.append(", curCommentPos=");
        r100.append(this.curCommentPos);
        r100.append(", permission = ");
        r100.append(this.permission);
        r100.append(", cards=");
        r100.append(this.cards);
        r100.append('}');
        return r100.toString();
    L5:
        r102 = Integer.valueOf(r101.size());
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

    public static String decodeString(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
    L8:
        return r100;
    L9:
        return StringEscapeUtils.unescapeXml(r100);
    L6:
        e = move-exception;
        a.e("Comment#ShowCardsJsData", "parse exception!", e, false);
        goto L8
    }

    public void setCancelHighlight(boolean r100) {
        this.cancelHighlight = r100;
    }

    public void setCards(List<Card> r100) {
        this.cards = r100;
    }

    public void setCurCommentPos(Float r100) {
        this.curCommentPos = r100;
    }

    public void setCur_comment_id(String r100) {
        this.cur_comment_id = r100;
    }

    public void setCur_reply_id(String r100) {
        this.cur_reply_id = r100;
    }

    public void setFocusCard(boolean r100) {
        this.focusCard = r100;
    }

    public void setFrom(String r100) {
        this.from = r100;
    }

    public void setGlobalComments(List<Card> r100) {
        this.globalComments = r100;
    }

    public void setInPicture(boolean r100) {
        this.isInPicture = r100;
    }

    public void setPosition(int r100) {
        this.position = r100;
    }

    public void setStatsExtra(StatsExtra r100) {
        this.statsExtra = r100;
    }

    public void setTmpCommentId(String r100) {
        this.tmpCommentId = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }
}
