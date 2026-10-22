package com.ss.android.lark.blueprint;

import com.ss.android.lark.blueprint.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e<Data, CellSpec extends n> implements wza.c<Data, CellSpec> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<CellSpec> f410646a;

    public final Class<CellSpec> b() {
        return this.f410646a;
    }

    public e(Class<CellSpec> r100) {
        Intrinsics.checkNotNullParameter(r100, "cellSpecClass");
        this.f410646a = r100;
    }

    @Override // wza.c
    public final m<Data> a(g r100, CellSpec r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, "cellSpec");
        return new BlueprintCell(r100, r101);
    }
}
