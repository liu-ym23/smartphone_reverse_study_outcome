package com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel;

import android.app.Application;
import android.content.Context;
import com.larus.common.apphost.AppHost;
import t19.s;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f309496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f309497b;

    public /* synthetic */ d(Context r100, int r101) {
        this.f309496a = r100;
        this.f309497b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context r100 = this.f309496a;
        int r101 = this.f309497b;
        s r102 = s.f544207a;
        Application r103 = AppHost.f326268a.getApplication();
        String r104 = r100.getString(r101);
        r102.getClass();
        s.c(r103, r104);
    }
}
