package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import android.animation.ValueAnimator;
import com.bytedance.android.ec.sdk.helper.q;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements Runnable {
    public final /* synthetic */ d a;

    public e(d r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = pi3.a.a;     // Catch: Throwable -> L6
        long r1 = System.currentTimeMillis() / ((long) 1000);     // Catch: Throwable -> L6
        q.a.e("anchor_v4_find_similar_button_last_show_time", r1);     // Catch: Throwable -> L6
        d r2 = this.a;     // Catch: Throwable -> L6
        r2.n = true;     // Catch: Throwable -> L6
        r2.setBubbleIsShown(true);     // Catch: Throwable -> L6
        ValueAnimator r3 = this.a.k;     // Catch: Throwable -> L6
        if (r3 == null) goto L9;
        r3.start();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
