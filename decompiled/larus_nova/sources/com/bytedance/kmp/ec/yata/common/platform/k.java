package com.bytedance.kmp.ec.yata.common.platform;

import com.bytedance.kmp.ec.yata.common.platform.jsonadapter.YataFieldsAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Gson f251545a;

    static {
    }

    @Deprecated(message = "不可以直接使用，必须走封装的API")
    public static Gson a() {
        if (f251545a != null) goto L5;
        GsonBuilder r100 = new GsonBuilder().serializeNulls();
        r100.registerTypeAdapter(Map.class, new YataFieldsAdapter());
        r100.registerTypeAdapter(List.class, new YataFieldsAdapter());
        f251545a = r100.create();
    L5:
        Gson r101 = f251545a;
        Intrinsics.checkNotNull(r101);
        return r101;
    }
}
