package com.bytedance.locallife.live.lynx.syncjsb;

import com.bytedance.android.locallife.core.service.LifeServiceManager;
import com.bytedance.locallife.live.util.w;
import com.bytedance.locallife.live.util.y;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class PostMsgMethod extends a {
    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final String c() {
        return "postLiveLifeMsg";
    }

    public PostMsgMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        super(r100);
    }

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final HashMap<String, Object> f(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        String r101 = y.d(r100, "eventName");
        HashMap<String, Object> r102 = y.c(r100, "extra");
        HashMap<String, Object> r103 = y.c(r100, "params");
        ConcurrentHashMap<Class<?>, Object> r104 = LifeServiceManager.f162660a;
        JsonObject r105 = ((com.bytedance.locallife.live.service.a) LifeServiceManager.b(com.bytedance.locallife.live.service.a.class)).postMsg(r101, y.e(r102, new PostMsgMethod$handleMethod$result$1(this)), y.e(r103, null), PostMsgMethod$handleMethod$result$2.INSTANCE);
        if (r105.get("status").getAsInt() == 0) goto L26;
        Pair[] r106 = new Pair[1];
        JsonElement r107 = r105.get("data");
        if (r107 != null) goto L9;
        Object r108 = "";
    L24:
        r106[0] = TuplesKt.to("data", r108);
        return a.d(this, MapsKt.mutableMapOf(r106), 1);
    L9:
        if (com.bytedance.locallife.live.experiment.k.a() == true) goto L11;
        Map<String, Object> r109 = w.h(r107);
        boolean r110 = !r109.isEmpty();
        Object r111 = r109;
        if (r110 == false) goto L20;
    L19:
        r108 = r111;
        goto L24
    L20:
        List<Object> r112 = w.g(r107);
        boolean r113 = !r112.isEmpty();
        r111 = r112;
        if (r113 == true) goto L19;
        r108 = r107.toString();
        goto L24
    L11:
        if (r107.isJsonObject() == false) goto L14;
        r108 = w.h(r107);
        goto L24
    L14:
        if (r107.isJsonArray() == false) goto L16;
        r108 = w.g(r107);
        goto L24
    L16:
        r108 = r107.toString();
        goto L24
    L26:
        return a.b(null);
    }
}
