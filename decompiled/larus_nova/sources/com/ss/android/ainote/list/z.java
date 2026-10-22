package com.ss.android.ainote.list;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes34.dex */
public final class z implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f407126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AINoteListView f407127b;

    public z(View r100, AINoteListView r101) {
        this.f407126a = r100;
        this.f407127b = r101;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r101.getAction() == 0) goto L5;
        return false;
    L5:
        Rect r102 = new Rect();
        this.f407126a.getGlobalVisibleRect(r102);
        if (r102.contains((int) r101.getRawX(), (int) r101.getRawY()) == true) goto L9;
        AINoteListView r103 = this.f407127b;
        int r104 = AINoteListView.f406958k1;
        r103.m();
        return true;
    L9:
        return false;
    }
}
