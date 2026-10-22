package gz1;

import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import vh7.f;

/* JADX INFO: loaded from: classes9.dex */
public final class c {
    public static /* synthetic */ String b(ArrayList r100) {
        return a(r100, 0);
    }

    public static final ArrayList<e3> d(JSONArray r100) {
    L6:
        e = move-exception;
        jy0.b.c(e3.TAG, "convertJsonToArray： " + e.getMessage(), null, 4);
        return new ArrayList();
    L3:
        if (r100.length() == 0) goto L5;
        ArrayList<e3> r101 = new ArrayList();     // Catch: Exception -> L6
        int r102 = r100.length();     // Catch: Exception -> L6
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L15;
        e3 r104 = (e3) f.c(e3.class);     // Catch: Exception -> L6
        Object r105 = r100.get(r103);     // Catch: Exception -> L6
        if (r105 == null) goto L14;
        c(r104, (JSONObject) r105);     // Catch: Exception -> L6
        r101.add(r104);     // Catch: Exception -> L6
        r103 = r103 + 1;     // Catch: Exception -> L6
        goto L9
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.revenue.platform.api.core.JSONObject /* = org.json.JSONObject */");     // Catch: Exception -> L6
    L15:
        return r101;
    L5:
        return new ArrayList();
    }

    public static final JSONObject e(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$convertToJSON");
        JSONObject r101 = new JSONObject();
        r101.put("plugin_id", r100.getPluginId());
        JSONObject r102 = new JSONObject();
        Map<String, String> r103 = r100.getItemPotentialValueHint();
        if (r103 != null) goto L5;
    L19:
        r101.put(e3.KEY_ITEM_POTENTIAL_VALUE_HINT, r102);
        return r101;
    L5:
        if ((!r103.isEmpty()) != true) goto L19;
        Map<String, String> r104 = r100.getItemPotentialValueHint();
        if (r104 == null) goto L19;
        Set<String> r105 = r104.keySet();
        if (r105 == null) goto L19;
        Iterator<T> r106 = r105.iterator();
    L12:
        if (r106.hasNext() == false) goto L19;
        String r107 = (String) r106.next();
        Map<String, String> r108 = r100.getItemPotentialValueHint();
        if (r108 == null) goto L17;
        String r109 = r108.get(r107);
        if (r109 == null) goto L17;
    L18:
        r102.put(r107, r109);
    L17:
        r109 = "";
        goto L18
    }

    public static final ArrayList<e3> g(n r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$plugins");
        return new ArrayList(CollectionsKt.toList(r100.getPluginsFlex()));
    }

    public static final String a(ArrayList<e3> r100, int r101) {
        if (r101 != 0) goto L4;
        ArrayList r102 = new ArrayList();
        if (r100 == null) goto L22;
        Iterator<T> r103 = r100.iterator();
    L19:
        if (r103.hasNext() == false) goto L22;
        r102.add(e((e3) r103.next()).toString());
    L22:
        return r102.toString();
    L4:
        if (r101 == 1) goto L7;
        return "";
    L7:
        JSONArray r104 = new JSONArray();
        if (r100 == null) goto L14;
        Iterator<T> r105 = r100.iterator();
    L11:
        if (r105.hasNext() == false) goto L14;
        r104.put(e((e3) r105.next()));
    L14:
        return r104.toString();
    }

    public static final void c(e3 r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$convertFromJSON");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        r100.setPluginId(JSONObjectProtectorUtils.getInt(r101, "plugin_id"));     // Catch: Exception -> L17
        LinkedHashMap r102 = new LinkedHashMap();     // Catch: Exception -> L17
        JSONObject r103 = JSONObjectProtectorUtils.getJSONObject(r101, e3.KEY_ITEM_POTENTIAL_VALUE_HINT);     // Catch: Exception -> L17
        if (r103 == null) goto L15;
        Iterator<String> r104 = r103.keys();     // Catch: Exception -> L17
        if (r104 == null) goto L15;
    L8:
        if (r104.hasNext() == false) goto L15;
        String r105 = r104.next();     // Catch: Exception -> L17
        Object r106 = r103.get(r105);     // Catch: Exception -> L17
        if (r106 == null) goto L13;
        String r107 = r106.toString();     // Catch: Exception -> L17
        if (r107 == null) goto L13;
    L14:
        r102.put(r105, r107);     // Catch: Exception -> L17
    L13:
        r107 = "";
    L15:
        r100.setItemPotentialValueHint(r102);     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        jy0.b.c(e3.TAG, "convertFromJSON： " + e.getMessage(), null, 4);
    }

