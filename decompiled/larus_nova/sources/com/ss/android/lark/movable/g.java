package com.ss.android.lark.movable;

import com.ss.android.lark.movable.island.ScrollIsland;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements jsb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MovableView f432665a;

    public g(MovableView r100) {
        this.f432665a = r100;
    }

    @Override // jsb.b
    public final void b(int r100) {
        this.f432665a.f432573m.remove(Integer.valueOf(r100));
    }

    @Override // jsb.b
    public final void a(jsb.a r100, ScrollIsland r101) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "scrollIsland");
        this.f432665a.f432573m.put(Integer.valueOf(r100.f500270a), r101);
    }
}
