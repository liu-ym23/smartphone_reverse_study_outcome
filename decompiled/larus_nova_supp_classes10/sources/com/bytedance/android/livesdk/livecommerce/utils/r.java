package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ EnumEntranceInfoScene b;
    public final /* synthetic */ Function0 c;

    public r(String r1, EnumEntranceInfoScene r2, Function0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        sg2.v r0 = new sg2.v("schema_report", com.bytedance.android.ec.common.api.jump.model.b.a);
        r0.c(LocationMonitorConst.LOCATION, "ecomLive");
        r0.c("business", this.b.getValue());
        Function0 r1 = this.c;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(r1.invoke());     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r3) == false) goto L10;
        r3 = null;
    L10:
        r0.c("in_schema", (String) r3);
        r0.c("out_schema", this.a);
        r0.i(null);
        return;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
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
