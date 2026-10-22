package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes35.dex */
public final class h implements Interpolator {
    public h() {
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        boolean r101 = false;
        if (r100 != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return 0.0f;
    L9:
        if (r100 != 1.0f) goto L11;
        r101 = true;
    L11:
        if (r101 == false) goto L14;
        return 1.0f;
    L14:
        return (float) ((((double) ((float) Math.pow(2.0f, (-10) * r100))) * Math.sin((((double) (r100 * 10)) - 0.75d) * 2.0943951023931953d)) + ((double) 1));
    L5:
        r102 = false;
        goto L6
    }
}
