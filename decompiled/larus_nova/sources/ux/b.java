package ux;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends nx.c {
    public b(String r100, JSONObject r101, wp2.b r102) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        super(r100, r102, "incentive_interface_preloading", r101);
    }
}
