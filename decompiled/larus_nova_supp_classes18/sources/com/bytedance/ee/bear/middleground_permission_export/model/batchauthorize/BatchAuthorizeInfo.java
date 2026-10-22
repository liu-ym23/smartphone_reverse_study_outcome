package com.bytedance.ee.bear.middleground_permission_export.model.batchauthorize;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public void setChatAvatar(String r1) {
        this.chatAvatar = r1;
    }

    public void setChatDesp(String r1) {
        this.chatDesp = r1;
    }

    public void setChatId(String r1) {
        this.chatId = r1;
    }

    public void setChatName(String r1) {
        this.chatName = r1;
    }

    public void setChatType(int r1) {
        this.chatType = r1;
    }

    public void setOwnerId(String r1) {
        this.ownerId = r1;
    }

    public void setOwnerName(String r1) {
        this.ownerName = r1;
    }

    public void setTaskId(String r1) {
        this.taskId = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }
}
