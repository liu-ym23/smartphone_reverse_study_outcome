package com.ss.android.lark.chat.api;

import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.ss.android.lark.chat.entity.chatter.a;
import com.ss.android.lark.chat.export.entity.chatter.OpenChatter;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public interface IChatterParser {
    /* synthetic */ Map<String, OpenChatter> fromPbChatterMap(Map<String, Chatter> r100);

    a getChatChatters(Entity r100, String r101);

    com.ss.android.lark.chat.entity.chatter.Chatter getChatter(Chatter r100);

    List<com.ss.android.lark.chat.entity.chatter.Chatter> getChatterList(List<Chatter> r100);

    Map<String, com.ss.android.lark.chat.entity.chatter.Chatter> getChatterMap(Map<String, Chatter> r100);

    Map<String, com.ss.android.lark.chat.entity.chatter.Chatter> getChatterMapFromEntity(Entity r100);
}
