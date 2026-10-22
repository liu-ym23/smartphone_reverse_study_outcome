package com.bytedance.ee.bear.office.common.upload;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y implements Runnable {
    public final /* synthetic */ OfficeUploadListPanel a;

    public y(OfficeUploadListPanel r1) {
        this.a = r1;
    }

    public final void a() {
        this.a.b.setVisibility(0);
        float r0 = this.a.getHeight() - this.a.b.getTop();
        if (r0 > 0.0f) goto L5;
        return;
    L5:
        LinearLayout r3 = this.a.b;
        TranslateAnimation r4 = new TranslateAnimation(0.0f, 0.0f, r0, 0.0f);
        r4.setDuration(300);
        r4.setInterpolator(new DecelerateInterpolator());
        r4.setFillAfter(false);
        r3.startAnimation(r4);
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
}
