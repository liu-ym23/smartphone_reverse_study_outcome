package mh3;

import com.bytedance.android.bcm.api.b;
import com.bytedance.android.ec.core.sku.SkuPerformanceOpt;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.shopping.sku.common.ability.SkuAbilityType;
import com.bytedance.android.shopping.sku.common.monitor.business.SkuBusinessMonitor;
import com.bytedance.android.shopping.sku.common.monitor.chain.SkuYataAddCartChain;
import com.bytedance.android.shopping.sku.common.monitor.chain.SkuYataAptChain;
import com.bytedance.android.shopping.sku.common.monitor.chain.SkuYataBuyNowChain;
import com.bytedance.android.shopping.sku.common.monitor.chain.SkuYataOpenSkuChain;
import com.bytedance.android.shopping.sku.common.monitor.chain.SkuYataPageShowChain;
import com.bytedance.android.shopping.sku.common.monitor.duration.SkuYataFirstScreenDurationMonitor;
import com.bytedance.android.shopping.sku.common.monitor.duration.SkuYataFirstScreenPoint;
import com.bytedance.android.shopping.sku.common.monitor.fps.SkuYataFpsMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final Map<String, a> m = null;
    public SkuYataFirstScreenDurationMonitor a;
    public SkuBusinessMonitor b;
    public com.bytedance.android.shopping.sku.common.monitor.error.a c;
    public SkuYataFpsMonitor d;
    public SkuYataAddCartChain e;
    public SkuYataAptChain f;
    public SkuYataPageShowChain g;
    public SkuYataOpenSkuChain h;
    public SkuYataBuyNowChain i;
    public String j;
    public String k;
    public final SkuParams l;

    /* JADX INFO: renamed from: mh3.a$a, reason: collision with other inner class name */
    public static final class C0219a {
        public static void b(String r2) {
            a r3 = a.m.remove(r2);
            if (r3 == null) goto L17;
            Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r0 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
            String r1 = r3.l.getMonitorId();
            if (r1 != null) goto L7;
            r1 = "";
        L7:
            Intrinsics.checkNotNullParameter(r1, "id");
            com.bytedance.android.shopping.sku.common.monitor.error.a.b.remove(r1);
            if (r3.e == null) goto L11;
            SkuYataAddCartChain.a();
        L11:
            if (r3.h == null) goto L13;
            SkuYataOpenSkuChain.a();
        L13:
            SkuYataAptChain r4 = r3.f;
            if (r4 == null) goto L18;
            r4.a();
            return;
        L18:
            return;
        }

        public static a c(String r1) {
            return (a) ((LinkedHashMap) a.m).get(r1);
        }

        public static void a(SkuAbilityType r4, SkuParams r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r4, "skuPageType");
            Intrinsics.checkNotNullParameter(r5, "skuParams");
            a r0 = new a(r4, r5, r6);
            String r1 = UUID.randomUUID().toString();
            a.m.put(r1, r0);
            r5.setMonitorId(r1);
            SkuPerformanceOpt.a();
            JSONObject r2 = new JSONObject();
            r2.put("EVENT_ORIGIN_FEATURE", "TEMAI");
            r2.put("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
            r2.put("page_type", r4.getValue());
            r2.put("scene_type", r5.getSceneType());
            r2.put("action_type", r5.getActionType());
            r2.put("rd_tag", r5.getProcessMonitorRdTag());
            if (r6 == false) goto L5;
            String r7 = "1";
        L6:
            r2.put("is_single_sku", r7);
            r2.put("biz_identifier", r5.getBizIdentifier());
            SkuYataFirstScreenDurationMonitor r8 = new SkuYataFirstScreenDurationMonitor(r5.getMonitorId(), x0.a(r2));
            r0.a = r8;
            SkuYataFirstScreenDurationMonitor.b(r8, SkuYataFirstScreenPoint.START);
            r0.b = new SkuBusinessMonitor(x0.a(r2));
            Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r9 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
            String r10 = r5.getMonitorId();
            if (r10 != null) goto L9;
            r10 = "";
        L9:
            JSONObject r11 = x0.a(r2);
            Intrinsics.checkNotNullParameter(r10, "id");
            Intrinsics.checkNotNullParameter(r11, "baseParams");
            com.bytedance.android.shopping.sku.common.monitor.error.a r3 = new com.bytedance.android.shopping.sku.common.monitor.error.a(r11);
            com.bytedance.android.shopping.sku.common.monitor.error.a.b.put(r10, r3);
            r0.c = r3;
            r0.d = new SkuYataFpsMonitor(r5, x0.a(r2));
            r0.f = new SkuYataAptChain(r5);
            r0.g = new SkuYataPageShowChain(x0.a(r2));
            String r12 = null;
            kc.a r13 = b.c(null, CollectionsKt.arrayListOf(new String[]{"ecom_entrance"}));
            if (r13 == null) goto L18;
            List r14 = r13.a;
            if (r14 == null) goto L18;
            List r15 = r14;
            ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
            Iterator r17 = r15.iterator();
        L15:
            if (r17.hasNext() == false) goto L17;
            r16.add(((kc.a.a) r17.next()).c);
            goto L15
        L17:
            r12 = k.d(r16);
        L18:
            r2.put("btm_list", r12);
            r0.e = new SkuYataAddCartChain(x0.a(r2));
            r0.h = new SkuYataOpenSkuChain(x0.a(r2));
            r0.i = new SkuYataBuyNowChain(x0.a(r2));
            return;
        L5:
            r7 = "0";
            goto L6
        }
    }

    static {
        m = new LinkedHashMap();
    }

    public final void a(String r7) {
        if (r7 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        this.j = this.k;
        this.k = r7;
        JSONObject r8 = new JSONObject();
        r8.put("pre_log_id", this.j);
        r8.put("cur_log_id", this.k);
        SkuBusinessMonitor r1 = this.b;
        if (r1 == null) goto L16;
        Intrinsics.checkNotNullParameter(r8, "params");
        Iterator<String> r2 = r8.keys();
    L14:
        if (r2.hasNext() == false) goto L16;
        String r3 = r2.next();
        r1.d.put(r3, r8.opt(r3));
    L16:
        com.bytedance.android.shopping.sku.common.monitor.error.a r4 = this.c;
        if (r4 == null) goto L22;
        Intrinsics.checkNotNullParameter(r8, "params");
        Iterator<String> r5 = r8.keys();
    L20:
        if (r5.hasNext() == false) goto L25;
        String r6 = r5.next();
        r4.a.put(r6, r8.opt(r6));
        goto L20
    L25:
        return;
    L22:
        return;
    L4:
        if (StringsKt.isBlank(r7) == true) goto L7;
        r0 = false;
        goto L8
    }

    public a(SkuAbilityType r1, SkuParams r2, boolean r3) {
        this.l = r2;
    }
}
