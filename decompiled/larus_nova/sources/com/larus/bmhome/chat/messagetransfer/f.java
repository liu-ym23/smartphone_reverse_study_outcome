package com.larus.bmhome.chat.messagetransfer;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f307333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f307334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f307335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f307336d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f307337e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f307338f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f307333a, r101.f307333a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f307334b, r101.f307334b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f307335c, r101.f307335c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f307336d, r101.f307336d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f307337e, r101.f307337e) == true) goto L24;
        return false;
    L24:
        if (this.f307338f == r101.f307338f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f307333a.hashCode() * 31;
        String r101 = this.f307334b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((((((r100 + r102) * 31) + this.f307335c.hashCode()) * 31) + this.f307336d.hashCode()) * 31) + this.f307337e.hashCode()) * 31) + this.f307338f;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "FlowHumanMergeForwardRequest(title=" + this.f307333a + ", hostMessageRef=" + this.f307334b + ", subMessageIds=" + this.f307335c + ", forwardChatId=" + this.f307336d + ", chatType=" + this.f307337e + ", isLarkMsg=" + this.f307338f + ')';
    }

    public f(String r100, String r101, List<String> r102, String r103, String r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r102, "subMessageIds");
        Intrinsics.checkNotNullParameter(r103, "forwardChatId");
        Intrinsics.checkNotNullParameter(r104, "chatType");
        this.f307333a = r100;
        this.f307334b = r101;
        this.f307335c = r102;
        this.f307336d = r103;
        this.f307337e = r104;
        this.f307338f = r105;
    }
}
