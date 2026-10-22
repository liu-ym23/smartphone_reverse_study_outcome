package com.ss.android.lark.widget.halfscreen;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarkPhotoPickerView f445930a;

    public c(LarkPhotoPickerView r100) {
        this.f445930a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LarkPhotoPickerView.d r101 = this.f445930a.H;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }
}
