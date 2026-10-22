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
public final class l0 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f327362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f327363b;

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        requestWindowFeature(1);
        if (this.f327363b == false) goto L5;
        setContentView(R.layout.larus_account_dialog_shadow);
    L6:
        Window r101 = getWindow();
        if (r101 == null) goto L9;
        WindowManager.LayoutParams r102 = r101.getAttributes();
    L10:
        if (r102 == null) goto L13;
        r102.width = -1;
        r102.height = -1;
        r102.gravity = 17;
    L13:
        if (r101 == null) goto L21;
        View r103 = r101.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L19;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L19;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L19:
        if (r103 == null) goto L21;
        r103.setPadding(0, 0, 0, 0);
    L21:
        if (r101 == null) goto L23;
        r101.setBackgroundDrawable(new ColorDrawable(0));
    L23:
        if (r101 == null) goto L25;
        r101.addFlags(Integer.MIN_VALUE);
    L25:
        if (r101 == null) goto L27;
        r101.setStatusBarColor(0);
    L27:
        if (r101 == null) goto L29;
        r101.setNavigationBarColor(0);
    L29:
        if (r101 == null) goto L32;
        r101.setDimAmount(this.f327362a);
        return;
    L32:
        return;
    L9:
        r102 = null;
        goto L10
    L5:
        setContentView(R.layout.larus_account_dialog);
        goto L6
    }

    public l0(Context r100, float r101, boolean r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = 0.2f;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = false;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(v19.f.d(r100));
        this.f327362a = r101;
        this.f327363b = r102;
        setCancelable(false);
    }
}
