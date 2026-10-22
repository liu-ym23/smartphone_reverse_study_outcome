package com.ss.android.lark.todo.impl.features.detail.at.view;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoAtView f442819a;

    public f(TodoAtView r100) {
        this.f442819a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        this.f442819a.S5();
        return true;
    }
}
