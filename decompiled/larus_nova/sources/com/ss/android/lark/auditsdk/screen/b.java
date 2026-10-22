package com.ss.android.lark.auditsdk.screen;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.view.WindowManager;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f409565j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f409566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f409567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Long> f409568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f409569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Application f409570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference<Activity> f409571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h f409572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f409573h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f409574i;

    public static final class a {
    }

    static {
    }

    public final void a(Application r100) {
        Application r101 = this.f409570e;
        if (r101 == null) goto L7;
        r100 = r101;
    L7:
        if (this.f409569d == false) goto L19;
        if (r100 != null) goto L58;
        Log.e("ScreenAuditCore", "[" + this.f409566a + "] application is null, cannot unregister lifecycle");
    L18:
        this.f409569d = false;
        Log.i("ScreenAuditCore", "[" + this.f409566a + "] coordinator stopped");
        goto L19
    L58:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        r100.unregisterActivityLifecycleCallbacks(this.f409574i);     // Catch: Throwable -> L12
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L17;
        Log.e("ScreenAuditCore", "[" + this.f409566a + "] unregister lifecycle failed", r104);
    L17:
        Result.m9448boximpl(r103);
    L12:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L19:
        h r106 = this.f409572g;
        r106.getClass();
        if (Build.VERSION.SDK_INT < 34) goto L34;
        Iterator r107 = new HashMap(r106.f409587d).entrySet().iterator();
    L24:
        if (r107.hasNext() == false) goto L33;
        Map.Entry r108 = (Map.Entry) r107.next();
        Activity r109 = (Activity) r108.getKey();
        Activity.ScreenCaptureCallback r110 = (Activity.ScreenCaptureCallback) r108.getValue();
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L28
        r109.unregisterScreenCaptureCallback(r110);     // Catch: Throwable -> L28
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L30:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L24;
        Log.e("ScreenAuditCore", "[" + r106.f409584a + "] unregister screenshot callback failed", r113);
    L28:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    L33:
        r106.f409587d.clear();
    L34:
        e r115 = this.f409573h;
        if (Build.VERSION.SDK_INT >= 35) goto L37;
        r115.getClass();
    L54:
        this.f409571f = null;
        this.f409570e = null;
        return;
    L37:
        g r116 = r115.f409580e;
        if (r116 == null) goto L54;
        if (r100 == null) goto L42;
        WindowManager r117 = (WindowManager) r100.getSystemService(WindowManager.class);
    L44:
        if (r117 != null) goto L62;
    L53:
        r115.f409580e = null;
        r115.f409581f = -1;
        goto L54
    L62:
        r117.removeScreenRecordingCallback(r116);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        Log.e("ScreenAuditCore", "[" + r115.f409576a + "] removeScreenRecordingCallback failed", th);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        r115.f409580e = null;
        r115.f409581f = -1;
        throw th;
    L42:
        r117 = null;
        goto L44
    }

    public b(d r100, Function0 r101) {
        Intrinsics.checkNotNullParameter("officesdk", "scene");
        Intrinsics.checkNotNullParameter(r100, "reporter");
        Intrinsics.checkNotNullParameter(r101, "dedupWindowMsProvider");
        this.f409566a = "officesdk";
        this.f409567b = r100;
        this.f409568c = r101;
        this.f409572g = new h(r101, new ScreenAuditCoordinator$screenshotManager$1(this));
        this.f409573h = new e(new ScreenAuditCoordinator$recordingManager$1(this));
        this.f409574i = new c(this);
    }
}
