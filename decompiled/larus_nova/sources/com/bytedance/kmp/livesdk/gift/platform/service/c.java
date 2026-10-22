package com.bytedance.kmp.livesdk.gift.platform.service;

import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f252441a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f252442b = null;

    static {
        int[] r100 = new int[ReceiverType.values().length];
        f252441a = r100;
        ReceiverType r101 = ReceiverType.Anchor;
        r100[r101.ordinal()] = 1;
        ReceiverType r102 = ReceiverType.Guest;
        r100[r102.ordinal()] = 2;
        ReceiverType r103 = ReceiverType.Audience;
        r100[r103.ordinal()] = 3;
        ReceiverType r104 = ReceiverType.OtherAnchor;
        r100[r104.ordinal()] = 4;
        int[] r105 = new int[ReceiverType.values().length];
        f252442b = r105;
        r105[r101.ordinal()] = 1;
        r105[r102.ordinal()] = 2;
        r105[r104.ordinal()] = 3;
        r105[r103.ordinal()] = 4;
    }
}
