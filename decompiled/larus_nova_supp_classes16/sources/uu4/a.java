package uu4;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$Result;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.common.layoutdraw.BitableListItemDrawTimeConsumer;
import com.bytedance.ee.bear.bitable.statistic.i;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends com.bytedance.ee.bear.bitable.statistic.common.a {
    public int f;
    public int g;
    public int h;
    public boolean i;

    /* JADX INFO: renamed from: uu4.a$a, reason: collision with other inner class name */
    public static final class C0308a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final String getTag() {
        return "OpenRecordConsumer";
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final String i() {
        return "base_mobile_performance_open_record";
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final String j() {
        return "OPEN_RECORD_START";
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final List<BitableStatisticEventModel$NormalPointModel> c(com.bytedance.ee.bear.bitable.statistic.e r4, BitableStatisticEventModel$NormalPointModel r5, List<BitableStatisticEventModel$NormalPointModel> r6) {
        Intrinsics.checkNotNullParameter(r4, "trace");
        Intrinsics.checkNotNullParameter(r5, "currPoint");
        Intrinsics.checkNotNullParameter(r6, "allPoints");
        if (this.i == false) goto L5;
        return null;
    L5:
        int r7 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
        tt5.a.h("BitableStatistic", "OpenRecordConsumer " + ("consumeTempPoint " + r5.getName()));
        if (Intrinsics.areEqual(r5.getName(), "OPEN_RECORD_CELL_LIST") == false) goto L16;
        this.i = true;
        int r8 = BitableListItemDrawTimeConsumer.c;
        BitableListItemDrawTimeConsumer.a.b();
        BitableListItemDrawTimeConsumer.a.a();
        Iterator<T> r9 = r6.iterator();
    L9:
        if (r9.hasNext() == false) goto L16;
        String r10 = ((BitableStatisticEventModel$NormalPointModel) r9.next()).getName();
        if (Intrinsics.areEqual(r10, "OPEN_RECORD_CELL_LIST_set_data") == true) goto L12;
        if (Intrinsics.areEqual(r10, "OPEN_RECORD_CELL_LIST_item_draw") == false) goto L9;
        this.h++;
        goto L9
    L12:
        this.g++;
    L16:
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final boolean k(i r11, com.bytedance.ee.bear.bitable.statistic.e r12, BitableStatisticEventModel$NormalPointModel r13, List<BitableStatisticEventModel$NormalPointModel> r14) {
        Intrinsics.checkNotNullParameter(r11, "logger");
        Intrinsics.checkNotNullParameter(r12, "trace");
        Intrinsics.checkNotNullParameter(r13, "currPoint");
        Intrinsics.checkNotNullParameter(r14, "allPoints");
        String r0 = r13.getName();
        if (Intrinsics.areEqual(r0, "OPEN_RECORD_START") == false) goto L7;
        d(r13, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.o(this, r11, r12, r13);
        return false;
    L7:
        if (Intrinsics.areEqual(r0, "OPEN_RECORD_SET_RECORD") == false) goto L14;
        if (this.f != 0) goto L11;
        d(r13, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r11, r12, r13, false, 24);
    L11:
        this.f++;
        return false;
    L14:
        if (Intrinsics.areEqual(r0, "OPEN_RECORD_TTV_NOTIFY_DATA_CHANGED") == false) goto L16;
    L44:
        d(r13, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r11, r12, r13, false, 24);
        int r1 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
        Long r2 = com.bytedance.ee.bear.bitable.statistic.common.e.a(this.a, "OPEN_RECORD_START", "OPEN_RECORD_TTV");
        if (r2 == null) goto L47;
        a("OPEN_RECORD_TTV", Long.valueOf(r2.longValue()));
    L47:
        return false;
    L16:
        if (Intrinsics.areEqual(r0, "OPEN_RECORD_TTU_NOTIFY_DATA_CHANGED") == true) goto L44;
        if (Intrinsics.areEqual(r0, "OPEN_RECORD_NOTIFY_TABLE_SHOWING") == true) goto L44;
        if (Intrinsics.areEqual(r0, "OPEN_RECORD_FETCH_DATA_END") == true) goto L44;
        if (Intrinsics.areEqual(r0, "OPEN_RECORD_SHOW_FRAGMENT") == true) goto L44;
        if (Intrinsics.areEqual(r0, "OPEN_RECORD_RETRY") == true) goto L44;
        if (Intrinsics.areEqual(r0, "OPEN_RECORD_TTV") == true) goto L44;
        if (Intrinsics.areEqual(r0, "OPEN_RECORD_CLOSE") == false) goto L33;
        d(r13, "OPEN_FILE_CANCEL", null);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r11, r12, r13, BitableStatisticConstant$Result.CANCEL, "close", null, 96);
        return true;
    L33:
        if (Intrinsics.areEqual(r0, "OPEN_RECORD_FAIL") == false) goto L37;
        d(r13, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r11, r12, r13, BitableStatisticConstant$Result.FAIL, null, null, 112);
        return true;
    L37:
        if (Intrinsics.areEqual(r0, "OPEN_RECORD_TTU") == false) goto L43;
        d(r13, null, null);
        int r3 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
        Long r4 = com.bytedance.ee.bear.bitable.statistic.common.e.a(this.a, "OPEN_RECORD_START", "OPEN_RECORD_TTU");
        if (r4 == null) goto L41;
        a("OPEN_RECORD_TTU", Long.valueOf(r4.longValue()));
    L41:
        BitableStatisticConstant$Result r5 = BitableStatisticConstant$Result.SUCCESS;
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("ttv_set_record_count", Integer.valueOf(this.f));
        r6.put("ttv_cell_set_data_count", Integer.valueOf(this.g));
        r6.put("ttv_cell_draw_count", Integer.valueOf(this.h));
        Unit r7 = Unit.INSTANCE;
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r11, r12, r13, r5, null, r6, 80);
        return true;
    L43:
        return false;
    }
}
