package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.reaction.widget.detailwindow.bean.ReactionDetailViewModel;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes18.dex */
public class CommentBean implements BaseJSModel {
    public static final int AREA = 0;
    public static final int RESOLVED = 1;
    public static final int STATUS_READ = 2;
    public static final int STATUS_UNREAD = 1;
    public static final int UN_RESOLVE = 0;
    public static final int WHOLE = 1;
    private Map<Object, Object> bizParams;
    private List<String> blockedActionList;
    private boolean canPerformAction;
    private String commentAnchorId;
    private int commentType;
    private String commentUUID;
    private String comment_id;
    private List<CommentDetail> comment_list;
    private String currentReplyId;
    private Extra extra;
    private int finish;
    private boolean focusCard;
    private boolean isExpanded;
    private boolean isNewInput;
    private boolean isScrollLast;
    private int is_whole;
    private String parentToken;
    private String parentType;
    private List<String> participantList;
    private String position;
    private String quote;
    private List<Reaction> reactionList;
    private boolean unSubmitComment;
    private String userId;

    public static class CommentDetail implements BaseJSModel {
        public static final String RETRY_TYPE_ADD = "add";
        public static final String RETRY_TYPE_DELETE = "delete";
        public static final String RETRY_TYPE_REPLY = "reply";
        public static final String RETRY_TYPE_UPDATE = "update";
        public static final int TYPE_COMMENT = 0;
        private boolean anonymous;
        private String avatar_url;
        private BitableExtraEntity bitableExtra;
        private int commentType;
        private String commentUUID;
        private String comment_id;
        private String compatibleReplyIdBeforeSend;
        private String content;
        private int create_timestamp;
        private DisplayName display_name;
        private ErrorBean error;
        private ExtraEntity extra;
        private boolean inReply;
        private boolean isEditStatus;
        private boolean isFirstReply;
        private boolean isFull;
        private int is_whole;
        private String[] messageIds;
        private int modify;
        private String name;
        private List<Reaction> originalReaction;
        private List<String> participantList;
        private boolean perSmartReplyPreview;
        private int position;
        private List<Reaction> reaction;
        private List<ReactionDetailViewModel> reactionDetailData;
        private List<q2c.c> reactionFlowData;
        private String reaction_type;
        private int readStatus;
        private int replyType;
        private String replyUUID;
        private String reply_id;
        private String retryType;
        private boolean sending;
        private SmartReplyData smartReplyData;
        private String targetLanguage;

        @JSONField(name = "translateContent")
        private String translate_content;

        @JSONField(name = "translateStatus")
        private String translate_status;
        private int update_timestamp;
        private String userDefaultTargetLang;
        private String userMainLang;
        private String user_id;

        public static class BitableExtraEntity implements Serializable {
            private boolean isMainComment;
            private String recordId;
            private String tableId;
            private String viewId;
            private int visibility;

            public BitableExtraEntity() {
            }

            public int hashCode() {
                return Objects.hash(new Object[]{Boolean.valueOf(this.isMainComment), Integer.valueOf(this.visibility), this.tableId, this.viewId, this.recordId});
            }

            public String getRecordId() {
                return this.recordId;
            }

            public String getTableId() {
                return this.tableId;
            }

            public String getViewId() {
                return this.viewId;
            }

            public int getVisibility() {
                return this.visibility;
            }

            public boolean isMainComment() {
                return this.isMainComment;
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if (r100 != null) goto L8;
            L23:
                return false;
            L8:
                if (getClass() != r100.getClass()) goto L23;
                BitableExtraEntity r101 = (BitableExtraEntity) r100;
                if (this.isMainComment == r101.isMainComment) goto L13;
            L21:
                return false;
            L13:
                if (this.visibility != r101.visibility) goto L21;
                if (Objects.equals(this.tableId, r101.tableId) == false) goto L21;
                if (Objects.equals(this.viewId, r101.viewId) == false) goto L21;
                if (Objects.equals(this.recordId, r101.recordId) == false) goto L21;
                return true;
            }

            public void setMainComment(boolean r100) {
                this.isMainComment = r100;
            }

            public void setRecordId(String r100) {
                this.recordId = r100;
            }

            public void setTableId(String r100) {
                this.tableId = r100;
            }

            public void setViewId(String r100) {
                this.viewId = r100;
            }

