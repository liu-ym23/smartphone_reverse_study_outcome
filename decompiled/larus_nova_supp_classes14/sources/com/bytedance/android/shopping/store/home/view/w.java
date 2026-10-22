package com.bytedance.android.shopping.store.home.view;

import com.bytedance.android.shopping.store.keva.ECStoreDefaultKevaRepo;
import com.bytedance.keva.Keva;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w implements Runnable {
    public final /* synthetic */ MovableFrameLayout a;

    public w(MovableFrameLayout r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Lazy r1 = ECStoreDefaultKevaRepo.a;     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter("live_icon_translation_x", "key");     // Catch: Throwable -> L13
        Lazy r2 = ECStoreDefaultKevaRepo.a;     // Catch: Throwable -> L13
        float r3 = ((Keva) r2.getValue()).getFloat("live_icon_translation_x", Float.MIN_VALUE);     // Catch: Throwable -> L13
        if (r3 == Float.MIN_VALUE) goto L6;
        this.a.setTranslationX(r3);     // Catch: Throwable -> L13
    L6:
        Intrinsics.checkNotNullParameter("live_icon_translation_y", "key");     // Catch: Throwable -> L13
        float r0 = ((Keva) r2.getValue()).getFloat("live_icon_translation_y", Float.MIN_VALUE);     // Catch: Throwable -> L13
        if (r0 == Float.MIN_VALUE) goto L10;
        this.a.setTranslationY(r0);     // Catch: Throwable -> L13
    L10:
        if (this.a.getNeedAdsorptionEdge() == false) goto L16;
        this.a.b(false);     // Catch: Throwable -> L13
        return;
    L16:
        return;
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L20;
        throw th;
    }
}
