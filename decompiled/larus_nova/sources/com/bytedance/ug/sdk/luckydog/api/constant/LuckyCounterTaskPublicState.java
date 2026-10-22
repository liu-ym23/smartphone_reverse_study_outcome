package com.bytedance.ug.sdk.luckydog.api.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ug/sdk/luckydog/api/constant/LuckyCounterTaskPublicState;", "", "CREATED", "DESTROYED", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final enum LuckyCounterTaskPublicState extends Enum<LuckyCounterTaskPublicState> {
    public static final LuckyCounterTaskPublicState CREATED = null;
    public static final LuckyCounterTaskPublicState DESTROYED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LuckyCounterTaskPublicState[] f271567a = null;

    static {
        LuckyCounterTaskPublicState r100 = new LuckyCounterTaskPublicState("CREATED", 0);
        CREATED = r100;
        LuckyCounterTaskPublicState r101 = new LuckyCounterTaskPublicState("DESTROYED", 1);
        DESTROYED = r101;
        f271567a = new LuckyCounterTaskPublicState[]{r100, r101};
    }

    public static LuckyCounterTaskPublicState valueOf(String r100) {
        return (LuckyCounterTaskPublicState) a.a(LuckyCounterTaskPublicState.class, r100);
    }

    public static LuckyCounterTaskPublicState[] values() {
        return (LuckyCounterTaskPublicState[]) f271567a.clone();
    }

    public LuckyCounterTaskPublicState(String r100, int r101) {
        super(r100, r101);
    }
}
