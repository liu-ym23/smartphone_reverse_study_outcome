package com.bytedance.ee.bear.document.render.node;

import com.ss.android.lark.log.Log;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o {
    public final Map<String, Serializable> a;
    public final Map<String, String> b;

    public static final class a {
    }

    static {
    }

    public o() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
    }

    public final void a(String r3, Serializable r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        Log.i("RenderParams", "addExtraRenderParams: ".concat(r3));
        this.a.put(r3, r4);
    }
}
