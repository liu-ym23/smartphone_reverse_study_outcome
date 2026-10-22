package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.view.preview.pdf.presentationview.PdfPresentationView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PDFCtrlView f225344a;

    public d0(PDFCtrlView r100) {
        this.f225344a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        if (this.f225344a.isAttachedToWindow() == false) goto L7;
        PdfPresentationView r102 = this.f225344a.getPresentationViewFromXml();
        Intrinsics.checkNotNull(r101);
        r102.setBackTitle(r101.booleanValue());
        return;
    }
}
