package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler;

import android.net.Uri;
import com.bytedance.android.ec.hybrid.delivery.MallTransparentTransformer;
import com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.ECHandlerType;
import com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.SessionSettingUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECPerfSessionStageHandler extends a {
    public final String e;

    @Override // com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.a
    public final Function6<String, String, String, Double, String, Map<String, ? extends Object>, Unit> c() {
        return new ECPerfSessionStageHandler$defaultAction$1(this);
    }

    @Override // com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.a
    public final Map<String, Object> e() {
        Gson r0 = SessionSettingUtil.a;
        ECHandlerType r1 = ECHandlerType.EC_PERF_SESSION;
        Intrinsics.checkNotNullParameter(r1, "handlerType");
        Map r2 = (Map) SessionSettingUtil.g.getValue();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (Map) r2.get(r1.getType());
    }

    public ECPerfSessionStageHandler() {
        this.e = "ec_perf_session_id";
    }

    @Override // com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.a
    public final ECHandlerType d() {
        return ECHandlerType.EC_PERF_SESSION;
    }

    @Override // com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.a, com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.c
    public final String a(String r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r4, "scheme");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        Uri r6 = UriProtector.parse(r4);     // Catch: Throwable -> L11
        if (r6 != null) goto L6;
    L8:
        r6 = null;
    L9:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r7) == false) goto L16;
        r7 = null;
    L16:
        Uri r8 = (Uri) r7;
        if (r8 == null) goto L20;
        String r9 = UriProtector.getQueryParameter(r8, this.e);
        if (r9 == null) goto L20;
        return r9;
    L20:
        String r10 = this.e;
        Intrinsics.checkNotNullParameter(r10, "sessionKey");
        if (r5 == null) goto L23;
        Object r2 = r5.get(r10);
    L25:
        if ((r2 instanceof String) == true) goto L27;
        r2 = null;
    L27:
        String r3 = (String) r2;
        if (r3 != null) goto L30;
    L33:
        boolean r11 = true;
    L34:
        if (r11 == false) goto L53;
        if (r5 == null) goto L37;
        Object r12 = r5.get("pdp_event_transparent_id");
    L39:
        if ((r12 instanceof String) == false) goto L42;
        r0 = r12;
    L42:
        String r13 = (String) r0;
        if (MallTransparentTransformer.b(r13) == false) goto L53;
        String r14 = (String) MallTransparentTransformer.c(r13).get(r10);     // Catch: Throwable -> L49
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L47
        return r14;
    L47:
        Throwable th = th;
        r3 = r14;
    L51:
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L49:
        th = move-exception;
        th = th;
        goto L51
    L37:
        r12 = null;
    L53:
        return r3;
    L30:
        if (r3.length() == 0) goto L33;
        r11 = false;
        goto L34
    L23:
        r2 = null;
        goto L25
    L6:
        if (r6.isHierarchical() == false) goto L8;
    L11:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
