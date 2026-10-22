package com.bytedance.locallife.rate;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import xu6.d;

/* JADX INFO: loaded from: classes21.dex */
public class b implements a {
    @Override // com.bytedance.locallife.rate.a
    public void a(d r100) {
    }

    @Override // com.bytedance.locallife.rate.a
    public void b(Context r100, String r101, Long r102, HashMap<String, String> r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "routerUrl");
        Intrinsics.checkNotNullParameter(r103, "ugcMobParams");
    }

    public b() {
    }
}
