package ub5;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements m {
    public b() {
    }

    @Override // tb5.m
    public final void a(NonProguard r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
    }

    @Override // tb5.m
    public final void b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
    }

    @Override // tb5.m
    public final void onCallBack(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }
}
