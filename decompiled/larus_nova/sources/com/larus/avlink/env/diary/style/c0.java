package com.larus.avlink.env.diary.style;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes25.dex */
public final class c0 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DiaryStyleInputDialog f292133a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public c0(DiaryStyleInputDialog r100) {
        this.f292133a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        DiaryStyleInputDialog r101 = this.f292133a;
        int r102 = DiaryStyleInputDialog.f292112j;
        r101.S90(r100);
    }
}
