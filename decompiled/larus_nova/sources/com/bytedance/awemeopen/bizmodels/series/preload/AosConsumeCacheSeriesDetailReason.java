package com.bytedance.awemeopen.bizmodels.series.preload;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/series/preload/AosConsumeCacheSeriesDetailReason;", "", "", "reason", "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "SDK_USER_ENTER_SERIES_PLAY", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final enum AosConsumeCacheSeriesDetailReason extends Enum<AosConsumeCacheSeriesDetailReason> {
    public static final AosConsumeCacheSeriesDetailReason SDK_USER_ENTER_SERIES_PLAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AosConsumeCacheSeriesDetailReason[] f198208a = null;
    private final String reason;

    public static AosConsumeCacheSeriesDetailReason valueOf(String r100) {
        return (AosConsumeCacheSeriesDetailReason) a.a(AosConsumeCacheSeriesDetailReason.class, r100);
    }

    public static AosConsumeCacheSeriesDetailReason[] values() {
        return (AosConsumeCacheSeriesDetailReason[]) f198208a.clone();
    }

    static {
        AosConsumeCacheSeriesDetailReason r100 = new AosConsumeCacheSeriesDetailReason();
        SDK_USER_ENTER_SERIES_PLAY = r100;
        f198208a = new AosConsumeCacheSeriesDetailReason[]{r100};
    }

    public AosConsumeCacheSeriesDetailReason() {
        super("SDK_USER_ENTER_SERIES_PLAY", 0);
        this.reason = "sdk_user_enter_series_play";
    }

    public final String getReason() {
        return this.reason;
    }
}
