package com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.record.cover;

import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import ip4.s;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f213476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f213477b;

    public a(String r100, ImageView r101) {
        this.f213476a = r100;
        this.f213477b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    L15:
        return;
    L3:
        if (s.d(this.f213476a) == false) goto L5;
        this.f213477b.setVisibility(0);     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        this.f213477b.setVisibility(8);     // Catch: Throwable -> L7
        goto L12
    }
}
