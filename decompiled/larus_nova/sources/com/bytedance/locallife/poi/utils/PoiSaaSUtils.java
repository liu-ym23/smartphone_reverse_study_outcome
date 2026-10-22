package com.bytedance.locallife.poi.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes21.dex */
public final class PoiSaaSUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f264217a = null;

    static {
        f264217a = LazyKt.lazy(PoiSaaSUtils$IS_SAAS$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean a() {
        return ((Boolean) f264217a.getValue()).booleanValue();
    }
}
