package com.bytedance.android.shopping.utils;

import android.content.Context;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g0 {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ Function2 h;

    public final void a() {
        n1.i.getClass();
        n1.g = true;
        MonitorUtils.monitorEvent("goods_alibc_init_error_rate", new JSONObject().put("status", 0), null, null);
        int r0 = h0.a;
        h0.b(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }

    public g0(Context r1, String r2, String r3, String r4, String r5, String r6, String r7, Function2 r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
