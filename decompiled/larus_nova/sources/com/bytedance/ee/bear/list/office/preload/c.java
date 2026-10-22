package com.bytedance.ee.bear.list.office.preload;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f229147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f229148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f229149c;

    public c(Context r100, int r101, int r102) {
        this.f229147a = r100;
        this.f229148b = r101;
        this.f229149c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.showText(this.f229147a, "OfficeSpace DB preload success: tabs=" + this.f229148b + ", size=" + this.f229149c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
