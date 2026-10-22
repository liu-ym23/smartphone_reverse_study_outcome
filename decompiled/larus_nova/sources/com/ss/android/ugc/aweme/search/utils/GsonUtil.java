package com.ss.android.ugc.aweme.search.utils;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes40.dex */
public final class GsonUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Gson f453413a;

    public static Gson a() {
        if (f453413a != null) goto L6;
        f453413a = new Gson();
    L6:
        return f453413a;
    }

    public static String b(Object r100) {
        return GsonProtectorUtils.toJson(a(), r100);
    }
}
