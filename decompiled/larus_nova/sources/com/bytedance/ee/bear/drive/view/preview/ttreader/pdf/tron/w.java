package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class w<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PDFCtrlView f225441a;

    public w(PDFCtrlView r100) {
        this.f225441a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        AppCompatImageView r101 = this.f225441a.getPdfToWpsEditFromXml();
        if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }
}
