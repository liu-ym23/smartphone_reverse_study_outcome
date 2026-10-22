package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.api.mall.common.tools.v;
import com.bytedance.android.shopping.mall.homepage.card.AbstractNativeCard;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements Runnable {
    public final /* synthetic */ BaseViewHolder a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public j(AbstractNativeCard r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        BaseViewHolder r0 = this.a;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        JSONObject r2 = com.bytedance.android.ec.hybrid.list.util.k.b(ToolsKt.k(r0));     // Catch: Throwable -> L11
        r2.remove("mall_lynx_config");     // Catch: Throwable -> L11
        JSONObject r3 = com.bytedance.android.ec.hybrid.list.util.k.b(v.f(UriProtector.parse(this.b)));     // Catch: Throwable -> L11
        IHybridHostService r4 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        yj.k r5 = r4.getIHybridHostEventService();     // Catch: Throwable -> L11
        if (r5 == null) goto L8;
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L11
        r6.put("business", "mall");     // Catch: Throwable -> L11
        r6.put("location", this.c);     // Catch: Throwable -> L11
        r6.put("in_schema", r2);     // Catch: Throwable -> L11
        r6.put("out_schema", r3);     // Catch: Throwable -> L11
        r6.put("origin_schema", this.b);     // Catch: Throwable -> L11
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L11
        r5.logV3("schema_report", r6);     // Catch: Throwable -> L11
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Result.constructor-impl(r8);     // Catch: Throwable -> L11
        return;
    L8:
        r8 = null;
    L11:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
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
