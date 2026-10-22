package com.larus.gallery.api;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.facebook.drawee.drawable.ScalingUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f343817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f343818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DisplayGravity f343819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScalingUtils.ScaleType f343820d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f343817a == r101.f343817a) goto L12;
        return false;
    L12:
        if (this.f343818b == r101.f343818b) goto L15;
        return false;
    L15:
        if (this.f343819c == r101.f343819c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f343820d, r101.f343820d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f343817a * 31) + this.f343818b) * 31) + this.f343819c.hashCode()) * 31) + this.f343820d.hashCode();
    }

    public final String toString() {
        return "DisplayAreaConfig(width=" + this.f343817a + ", height=" + this.f343818b + ", gravity=" + this.f343819c + ", scaleType=" + this.f343820d + ')';
    }

    public a(int r100, int r101, DisplayGravity r102, com.larus.gallery.adapter.ui.i r103) {
        Intrinsics.checkNotNullParameter(r102, GXTemplateKey.GAIAX_LAYER_GRAVITY);
        Intrinsics.checkNotNullParameter(r103, "scaleType");
        this.f343817a = r100;
        this.f343818b = r101;
        this.f343819c = r102;
        this.f343820d = r103;
    }
}
