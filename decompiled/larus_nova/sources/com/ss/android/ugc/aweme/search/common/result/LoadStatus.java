package com.ss.android.ugc.aweme.search.common.result;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/LoadStatus;", "", "Initialize", "InitializeSuccess", "InitializeError", "InitializeEmpty", "LoadMoreIn", "LoadMoreSuccess", "LoadMoreError", "LoadMoreEnd", "UserLogin", "RequestFinish", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LoadStatus extends Enum<LoadStatus> {
    public static final LoadStatus Initialize = null;
    public static final LoadStatus InitializeEmpty = null;
    public static final LoadStatus InitializeError = null;
    public static final LoadStatus InitializeSuccess = null;
    public static final LoadStatus LoadMoreEnd = null;
    public static final LoadStatus LoadMoreError = null;
    public static final LoadStatus LoadMoreIn = null;
    public static final LoadStatus LoadMoreSuccess = null;
    public static final LoadStatus RequestFinish = null;
    public static final LoadStatus UserLogin = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadStatus[] f451852a = null;

    static {
        LoadStatus r100 = new LoadStatus("Initialize", 0);
        Initialize = r100;
        LoadStatus r101 = new LoadStatus("InitializeSuccess", 1);
        InitializeSuccess = r101;
        LoadStatus r102 = new LoadStatus("InitializeError", 2);
        InitializeError = r102;
        LoadStatus r103 = new LoadStatus("InitializeEmpty", 3);
        InitializeEmpty = r103;
        LoadStatus r104 = new LoadStatus("LoadMoreIn", 4);
        LoadMoreIn = r104;
        LoadStatus r105 = new LoadStatus("LoadMoreSuccess", 5);
        LoadMoreSuccess = r105;
        LoadStatus r106 = new LoadStatus("LoadMoreError", 6);
        LoadMoreError = r106;
        LoadStatus r107 = new LoadStatus("LoadMoreEnd", 7);
        LoadMoreEnd = r107;
        LoadStatus r108 = new LoadStatus("UserLogin", 8);
        UserLogin = r108;
        LoadStatus r109 = new LoadStatus("RequestFinish", 9);
        RequestFinish = r109;
        f451852a = new LoadStatus[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public static LoadStatus valueOf(String r100) {
        return (LoadStatus) a.a(LoadStatus.class, r100);
    }

    public static LoadStatus[] values() {
        return (LoadStatus[]) f451852a.clone();
    }

    public LoadStatus(String r100, int r101) {
        super(r100, r101);
    }
}
