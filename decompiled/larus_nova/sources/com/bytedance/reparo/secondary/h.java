package com.bytedance.reparo.secondary;

import android.app.Application;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Application f267485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ExecutorService f267486b;

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            MonitorService.c();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a() {
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.reparo.j.a(this.f267485a);     // Catch: Throwable -> L6 NoClassDefFoundError -> L8
        if (MonitorService.f267467c == true) goto L15;
        wh4.d.a().a(new a());     // Catch: Throwable -> L6 NoClassDefFoundError -> L8
    L15:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    L19:
        return;
    L9:
        i.f267487a = true;     // Catch: Throwable -> L6
        goto L15
    }

    public h(Application r100, ExecutorService r101) {
        this.f267485a = r100;
        this.f267486b = r101;
    }
}
