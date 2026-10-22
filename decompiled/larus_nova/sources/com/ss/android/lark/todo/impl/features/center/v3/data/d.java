package com.ss.android.lark.todo.impl.features.center.v3.data;

import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.SimpleSubTodoData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f441550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleSubTodoData f441551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f441552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f441553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f441554e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f441550a, r101.f441550a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f441551b, r101.f441551b) == true) goto L15;
        return false;
    L15:
        if (this.f441552c == r101.f441552c) goto L18;
        return false;
    L18:
        if (this.f441553d == r101.f441553d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f441550a.hashCode() * 31;
        SimpleSubTodoData r101 = this.f441551b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        int r104 = 1231;
        if (this.f441552c == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f441553d == true) goto L15;
        r104 = 1237;
    L15:
        return r106 + r104;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "InlineCreateItem(sectionGuid=" + this.f441550a + ", simpleTodo=" + this.f441551b + ", isSectionFirstItem=" + this.f441552c + ", isSectionLastItem=" + this.f441553d + ')';
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final boolean a() {
        return this.f441553d;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final int c() {
        return this.f441554e;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final String d() {
        return this.f441550a;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final boolean f() {
        return this.f441552c;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final void b(boolean r100) {
        this.f441552c = r100;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final void g(boolean r100) {
        this.f441553d = r100;
    }

    public d(String r100, SimpleSubTodoData r101) {
        Intrinsics.checkNotNullParameter(r100, "sectionGuid");
        this.f441550a = r100;
        this.f441551b = r101;
        this.f441552c = false;
        this.f441553d = true;
        this.f441554e = 2;
    }
}
