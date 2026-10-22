package com.ss.android.lark.widget.photo.preview.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.gallery.OriginalMediaHandler;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<PhotoItem> f447157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f447158b;

    /* JADX WARN: Multi-variable type inference failed */
    public f(List<? extends PhotoItem> r100, Runnable r101) {
        this.f447157a = r100;
        this.f447158b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OriginalMediaHandler.a(this.f447157a, this.f447158b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
