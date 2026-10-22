package com.ss.android.lark.contact.base.contact_search;

import android.view.View;

/* JADX INFO: loaded from: classes35.dex */
public final class p implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f418816a;

    public p(s r100) {
        this.f418816a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f418816a.f418825r.hasFocus() == false) goto L5;
        s r101 = this.f418816a;
        r101.A = true;
        r101.f();
        return;
    L5:
        s r102 = this.f418816a;
        s.a r103 = r102.f418821n;
        if (r103 == null) goto L10;
        r103.a(r102.f418825r.getText().toString().replace(" ", ""), false, this.f418816a.B);
        return;
    }
}
