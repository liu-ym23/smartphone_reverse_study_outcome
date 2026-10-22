package com.larus.dora.o.impl.diary;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes27.dex */
public final class j0 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f338555a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public j0(i0 r100) {
        this.f338555a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        i0 r101 = this.f338555a;
        if (r100 == null) goto L5;
        int r102 = r100.length();
    L6:
        r101.d(r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }
}
