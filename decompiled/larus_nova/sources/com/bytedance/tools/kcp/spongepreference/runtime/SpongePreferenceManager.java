package com.bytedance.tools.kcp.spongepreference.runtime;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class SpongePreferenceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f271010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<Unit> f271011b = null;

    static {
        f271010a = b.f271012a;
        f271011b = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, SpongePreferenceManager$reflectiveInit$1.INSTANCE);
    }

    @JvmStatic
    public static final b a() {
        if ((!Intrinsics.areEqual(f271010a, b.f271012a)) == true) goto L10;
        Lazy<Unit> r100 = f271011b;
        if (r100.isInitialized() == true) goto L10;
        r100.getValue();
        return f271010a;
    L10:
        return f271010a;
    }
}
