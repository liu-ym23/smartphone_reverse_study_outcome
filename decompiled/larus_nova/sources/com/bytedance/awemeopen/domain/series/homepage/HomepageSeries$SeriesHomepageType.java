package com.bytedance.awemeopen.domain.series.homepage;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"com/bytedance/awemeopen/domain/series/homepage/HomepageSeries$SeriesHomepageType", "", "Lcom/bytedance/awemeopen/domain/series/homepage/HomepageSeries$SeriesHomepageType;", "", "value", "I", "getValue", "()I", "TYPE_TITLE", "TYPE_SERIES", "TYPE_DIVIDER", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public final enum HomepageSeries$SeriesHomepageType extends Enum<HomepageSeries$SeriesHomepageType> {
    public static final HomepageSeries$SeriesHomepageType TYPE_DIVIDER = null;
    public static final HomepageSeries$SeriesHomepageType TYPE_SERIES = null;
    public static final HomepageSeries$SeriesHomepageType TYPE_TITLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HomepageSeries$SeriesHomepageType[] f198457a = null;
    private final int value;

    public static HomepageSeries$SeriesHomepageType valueOf(String r100) {
        return (HomepageSeries$SeriesHomepageType) a.a(HomepageSeries$SeriesHomepageType.class, r100);
    }

    public static HomepageSeries$SeriesHomepageType[] values() {
        return (HomepageSeries$SeriesHomepageType[]) f198457a.clone();
    }

    static {
        HomepageSeries$SeriesHomepageType r100 = new HomepageSeries$SeriesHomepageType("TYPE_TITLE", 0, 1);
        TYPE_TITLE = r100;
        HomepageSeries$SeriesHomepageType r101 = new HomepageSeries$SeriesHomepageType("TYPE_SERIES", 1, 2);
        TYPE_SERIES = r101;
        HomepageSeries$SeriesHomepageType r102 = new HomepageSeries$SeriesHomepageType("TYPE_DIVIDER", 2, 3);
        TYPE_DIVIDER = r102;
        f198457a = new HomepageSeries$SeriesHomepageType[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public HomepageSeries$SeriesHomepageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
