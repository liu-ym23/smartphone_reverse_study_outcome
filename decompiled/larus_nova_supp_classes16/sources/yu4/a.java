package yu4;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$Result;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.e;
import com.bytedance.ee.bear.bitable.statistic.i;
import com.bytedance.ee.bear.document.analytic.BatterySceneData;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends com.bytedance.ee.bear.bitable.statistic.common.a {
    public final String f;

    /* JADX INFO: renamed from: yu4.a$a, reason: collision with other inner class name */
    public static final class C0326a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final List<BitableStatisticEventModel$NormalPointModel> c(e r2, BitableStatisticEventModel$NormalPointModel r3, List<BitableStatisticEventModel$NormalPointModel> r4) {
        Intrinsics.checkNotNullParameter(r2, "trace");
        Intrinsics.checkNotNullParameter(r3, "currPoint");
        Intrinsics.checkNotNullParameter(r4, "allPoints");
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final String getTag() {
        return "CellDrillDownConsumer";
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final String i() {
        return this.f;
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "panelEventName");
        this.f = r2;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final boolean k(i r10, e r11, BitableStatisticEventModel$NormalPointModel r12, List<BitableStatisticEventModel$NormalPointModel> r13) {
        Intrinsics.checkNotNullParameter(r10, "logger");
        Intrinsics.checkNotNullParameter(r11, "trace");
        Intrinsics.checkNotNullParameter(r12, "currPoint");
        Intrinsics.checkNotNullParameter(r13, "allPoints");
        String r0 = r12.getName();
        if (Intrinsics.areEqual(r0, BatterySceneData.OPT_START) == false) goto L7;
        d(r12, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.o(this, r10, r11, r12);
        return false;
    L7:
        if (Intrinsics.areEqual(r0, "panel_show_success") == false) goto L9;
    L20:
        d(r12, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r10, r11, r12, BitableStatisticConstant$Result.SUCCESS, null, null, 112);
        return true;
    L9:
        if (Intrinsics.areEqual(r0, "auto_location_success") == true) goto L20;
        if (Intrinsics.areEqual(r0, "upload_success") == true) goto L20;
        if (Intrinsics.areEqual(r0, "panel_show_failed") == false) goto L16;
    L19:
        d(r12, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r10, r11, r12, BitableStatisticConstant$Result.FAIL, null, null, 112);
        return true;
    L16:
        if (Intrinsics.areEqual(r0, "auto_location_failed") == true) goto L19;
        if (Intrinsics.areEqual(r0, "upload_failed") == true) goto L19;
        return true;
    }
}
