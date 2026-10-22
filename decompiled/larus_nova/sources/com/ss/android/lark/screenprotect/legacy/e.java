package com.ss.android.lark.screenprotect.legacy;

import android.app.Activity;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Deprecated(message = "no need for user scope")
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f439794a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f439795b = null;

    public static final class a extends com.ss.android.lark.appcontext.applifecycle.a {
        public a() {
        }

        @Override // com.ss.android.lark.appcontext.applifecycle.a, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            int r101 = ScsLogger.f440428a;
            ScsLogger.d("ScreenshotProtection", "onActivityPaused: current activity is " + r100);
            if (Intrinsics.areEqual(SwitchData.f439788a.getValue(), Boolean.FALSE) == true) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(SwitchData.f439789b.getValue(), Boolean.TRUE) == false) goto L9;
            r100.getWindow().addFlags(8192);
            ScsLogger.d("ScreenshotProtection", "onActivityPaused: vc share screen and admin ban screenshot ,add flag");
            return;
        }

        @Override // com.ss.android.lark.appcontext.applifecycle.a, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            int r101 = ScsLogger.f440428a;
            ScsLogger.d("ScreenshotProtection", "onActivityResumed: current activity is " + r100);
            int r102 = r100.getIntent().getIntExtra("SCS_FLAG_STATE", FlagState.None.getValue());
            if (r102 != FlagState.Original.getValue()) goto L5;
        L9:
            ScsLogger.d("ScreenshotProtection", "onActivityResumed: scs is not allowed to clear flag");
            return;
        L5:
            if (r102 == FlagState.Ban.getValue()) goto L9;
            r100.getWindow().clearFlags(8192);
            ScsLogger.d("ScreenshotProtection", "onActivityResumed: clear flag done");
        }
    }

    public static final class b extends com.ss.android.lark.appcontext.applifecycle.a {
        public b() {
        }

        @Override // com.ss.android.lark.appcontext.applifecycle.a, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            int r101 = ScsLogger.f440428a;
            ScsLogger.d("ScreenshotProtection", "onActivityResumed: current activity is " + r100);
            int r102 = r100.getIntent().getIntExtra("SCS_FLAG_STATE", FlagState.None.getValue());
            if (r102 != FlagState.Original.getValue()) goto L5;
        L9:
            ScsLogger.d("ScreenshotProtection", "onActivityResumed: scs is not allowed to add flag");
            return;
        L5:
            if (r102 == FlagState.Allow.getValue()) goto L9;
            r100.getWindow().addFlags(8192);
            ScsLogger.d("ScreenshotProtection", "onActivityResumed: add flag");
        }
    }

    static {
        f439794a = new b();
        f439795b = new a();
    }

    public static void a(boolean r100) {
        if (r100 == false) goto L13;
        Activity r101 = AppLifecycle.a.f408803a.f();
        if (r101 == null) goto L13;
        int r102 = r101.getIntent().getIntExtra("SCS_FLAG_STATE", FlagState.None.getValue());
        if (r102 != FlagState.Original.getValue()) goto L9;
    L12:
        ScsLogger.d("ScreenshotProtection", "MonitorActivity.allowScreenshots: scs is not allowed to clear flag");
        goto L13
    L9:
        if (r102 == FlagState.Ban.getValue()) goto L12;
        r101.getWindow().clearFlags(8192);
        ScsLogger.d("ScreenshotProtection", "MonitorActivity.allowScreenshots: topActivity clear flags done");
    L13:
        AppLifecycle r103 = AppLifecycle.a.f408803a;
        r103.j(f439794a);
        r103.b(f439795b);
        MutableLiveData<Boolean> r104 = SwitchData.f439788a;
        ScsLogger.d("ScreenshotProtection", "allowScreenshots: done");
    }
}
