package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum FallbackOrRecoverReason extends Enum<FallbackOrRecoverReason> {
    private static final /* synthetic */ FallbackOrRecoverReason[] $VALUES = null;
    public static final FallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_BANDWIDTH = null;
    public static final FallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_PERFORMANCE = null;
    public static final FallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_BANDWIDTH = null;
    public static final FallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_PERFORMANCE = null;
    public static final FallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_BANDWIDTH = null;
    public static final FallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_PERFORMANCE = null;
    public static final FallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_BANDWIDTH = null;
    public static final FallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_PERFORMANCE = null;
    public static final FallbackOrRecoverReason FALLBACK_OR_RECOVER_REASON_UNKNOWN = null;
    int value;

    static {
        FallbackOrRecoverReason r100 = new FallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_UNKNOWN", 0, -1);
        FALLBACK_OR_RECOVER_REASON_UNKNOWN = r100;
        FallbackOrRecoverReason r101 = new FallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_BANDWIDTH", 1, 0);
        FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_BANDWIDTH = r101;
        FallbackOrRecoverReason r102 = new FallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_PERFORMANCE", 2, 1);
        FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_PERFORMANCE = r102;
        FallbackOrRecoverReason r103 = new FallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_BANDWIDTH", 3, 2);
        FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_BANDWIDTH = r103;
        FallbackOrRecoverReason r104 = new FallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_PERFORMANCE", 4, 3);
        FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_PERFORMANCE = r104;
        FallbackOrRecoverReason r105 = new FallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_BANDWIDTH", 5, 4);
        FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_BANDWIDTH = r105;
        FallbackOrRecoverReason r110 = new FallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_PERFORMANCE", 6, 5);
        FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_PERFORMANCE = r110;
        FallbackOrRecoverReason r111 = new FallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_BANDWIDTH", 7, 6);
        FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_BANDWIDTH = r111;
        FallbackOrRecoverReason r112 = new FallbackOrRecoverReason("FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_PERFORMANCE", 8, 7);
        FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_PERFORMANCE = r112;
        $VALUES = new FallbackOrRecoverReason[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static FallbackOrRecoverReason[] values() {
        return (FallbackOrRecoverReason[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static FallbackOrRecoverReason valueOf(String r100) {
        return (FallbackOrRecoverReason) a.a(FallbackOrRecoverReason.class, r100);
    }

    private FallbackOrRecoverReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
