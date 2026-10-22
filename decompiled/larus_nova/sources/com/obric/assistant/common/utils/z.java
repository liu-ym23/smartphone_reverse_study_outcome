package com.obric.assistant.common.utils;

import android.widget.Toast;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f387899a;

    public /* synthetic */ z(int r100) {
        this.f387899a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = this.f387899a;
        AppHost.Companion r101 = AppHost.f326268a;
        if (r101.a().isAppBackground() == false) goto L5;
        Toast.makeText(r101.getApplication(), r101.getApplication().getResources().getString(r100), 1).show();
        return;
    L5:
        t19.s.f544207a.g(r101.getApplication(), r100, false);
    }
}
