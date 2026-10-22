package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class m implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DescriptionSection f443394a;

    public m(DescriptionSection r100) {
        this.f443394a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        this.f443394a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.h.f443704a);
        return false;
    }
}
