package com.larus.avlink.aiproactive;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes23.dex */
public final class g0 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AiProactiveTaskEditDialog f291571a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public g0(AiProactiveTaskEditDialog r100) {
        this.f291571a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        AiProactiveTaskEditDialog r101 = this.f291571a;
        if (r100 == null) goto L5;
        int r102 = r100.length();
    L6:
        int r103 = AiProactiveTaskEditDialog.f291537i;
        r101.T90(r102);
        this.f291571a.S90(r100);
        return;
    L5:
        r102 = 0;
        goto L6
    }
}
