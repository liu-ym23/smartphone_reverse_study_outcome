package com.bytedance.upc.cache;

import android.net.Uri;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f272455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f272456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ApiMultiProcessSharedProvider f272457c;

    @Override // java.lang.Runnable
    public final void run() {
        ApiMultiProcessSharedProvider r100 = this.f272457c;     // Catch: Throwable -> L4
        Uri r101 = ApiMultiProcessSharedProvider.b(r100.getContext(), this.f272455a, this.f272456b);     // Catch: Throwable -> L4
        r100.getContext().getContentResolver().notifyChange(r101, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(ApiMultiProcessSharedProvider r100, String r101, String r102) {
        this.f272457c = r100;
        this.f272455a = r101;
        this.f272456b = r102;
    }
}
