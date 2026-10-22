package com.larus.utils.gson;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f375403a = null;

    static {
        f375403a = LazyKt.lazy(new a());
    }

    public static String a(Object r100) {
        return GsonProtectorUtils.toJson((Gson) f375403a.getValue(), r100);
    }
}
