package com.bytedance.lark.molten_livequery;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/lark/molten_livequery/CallbackEntry;", "", "<init>", "()V", "Companion", "molten_livequery_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        com.bytedance.lark.molten_livequery.a r103 = com.bytedance.lark.molten_livequery.a.f253323a;
        i r104 = r103.a(r100);
        if (r104 == null) goto L22;
        if (r101 != 0) goto L17;
        monitor-enter(r103);
        Map<Long, i> r105 = com.bytedance.lark.molten_livequery.a.f253325c;     // Catch: Throwable -> L14
        if (((i) ((LinkedHashMap) r105).get(Long.valueOf(r100))) != null) goto L11;
        monitor-exit(r103);
    L25:
        return new byte[0];
    L11:
        i r106 = r105.remove(Long.valueOf(r100));     // Catch: Throwable -> L14
        monitor-exit(r103);
    L14:
        th = move-exception;
        throw th;
    L17:
        byte[] r107 = r104.b(r102);
        if (r107 == null) goto L22;
        return r107;
    L22:
        throw new RuntimeException("No registered callback<InstanceId(" + r100 + ")>");
    }

    @JvmStatic
    public static final void invokeAsync(long r100, long r101, long r102, byte[] r103) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r103, "params");
        i r104 = com.bytedance.lark.molten_livequery.a.f253323a.a(r101);
        if (r104 == null) goto L7;
        r104.a(r103);
        return;
    L7:
        throw new RuntimeException("No registered callback<InstanceId(" + r101 + ")>");
    }
}
