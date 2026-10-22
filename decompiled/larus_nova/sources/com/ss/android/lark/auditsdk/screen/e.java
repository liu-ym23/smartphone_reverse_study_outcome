package com.ss.android.lark.auditsdk.screen;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import com.ss.android.lark.log.Log;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f409576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f409577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f409578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f409579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f409580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f409581f;

    public static final class a {
    }

    static {
    }

    public e(Function0 r100) {
        Intrinsics.checkNotNullParameter("officesdk", "scene");
        Intrinsics.checkNotNullParameter(r100, "onScreenRecordingVisible");
        this.f409576a = "officesdk";
        this.f409577b = r100;
        this.f409578c = new Handler(Looper.getMainLooper());
        this.f409579d = new f(this);
        this.f409581f = -1;
    }

    public final void a(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (Build.VERSION.SDK_INT >= 35) goto L6;
        return;
    L6:
        if (this.f409580e == null) goto L8;
        return;
    L8:
        WindowManager r101 = (WindowManager) r100.getSystemService(WindowManager.class);
        if (r101 == null) goto L23;
        g r102 = new g(this);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
        r101.addScreenRecordingCallback(this.f409579d, r102);     // Catch: Throwable -> L14
        this.f409580e = r102;     // Catch: Throwable -> L14
        this.f409581f = -1;     // Catch: Throwable -> L14
        Log.i("ScreenAuditCore", "[" + this.f409576a + "] screen recording callback registered, activity=" + r100.getClass().getName());     // Catch: Throwable -> L14
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L22;
        Log.e("ScreenAuditCore", "[" + this.f409576a + "] addScreenRecordingCallback failed", r105);
        return;
    L22:
        return;
    L14:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }
}
