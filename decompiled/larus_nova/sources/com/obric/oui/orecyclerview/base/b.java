package com.obric.oui.orecyclerview.base;

import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f401540a = 0;

    public static final class a {
        public static float b(float r100, float r101) {
            if (r100 >= 0.0f) goto L5;
            return 0.0f;
        L5:
            if (r101 > 0.0f) goto L8;
            return 0.0f;
        L8:
            return (1.0f - (1.0f / (((r100 / r101) * 0.55f) + 1.0f))) * r101;
        }

        public static float a(float r100, float r101) {
            if (r100 >= 0.0f) goto L5;
            return 0.0f;
        L5:
            if (r101 <= 0.0f) goto L10;
            float r102 = RangesKt.coerceAtMost(r100, r101 - 1.0E-5f);
            return ((r101 * r102) / (r101 - r102)) / 0.55f;
        L10:
            return 0.0f;
        }
    }

    static {
    }
}
