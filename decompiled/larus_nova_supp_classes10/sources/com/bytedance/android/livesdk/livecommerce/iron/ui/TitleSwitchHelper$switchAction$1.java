package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.view.ViewPropertyAnimator;
import androidx.core.view.ViewCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import xi2.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class TitleSwitchHelper$switchAction$1 implements Runnable {
    public final /* synthetic */ m a;

    public final void a() {
        final List<f0> r0 = this.a.d.d();
        if (r0 != null) goto L5;
        return;
    L5:
        m r1 = this.a;
        int r2 = r1.a + 1;
        r1.a = r2;
        if (r2 < r0.size()) goto L9;
        this.a.a = 0;
    L9:
        if (ViewCompat.isAttachedToWindow(this.a.c) == true) goto L11;
        return;
    L11:
        ViewPropertyAnimator r3 = this.a.c.animate().alpha(0.0f).setDuration(300);
        com.bytedance.android.ec.core.utils.f.b(r3, new TitleSwitchHelper$switchAction$1$run$1(this, r0));
        r3.start();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public TitleSwitchHelper$switchAction$1(m r1) {
        this.a = r1;
    }
}
