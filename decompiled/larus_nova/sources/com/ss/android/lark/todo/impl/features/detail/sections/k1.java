package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class k1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f443385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SummarySection f443386b;

    public k1(SummarySection r100) {
        this.f443386b = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f443385a;
        long r102 = System.currentTimeMillis();
        this.f443385a = r102;
        if ((r102 - r101) >= 500) goto L6;
        return;
    L6:
        if (this.f443386b.f443275l.isEnabled() == false) goto L9;
        this.f443386b.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.d3.f443684a);
        return;
    }
}
