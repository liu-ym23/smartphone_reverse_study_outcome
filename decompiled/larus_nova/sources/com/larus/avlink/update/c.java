package com.larus.avlink.update;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.common.utility.Logger;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f294706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f294707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f294708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f294709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f294710e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f294711f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f294712g;

    public static final class a {
    }

    static {
    }

    public static void a(c r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        boolean r101 = true;
        requestWindowFeature(1);
        setContentView(R.layout.layout_g_update_dialog);
        Window r102 = getWindow();
        if (r102 == null) goto L5;
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.setLayout(-1, -2);
        r102.setGravity(17);
    L5:
        setCanceledOnTouchOutside(false);
        this.f294712g = (TextView) findViewById(R.id.tvDialogTitle);
        this.f294710e = (TextView) findViewById(R.id.tvDialogCancel);
        this.f294709d = (TextView) findViewById(R.id.btnDialogConfirm);
        this.f294711f = (TextView) findViewById(R.id.tvDialogContent);
        e1.d(this.f294710e, new com.larus.avlink.update.a(this));
        TextView r103 = this.f294709d;
        if (r103 == null) goto L8;
        e1.d(r103, new b(this));
    L8:
        TextView r104 = this.f294712g;
        if (r104 == null) goto L12;
        r104.setText(getContext().getResources().getString(R.string.larus_update_popup_title));
    L12:
        if (TextUtils.isEmpty(this.f294706a.f294721a) == true) goto L16;
        TextView r105 = this.f294712g;
        if (r105 == null) goto L16;
        r105.setText(this.f294706a.f294721a);
    L16:
        TextView r106 = this.f294709d;
        if (r106 == null) goto L20;
        r106.setText(getContext().getResources().getString(R.string.larus_update_popup_agree));
    L20:
        if (TextUtils.isEmpty(this.f294706a.f294724d) == true) goto L24;
        TextView r107 = this.f294709d;
        if (r107 == null) goto L24;
        r107.setText(this.f294706a.f294724d);
    L24:
        TextView r108 = this.f294710e;
        if (r108 == null) goto L28;
        r108.setText(getContext().getResources().getString(R.string.larus_update_popup_reject));
    L28:
        if (TextUtils.isEmpty(this.f294706a.f294723c) == true) goto L32;
        TextView r109 = this.f294710e;
        if (r109 == null) goto L32;
        r109.setText(this.f294706a.f294723c);
    L32:
        String r110 = this.f294706a.f294722b;
        if (r110 != null) goto L35;
    L38:
        if (r101 == true) goto L45;
        TextView r111 = this.f294711f;
        if (r111 == null) goto L44;
        r111.setText(r110);
        return;
    L44:
        return;
    L45:
        return;
    L35:
        if (r110.length() == 0) goto L38;
        r101 = false;
        goto L38
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
        Window r101 = getWindow();
        if (r100 == false) goto L16;
        if (r101 == null) goto L17;
        View r102 = r101.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L11;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L11;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L11:
        if (r102.getHeight() != 0) goto L13;
    L14:
        r102.requestLayout();
        Logger.d("CheckUpdateDialog", "relayout");
        return;
    L13:
        if (r102.getWidth() == 0) goto L14;
        return;
    L17:
        return;
    }

    public c(Context r100, i r101, e r102, f r103) {
        Intrinsics.checkNotNullParameter(r100, "cxt");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "cancelClick");
        Intrinsics.checkNotNullParameter(r103, "confirmClick");
        super(r100);
        this.f294706a = r101;
        this.f294707b = r102;
        this.f294708c = r103;
    }
}
