package com.bytedance.ee.bear.document.debug;

import kotlin.Lazy;
import kotlin.LazyKt;
import ml5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DebugUtils {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(DebugUtils$mSp$2.INSTANCE);
    }

    public static b a() {
        return (b) a.getValue();
    }
}
