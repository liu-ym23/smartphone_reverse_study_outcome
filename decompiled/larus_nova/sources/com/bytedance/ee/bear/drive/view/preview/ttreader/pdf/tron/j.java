package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.structure.ScrollState;

/* JADX INFO: loaded from: classes16.dex */
public final class j<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PDFCtrlView f225360a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f225361a = null;

        static {
            int[] r100 = new int[ScrollState.values().length];
            r100[ScrollState.STOPPED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ScrollState.STARTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ScrollState.SCROLLING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f225361a = r100;
        }
    }

    public j(PDFCtrlView r100) {
        this.f225360a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ScrollState r101 = (ScrollState) r100;
        if (r101 != null) goto L5;
        int r102 = -1;
    L7:
        if (r102 != 1) goto L9;
        tt5.a.h("PDFCtrlView", "bindListener - scrollStateObserver, scrollState: STOPPED");
        this.f225360a.getPdfThumbnailSliderFromXml().setAutoHide(true);
        return;
    L9:
        if (r102 != 2) goto L15;
        tt5.a.h("PDFCtrlView", "bindListener - scrollStateObserver, scrollState: STARTED");
        this.f225360a.getPdfThumbnailSliderFromXml().setAutoHide(false);
        this.f225360a.getPdfThumbnailSliderFromXml().d(true);
        return;
    L15:
        return;
    L5:
        r102 = a.f225361a[r101.ordinal()];
        goto L7
    }
}
