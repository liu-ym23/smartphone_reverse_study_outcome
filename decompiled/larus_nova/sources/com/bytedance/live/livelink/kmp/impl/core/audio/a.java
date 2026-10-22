package com.bytedance.live.livelink.kmp.impl.core.audio;

import com.bytedance.live.livelink.kmp.api.core.audio.AudioMode;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f255359a = null;

    static {
        int[] r100 = new int[AudioMode.values().length];
        f255359a = r100;
        r100[AudioMode.MODE_MIC.ordinal()] = 1;
        r100[AudioMode.MODE_VOICE_COMMUNICATION.ordinal()] = 2;
        r100[AudioMode.MODE_VOICE_CALL.ordinal()] = 3;
    }
}
