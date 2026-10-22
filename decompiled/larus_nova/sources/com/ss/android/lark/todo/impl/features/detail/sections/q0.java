package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class q0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DetailSubTaskSection f443424a;

    public q0(DetailSubTaskSection r100) {
        this.f443424a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        DetailSubTaskSection r101 = this.f443424a;
        long r102 = r101.f443213i;
        r101.f443213i = System.currentTimeMillis();
        DetailSubTaskSection r103 = this.f443424a;
        if ((r103.f443213i - r102) >= 500) goto L6;
        return;
    L6:
        if (r103.f443211g.getEditableText().length() != 0) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        this.f443424a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.x2.f443793a);
        return;
    L12:
        this.f443424a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.n.f443740a);
        return;
    L8:
        r104 = false;
        goto L9
    }
}
