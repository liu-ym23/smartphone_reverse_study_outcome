package com.ss.android.lark.chat.video;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes35.dex */
public final class l implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f416825a;

    public l(h r100) {
        this.f416825a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r110, MotionEvent r111) {
        Rect r112 = new Rect();
        this.f416825a.f416803o.getHitRect(r112);
        if (r111.getY() >= (r112.top - 500)) goto L5;
        return false;
    L5:
        if (r111.getY() > (r112.bottom + 500)) goto L17;
        float r100 = r112.top + (r112.height() / 2);
        float r101 = r111.getX() - r112.left;
        if (r101 >= 0.0f) goto L10;
        float r102 = 0.0f;
    L14:
        return this.f416825a.f416803o.onTouchEvent(MotionEvent.obtain(r111.getDownTime(), r111.getEventTime(), r111.getAction(), r102, r100, r111.getMetaState()));
    L10:
        if (r101 <= r112.width()) goto L12;
        r102 = r112.width();
        goto L14
    L12:
        r102 = r101;
        goto L14
    L17:
        return false;
    }
}
