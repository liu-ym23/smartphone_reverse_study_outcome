package com.bytedance.live.livelink.kmp.impl.extend;

import com.bytedance.live.livelink.kmp.api.base.event.EventCategory;
import gi6.e;
import gi6.h;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static final Disposable a(final b r100, EventCategory r101, h r102, Function1 r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$subscribeEvent");
        Intrinsics.checkNotNullParameter(r101, "eventCategory");
        Intrinsics.checkNotNullParameter(r103, "onEvent");
        e r104 = r100.c().f255521j;
        if (r104 == null) goto L6;
        final String r105 = r104.a(r101, r102, r103);
        if (r105 == null) goto L6;
    L7:
        int r106 = com.bytedance.revenue.platform.api.core.rx.h.f267513a;
        return com.bytedance.revenue.platform.api.core.rx.h.a(new EventManagerExtendKt$subscribeEvent$1(r100, r105));
    L6:
        r105 = "";
        goto L7
    }
}
