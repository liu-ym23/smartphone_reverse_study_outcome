package com.bytedance.android.shopping.ligo.context;

import android.net.Uri;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class LigoComponentRegistry {
    public static final Lazy b = null;
    public final HashMap<String, w83.a> a;

    public static final class a {
    }

    static {
        b = LazyKt.lazy(LigoComponentRegistry$Companion$INSTANCE$2.INSTANCE);
    }

    public LigoComponentRegistry() {
        this.a = new HashMap();
    }

    public final w83.a a(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return this.a.get(r2.toString());
    }
}
