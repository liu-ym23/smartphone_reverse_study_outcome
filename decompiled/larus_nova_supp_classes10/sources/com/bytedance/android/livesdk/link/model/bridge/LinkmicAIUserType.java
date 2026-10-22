package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/LinkmicAIUserType;", "", "", LocationMonitorConst.TYPE, "I", "getType", "()I", "UnknownAI", "Assistant", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkmicAIUserType extends Enum<LinkmicAIUserType> {
    public static final LinkmicAIUserType Assistant = null;
    public static final LinkmicAIUserType UnknownAI = null;
    public static final /* synthetic */ LinkmicAIUserType[] a = null;
    private final int type;

    static {
        LinkmicAIUserType r1 = new LinkmicAIUserType("UnknownAI", 0, 0);
        UnknownAI = r1;
        LinkmicAIUserType r2 = new LinkmicAIUserType("Assistant", 1, 1);
        Assistant = r2;
        a = new LinkmicAIUserType[]{r1, r2};
    }

    public static LinkmicAIUserType valueOf(String r1) {
        return (LinkmicAIUserType) r27.a.a(LinkmicAIUserType.class, r1);
    }

    public static LinkmicAIUserType[] values() {
        return (LinkmicAIUserType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public LinkmicAIUserType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
