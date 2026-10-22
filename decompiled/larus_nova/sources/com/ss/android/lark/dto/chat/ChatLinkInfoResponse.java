package com.ss.android.lark.dto.chat;

import com.bytedance.lark.pb.im.v1.GetChatLinkInfoResponse;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.parser.internal.h;
import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class ChatLinkInfoResponse implements Serializable {
    private boolean canInvited;
    private Chat chat;
    private String chatId;
    private String inviterId;
    private boolean isInChat;

    public Chat getChat() {
        return this.chat;
    }

    public String getChatId() {
        return this.chatId;
    }

    public String getInviterId() {
        return this.inviterId;
    }

    public boolean isCanInvited() {
        return this.canInvited;
    }

    public boolean isInChat() {
        return this.isInChat;
    }

    public ChatLinkInfoResponse(GetChatLinkInfoResponse r100) {
        this.isInChat = r100.already_in_chat.booleanValue();
        String r101 = r100.chat_id;
        this.chatId = r101;
        this.chat = h.a(r100.entity.chats.get(r101), null);
        this.canInvited = r100.is_inviter_can_invite_member.booleanValue();
        this.inviterId = r100.inviter_chatter_id;
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
}
