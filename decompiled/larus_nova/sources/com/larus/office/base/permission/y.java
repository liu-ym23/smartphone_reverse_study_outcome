package com.larus.office.base.permission;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes29.dex */
public final class y implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PasswordInputFragment f360687a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public y(PasswordInputFragment r100) {
        this.f360687a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        boolean r102 = !r101;
        PasswordInputFragment r103 = this.f360687a;
        if (r103.f360632e == true) goto L13;
        r103.W90(r102);
        return;
    L13:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
