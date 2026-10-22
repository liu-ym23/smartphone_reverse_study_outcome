package com.ss.android.ugc.aweme.poi.bean;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/bean/PoiUgcSearchOptionType;", "", "", "value", "I", "getValue", "()I", "SORT_BY", "FILTER_BY", "IMPRESSION", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum PoiUgcSearchOptionType extends Enum<PoiUgcSearchOptionType> {
    public static final PoiUgcSearchOptionType FILTER_BY = null;
    public static final PoiUgcSearchOptionType IMPRESSION = null;
    public static final PoiUgcSearchOptionType SORT_BY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiUgcSearchOptionType[] f451315a = null;
    private final int value;

    public static PoiUgcSearchOptionType valueOf(String r100) {
        return (PoiUgcSearchOptionType) a.a(PoiUgcSearchOptionType.class, r100);
    }

    public static PoiUgcSearchOptionType[] values() {
        return (PoiUgcSearchOptionType[]) f451315a.clone();
    }

    static {
        PoiUgcSearchOptionType r100 = new PoiUgcSearchOptionType("SORT_BY", 0, 1);
        SORT_BY = r100;
        PoiUgcSearchOptionType r101 = new PoiUgcSearchOptionType("FILTER_BY", 1, 2);
        FILTER_BY = r101;
        PoiUgcSearchOptionType r102 = new PoiUgcSearchOptionType("IMPRESSION", 2, 3);
        IMPRESSION = r102;
        f451315a = new PoiUgcSearchOptionType[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public PoiUgcSearchOptionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
