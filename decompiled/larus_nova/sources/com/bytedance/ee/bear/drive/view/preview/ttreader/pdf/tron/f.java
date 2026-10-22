package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.view.View;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PDFCtrlView f225348a;

    public f(PDFCtrlView r100) {
        this.f225348a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ViewOwner r101 = this.f225348a.f225229j;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r101 = null;
    L5:
        ((PreviewViewModel) r101.viewModel(PreviewViewModel.class)).liveInnerEditModeSwitchAction().setValue(1);
    }
}
