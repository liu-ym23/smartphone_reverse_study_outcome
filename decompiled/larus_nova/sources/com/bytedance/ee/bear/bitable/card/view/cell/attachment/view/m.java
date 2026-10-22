package com.bytedance.ee.bear.bitable.card.view.cell.attachment.view;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes15.dex */
public final class m implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bb5.h f207483a;

    public m(ip4.f r100) {
        this.f207483a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        tt5.a.b("AttachmentMediaPickerPanel", "onDismiss");
        this.f207483a.onDismiss();
    }
}
