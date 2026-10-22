package yu4;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$Result;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.e;
import com.bytedance.ee.bear.bitable.statistic.i;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends com.bytedance.ee.bear.bitable.statistic.common.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f569222f;

    /* JADX INFO: renamed from: yu4.a$a, reason: collision with other inner class name */
    public static final class C8388a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final List<BitableStatisticEventModel$NormalPointModel> c(e r100, BitableStatisticEventModel$NormalPointModel r101, List<BitableStatisticEventModel$NormalPointModel> r102) {
        Intrinsics.checkNotNullParameter(r100, "trace");
        Intrinsics.checkNotNullParameter(r101, "currPoint");
        Intrinsics.checkNotNullParameter(r102, "allPoints");
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final String getTag() {
        return "CellDrillDownConsumer";
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final String i() {
        return this.f569222f;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "panelEventName");
        this.f569222f = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final boolean k(i r110, e r111, BitableStatisticEventModel$NormalPointModel r112, List<BitableStatisticEventModel$NormalPointModel> r113) {
        Intrinsics.checkNotNullParameter(r110, "logger");
        Intrinsics.checkNotNullParameter(r111, "trace");
        Intrinsics.checkNotNullParameter(r112, "currPoint");
        Intrinsics.checkNotNullParameter(r113, "allPoints");
        String r100 = r112.getName();
        if (Intrinsics.areEqual(r100, "start") == false) goto L7;
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.o(this, r110, r111, r112);
        return false;
    L7:
        if (Intrinsics.areEqual(r100, "panel_show_success") == false) goto L9;
    L20:
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r110, r111, r112, BitableStatisticConstant$Result.SUCCESS, null, null, 112);
        return true;
    L9:
        if (Intrinsics.areEqual(r100, "auto_location_success") == true) goto L20;
        if (Intrinsics.areEqual(r100, "upload_success") == true) goto L20;
        if (Intrinsics.areEqual(r100, "panel_show_failed") == false) goto L16;
    L19:
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r110, r111, r112, BitableStatisticConstant$Result.FAIL, null, null, 112);
        return true;
    L16:
        if (Intrinsics.areEqual(r100, "auto_location_failed") == true) goto L19;
        if (Intrinsics.areEqual(r100, "upload_failed") == true) goto L19;
        return true;
    }
}
