package com.larus.common_ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class m0 extends Dialog {
    public m0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(v19.f.d(r100));
        setCancelable(false);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        requestWindowFeature(1);
        setContentView(R.layout.larus_account_dialog);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        WindowManager.LayoutParams r102 = r101.getAttributes();
    L6:
        if (r102 == null) goto L9;
        r102.width = -1;
        r102.height = -1;
        r102.gravity = 17;
    L9:
        if (r101 == null) goto L17;
        View r103 = r101.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L15;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L15;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L15:
        if (r103 == null) goto L17;
        r103.setPadding(0, 0, 0, 0);
    L17:
        if (r101 == null) goto L19;
        r101.setBackgroundDrawable(new ColorDrawable(0));
    L19:
        if (r101 == null) goto L21;
        r101.addFlags(Integer.MIN_VALUE);
    L21:
        if (r101 == null) goto L23;
        r101.setStatusBarColor(0);
    L23:
        if (r101 == null) goto L25;
        r101.setNavigationBarColor(0);
    L25:
        com.larus.utils.e1.q(findViewById(R.id.google_login_loading_bar));
        com.larus.utils.e1.q(findViewById(R.id.loading_page));
        findViewById(R.id.dialogRootView).setBackgroundColor(0);
        if (r101 == null) goto L29;
        r101.setDimAmount(0.0f);
        return;
    L29:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
