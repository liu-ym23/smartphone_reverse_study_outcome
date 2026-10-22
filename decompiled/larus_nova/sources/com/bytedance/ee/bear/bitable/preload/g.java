package com.bytedance.ee.bear.bitable.preload;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f215001a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f215002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f215003b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f215004c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, String> f215005d;

        public a() {
            this.f215004c = System.currentTimeMillis();
        }

        public final String getType() {
            return this.f215002a;
        }
    }

    static {
        int r100 = zt4.i.a.C8493a.f573602a;
        f215001a = CollectionsKt.listOf(new String[]{"bitable.queue", "bitable.follow", "bitable.sending"});
    }

    public static JSONObject a(a r100) {
        return new JSONObject().put("action", r100.f215003b).put("type", r100.getType()).put("time_cost", System.currentTimeMillis() - r100.f215004c).put("network_status", ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.c(com.bytedance.ee.bear.drive.sdk.service.f.class, null, null, 6)).d0().p().getValue());
    }

    public static a b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "action");
        a r102 = new a();
        r102.f215002a = r100;
        r102.f215003b = r101;
        r102.f215005d = null;
        if (du5.b.a(r100) == false) goto L11;
        Iterator<String> r103 = f215001a.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        String r104 = r103.next();
        if (StringsKt.contains$default(r100, r104, false, 2, null) == false) goto L6;
        r102.f215002a = r104;
        goto L11
    L10:
        r102.f215002a = du5.d.a(r100);
    L11:
        return r102;
    }

    public static void c(a r100, JSONObject r101) {
        tt5.a.h("BitablePreloadAnalytic", "logExtra:" + r100.f215005d + ", " + r101);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).u("bitable_resources_preload", r101);
    }

    @JvmStatic
    public static final void d(a r100, long r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "debugMessage");
        Intrinsics.checkNotNullParameter(r103, "cacheHitList");
        if (r100 != null) goto L14;
        return;
    L14:
        JSONObject r104 = a(r100);     // Catch: JSONException -> L11
        if (r101 < 0) goto L8;
        String r105 = "success";
    L9:
        r104.put("status", r105).put("size", r101).put("debug_message", r102).put("cache_hit_list", r103);     // Catch: JSONException -> L11
        c(r100, r104);     // Catch: JSONException -> L11
        return;
    L8:
        r105 = "error";
    L11:
        e = move-exception;
        tt5.a.l("BitablePreloadAnalytic", "Failed to report preload, ", e);
    }
}
