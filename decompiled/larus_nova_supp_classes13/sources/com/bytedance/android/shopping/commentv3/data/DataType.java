package com.bytedance.android.shopping.commentv3.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/DataType;", "", "", "type", "I", "getType", "()I", "PRODUCT", "SIMILAR", "MIX", "FUSION", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DataType extends Enum<DataType> {
    public static final DataType FUSION = null;
    public static final DataType MIX = null;
    public static final DataType PRODUCT = null;
    public static final DataType SIMILAR = null;
    public static final /* synthetic */ DataType[] a = null;
    private final int type;

    static {
        DataType r1 = new DataType("PRODUCT", 0, 0);
        PRODUCT = r1;
        DataType r2 = new DataType("SIMILAR", 1, 1);
        SIMILAR = r2;
        DataType r3 = new DataType("MIX", 2, 2);
        MIX = r3;
        DataType r4 = new DataType("FUSION", 3, 3);
        FUSION = r4;
        a = new DataType[]{r1, r2, r3, r4};
    }

    public static DataType valueOf(String r1) {
        return (DataType) r27.a.a(DataType.class, r1);
    }

    public static DataType[] values() {
        return (DataType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public DataType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
