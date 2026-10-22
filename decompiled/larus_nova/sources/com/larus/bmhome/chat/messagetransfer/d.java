package com.larus.bmhome.chat.messagetransfer;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f307326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f307327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f307328c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f307326a, r101.f307326a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f307327b, r101.f307327b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f307328c, r101.f307328c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f307326a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f307327b.hashCode()) * 31;
        String r104 = this.f307328c;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowAskDoubaoResult(conversationId=" + this.f307326a + ", chatBundle=" + this.f307327b + ", messageCacheKey=" + this.f307328c + ')';
    }

    public d(String r100, Bundle r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "chatBundle");
        this.f307326a = r100;
        this.f307327b = r101;
        this.f307328c = r102;
    }
}
