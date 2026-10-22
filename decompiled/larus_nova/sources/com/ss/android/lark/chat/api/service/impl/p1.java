package com.ss.android.lark.chat.api.service.impl;

import android.text.TextUtils;
import com.byted.cast.common.sink.ISendResultListener;
import com.bytedance.lark.pb.basic.v1.Chat;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.QuasiMessage;
import com.bytedance.lark.pb.basic.v1.QuasiThread;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.bytedance.lark.pb.im.v1.ChannelDataType;
import com.bytedance.lark.pb.im.v1.GetChannelThreadsResponse;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.ModelParserMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
public final class p1 implements Function1<GetChannelThreadsResponse, l5b.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f411624a;

    @Override // kotlin.jvm.functions.Function1
    public final l5b.b invoke(GetChannelThreadsResponse r210) {
        p1 r100 = this;
        GetChannelThreadsResponse r101 = r210;
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        l5b.b r105 = new l5b.b(r102, r103, r104, new ArrayList());
        System.currentTimeMillis();
        long r106 = System.currentTimeMillis();
        r101.new_reply_count.intValue();
        r101.new_at_reply_count.intValue();
        System.currentTimeMillis();
        r101.show_expired_period.intValue();
        if (CollectionUtils.isNotEmpty(r101.invalid_positions) == false) goto L6;
        r103.addAll(r101.invalid_positions);
        Collections.sort(r103);
    L6:
        if (CollectionUtils.isNotEmpty(r101.missing_positions) == false) goto L8;
        r104.addAll(r101.missing_positions);
        Collections.sort(r104);
    L8:
        Entity r107 = r101.entity;
        if (r107 == null) goto L87;
        com.ss.android.lark.chat.entity.chatter.a r108 = com.ss.android.lark.parser.internal.b.d(r107, true);
        Map<String, Message> r109 = ModelParserMessage.h(r107);
        r105.f507585d = q1.d(r107, r108, r109, r101.new_at_reply_ids);
        Map<String, com.bytedance.lark.pb.basic.v1.Message> r110 = r107.messages;
        Map<String, Thread> r111 = r107.threads;
        Map<String, QuasiThread> r112 = r107.quasi_threads;
        Map<String, Chat> r113 = r107.chats;
        Iterator<GetChannelThreadsResponse.ThreadItem> r114 = r101.thread_items.iterator();
    L13:
        if (r114.hasNext() == false) goto L86;
        GetChannelThreadsResponse.ThreadItem r115 = r114.next();
        String r116 = r115.item_id;
        ChannelDataType r117 = r115.item_type;
        ChannelDataType r118 = ChannelDataType.NORMAL_DATA;
        Iterator<GetChannelThreadsResponse.ThreadItem> r119 = r114;
        String r120 = ISendResultListener.ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_MESSAGE_NULL;
        long r121 = r106;
        if (r117 != r118) goto L52;
        LinkedHashMap r122 = (LinkedHashMap) r109;
        Message r123 = (Message) r122.get(r116);
        Map<String, Thread> r211 = r111;
        ThreadTopic r124 = com.ss.android.lark.parser.internal.b0.a(r111.get(r116));
        if (r123 == null) goto L47;
        if (r124 == null) goto L47;
        String r125 = r123.getChatId();
        ChatChatter r126 = r108.b(r125, r123.getFromId());
        if (r126 != null) goto L23;
        Log.e("ThreadService", "parse thread failed id is:" + r116 + ", chatter is:" + r126);
    L48:
        n5b.a r127 = null;
    L49:
        if (r127 == null) goto L83;
        r105.f507582a.add(r127);
    L83:
        p1 r128 = this;
        Map<String, QuasiThread> r129 = r112;
    L84:
        Map<String, Chat> r130 = r113;
    L85:
        r100 = r128;
        r112 = r129;
        r113 = r130;
        r114 = r119;
        r106 = r121;
        r111 = r211;
        r110 = r110;
        goto L13
    L23:
        r112 = r112;
        n5b.a r131 = new n5b.a(r126, r124, r123);
        r113 = r113;
        r131.f518087l = com.ss.android.lark.parser.internal.h.a(r113.get(r123.getChatId()), null);
        r131.f518084i = com.ss.android.lark.parser.internal.a.g(r123, r108);
        com.bytedance.lark.pb.basic.v1.Message r132 = r110.get(r116);
        if (r132 == null) goto L30;
        r131.f518079d = com.ss.android.lark.parser.internal.a.e(r108, r125, com.ss.android.lark.parser.internal.x.b(r132.reactions));
        r131.f518082g = com.ss.android.lark.parser.internal.a.h(r132.pin, r125, r108);
        com.ss.android.lark.parser.internal.a.m(r132, r131, r108);
        String r133 = r123.getRecallerId();
        if (TextUtils.isEmpty(r133) == true) goto L28;
        r131.f518090o = r108.b(r125, r133);
    L28:
        r131.f518083h = com.ss.android.lark.parser.internal.d0.e(r123, r107, true);
    L30:
        if (CollectionUtils.isNotEmpty(r124.getLastReplyIds()) == false) goto L42;
        ArrayList r134 = new ArrayList();
        Iterator<String> r135 = r124.getLastReplyIds().iterator();
    L33:
        if (r135.hasNext() == false) goto L41;
        Message r136 = (Message) r122.get(r135.next());
        if (r136 == null) goto L36;
        ChatChatter r137 = r108.b(r125, r136.getFromId());
        if (r137 == null) goto L39;
        String r138 = r125;
        MessageInfo r139 = new MessageInfo(r136, r137);
        r139.setTranslateInfo(com.ss.android.lark.parser.internal.d0.e(r136, r107, true));
        r139.setOriginalSender(com.ss.android.lark.parser.internal.a.g(r136, r108));
        r134.add(r139);
        r110 = r110;
        r125 = r138;
        goto L33
    L39:
        Log.e("ThreadService", "message sender is null");
        goto L33
    L36:
        Log.e("ThreadService", ISendResultListener.ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_MESSAGE_NULL);
        goto L33
    L41:
        r110 = r110;
        r131.f518080e = r134;
    L43:
        List<MessageInfo> r140 = q1.a(r107, r124, r108, r109);
        if (CollectionUtils.isEmpty(r140) == true) goto L46;
        r131.f518081f = r140;
    L46:
        r127 = r131;
        goto L49
    L42:
        r110 = r110;
    L47:
        Log.e("ThreadService", "parse thread failed, id is:" + r116 + ", message is :" + r123 + ", thread is:" + r124);
        goto L48
    L52:
        r110 = r110;
        r211 = r111;
        r112 = r112;
        r113 = r113;
        if (r117 != ChannelDataType.QUASI_DATA) goto L83;
        QuasiMessage r141 = r107.quasi_messages.get(r116);
        r129 = r112;
        QuasiThread r142 = r129.get(r116);
        if (r142 != null) goto L57;
        ThreadTopic r143 = null;
    L58:
        if (r141 == null) goto L82;
        if (r143 == null) goto L82;
        Message r144 = ModelParserMessage.d(r107, r141);
        r128 = this;
        ChatChatter r145 = r108.b(r128.f411624a, r144.getFromId());
        if (r145 != null) goto L64;
        Log.e("ThreadService", "parse thread failed, chatter is null,  id is:" + r116);
        goto L84
    L64:
        n5b.a r146 = new n5b.a(r145, r143, r144);
        r130 = r113;
        r146.f518087l = com.ss.android.lark.parser.internal.h.a(r130.get(r128.f411624a), null);
        if (CollectionUtils.isNotEmpty(r143.getLastReplyIds()) == false) goto L78;
        ArrayList r147 = new ArrayList();
        Iterator<String> r148 = r143.getLastReplyIds().iterator();
    L68:
        if (r148.hasNext() == false) goto L77;
        Message r149 = (Message) ((LinkedHashMap) r109).get(r148.next());
        if (r149 == null) goto L71;
        String r150 = r120;
        ChatChatter r151 = r108.b(r128.f411624a, r149.getFromId());
        if (r151 != null) goto L75;
        Log.e("ThreadService", "message sender is null");
    L76:
        r120 = r150;
        goto L68
    L75:
        r147.add(new MessageInfo(r149, r151));
        goto L76
    L71:
        Log.e("ThreadService", r120);
        goto L68
    L77:
        r146.f518080e = r147;
    L78:
        List<MessageInfo> r152 = q1.a(r107, r143, r108, r109);
        if (CollectionUtils.isEmpty(r152) == true) goto L81;
        r146.f518081f = r152;
    L81:
        r105.f507582a.add(r146);
    L82:
        r128 = this;
        r130 = r113;
        Log.e("ThreadService", "parse thread failed, id is:" + r116);
        goto L85
    L57:
        r143 = new ThreadTopic();
        r143.setId(r142.f253539id);
        r143.setChannel(new Channel(r142.channel.type.getValue(), r142.channel.f253443id));
        r143.setTopic(r142.topic);
        r143.setPosition(r142.position.intValue());
        goto L58
    L86:
        Collections.sort(r105.f507582a, new o1());
        StringBuilder r153 = new StringBuilder("parse cost:");
        r153.append(System.currentTimeMillis() - r106);
        Log.d("ThreadWindow", r153.toString());
    L87:
        return r105;
    }

    public p1(long r100, String r101) {
        this.f411624a = r101;
    }
}
