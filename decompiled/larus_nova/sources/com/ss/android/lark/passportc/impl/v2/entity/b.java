package com.ss.android.lark.passportc.impl.v2.entity;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.entity.UserState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final User f438275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f438276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UserState f438277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final UserState f438278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Scene f438279e;

    public final int hashCode() {
        int r100 = this.f438275a.userId.hashCode() * 31;
        if (this.f438276b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (((((r100 + r101) * 31) + this.f438277c.hashCode()) * 31) + this.f438278d.hashCode()) * 31;
        Scene r103 = this.f438279e;
        if (r103 == null) goto L9;
        int r104 = r103.hashCode();
    L11:
        return r102 + r104;
    L9:
        r104 = 0;
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "{uid:" + this.f438275a.userId + ", foreground:" + this.f438276b + ", " + this.f438277c + " -> " + this.f438278d + ", scene:" + this.f438279e + '}';
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f438275a.userId, r101.f438275a.userId) == true) goto L12;
        return false;
    L12:
        if (this.f438276b == r101.f438276b) goto L15;
        return false;
    L15:
        if (this.f438277c == r101.f438277c) goto L18;
        return false;
    L18:
        if (this.f438278d == r101.f438278d) goto L21;
        return false;
    L21:
        if (this.f438279e == r101.f438279e) goto L23;
        return false;
    L23:
        return true;
    }

    public /* synthetic */ b(User r100, boolean r101, UserState r102, UserState r110) {
        this(r100, r101, r102, r110, null);
    }

    public b(User r100, boolean r101, UserState r102, UserState r103, Scene r104) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r102, "from");
        Intrinsics.checkNotNullParameter(r103, RemoteMessageConst.TO);
        this.f438275a = r100;
        this.f438276b = r101;
        this.f438277c = r102;
        this.f438278d = r103;
        this.f438279e = r104;
    }
}
