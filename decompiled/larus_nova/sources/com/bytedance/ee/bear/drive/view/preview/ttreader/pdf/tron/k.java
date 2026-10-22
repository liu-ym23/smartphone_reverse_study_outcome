package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class k<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PDFCtrlView f225368a;

    public k(PDFCtrlView r100) {
        this.f225368a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L9;
        com.bytedance.ee.bear.drive.biz.preview.vc.connector.g r101 = this.f225368a.f225233n;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("vcReadyCallback");
        r101 = null;
    L7:
        r101.onViewReady();
        return;
    }
}
