package ub5;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements m {
    public b() {
    }

    @Override // tb5.m
    public final void a(NonProguard r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
    }

    @Override // tb5.m
    public final void b(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
    }

    @Override // tb5.m
    public final void onCallBack(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }
}
