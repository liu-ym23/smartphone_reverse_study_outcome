package com.ss.android.lark.active.user.bridge;

import com.ss.android.lark.passport_user.api.IUserListService;
import com.ss.android.lark.passportc.internal.v;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Singleton
public final class j implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.j f408565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.j f408566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IUserListService f408567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final mua.a f408568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.i f408569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final v f408570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.b f408571g;

    @Override // com.ss.android.lark.active.user.bridge.g
    public final p a(r r110) {
        Intrinsics.checkNotNullParameter(r110, "request");
        return new p(r110, this.f408565a, this.f408566b, this.f408567c, this.f408568d, this.f408569e, this.f408570f, this.f408571g);
    }

    @Inject
    public j(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.api.j r101, IUserListService r102, mua.a r103, com.ss.android.lark.passportc.api.i r104, v r105, com.ss.android.lark.passportc.internal.b r106) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "globalPassportService");
        Intrinsics.checkNotNullParameter(r102, "userService");
        Intrinsics.checkNotNullParameter(r103, "multiSwitch");
        Intrinsics.checkNotNullParameter(r104, "multiUserFG");
        Intrinsics.checkNotNullParameter(r105, "accessor");
        Intrinsics.checkNotNullParameter(r106, "backgroundAccessor");
        this.f408565a = r100;
        this.f408566b = r101;
        this.f408567c = r102;
        this.f408568d = r103;
        this.f408569e = r104;
        this.f408570f = r105;
        this.f408571g = r106;
    }
}
