package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccountState f364875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f364876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f364877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final UserAction f364878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f364879e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f364875a == r101.f364875a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f364876b, r101.f364876b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f364877c, r101.f364877c) == true) goto L18;
        return false;
    L18:
        if (this.f364878d == r101.f364878d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f364879e, r101.f364879e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f364875a.hashCode() * 31) + this.f364876b.hashCode()) * 31) + this.f364877c.hashCode()) * 31) + this.f364878d.hashCode()) * 31) + this.f364879e.hashCode();
    }

    public final String toString() {
        return "AccountStatusEvent(state=" + this.f364875a + ", userId=" + this.f364876b + ", secUserId=" + this.f364877c + ", action=" + this.f364878d + ", businessScene=" + this.f364879e + ')';
    }

    public c(AccountState r100, String r101, String r102, UserAction r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r102, "secUserId");
        Intrinsics.checkNotNullParameter(r103, "action");
        Intrinsics.checkNotNullParameter(r104, "businessScene");
        this.f364875a = r100;
        this.f364876b = r101;
        this.f364877c = r102;
        this.f364878d = r103;
        this.f364879e = r104;
    }
}
