package com.bytedance.locallife.adapter.impl.host.poi;

import android.app.Activity;
import android.net.Uri;
import com.bytedance.android.locallife.core.service.LifeServiceManager;
import com.ss.android.ugc.aweme.poi.bean.DetailEnterPage;
import com.ss.android.ugc.aweme.poi.bean.PoiBizCode;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class a implements vt6.b {
    public a() {
    }

    @Override // vt6.b
    public final void e(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        ConcurrentHashMap<Class<?>, Object> r101 = LifeServiceManager.f162660a;
        ((com.bytedance.locallife.pdp.d) LifeServiceManager.b(com.bytedance.locallife.pdp.d.class)).e(r100);
    }

    @Override // vt6.b
    public final boolean c(PoiBizCode r100, DetailEnterPage r101) {
        Intrinsics.checkNotNullParameter(r100, "bizCode");
        Intrinsics.checkNotNullParameter(r101, "detailEnterPage");
        ConcurrentHashMap<Class<?>, Object> r102 = LifeServiceManager.f162660a;
        return ((com.bytedance.locallife.pdp.d) LifeServiceManager.b(com.bytedance.locallife.pdp.d.class)).c(r100, r101);
    }

    @Override // vt6.b
    public final void d(Activity r100, DetailEnterPage r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        ConcurrentHashMap<Class<?>, Object> r102 = LifeServiceManager.f162660a;
        ((com.bytedance.locallife.pdp.d) LifeServiceManager.b(com.bytedance.locallife.pdp.d.class)).d(r100, r101);
    }

    @Override // vt6.b
    public final Object f(Uri r110, boolean r111, String r112) {
        Intrinsics.checkNotNullParameter(r112, "uniqueKey");
        String r100 = xm6.a.c();
        ConcurrentHashMap<Class<?>, Object> r101 = LifeServiceManager.f162660a;
        com.bytedance.locallife.pdp.d r102 = (com.bytedance.locallife.pdp.d) LifeServiceManager.b(com.bytedance.locallife.pdp.d.class);
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        if (r111 == false) goto L5;
        String r113 = "1";
    L6:
        r104.put("is_auto_open_detail", r113);
        r104.put("unique_key", r112);
        Unit r114 = Unit.INSTANCE;
        r103.put("live_life_extra", r104);
        return com.bytedance.locallife.pdp.d.a.a(r102, r110, null, null, r100, null, r103.toString(), 22);
    L5:
        r113 = "0";
        goto L6
    }

    @Override // vt6.b
    public final boolean b(PoiBizCode r100, String r101, DetailEnterPage r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "bizCode");
        Intrinsics.checkNotNullParameter(r101, "activityId");
        Intrinsics.checkNotNullParameter(r102, "detailEnterPage");
        Intrinsics.checkNotNullParameter(r103, "params");
        ConcurrentHashMap<Class<?>, Object> r104 = LifeServiceManager.f162660a;
        return ((com.bytedance.locallife.pdp.d) LifeServiceManager.b(com.bytedance.locallife.pdp.d.class)).b(r100, r101, r102, r103);
    }

    @Override // vt6.b
    public final void a(PoiBizCode r100, String r110, DetailEnterPage r111, Map<String, String> r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r100, "bizCode");
        Intrinsics.checkNotNullParameter(r110, "activityId");
        Intrinsics.checkNotNullParameter(r111, "detailEnterPage");
        Intrinsics.checkNotNullParameter(r112, "params");
        ConcurrentHashMap<Class<?>, Object> r101 = LifeServiceManager.f162660a;
        ((com.bytedance.locallife.pdp.d) LifeServiceManager.b(com.bytedance.locallife.pdp.d.class)).g(r100, r110, r111, r112, r113, null);
    }
}
