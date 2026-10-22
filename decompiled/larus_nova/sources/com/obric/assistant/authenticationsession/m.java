package com.obric.assistant.authenticationsession;

import android.os.Build;
import android.os.Handler;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;

/* JADX INFO: loaded from: classes4.dex */
public final class m implements f09.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f385825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SessionAuthenticationServiceImpl f385826b;

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
    }

    @Override // f09.a.b
    public final void onAppBackground() {
        FLogger.f375446a.i("SessionAuthenticationServiceImpl", "onAppBackground");
        Handler r100 = t0.f375468a;
        r100.removeCallbacks(this.f385825a);
        r100.postDelayed(this.f385825a, 600);
    }

    @Override // f09.a.b
    public final void onAppForeground() {
        FLogger r100 = FLogger.f375446a;
        r100.i("SessionAuthenticationServiceImpl", "onAppForeground");
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 29) goto L7;
        Handler r102 = t0.f375468a;
        if (r102.hasCallbacks(this.f385825a) == false) goto L8;
        r100.i("SessionAuthenticationServiceImpl", "onAppForeground: hasCallbacks");
        r102.removeCallbacks(this.f385825a);
    L8:
        SessionAuthenticationServiceImpl r103 = this.f385826b;
        int r104 = SessionAuthenticationServiceImpl.f385719r;
        r103.c("onAppForeground", true);
        return;
    L7:
        r100.w("SessionAuthenticationServiceImpl", "onAppForeground: api is too low " + r101);
        goto L8
    }

    public m(k r100, SessionAuthenticationServiceImpl r101) {
        this.f385825a = r100;
        this.f385826b = r101;
    }
}
