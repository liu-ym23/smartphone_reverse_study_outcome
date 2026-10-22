package com.bytedance.android.shopping.commentv3.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/FusionState;", "", "", "type", "I", "getType", "()I", "Companion", "a", "PRODUCT", "FUSION", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FusionState extends Enum<FusionState> {
    public static final a Companion = null;
    public static final FusionState FUSION = null;
    public static final FusionState PRODUCT = null;
    public static final /* synthetic */ FusionState[] a = null;
    private final int type;

    public static final class a {
        public a() {
        }
    }

    static {
        FusionState r1 = new FusionState("PRODUCT", 0, 0);
        PRODUCT = r1;
        FusionState r2 = new FusionState("FUSION", 1, 1);
        FUSION = r2;
        a = new FusionState[]{r1, r2};
        Companion = new a();
    }

    public static FusionState valueOf(String r1) {
        return (FusionState) r27.a.a(FusionState.class, r1);
    }

    public static FusionState[] values() {
        return (FusionState[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public FusionState(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
