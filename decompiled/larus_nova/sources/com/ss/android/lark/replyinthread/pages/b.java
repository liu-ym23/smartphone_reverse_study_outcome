package com.ss.android.lark.replyinthread.pages;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f439506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f439507d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f439506c, r101.f439506c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f439507d, r101.f439507d) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f439506c.hashCode() * 31) + this.f439507d.hashCode();
    }

    public final String toString() {
        return "InChatThreadPageInfo(threadId=" + this.f439506c + ", bundle=" + this.f439507d + ')';
    }

    @Override // com.ss.android.lark.replyinthread.pages.f
    public final String a() {
        return this.f439506c;
    }

    public b(String r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "threadId");
        Intrinsics.checkNotNullParameter(r101, "bundle");
        super(0, r100);
        this.f439506c = r100;
        this.f439507d = r101;
    }
}
