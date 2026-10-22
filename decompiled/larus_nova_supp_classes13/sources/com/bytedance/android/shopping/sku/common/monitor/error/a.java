package com.bytedance.android.shopping.sku.common.monitor.error;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.utils.x0;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final Map<String, a> b = null;
    public final JSONObject a;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.sku.common.monitor.error.a$a, reason: collision with other inner class name */
    public static final class C0178a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ SkuErrorMonitorType b;
        public final /* synthetic */ String c;
        public final /* synthetic */ JSONObject d;

        public b(a r1, SkuErrorMonitorType r2, String r3, JSONObject r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r0 = this.a;     // Catch: Throwable -> L4
            String r1 = this.b.getValue();     // Catch: Throwable -> L4
            String r2 = this.c;     // Catch: Throwable -> L4
            JSONObject r3 = this.d;     // Catch: Throwable -> L4
            r0.getClass();     // Catch: Throwable -> L4
            a.b(r1, r2, r3);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        b = new LinkedHashMap();
    }

    public a(JSONObject r1) {
        this.a = r1;
    }

    public static void b(String r8, String r9, JSONObject r10) {
        ECProcessMonitor.l("yata_sku_or_ultimate", r8, r9, r10, null, null, null, 228);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        ECExceptionMonitor.e(e);
        int r11 = ECMonitorService.b;
        JSONObject r12 = new JSONObject();
        r12.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r12.put("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        r12.put("error_type", "CRASH");
        JSONObject r13 = new JSONObject();
        r13.put("error_msg", e.getMessage());
        Unit r14 = Unit.INSTANCE;
        r12.put("extra", r13);
        ECMonitorService.a.a("sku_error_monitor", r12, null, null);
    }

    public final void a(SkuErrorMonitorType r4, String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r4, "errorType");
        Intrinsics.checkNotNullParameter(r5, "errorMsg");
        JSONObject r0 = x0.a(this.a);
        r0.put("error_type", r4.getValue());
        r0.put("error_msg", r5);
        r0.put("extra", r6);
        int r7 = ECMonitorService.b;
        ECMonitorService.a.a("sku_error_monitor", r0, null, null);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        b(r4.getValue(), r5, r0);
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(new b(this, r4, r5, r0));
    }
}
