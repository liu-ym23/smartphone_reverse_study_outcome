package com.relax.relaxreact;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SnapshotInstance f405524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<SnapshotInstance> f405525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f405526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Long, g0> f405527d;

    public j0(SnapshotInstance r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.f405527d = new LinkedHashMap();
        this.f405524a = r100;
        this.f405525b = h0.b(r100);
    }

    public static void a(ArrayList r100, SnapshotInstance r101, int r102) {
        f0 r103 = new f0();
        r103.f405494a = r102;
        g0 r104 = r101.f405446j;
        Intrinsics.checkNotNullParameter(r103, "action");
        if (r104 == null) goto L6;
        r103.f405496c = null;
        r103.f405497d = null;
        r103.f405498e = null;
        r103.f405499f = null;
        r103.f405500g = null;
        r103.f405501h = null;
        r103.f405502i = null;
        r103.f405503j = null;
        r103.f405504k = null;
    L6:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.add(r103);
    }
}
