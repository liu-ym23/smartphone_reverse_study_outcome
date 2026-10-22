package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.biz.preview.configuration.DriveConfigurationVM;
import com.bytedance.ee.bear.drive.view.preview.pdf.ExhibitionMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ PDFCtrlView a;

    public i(PDFCtrlView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Float r5 = (Float) r4;
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.c r6 = this.a.o;
        if (r6 == null) goto L5;
        tt5.a.h("CCMFollow_PDFVCFollowConnector", "ScrollListener onScrollStateChanged: ");
        ((l65.a.C0248a) ((com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b.c) r6).a).b();
    L5:
        PDFCtrlViewModel r7 = this.a.k;
        DriveConfigurationVM r0 = null;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r7 = null;
    L8:
        MutableLiveData<Boolean> r8 = r7.getBookLoaded();
        if (r8 == null) goto L11;
        boolean r9 = Intrinsics.areEqual(r8.getValue(), Boolean.TRUE);
    L12:
        if (r9 == false) goto L21;
        PDFCtrlView r10 = this.a;
        if (r10.p == ExhibitionMode.PRESENTATION) goto L22;
        DriveConfigurationVM r11 = r10.z;
        if (r11 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mDriveConfigurationVM");
    L19:
        r0.getCurrentV2Offset().postValue(this.a.c());
        return;
    L18:
        r0 = r11;
        goto L19
    L22:
        return;
    L21:
        return;
    L11:
        r9 = false;
        goto L12
    }
}
