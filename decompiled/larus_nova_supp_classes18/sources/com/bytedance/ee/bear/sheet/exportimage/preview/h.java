package com.bytedance.ee.bear.sheet.exportimage.preview;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareView;
import com.bytedance.ee.util.ui.n;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements Runnable {
    public final /* synthetic */ SheetImagePreviewFragment a;

    public h(SheetImagePreviewFragment r1) {
        this.a = r1;
    }

    public final void a() {
        ExternalShareView r0 = this.a.h;
        if (r0 == null) goto L5;
        int r1 = r0.getMeasuredHeight();
    L6:
        ImagePreviewViewModel r2 = this.a.f;
        if (r2 == null) goto L9;
        r2.onSharePanelHeightChanged(n.E(r1));
    L9:
        View r3 = this.a.l;
        ViewGroup.MarginLayoutParams r4 = null;
        if (r3 == null) goto L12;
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
    L14:
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        r4 = (ViewGroup.MarginLayoutParams) r5;
    L16:
        if (r4 == null) goto L18;
        r4.bottomMargin = r1;
    L18:
        View r6 = this.a.l;
        if (r6 == null) goto L22;
        r6.setLayoutParams(r4);
        return;
    L22:
        return;
    L12:
        r5 = null;
        goto L14
    L5:
        r1 = 0;
        goto L6
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
