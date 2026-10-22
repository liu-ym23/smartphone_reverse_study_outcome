package com.larus.livetutor.impl.view;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes30.dex */
public final class n implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonFeedbackDialog f356874a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public n(CommonFeedbackDialog r100) {
        this.f356874a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        CommonFeedbackDialog r101 = this.f356874a;
        int r102 = CommonFeedbackDialog.f356691y;
        r101.U0();
    }
}
