package com.bytedance.ee.bear.basesdk.services.container;

import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class UserDomainCharacteristicServiceProxy extends c0c.b implements s45.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s45.c f206618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f206619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<s45.c> f206620d;

    @Override // s45.c
    public final String Ba(String r100) {
        return this.f206618b.Ba(r100);
    }

    @Override // s45.c
    public final String O6() {
        return this.f206618b.O6();
    }

    @Override // s45.c
    public final void R8(String r100) {
        this.f206618b.R8(r100);
    }

    @Override // s45.c
    public final void dd(boolean r100) {
        this.f206618b.dd(r100);
    }

    @Override // s45.c
    public final String getString(String r100, String r101) {
        return this.f206618b.getString(r100, r101);
    }

    @Override // s45.c
    public final void h7(String r100, String r101) {
        this.f206618b.h7(r100, r101);
    }

    @Override // s45.c
    public final Flowable<String> ka() {
        return this.f206618b.ka();
    }

    @Override // s45.c
    public final String t6(String r100) {
        return this.f206618b.t6(r100);
    }

    @Override // s45.c
    public final void b1(final s45.c.a r100) {
        com.ss.android.lark.passportc.convention.b<s45.c> r101 = this.f206620d;
        if (r100 != null) goto L5;
        Object r102 = "";
    L6:
        r101.a(new com.ss.android.lark.passportc.convention.b.C5239b(s45.c.a.class, r102), new com.ss.android.lark.passportc.convention.b.c(new UserDomainCharacteristicServiceProxy$registerConfigChangeListener$1(r100), new UserDomainCharacteristicServiceProxy$registerConfigChangeListener$2(r100)));
        return;
    L5:
        r102 = r100;
        goto L6
    }

    @Override // s45.c
    public final void o4(s45.c.a r100) {
        com.ss.android.lark.passportc.convention.b<s45.c> r101 = this.f206620d;
        Object r102 = r100;
        if (r100 != null) goto L5;
        r102 = "";
    L5:
        r101.d(new com.ss.android.lark.passportc.convention.b.C5239b(s45.c.a.class, r102));
    }

    public UserDomainCharacteristicServiceProxy(com.ss.android.lark.passportc.api.j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<s45.c> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), s45.c.class), s45.c.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f206618b = r103.b();
        this.f206619c = r101;
        this.f206620d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        v r102 = this.f206619c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        s45.c r104 = (s45.c) k.b(r102.c(r103), s45.c.class);
        this.f206620d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
