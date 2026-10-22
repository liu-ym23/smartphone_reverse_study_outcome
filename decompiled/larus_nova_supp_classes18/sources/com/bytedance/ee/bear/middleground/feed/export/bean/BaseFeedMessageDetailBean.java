package com.bytedance.ee.bear.middleground.feed.export.bean;

import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.ErrorBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.Reaction;
import com.ss.android.lark.reaction.widget.detailwindow.bean.ReactionDetailViewModel;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class BaseFeedMessageDetailBean implements BaseJSModel {
    public static final String RETRY_TYPE_ADD = "add";
    public static final String RETRY_TYPE_DELETE = "delete";
    public static final String RETRY_TYPE_REPLY = "reply";
    public static final String RETRY_TYPE_UPDATE = "update";
    private boolean anonymous;
    private String avatar_url;
    private String comment_id;
    private String content;
    private int create_timestamp;
    private DisplayName display_name;
    private ErrorBean error;
    private ExtraEntity extra;
    private boolean isEditStatus;
    private boolean isFull;
    private int is_whole;
    private int modify;
    private String name;
    protected String quote;
    private List<Reaction> reaction;
    private List<ReactionDetailViewModel> reactionDetailData;
    private List<q2c.c> reactionFlowData;
    private String reaction_type;
    private String reply_id;
    private String retryType;
    private boolean sending;
    private String translate_content;
    private String translate_status;
    private int update_timestamp;
    private String user_id;

    public static class ExtraEntity implements Serializable {
        private CommentBean.CommentDetail.ExtraEntity.AttachmentEntity attachment;
        private List<String> image_list;

        public static class AttachmentEntity implements Serializable {
            private int audio_duration;
            private String audio_file_token;

            public AttachmentEntity() {
            }

            public int hashCode() {
                return Objects.hash(new Object[]{this.audio_file_token, Integer.valueOf(this.audio_duration)});
            }

            public int getAudio_duration() {
                return this.audio_duration;
            }

            public String getAudio_file_token() {
                return this.audio_file_token;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (r5 != null) goto L8;
            L17:
                return false;
            L8:
                if (getClass() != r5.getClass()) goto L17;
                AttachmentEntity r6 = (AttachmentEntity) r5;
                if (this.audio_duration == r6.audio_duration) goto L13;
            L15:
                return false;
            L13:
                if (Objects.equals(this.audio_file_token, r6.audio_file_token) == false) goto L15;
                return true;
            }

            public void setAudio_duration(int r1) {
                this.audio_duration = r1;
            }

            public void setAudio_file_token(String r1) {
                this.audio_file_token = r1;
            }
        }

        public ExtraEntity() {
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.attachment, this.image_list});
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("ExtraEntity{, image_list=");
            List<String> r1 = this.image_list;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            r0.append(r2);
            r0.append('}');
            return r0.toString();
        L5:
            r2 = r1.size();
            goto L6
        }

        public CommentBean.CommentDetail.ExtraEntity.AttachmentEntity getAttachment() {
            return this.attachment;
        }

        public List<String> getImage_list() {
            return this.image_list;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L17:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L17;
            ExtraEntity r6 = (ExtraEntity) r5;
            if (Objects.equals(this.attachment, r6.attachment) == true) goto L13;
        L15:
            return false;
        L13:
            if (Objects.equals(this.image_list, r6.image_list) == false) goto L15;
            return true;
        }

        public void setAttachment(CommentBean.CommentDetail.ExtraEntity.AttachmentEntity r1) {
            this.attachment = r1;
        }

        public void setImage_list(List<String> r1) {
            this.image_list = r1;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TranslateStatus {
        public static final String ERROR = "error";
        public static final String LOADING = "loading";
        public static final String NOTHING = "default";
        public static final String SUCCESS = "success";
    }

    public ErrorBean getError() {
        ErrorBean r0 = this.error;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new ErrorBean();
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.comment_id, this.reply_id, this.user_id, this.avatar_url, this.name, this.content, this.quote, Integer.valueOf(this.create_timestamp), Integer.valueOf(this.update_timestamp), Boolean.valueOf(this.isEditStatus), Boolean.valueOf(this.anonymous), Integer.valueOf(this.modify), this.extra, this.reaction_type, this.reactionFlowData, this.reactionDetailData, this.reaction, Boolean.valueOf(this.isFull), this.translate_content, this.translate_status, Integer.valueOf(this.is_whole), Boolean.valueOf(this.sending), this.retryType, this.error});
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("CommentDetail{comment_id='");
        r0.append(this.comment_id);
        r0.append("', reply_id='");
        r0.append(this.reply_id);
        r0.append("', user_id='");
        r0.append(this.user_id);
        r0.append("', avatar_url='");
        r0.append(this.avatar_url);
        r0.append("', name='");
        r0.append(this.name);
        r0.append("', content='");
        String r1 = this.content;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        r0.append(r2);
        r0.append("', create_timestamp=");
        r0.append(this.create_timestamp);
        r0.append(", extra=");
        r0.append(this.extra);
        r0.append(", quote=");
        r0.append(this.quote);
        r0.append('}');
        return r0.toString();
    L5:
        r2 = r1.length();
        goto L6
    }

    public BaseFeedMessageDetailBean() {
        this.isEditStatus = false;
        this.anonymous = false;
        this.modify = 0;
        this.translate_status = "default";
        this.is_whole = 0;
    }

    public String getAvatar_url() {
        return this.avatar_url;
    }

    public String getComment_id() {
        return this.comment_id;
    }

    public String getContent() {
        return this.content;
    }

    public int getCreate_timestamp() {
        return this.create_timestamp;
    }

    public DisplayName getDisplay_name() {
        return this.display_name;
    }

    public ExtraEntity getExtra() {
        return this.extra;
    }

    public int getIs_whole() {
        return this.is_whole;
    }

    public int getModify() {
        return this.modify;
    }

    public String getName() {
        return this.name;
    }

    public String getQuote() {
        return this.quote;
    }

    public List<Reaction> getReaction() {
        return this.reaction;
    }

    public List<ReactionDetailViewModel> getReactionDetailData() {
        return this.reactionDetailData;
    }

    public List<q2c.c> getReactionFlowData() {
        return this.reactionFlowData;
    }

    public String getReaction_type() {
        return this.reaction_type;
    }

    public String getReferKey() {
        return this.reply_id;
    }

    public String getReply_id() {
        return this.reply_id;
    }

    public String getRetryType() {
        return this.retryType;
    }

    public String getTranslate_content() {
        return this.translate_content;
    }

    public String getTranslate_status() {
        return this.translate_status;
    }

    public int getUpdate_timestamp() {
        return this.update_timestamp;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public boolean isAnonymous() {
        return this.anonymous;
    }

    public boolean isEditStatus() {
        return this.isEditStatus;
    }

    public boolean isFull() {
        return this.isFull;
    }

    public boolean isSending() {
        return this.sending;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L61:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L61;
        BaseFeedMessageDetailBean r6 = (BaseFeedMessageDetailBean) r5;
        if (this.create_timestamp == r6.create_timestamp) goto L13;
    L59:
        return false;
    L13:
        if (this.update_timestamp != r6.update_timestamp) goto L59;
        if (this.isEditStatus != r6.isEditStatus) goto L59;
        if (this.anonymous != r6.anonymous) goto L59;
        if (this.modify != r6.modify) goto L59;
        if (this.isFull != r6.isFull) goto L59;
        if (this.is_whole != r6.is_whole) goto L59;
        if (this.sending != r6.sending) goto L59;
        if (Objects.equals(this.comment_id, r6.comment_id) == false) goto L59;
        if (Objects.equals(this.reply_id, r6.reply_id) == false) goto L59;
        if (Objects.equals(this.user_id, r6.user_id) == false) goto L59;
        if (Objects.equals(this.avatar_url, r6.avatar_url) == false) goto L59;
        if (Objects.equals(this.name, r6.name) == false) goto L59;
        if (Objects.equals(this.content, r6.content) == false) goto L59;
        if (Objects.equals(this.quote, r6.quote) == false) goto L59;
        if (Objects.equals(this.extra, r6.extra) == false) goto L59;
        if (Objects.equals(this.reaction_type, r6.reaction_type) == false) goto L59;
        if (Objects.equals(this.reactionFlowData, r6.reactionFlowData) == false) goto L59;
        if (Objects.equals(this.reactionDetailData, r6.reactionDetailData) == false) goto L59;
        if (Objects.equals(this.reaction, r6.reaction) == false) goto L59;
        if (Objects.equals(this.translate_content, r6.translate_content) == false) goto L59;
        if (Objects.equals(this.translate_status, r6.translate_status) == false) goto L59;
        if (Objects.equals(this.retryType, r6.retryType) == false) goto L59;
        if (Objects.equals(this.error, r6.error) == false) goto L59;
        return true;
    }

    public void setAnonymous(boolean r1) {
        this.anonymous = r1;
    }

    public void setAvatar_url(String r1) {
        this.avatar_url = r1;
    }

    public void setComment_id(String r1) {
        this.comment_id = r1;
    }

    public void setContent(String r1) {
        this.content = r1;
    }

    public void setCreate_timestamp(int r1) {
        this.create_timestamp = r1;
    }

    public void setDisplay_name(DisplayName r1) {
        this.display_name = r1;
    }

    public void setEditStatus(boolean r1) {
        this.isEditStatus = r1;
    }

    public void setError(ErrorBean r1) {
        this.error = r1;
    }

    public void setExtra(ExtraEntity r1) {
        this.extra = r1;
    }

    public void setFull(boolean r1) {
        this.isFull = r1;
    }

    public void setIs_whole(int r1) {
        this.is_whole = r1;
    }

    public void setModify(int r1) {
        this.modify = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setQuote(String r1) {
        this.quote = r1;
    }

    public void setReaction(List<Reaction> r1) {
        this.reaction = r1;
    }

    public void setReactionDetailData(List<ReactionDetailViewModel> r1) {
        this.reactionDetailData = r1;
    }

    public void setReactionFlowData(List<q2c.c> r1) {
        this.reactionFlowData = r1;
    }

    public void setReaction_type(String r1) {
        this.reaction_type = r1;
    }

    public void setReferKey(String r1) {
        this.reply_id = r1;
    }

    public void setReply_id(String r1) {
        this.reply_id = r1;
    }

    public void setRetryType(String r1) {
        this.retryType = r1;
    }

    public void setSending(boolean r1) {
        this.sending = r1;
    }

    public void setTranslate_content(String r1) {
        this.translate_content = r1;
    }

    public void setTranslate_status(String r1) {
        this.translate_status = r1;
    }

    public void setUpdate_timestamp(int r1) {
        this.update_timestamp = r1;
    }

    public void setUser_id(String r1) {
        this.user_id = r1;
    }
}
