package com.ss.android.lark.widget.photopicker;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PhotoPreviewPickerFragment f447549a;

    public m(PhotoPreviewPickerFragment r100) {
        this.f447549a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f447549a.onBackPressed();
    }
}
