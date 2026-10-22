package com.ss.android.lark.chameleonv2.container.webcontainer;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.ChameleonResourceLoadCallback;
import com.ss.android.lark.vfs.VFSPath;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChameleonResourceLoadCallback f411150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VFSPath f411151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f411152c;

    public a(ChameleonResourceLoadCallback r100, VFSPath r101, String r102) {
        this.f411150a = r100;
        this.f411151b = r101;
        this.f411152c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f411150a.onLoadSuccess(this.f411151b, this.f411152c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
