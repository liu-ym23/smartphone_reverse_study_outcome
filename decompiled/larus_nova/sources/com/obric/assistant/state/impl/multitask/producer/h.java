package com.obric.assistant.state.impl.multitask.producer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f393169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f393170b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f393169a, r101.f393169a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f393170b, r101.f393170b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f393169a.hashCode() * 31) + this.f393170b.hashCode();
    }

    public final String toString() {
        return "MessageTrackingKey(conversationId=" + this.f393169a + ", taskRootMessageId=" + this.f393170b + ')';
    }

    public h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "taskRootMessageId");
        this.f393169a = r100;
        this.f393170b = r101;
    }
}
