package com.larus.dora.o.impl.diary.style;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes27.dex */
public final class a0 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f338617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f338618b;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        b0 r101 = this.f338617a;
        Context r102 = this.f338618b;
        if (r100 == null) goto L5;
        int r103 = r100.length();
    L6:
        r101.b(r102, r103);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public a0(b0 r100, Context r101) {
        this.f338617a = r100;
        this.f338618b = r101;
    }
}
