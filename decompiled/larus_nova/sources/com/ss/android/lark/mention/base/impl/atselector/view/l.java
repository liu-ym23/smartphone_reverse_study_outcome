package com.ss.android.lark.mention.base.impl.atselector.view;

import android.view.View;
import com.larksuite.framework.utils.KeyboardUtils;

/* JADX INFO: loaded from: classes36.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtView f431850a;

    public l(AtView r100) {
        this.f431850a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f431850a.mSearchEt.setFocusable(true);
        this.f431850a.mSearchEt.setFocusableInTouchMode(true);
        this.f431850a.mSearchEt.requestFocus();
        KeyboardUtils.showKeyboard(this.f431850a.f431811b);
    }
}
