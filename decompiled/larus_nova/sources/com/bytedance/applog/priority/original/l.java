package com.bytedance.applog.priority.original;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f192755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f192756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f192757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f192758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f192759e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r f192760f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f192761g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f192762h;

    public final String toString() {
        return "GroupConfig-" + this.f192755a;
    }

    public l(int r100, t r101, int r102, m r103, n r104, r r105, List<String> r106, String r107) {
        Intrinsics.checkNotNullParameter(r101, "version");
        Intrinsics.checkNotNullParameter(r103, "frequency");
        Intrinsics.checkNotNullParameter(r104, "priority");
        Intrinsics.checkNotNullParameter(r106, "supportEventTypes");
        Intrinsics.checkNotNullParameter(r107, "reportUrl");
        this.f192755a = r100;
        this.f192756b = r101;
        this.f192757c = r102;
        this.f192758d = r103;
        this.f192759e = r104;
        this.f192760f = r105;
        this.f192761g = r106;
        this.f192762h = r107;
        if (r102 > 0) goto L6;
        r103.f192766d = Integer.MAX_VALUE;
        return;
    L6:
        if (r103.f192766d > 0) goto L11;
        r103.f192766d = RangesKt.coerceAtLeast(60 / r102, 10);
        return;
    }
}
