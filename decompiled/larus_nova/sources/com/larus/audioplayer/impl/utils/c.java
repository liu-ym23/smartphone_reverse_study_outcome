package com.larus.audioplayer.impl.utils;

import com.larus.audioplayer.api.stream.StreamPlayerStatus;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f290479a = null;

    static {
        int[] r100 = new int[StreamPlayerStatus.values().length];
        r100[StreamPlayerStatus.PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r100[StreamPlayerStatus.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r100[StreamPlayerStatus.STOPPED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        f290479a = r100;
    }
}
