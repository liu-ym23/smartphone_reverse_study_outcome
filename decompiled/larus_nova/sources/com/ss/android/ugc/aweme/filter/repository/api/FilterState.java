package com.ss.android.ugc.aweme.filter.repository.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/filter/repository/api/FilterState;", "", "FILTER_STATE_UNKNOWN", "FILTER_STATE_NOT_DOWNLOAD", "FILTER_STATE_DOWNLOADING", "FILTER_STATE_DOWNLOAD_SUCCESS", "FILTER_STATE_DOWNLOAD_FAILED", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final enum FilterState extends Enum<FilterState> {
    public static final FilterState FILTER_STATE_DOWNLOADING = null;
    public static final FilterState FILTER_STATE_DOWNLOAD_FAILED = null;
    public static final FilterState FILTER_STATE_DOWNLOAD_SUCCESS = null;
    public static final FilterState FILTER_STATE_NOT_DOWNLOAD = null;
    public static final FilterState FILTER_STATE_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FilterState[] f450846a = null;

    static {
        FilterState r100 = new FilterState("FILTER_STATE_UNKNOWN", 0);
        FILTER_STATE_UNKNOWN = r100;
        FilterState r101 = new FilterState("FILTER_STATE_NOT_DOWNLOAD", 1);
        FILTER_STATE_NOT_DOWNLOAD = r101;
        FilterState r102 = new FilterState("FILTER_STATE_DOWNLOADING", 2);
        FILTER_STATE_DOWNLOADING = r102;
        FilterState r103 = new FilterState("FILTER_STATE_DOWNLOAD_SUCCESS", 3);
        FILTER_STATE_DOWNLOAD_SUCCESS = r103;
        FilterState r104 = new FilterState("FILTER_STATE_DOWNLOAD_FAILED", 4);
        FILTER_STATE_DOWNLOAD_FAILED = r104;
        f450846a = new FilterState[]{r100, r101, r102, r103, r104};
    }

    public static FilterState valueOf(String r100) {
        return (FilterState) a.a(FilterState.class, r100);
    }

    public static FilterState[] values() {
        return (FilterState[]) f450846a.clone();
    }

    public FilterState(String r100, int r101) {
        super(r100, r101);
    }
}
