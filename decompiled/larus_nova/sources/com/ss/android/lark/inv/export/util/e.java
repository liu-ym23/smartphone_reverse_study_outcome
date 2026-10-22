package com.ss.android.lark.inv.export.util;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.suite.lark.emm.design.edittext.SCEditText;

/* JADX INFO: loaded from: classes36.dex */
public final class e {
    public static void a(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Window r101 = r100.getWindow();
        if (r101 == null) goto L23;
        View r102 = r101.getCurrentFocus();
        if (r102 != null) goto L18;
        View r103 = r101.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L14;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L14;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L14:
        View r105 = r103.findViewWithTag("keyboardTagView");
        if (r105 != null) goto L17;
        r105 = new EditText(r101.getContext());
        r105.setTag("keyboardTagView");
        ((ViewGroup) r103).addView(r105, 0, 0);
    L17:
        r102 = r105;
        r102.requestFocus();
    L18:
        InputMethodManager r106 = (InputMethodManager) com.larksuite.framework.utils.b.f285948a.getSystemService("input_method");
        if (r106 == null) goto L24;
        r106.hideSoftInputFromWindow(r102.getWindowToken(), 0);
        return;
    L24:
        return;
    }

    public static void b(SCEditText r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        InputMethodManager r101 = (InputMethodManager) com.larksuite.framework.utils.b.f285948a.getSystemService("input_method");
        if (r101 == null) goto L9;
        r100.setFocusable(true);
        r100.setFocusableInTouchMode(true);
        r100.requestFocus();
        final Handler r102 = new Handler();
        r101.showSoftInput(r100, 0, new InvKeyboardUtils$1(r102));
        r101.toggleSoftInput(2, 1);
        return;
    }
}
