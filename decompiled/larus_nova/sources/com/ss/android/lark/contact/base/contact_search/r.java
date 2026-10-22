package com.ss.android.lark.contact.base.contact_search;

import android.view.View;

/* JADX INFO: loaded from: classes35.dex */
public final class r implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f418818a;

    public r(s r100) {
        this.f418818a = r100;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        if (r101 == false) goto L9;
        s r102 = this.f418818a;
        if (r102.f418829v.getText().length() == 0) goto L6;
        boolean r103 = true;
    L7:
        r102.m(Boolean.valueOf(r103));
        return;
    L6:
        r103 = false;
        goto L7
    }
}
