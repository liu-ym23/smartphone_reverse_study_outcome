package com.bytedance.android.livesdk.livecommerce.playback.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/utils/LiveReplayPageOptEnums;", "", "", "trial", "I", "getTrial", "()I", "DEFAULT", "SINGLE_CARD", "MULTI_CARD", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveReplayPageOptEnums extends Enum<LiveReplayPageOptEnums> {
    public static final LiveReplayPageOptEnums DEFAULT = null;
    public static final LiveReplayPageOptEnums MULTI_CARD = null;
    public static final LiveReplayPageOptEnums SINGLE_CARD = null;
    public static final /* synthetic */ LiveReplayPageOptEnums[] a = null;
    private final int trial;

    static {
        LiveReplayPageOptEnums r1 = new LiveReplayPageOptEnums("DEFAULT", 0, 0);
        DEFAULT = r1;
        LiveReplayPageOptEnums r2 = new LiveReplayPageOptEnums("SINGLE_CARD", 1, 1);
        SINGLE_CARD = r2;
        LiveReplayPageOptEnums r3 = new LiveReplayPageOptEnums("MULTI_CARD", 2, 2);
        MULTI_CARD = r3;
        a = new LiveReplayPageOptEnums[]{r1, r2, r3};
    }

    public static LiveReplayPageOptEnums valueOf(String r1) {
        return (LiveReplayPageOptEnums) r27.a.a(LiveReplayPageOptEnums.class, r1);
    }

    public static LiveReplayPageOptEnums[] values() {
        return (LiveReplayPageOptEnums[]) a.clone();
    }

    public final int getTrial() {
        return this.trial;
    }

    public LiveReplayPageOptEnums(String r1, int r2, int r3) {
        super(r1, r2);
        this.trial = r3;
    }
}
