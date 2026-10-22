package oa5;

import at5.e;
import at5.l;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.larkwebview.bridge.Status;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends e {
    public a() {
    }

    public final l a(Status r3, String r4, Object r5, String r6) {
        JSONObject r7 = new JSONObject();
        r7.put("bizDomain", "ccm");
        l r0 = new l();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.b = r4;
        r0.d = r7.toString();
        r0.a = r3;
        r0.c = r5;
        return r0;
    }
}
