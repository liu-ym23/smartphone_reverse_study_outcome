package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<g> f443898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f443899b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f443898a, r101.f443898a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f443899b, r101.f443899b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f443898a.hashCode() * 31) + this.f443899b.hashCode();
    }

    public final String toString() {
        return "SearchTaskListsData(searchItems=" + this.f443898a + ", searchKey=" + this.f443899b + ')';
    }

    public u(List<g> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "searchItems");
        Intrinsics.checkNotNullParameter(r101, "searchKey");
        this.f443898a = r100;
        this.f443899b = r101;
    }
}
