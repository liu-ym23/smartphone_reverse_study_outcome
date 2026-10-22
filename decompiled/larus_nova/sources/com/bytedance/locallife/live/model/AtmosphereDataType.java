package com.bytedance.locallife.live.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/locallife/live/model/AtmosphereDataType;", "", "", "value", "I", "getValue", "()I", "Default", "SoldCount", "Stock", "ExclusivePrice", "ExclusiveChannel", "ReviewCount", "SoldCount30Day", "Repurchase", "ReviewRating", "Refund", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum AtmosphereDataType extends Enum<AtmosphereDataType> {
    public static final AtmosphereDataType Default = null;
    public static final AtmosphereDataType ExclusiveChannel = null;
    public static final AtmosphereDataType ExclusivePrice = null;
    public static final AtmosphereDataType Refund = null;
    public static final AtmosphereDataType Repurchase = null;
    public static final AtmosphereDataType ReviewCount = null;
    public static final AtmosphereDataType ReviewRating = null;
    public static final AtmosphereDataType SoldCount = null;
    public static final AtmosphereDataType SoldCount30Day = null;
    public static final AtmosphereDataType Stock = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtmosphereDataType[] f260616a = null;
    private final int value;

    public static AtmosphereDataType valueOf(String r100) {
        return (AtmosphereDataType) a.a(AtmosphereDataType.class, r100);
    }

    public static AtmosphereDataType[] values() {
        return (AtmosphereDataType[]) f260616a.clone();
    }

    static {
        AtmosphereDataType r100 = new AtmosphereDataType("Default", 0, 0);
        Default = r100;
        AtmosphereDataType r101 = new AtmosphereDataType("SoldCount", 1, 1);
        SoldCount = r101;
        AtmosphereDataType r102 = new AtmosphereDataType("Stock", 2, 2);
        Stock = r102;
        AtmosphereDataType r103 = new AtmosphereDataType("ExclusivePrice", 3, 3);
        ExclusivePrice = r103;
        AtmosphereDataType r104 = new AtmosphereDataType("ExclusiveChannel", 4, 4);
        ExclusiveChannel = r104;
        AtmosphereDataType r105 = new AtmosphereDataType("ReviewCount", 5, 5);
        ReviewCount = r105;
        AtmosphereDataType r110 = new AtmosphereDataType("SoldCount30Day", 6, 6);
        SoldCount30Day = r110;
        AtmosphereDataType r111 = new AtmosphereDataType("Repurchase", 7, 7);
        Repurchase = r111;
        AtmosphereDataType r112 = new AtmosphereDataType("ReviewRating", 8, 8);
        ReviewRating = r112;
        AtmosphereDataType r113 = new AtmosphereDataType("Refund", 9, 9);
        Refund = r113;
        f260616a = new AtmosphereDataType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public final int getValue() {
        return this.value;
    }

    public AtmosphereDataType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
