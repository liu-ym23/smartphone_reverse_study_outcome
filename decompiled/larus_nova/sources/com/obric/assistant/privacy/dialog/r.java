package com.obric.assistant.privacy.dialog;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.sheet.v2.OSheet;

/* JADX INFO: loaded from: classes33.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f391134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.obric.oui.sheet.v2.i f391135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ OSheet f391136c;

    public r(RadiusLayout r100, com.obric.oui.sheet.v2.i r101, OSheet r102) {
        this.f391134a = r100;
        this.f391135b = r101;
        this.f391136c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.obric.oui.sheet.v2.i r100 = this.f391135b;     // Catch: Throwable -> L4
        r100.f402977i = this.f391136c.f402890q.getHeight();     // Catch: Throwable -> L4
        this.f391135b.e();     // Catch: Throwable -> L4
        this.f391135b.a();     // Catch: Throwable -> L4
        this.f391135b.f402971c.setRadius(0.0f);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
