package com.ss.android.lark.forwardv3;

import com.bytedance.i18n.claymore.PluginServiceLoader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class ForwardModuleV3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static tib.g f425079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f425080b = null;

    static {
        f425080b = LazyKt.lazy(ForwardModuleV3$forwardImDependency$2.INSTANCE);
    }

    public static tib.g a() {
        if (f425079a != null) goto L6;
        f425079a = (tib.g) PluginServiceLoader.loadFirstOrNull(tib.g.class);
    L6:
        if (f425079a != null) goto L8;
        f425079a = new c();
    L8:
        tib.g r100 = f425079a;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.forwardv3.dependency.IForwardNewDependency");
        return r100;
    }
}
