package com.bytedance.lynx.webview.internal;

import android.view.View;

/* JADX INFO: loaded from: classes21.dex */
public final class l0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SwitchValuesActivity f265334a;

    public l0(SwitchValuesActivity r100) {
        this.f265334a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f265334a.finish();
    }
}
