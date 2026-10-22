package di3;

import android.app.Activity;
import android.content.Context;
import android.util.AndroidRuntimeException;
import android.view.View;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.bst.api.f;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.anchorv3.PdpSchemaSizeMonitor;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.sdk.helper.g;
import com.bytedance.android.ec.sdk.helper.i;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.ecom.arch.slice.action.t;
import com.bytedance.android.shopping.anchorv3.utils.l;
import com.bytedance.android.shopping.anchorv4.containers.page.PdContext;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.helper.PdpBottomNavBarHelper;
import com.bytedance.android.shopping.anchorv4.helper.e;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.utils.y;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class b implements t {
    public final Context a;
    public final AnchorV4VM b;

    public b(Context r2, AnchorV4VM r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "anchorV4Vm");
        this.a = r2;
        this.b = r3;
    }

    private static jq.a h(jq.a r6, String r7) {
        String r0 = r6.h();
        if (r0 == null) goto L8;
        String r1 = r6.f();
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        String r2 = StringsKt.replace$default(r0, r1, r7, false, 4, null);
    L10:
        return jq.a.a(r6, r7, r2);
    L8:
        r2 = null;
        goto L10
    }

    public final void e(Context r4, iq.b r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "toastParam");
        i r0 = i.a;
        String r1 = r5.a();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.e(r4, r1, r5.b(), false);
    }

    public final void f(Activity r9, hq.c r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "param");
        String r11 = r10.f();
        if (r11 != null) goto L5;
        return;
    L5:
        PdContext r0 = this.b.getPdContext();
        if (r0 == null) goto L13;
        PdpBottomNavBarHelper r1 = r0.k;
        if (r1 == null) goto L13;
        String r2 = r1.a(r11);
        if (r2 == null) goto L13;
        r11 = r2;
    L13:
        String r12 = u73.a.a(r11);
        int r3 = e.a;
        String r13 = e.a(r12, this.b);
        if (ECLiveHybridUtil.i(r13) == false) goto L16;
        ECLiveHybridUtil.k(r9, r13, false, false, this.b.isInSplit(), "ecom_pdp", 92);
    L17:
        Lazy r14 = PdpSchemaSizeMonitor.a;
        PdpSchemaSizeMonitor.a(r13, this.b.getLastLogId());
        return;
    L16:
        p r4 = p.a;
        int r5 = y.a;
        r4.d(y.g(r13), r9);
        goto L17
    }

    private final void g(jq.a r13, Map<String, ? extends Object> r14, View r15) {
        LinkedHashMap r0 = new LinkedHashMap();
        LinkedTreeMap r1 = this.b.trackMeta();
        if (r1 == null) goto L5;
        r0.putAll(r1);
    L5:
        if (r14 == null) goto L7;
        r0.putAll(r14);
    L7:
        Integer r2 = r13.d();
        boolean r3 = true;
        if (r2 != null) goto L10;
    L12:
        boolean r4 = false;
    L13:
        String r5 = "";
        if (r4 == false) goto L49;
        if (r15 == null) goto L118;
        String r6 = r13.e();
        if (r6 == null) goto L21;
        r5 = r6;
    L21:
        String r7 = r13.f();
        String r8 = r13.h();
        a r9 = new a(this, r13, r14);
        if (r5.length() != 0) goto L24;
        boolean r16 = true;
    L25:
        if (r16 == false) goto L27;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L27:
        com.bytedance.android.bst.api.d r17 = new com.bytedance.android.bst.api.d(r15);
        r17.a = r5;
        if (r7 == null) goto L48;
        r17.b = r7;
        r17.c = r8;
        r17.d = "shopping";
        r17.e = -1;
        r17.f = r9;
        Integer r18 = r13.d();
        if (r18 != null) goto L33;
    L35:
        boolean r19 = false;
    L36:
        if (r19 == false) goto L38;
        f.b.getClass();
        f.a(r17);
        return;
    L38:
        Integer r110 = r13.d();
        if (r110 != null) goto L42;
    L44:
        r3 = false;
    L45:
        if (r3 == false) goto L113;
        f.b.getClass();
        f.c(r17);
        return;
    L113:
        return;
    L42:
        if (r110.intValue() != 2) goto L44;
    L33:
        if (r18.intValue() != 1) goto L35;
        r19 = true;
        goto L36
    L48:
        throw new AndroidRuntimeException("event is empty");
    L24:
        r16 = false;
        goto L25
    L118:
        return;
    L49:
        String r10 = r13.b();
        if (r10 != null) goto L52;
    L55:
        if (r3 == false) goto L68;
        LinkedHashMap r11 = new LinkedHashMap();
        if (r14 == null) goto L59;
        r11.putAll(r14);
    L59:
        Map r111 = r13.i();
        if (r111 == null) goto L62;
        r11.putAll(r111);
    L62:
        String r112 = r13.e();
        if (r112 == null) goto L65;
        r11.put("btm", r112);
    L65:
        int r113 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r12 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r12 == null) goto L115;
        r12.c = r11;
        String r20 = r13.g();
        String r21 = r13.h();
        AnchorV4TrackerImpl.b(r12, r20, r13.c(), r21, false, PageFinder.via(r15), 8);
        return;
    L115:
        return;
    L68:
        LinkedHashMap r114 = new LinkedHashMap();
        LinkedTreeMap r22 = this.b.trackMeta();
        if (r22 == null) goto L71;
        r114.putAll(r22);
    L71:
        if (r14 == null) goto L73;
        r114.putAll(r14);
    L73:
        CommonMeta r115 = this.b.commonMeta();
        if (r115 == null) goto L117;
        ECAdLogExtra r116 = r115.getAdLogExtra();
        if (r116 == null) goto L119;
        LinkedHashMap r23 = new LinkedHashMap();
        CommonMeta r24 = this.b.commonMeta();
        if (r24 == null) goto L82;
        String r25 = r24.getProductId();
        if (r25 == null) goto L82;
    L83:
        r23.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r25);
        LinkedTreeMap r26 = this.b.trackMeta();
        if (r26 == null) goto L88;
        Object r27 = r26.get("button_status");
        if (r27 == null) goto L88;
        r23.put("button_status", r27);
    L88:
        r23.put("duration", Long.valueOf(this.b.getDuration()));
        r23.put("commodity_duration", Long.valueOf(this.b.getDuration()));
        Iterator r117 = r114.entrySet().iterator();
    L90:
        if (r117.hasNext() == false) goto L94;
        Map.Entry r28 = (Map.Entry) r117.next();
        String r29 = (String) r28.getKey();
        Object r30 = r28.getValue();
        if (r30 == null) goto L90;
        r23.put(r29, r30);
        goto L90
    L94:
        Map r118 = r13.i();
        if (r118 == null) goto L97;
        r23.putAll(r118);
    L97:
        g r31 = g.a;
        Context r32 = this.a;
        String r33 = r13.g();
        String r119 = r13.b();
        if (r119 != null) goto L100;
        String r34 = "";
    L101:
        String r35 = r116.getCreativeId();
        Long r120 = StringsKt.toLongOrNull(r116.getGroupId());
        if (r120 == null) goto L104;
        long r36 = r120.longValue();
    L105:
        int r121 = l.a;
        r31.b(r32, r33, r34, r35, r36, l.b(r116.getLogExtra(), l.a(r116.getAdExtraData(), r23), null, null));
        return;
    L104:
        r36 = 0;
        goto L105
    L100:
        r34 = r119;
    L82:
        r25 = "";
        goto L83
    L119:
        return;
    L117:
        return;
    L52:
        if (r10.length() == 0) goto L55;
        r3 = false;
        goto L55
    L10:
        if (r2.intValue() <= 0) goto L12;
        r4 = true;
        goto L13
    }

    public final void a(jq.a r4, Map<String, ? extends Object> r5, View r6) {
        Intrinsics.checkNotNullParameter(r4, "logData");
        g(r4, r5, r6);
        Integer r0 = r4.j();
        if (r0 != null) goto L6;
    L8:
        if (r0 != null) goto L11;
    L13:
        jq.a r7 = null;
    L14:
        if (r7 == null) goto L17;
        g(r7, r5, r6);
        return;
    L17:
        return;
    L11:
        if (r0.intValue() != 2) goto L13;
        r7 = h(r4, "pdp_module_click");
        goto L14
    L6:
        if (r0.intValue() != 1) goto L8;
        r7 = h(r4, "pdp_module_show");
        goto L14
    }
}
