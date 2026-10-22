package com.bytedance.locallife.biz.btm;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.locallife.biz.btm.bcm.BcmNode;
import com.bytedance.locallife.biz.btm.bcm.BcmStandTrackModel;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.common.utils.d;
import com.bytedance.locallife.common.utils.j;
import com.bytedance.locallife.live.goodsshelves.ui.GoodsShelvesDialogFragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class c {
    public static final Map<String, Object> f(Object r100, String r101) {
        if ((r100 instanceof View) == false) goto L5;
        r100 = a.a(r101, (View) r100);
    L5:
        vs6.a r102 = HostServiceUtilsKt.p();
        if (r101 != null) goto L8;
        String r103 = "c0.d0";
    L9:
        Map<String, Object> r104 = r102.o(r100, r103);
        if (r104.isEmpty() == false) goto L17;
        Map<String, Object> r105 = MapsKt.emptyMap();
        Object r106 = r102.b();
        if (r106 == null) goto L18;
        if (r101 != null) goto L16;
        r101 = "c0.d0";
    L16:
        return r102.o(r106, r101);
    L18:
        return r105;
    L17:
        return r104;
    L8:
        r103 = r101;
        goto L9
    }

    public static final Map<String, Object> g(Object r100, String r101) {
        if (r101 != null) goto L4;
    L6:
        vs6.b r102 = HostServiceUtilsKt.p().l(r100);
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("btm", r102.f557056b), TuplesKt.to("btm_show_id", r102.f557055a)});
    L4:
        if ((r100 instanceof View) == false) goto L6;
        r100 = a.a(r101, (View) r100);
        goto L6
    }

    public static String b(Activity r100, String r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "sourceBtm");
        return e(r100, r101, r102, null, true, null);
    }

    public static String d(GoodsShelvesDialogFragment r100, String r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "sourceBtm");
        return e(r100, r101, r102, null, true, null);
    }

    public static final Map<String, String> h(Object r100, String r101, String r102) {
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r102 != null) goto L10;
        Map<String, Object> r103 = g(r100, null);
        if (r103 == null) goto L9;
        Object r104 = r103.get("btm");
    L12:
        if ((r104 instanceof String) == false) goto L14;
        String r105 = (String) r104;
    L15:
        if (r105 != null) goto L64;
        return null;
    L64:
        BcmStandTrackModel r106 = (BcmStandTrackModel) d.a(r101, BcmStandTrackModel.class);     // Catch: Exception -> L19
    L20:
        LinkedHashMap r107 = new LinkedHashMap();
        if (r106 == null) goto L30;
        List<BcmNode> r108 = r106.getBcmParam();
        if (r108 == null) goto L30;
        Iterator<T> r109 = r108.iterator();
    L26:
        if (r109.hasNext() == false) goto L30;
        BcmNode r110 = (BcmNode) r109.next();
        if (r110.getBtm() == null) goto L26;
        r107.put(r110.getBtm(), r110);
    L30:
        if (r102 == null) goto L33;
        r105 = r102;
    L33:
        BcmNode r111 = (BcmNode) r107.get(r105);
        boolean r112 = true;
        if (r102 == null) goto L44;
        if (r111 == null) goto L41;
        Map<String, String> r113 = r111.getUnit();
        if (r113 == null) goto L41;
        if (r113.isEmpty() != true) goto L41;
        boolean r114 = true;
    L42:
        if (r114 == false) goto L44;
        return null;
    L41:
        r114 = false;
    L44:
        if (r102 != null) goto L54;
        if (r111 == null) goto L51;
        Map<String, String> r115 = r111.getPage();
        if (r115 == null) goto L51;
        if (r115.isEmpty() != true) goto L51;
    L52:
        if (r112 == false) goto L54;
        return null;
    L51:
        r112 = false;
    L54:
        LinkedHashMap r116 = new LinkedHashMap();
        if (r111 == null) goto L59;
        Map<String, String> r117 = r111.getPage();
        if (r117 == null) goto L59;
        r116.putAll(r117);
    L59:
        if (r111 == null) goto L63;
        Map<String, String> r118 = r111.getUnit();
        if (r118 == null) goto L63;
        r116.putAll(r118);
    L63:
        return r116;
    L19:
        r106 = null;
        goto L20
    L14:
        r105 = null;
        goto L15
    L9:
        r104 = null;
        goto L12
    L10:
        r104 = r102;
        goto L12
    }

    public static final boolean i(Object r100, String r101, String r102, Map<String, ? extends Object> r103) {
        if (StringsKt.endsWith$default(r101, "c0.d0", false, 2, null) == true) goto L5;
        r101 = r101 + ".c0.d0";
    L5:
        vs6.a r104 = HostServiceUtilsKt.p();
        r104.bind(r100);
        if ((r100 instanceof Activity) == false) goto L9;
        r104.registerBtmPageOnCreate((Activity) r100, r101, r102);
    L11:
        boolean r105 = true;
    L16:
        if (r105 == false) goto L18;
        j(r100, r103, null, false);
    L18:
        return r105;
    L9:
        if ((r100 instanceof Fragment) == false) goto L13;
        r104.registerBtmPageOnCreate((Fragment) r100, r101, r102);
        goto L11
    L13:
        if ((r100 instanceof View) == false) goto L15;
        r105 = r104.registerBtmPage((View) r100, r101, r102);
        goto L16
    L15:
        r105 = false;
        goto L16
    }

    public static final void j(Object r100, Map<String, ? extends Object> r101, String r102, boolean r103) {
        Map<String, String> r104 = h(r100, r102, null);
        vs6.a r105 = HostServiceUtilsKt.p();
        r105.g();
        LinkedHashMap r106 = new LinkedHashMap();
        if (r101 == null) goto L5;
        r106.putAll(r101);
    L5:
        if (r104 == null) goto L7;
        r106.putAll(r104);
    L7:
        Unit r107 = Unit.INSTANCE;
        r105.f(r100, r106, false);
    }

    public static /* synthetic */ String e(Object r100, String r101, Map r102, String r110, boolean r111, Map r112) {
        return a(r100, r101, r102, r110, false, r111, r112);
    }

    public static final String a(Object r110, final String r111, Map<String, ? extends Object> r112, String r113, boolean r210, boolean r211, Map<String, ? extends Object> r212) {
        final String r100 = "";
        if ((r110 instanceof View) == false) goto L5;
        Object r114 = a.a("", (View) r110);
    L6:
        vs6.a r115 = HostServiceUtilsKt.p();
        vs6.b r116 = r115.l(r114);
        if (zn6.a.a(r111) == false) goto L9;
        final String r101 = r111;
    L23:
        Map<String, String> r102 = h(r114, r113, r101);
        final LinkedHashMap r103 = new LinkedHashMap();
        if (r112 == null) goto L26;
        r103.putAll(r112);
    L26:
        if (r102 == null) goto L29;
        r103.putAll(r102);
    L29:
        if (r211 == true) goto L39;
        if (r102 == null) goto L39;
        String r104 = (String) ((LinkedHashMap) r102).get("life_candidate_info_array");
        if (r104 == null) goto L39;
        if (r104.length() <= 0) goto L36;
        boolean r105 = true;
    L37:
        if (r105 == false) goto L39;
        j(r110, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("life_candidate_info_array", r104)}), null, false);
        goto L39
    L36:
        r105 = false;
    L39:
        r115.v();
        if (r102 == null) goto L49;
        String r106 = (String) ((LinkedHashMap) r102).get("life_candidate_info_array");
        if (r106 == null) goto L49;
        if (r106.length() <= 0) goto L46;
        boolean r107 = true;
    L47:
        if (r107 == false) goto L49;
        j(r110, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("life_candidate_info_array", r106)}), null, false);
        goto L49
    L46:
        r107 = false;
    L49:
        if (r210 == false) goto L51;
        r115.p();
    L54:
        r115.x(r114, r103);
        Intrinsics.checkNotNullParameter(r111, "btmCD");
        Intrinsics.checkNotNullParameter(r101, "finalBtm");
        Intrinsics.checkNotNullParameter(r103, "originParams");
        rp6.b.b(0, new BtmTrackerKt$sendBuildSourceToken$1(r103, r111, r101, r100));
        return r100;
    L51:
        if (r211 == false) goto L53;
        String r108 = r116.f557055a;
        r115.c(r101);
    L53:
        r100 = r115.t(r114, r101, r103);
        goto L54
    L9:
        Intrinsics.checkNotNullParameter(r111, "<this>");
        List r109 = StringsKt.split$default(r111, new String[]{"."}, false, 0, 6, null);
        if (r109.size() == 2) goto L12;
    L16:
        boolean r117 = false;
    L17:
        if (r117 == false) goto L21;
        String r118 = r116.f557056b;
        if (j.a(r118) == false) goto L21;
        Intrinsics.checkNotNull(r118);
        r101 = StringsKt.replace$default(r118, "c0.d0", r111, false, 4, null);
    L21:
        r101 = "";
        goto L23
    L12:
        if (StringsKt.startsWith$default((String) ListProtector.get(r109, 0), "c", false, 2, null) == false) goto L16;
        if (StringsKt.startsWith$default((String) ListProtector.get(r109, 1), "d", false, 2, null) == false) goto L16;
        r117 = true;
        goto L17
    L5:
        r114 = r110;
        goto L6
    }

    public static String c(View r100, String r110, Map r111, boolean r112, boolean r113, Map r114, int r115) {
        if ((r115 & 2) == 0) goto L5;
        Map r101 = null;
    L7:
        if ((r115 & 8) == 0) goto L9;
        boolean r102 = false;
    L11:
        if ((r115 & 16) == 0) goto L13;
        boolean r103 = true;
    L15:
        if ((r115 & 32) == 0) goto L17;
        Map r104 = null;
    L18:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r110, "sourceBtm");
        return a(r100, r110, r101, null, r102, r103, r104);
    L17:
        r104 = r114;
        goto L18
    L13:
        r103 = r113;
        goto L15
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }
}
