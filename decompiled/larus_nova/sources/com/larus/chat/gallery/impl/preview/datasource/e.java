package com.larus.chat.gallery.impl.preview.datasource;

import androidx.lifecycle.LiveData;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f324258a;

    public /* synthetic */ e(f r100) {
        this.f324258a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f r100 = this.f324258a;
        r100.f324263e.removeObserver(r100.f324265g);
        LiveData<Integer> r101 = r100.f324264f;
        if (r101 == null) goto L6;
        r101.removeObserver(r100.f324266h);
        return;
    }
}
