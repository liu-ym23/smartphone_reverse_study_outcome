package com.bytedance.locallife.pdp.headimage.vo;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/locallife/pdp/headimage/vo/PointInfoType;", "", "", "type", "I", "getType", "()I", "MARQUEE", "BUYER_SHOW", "REC_DISH", "RATE", "SUPER_DISCOUNT", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum PointInfoType extends Enum<PointInfoType> {
    public static final PointInfoType BUYER_SHOW = null;
    public static final PointInfoType MARQUEE = null;
    public static final PointInfoType RATE = null;
    public static final PointInfoType REC_DISH = null;
    public static final PointInfoType SUPER_DISCOUNT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PointInfoType[] f261549a = null;
    private final int type;

    public static PointInfoType valueOf(String r100) {
        return (PointInfoType) a.a(PointInfoType.class, r100);
    }

    public static PointInfoType[] values() {
        return (PointInfoType[]) f261549a.clone();
    }

    static {
        PointInfoType r100 = new PointInfoType("MARQUEE", 0, 1);
        MARQUEE = r100;
        PointInfoType r101 = new PointInfoType("BUYER_SHOW", 1, 2);
        BUYER_SHOW = r101;
        PointInfoType r102 = new PointInfoType("REC_DISH", 2, 3);
        REC_DISH = r102;
        PointInfoType r103 = new PointInfoType("RATE", 3, 4);
        RATE = r103;
        PointInfoType r104 = new PointInfoType("SUPER_DISCOUNT", 4, 5);
        SUPER_DISCOUNT = r104;
        f261549a = new PointInfoType[]{r100, r101, r102, r103, r104};
    }

    public final int getType() {
        return this.type;
    }

    public PointInfoType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
