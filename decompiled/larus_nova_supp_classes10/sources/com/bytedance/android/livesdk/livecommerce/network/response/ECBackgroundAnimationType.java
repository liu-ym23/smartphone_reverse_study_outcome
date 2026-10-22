package com.bytedance.android.livesdk.livecommerce.network.response;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECBackgroundAnimationType;", "", "", LocationMonitorConst.TYPE, "I", "getType", "()I", "NUMBER", "INFINITE", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECBackgroundAnimationType extends Enum<ECBackgroundAnimationType> {
    public static final ECBackgroundAnimationType INFINITE = null;
    public static final ECBackgroundAnimationType NUMBER = null;
    public static final /* synthetic */ ECBackgroundAnimationType[] a = null;
    private final int type;

    static {
        ECBackgroundAnimationType r2 = new ECBackgroundAnimationType("NUMBER", 0, 1);
        NUMBER = r2;
        ECBackgroundAnimationType r3 = new ECBackgroundAnimationType("INFINITE", 1, 2);
        INFINITE = r3;
        a = new ECBackgroundAnimationType[]{r2, r3};
    }

    public static ECBackgroundAnimationType valueOf(String r1) {
        return (ECBackgroundAnimationType) a.a(ECBackgroundAnimationType.class, r1);
    }

    public static ECBackgroundAnimationType[] values() {
        return (ECBackgroundAnimationType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ECBackgroundAnimationType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
