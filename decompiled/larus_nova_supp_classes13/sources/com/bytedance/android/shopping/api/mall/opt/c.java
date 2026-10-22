package com.bytedance.android.shopping.api.mall.opt;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements e93.e {
    public final Map<String, Pair<Integer, Long>> a;
    public String b;
    public final Map<String, Map<String, Object>> c;
    public final Set<ECHybridListItemVO> d;
    public Long e;
    public final ECHybridRecyclerView f;
    public final String g;

    public static final class a {
    }

    static {
    }

    @Override // e93.e
    public final void initOrRefresh(boolean r1, Integer r2) {
    }

    @Override // e93.e
    public final void onFirstScreen() {
    }

    @Override // e93.e
    public final void onPause() {
    }

    @Override // e93.e
    public final void onRefreshEnd() {
    }

    @Override // e93.e
    public final void onBackMall() {
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        ECHybridListItemVO r1 = (ECHybridListItemVO) r0.next();
        String r2 = c(r1);
        if (r2 == null) goto L4;
        if (this.a.containsKey(r2) == true) goto L4;
        Map<String, Pair<Integer, Long>> r3 = this.a;
        com.bytedance.android.ec.hybrid.list.entity.dto.a r4 = r1.D;
        if (r4 == null) goto L13;
        Integer r5 = Integer.valueOf(r4.a);
    L14:
        r3.put(r2, TuplesKt.to(r5, Long.valueOf(System.currentTimeMillis())));
        goto L4
    L13:
        r5 = null;
        goto L14
    }

    @Override // e93.e
    public final void onDestroy() {
        if (this.e != null) goto L5;
        return;
    L5:
        int r0 = a(this.d);
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator<T> r2 = this.d.iterator();
    L7:
        if (r2.hasNext() == false) goto L39;
        ECHybridListItemVO r3 = (ECHybridListItemVO) r2.next();
        String r4 = c(r3);
        if (r4 == null) goto L7;
        if (r1.contains(r4) == true) goto L7;
        ECNAMallCardExtra r5 = r3.c();
        if (r5 == null) goto L17;
        Map r6 = r5.getTrackParams();
    L18:
        com.bytedance.android.ec.hybrid.list.entity.dto.a r7 = r3.D;
        if (r7 != null) goto L21;
    L23:
        boolean r8 = false;
    L24:
        Long r9 = this.e;
        if (r9 == null) goto L38;
        r9.longValue();
        if (r6 == null) goto L38;
        JSONObject r10 = new JSONObject();
        r10.putOpt("is_screen_last", Boolean.valueOf(r8));
        r10.putOpt("destroy_time", Long.valueOf(System.currentTimeMillis()));
        r10.putOpt("background_time", this.e);
        long r11 = System.currentTimeMillis();
        Long r12 = this.e;
        if (r12 == null) goto L32;
        long r13 = r12.longValue();
    L33:
        r10.putOpt("duration", Long.valueOf(r11 - r13));
        int r14 = f93.a.a;
        f93.a.c(r10, this.g);
        Iterator r15 = r6.keySet().iterator();
    L35:
        if (r15.hasNext() == false) goto L37;
        String r16 = (String) r15.next();
        r10.putOpt(r16, r6.get(r16));
        goto L35
    L37:
        Unit r17 = Unit.INSTANCE;
        AppLogNewUtils.onEventV3("mall_req_for_destroy", r10);
        goto L38
    L32:
        r13 = 0;
    L38:
        r1.add(r4);
        goto L7
    L21:
        if (r7.a != r0) goto L23;
        r8 = true;
        goto L24
    L17:
        r6 = null;
        goto L18
    }

    @Override // e93.e
    public final void onGylRefreshStart() {
        Iterator r0 = ((LinkedHashMap) this.a).keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        String r1 = (String) r0.next();
        Pair<Integer, Long> r2 = (Pair) ((LinkedHashMap) this.a).get(r1);
        if (r2 == null) goto L4;
        Map<String, ? extends Object> r3 = (Map) ((LinkedHashMap) this.c).get(r1);
        if (r3 == null) goto L4;
        b(r3, r2);
        goto L4
    L12:
        ((LinkedHashMap) this.a).clear();
        this.d.clear();
        this.b = null;
        ((LinkedHashMap) this.c).clear();
    }

    @Override // e93.e
    public final void onLeaveMall() {
        Iterator r0 = ((LinkedHashMap) this.a).keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        String r1 = (String) r0.next();
        Pair<Integer, Long> r2 = (Pair) ((LinkedHashMap) this.a).get(r1);
        if (r2 == null) goto L4;
        Map<String, ? extends Object> r3 = (Map) ((LinkedHashMap) this.c).get(r1);
        if (r3 == null) goto L4;
        b(r3, r2);
        goto L4
    L12:
        ((LinkedHashMap) this.a).clear();
    }

    @Override // e93.e
    public final void onStartLoadFeed() {
        this.f.addOnChildAttachStateChangeListener(new MallGylReqShowMonitor$recordCurWindState$1(this));
    }

    public static int a(Set r3) {
        Iterator r4 = r3.iterator();
        int r1 = 0;
    L4:
        if (r4.hasNext() == false) goto L10;
        com.bytedance.android.ec.hybrid.list.entity.dto.a r2 = ((ECHybridListItemVO) r4.next()).D;
        if (r2 == null) goto L8;
        int r5 = r2.a;
    L9:
        r1 = Math.max(r1, r5);
        goto L4
    L8:
        r5 = 0;
        goto L9
    L10:
        return r1;
    }

    public static String c(ECHybridListItemVO r2) {
        ECNAMallCardExtra r3 = r2.c();
        Object r0 = null;
        if (r3 == null) goto L12;
        Map r4 = r3.getTrackParams();
        if (r4 == null) goto L13;
        Object r5 = r4.get("request_id");
        if ((r5 instanceof String) == false) goto L11;
        r0 = r5;
    L11:
        return (String) r0;
    L13:
        return null;
    L12:
        return null;
    }

    @Override // e93.e
    public final void onEnterBackGround(boolean r9) {
        if (r9 == true) goto L4;
        return;
    L4:
        this.e = Long.valueOf(System.currentTimeMillis());
        LinkedHashSet r10 = new LinkedHashSet();
        int r0 = a(this.d);
        Iterator<T> r1 = this.d.iterator();
    L6:
        if (r1.hasNext() == false) goto L34;
        ECHybridListItemVO r2 = (ECHybridListItemVO) r1.next();
        String r3 = c(r2);
        if (r3 == null) goto L6;
        if (r10.contains(r3) == true) goto L6;
        com.bytedance.android.ec.hybrid.list.entity.dto.a r4 = r2.D;
        int r5 = 0;
        if (r4 != null) goto L16;
    L18:
        boolean r6 = false;
    L19:
        ECNAMallCardExtra r7 = r2.c();
        if (r7 == null) goto L22;
        Map r8 = r7.getTrackParams();
    L23:
        com.bytedance.android.ec.hybrid.list.entity.dto.a r11 = r2.D;
        if (r11 == null) goto L26;
        r5 = r11.a;
    L26:
        if (r8 == null) goto L33;
        JSONObject r12 = new JSONObject();
        r12.putOpt("req_num", Integer.valueOf(r5));
        r12.putOpt("is_screen_last", Boolean.valueOf(r6));
        int r13 = f93.a.a;
        f93.a.c(r12, this.g);
        Iterator r14 = r8.keySet().iterator();
    L30:
        if (r14.hasNext() == false) goto L32;
        String r15 = (String) r14.next();
        r12.putOpt(r15, r8.get(r15));
        goto L30
    L32:
        Unit r16 = Unit.INSTANCE;
        AppLogNewUtils.onEventV3("mall_req_for_background", r12);
    L33:
        r10.add(r3);
        goto L6
    L22:
        r8 = null;
        goto L23
    L16:
        if (r4.a != r0) goto L18;
        r6 = true;
        goto L19
    }

    @Override // e93.e
    public final void onTabChange(Integer r1) {
        this.b = null;
    }

    public c(ECHybridRecyclerView r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "btmID");
        this.f = r2;
        this.g = r3;
        this.a = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashSet();
    }

    public final void b(Map<String, ? extends Object> r9, Pair<Integer, Long> r10) {
        long r0 = ((Number) r10.getSecond()).longValue();
        long r2 = System.currentTimeMillis();
        long r4 = r2 - r0;
        JSONObject r6 = new JSONObject();
        r6.putOpt("req_num", r10.getFirst());
        r6.putOpt("start_time", Long.valueOf(r0));
        r6.putOpt("end_time", Long.valueOf(r2));
        r6.putOpt("stay_time", Long.valueOf(r4));
        int r11 = f93.a.a;
        f93.a.c(r6, this.g);
        Iterator<T> r12 = r9.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        String r1 = (String) r12.next();
        r6.putOpt(r1, r9.get(r1));
        goto L4
    L6:
        Unit r13 = Unit.INSTANCE;
        AppLogNewUtils.onEventV3("mall_req_for_stay_time", r6);
    }
}
