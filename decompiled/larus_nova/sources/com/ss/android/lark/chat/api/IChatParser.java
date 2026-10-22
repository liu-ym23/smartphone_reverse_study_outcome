package com.ss.android.lark.chat.api;

import com.bytedance.lark.pb.basic.v1.ChatMailSetting;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public interface IChatParser {
    Chat getChat(com.bytedance.lark.pb.basic.v1.Chat r100);

    Chat getChat(com.bytedance.lark.pb.basic.v1.Chat r100, Map<String, ChatMailSetting> r101);

    List<Chat> getChatList(List<com.bytedance.lark.pb.basic.v1.Chat> r100);

    Map<String, Chat> getChatMap(Map<String, com.bytedance.lark.pb.basic.v1.Chat> r100);

    Chatter getChatter(com.bytedance.lark.pb.basic.v1.Chatter r100);

    Map<String, Chatter> parseChatterMapFromEntity(Entity r100);
}
