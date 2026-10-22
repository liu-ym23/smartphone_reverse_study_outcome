package com.obric.miniapp.lynx;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes33.dex */
public final class y3 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxOUISearchBarUI f398338a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public y3(LynxOUISearchBarUI r100) {
        this.f398338a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        LynxOUISearchBarUI r101 = this.f398338a;
        if (r101.f397989c == false) goto L5;
        return;
    L5:
        if (r100 == null) goto L7;
        String r102 = r100.toString();
    L8:
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        r101.O("input", r102);
        return;
    L7:
        r102 = null;
        goto L8
    }
}
