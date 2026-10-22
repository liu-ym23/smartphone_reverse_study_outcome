package com.ss.android.lark.keyboard.plugin.tool.voice.vote;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f430841a = null;

    static {
        f430841a = new b();
    }

    public b() {
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if ((r100 instanceof EditText) == false) goto L10;
        EditText r102 = (EditText) r100;
        r102.getParent().requestDisallowInterceptTouchEvent(true);
        int r103 = r101.getAction() & 255;
        if (r103 != 1) goto L7;
    L9:
        r102.getParent().requestDisallowInterceptTouchEvent(false);
        goto L10
    L7:
        if (r103 == 3) goto L9;
    L10:
        return false;
    }
}
