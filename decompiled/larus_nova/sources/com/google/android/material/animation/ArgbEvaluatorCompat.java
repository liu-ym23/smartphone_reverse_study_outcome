package com.google.android.material.animation;

import android.animation.TypeEvaluator;

/* JADX INFO: loaded from: classes23.dex */
public class ArgbEvaluatorCompat implements TypeEvaluator<Integer> {
    private static final ArgbEvaluatorCompat instance = null;

    public ArgbEvaluatorCompat() {
    }

    static {
        instance = new ArgbEvaluatorCompat();
    }

    public static ArgbEvaluatorCompat getInstance() {
        return instance;
    }

    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public Integer evaluate2(float r110, Integer r111, Integer r112) {
        int r113 = r111.intValue();
        float r100 = ((r113 >> 24) & 255) / 255.0f;
        int r114 = r112.intValue();
        float r101 = (float) Math.pow(((r113 >> 16) & 255) / 255.0f, 2.2d);
        float r102 = (float) Math.pow(((r113 >> 8) & 255) / 255.0f, 2.2d);
        float r115 = (float) Math.pow((r113 & 255) / 255.0f, 2.2d);
        float r103 = (float) Math.pow(((r114 >> 16) & 255) / 255.0f, 2.2d);
        float r104 = r100 + (((((r114 >> 24) & 255) / 255.0f) - r100) * r110);
        float r105 = r102 + ((((float) Math.pow(((r114 >> 8) & 255) / 255.0f, 2.2d)) - r102) * r110);
        float r116 = r115 + (r110 * (((float) Math.pow((r114 & 255) / 255.0f, 2.2d)) - r115));
        float r117 = ((float) Math.pow(r101 + ((r103 - r101) * r110), 0.45454545454545453d)) * 255.0f;
        float r118 = ((float) Math.pow(r105, 0.45454545454545453d)) * 255.0f;
        float r119 = ((float) Math.pow(r116, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf((((Math.round(r117) << 16) | (Math.round(r104 * 255.0f) << 24)) | (Math.round(r118) << 8)) | Math.round(r119));
    }

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ Integer evaluate(float r100, Integer r101, Integer r102) {
        return evaluate2(r100, r101, r102);
    }
}
