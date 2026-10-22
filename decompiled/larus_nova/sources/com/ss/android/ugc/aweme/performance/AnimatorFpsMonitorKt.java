package com.ss.android.ugc.aweme.performance;

import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"lib-runtime_release"}, k = 2, mv = {1, 4, 1})
public final class AnimatorFpsMonitorKt {
    public static final void a(final ValueAnimator r110, final String r111, final boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "$this$monitorFps");
        Intrinsics.checkNotNullParameter(r111, "scene");
        final Ref.IntRef r100 = new Ref.IntRef();
        r100.element = 0;
        final Ref.LongRef r101 = new Ref.LongRef();
        r101.element = -1;
        final Ref.LongRef r102 = new Ref.LongRef();
        r102.element = -1;
        r110.addListener(new AnimatorFpsMonitorKt$monitorFps$1(r110, r100, r101, r102, r111, r112));
        r110.addUpdateListener(new AnimatorFpsMonitorKt$monitorFps$2(r102, r100));
    }
}
