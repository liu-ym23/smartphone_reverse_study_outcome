package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.view.View;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ PDFCtrlView a;

    public f(PDFCtrlView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ViewOwner r3 = this.a.j;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r3 = null;
    L5:
        ((PreviewViewModel) r3.viewModel(PreviewViewModel.class)).liveInnerEditModeSwitchAction().setValue(1);
    }
}
