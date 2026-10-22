package com.ss.android.lark.forwardv2.impl.view;

import android.text.Editable;
import android.text.TextWatcher;
import com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView;

/* JADX INFO: loaded from: classes36.dex */
public final class o implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForwardClickableEnhancedView f425026a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public o(ForwardClickableEnhancedView r100) {
        this.f425026a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        this.f425026a.k1(r100);
    }
}
