package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f436490a;

    public b(c r100) {
        this.f436490a = r100;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f436490a.f436492b.onDismiss();
    }
}
