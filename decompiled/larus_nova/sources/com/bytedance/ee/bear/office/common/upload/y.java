package com.bytedance.ee.bear.office.common.upload;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeUploadListPanel f235443a;

    public y(OfficeUploadListPanel r100) {
        this.f235443a = r100;
    }

    public final void a() {
        this.f235443a.f235274b.setVisibility(0);
        float r100 = this.f235443a.getHeight() - this.f235443a.f235274b.getTop();
        if (r100 > 0.0f) goto L5;
        return;
    L5:
        LinearLayout r101 = this.f235443a.f235274b;
        TranslateAnimation r102 = new TranslateAnimation(0.0f, 0.0f, r100, 0.0f);
        r102.setDuration(300);
        r102.setInterpolator(new DecelerateInterpolator());
        r102.setFillAfter(false);
        r101.startAnimation(r102);
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
