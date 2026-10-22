package com.bytedance.ee.bear.document.print;

import android.view.View;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f221159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f221160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CommonActionPanelLayout f221161c;

    public e(View r100, float r101, CommonActionPanelLayout r102) {
        this.f221159a = r100;
        this.f221160b = r101;
        this.f221161c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L20;
        throw th;
    L20:
        return;
    L3:
        if (this.f221159a.isAttachedToWindow() == false) goto L16;
        float r100 = this.f221159a.getMeasuredHeight();     // Catch: Throwable -> L13
        if (r100 != 0.0f) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        r100 = this.f221160b;     // Catch: Throwable -> L13
    L11:
        this.f221161c.l(0.0f, r100, r100);     // Catch: Throwable -> L13
        return;
    L8:
        r101 = false;
        goto L9
    }
}
