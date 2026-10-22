package com.bytedance.android.shopping.api.mall.common.homepage.pagecard.monitor;

import android.net.Uri;
import com.bytedance.android.shopping.api.mall.common.tools.h;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kk.d;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;
import y93.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class MallDeliveryMonitor$onStartMonitor$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $appLaunchTime;
    final /* synthetic */ int $appLaunchType;
    final /* synthetic */ int $openFrom;
    final /* synthetic */ Map $searchParams;
    final /* synthetic */ Uri $uri;
    final /* synthetic */ String $uuid;
    final /* synthetic */ MallDeliveryMonitor this$0;

    public MallDeliveryMonitor$onStartMonitor$1(MallDeliveryMonitor r1, String r2, Map r3, Uri r4, int r5, int r6, long r7) {
        this.this$0 = r1;
        this.$uuid = r2;
        this.$searchParams = r3;
        this.$uri = r4;
        this.$openFrom = r5;
        this.$appLaunchType = r6;
        this.$appLaunchTime = r7;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m198invoke() {
        Iterator r1 = ((LinkedHashMap) this.this$0.d).entrySet().iterator();
    L3:
        Unit r4 = null;
        if (r1.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) r1.next();
        if (((Set) r2.getValue()).contains("delivery_end") == true) goto L3;
        JSONObject r5 = new JSONObject();
        MallDeliveryMonitor.i(this.this$0, r5, (String) r2.getKey(), null);
        MallDeliveryMonitor r6 = this.this$0;
        String r3 = (String) r2.getKey();
        r6.getClass();
        d.c(new MallDeliveryMonitor$reportDeliveryEvent$1(r6, r3, r5, false));
        goto L3
    L8:
        ((LinkedHashMap) this.this$0.a).clear();
        ((LinkedHashMap) this.this$0.b).clear();
        ((LinkedHashMap) this.this$0.d).clear();
        ((LinkedHashMap) this.this$0.e).clear();
        ((LinkedHashMap) this.this$0.i).clear();
        Map<String, Map<String, String>> r7 = this.this$0.e;
        String r8 = this.$uuid;
        Map<String, String> r9 = this.$searchParams;
        if (r9 != null) goto L11;
        r9 = MapsKt.emptyMap();
    L11:
        r7.put(r8, r9);
        this.this$0.j = "";
        Uri r10 = this.$uri;
        if (r10.isHierarchical() == true) goto L93;
        r10 = null;
    L93:
        boolean r11 = h.b.getIHybridHostUserService().isLogin();     // Catch: Throwable -> L17
    L19:
        Pair[] r12 = new Pair[13];
        r12[0] = TuplesKt.to("delivery_identify_time", Long.valueOf(System.currentTimeMillis()));
        r12[1] = TuplesKt.to("delivery_schema", this.$uri.toString());
        r12[2] = TuplesKt.to("is_delivery_outer", Integer.valueOf(this.$openFrom));
        r12[3] = TuplesKt.to("launch_type", Integer.valueOf(this.$appLaunchType));
        r12[4] = TuplesKt.to("app_launch_start_time", Long.valueOf(this.$appLaunchTime));
        if (r10 == null) goto L22;
        String r13 = UriProtector.getQueryParameter(r10, SimilarProductParam.ENTER_FROM);
    L23:
        if (r13 != null) goto L25;
        r13 = "";
    L25:
        r12[5] = TuplesKt.to(SimilarProductParam.ENTER_FROM, r13);
        if (r10 == null) goto L28;
        String r14 = UriProtector.getQueryParameter(r10, "delivery_type");
    L29:
        if (r14 != null) goto L31;
        r14 = "";
    L31:
        r12[6] = TuplesKt.to("delivery_type", r14);
        if (r10 == null) goto L34;
        String r15 = UriProtector.getQueryParameter(r10, "delivery_value");
    L35:
        if (r15 != null) goto L37;
        r15 = "";
    L37:
        r12[7] = TuplesKt.to("delivery_value", r15);
        if (r10 == null) goto L40;
        String r16 = UriProtector.getQueryParameter(r10, "delivery_channel_tag");
    L41:
        if (r16 != null) goto L43;
        r16 = "";
    L43:
        r12[8] = TuplesKt.to("delivery_channel_tag", r16);
        if (r10 == null) goto L46;
        String r17 = UriProtector.getQueryParameter(r10, "delivery_event_block");
    L47:
        if (r17 != null) goto L49;
        r17 = "";
    L49:
        r12[9] = TuplesKt.to("delivery_event_block", r17);
        if (r10 == null) goto L52;
        String r18 = UriProtector.getQueryParameter(r10, "delivery_screen_type");
    L53:
        if (r18 != null) goto L55;
        r18 = "";
    L55:
        r12[10] = TuplesKt.to("delivery_screen_type", r18);
        if (r10 == null) goto L58;
        String r19 = UriProtector.getQueryParameter(r10, "delivery_template_key");
    L59:
        if (r19 != null) goto L61;
        r19 = "";
    L61:
        r12[11] = TuplesKt.to("delivery_template_key", r19);
        if (r11 == false) goto L64;
        String r20 = "1";
    L65:
        r12[12] = TuplesKt.to("is_login", r20);
        Map<String, Object> r21 = MapsKt.mutableMapOf(r12);
        if (r10 == null) goto L91;
        Set r22 = UriProtector.getQueryParameterNames(r10);
        if (r22 == null) goto L91;
        Iterator r23 = r22.iterator();
    L71:
        if (r23.hasNext() == false) goto L91;
        String r24 = (String) r23.next();
        String r25 = UriProtector.getQueryParameter(r10, r24);
        if (r25 != null) goto L75;
        r25 = "";
    L75:
        r21.put(r24, r25);
    L91:
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L84
        Object r27 = r21.get("delivery_start_time");     // Catch: Throwable -> L84
        if ((r27 instanceof String) == true) goto L79;
        r27 = null;
    L79:
        String r28 = (String) r27;     // Catch: Throwable -> L84
        if (r28 == null) goto L82;
        r21.put("delivery_start_time", Long.valueOf(CastLongProtector.parseLong(r28)));     // Catch: Throwable -> L84
        r4 = Unit.INSTANCE;     // Catch: Throwable -> L84
    L82:
        Result.constructor-impl(r4);     // Catch: Throwable -> L84
    L86:
        this.this$0.a.put(this.$uuid, r21);
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(r21);
        Map<String, Object> r29 = this.this$0.c.remove(this.$uuid);
        if (r29 == null) goto L89;
        r0.putAll(r29);
    L89:
        this.this$0.b.put(this.$uuid, r0);
        this.this$0.c(new e("delivery_identify", this.$uuid));
        return;
    L84:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L86
    L64:
        r20 = "0";
        goto L65
    L58:
        r19 = null;
        goto L59
    L52:
        r18 = null;
        goto L53
    L46:
        r17 = null;
        goto L47
    L40:
        r16 = null;
        goto L41
    L34:
        r15 = null;
        goto L35
    L28:
        r14 = null;
        goto L29
    L22:
        r13 = null;
    L17:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th);
        r11 = false;
        goto L19
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m198invoke();
        return Unit.INSTANCE;
    }
}
