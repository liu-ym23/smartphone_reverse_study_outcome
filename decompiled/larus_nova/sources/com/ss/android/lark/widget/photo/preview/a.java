package com.ss.android.lark.widget.photo.preview;

import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PhotoPagerActivity f446584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f446585b;

    public a(PhotoPagerActivity r100, ViewGroup r101) {
        this.f446584a = r100;
        this.f446585b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PhotoPagerActivity r100 = this.f446584a;     // Catch: Throwable -> L4
        ViewGroup r101 = this.f446585b;     // Catch: Throwable -> L4
        int r102 = PhotoPagerActivity.f446498j;     // Catch: Throwable -> L4
        r100.A1(r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
