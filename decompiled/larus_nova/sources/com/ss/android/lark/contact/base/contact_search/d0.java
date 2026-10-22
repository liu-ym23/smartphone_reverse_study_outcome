package com.ss.android.lark.contact.base.contact_search;

import android.view.View;
import com.larksuite.framework.utils.KeyboardUtils;

/* JADX INFO: loaded from: classes35.dex */
public final class d0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f418799a;

    public d0(b0 r100) {
        this.f418799a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        b0 r101 = this.f418799a;
        r101.f418776b.x0(r101.f418779e.getText().toString().replace(" ", ""));
        KeyboardUtils.hideKeyboard(this.f418799a.f418775a.getActivity());
    }
}
