package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum SubscribeFallbackOptions extends Enum<SubscribeFallbackOptions> {
    private static final /* synthetic */ SubscribeFallbackOptions[] $VALUES = null;
    public static final SubscribeFallbackOptions SUBSCRIBE_FALLBACK_OPTIONS_AUDIO_ONLY = null;
    public static final SubscribeFallbackOptions SUBSCRIBE_FALLBACK_OPTIONS_DISABLED = null;
    public static final SubscribeFallbackOptions SUBSCRIBE_FALLBACK_OPTIONS_STREAM_LOW = null;
    private int value;

    static {
        SubscribeFallbackOptions r100 = new SubscribeFallbackOptions("SUBSCRIBE_FALLBACK_OPTIONS_DISABLED", 0, 0);
        SUBSCRIBE_FALLBACK_OPTIONS_DISABLED = r100;
        SubscribeFallbackOptions r101 = new SubscribeFallbackOptions("SUBSCRIBE_FALLBACK_OPTIONS_STREAM_LOW", 1, 1);
        SUBSCRIBE_FALLBACK_OPTIONS_STREAM_LOW = r101;
        SubscribeFallbackOptions r102 = new SubscribeFallbackOptions("SUBSCRIBE_FALLBACK_OPTIONS_AUDIO_ONLY", 2, 2);
        SUBSCRIBE_FALLBACK_OPTIONS_AUDIO_ONLY = r102;
        $VALUES = new SubscribeFallbackOptions[]{r100, r101, r102};
    }

    public static SubscribeFallbackOptions[] values() {
        return (SubscribeFallbackOptions[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static SubscribeFallbackOptions fromId(int r100) {
        SubscribeFallbackOptions[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        SubscribeFallbackOptions r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static SubscribeFallbackOptions valueOf(String r100) {
        return (SubscribeFallbackOptions) a.a(SubscribeFallbackOptions.class, r100);
    }

    private SubscribeFallbackOptions(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
