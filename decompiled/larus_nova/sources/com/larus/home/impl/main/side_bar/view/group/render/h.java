package com.larus.home.impl.main.side_bar.view.group.render;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f345632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fb9.c f345633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<List<eb9.d>> f345634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f345635d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<String, Unit> f345636e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function2<String, Boolean, Unit> f345637f;

    public h(k r100, rb9.b r101, com.larus.home.impl.main.side_bar.view.group.module.b0 r102, Function0 r103, Function1 r104, Function2 r105) {
        Intrinsics.checkNotNullParameter(r100, "inserter");
        Intrinsics.checkNotNullParameter(r101, "actionAbility");
        Intrinsics.checkNotNullParameter(r102, "actionItems");
        Intrinsics.checkNotNullParameter(r103, "onActionMenuShow");
        Intrinsics.checkNotNullParameter(r104, "onHeaderShow");
        Intrinsics.checkNotNullParameter(r105, "onHeaderCollapse");
        this.f345632a = r100;
        this.f345633b = r101;
        this.f345634c = r102;
        this.f345635d = r103;
        this.f345636e = r104;
        this.f345637f = r105;
    }
}