            public void setVisibility(int r100) {
                this.visibility = r100;
            }
        }

        public static class ExtraEntity implements Serializable {
            private AttachmentEntity attachment;
            private List<CommentImageEntity> image_list;
            private int source;
            private int visibility;

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

            public static class CommentImageEntity implements Serializable {
                private ArrayList<CommentAreaMark> areaMark;
                private boolean loadFail;
                private String originalSrc;

                /* JADX INFO: renamed from: src, reason: collision with root package name */
                private String f231358src;
                private String token;
                private String uuid;

                public int hashCode() {
                    return Objects.hash(new Object[]{this.token, this.uuid, this.f231358src, this.originalSrc, Boolean.valueOf(this.loadFail), this.areaMark});
                }

                public CommentImageEntity copy() {
                    CommentImageEntity r100 = new CommentImageEntity();
                    r100.token = this.token;
                    r100.uuid = this.uuid;
                    r100.f231358src = this.f231358src;
                    r100.originalSrc = this.originalSrc;
                    r100.loadFail = this.loadFail;
                    ArrayList<CommentAreaMark> r101 = new ArrayList();
                    Iterator<CommentAreaMark> r102 = this.areaMark.iterator();
                L4:
                    if (r102.hasNext() == false) goto L8;
                    CommentAreaMark r103 = r102.next();
                    if (r103 == null) goto L4;
                    r101.add(r103.copy());
                    goto L4
                L8:
                    r100.areaMark = r101;
                    return r100;
                }

                public String toString() {
                    return "CommentImageEntity{token='" + du5.b.g(this.token) + "', uuid='" + this.uuid + "', src='" + du5.b.f(this.f231358src) + "', loadFail=" + this.loadFail + ", commentAreaMarks=" + this.areaMark.size() + '}';
                }

                public CommentImageEntity() {
                    this.areaMark = new ArrayList();
                }

                public ArrayList<CommentAreaMark> getAreaMark() {
                    return this.areaMark;
                }

                public boolean getLoadFail() {
                    return this.loadFail;
                }

                public String getOriginalSrc() {
                    return this.originalSrc;
                }

                public String getSrc() {
                    return this.f231358src;
                }

                public String getToken() {
                    return this.token;
                }

                public String getUuid() {
                    return this.uuid;
                }

                public boolean equals(Object r100) {
                    if (this != r100) goto L6;
                    return true;
                L6:
                    if (r100 != null) goto L8;
                L25:
                    return false;
                L8:
                    if (getClass() != r100.getClass()) goto L25;
                    CommentImageEntity r101 = (CommentImageEntity) r100;
                    if (Objects.equals(this.token, r101.token) == true) goto L13;
                L23:
                    return false;
                L13:
                    if (Objects.equals(this.uuid, r101.uuid) == false) goto L23;
                    if (this.f231358src.equals(r101.f231358src) == false) goto L23;
                    if (Objects.equals(this.originalSrc, r101.originalSrc) == false) goto L23;
                    if (Objects.equals(Boolean.valueOf(this.loadFail), Boolean.valueOf(r101.loadFail)) == false) goto L23;
                    if (Objects.equals(this.areaMark, r101.areaMark) == false) goto L23;
                    return true;
                }

                public void setAreaMark(ArrayList<CommentAreaMark> r100) {
                    if (r100 != null) goto L4;
                    r100 = new ArrayList();
                L4:
                    this.areaMark = r100;
                }

                public void setLoadFail(boolean r100) {
                    this.loadFail = r100;
                }

                public void setOriginalSrc(String r100) {
                    this.originalSrc = r100;
                }

                public void setSrc(String r100) {
                    this.f231358src = r100;
                }

                public void setToken(String r100) {
                    this.token = r100;
                }

                public void setUuid(String r100) {
                    this.uuid = r100;
                }
            }

            public ExtraEntity() {
            }

            public int hashCode() {
                return Objects.hash(new Object[]{this.attachment, this.image_list, Integer.valueOf(this.visibility)});
            }

            public String toString() {
                return "ExtraEntity{image_list=" + this.image_list + "visibility=" + this.visibility + '}';
            }

            public AttachmentEntity getAttachment() {
                return this.attachment;
            }

            public List<CommentImageEntity> getImage_list() {
                return this.image_list;
            }

