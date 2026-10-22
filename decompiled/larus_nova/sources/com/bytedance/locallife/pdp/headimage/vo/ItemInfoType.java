package com.bytedance.locallife.pdp.headimage.vo;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/pdp/headimage/vo/ItemInfoType;", "", "", "type", "I", "getType", "()I", "PIC", "VIDEO", "RATE", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum ItemInfoType extends Enum<ItemInfoType> {
    public static final ItemInfoType PIC = null;
    public static final ItemInfoType RATE = null;
    public static final ItemInfoType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ItemInfoType[] f261548a = null;
    private final int type;

    public static ItemInfoType valueOf(String r100) {
        return (ItemInfoType) a.a(ItemInfoType.class, r100);
    }

    public static ItemInfoType[] values() {
        return (ItemInfoType[]) f261548a.clone();
    }

    static {
        ItemInfoType r100 = new ItemInfoType("PIC", 0, 1);
        PIC = r100;
        ItemInfoType r101 = new ItemInfoType("VIDEO", 1, 2);
        VIDEO = r101;
        ItemInfoType r102 = new ItemInfoType("RATE", 2, 3);
        RATE = r102;
        f261548a = new ItemInfoType[]{r100, r101, r102};
    }

    public final int getType() {
        return this.type;
    }

    public ItemInfoType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
