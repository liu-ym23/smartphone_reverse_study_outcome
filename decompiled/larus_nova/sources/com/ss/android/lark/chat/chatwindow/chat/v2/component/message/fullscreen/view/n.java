package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes35.dex */
public final class n implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GestureDetector f414133a;

    public n(GestureDetector r100) {
        this.f414133a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        return this.f414133a.onTouchEvent(r101);
    }
}
