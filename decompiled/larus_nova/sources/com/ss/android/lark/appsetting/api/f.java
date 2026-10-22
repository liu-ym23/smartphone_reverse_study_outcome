package com.ss.android.lark.appsetting.api;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes34.dex */
public final class f {
    public static <T> T a(Class<T> r100, String r101, String r102) {
    L13:
        e = move-exception;
        Log.e("SettingParseService", "parse by custom method failed, parseMethod:" + r102, e);     // Catch: Throwable -> L11
        int r103 = zva.b.f573773a;     // Catch: Throwable -> L11 Exception -> L18
        T r104 = (T) zva.b.a.b(r100);
        Log.e("SettingParseService", "parse by custom method finally, parseMethod:" + r102);
        return r104;
    L18:
        e = move-exception;
        Log.e("SettingParseService", "parse by custom method fallback failed, parseMethod:" + r102, e);     // Catch: Throwable -> L11
        Log.e("SettingParseService", "parse by custom method finally, parseMethod:" + r102);
        return null;
    L4:
        if (TextUtils.isEmpty(r102) == false) goto L8;
        Log.d("SettingParseService", "parse by Gson.");     // Catch: Throwable -> L11 Exception -> L13
        T r105 = (T) new Gson().fromJson(r101, r100);
        Log.e("SettingParseService", "parse by custom method finally, parseMethod:" + r102);
        return r105;
    L8:
        Log.d("SettingParseService", "parse by custom method:" + r102);     // Catch: Throwable -> L11 Exception -> L13
        int r106 = zva.b.f573773a;     // Catch: Throwable -> L11 Exception -> L13
        T r107 = (T) zva.b.a.a(zva.b.a.b(r100), r100, r102, r101);
        Log.e("SettingParseService", "parse by custom method finally, parseMethod:" + r102);
        return r107;
    L11:
        th = move-exception;
        Log.e("SettingParseService", "parse by custom method finally, parseMethod:" + r102);
        throw th;
    }
}
