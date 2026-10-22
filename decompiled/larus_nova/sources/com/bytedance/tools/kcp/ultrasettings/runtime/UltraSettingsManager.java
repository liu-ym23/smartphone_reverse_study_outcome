package com.bytedance.tools.kcp.ultrasettings.runtime;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class UltraSettingsManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, c> f271014a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f271015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<Unit> f271016c = null;

    static {
        f271014a = new ConcurrentHashMap();
        f271015b = b.f271021a;
        f271016c = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, UltraSettingsManager$reflectiveInit$1.INSTANCE);
    }

    public static b a() {
        if ((!Intrinsics.areEqual(f271015b, b.f271021a)) == true) goto L10;
        Lazy<Unit> r100 = f271016c;
        if (r100.isInitialized() == true) goto L10;
        r100.getValue();
        return f271015b;
    L10:
        return f271015b;
    }

    public static void b(String r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        f271014a.put(r100, r101);
    }
}
