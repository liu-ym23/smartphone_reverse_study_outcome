package com.bytedance.ee.bear.basesdk.services.route;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.ee.bear.route.PostCard;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f extends c0c.b implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f206689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f206690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<h> f206691d;

    @Override // com.bytedance.ee.bear.route.h
    public final boolean D4(String r100) {
        return this.f206689b.D4(r100);
    }

    @Override // com.bytedance.ee.bear.route.h
    public final void H6(String r100, String r101) {
        this.f206689b.H6(r100, r101);
    }

    @Override // com.bytedance.ee.bear.route.h
    public final void K8() {
        this.f206689b.K8();
    }

    @Override // com.bytedance.ee.bear.route.h
    public final void N9(String r100, String r101) {
        this.f206689b.N9(r100, r101);
    }

    @Override // com.bytedance.ee.bear.route.h
    public final void P3(String r100, String r101, String r102, Bundle r110, b.C2981b r111) {
        this.f206689b.P3(r100, r101, r102, r110, r111);
    }

    @Override // com.bytedance.ee.bear.route.h
    public final void Pb(String r100, com.ss.android.lark.maintab.export.a r101, boolean r102) {
        this.f206689b.Pb(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.route.h
    public final com.ss.android.lark.maintab.export.a Pd(String r100) {
        return this.f206689b.Pd(r100);
    }

    @Override // com.bytedance.ee.bear.route.h
    public final void R3(Context r100, String r101, RouteBean r102) {
        this.f206689b.R3(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.route.h
    public final void Td(com.bytedance.ee.bear.route.d r100) {
        this.f206689b.Td(r100);
    }

    @Override // com.bytedance.ee.bear.route.h
    public final Intent W0() {
        return this.f206689b.W0();
    }

    @Override // com.bytedance.ee.bear.route.h
    @Deprecated(message = "Deprecated in Java")
    public final void X8(Activity r100) {
        this.f206689b.X8(r100);
    }

    @Override // com.bytedance.ee.bear.route.h
    public final boolean Xb(String r100) {
        return this.f206689b.Xb(r100);
    }

    @Override // com.bytedance.ee.bear.route.h
    public final void Xc(String r100, String r101, TabAppInfo.CustomNavigationAppLogoType r102) {
        this.f206689b.Xc(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.route.h
    public final void Y3(com.ss.android.lark.maintab.export.a r100) {
        this.f206689b.Y3(r100);
    }

    @Override // com.bytedance.ee.bear.route.h
    public final void d4(String r100, com.ss.android.lark.maintab.export.a r101) {
        this.f206689b.d4(r100, r101);
    }

    @Override // com.bytedance.ee.bear.route.h
    public final void g3(String r100, String r101) {
        this.f206689b.g3(r100, r101);
    }

    @Override // com.bytedance.ee.bear.route.h
    @Deprecated(message = "Deprecated in Java")
    public Activity getActivity() {
        return this.f206689b.getActivity();
    }

    @Override // com.bytedance.ee.bear.route.h
    @Deprecated(message = "Deprecated in Java")
    public final Activity getCurrentActivity() {
        return this.f206689b.getCurrentActivity();
    }

    @Override // com.bytedance.ee.bear.route.h
    public final void m9(String r100, RouteBean r101) {
        this.f206689b.m9(r100, r101);
    }

    @Override // com.bytedance.ee.bear.route.h
    public final void pc(z05.h r100, Class r101, Class r102) {
        this.f206689b.pc(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.route.h
    public final void re(ra5.h r100) {
        this.f206689b.re(r100);
    }

    @Override // com.bytedance.ee.bear.route.h
    public final void s5(com.bytedance.ee.bear.route.d r100) {
        this.f206689b.s5(r100);
    }

    @Override // com.bytedance.ee.bear.route.h
    @Deprecated(message = "Deprecated in Java")
    public final void setActivity(Activity r100) {
        this.f206689b.setActivity(r100);
    }

    @Override // com.bytedance.ee.bear.route.h
    public final void u5(String r100) {
        this.f206689b.u5(r100);
    }

    @Override // com.bytedance.ee.bear.route.h
    public final PostCard w2(String r100) {
        return this.f206689b.w2(r100);
    }

    @Override // com.bytedance.ee.bear.route.h
    public final PostCard yd(String r100, RouteBean r101) {
        return this.f206689b.yd(r100, r101);
    }

    public f(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<h> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), h.class), h.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f206689b = r103.b();
        this.f206690c = r101;
        this.f206691d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        v r102 = this.f206690c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        h r104 = (h) k.b(r102.c(r103), h.class);
        this.f206691d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
