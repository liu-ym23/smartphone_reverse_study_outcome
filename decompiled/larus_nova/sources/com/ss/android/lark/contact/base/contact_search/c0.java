package com.ss.android.lark.contact.base.contact_search;

import android.view.View;
import com.larksuite.framework.utils.KeyboardUtils;

/* JADX INFO: loaded from: classes35.dex */
public final class c0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f418797a;

    public c0(b0 r100) {
        this.f418797a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        KeyboardUtils.hideKeyboard(this.f418797a.f418775a.getActivity());
    }
}
