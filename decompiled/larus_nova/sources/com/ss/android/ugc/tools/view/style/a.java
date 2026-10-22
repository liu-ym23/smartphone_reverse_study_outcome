package com.ss.android.ugc.tools.view.style;

import android.graphics.drawable.GradientDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final float[] f454970i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f454971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f454972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f454973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f454974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f454975e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f454976f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Float f454977g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float[] f454978h;

    /* JADX INFO: renamed from: com.ss.android.ugc.tools.view.style.a$a, reason: collision with other inner class name */
    public static final class C5455a {
    }

    static {
        f454970i = new float[0];
    }

    public final GradientDrawable a() {
        GradientDrawable r100 = new GradientDrawable();
        Integer r101 = this.f454971a;
        if (r101 == null) goto L5;
        r100.setShape(r101.intValue());
    L5:
        Integer r102 = this.f454972b;
        if (r102 == null) goto L8;
        r100.setColor(r102.intValue());
    L8:
        Integer r103 = this.f454973c;
        if (r103 == null) goto L11;
        int r104 = r103.intValue();
        Integer r105 = this.f454974d;
        Intrinsics.checkNotNull(r105);
        r100.setStroke(r105.intValue(), r104);
    L11:
        Integer r106 = this.f454975e;
        if (r106 == null) goto L14;
        int r107 = r106.intValue();
        Integer r108 = this.f454976f;
        Intrinsics.checkNotNull(r108);
        r100.setSize(r107, r108.intValue());
    L14:
        Float r109 = this.f454977g;
        if (r109 == null) goto L17;
        r100.setCornerRadius(r109.floatValue());
    L17:
        float[] r110 = this.f454978h;
        if (r110 == f454970i) goto L20;
        r100.setCornerRadii(r110);
    L20:
        return r100;
    }

    public a() {
        this.f454978h = f454970i;
    }

    public final void b(int r100) {
        this.f454972b = Integer.valueOf(r100);
    }

    public final void c(int r100) {
        this.f454971a = Integer.valueOf(r100);
    }

    public final void d(int r100, int r101) {
        this.f454973c = Integer.valueOf(r100);
        this.f454974d = Integer.valueOf(r101);
    }
}
