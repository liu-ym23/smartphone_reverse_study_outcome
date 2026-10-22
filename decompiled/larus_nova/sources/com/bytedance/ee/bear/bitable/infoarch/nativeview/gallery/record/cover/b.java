package com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.record.cover;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f213478a;

    public b(ImageView r100) {
        this.f213478a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f213478a.setVisibility(8);     // Catch: Throwable -> L4
        Drawable r100 = this.f213478a.getDrawable();     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larksuite.component.universe_design.loading.UDLoadingDrawable");     // Catch: Throwable -> L4
        ((UDLoadingDrawable) r100).stop();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
