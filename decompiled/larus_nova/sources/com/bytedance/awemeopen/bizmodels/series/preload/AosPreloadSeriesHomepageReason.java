package com.bytedance.awemeopen.bizmodels.series.preload;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/series/preload/AosPreloadSeriesHomepageReason;", "", "", "reason", "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "HOST_INVOKE_PRELOAD", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final enum AosPreloadSeriesHomepageReason extends Enum<AosPreloadSeriesHomepageReason> {
    public static final AosPreloadSeriesHomepageReason HOST_INVOKE_PRELOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AosPreloadSeriesHomepageReason[] f198211a = null;
    private final String reason;

    public static AosPreloadSeriesHomepageReason valueOf(String r100) {
        return (AosPreloadSeriesHomepageReason) a.a(AosPreloadSeriesHomepageReason.class, r100);
    }

    public static AosPreloadSeriesHomepageReason[] values() {
        return (AosPreloadSeriesHomepageReason[]) f198211a.clone();
    }

    static {
        AosPreloadSeriesHomepageReason r100 = new AosPreloadSeriesHomepageReason();
        HOST_INVOKE_PRELOAD = r100;
        f198211a = new AosPreloadSeriesHomepageReason[]{r100};
    }

    public AosPreloadSeriesHomepageReason() {
        super("HOST_INVOKE_PRELOAD", 0);
        this.reason = "host_invoke_preload";
    }

    public final String getReason() {
        return this.reason;
    }
}
