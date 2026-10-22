package com.ss.android.lark.utils;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ss.android.lark.log.Log;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes38.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f444793a = null;

    static {
        f444793a = new Gson();
    }

    public static final <T> T a(String r100, Class<T> r101) {
        if (r100 != null) goto L13;
        return null;
    L13:
        return (T) JSON.parseObject(r100, r101);
    L7:
        th = move-exception;
        Log.e("FastJsonUtils", th);     // Catch: Throwable -> L10
        Type r102 = TypeToken.get(r101).getType();     // Catch: Throwable -> L10
        return (T) f444793a.fromJson(r100, r102);
    L10:
        th = move-exception;
        Log.e("FastJsonUtils", th);
        return null;
    }
}
