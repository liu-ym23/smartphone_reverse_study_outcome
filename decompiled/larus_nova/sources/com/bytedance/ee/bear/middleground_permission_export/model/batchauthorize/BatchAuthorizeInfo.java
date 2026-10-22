package com.bytedance.ee.bear.middleground_permission_export.model.batchauthorize;

import java.io.Serializable;

/* JADX INFO: loaded from: classes18.dex */
public class BatchAuthorizeInfo implements Serializable {
    public static final String KEY_BATCH_AUTHORIZE = "key_batch_authorize";
    private String chatAvatar;
    private String chatDesp;
    private String chatId;
    private String chatName;
    private int chatType;
    private String ownerId;
    private String ownerName;
    private String taskId;
    private String token;
    private int type;

    public BatchAuthorizeInfo() {
    }

    public String getChatAvatar() {
        return this.chatAvatar;
    }

    public String getChatDesp() {
        return this.chatDesp;
    }

    public String getChatId() {
        return this.chatId;
    }

    public String getChatName() {
        return this.chatName;
    }

    public int getChatType() {
        return this.chatType;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getToken() {
        return this.token;
    }

    public int getType() {
        return this.type;
    }

    public void setChatAvatar(String r100) {
        this.chatAvatar = r100;
    }

    public void setChatDesp(String r100) {
        this.chatDesp = r100;
    }

    public void setChatId(String r100) {
        this.chatId = r100;
    }

    public void setChatName(String r100) {
        this.chatName = r100;
    }

    public void setChatType(int r100) {
        this.chatType = r100;
    }

    public void setOwnerId(String r100) {
        this.ownerId = r100;
    }

    public void setOwnerName(String r100) {
        this.ownerName = r100;
    }

    public void setTaskId(String r100) {
        this.taskId = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }
}
