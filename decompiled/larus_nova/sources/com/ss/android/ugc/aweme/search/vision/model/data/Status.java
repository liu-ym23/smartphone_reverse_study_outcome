package com.ss.android.ugc.aweme.search.vision.model.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/model/data/Status;", "", "Complete", "Success", "Failed", "Loading", "LoadingEmpty", "LoadMoreLoading", "LoadMoreFailed", "LoadMoreSuccess", "LoadMoreComplete", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Status extends Enum<Status> {
    public static final Status Complete = null;
    public static final Status Failed = null;
    public static final Status LoadMoreComplete = null;
    public static final Status LoadMoreFailed = null;
    public static final Status LoadMoreLoading = null;
    public static final Status LoadMoreSuccess = null;
    public static final Status Loading = null;
    public static final Status LoadingEmpty = null;
    public static final Status Success = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Status[] f453651a = null;

    static {
        Status r100 = new Status("Complete", 0);
        Complete = r100;
        Status r101 = new Status("Success", 1);
        Success = r101;
        Status r102 = new Status("Failed", 2);
        Failed = r102;
        Status r103 = new Status("Loading", 3);
        Loading = r103;
        Status r104 = new Status("LoadingEmpty", 4);
        LoadingEmpty = r104;
        Status r105 = new Status("LoadMoreLoading", 5);
        LoadMoreLoading = r105;
        Status r106 = new Status("LoadMoreFailed", 6);
        LoadMoreFailed = r106;
        Status r107 = new Status("LoadMoreSuccess", 7);
        LoadMoreSuccess = r107;
        Status r108 = new Status("LoadMoreComplete", 8);
        LoadMoreComplete = r108;
        f453651a = new Status[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public static Status valueOf(String r100) {
        return (Status) a.a(Status.class, r100);
    }

    public static Status[] values() {
        return (Status[]) f453651a.clone();
    }

    public Status(String r100, int r101) {
        super(r100, r101);
    }
}
