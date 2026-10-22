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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a extends com.bytedance.ee.bear.bitable.statistic.common.a {
    public boolean f;
    public boolean g;
    public boolean h;
    public final HashMap<String, Serializable> i;

    /* JADX INFO: renamed from: tu4.a$a, reason: collision with other inner class name */
    public static final class C0297a {
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
        this.i = new HashMap();
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final void p() {
        super.p();
        this.i.clear();
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final List<BitableStatisticEventModel$NormalPointModel> c(com.bytedance.ee.bear.bitable.statistic.e r2, BitableStatisticEventModel$NormalPointModel r3, List<BitableStatisticEventModel$NormalPointModel> r4) {
        Intrinsics.checkNotNullParameter(r2, "trace");
        Intrinsics.checkNotNullParameter(r3, "currPoint");
        Intrinsics.checkNotNullParameter(r4, "allPoints");
        int r5 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
        tt5.a.h("BitableStatistic", "OpenFileConsumer " + ("OpenFile consumeTempPoint " + r3.getName()));
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public boolean k(i r16, com.bytedance.ee.bear.bitable.statistic.e r17, BitableStatisticEventModel$NormalPointModel r18, List<BitableStatisticEventModel$NormalPointModel> r19) {
        Intrinsics.checkNotNullParameter(r16, "logger");
        Intrinsics.checkNotNullParameter(r17, "trace");
        Intrinsics.checkNotNullParameter(r18, "currPoint");
        Intrinsics.checkNotNullParameter(r19, "allPoints");
        String r0 = r18.getName();
        if (Intrinsics.areEqual(r0, "OPEN_FILE_START") == false) goto L7;
        d(r18, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.o(this, r16, r17, r18);
        return false;
    L7:
        if (Intrinsics.areEqual(r0, "OPEN_FILE_BRIDGE_IS_READY") == false) goto L9;
    L94:
        d(r18, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r16, r17, r18, false, 24);
        return false;
    L9:
        if (Intrinsics.areEqual(r0, "OPEN_FILE_CREATE_UI_START") == true) goto L94;
        if (Intrinsics.areEqual(r0, "OPEN_FILE_CREATE_UI_END") == true) goto L94;
        if (Intrinsics.areEqual(r0, "OPEN_FILE_TEMPLATE_PRELOAD_START") == true) goto L94;
        if (Intrinsics.areEqual(r0, "OPEN_FILE_TEMPLATE_PRELOAD_END") == true) goto L94;
        if (Intrinsics.areEqual(r0, "OPEN_FILE_START_RENDER") == true) goto L94;
        if (Intrinsics.areEqual(r0, "OPEN_FILE_END_RENDER") == true) goto L94;
        if (Intrinsics.areEqual(r0, "OPEN_FILE_AFTER_CLIENTVARS_LOADED_AND_SWITCH") == true) goto L94;
        if (Intrinsics.areEqual(r0, "BITABLE_NATIVE_VIEW_RENDER_START") == true) goto L94;
        if (Intrinsics.areEqual(r0, "BITABLE_NATIVE_VIEW_RECEIVE_DATA") == true) goto L94;
        if (Intrinsics.areEqual(r0, "OPEN_FILE_OLD_RENDER_SUCCESS") == true) goto L94;
        if (Intrinsics.areEqual(r0, "POINT_MID_STAGE_COST") == false) goto L39;
        HashMap<String, Serializable> r1 = r18.getExtras();
        if (r1 == null) goto L37;
        Iterator<Map.Entry<String, Serializable>> r2 = r1.entrySet().iterator();
    L35:
        if (r2.hasNext() == false) goto L37;
        Map.Entry<String, Serializable> r3 = r2.next();
        d(r18, r3.getKey(), r3.getValue());
    L37:
        return false;
    L39:
        if (Intrinsics.areEqual(r0, "POINT_SDK_LOAD_COST") == false) goto L46;
        this.h = true;
        HashMap<String, Serializable> r4 = r18.getExtras();
        if (r4 == null) goto L43;
        r4.putAll(this.i);
    L43:
        d(r18, "SDK_COST", r18.getExtras());
        a("is_from_native_pull", Boolean.FALSE);
        return false;
    L46:
        if (Intrinsics.areEqual(r0, "POINT_NATIVE_LOAD_COST") == false) goto L52;
        HashMap<String, Serializable> r5 = r18.getExtras();
        if (r5 == null) goto L50;
        this.i.putAll(r5);
    L50:
        return false;
    L52:
        if (Intrinsics.areEqual(r0, "POINT_ADD_END_STAGE_EXTRA") == false) goto L61;
        HashMap<String, Serializable> r6 = r18.getExtras();
        if (r6 == null) goto L59;
        Iterator<Map.Entry<String, Serializable>> r7 = r6.entrySet().iterator();
    L57:
        if (r7.hasNext() == false) goto L59;
        Map.Entry<String, Serializable> r8 = r7.next();
        a(r8.getKey(), r8.getValue());
    L59:
        return false;
    L61:
        if (Intrinsics.areEqual(r0, "OPEN_FILE_CANCEL") == false) goto L65;
        d(r18, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r16, r17, r18, BitableStatisticConstant$Result.CANCEL, "cancel", null, 96);
        return true;
    L65:
        if (Intrinsics.areEqual(r0, "OPEN_FILE_FAIL") == false) goto L69;
        d(r18, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r16, r17, r18, BitableStatisticConstant$Result.FAIL, null, null, 112);
        return true;
    L69:
        if (Intrinsics.areEqual(r0, "OPEN_FILE_TTV") == false) goto L80;
        if (this.g == false) goto L73;
        return false;
    L73:
        this.g = true;
        d(r18, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r16, r17, r18, false, 24);
        if (this.f == false) goto L76;
        long r9 = r18.getTimestamp();
        Intrinsics.checkNotNullParameter("OPEN_FILE_TTU", "stageName");
        Long r10 = Long.valueOf(r9);
        this.a.put("OPEN_FILE_TTU", r10);
    L76:
        int r11 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
        Long r12 = com.bytedance.ee.bear.bitable.statistic.common.e.a(this.a, "OPEN_FILE_START", "OPEN_FILE_TTV");
        if (r12 == null) goto L93;
        a("open_file_ttv", Long.valueOf(r12.longValue()));
    L93:
        return false;
    L80:
        if (Intrinsics.areEqual(r0, "OPEN_FILE_TTU") == false) goto L93;
        d(r18, null, null);
        Serializable r13 = r17.c(false).get("block_type");
        if ((r13 instanceof String) == true) goto L84;
    L86:
        boolean r14 = false;
    L87:
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r16, r17, r18, r14, 8);
        this.f = true;
        if (this.h == true) goto L90;
        d(r18, "SDK_COST", this.i);
    L90:
        int r20 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
        Long r21 = com.bytedance.ee.bear.bitable.statistic.common.e.a(this.a, "OPEN_FILE_START", "OPEN_FILE_TTU");
        if (r21 == null) goto L93;
        a("open_file_ttu", Long.valueOf(r21.longValue()));
        goto L93
    L84:
        if (Intrinsics.areEqual(r13, "DASHBOARD") == false) goto L86;
        r14 = true;
        goto L87
    }
}
