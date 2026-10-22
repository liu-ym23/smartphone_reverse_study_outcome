package com.obric.oui.material;

import com.alibaba.gaiax.render.view.GXViewKey;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f401450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.obric.oui.shadow.a[] f401451b;

    public final String toString() {
        return "BlurShadowConfig(blurRadius=" + this.f401450a + ", shadow=" + Arrays.toString(this.f401451b) + ')';
    }

    public final int hashCode() {
        return (int) ((31 * this.f401450a) + Arrays.hashCode(this.f401451b));
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
        Class<?> r101 = null;
    L10:
        if (Intrinsics.areEqual(a.class, r101) == true) goto L12;
        return false;
    L12:
        if (r100 == null) goto L24;
        a r102 = (a) r100;
        if (this.f401450a != r102.f401450a) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == true) goto L20;
        return false;
    L20:
        if (Arrays.equals(this.f401451b, r102.f401451b) == true) goto L22;
        return false;
    L22:
        return true;
    L16:
        r103 = false;
        goto L17
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.material.BlurShadowConfig");
    L8:
        r101 = r100.getClass();
        goto L10
    }

    public a(float r100, com.obric.oui.shadow.a[] r101) {
        Intrinsics.checkNotNullParameter(r101, GXViewKey.VIEW_TYPE_SHADOW_LAYOUT);
        this.f401450a = r100;
        this.f401451b = r101;
    }
}
