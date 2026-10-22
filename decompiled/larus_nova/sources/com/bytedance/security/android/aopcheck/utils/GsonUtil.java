package com.bytedance.security.android.aopcheck.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class GsonUtil {
    private static Gson GSON;

    static {
        GSON = new GsonBuilder().create();
    }

    private GsonUtil() {
    }

    public static String toJsonStr(Object r100) {
        if (r100 == null) goto L11;
        return GSON.toJson(r100);
    L6:
        e = move-exception;
        LogPrint.e("object to json exception:" + e);
        return "";
    L11:
        return "";
    }

    public static <T> T pare(String r100, Type r101) {
        if (r100 == null) goto L11;
        return (T) GSON.fromJson(r100, r101);
    L6:
        e = move-exception;
        LogPrint.e("json to object exception：" + e);
        return null;
    L11:
        return null;
    }

    public static <T> T parse(String r100, Class<T> r101) {
        if (r100 == null) goto L11;
        return (T) GSON.fromJson(r100, r101);
    L6:
        e = move-exception;
        LogPrint.e("json to object exception：" + e);
        return null;
    L11:
        return null;
    }

    public static <T> List<T> parseList(String r100, Class<T> r101) {
        if (r100 == null) goto L11;
        return (List) GSON.fromJson(r100, new AnonymousClass1().getType());
    L6:
        e = move-exception;
        LogPrint.e("json to array exception:" + e);
        return null;
    L11:
        return null;
    }
}
