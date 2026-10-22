package com.bytedance.android.shopping.api.sku;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/api/sku/PassThroughAppendType;", "", "", "value", "I", "getValue", "()I", "ADD", "MERGE", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final enum PassThroughAppendType extends Enum<PassThroughAppendType> {
    public static final PassThroughAppendType ADD = null;
    public static final PassThroughAppendType MERGE = null;
    public static final /* synthetic */ PassThroughAppendType[] a = null;
    private final int value;

    static {
        PassThroughAppendType r1 = new PassThroughAppendType("ADD", 0, 0);
        ADD = r1;
        PassThroughAppendType r2 = new PassThroughAppendType("MERGE", 1, 1);
        MERGE = r2;
        a = new PassThroughAppendType[]{r1, r2};
    }

    public static PassThroughAppendType valueOf(String r1) {
        return (PassThroughAppendType) a.a(PassThroughAppendType.class, r1);
    }

    public static PassThroughAppendType[] values() {
        return (PassThroughAppendType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public PassThroughAppendType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
