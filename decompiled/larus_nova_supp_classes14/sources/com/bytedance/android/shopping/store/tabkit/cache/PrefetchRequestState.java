package com.bytedance.android.shopping.store.tabkit.cache;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/cache/PrefetchRequestState;", "", "", "value", "I", "getValue", "()I", "NO_MATCH", "NO_STORE", "MATCH_SUCCESS_NORMAL", "MATCH_SUCCESS_EXPIRED", "MATCH_QUERY_FAILED", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PrefetchRequestState extends Enum<PrefetchRequestState> {
    public static final PrefetchRequestState MATCH_QUERY_FAILED = null;
    public static final PrefetchRequestState MATCH_SUCCESS_EXPIRED = null;
    public static final PrefetchRequestState MATCH_SUCCESS_NORMAL = null;
    public static final PrefetchRequestState NO_MATCH = null;
    public static final PrefetchRequestState NO_STORE = null;
    public static final /* synthetic */ PrefetchRequestState[] a = null;
    private final int value;

    static {
        PrefetchRequestState r1 = new PrefetchRequestState("NO_MATCH", 0, -1);
        NO_MATCH = r1;
        PrefetchRequestState r2 = new PrefetchRequestState("NO_STORE", 1, 0);
        NO_STORE = r2;
        PrefetchRequestState r3 = new PrefetchRequestState("MATCH_SUCCESS_NORMAL", 2, 1);
        MATCH_SUCCESS_NORMAL = r3;
        PrefetchRequestState r4 = new PrefetchRequestState("MATCH_SUCCESS_EXPIRED", 3, 2);
        MATCH_SUCCESS_EXPIRED = r4;
        PrefetchRequestState r5 = new PrefetchRequestState("MATCH_QUERY_FAILED", 4, 3);
        MATCH_QUERY_FAILED = r5;
        a = new PrefetchRequestState[]{r1, r2, r3, r4, r5};
    }

    public static PrefetchRequestState valueOf(String r1) {
        return (PrefetchRequestState) r27.a.a(PrefetchRequestState.class, r1);
    }

    public static PrefetchRequestState[] values() {
        return (PrefetchRequestState[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public PrefetchRequestState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
