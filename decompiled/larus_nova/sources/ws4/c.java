package ws4;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$Result;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.i;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends com.bytedance.ee.bear.bitable.statistic.common.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f561043f;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final List<BitableStatisticEventModel$NormalPointModel> c(com.bytedance.ee.bear.bitable.statistic.e r100, BitableStatisticEventModel$NormalPointModel r101, List<BitableStatisticEventModel$NormalPointModel> r102) {
        Intrinsics.checkNotNullParameter(r100, "trace");
        Intrinsics.checkNotNullParameter(r101, "currPoint");
        Intrinsics.checkNotNullParameter(r102, "allPoints");
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final String getTag() {
        return "BitableHomePageV4Consumer";
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final String i() {
        return "base_mobile_performance_enter_homepage_tab";
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final String j() {
        return "start";
    }

    public c() {
    }

    public final void q(BitableStatisticEventModel$NormalPointModel r100, i r110, com.bytedance.ee.bear.bitable.statistic.e r111) {
        d(r100, null, null);
        r100.addExtra(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(r100.getTimestamp() - this.f561043f));
        HashMap r101 = new HashMap();
        r101.putAll(this.f215609a);
        Unit r102 = Unit.INSTANCE;
        r100.addExtra("main_stage_timestamp_list", r101);
        int r103 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
        r100.addExtra("main_stage_duration_list", com.bytedance.ee.bear.bitable.statistic.common.e.b(this.f215609a, "start"));
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r110, r111, r100, false, 24);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final boolean k(i r110, com.bytedance.ee.bear.bitable.statistic.e r111, BitableStatisticEventModel$NormalPointModel r112, List<BitableStatisticEventModel$NormalPointModel> r113) {
        Intrinsics.checkNotNullParameter(r110, "logger");
        Intrinsics.checkNotNullParameter(r111, "trace");
        Intrinsics.checkNotNullParameter(r112, "currPoint");
        Intrinsics.checkNotNullParameter(r113, "allPoints");
        String r100 = r112.getName();
        switch(r100.hashCode()) {
            case -1609811416: goto L51;
            case -1110874977: goto L46;
            case -632402295: goto L41;
            case -96401826: goto L36;
            case 12848240: goto L31;
            case 109757538: goto L26;
            case 648090624: goto L21;
            case 1404662961: goto L16;
            case 1725126658: goto L11;
            case 1935450183: goto L6;
            default: goto L54;
        };
    L54:
        return false;
    L6:
        if (r100.equals("OPEN_HOME_LOAD_DATA_END_FILE") == false) goto L54;
        r112.addExtra(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(r112.getTimestamp() - this.f561043f));
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r110, r111, r112, false, 24);
        return false;
    L11:
        if (r100.equals("end_fail") == false) goto L54;
        q(r112, r110, r111);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r110, r111, r112, BitableStatisticConstant$Result.FAIL, null, null, 112);
        return true;
    L16:
        if (r100.equals("OPEN_HOME_LOAD_DATA_END_RECOMMEND") == false) goto L54;
        r112.addExtra(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(r112.getTimestamp() - this.f561043f));
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r110, r111, r112, false, 24);
        return false;
    L21:
        if (r100.equals("OPEN_HOME_TTV_DASHBOARD") == false) goto L54;
        r112.addExtra(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(r112.getTimestamp() - this.f561043f));
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r110, r111, r112, false, 24);
        return false;
    L26:
        if (r100.equals("start") == false) goto L54;
        this.f561043f = r112.getTimestamp();
        p();
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.o(this, r110, r111, r112);
        return false;
    L31:
        if (r100.equals("OPEN_HOME_TTV_FILE") == false) goto L54;
        r112.addExtra(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(r112.getTimestamp() - this.f561043f));
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r110, r111, r112, false, 24);
        return false;
    L36:
        if (r100.equals("end_cancel") == false) goto L54;
        q(r112, r110, r111);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r110, r111, r112, BitableStatisticConstant$Result.CANCEL, null, null, 112);
        return true;
    L41:
        if (r100.equals("OPEN_HOME_LOAD_DATA_END_DASHBOARD") == false) goto L54;
        r112.addExtra(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(r112.getTimestamp() - this.f561043f));
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r110, r111, r112, false, 24);
        return false;
    L46:
        if (r100.equals("end_success") == false) goto L54;
        q(r112, r110, r111);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r110, r111, r112, BitableStatisticConstant$Result.SUCCESS, null, null, 112);
        return true;
    L51:
        if (r100.equals("OPEN_HOME_TTV_RECOMMEND") == false) goto L54;
        r112.addExtra(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(r112.getTimestamp() - this.f561043f));
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r110, r111, r112, false, 24);
        goto L54
    }
}
