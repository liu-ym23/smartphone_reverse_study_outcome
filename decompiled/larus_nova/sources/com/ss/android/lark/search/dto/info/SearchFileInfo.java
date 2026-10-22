package com.ss.android.lark.search.dto.info;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.search.dto.constant.SearchCommonConstants;

/* JADX INFO: loaded from: classes38.dex */
public class SearchFileInfo extends SearchBaseInfo {
    private static final long serialVersionUID = 2939786038190638748L;
    private String chatId;
    private FileContent fileContent;
    private String fromId;
    private boolean isP2pChat;
    private Message.Type msgType;
    private long p2pChatterId;
    private int position;
    private String threadId;
    private int threadPosition;
    private long updateTime;

    public SearchFileInfo() {
        this.fileContent = null;
        this.type = SearchCommonConstants.SearchResultType.FILE;
    }

    public String getChatId() {
        return this.chatId;
    }

    public FileContent getFileContent() {
        return this.fileContent;
    }

    public String getFromId() {
        return this.fromId;
    }

    public Message.Type getMsgType() {
        return this.msgType;
    }

    public long getP2pChatterId() {
        return this.p2pChatterId;
    }

    public int getPosition() {
        return this.position;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public int getThreadPosition() {
        return this.threadPosition;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public boolean isP2pChat() {
        return this.isP2pChat;
    }

    public void setChatId(String r100) {
        this.chatId = r100;
    }

    public void setFileContent(FileContent r100) {
        this.fileContent = r100;
    }

    public void setFromId(String r100) {
        this.fromId = r100;
    }

    public void setMsgType(Message.Type r100) {
        this.msgType = r100;
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

    public void setThreadId(String r100) {
        this.threadId = r100;
    }

    public void setThreadPosition(int r100) {
        this.threadPosition = r100;
    }

    public void setUpdateTime(long r100) {
        this.updateTime = r100;
    }
}
