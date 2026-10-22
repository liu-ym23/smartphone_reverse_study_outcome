package com.ss.android.lark.passportc.internal;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passportc.entity.UserSession;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class a0 implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f438456a;

    @Inject
    public a0(y r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponentManager");
        this.f438456a = r100;
    }

    @Override // com.ss.android.lark.passportc.internal.z
    public final void a(UserSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f438456a.a(r100);
    }

    @Override // com.ss.android.lark.passportc.internal.z
    public final Set<com.ss.android.lark.passportc.task.c> b(UserSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        e0c.l r101 = this.f438456a.g(r100);
        if (r101 == null) goto L7;
        Set<com.ss.android.lark.passportc.task.c> r102 = ((com.ss.android.lark.passportc.task.j) r101).g();
        if (r102 == null) goto L7;
        return r102;
    L7:
        return SetsKt.emptySet();
    }

    @Override // com.ss.android.lark.passportc.internal.z
    public final Set<com.ss.android.lark.passportc.task.d> c(UserSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        e0c.l r101 = this.f438456a.g(r100);
        if (r101 == null) goto L7;
        Set<com.ss.android.lark.passportc.task.d> r102 = ((com.ss.android.lark.passportc.task.j) r101).R();
        if (r102 == null) goto L7;
        return r102;
    L7:
        return SetsKt.emptySet();
    }

    @Override // com.ss.android.lark.passportc.internal.z
    public final void d(UserSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f438456a.d(r100);
    }

    @Override // com.ss.android.lark.passportc.internal.z
    public final void e(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "userDelegate");
        this.f438456a.i(r100);
    }

    @Override // com.ss.android.lark.passportc.internal.z
    public final e0c.a f(UserSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        return this.f438456a.f(r100);
    }

    @Override // com.ss.android.lark.passportc.internal.z
    public final void g(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "userDelegate");
        this.f438456a.h(r100);
    }
}
