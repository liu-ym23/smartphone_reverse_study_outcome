package com.bytedance.live.livelink.kmp.impl.core.rtc;

import com.bytedance.live.livelink.kmp.api.core.rtc.PublicStreamType;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f255425a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f255426b = null;

    static {
        int[] r100 = new int[PublicStreamType.values().length];
        f255425a = r100;
        PublicStreamType r101 = PublicStreamType.VIDEO;
        r100[r101.ordinal()] = 1;
        PublicStreamType r102 = PublicStreamType.AUDIO;
        r100[r102.ordinal()] = 2;
        PublicStreamType r103 = PublicStreamType.VIDEO_AUDIO;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[PublicStreamType.values().length];
        f255426b = r104;
        r104[r102.ordinal()] = 1;
        r104[r101.ordinal()] = 2;
        r104[r103.ordinal()] = 3;
    }
}
