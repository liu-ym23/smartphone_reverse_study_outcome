package com.ss.android.lark.chameleonv2.debug;

import android.view.View;
import android.widget.AutoCompleteTextView;

/* JADX INFO: loaded from: classes35.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AutoCompleteTextView f411392a;

    public i(AutoCompleteTextView r100) {
        this.f411392a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f411392a.showDropDown();
    }
}
