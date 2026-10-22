package tu4;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$Result;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.i;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public abstract class a extends com.bytedance.ee.bear.bitable.statistic.common.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f547618f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f547619g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f547620h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashMap<String, Serializable> f547621i;

    /* JADX INFO: renamed from: tu4.a$a, reason: collision with other inner class name */
    public static final class C7778a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final String getTag() {
        return "OpenFileConsumer";
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final String i() {
        return "base_mobile_performance_open_file";
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final String j() {
        return "OPEN_FILE_START";
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public List<String> e() {
        return CollectionsKt.listOf(new String[]{"OPEN_FILE_TTV", "OPEN_FILE_TTU"});
    }

    public a() {
        this.f547621i = new HashMap();
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final void p() {
        super.p();
        this.f547621i.clear();
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final List<BitableStatisticEventModel$NormalPointModel> c(com.bytedance.ee.bear.bitable.statistic.e r100, BitableStatisticEventModel$NormalPointModel r101, List<BitableStatisticEventModel$NormalPointModel> r102) {
        Intrinsics.checkNotNullParameter(r100, "trace");
        Intrinsics.checkNotNullParameter(r101, "currPoint");
        Intrinsics.checkNotNullParameter(r102, "allPoints");
        int r103 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
        tt5.a.h("BitableStatistic", "OpenFileConsumer " + ("OpenFile consumeTempPoint " + r101.getName()));
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public boolean k(i r110, com.bytedance.ee.bear.bitable.statistic.e r111, BitableStatisticEventModel$NormalPointModel r112, List<BitableStatisticEventModel$NormalPointModel> r113) {
        Intrinsics.checkNotNullParameter(r110, "logger");
        Intrinsics.checkNotNullParameter(r111, "trace");
        Intrinsics.checkNotNullParameter(r112, "currPoint");
        Intrinsics.checkNotNullParameter(r113, "allPoints");
        String r100 = r112.getName();
        if (Intrinsics.areEqual(r100, "OPEN_FILE_START") == false) goto L7;
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.o(this, r110, r111, r112);
        return false;
    L7:
        if (Intrinsics.areEqual(r100, "OPEN_FILE_BRIDGE_IS_READY") == false) goto L9;
    L94:
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r110, r111, r112, false, 24);
        return false;
    L9:
        if (Intrinsics.areEqual(r100, "OPEN_FILE_CREATE_UI_START") == true) goto L94;
        if (Intrinsics.areEqual(r100, "OPEN_FILE_CREATE_UI_END") == true) goto L94;
        if (Intrinsics.areEqual(r100, "OPEN_FILE_TEMPLATE_PRELOAD_START") == true) goto L94;
        if (Intrinsics.areEqual(r100, "OPEN_FILE_TEMPLATE_PRELOAD_END") == true) goto L94;
        if (Intrinsics.areEqual(r100, "OPEN_FILE_START_RENDER") == true) goto L94;
        if (Intrinsics.areEqual(r100, "OPEN_FILE_END_RENDER") == true) goto L94;
        if (Intrinsics.areEqual(r100, "OPEN_FILE_AFTER_CLIENTVARS_LOADED_AND_SWITCH") == true) goto L94;
        if (Intrinsics.areEqual(r100, "BITABLE_NATIVE_VIEW_RENDER_START") == true) goto L94;
        if (Intrinsics.areEqual(r100, "BITABLE_NATIVE_VIEW_RECEIVE_DATA") == true) goto L94;
        if (Intrinsics.areEqual(r100, "OPEN_FILE_OLD_RENDER_SUCCESS") == true) goto L94;
        if (Intrinsics.areEqual(r100, "POINT_MID_STAGE_COST") == false) goto L39;
        HashMap<String, Serializable> r101 = r112.getExtras();
        if (r101 == null) goto L37;
        Iterator<Map.Entry<String, Serializable>> r102 = r101.entrySet().iterator();
    L35:
        if (r102.hasNext() == false) goto L37;
        Map.Entry<String, Serializable> r103 = r102.next();
        d(r112, r103.getKey(), r103.getValue());
    L37:
        return false;
    L39:
        if (Intrinsics.areEqual(r100, "POINT_SDK_LOAD_COST") == false) goto L46;
        this.f547620h = true;
        HashMap<String, Serializable> r104 = r112.getExtras();
        if (r104 == null) goto L43;
        r104.putAll(this.f547621i);
    L43:
        d(r112, "SDK_COST", r112.getExtras());
        a("is_from_native_pull", Boolean.FALSE);
        return false;
    L46:
        if (Intrinsics.areEqual(r100, "POINT_NATIVE_LOAD_COST") == false) goto L52;
        HashMap<String, Serializable> r105 = r112.getExtras();
        if (r105 == null) goto L50;
        this.f547621i.putAll(r105);
    L50:
        return false;
    L52:
        if (Intrinsics.areEqual(r100, "POINT_ADD_END_STAGE_EXTRA") == false) goto L61;
        HashMap<String, Serializable> r106 = r112.getExtras();
        if (r106 == null) goto L59;
        Iterator<Map.Entry<String, Serializable>> r107 = r106.entrySet().iterator();
    L57:
        if (r107.hasNext() == false) goto L59;
        Map.Entry<String, Serializable> r108 = r107.next();
        a(r108.getKey(), r108.getValue());
    L59:
        return false;
    L61:
        if (Intrinsics.areEqual(r100, "OPEN_FILE_CANCEL") == false) goto L65;
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r110, r111, r112, BitableStatisticConstant$Result.CANCEL, "cancel", null, 96);
        return true;
    L65:
        if (Intrinsics.areEqual(r100, "OPEN_FILE_FAIL") == false) goto L69;
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r110, r111, r112, BitableStatisticConstant$Result.FAIL, null, null, 112);
        return true;
    L69:
        if (Intrinsics.areEqual(r100, "OPEN_FILE_TTV") == false) goto L80;
        if (this.f547619g == false) goto L73;
        return false;
    L73:
        this.f547619g = true;
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r110, r111, r112, false, 24);
        if (this.f547618f == false) goto L76;
        long r109 = r112.getTimestamp();
        Intrinsics.checkNotNullParameter("OPEN_FILE_TTU", "stageName");
        Long r114 = Long.valueOf(r109);
        this.f215609a.put("OPEN_FILE_TTU", r114);
    L76:
        int r115 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
        Long r116 = com.bytedance.ee.bear.bitable.statistic.common.e.a(this.f215609a, "OPEN_FILE_START", "OPEN_FILE_TTV");
        if (r116 == null) goto L93;
        a("open_file_ttv", Long.valueOf(r116.longValue()));
    L93:
        return false;
    L80:
        if (Intrinsics.areEqual(r100, "OPEN_FILE_TTU") == false) goto L93;
        d(r112, null, null);
        Serializable r117 = r111.c(false).get("block_type");
        if ((r117 instanceof String) == true) goto L84;
    L86:
        boolean r118 = false;
    L87:
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r110, r111, r112, r118, 8);
        this.f547618f = true;
        if (this.f547620h == true) goto L90;
        d(r112, "SDK_COST", this.f547621i);
    L90:
        int r119 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
        Long r120 = com.bytedance.ee.bear.bitable.statistic.common.e.a(this.f215609a, "OPEN_FILE_START", "OPEN_FILE_TTU");
        if (r120 == null) goto L93;
        a("open_file_ttu", Long.valueOf(r120.longValue()));
        goto L93
    L84:
        if (Intrinsics.areEqual(r117, "DASHBOARD") == false) goto L86;
        r118 = true;
        goto L87
    }
}
