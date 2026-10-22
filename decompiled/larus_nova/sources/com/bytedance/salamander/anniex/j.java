package com.bytedance.salamander.anniex;

import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.anniex.bd.foundation.impl.m f268132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.anniex.bd.foundation.impl.m f268133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.anniex.bd.foundation.impl.m f268134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.anniex.bd.foundation.impl.m f268135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f268136e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f268137f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f268138g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f268139h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PadAdapterStyle f268140i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f268141j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f268142k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Boolean f268143l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.anniex.bd.foundation.impl.m f268144m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.anniex.bd.foundation.impl.m f268145n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AnnieXStatusFontMode f268146o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Boolean f268147p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f268148q;

    public final g a() {
        if (this.f268132a == null) goto L5;
    L10:
        g r100 = new g();
        com.bytedance.anniex.bd.foundation.impl.m r101 = this.f268133b;
        if (r101 == null) goto L13;
        r100.f268074b = r101;
    L13:
        com.bytedance.anniex.bd.foundation.impl.m r102 = this.f268134c;
        if (r102 == null) goto L16;
        r100.f268075c = r102;
    L16:
        com.bytedance.anniex.bd.foundation.impl.m r103 = this.f268132a;
        if (r103 == null) goto L19;
        r100.f268073a = r103;
    L19:
        return r100;
    L5:
        if (this.f268133b != null) goto L10;
        if (this.f268134c != null) goto L10;
        com.bytedance.anniex.bd.foundation.impl.m r104 = g.f268070d;
        return g.a.a();
    }

    public boolean b() {
        Boolean r100 = this.f268143l;
        if (r100 != null) goto L10;
        r100 = this.f268147p;
        if (r100 != null) goto L10;
        return false;
    L10:
        return r100.booleanValue();
    }

    public j() {
        this.f268136e = true;
        this.f268137f = true;
        this.f268140i = PadAdapterStyle.NONE;
        this.f268141j = -1;
        this.f268146o = AnnieXStatusFontMode.DEFAULT;
    }

    public final void c(String r100) {
        PadAdapterStyle r101 = PadAdapterStyle.CHANNEL_STYLE;
        if (Intrinsics.areEqual(r100, r101.getValue()) == false) goto L5;
        this.f268140i = r101;
        return;
    L5:
        PadAdapterStyle r102 = PadAdapterStyle.UNIFORM_STYLE;
        if (Intrinsics.areEqual(r100, r102.getValue()) == false) goto L9;
        this.f268140i = r102;
        return;
    L9:
        if (Intrinsics.areEqual(r100, PadAdapterStyle.WIDTH_PERCENT.getValue()) == false) goto L14;
        this.f268140i = r102;
        return;
    }

    public final void d(String r110) {
        if (Intrinsics.areEqual(r110, "dark") == false) goto L6;
        this.f268146o = AnnieXStatusFontMode.DARK;
        return;
    L6:
        if (Intrinsics.areEqual(r110, "light") == false) goto L8;
        this.f268146o = AnnieXStatusFontMode.LIGHT;
        return;
    L8:
        g r100 = new g();
        com.bytedance.anniex.bd.foundation.impl.m r101 = this.f268144m;
        if (r101 != null) goto L13;
        r101 = this.f268145n;
        if (r101 != null) goto L13;
        r101 = r100.b(null);
    L13:
        Intrinsics.checkNotNullParameter(r101, "color");
        int r102 = r101.f190146a;
        int r103 = r101.f190147b;
        int r104 = r101.f190148c;
        IntCompanionObject r105 = IntCompanionObject.INSTANCE;
        double r106 = 255;
        double r107 = com.bytedance.rts.foundation.k.b(r105, r102) / r106;
        double r108 = com.bytedance.rts.foundation.k.b(r105, r103) / r106;
        double r109 = com.bytedance.rts.foundation.k.b(r105, r104) / r106;
        if (r107 > 0.03928d) goto L16;
        double r111 = r107 / 12.92d;
    L18:
        if (r108 > 0.03928d) goto L20;
        double r112 = r108 / 12.92d;
    L22:
        if (r109 > 0.03928d) goto L24;
        double r113 = r109 / 12.92d;
    L26:
        if ((((r111 * 0.2126d) + (r112 * 0.7152d)) + (r113 * 0.0722d)) <= 0.5d) goto L28;
        boolean r114 = true;
    L29:
        if (r114 == false) goto L31;
        AnnieXStatusFontMode r115 = AnnieXStatusFontMode.DARK;
    L32:
        this.f268146o = r115;
        return;
    L31:
        r115 = AnnieXStatusFontMode.LIGHT;
        goto L32
    L28:
        r114 = false;
        goto L29
    L24:
        int r116 = com.bytedance.rts.foundation.h.f267580a;
        r113 = Math.pow((r109 + 0.055d) / 1.055d, 2.4d);
        goto L26
    L20:
        int r117 = com.bytedance.rts.foundation.h.f267580a;
        r112 = Math.pow((r108 + 0.055d) / 1.055d, 2.4d);
        goto L22
    L16:
        int r118 = com.bytedance.rts.foundation.h.f267580a;
        r111 = Math.pow((r107 + 0.055d) / 1.055d, 2.4d);
        goto L18
    }
}
