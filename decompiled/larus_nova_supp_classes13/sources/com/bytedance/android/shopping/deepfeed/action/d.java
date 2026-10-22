package com.bytedance.android.shopping.deepfeed.action;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.o0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedQueryParam;
import com.bytedance.android.shopping.deepfeed.data.repo.l;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import com.bytedance.android.shopping.infeed.data.idl.ad.AdBaseInfo;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.UriProtector;
import he3.e1;
import he3.e2;
import he3.f1;
import he3.g1;
import he3.h1;
import he3.j1;
import he3.k0;
import he3.k2;
import he3.l1;
import he3.n0;
import he3.o1;
import he3.p0;
import he3.p1;
import he3.q0;
import he3.q1;
import he3.r0;
import he3.r1;
import he3.u0;
import he3.u1;
import he3.w0;
import he3.w1;
import he3.x1;
import he3.y;
import he3.z0;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements fa3.d {
    public static final /* synthetic */ int h = 0;
    public Function0<Unit> a;
    public Function2<? super String, ? super String, Unit> b;
    public Function4<? super Integer, ? super Integer, ? super Integer, ? super Boolean, Unit> c;
    public boolean d;
    public long e;
    public final Context f;
    public final /* synthetic */ fa3.b g;

    public static final class a {
    }

    static {
    }

    @Override // fa3.d
    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.g.add(r2);
        return r2;
    }

    public final Context getContext() {
        return this.f;
    }

    public static JSONObject c(JSONObject r5) {
        if (r5 == null) goto L4;
        JSONObject r0 = new JSONObject();
        Iterator<String> r1 = r5.keys();     // Catch: Throwable -> L19
    L7:
        if (r1.hasNext() == false) goto L18;
        String r2 = r1.next();     // Catch: Throwable -> L19
        Object r3 = r5.opt(r2);     // Catch: Throwable -> L19
        if ((r3 instanceof String) == false) goto L16;
        if (((CharSequence) r3).length() <= 0) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L7;
    L14:
        r4 = false;
    L16:
        r0.put(r2, r3);     // Catch: Throwable -> L19
    L18:
        return r0;
    L4:
        return new JSONObject();
    }

    public d(Context r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        this.g = new fa3.b();
        this.f = r2;
    }

    public final void j(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "schema");
        Function2<? super String, ? super String, Unit> r0 = this.b;
        if (r0 == null) goto L6;
        Unit r4 = (Unit) r0.invoke(r2, r3);
        return;
    }

    public final boolean l(InFeedProductV2 r8, String r9) {
        if (r9 != null) goto L19;
        if (r8 == null) goto L17;
        InFeedProductPackData r10 = r8.getPackData();
        if (r10 == null) goto L17;
        InFeedProductPackDataElements r11 = r10.getElements();
        if (r11 == null) goto L17;
        List<p0> r12 = r11.getProducts();
        if (r12 == null) goto L17;
        p0 r13 = (p0) CollectionsKt.firstOrNull(r12);
        if (r13 == null) goto L17;
        q0 r14 = r13.j();
        if (r14 == null) goto L17;
        l1 r15 = r14.a();
        if (r15 == null) goto L17;
        r9 = r15.a();
    L17:
        r9 = null;
    L19:
        if (r9 != null) goto L21;
    L24:
        boolean r16 = true;
    L25:
        if (r16 == false) goto L27;
        return false;
    L27:
        long r1 = SystemClock.elapsedRealtime();
        if (this.d == false) goto L33;
        if ((r1 - this.e) >= 5000) goto L33;
        return false;
    L33:
        if ((r1 - this.e) >= 800) goto L35;
        return false;
    L35:
        this.d = true;
        this.e = r1;
        return true;
    L21:
        if (r9.length() == 0) goto L24;
        r16 = false;
        goto L25
    }

    public final void d(InFeedProductV2 r2, String r3, String r4) {
        if (r2 == null) goto L11;
        InFeedProductPackData r5 = r2.getPackData();
        if (r5 == null) goto L11;
        InFeedProductPackDataElements r6 = r5.getElements();
        if (r6 == null) goto L11;
        List<p0> r7 = r6.getProducts();
        if (r7 == null) goto L11;
        p0 r8 = (p0) CollectionsKt.firstOrNull(r7);
    L12:
        if (r4 != null) goto L20;
        if (r8 == null) goto L19;
        j1 r9 = r8.f();
        if (r9 == null) goto L19;
        f1 r10 = r9.a();
        if (r10 == null) goto L19;
        r4 = r10.a();
    L19:
        r4 = null;
    L20:
        if (r4 != null) goto L22;
    L25:
        boolean r11 = true;
    L26:
        if (r11 == false) goto L28;
        return;
    L28:
        o0 r12 = le3.b.b(new o0(r4), r3);
        j("comment", r12.c());
        Function0<Unit> r13 = this.a;
        if (r13 == null) goto L31;
        Unit r14 = (Unit) r13.invoke();
    L31:
        p.a.openSchema(this.f, r12.c());
        return;
    L22:
        if (r4.length() == 0) goto L25;
        r11 = false;
    L11:
        r8 = null;
        goto L12
    }

    public final void g(InFeedProductV2 r2, String r3, String r4) {
        if (r2 == null) goto L11;
        InFeedProductPackData r5 = r2.getPackData();
        if (r5 == null) goto L11;
        InFeedProductPackDataElements r6 = r5.getElements();
        if (r6 == null) goto L11;
        List<p0> r7 = r6.getProducts();
        if (r7 == null) goto L11;
        p0 r8 = (p0) CollectionsKt.firstOrNull(r7);
    L12:
        if (r4 != null) goto L22;
        if (r8 == null) goto L21;
        w1 r9 = r8.o();
        if (r9 == null) goto L21;
        List<x1> r10 = r9.a();
        if (r10 == null) goto L21;
        x1 r11 = (x1) CollectionsKt.firstOrNull(r10);
        if (r11 == null) goto L21;
        r4 = r11.b();
    L21:
        r4 = null;
    L22:
        if (r4 != null) goto L24;
    L27:
        boolean r12 = true;
    L28:
        if (r12 == false) goto L30;
        return;
    L30:
        o0 r13 = new o0(r4);
        le3.b.b(r13, r3);
        j("search", r13.c());
        Function0<Unit> r14 = this.a;
        if (r14 == null) goto L33;
        Unit r15 = (Unit) r14.invoke();
    L33:
        p.a.openSchema(this.f, r13.c());
        return;
    L24:
        if (r4.length() == 0) goto L27;
        r12 = false;
    L11:
        r8 = null;
        goto L12
    }

    public final void k(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "link");
        Intrinsics.checkNotNullParameter(r4, "type");
        o0 r0 = new o0(r3);
        le3.b.b(r0, r2);
        j(r4, r0.c());
        Function0<Unit> r5 = this.a;
        if (r5 == null) goto L5;
        Unit r6 = (Unit) r5.invoke();
    L5:
        p.a.openSchema(this.f, r0.c());
    }

    public static void i(InFeedProductV2 r11, DeepFeedQueryParam r12, int r13, JSONObject r14) {
        if (r11 == null) goto L228;
        InFeedProductPackData r0 = r11.getPackData();
        if (r0 == null) goto L229;
        InFeedProductPackDataElements r1 = r0.getElements();
        if (r1 == null) goto L232;
        e1 r2 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r11);
        List<e2> r3 = com.bytedance.android.shopping.deepfeed.utlis.a.m(r11);
        List<InFeedUrlModel> r4 = com.bytedance.android.shopping.deepfeed.utlis.a.h(r11);
        p1 r5 = com.bytedance.android.shopping.deepfeed.utlis.a.i(r11);
        r1 r6 = com.bytedance.android.shopping.deepfeed.utlis.a.k(r11);
        String r7 = "";
        if (r12 != null) goto L225;
    L16:
        z0 r8 = r11.getRespExtra();     // Catch: JSONException -> L218
        AdBaseInfo r9 = null;
        if (r8 == null) goto L19;
        String r10 = r8.c();     // Catch: JSONException -> L218
    L20:
        if (r10 != null) goto L22;
        r10 = "";
    L22:
        r14.put("request_id", r10);     // Catch: JSONException -> L218
        r14.put("inflow_order", r13);     // Catch: JSONException -> L218
        r14.put("click_order", r13);     // Catch: JSONException -> L218
        he3.a r15 = r1.getAuthor();     // Catch: JSONException -> L218
        if (r15 == null) goto L27;
        he3.b r16 = r15.a();     // Catch: JSONException -> L218
        if (r16 == null) goto L27;
        String r17 = r16.b();     // Catch: JSONException -> L218
    L28:
        r14.put("anchor_id", r17);     // Catch: JSONException -> L218
        he3.a r18 = r1.getAuthor();     // Catch: JSONException -> L218
        if (r18 == null) goto L33;
        he3.b r19 = r18.a();     // Catch: JSONException -> L218
        if (r19 == null) goto L33;
        String r20 = r19.b();     // Catch: JSONException -> L218
    L34:
        r14.put("author_id", r20);     // Catch: JSONException -> L218
        he3.a r21 = r1.getAuthor();     // Catch: JSONException -> L218
        if (r21 == null) goto L39;
        he3.b r22 = r21.a();     // Catch: JSONException -> L218
        if (r22 == null) goto L39;
        String r23 = r22.a();     // Catch: JSONException -> L218
    L40:
        r14.put(PdpOpenThirdParam.KEY_SEC_AUTHOR_ID, r23);     // Catch: JSONException -> L218
        if (r2 == null) goto L43;
        String r24 = r2.b();     // Catch: JSONException -> L218
    L44:
        r14.put(PdpOpenThirdParam.KEY_PROMOTION_ID, r24);     // Catch: JSONException -> L218
        List<e2> r25 = r3;     // Catch: JSONException -> L218
        boolean r26 = true;
        if (r25 != null) goto L47;
    L50:
        boolean r27 = true;
    L51:
        if (r27 == false) goto L60;
        List<e2> r28 = r3;     // Catch: JSONException -> L218
        if (r28 != null) goto L56;
    L59:
        if (r26 == false) goto L60;
        String r29 = "0";
    L62:
        r14.put("is_show_main_video", r29);     // Catch: JSONException -> L218
        if (r12 == null) goto L65;
        String r30 = r12.getProductSourcePage();     // Catch: JSONException -> L218
    L66:
        if (r30 != null) goto L68;
        r30 = "";
    L68:
        r14.put("product_source_page", r30);     // Catch: JSONException -> L218
        r14.put("new_source_type", "product_inflow");     // Catch: JSONException -> L218
        r14.put("module_label", "guess_you_like_product");     // Catch: JSONException -> L218
        r14.put(PdpOpenThirdParam.KEY_CARRIER_TYPE, "full_screen_card");     // Catch: JSONException -> L218
        r14.put("list_type", "big_card");     // Catch: JSONException -> L218
        if (r12 == null) goto L71;
        String r31 = r12.getCarrierSource();     // Catch: JSONException -> L218
    L72:
        if (r31 != null) goto L74;
        r31 = "";
    L74:
        r14.put("carrier_source", r31);     // Catch: JSONException -> L218
        r14.put("source_method", "guess_you_like");     // Catch: JSONException -> L218
        if (r12 == null) goto L77;
        Integer r32 = r12.getOutflowRank();     // Catch: JSONException -> L218
    L78:
        r14.put("outflow_order", k.f(r32));     // Catch: JSONException -> L218
        if (r12 == null) goto L81;
        String r33 = r12.getPrevPage();     // Catch: JSONException -> L218
    L82:
        if (r33 != null) goto L84;
        r33 = "";
    L84:
        r14.put("previous_page", r33);     // Catch: JSONException -> L218
        if (r12 == null) goto L87;
        String r34 = r12.getTabName();     // Catch: JSONException -> L218
    L88:
        if (r34 != null) goto L90;
        r34 = "";
    L90:
        r14.put("tab_name", r34);     // Catch: JSONException -> L218
        if (r12 == null) goto L93;
        String r35 = r12.getTabId();     // Catch: JSONException -> L218
    L94:
        if (r35 != null) goto L96;
        r35 = "";
    L96:
        r14.put("tab_id", r35);     // Catch: JSONException -> L218
        if (r12 == null) goto L99;
        String r36 = r12.getRequestID();     // Catch: JSONException -> L218
    L100:
        if (r36 != null) goto L102;
        r36 = "";
    L102:
        r14.put("outer_reqid", r36);     // Catch: JSONException -> L218
        u0 r37 = r11.getCustom();     // Catch: JSONException -> L218
        if (r37 == null) goto L105;
        String r38 = r37.a();     // Catch: JSONException -> L218
    L106:
        if (r38 != null) goto L108;
        r38 = "";
    L108:
        r14.put("recommend_info", r38);     // Catch: JSONException -> L218
        if (r2 == null) goto L111;
        String r39 = r2.a();     // Catch: JSONException -> L218
    L112:
        if (r39 != null) goto L114;
        r39 = "";
    L114:
        r14.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r39);     // Catch: JSONException -> L218
        r14.put("is_live_product", 0);     // Catch: JSONException -> L218
        if (r5 == null) goto L117;
        String r40 = com.bytedance.android.ec.hybrid.list.util.k.b(r5).toString();     // Catch: JSONException -> L218
    L118:
        if (r40 != null) goto L120;
        r40 = "";
    L120:
        r14.put("price_info", r40);     // Catch: JSONException -> L218
        if (r6 == null) goto L129;
        List<q1> r41 = r6.a();     // Catch: JSONException -> L218
        if (r41 == null) goto L129;
        q1 r42 = (q1) CollectionsKt.firstOrNull(r41);     // Catch: JSONException -> L218
        if (r42 == null) goto L129;
        Integer r43 = r42.getType();     // Catch: JSONException -> L218
        if (r43 == null) goto L129;
        String r44 = String.valueOf(r43.intValue());     // Catch: JSONException -> L218
    L130:
        if (r44 != null) goto L132;
        r44 = "";
    L132:
        r14.put("reason_type", r44);     // Catch: JSONException -> L218
        if (r6 == null) goto L139;
        List<q1> r45 = r6.a();     // Catch: JSONException -> L218
        if (r45 == null) goto L139;
        q1 r46 = (q1) CollectionsKt.firstOrNull(r45);     // Catch: JSONException -> L218
        if (r46 == null) goto L139;
        String r47 = r46.h();     // Catch: JSONException -> L218
    L140:
        if (r47 != null) goto L142;
        r47 = "";
    L142:
        r14.put("reason_name", r47);     // Catch: JSONException -> L218
        Intrinsics.checkNotNullParameter(r11, "$this$custom");     // Catch: JSONException -> L218
        InFeedProductPackDataElements r48 = com.bytedance.android.shopping.deepfeed.utlis.a.d(r11);     // Catch: JSONException -> L218
        if (r48 == null) goto L150;
        List<p0> r49 = r48.getProducts();     // Catch: JSONException -> L218
        if (r49 == null) goto L150;
        p0 r50 = (p0) CollectionsKt.firstOrNull(r49);     // Catch: JSONException -> L218
        if (r50 == null) goto L150;
        w0 r51 = r50.h();     // Catch: JSONException -> L218
        if (r51 == null) goto L150;
    L157:
        if (r51 == null) goto L159;
        String r52 = r51.c();     // Catch: JSONException -> L218
    L160:
        r14.put("subside_type", r52);     // Catch: JSONException -> L218
        r14.put("outflow_ecom_type", "product");     // Catch: JSONException -> L218
        int r53 = com.bytedance.android.shopping.deepfeed.event.f.a;     // Catch: JSONException -> L218
        if (r2 == null) goto L163;
        String r54 = r2.c();     // Catch: JSONException -> L218
    L164:
        r14.put("main_pic_type", com.bytedance.android.shopping.deepfeed.event.f.d(r3, r4, r54, false));     // Catch: JSONException -> L218
        Intrinsics.checkNotNullParameter(r11, "$this$salesInfo");     // Catch: JSONException -> L218
        InFeedProductPackDataElements r110 = com.bytedance.android.shopping.deepfeed.utlis.a.d(r11);     // Catch: JSONException -> L218
        if (r110 == null) goto L172;
        List<p0> r55 = r110.getProducts();     // Catch: JSONException -> L218
        if (r55 == null) goto L172;
        p0 r56 = (p0) CollectionsKt.firstOrNull(r55);     // Catch: JSONException -> L218
        if (r56 == null) goto L172;
        u1 r57 = r56.n();     // Catch: JSONException -> L218
        if (r57 == null) goto L172;
    L179:
        if (r57 == null) goto L181;
        Integer r111 = r57.b();     // Catch: JSONException -> L218
    L182:
        r14.put("history_sale_cnt", r111);     // Catch: JSONException -> L218
        if (r5 == null) goto L188;
        o1 r112 = r5.b();     // Catch: JSONException -> L218
        if (r112 == null) goto L188;
        String r113 = r112.a();     // Catch: JSONException -> L218
        if (r113 == null) goto L188;
    L193:
        r14.put("price_type", r113);     // Catch: JSONException -> L218
        if (r12 == null) goto L196;
        String r114 = r12.getESceneId();     // Catch: JSONException -> L218
    L198:
        if (k.c(r114) == false) goto L205;
        if (r12 == null) goto L202;
        String r115 = r12.getESceneId();     // Catch: JSONException -> L218
    L203:
        r14.put("ecom_scene_id", r115);     // Catch: JSONException -> L218
        goto L205
    L202:
        r115 = null;
    L205:
        if (r3 == null) goto L209;
        e2 r116 = (e2) CollectionsKt.firstOrNull(r3);     // Catch: JSONException -> L218
        if (r116 == null) goto L209;
        String r117 = r116.e();     // Catch: JSONException -> L218
    L210:
        r14.put("video_id", r117);     // Catch: JSONException -> L218
        ie3.a r118 = r1.getAd();     // Catch: JSONException -> L218
        if (r118 == null) goto L213;
        r9 = r118.a();     // Catch: JSONException -> L218
    L213:
        if (r9 == null) goto L230;
        l.s.getClass();     // Catch: JSONException -> L218
        if (l.r == false) goto L231;
        int r119 = ie3.b.a;     // Catch: JSONException -> L218
        z1.b(r14, new JSONObject());     // Catch: JSONException -> L218
        return;
    L218:
        e = move-exception;
        String r120 = e.getMessage();
        if (r120 == null) goto L223;
        r7 = r120;
    L223:
        ECExceptionMonitor.c(r7);
        return;
    L231:
        return;
    L230:
        return;
    L209:
        r117 = null;
        goto L210
    L196:
        r114 = null;
    L188:
        if (r5 == null) goto L192;
        o1 r121 = r5.d();     // Catch: JSONException -> L218
        if (r121 == null) goto L192;
        r113 = r121.a();     // Catch: JSONException -> L218
    L192:
        r113 = null;
        goto L193
    L181:
        r111 = null;
    L172:
        if (r110 == null) goto L178;
        n0 r122 = r110.getSliceCard();     // Catch: JSONException -> L218
        if (r122 == null) goto L178;
        y r123 = r122.c;     // Catch: JSONException -> L218
        if (r123 == null) goto L178;
        r57 = r123.e();     // Catch: JSONException -> L218
    L178:
        r57 = null;
        goto L179
    L163:
        r54 = null;
        goto L164
    L159:
        r52 = null;
    L150:
        if (r48 == null) goto L156;
        n0 r58 = r48.getSliceCard();     // Catch: JSONException -> L218
        if (r58 == null) goto L156;
        k0 r59 = r58.e();     // Catch: JSONException -> L218
        if (r59 == null) goto L156;
        r51 = r59.c();     // Catch: JSONException -> L218
    L156:
        r51 = null;
    L139:
        r47 = null;
    L129:
        r44 = null;
        goto L130
    L117:
        r40 = null;
        goto L118
    L111:
        r39 = null;
        goto L112
    L105:
        r38 = null;
        goto L106
    L99:
        r36 = null;
        goto L100
    L93:
        r35 = null;
        goto L94
    L87:
        r34 = null;
        goto L88
    L81:
        r33 = null;
        goto L82
    L77:
        r32 = null;
        goto L78
    L71:
        r31 = null;
        goto L72
    L65:
        r30 = null;
        goto L66
    L56:
        if (r28.isEmpty() == true) goto L59;
        r26 = false;
    L60:
        r29 = "1";
        goto L62
    L47:
        if (r25.isEmpty() == true) goto L50;
        r27 = false;
        goto L51
    L43:
        r24 = null;
    L39:
        r23 = null;
    L33:
        r20 = null;
    L27:
        r17 = null;
        goto L28
    L19:
        r10 = null;
        goto L20
    L225:
        Map<String, Object> r60 = r12.getTracker();     // Catch: JSONException -> L218
        if (r60 == null) goto L16;
        ArrayList r61 = new ArrayList(r60.size());     // Catch: JSONException -> L218
        Iterator<Map.Entry<String, Object>> r62 = r60.entrySet().iterator();     // Catch: JSONException -> L218
    L14:
        if (r62.hasNext() == false) goto L16;
        Map.Entry<String, Object> r63 = r62.next();     // Catch: JSONException -> L218
        r61.add(r14.put(r63.getKey(), r63.getValue()));     // Catch: JSONException -> L218
        goto L14
    L232:
        return;
    L229:
        return;
    }

    public final void h(InFeedProductV2 r3, DeepFeedQueryParam r4, String r5, String r6) {
        String r0 = null;
        if (r3 == null) goto L11;
        InFeedProductPackData r1 = r3.getPackData();
        if (r1 == null) goto L11;
        InFeedProductPackDataElements r2 = r1.getElements();
        if (r2 == null) goto L11;
        List<p0> r7 = r2.getProducts();
        if (r7 == null) goto L11;
        p0 r8 = (p0) CollectionsKt.firstOrNull(r7);
    L12:
        if (r3 == null) goto L16;
        e1 r9 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r3);
        if (r9 == null) goto L16;
        String r10 = r9.a();
    L17:
        if (r6 != null) goto L25;
        if (r8 == null) goto L24;
        r0 r11 = r8.p();
        if (r11 == null) goto L24;
        k2 r12 = r11.a();
        if (r12 == null) goto L24;
        r6 = r12.a();
    L24:
        r6 = null;
    L25:
        if (r6 != null) goto L27;
    L30:
        boolean r13 = true;
    L31:
        if (r13 == true) goto L43;
        o0 r14 = new o0(r6);
        if (r4 == null) goto L36;
        r0 = r4.getPrevPage();
    L36:
        if (r0 != null) goto L38;
        r0 = "";
    L38:
        r14.a("store_source_page", r0);
        r14.a("store_source_method", "guess_you_like");
        r14.a("entrance_location", "product_inflow_down");
        r14.b("source_product_id", r10);
        le3.b.b(r14, r5);
        j("shop", r14.c());
        Function0<Unit> r15 = this.a;
        if (r15 == null) goto L41;
        Unit r16 = (Unit) r15.invoke();
    L41:
        p.a.openSchema(this.f, r14.c());
        return;
    L43:
        return;
    L27:
        if (r6.length() == 0) goto L30;
        r13 = false;
    L16:
        r10 = null;
    L11:
        r8 = null;
        goto L12
    }

    public final void e(InFeedProductV2 r7, String r8, int r9, String r10, View r11) {
        Intrinsics.checkNotNullParameter(r8, "baseSchema");
        Intrinsics.checkNotNullParameter(r10, "baseBtm");
        Intrinsics.checkNotNullParameter(r11, FreqActions.ACTION_VIEW);
        String r12 = com.bytedance.android.shopping.deepfeed.utlis.a.c(r7, r10, r11);
        boolean r2 = true;
        if (r8.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L28;
        if (r7 == null) goto L12;
        u0 r13 = r7.getCustom();
        if (r13 == null) goto L12;
        String r14 = r13.a();
    L33:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L26
        Uri r4 = UriProtector.parse(r8);     // Catch: Throwable -> L26
        String r5 = UriProtector.getQueryParameter(r4, "ecom_live_params");     // Catch: Throwable -> L26
        if (r5 != null) goto L16;
    L19:
        if (r2 == true) goto L28;
        JSONObject r6 = new JSONObject(r5);     // Catch: Throwable -> L26
        JSONObject r15 = r6.optJSONObject("pass_through_log_data");     // Catch: Throwable -> L26
        if (r15 != null) goto L24;
        r15 = new JSONObject();     // Catch: Throwable -> L26
    L24:
        r15.putOpt("inflow_order", Integer.valueOf(r9));     // Catch: Throwable -> L26
        r15.putOpt("recommend_info", r14);     // Catch: Throwable -> L26
        r6.putOpt("pass_through_log_data", r15);     // Catch: Throwable -> L26
        r8 = com.bytedance.android.ec.core.utils.j1.d(r4, "ecom_live_params").buildUpon().appendQueryParameter("ecom_live_params", r6.toString()).appendQueryParameter("source_btm_token", r12).build().toString();     // Catch: Throwable -> L26
        goto L28
    L16:
        if (r5.length() == 0) goto L19;
        r2 = false;
    L26:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
    L12:
        r14 = null;
    L28:
        j("live", r8);
        Function0<Unit> r17 = this.a;
        if (r17 == null) goto L31;
        Unit r18 = (Unit) r17.invoke();
    L31:
        p.a.openSchema(this.f, r8);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void f(InFeedProductV2 r25, int r26, DeepFeedQueryParam r27, String r28, String r29, boolean r30) {
        String r3 = r29;
        if (r30 == false) goto L5;
    L7:
        String r4 = null;
        if (r25 == null) goto L16;
        InFeedProductPackData r5 = r25.getPackData();
        if (r5 == null) goto L16;
        InFeedProductPackDataElements r6 = r5.getElements();
        if (r6 == null) goto L16;
        List<p0> r7 = r6.getProducts();
        if (r7 == null) goto L16;
        p0 r8 = (p0) CollectionsKt.firstOrNull(r7);
    L17:
        if (r3 != null) goto L25;
        if (r8 == null) goto L24;
        q0 r9 = r8.j();
        if (r9 == null) goto L24;
        l1 r10 = r9.a();
        if (r10 == null) goto L24;
        r3 = r10.a();
    L24:
        r3 = null;
    L25:
        int r11 = ie3.b.a;
        if (r3 != null) goto L28;
    L31:
        boolean r12 = true;
    L32:
        if (r12 == true) goto L57;
        JSONObject r14 = new JSONObject();
        i(r25, r27, r26, r14);
        JSONObject r15 = new JSONObject();
        JSONObject r1 = new JSONObject();
        JSONObject r13 = new JSONObject();
        if (r27 == null) goto L37;
        r4 = r27.getESceneId();
    L37:
        String r2 = "";
        if (r4 != null) goto L40;
        r4 = "";
    L40:
        r13.put("ecom_scene_id", r4);
        Unit r16 = Unit.INSTANCE;
        r1.put("multi_room_data", r13.toString());
        r15.put("ecom_live_params", r1.toString());
        JSONObject r18 = new JSONObject();
        Context r17 = this.f;
        if (r17 == null) goto L54;
        if (r3 == null) goto L45;
        r2 = r3;
    L45:
        j("product_detail", r2);
        Function0<Unit> r19 = this.a;
        if (r19 == null) goto L48;
        Unit r20 = (Unit) r19.invoke();
    L48:
        int r21 = ECSdk.a;
        IEShoppingService r22 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r22 == null) goto L55;
        p83.d r23 = r22.getAnchorV3Service();
        if (r23 == null) goto L56;
        r23.a(r17, r3, new p83.h(false, null, 1, false, null, null, r14, r15, null, r28, r18, null, null, null, null, 16121658));
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L57:
        return;
    L28:
        if (r3.length() == 0) goto L31;
        r12 = false;
    L16:
        r8 = null;
        goto L17
    L5:
        if (l(r25, r3) == true) goto L7;
    }

    public final void a(InFeedProductV2 r12, DeepFeedQueryParam r13, int r14, JSONArray r15, Long r16, String r17, String r18) {
        String r1 = null;
        if (r12 == null) goto L11;
        InFeedProductPackData r2 = r12.getPackData();
        if (r2 == null) goto L11;
        InFeedProductPackDataElements r3 = r2.getElements();
        if (r3 == null) goto L11;
        List<p0> r4 = r3.getProducts();
        if (r4 == null) goto L11;
        p0 r5 = (p0) CollectionsKt.firstOrNull(r4);
    L12:
        if (r18 != null) goto L20;
        if (r5 == null) goto L19;
        h1 r6 = r5.d();
        if (r6 == null) goto L19;
        f1 r7 = r6.a();
        if (r7 == null) goto L19;
        r1 = r7.a();
    L19:
        String r8 = r1;
    L21:
        if (r8 != null) goto L23;
    L26:
        boolean r9 = true;
    L27:
        if (r9 == true) goto L34;
        String r10 = m(r12, r13, r14, r8, r15, r16, r17, true, "");
        j("add_cart", r10);
        Function0<Unit> r11 = this.a;
        if (r11 == null) goto L32;
        Unit r19 = (Unit) r11.invoke();
    L32:
        p.a.openSchema(this.f, r10);
        return;
    L34:
        return;
    L23:
        if (r8.length() == 0) goto L26;
        r9 = false;
        goto L27
    L20:
        r8 = r18;
    L11:
        r5 = null;
        goto L12
    }

    public final void b(InFeedProductV2 r12, DeepFeedQueryParam r13, int r14, JSONArray r15, Long r16, String r17, String r18, String r19) {
        String r1 = null;
        if (r12 == null) goto L11;
        InFeedProductPackData r2 = r12.getPackData();
        if (r2 == null) goto L11;
        InFeedProductPackDataElements r3 = r2.getElements();
        if (r3 == null) goto L11;
        List<p0> r4 = r3.getProducts();
        if (r4 == null) goto L11;
        p0 r5 = (p0) CollectionsKt.firstOrNull(r4);
    L12:
        if (r19 != null) goto L22;
        if (r5 == null) goto L21;
        g1 r6 = r5.c();
        if (r6 == null) goto L21;
        List<f1> r7 = r6.a();
        if (r7 == null) goto L21;
        f1 r8 = (f1) CollectionsKt.firstOrNull(r7);
        if (r8 == null) goto L21;
        r1 = r8.a();
    L21:
        String r9 = r1;
    L23:
        if (r9 != null) goto L25;
    L28:
        boolean r10 = true;
    L29:
        if (r10 == true) goto L36;
        String r11 = m(r12, r13, r14, r9, r15, r16, r18, false, r17);
        j("buy", r11);
        Function0<Unit> r20 = this.a;
        if (r20 == null) goto L34;
        Unit r21 = (Unit) r20.invoke();
    L34:
        p.a.openSchema(this.f, r11);
        return;
    L36:
        return;
    L25:
        if (r9.length() == 0) goto L28;
        r10 = false;
        goto L29
    L22:
        r9 = r19;
    L11:
        r5 = null;
        goto L12
    }

    public static String m(InFeedProductV2 r24, DeepFeedQueryParam r25, int r26, String r27, JSONArray r28, Long r29, String r30, boolean r31, String r32) {
        Uri r7 = UriProtector.parse(r27);
        String r8 = "sslocal://buy_now";
        boolean r12 = StringsKt.startsWith$default(r27, "sslocal://buy_now", false, 2, null);
        boolean r13 = Intrinsics.areEqual(UriProtector.getQueryParameter(r7, "is_single_sku"), "1");
        String r14 = "pass_through";
        JSONArray r15 = k.t(UriProtector.getQueryParameter(r7, "pass_through"));
        JSONArray r11 = new JSONArray();
        String r16 = "";
        if (r15 != null) goto L103;
    L61:
        String r19 = r8;
        String r20 = r14;
    L62:
        JSONObject r9 = c(k.w(UriProtector.getQueryParameter(r7, "client_params")));
        if (r28 != null) goto L101;
    L67:
        if (r29 == null) goto L75;
        r9.put("default_count", r29.longValue());     // Catch: Exception -> L65
    L65:
        e = move-exception;
        String r0 = e.getMessage();
        if (r0 == null) goto L74;
        r16 = r0;
    L74:
        ECExceptionMonitor.c(r16);
    L75:
        o0 r1 = new o0(r27);
        r1.a(r20, Uri.encode(r11.toString()));
        r1.a("client_params", Uri.encode(r9.toString()));
        boolean r10 = false;
        if (StringsKt.startsWith$default(r27, r19, false, 2, null) == false) goto L97;
        if (r13 == false) goto L85;
        String r6 = UriProtector.getQueryParameter(r7, "entrance_info");
        JSONObject r17 = new JSONObject();
        if (r6 == null) goto L83;
        JSONObject r18 = k.w(r6);
        if (r18 == null) goto L83;
        z1.b(r17, r18);
    L83:
        i(r24, r25, r26, r17);
        r1.a("entrance_info", r17.toString());
    L85:
        if (k.c(r32) == false) goto L97;
        String r2 = UriProtector.getQueryParameter(r7, "sku_session_id");
        if (r2 != null) goto L89;
    L90:
        r10 = true;
    L91:
        if (r10 == false) goto L97;
        r1.b("sku_session_id", r32);
        if (r28 == null) goto L95;
        r1.a("default_spec_id", r28.toString());
    L95:
        if (r29 == null) goto L97;
        r1.a("default_count", String.valueOf(r29.longValue()));
        goto L97
    L89:
        if (r2.length() != 0) goto L91;
    L97:
        le3.b.b(r1, r30);
        return r1.c();
    L101:
        r9.put("default_spec_id", r28);     // Catch: Exception -> L65
        goto L67
    L103:
        int r21 = r15.length();     // Catch: Throwable -> L60
        int r110 = 0;
    L5:
        if (r110 >= r21) goto L61;
        int r111 = r21;
        JSONObject r22 = k.w(r15.optString(r110, "{}"));     // Catch: Throwable -> L60
        if (r22 != null) goto L105;
        JSONArray r112 = null;
    L11:
        if (r112 != null) goto L109;
        r11.put(r22);     // Catch: Throwable -> L9
        r19 = r8;
        r20 = r14;
    L59:
        r110 = r110 + 1;
        r21 = r111;
        r15 = r15;
        r8 = r19;
        r14 = r20;
        goto L5
    L109:
        r19 = r8;
        if (r112.length() == 2) goto L112;
        r20 = r14;
    L40:
        boolean r3 = false;
    L42:
        if (r3 == false) goto L50;
        if (r12 == false) goto L47;
        if (r13 == false) goto L47;
        boolean r4 = false;
    L48:
        if (r4 == true) goto L110;
    L58:
        r11.put(r22);     // Catch: Throwable -> L99
        goto L59
    L110:
        JSONObject r5 = c(k.w(r22.optString("data", "{}")));     // Catch: Throwable -> L99
        i(r24, r25, r26, r5);     // Catch: Throwable -> L99
        r22.put("data", r5.toString());     // Catch: Throwable -> L99
    L47:
        r4 = true;
        goto L48
    L50:
        if (r31 == false) goto L58;
        if (r112.length() != 1) goto L58;
        if (Intrinsics.areEqual(r112.optString(0), "api.add.extra") == false) goto L58;
        JSONObject r23 = k.w(r22.optString("data", "{}"));     // Catch: Throwable -> L99
        if (r23 == null) goto L58;
        JSONObject r113 = new JSONObject();     // Catch: Throwable -> L99
        i(r24, r25, r26, r113);     // Catch: Throwable -> L99
        r23.put("cart_track", r113.toString());     // Catch: Throwable -> L99
        r22.put("data", r23.toString());     // Catch: Throwable -> L99
        goto L58
    L112:
        List r33 = CollectionsKt.mutableListOf(new String[]{"track.client.entrance_info", "api.sku.entrance_info"});     // Catch: Throwable -> L100 Exception -> L32
        int r34 = r112.length();     // Catch: Throwable -> L100 Exception -> L32
        r20 = r14;
        int r114 = 0;
    L20:
        if (r114 >= r34) goto L29;
        int r210 = r34;
        List r211 = r33;
        if ((!Intrinsics.areEqual(r112.optString(r114), (String) CollectionsKt.getOrNull(r33, r114))) == true) goto L40;
        r114 = r114 + 1;
        r34 = r210;
        r33 = r211;
    L27:
        e = e;
    L36:
        String r35 = e.getMessage();     // Catch: Throwable -> L99
        if (r35 != null) goto L39;
        r35 = "";
    L39:
        ECExceptionMonitor.c(r35);     // Catch: Throwable -> L99
        goto L40
    L29:
        r3 = true;
        goto L42
    L32:
        e = e;
    L33:
        r20 = r14;
    L30:
        r20 = r14;
        goto L62
    L34:
        e = e;
        r19 = r8;
        goto L33
    L105:
        r112 = r22.optJSONArray("to");     // Catch: Throwable -> L9
    L60:
        r19 = r8;
        goto L30
    }
}
