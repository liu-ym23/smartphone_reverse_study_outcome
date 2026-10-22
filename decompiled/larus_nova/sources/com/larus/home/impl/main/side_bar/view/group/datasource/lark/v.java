package com.larus.home.impl.main.side_bar.view.group.datasource.lark;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f345451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f345452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HumanFeedScope f345453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f345454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final zb9.c f345455e;

    public v(String r100, i r101, g r102, HumanFeedScope r103) {
        o r104 = o.f345433a;
        Intrinsics.checkNotNullParameter(r100, "sourceId");
        Intrinsics.checkNotNullParameter(r101, "dataSource");
        Intrinsics.checkNotNullParameter(r102, "renderer");
        Intrinsics.checkNotNullParameter(r103, "scope");
        this.f345451a = r101;
        this.f345452b = r102;
        this.f345453c = r103;
        this.f345454d = r104;
        this.f345455e = new zb9.c(r100, r101);
    }
}
