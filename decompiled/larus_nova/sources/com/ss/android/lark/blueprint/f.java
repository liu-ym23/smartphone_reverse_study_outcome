package com.ss.android.lark.blueprint;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class f implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f410647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<j> f410648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f410649c;

    @Override // com.ss.android.lark.blueprint.n
    public final u a() {
        return this.f410647a;
    }

    @Override // com.ss.android.lark.blueprint.n
    public final List<j> b() {
        return this.f410648b;
    }

    @Override // com.ss.android.lark.blueprint.n
    public final int getId() {
        return this.f410649c;
    }

    public final int hashCode() {
        return this.f410649c;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(f.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.blueprint.BlueprintCellSpec");
        if (this.f410649c == ((f) r100).f410649c) goto L15;
        return false;
    L15:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(u r100, List<? extends j> r101) {
        Intrinsics.checkNotNullParameter(r100, "layoutType");
        Intrinsics.checkNotNullParameter(r101, "blockKeys");
        this.f410647a = r100;
        this.f410648b = r101;
        this.f410649c = (r100.hashCode() * 31) + r101.hashCode();
    }
}
