package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VideoSimulcastMode extends Enum<VideoSimulcastMode> {
    private static final /* synthetic */ VideoSimulcastMode[] $VALUES = null;
    public static final VideoSimulcastMode VIDEO_SIMULCAST_MODE_ALWAYS_SIMULCAST = null;
    public static final VideoSimulcastMode VIDEO_SIMULCAST_MODE_ONLY_ONE = null;
    public static final VideoSimulcastMode VIDEO_SIMULCAST_MODE_ON_DEMAND = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.VideoSimulcastMode$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$VideoSimulcastMode = null;

        static {
            int[] r100 = new int[VideoSimulcastMode.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$VideoSimulcastMode = r100;
            r100[VideoSimulcastMode.VIDEO_SIMULCAST_MODE_ONLY_ONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$ss$bytertc$engine$data$VideoSimulcastMode[VideoSimulcastMode.VIDEO_SIMULCAST_MODE_ON_DEMAND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$bytertc$engine$data$VideoSimulcastMode[VideoSimulcastMode.VIDEO_SIMULCAST_MODE_ALWAYS_SIMULCAST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        VideoSimulcastMode r100 = new VideoSimulcastMode("VIDEO_SIMULCAST_MODE_ONLY_ONE", 0, 0);
        VIDEO_SIMULCAST_MODE_ONLY_ONE = r100;
        VideoSimulcastMode r101 = new VideoSimulcastMode("VIDEO_SIMULCAST_MODE_ON_DEMAND", 1, 1);
        VIDEO_SIMULCAST_MODE_ON_DEMAND = r101;
        VideoSimulcastMode r102 = new VideoSimulcastMode("VIDEO_SIMULCAST_MODE_ALWAYS_SIMULCAST", 2, 2);
        VIDEO_SIMULCAST_MODE_ALWAYS_SIMULCAST = r102;
        $VALUES = new VideoSimulcastMode[]{r100, r101, r102};
    }

    public static VideoSimulcastMode[] values() {
        return (VideoSimulcastMode[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$VideoSimulcastMode[ordinal()];
        if (r100 != 1) goto L5;
        return "kVideoSimulcastModeOnlyOne";
    L5:
        if (r100 != 2) goto L7;
        return "kVideoSimulcastModeOnDemand";
    L7:
        if (r100 == 3) goto L10;
        return "valid";
    L10:
        return "kVideoSimulcastModeAlwaysSimulcast";
    }

    public int value() {
        return this.value;
    }

    public static VideoSimulcastMode fromId(int r100) {
        VideoSimulcastMode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        VideoSimulcastMode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static VideoSimulcastMode valueOf(String r100) {
        return (VideoSimulcastMode) a.a(VideoSimulcastMode.class, r100);
    }

    private VideoSimulcastMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
