package xu4;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$Result;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.e;
import com.bytedance.ee.bear.bitable.statistic.i;
import com.bytedance.ee.bear.document.analytic.BatterySceneData;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends com.bytedance.ee.bear.bitable.statistic.common.a {
    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final List<BitableStatisticEventModel$NormalPointModel> c(e r2, BitableStatisticEventModel$NormalPointModel r3, List<BitableStatisticEventModel$NormalPointModel> r4) {
        Intrinsics.checkNotNullParameter(r2, "trace");
        Intrinsics.checkNotNullParameter(r3, "currPoint");
        Intrinsics.checkNotNullParameter(r4, "allPoints");
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final String getTag() {
        return "BitableViewFormSwitchConsumer";
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final String i() {
        return "base_mobile_performance_switch_to_forms_view";
    }

    public b() {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final boolean k(i r11, e r12, BitableStatisticEventModel$NormalPointModel r13, List<BitableStatisticEventModel$NormalPointModel> r14) {
        Intrinsics.checkNotNullParameter(r11, "logger");
        Intrinsics.checkNotNullParameter(r12, "trace");
        Intrinsics.checkNotNullParameter(r13, "currPoint");
        Intrinsics.checkNotNullParameter(r14, "allPoints");
        String r0 = r13.getName();
        if (Intrinsics.areEqual(r0, "VIEW_FORM_SWITCH_START") == false) goto L7;
        p();
        this.b.put("forms_type", "old_form");
        d(r13, BatterySceneData.OPT_START, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.o(this, r11, r12, r13);
        return false;
    L7:
        if (Intrinsics.areEqual(r0, "OPEN_RECORD_TTU") == true) goto L9;
    L11:
        return false;
    L9:
        if (this.a.containsKey(BatterySceneData.OPT_START) == false) goto L11;
        d(r13, BatterySceneData.OPT_END, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r11, r12, r13, BitableStatisticConstant$Result.SUCCESS, null, null, 112);
        goto L11
    }
}
