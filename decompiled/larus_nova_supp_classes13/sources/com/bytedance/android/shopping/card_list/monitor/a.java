package com.bytedance.android.shopping.card_list.monitor;

import com.bytedance.android.shopping.card_list.container.init.LauncherBizType;
import com.bytedance.android.shopping.slice.action.entity.CheckLoginParam;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static String a;

    static {
        a = "";
    }

    public static void b(LauncherBizType r7) {
        Intrinsics.checkNotNullParameter(r7, "bizType");
        if (r7 != LauncherBizType.CART) goto L6;
        a = "cart";
    L9:
        ConcurrentHashMap<String, String> r8 = com.bytedance.android.shopping.base.event.a.a;
        com.bytedance.android.shopping.base.event.a.a.clear();
        com.bytedance.android.shopping.base.event.a.d(a, "schema_parse", "start", null, false, null, 56);
        return;
    L6:
        if (r7 != LauncherBizType.COLLECT) goto L8;
        a = "collect";
        goto L9
    L8:
        a = "none";
        goto L9
    }

    public static void a(int r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "errorMessage");
        ConcurrentHashMap<String, String> r0 = com.bytedance.android.shopping.base.event.a.a;
        String r1 = a;
        JSONObject r6 = new JSONObject();
        r6.put("statusCode", r7);
        Unit r9 = Unit.INSTANCE;
        com.bytedance.android.shopping.base.event.a.c(r1, "request", CheckLoginParam.KEY_FAILED, r8, true, r6);
    }
}
