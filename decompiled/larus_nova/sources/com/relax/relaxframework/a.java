package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Object[]> f404996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b2> f404997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<r1> f404998c;

    public final b a() {
        ArrayList<Object[]> r100 = this.f404996a;
        ArrayList<r1> r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("numInterpolations");
        r100 = null;
    L5:
        ArrayList<b2> r102 = this.f404997b;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("transformValues");
        r102 = null;
    L8:
        ArrayList<r1> r103 = this.f404998c;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("filterValues");
    L13:
        return new b(r100, r102, r101);
    L11:
        r101 = r103;
        goto L13
    }

    public a() {
        this.f404996a = com.bytedance.rts.foundation.j.k(new Object[0][]);
        this.f404997b = com.bytedance.rts.foundation.j.k(new b2[0]);
        this.f404998c = com.bytedance.rts.foundation.j.k(new r1[0]);
    }

    public final void b(double r100) {
        ArrayList<Object[]> r101 = this.f404996a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("numInterpolations");
        r101 = null;
    L5:
        com.bytedance.rts.foundation.j.j(r101, new Object[]{Integer.valueOf(ModifierValue_AnimationProperty.Opacity.getValue()), Double.valueOf(r100), ModifierValuePattern.NUMBER});
    }

    public final void c(b2 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        ArrayList<b2> r101 = this.f404997b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("transformValues");
        r101 = null;
    L5:
        com.bytedance.rts.foundation.j.j(r101, r100);
    }
}
