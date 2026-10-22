package com.bytedance.android.shopping.card_list.monitor.error;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final Map<String, a> b = null;
    public final JSONObject a;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.card_list.monitor.error.a$a, reason: collision with other inner class name */
    public static final class C0034a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ CardListErrorMonitorType b;
        public final /* synthetic */ String c;
        public final /* synthetic */ JSONObject d;

        public b(a r1, CardListErrorMonitorType r2, String r3, JSONObject r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a(this.b.getValue(), this.c, this.d);     // Catch: Throwable -> L4
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

    public final void a(String r11, String r12, JSONObject r13) {
        Set r0 = ECProcessMonitor.a;     // Catch: Exception -> L4
        ECProcessMonitor.l(this.a.optString(PdpOpenThirdParam.KEY_PAGE_NAME), r11, r12, r13, null, null, null, 228);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        ECExceptionMonitor.e(e);
        int r14 = ECMonitorService.b;
        JSONObject r15 = new JSONObject();
        r15.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r15.put("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        r15.put("error_type", "CRASH");
        JSONObject r16 = new JSONObject();
        r16.put("error_msg", e.getMessage());
        Unit r17 = Unit.INSTANCE;
        r15.put("extra", r16);
        ECMonitorService.a.a("card_list_error_monitor", r15, null, null);
    }

    public final void b(CardListErrorMonitorType r4, String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r4, "errorType");
        Intrinsics.checkNotNullParameter(r5, "errorMsg");
        JSONObject r0 = x0.a(this.a);
        r0.put("error_type", r4.getValue());
        r0.put("error_msg", r5);
        r0.put("extra", r6);
        int r7 = ECMonitorService.b;
        ECMonitorService.a.a("card_list_error_monitor", r0, null, null);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        a(r4.getValue(), r5, r0);
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(new b(this, r4, r5, r0));
    }
}
