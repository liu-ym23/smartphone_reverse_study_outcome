package com.bytedance.awemeopen.apps.framework.feed.pinch.utils;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements View.OnTouchListener {
    public c() {
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        int r102 = r101.getAction();
        if (r102 != 0) goto L5;
        r100.setAlpha(0.5f);
        return false;
    L5:
        if (r102 == 1) goto L10;
        if (r102 == 3) goto L10;
        return false;
    L10:
        if (r100.getAlpha() != 0.5f) goto L15;
        r100.setAlpha(1.0f);
        return false;
    L15:
        return false;
    }
}
