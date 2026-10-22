package com.bytedance.ee.bear.document.icon;

import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final com.bytedance.ee.bear.contract.d a;
    public final String b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.icon.a$a, reason: collision with other inner class name */
    public static final class C0077a {
    }

    static {
    }

    public final Map<String, String> a(String r3) {
        HashMap r0 = new HashMap();
        r0.put(JSEventListener.ACTION, r3);
        r0.put("file_id", du5.b.g(d25.d.d));
        String r4 = this.b;
        if (r4 != null) goto L5;
        r4 = sbb.e.e.getType();
    L5:
        r0.put("file_type", r4);
        r0.put("module", "doc");
        return r0;
    }

    public a(com.bytedance.ee.bear.contract.d r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "analyticService");
        this.a = r2;
        this.b = r3;
    }
}
