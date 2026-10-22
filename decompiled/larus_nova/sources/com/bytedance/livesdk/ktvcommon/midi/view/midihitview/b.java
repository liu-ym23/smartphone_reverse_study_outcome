package com.bytedance.livesdk.ktvcommon.midi.view.midihitview;

import com.bytedance.livesdk.ktvcommon.midi.model.HitType;

/* JADX INFO: loaded from: classes20.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f256174a = null;

    static {
        int[] r100 = new int[HitType.values().length];
        f256174a = r100;
        r100[HitType.GOOD.ordinal()] = 1;
        r100[HitType.GREAT.ordinal()] = 2;
        r100[HitType.PERFECT.ordinal()] = 3;
    }
}
