package yu4;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$Result;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.e;
import com.bytedance.ee.bear.bitable.statistic.i;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import com.ss.android.lark.monitor.memory.MemoryInfoUtil;
import com.suite.lark.platform.component.deviceperf.DevicePerfUtils;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends com.bytedance.ee.bear.bitable.statistic.common.a {

    public static final class a {
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
    public final Map<String, Serializable> h(BitableStatisticConstant$Result r6) {
        Intrinsics.checkNotNullParameter(r6, TipCallBackData.RESULT);
        Map<String, Serializable> r7 = super.h(r6);
        int r0 = com.bytedance.ee.bear.bitable.c.a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.itemview.add.deviceinfo.edit.report") == false) goto L25;
        bsb.c r1 = DevicePerfManager.b.a.e;
        DevicePerfUtils.a r2 = DevicePerfUtils.e();
        if (r2 == null) goto L7;
        Serializable r3 = Double.valueOf(r2.e);
    L8:
        r7.put("device_score", r3);
        if (r1 == null) goto L11;
        Serializable r4 = Float.valueOf(MemoryInfoUtil.getUsedJavaHeapMB());
    L12:
        r7.put("current_memory", r4);
        if (r1 == null) goto L15;
        int r5 = r1.l;
    L16:
        r7.put("cpu_avg", Float.valueOf(r5 / 100.0f));
        if (r1 == null) goto L19;
        Serializable r8 = Float.valueOf(r1.k);
    L20:
        r7.put("total_memory", r8);
        if (r1 == null) goto L23;
        Serializable r9 = Float.valueOf(r1.j);
    L24:
        r7.put("temperature", r9);
        goto L25
    L23:
        r9 = -1;
        goto L24
    L19:
        r8 = -1;
        goto L20
    L15:
        r5 = -100;
        goto L16
    L11:
        r4 = -1;
        goto L12
    L7:
        r3 = -1;
    L25:
        return r7;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final boolean k(i r12, e r13, BitableStatisticEventModel$NormalPointModel r14, List<BitableStatisticEventModel$NormalPointModel> r16) {
        Intrinsics.checkNotNullParameter(r12, "logger");
        Intrinsics.checkNotNullParameter(r13, "trace");
        Intrinsics.checkNotNullParameter(r14, "currPoint");
        Intrinsics.checkNotNullParameter(r16, "allPoints");
        String r17 = r14.getName();
        if (Intrinsics.areEqual(r17, "BASE_ITEM_VIEW_EDIT_START") == false) goto L7;
        d(r14, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.o(this, r12, r13, r14);
        return false;
    L7:
        if (Intrinsics.areEqual(r17, "BASE_ITEM_VIEW_EDIT_JSSDK_SET_RECORD") == false) goto L9;
    L24:
        d(r14, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r12, r13, r14, false, 24);
        return false;
    L9:
        if (Intrinsics.areEqual(r17, "BASE_ITEM_VIEW_EDIT_JSSDK_GEN_CARDS_DATA") == true) goto L24;
        if (Intrinsics.areEqual(r17, "BASE_ITEM_VIEW_EDIT_RECEIVE_UPDATE") == true) goto L24;
        if (Intrinsics.areEqual(r17, "BASE_ITEM_VIEW_EDIT_REQUEST_RECORD_DATA_START") == true) goto L24;
        if (Intrinsics.areEqual(r17, "BASE_ITEM_VIEW_EDIT_REQUEST_TABLE_DATA_START") == true) goto L24;
        if (Intrinsics.areEqual(r17, "BASE_ITEM_VIEW_EDIT_REQUEST_RECORD_DATA_FINISH") == true) goto L24;
        if (Intrinsics.areEqual(r17, "BASE_ITEM_VIEW_EDIT_RENDER_UI_FINISH") == false) goto L23;
        d(r14, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r12, r13, r14, BitableStatisticConstant$Result.SUCCESS, "success", null, 96);
        return true;
    L23:
        return false;
    }
}
