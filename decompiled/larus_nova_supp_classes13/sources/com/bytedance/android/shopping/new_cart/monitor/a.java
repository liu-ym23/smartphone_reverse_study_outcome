package com.bytedance.android.shopping.new_cart.monitor;

import com.bytedance.android.shopping.slice.action.entity.CheckLoginParam;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public static void a() {
        com.bytedance.android.shopping.base.event.a.d("cart", "page_create", "end", null, false, null, 56);
    }

    public static void c() {
        com.bytedance.android.shopping.base.event.a.d("cart", "render", "start", null, false, null, 56);
    }

    static {
    }

    public static void b(boolean r8) {
        ConcurrentHashMap<String, String> r0 = com.bytedance.android.shopping.base.event.a.a;
        JSONObject r6 = new JSONObject();
        r6.put("full_mode", r8);
        Unit r9 = Unit.INSTANCE;
        com.bytedance.android.shopping.base.event.a.d("cart", "page_create", "start", null, false, r6, 24);
    }

    public static void d(int r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "errorMessage");
        ConcurrentHashMap<String, String> r0 = com.bytedance.android.shopping.base.event.a.a;
        JSONObject r6 = new JSONObject();
        r6.put("statusCode", r7);
        Unit r9 = Unit.INSTANCE;
        com.bytedance.android.shopping.base.event.a.c("cart", "request", CheckLoginParam.KEY_FAILED, r8, true, r6);
    }
}
