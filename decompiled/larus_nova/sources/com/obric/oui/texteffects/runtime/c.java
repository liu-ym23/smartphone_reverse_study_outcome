package com.obric.oui.texteffects.runtime;

import android.content.res.Resources;
import android.view.View;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f403317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f403318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Float> f403319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f403320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f403321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f403322f;

    public static final class a {
    }

    static {
    }

    public c() {
        throw null;
    }

    public final float a(qma.d r100, float r101) {
        if ((r100 instanceof qma.d.b) == false) goto L6;
        return ((qma.d.b) r100).f533947a;
    L6:
        if ((r100 instanceof qma.d.a) == false) goto L10;
        float r102 = ((qma.d.a) r100).f533946a;
        float r103 = this.f403322f;
    L49:
        return r102 * r103;
    L10:
        if ((r100 instanceof qma.d.e) == false) goto L13;
        float r104 = ((qma.d.e) r100).f533952a;
        float r105 = this.f403322f;
    L50:
        return (r104 * r105) + r101;
    L13:
        if ((r100 instanceof qma.d.C7363d) == false) goto L40;
        Integer r106 = Integer.valueOf(this.f403318b.getMeasuredWidth());
        int r107 = r106.intValue();
        Integer r108 = Integer.valueOf(this.f403318b.getWidth());
        boolean r109 = true;
        if (r108.intValue() <= 0) goto L17;
        boolean r110 = true;
    L19:
        if (r110 == true) goto L22;
        r108 = null;
    L22:
        if (r108 != null) goto L24;
        int r111 = 0;
    L25:
        if (r107 > r111) goto L28;
        r109 = false;
    L28:
        if (r109 == true) goto L31;
        r106 = null;
    L31:
        if (r106 != null) goto L33;
        int r112 = this.f403318b.getWidth();
    L34:
        if (r112 <= 0) goto L36;
        float r113 = r112;
    L37:
        r101 = -r113;
        r104 = ((qma.d.C7363d) r100).f533951a;
        r105 = this.f403322f;
        goto L50
    L36:
        float r114 = this.f403321e;
        Resources r115 = this.f403318b.getResources();
        r113 = r114 * WindowDisplayMetricsOverride.apply(r115, r115.getDisplayMetrics()).density;
        goto L37
    L33:
        r112 = r106.intValue();
        goto L34
    L24:
        r111 = r108.intValue();
        goto L25
    L17:
        r110 = false;
        goto L19
    L40:
        if ((r100 instanceof qma.d.f) == false) goto L43;
        r103 = RangesKt.coerceAtLeast(this.f403319c.invoke().floatValue(), 0.0f);
        r102 = ((qma.d.f) r100).f533953a;
        goto L49
    L43:
        if ((r100 instanceof qma.d.c) == false) goto L47;
        qma.d.c r116 = (qma.d.c) r100;
        float r117 = a(r116.f533948a, r101);
        return r117 + ((a(r116.f533949b, r101) - r117) * RangesKt.coerceIn(r116.f533950c, 0.0f, 1.0f));
    L47:
        throw new NoWhenBranchMatchedException();
    }

    public c(String r100, View r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "bindingKey");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "textWidthProvider");
        this.f403317a = r100;
        this.f403318b = r101;
        this.f403319c = r102;
        this.f403320d = 4;
        this.f403321e = 248.0f;
        Resources r103 = r101.getResources();
        this.f403322f = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density;
    }
}
