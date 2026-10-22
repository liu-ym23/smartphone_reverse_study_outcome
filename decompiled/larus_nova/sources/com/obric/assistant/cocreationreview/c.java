package com.obric.assistant.cocreationreview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f387211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CardTemplateTagTone f387212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f387213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f387214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<Context, Drawable> f387215e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f387216f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f387217g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Unit> f387218h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f387211a, r101.f387211a) == true) goto L12;
        return false;
    L12:
        if (this.f387212b == r101.f387212b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f387213c, r101.f387213c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f387214d, r101.f387214d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f387215e, r101.f387215e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f387216f, r101.f387216f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f387217g, r101.f387217g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f387218h, r101.f387218h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f387211a.hashCode() * 31) + this.f387212b.hashCode()) * 31;
        Integer r101 = this.f387213c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f387214d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Function1<Context, Drawable> r108 = this.f387215e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f387216f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f387217g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Function0<Unit> r117 = this.f387218h;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CardTemplateFootTag(text=" + this.f387211a + ", tone=" + this.f387212b + ", accentColor=" + this.f387213c + ", iconRes=" + this.f387214d + ", iconDrawableProvider=" + this.f387215e + ", maxWidthDp=" + this.f387216f + ", detailAnchor=" + this.f387217g + ", onClick=" + this.f387218h + ')';
    }

    public /* synthetic */ c(String r110, CardTemplateTagTone r111, Integer r112, hda.t0 r113, Integer r114, String r115, ida.h r116, int r117) {
        if ((r117 & 2) == 0) goto L5;
        CardTemplateTagTone r100 = CardTemplateTagTone.METRIC;
    L7:
        if ((r117 & 8) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r117 & 16) == 0) goto L13;
        hda.t0 r102 = null;
    L15:
        if ((r117 & 32) == 0) goto L17;
        Integer r103 = null;
    L19:
        if ((r117 & 64) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r117 & 128) == 0) goto L25;
        ida.h r118 = null;
    L26:
        this(r110, r100, null, r101, r102, r103, r104, r118);
        return;
    L25:
        r118 = r116;
        goto L26
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(String r100, CardTemplateTagTone r101, Integer r102, Integer r103, Function1<? super Context, ? extends Drawable> r104, Integer r105, String r106, Function0<Unit> r107) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "tone");
        this.f387211a = r100;
        this.f387212b = r101;
        this.f387213c = r102;
        this.f387214d = r103;
        this.f387215e = r104;
        this.f387216f = r105;
        this.f387217g = r106;
        this.f387218h = r107;
    }
}