            public int getVisibility() {
                return this.visibility;
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if (r100 != null) goto L8;
            L19:
                return false;
            L8:
                if (getClass() != r100.getClass()) goto L19;
                ExtraEntity r101 = (ExtraEntity) r100;
                if (Objects.equals(this.attachment, r101.attachment) == true) goto L13;
            L17:
                return false;
            L13:
                if (Objects.equals(this.image_list, r101.image_list) == false) goto L17;
                if (Objects.equals(Integer.valueOf(this.visibility), Integer.valueOf(r101.visibility)) == false) goto L17;
                return true;
            }

            public void setAttachment(AttachmentEntity r100) {
                this.attachment = r100;
            }

            public void setImage_list(List<CommentImageEntity> r100) {
                this.image_list = r100;
            }

            public void setSource(int r100) {
                this.source = r100;
            }

            public void setVisibility(int r100) {
                this.visibility = r100;
            }
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface TranslateStatus {
            public static final String ERROR = "error";
            public static final String LOADING = "loading";
            public static final String NOTHING = "default";
            public static final String SUCCESS = "success";
        }

        public String getComment_id() {
            String r100 = this.comment_id;
            if (r100 != null) goto L7;
            return "";
        L7:
            return r100;
        }

        public ErrorBean getError() {
            ErrorBean r100 = this.error;
            if (r100 == null) goto L6;
            return r100;
        L6:
            return new ErrorBean();
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.comment_id, this.reply_id, this.user_id, this.name, this.content, Boolean.valueOf(this.sending), this.error, this.reaction_type, this.bitableExtra, this.translate_content, this.targetLanguage, this.userMainLang, this.userDefaultTargetLang, this.translate_status, Boolean.valueOf(this.isEditStatus), this.reaction, this.extra, Integer.valueOf(this.replyType), this.smartReplyData, Boolean.valueOf(this.perSmartReplyPreview), this.participantList}) + Arrays.hashCode(this.messageIds);
        }

