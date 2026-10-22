package com.bytedance.live.livelink.kmp.api.base.video;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/base/video/Status;", "", "UNDEFINED", "READY", "STARTED", "PAUSED", "RESUMED", "STOPPED", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum Status extends Enum<Status> {
    public static final Status PAUSED = null;
    public static final Status READY = null;
    public static final Status RESUMED = null;
    public static final Status STARTED = null;
    public static final Status STOPPED = null;
    public static final Status UNDEFINED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Status[] f255227a = null;

    static {
        Status r100 = new Status("UNDEFINED", 0);
        UNDEFINED = r100;
        Status r101 = new Status("READY", 1);
        READY = r101;
        Status r102 = new Status("STARTED", 2);
        STARTED = r102;
        Status r103 = new Status("PAUSED", 3);
        PAUSED = r103;
        Status r104 = new Status("RESUMED", 4);
        RESUMED = r104;
        Status r105 = new Status("STOPPED", 5);
        STOPPED = r105;
        f255227a = new Status[]{r100, r101, r102, r103, r104, r105};
    }

    public static Status valueOf(String r100) {
        return (Status) a.a(Status.class, r100);
    }

    public static Status[] values() {
        return (Status[]) f255227a.clone();
    }

    public Status(String r100, int r101) {
        super(r100, r101);
    }
}
