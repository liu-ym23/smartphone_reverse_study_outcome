package com.bytedance.ee.bear.middleground.feed.export.bean;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: classes18.dex */
public class MessageBean extends BaseFeedMessageDetailBean implements Serializable {
    public static final int COMMENT_DELETE = 1;
    public static final int COMMENT_HAS_AT = 1;
    public static final int COMMENT_NO_AT = 0;
    public static final int COMMENT_NO_DELETE = 0;
    public static final String MESSAGE_DOC_COMMENT = "MESSAGE_DOC_COMMENT";
    public static final String MESSAGE_DOC_MENTION = "MESSAGE_DOC_MENTION";
    public static final String MESSAGE_DOC_SHARE = "MESSAGE_DOC_SHARE";
    public static final int TYPE_READED = 2;
    public static final int TYPE_UNREAD = 1;
    private String commentExtra;
    private int commentMention;
    private int commentType;

    @JSONField(name = "content_reaction_key")
    private String contentReactionKey;

    @JSONField(name = "contentReactionDelete")
    private boolean content_reaction_delete;

    @JSONField(name = "contentReactionId")
    private String content_reaction_id;
    private int createTime;

    @JSONField(name = "commentDelete")
    private int delete;
    private int finish;

    @JSONField(alternateNames = {"hasCommentPermission"}, name = "has_comment_permission")
    private boolean hasCommentPermission;
    private String mentionId;
    private String messageId;

    @JSONField(name = "localDeleted")
    private boolean originContentDelete;

    @JSONField(name = "status")
    private int readStatus;
    private int replyIndex;
    private String subType;
    private String type;

    public MessageBean() {
        this.type = MESSAGE_DOC_COMMENT;
        this.subType = "";
        this.readStatus = 2;
        this.originContentDelete = false;
        this.hasCommentPermission = true;
        this.delete = 0;
        this.replyIndex = 0;
        this.commentMention = 0;
        this.commentType = 0;
        this.commentExtra = "";
    }

    @JSONField(name = "comment_extra")
    public String getCommentExtra() {
        return this.commentExtra;
    }

    public int getCommentMention() {
        return this.commentMention;
    }

    public int getCommentType() {
        return this.commentType;
    }

    public String getContentReactionKey() {
        return this.contentReactionKey;
    }

    public String getContent_reaction_id() {
        return this.content_reaction_id;
    }

    public int getCreateTime() {
        return this.createTime;
    }

    public int getDelete() {
        return this.delete;
    }

    public int getFinish() {
        return this.finish;
    }

    public String getMentionId() {
        return this.mentionId;
    }

    public String getMessageId() {
        return this.messageId;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.BaseFeedMessageDetailBean
    public String getQuote() {
        return this.quote;
    }

    public int getReadStatus() {
        return this.readStatus;
    }

    public int getReplyIndex() {
        return this.replyIndex;
    }

    public String getSubType() {
        return this.subType;
    }

    public String getType() {
        return this.type;
    }

    public boolean isContent_reaction_delete() {
        return this.content_reaction_delete;
    }

    public boolean isHasCommentPermission() {
        return this.hasCommentPermission;
    }

    public boolean isOriginContentDelete() {
        return this.originContentDelete;
    }

    public static String a(Object r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if ((r100 instanceof String) == false) goto L10;
        return (String) r100;
    L10:
        if ((r100 instanceof JSONObject) == true) goto L17;
        if ((r100 instanceof JSONArray) == true) goto L17;
        tt5.a.k("MessageBean", "parse commentExtra failed: unsupported type = ".concat(r100.getClass().getSimpleName()));
        return "";
    L17:
        return r100.toString();
    }

    public void setCommentExtra(String r100) {
        this.commentExtra = a(r100);
    }

    @JSONField(alternateNames = {"commentExtra"}, name = "comment_extra")
    public void setCommentExtraValue(Object r100) {
        this.commentExtra = a(r100);
    }

    public void setCommentMention(int r100) {
        this.commentMention = r100;
    }

    public void setCommentType(int r100) {
        this.commentType = r100;
    }

    public void setContentReactionKey(String r100) {
        this.contentReactionKey = r100;
    }

    public void setContent_reaction_delete(boolean r100) {
        this.content_reaction_delete = r100;
    }

    public void setContent_reaction_id(String r100) {
        this.content_reaction_id = r100;
    }

    public void setCreateTime(int r100) {
        this.createTime = r100;
    }

    public void setDelete(int r100) {
        this.delete = r100;
    }

    public void setFinish(int r100) {
        this.finish = r100;
    }

    public void setHasCommentPermission(boolean r100) {
        this.hasCommentPermission = r100;
    }

    public void setMentionId(String r100) {
        this.mentionId = r100;
    }

    public void setMessageId(String r100) {
        this.messageId = r100;
    }

    public void setOriginContentDelete(boolean r100) {
        this.originContentDelete = r100;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.BaseFeedMessageDetailBean
    public void setQuote(String r100) {
        this.quote = r100;
    }

    public void setReadStatus(int r100) {
        this.readStatus = r100;
    }

    public void setReplyIndex(int r100) {
        this.replyIndex = r100;
    }

    public void setSubType(String r100) {
        this.subType = r100;
    }

    public void setType(String r100) {
        this.type = r100;
    }
}
