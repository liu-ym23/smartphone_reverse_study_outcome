package com.bytedance.live.livelink.kmp.impl.extend.chorus;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f255573a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f255574b = null;

    static {
        int[] r100 = new int[LiveWrappedStreamIndex.values().length];
        f255573a = r100;
        LiveWrappedStreamIndex r101 = LiveWrappedStreamIndex.STREAM_INDEX_MAIN;
        r100[r101.ordinal()] = 1;
        LiveWrappedStreamIndex r102 = LiveWrappedStreamIndex.STREAM_INDEX_3RD;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[LiveWrappedStreamIndex.values().length];
        f255574b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
    }
}
