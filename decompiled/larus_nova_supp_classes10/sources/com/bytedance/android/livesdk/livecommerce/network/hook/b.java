package com.bytedance.android.livesdk.livecommerce.network.hook;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.i;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.shopping.api.address.IAddressService;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import si2.g;
import si2.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final Map<String, List<String>> a = null;
    public static final int b = 0;
    public static final List<String> c = null;
    public static final List<String> d = null;

    static {
        a = EComABUtils.liveExtraRequestParmasPageList();
        b = EComABUtils.liveExtraRequestParmasPageMaxSize();
        String r1 = g.q;
        String r7 = g.r;
        StringBuilder r10 = new StringBuilder();
        String r11 = g.a;
        r10.append(r11);
        r10.append("/live/promotions/pop/refresh/");
        c = CollectionsKt.listOf(new String[]{g.f, g.g, g.h, g.k, r1, g.P, g.E, g.Y, r7, g.j, r10.toString()});
        d = CollectionsKt.listOf(new String[]{r1, "/live/promotions/pop/preview/", r7, r11 + "/live/promotions/pop/refresh/", r11 + "/live/promotions/pop/v3/high/heat/", r11 + "/live/promotions/pop/refresh/high/heat/"});
    }

    public static void a(String r16, List r17) {
        Intrinsics.checkNotNullParameter(r16, "url");
        Intrinsics.checkNotNullParameter(r17, "param");
        List<String> r2 = EComABUtils.getNetworkAPINeedAppendAddressInfo();
        boolean r4 = true;
        if (r2 != null) goto L5;
    L9:
        r2 = c;
    L11:
        if (r2.contains(r16) == false) goto L66;
        List r3 = r17;
        Iterator r8 = r3.iterator();
    L14:
        if (r8.hasNext() == false) goto L18;
        Object r9 = r8.next();
        if (Intrinsics.areEqual(((i) ((k) r9)).a, "room_id") == false) goto L14;
    L19:
        k r10 = (k) r9;
        if (r10 == null) goto L22;
        String r11 = ((i) r10).b;
    L23:
        Iterator r12 = r3.iterator();
    L25:
        if (r12.hasNext() == false) goto L29;
        Object r13 = r12.next();
        if (Intrinsics.areEqual(((i) ((k) r13)).a, "room_unique_key") == false) goto L25;
    L30:
        k r14 = (k) r13;
        if (r14 == null) goto L33;
        String r15 = ((i) r14).b;
    L34:
        int r18 = RoomContextController.h;
        Context r19 = RoomContextController.a.b(r11, r15).getContext();
        List<String> r110 = EComABUtils.getLiveRequestAddressBizCodes();
        if (r110 != null) goto L37;
    L43:
        Set r111 = SetsKt.setOf("xiaodian.supermarket_pop");
    L44:
        int r112 = ECSdk.a;
        IAddressService r113 = (IAddressService) ECSdk.a(IAddressService.class);
        if (r113 == null) goto L47;
        String r114 = r113.getBtmCodeInSaas("live");
    L49:
        if (r113 == null) goto L53;
        o83.a r5 = IAddressService.a.a(r113, r19, r114, 4);
        if (r5 == null) goto L53;
        JSONObject r6 = r5.a(true, r111, SetsKt.setOf("address_list"));
        r17.add(new k("address_info", Uri.encode(r6.toString())));
        dm.a.a("LiveAddress").a("appendAddressInfo: addr=" + r6 + ", url=" + r16);
    L53:
        Iterator r7 = r3.iterator();
    L55:
        if (r7.hasNext() == false) goto L59;
        Object r20 = r7.next();
        if (Intrinsics.areEqual(((i) ((k) r20)).a, "store_id") == false) goto L55;
    L60:
        if (r20 != null) goto L62;
        boolean r21 = true;
    L63:
        if (r21 == false) goto L66;
        PromotionListController.T.getClass();
        String r22 = PromotionListController.a.c(r11, r15).z;
        r17.add(new k("store_id", r22));
        dm.a.a("LiveAddress").a("appendStoreId: storeId=" + r22 + ", url=" + r16);
        goto L66
    L62:
        r21 = false;
        goto L63
    L59:
        r20 = null;
        goto L60
    L47:
        r114 = null;
        goto L49
    L37:
        if ((!r110.isEmpty()) == true) goto L40;
        r110 = null;
    L40:
        if (r110 == null) goto L43;
        r111 = CollectionsKt.toSet(r110);
        if (r111 != null) goto L44;
    L33:
        r15 = null;
        goto L34
    L29:
        r13 = null;
        goto L30
    L22:
        r11 = null;
        goto L23
    L18:
        r9 = null;
    L66:
        if (EComABUtils.enablePopCardRequestTimeOpt() == true) goto L68;
    L70:
        List r23 = r17;
        Iterator r24 = r23.iterator();
    L72:
        if (r24.hasNext() == false) goto L76;
        Object r25 = r24.next();
        if (Intrinsics.areEqual(((i) ((k) r25)).a, "room_id") == false) goto L72;
    L77:
        k r26 = (k) r25;
        if (r26 == null) goto L80;
        String r27 = ((i) r26).b;
    L81:
        Iterator r28 = r23.iterator();
    L83:
        if (r28.hasNext() == false) goto L87;
        Object r29 = r28.next();
        if (Intrinsics.areEqual(((i) ((k) r29)).a, "room_unique_key") == false) goto L83;
    L88:
        k r30 = (k) r29;
        if (r30 == null) goto L91;
        String r31 = ((i) r30).b;
    L93:
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L95;
        int r32 = RoomContextController.h;
        RoomContextController r33 = RoomContextController.a.a();
    L135:
    L131:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L133:
        CollectionsKt.removeAll(r17, ECNetworkRequestUtils$filterRequestParams$1.INSTANCE);
        return;
    L97:
        if (r33.x() == false) goto L133;
        com.bytedance.android.ec.adapter.api.state.a r34 = r33.L();     // Catch: Exception -> L131
        if (r34 == null) goto L133;
        String r35 = ((String) r34.m.get("enter_from_merge")) + "_temai_" + ((String) r34.m.get("enter_method"));     // Catch: Exception -> L131
        String r0 = UriProtector.parse(r16).getPath();     // Catch: Exception -> L131
        List<String> r36 = a.get(r35);     // Catch: Exception -> L131
        if (r36 == null) goto L133;
        Iterator<T> r37 = r36.iterator();     // Catch: Exception -> L131
    L104:
        if (r37.hasNext() == false) goto L108;
        Object r38 = r37.next();     // Catch: Exception -> L131
        if (Intrinsics.areEqual(r0, (String) r38) == false) goto L104;
    L110:
        if (((String) r38) == null) goto L133;
        String r1 = (String) r34.p.get("extra_request_params");     // Catch: Exception -> L131
        if (r1 == null) goto L133;
        if (r1.length() <= 0) goto L116;
        boolean r39 = true;
    L117:
        if (r39 == true) goto L119;
    L121:
        r4 = false;
    L122:
        if (r4 == false) goto L124;
        String r40 = r1;
    L125:
        if (r40 == null) goto L133;
        List r41 = CollectionsKt.toMutableList(r17);     // Catch: Exception -> L131
        int r42 = k.c;     // Catch: Exception -> L131
        k r43 = k.a.a("extra_request_params", r40);     // Catch: Exception -> L131
        if (r43 == null) goto L129;
        r41.add(r43);     // Catch: Exception -> L131
    L129:
        Unit r44 = Unit.INSTANCE;     // Catch: Exception -> L131
        goto L133
    L124:
        r40 = null;
        goto L125
    L119:
        if (r1.length() > b) goto L121;
    L116:
        r39 = false;
        goto L117
    L108:
        r38 = null;
        goto L110
    L95:
        int r45 = RoomContextController.h;
        r33 = RoomContextController.a.b(r27, r31);
        goto L135
    L91:
        r31 = null;
        goto L93
    L87:
        r29 = null;
        goto L88
    L80:
        r27 = null;
        goto L81
    L76:
        r25 = null;
        goto L77
    L68:
        if (d.contains(r16) == false) goto L70;
        r17.add(new k("routine_optimize", "1"));
        dm.a.a("PopCardParams").a("appendParams: routine_optimize=1, url=" + r16);
        goto L70
    L5:
        if ((!r2.isEmpty()) == true) goto L8;
        r2 = null;
    L8:
        if (r2 != null) goto L11;
        goto L9
    }
}
