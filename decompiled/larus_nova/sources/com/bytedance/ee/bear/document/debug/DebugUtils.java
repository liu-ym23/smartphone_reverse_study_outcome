package com.bytedance.ee.bear.document.debug;

import kotlin.Lazy;
import kotlin.LazyKt;
import ml5.b;

/* JADX INFO: loaded from: classes16.dex */
public final class DebugUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f219500a = null;

    static {
        f219500a = LazyKt.lazy(DebugUtils$mSp$2.INSTANCE);
    }

    public static b a() {
        return (b) f219500a.getValue();
    }
}
