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
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
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

    public static View INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_keyboard_utils_KeyBoardUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void addKeyboardEventInterceptor(KeyboardEventInterceptor r100) {
        List<KeyboardEventInterceptor> r101 = mKeyboardEventInterceptors;
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);
        return;
    }

    public static void disableShowSoftInput(EditText r100) {
        controlEditTextShowSoftInput(r100, false);
    }

    private static int getSoftButtonsBarHeight(View r100) {
        if (r100 == null) goto L10;
        WindowManager r101 = (WindowManager) r100.getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r102 = new DisplayMetrics();
        if (r101 == null) goto L11;
        Display r103 = r101.getDefaultDisplay();
        r103.getMetrics(r102);
        int r104 = r102.heightPixels;
        int r105 = getRealMetricsHeight(r103, r102, r104);
        if (r105 > r104) goto L9;
        return 0;
    L9:
        return r105 - r104;
    L11:
        return 0;
    L10:
        return 0;
    }

    public static void hideKeyboard(View r100) {
        if (r100 != null) goto L6;
        Log.e(TAG, "hideKeyboard view null", new IllegalArgumentException());
        return;
    L6:
        Iterator<KeyboardEventInterceptor> r101 = mKeyboardEventInterceptors.iterator();
    L8:
        if (r101.hasNext() == false) goto L13;
        KeyboardEventInterceptor r102 = r101.next();
        if (r102.interceptKeyboardEvent() == false) goto L8;
        Log.i(TAG, "intercept hideKeyboard event: " + r102);
        return;
    L13:
        Log.i(TAG, "hideKeyboard ");
        InputMethodManager r103 = (InputMethodManager) r100.getContext().getSystemService("input_method");
        if (r103 == null) goto L27;
    L19:
        e = move-exception;
        Log.i(TAG, "hideKeyboard err = " + e.getMessage());
        return;
    L16:
        if (r103.isActive() == false) goto L28;
        Log.i(TAG, "hideKeyboard  view.getWindowToken() =" + r100.getWindowToken());     // Catch: Exception -> L19
        Log.i(TAG, "hideKeyboard hideSoftInputFromWindow result =" + r103.hideSoftInputFromWindow(r100.getWindowToken(), 0));     // Catch: Exception -> L19
        return;
    L28:
        return;
    }

    public static boolean isKeyBoardShowing(View r100) {
        if (r100 == null) goto L10;
        WindowManager r101 = (WindowManager) r100.getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r102 = new DisplayMetrics();
        if (r101 == null) goto L11;
        r101.getDefaultDisplay().getMetrics(r102);
        int r103 = r102.heightPixels;
        Rect r104 = new Rect();
        r100.getWindowVisibleDisplayFrame(r104);
        if (((r103 - r104.bottom) - getSoftButtonsBarHeight(r100)) <= 0) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    L10:
        return false;
    }

    public static void removeKeyboardEventInterceptor(KeyboardEventInterceptor r100) {
        mKeyboardEventInterceptors.remove(r100);
    }

    public static void requestFocus(View r100) {
        if (r100.requestFocus() == true) goto L6;
        r100.setFocusableInTouchMode(true);
        r100.setFocusable(true);
        r100.requestFocus();
        return;
    }

    public static void resetShowSoftInput(EditText r100) {
        controlEditTextShowSoftInput(r100, true);
    }

    public static void showKeyboard(Context r100) {
        if ((r100 instanceof Activity) == true) goto L6;
        Log.e(TAG, "showKeyboard context not activity", new IllegalArgumentException());
        return;
    L6:
        showKeyboard(((Activity) r100).getCurrentFocus());
    }

    public static void hideKeyboard(Context r100) {
        if ((r100 instanceof Activity) == true) goto L6;
        Log.e(TAG, "hideKeyboard context not activity", new IllegalArgumentException());
        return;
    L6:
        hideKeyboard(INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_keyboard_utils_KeyBoardUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(((Activity) r100).getWindow()));
    }

    public static boolean isKeyBoardShowing(Activity r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        return isKeyBoardShowing(INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_keyboard_utils_KeyBoardUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getRootView());
    }

    public static void showKeyboard(View r100) {
        showKeyboard(r100, null);
    }

    public static void controlEditTextShowSoftInput(EditText r100, boolean r101) {
        Method r102 = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});     // Catch: Exception -> L5
        r102.setAccessible(true);     // Catch: Exception -> L5
        r102.invoke(r100, new Object[]{Boolean.valueOf(r101)});     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.d(TAG, "disableShowSoftInput fail, error: " + e.toString());
        Method r103 = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});     // Catch: Exception -> L9
        r103.setAccessible(true);     // Catch: Exception -> L9
        r103.invoke(r100, new Object[]{Boolean.valueOf(r101)});     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        Log.d(TAG, "disableShowSoftInput fail, error: " + e.toString());
    }

    public static void setPopupWindowType(PopupWindow r100, int r101) {
        Field r102 = PopupWindow.class.getDeclaredField("mWindowLayoutType");     // Catch: Exception -> L4
        r102.setAccessible(true);     // Catch: Exception -> L4
        r102.set(r100, Integer.valueOf(r101));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, e.toString());
    }

    public static void showKeyboard(View r100, ResultReceiver r101) {
        if (r100 != null) goto L6;
        Log.e(TAG, "showKeyboard view null", new IllegalArgumentException());
        return;
    L6:
        Iterator<KeyboardEventInterceptor> r102 = mKeyboardEventInterceptors.iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        KeyboardEventInterceptor r103 = r102.next();
        if (r103.interceptKeyboardEvent() == false) goto L8;
        Log.i(TAG, "intercept showKeyboard event: " + r103);
        return;
    L13:
        Log.i(TAG, "showKeyboard ");
        InputMethodManager r104 = (InputMethodManager) r100.getContext().getSystemService("input_method");
        if (r104 == null) goto L23;
        requestFocus(r100);
        if (r101 == null) goto L18;
        r104.showSoftInput(r100, 1, new KeyboardResultReceiver(r101, null));
        return;
    L18:
        r104.showSoftInput(r100, 1, null);
        return;
    }

    private static int getRealMetricsHeight(Display r100, DisplayMetrics r101, int r102) {
        r100.getClass().getDeclaredMethod("getRealMetrics", new Class[]{r101.getClass()}).invoke(r100, new Object[]{r101});     // Catch: Exception -> L4
        return r101.heightPixels;
    L4:
        return r102;
    }
}
