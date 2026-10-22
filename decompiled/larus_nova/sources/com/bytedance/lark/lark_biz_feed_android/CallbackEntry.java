package com.bytedance.lark.lark_biz_feed_android;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/lark/lark_biz_feed_android/CallbackEntry;", "", "()V", "Companion", "lark_biz_feed_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CallbackEntry {
    public static final a Companion = null;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CallbackEntry() {
    }

    @JvmStatic
    public static final byte[] invoke(long r100, long r101, byte[] r102) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r102, "params");
        e r103 = e.f253155a;
        u0 r104 = r103.a(r100);
        if (r104 == null) goto L22;
        if (r101 != 0) goto L17;
        monitor-enter(r103);
        Map<Long, u0> r105 = e.f253157c;     // Catch: Throwable -> L14
        if (((u0) ((LinkedHashMap) r105).get(Long.valueOf(r100))) != null) goto L11;
        monitor-exit(r103);
    L25:
        return new byte[0];
    L11:
        u0 r106 = r105.remove(Long.valueOf(r100));     // Catch: Throwable -> L14
        monitor-exit(r103);
    L14:
        th = move-exception;
        throw th;
    L17:
        byte[] r107 = r104.onInvoke(r101, r102);
        if (r107 == null) goto L22;
        return r107;
    L22:
        throw new RuntimeException("No registered callback<InstanceId(" + r100 + ")>");
    }

    @JvmStatic
    public static final void invokeAsync(long r100, long r101, long r110, byte[] r111) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r111, "params");
        u0 r102 = e.f253155a.a(r101);
        if (r102 == null) goto L5;
        r102.onInvokeAsync(r100, r110, r111);
        Unit r103 = Unit.INSTANCE;
    L6:
        if (r103 == null) goto L9;
        return;
    L9:
        throw new RuntimeException("No registered callback<InstanceId(" + r101 + ")>");
    L5:
        r103 = null;
        goto L6
    }
}
