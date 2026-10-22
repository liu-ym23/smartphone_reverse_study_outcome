package com.larus.dora.impl.util;

import android.app.Application;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class j implements ActivityResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraConnectChecker f338141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f338142b;

    public /* synthetic */ j(DoraConnectChecker r100, String r101) {
        this.f338141a = r100;
        this.f338142b = r101;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object r100) {
        DoraConnectChecker r101 = this.f338141a;
        String r102 = this.f338142b;
        ActivityResult r103 = (ActivityResult) r100;
        StringBuilder r104 = new StringBuilder("checkReady: request bluetooth switch, result ");
        if (r103.getResultCode() != (-1)) goto L5;
        boolean r105 = true;
    L6:
        r104.append(r105);
        g49.d.d("DoraConnectChecker", r104.toString());
        if (r103.getResultCode() != (-1)) goto L9;
        r101.a("bt_ok", r102, r101.f338098d);
        return;
    L9:
        t19.s r106 = t19.s.f544207a;
        Application r107 = AppHost.f326268a.getApplication();
        r106.getClass();
        t19.s.b(r107, R.string.larus_dora_request_open_bt_switch_fail_cn, false);
        r101.getClass();
        return;
    L5:
        r105 = false;
        goto L6
    }
}
