package com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.record.cover;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f213497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Drawable f213498b;

    public e(ImageView r100, Drawable r101) {
        this.f213497a = r100;
        this.f213498b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f213497a.setBackground(this.f213498b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
