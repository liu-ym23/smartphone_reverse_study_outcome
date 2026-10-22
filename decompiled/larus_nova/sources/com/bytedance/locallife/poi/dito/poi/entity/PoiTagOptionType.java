package com.bytedance.locallife.poi.dito.poi.entity;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/poi/dito/poi/entity/PoiTagOptionType;", "", "", "value", "I", "getValue", "()I", CancelRetainContactInfoFunctions.All, "Hot", "BackendTypeTag", "CityLiveTag", "CitySearchPageHotTag", "CityMallTag", "CityTravelOnSite", "CityTravelGuideLine", "CityTravelRecentOnSite", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum PoiTagOptionType extends Enum<PoiTagOptionType> {
    public static final PoiTagOptionType All = null;
    public static final PoiTagOptionType BackendTypeTag = null;
    public static final PoiTagOptionType CityLiveTag = null;
    public static final PoiTagOptionType CityMallTag = null;
    public static final PoiTagOptionType CitySearchPageHotTag = null;
    public static final PoiTagOptionType CityTravelGuideLine = null;
    public static final PoiTagOptionType CityTravelOnSite = null;
    public static final PoiTagOptionType CityTravelRecentOnSite = null;
    public static final PoiTagOptionType Hot = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiTagOptionType[] f262538a = null;
    private final int value;

    public static PoiTagOptionType valueOf(String r100) {
        return (PoiTagOptionType) a.a(PoiTagOptionType.class, r100);
    }

    public static PoiTagOptionType[] values() {
        return (PoiTagOptionType[]) f262538a.clone();
    }

    static {
        PoiTagOptionType r100 = new PoiTagOptionType(CancelRetainContactInfoFunctions.All, 0, 1);
        All = r100;
        PoiTagOptionType r101 = new PoiTagOptionType("Hot", 1, 2);
        Hot = r101;
        PoiTagOptionType r102 = new PoiTagOptionType("BackendTypeTag", 2, 3);
        BackendTypeTag = r102;
        PoiTagOptionType r103 = new PoiTagOptionType("CityLiveTag", 3, 4);
        CityLiveTag = r103;
        PoiTagOptionType r104 = new PoiTagOptionType("CitySearchPageHotTag", 4, 5);
        CitySearchPageHotTag = r104;
        PoiTagOptionType r110 = new PoiTagOptionType("CityMallTag", 5, 6);
        CityMallTag = r110;
        PoiTagOptionType r111 = new PoiTagOptionType("CityTravelOnSite", 6, 7);
        CityTravelOnSite = r111;
        PoiTagOptionType r112 = new PoiTagOptionType("CityTravelGuideLine", 7, 8);
        CityTravelGuideLine = r112;
        PoiTagOptionType r113 = new PoiTagOptionType("CityTravelRecentOnSite", 8, 9);
        CityTravelRecentOnSite = r113;
        f262538a = new PoiTagOptionType[]{r100, r101, r102, r103, r104, r110, r111, r112, r113};
    }

    public final int getValue() {
        return this.value;
    }

    public PoiTagOptionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
