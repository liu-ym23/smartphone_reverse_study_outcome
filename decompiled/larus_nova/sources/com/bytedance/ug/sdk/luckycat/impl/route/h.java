package com.bytedance.ug.sdk.luckycat.impl.route;

import android.content.Context;
import android.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f271447a;

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText(this.f271447a, "目前使用UG老Lynx容器，请尽快切新容器", 0).show();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(Context r100) {
        this.f271447a = r100;
    }
}
