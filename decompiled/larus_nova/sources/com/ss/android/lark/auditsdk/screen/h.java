package com.ss.android.lark.auditsdk.screen;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f409584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Long> f409585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Activity, Unit> f409586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakHashMap<Activity, Activity.ScreenCaptureCallback> f409587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f409588e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f409589f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f409590g;

    public static final class a {
    }

    static {
    }

    public final void a(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (Build.VERSION.SDK_INT >= 34) goto L6;
        return;
    L6:
        if (this.f409587d.containsKey(r100) == true) goto L20;
        j r101 = new j(new WeakReference(r100), this);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        r100.registerScreenCaptureCallback(this.f409589f, r101);     // Catch: Throwable -> L11
        this.f409587d.put(r100, r101);     // Catch: Throwable -> L11
        Log.i("ScreenAuditCore", "[" + this.f409584a + "] screenshot callback registered, activity=" + r100.getClass().getName());     // Catch: Throwable -> L11
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L19;
        Log.e("ScreenAuditCore", "[" + this.f409584a + "] register screenshot callback failed", r104);
        return;
    L19:
        return;
    L11:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public final void b(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return;
    L5:
        Activity.ScreenCaptureCallback r101 = this.f409587d.remove(r100);
        if (r101 == null) goto L19;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        r100.unregisterScreenCaptureCallback(r101);     // Catch: Throwable -> L10
        Log.i("ScreenAuditCore", "[" + this.f409584a + "] screenshot callback unregistered, activity=" + r100.getClass().getName());     // Catch: Throwable -> L10
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L18;
        Log.e("ScreenAuditCore", "[" + this.f409584a + "] unregister screenshot callback failed", r104);
        return;
    L18:
        return;
    L10:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public h(Function0 r100, Function1 r101) {
        Intrinsics.checkNotNullParameter("officesdk", "scene");
        Intrinsics.checkNotNullParameter(r100, "dedupWindowMsProvider");
        Intrinsics.checkNotNullParameter(r101, "onScreenCaptured");
        this.f409584a = "officesdk";
        this.f409585b = r100;
        this.f409586c = r101;
        this.f409587d = new WeakHashMap();
        this.f409588e = new Handler(Looper.getMainLooper());
        this.f409589f = new i(this);
    }
}
