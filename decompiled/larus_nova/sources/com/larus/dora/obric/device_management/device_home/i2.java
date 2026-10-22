package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f339267a = 0;

    static {
    }

    public static h2 a(DoraObricEnvironmentMemoryClickAction r100, DoraObricEnvironmentMemoryState r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "requestedAction");
        Intrinsics.checkNotNullParameter(r101, "latestState");
        if (r100 == DoraObricEnvironmentMemoryClickAction.ENABLE_SWITCH_WITH_OVERRIDE) goto L5;
    L8:
        boolean r103 = false;
    L10:
        if (r103 == false) goto L12;
        DoraObricEnvironmentMemoryToastType r104 = DoraObricEnvironmentMemoryToastType.TEMPORARY_OVERRIDE;
    L14:
        return new h2(r103, r104);
    L12:
        r104 = DoraObricEnvironmentMemoryToastType.ENABLED;
        goto L14
    L5:
        if (r101 != DoraObricEnvironmentMemoryState.OFF) goto L8;
        if (r102 == true) goto L8;
        r103 = true;
        goto L10
    }
}
