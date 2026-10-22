package com.bytedance.awemeopen.bizmodels.series.preload;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/series/preload/AosPreloadSeriesDetailReason;", "", "", "reason", "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "ENTER_SERIES_FEED", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final enum AosPreloadSeriesDetailReason extends Enum<AosPreloadSeriesDetailReason> {
    public static final AosPreloadSeriesDetailReason ENTER_SERIES_FEED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AosPreloadSeriesDetailReason[] f198210a = null;
    private final String reason;

    public static AosPreloadSeriesDetailReason valueOf(String r100) {
        return (AosPreloadSeriesDetailReason) a.a(AosPreloadSeriesDetailReason.class, r100);
    }

    public static AosPreloadSeriesDetailReason[] values() {
        return (AosPreloadSeriesDetailReason[]) f198210a.clone();
    }

    static {
        AosPreloadSeriesDetailReason r100 = new AosPreloadSeriesDetailReason();
        ENTER_SERIES_FEED = r100;
        f198210a = new AosPreloadSeriesDetailReason[]{r100};
    }

    public AosPreloadSeriesDetailReason() {
        super("ENTER_SERIES_FEED", 0);
        this.reason = "enter_series_feed";
    }

    public final String getReason() {
        return this.reason;
    }
}
