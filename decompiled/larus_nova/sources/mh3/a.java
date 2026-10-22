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

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Map<String, a> f513939m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SkuYataFirstScreenDurationMonitor f513940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SkuBusinessMonitor f513941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.shopping.sku.common.monitor.error.a f513942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SkuYataFpsMonitor f513943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SkuYataAddCartChain f513944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SkuYataAptChain f513945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SkuYataPageShowChain f513946g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SkuYataOpenSkuChain f513947h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SkuYataBuyNowChain f513948i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f513949j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f513950k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SkuParams f513951l;

    /* JADX INFO: renamed from: mh3.a$a, reason: collision with other inner class name */
    public static final class C6814a {
        public static void b(String r100) {
            a r101 = a.f513939m.remove(r100);
            if (r101 == null) goto L17;
            Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r102 = com.bytedance.android.shopping.sku.common.monitor.error.a.f182753b;
            String r103 = r101.f513951l.getMonitorId();
            if (r103 != null) goto L7;
            r103 = "";
        L7:
            Intrinsics.checkNotNullParameter(r103, "id");
            com.bytedance.android.shopping.sku.common.monitor.error.a.f182753b.remove(r103);
            if (r101.f513944e == null) goto L11;
            SkuYataAddCartChain.a();
        L11:
            if (r101.f513947h == null) goto L13;
            SkuYataOpenSkuChain.a();
        L13:
            SkuYataAptChain r104 = r101.f513945f;
            if (r104 == null) goto L18;
            r104.a();
            return;
        L18:
            return;
        }

        public static a c(String r100) {
            return (a) ((LinkedHashMap) a.f513939m).get(r100);
        }

        public static void a(SkuAbilityType r100, SkuParams r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "skuPageType");
            Intrinsics.checkNotNullParameter(r101, "skuParams");
            a r103 = new a(r100, r101, r102);
            String r104 = UUID.randomUUID().toString();
            a.f513939m.put(r104, r103);
            r101.setMonitorId(r104);
            SkuPerformanceOpt.a();
            JSONObject r105 = new JSONObject();
            r105.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
            r105.put("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
            r105.put("page_type", r100.getValue());
            r105.put("scene_type", r101.getSceneType());
            r105.put("action_type", r101.getActionType());
            r105.put("rd_tag", r101.getProcessMonitorRdTag());
            if (r102 == false) goto L5;
            String r106 = "1";
        L6:
            r105.put("is_single_sku", r106);
            r105.put("biz_identifier", r101.getBizIdentifier());
            SkuYataFirstScreenDurationMonitor r107 = new SkuYataFirstScreenDurationMonitor(r101.getMonitorId(), x0.a(r105));
            r103.f513940a = r107;
            SkuYataFirstScreenDurationMonitor.b(r107, SkuYataFirstScreenPoint.START);
            r103.f513941b = new SkuBusinessMonitor(x0.a(r105));
            Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r108 = com.bytedance.android.shopping.sku.common.monitor.error.a.f182753b;
            String r109 = r101.getMonitorId();
            if (r109 != null) goto L9;
            r109 = "";
        L9:
            JSONObject r110 = x0.a(r105);
            Intrinsics.checkNotNullParameter(r109, "id");
            Intrinsics.checkNotNullParameter(r110, "baseParams");
            com.bytedance.android.shopping.sku.common.monitor.error.a r111 = new com.bytedance.android.shopping.sku.common.monitor.error.a(r110);
            com.bytedance.android.shopping.sku.common.monitor.error.a.f182753b.put(r109, r111);
            r103.f513942c = r111;
            r103.f513943d = new SkuYataFpsMonitor(r101, x0.a(r105));
            r103.f513945f = new SkuYataAptChain(r101);
            r103.f513946g = new SkuYataPageShowChain(x0.a(r105));
            String r112 = null;
            kc.a r113 = b.c(null, CollectionsKt.arrayListOf(new String[]{"ecom_entrance"}));
            if (r113 == null) goto L18;
            List<kc.a.C6534a> r114 = r113.f502353a;
            if (r114 == null) goto L18;
            List<kc.a.C6534a> r115 = r114;
            ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
            Iterator<T> r117 = r115.iterator();
        L15:
            if (r117.hasNext() == false) goto L17;
            r116.add(((kc.a.C6534a) r117.next()).f502356c);
            goto L15
        L17:
            r112 = k.d(r116);
        L18:
            r105.put("btm_list", r112);
            r103.f513944e = new SkuYataAddCartChain(x0.a(r105));
            r103.f513947h = new SkuYataOpenSkuChain(x0.a(r105));
            r103.f513948i = new SkuYataBuyNowChain(x0.a(r105));
            return;
        L5:
            r106 = "0";
            goto L6
        }
    }

    static {
        f513939m = new LinkedHashMap();
    }

    public final void a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        this.f513949j = this.f513950k;
        this.f513950k = r100;
        JSONObject r102 = new JSONObject();
        r102.put("pre_log_id", this.f513949j);
        r102.put("cur_log_id", this.f513950k);
        SkuBusinessMonitor r103 = this.f513941b;
        if (r103 == null) goto L16;
        Intrinsics.checkNotNullParameter(r102, "params");
        Iterator<String> r104 = r102.keys();
    L14:
        if (r104.hasNext() == false) goto L16;
        String r105 = r104.next();
        r103.f182738d.put(r105, r102.opt(r105));
    L16:
        com.bytedance.android.shopping.sku.common.monitor.error.a r106 = this.f513942c;
        if (r106 == null) goto L22;
        Intrinsics.checkNotNullParameter(r102, "params");
        Iterator<String> r107 = r102.keys();
    L20:
        if (r107.hasNext() == false) goto L25;
        String r108 = r107.next();
        r106.f182754a.put(r108, r102.opt(r108));
        goto L20
    L25:
        return;
    L22:
        return;
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L8
    }

    public a(SkuAbilityType r100, SkuParams r101, boolean r102) {
        this.f513951l = r101;
    }
}
