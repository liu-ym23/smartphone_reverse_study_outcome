package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes36.dex */
public class o extends ArrowKeyMovementMethod {
    public o() {
    }

    @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView r100, Spannable r101, MotionEvent r102) {
        boolean r103 = false;
        if (r102 != null) goto L5;
    L7:
        if (r103 == false) goto L11;
        return Touch.onTouchEvent(r100, r101, r102);
    L11:
        return super.onTouchEvent(r100, r101, r102);
    L5:
        if (r102.getActionMasked() != 1) goto L7;
        r103 = true;
        goto L7
    }
}
