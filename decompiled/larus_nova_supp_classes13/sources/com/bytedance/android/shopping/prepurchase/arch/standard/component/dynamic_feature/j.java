package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements Runnable {
    public final /* synthetic */ l a;
    public final /* synthetic */ com.bytedance.android.ecom.arch.slice.slices.template.d b;
    public final /* synthetic */ String c;

    public j(l r1, com.bytedance.android.ecom.arch.slice.slices.template.d r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        l r0 = this.a;
        JSONObject r1 = new JSONObject();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L10
        Map r3 = this.b.getData();     // Catch: Throwable -> L10
        if (r3 == null) goto L7;
        Object r4 = r3.get("product_status");     // Catch: Throwable -> L10
    L8:
        r1.put("product_status", r4);     // Catch: Throwable -> L10
        Result.constructor-impl(r1.put("schema", this.c));     // Catch: Throwable -> L10
    L12:
        Unit r5 = Unit.INSTANCE;
        r0.sendJsEvent("refresh_market_cart", r1);
        return;
    L7:
        r4 = null;
    L10:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
