package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class f8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Double> f405085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<Integer> f405086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f405087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f405088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f405089e;

    public f8(ArrayList<Double> r100, ArrayList<Integer> r101, double r102, int r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, "offset");
        Intrinsics.checkNotNullParameter(r101, "offsetPattern");
        this.f405085a = r100;
        this.f405086b = r101;
        this.f405087c = r102;
        this.f405088d = r103;
        this.f405089e = r104;
    }
}
