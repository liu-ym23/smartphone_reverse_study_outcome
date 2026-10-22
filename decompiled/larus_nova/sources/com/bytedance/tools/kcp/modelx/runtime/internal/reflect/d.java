package com.bytedance.tools.kcp.modelx.runtime.internal.reflect;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import vh7.j;

/* JADX INFO: loaded from: classes22.dex */
public final class d {
    @JvmStatic
    public static final <E> List<E> a() {
        return new ArrayList(0);
    }

    @JvmStatic
    public static final <K, V> Map<K, V> b() {
        return new LinkedHashMap(0);
    }

    static {
    }

    @JvmStatic
    public static final <R> R c(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (vh7.c.class.isAssignableFrom(r100) == false) goto L6;
        return (R) vh7.f.c(r100);
    L6:
        if (j.class.isAssignableFrom(r100) == false) goto L9;
        Gson r101 = ModelXReflections.f270980a;
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) GsonProtectorUtils.fromJson(ModelXReflections.f270980a, SliceInitService.DEFAULT_SWITCH, r100);
    L9:
        if (Intrinsics.areEqual(JsonObject.class, r100) == false) goto L12;
        return (R) new JsonObject();
    L12:
        if (Intrinsics.areEqual(JsonArray.class, r100) == false) goto L15;
        return (R) new JsonArray();
    L15:
        if (r100.isInterface() == false) goto L18;
        return (R) ModelXReflections.g(new Class[]{r100}, f.a.f270991b);
    L18:
        return (R) ModelXReflections.f(r100, SliceInitService.DEFAULT_SWITCH, true);
    }
}
