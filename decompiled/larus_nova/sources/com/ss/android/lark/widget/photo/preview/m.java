package com.ss.android.lark.widget.photo.preview;

import android.app.Activity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k.c f446750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f446751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f446752c;

    public m(k.c r100, Activity r101) {
        this.f446750a = r100;
        this.f446751b = r101;
        this.f446752c = 666;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k.c r100 = this.f446750a;     // Catch: Throwable -> L4
        Activity r101 = this.f446751b;     // Catch: Throwable -> L4
        int r102 = this.f446752c;     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        r100.a(r101, new n(r101, r100, r102));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
