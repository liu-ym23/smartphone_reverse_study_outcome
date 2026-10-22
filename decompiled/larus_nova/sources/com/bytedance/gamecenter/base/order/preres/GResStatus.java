package com.bytedance.gamecenter.base.order.preres;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/gamecenter/base/order/preres/GResStatus;", "", "", "status", "I", "getStatus", "()I", "STATUS_UNKNOWN", "NOT_STARTED", "ON_LINE", "OFF_LINE", "gamecenterbase_release"}, k = 1, mv = {1, 4, 3})
public final enum GResStatus extends Enum<GResStatus> {
    public static final GResStatus NOT_STARTED = null;
    public static final GResStatus OFF_LINE = null;
    public static final GResStatus ON_LINE = null;
    public static final GResStatus STATUS_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GResStatus[] f245043a = null;
    private final int status;

    static {
        GResStatus r100 = new GResStatus("STATUS_UNKNOWN", 0, 0);
        STATUS_UNKNOWN = r100;
        GResStatus r101 = new GResStatus("NOT_STARTED", 1, 1);
        NOT_STARTED = r101;
        GResStatus r102 = new GResStatus("ON_LINE", 2, 2);
        ON_LINE = r102;
        GResStatus r103 = new GResStatus("OFF_LINE", 3, 3);
        OFF_LINE = r103;
        f245043a = new GResStatus[]{r100, r101, r102, r103};
    }

    public static GResStatus valueOf(String r100) {
        return (GResStatus) a.a(GResStatus.class, r100);
    }

    public static GResStatus[] values() {
        return (GResStatus[]) f245043a.clone();
    }

    public final int getStatus() {
        return this.status;
    }

    public GResStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.status = r102;
    }
}
