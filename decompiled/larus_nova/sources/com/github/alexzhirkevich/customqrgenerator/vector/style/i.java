package com.github.alexzhirkevich.customqrgenerator.vector.style;

import android.graphics.drawable.Drawable;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f274296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f274297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f274298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f274299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.github.alexzhirkevich.customqrgenerator.style.a f274300e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f274301f;

    public i() {
        this(0);
    }

    public final int hashCode() {
        Drawable r100 = this.f274296a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((((((((r101 * 31) + Float.floatToIntBits(this.f274297b)) * 31) + this.f274298c.hashCode()) * 31) + this.f274299d.hashCode()) * 31) + this.f274300e.hashCode()) * 31) + this.f274301f.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "QrVectorLogo(drawable=" + this.f274296a + ", size=" + this.f274297b + ", padding=" + this.f274298c + ", shape=" + this.f274299d + ", scale=" + this.f274300e + ", backgroundColor=" + this.f274301f + ')';
    }

    public i(int r100) {
        j.a r101 = j.a.f274302a;
        k.a r102 = k.a.f274303b;
        com.github.alexzhirkevich.customqrgenerator.style.a.C3844a r103 = com.github.alexzhirkevich.customqrgenerator.style.a.C3844a.f274255a;
        e.c r104 = e.c.f274282b;
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.FLEXBOX_PADDING);
        Intrinsics.checkNotNullParameter(r102, "shape");
        Intrinsics.checkNotNullParameter(r103, "scale");
        Intrinsics.checkNotNullParameter(r104, "backgroundColor");
        this.f274296a = null;
        this.f274297b = 0.2f;
        this.f274298c = r101;
        this.f274299d = r102;
        this.f274300e = r103;
        this.f274301f = r104;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f274296a, r101.f274296a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(Float.valueOf(this.f274297b), Float.valueOf(r101.f274297b)) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f274298c, r101.f274298c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f274299d, r101.f274299d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f274300e, r101.f274300e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f274301f, r101.f274301f) == true) goto L26;
        return false;
    L26:
        return true;
    }
}
