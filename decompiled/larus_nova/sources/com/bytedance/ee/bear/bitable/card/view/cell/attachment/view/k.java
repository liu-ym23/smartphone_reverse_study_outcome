package com.bytedance.ee.bear.bitable.card.view.cell.attachment.view;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AttachmentMediaPickerPanel f207481a;

    public k(AttachmentMediaPickerPanel r100) {
        this.f207481a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f207481a.f207428b.j("cancel");
    }
}
