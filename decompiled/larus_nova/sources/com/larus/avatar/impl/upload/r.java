package com.larus.avatar.impl.upload;

import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.trace.tracknode.TraceFragment;
import kotlin.jvm.internal.Intrinsics;
import tx9.r0;

/* JADX INFO: loaded from: classes23.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TraceFragment f291313a;

    public r(TraceFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f291313a = r100;
    }

    public static void a(String r100, String r101, String r102, long r103, String r110) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r102, "reason");
        if (r101 != null) goto L5;
        r101 = "null";
    L5:
        r0.e(r100, r102, r101, r103, r110);
    }
}
