package com.bytedance.android.livesdk.livecommerce.room.controller.related;

import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.sdk.helper.j;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class RelatedInfoManager {
    public static final Lazy e = null;
    public volatile Pair<? extends IRelatedInfoManager$FromSource, ? extends JSONObject> a;
    public volatile Map<String, JSONObject> b;
    public volatile Pair<? extends IRelatedInfoManager$FromSource, ? extends JSONObject> c;
    public volatile Map<String, JSONObject> d;

    public static final class a {
    }

    public RelatedInfoManager() {
    }

    static {
        e = LazyKt.lazy(RelatedInfoManager$Companion$DEFALUT_CONFIG$2.INSTANCE);
    }

    public static Map g(JSONArray r6) {
        HashMap r0 = null;
        if (r6 == null) goto L21;
        int r2 = 0;
        if (r6.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
        JSONArray r3 = r6;
    L11:
        if (r3 == null) goto L21;
        r0 = new HashMap(r6.length());
        int r4 = r6.length();
    L14:
        if (r2 >= r4) goto L21;
        JSONObject r5 = JSONArrayProtectorUtils.getJSONObject(r6, r2);
        String r7 = r5.optString("id");
        if (com.bytedance.android.livesdk.livecommerce.playback.main.c.a(r7) == false) goto L20;
        JSONObject r8 = r5.optJSONObject("client_config");
        if (r8 == null) goto L20;
        r0.put(r7, r8);
    L20:
        r2 = r2 + 1;
        goto L14
    L10:
        r3 = null;
        goto L11
    L7:
        r1 = false;
    L21:
        return r0;
    }

    public final boolean a(IRelatedInfoManager$FromSource r5) {
        Intrinsics.checkNotNullParameter(r5, "fromSource");
        Pair<? extends IRelatedInfoManager$FromSource, ? extends JSONObject> r0 = this.a;
        if (r0 == null) goto L5;
        IRelatedInfoManager$FromSource r1 = (IRelatedInfoManager$FromSource) r0.getFirst();
    L7:
        if (r1 == null) goto L9;
        int r2 = r1.getPriority();
    L11:
        if (r2 >= r5.getPriority()) goto L13;
    L15:
        return true;
    L13:
        if (r2 != r5.getPriority()) goto L17;
        if (r1 != r5) goto L15;
        return false;
    L17:
        return false;
    L9:
        r2 = 0;
        goto L11
    L5:
        r1 = null;
        goto L7
    }

    public final synchronized void c(boolean r12) {
        monitor-enter(this);
        dm.a.a("RelatedInfoManager").a("clear force: " + r12);     // Catch: Throwable -> L66
        Pair<? extends IRelatedInfoManager$FromSource, ? extends JSONObject> r2 = this.c;     // Catch: Throwable -> L66
        this.c = null;     // Catch: Throwable -> L66
        if (r12 == false) goto L9;
        this.a = null;     // Catch: Throwable -> L66
        this.b = null;     // Catch: Throwable -> L66
        monitor-exit(this);
        return;
    L9:
        if (r2 == null) goto L13;
        dm.a.a("RelatedInfoManager").i("clear force: " + r12 + " tempRelatedInfo != null");     // Catch: Throwable -> L66
        monitor-exit(this);
        return;
    L13:
        Map<String, JSONObject> r1 = this.b;     // Catch: Throwable -> L66
        if (r1 != null) goto L19;
        this.a = null;     // Catch: Throwable -> L66
        dm.a.a("RelatedInfoManager").i("clear force: " + r12 + " relatedConfig == null");     // Catch: Throwable -> L66
        monitor-exit(this);
        return;
    L19:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_RELATED_INFO() == false) goto L25;
        Pair<? extends IRelatedInfoManager$FromSource, ? extends JSONObject> r0 = this.a;     // Catch: Throwable -> L66
        if (r0 == null) goto L29;
        JSONObject r3 = (JSONObject) r0.getSecond();     // Catch: Throwable -> L66
        if (r3 == null) goto L29;
        JSONObject r4 = x0.a(r3);     // Catch: Throwable -> L66
    L30:
        if (r4 != null) goto L33;
        monitor-exit(this);
        return;
    L33:
        HashSet r5 = new HashSet();     // Catch: Throwable -> L66
        HashMap r6 = (HashMap) r1;     // Catch: Throwable -> L66
        Iterator r7 = r6.entrySet().iterator();     // Catch: Throwable -> L66
    L35:
        if (r7.hasNext() == false) goto L40;
        Map.Entry r8 = (Map.Entry) r7.next();     // Catch: Throwable -> L66
        String r9 = (String) r8.getKey();     // Catch: Throwable -> L66
        JSONObject r10 = (JSONObject) r8.getValue();     // Catch: Throwable -> L66
        int r11 = r10.optInt("list_show_count", 1) - 1;     // Catch: Throwable -> L66
        dm.a.a("RelatedInfoManager").a("clear force: " + r12 + " relatedInfo id: " + r9 + " listShowCount: " + r11);     // Catch: Throwable -> L66
        if (r11 <= 0) goto L38;
        r10.put("list_show_count", r11);     // Catch: Throwable -> L66
        goto L35
    L38:
        r5.add(r9);     // Catch: Throwable -> L66
        goto L35
    L40:
        Iterator<String> r13 = r4.keys();     // Catch: Throwable -> L66
    L42:
        if (r13.hasNext() == false) goto L46;
        String r14 = r13.next();     // Catch: Throwable -> L66
        if (((JSONObject) r6.get(r14)) != null) goto L42;
        r5.add(r14);     // Catch: Throwable -> L66
        dm.a.a("RelatedInfoManager").a("clear force: " + r12 + " relatedInfo id: " + r14 + " not config");     // Catch: Throwable -> L66
        goto L42
    L46:
        Iterator<T> r15 = EComABUtils.getRelatedInfoCommonKey().iterator();     // Catch: Throwable -> L66
    L48:
        if (r15.hasNext() == false) goto L50;
        r5.remove((String) r15.next());     // Catch: Throwable -> L66
        goto L48
    L50:
        Iterator r16 = r5.iterator();     // Catch: Throwable -> L66
    L52:
        if (r16.hasNext() == false) goto L55;
        String r17 = (String) r16.next();     // Catch: Throwable -> L66
        r4.remove(r17);     // Catch: Throwable -> L66
        r6.remove(r17);     // Catch: Throwable -> L66
        goto L52
    L55:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_RELATED_INFO() == false) goto L61;
        Pair<? extends IRelatedInfoManager$FromSource, ? extends JSONObject> r18 = this.a;     // Catch: Throwable -> L66
        if (r18 == null) goto L59;
        Pair<? extends IRelatedInfoManager$FromSource, ? extends JSONObject> r19 = Pair.copy$default(r18, null, r4, 1, null);     // Catch: Throwable -> L66
    L60:
        this.a = r19;     // Catch: Throwable -> L66
        goto L61
    L59:
        r19 = null;
    L61:
        dm.a.a("RelatedInfoManager").a("clear force: " + r12 + " removeId: " + r5);     // Catch: Throwable -> L66
        if (r4.length() > 0) goto L64;
        dm.a.a("RelatedInfoManager").i("clear force: " + r12 + " relatedInfo is empty");     // Catch: Throwable -> L66
        this.a = null;     // Catch: Throwable -> L66
        this.b = null;     // Catch: Throwable -> L66
    L64:
        monitor-exit(this);
        return;
    L29:
        r4 = null;
        goto L30
    L25:
        Pair<? extends IRelatedInfoManager$FromSource, ? extends JSONObject> r20 = this.a;     // Catch: Throwable -> L66
        if (r20 == null) goto L29;
        r4 = (JSONObject) r20.getSecond();     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        throw th;
    }

    public final JSONObject d(IRelatedInfoManager$Scene r7) {
        Intrinsics.checkNotNullParameter(r7, "scene");
        dm.a.a("RelatedInfoManager").a("getRelatedInfoJson scene:" + r7.getValue());
        String r4 = "";
        if (r7 == IRelatedInfoManager$Scene.PROMOTION_LIST) goto L5;
    L20:
        Pair<? extends IRelatedInfoManager$FromSource, ? extends JSONObject> r0 = this.a;
        if (r0 == null) goto L23;
        JSONObject r1 = (JSONObject) r0.getSecond();
    L24:
        JSONObject r2 = e(r7, r1, this.b);
        if (r2 == null) goto L30;
        String r3 = r2.toString();
        if (r3 == null) goto L30;
        r4 = r3;
    L30:
        h(r4, r7, false);
        if (b(r2, r7) == true) goto L33;
        return null;
    L33:
        return r2;
    L23:
        r1 = null;
        goto L24
    L5:
        if (this.c == null) goto L20;
        dm.a.a("RelatedInfoManager").i("getRelatedInfoJson scene:" + r7.getValue() + " return tempRelatedInfo: " + this.c);
        Pair<? extends IRelatedInfoManager$FromSource, ? extends JSONObject> r5 = this.c;
        if (r5 == null) goto L9;
        JSONObject r6 = (JSONObject) r5.getSecond();
    L10:
        JSONObject r8 = e(r7, r6, this.d);
        if (r8 == null) goto L16;
        String r9 = r8.toString();
        if (r9 == null) goto L16;
        r4 = r9;
    L16:
        h(r4, r7, false);
        if (b(r8, r7) == true) goto L19;
        return null;
    L19:
        return r8;
    L9:
        r6 = null;
        goto L10
    }

    public final String f(IRelatedInfoManager$Scene r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        JSONObject r3 = d(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.toString();
    }

    public static boolean b(JSONObject r6, IRelatedInfoManager$Scene r7) {
        ECLiveABUtils r0 = ECLiveABUtils.INSTANCE;
        int r1 = r0.getEC_LIVE_RELATED_INFO_MAX_LENGTH();
        dm.a.a("RelatedInfoManager").i("relatedInfoLegalMaxLength is " + r1);
        if (r1 > 0) goto L6;
        return true;
    L6:
        if (r6 == null) goto L10;
        String r4 = r6.toString();
        if (r4 == null) goto L10;
        int r5 = r4.length();
    L11:
        if (r5 <= r1) goto L25;
        Pair[] r2 = new Pair[4];
        r2[0] = TuplesKt.to("related_info", String.valueOf(r6));
        r2[1] = TuplesKt.to("related_info_max_length", String.valueOf(r0.getEC_LIVE_RELATED_INFO_MAX_LENGTH()));
        if (r6 == null) goto L17;
        String r3 = r6.toString();
        if (r3 == null) goto L17;
        int r8 = r3.length();
    L18:
        r2[2] = TuplesKt.to("related_info_length", String.valueOf(r8));
        r2[3] = TuplesKt.to("scene", r7.getValue());
        Map r9 = MapsKt.mapOf(r2);
        int r10 = j.a;
        j.b("ec_live_related_info", r9.toString());
        if (r6 == null) goto L22;
        String r11 = r6.toString();
        if (r11 == null) goto L22;
    L23:
        h(r11, r7, true);
        return false;
    L22:
        r11 = "";
    L17:
        r8 = 0;
        goto L18
    L25:
        return true;
    L10:
        r5 = 0;
        goto L11
    }

    public final synchronized void i(String r6, IRelatedInfoManager$FromSource r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, "relatedInfo");     // Catch: Throwable -> L33
        Intrinsics.checkNotNullParameter(r7, "fromSource");     // Catch: Throwable -> L33
        dm.a.a("RelatedInfoManager").a("updateRelatedInfo relatedInfo: " + r6 + " fromSource: " + r7.name());     // Catch: Throwable -> L33
        JSONObject r8 = com.bytedance.android.livesdk.livecommerce.playback.main.c.c(r6);     // Catch: Throwable -> L33
        if (r8 == null) goto L31;
        IRelatedInfoManager$FromSource r3 = null;
        if (r7 != IRelatedInfoManager$FromSource.ENTER_ROOM_API) goto L13;
        Pair<? extends IRelatedInfoManager$FromSource, ? extends JSONObject> r2 = this.a;     // Catch: Throwable -> L33
        if (r2 == null) goto L11;
        JSONObject r4 = (JSONObject) r2.getSecond();     // Catch: Throwable -> L33
    L12:
        b.a(r8, r4, false);     // Catch: Throwable -> L33
        goto L13
    L11:
        r4 = null;
    L13:
        int r5 = com.bytedance.android.livesdk.livecommerce.room.controller.related.a.a[r7.ordinal()];     // Catch: Throwable -> L33
        if (r5 != 1) goto L16;
    L24:
        Pair<? extends IRelatedInfoManager$FromSource, ? extends JSONObject> r0 = this.c;     // Catch: Throwable -> L33
        if (r0 == null) goto L27;
        r3 = (IRelatedInfoManager$FromSource) r0.getFirst();     // Catch: Throwable -> L33
    L27:
        if (r3 != null) goto L29;
    L30:
        this.d = g(r8.optJSONArray("related_config"));     // Catch: Throwable -> L33
        this.c = TuplesKt.to(r7, r8);     // Catch: Throwable -> L33
        dm.a.a("RelatedInfoManager").i("updateRelatedInfo save tempRelatedInfo: " + r8);     // Catch: Throwable -> L33
        goto L31
    L29:
        if (r7.getPriority() < r3.getPriority()) goto L31;
    L16:
        if (r5 == 2) goto L24;
        Pair<? extends IRelatedInfoManager$FromSource, ? extends JSONObject> r1 = this.a;     // Catch: Throwable -> L33
        if (r1 == null) goto L20;
        r3 = (IRelatedInfoManager$FromSource) r1.getFirst();     // Catch: Throwable -> L33
    L20:
        if (r3 != null) goto L22;
    L23:
        this.b = g(r8.optJSONArray("related_config"));     // Catch: Throwable -> L33
        this.a = TuplesKt.to(r7, r8);     // Catch: Throwable -> L33
        dm.a.a("RelatedInfoManager").i("updateRelatedInfo save relatedInfo: " + r8 + " fromSource: " + r7.name() + " relatedInfoConfig: " + this.b);     // Catch: Throwable -> L33
        goto L31
    L22:
        if (r7.getPriority() >= r3.getPriority()) goto L23;
    L31:
        monitor-exit(this);
        return;
    L33:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.util.ArrayList] */
    public static JSONObject e(IRelatedInfoManager$Scene r12, JSONObject r13, Map r14) {
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_ENTER_ROOM_RELATED_MATCH() == false) goto L5;
    L7:
        boolean r0 = true;
        if (r14 == null) goto L10;
        if (r13 != null) goto L16;
        return null;
    L16:
        JSONObject r4 = new JSONObject();
        dm.a.a("RelatedInfoManager").i("getRelatedInfoJson scene:" + r12.getValue() + " relatedConfig: " + r14);
        Iterator<String> r5 = r13.keys();
    L17:
        int r7 = 0;
        if (r5.hasNext() == false) goto L38;
        String r6 = r5.next();
        JSONObject r8 = (JSONObject) ((HashMap) r14).get(r6);
        if (r8 != null) goto L22;
        r8 = (JSONObject) e.getValue();
    L22:
        JSONArray r9 = r8.optJSONArray(LocationMonitorConst.TYPE);
        if (r9 == null) goto L27;
        Intrinsics.checkNotNullParameter(r9, "$this$toArrayList");
        ?? r10 = new ArrayList();
        int r11 = r9.length();
    L25:
        if (r7 >= r11) goto L28;
        r10.add(JSONArrayProtectorUtils.getString(r9, r7));
        r7 = r7 + 1;
    L28:
        Iterator r15 = ((Iterable) r10).iterator();
    L30:
        if (r15.hasNext() == false) goto L34;
        Object r16 = r15.next();
        if (Intrinsics.areEqual((String) r16, r12.getValue()) == false) goto L30;
    L35:
        if (r16 == null) goto L17;
        r4.put(r6, r13.optString(r6));
        goto L17
    L34:
        r16 = null;
        goto L35
    L27:
        r10 = CollectionsKt.emptyList();
        goto L28
    L38:
        if (r4.length() != 0) goto L41;
        dm.a.a("RelatedInfoManager").a("getRelatedInfoJson scene:" + r12.getValue() + " result is empty");
        return null;
    L41:
        List<String> r17 = EComABUtils.getRelatedInfoCommonKey();
        dm.a.a("RelatedInfoManager").a("getRelatedInfoJson scene:" + r12.getValue() + " relatedInfoCommonKey: " + r17);
        Iterator r18 = r17.iterator();
    L43:
        if (r18.hasNext() == false) goto L47;
        String r19 = (String) r18.next();
        Object r20 = r13.opt(r19);
        if (r20 == null) goto L43;
        r4.put(r19, r20);
        goto L43
    L47:
        dm.a.a("RelatedInfoManager").i("getRelatedInfoJson scene:" + r12.getValue() + " result: " + r4);
        if (r4.length() > 0) goto L51;
        r0 = false;
    L51:
        if (r0 == true) goto L53;
        return null;
    L53:
        return r4;
    L10:
        if (com.bytedance.android.livesdk.livecommerce.room.controller.related.a.b[r12.ordinal()] == 1) goto L12;
        r13 = null;
    L12:
        dm.a.a("RelatedInfoManager").i("getRelatedInfoJson scene:" + r12.getValue() + " return relatedInfo: " + String.valueOf(r13));
        return r13;
    L5:
        if (r12 != IRelatedInfoManager$Scene.ENTER_ROOM_API) goto L7;
        return r13;
    }

    public static void h(String r5, IRelatedInfoManager$Scene r6, boolean r7) {
        int r0 = com.bytedance.android.livesdk.livecommerce.room.controller.related.a.c[r6.ordinal()];
        if (r0 == 1) goto L9;
        if (r0 == 2) goto L9;
        if (r0 == 3) goto L9;
        if (r7 == false) goto L8;
        Action r8 = Action.ENTER_FROM_RELATED_INFO_FAIL;
    L12:
        int r1 = zg2.a.a;
        zg2.a.a(null, null, r8, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("related_info", r5), TuplesKt.to("related_info_length", String.valueOf(r5.length())), TuplesKt.to("related_info_scene", r6.getValue())}));
        return;
    L8:
        r8 = Action.ENTER_FROM_RELATED_INFO;
    L9:
        if (r7 == false) goto L11;
        r8 = Action.GOODS_CARD_RELATED_INFO_FAIL;
        goto L12
    L11:
        r8 = Action.GOODS_CARD_RELATED_INFO;
        goto L12
    }
}
