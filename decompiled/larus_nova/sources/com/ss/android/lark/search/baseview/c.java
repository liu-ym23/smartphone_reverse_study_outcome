package com.ss.android.lark.search.baseview;

import android.view.View;
import java.util.Iterator;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchInputView f439923a;

    public c(SearchInputView r100) {
        this.f439923a = r100;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        Iterator<T> r102 = this.f439923a.f439903i.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((View.OnFocusChangeListener) r102.next()).onFocusChange(r100, r101);
        goto L4
    }
}