        public boolean isWholeComment() {
            if (this.is_whole == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public String toString() {
            StringBuilder r100 = new StringBuilder("CommentDetail{comment_id='");
            r100.append(this.comment_id);
            r100.append("', reply_id='");
            r100.append(this.reply_id);
            r100.append("', replyUUID='");
            r100.append(this.replyUUID);
            r100.append("', content length='");
            String r101 = this.content;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            r100.append(r103);
            r100.append("', extra=");
            r100.append(this.extra);
            r100.append(", messageId='");
            String[] r104 = this.messageIds;
            if (r104 != null) goto L9;
            Object r105 = "";
        L10:
            r100.append(r105);
            r100.append("', readStatus=");
            r100.append(this.readStatus);
            r100.append(", smartReplyData length='");
            SmartReplyData r106 = this.smartReplyData;
            if (r106 != null) goto L13;
            int r107 = 0;
        L14:
            r100.append(r107);
            r100.append("', reaction size='");
            List<Reaction> r108 = this.reaction;
            if (r108 != null) goto L17;
            int r109 = 0;
        L18:
            r100.append(r109);
            r100.append("', originalReaction size='");
            List<Reaction> r110 = this.originalReaction;
            if (r110 != null) goto L21;
            int r111 = 0;
        L22:
            r100.append(r111);
            r100.append("', participantList size='");
            List<String> r112 = this.participantList;
            if (r112 == null) goto L26;
            r102 = r112.size();
        L26:
            r100.append(r102);
            r100.append("'}");
            return r100.toString();
        L21:
            r111 = r110.size();
            goto L22
        L17:
            r109 = r108.size();
            goto L18
        L13:
            r107 = r106.getPlainTextPreview().length();
            goto L14
        L9:
            r105 = Integer.valueOf(r104.length);
            goto L10
        L5:
            r103 = r101.length();
            goto L6
        }

        public CommentDetail() {
            this.isEditStatus = false;
            this.anonymous = false;
            this.modify = 0;
            this.translate_status = "default";
            this.is_whole = 0;
            this.perSmartReplyPreview = false;
        }

        public String getAvatar_url() {
            return this.avatar_url;
        }

        public BitableExtraEntity getBitableExtra() {
            return this.bitableExtra;
        }

        public int getCommentType() {
            return this.commentType;
        }

        public String getCommentUUID() {
            return this.commentUUID;
        }

        public String getCompatibleReplyIdBeforeSend() {
            return this.compatibleReplyIdBeforeSend;
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

        public String[] getMessageIds() {
            return this.messageIds;
        }

        public int getModify() {
            return this.modify;
        }

        public String getName() {
            return this.name;
        }

        public List<Reaction> getOriginalReaction() {
            return this.originalReaction;
        }

        public List<String> getParticipantList() {
            return this.participantList;
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

        public int getReadStatus() {
            return this.readStatus;
        }

        public String getReferKey() {
            return this.reply_id;
        }

        public int getReplyType() {
            return this.replyType;
        }

        public String getReplyUUID() {
            return this.replyUUID;
        }

        public String getReply_id() {
            return this.reply_id;
        }

        public String getRetryType() {
            return this.retryType;
        }

        public SmartReplyData getSmartReplyData() {
            return this.smartReplyData;
        }

        public String getTargetLanguage() {
            return this.targetLanguage;
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

        public String getUserDefaultTargetLang() {
            return this.userDefaultTargetLang;
        }

        public String getUserMainLang() {
            return this.userMainLang;
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

        public boolean isFirstReply() {
            return this.isFirstReply;
        }

        public boolean isFull() {
            return this.isFull;
        }

        public boolean isInReply() {
            return this.inReply;
        }

        public boolean isPerSmartReplyPreview() {
            return this.perSmartReplyPreview;
        }

        public boolean isSending() {
            return this.sending;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L59:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L59;
            CommentDetail r101 = (CommentDetail) r100;
            if (Objects.equals(this.comment_id, r101.comment_id) == true) goto L13;
        L57:
            return false;
        L13:
            if (Objects.equals(this.reply_id, r101.reply_id) == false) goto L57;
            if (Objects.equals(this.user_id, r101.user_id) == false) goto L57;
            if (Objects.equals(this.name, r101.name) == false) goto L57;
            if (Objects.equals(this.content, r101.content) == false) goto L57;
            if (Objects.equals(Boolean.valueOf(this.sending), Boolean.valueOf(r101.isSending())) == false) goto L57;
            if (Objects.equals(this.error, r101.error) == false) goto L57;
            if (Objects.equals(this.reaction_type, r101.reaction_type) == false) goto L57;
            if (Objects.equals(this.translate_content, r101.translate_content) == false) goto L57;
            if (Objects.equals(this.targetLanguage, r101.targetLanguage) == false) goto L57;
            if (Objects.equals(this.userMainLang, r101.userMainLang) == false) goto L57;
            if (Objects.equals(this.userDefaultTargetLang, r101.userDefaultTargetLang) == false) goto L57;
            if (Objects.equals(this.translate_status, r101.translate_status) == false) goto L57;
            if (Objects.equals(Boolean.valueOf(this.isEditStatus), Boolean.valueOf(r101.isEditStatus)) == false) goto L57;
            if (Objects.equals(this.reaction, r101.reaction) == false) goto L57;
            if (Objects.equals(this.extra, r101.extra) == false) goto L57;
            if (Arrays.equals(this.messageIds, r101.messageIds) == false) goto L57;
            if (Objects.equals(Integer.valueOf(this.replyType), Integer.valueOf(r101.replyType)) == false) goto L57;
            if (Objects.equals(this.bitableExtra, r101.bitableExtra) == false) goto L57;
            if (Objects.equals(Boolean.valueOf(this.perSmartReplyPreview), Boolean.valueOf(r101.perSmartReplyPreview)) == false) goto L57;
            if (Objects.equals(this.smartReplyData, r101.smartReplyData) == false) goto L57;
            if (Objects.equals(this.participantList, r101.participantList) == false) goto L57;
            if (Objects.equals(Integer.valueOf(this.modify), Integer.valueOf(r101.modify)) == false) goto L57;
            return true;
        }

        public void setAnonymous(boolean r100) {
            this.anonymous = r100;
        }

        public void setAvatar_url(String r100) {
            this.avatar_url = r100;
        }

        public void setBitableExtra(BitableExtraEntity r100) {
            this.bitableExtra = r100;
        }

        public void setCommentType(int r100) {
            this.commentType = r100;
        }

        public void setCommentUUID(String r100) {
            this.commentUUID = r100;
        }

        public void setComment_id(String r100) {
            this.comment_id = r100;
        }

        public void setCompatibleReplyIdBeforeSend(String r100) {
            this.compatibleReplyIdBeforeSend = r100;
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

        public void setFirstReply(boolean r100) {
            this.isFirstReply = r100;
        }

        public void setFull(boolean r100) {
            this.isFull = r100;
        }

        public void setInReply(boolean r100) {
            this.inReply = r100;
        }

        public void setIs_whole(int r100) {
            this.is_whole = r100;
        }

        public void setMessageId(String r100) {
            if (this.messageIds != null) goto L6;
            this.messageIds = new String[]{r100};
            return;
        }

        public void setMessageIds(String[] r100) {
            this.messageIds = r100;
        }

        public void setModify(int r100) {
            this.modify = r100;
        }

        public void setName(String r100) {
            this.name = r100;
        }

        public void setOriginalReaction(List<Reaction> r100) {
            this.originalReaction = r100;
        }

        public void setParticipantList(List<String> r100) {
            this.participantList = r100;
        }

        public void setPerSmartReplyPreview(boolean r100) {
            this.perSmartReplyPreview = r100;
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

        public void setReadStatus(int r100) {
            this.readStatus = r100;
        }

        public void setReferKey(String r100) {
            this.reply_id = r100;
        }

        public void setReplyType(int r100) {
            this.replyType = r100;
        }

        public void setReplyUUID(String r100) {
            this.replyUUID = r100;
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

        public void setSmartReplyData(SmartReplyData r100) {
            this.smartReplyData = r100;
        }

        public void setTargetLanguage(String r100) {
            this.targetLanguage = r100;
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

        public void setUserDefaultTargetLang(String r100) {
            this.userDefaultTargetLang = r100;
        }

        public void setUserMainLang(String r100) {
            this.userMainLang = r100;
        }

        public void setUser_id(String r100) {
            this.user_id = r100;
        }
    }

    public static class Extra implements NonProguard {
        public static final int SOURCE_NORMAL = 0;
        public static final int SOURCE_SELECTABLE = 3;
        public static final int SOURCE_SELECTION = 2;
        public static final int SOURCE_TEXT_QUOTE = 1;
        private VisibilityBean newInputVisibility;
        private ParentCommentInfo parentInfo;
        private RevisionExtra revisionExtra;
        private int source;
        private int visibility;

        @Retention(RetentionPolicy.SOURCE)
        public @interface SourceType {
        }

        public Extra() {
        }

        public int getVisibility() {
            VisibilityBean r100 = this.newInputVisibility;
            if (r100 == null) goto L7;
            return r100.getType();
        L7:
            return this.visibility;
        }

        public String getReportVisibility() {
            int r100 = getVisibility();
            if (r100 != 0) goto L7;
            return "public_comment";
        L7:
            if (r100 != 1) goto L11;
            return "partially_visible_comments";
        L11:
            if (r100 != 2) goto L14;
            return "private_comments";
        L14:
            return "";
        }

        public VisibilityBean getNewInputVisibility() {
            return this.newInputVisibility;
        }

        public ParentCommentInfo getParentInfo() {
            return this.parentInfo;
        }

        public RevisionExtra getRevisionExtra() {
            return this.revisionExtra;
        }

        public int getSource() {
            return this.source;
        }

        public static /* synthetic */ ParentCommentInfo access$000(Extra r100) {
            return r100.parentInfo;
        }

        public void setNewInputVisibility(VisibilityBean r100) {
            this.newInputVisibility = r100;
        }

        public void setParentInfo(ParentCommentInfo r100) {
            this.parentInfo = r100;
        }

        public void setRevisionExtra(RevisionExtra r100) {
            this.revisionExtra = r100;
        }

        public void setSource(int r100) {
            if (r100 != 0) goto L4;
        L10:
            this.source = r100;
            return;
        L4:
            if (r100 == 1) goto L10;
            if (r100 == 2) goto L10;
            if (r100 == 3) goto L10;
            this.source = 0;
        }

        public void setVisibility(int r100) {
            this.visibility = r100;
        }
    }

    public static class ParentCommentInfo implements NonProguard {
        private String parentId;
        private String referReplyId;

        public ParentCommentInfo() {
        }

        public String getParentId() {
            return this.parentId;
        }

        public String getReferReplyId() {
            return this.referReplyId;
        }

        public static /* synthetic */ String access$100(ParentCommentInfo r100) {
            return r100.parentId;
        }

        public void setParentId(String r100) {
            this.parentId = r100;
        }

        public void setReferReplyId(String r100) {
            this.referReplyId = r100;
        }
    }

    public boolean isTmpCard() {
        if (this.isNewInput == false) goto L11;
        Extra r100 = this.extra;
        if (r100 == null) goto L11;
        if (Extra.access$000(r100) == null) goto L11;
        if (ParentCommentInfo.access$100(Extra.access$000(this.extra)) == null) goto L11;
        return true;
    L11:
        return false;
    }

    public CommentBean() {
        this.focusCard = true;
        this.isScrollLast = false;
        this.finish = 0;
        this.quote = "";
        this.is_whole = 0;
        this.canPerformAction = true;
        this.blockedActionList = new ArrayList();
    }

    public Map<Object, Object> getBizParams() {
        return this.bizParams;
    }

    public List<String> getBlockedActionList() {
        return this.blockedActionList;
    }

    public String getCommentAnchorId() {
        return this.commentAnchorId;
    }

    public int getCommentType() {
        return this.commentType;
    }

    public String getCommentUUID() {
        return this.commentUUID;
    }

    public String getComment_id() {
        return this.comment_id;
    }

    public List<CommentDetail> getComment_list() {
        return this.comment_list;
    }

    public String getCurrentReplyId() {
        return this.currentReplyId;
    }

    public Extra getExtra() {
        return this.extra;
    }

    public int getFinish() {
        return this.finish;
    }

    public int getIs_whole() {
        return this.is_whole;
    }

    public String getParentToken() {
        return this.parentToken;
    }

    public String getParentType() {
        return this.parentType;
    }

    public List<String> getParticipantList() {
        return this.participantList;
    }

    public String getPosition() {
        return this.position;
    }

    public String getQuote() {
        return this.quote;
    }

    public List<Reaction> getReactionList() {
        return this.reactionList;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isCanPerformAction() {
        return this.canPerformAction;
    }

    public boolean isExpanded() {
        return this.isExpanded;
    }

    public boolean isFocusCard() {
        return this.focusCard;
    }

    public boolean isNewInput() {
        return this.isNewInput;
    }

    public boolean isScrollLast() {
        return this.isScrollLast;
    }

    public boolean isUnSubmitComment() {
        return this.unSubmitComment;
    }

    public boolean isActionBlocked(CommentAction r100) {
        return this.blockedActionList.contains(r100.getValue());
    }

    public void setBizParams(Map<Object, Object> r100) {
        this.bizParams = r100;
    }

    public void setBlockedActionList(List<String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.blockedActionList = r100;
    }

    public void setCanPerformAction(boolean r100) {
        this.canPerformAction = r100;
    }

    public void setCommentAnchorId(String r100) {
        this.commentAnchorId = r100;
    }

    public void setCommentType(int r100) {
        this.commentType = r100;
    }

    public void setCommentUUID(String r100) {
        this.commentUUID = r100;
    }

    public void setComment_id(String r100) {
        this.comment_id = r100;
    }

    public void setComment_list(List<CommentDetail> r100) {
        this.comment_list = r100;
    }

    public void setCurrentReplyId(String r100) {
        this.currentReplyId = r100;
    }

    public void setExpanded(boolean r100) {
        this.isExpanded = r100;
    }

    public void setExtra(Extra r100) {
        this.extra = r100;
    }

    public void setFinish(int r100) {
        this.finish = r100;
    }

    public void setFocusCard(boolean r100) {
        this.focusCard = r100;
    }

    public void setIs_whole(int r100) {
        this.is_whole = r100;
    }

    public void setNewInput(boolean r100) {
        this.isNewInput = r100;
    }

    public void setParentToken(String r100) {
        this.parentToken = r100;
    }

    public void setParentType(String r100) {
        this.parentType = r100;
    }

    public void setParticipantList(List<String> r100) {
        this.participantList = r100;
    }

    public void setPosition(String r100) {
        this.position = r100;
    }

    public void setQuote(String r100) {
        this.quote = r100;
    }

    public void setReactionList(List<Reaction> r100) {
        this.reactionList = r100;
    }

    public void setScrollLast(boolean r100) {
        this.isScrollLast = r100;
    }

    public void setUnSubmitComment(boolean r100) {
        this.unSubmitComment = r100;
    }

    public void setUserId(String r100) {
        this.userId = r100;
    }
}
