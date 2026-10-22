package yu4;

import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$Result;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.e;
import com.bytedance.ee.bear.bitable.statistic.i;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import com.ss.android.lark.monitor.memory.MemoryInfoUtil;
import com.suite.lark.platform.component.deviceperf.DevicePerfUtils;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c extends com.bytedance.ee.bear.bitable.statistic.common.a {

    public static final class a {
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
        return "BitableRecordCellEditConsumer";
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final String i() {
        return "base_mobile_performance_item_view_edit";
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final String j() {
        return "BASE_ITEM_VIEW_EDIT_START";
    }

    public c() {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final Map<String, Serializable> h(BitableStatisticConstant$Result r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Map<String, Serializable> r101 = super.h(r100);
        int r102 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.itemview.add.deviceinfo.edit.report") == false) goto L25;
        bsb.c r103 = DevicePerfManager.b.f432386a.f432372e;
        DevicePerfUtils.a r104 = DevicePerfUtils.e();
        if (r104 == null) goto L7;
        Serializable r105 = Double.valueOf(r104.f460576e);
    L8:
        r101.put("device_score", r105);
        if (r103 == null) goto L11;
        Serializable r106 = Float.valueOf(MemoryInfoUtil.getUsedJavaHeapMB());
    L12:
        r101.put("current_memory", r106);
        if (r103 == null) goto L15;
        int r107 = r103.f20374l;
    L16:
        r101.put("cpu_avg", Float.valueOf(r107 / 100.0f));
        if (r103 == null) goto L19;
        Serializable r108 = Float.valueOf(r103.f20373k);
    L20:
        r101.put("total_memory", r108);
        if (r103 == null) goto L23;
        Serializable r109 = Float.valueOf(r103.f20372j);
    L24:
        r101.put(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, r109);
        goto L25
    L23:
        r109 = -1;
        goto L24
    L19:
        r108 = -1;
        goto L20
    L15:
        r107 = -100;
        goto L16
    L11:
        r106 = -1;
        goto L12
    L7:
        r105 = -1;
    L25:
        return r101;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final boolean k(i r110, e r111, BitableStatisticEventModel$NormalPointModel r112, List<BitableStatisticEventModel$NormalPointModel> r113) {
        Intrinsics.checkNotNullParameter(r110, "logger");
        Intrinsics.checkNotNullParameter(r111, "trace");
        Intrinsics.checkNotNullParameter(r112, "currPoint");
        Intrinsics.checkNotNullParameter(r113, "allPoints");
        String r114 = r112.getName();
        if (Intrinsics.areEqual(r114, "BASE_ITEM_VIEW_EDIT_START") == false) goto L7;
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.o(this, r110, r111, r112);
        return false;
    L7:
        if (Intrinsics.areEqual(r114, "BASE_ITEM_VIEW_EDIT_JSSDK_SET_RECORD") == false) goto L9;
    L24:
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r110, r111, r112, false, 24);
        return false;
    L9:
        if (Intrinsics.areEqual(r114, "BASE_ITEM_VIEW_EDIT_JSSDK_GEN_CARDS_DATA") == true) goto L24;
        if (Intrinsics.areEqual(r114, "BASE_ITEM_VIEW_EDIT_RECEIVE_UPDATE") == true) goto L24;
        if (Intrinsics.areEqual(r114, "BASE_ITEM_VIEW_EDIT_REQUEST_RECORD_DATA_START") == true) goto L24;
        if (Intrinsics.areEqual(r114, "BASE_ITEM_VIEW_EDIT_REQUEST_TABLE_DATA_START") == true) goto L24;
        if (Intrinsics.areEqual(r114, "BASE_ITEM_VIEW_EDIT_REQUEST_RECORD_DATA_FINISH") == true) goto L24;
        if (Intrinsics.areEqual(r114, "BASE_ITEM_VIEW_EDIT_RENDER_UI_FINISH") == false) goto L23;
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r110, r111, r112, BitableStatisticConstant$Result.SUCCESS, "success", null, 96);
        return true;
    L23:
        return false;
    }
}
