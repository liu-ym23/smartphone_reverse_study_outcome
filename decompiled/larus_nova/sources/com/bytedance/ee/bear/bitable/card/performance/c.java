package com.bytedance.ee.bear.bitable.card.performance;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.HashMap;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f207188l = 0;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f207189a = null;

        static {
            f207189a = new c();
        }
    }

    static {
    }

    public c() {
    }

    public final void a(com.bytedance.ee.bear.contract.d r100, String r101, String r102) {
        int r103 = com.bytedance.ee.bear.bitable.card.performance.b.f207177u;
        com.bytedance.ee.bear.bitable.card.performance.b.C2989b.f207187a.f207200j = false;
        int r104 = com.bytedance.ee.bear.bitable.card.performance.a.f207168s;
        com.bytedance.ee.bear.bitable.card.performance.a.b.f207176a.f207200j = false;
        HashMap r105 = new HashMap();
        r105.put("file_id", this.f207191a);
        r105.put(EventConstant.Key.MODULE, this.f207192b);
        r105.put("table_id", this.f207193c);
        r105.put(BitableResourceData.KEY_VIEW_ID, this.f207194d);
        r105.put("platform", "native");
        r105.put(BdpAppEventConstant.PARAMS_FAIL_TYPE, r101);
        r105.put("error_msg", r102);
        tt5.a.b("STPerformanceTracker_DataParseFail", "report the ST data parsing failed : params = " + r105);
        if (r100 == null) goto L6;
        r100.v("bitable_performance_fail_details", r105);
        return;
    }
}
