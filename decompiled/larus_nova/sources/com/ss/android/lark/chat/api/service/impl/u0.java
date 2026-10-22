package com.ss.android.lark.chat.api.service.impl;

import com.ss.android.lark.chat.api.service.request.PullUrlPreviewRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PullUrlPreviewRequest f411661a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f411661a, ((u0) r100).f411661a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f411661a.hashCode();
    }

    public final String toString() {
        return "PatchPreviewTask(request=" + this.f411661a + ')';
    }

    public u0(PullUrlPreviewRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f411661a = r100;
    }
}
