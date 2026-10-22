package rcb;

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
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.edit.keyboard.utils.KeyboardResultReceiver;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<d> f537197a = null;

    static {
        f537197a = new ArrayList();
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

    public static void b(EditText r100) {
        Method r101 = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});     // Catch: Exception -> L5
        r101.setAccessible(true);     // Catch: Exception -> L5
        r101.invoke(r100, new Object[]{Boolean.FALSE});     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.d("KeyBoardUtils", "disableShowSoftInput fail, error: " + e.toString());
        Method r102 = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});     // Catch: Exception -> L9
        r102.setAccessible(true);     // Catch: Exception -> L9
        r102.invoke(r100, new Object[]{Boolean.FALSE});     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        Log.d("KeyBoardUtils", "disableShowSoftInput fail, error: " + e.toString());
    }

    public static void c(Context r100) {
        if ((r100 instanceof Activity) == true) goto L6;
        Log.e("KeyBoardUtils", "hideKeyboard context not activity", new IllegalArgumentException());
        return;
    L6:
        Activity r101 = (Activity) r100;
        if (r101.getWindow() != null) goto L10;
        Log.e("KeyBoardUtils", "hideKeyboard window null", new IllegalArgumentException());
        return;
    L10:
        d(a(r101.getWindow()));
    }

    public static void d(View r100) {
        if (r100 != null) goto L6;
        Log.e("KeyBoardUtils", "hideKeyboard view null", new IllegalArgumentException());
        return;
    L6:
        Iterator r101 = ((ArrayList) f537197a).iterator();
    L8:
        if (r101.hasNext() == false) goto L13;
        d r102 = (d) r101.next();
        if (r102.interceptKeyboardEvent() == false) goto L8;
        Log.i("KeyBoardUtils", "intercept hideKeyboard event: " + r102);
        return;
    L13:
        Log.i("KeyBoardUtils", "hideKeyboard ");
        InputMethodManager r103 = (InputMethodManager) r100.getContext().getSystemService("input_method");
        if (r103 == null) goto L27;
    L19:
        e = move-exception;
        Log.i("KeyBoardUtils", "hideKeyboard err = " + e.getMessage());
        return;
    L16:
        if (r103.isActive() == false) goto L28;
        Log.i("KeyBoardUtils", "hideKeyboard  view.getWindowToken() =" + r100.getWindowToken());     // Catch: Exception -> L19
        Log.i("KeyBoardUtils", "hideKeyboard hideSoftInputFromWindow result =" + r103.hideSoftInputFromWindow(r100.getWindowToken(), 0));     // Catch: Exception -> L19
        return;
    L28:
        return;
    }

    public static boolean e(Activity r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        return f(a(r100.getWindow()).getRootView());
    }

    public static boolean f(View r100) {
        if (r100 == null) goto L21;
        WindowManager r101 = (WindowManager) r100.getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r102 = new DisplayMetrics();
        if (r101 == null) goto L22;
        r101.getDefaultDisplay().getMetrics(r102);
        int r103 = r102.heightPixels;
        Rect r104 = new Rect();
        r100.getWindowVisibleDisplayFrame(r104);
        int r105 = r103 - r104.bottom;
        WindowManager r106 = (WindowManager) r100.getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r107 = new DisplayMetrics();
        if (r106 == null) goto L14;
        Display r108 = r106.getDefaultDisplay();
        r108.getMetrics(r107);
        int r109 = r107.heightPixels;
        r108.getClass().getDeclaredMethod("getRealMetrics", new Class[]{r107.getClass()}).invoke(r108, new Object[]{r107});     // Catch: Exception -> L11
        int r110 = r107.heightPixels;     // Catch: Exception -> L11
    L12:
        if (r110 <= r109) goto L14;
        int r111 = r110 - r109;
    L16:
        if ((r105 - r111) <= 0) goto L23;
        return true;
    L23:
        return false;
    L11:
        r110 = r109;
    L14:
        r111 = 0;
        goto L16
    L22:
        return false;
    L21:
        return false;
    }

    public static void g(Context r100) {
        if ((r100 instanceof Activity) == true) goto L6;
        Log.e("KeyBoardUtils", "showKeyboard context not activity", new IllegalArgumentException());
        return;
    L6:
        h(((Activity) r100).getCurrentFocus(), null);
    }

    public static void h(View r100, ResultReceiver r101) {
        if (r100 != null) goto L6;
        Log.e("KeyBoardUtils", "showKeyboard view null", new IllegalArgumentException());
        return;
    L6:
        Iterator r102 = ((ArrayList) f537197a).iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        d r103 = (d) r102.next();
        if (r103.interceptKeyboardEvent() == false) goto L8;
        Log.i("KeyBoardUtils", "intercept showKeyboard event: " + r103);
        return;
    L13:
        Log.i("KeyBoardUtils", "showKeyboard ");
        InputMethodManager r104 = (InputMethodManager) r100.getContext().getSystemService("input_method");     // Catch: Exception -> L24
        if (r104 != null) goto L17;
        return;
    L17:
        if (r100.requestFocus() == true) goto L20;
        r100.setFocusableInTouchMode(true);     // Catch: Exception -> L24
        r100.setFocusable(true);     // Catch: Exception -> L24
        r100.requestFocus();     // Catch: Exception -> L24
    L20:
        if (r101 == null) goto L22;
        Log.i("KeyBoardUtils", "showKeyboard  resultReceiver is not null");     // Catch: Exception -> L24
        Log.i("KeyBoardUtils", "showKeyboard  showSoftInput result = " + r104.showSoftInput(r100, 1, new KeyboardResultReceiver(r101)));     // Catch: Exception -> L24
        return;
    L22:
        Log.i("KeyBoardUtils", "showKeyboard  showSoftInput result = " + r104.showSoftInput(r100, 1, null));     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        Log.e("KeyBoardUtils", "Android System InputMethodManager is error", e);
    }
}
