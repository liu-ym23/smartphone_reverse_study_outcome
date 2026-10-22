package com.ss.android.lark.parser.internal;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.MessageLink;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes37.dex */
public final class t {
    static {
    }

    public static MessageLink a(com.bytedance.lark.pb.basic.v1.MessageLink r110) {
        Chat.Type r100 = null;
        if (r110 != null) goto L5;
        return null;
    L5:
        boolean r101 = false;
        HashMap r102 = new HashMap(0);
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r110.entity_ids.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        r103.add((Long) r104.next());
        goto L7
    L9:
        com.bytedance.lark.pb.basic.v1.MessageLink.MetaInfo r105 = r110.meta_info;
        if (r105 == null) goto L14;
        Long r106 = r105.from_chat_id;
        if (r106 == null) goto L14;
        String r107 = r106.toString();
    L15:
        if (r107 == null) goto L19;
        Map<String, com.bytedance.lark.pb.basic.v1.Chat> r108 = r110.chats;
        if (r108 == null) goto L19;
        com.bytedance.lark.pb.basic.v1.Chat r109 = r108.get(r107);
    L20:
        String r111 = r110.token;
        com.bytedance.lark.pb.basic.v1.MessageLink.ChatInfo r112 = r110.chat_info;
        if (r112 != null) goto L33;
        com.bytedance.lark.pb.basic.v1.MessageLink.ChatInfo.Builder r113 = new com.bytedance.lark.pb.basic.v1.MessageLink.ChatInfo.Builder().name("");
        if (r109 == null) goto L26;
        com.bytedance.lark.pb.basic.v1.Chat.Type r114 = r109.type;
        if (r114 == null) goto L26;
    L27:
        com.bytedance.lark.pb.basic.v1.MessageLink.ChatInfo.Builder r115 = r113.type(r114);
        if (r109 == null) goto L32;
        Boolean r116 = r109.is_p2p_official_bot_ai;
        if (r116 == null) goto L32;
        r101 = r116.booleanValue();
    L32:
        r112 = r115.is_p2p_bot(Boolean.valueOf(r101)).is_auth(Boolean.FALSE).build();
    L26:
        r114 = com.bytedance.lark.pb.basic.v1.Chat.DEFAULT_TYPE;
    L33:
        com.bytedance.lark.pb.basic.v1.Chat.Type r117 = r112.type;
        if (r117 == null) goto L37;
        r100 = Chat.Type.valueOf(r117.getValue());
    L37:
        return new MessageLink(r111, r103, r102, new MessageLink.ChatInfo(r112.name, r100, r112.is_p2p_bot.booleanValue(), r107, r112.is_auth.booleanValue()));
    L19:
        r109 = null;
    L14:
        r107 = null;
        goto L15
    }
}
