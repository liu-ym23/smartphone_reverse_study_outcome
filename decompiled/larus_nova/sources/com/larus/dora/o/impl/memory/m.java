package com.larus.dora.o.impl.memory;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

/* JADX INFO: loaded from: classes27.dex */
public final class m implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f338817a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public m(l r100) {
        this.f338817a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        l r101 = this.f338817a;
        if (r100 == null) goto L5;
        int r102 = r100.length();
    L6:
        TextView r103 = r101.f338814e;
        if (r103 == null) goto L10;
        r103.setText(r102 + "/300");
        return;
    L10:
        return;
    L5:
        r102 = 0;
        goto L6
    }
}
