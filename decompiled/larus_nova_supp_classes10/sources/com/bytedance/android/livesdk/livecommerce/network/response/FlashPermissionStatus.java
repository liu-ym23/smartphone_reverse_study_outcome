package com.bytedance.android.livesdk.livecommerce.network.response;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/FlashPermissionStatus;", "", "", "status", "I", "getStatus", "()I", "NOT_OPEN_YET", "OFF", "ON", "PAUSED", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FlashPermissionStatus extends Enum<FlashPermissionStatus> {
    public static final FlashPermissionStatus NOT_OPEN_YET = null;
    public static final FlashPermissionStatus OFF = null;
    public static final FlashPermissionStatus ON = null;
    public static final FlashPermissionStatus PAUSED = null;
    public static final /* synthetic */ FlashPermissionStatus[] a = null;
    private final int status;

    static {
        FlashPermissionStatus r1 = new FlashPermissionStatus("NOT_OPEN_YET", 0, -1);
        NOT_OPEN_YET = r1;
        FlashPermissionStatus r2 = new FlashPermissionStatus("OFF", 1, 0);
        OFF = r2;
        FlashPermissionStatus r3 = new FlashPermissionStatus("ON", 2, 1);
        ON = r3;
        FlashPermissionStatus r4 = new FlashPermissionStatus("PAUSED", 3, 2);
        PAUSED = r4;
        a = new FlashPermissionStatus[]{r1, r2, r3, r4};
    }

    public static FlashPermissionStatus valueOf(String r1) {
        return (FlashPermissionStatus) a.a(FlashPermissionStatus.class, r1);
    }

    public static FlashPermissionStatus[] values() {
        return (FlashPermissionStatus[]) a.clone();
    }

    public final int getStatus() {
        return this.status;
    }

    public FlashPermissionStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.status = r3;
    }
}
