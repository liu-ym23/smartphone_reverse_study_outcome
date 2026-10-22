package com.ss.android.lark.share_group;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import java.io.Serializable;

/* JADX INFO: loaded from: classes38.dex */
public class GroupProfileData implements Serializable {
    private Chat chat;
    private Chatter chatOwner;
    private Message message;

    public Chat getChat() {
        return this.chat;
    }

    public Chatter getChatOwner() {
        return this.chatOwner;
    }

    public Message getMessage() {
        return this.message;
    }

    public void setChat(Chat r100) {
        this.chat = r100;
    }

    public void setChatOwner(Chatter r100) {
        this.chatOwner = r100;
    }

    public void setMessage(Message r100) {
        this.message = r100;
    }

    public GroupProfileData(Message r100, Chat r101, Chatter r102) {
        this.message = r100;
        this.chat = r101;
        this.chatOwner = r102;
    }
}
