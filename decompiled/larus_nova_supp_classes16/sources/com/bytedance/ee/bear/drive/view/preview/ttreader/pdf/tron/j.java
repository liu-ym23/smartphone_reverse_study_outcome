package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.structure.ScrollState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j<T> implements Observer {
    public final /* synthetic */ PDFCtrlView a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ScrollState.values().length];
            r0[ScrollState.STOPPED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ScrollState.STARTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ScrollState.SCROLLING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public j(PDFCtrlView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        ScrollState r5 = (ScrollState) r4;
        if (r5 != null) goto L5;
        int r6 = -1;
    L7:
        if (r6 != 1) goto L9;
        tt5.a.h("PDFCtrlView", "bindListener - scrollStateObserver, scrollState: STOPPED");
        this.a.getPdfThumbnailSliderFromXml().setAutoHide(true);
        return;
    L9:
        if (r6 != 2) goto L15;
        tt5.a.h("PDFCtrlView", "bindListener - scrollStateObserver, scrollState: STARTED");
        this.a.getPdfThumbnailSliderFromXml().setAutoHide(false);
        this.a.getPdfThumbnailSliderFromXml().d(true);
        return;
    L15:
        return;
    L5:
        r6 = a.a[r5.ordinal()];
        goto L7
    }
}
