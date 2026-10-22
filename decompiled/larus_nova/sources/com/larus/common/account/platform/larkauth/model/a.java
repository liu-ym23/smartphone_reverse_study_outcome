package com.larus.common.account.platform.larkauth.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f326140d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f326141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f326142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LarkAuthAccountKind f326143c;

    /* JADX INFO: renamed from: com.larus.common.account.platform.larkauth.model.a$a, reason: collision with other inner class name */
    public static final class C4180a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f326141a == r101.f326141a) goto L12;
        return false;
    L12:
        if (this.f326142b == r101.f326142b) goto L15;
        return false;
    L15:
        if (this.f326143c == r101.f326143c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f326141a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f326142b == true) goto L11;
        r100 = 1237;
    L11:
        return ((r102 + r100) * 31) + this.f326143c.hashCode();
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "LarkAuthIdentity(isLogin=" + this.f326141a + ", isEnterpriseAccount=" + this.f326142b + ", accountKind=" + this.f326143c + ')';
    }

    public a(boolean r100, boolean r101, LarkAuthAccountKind r102) {
        Intrinsics.checkNotNullParameter(r102, "accountKind");
        this.f326141a = r100;
        this.f326142b = r101;
        this.f326143c = r102;
    }
}
