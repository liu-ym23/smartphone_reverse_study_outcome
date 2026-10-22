package com.ss.android.lark.biz.im.api;

import com.ss.android.lark.chat.entity.chat.Chat;
import java.io.Serializable;

/* JADX INFO: loaded from: classes34.dex */
public class ChatQRCodeInfoResponse implements Serializable {
    private boolean alreadyInChat;
    private Chat chat;
    private String inviteUrl;
    private String inviterId;
    private boolean isInviteCanAddMember;
    private String showMsg;

    public Chat getChat() {
        return this.chat;
    }

    public String getInviteUrl() {
        return this.inviteUrl;
    }

    public String getInviterId() {
        return this.inviterId;
    }

    public String getShowMsg() {
        return this.showMsg;
    }

    public boolean isAlreadyInChat() {
        return this.alreadyInChat;
    }

    public boolean isInviteCanAddMember() {
        return this.isInviteCanAddMember;
    }

    public void setAlreadyInChat(boolean r100) {
        this.alreadyInChat = r100;
    }

    public void setChat(Chat r100) {
        this.chat = r100;
    }

    public void setInviteCanAddMember(boolean r100) {
        this.isInviteCanAddMember = r100;
    }

    public void setInviteUrl(String r100) {
        this.inviteUrl = r100;
    }

    public void setInviterId(String r100) {
        this.inviterId = r100;
    }

    public void setShowMsg(String r100) {
        this.showMsg = r100;
    }

    public ChatQRCodeInfoResponse(boolean r100, Chat r101, String r102, boolean r103, String r104, String r105) {
        this.alreadyInChat = r100;
        this.chat = r101;
        this.inviterId = r102;
        this.isInviteCanAddMember = r103;
        this.showMsg = r104;
        this.inviteUrl = r105;
    }
}
