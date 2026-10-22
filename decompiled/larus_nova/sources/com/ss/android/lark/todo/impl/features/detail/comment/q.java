package com.ss.android.lark.todo.impl.features.detail.comment;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class q implements com.larksuite.framework.section.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f442976a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f442976a, ((q) r100).f442976a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f442976a.hashCode();
    }

    public final String toString() {
        return "CommentDeleteInfo(deleteId=" + this.f442976a + ')';
    }

    public q(String r100) {
        Intrinsics.checkNotNullParameter(r100, "deleteId");
        this.f442976a = r100;
    }
}
