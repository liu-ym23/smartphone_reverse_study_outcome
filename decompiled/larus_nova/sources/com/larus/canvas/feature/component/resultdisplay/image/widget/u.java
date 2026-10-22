package com.larus.canvas.feature.component.resultdisplay.image.widget;

import androidx.viewpager2.widget.ViewPager2;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes26.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateFlowImpl f323668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StateFlowImpl f323669b;

    public u(ViewPager2 r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        StateFlowImpl r101 = j1.a(TuplesKt.to(0, 0));
        this.f323668a = r101;
        this.f323669b = r101;
        r100.addOnLayoutChangeListener(new t(this));
    }
}
