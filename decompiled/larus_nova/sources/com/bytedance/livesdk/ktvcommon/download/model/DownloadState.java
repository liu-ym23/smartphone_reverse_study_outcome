package com.bytedance.livesdk.ktvcommon.download.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/livesdk/ktvcommon/download/model/DownloadState;", "", "PENDING", "DOWNLOADING", "SUCCESS", "FAILED", "CANCELLED", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum DownloadState extends Enum<DownloadState> {
    public static final DownloadState CANCELLED = null;
    public static final DownloadState DOWNLOADING = null;
    public static final DownloadState FAILED = null;
    public static final DownloadState PENDING = null;
    public static final DownloadState SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DownloadState[] f255939a = null;

    static {
        DownloadState r100 = new DownloadState("PENDING", 0);
        PENDING = r100;
        DownloadState r101 = new DownloadState("DOWNLOADING", 1);
        DOWNLOADING = r101;
        DownloadState r102 = new DownloadState("SUCCESS", 2);
        SUCCESS = r102;
        DownloadState r103 = new DownloadState("FAILED", 3);
        FAILED = r103;
        DownloadState r104 = new DownloadState("CANCELLED", 4);
        CANCELLED = r104;
        f255939a = new DownloadState[]{r100, r101, r102, r103, r104};
    }

    public static DownloadState valueOf(String r100) {
        return (DownloadState) r27.a.a(DownloadState.class, r100);
    }

    public static DownloadState[] values() {
        return (DownloadState[]) f255939a.clone();
    }

    public DownloadState(String r100, int r101) {
        super(r100, r101);
    }
}
