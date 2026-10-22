package com.ss.android.lark.chat.entity.message;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class MessageIdentity implements Serializable {
    private String chatId;
    private long createTime;
    private boolean hideCopy;
    private boolean hideEditor;
    private boolean hideForward;
    private boolean hideImageOCR;
    private boolean hideJumpChat;
    private boolean hideSaveToDriver;
    private boolean hideStickerSave;
    private boolean mergeForwardRootMessageIsRestricted;
    private String messageId;
    private ArrayList<String> riskObjectKeys;
    private String senderId;
    private String senderTenantId;
    private String sourceId;
    private Message.SourceType sourceType;
    private String threadId;
    private int threadPosition;

    public Message.SourceType getSourceType() {
        Message.SourceType r100 = this.sourceType;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return Message.SourceType.TYPE_FROM_MESSAGE;
    }

    public String toString() {
        return "MessageIdentity{messageId='" + this.messageId + "', sourceId='" + this.sourceId + "', chatId='" + this.chatId + "', sourceType=" + this.sourceType + ", createTime=" + this.createTime + ", threadId='" + this.threadId + "', threadPosition=" + this.threadPosition + ", hideForward=" + this.hideForward + ", hideEditor=" + this.hideEditor + ", hideJumpChat=" + this.hideJumpChat + ", hideSaveToDriver=" + this.hideSaveToDriver + ", hideStickerSave=" + this.hideStickerSave + ", hideCopy=" + this.hideCopy + ", hideImageOCR=" + this.hideImageOCR + ", senderId=" + this.senderId + ", senderTenantId=" + this.senderTenantId + '}';
    }

    public String getChatId() {
        return this.chatId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public List<String> getRiskObjectKeys() {
        return this.riskObjectKeys;
    }

    public String getSenderId() {
        return this.senderId;
    }

    public String getSenderTenantId() {
        return this.senderTenantId;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public int getThreadPosition() {
        return this.threadPosition;
    }

    public boolean isHideCopy() {
        return this.hideCopy;
    }

    public boolean isHideEditor() {
        return this.hideEditor;
    }

    public boolean isHideForward() {
        return this.hideForward;
    }

    public boolean isHideImageOCR() {
        return this.hideImageOCR;
    }

    public boolean isHideJumpChat() {
        return this.hideJumpChat;
    }

    public boolean isHideSaveToDriver() {
        return this.hideSaveToDriver;
    }

    public boolean isHideStickerSave() {
        return this.hideStickerSave;
    }

    public boolean isMergeForwardRootMessageIsRestricted() {
        return this.mergeForwardRootMessageIsRestricted;
    }

    public void setChatId(String r100) {
        this.chatId = r100;
    }

    public void setCreateTime(long r100) {
        this.createTime = r100;
    }

    public void setHideCopy(boolean r100) {
        this.hideCopy = r100;
    }

    public void setHideEditor(boolean r100) {
        this.hideEditor = r100;
    }

    public void setHideForward(boolean r100) {
        this.hideForward = r100;
    }

    public void setHideImageOCR(boolean r100) {
        this.hideImageOCR = r100;
    }

    public void setHideJumpChat(boolean r100) {
        this.hideJumpChat = r100;
    }

    public void setHideSaveToDriver(boolean r100) {
        this.hideSaveToDriver = r100;
    }

    public void setHideStickerSave(boolean r100) {
        this.hideStickerSave = r100;
    }

    public void setMergeForwardRootMessageIsRestricted(boolean r100) {
        this.mergeForwardRootMessageIsRestricted = r100;
    }

    public void setMessageId(String r100) {
        this.messageId = r100;
    }

    public void setRiskObjectKeys(List<String> r100) {
        if (r100 == null) goto L5;
        this.riskObjectKeys = new ArrayList(r100);
        return;
    }

    public void setSenderId(String r100) {
        this.senderId = r100;
    }

    public void setSenderTenantId(String r100) {
        this.senderTenantId = r100;
    }

    public void setSourceId(String r100) {
        this.sourceId = r100;
    }

    public void setSourceType(Message.SourceType r100) {
        this.sourceType = r100;
    }

    public void setThreadId(String r100) {
        this.threadId = r100;
    }

    public void setThreadPosition(int r100) {
        this.threadPosition = r100;
    }

    public MessageIdentity(String r100, String r101) {
        this.hideStickerSave = true;
        this.hideCopy = false;
        this.hideImageOCR = false;
        this.messageId = r100;
        this.chatId = r101;
        this.sourceId = r100;
        this.sourceType = Message.SourceType.TYPE_FROM_MESSAGE;
        setRiskObjectKeys(new ArrayList());
    }

    public MessageIdentity(String r100, String r101, String r102, Message.SourceType r103) {
        this.hideStickerSave = true;
        this.hideCopy = false;
        this.hideImageOCR = false;
        this.messageId = r100;
        this.chatId = r101;
        if (TextUtils.isEmpty(r102) == false) goto L5;
        this.sourceId = r100;
    L6:
        this.sourceType = r103;
        setRiskObjectKeys(new ArrayList());
        return;
    L5:
        this.sourceId = r102;
        goto L6
    }
}
