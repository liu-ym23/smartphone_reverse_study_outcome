package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class i implements m6b.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Object, m6b.c> f416508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a2 f416509b;

    public class a implements a2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IChatService f416510a;

        public a(IChatService r100) {
            this.f416510a = r100;
        }
    }

    @Inject
    public i(IChatService r100) {
        this.f416508a = new ConcurrentHashMap(16);
        this.f416509b = new a2(new a(r100));
    }

    @Override // m6b.d
    public final void K6(String r100, SubscribeChatEventRequest.SubscriptionKey r101) {
        a2 r102 = this.f416509b;
        r102.getClass();
        if (r100 == null) goto L21;
        Map<String, Integer> r103 = a2.f416449b;
        monitor-enter(r103);
        Integer r104 = (Integer) ((ConcurrentHashMap) r103).get(r100);     // Catch: Throwable -> L16
        if (r104 != null) goto L10;
    L11:
        r104 = 0;     // Catch: Throwable -> L16
    L12:
        Integer r105 = Integer.valueOf(r104.intValue() + 1);     // Catch: Throwable -> L16
        Log.i("PushChatSubscribeCenter", "subscribe chatid: " + r100 + "  count: " + r105);     // Catch: Throwable -> L16
        ((ConcurrentHashMap) r103).put(r100, r105);     // Catch: Throwable -> L16
        monitor-exit(r103);     // Catch: Throwable -> L16
        r102.a(r101);
        return;
    L10:
        if (r104.intValue() > 0) goto L12;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // m6b.d
    public final void V(Object r100, String r101) {
        m6b.c r102 = (m6b.c) ((ConcurrentHashMap) this.f416508a).remove(r100);
        if (r102 != null) goto L5;
        Log.w("ChatSubscribeService", "subscriber unregister is empty，key: " + r100);
        return;
    L5:
        r102.b(r101);
    }

    @Override // m6b.d
    public final void z9(String r100, SubscribeChatEventRequest.SubscriptionKey r101) {
        a2 r102 = this.f416509b;
        r102.getClass();
        if (r100 == null) goto L22;
        Map<String, Integer> r103 = a2.f416449b;
        monitor-enter(r103);
        Integer r104 = (Integer) ((ConcurrentHashMap) r103).get(r100);     // Catch: Throwable -> L17
        if (r104 != null) goto L10;
        r104 = 0;     // Catch: Throwable -> L17
    L10:
        Integer r105 = Integer.valueOf(r104.intValue() - 1);     // Catch: Throwable -> L17
        if (r105.intValue() > 0) goto L13;
        r105 = 0;     // Catch: Throwable -> L17
    L13:
        Log.i("PushChatSubscribeCenter", "unSubscribe chatid: " + r100 + "  count: " + r105);     // Catch: Throwable -> L17
        ((ConcurrentHashMap) r103).put(r100, r105);     // Catch: Throwable -> L17
        monitor-exit(r103);     // Catch: Throwable -> L17
        r102.a(r101);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // m6b.d
    public final void W1(Object r100, String r101, aqb.a r102) {
        m6b.c r103 = (m6b.c) ((ConcurrentHashMap) this.f416508a).get(r100);
        if (r103 == null) goto L5;
    L14:
        r103.c(r101, r102);
        return;
    L5:
        monitor-enter(i.class);
        r103 = (m6b.c) ((ConcurrentHashMap) this.f416508a).get(r100);     // Catch: Throwable -> L11
        if (r103 != null) goto L9;
        r103 = new h(this);     // Catch: Throwable -> L11
        ((ConcurrentHashMap) this.f416508a).put(r100, r103);     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // m6b.d
    public final void unregisterPushChatRelation(Object r100, String r101, SubscribeChatEventRequest.SubscriptionKey r102) {
        m6b.c r103 = (m6b.c) ((ConcurrentHashMap) this.f416508a).remove(r100);
        if (r103 != null) goto L5;
        Log.w("ChatSubscribeService", "subscriber unregister is empty，key: " + r100);
        return;
    L5:
        r103.d(r101, r102);
    }

    @Override // m6b.d
    public final void registerPushChatRelation(Object r100, String r101, SubscribeChatEventRequest.SubscriptionKey r102, m6b.o r103) {
        m6b.c r104 = (m6b.c) ((ConcurrentHashMap) this.f416508a).get(r100);
        if (r104 == null) goto L5;
    L14:
        r104.a(r101, r102, r103);
        return;
    L5:
        monitor-enter(i.class);
        r104 = (m6b.c) ((ConcurrentHashMap) this.f416508a).get(r100);     // Catch: Throwable -> L11
        if (r104 != null) goto L9;
        r104 = new h(this);     // Catch: Throwable -> L11
        ((ConcurrentHashMap) this.f416508a).put(r100, r104);     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
