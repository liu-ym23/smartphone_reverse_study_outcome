package com.bytedance.ee.bear.sheet.exportimage.preview;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SheetImagePreviewFragment f237589a;

    public i(SheetImagePreviewFragment r100) {
        this.f237589a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L8;
        SheetImagePreviewFragment r101 = this.f237589a;
        ExternalShareView r102 = r101.f237536h;
        if (r102 == null) goto L9;
        r102.post(new h(r101));
        return;
    L9:
        return;
    }
}
