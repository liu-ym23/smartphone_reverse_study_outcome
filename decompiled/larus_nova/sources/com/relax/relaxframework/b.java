package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Object[]> f405011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b2> f405012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<r1> f405013c;

    public b(ArrayList<Object[]> r100, ArrayList<b2> r101, ArrayList<r1> r102) {
        Intrinsics.checkNotNullParameter(r100, "numeric");
        Intrinsics.checkNotNullParameter(r101, "transform");
        Intrinsics.checkNotNullParameter(r102, "filter");
        this.f405011a = r100;
        this.f405012b = r101;
        this.f405013c = r102;
    }
}
