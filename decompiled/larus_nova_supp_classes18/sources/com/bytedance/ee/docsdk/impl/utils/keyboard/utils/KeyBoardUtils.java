package com.bytedance.ee.docsdk.impl.utils.keyboard.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.ResultReceiver;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class KeyBoardUtils {
    private static final String TAG = "KeyBoardUtils";
    private static final List<KeyboardEventInterceptor> mKeyboardEventInterceptors = null;

    public KeyBoardUtils() {
    }

    static {
        mKeyboardEventInterceptors = new ArrayList();
    }

    public static int getKeyboardEventSize() {
        return mKeyboardEventInterceptors.size();
    }

    public static void removeAllKeyboardEvent() {
        mKeyboardEventInterceptors.clear();
    }

    public static View INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_keyboard_utils_KeyBoardUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void addKeyboardEventInterceptor(KeyboardEventInterceptor r2) {
        List<KeyboardEventInterceptor> r0 = mKeyboardEventInterceptors;
        if (r0.contains(r2) == true) goto L6;
        r0.add(r2);
        return;
    }

    public static void disableShowSoftInput(EditText r1) {
        controlEditTextShowSoftInput(r1, false);
    }

    private static int getSoftButtonsBarHeight(View r3) {
        if (r3 == null) goto L10;
        WindowManager r4 = (WindowManager) r3.getContext().getSystemService("window");
        DisplayMetrics r1 = new DisplayMetrics();
        if (r4 == null) goto L11;
        Display r5 = r4.getDefaultDisplay();
        r5.getMetrics(r1);
        int r2 = r1.heightPixels;
        int r6 = getRealMetricsHeight(r5, r1, r2);
        if (r6 > r2) goto L9;
        return 0;
    L9:
        return r6 - r2;
    L11:
        return 0;
    L10:
        return 0;
    }

    public static void hideKeyboard(View r4) {
        if (r4 != null) goto L6;
        Log.e(TAG, "hideKeyboard view null", new IllegalArgumentException());
        return;
    L6:
        Iterator<KeyboardEventInterceptor> r1 = mKeyboardEventInterceptors.iterator();
    L8:
        if (r1.hasNext() == false) goto L13;
        KeyboardEventInterceptor r2 = r1.next();
        if (r2.interceptKeyboardEvent() == false) goto L8;
        Log.i(TAG, "intercept hideKeyboard event: " + r2);
        return;
    L13:
        Log.i(TAG, "hideKeyboard ");
        InputMethodManager r3 = (InputMethodManager) r4.getContext().getSystemService("input_method");
        if (r3 == null) goto L27;
    L19:
        e = move-exception;
        Log.i(TAG, "hideKeyboard err = " + e.getMessage());
        return;
    L16:
        if (r3.isActive() == false) goto L28;
        Log.i(TAG, "hideKeyboard  view.getWindowToken() =" + r4.getWindowToken());     // Catch: Exception -> L19
        Log.i(TAG, "hideKeyboard hideSoftInputFromWindow result =" + r3.hideSoftInputFromWindow(r4.getWindowToken(), 0));     // Catch: Exception -> L19
        return;
    L28:
        return;
    }

    public static boolean isKeyBoardShowing(View r3) {
        if (r3 == null) goto L10;
        WindowManager r1 = (WindowManager) r3.getContext().getSystemService("window");
        DisplayMetrics r2 = new DisplayMetrics();
        if (r1 == null) goto L11;
        r1.getDefaultDisplay().getMetrics(r2);
        int r4 = r2.heightPixels;
        Rect r5 = new Rect();
        r3.getWindowVisibleDisplayFrame(r5);
        if (((r4 - r5.bottom) - getSoftButtonsBarHeight(r3)) <= 0) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    L10:
        return false;
    }

    public static void removeKeyboardEventInterceptor(KeyboardEventInterceptor r1) {
        mKeyboardEventInterceptors.remove(r1);
    }

    public static void requestFocus(View r1) {
        if (r1.requestFocus() == true) goto L6;
        r1.setFocusableInTouchMode(true);
        r1.setFocusable(true);
        r1.requestFocus();
        return;
    }

    public static void resetShowSoftInput(EditText r1) {
        controlEditTextShowSoftInput(r1, true);
    }

    public static void showKeyboard(Context r2) {
        if ((r2 instanceof Activity) == true) goto L6;
        Log.e(TAG, "showKeyboard context not activity", new IllegalArgumentException());
        return;
    L6:
        showKeyboard(((Activity) r2).getCurrentFocus());
    }

    public static void hideKeyboard(Context r2) {
        if ((r2 instanceof Activity) == true) goto L6;
        Log.e(TAG, "hideKeyboard context not activity", new IllegalArgumentException());
        return;
    L6:
        hideKeyboard(INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_keyboard_utils_KeyBoardUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(((Activity) r2).getWindow()));
    }

    public static boolean isKeyBoardShowing(Activity r0) {
        if (r0 != null) goto L4;
        return false;
    L4:
        return isKeyBoardShowing(INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_keyboard_utils_KeyBoardUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r0.getWindow()).getRootView());
    }

    public static void showKeyboard(View r1) {
        showKeyboard(r1, null);
    }

    public static void controlEditTextShowSoftInput(EditText r8, boolean r9) {
        Method r3 = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});     // Catch: Exception -> L5
        r3.setAccessible(true);     // Catch: Exception -> L5
        r3.invoke(r8, new Object[]{Boolean.valueOf(r9)});     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.d(TAG, "disableShowSoftInput fail, error: " + e.toString());
        Method r0 = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});     // Catch: Exception -> L9
        r0.setAccessible(true);     // Catch: Exception -> L9
        r0.invoke(r8, new Object[]{Boolean.valueOf(r9)});     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        Log.d(TAG, "disableShowSoftInput fail, error: " + e.toString());
    }

    public static void setPopupWindowType(PopupWindow r2, int r3) {
        Field r0 = PopupWindow.class.getDeclaredField("mWindowLayoutType");     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        r0.set(r2, Integer.valueOf(r3));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, e.toString());
    }

    public static void showKeyboard(View r4, ResultReceiver r5) {
        if (r4 != null) goto L6;
        Log.e(TAG, "showKeyboard view null", new IllegalArgumentException());
        return;
    L6:
        Iterator<KeyboardEventInterceptor> r1 = mKeyboardEventInterceptors.iterator();
    L8:
        if (r1.hasNext() == false) goto L13;
        KeyboardEventInterceptor r2 = r1.next();
        if (r2.interceptKeyboardEvent() == false) goto L8;
        Log.i(TAG, "intercept showKeyboard event: " + r2);
        return;
    L13:
        Log.i(TAG, "showKeyboard ");
        InputMethodManager r0 = (InputMethodManager) r4.getContext().getSystemService("input_method");
        if (r0 == null) goto L23;
        requestFocus(r4);
        if (r5 == null) goto L18;
        r0.showSoftInput(r4, 1, new KeyboardResultReceiver(r5, null));
        return;
    L18:
        r0.showSoftInput(r4, 1, null);
        return;
    }

    private static int getRealMetricsHeight(Display r6, DisplayMetrics r7, int r8) {
        r6.getClass().getDeclaredMethod("getRealMetrics", new Class[]{r7.getClass()}).invoke(r6, new Object[]{r7});     // Catch: Exception -> L4
        return r7.heightPixels;
    L4:
        return r8;
    }
}
