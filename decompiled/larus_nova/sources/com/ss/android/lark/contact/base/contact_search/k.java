package com.ss.android.lark.contact.base.contact_search;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes35.dex */
public final class k implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f418811a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public k(s r100) {
        this.f418811a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        this.f418811a.B = true;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        this.f418811a.f418832y.setEnabled(false);
        return;
    L5:
        this.f418811a.f418832y.setEnabled(true);
    }
}
