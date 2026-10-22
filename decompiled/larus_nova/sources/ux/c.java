package ux;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class c extends nx.c {
    public c(String r100, JSONObject r101, wp2.b r102) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        super(r100, r102, "live_sheild_incentive_panel", r101);
    }
}
