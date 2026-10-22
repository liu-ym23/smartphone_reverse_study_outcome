package z06;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {
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

    public static final int b(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        WindowInsetsCompat r101 = ViewCompat.getRootWindowInsets(a(r100.getWindow()));
        if (r101 == null) goto L7;
        Insets r102 = r101.getInsets(WindowInsetsCompat.Type.ime());
        if (r102 == null) goto L7;
        Integer r103 = Integer.valueOf(r102.bottom);
    L8:
        if (r103 != null) goto L12;
        return 0;
    L12:
        return r103.intValue();
    L7:
        r103 = null;
        goto L8
    }

    public static final void c(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        View r101 = r100.getCurrentFocus();
        if (r101 == null) goto L5;
        Object r102 = r100.getSystemService("input_method");
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r102).hideSoftInputFromWindow(r101.getWindowToken(), 2);
        return;
    L5:
        WindowInsetsControllerCompat r103 = ViewCompat.getWindowInsetsController(a(r100.getWindow()));
        if (r103 == null) goto L10;
        r103.hide(WindowInsetsCompat.Type.ime());
        return;
    }
}
