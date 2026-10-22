package com.bytedance.locallife.live.goodsshelves.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/ProductSubType;", "", "", "value", "J", "getValue", "()J", "House", "IntentionVoucher", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum ProductSubType extends Enum<ProductSubType> {
    public static final ProductSubType House = null;
    public static final ProductSubType IntentionVoucher = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProductSubType[] f259582a = null;
    private final long value;

    public static ProductSubType valueOf(String r100) {
        return (ProductSubType) r27.a.a(ProductSubType.class, r100);
    }

    public static ProductSubType[] values() {
        return (ProductSubType[]) f259582a.clone();
    }

    static {
        ProductSubType r100 = new ProductSubType("House", 0, 2001);
        House = r100;
        ProductSubType r101 = new ProductSubType("IntentionVoucher", 1, 1102);
        IntentionVoucher = r101;
        f259582a = new ProductSubType[]{r100, r101};
    }

    public final long getValue() {
        return this.value;
    }

    public ProductSubType(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
