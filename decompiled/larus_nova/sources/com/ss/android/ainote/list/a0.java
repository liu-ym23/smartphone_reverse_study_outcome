package com.ss.android.ainote.list;

import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes34.dex */
public final class a0 implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AINoteListView f407055a;

    public a0(AINoteListView r100) {
        this.f407055a = r100;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        AINoteListView r100 = this.f407055a;
        Long r101 = r100.f406986v;
        r100.f406985u = null;
        r100.f406986v = null;
        r100.getClass();
        this.f407055a.O();
        if (r101 == null) goto L8;
        AINoteItemView r102 = this.f407055a.p(r101.longValue());
        if (r102 == null) goto L9;
        r102.setHighlighted(false);
        return;
    L9:
        return;
    }
}
