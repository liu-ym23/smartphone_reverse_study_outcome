package com.ss.android.lark.chat.api.service.impl;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.Message;
import com.bytedance.lark.pb.im.v1.GetThreadMessagesByPositionsResponse;
import com.larksuite.framework.utils.CollectionUtils;
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
public final class s1 implements Function1<GetThreadMessagesByPositionsResponse, l5b.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f411640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f411641b;

    @Override // kotlin.jvm.functions.Function1
    public final l5b.a invoke(GetThreadMessagesByPositionsResponse r110) {
        GetThreadMessagesByPositionsResponse r111 = r110;
        l5b.a r100 = new l5b.a();
        Entity r101 = r111.entity;
        if (r101 == null) goto L23;
        Map<String, Message> r102 = r101.messages;
        if (CollectionUtils.isEmpty(r102) == true) goto L23;
        Map<String, com.ss.android.lark.chat.entity.message.Message> r103 = ModelParserMessage.h(r101);
        com.ss.android.lark.chat.entity.chatter.a r104 = com.ss.android.lark.parser.internal.b.d(r101, true);
        ArrayList r105 = new ArrayList();
        Iterator r106 = ((LinkedHashMap) r103).entrySet().iterator();
    L10:
        if (r106.hasNext() == false) goto L20;
        Map.Entry r107 = (Map.Entry) r106.next();
        String r108 = (String) r107.getKey();
        com.ss.android.lark.chat.entity.message.Message r109 = (com.ss.android.lark.chat.entity.message.Message) r107.getValue();
        if (this.f411640a.contains(Integer.valueOf(r109.getThreadPosition())) == false) goto L10;
        if (r109.getThreadId() == null) goto L19;
        if (TextUtils.equals(r109.getThreadId(), this.f411641b) == true) goto L19;
        Log.i("ThreadService", "ThreadService::GetThreadMessagesByPositionsRequest skip message id: " + r109.getId() + " position: " + r109.getPosition() + " chatId: " + r109.getChatId() + " threadId: " + r109.getThreadId());
    L19:
        r105.add(com.ss.android.lark.parser.internal.a.k(r109, r102.get(r108), r101, r104, null));
        goto L10
    L20:
        Collections.sort(r105, new r1());
        r100.f507575a.addAll(r105);
        if (CollectionUtils.isNotEmpty(r111.invalid_positions) == false) goto L23;
        r100.f507577c.addAll(r111.invalid_positions);
    L23:
        return r100;
    }

    public s1(List r100, String r101) {
        this.f411640a = r100;
        this.f411641b = r101;
    }
}
