package com.ss.android.lark.filedetail.impl.detail;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes35.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileTransmissionPresenter f421608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f421609b;

    public /* synthetic */ i(FileTransmissionPresenter r100, int r101, long r102) {
        this.f421608a = r100;
        this.f421609b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FileTransmissionPresenter r100 = this.f421608a;
        int r101 = this.f421609b;
        WeakReference<z> r102 = r100.f421574a;
        if (r102 == null) goto L10;
        z r103 = r102.get();
        if (r103 == null) goto L11;
        r103.dX(r101);
        return;
    L11:
        return;
    }
}
