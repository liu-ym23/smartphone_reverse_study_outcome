package com.larus.voicecall.impl.degrade;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.spi.common.IObricUtilService;
import t19.s;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f378332a;

    public /* synthetic */ b(String r100) {
        this.f378332a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = this.f378332a;
        IObricUtilService r101 = kga.b.a();
        AppHost.Companion r102 = AppHost.f326268a;
        if (r101.d(r102.getApplication().getApplicationContext(), r100) == true) goto L11;
        Context r103 = r102.a().getCurrentActivity();
        if (r103 != null) goto L9;
        r103 = r102.getApplication().getApplicationContext();
    L9:
        Context r104 = r103;
        s.j(s.f544207a, r104, r100, null, false, 28);
        return;
    }
}
