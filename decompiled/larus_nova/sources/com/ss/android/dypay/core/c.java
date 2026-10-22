package com.ss.android.dypay.core;

import android.app.Activity;
import android.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f408475a;

    public c(Activity r100) {
        this.f408475a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Activity r100 = this.f408475a;     // Catch: Throwable -> L4
        Toast.makeText(r100, r100.getResources().getString(R.string.dypay_not_repeat_the_order), 0).show();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
