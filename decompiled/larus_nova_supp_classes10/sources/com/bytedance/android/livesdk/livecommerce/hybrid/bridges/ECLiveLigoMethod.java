package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.livesdk.livecommerce.ability.e;
import com.bytedance.android.livesdk.livecommerce.ability.f;
import com.bytedance.android.livesdk.livecommerce.dynamiccontext.LiveDynamicContext;
import com.bytedance.android.livesdk.livecommerce.kmp.ECLiveKmpABUtils;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.shopping.ligo.context.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECLiveLigoMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveLigoMethod extends ECBaseBridgeMethod {
    public final String e;

    public static final class a {
    }

    public static final class b implements e {
        public final /* synthetic */ ECBaseBridgeMethod.a a;

        @Override // com.bytedance.android.livesdk.livecommerce.ability.e
        public final void onSuccess() {
            this.a.onSuccess(null);
        }

        public b(ECBaseBridgeMethod.a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.ability.e
        public final void onFail(int r3, String r4) {
            this.a.onFailed(0, "ecom-live atomic ability execute failed, error msg: " + r4);
        }
    }

    static {
    }

    public ECLiveLigoMethod() {
        this.e = "ecLiveLigoHybrid";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r14, ECBaseBridgeMethod.a r15) {
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r15, "iReturn");
        String r1 = r14.optString("room_id");
        if (r1.length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        Unit r5 = null;
        if (r2 == true) goto L11;
        r1 = null;
    L11:
        if (((Boolean) ECLiveKmpABUtils.i.getValue()).booleanValue() == false) goto L16;
        int r3 = com.bytedance.android.livesdk.livecommerce.kmp.b.c;
        if (ControllerCenter.c(r1, null).w == null) goto L16;
        String r4 = this.e;
        String r6 = r14.toString();
        com.bytedance.android.livesdk.livecommerce.hybrid.bridges.b r7 = new com.bytedance.android.livesdk.livecommerce.hybrid.bridges.b(r15);
        Intrinsics.checkNotNullParameter(r4, "jsbName");
        Intrinsics.checkNotNullParameter(r6, "paramsJson");
        Intrinsics.checkNotNullParameter(r7, "callback");
    L16:
        String r8 = r14.optString("biz_name");
        if (r8.length() <= 0) goto L19;
        boolean r9 = true;
    L20:
        if (r9 == true) goto L23;
        r8 = null;
    L23:
        String r10 = r14.optString("function");
        if (r10 != null) goto L27;
    L147:
        r15.onFailed(0, "unsupported func type");
        return;
    L27:
        switch(r10.hashCode()) {
            case -1413873225: goto L126;
            case 730857226: goto L95;
            case 996179031: goto L82;
            case 1084758859: goto L30;
            default: goto L147;
        };
    L30:
        if (r10.equals("getProperty") == false) goto L147;
        JSONObject r11 = r14.optJSONObject("params");
        if (r11 == null) goto L80;
        String r12 = r11.optString("property");
        if (r12 == null) goto L80;
        if (r12.length() <= 0) goto L38;
        boolean r13 = true;
    L39:
        if (r13 == true) goto L42;
        r12 = null;
    L42:
        if (r12 == null) goto L80;
        dm.a.a("LigoBridge").a("jsb read property [" + r12 + ']');
        if (r12.hashCode() == (-98276989)) goto L47;
    L73:
        PromotionListController.T.getClass();
        com.bytedance.android.shopping.ligo.context.b<?> r16 = PromotionListController.a.c(r1, null).J;
        if (r16 == null) goto L78;
        Object r17 = r16.d(r12);
        if (r17 == null) goto L78;
        r15.onSuccess(r17);
        String r18 = Unit.INSTANCE;
    L79:
        if (r18 == null) goto L80;
        return;
    L78:
        r15.onFailed(0, "cannot get value of param [" + r12 + ']');
        r18 = Unit.INSTANCE;
        goto L79
    L47:
        if (r12.equals("addon_floor_coord") == false) goto L73;
        JSONObject r19 = r14.optJSONObject("params");
        if (r19 == null) goto L72;
        r18 = r19.optString("product_id");
        if (r18 == null) goto L72;
        if (r18.length() <= 0) goto L55;
        boolean r0 = true;
    L56:
        if (r0 == true) goto L59;
        r18 = null;
    L59:
        if (r18 == null) goto L72;
        PromotionListController.T.getClass();
        fh2.a r20 = PromotionListController.a.b(r1, null);
        if (r20 == null) goto L79;
        Pair r21 = ((LivePromotionListFragment) r20).fa0(r18);
        if (r21 == null) goto L79;
        float[] r22 = (float[]) r21.component1();
        float[] r23 = (float[]) r21.component2();
        StringBuilder r24 = new StringBuilder();
        Float r25 = ArraysKt.getOrNull(r22, 0);
        float r26 = 0.0f;
        if (r25 == null) goto L67;
        float r27 = r25.floatValue();
    L68:
        r24.append(r27);
        r24.append(',');
        Float r28 = ArraysKt.getOrNull(r23, 1);
        if (r28 == null) goto L71;
        r26 = r28.floatValue();
    L71:
        r24.append(r26);
        r15.onSuccess(r24.toString());
        goto L79
    L67:
        r27 = 0.0f;
        goto L68
    L55:
        r0 = false;
    L72:
        r15.onFailed(0, "cannot get value of param [" + r12 + ']');
        r18 = Unit.INSTANCE;
        goto L79
    L38:
        r13 = false;
    L80:
        r15.onFailed(0, "wrong formatting of params, no [property] passed.");
        Unit r110 = Unit.INSTANCE;
        return;
    L82:
        if (r10.equals("setProperty") == false) goto L147;
        JSONObject r111 = r14.optJSONObject("params");
        if (r111 == null) goto L92;
        Iterator r112 = ((HashMap) z1.k(r111)).entrySet().iterator();
    L87:
        if (r112.hasNext() == false) goto L91;
        Map.Entry r29 = (Map.Entry) r112.next();
        String r30 = (String) r29.getKey();
        Object r31 = r29.getValue();
        dm.a.a("LigoBridge").i("put (" + r30 + ", " + r31 + ") into ligo property");
        PromotionListController.T.getClass();
        com.bytedance.android.shopping.ligo.context.b<?> r32 = PromotionListController.a.c(r1, null).J;
        if (r32 == null) goto L87;
        r32.b(r30, r31);
        goto L87
    L91:
        r15.onSuccess(null);
        return;
    L92:
        r15.onFailed(0, "params is null");
        return;
    L95:
        if (r10.equals("executeAtomicAbility") == false) goto L147;
        JSONObject r113 = r14.optJSONObject("params");
        if (r113 == null) goto L117;
        String r33 = r113.optString("service");
        if (r33.length() <= 0) goto L102;
        boolean r34 = true;
    L103:
        if (r34 == true) goto L106;
        r33 = null;
    L106:
        String r35 = r113.optString("action");
        if (r35.length() <= 0) goto L109;
        boolean r36 = true;
    L110:
        if (r36 == true) goto L113;
        r35 = null;
    L113:
        JSONObject r114 = r113.optJSONObject("params");
        if (r114 == null) goto L116;
        r114.put("from_live_ligo_jsb_method", true);
    L116:
        if (r35 == null) goto L117;
        f r37 = new f(r33, r35, r114);
    L119:
        if (r37 == null) goto L124;
        Context r38 = getContext();
        if (r38 == null) goto L123;
        Lazy r115 = LiveDynamicContext.c;
        com.bytedance.android.livesdk.livecommerce.ability.b.a.a(LiveDynamicContext.a.a().a(), r38, r37, null, null, new b(r15), 8);
        r5 = Unit.INSTANCE;
    L123:
        if (r5 == null) goto L124;
        return;
    L124:
        r15.onFailed(0, "wrong formatting of params");
        Unit r116 = Unit.INSTANCE;
        return;
    L109:
        r36 = false;
        goto L110
    L102:
        r34 = false;
    L117:
        r37 = null;
        goto L119
    L126:
        if (r10.equals("registerEvent") == false) goto L147;
        JSONObject r117 = r14.optJSONObject("params");
        if (r117 == null) goto L146;
        JSONArray r118 = r117.optJSONArray("events");
        if (r118 == null) goto L146;
        int r39 = r118.length();
        int r40 = 0;
    L132:
        if (r40 >= r39) goto L145;
        String r41 = r118.optString(r40);
        if (r41.length() <= 0) goto L136;
        boolean r42 = true;
    L137:
        if (r42 == true) goto L140;
        r41 = null;
    L140:
        if (r41 == null) goto L144;
        dm.a.a("LigoBridge").i("service [" + r8 + "] register hybrid event " + r41);
        PromotionListController.T.getClass();
        com.bytedance.android.shopping.ligo.context.b<?> r43 = PromotionListController.a.c(r1, null).J;
        if (r43 == null) goto L144;
        Intrinsics.checkNotNullParameter(r41, "eventName");
        c r44 = r43.d;
        r44.getClass();
        Intrinsics.checkNotNullParameter(r41, "eventName");
        dm.a.a("LigoContext").i("service " + r8 + " register event " + r41);
        r44.a.add(r41);
    L144:
        r40 = r40 + 1;
        goto L132
    L136:
        r42 = false;
        goto L137
    L145:
        r15.onSuccess(null);
        return;
    L146:
        r15.onFailed(0, "event list is null");
        return;
    L19:
        r9 = false;
        goto L20
    L5:
        r2 = false;
        goto L6
    }
}
