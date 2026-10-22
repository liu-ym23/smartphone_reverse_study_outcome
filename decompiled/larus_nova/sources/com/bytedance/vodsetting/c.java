package com.bytedance.vodsetting;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes22.dex */
public final class c extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f272567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f272568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f272569c;

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.f272569c.c(this.f272567a, this.f272568b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(b r100, String r101, String r102) {
        this.f272569c = r100;
        this.f272567a = r101;
        this.f272568b = r102;
    }
}
