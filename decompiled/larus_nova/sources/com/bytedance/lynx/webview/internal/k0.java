package com.bytedance.lynx.webview.internal;

import android.view.View;

/* JADX INFO: loaded from: classes21.dex */
public final class k0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SwitchValuesActivity f265332a;

    public k0(SwitchValuesActivity r100) {
        this.f265332a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f265332a.f265189a.setText("");
        SwitchValuesActivity r101 = this.f265332a;
        r101.f265195g = "";
        r101.a();
    }
}
