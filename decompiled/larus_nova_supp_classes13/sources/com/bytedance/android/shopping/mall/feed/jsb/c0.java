package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c0 {

    public static final class a implements Runnable {
        public final /* synthetic */ ECMallFeed a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(ECMallFeed r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
            JSONObject r1 = com.bytedance.android.ec.hybrid.list.util.k.b(this.a.A1.getGlobalProps());     // Catch: Throwable -> L14
            r1.remove("mall_lynx_config");     // Catch: Throwable -> L14
            JSONObject r2 = com.bytedance.android.ec.hybrid.list.util.k.b(com.bytedance.android.shopping.api.mall.common.tools.v.f(UriProtector.parse(this.b)));     // Catch: Throwable -> L14
            IHybridHostService r3 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L14
            if (r3 == null) goto L11;
            yj.k r4 = r3.getIHybridHostEventService();     // Catch: Throwable -> L14
            if (r4 == null) goto L11;
            JSONObject r5 = new JSONObject();     // Catch: Throwable -> L14
            r5.put("business", "mall");     // Catch: Throwable -> L14
            r5.put("location", this.c);     // Catch: Throwable -> L14
            r5.put("in_schema", r1);     // Catch: Throwable -> L14
            r5.put("out_schema", r2);     // Catch: Throwable -> L14
            r5.put("origin_schema", this.b);     // Catch: Throwable -> L14
            Long r6 = this.a.B1.t;     // Catch: Throwable -> L14
            if (r6 == null) goto L9;
            long r7 = r6.longValue();     // Catch: Throwable -> L14
        L10:
            r5.put("gecko_id", r7);     // Catch: Throwable -> L14
            Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L14
            r4.logV3("schema_report", r5);     // Catch: Throwable -> L14
            Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L14
        L12:
            Result.constructor-impl(r9);     // Catch: Throwable -> L14
            return;
        L9:
            r7 = -1;
        L11:
            r9 = null;
        L14:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
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

    public static final void a(Map r1, String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$putIfNotNullOrEmpty");
        if (StringsKt.isBlank(r2) == false) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L11;
        if (r3 == null) goto L12;
        r1.put(r2, r3);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static final void b(ECMallFeed r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "mallFeed");
        Intrinsics.checkNotNullParameter(r3, "schema");
        if (r4 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        com.bytedance.android.ec.hybrid.a.d().submit(new a(r2, r3, r4));
        return;
    L5:
        if (r4.length() == 0) goto L8;
        r0 = false;
        goto L9
    }
}
