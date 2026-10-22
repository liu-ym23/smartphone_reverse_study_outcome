package com.ss.android.ugc.aweme.search.optimize;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/search/optimize/ResponseStatus;", "", "ON_COMMON_DATA_RECEIVED", "ON_FORECAST_DATA_RECEIVED", "FORECAST_HIT", "FORECAST_MISS", "ON_REAL_DATA_RECEIVED_AFTER_MISS", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum ResponseStatus extends Enum<ResponseStatus> {
    public static final ResponseStatus FORECAST_HIT = null;
    public static final ResponseStatus FORECAST_MISS = null;
    public static final ResponseStatus ON_COMMON_DATA_RECEIVED = null;
    public static final ResponseStatus ON_FORECAST_DATA_RECEIVED = null;
    public static final ResponseStatus ON_REAL_DATA_RECEIVED_AFTER_MISS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResponseStatus[] f453357a = null;

    public static ResponseStatus valueOf(String r100) {
        return (ResponseStatus) a.a(ResponseStatus.class, r100);
    }

    public static ResponseStatus[] values() {
        return (ResponseStatus[]) f453357a.clone();
    }

    static {
        ResponseStatus r100 = new ResponseStatus("ON_COMMON_DATA_RECEIVED", 0);
        ON_COMMON_DATA_RECEIVED = r100;
        ResponseStatus r101 = new ResponseStatus("ON_FORECAST_DATA_RECEIVED", 1);
        ON_FORECAST_DATA_RECEIVED = r101;
        ResponseStatus r102 = new ResponseStatus("FORECAST_HIT", 2);
        FORECAST_HIT = r102;
        ResponseStatus r103 = new ResponseStatus("FORECAST_MISS", 3);
        FORECAST_MISS = r103;
        ResponseStatus r104 = new ResponseStatus("ON_REAL_DATA_RECEIVED_AFTER_MISS", 4);
        ON_REAL_DATA_RECEIVED_AFTER_MISS = r104;
        f453357a = new ResponseStatus[]{r100, r101, r102, r103, r104};
    }

    public ResponseStatus(String r100, int r101) {
        super(r100, r101);
    }
}
