package com.bytedance.dux.common;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class DuxConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<PadAdaptScene, Boolean> f204897a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<Boolean> f204898b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<Boolean> f204899c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<Boolean> f204900d = null;

    static {
        f204897a = MapsKt.emptyMap();
        f204898b = LazyKt.lazy(DuxConfig$sDebugModePrivate$1.INSTANCE);
        f204899c = LazyKt.lazy(DuxConfig$sPrivateLTR$1.INSTANCE);
        f204900d = LazyKt.lazy(DuxConfig$sIsCloseDoubleColorBallStartAfterOnAttachFlag$1.INSTANCE);
    }

    public static boolean a(PadAdaptScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Boolean r101 = f204897a.get(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.booleanValue();
    }
}
