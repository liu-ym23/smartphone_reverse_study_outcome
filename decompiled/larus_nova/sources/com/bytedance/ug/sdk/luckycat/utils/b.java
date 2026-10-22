package com.bytedance.ug.sdk.luckycat.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f271550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f271551b;

        @Override // java.lang.Runnable
        public final void run() {
            Toast.makeText(this.f271550a, this.f271551b, 0).show();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Context r100, String r101) {
            this.f271550a = r100;
            this.f271551b = r101;
        }
    }

    public static void a(Context r100, String r101) {
        if (m.a.f271349a.f271344l == true) goto L6;
        return;
    L6:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        Toast.makeText(r100, r101, 0).show();
        return;
    L11:
        new Handler(Looper.getMainLooper()).post(new a(r100, r101));
        return;
    L8:
        r102 = false;
        goto L9
    }
}
