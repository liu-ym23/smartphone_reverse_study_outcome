package com.bytedance.kmp.ec.yata.view.render.controller.common;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f251846a = 0;

    static {
    }

    public static boolean a(c r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "oldItem");
        Intrinsics.checkNotNullParameter(r101, "newItem");
        return Intrinsics.areEqual(r100.c().d(), r101.c().d());
    }
}
