package com.bytedance.ee.bear.middleground.comment.export.bean;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
        String r0 = this.doc_token;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public String getDocUrl() {
        String r0 = this.doc_url;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public String getTmpCommentId() {
        String r0 = this.tmpCommentId;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
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
        StringBuilder r0 = new StringBuilder("CommentInputRequest{is_whole=");
        r0.append(this.is_whole);
        r0.append(", isDrive=");
        r0.append(this.isDrive);
        r0.append(", type=");
        r0.append(this.type);
        r0.append(", comment_id=");
        r0.append(this.comment_id);
        r0.append(", reply_id=");
        r0.append(this.reply_id);
        r0.append(", directional_reply_id=");
        r0.append(this.directional_reply_id);
        r0.append(", content length=");
        String r1 = this.content;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.length();
    L6:
        r0.append(r3);
        r0.append(", image count=");
        CommentBean.CommentDetail.ExtraEntity r4 = this.extra;
        if (r4 != null) goto L9;
    L11:
        r0.append(r2);
        r0.append(", smartReplyDataForInsert");
        if (this.smartReplyDataForInsert != null) goto L14;
        String r5 = "is null";
    L15:
        r0.append(r5);
        r0.append(", from=");
        r0.append(this.from);
        r0.append(", isShowAreaSelectBtn=");
        r0.append(this.isShowAreaSelectBtn);
        r0.append('}');
        return r0.toString();
    L14:
        r5 = "is not null";
        goto L15
    L9:
        if (r4.getImage_list() == null) goto L11;
        r2 = this.extra.getImage_list().size();
        goto L11
    L5:
        r3 = 0;
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

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L49:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L49;
        CommentInputRequest r6 = (CommentInputRequest) r5;
        if (this.is_whole == r6.is_whole) goto L13;
    L47:
        return false;
    L13:
        if (this.show_voice != r6.show_voice) goto L47;
        if (this.type != r6.type) goto L47;
        if (this.show_comment_image != r6.show_comment_image) goto L47;
        if (this.show_insert_image != r6.show_insert_image) goto L47;
        if (this.need_loading != r6.need_loading) goto L47;
        if (Objects.equals(this.doc_token, r6.doc_token) == false) goto L47;
        if (Objects.equals(this.doc_url, r6.doc_url) == false) goto L47;
        if (Objects.equals(this.content, r6.content) == false) goto L47;
        if (Objects.equals(this.comment_id, r6.comment_id) == false) goto L47;
        if (Objects.equals(this.reply_id, r6.reply_id) == false) goto L47;
        if (Objects.equals(this.tmpCommentId, r6.tmpCommentId) == false) goto L47;
        if (Objects.equals(this.extra, r6.extra) == false) goto L47;
        if (Objects.equals(this.quote, r6.quote) == false) goto L47;
        if (Objects.equals(this.bizParams, r6.bizParams) == false) goto L47;
        if (Objects.equals(this.position, r6.position) == false) goto L47;
        if (Objects.equals(this.smartReplyDataForInsert, r6.smartReplyDataForInsert) == false) goto L47;
        if (Objects.equals(this.from, r6.from) == false) goto L47;
        return true;
    }

    public String resolveInputHint(String r2) {
        if (TextUtils.isEmpty(this.inputHint) == false) goto L6;
        return r2;
    L6:
        return this.inputHint;
    }

    public void setCommentType(int r1) {
        this.commentType = r1;
    }

    public void setFrom(String r1) {
        this.from = r1;
    }

    public void setKeyboard_pop(boolean r1) {
        this.keyboard_pop = r1;
    }

    public void setLastReplyId(String r1) {
        this.lastReplyId = r1;
    }

    public void setLocal_comment_id(String r1) {
        this.local_comment_id = r1;
    }

    public void setNeed_loading(boolean r1) {
        this.need_loading = r1;
    }

    public void setParent_token(String r1) {
        this.parent_token = r1;
    }

    public void setParent_type(String r1) {
        this.parent_type = r1;
    }

    public void setStatsExtra(StatsExtra r1) {
        this.statsExtra = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }
}
