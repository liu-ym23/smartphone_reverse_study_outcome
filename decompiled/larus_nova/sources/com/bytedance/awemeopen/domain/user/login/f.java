package com.bytedance.awemeopen.domain.user.login;

import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.user.serviceapi.AoLoginBaseService;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f198519d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LoginHelper f198520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f198521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<com.bytedance.awemeopen.bizmodels.user.b> f198522c;

    public static final class a {
    }

    public static final class b implements u64.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f198523a;

        public b(c r100) {
            this.f198523a = r100;
        }

        @Override // u64.a
        public final void a(u64.b r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            int r101 = f.f198519d;
            AoLogger.g("SilentRefreshHostAccessTokenProcessHelper", new Object[]{"silentRefreshHostAccessToken() success"});
            this.f198523a.a(com.bytedance.awemeopen.domain.user.b.a(r100));
        }

        @Override // u64.a
        public final void onFail(int r100) {
            int r101 = f.f198519d;
            AoLogger.g("SilentRefreshHostAccessTokenProcessHelper", new Object[]{"silentRefreshHostAccessToken() invoke hostRefreshAccessToken() result==fail,no-op"});
            this.f198523a.onFail(new Exception(""));
        }
    }

    public static final class c implements com.bytedance.awemeopen.bizmodels.user.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f198524a;

        public c(f r100) {
            this.f198524a = r100;
        }

        @Override // com.bytedance.awemeopen.bizmodels.user.b
        public final void a(com.bytedance.awemeopen.bizmodels.user.c r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            f r101 = this.f198524a;
            monitor-enter(r101);
            Iterator<com.bytedance.awemeopen.bizmodels.user.b> r102 = r101.f198522c.iterator();     // Catch: Throwable -> L14
        L6:
            if (r102.hasNext() == false) goto L10;
            com.bytedance.awemeopen.bizmodels.user.b r103 = r102.next();     // Catch: Throwable -> L14
            if (r103 == null) goto L6;
            r103.a(r100);     // Catch: Throwable -> L14
            goto L6
        L10:
            r101.f198522c.clear();     // Catch: Throwable -> L14
            Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L14
            monitor-exit(r101);
            this.f198524a.f198521b = false;
            int r105 = f.f198519d;
            AoLogger.g("SilentRefreshHostAccessTokenProcessHelper", new Object[]{"silentRefreshHostAccessToken(),dispatchSilentRefreshCallbacksSuccessAndClear()"});
            return;
        L14:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.awemeopen.bizmodels.user.b
        public final void onFail(Exception r100) {
            f r101 = this.f198524a;
            monitor-enter(r101);
            Iterator<com.bytedance.awemeopen.bizmodels.user.b> r102 = r101.f198522c.iterator();     // Catch: Throwable -> L14
        L6:
            if (r102.hasNext() == false) goto L10;
            com.bytedance.awemeopen.bizmodels.user.b r103 = r102.next();     // Catch: Throwable -> L14
            if (r103 == null) goto L6;
            r103.onFail(r100);     // Catch: Throwable -> L14
            goto L6
        L10:
            r101.f198522c.clear();     // Catch: Throwable -> L14
            Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L14
            monitor-exit(r101);
            this.f198524a.f198521b = false;
            int r105 = f.f198519d;
            AoLogger.g("SilentRefreshHostAccessTokenProcessHelper", new Object[]{"silentRefreshHostAccessToken(),dispatchSilentRefreshCallbacksSuccessAndClear()"});
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    public f() {
        LoginHelper r100 = LoginHelper.f198497a;
        Intrinsics.checkNotNullParameter(r100, "loginHelper");
        this.f198520a = r100;
        this.f198522c = new HashSet();
    }

    public final void a(com.bytedance.awemeopen.bizmodels.user.b r100) {
        AoLogger.g("SilentRefreshHostAccessTokenProcessHelper", new Object[]{"--------------invoke silentRefreshHostAccessToken()--------------"});
        AoLogger.g("SilentRefreshHostAccessTokenProcessHelper", new Object[]{"silentRefreshHostAccessToken(),addSilentRefreshCallbacks()"});
        monitor-enter(this);
        this.f198522c.add(r100);     // Catch: Throwable -> L14
        monitor-exit(this);
        if (this.f198521b == false) goto L10;
        AoLogger.g("SilentRefreshHostAccessTokenProcessHelper", new Object[]{"silentRefreshHostAccessToken(),isSilentRefreshing=true,return,but callback will been invoked after silent refresh token finished!"});
        return;
    L10:
        this.f198521b = true;
        AoLogger.g("SilentRefreshHostAccessTokenProcessHelper", new Object[]{"silentRefreshHostAccessToken(),isSilentRefreshing=true"});
        c r101 = new c(this);
        LoginHelper r102 = this.f198520a;
        y54.a.a();
        b r103 = new b(r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter("", "loginSource");
        AoLoginBaseService r104 = LoginHelper.f198498b;
        if (r104 == null) goto L19;
        r104.u0(new com.bytedance.awemeopen.domain.user.login.b(r103));
        return;
    L19:
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
