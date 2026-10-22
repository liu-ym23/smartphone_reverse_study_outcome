package com.relax.relaxframework;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<Double> f405254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<ModifierValuePattern> f405255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ModifierValuePattern f405256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ModifierValuePattern f405257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ModifierValue_ShadowOption f405258e;

    public final g0 a() {
        ArrayList r100 = new ArrayList();
        ArrayList<ModifierValuePattern> r101 = this.f405255b;
        ModifierValue_ShadowOption r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("offsetPattern");
        r101 = null;
    L6:
        Iterator<T> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        com.bytedance.rts.foundation.j.j(r100, Integer.valueOf(((ModifierValuePattern) r103.next()).getValue()));
        goto L8
    L10:
        ArrayList<Double> r104 = this.f405254a;
        if (r104 == null) goto L13;
        ArrayList<Double> r105 = r104;
    L14:
        ModifierValuePattern r106 = this.f405256c;
        if (r106 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("blurPattern");
        r106 = null;
    L18:
        int r107 = r106.getValue();
        ModifierValuePattern r108 = this.f405257d;
        if (r108 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("spreadPattern");
        r108 = null;
    L22:
        int r109 = r108.getValue();
        ModifierValue_ShadowOption r110 = this.f405258e;
        if (r110 == null) goto L25;
        r102 = r110;
    L27:
        return new g0(r105, r100, r107, r109, r102.getValue());
    L25:
        Intrinsics.throwUninitializedPropertyAccessException("optionValue");
        goto L27
    L13:
        Intrinsics.throwUninitializedPropertyAccessException("offsetValues");
        r105 = null;
        goto L14
    }

    public s() {
        ArrayList<Double> r100 = com.bytedance.rts.foundation.j.k(new Double[0]);
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f405254a = r100;
        ArrayList<ModifierValuePattern> r101 = com.bytedance.rts.foundation.j.k(new ModifierValuePattern[0]);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f405255b = r101;
        ModifierValuePattern r102 = ModifierValuePattern.PX;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f405256c = r102;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f405257d = r102;
        ModifierValue_ShadowOption r103 = ModifierValue_ShadowOption.None;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f405258e = r103;
    }
}
