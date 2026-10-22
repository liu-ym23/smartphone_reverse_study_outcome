package com.bytedance.sdk.account.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static f f269543b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f269544a;

    public static f a() {
        if (f269543b != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f269543b != null) goto L9;
        f269543b = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f269543b;
    }

    public f() {
    }

    public static String b(String r100) {
        return r100;
    }

    public final void c(String r100, long r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty("whatever") == true) goto L26;
        String r102 = b(r100);     // Catch: Exception -> L18
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L18
        r103.put("expire_timing", r101);     // Catch: Exception -> L18
        r103.put("cache_value", "whatever");     // Catch: Exception -> L18
        if (this.f269544a != null) goto L12;
        Context r104 = com.ss.android.account.k.c();     // Catch: Exception -> L18
        if (r104 == null) goto L12;
        this.f269544a = r104.getSharedPreferences("com_bytedance_sdk_account_utils_common_request_cache_helper", 0);     // Catch: Exception -> L18
    L12:
        SharedPreferences r105 = this.f269544a;     // Catch: Exception -> L18
        if (r105 != null) goto L15;
        return;
    L15:
        if (System.currentTimeMillis() >= r101) goto L25;
        r105.edit().putString(r102, r103.toString()).apply();     // Catch: Exception -> L18
        return;
    L25:
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
