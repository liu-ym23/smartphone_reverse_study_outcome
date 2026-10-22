package com.larus.home.impl.ug;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f346317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f346318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f346319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WindowManager.LayoutParams f346320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f346321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f346322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f346323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f346324h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f346325i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f346326j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WindowManager f346327k;

    public static final class a {
    }

    static {
    }

    public final View b() {
        return this.f346317a.asView();
    }

    public final void a(final Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        r100.runOnUiThread(new h(r100, this));     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void c(final Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        r100.runOnUiThread(new i(r100, this));     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void d(int r100) {
        FLogger.f375446a.d("UGReturnFloatingViewController", "[updateViewPosition] newY:" + r100);
        if (r100 <= 0) goto L5;
        this.f346320d.y = r100;
    L5:
        f r101 = this.f346321e;
        WindowManager.LayoutParams r102 = this.f346320d;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "floatingLayoutParams");
        int r103 = r102.y;
        f.b r104 = r101.f346305e;
        r102.y = RangesKt.coerceIn(r103, new IntRange(r104.f346307a, r104.f346308b));
        r102.x = 0;
        if (b().isAttachedToWindow() == false) goto L11;
        WindowManager r105 = this.f346327k;
        if (r105 == null) goto L12;
        r105.updateViewLayout(b(), this.f346320d);
        return;
    L12:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.home.impl.ug.j] */
    public l(UGReturnFloatingView r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "floating");
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.f346317a = r100;
        this.f346318b = r101;
        Context r102 = AppHost.f326268a.getApplication().getApplicationContext();
        this.f346319c = r102;
        WindowManager.LayoutParams r103 = new WindowManager.LayoutParams(-2, -2, 2, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME, -3);
        r103.gravity = 8388659;
        this.f346320d = r103;
        this.f346321e = new f(r102, new j(this));
        this.f346325i = -1;
        b().setOnTouchListener(new k(this));
    }
}
