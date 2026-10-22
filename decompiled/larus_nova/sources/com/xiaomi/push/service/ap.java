package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;

/* JADX INFO: loaded from: classes41.dex */
public class ap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ap f464263a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f1064a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f1065a;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9369a() {
        String r100 = com.xiaomi.push.w.f1159a;
        if (r100.contains("xmsf") == false) goto L5;
    L10:
        return true;
    L5:
        if (r100.contains(DimLocationCheckUtil.XIAOMI) == true) goto L10;
        if (r100.contains("miui") == true) goto L10;
        return false;
    }

    public int a() {
        int r100 = this.f1064a;
        if (r100 == 0) goto L9;
        return r100;
    L9:
        this.f1064a = Settings.Global.getInt(this.f1065a.getContentResolver(), "device_provisioned", 0);     // Catch: Exception -> L8
    L7:
        return this.f1064a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Uri m9368a() {
        return Settings.Global.getUriFor("device_provisioned");
    }

    private ap(Context r100) {
        this.f1064a = 0;
        this.f1065a = r100.getApplicationContext();
    }

    public static ap a(Context r100) {
        if (f464263a != null) goto L6;
        f464263a = new ap(r100);
    L6:
        return f464263a;
    }
}
