package com.ss.android.lark.integrator.security.compliance.screen_audit;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.log.Log;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f428123d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.integrator.security.compliance.screen_audit.a f428124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f428125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f428126c;

    public static final class a {
    }

    static {
    }

    public b(com.ss.android.lark.integrator.security.compliance.screen_audit.a r100) {
        Intrinsics.checkNotNullParameter(r100, "reporter");
        this.f428124a = r100;
        this.f428126c = -1;
    }

    public final void a(Application r100) {
        if (Build.VERSION.SDK_INT >= 35) goto L5;
        return;
    L5:
        c r101 = this.f428125b;
        if (r101 != null) goto L9;
    L20:
        Log.i("OfficeSDKScreenAudit", "all recording callbacks cleaned");
        return;
    L9:
        if (r100 == null) goto L11;
        WindowManager r102 = (WindowManager) r100.getSystemService(WindowManager.class);
    L13:
        if (r102 != null) goto L27;
        this.f428125b = null;
        this.f428126c = -1;
        Log.w("OfficeSDKScreenAudit", "cannot resolve WindowManager when unregistering");
        goto L20
    L27:
        r102.removeScreenRecordingCallback(r101);     // Catch: Throwable -> L17
        Log.i("OfficeSDKScreenAudit", "recording callback unregistered");     // Catch: Throwable -> L17
    L19:
        this.f428125b = null;
        this.f428126c = -1;
    L17:
        th = move-exception;
        Log.e("OfficeSDKScreenAudit", "removeScreenRecordingCallback failed", th);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        this.f428125b = null;
        this.f428126c = -1;
        throw th;
    L11:
        r102 = null;
        goto L13
    }

    public final void b(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 35) goto L7;
        Log.i("OfficeSDKScreenAudit", "skip onActivityStarted, device sdk=" + r101 + " < 35 (Android 15)");
        return;
    L7:
        if (this.f428125b == null) goto L9;
        return;
    L9:
        WindowManager r102 = (WindowManager) r100.getSystemService(WindowManager.class);
        if (r102 == null) goto L20;
        Executor r103 = ContextCompat.getMainExecutor(r100);
        c r104 = new c(this);
        r102.addScreenRecordingCallback(r103, r104);     // Catch: Throwable -> L15
        this.f428125b = r104;     // Catch: Throwable -> L15
        this.f428126c = -1;     // Catch: Throwable -> L15
        Log.i("OfficeSDKScreenAudit", "recording callback registered via ".concat(r100.getClass().getSimpleName()));     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        Log.e("OfficeSDKScreenAudit", "addScreenRecordingCallback failed", th);
        return;
    }
}