    public static final boolean h(ArrayList<e3> r110, ArrayList<e3> r111) {
        if (r110 == null) goto L5;
        Integer r100 = Integer.valueOf(r110.size());
    L6:
        if (r111 == null) goto L8;
        Integer r101 = Integer.valueOf(r111.size());
    L10:
        if ((!Intrinsics.areEqual(r100, r101)) == true) goto L77;
        if (r110 != null) goto L13;
    L15:
        if (r111 == null) goto L17;
        int r102 = r111.size();
    L18:
        if (r110 == null) goto L76;
        Iterator<T> r112 = r110.iterator();
    L21:
        if (r112.hasNext() == false) goto L76;
        e3 r103 = (e3) r112.next();
        int r104 = 0;
    L23:
        if (r104 >= r102) goto L73;
        if (r111 == null) goto L26;
        e3 r105 = (e3) ListProtector.get(r111, r104);
    L27:
        Intrinsics.checkNotNullParameter(r103, "$this$isSame");
        if (r105 != null) goto L31;
    L29:
        boolean r106 = false;
    L70:
        if (r106 == true) goto L71;
        r104 = r104 + 1;
        goto L23
    L71:
        boolean r107 = true;
    L74:
        if (r107 == true) goto L21;
        return false;
    L31:
        if (r105.getPluginId() != r103.getPluginId()) goto L29;
        Map<String, String> r108 = r105.getItemPotentialValueHint();
        if (r108 == null) goto L35;
        Integer r109 = Integer.valueOf(r108.size());
    L36:
        Map<String, String> r113 = r103.getItemPotentialValueHint();
        if (r113 == null) goto L39;
        Integer r114 = Integer.valueOf(r113.size());
    L41:
        if (Intrinsics.areEqual(r109, r114) == false) goto L29;
        Map<String, String> r115 = r105.getItemPotentialValueHint();
        if (r115 == null) goto L45;
        Set<String> r116 = r115.keySet();
    L46:
        Map<String, String> r117 = r103.getItemPotentialValueHint();
        if (r117 == null) goto L49;
        Set<String> r118 = r117.keySet();
    L50:
        if (r116 == null) goto L69;
        Iterator<T> r119 = r116.iterator();
        r106 = true;
    L53:
        if (r119.hasNext() == false) goto L70;
        String r120 = (String) r119.next();
        if (r118 == null) goto L68;
        if (r118.contains(r120) != true) goto L68;
        Map<String, String> r121 = r105.getItemPotentialValueHint();
        if (r121 == null) goto L68;
        String r122 = r121.get(r120);
        if (r122 == null) goto L68;
        Map<String, String> r123 = r103.getItemPotentialValueHint();
        if (r123 == null) goto L65;
        String r124 = r123.get(r120);
    L67:
        if (r122.equals(r124) == true) goto L53;
    L65:
        r124 = null;
    L68:
        r106 = false;
        goto L53
    L69:
        r106 = true;
        goto L70
    L49:
        r118 = null;
        goto L50
    L45:
        r116 = null;
        goto L46
    L39:
        r114 = null;
        goto L41
    L35:
        r109 = null;
        goto L36
    L26:
        r105 = null;
        goto L27
    L73:
        r107 = false;
    L76:
        return true;
    L17:
        r102 = 0;
        goto L18
    L13:
        if (r110.size() != 0) goto L15;
    L77:
        return false;
    L8:
        r101 = null;
        goto L10
    L5:
        r100 = null;
        goto L6
    }

    public static final String f(ArrayList<e3> r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "cardName");
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<e3> r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(String.valueOf(r104.next().getPluginId()));
        goto L4
    L6:
        Set r105 = CollectionsKt.toMutableSet(r103);
        r105.add(r101);
        if (r102 == null) goto L10;
        r105.add(r102);
    L10:
        return String.valueOf(r105.hashCode());
    }
}
