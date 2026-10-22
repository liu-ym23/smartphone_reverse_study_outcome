package com.ss.android.lark.auditsdk.authorization;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import com.larksuite.component.ui.dialog.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f409561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f409562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnDismissListener f409563c;

    public final void a() {
        String r100 = this.f409561a;
        if (r100 != null) goto L6;
        Log.e("AuditUtils", "onCheckedAuthorizationFailed, displayMsg is null");
        return;
    L6:
        Context r101 = this.f409562b;
        DialogInterface.OnDismissListener r102 = this.f409563c;
        d r103 = new d(r101);
        r103.h(r100);
        r103.a(R.id.lkui_dialog_btn_right, R.string.Lark_Group_RevokeIKnow, null);
        r103.f284132c.onDismissListener(r102);
        if ((r101 instanceof Application) == false) goto L9;
        r103.d();
        return;
    L9:
        r103.i();
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

    public a(String r100, Context r101) {
        this.f409561a = r100;
        this.f409562b = r101;
        this.f409563c = null;
    }
}
