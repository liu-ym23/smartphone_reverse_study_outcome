package com.bytedance.ee.bear.middleground.comment.export.bean;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes18.dex */
public class CommentInputRequest implements Serializable {
    public static final int CREATE_COMMENT = 0;
    public static final int EDIT_COMMENT = 1;
    public static final String FROM_ADD_AREA_COMMENT = "addAreaComment";
    public static final int REPLY_COMMENT = 2;
    public Map<Object, Object> bizParams;
    public boolean canUseBlankContent;
    private int commentType;
    public String comment_id;
    public String content;
    public String directional_reply_id;
    public String doc_token;
    public String doc_url;
    public CommentBean.CommentDetail.ExtraEntity extra;
    public String from;
    public String imageId;
    public transient String inputHint;
    public boolean isDrive;
    public boolean isImageAreaComment;
    public boolean isShowAreaSelectBtn;
    public boolean is_whole;
    public boolean keyboard_pop;
    public String lastReplyId;
    public String local_comment_id;
    public boolean need_loading;
    public String parent_token;
    public String parent_type;
    public String position;
    public String quote;
    public String reply_id;
    public transient boolean restoreInputModeOnDismiss;
    public transient Boolean restoreVoiceModeOnVoiceClick;
    public boolean show_comment_image;
    public boolean show_insert_image;
    public boolean show_voice;
    public SmartReplyDataForInsert smartReplyDataForInsert;
    private StatsExtra statsExtra;
    public String tmpCommentId;
    public int type;
    public VisibilityBean visibilityBean;

    public static class StatsExtra implements Serializable {
        public String clickFrom;
        public long clickTime;

        public StatsExtra() {
        }
    }

    public String getDocToken() {
        String r100 = this.doc_token;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String getDocUrl() {
        String r100 = this.doc_url;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String getTmpCommentId() {
        String r100 = this.tmpCommentId;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(this.is_whole), this.doc_token, this.doc_url, this.content, this.comment_id, this.reply_id, Boolean.valueOf(this.show_voice), Boolean.valueOf(this.show_insert_image), Boolean.valueOf(this.show_comment_image), Integer.valueOf(this.type), this.tmpCommentId, this.quote, this.bizParams, this.position, Boolean.valueOf(this.need_loading), this.smartReplyDataForInsert, this.from});
    }

    public boolean isCreate() {
        if (this.type != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEdit() {
        if (this.type == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isReply() {
        if (this.type != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("CommentInputRequest{is_whole=");
        r100.append(this.is_whole);
        r100.append(", isDrive=");
        r100.append(this.isDrive);
        r100.append(", type=");
        r100.append(this.type);
        r100.append(", comment_id=");
        r100.append(this.comment_id);
        r100.append(", reply_id=");
        r100.append(this.reply_id);
        r100.append(", directional_reply_id=");
        r100.append(this.directional_reply_id);
        r100.append(", content length=");
        String r101 = this.content;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.length();
    L6:
        r100.append(r103);
        r100.append(", image count=");
        CommentBean.CommentDetail.ExtraEntity r104 = this.extra;
        if (r104 != null) goto L9;
    L11:
        r100.append(r102);
        r100.append(", smartReplyDataForInsert");
        if (this.smartReplyDataForInsert != null) goto L14;
        String r105 = "is null";
    L15:
        r100.append(r105);
        r100.append(", from=");
        r100.append(this.from);
        r100.append(", isShowAreaSelectBtn=");
        r100.append(this.isShowAreaSelectBtn);
        r100.append('}');
        return r100.toString();
    L14:
        r105 = "is not null";
        goto L15
    L9:
        if (r104.getImage_list() == null) goto L11;
        r102 = this.extra.getImage_list().size();
        goto L11
    L5:
        r103 = 0;
        goto L6
    }

    public CommentInputRequest() {
        this.visibilityBean = new VisibilityBean();
        this.isShowAreaSelectBtn = false;
        this.imageId = "";
        this.isImageAreaComment = false;
        this.keyboard_pop = true;
        this.isDrive = false;
        this.commentType = 0;
    }

    public int getCommentType() {
        return this.commentType;
    }

    public String getFrom() {
        return this.from;
    }

    public String getLastReplyId() {
        return this.lastReplyId;
    }

    public String getLocal_comment_id() {
        return this.local_comment_id;
    }

    public String getParent_token() {
        return this.parent_token;
    }

    public String getParent_type() {
        return this.parent_type;
    }

    public StatsExtra getStatsExtra() {
        return this.statsExtra;
    }

    public int getType() {
        return this.type;
    }

    public boolean isForWhole() {
        return this.is_whole;
    }

    public boolean isKeyboard_pop() {
        return this.keyboard_pop;
    }

    public boolean isNeed_loading() {
        return this.need_loading;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L49:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L49;
        CommentInputRequest r101 = (CommentInputRequest) r100;
        if (this.is_whole == r101.is_whole) goto L13;
    L47:
        return false;
    L13:
        if (this.show_voice != r101.show_voice) goto L47;
        if (this.type != r101.type) goto L47;
        if (this.show_comment_image != r101.show_comment_image) goto L47;
        if (this.show_insert_image != r101.show_insert_image) goto L47;
        if (this.need_loading != r101.need_loading) goto L47;
        if (Objects.equals(this.doc_token, r101.doc_token) == false) goto L47;
        if (Objects.equals(this.doc_url, r101.doc_url) == false) goto L47;
        if (Objects.equals(this.content, r101.content) == false) goto L47;
        if (Objects.equals(this.comment_id, r101.comment_id) == false) goto L47;
        if (Objects.equals(this.reply_id, r101.reply_id) == false) goto L47;
        if (Objects.equals(this.tmpCommentId, r101.tmpCommentId) == false) goto L47;
        if (Objects.equals(this.extra, r101.extra) == false) goto L47;
        if (Objects.equals(this.quote, r101.quote) == false) goto L47;
        if (Objects.equals(this.bizParams, r101.bizParams) == false) goto L47;
        if (Objects.equals(this.position, r101.position) == false) goto L47;
        if (Objects.equals(this.smartReplyDataForInsert, r101.smartReplyDataForInsert) == false) goto L47;
        if (Objects.equals(this.from, r101.from) == false) goto L47;
        return true;
    }

    public String resolveInputHint(String r100) {
        if (TextUtils.isEmpty(this.inputHint) == false) goto L6;
        return r100;
    L6:
        return this.inputHint;
    }

    public void setCommentType(int r100) {
        this.commentType = r100;
    }

    public void setFrom(String r100) {
        this.from = r100;
    }

    public void setKeyboard_pop(boolean r100) {
        this.keyboard_pop = r100;
    }

    public void setLastReplyId(String r100) {
        this.lastReplyId = r100;
    }

    public void setLocal_comment_id(String r100) {
        this.local_comment_id = r100;
    }

    public void setNeed_loading(boolean r100) {
        this.need_loading = r100;
    }

    public void setParent_token(String r100) {
        this.parent_token = r100;
    }

    public void setParent_type(String r100) {
        this.parent_type = r100;
    }

    public void setStatsExtra(StatsExtra r100) {
        this.statsExtra = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }
}
