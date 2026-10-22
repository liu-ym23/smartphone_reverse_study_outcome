package com.bytedance.lynx.webview.internal;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes21.dex */
public final class m0 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SwitchValuesActivity f265335a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public m0(SwitchValuesActivity r100) {
        this.f265335a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        SwitchValuesActivity r101 = this.f265335a;
        r101.f265195g = r100.toString().trim();
        if (this.f265335a.f265195g.isEmpty() == false) goto L6;
        this.f265335a.a();
        return;
    }
}
