package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements com.larksuite.framework.section.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssigneeBean f443817a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f443817a, ((c) r100).f443817a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f443817a.hashCode();
    }

    public final String toString() {
        return "CompleteInfo(assigneeBean=" + this.f443817a + ')';
    }

    public c(AssigneeBean r100) {
        Intrinsics.checkNotNullParameter(r100, "assigneeBean");
        this.f443817a = r100;
    }
}
