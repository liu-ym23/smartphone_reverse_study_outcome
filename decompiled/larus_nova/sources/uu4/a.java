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

/* JADX INFO: loaded from: classes16.dex */
public final class a extends com.bytedance.ee.bear.bitable.statistic.common.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f551739f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f551740g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f551741h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f551742i;

    /* JADX INFO: renamed from: uu4.a$a, reason: collision with other inner class name */
    public static final class C7936a {
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
    public final List<BitableStatisticEventModel$NormalPointModel> c(com.bytedance.ee.bear.bitable.statistic.e r100, BitableStatisticEventModel$NormalPointModel r101, List<BitableStatisticEventModel$NormalPointModel> r102) {
        Intrinsics.checkNotNullParameter(r100, "trace");
        Intrinsics.checkNotNullParameter(r101, "currPoint");
        Intrinsics.checkNotNullParameter(r102, "allPoints");
        if (this.f551742i == false) goto L5;
        return null;
    L5:
        int r103 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
        tt5.a.h("BitableStatistic", "OpenRecordConsumer " + ("consumeTempPoint " + r101.getName()));
        if (Intrinsics.areEqual(r101.getName(), "OPEN_RECORD_CELL_LIST") == false) goto L16;
        this.f551742i = true;
        int r104 = BitableListItemDrawTimeConsumer.f215632c;
        BitableListItemDrawTimeConsumer.a.b();
        BitableListItemDrawTimeConsumer.a.a();
        Iterator<T> r105 = r102.iterator();
    L9:
        if (r105.hasNext() == false) goto L16;
        String r106 = ((BitableStatisticEventModel$NormalPointModel) r105.next()).getName();
        if (Intrinsics.areEqual(r106, "OPEN_RECORD_CELL_LIST_set_data") == true) goto L12;
        if (Intrinsics.areEqual(r106, "OPEN_RECORD_CELL_LIST_item_draw") == false) goto L9;
        this.f551741h++;
        goto L9
    L12:
        this.f551740g++;
    L16:
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final boolean k(i r110, com.bytedance.ee.bear.bitable.statistic.e r111, BitableStatisticEventModel$NormalPointModel r112, List<BitableStatisticEventModel$NormalPointModel> r113) {
        Intrinsics.checkNotNullParameter(r110, "logger");
        Intrinsics.checkNotNullParameter(r111, "trace");
        Intrinsics.checkNotNullParameter(r112, "currPoint");
        Intrinsics.checkNotNullParameter(r113, "allPoints");
        String r100 = r112.getName();
        if (Intrinsics.areEqual(r100, "OPEN_RECORD_START") == false) goto L7;
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.o(this, r110, r111, r112);
        return false;
    L7:
        if (Intrinsics.areEqual(r100, "OPEN_RECORD_SET_RECORD") == false) goto L14;
        if (this.f551739f != 0) goto L11;
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r110, r111, r112, false, 24);
    L11:
        this.f551739f++;
        return false;
    L14:
        if (Intrinsics.areEqual(r100, "OPEN_RECORD_TTV_NOTIFY_DATA_CHANGED") == false) goto L16;
    L44:
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r110, r111, r112, false, 24);
        int r101 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
        Long r102 = com.bytedance.ee.bear.bitable.statistic.common.e.a(this.f215609a, "OPEN_RECORD_START", "OPEN_RECORD_TTV");
        if (r102 == null) goto L47;
        a("OPEN_RECORD_TTV", Long.valueOf(r102.longValue()));
    L47:
        return false;
    L16:
        if (Intrinsics.areEqual(r100, "OPEN_RECORD_TTU_NOTIFY_DATA_CHANGED") == true) goto L44;
        if (Intrinsics.areEqual(r100, "OPEN_RECORD_NOTIFY_TABLE_SHOWING") == true) goto L44;
        if (Intrinsics.areEqual(r100, "OPEN_RECORD_FETCH_DATA_END") == true) goto L44;
        if (Intrinsics.areEqual(r100, "OPEN_RECORD_SHOW_FRAGMENT") == true) goto L44;
        if (Intrinsics.areEqual(r100, "OPEN_RECORD_RETRY") == true) goto L44;
        if (Intrinsics.areEqual(r100, "OPEN_RECORD_TTV") == true) goto L44;
        if (Intrinsics.areEqual(r100, "OPEN_RECORD_CLOSE") == false) goto L33;
        d(r112, "OPEN_FILE_CANCEL", null);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r110, r111, r112, BitableStatisticConstant$Result.CANCEL, "close", null, 96);
        return true;
    L33:
        if (Intrinsics.areEqual(r100, "OPEN_RECORD_FAIL") == false) goto L37;
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r110, r111, r112, BitableStatisticConstant$Result.FAIL, null, null, 112);
        return true;
    L37:
        if (Intrinsics.areEqual(r100, "OPEN_RECORD_TTU") == false) goto L43;
        d(r112, null, null);
        int r103 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
        Long r104 = com.bytedance.ee.bear.bitable.statistic.common.e.a(this.f215609a, "OPEN_RECORD_START", "OPEN_RECORD_TTU");
        if (r104 == null) goto L41;
        a("OPEN_RECORD_TTU", Long.valueOf(r104.longValue()));
    L41:
        BitableStatisticConstant$Result r105 = BitableStatisticConstant$Result.SUCCESS;
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("ttv_set_record_count", Integer.valueOf(this.f551739f));
        r106.put("ttv_cell_set_data_count", Integer.valueOf(this.f551740g));
        r106.put("ttv_cell_draw_count", Integer.valueOf(this.f551741h));
        Unit r107 = Unit.INSTANCE;
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r110, r111, r112, r105, null, r106, 80);
        return true;
    L43:
        return false;
    }
}
