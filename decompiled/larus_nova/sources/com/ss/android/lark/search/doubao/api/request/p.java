package com.ss.android.lark.search.doubao.api.request;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f439985a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f439985a, ((p) r100).f439985a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f439985a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "MessageDslModel(chatID=" + this.f439985a + ')';
    }

    public p() {
        this.f439985a = null;
    }
}
