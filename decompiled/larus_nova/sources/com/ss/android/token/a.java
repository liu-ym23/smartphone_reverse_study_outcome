package com.ss.android.token;

import android.net.Uri;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f449703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f449704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AuthTokenMultiProcessSharedProvider f449705c;

    @Override // java.lang.Runnable
    public final void run() {
        AuthTokenMultiProcessSharedProvider r100 = this.f449705c;     // Catch: Throwable -> L4
        Uri r101 = AuthTokenMultiProcessSharedProvider.b(r100.getContext(), this.f449703a, this.f449704b);     // Catch: Throwable -> L4
        r100.getContext().getContentResolver().notifyChange(r101, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(AuthTokenMultiProcessSharedProvider r100, String r101, String r102) {
        this.f449705c = r100;
        this.f449703a = r101;
        this.f449704b = r102;
    }
}
