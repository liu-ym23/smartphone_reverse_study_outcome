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

/* JADX INFO: loaded from: classes18.dex */
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

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if (r100 != null) goto L8;
            L17:
                return false;
            L8:
                if (getClass() != r100.getClass()) goto L17;
                AttachmentEntity r101 = (AttachmentEntity) r100;
                if (this.audio_duration == r101.audio_duration) goto L13;
            L15:
                return false;
            L13:
                if (Objects.equals(this.audio_file_token, r101.audio_file_token) == false) goto L15;
                return true;
            }

            public void setAudio_duration(int r100) {
                this.audio_duration = r100;
            }

            public void setAudio_file_token(String r100) {
                this.audio_file_token = r100;
            }
        }

        public ExtraEntity() {
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.attachment, this.image_list});
        }

        public String toString() {
            StringBuilder r100 = new StringBuilder("ExtraEntity{, image_list=");
            List<String> r101 = this.image_list;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            r100.append(r102);
            r100.append('}');
            return r100.toString();
        L5:
            r102 = r101.size();
            goto L6
        }

        public CommentBean.CommentDetail.ExtraEntity.AttachmentEntity getAttachment() {
            return this.attachment;
        }

        public List<String> getImage_list() {
            return this.image_list;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L17:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L17;
            ExtraEntity r101 = (ExtraEntity) r100;
            if (Objects.equals(this.attachment, r101.attachment) == true) goto L13;
        L15:
            return false;
        L13:
            if (Objects.equals(this.image_list, r101.image_list) == false) goto L15;
            return true;
        }

        public void setAttachment(CommentBean.CommentDetail.ExtraEntity.AttachmentEntity r100) {
            this.attachment = r100;
        }

        public void setImage_list(List<String> r100) {
            this.image_list = r100;
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
        ErrorBean r100 = this.error;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new ErrorBean();
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.comment_id, this.reply_id, this.user_id, this.avatar_url, this.name, this.content, this.quote, Integer.valueOf(this.create_timestamp), Integer.valueOf(this.update_timestamp), Boolean.valueOf(this.isEditStatus), Boolean.valueOf(this.anonymous), Integer.valueOf(this.modify), this.extra, this.reaction_type, this.reactionFlowData, this.reactionDetailData, this.reaction, Boolean.valueOf(this.isFull), this.translate_content, this.translate_status, Integer.valueOf(this.is_whole), Boolean.valueOf(this.sending), this.retryType, this.error});
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("CommentDetail{comment_id='");
        r100.append(this.comment_id);
        r100.append("', reply_id='");
        r100.append(this.reply_id);
        r100.append("', user_id='");
        r100.append(this.user_id);
        r100.append("', avatar_url='");
        r100.append(this.avatar_url);
        r100.append("', name='");
        r100.append(this.name);
        r100.append("', content='");
        String r101 = this.content;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        r100.append(r102);
        r100.append("', create_timestamp=");
        r100.append(this.create_timestamp);
        r100.append(", extra=");
        r100.append(this.extra);
        r100.append(", quote=");
        r100.append(this.quote);
        r100.append('}');
        return r100.toString();
    L5:
        r102 = r101.length();
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

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L61:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L61;
        BaseFeedMessageDetailBean r101 = (BaseFeedMessageDetailBean) r100;
        if (this.create_timestamp == r101.create_timestamp) goto L13;
    L59:
        return false;
    L13:
        if (this.update_timestamp != r101.update_timestamp) goto L59;
        if (this.isEditStatus != r101.isEditStatus) goto L59;
        if (this.anonymous != r101.anonymous) goto L59;
        if (this.modify != r101.modify) goto L59;
        if (this.isFull != r101.isFull) goto L59;
        if (this.is_whole != r101.is_whole) goto L59;
        if (this.sending != r101.sending) goto L59;
        if (Objects.equals(this.comment_id, r101.comment_id) == false) goto L59;
        if (Objects.equals(this.reply_id, r101.reply_id) == false) goto L59;
        if (Objects.equals(this.user_id, r101.user_id) == false) goto L59;
        if (Objects.equals(this.avatar_url, r101.avatar_url) == false) goto L59;
        if (Objects.equals(this.name, r101.name) == false) goto L59;
        if (Objects.equals(this.content, r101.content) == false) goto L59;
        if (Objects.equals(this.quote, r101.quote) == false) goto L59;
        if (Objects.equals(this.extra, r101.extra) == false) goto L59;
        if (Objects.equals(this.reaction_type, r101.reaction_type) == false) goto L59;
        if (Objects.equals(this.reactionFlowData, r101.reactionFlowData) == false) goto L59;
        if (Objects.equals(this.reactionDetailData, r101.reactionDetailData) == false) goto L59;
        if (Objects.equals(this.reaction, r101.reaction) == false) goto L59;
        if (Objects.equals(this.translate_content, r101.translate_content) == false) goto L59;
        if (Objects.equals(this.translate_status, r101.translate_status) == false) goto L59;
        if (Objects.equals(this.retryType, r101.retryType) == false) goto L59;
        if (Objects.equals(this.error, r101.error) == false) goto L59;
        return true;
    }

    public void setAnonymous(boolean r100) {
        this.anonymous = r100;
    }

    public void setAvatar_url(String r100) {
        this.avatar_url = r100;
    }

    public void setComment_id(String r100) {
        this.comment_id = r100;
    }

    public void setContent(String r100) {
        this.content = r100;
    }

    public void setCreate_timestamp(int r100) {
        this.create_timestamp = r100;
    }

    public void setDisplay_name(DisplayName r100) {
        this.display_name = r100;
    }

    public void setEditStatus(boolean r100) {
        this.isEditStatus = r100;
    }

    public void setError(ErrorBean r100) {
        this.error = r100;
    }

    public void setExtra(ExtraEntity r100) {
        this.extra = r100;
    }

    public void setFull(boolean r100) {
        this.isFull = r100;
    }

    public void setIs_whole(int r100) {
        this.is_whole = r100;
    }

    public void setModify(int r100) {
        this.modify = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setQuote(String r100) {
        this.quote = r100;
    }

    public void setReaction(List<Reaction> r100) {
        this.reaction = r100;
    }

    public void setReactionDetailData(List<ReactionDetailViewModel> r100) {
        this.reactionDetailData = r100;
    }

    public void setReactionFlowData(List<q2c.c> r100) {
        this.reactionFlowData = r100;
    }

    public void setReaction_type(String r100) {
        this.reaction_type = r100;
    }

    public void setReferKey(String r100) {
        this.reply_id = r100;
    }

    public void setReply_id(String r100) {
        this.reply_id = r100;
    }

    public void setRetryType(String r100) {
        this.retryType = r100;
    }

    public void setSending(boolean r100) {
        this.sending = r100;
    }

    public void setTranslate_content(String r100) {
        this.translate_content = r100;
    }

    public void setTranslate_status(String r100) {
        this.translate_status = r100;
    }

    public void setUpdate_timestamp(int r100) {
        this.update_timestamp = r100;
    }

    public void setUser_id(String r100) {
        this.user_id = r100;
    }
}
