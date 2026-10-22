package com.bytedance.ee.bear.document.render.node;

import com.ss.android.lark.log.Log;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Serializable> f221359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f221360b;

    public static final class a {
    }

    static {
    }

    public o() {
        this.f221359a = new LinkedHashMap();
        this.f221360b = new LinkedHashMap();
    }

    public final void a(String r100, Serializable r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        Log.i("RenderParams", "addExtraRenderParams: ".concat(r100));
        this.f221359a.put(r100, r101);
    }
}
