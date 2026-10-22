package com.bytedance.locallife.photo.album.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/photo/album/model/RequestStatus;", "", "", "status", "I", "getStatus", "()I", "FAIL", "SUCCESS", "LOADING", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum RequestStatus extends Enum<RequestStatus> {
    public static final RequestStatus FAIL = null;
    public static final RequestStatus LOADING = null;
    public static final RequestStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RequestStatus[] f261970a = null;
    private final int status;

    public static RequestStatus valueOf(String r100) {
        return (RequestStatus) r27.a.a(RequestStatus.class, r100);
    }

    public static RequestStatus[] values() {
        return (RequestStatus[]) f261970a.clone();
    }

    static {
        RequestStatus r100 = new RequestStatus("FAIL", 0, 0);
        FAIL = r100;
        RequestStatus r101 = new RequestStatus("SUCCESS", 1, 1);
        SUCCESS = r101;
        RequestStatus r102 = new RequestStatus("LOADING", 2, 2);
        LOADING = r102;
        f261970a = new RequestStatus[]{r100, r101, r102};
    }

    public final int getStatus() {
        return this.status;
    }

    public RequestStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.status = r102;
    }
}
