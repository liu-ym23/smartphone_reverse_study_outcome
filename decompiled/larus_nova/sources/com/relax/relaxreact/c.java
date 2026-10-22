package com.relax.relaxreact;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<a0> f405469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<n> f405470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<n> f405471c;

    public final ArrayList<a0> a() {
        ArrayList<a0> r100 = this.f405469a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("list");
        return null;
    }

    public c() {
        ArrayList<a0> r100 = new ArrayList();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f405469a = r100;
        ArrayList<n> r101 = new ArrayList();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f405470b = r101;
        ArrayList<n> r102 = new ArrayList();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f405471c = r102;
    }
}
