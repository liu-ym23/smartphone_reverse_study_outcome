package com.ss.android.lark.search.dto.info;

import android.text.TextUtils;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.lark.pb.search.v2.SearchResult;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.q;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.entity.message.content.FolderContent;
import com.ss.android.lark.doc.entity.Doc;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class SearchMessageInfo extends SearchBaseInfo {
    private static final long serialVersionUID = -265524418720780540L;
    private int attachmentCount;
    private ArrayList<MessageAttachment> attachments;
    private AuthAction authAction;
    private boolean binderByFile;
    private String chatId;
    private long createTime;
    private FileContent fileContent;
    private FolderContent folderContent;
    private String fromAvatarKey;
    private String fromId;
    private String fromName;
    private String fromTenantId;
    private boolean isP2pChat;
    private List<Doc> messageDocInfoList;
    private String messageId;
    private int messageThreadPosition;
    private Message.Type msgType;
    private String p2pBotId;
    private long p2pChatterId;
    private int position;
    private int rootMessagePosition;
    private int threadChatPosition;
    private String threadId;
    private com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType threadMessageType;
    private long updateTime;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AvatarType {
        public static final int ChatInside = 1;
        public static final int Default = 0;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getResultTypeForReport() {
        if (this.binderByFile == true) goto L5;
        return "messages";
    L5:
        if (this.fileContent == null) goto L9;
        return "file";
    L9:
        if (this.folderContent == null) goto L14;
        return DocumentType.FOLDER_NAME;
    L14:
        return "messages";
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getTagForReport() {
        StringBuilder r100 = new StringBuilder(super.getTagForReport());
        if (CollectionUtils.isEmpty(this.attachments) == true) goto L6;
        r100.append("multimedia_card,");
    L6:
        if (getRecallScene() != SearchResult.RecallScene.MESSAGE_PINYIN_TO_CHINESE_NAME) goto L9;
        r100.append("message_pinyin_to_chinese_name,");
    L9:
        return r100.toString();
    }

    public SearchMessageInfo() {
        this.fileContent = null;
        this.folderContent = null;
        this.authAction = new AuthAction();
        this.attachmentCount = 0;
        this.type = 3;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getSubResultTypeForReport() {
        String r100 = super.getSubResultTypeForReport();
        if (TextUtils.equals(getResultTypeForReport(), "messages") == true) goto L5;
        return r100;
    L5:
        if (q.a(this.attachments) == true) goto L31;
        Iterator<MessageAttachment> r101 = this.attachments.iterator();
    L8:
        if (r101.hasNext() == false) goto L33;
        MessageAttachment r102 = r101.next();
        if (r102.getLinkClickedForReport() == false) goto L8;
        if (r102.getAttachmentType() != com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType.ATTACHMENT_FILE) goto L16;
        return "file";
    L16:
        if (r102.getAttachmentType() != com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType.ATTACHMENT_IMAGE) goto L20;
        return "image";
    L20:
        if (r102.getAttachmentType() != com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType.ATTACHMENT_LINK) goto L24;
        return "link";
    L24:
        if (r102.getAttachmentType() != com.bytedance.lark.pb.basic.v1.Message.MessageAttachmentType.ATTACHMENT_VIDEO) goto L32;
        return "video";
    L32:
        return r100;
    L33:
        return r100;
    L31:
        return r100;
    }

    public int getAttachmentCount() {
        return this.attachmentCount;
    }

    public List<MessageAttachment> getAttachments() {
        return this.attachments;
    }

    public AuthAction getAuthAction() {
        return this.authAction;
    }

    public String getChatId() {
        return this.chatId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public FileContent getFileContent() {
        return this.fileContent;
    }

    public FolderContent getFolderContent() {
        return this.folderContent;
    }

    public String getFromAvatarKey() {
        return this.fromAvatarKey;
    }

    public String getFromId() {
        return this.fromId;
    }

    public String getFromName() {
        return this.fromName;
    }

    public String getFromTenantId() {
        return this.fromTenantId;
    }

    public List<Doc> getMessageDocInfoList() {
        return this.messageDocInfoList;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getMessageThreadPosition() {
        return this.messageThreadPosition;
    }

    public Message.Type getMsgType() {
        return this.msgType;
    }

    public String getP2pBotId() {
        return this.p2pBotId;
    }

    public long getP2pChatterId() {
        return this.p2pChatterId;
    }

    public int getPosition() {
        return this.position;
    }

    public int getRootMessagePosition() {
        return this.rootMessagePosition;
    }

    public int getThreadChatPosition() {
        return this.threadChatPosition;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType getThreadMessageType() {
        return this.threadMessageType;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public boolean isBinderByFile() {
        return this.binderByFile;
    }

    public boolean isP2pChat() {
        return this.isP2pChat;
    }

    public String getAvatarId(int r100) {
        if (r100 != 0) goto L10;
        if (this.isP2pChat == false) goto L8;
        return String.valueOf(this.p2pChatterId);
    L8:
        return this.chatId;
    L10:
        return this.fromId;
    }

    public void setAttachmentCount(int r100) {
        this.attachmentCount = r100;
    }

    public void setAttachments(List<MessageAttachment> r100) {
        this.attachments = new ArrayList(r100);
    }

    public void setAuthAction(AuthAction r100) {
        this.authAction = r100;
    }

    public void setBinderByFile(boolean r100) {
        this.binderByFile = r100;
    }

    public void setChatId(String r100) {
        this.chatId = r100;
    }

    public void setCreateTime(long r100) {
        this.createTime = r100;
    }

    public void setFileContent(FileContent r100) {
        this.fileContent = r100;
    }

    public void setFolderContent(FolderContent r100) {
        this.folderContent = r100;
    }

    public void setFromAvatarKey(String r100) {
        this.fromAvatarKey = r100;
    }

    public void setFromId(String r100) {
        this.fromId = r100;
    }

    public void setFromName(String r100) {
        this.fromName = r100;
    }

    public void setFromTenantId(String r100) {
        this.fromTenantId = r100;
    }

    public void setMessageDocInfoList(List<Doc> r100) {
        this.messageDocInfoList = r100;
    }

    public void setMessageId(String r100) {
        this.messageId = r100;
    }

    public void setMessageThreadPosition(int r100) {
        this.messageThreadPosition = r100;
    }

    public void setMsgType(Message.Type r100) {
        this.msgType = r100;
    }

    public void setP2pBotId(String r100) {
        this.p2pBotId = r100;
    }

    public void setP2pChat(boolean r100) {
        this.isP2pChat = r100;
    }

    public void setP2pChatterId(long r100) {
        this.p2pChatterId = r100;
    }

    public void setPosition(int r100) {
        this.position = r100;
    }

    public void setRootMessagePosition(int r100) {
        this.rootMessagePosition = r100;
    }

    public void setThreadChatPosition(int r100) {
        this.threadChatPosition = r100;
    }

    public void setThreadId(String r100) {
        this.threadId = r100;
    }

    public void setThreadMessageType(com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType r100) {
        this.threadMessageType = r100;
    }

    public void setUpdateTime(long r100) {
        this.updateTime = r100;
    }
}
