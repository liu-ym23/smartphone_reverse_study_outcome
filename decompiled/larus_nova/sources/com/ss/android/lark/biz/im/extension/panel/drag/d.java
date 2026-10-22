package com.ss.android.lark.biz.im.extension.panel.drag;

import android.view.View;

/* JADX INFO: loaded from: classes34.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DragPanel f410533a;

    public d(DragPanel r100) {
        this.f410533a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        DragPanel.f(this.f410533a);
    }
}
