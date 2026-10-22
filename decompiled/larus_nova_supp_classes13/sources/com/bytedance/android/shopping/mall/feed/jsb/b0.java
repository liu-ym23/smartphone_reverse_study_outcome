package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b0 implements Runnable {
    public final /* synthetic */ Map a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;
    public final /* synthetic */ String e;
    public final /* synthetic */ int f;
    public final /* synthetic */ qf3.d g;

    public b0(Map r1, long r2, long r4, long r6, int r8, qf3.d r9) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r6;
        this.e = "use_jsb";
        this.f = r8;
        this.g = r9;
    }

    public final void a() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L27
        Object r2 = this.a.get("openTime");     // Catch: Throwable -> L27
        String r3 = null;
        if ((r2 instanceof Number) == true) goto L6;
        r2 = null;
    L6:
        Number r4 = (Number) r2;     // Catch: Throwable -> L27
        if (r4 == null) goto L26;
        long r5 = r4.longValue();     // Catch: Throwable -> L27
        if (r5 > 0) goto L11;
        return;
    L11:
        Object r6 = this.a.get("jsbStartTime");     // Catch: Throwable -> L27
        if ((r6 instanceof Number) == true) goto L14;
        r6 = null;
    L14:
        Number r7 = (Number) r6;     // Catch: Throwable -> L27
        if (r7 == null) goto L17;
        Long r8 = Long.valueOf(r7.longValue());     // Catch: Throwable -> L27
    L18:
        Object r9 = this.a.get("scene");     // Catch: Throwable -> L27
        if ((r9 instanceof String) == true) goto L21;
        r9 = null;
    L21:
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L27
        r10.putOpt("open_time", Long.valueOf(r5));     // Catch: Throwable -> L27
        r10.putOpt("jsb_start_time", r8);     // Catch: Throwable -> L27
        r10.putOpt("jsb_end_time", Long.valueOf(this.b));     // Catch: Throwable -> L27
        r10.putOpt("router_start_time", Long.valueOf(this.c));     // Catch: Throwable -> L27
        r10.putOpt("router_end_time", Long.valueOf(this.d));     // Catch: Throwable -> L27
        r10.putOpt("scene", (String) r9);     // Catch: Throwable -> L27
        r10.putOpt("type", this.e);     // Catch: Throwable -> L27
        r10.putOpt("open_schema_type", Integer.valueOf(this.f));     // Catch: Throwable -> L27
        qf3.d r11 = this.g;     // Catch: Throwable -> L27
        if (r11 == null) goto L24;
        r3 = r11.b.B1.c;     // Catch: Throwable -> L27
    L24:
        r10.putOpt(PdpOpenThirdParam.KEY_PAGE_NAME, r3);     // Catch: Throwable -> L27
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L27
        AppLogNewUtils.onEventV3("mall_enter_detail_time", r10);     // Catch: Throwable -> L27
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L35;
        EnsureManager.ensureNotReachHere(r13);
        return;
    L35:
        return;
    L17:
        r8 = null;
        goto L18
    L26:
        return;
    L27:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
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
