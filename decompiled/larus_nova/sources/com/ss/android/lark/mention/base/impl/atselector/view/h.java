package com.ss.android.lark.mention.base.impl.atselector.view;

import android.view.View;
import com.larksuite.framework.utils.KeyboardUtils;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtView f431846a;

    public h(AtView r100) {
        this.f431846a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        KeyboardUtils.hideKeyboard(this.f431846a.f431811b);
        this.f431846a.f431812c.y();
    }
}
