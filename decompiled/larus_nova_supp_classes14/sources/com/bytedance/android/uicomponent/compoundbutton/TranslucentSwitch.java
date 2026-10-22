package com.bytedance.android.uicomponent.compoundbutton;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.SwitchCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class TranslucentSwitch extends SwitchCompat {
    public TranslucentSwitch(Context r1) {
        super(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r8) {
        float r3 = getWidth();
        float r4 = getHeight();
        if (isEnabled() == false) goto L5;
        int r5 = 255;
    L6:
        r8.saveLayerAlpha(0.0f, 0.0f, r3, r4, r5, 31);
        super.onDraw(r8);
        r8.restore();
        return;
    L5:
        r5 = 127;
        goto L6
    }

    public TranslucentSwitch(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public TranslucentSwitch(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
