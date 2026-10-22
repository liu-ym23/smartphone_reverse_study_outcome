package wr8;

import com.larus.bmhome.auth.LaunchCacheDelegate;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.social.userchat.start.core.StartTaskExecTime;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import wc9.e;

/* JADX INFO: loaded from: classes26.dex */
public final class d extends xr8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CompletableDeferred<Boolean> f560874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f560875b = null;

    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        @Override // com.larus.platform.api.b
        public final void a(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            CompletableDeferred<Boolean> r101 = d.f560874a;
            b.c("onLogIn");
        }

        @Override // com.larus.platform.api.b
        public final void b(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            CompletableDeferred<Boolean> r101 = d.f560874a;
            b.c("onLogout");
        }
    }

    public static final class b {
        public static void b() {
            d.f560874a = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        }

        public static e a() {
            e r100 = AuthModelDelegate.f297134b.y().getValue();
            if (r100 == null) goto L5;
            return r100;
        L5:
            return LaunchCacheDelegate.f295726b.b();
        }

        public static void c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            if (d.f560874a == null) goto L9;
            FLogger.f375446a.i("MainBotPreFetchHelper", "cancel load deffer， reason is [" + r100 + ']');
            CompletableDeferred<Boolean> r101 = d.f560874a;
            if (r101 == null) goto L7;
            r101.complete(Boolean.TRUE);
        L7:
            d.f560874a = null;
            AccountService.f365697a.D(d.f560875b);
            return;
        }
    }

    @Override // xr8.a
    public final boolean a() {
        return false;
    }

    @Override // xr8.a
    public final void b() {
    }

    @Override // xr8.a
    public final int d() {
        return 50;
    }

    static {
        f560875b = new a();
    }

    public d() {
        AccountService.f365697a.E(f560875b);
    }

    @Override // xr8.a
    public final void e() {
        b.c("skip preload task execute");
    }

    @Override // xr8.a
    public final StartTaskExecTime c() {
        return StartTaskExecTime.BEFORE_MAIN_ACTIVITY_SUPER_ON_CREATED;
    }
}
