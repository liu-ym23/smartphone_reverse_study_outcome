package com.ss.android.lark.passportc.internal;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passportc.entity.UserSession;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class UserComponentManagerImpl implements y, v, b, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f438400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.log.c f438401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f438402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f438403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f438404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f438405f;

    @Override // com.ss.android.lark.passportc.internal.y
    public final synchronized e0c.l a(UserSession r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);     // Catch: Throwable -> L7
        m0c.b.b(this.f438401b, "deleteUserComponent, uid=" + r100.f438138b);     // Catch: Throwable -> L7
        e0c.l r101 = this.f438402c.destroyComponent(r100);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.passportc.internal.b
    public final e0c.a b(UserSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        e0c.a r101 = this.f438404e.findComponent(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return (e0c.a) this.f438405f.getValue();
    }

    @Override // com.ss.android.lark.passportc.internal.v
    public final synchronized e0c.l c(UserSession r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);     // Catch: Throwable -> L8
        e0c.l r101 = this.f438402c.findComponent(r100);     // Catch: Throwable -> L8
        if (r101 != null) goto L6;
        r101 = (e0c.l) this.f438403d.getValue();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r101;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.passportc.internal.y
    public final e0c.a d(UserSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        m0c.b.b(this.f438401b, "deleteUserComponent, uid=" + r100.f438138b);
        return this.f438404e.destroyComponent(r100);
    }

    @Override // com.ss.android.lark.passportc.internal.y
    public final e0c.a f(UserSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        return this.f438404e.findComponent(r100);
    }

    @Override // com.ss.android.lark.passportc.internal.y
    public final e0c.l g(UserSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        return this.f438402c.findComponent(r100);
    }

    @Override // com.ss.android.lark.passportc.internal.y
    public final e0c.a h(f0 r100) {
        Intrinsics.checkNotNullParameter(r100, "userDelete");
        e0c.a r101 = f(r100.getSession());
        if (r101 == null) goto L5;
        return r101;
    L5:
        return this.f438404e.generatedComponent(r100.getSession(), r100);
    }

    @Override // com.ss.android.lark.passportc.internal.y
    public final synchronized e0c.l i(f0 r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "userDelete");     // Catch: Throwable -> L8
        e0c.l r101 = this.f438402c.findComponent(r100.getSession());     // Catch: Throwable -> L8
        if (r101 != null) goto L6;
        r101 = this.f438402c.generatedComponent(r100.getSession(), r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r101;
    L8:
        th = move-exception;
        throw th;
    }

    @Inject
    public UserComponentManagerImpl(b0 r100, com.ss.android.lark.log.c r101) {
        Intrinsics.checkNotNullParameter(r100, "componentProviders");
        Intrinsics.checkNotNullParameter(r101, "logger");
        this.f438400a = r100;
        this.f438401b = r101;
        this.f438402c = new x(r100, r101);
        this.f438403d = LazyKt.lazy(new UserComponentManagerImpl$absentUserComponent$2(this));
        this.f438404e = new d(r100, r101);
        this.f438405f = LazyKt.lazy(new UserComponentManagerImpl$absentBackgroundUserComponent$2(this));
    }
}
