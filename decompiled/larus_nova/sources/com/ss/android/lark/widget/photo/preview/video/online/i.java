package com.ss.android.lark.widget.photo.preview.video.online;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f447362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OnlineVideoGalleryPresenter.a f447363b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f447363b.f447311a.getView().f4(this.f447362a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i(OnlineVideoGalleryPresenter.a r100, int r101) {
        this.f447363b = r100;
        this.f447362a = r101;
    }
}
