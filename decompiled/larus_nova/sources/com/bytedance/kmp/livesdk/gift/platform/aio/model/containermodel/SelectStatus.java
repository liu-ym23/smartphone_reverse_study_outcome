package com.bytedance.kmp.livesdk.gift.platform.aio.model.containermodel;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/containermodel/SelectStatus;", "", "", "status", "J", "getStatus", "()J", "IDLE", "SELECT", "LONG_PRESS", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SelectStatus extends Enum<SelectStatus> {
    public static final SelectStatus IDLE = null;
    public static final SelectStatus LONG_PRESS = null;
    public static final SelectStatus SELECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SelectStatus[] f252244a = null;
    private final long status;

    static {
        SelectStatus r100 = new SelectStatus("IDLE", 0, 0);
        IDLE = r100;
        SelectStatus r101 = new SelectStatus("SELECT", 1, 1);
        SELECT = r101;
        SelectStatus r102 = new SelectStatus("LONG_PRESS", 2, 2);
        LONG_PRESS = r102;
        f252244a = new SelectStatus[]{r100, r101, r102};
    }

    public static SelectStatus valueOf(String r100) {
        return (SelectStatus) a.a(SelectStatus.class, r100);
    }

    public static SelectStatus[] values() {
        return (SelectStatus[]) f252244a.clone();
    }

    public final long getStatus() {
        return this.status;
    }

    public SelectStatus(String r100, int r101, long r102) {
        super(r100, r101);
        this.status = r102;
    }
}
