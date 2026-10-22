package com.ss.android.lark.widget.photo.preview.video.cover;

import android.os.Bundle;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f447264a;

    public z(r r100) {
        this.f447264a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    L14:
        return;
    L3:
        if (this.f447264a.f447254x < 0) goto L10;
        Bundle r100 = w0c.a.a();     // Catch: Throwable -> L7
        r100.putInt("int_data", this.f447264a.f447254x);     // Catch: Throwable -> L7
        this.f447264a.j(-66005, r100);     // Catch: Throwable -> L7
        return;
    }
}
