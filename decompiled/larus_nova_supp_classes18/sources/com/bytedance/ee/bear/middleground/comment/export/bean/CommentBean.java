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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (r5 != null) goto L8;
            L23:
                return false;
            L8:
                if (getClass() != r5.getClass()) goto L23;
                BitableExtraEntity r6 = (BitableExtraEntity) r5;
                if (this.isMainComment == r6.isMainComment) goto L13;
            L21:
                return false;
            L13:
                if (this.visibility != r6.visibility) goto L21;
                if (Objects.equals(this.tableId, r6.tableId) == false) goto L21;
                if (Objects.equals(this.viewId, r6.viewId) == false) goto L21;
                if (Objects.equals(this.recordId, r6.recordId) == false) goto L21;
                return true;
            }

            public void setMainComment(boolean r1) {
                this.isMainComment = r1;
            }

            public void setRecordId(String r1) {
                this.recordId = r1;
            }

            public void setTableId(String r1) {
                this.tableId = r1;
            }

            public void setViewId(String r1) {
                this.viewId = r1;
            }

            public void setVisibility(int r1) {
                this.visibility = r1;
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

            public static class CommentImageEntity implements Serializable {
                private ArrayList<CommentAreaMark> areaMark;
                private boolean loadFail;
                private String originalSrc;
                private String src;
                private String token;
                private String uuid;

                public int hashCode() {
                    return Objects.hash(new Object[]{this.token, this.uuid, this.src, this.originalSrc, Boolean.valueOf(this.loadFail), this.areaMark});
                }

                public CommentImageEntity copy() {
                    CommentImageEntity r0 = new CommentImageEntity();
                    r0.token = this.token;
                    r0.uuid = this.uuid;
                    r0.src = this.src;
                    r0.originalSrc = this.originalSrc;
                    r0.loadFail = this.loadFail;
                    ArrayList<CommentAreaMark> r1 = new ArrayList();
                    Iterator<CommentAreaMark> r2 = this.areaMark.iterator();
                L4:
                    if (r2.hasNext() == false) goto L8;
                    CommentAreaMark r3 = r2.next();
                    if (r3 == null) goto L4;
                    r1.add(r3.copy());
                    goto L4
                L8:
                    r0.areaMark = r1;
                    return r0;
                }

                public String toString() {
                    return "CommentImageEntity{token='" + du5.b.g(this.token) + "', uuid='" + this.uuid + "', src='" + du5.b.f(this.src) + "', loadFail=" + this.loadFail + ", commentAreaMarks=" + this.areaMark.size() + '}';
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
                    return this.src;
                }

                public String getToken() {
                    return this.token;
                }

                public String getUuid() {
                    return this.uuid;
                }

                public boolean equals(Object r5) {
                    if (this != r5) goto L6;
                    return true;
                L6:
                    if (r5 != null) goto L8;
                L25:
                    return false;
                L8:
                    if (getClass() != r5.getClass()) goto L25;
                    CommentImageEntity r6 = (CommentImageEntity) r5;
                    if (Objects.equals(this.token, r6.token) == true) goto L13;
                L23:
                    return false;
                L13:
                    if (Objects.equals(this.uuid, r6.uuid) == false) goto L23;
                    if (this.src.equals(r6.src) == false) goto L23;
                    if (Objects.equals(this.originalSrc, r6.originalSrc) == false) goto L23;
                    if (Objects.equals(Boolean.valueOf(this.loadFail), Boolean.valueOf(r6.loadFail)) == false) goto L23;
                    if (Objects.equals(this.areaMark, r6.areaMark) == false) goto L23;
                    return true;
                }

                public void setAreaMark(ArrayList<CommentAreaMark> r1) {
                    if (r1 != null) goto L4;
                    r1 = new ArrayList();
                L4:
                    this.areaMark = r1;
                }

                public void setLoadFail(boolean r1) {
                    this.loadFail = r1;
                }

                public void setOriginalSrc(String r1) {
                    this.originalSrc = r1;
                }

                public void setSrc(String r1) {
                    this.src = r1;
                }

                public void setToken(String r1) {
                    this.token = r1;
                }

                public void setUuid(String r1) {
                    this.uuid = r1;
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

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (r5 != null) goto L8;
            L19:
                return false;
            L8:
                if (getClass() != r5.getClass()) goto L19;
                ExtraEntity r6 = (ExtraEntity) r5;
                if (Objects.equals(this.attachment, r6.attachment) == true) goto L13;
            L17:
                return false;
            L13:
                if (Objects.equals(this.image_list, r6.image_list) == false) goto L17;
                if (Objects.equals(Integer.valueOf(this.visibility), Integer.valueOf(r6.visibility)) == false) goto L17;
                return true;
            }

            public void setAttachment(AttachmentEntity r1) {
                this.attachment = r1;
            }

            public void setImage_list(List<CommentImageEntity> r1) {
                this.image_list = r1;
            }

            public void setSource(int r1) {
                this.source = r1;
            }

            public void setVisibility(int r1) {
                this.visibility = r1;
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
            String r0 = this.comment_id;
            if (r0 != null) goto L7;
            return "";
        L7:
            return r0;
        }

        public ErrorBean getError() {
            ErrorBean r0 = this.error;
            if (r0 == null) goto L6;
            return r0;
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
            StringBuilder r0 = new StringBuilder("CommentDetail{comment_id='");
            r0.append(this.comment_id);
            r0.append("', reply_id='");
            r0.append(this.reply_id);
            r0.append("', replyUUID='");
            r0.append(this.replyUUID);
            r0.append("', content length='");
            String r1 = this.content;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            r0.append(r3);
            r0.append("', extra=");
            r0.append(this.extra);
            r0.append(", messageId='");
            String[] r4 = this.messageIds;
            if (r4 != null) goto L9;
            Object r5 = "";
        L10:
            r0.append(r5);
            r0.append("', readStatus=");
            r0.append(this.readStatus);
            r0.append(", smartReplyData length='");
            SmartReplyData r6 = this.smartReplyData;
            if (r6 != null) goto L13;
            int r7 = 0;
        L14:
            r0.append(r7);
            r0.append("', reaction size='");
            List<Reaction> r8 = this.reaction;
            if (r8 != null) goto L17;
            int r9 = 0;
        L18:
            r0.append(r9);
            r0.append("', originalReaction size='");
            List<Reaction> r10 = this.originalReaction;
            if (r10 != null) goto L21;
            int r11 = 0;
        L22:
            r0.append(r11);
            r0.append("', participantList size='");
            List<String> r12 = this.participantList;
            if (r12 == null) goto L26;
            r2 = r12.size();
        L26:
            r0.append(r2);
            r0.append("'}");
            return r0.toString();
        L21:
            r11 = r10.size();
            goto L22
        L17:
            r9 = r8.size();
            goto L18
        L13:
            r7 = r6.getPlainTextPreview().length();
            goto L14
        L9:
            r5 = Integer.valueOf(r4.length);
            goto L10
        L5:
            r3 = r1.length();
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

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L59:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L59;
            CommentDetail r6 = (CommentDetail) r5;
            if (Objects.equals(this.comment_id, r6.comment_id) == true) goto L13;
        L57:
            return false;
        L13:
            if (Objects.equals(this.reply_id, r6.reply_id) == false) goto L57;
            if (Objects.equals(this.user_id, r6.user_id) == false) goto L57;
            if (Objects.equals(this.name, r6.name) == false) goto L57;
            if (Objects.equals(this.content, r6.content) == false) goto L57;
            if (Objects.equals(Boolean.valueOf(this.sending), Boolean.valueOf(r6.isSending())) == false) goto L57;
            if (Objects.equals(this.error, r6.error) == false) goto L57;
            if (Objects.equals(this.reaction_type, r6.reaction_type) == false) goto L57;
            if (Objects.equals(this.translate_content, r6.translate_content) == false) goto L57;
            if (Objects.equals(this.targetLanguage, r6.targetLanguage) == false) goto L57;
            if (Objects.equals(this.userMainLang, r6.userMainLang) == false) goto L57;
            if (Objects.equals(this.userDefaultTargetLang, r6.userDefaultTargetLang) == false) goto L57;
            if (Objects.equals(this.translate_status, r6.translate_status) == false) goto L57;
            if (Objects.equals(Boolean.valueOf(this.isEditStatus), Boolean.valueOf(r6.isEditStatus)) == false) goto L57;
            if (Objects.equals(this.reaction, r6.reaction) == false) goto L57;
            if (Objects.equals(this.extra, r6.extra) == false) goto L57;
            if (Arrays.equals(this.messageIds, r6.messageIds) == false) goto L57;
            if (Objects.equals(Integer.valueOf(this.replyType), Integer.valueOf(r6.replyType)) == false) goto L57;
            if (Objects.equals(this.bitableExtra, r6.bitableExtra) == false) goto L57;
            if (Objects.equals(Boolean.valueOf(this.perSmartReplyPreview), Boolean.valueOf(r6.perSmartReplyPreview)) == false) goto L57;
            if (Objects.equals(this.smartReplyData, r6.smartReplyData) == false) goto L57;
            if (Objects.equals(this.participantList, r6.participantList) == false) goto L57;
            if (Objects.equals(Integer.valueOf(this.modify), Integer.valueOf(r6.modify)) == false) goto L57;
            return true;
        }

        public void setAnonymous(boolean r1) {
            this.anonymous = r1;
        }

        public void setAvatar_url(String r1) {
            this.avatar_url = r1;
        }

        public void setBitableExtra(BitableExtraEntity r1) {
            this.bitableExtra = r1;
        }

        public void setCommentType(int r1) {
            this.commentType = r1;
        }

        public void setCommentUUID(String r1) {
            this.commentUUID = r1;
        }

        public void setComment_id(String r1) {
            this.comment_id = r1;
        }

        public void setCompatibleReplyIdBeforeSend(String r1) {
            this.compatibleReplyIdBeforeSend = r1;
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

        public void setFirstReply(boolean r1) {
            this.isFirstReply = r1;
        }

        public void setFull(boolean r1) {
            this.isFull = r1;
        }

        public void setInReply(boolean r1) {
            this.inReply = r1;
        }

        public void setIs_whole(int r1) {
            this.is_whole = r1;
        }

        public void setMessageId(String r3) {
            if (this.messageIds != null) goto L6;
            this.messageIds = new String[]{r3};
            return;
        }

        public void setMessageIds(String[] r1) {
            this.messageIds = r1;
        }

        public void setModify(int r1) {
            this.modify = r1;
        }

        public void setName(String r1) {
            this.name = r1;
        }

        public void setOriginalReaction(List<Reaction> r1) {
            this.originalReaction = r1;
        }

        public void setParticipantList(List<String> r1) {
            this.participantList = r1;
        }

        public void setPerSmartReplyPreview(boolean r1) {
            this.perSmartReplyPreview = r1;
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

        public void setReadStatus(int r1) {
            this.readStatus = r1;
        }

        public void setReferKey(String r1) {
            this.reply_id = r1;
        }

        public void setReplyType(int r1) {
            this.replyType = r1;
        }

        public void setReplyUUID(String r1) {
            this.replyUUID = r1;
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

        public void setSmartReplyData(SmartReplyData r1) {
            this.smartReplyData = r1;
        }

        public void setTargetLanguage(String r1) {
            this.targetLanguage = r1;
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

        public void setUserDefaultTargetLang(String r1) {
            this.userDefaultTargetLang = r1;
        }

        public void setUserMainLang(String r1) {
            this.userMainLang = r1;
        }

        public void setUser_id(String r1) {
            this.user_id = r1;
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
            VisibilityBean r0 = this.newInputVisibility;
            if (r0 == null) goto L7;
            return r0.getType();
        L7:
            return this.visibility;
        }

        public String getReportVisibility() {
            int r0 = getVisibility();
            if (r0 != 0) goto L7;
            return "public_comment";
        L7:
            if (r0 != 1) goto L11;
            return "partially_visible_comments";
        L11:
            if (r0 != 2) goto L14;
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

        public static /* synthetic */ ParentCommentInfo access$000(Extra r0) {
            return r0.parentInfo;
        }

        public void setNewInputVisibility(VisibilityBean r1) {
            this.newInputVisibility = r1;
        }

        public void setParentInfo(ParentCommentInfo r1) {
            this.parentInfo = r1;
        }

        public void setRevisionExtra(RevisionExtra r1) {
            this.revisionExtra = r1;
        }

        public void setSource(int r2) {
            if (r2 != 0) goto L4;
        L10:
            this.source = r2;
            return;
        L4:
            if (r2 == 1) goto L10;
            if (r2 == 2) goto L10;
            if (r2 == 3) goto L10;
            this.source = 0;
        }

        public void setVisibility(int r1) {
            this.visibility = r1;
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

        public static /* synthetic */ String access$100(ParentCommentInfo r0) {
            return r0.parentId;
        }

        public void setParentId(String r1) {
            this.parentId = r1;
        }

        public void setReferReplyId(String r1) {
            this.referReplyId = r1;
        }
    }

    public boolean isTmpCard() {
        if (this.isNewInput == false) goto L11;
        Extra r0 = this.extra;
        if (r0 == null) goto L11;
        if (Extra.access$000(r0) == null) goto L11;
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

    public boolean isActionBlocked(CommentAction r2) {
        return this.blockedActionList.contains(r2.getValue());
    }

    public void setBizParams(Map<Object, Object> r1) {
        this.bizParams = r1;
    }

    public void setBlockedActionList(List<String> r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.blockedActionList = r1;
    }

    public void setCanPerformAction(boolean r1) {
        this.canPerformAction = r1;
    }

    public void setCommentAnchorId(String r1) {
        this.commentAnchorId = r1;
    }

    public void setCommentType(int r1) {
        this.commentType = r1;
    }

    public void setCommentUUID(String r1) {
        this.commentUUID = r1;
    }

    public void setComment_id(String r1) {
        this.comment_id = r1;
    }

    public void setComment_list(List<CommentDetail> r1) {
        this.comment_list = r1;
    }

    public void setCurrentReplyId(String r1) {
        this.currentReplyId = r1;
    }

    public void setExpanded(boolean r1) {
        this.isExpanded = r1;
    }

    public void setExtra(Extra r1) {
        this.extra = r1;
    }

    public void setFinish(int r1) {
        this.finish = r1;
    }

    public void setFocusCard(boolean r1) {
        this.focusCard = r1;
    }

    public void setIs_whole(int r1) {
        this.is_whole = r1;
    }

    public void setNewInput(boolean r1) {
        this.isNewInput = r1;
    }

    public void setParentToken(String r1) {
        this.parentToken = r1;
    }

    public void setParentType(String r1) {
        this.parentType = r1;
    }

    public void setParticipantList(List<String> r1) {
        this.participantList = r1;
    }

    public void setPosition(String r1) {
        this.position = r1;
    }

    public void setQuote(String r1) {
        this.quote = r1;
    }

    public void setReactionList(List<Reaction> r1) {
        this.reactionList = r1;
    }

    public void setScrollLast(boolean r1) {
        this.isScrollLast = r1;
    }

    public void setUnSubmitComment(boolean r1) {
        this.unSubmitComment = r1;
    }

    public void setUserId(String r1) {
        this.userId = r1;
    }
}
