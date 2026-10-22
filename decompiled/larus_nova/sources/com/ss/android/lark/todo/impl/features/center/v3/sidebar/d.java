package com.ss.android.lark.todo.impl.features.center.v3.sidebar;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.ss.android.lark.todo.impl.features.detail.sections.c> f441706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f441707b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f441706a, r101.f441706a) == true) goto L12;
        return false;
    L12:
        if (this.f441707b == r101.f441707b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f441706a.hashCode() * 31) + this.f441707b;
    }

    public final String toString() {
        return "ShareCollaboratorData(collaborators=" + this.f441706a + ", collaboratorsTotal=" + this.f441707b + ')';
    }

    public d(List<com.ss.android.lark.todo.impl.features.detail.sections.c> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "collaborators");
        this.f441706a = r100;
        this.f441707b = r101;
    }
}
