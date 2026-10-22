package com.bytedance.ee.android.file.picker.lib.v2.ui;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConfirmActivity f206085a;

    public a(ConfirmActivity r100) {
        this.f206085a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f206085a.finish();
    }
}
