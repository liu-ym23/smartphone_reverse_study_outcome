package com.bytedance.android.shopping.mall.facade.service;

import android.content.Context;
import com.bytedance.android.ec.hybrid.a;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yj.u;
import yj.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DefaultHybridPluginService implements u {
    public static boolean a;
    public static boolean b;

    static {
        a = true;
    }

    public final boolean a() {
        if (a == false) goto L5;
    L6:
        d("check", 0L, null);
    L7:
        a = false;
        IHybridHostService r0 = a.h();
        if (r0 == null) goto L12;
        x r1 = r0.getECPluginService();
        if (r1 == null) goto L12;
        r1.a();
    L12:
        b = true;
        return true;
    L5:
        if (b == true) goto L7;
        goto L6
    }

    public final List<String> c() {
        return CollectionsKt.emptyList();
    }

    public static void d(String r2, Long r3, String r4) {
        JSONObject r0 = new JSONObject();
        r0.put("status", r2);
        r0.put("duration", r3);
        r0.put("errorMessage", r4);
        Unit r5 = Unit.INSTANCE;
        AppLogNewUtils.onEventV3("mall_second_page_plugin", r0);
    }

    public final void b(Context r5, final Function2<? super String, ? super Boolean, Unit> r6, final Function2<? super String, ? super Boolean, Unit> r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "onSuccess");
        Intrinsics.checkNotNullParameter(r7, "onFail");
        final long r0 = System.currentTimeMillis();
        x r3 = null;
        d("start", 0L, null);
        IHybridHostService r8 = a.h();
        if (r8 == null) goto L5;
        r3 = r8.getECPluginService();
    L5:
        Intrinsics.checkNotNull(r3);
        r3.b(new DefaultHybridPluginService$installECPlugin$1(r0, r6), new DefaultHybridPluginService$installECPlugin$2(r0, r7));
    }
}
