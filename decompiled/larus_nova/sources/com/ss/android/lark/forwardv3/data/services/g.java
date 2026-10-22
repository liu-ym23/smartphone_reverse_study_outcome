package com.ss.android.lark.forwardv3.data.services;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f425325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f425326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f425327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f425328d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f425325a, r101.f425325a) == true) goto L12;
        return false;
    L12:
        if (this.f425326b == r101.f425326b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f425327c, r101.f425327c) == true) goto L18;
        return false;
    L18:
        if (this.f425328d == r101.f425328d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f425325a.hashCode() * 31;
        int r101 = 1231;
        if (this.f425326b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f425327c.hashCode()) * 31;
        if (this.f425328d == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "SendTarget(chatId=" + this.f425325a + ", isThreadTarget=" + this.f425326b + ", parentId=" + this.f425327c + ", isReplyInThread=" + this.f425328d + ')';
    }

    public /* synthetic */ g(String r100) {
        this(r100, false, "", false);
    }

    public g(String r100, boolean r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r102, "parentId");
        this.f425325a = r100;
        this.f425326b = r101;
        this.f425327c = r102;
        this.f425328d = r103;
    }
}
