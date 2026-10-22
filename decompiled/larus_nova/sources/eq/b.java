package eq;

import android.text.TextUtils;
import android.util.Log;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.ec.sdk.helper.g;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b {
    public b() {
    }

    static {
    }

    public static Pair a(Map r110) {
        Intrinsics.checkNotNullParameter(r110, "action");
        ArrayList r100 = new ArrayList();
        Object r101 = null;
        if (Intrinsics.areEqual(r110.get("type"), "Group") == false) goto L30;
        StringBuilder r102 = new StringBuilder("");
        Object r111 = r110.get(SlcCommonAction.KEY_ACTIONS);
        if ((r111 instanceof List) == false) goto L8;
        r101 = r111;
    L8:
        List r103 = (List) r101;
        if (r103 == null) goto L12;
        List r112 = CollectionsKt.filterNotNull(r103);
        if (r112 == null) goto L12;
    L13:
        Iterator r113 = r112.iterator();
    L15:
        if (r113.hasNext() == false) goto L92;
        Object r104 = r113.next();
        if ((r104 instanceof Map) == true) goto L18;
        if ((r104 instanceof IAction) == true) goto L24;
        b("", r104);
        goto L15
    L24:
        b("", r104);
        IAction r105 = (IAction) r104;
        Map r106 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", r105.getType()), TuplesKt.to(SlcCommonAction.KEY_PARAMS, r105.getParams())});
    L26:
        if (r106.isEmpty() == true) goto L15;
        Pair r107 = a(r106);
        List r108 = (List) r107.component1();
        String r109 = (String) r107.component2();
        r100.addAll(r108);
        r102.append(r109);
        goto L15
    L18:
        if (r104 == null) goto L21;
        r106 = (Map) r104;
        goto L26
    L21:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
    L92:
        return new Pair(r100, "" + r102);
    L12:
        r112 = CollectionsKt.emptyList();
        goto L13
    L30:
        Object r114 = r110.get(SlcCommonAction.KEY_PARAMS);
        if ((r114 instanceof Map) == true) goto L33;
        r114 = null;
    L33:
        Map r115 = (Map) r114;
        if (r115 != null) goto L36;
        r115 = MapsKt.emptyMap();
    L36:
        Object r116 = r110.get("type");
        if ((r116 instanceof String) == true) goto L39;
        r116 = null;
    L39:
        String r117 = (String) r116;
        if (r117 != null) goto L42;
        r117 = "";
    L42:
        String r118 = "" + r117 + '_';
        Object r119 = r110.get(TeaEventTrack.ACTION_DRAMA_NEXT);
        if ((r119 instanceof Map) == true) goto L45;
        r119 = null;
    L45:
        Map r120 = (Map) r119;
        if (r120 != null) goto L48;
        r120 = MapsKt.emptyMap();
    L48:
        LinkedHashMap r121 = new LinkedHashMap();
        if (r120.containsKey("success") == false) goto L60;
        Object r122 = r120.get("success");
        if ((r122 instanceof Map) == true) goto L53;
        r122 = null;
    L53:
        Map r123 = (Map) r122;
        if (r123 != null) goto L57;
        r123 = MapsKt.emptyMap();
    L57:
        if ((!r123.isEmpty()) == false) goto L60;
        Pair r124 = a(r123);
        List r125 = (List) r124.component1();
        String r126 = (String) r124.component2();
        r121.put("success", r125);
        r118 = r118 + r126;
    L60:
        if (r120.containsKey("failed") == false) goto L70;
        Object r127 = r120.get("failed");
        if ((r127 instanceof Map) == true) goto L64;
        r127 = null;
    L64:
        Map r128 = (Map) r127;
        if (r128 != null) goto L68;
        r128 = MapsKt.emptyMap();
    L68:
        if ((!r128.isEmpty()) == false) goto L70;
        Pair r129 = a(r128);
        List r130 = (List) r129.component1();
        String r131 = (String) r129.component2();
        r121.put("failed", r130);
        r118 = r118 + r131;
    L70:
        Set r132 = CollectionsKt.toMutableSet(r120.keySet());
        r132.remove("success");
        r132.remove("failed");
        if ((true ^ r132.isEmpty()) == false) goto L78;
        JSONObject r133 = new JSONObject();
        Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L75
        r133.put("chain_name", r118);     // Catch: Throwable -> L75
        r133.put(TeaEventTrack.ACTION_DRAMA_NEXT, TextUtils.join(",", r132));     // Catch: Throwable -> L75
        Result.m9449constructorimpl(r133.put("stack", Log.getStackTraceString(new Throwable())));     // Catch: Throwable -> L75
    L77:
        g.f48122a.logV3("pdp_event_chain_next_error", r133);
    L75:
        th = move-exception;
        Result.Companion r135 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L78:
        r100.add(new a(r117, r115, null, r121));
        return new Pair(r100, r118);
    }

    public static void b(String r100, Object r101) {
        if (r101 == null) goto L4;
        String r102 = r101.getClass().getName();
    L5:
        JSONObject r103 = new JSONObject();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
        r103.put("chain_name", r100);     // Catch: Throwable -> L8
        Result.m9449constructorimpl(r103.put("unknown_sub_action_type", r102));     // Catch: Throwable -> L8
    L10:
        g.f48122a.logV3("pdp_event_chain_cover_unknown_error", r103);
        return;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L4:
        r102 = "null";
        goto L5
    }
}
