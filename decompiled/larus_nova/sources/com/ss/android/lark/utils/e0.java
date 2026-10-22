package com.ss.android.lark.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ss.android.lark.log.Log;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes38.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f444707a = null;

    static {
        f444707a = new GsonBuilder().create();
    }

    public static String c(Object r100) {
        return f444707a.toJson(r100);
    L4:
        th = move-exception;
        Log.e("GsonUtils", th.getMessage());
        return null;
    }

    public static Object a(String r100, Class r101) {
        return f444707a.fromJson(r100, r101);
    L4:
        th = move-exception;
        Log.e("GsonUtils", th.getMessage());
        return null;
    }

    public static Object b(String r100, Type r101) {
        return f444707a.fromJson(r100, r101);
    L4:
        th = move-exception;
        Log.e("GsonUtils", th.getMessage());
        return null;
    }
}
