package com.obric.matrixpro.sdk.deviceinfoclient;

import android.os.HandlerThread;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes33.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f397043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f397044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC4654a f397045c;

    public d(String r100, String r101, a.InterfaceC4654a r102) {
        this.f397043a = r100;
        this.f397044b = r101;
        this.f397045c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = this.f397043a;     // Catch: Throwable -> L15
        if (r100 == null) goto L5;
        this.f397045c.onError(r100);     // Catch: Throwable -> L15
    L20:
        return;
    L5:
        String r101 = this.f397044b;     // Catch: Throwable -> L15
        if (r101 != null) goto L8;
    L13:
        this.f397045c.onError("OSDID为空或列索引异常");     // Catch: Throwable -> L15
        goto L20
    L8:
        if (r101.length() <= 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        HandlerThread r103 = a.f397034a;     // Catch: Throwable -> L15
        String r104 = this.f397044b;     // Catch: Throwable -> L15
        this.f397045c.onSuccess(r104);     // Catch: Throwable -> L15
        goto L20
    L10:
        r102 = false;
    L15:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L23;
        throw th;
    }
}
