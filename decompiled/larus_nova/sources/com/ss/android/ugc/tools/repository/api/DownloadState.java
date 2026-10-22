package com.ss.android.ugc.tools.repository.api;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/tools/repository/api/DownloadState;", "", "PENDING", GXAnimation.STATE_START, "SUCCESS", "FAILED", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final enum DownloadState extends Enum<DownloadState> {
    public static final DownloadState FAILED = null;
    public static final DownloadState PENDING = null;
    public static final DownloadState START = null;
    public static final DownloadState SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DownloadState[] f454846a = null;

    static {
        DownloadState r100 = new DownloadState("PENDING", 0);
        PENDING = r100;
        DownloadState r101 = new DownloadState(GXAnimation.STATE_START, 1);
        START = r101;
        DownloadState r102 = new DownloadState("SUCCESS", 2);
        SUCCESS = r102;
        DownloadState r103 = new DownloadState("FAILED", 3);
        FAILED = r103;
        f454846a = new DownloadState[]{r100, r101, r102, r103};
    }

    public static DownloadState valueOf(String r100) {
        return (DownloadState) a.a(DownloadState.class, r100);
    }

    public static DownloadState[] values() {
        return (DownloadState[]) f454846a.clone();
    }

    public DownloadState(String r100, int r101) {
        super(r100, r101);
    }
}
