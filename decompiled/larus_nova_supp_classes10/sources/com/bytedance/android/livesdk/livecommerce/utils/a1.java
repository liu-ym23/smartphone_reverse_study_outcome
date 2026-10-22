package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class a1 {
    public final JSONObject a;
    public final String b;

    public static final class a {
    }

    static {
    }

    public final String getType() {
        return this.b;
    }

    public a1(String r3) {
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TYPE);
        this.b = r3;
        System.currentTimeMillis();
        JSONObject r1 = new JSONObject();
        r1.put(LocationMonitorConst.TYPE, r3);
        Unit r4 = Unit.INSTANCE;
        this.a = r1;
    }
}
