package com.obric.memorydata.sdk.screencapture;

import com.bytedance.ugc.glue.monitor.UGCMonitor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Function0<Unit>, Unit> f397220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<ScreenData, Unit> f397221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f397222c;

    public b(h r100, Function1 r101, i r102) {
        Intrinsics.checkNotNullParameter(r100, UGCMonitor.TYPE_POST);
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "onComplete");
        this.f397220a = r100;
        this.f397221b = r101;
        this.f397222c = r102;
    }
}
