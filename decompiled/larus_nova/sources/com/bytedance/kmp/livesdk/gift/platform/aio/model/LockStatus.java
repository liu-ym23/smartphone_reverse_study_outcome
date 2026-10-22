package com.bytedance.kmp.livesdk.gift.platform.aio.model;

import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.bytedance.tools.kcp.aio.runtime.RpcEnum;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@RpcEnum(messageName = "webcast.revenue.biz.gift.kmp.dialog.LockStatus")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/LockStatus;", "", "", "status", "I", "getStatus", "()I", "IDLE", OpenNetMethod.LOCK, "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LockStatus extends Enum<LockStatus> {
    public static final LockStatus IDLE = null;
    public static final LockStatus LOCK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LockStatus[] f252242a = null;
    private final int status;

    static {
        LockStatus r100 = new LockStatus("IDLE", 0, 0);
        IDLE = r100;
        LockStatus r101 = new LockStatus(OpenNetMethod.LOCK, 1, 1);
        LOCK = r101;
        f252242a = new LockStatus[]{r100, r101};
    }

    public static LockStatus valueOf(String r100) {
        return (LockStatus) a.a(LockStatus.class, r100);
    }

    public static LockStatus[] values() {
        return (LockStatus[]) f252242a.clone();
    }

    public final int getStatus() {
        return this.status;
    }

    public LockStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.status = r102;
    }
}
