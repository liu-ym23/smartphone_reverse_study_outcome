package com.ss.android.lark.passportc.impl.v2.entity;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.state.UserStateModel;
import com.ss.android.lark.passportc.internal.g0;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class UpdateUserContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f438252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UserStateModel f438253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final User f438254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BehaviorSubject<c> f438255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.d f438256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final lzb.a f438257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.ss.android.lark.passportc.impl.v2.d f438258g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h0c.a<UserState, UpdateUserContext, j0c.a> f438259h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g0 f438260i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public UserSession f438261j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UpdateUserContext) == true) goto L8;
        return false;
    L8:
        UpdateUserContext r101 = (UpdateUserContext) r100;
        if (this.f438252a == r101.f438252a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f438253b, r101.f438253b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f438254c, r101.f438254c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f438255d, r101.f438255d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f438256e, r101.f438256e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f438257f, r101.f438257f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f438258g, r101.f438258g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f438259h, r101.f438259h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f438252a * 31) + this.f438253b.hashCode()) * 31) + this.f438254c.hashCode()) * 31) + this.f438255d.hashCode()) * 31) + this.f438256e.hashCode()) * 31) + this.f438257f.hashCode()) * 31;
        com.ss.android.lark.passportc.impl.v2.d r101 = this.f438258g;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        h0c.a<UserState, UpdateUserContext, j0c.a> r105 = this.f438259h;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "UpdateUserContext(requestId=" + this.f438252a + ", userStateModel=" + this.f438253b + ", targetUser=" + this.f438254c + ", updateSubject=" + this.f438255d + ", executeMode=" + this.f438256e + ", actionContext=" + this.f438257f + ", updateVisitor=" + this.f438258g + ", actionCallback=" + this.f438259h + ')';
    }

    public UpdateUserContext(int r100, UserStateModel r101, User r102, BehaviorSubject<c> r103, com.ss.android.lark.passportc.api.d r104, lzb.a r105, com.ss.android.lark.passportc.impl.v2.d r106, h0c.a<UserState, UpdateUserContext, j0c.a> r107) {
        Intrinsics.checkNotNullParameter(r101, "userStateModel");
        Intrinsics.checkNotNullParameter(r102, "targetUser");
        Intrinsics.checkNotNullParameter(r103, "updateSubject");
        Intrinsics.checkNotNullParameter(r104, "executeMode");
        Intrinsics.checkNotNullParameter(r105, "actionContext");
        this.f438252a = r100;
        this.f438253b = r101;
        this.f438254c = r102;
        this.f438255d = r103;
        this.f438256e = r104;
        this.f438257f = r105;
        this.f438258g = r106;
        this.f438259h = r107;
        this.f438260i = (g0) r101.b(new UpdateUserContext$userDelegate$1(this));
        this.f438261j = (UserSession) r101.b(new UpdateUserContext$targetSession$1(this));
    }
}
