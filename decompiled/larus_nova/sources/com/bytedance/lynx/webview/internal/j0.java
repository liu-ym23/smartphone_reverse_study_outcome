package com.bytedance.lynx.webview.internal;

import android.view.View;

/* JADX INFO: loaded from: classes21.dex */
public final class j0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SwitchValuesActivity f265331a;

    public j0(SwitchValuesActivity r100) {
        this.f265331a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        SwitchValuesActivity r101 = this.f265331a;
        r101.f265195g = r101.f265189a.getText().toString().trim();
        r101.a();
    }
}
