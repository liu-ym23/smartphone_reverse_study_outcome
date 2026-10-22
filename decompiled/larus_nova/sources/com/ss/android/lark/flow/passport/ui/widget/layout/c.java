package com.ss.android.lark.flow.passport.ui.widget.layout;

import android.view.View;
import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes36.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonContainerLayout f423881a;

    public c(CommonContainerLayout r100) {
        this.f423881a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        uzb.b.C7950b r101 = (uzb.b.C7950b) r100;
        View r102 = this.f423881a.findFocus();
        if (this.f423881a.getIntercept() == true) goto L6;
        this.f423881a.getOnImeChangeHandler().invoke(r102, Boolean.valueOf(r101.f552243a), Integer.valueOf(r101.f552244b));
        return;
    }
}
