package com.larus.avlink.autoGreet;

import com.larus.avlink.n1;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f291674a = null;

    static {
        f291674a = LazyKt.lazy(new d());
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        n1.d("AutoGreetUtils", r100);
    }

    public static void b(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (r101 == null) goto L5;
        n1.c("AutoGreetUtils", r100, r101);
        return;
    L5:
        n1.b("AutoGreetUtils", r100);
    }

    public static g a(String r110, String r111, t39.d r112) {
        Intrinsics.checkNotNullParameter(r110, "userId");
        Intrinsics.checkNotNullParameter(r111, "deviceId");
        Intrinsics.checkNotNullParameter(r112, "deviceInfo");
        Intrinsics.checkNotNullParameter(r112, "deviceInfo");
        Intrinsics.checkNotNullParameter(r112, "deviceInfo");
        IDoraService r113 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        boolean r100 = true;
        if (r113 == null) goto L9;
        DeviceService r114 = r113.device();
        if (r114 == null) goto L9;
        if (r114.a() != true) goto L9;
        boolean r115 = true;
    L10:
        if (r115 == false) goto L12;
        ProductType r116 = ProductType.OlaFriend;
    L23:
        Integer r117 = Integer.valueOf(r116.getValue());
        Intrinsics.checkNotNullParameter(new h(r117), "wearEventData");
        JSONObject r101 = new JSONObject();
        r101.put("product_type", r117);
        String r118 = r101.toString();
        Intrinsics.checkNotNullParameter("dora_user_wear_earphone", "eventName");
        Intrinsics.checkNotNullParameter(r111, "deviceId");
        return new g(r110, r111, new f("dora_user_wear_earphone", "dora_user_wear_earphone_" + r111 + '_' + System.currentTimeMillis() + '_' + StringsKt.replace$default(UUID.randomUUID().toString(), "-", "", false, 4, null).substring(0, 8), Long.valueOf(System.currentTimeMillis()), r118));
    L12:
        IDoraService r119 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r119 == null) goto L19;
        DeviceService r120 = r119.device();
        if (r120 == null) goto L19;
        if (r120.f() != true) goto L19;
    L20:
        if (r100 == false) goto L22;
        r116 = ProductType.DoraH;
        goto L23
    L22:
        r116 = ProductType.E;
    L19:
        r100 = false;
    L9:
        r115 = false;
        goto L10
    }
}
