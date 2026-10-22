package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class w<T> implements Observer {
    public final /* synthetic */ PDFCtrlView a;

    public w(PDFCtrlView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        AppCompatImageView r0 = this.a.getPdfToWpsEditFromXml();
        if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L5;
        int r4 = 0;
    L6:
        r0.setVisibility(r4);
        return;
    L5:
        r4 = 8;
        goto L6
    }
}
