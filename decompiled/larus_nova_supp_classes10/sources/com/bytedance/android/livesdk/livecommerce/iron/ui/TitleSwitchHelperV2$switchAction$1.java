package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.view.ViewPropertyAnimator;
import androidx.core.view.ViewCompat;
import com.bytedance.android.livesdk.livecommerce.network.response.ECBackgroundAnimationType;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class TitleSwitchHelperV2$switchAction$1 implements Runnable {
    public final /* synthetic */ TitleSwitchHelperV2 a;

    public final void a() {
        final List<xi2.f> r0 = this.a.f.b();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isEmpty() == false) goto L8;
        return;
    L8:
        TitleSwitchHelperV2 r1 = this.a;
        int r2 = r1.a + 1;
        r1.a = r2;
        if (r2 < r0.size()) goto L12;
        TitleSwitchHelperV2 r3 = this.a;
        r3.a = 0;
        r3.b++;
    L12:
        if (ViewCompat.isAttachedToWindow(this.a.e) == true) goto L14;
        return;
    L14:
        xi2.g r4 = this.a.f.a();
        if (r4 != null) goto L17;
    L18:
        TitleSwitchHelperV2 r5 = this.a;
        long r6 = r5.b;
        xi2.g r7 = r5.f.a();
        if (r7 == null) goto L23;
        Long r8 = r7.b();
        if (r8 == null) goto L23;
        long r9 = r8.longValue();
    L25:
        if (r6 < r9) goto L27;
        TitleSwitchHelperV2 r10 = this.a;
        r10.getClass();
        UtilityKotlinExtentionsKt.b.removeCallbacks(r10.d);
        return;
    L27:
        ViewPropertyAnimator r11 = this.a.e.animate().alpha(0.0f).setDuration(300);
        com.bytedance.android.ec.core.utils.f.b(r11, new TitleSwitchHelperV2$switchAction$1$run$1(this, r0));
        r11.start();
        return;
    L23:
        r9 = 0;
        goto L25
    L17:
        if (r4.getType() == ECBackgroundAnimationType.INFINITE.getType()) goto L27;
        goto L18
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

    public TitleSwitchHelperV2$switchAction$1(TitleSwitchHelperV2 r1) {
        this.a = r1;
    }
}
