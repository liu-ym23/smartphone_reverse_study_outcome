package com.larus.login.impl.switchbind;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f358257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bk9.a f358258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bk9.a f358259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f358260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Result<Unit> f358261e;

    public n() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f358257a == r101.f358257a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f358258b, r101.f358258b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f358259c, r101.f358259c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f358260d, r101.f358260d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f358261e, r101.f358261e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.f358257a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        bk9.a r102 = this.f358258b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        bk9.a r106 = this.f358259c;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f358260d;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        Result<Unit> r112 = this.f358261e;
        if (r112 == null) goto L23;
        r103 = Result.m9454hashCodeimpl(r112.m9458unboximpl());
    L23:
        return r111 + r103;
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "SwitchBindState(isLoading=" + this.f358257a + ", conflictAccount=" + this.f358258b + ", currentAccount=" + this.f358259c + ", accountInfoErrorMessage=" + this.f358260d + ", switchResult=" + this.f358261e + ')';
    }

    public /* synthetic */ n(int r100) {
        this(false, null, null, null, null);
    }

    public n(boolean r100, bk9.a r101, bk9.a r102, String r103, Result<Unit> r104) {
        this.f358257a = r100;
        this.f358258b = r101;
        this.f358259c = r102;
        this.f358260d = r103;
        this.f358261e = r104;
    }

    public static n a(n r100, boolean r101, bk9.a r102, bk9.a r103, String r110, Result r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.f358257a;
    L5:
        boolean r104 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.f358258b;
    L8:
        bk9.a r105 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.f358259c;
    L11:
        bk9.a r106 = r103;
        if ((r112 & 8) == 0) goto L14;
        r110 = r100.f358260d;
    L14:
        String r107 = r110;
        if ((r112 & 16) == 0) goto L17;
        r111 = r100.f358261e;
    L17:
        r100.getClass();
        return new n(r104, r105, r106, r107, r111);
    }
}
