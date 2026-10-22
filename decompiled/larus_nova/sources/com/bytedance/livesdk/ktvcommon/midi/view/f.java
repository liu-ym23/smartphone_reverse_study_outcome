package com.bytedance.livesdk.ktvcommon.midi.view;

import com.bytedance.livesdk.ktvcommon.midi.model.HitType;

/* JADX INFO: loaded from: classes20.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f256087a = null;

    static {
        int[] r100 = new int[HitType.values().length];
        HitType r101 = HitType.GOOD;
        r100[r101.ordinal()] = 1;
        HitType r102 = HitType.GREAT;
        r100[r102.ordinal()] = 2;
        HitType r103 = HitType.PERFECT;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[HitType.values().length];
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        r104[r103.ordinal()] = 3;
        int[] r105 = new int[HitType.values().length];
        r105[r101.ordinal()] = 1;
        r105[r102.ordinal()] = 2;
        r105[r103.ordinal()] = 3;
        int[] r106 = new int[HitType.values().length];
        f256087a = r106;
        r106[r101.ordinal()] = 1;
        r106[r102.ordinal()] = 2;
        r106[r103.ordinal()] = 3;
    }
}
