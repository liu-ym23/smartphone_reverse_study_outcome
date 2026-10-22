package com.bytedance.ee.bear.sheet.exportimage.preview;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareView;
import com.bytedance.ee.util.ui.n;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SheetImagePreviewFragment f237588a;

    public h(SheetImagePreviewFragment r100) {
        this.f237588a = r100;
    }

    public final void a() {
        ExternalShareView r100 = this.f237588a.f237536h;
        if (r100 == null) goto L5;
        int r101 = r100.getMeasuredHeight();
    L6:
        ImagePreviewViewModel r102 = this.f237588a.f237534f;
        if (r102 == null) goto L9;
        r102.onSharePanelHeightChanged(n.E(r101));
    L9:
        View r103 = this.f237588a.f237540l;
        ViewGroup.MarginLayoutParams r104 = null;
        if (r103 == null) goto L12;
        ViewGroup.LayoutParams r105 = r103.getLayoutParams();
    L14:
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        r104 = (ViewGroup.MarginLayoutParams) r105;
    L16:
        if (r104 == null) goto L18;
        r104.bottomMargin = r101;
    L18:
        View r106 = this.f237588a.f237540l;
        if (r106 == null) goto L22;
        r106.setLayoutParams(r104);
        return;
    L22:
        return;
    L12:
        r105 = null;
        goto L14
    L5:
        r101 = 0;
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
