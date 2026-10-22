package com.ss.android.lark.integrator.security.compliance.screen_audit;

import android.app.Activity;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.integrator.security.compliance.screen_audit.a f428128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakHashMap<Activity, Activity.ScreenCaptureCallback> f428129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f428130c;

    public static final class a {
    }

    static {
    }

    public final void a() {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return;
    L5:
        Iterator r100 = new HashMap(this.f428129b).entrySet().iterator();
    L7:
        if (r100.hasNext() == false) goto L13;
        Map.Entry r101 = (Map.Entry) r100.next();
        Activity r102 = (Activity) r101.getKey();
        Activity.ScreenCaptureCallback r103 = (Activity.ScreenCaptureCallback) r101.getValue();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
        r102.unregisterScreenCaptureCallback(r103);     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    L13:
        this.f428129b.clear();
        Log.i("OfficeSDKScreenAudit", "all screenshot callbacks cleaned");
    }

    public d(com.ss.android.lark.integrator.security.compliance.screen_audit.a r100) {
        Intrinsics.checkNotNullParameter(r100, "reporter");
        this.f428128a = r100;
        this.f428129b = new WeakHashMap();
    }

    public final void b(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 34) goto L7;
        Log.i("OfficeSDKScreenAudit", "skip onActivityStarted, device sdk=" + r101 + " < 34 (Android 14)");
        return;
    L7:
        if (this.f428129b.containsKey(r100) == true) goto L17;
        Executor r102 = ContextCompat.getMainExecutor(r100);
        e r103 = new e(this, r100);
        r100.registerScreenCaptureCallback(r102, r103);     // Catch: Throwable -> L12
        this.f428129b.put(r100, r103);     // Catch: Throwable -> L12
        Log.i("OfficeSDKScreenAudit", "screenshot callback registered for ".concat(r100.getClass().getSimpleName()));     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        Log.e("OfficeSDKScreenAudit", "registerScreenCaptureCallback failed", th);
        return;
    }

    public final void c(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return;
    L5:
        Activity.ScreenCaptureCallback r101 = this.f428129b.remove(r100);
        if (r101 == null) goto L15;
        r100.unregisterScreenCaptureCallback(r101);     // Catch: Throwable -> L10
        Log.i("OfficeSDKScreenAudit", "screenshot callback unregistered for ".concat(r100.getClass().getSimpleName()));     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Log.e("OfficeSDKScreenAudit", "unregisterScreenCaptureCallback failed", th);
        return;
    }
}
