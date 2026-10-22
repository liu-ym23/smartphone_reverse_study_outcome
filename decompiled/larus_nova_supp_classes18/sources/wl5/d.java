package wl5;

import com.bytedance.ee.bear.rn.RnSyncManager;
import com.bytedance.ee.bear.rn.u;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import onb.j;
import vl5.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements j<i> {
    public d() {
    }

    public final /* bridge */ /* synthetic */ void a(onb.b r1) {
        i r2 = (i) r1;
    }

    public final void onError(String r3, String r4) {
        tt5.a.h("JSModelService-Docs", "commands-> + onError  ->code: " + r3 + " message: " + r4);
        RnSyncManager r0 = RnSyncManager.a;
        Intrinsics.checkNotNullParameter("dev_performance_rn_error", "event");
        Intrinsics.checkNotNullParameter(r3, "code");
        Intrinsics.checkNotNullParameter(r4, "message");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("rn_error_code", r3);
        r1.put("rn_error_message", r4);
        iu5.f.a(new u(r1));
    }
}
