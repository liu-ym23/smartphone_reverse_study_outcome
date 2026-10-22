package eba;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes32.dex */
public final class a extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jba.c f471915a;

    public a(jba.c r100) {
        Intrinsics.checkNotNullParameter(r100, "cornerRadii");
        this.f471915a = r100;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r110, "outline");
        if (r100.getWidth() > 0) goto L5;
        return;
    L5:
        if (r100.getHeight() > 0) goto L7;
        return;
    L7:
        if (this.f471915a.a() == false) goto L13;
        float r101 = Math.min(r100.getWidth(), r100.getHeight()) / 2.0f;
        jba.c r102 = this.f471915a;
        r110.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), RangesKt.coerceAtMost(r101, ComparisonsKt.maxOf(r102.f498046a, new float[]{r102.f498047b, r102.f498048c, r102.f498049d, 0.0f})));
        return;
    }
}
