package com.bytedance.android.shopping.buynow.container;

import android.content.Context;
import com.bytedance.android.ec.core.vmsdk.VmSdkSetting;
import com.bytedance.android.ec.sdk.ECSdk;
import io.reactivex.functions.Action;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Action {
    public final /* synthetic */ BuyNowFragment a;

    public b(BuyNowFragment r1) {
        this.a = r1;
    }

    public final void run() {
        BuyNowFragment r0 = this.a;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
        Context r2 = r0.getContext();     // Catch: Throwable -> L18
        String r3 = null;
        if (r2 == null) goto L16;
        int r4 = ECSdk.a;     // Catch: Throwable -> L18
        com.bytedance.android.ec.core.monitor.o r5 = (com.bytedance.android.ec.core.monitor.o) ECSdk.a(com.bytedance.android.ec.core.monitor.o.class);     // Catch: Throwable -> L18
        if (r5 == null) goto L15;
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L18
        nl.c r7 = r0.W90().getStaticState().a;     // Catch: Throwable -> L18
        if (r7 == null) goto L10;
        Map r8 = r7.b();     // Catch: Throwable -> L18
    L11:
        r6.put("schema_query_items", com.bytedance.android.shopping.extensions.k.x(r8));     // Catch: Throwable -> L18
        nl.c r9 = r0.W90().getStaticState().a;     // Catch: Throwable -> L18
        if (r9 == null) goto L14;
        r3 = r9.a();     // Catch: Throwable -> L18
    L14:
        r6.put("mega_object", r3);     // Catch: Throwable -> L18
        r6.put("tech_type", "android");     // Catch: Throwable -> L18
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L18
        com.bytedance.android.ec.core.monitor.o.a.a(r5, r2, "buynow_yata_check", r6.toString(), VmSdkSetting.a().a());     // Catch: Throwable -> L18
        goto L15
    L10:
        r8 = null;
    L15:
        r3 = com.bytedance.android.shopping.buynow.opt.g.a(r2);     // Catch: Throwable -> L18
    L16:
        Result.constructor-impl(r3);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
