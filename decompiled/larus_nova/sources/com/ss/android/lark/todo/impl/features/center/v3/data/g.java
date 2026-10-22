package com.ss.android.lark.todo.impl.features.center.v3.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f441571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f441572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f441573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f441574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f441575e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f441571a, r101.f441571a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f441572b, r101.f441572b) == true) goto L15;
        return false;
    L15:
        if (this.f441573c == r101.f441573c) goto L18;
        return false;
    L18:
        if (this.f441574d == r101.f441574d) goto L21;
        return false;
    L21:
        if (this.f441575e == r101.f441575e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f441571a.hashCode() * 31) + this.f441572b.hashCode()) * 31) + this.f441573c) * 31;
        int r101 = 1231;
        if (this.f441574d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f441575e == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "TaskSkeletonItem(taskGuid=" + this.f441571a + ", sectionGuid=" + this.f441572b + ", itemTag=" + this.f441573c + ", isSectionFirstItem=" + this.f441574d + ", isSectionLastItem=" + this.f441575e + ')';
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final boolean a() {
        return this.f441575e;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final int c() {
        return this.f441573c;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final String d() {
        return this.f441572b;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final boolean f() {
        return this.f441574d;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final void b(boolean r100) {
        this.f441574d = r100;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final void g(boolean r100) {
        this.f441575e = r100;
    }

    public g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "taskGuid");
        Intrinsics.checkNotNullParameter(r101, "sectionGuid");
        this.f441571a = r100;
        this.f441572b = r101;
        this.f441573c = 3;
        this.f441574d = false;
        this.f441575e = false;
    }
}
