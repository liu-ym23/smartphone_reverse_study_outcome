package com.larus.kmp.voice_setting.voice.ui;

import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes30.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f355038a = 0;

    static {
    }

    public static float a(float r100, float r101) {
        if (r101 > 0.0f) goto L5;
    L7:
        float r102 = 1.0f;
    L9:
        return Dp.m7544constructorimpl(r100 * r102);
    L5:
        if (r101 >= 600.0f) goto L7;
        r102 = r101 / 390.0f;
        goto L9
    }
}
