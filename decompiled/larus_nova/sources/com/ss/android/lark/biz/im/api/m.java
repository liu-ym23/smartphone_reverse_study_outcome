package com.ss.android.lark.biz.im.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class m {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f410320e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f410321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f410322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f410323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f410324d;

    public static final class a {
    }

    public m() {
        this(false, "", false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (this.f410321a == r101.f410321a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f410322b, r101.f410322b) == true) goto L15;
        return false;
    L15:
        if (this.f410323c == r101.f410323c) goto L18;
        return false;
    L18:
        if (this.f410324d == r101.f410324d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f410321a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f410322b.hashCode()) * 31;
        if (this.f410323c == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f410324d == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "GroupMemberAuthorization(pass=" + this.f410321a + ", msgDescription=" + this.f410322b + ", memberLimitNeedApply=" + this.f410323c + ", isCrossTenant=" + this.f410324d + ')';
    }

    static {
        new m(true, "", false, false);
    }

    public m(boolean r100, String r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "msgDescription");
        this.f410321a = r100;
        this.f410322b = r101;
        this.f410323c = r102;
        this.f410324d = r103;
    }
}
