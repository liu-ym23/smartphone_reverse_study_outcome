package com.bytedance.locallife.photo.photodraweeview.indicator;

import android.view.View;
import com.bytedance.locallife.cube.api.i.IPoiLynxKitDelegate;
import com.bytedance.locallife.photo.preview.uilayer.LynxUILayer;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f262142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PhotoPreviewDecorateView f262143b;

    public a(boolean r100, PhotoPreviewDecorateView r101) {
        this.f262142a = r100;
        this.f262143b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L19:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L27;
        throw th;
    L27:
        return;
    L3:
        if (this.f262142a == false) goto L11;
        LynxUILayer r100 = this.f262143b.f262133e;     // Catch: Throwable -> L19
        if (r100 == null) goto L24;
        IPoiLynxKitDelegate r101 = r100.d();     // Catch: Throwable -> L19
        if (r101 == null) goto L24;
        r101.onShow();     // Catch: Throwable -> L19
        View r102 = r101.realView();     // Catch: Throwable -> L19
        if (r102 == null) goto L24;
        r102.setVisibility(0);     // Catch: Throwable -> L19
    L24:
        return;
    L11:
        LynxUILayer r103 = this.f262143b.f262133e;     // Catch: Throwable -> L19
        if (r103 == null) goto L24;
        IPoiLynxKitDelegate r104 = r103.d();     // Catch: Throwable -> L19
        if (r104 == null) goto L24;
        r104.onHide();     // Catch: Throwable -> L19
        View r105 = r104.realView();     // Catch: Throwable -> L19
        if (r105 == null) goto L24;
        r105.setVisibility(8);     // Catch: Throwable -> L19
        goto L24
    }
}
