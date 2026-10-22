package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class e1 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SummarySection f443355a;

    public e1(SummarySection r100) {
        this.f443355a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (this.f443355a.f443273j.getKeyListener() == null) goto L8;
        if (r101.getAction() != 1) goto L8;
        this.f443355a.b().e(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.f0.f443693a, false);
    L8:
        if (r101.getAction() != 0) goto L10;
        this.f443355a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.h.f443704a);
    L10:
        return false;
    }
}
