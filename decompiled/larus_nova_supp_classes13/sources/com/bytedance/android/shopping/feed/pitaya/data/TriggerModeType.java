package com.bytedance.android.shopping.feed.pitaya.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/feed/pitaya/data/TriggerModeType;", "", "", "type", "I", "getType", "()I", "OTHER_USER", "NEW_USER", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TriggerModeType extends Enum<TriggerModeType> {
    public static final TriggerModeType NEW_USER = null;
    public static final TriggerModeType OTHER_USER = null;
    public static final /* synthetic */ TriggerModeType[] a = null;
    private final int type;

    static {
        TriggerModeType r1 = new TriggerModeType("OTHER_USER", 0, 0);
        OTHER_USER = r1;
        TriggerModeType r2 = new TriggerModeType("NEW_USER", 1, 1);
        NEW_USER = r2;
        a = new TriggerModeType[]{r1, r2};
    }

    public static TriggerModeType valueOf(String r1) {
        return (TriggerModeType) a.a(TriggerModeType.class, r1);
    }

    public static TriggerModeType[] values() {
        return (TriggerModeType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public TriggerModeType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
