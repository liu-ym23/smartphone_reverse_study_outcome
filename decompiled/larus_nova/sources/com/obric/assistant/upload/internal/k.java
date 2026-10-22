package com.obric.assistant.upload.internal;

import androidx.collection.LruCache;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.platform.service.o;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<String, l> f393569a = null;

    static {
        f393569a = new LruCache(10);
    }

    public static void a(String r100, boolean r101, long r102, long r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        long r106 = System.currentTimeMillis() - r102;
        long r107 = System.currentTimeMillis() - r103;
        l r108 = f393569a.get(r100);
        if (r108 != null) goto L5;
        r108 = new l(0);
    L5:
        r108.i(Boolean.valueOf(r101));
        if (r104 == null) goto L8;
        r108.g(r104);
    L8:
        if (r105 == null) goto L10;
        r108.h(r105);
    L10:
        r108.e(Long.valueOf(r106));
        r108.f(Long.valueOf(r107));
        JSONObject r109 = new JSONObject(GsonProtectorUtils.toJson(new Gson(), r108));
        o.f365780a.reportEvent("o_resource_upload", r109);
    }
}
