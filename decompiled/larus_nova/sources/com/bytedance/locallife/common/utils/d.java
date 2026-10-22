package com.bytedance.locallife.common.utils;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Gson f257145a;

    public static Gson b() {
        if (f257145a != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f257145a != null) goto L9;
        f257145a = new Gson();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f257145a;
    }

    public d() {
    }

    public static String c(Object r100) {
        return GsonProtectorUtils.toJson(b(), r100);
    }

    public static <T> T a(String r100, Class<T> r101) {
        return (T) GsonProtectorUtils.fromJson(b(), r100, r101);
    }

    public static <T> List<T> d(String r100, Class<T[]> r101) {
        Object[] r102 = (Object[]) GsonProtectorUtils.fromJson(b(), r100, r101);
        if (r102 != null) goto L6;
        return new ArrayList();
    L6:
        return new ArrayList(Arrays.asList(r102));
    }
}
