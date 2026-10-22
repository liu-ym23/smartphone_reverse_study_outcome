package com.ss.android.ugc.aweme.search.common.utils;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/utils/TradeSearchContentType;", "", "MIDDLE", "RESULT", "SUG", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum TradeSearchContentType extends Enum<TradeSearchContentType> {
    public static final TradeSearchContentType MIDDLE = null;
    public static final TradeSearchContentType RESULT = null;
    public static final TradeSearchContentType SUG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TradeSearchContentType[] f452291a = null;

    public static TradeSearchContentType valueOf(String r100) {
        return (TradeSearchContentType) a.a(TradeSearchContentType.class, r100);
    }

    public static TradeSearchContentType[] values() {
        return (TradeSearchContentType[]) f452291a.clone();
    }

    static {
        TradeSearchContentType r100 = new TradeSearchContentType("MIDDLE", 0);
        MIDDLE = r100;
        TradeSearchContentType r101 = new TradeSearchContentType("RESULT", 1);
        RESULT = r101;
        TradeSearchContentType r102 = new TradeSearchContentType("SUG", 2);
        SUG = r102;
        f452291a = new TradeSearchContentType[]{r100, r101, r102};
    }

    public TradeSearchContentType(String r100, int r101) {
        super(r100, r101);
    }
}
