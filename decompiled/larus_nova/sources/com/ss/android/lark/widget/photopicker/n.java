package com.ss.android.lark.widget.photopicker;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PhotoPreviewPickerFragment f447550a;

    public n(PhotoPreviewPickerFragment r100) {
        this.f447550a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        jdc.c.a("send", "im_chat_main_view");
        PhotoPreviewPickerFragment r101 = this.f447550a;
        int r102 = PhotoPreviewPickerFragment.f447432J;
        r101.S90(false);
    }
}
