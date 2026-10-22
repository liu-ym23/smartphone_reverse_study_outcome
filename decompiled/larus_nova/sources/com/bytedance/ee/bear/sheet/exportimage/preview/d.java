package com.bytedance.ee.bear.sheet.exportimage.preview;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.widgets.BaseTitleBar;

/* JADX INFO: loaded from: classes18.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SheetImagePreviewFragment f237584a;

    public d(SheetImagePreviewFragment r100) {
        this.f237584a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        PreviewTitleModel r101 = (PreviewTitleModel) r100;
        if (r101 == null) goto L13;
        PreviewTitleModel.Item r102 = r101.getTitleItem();
        if (r102 == null) goto L14;
        String r103 = r102.text;
        if (r103 == null) goto L16;
        BaseTitleBar r104 = this.f237584a.f237537i;
        if (r104 == null) goto L15;
        r104.setTitle(r103);
        return;
    L15:
        return;
    L16:
        return;
    L14:
        return;
    }
}
