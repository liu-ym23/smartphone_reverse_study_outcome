package com.bytedance.ee.bear.bitable.card.view.cell.attachment.view;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes15.dex */
public final class l implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AttachmentMediaPickerPanel f207482a;

    public l(AttachmentMediaPickerPanel r100) {
        this.f207482a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        tt5.a.b("AttachmentMediaPickerPanel", "onCancel");
        this.f207482a.f207428b.j("cancel");
    }
}
