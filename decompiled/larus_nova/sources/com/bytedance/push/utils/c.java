package com.bytedance.push.utils;

import com.google.gson.Gson;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f267060a = null;

    static {
        f267060a = new Gson();
    }

    public static <T> T a(String r100, Class<T> r101) {
        return (T) f267060a.fromJson(r100, r101);
    L4:
        return null;
    }
}
