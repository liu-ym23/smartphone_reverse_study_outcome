package com.ss.android.lark.chat.api.service.impl.usergroup;

import a2b.n;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class UserGroupPushProxy extends c0c.b implements n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f411670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f411671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<n> f411672d;

    public static final class a {
    }

    static {
    }

    @Override // a2b.n
    public final void C3(final com.ss.android.lark.biz.im.api.usergroup.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f411672d.a(new com.ss.android.lark.passportc.convention.b.C5239b(com.ss.android.lark.biz.im.api.usergroup.a.class, r100), new com.ss.android.lark.passportc.convention.b.c(new UserGroupPushProxy$startPush$1(r100), new UserGroupPushProxy$startPush$2(r100)));
    }

    @Override // c0c.b
    public final void mf(g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Log.i("UserGroupPushProxy", "destroy user: " + r100.f475034b.f438138b);
        Intrinsics.checkNotNullParameter(r100, "user");
        n r101 = this.f411672d.c();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.chat.api.service.impl.usergroup.UserGroupPush");
        ((UserGroupPush) r101).f411665a.b();
    }

    @Override // c0c.b
    public final void of(g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Log.i("UserGroupPushProxy", "user onPrepared: " + r100.f475034b.f438138b);
        Intrinsics.checkNotNullParameter(r100, "user");
    }

    @Override // a2b.n
    public final void vc(com.ss.android.lark.biz.im.api.usergroup.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f411672d.d(new com.ss.android.lark.passportc.convention.b.C5239b(com.ss.android.lark.biz.im.api.usergroup.a.class, r100));
    }

    public UserGroupPushProxy(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<n> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), n.class), n.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f411670b = r103.b();
        this.f411671c = r101;
        this.f411672d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        StringBuilder r102 = new StringBuilder("preparing, fromUser: ");
        String r103 = "";
        if (r100 == null) goto L8;
        UserSession r104 = r100.f475034b;
        if (r104 == null) goto L8;
        String r105 = r104.f438138b;
        if (r105 == null) goto L8;
    L9:
        r102.append(r105);
        r102.append(", toUser: ");
        if (r101 == null) goto L17;
        UserSession r106 = r101.f475034b;
        if (r106 == null) goto L17;
        String r107 = r106.f438138b;
        if (r107 == null) goto L17;
        r103 = r107;
    L17:
        r102.append(r103);
        Log.i("UserGroupPushProxy", r102.toString());
        n r108 = this.f411672d.c();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.ss.android.lark.chat.api.service.impl.usergroup.UserGroupPush");
        UserGroupPush r109 = (UserGroupPush) r108;
        b r110 = r109.f411665a;
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.ss.android.lark.chat.api.service.impl.usergroup.UserGroupPushRepository");
        if (Intrinsics.areEqual(((UserGroupPushRepository) r110).f411673a, "absent_user") == false) goto L20;
        Log.w("UserGroupPushProxy", "from user is ABSENT_USER, call release manually");
        r109.f411665a.b();
    L20:
        v r111 = this.f411671c;
        if (r101 == null) goto L24;
        UserSession r112 = r101.f475034b;
        if (r112 == null) goto L24;
    L25:
        n r113 = (n) k.b(r111.c(r112), n.class);
        this.f411672d.e(r113);
        return;
    L24:
        r112 = ContainerConstsKt.a();
    L8:
        r105 = "";
        goto L9
    }
}
