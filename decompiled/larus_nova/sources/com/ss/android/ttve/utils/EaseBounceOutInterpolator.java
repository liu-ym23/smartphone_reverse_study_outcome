package com.ss.android.ttve.utils;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes38.dex */
public class EaseBounceOutInterpolator implements TimeInterpolator {
    public EaseBounceOutInterpolator() {
    }

    public EaseBounceOutInterpolator(Context r100, AttributeSet r101) {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r100) {
        double r101 = r100;
        if (r101 >= 0.36363636363636365d) goto L7;
        return (7.5625f * r100) * r100;
    L7:
        if (r101 >= 0.7272727272727273d) goto L11;
        float r102 = r100 - 0.54545456f;
        return ((7.5625f * r102) * r102) + 0.75f;
    L11:
        if (r101 >= 0.9090909090909091d) goto L14;
        float r103 = r100 - 0.8181818f;
        return ((7.5625f * r103) * r103) + 0.9375f;
    L14:
        float r104 = r100 - 0.95454544f;
        return ((7.5625f * r104) * r104) + 0.984375f;
    }
}
