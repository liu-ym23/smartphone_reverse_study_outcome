package com.ss.android.ugc.tools.repository.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/tools/repository/api/CommonDataState;", "", "UNKNOWN", "NOT_DOWNLOAD", "DOWNLOADING", "DOWNLOAD_SUCCESS", "DOWNLOAD_FAILED", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final enum CommonDataState extends Enum<CommonDataState> {
    public static final CommonDataState DOWNLOADING = null;
    public static final CommonDataState DOWNLOAD_FAILED = null;
    public static final CommonDataState DOWNLOAD_SUCCESS = null;
    public static final CommonDataState NOT_DOWNLOAD = null;
    public static final CommonDataState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommonDataState[] f454845a = null;

    static {
        CommonDataState r100 = new CommonDataState("UNKNOWN", 0);
        UNKNOWN = r100;
        CommonDataState r101 = new CommonDataState("NOT_DOWNLOAD", 1);
        NOT_DOWNLOAD = r101;
        CommonDataState r102 = new CommonDataState("DOWNLOADING", 2);
        DOWNLOADING = r102;
        CommonDataState r103 = new CommonDataState("DOWNLOAD_SUCCESS", 3);
        DOWNLOAD_SUCCESS = r103;
        CommonDataState r104 = new CommonDataState("DOWNLOAD_FAILED", 4);
        DOWNLOAD_FAILED = r104;
        f454845a = new CommonDataState[]{r100, r101, r102, r103, r104};
    }

    public static CommonDataState valueOf(String r100) {
        return (CommonDataState) a.a(CommonDataState.class, r100);
    }

    public static CommonDataState[] values() {
        return (CommonDataState[]) f454845a.clone();
    }

    public CommonDataState(String r100, int r101) {
        super(r100, r101);
    }
}
