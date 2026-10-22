package com.ss.android.lark.contact.base.dto;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class ChatBotsResponse implements Serializable {
    public List<Chatter> chatters;
    public boolean hasMore;

    public ChatBotsResponse(List<Chatter> r100, boolean r101) {
        this.chatters = r100;
        this.hasMore = r101;
    }
}
