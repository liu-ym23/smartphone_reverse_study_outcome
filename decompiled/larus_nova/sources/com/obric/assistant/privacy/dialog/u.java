package com.obric.assistant.privacy.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class u extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f391139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f391140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f391141c;

    public static final class a {
    }

    static {
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        cancel();
        Activity r100 = AppHost.f326268a.a().getCurrentActivity();
        if (r100 == null) goto L6;
        r100.finish();
        return;
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    public u(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        requestWindowFeature(1);
        setContentView(R.layout.obric_stop_service_dialog);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setBackgroundDrawableResource(R.drawable.obric_transparent);
        r101.setLayout(-1, -2);
        r101.setGravity(17);
        r101.setWindowAnimations(R.style.obric_update_dialog_animation);
    L5:
        setCanceledOnTouchOutside(false);
        this.f391140b = (TextView) findViewById(R.id.tvDialogCancel);
        this.f391139a = (TextView) findViewById(R.id.btnDialogConfirm);
        this.f391141c = (TextView) findViewById(R.id.tvDialogContent);
        TextView r102 = this.f391139a;
        if (r102 == null) goto L8;
        r102.setText(getContext().getResources().getString(R.string.obric_settings_double_check_comfirm));
    L8:
        TextView r103 = this.f391141c;
        if (r103 == null) goto L11;
        r103.setText(getContext().getResources().getString(R.string.stop_service_content));
    L11:
        e1.d(this.f391140b, new s(this));
        TextView r104 = this.f391139a;
        if (r104 == null) goto L15;
        e1.b(r104, new t(this));
        return;
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
        return;
    L13:
        if (r102.getWidth() == 0) goto L14;
        return;
    L17:
        return;
    }
}
