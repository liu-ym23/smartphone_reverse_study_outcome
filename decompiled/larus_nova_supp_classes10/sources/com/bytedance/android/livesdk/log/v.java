package com.bytedance.android.livesdk.log;

import com.bytedance.android.livesdk.log.filter.u0;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v implements h {
    public final Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> a;
    public final Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> b;
    public final Map<Object, com.bytedance.android.livesdk.log.filter.v> c;

    public static Map a() {
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        r0.putAll(bm2.a.b());
        r0.putAll(bm2.a.b);
        r0.putAll(bm2.a.a);
        r0.putAll(bm2.a.a());
        return r0;
    }

    @Override // com.bytedance.android.livesdk.log.h
    public final Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> getFakeTempMap() {
        if (LiveInitAssistant.INSTANCE.getInitConfigInner().isLiveInitArcOpt() == false) goto L7;
        return this.b;
    L7:
        return new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.livesdk.log.h
    public final void initConfig() {
        if (LiveInitAssistant.INSTANCE.getInitConfigInner().isLiveInitArcOpt() == true) goto L5;
        Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> r0 = this.a;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        r1.putAll(a());
    L9:
        addSendLogFilter(u0.class, new u0());
        return;
    L5:
        if (((ConcurrentHashMap) this.b).isEmpty() == true) goto L7;
        Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> r2 = this.a;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        r3.putAll(this.b);
        goto L9
    L7:
        Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> r4 = this.a;
        ConcurrentHashMap r5 = (ConcurrentHashMap) r4;
        r5.putAll(a());
        goto L9
    }

    public v() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.livesdk.log.h
    public final Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> getMap() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.log.h
    public final Map<Object, com.bytedance.android.livesdk.log.filter.v> getSendLogFilter() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.log.h
    public final com.bytedance.android.livesdk.log.filter.v removeSendLogFilter(Object r2) {
        com.bytedance.android.livesdk.log.filter.v r3 = (com.bytedance.android.livesdk.log.filter.v) ((ConcurrentHashMap) this.c).remove(r2);
        if (r3 == null) goto L5;
        r3.onRemove();
    L5:
        return r3;
    }

    @Override // com.bytedance.android.livesdk.log.h
    public final <T> void unregister(Class<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        ((ConcurrentHashMap) this.a).remove(r2);
    }

    @Override // com.bytedance.android.livesdk.log.h
    public final boolean addSendLogFilter(Object r2, com.bytedance.android.livesdk.log.filter.v r3) {
        Intrinsics.checkNotNullParameter(r3, "filter");
        if (((ConcurrentHashMap) this.c).containsKey(r2) == false) goto L5;
        return false;
    L5:
        ((ConcurrentHashMap) this.c).put(r2, r3);
        r3.Rd();
        return true;
    }

    @Override // com.bytedance.android.livesdk.log.h
    public final <T> void register(Class<? extends T> r2, com.bytedance.android.livesdk.log.filter.o<? extends T> r3) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r3, "filter");
        ((ConcurrentHashMap) this.a).put(r2, r3);
    }
}
