package com.ss.bytertc.engine.data;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum EarMonitorAudioFilter extends Enum<EarMonitorAudioFilter> {
    private static final /* synthetic */ EarMonitorAudioFilter[] $VALUES = null;
    public static final EarMonitorAudioFilter NONE = null;
    public static final EarMonitorAudioFilter REUSE_AUDIO_PROCESSING = null;
    private int value;

    static {
        EarMonitorAudioFilter r100 = new EarMonitorAudioFilter(UserProfileEvent.POSITION_NONE, 0, 1);
        NONE = r100;
        EarMonitorAudioFilter r101 = new EarMonitorAudioFilter("REUSE_AUDIO_PROCESSING", 1, 32768);
        REUSE_AUDIO_PROCESSING = r101;
        $VALUES = new EarMonitorAudioFilter[]{r100, r101};
    }

    public static EarMonitorAudioFilter[] values() {
        return (EarMonitorAudioFilter[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this != NONE) goto L5;
        return "kEarMonitorAudioFilterNone";
    L5:
        return "kEarMonitorAudioFilterReuseAudioProcessing";
    }

    public int value() {
        return this.value;
    }

    public static EarMonitorAudioFilter fromId(int r100) {
        EarMonitorAudioFilter[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        EarMonitorAudioFilter r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static EarMonitorAudioFilter valueOf(String r100) {
        return (EarMonitorAudioFilter) a.a(EarMonitorAudioFilter.class, r100);
    }

    private EarMonitorAudioFilter(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
