package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f405242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ModifierValuePattern f405243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f405244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ModifierValuePattern f405245d;

    public ArrayList<Object> a() {
        return new ArrayList();
    }

    public final f0 b() {
        double r100 = this.f405242a;
        ModifierValuePattern r101 = this.f405243b;
        ModifierValuePattern r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("xPattern");
        r101 = null;
    L6:
        int r103 = r101.getValue();
        double r104 = this.f405244c;
        ModifierValuePattern r105 = this.f405245d;
        if (r105 == null) goto L9;
        r102 = r105;
    L11:
        return new f0(r100, r103, r104, r102.getValue());
    L9:
        Intrinsics.throwUninitializedPropertyAccessException("yPattern");
        goto L11
    }

    public r(double r100, ModifierValuePattern r101, double r102, ModifierValuePattern r103) {
        Intrinsics.checkNotNullParameter(r101, "xPattern");
        Intrinsics.checkNotNullParameter(r103, "yPattern");
        this.f405242a = r100;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f405243b = r101;
        this.f405244c = r102;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f405245d = r103;
    }

    public void c(double r100, ModifierValuePattern r101, double r102, ModifierValuePattern r103) {
        Intrinsics.checkNotNullParameter(r101, "xPattern");
        Intrinsics.checkNotNullParameter(r103, "yPattern");
        this.f405242a = r100;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f405243b = r101;
        this.f405244c = r102;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f405245d = r103;
    }
}
