package com.larus.im.internal.audio.session.omni;

import com.larus.im.service.audio.AvAudioKitMode;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f347321a = null;

    static {
        int[] r100 = new int[AvAudioKitMode.values().length];
        r100[AvAudioKitMode.PURE_AV.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L13:
        r100[AvAudioKitMode.PURE_RTC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L19:
        r100[AvAudioKitMode.MIX_SPEECH_BIZ.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L15:
        r100[AvAudioKitMode.PURE_BIZ.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L7:
        f347321a = r100;
    }
}
