package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ PDFCtrlView a;

    public k(PDFCtrlView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        if (((Boolean) r1).booleanValue() == false) goto L9;
        com.bytedance.ee.bear.drive.biz.preview.vc.connector.g r2 = this.a.n;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("vcReadyCallback");
        r2 = null;
    L7:
        r2.onViewReady();
        return;
    }
}
