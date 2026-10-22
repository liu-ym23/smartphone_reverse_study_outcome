package com.bytedance.android.shopping.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.g2;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.shopping.OpenAppActivity;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h0 {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final /* synthetic */ Function2 a;

        public a(Function2 r1) {
            this.a = r1;
        }
    }

    static {
    }

    public static void a(Context r3, String r4) {
        int r0 = f0.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "url");
        int r1 = m0.a;
        String r2 = r3.getString(2131914254);
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter("title", "key");
        Intrinsics.checkNotNullParameter(r2, "value");
        g2 r5 = new g2(r4);
        r5.a("title", r2);
        String r6 = r5.b();
        Activity r7 = com.bytedance.android.shopping.anchorv3.utils.d0.a.getActivity(r3);
        if (r7 == null) goto L6;
        jj.a.a.b(com.bytedance.android.ec.sdk.helper.p.a, r6, r7, null, 28);
        return;
    }

    public static void b(Context r11, String r12, String r13, String r14, String r15, String r16, String r17, Function2 r18) {
        OpenAppActivity.a r1 = OpenAppActivity.k;
        r1.getClass();
        OpenAppActivity.i = false;
        Ref.BooleanRef r9 = new Ref.BooleanRef();
        r9.element = false;
        if (TextUtils.isEmpty(r13) == true) goto L5;
    L12:
        r1.startActivity(r11, r13, r14, r15, r16, r17, Long.valueOf(System.currentTimeMillis()));
        r9.element = true;
    L31:
        new HashMap().put("backUrl", "taobao://openapp.aweme.sdk.com");     // Catch: Throwable -> L23
        int r0 = com.bytedance.android.shopping.utils.a.a;     // Catch: Throwable -> L23
        a r2 = new a(r18);     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r11, "context");     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r12, "url");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r2, "callback");     // Catch: Throwable -> L19
        return;
    L19:
        th = th;
    L25:
        a(r11, r12);
        MonitorUtils.monitorEvent("goods_alibc_open_error_rate", new JSONObject().put("status", 1), null, null);
        ECExceptionMonitor.f(th, "Jump to Taobao failed");
        return;
    L21:
        th = th;
    L23:
        th = th;
        goto L25
    L5:
        if (TextUtils.isEmpty(r14) == false) goto L12;
        if (TextUtils.isEmpty(r15) == false) goto L12;
        if (TextUtils.isEmpty(r16) == false) goto L12;
        if (TextUtils.isEmpty(r17) == true) goto L31;
        goto L12
    }

    public static void c(Context r11, String r12, String r13, String r14, String r15, String r16, String r17, Function2 r18) {
        Intrinsics.checkNotNullParameter(r11, "fromAct");
        Intrinsics.checkNotNullParameter(r12, "url");
        if (ita.k.h(r11, "com.taobao.taobao") == false) goto L17;
        n1.i.getClass();
        if (n1.h == false) goto L12;
        n1.h = false;
        int r1 = com.bytedance.android.shopping.utils.a.a;     // Catch: Throwable -> L9
        g0 r10 = new g0(r11, r12, r13, r14, r15, r16, r17, r18);     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r10, "callback");     // Catch: Throwable -> L9
        r10.a();     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        MonitorUtils.monitorEvent("goods_alibc_init_error_rate", new JSONObject().put("status", 1), null, null);
        ECExceptionMonitor.f(th, "Baichuan SDK not init");
        th.printStackTrace();
        return;
    L12:
        if (n1.g == false) goto L14;
        b(r11, r12, r13, r14, r15, r16, r17, r18);
        return;
    L14:
        a(r11, r12);
        if (r18 == null) goto L25;
        Unit r0 = (Unit) r18.invoke(Boolean.FALSE, Boolean.TRUE);
        return;
    L25:
        return;
    L17:
        a(r11, r12);
        if (r18 == null) goto L27;
        Unit r2 = (Unit) r18.invoke(Boolean.FALSE, Boolean.TRUE);
        return;
    }
}
