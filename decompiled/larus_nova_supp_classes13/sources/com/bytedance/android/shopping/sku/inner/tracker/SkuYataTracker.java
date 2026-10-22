package com.bytedance.android.shopping.sku.inner.tracker;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.event.EventActionImpl;
import com.bytedance.android.ec.core.sku.SkuPerformanceOpt;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.track.TrackCatcher;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuYataTracker {
    public final EventActionImpl a;
    public volatile long b;
    public volatile long c;
    public final Map<String, String> d;
    public Map<String, String> e;
    public final Map<String, String> f;
    public final b g;
    public final SkuParams h;

    public final void d() {
        if (this.h.getSceneType() != 201) goto L5;
        String r0 = "livesdk_ecom_sku_should_open";
    L6:
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("data_type", "commerce_data");
        r1.put("sku_from", this.h.getMethod());
        r1.put(PdpOpenThirdParam.KEY_PROMOTION_ID, this.h.getPromotionId());
        r1.put("author_id", this.h.getAuthorId());
        String r2 = this.h.getRoomId();
        if (r2 == null) goto L9;
        r1.put("room_id", r2);
    L9:
        Unit r3 = Unit.INSTANCE;
        c(r0, null, null, r1);
        return;
    L5:
        r0 = "ecom_sku_should_open";
        goto L6
    }

    public SkuYataTracker(SkuParams r4) {
        Intrinsics.checkNotNullParameter(r4, "skuParams");
        this.h = r4;
        this.a = new EventActionImpl();
        Pair[] r0 = new Pair[5];
        r0[0] = TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI");
        r0[1] = TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        Float r1 = ECAppInfoService.e.getCurrentFontScale();
        if (r1 == null) goto L5;
        String r2 = String.valueOf(r1.floatValue());
    L6:
        r0[2] = TuplesKt.to("font_scale", r2);
        r0[3] = TuplesKt.to("biz_identifier", r4.getBizIdentifier());
        r0[4] = TuplesKt.to("gecko_channel_version", String.valueOf(wh.a.a("ecom_sku_pannel_template")));
        this.d = MapsKt.mapOf(r0);
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.g = new b(new SkuYataTracker$trackerQueue$1(this));
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final synchronized void e(Map<String, ? extends Object> r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "map");     // Catch: Throwable -> L14
        Iterator<Map.Entry<String, ? extends Object>> r5 = r4.entrySet().iterator();     // Catch: Throwable -> L14
    L4:
        if (r5.hasNext() == false) goto L12;
        Map.Entry<String, ? extends Object> r0 = r5.next();     // Catch: Throwable -> L14
        Map<String, String> r1 = this.f;     // Catch: Throwable -> L14
        String r2 = r0.getKey();     // Catch: Throwable -> L14
        Object r3 = r0.getValue();     // Catch: Throwable -> L14
        if (r3 == null) goto L9;
        String r6 = r3.toString();     // Catch: Throwable -> L14
    L10:
        r1.put(r2, r6);     // Catch: Throwable -> L14
        goto L4
    L9:
        r6 = null;
        goto L10
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final void a(final String r7, Map<String, String> r8) {
        if (Intrinsics.areEqual(r7, "sku_action") == false) goto L6;
        Lazy r0 = SkuCommonLog.a;
        SkuCommonLog.a("SkuTracker", new SkuYataTracker$addSkuActionIndexIfNeed$1(this, r7));
        r8.put("sku_action_index", String.valueOf(this.b));
        this.b++;
        return;
    L6:
        if (Intrinsics.areEqual(r7, "sku_content_show") == false) goto L10;
        Lazy r1 = SkuCommonLog.a;
        SkuCommonLog.a("SkuTracker", new SkuYataTracker$addSkuActionIndexIfNeed$2(this, r7));
        r8.put("sku_action_index", String.valueOf(this.c));
        this.c++;
        return;
    }

    public final void b(PageFinder r6, String r7, Map<String, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r6, "pageFinder");
        Intrinsics.checkNotNullParameter(r7, "eventName");
        Intrinsics.checkNotNullParameter(r8, "params");
        Object r0 = r8.get("btm");
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        LinkedHashMap r2 = new LinkedHashMap(MapsKt.mapCapacity(r8.size()));
        Iterator<T> r9 = r8.entrySet().iterator();
    L8:
        if (r9.hasNext() == false) goto L14;
        Map.Entry r3 = (Map.Entry) r9.next();
        Object r4 = r3.getKey();
        Object r5 = r3.getValue();
        if (r5 == null) goto L12;
        String r10 = r5.toString();
    L13:
        r2.put(r4, r10);
        goto L8
    L12:
        r10 = null;
        goto L13
    L14:
        c(r7, r1, r6, r2);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final synchronized void f(Map<String, ? extends Object> r3, boolean r4, PageFinder r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "map");     // Catch: Throwable -> L19
        Lazy r0 = SkuPerformanceOpt.a;     // Catch: Throwable -> L19
        BuyNowPerformanceOpt.l();     // Catch: Throwable -> L19
        if (r4 == false) goto L8;
        Map r6 = MapsKt.toMutableMap(this.h.getEventParams());     // Catch: Throwable -> L19
        String r7 = EcomBcmTracker.b(r5, (String) this.h.getEventParams().get("entrance_info"));     // Catch: Throwable -> L19
        if (r7 == null) goto L8;
        r6.put("entrance_info", r7);     // Catch: Throwable -> L19
        this.h.setEventParams(r6);     // Catch: Throwable -> L19
    L8:
        LinkedHashMap r8 = new LinkedHashMap();     // Catch: Throwable -> L19
        r8.putAll(this.h.getEventParams());     // Catch: Throwable -> L19
        LinkedHashMap r9 = new LinkedHashMap(MapsKt.mapCapacity(r3.size()));     // Catch: Throwable -> L19
        Iterator<T> r10 = r3.entrySet().iterator();     // Catch: Throwable -> L19
    L10:
        if (r10.hasNext() == false) goto L16;
        Object r1 = r10.next();     // Catch: Throwable -> L19
        Object r2 = ((Map.Entry) r1).getKey();     // Catch: Throwable -> L19
        Object r11 = ((Map.Entry) r1).getValue();     // Catch: Throwable -> L19
        if (r11 == null) goto L14;
        String r12 = r11.toString();     // Catch: Throwable -> L19
    L15:
        r9.put(r2, r12);     // Catch: Throwable -> L19
        goto L10
    L14:
        r12 = null;
        goto L15
    L16:
        r8.putAll(r9);     // Catch: Throwable -> L19
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L19
        this.e = r8;     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final synchronized void c(final String r3, String r4, PageFinder r5, Map<String, String> r6) {
        monitor-enter(this);
        Lazy r0 = SkuCommonLog.a;     // Catch: Throwable -> L16
        SkuCommonLog.a("SkuTracker", new SkuYataTracker$doSkuEventAction$1(r3));     // Catch: Throwable -> L16
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L16
        r1.putAll(this.d);     // Catch: Throwable -> L16
        r1.putAll(this.e);     // Catch: Throwable -> L16
        r1.putAll(r6);     // Catch: Throwable -> L16
        Lazy r7 = TrackCatcher.a;     // Catch: Throwable -> L16
        if (TrackCatcher.a.a() != null) goto L6;
    L10:
        a(r3, r1);     // Catch: Throwable -> L16
        b r8 = this.g;     // Catch: Throwable -> L16
        a r2 = new a(r3, r4, r5, r1);     // Catch: Throwable -> L16
        r8.getClass();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r2, "event");     // Catch: Throwable -> L16
        if (r8.a == false) goto L13;
        r8.b.add(r2);     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return;
    L13:
        r8.c.invoke(r2);     // Catch: Throwable -> L16
        goto L14
    L6:
        if (r4 != null) goto L8;
        String r9 = "";
    L9:
        TrackCatcher.c("sku", r3, r9);     // Catch: Throwable -> L16
        goto L10
    L8:
        r9 = r4;
    L16:
        th = move-exception;
        throw th;
    }
}
