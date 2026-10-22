package com.ss.android.lark.passportc.impl.v2.entity;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.entity.UserState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final User f438280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UserState f438281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f438282c;

    public final int hashCode() {
        int r100 = ((this.f438280a.userId.hashCode() * 31) + this.f438281b.hashCode()) * 31;
        if (this.f438282c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "(targetUserId=" + this.f438280a.userId + ", targetState=" + this.f438281b + ", forceReset=" + this.f438282c + ')';
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f438280a.userId, r101.f438280a.userId) == true) goto L12;
        return false;
    L12:
        if (this.f438281b == r101.f438281b) goto L15;
        return false;
    L15:
        if (this.f438282c == r101.f438282c) goto L17;
        return false;
    L17:
        return true;
    }

    public d(User r100, UserState r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "targetUser");
        Intrinsics.checkNotNullParameter(r101, "targetState");
        this.f438280a = r100;
        this.f438281b = r101;
        this.f438282c = r102;
    }
}
