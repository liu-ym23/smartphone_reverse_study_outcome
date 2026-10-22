package com.ss.android.account.share.data.write;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes5.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f406339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f406340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f406341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f406342d;

    public b(Context r100, String r101, String r102) {
        this.f406339a = r100;
        this.f406340b = r101;
        this.f406341c = "key_account_info";
        this.f406342d = r102;
    }

    public final void a() {
        AccountManager r100 = AccountManager.get(this.f406339a);     // Catch: Exception -> L15
        String r101 = this.f406340b;     // Catch: Exception -> L15
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L9;
        r101 = this.f406339a.getPackageName();     // Catch: Exception -> L15
    L9:
        Account[] r102 = r100.getAccountsByType(r101);     // Catch: Exception -> L15
        if (r102 == null) goto L21;
        int r103 = r102.length;     // Catch: Exception -> L15
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L22;
        Account r105 = r102[r104];     // Catch: Exception -> L15
        AccountManager.get(this.f406339a).setUserData(r105, this.f406341c, this.f406342d);     // Catch: Exception -> L15
        r104 = r104 + 1;
        goto L12
    L22:
        return;
    L21:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        dra.b r106 = new dra.b();
        r106.b("share_sdk_save_account_info_failed");
        r106.a(LocationMonitorConst.ERR_MSG, e.getMessage());
        r106.a("err_msg_stack", Log.getStackTraceString(e));
        r106.c();
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
}
