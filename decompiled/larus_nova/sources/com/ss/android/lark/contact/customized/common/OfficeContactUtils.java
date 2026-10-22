package com.ss.android.lark.contact.customized.common;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.contact.base.entity.mobile.util.ContactMobileUtils;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.f;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes35.dex */
public final class OfficeContactUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f418960a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f418961b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f418962c = null;

    public static int b(char r100) {
        if (r100 != ' ') goto L5;
        return 36;
    L5:
        boolean r101 = false;
        if ('a' <= r100) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L14;
        return 35 - (r100 - 'a');
    L14:
        if ('0' <= r100) goto L16;
    L18:
        if (r101 == true) goto L24;
        return -1;
    L24:
        return 9 - (r100 - '0');
    L16:
        if (r100 >= ':') goto L18;
        r101 = true;
        goto L18
    L8:
        if (r100 >= '{') goto L10;
        r102 = true;
        goto L11
    }

    static {
        f418960a = LazyKt.lazy(OfficeContactUtils$profileProtocol$2.INSTANCE);
        f418961b = LazyKt.lazy(OfficeContactUtils$appBaseInfo$2.INSTANCE);
        f418962c = LazyKt.lazy(OfficeContactUtils$tokenService$2.INSTANCE);
    }

    public static boolean f() {
        return ((com.ss.android.lark.passport.dpop.b) f418962c.getValue()).isDoubaoBUser();
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

    public static String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        String r101 = ContactMobileUtils.c(r100);
        boolean r102 = true;
        if (r101.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        char r104 = r101.charAt(0);
    L10:
        if ('A' <= r104) goto L12;
    L14:
        boolean r105 = false;
    L15:
        if (r105 == false) goto L18;
        return String.valueOf(r104);
    L18:
        if ('a' <= r104) goto L20;
    L22:
        r102 = false;
    L23:
        if (r102 == true) goto L28;
        return "#";
    L28:
        return String.valueOf(Character.toUpperCase(r104));
    L20:
        if (r104 >= '{') goto L22;
    L12:
        if (r104 >= '[') goto L14;
        r105 = true;
        goto L15
    L8:
        r104 = '#';
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    public static boolean g(final Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Function0<Unit> r101 = new OfficeContactUtils$requireOfficeSDKInitOrFinish$1(r100);
        if (OfficeSDKManager.isAvailable() == true) goto L5;
        Log.w("Contact_Utils", "office sdk not initialized, finish. ".concat(r100.getClass().getName()));
        r101.invoke();
        return false;
    L5:
        return true;
    }

    public static void e(Fragment r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        f r102 = WindowInsetsUtils.b(r100);
        r102.k(true);
        r102.r(true);
        r102.f(false);
        r102.o(false);
        r102.c(false);
        r102.b(r101);
        FragmentActivity r103 = r100.getActivity();
        if (r103 == null) goto L16;
        WindowInsetsUtils.e(r103);
        WindowCompat.setDecorFitsSystemWindows(r103.getWindow(), false);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L7
        View r105 = a(r103.getWindow());     // Catch: Throwable -> L7
        r103.getWindow().setStatusBarColor(0);     // Catch: Throwable -> L7
        r103.getWindow().setNavigationBarColor(0);     // Catch: Throwable -> L7
        Object r106 = Result.m9449constructorimpl(OneShotPreDrawListener.add(r105, new c(r105, r105)));     // Catch: Throwable -> L7
    L9:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L12;
        Log.e("Contact_Utils", "hideStatusBar failed", r107);
    L12:
        a(r103.getWindow()).setBackgroundColor(r101);
        return;
    L7:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public static float d(View r100, int r101, Rect r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r102, "outRect");
        if (r100.getGlobalVisibleRect(r102) == true) goto L7;
        return 0.0f;
    L7:
        if (r101 != 1) goto L9;
        float r103 = r102.height();
        float r104 = RangesKt.coerceAtLeast(r100.getHeight(), 0.01f);
    L11:
        return r103 / r104;
    L9:
        r103 = r102.width();
        r104 = RangesKt.coerceAtLeast(r100.getWidth(), 0.01f);
        goto L11
    }
}
