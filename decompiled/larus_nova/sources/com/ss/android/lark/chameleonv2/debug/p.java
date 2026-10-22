package com.ss.android.lark.chameleonv2.debug;

import android.view.View;
import android.widget.AutoCompleteTextView;

/* JADX INFO: loaded from: classes35.dex */
public final class p implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AutoCompleteTextView f411412a;

    public p(AutoCompleteTextView r100) {
        this.f411412a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f411412a.showDropDown();
    }
}
