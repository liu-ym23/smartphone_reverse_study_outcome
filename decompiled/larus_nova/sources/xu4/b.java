package xu4;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$Result;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.e;
import com.bytedance.ee.bear.bitable.statistic.i;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends com.bytedance.ee.bear.bitable.statistic.common.a {
    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final List<BitableStatisticEventModel$NormalPointModel> c(e r100, BitableStatisticEventModel$NormalPointModel r101, List<BitableStatisticEventModel$NormalPointModel> r102) {
        Intrinsics.checkNotNullParameter(r100, "trace");
        Intrinsics.checkNotNullParameter(r101, "currPoint");
        Intrinsics.checkNotNullParameter(r102, "allPoints");
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
    public final boolean k(i r110, e r111, BitableStatisticEventModel$NormalPointModel r112, List<BitableStatisticEventModel$NormalPointModel> r113) {
        Intrinsics.checkNotNullParameter(r110, "logger");
        Intrinsics.checkNotNullParameter(r111, "trace");
        Intrinsics.checkNotNullParameter(r112, "currPoint");
        Intrinsics.checkNotNullParameter(r113, "allPoints");
        String r100 = r112.getName();
        if (Intrinsics.areEqual(r100, "VIEW_FORM_SWITCH_START") == false) goto L7;
        p();
        this.f215610b.put("forms_type", "old_form");
        d(r112, "start", null);
        com.bytedance.ee.bear.bitable.statistic.common.a.o(this, r110, r111, r112);
        return false;
    L7:
        if (Intrinsics.areEqual(r100, "OPEN_RECORD_TTU") == true) goto L9;
    L11:
        return false;
    L9:
        if (this.f215609a.containsKey("start") == false) goto L11;
        d(r112, "end", null);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r110, r111, r112, BitableStatisticConstant$Result.SUCCESS, null, null, 112);
        goto L11
    }
}
