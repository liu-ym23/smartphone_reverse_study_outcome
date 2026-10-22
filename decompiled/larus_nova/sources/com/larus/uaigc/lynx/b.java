package com.larus.uaigc.lynx;

import android.view.View;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.larus.platform.api.f4;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: classes31.dex */
public final class b implements f4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletableDeferred<Boolean> f373506a;

    @Override // com.larus.platform.api.f4
    public final void a() {
        FLogger.f375446a.i("LotteryLynxWarmer", "[onTimingSetup]");
        if (this.f373506a.isCompleted() == true) goto L6;
        this.f373506a.complete(Boolean.TRUE);
        return;
    }

    @Override // com.larus.platform.api.f4
    public final void f() {
        FLogger.f375446a.i("LotteryLynxWarmer", "[onViewDestroy]");
    }

    @Override // com.larus.platform.api.f4
    public final void onLoadStart() {
        FLogger.f375446a.i("LotteryLynxWarmer", "[onLoadStart]");
    }

    public b(CompletableDeferred<Boolean> r100) {
        this.f373506a = r100;
    }

    @Override // com.larus.platform.api.f4
    public final void b(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        FLogger.f375446a.e("LotteryLynxWarmer", "[onFallback]", r100);
        if (this.f373506a.isCompleted() == true) goto L6;
        this.f373506a.complete(Boolean.FALSE);
        return;
    }

    @Override // com.larus.platform.api.f4
    public final void c(BulletContainerView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        FLogger.f375446a.i("LotteryLynxWarmer", "[onRuntimeReady]");
    }

    @Override // com.larus.platform.api.f4
    public final void d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        FLogger.f375446a.i("LotteryLynxWarmer", "[onViewCreate]");
    }

    @Override // com.larus.platform.api.f4
    public final void e(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        FLogger.f375446a.e("LotteryLynxWarmer", "[onLoadFail]", r100);
        if (this.f373506a.isCompleted() == true) goto L6;
        this.f373506a.complete(Boolean.FALSE);
        return;
    }

    @Override // com.larus.platform.api.f4
    public final void onLoadSuccess(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        FLogger.f375446a.i("LotteryLynxWarmer", "[onLoadSuccess]");
        if (this.f373506a.isCompleted() == true) goto L6;
        this.f373506a.complete(Boolean.TRUE);
        return;
    }
}
