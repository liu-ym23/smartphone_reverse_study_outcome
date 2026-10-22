package com.larksuite.framework.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes24.dex */
public class KeyboardUtils {
    private static volatile int KEYBOARD_HEIGHT;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f285894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<Context> f285895b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WeakReference<View> f285896c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f285897d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Handler f285898e;

        public final void a() {
            Context r100 = this.f285895b.get();
            View r101 = this.f285896c.get();
            if (r100 == null) goto L29;
            if (r101 == null) goto L30;
            int r102 = this.f285894a - 1;
            this.f285894a = r102;
            if (r102 >= 0) goto L9;
            return;
        L9:
            if (this.f285897d == true) goto L13;
            Boolean r103 = ExternalKeyboardUtils.f285887a;
            if (ExternalKeyboardUtils.b(false) == false) goto L13;
            return;
        L13:
            InputMethodManager r104 = (InputMethodManager) r100.getSystemService("input_method");
            if (r101.isFocusable() == true) goto L16;
        L25:
            Log.d("ShowKeyboardRunnable", "focusable = " + r101.isFocusable() + ", focusableInTouchMode = " + r101.isFocusableInTouchMode());
            return;
        L16:
            if (r101.isFocusableInTouchMode() == false) goto L25;
            if (r101.requestFocus() == true) goto L22;
            Log.d("ShowKeyboardRunnable", "Cannot focus on view");
            this.f285898e.postDelayed(this, 100);
            return;
        L22:
            if (r104.showSoftInput(r101, 0) == true) goto L28;
            Log.d("ShowKeyboardRunnable", "Unable to show keyboard");
            this.f285898e.postDelayed(this, 100);
            return;
        L28:
            return;
        L30:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Context r100, View r101, boolean r102) {
            this.f285894a = 5;
            this.f285895b = new WeakReference(r100);
            this.f285896c = new WeakReference(r101);
            this.f285897d = r102;
            this.f285898e = new Handler(Looper.getMainLooper());
        }
    }

    public KeyboardUtils() {
    }

    public static View INVOKEVIRTUAL_com_larksuite_framework_utils_KeyboardUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static int getKeyboardHeight(Context r100) {
        if (KEYBOARD_HEIGHT != 0) goto L5;
        if (r100 == null) goto L8;
        int r101 = UIUtils.dp2px(r100, 236.0f);
    L10:
        if (r101 < KEYBOARD_HEIGHT) goto L13;
        return r101;
    L13:
        return KEYBOARD_HEIGHT;
    L8:
        r101 = TTVideoEngineInterface.PLAYER_OPTION_ENABLE_TEXTURE_RENDER_NO_RENDER_CHECK;
        goto L10
    L5:
        return KEYBOARD_HEIGHT;
    }

    public static int getSoftButtonsBarHeight(Activity r100) {
        DisplayMetrics r101 = new DisplayMetrics();
        r100.getWindowManager().getDefaultDisplay().getMetrics(r101);
        int r102 = r101.heightPixels;
        r100.getWindowManager().getDefaultDisplay().getRealMetrics(r101);
        int r103 = r101.heightPixels;
        if (r103 > r102) goto L5;
        return 0;
    L5:
        return r103 - r102;
    }

    public static void hideKeyboard(Context r100) {
        if (UIUtils.getActivityFromContext(r100) != null) goto L5;
        return;
    L5:
        Activity r101 = UIUtils.getActivityFromContext(r100);
        if (r101 == null) goto L15;
        InputMethodManager r102 = (InputMethodManager) r100.getSystemService("input_method");
        if (r102 != null) goto L10;
        return;
    L10:
        if (r102.isActive() == true) goto L12;
        return;
    L12:
        if (r101.getCurrentFocus() == null) goto L18;
        r102.hideSoftInputFromWindow(r101.getCurrentFocus().getWindowToken(), 0);
        return;
    L18:
        return;
    }

    public static boolean isSoftShowing(Activity r100) {
        int r101 = INVOKEVIRTUAL_com_larksuite_framework_utils_KeyboardUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getHeight();
        Rect r102 = new Rect();
        INVOKEVIRTUAL_com_larksuite_framework_utils_KeyboardUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getWindowVisibleDisplayFrame(r102);
        if (((r101 - r102.bottom) - getSoftButtonsBarHeight(r100)) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void setKeyboardHeight(int r100) {
        if (KEYBOARD_HEIGHT == r100) goto L6;
        KEYBOARD_HEIGHT = r100;
        return;
    }

    public static void showKeyboard(Context r100) {
        if (UIUtils.getActivityFromContext(r100) != null) goto L5;
        return;
    L5:
        Activity r101 = UIUtils.getActivityFromContext(r100);
        if (r101 == null) goto L13;
        InputMethodManager r102 = (InputMethodManager) r101.getSystemService("input_method");
        View r103 = r101.getCurrentFocus();
        if (r103 != null) goto L10;
        r103 = new View(r101);
    L10:
        if (r102 == null) goto L14;
        r102.showSoftInputFromInputMethod(r103.getWindowToken(), 0);
        r102.toggleSoftInput(0, 2);
        return;
    L14:
        return;
    }

    public static void showKeyboardIgnoreExternalKeyboardCheck(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        a r101 = new a(r100.getContext(), r100, true);
        r101.f285898e.post(r101);
    }

    public static void showKeyboard(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        a r101 = new a(r100.getContext(), r100, false);
        r101.f285898e.post(r101);
    }

    public static void hideKeyboard(Context r100, View r101) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L11;
        InputMethodManager r102 = (InputMethodManager) r100.getSystemService("input_method");
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.isActive() == false) goto L13;
        r102.hideSoftInputFromWindow(r101.getWindowToken(), 0);
        return;
    L13:
        return;
    L11:
        return;
    }

    public static void hideKeyboardUseCompat(Context r100, View r101) {
        if (r100 == null) goto L17;
        if (r101 != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 30) goto L10;
        WindowInsetsController r102 = r101.getWindowInsetsController();
        if (r102 == null) goto L16;
        r102.hide(WindowInsets.Type.ime());
        return;
    L16:
        return;
    L10:
        Activity r103 = UIUtils.getActivityFromContext(r100);
        if (r103 == null) goto L19;
        WindowInsetsControllerCompat r104 = WindowCompat.getInsetsController(r103.getWindow(), r101);
        if (r104 == null) goto L20;
        r104.hide(WindowInsetsCompat.Type.ime());
        return;
    L20:
        return;
    L19:
        return;
    }
}
