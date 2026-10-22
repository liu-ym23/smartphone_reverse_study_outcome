package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service;

/* JADX INFO: loaded from: classes37.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f434410a = null;

    static {
        int[] r100 = new int[MinutesForegroundService.ForegroundServiceType.values().length];
        r100[MinutesForegroundService.ForegroundServiceType.RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r100[MinutesForegroundService.ForegroundServiceType.HARDWARE_LIVE_RECORDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r100[MinutesForegroundService.ForegroundServiceType.DATA_SYNC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        f434410a = r100;
    }
}
