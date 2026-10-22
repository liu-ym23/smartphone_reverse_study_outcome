package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile gc f463644a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Context f610a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Map<String, gd> f611a;

    public gd a() {
        gd r100 = this.f611a.get("UPLOADER_PUSH_CHANNEL");
        if (r100 == null) goto L5;
        return r100;
    L5:
        gd r101 = this.f611a.get("UPLOADER_HTTP");
        if (r101 == null) goto L8;
        return r101;
    L8:
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<String, gd> m9127a() {
        return this.f611a;
    }

    private gc(Context r100) {
        this.f611a = new HashMap();
        this.f610a = r100;
    }

    public static gc a(Context r100) {
        if (r100 != null) goto L6;
        com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
        return null;
    L6:
        if (f463644a != null) goto L18;
        monitor-enter(gc.class);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (f463644a != null) goto L12;
        f463644a = new gc(r100);     // Catch: Throwable -> L14
    L12:
        monitor-exit(gc.class);     // Catch: Throwable -> L14
    L18:
        return f463644a;
    }

    public boolean a(gi r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L7;
        com.xiaomi.channel.commonutils.logger.b.m8718a("pkgName is null or empty, upload ClientUploadDataItem failed.");
        return false;
    L7:
        if (com.xiaomi.push.service.az.a(r100, false) == false) goto L10;
        return false;
    L10:
        if (TextUtils.isEmpty(r100.d()) == false) goto L12;
        r100.f(com.xiaomi.push.service.az.a());
    L12:
        r100.g(r101);
        com.xiaomi.push.service.ba.a(this.f610a, r100);
        return true;
    }

    public void a(gd r100, String r101) {
        if (r100 != null) goto L6;
        com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        return;
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L9;
        com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: can not add a provider from unkown resource.");
        return;
    L9:
        m9127a().put(r101, r100);
    }
}
