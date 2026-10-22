package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/eventcenter/ability/LiveListAtomicRefreshType;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "SILENCE", "LOADING_RESET", "SILENCE_RESET_TO_ALL_TAB", "SILENCE_RESET_TO_TOP", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveListAtomicRefreshType extends Enum<LiveListAtomicRefreshType> {
    public static final LiveListAtomicRefreshType LOADING_RESET = null;
    public static final LiveListAtomicRefreshType SILENCE = null;
    public static final LiveListAtomicRefreshType SILENCE_RESET_TO_ALL_TAB = null;
    public static final LiveListAtomicRefreshType SILENCE_RESET_TO_TOP = null;
    public static final LiveListAtomicRefreshType UNKNOWN = null;
    public static final /* synthetic */ LiveListAtomicRefreshType[] a = null;
    private final int value;

    static {
        LiveListAtomicRefreshType r1 = new LiveListAtomicRefreshType("UNKNOWN", 0, 0);
        UNKNOWN = r1;
        LiveListAtomicRefreshType r2 = new LiveListAtomicRefreshType("SILENCE", 1, 1);
        SILENCE = r2;
        LiveListAtomicRefreshType r3 = new LiveListAtomicRefreshType("LOADING_RESET", 2, 2);
        LOADING_RESET = r3;
        LiveListAtomicRefreshType r4 = new LiveListAtomicRefreshType("SILENCE_RESET_TO_ALL_TAB", 3, 3);
        SILENCE_RESET_TO_ALL_TAB = r4;
        LiveListAtomicRefreshType r5 = new LiveListAtomicRefreshType("SILENCE_RESET_TO_TOP", 4, 4);
        SILENCE_RESET_TO_TOP = r5;
        a = new LiveListAtomicRefreshType[]{r1, r2, r3, r4, r5};
    }

    public static LiveListAtomicRefreshType valueOf(String r1) {
        return (LiveListAtomicRefreshType) r27.a.a(LiveListAtomicRefreshType.class, r1);
    }

    public static LiveListAtomicRefreshType[] values() {
        return (LiveListAtomicRefreshType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveListAtomicRefreshType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
