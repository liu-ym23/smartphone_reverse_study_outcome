package com.larus.audio;

import android.app.Activity;
import android.app.Application;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 implements m58.b {
    public d0() {
    }

    @Override // m58.b
    public final boolean a() {
        return t68.a.f544678a.c();
    }

    @Override // m58.b
    public final long b() {
        return AppHost.f326268a.getAppStartTime().getFirst().longValue();
    }

    @Override // m58.b
    public final Activity currentActivity() {
        return AppHost.f326268a.a().getCurrentActivity();
    }

    @Override // m58.b
    public final boolean g() {
        AppHost.Companion r100 = AppHost.f326268a;
        if (Intrinsics.areEqual(r100.getBuildChannel(), "auto_test") == false) goto L5;
    L8:
        return true;
    L5:
        if (r100.isTestChannel() == true) goto L8;
        return false;
    }

    @Override // m58.b
    public final Application getApplication() {
        return AppHost.f326268a.getApplication();
    }

    @Override // m58.b
    public final boolean isAppBackground() {
        return AppHost.f326268a.a().isAppBackground();
    }

    @Override // m58.b
    public final boolean isAppPaused() {
        return AppHost.f326268a.a().isAppPaused();
    }

    @Override // m58.b
    public final String c(CharSequence r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "content");
        return g2a.e.f479755a.a(r100, r101, r102, 3);
    }
}
