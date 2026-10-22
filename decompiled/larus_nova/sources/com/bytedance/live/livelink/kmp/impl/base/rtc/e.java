package com.bytedance.live.livelink.kmp.impl.base.rtc;

import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f255313a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f255314b = null;

    static {
        int[] r100 = new int[MixStreamType.values().length];
        f255313a = r100;
        MixStreamType r101 = MixStreamType.SERVER_MIX;
        r100[r101.ordinal()] = 1;
        MixStreamType r102 = MixStreamType.RTC_CLIENT_MIX;
        r100[r102.ordinal()] = 2;
        MixStreamType r103 = MixStreamType.CLIENT_MIX;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[MixStreamType.values().length];
        f255314b = r104;
        r104[r101.ordinal()] = 1;
        r104[r103.ordinal()] = 2;
        r104[r102.ordinal()] = 3;
    }
}
