package com.larus.utils;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i0 f375410a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f375411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f375412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f375413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f375414e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f375415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Rect f375416g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f375417h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f375418i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f375419j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f375420k;

    public static final class a implements f09.a.b {
        public a() {
        }

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppForeground() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            FLogger.f375446a.i("ResourceCache", "onAppBackground: reset some cache");
            i0.f375415f = -1;
        }
    }

    public i0() {
    }

    static {
        f375410a = new i0();
        f375411b = -1;
        f375412c = -1;
        f375413d = -1;
        f375414e = -1;
        f375415f = -1;
        f375416g = new Rect();
        f375419j = -1;
        AppHost.f326268a.a().j(new a());
    }

    public static int e() {
        int r100 = f375415f;
        int r101 = -1;
        if (r100 <= (-1)) goto L5;
        return r100;
    L5:
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
        if (Build.VERSION.SDK_INT < 30) goto L11;
        Object r104 = AppHost.f326268a.getApplication().getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.view.WindowManager");     // Catch: Throwable -> L14
        int r105 = ((WindowManager) r104).getCurrentWindowMetrics().getWindowInsets().getInsets(WindowInsets.Type.navigationBars()).bottom;     // Catch: Throwable -> L14
        if (r105 <= 0) goto L11;
        FLogger.f375446a.i("ResourceCache", "getNavBarHeight use window insets: " + r105);     // Catch: Throwable -> L14
        Integer r106 = Integer.valueOf(r105);     // Catch: Throwable -> L14
    L12:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L14
    L16:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L20;
        FLogger.f375446a.w("ResourceCache", "getNavBarHeight failed: " + r108.getMessage(), r108);
    L20:
        if (Result.m9455isFailureimpl(r107) == true) goto L23;
        r102 = r107;
    L23:
        Integer r109 = (Integer) r102;
        if (r109 == null) goto L27;
        int r110 = r109.intValue();
    L30:
        f375415f = r110;
        return r110;
    L27:
        if (f() <= 0) goto L29;
        r101 = AppHost.f326268a.getApplication().getResources().getDimensionPixelSize(f());
    L29:
        r110 = r101;
    L11:
        r106 = null;
    L14:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public static int f() {
        int r100 = f375411b;
        if (r100 <= 0) goto L5;
        return r100;
    L5:
        int r101 = AppHost.f326268a.getApplication().getResources().getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        f375411b = r101;
        return r101;
    }

    public static int g() {
        int r100 = f375414e;
        int r101 = -1;
        if (r100 <= (-1)) goto L6;
        return r100;
    L6:
        if (h() <= 0) goto L8;
        r101 = AppHost.f326268a.getApplication().getResources().getDimensionPixelSize(h());
    L8:
        f375414e = r101;
        return r101;
    }

    public static int h() {
        int r100 = f375412c;
        if (r100 <= 0) goto L5;
        return r100;
    L5:
        int r101 = AppHost.f326268a.getApplication().getResources().getIdentifier("status_bar_height", "dimen", "android");
        f375412c = r101;
        return r101;
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static int b(FragmentActivity r100) {
        f375418i = true;
        Rect r101 = f375416g;
        r101.setEmpty();
        a(r100.getWindow()).getWindowVisibleDisplayFrame(r101);
        int r102 = r101.height();
        int r103 = m0.a(r100) - g();
        if (r103 <= 0) goto L13;
        if (r102 <= 0) goto L13;
        int r104 = Math.max(r103 - r102, -1);
        if (r104 <= 0) goto L9;
        int r105 = r104;
    L10:
        f375419j = r105;
        return r104;
    L9:
        r105 = 0;
    L13:
        return f375413d;
    }

    public static int c(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        boolean r101 = false;
        if (f375418i == false) goto L11;
        int r102 = f375413d;
        if (r102 <= (-1)) goto L11;
        if (f375417h == false) goto L11;
        return Math.max(r102, 0);
    L11:
        if (Build.VERSION.SDK_INT < 30) goto L17;
        WindowInsets r103 = a(r100.getWindow()).getRootWindowInsets();
        if (r103 != null) goto L15;
    L22:
        boolean r104 = false;
    L24:
        if (r104 == true) goto L32;
        String r105 = f375420k;
        if (r105 != null) goto L28;
    L30:
        f375420k = r100.getClass().getSimpleName();
        FLogger.f375446a.d("ResourceCache", "calculateNavBarHeight, but should not cache it, activity:" + r100.getClass().getSimpleName() + ' ');
        return b(r100);
    L28:
        if (Intrinsics.areEqual(r105, r100.getClass().getSimpleName()) == true) goto L30;
    L32:
        Integer r106 = null;
        f375420k = null;
        Integer r107 = Integer.valueOf(b(r100));
        if (r107.intValue() < 0) goto L35;
        r101 = true;
    L35:
        if (r101 == false) goto L37;
        r106 = r107;
    L37:
        if (r106 == null) goto L39;
        f375413d = r106.intValue();
    L39:
        FLogger.f375446a.d("ResourceCache", "calculateNavBarHeight:" + f375413d + ",activity:" + r100.getClass().getSimpleName() + ' ');
        return f375413d;
    L15:
        if (r103.isVisible(WindowInsets.Type.navigationBars()) != true) goto L22;
    L21:
        r104 = true;
        goto L24
    L17:
        WindowInsetsCompat r108 = ViewCompat.getRootWindowInsets(a(r100.getWindow()));
        if (r108 == null) goto L22;
        if (r108.isVisible(WindowInsetsCompat.Type.navigationBars()) != true) goto L22;
        goto L21
    }

    public static void d(boolean r100) {
        f375417h = r100;
        if (r100 == true) goto L5;
        return;
    L5:
        if (f375419j != (-1)) goto L9;
        f375419j = e();
        return;
    }

    public static void i(final WeakReference r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        FragmentActivity r101 = (FragmentActivity) r100.get();
        if (r101 == null) goto L10;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L11;
        View r103 = a(r102);
        if (r103 == null) goto L12;
        ViewCompat.setOnApplyWindowInsetsListener(r103, new h0(r100));
        return;
    L12:
        return;
    L11:
        return;
    }
}
