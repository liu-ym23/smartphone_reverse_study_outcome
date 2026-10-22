package com.larus.common.account.douyin;

import android.os.Handler;
import android.os.Looper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes27.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f326085a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static m f326086b;

    public static final class a implements f09.a.b {
        public a() {
        }

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppForeground() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            n.a("app background");
        }
    }

    static {
        f326085a = new Handler(Looper.getMainLooper());
        AppHost.f326268a.a().j(new a());
    }

    public static void a(String r100) {
        m r101 = f326086b;
        if (r101 == null) goto L6;
        FLogger.f375446a.i("DouyinOauthTokenRefreshScheduler", "cancel task: ".concat(r100));
        f326085a.removeCallbacks(r101);
        f326086b = null;
        return;
    }
}
