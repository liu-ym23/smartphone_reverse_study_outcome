package com.bytedance.awemeopen.apps.framework.feed.pinch.utils;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements View.OnTouchListener {
    public c() {
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r3, MotionEvent r4) {
        int r5 = r4.getAction();
        if (r5 != 0) goto L5;
        r3.setAlpha(0.5f);
        return false;
    L5:
        if (r5 == 1) goto L10;
        if (r5 == 3) goto L10;
        return false;
    L10:
        if (r3.getAlpha() != 0.5f) goto L15;
        r3.setAlpha(1.0f);
        return false;
    L15:
        return false;
    }
}
