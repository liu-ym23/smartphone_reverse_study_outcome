package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class r implements com.larksuite.framework.section.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f443892a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f443892a, ((r) r100).f443892a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f443892a.hashCode();
    }

    public final String toString() {
        return "PasteBean(content=" + this.f443892a + ')';
    }

    public r(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.f443892a = r100;
    }
}
