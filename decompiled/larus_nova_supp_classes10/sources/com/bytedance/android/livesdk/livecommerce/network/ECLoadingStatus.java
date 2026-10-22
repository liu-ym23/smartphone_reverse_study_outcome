package com.bytedance.android.livesdk.livecommerce.network;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/ECLoadingStatus;", "", "SUCCESS", "ERROR", "LOADING", "EMPTY", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECLoadingStatus extends Enum<ECLoadingStatus> {
    public static final ECLoadingStatus EMPTY = null;
    public static final ECLoadingStatus ERROR = null;
    public static final ECLoadingStatus LOADING = null;
    public static final ECLoadingStatus SUCCESS = null;
    public static final /* synthetic */ ECLoadingStatus[] a = null;

    static {
        ECLoadingStatus r1 = new ECLoadingStatus("SUCCESS", 0);
        SUCCESS = r1;
        ECLoadingStatus r2 = new ECLoadingStatus("ERROR", 1);
        ERROR = r2;
        ECLoadingStatus r3 = new ECLoadingStatus("LOADING", 2);
        LOADING = r3;
        ECLoadingStatus r4 = new ECLoadingStatus("EMPTY", 3);
        EMPTY = r4;
        a = new ECLoadingStatus[]{r1, r2, r3, r4};
    }

    public static ECLoadingStatus valueOf(String r1) {
        return (ECLoadingStatus) a.a(ECLoadingStatus.class, r1);
    }

    public static ECLoadingStatus[] values() {
        return (ECLoadingStatus[]) a.clone();
    }

    public ECLoadingStatus(String r1, int r2) {
        super(r1, r2);
    }
}
