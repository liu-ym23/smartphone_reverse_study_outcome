package com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller;

import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeBaseMainCatalogDrawerController f210398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.bitable.common.b f210399b;

    public d(OfficeBaseMainCatalogDrawerController r100, c r101) {
        this.f210398a = r100;
        this.f210399b = r101;
    }

    public final void a() {
        OfficeBaseMainCatalogDrawerController r100 = this.f210398a;
        com.bytedance.ee.bear.bitable.core.infoarch.g r101 = r100.f210299b;
        if (r101.f210554b == true) goto L5;
        return;
    L5:
        if (r101.f210555c == true) goto L13;
        r100.a(true);
        OfficeBaseMainCatalogDrawerController r102 = this.f210398a;
        OfficeBaseMainCatalogDrawerController.c(r102, r102.f210298a.f210509f, r102.d());
        OfficeBaseMainCatalogDrawerController r103 = this.f210398a;
        ViewGroup r104 = r103.f210298a.f210511h;
        if (r104 == null) goto L10;
        OfficeBaseMainCatalogDrawerController.c(r103, r104, r103.d());
    L10:
        OfficeBaseMainCatalogDrawerController r105 = this.f210398a;
        OfficeBaseMainCatalogDrawerController.b(r105.f210298a.f210520q, 0.0f, -r105.d(), this.f210399b);
        return;
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
