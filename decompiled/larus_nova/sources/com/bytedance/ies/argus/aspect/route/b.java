package com.bytedance.ies.argus.aspect.route;

import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends a {
    @Override // com.bytedance.ies.argus.aspect.route.a, com.bytedance.ies.argus.strategy.b
    public final JSONObject d(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        JSONObject r101 = super.d(r100);
        JSONUtilsKt.d(r101, "launchMode", null);
        return r101;
    }
}
