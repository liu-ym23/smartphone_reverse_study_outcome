package com.ss.android.lark.flow.group;

import com.ss.android.lark.chat.entity.chat.Chat;
import java.io.Serializable;

/* JADX INFO: loaded from: classes36.dex */
public class FlowChatLinkInfoResponse implements Serializable {
    private boolean canInvited;
    private Chat chat;
    private String chatId;
    private String inviterId;
    private boolean isInChat;
    private String token;

    public Chat getChat() {
        return this.chat;
    }

    public String getChatId() {
        return this.chatId;
    }

    public String getInviterId() {
        return this.inviterId;
    }

    public String getToken() {
        return this.token;
    }

    public boolean isCanInvited() {
        return this.canInvited;
    }

    public boolean isInChat() {
        return this.isInChat;
    }

    public void setCanInvited(boolean r100) {
        this.canInvited = r100;
    }

    public void setChat(Chat r100) {
        this.chat = r100;
    }

    public void setChatId(String r100) {
        this.chatId = r100;
    }

    public void setInChat(boolean r100) {
        this.isInChat = r100;
    }

    public void setInviterId(String r100) {
        this.inviterId = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public FlowChatLinkInfoResponse(boolean r100, String r101, String r102, Chat r103, boolean r104, String r105) {
        this.isInChat = r100;
        this.chatId = r101;
        this.token = r102;
        this.chat = r103;
        this.canInvited = r104;
        this.inviterId = r105;
    }
}
