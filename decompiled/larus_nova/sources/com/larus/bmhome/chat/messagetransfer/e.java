package com.larus.bmhome.chat.messagetransfer;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f307329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f307330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f307331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<byte[]> f307332d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f307329a, r101.f307329a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f307330b, r101.f307330b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f307331c, r101.f307331c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f307332d, r101.f307332d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f307329a.hashCode() * 31;
        String r101 = this.f307330b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f307331c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((r104 + r102) * 31) + this.f307332d.hashCode();
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowDoubaoMergeForwardRequest(title=" + this.f307329a + ", hostMessageRef=" + this.f307330b + ", hostMessageId=" + this.f307331c + ", subMessagePayloads=" + this.f307332d + ')';
    }

    public e(String r100, String r101, String r102, List<byte[]> r103) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r103, "subMessagePayloads");
        this.f307329a = r100;
        this.f307330b = r101;
        this.f307331c = r102;
        this.f307332d = r103;
    }
}
