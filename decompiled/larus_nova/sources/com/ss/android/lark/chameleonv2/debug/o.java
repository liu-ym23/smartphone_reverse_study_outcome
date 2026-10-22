package com.ss.android.lark.chameleonv2.debug;

import android.view.View;
import android.widget.AutoCompleteTextView;

/* JADX INFO: loaded from: classes35.dex */
public final class o implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AutoCompleteTextView f411411a;

    public o(AutoCompleteTextView r100) {
        this.f411411a = r100;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        if (r101 == false) goto L4;
        this.f411411a.showDropDown();
        return;
    L4:
        this.f411411a.dismissDropDown();
    }
}
