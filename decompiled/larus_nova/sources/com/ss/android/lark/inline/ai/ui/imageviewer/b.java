package com.ss.android.lark.inline.ai.ui.imageviewer;

import android.view.View;
import androidx.appcompat.widget.AppCompatCheckBox;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageViewerFragment<Object> f427556a;

    public b(ImageViewerFragment<Object> r100) {
        this.f427556a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AppCompatCheckBox r101 = this.f427556a.f427541i;
        if (r101 == null) goto L6;
        r101.performClick();
        return;
    }
}
