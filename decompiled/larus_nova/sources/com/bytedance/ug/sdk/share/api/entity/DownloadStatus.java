package com.bytedance.ug.sdk.share.api.entity;

import com.alibaba.gaiax.model.GXAnimation;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum DownloadStatus extends Enum<DownloadStatus> {
    public static final DownloadStatus CANCELED = null;
    public static final DownloadStatus FAILED = null;
    public static final DownloadStatus START = null;
    public static final DownloadStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DownloadStatus[] f272305a = null;

    static {
        DownloadStatus r100 = new DownloadStatus(GXAnimation.STATE_START, 0);
        START = r100;
        DownloadStatus r101 = new DownloadStatus("SUCCESS", 1);
        SUCCESS = r101;
        DownloadStatus r102 = new DownloadStatus("FAILED", 2);
        FAILED = r102;
        DownloadStatus r103 = new DownloadStatus("CANCELED", 3);
        CANCELED = r103;
        f272305a = new DownloadStatus[]{r100, r101, r102, r103};
    }

    public static DownloadStatus[] values() {
        return (DownloadStatus[]) f272305a.clone();
    }

    public static DownloadStatus valueOf(String r100) {
        return (DownloadStatus) a.a(DownloadStatus.class, r100);
    }

    public DownloadStatus(String r100, int r101) {
        super(r100, r101);
    }
}
