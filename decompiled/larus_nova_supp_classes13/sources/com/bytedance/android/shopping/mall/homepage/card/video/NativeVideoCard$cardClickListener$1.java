package com.bytedance.android.shopping.mall.homepage.card.video;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.tools.TransitionAnimationHelper;
import com.bytedance.android.ec.hybrid.ui.ECMediaType;
import com.bytedance.android.ec.hybrid.ui.IHybridVideoBoxView;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.homepage.card.video.VideoCardData;
import com.bytedance.android.shopping.api.mall.common.tools.k;
import com.bytedance.android.shopping.mall.homepage.card.live.o;
import com.bytedance.android.shopping.mall.homepage.jsb.q;
import com.bytedance.android.shopping.mall.homepage.tools.c0;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import yj.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class NativeVideoCard$cardClickListener$1 implements View.OnClickListener {
    public final /* synthetic */ NativeVideoCard a;
    public final /* synthetic */ View b;

    public NativeVideoCard$cardClickListener$1(NativeVideoCard r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r15) {
        int r16 = q.a;
        NativeVideoCard r17 = this.a;
        String r0 = r17.r;
        VideoCardData r18 = r17.O;
        if (r18 == null) goto L7;
        VideoCardData.Video r19 = r18.getVideo();
        if (r19 == null) goto L7;
        String r110 = r19.getId();
    L8:
        ECHybridListItemVO r2 = ((BaseViewHolder) this.a).c;
        if (r2 == null) goto L11;
        String r3 = r2.d;
    L12:
        q.a(r0, r110, r3);
        VideoCardData r111 = this.a.O;
        if (r111 == null) goto L16;
        String r112 = r111.getBtmCD();
        if (r112 == null) goto L16;
    L17:
        String r113 = r112 + "_i" + (ToolsKt.g(this.a) + 1);
        g.e(this.a, r113);
        Map<String, Object> r1 = c0.a;
        ECHybridListItemVO r4 = ((BaseViewHolder) this.a).c;
        if (r4 == null) goto L23;
        ECNAMallCardExtra r5 = r4.c();
        if (r5 == null) goto L23;
        Map r6 = r5.getSchemaMap();
        if (r6 == null) goto L23;
    L24:
        String r7 = c0.a(r6, false, ToolsKt.g(this.a), new NativeVideoCard$cardClickListener$1$schema$1(this));
        JsonObject r8 = new JsonObject();
        Object r9 = ToolsKt.k(this.a).get(SimilarProductParam.ENTER_FROM);
        if ((r9 instanceof String) == true) goto L27;
        r9 = null;
    L27:
        String r10 = (String) r9;
        String r11 = "";
        if (r10 != null) goto L30;
        r10 = "";
    L30:
        r8.addProperty(SimilarProductParam.ENTER_FROM, r10);
        r8.toString();
        com.bytedance.android.shopping.api.mall.common.tools.h.b.getIHybridHostECSchemaMonitorService();
        if (BtmSDK.INSTANCE.useV2Api() == false) goto L40;
        Map r12 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "video")});
        ECHybridListItemVO r13 = ((BaseViewHolder) this.a).c;
        if (r13 == null) goto L39;
        ECNAMallCardExtra r14 = r13.c();
        if (r14 == null) goto L39;
        Map r20 = r14.getBcmData();
        if (r20 == null) goto L39;
        r12.putAll(r20);
    L39:
        int r21 = com.bytedance.android.shopping.api.mall.common.tools.b.a;
        r7 = com.bytedance.android.shopping.api.mall.common.tools.b.a(r7, MapsKt.mapOf(new Pair[]{TuplesKt.to("btm", r113), TuplesKt.to("bcm", r12)}), PageFinder.via(this.b), this.b.getContext(), false);
    L41:
        Map r114 = MapsKt.mapOf(new Pair[]{TuplesKt.to("ec_jump_tag", "ec_mall_video"), TuplesKt.to("ec_click_jump_time", String.valueOf(System.currentTimeMillis()))});
        Intrinsics.checkNotNullParameter(r7, "$this$addOrReplaceQueryParameter");
        if (r114 != null) goto L126;
    L62:
        NativeVideoCard.y4(this.a);
        NativeVideoCard r115 = this.a;
        if (r115.Q != null) goto L65;
    L67:
        Function0<Boolean> r116 = r115.Q1;
        if (r116 != null) goto L70;
    L72:
        boolean r117 = false;
    L74:
        if (((Number) this.a.P0.getValue()).intValue() > 0) goto L76;
    L92:
        SimpleDraweeView r118 = null;
        boolean r22 = false;
    L93:
        NativeVideoCard r23 = this.a;
        IHybridVideoBoxView r24 = r23.Q;
        if (r24 == null) goto L99;
        if (r23.h1 == false) goto L99;
        MapsKt.hashMapOf(new Pair[]{TuplesKt.to("schema", r7)});
        r24.b();
    L119:
        NativeVideoCard r119 = this.a;
        if (r119.S == false) goto L122;
        o.a(r119, null, r119.O, 5);
    L122:
        ToolsKt.v(this.a, r7, "go_video_inner");
        NativeVideoCard r120 = this.a;
        String r25 = r120.y1;
        if (r25 == null) goto L135;
        Intrinsics.checkNotNullParameter(r120, "$this$onPageOpenSchema");
        Intrinsics.checkNotNullParameter(r25, "pageName");
        Intrinsics.checkNotNullParameter("go_video_inner", "scene");
        return;
    L135:
        return;
    L99:
        if (((Boolean) r23.Z.getValue()).booleanValue() == false) goto L118;
        String r26 = (String) this.a.k0.getValue();
        String r27 = this.a.y1;
        if (r27 == null) goto L105;
        r11 = r27;
    L105:
        if (StringsKt.contains$default(r26, r11, false, 2, null) == true) goto L118;
        com.bytedance.android.shopping.api.mall.common.tools.h r28 = com.bytedance.android.shopping.api.mall.common.tools.h.b;
        if (r28.getHybridLynxHostService() == null) goto L118;
        t r29 = r28.getHybridLynxHostService();
        if (r29 == null) goto L119;
        HashMap r30 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("schema", r7)});
        if (r118 != null) goto L113;
        r118 = this.a.F4();
    L113:
        Gson r31 = new Gson();
        VideoCardData r32 = this.a.O;
        if (r32 == null) goto L116;
        VideoCardData.Video r33 = r32.getVideo();
    L117:
        r29.videoEnterDetailByCover(r30, r118, GsonProtectorUtils.toJson(r31, r33), r22);
        goto L119
    L116:
        r33 = null;
    L118:
        k.b.d(this.b.getContext(), r7, null);
        goto L119
    L76:
        if (((String) this.a.V0.getValue()).length() <= 0) goto L78;
        boolean r34 = true;
    L79:
        if (r34 == false) goto L92;
        String r35 = this.a.y1;
        if (r35 != null) goto L83;
    L86:
        boolean r36 = true;
    L87:
        if (r36 == true) goto L92;
        if (StringsKt.contains$default((String) this.a.V0.getValue(), this.a.y1, false, 2, null) == false) goto L92;
        if (r117 == true) goto L92;
        Lazy r121 = TransitionAnimationHelper.a;
        TransitionAnimationHelper.d(this.a.E4(), "video");
        TransitionAnimationHelper.b(ECMediaType.VIDEO.getType(), false);
        r118 = this.a.E4();
        r22 = true;
        goto L93
    L83:
        if (r35.length() == 0) goto L86;
        r36 = false;
        goto L87
    L78:
        r34 = false;
        goto L79
    L70:
        if (((Boolean) r116.invoke()).booleanValue() != true) goto L72;
        r117 = true;
        goto L74
    L65:
        if (r115.h1 == false) goto L67;
        r115.X = true;
        goto L67
    L126:
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L60
        Uri r38 = UriProtector.parse(r7);     // Catch: Throwable -> L60
        Set r39 = r114.keySet();     // Catch: Throwable -> L60
        Set r40 = UriProtector.getQueryParameterNames(r38);     // Catch: Throwable -> L60
        Uri.Builder r122 = r38.buildUpon().clearQuery();     // Catch: Throwable -> L60
        ArrayList r123 = new ArrayList();     // Catch: Throwable -> L60
        Iterator r41 = r40.iterator();     // Catch: Throwable -> L60
    L46:
        if (r41.hasNext() == false) goto L50;
        Object r124 = r41.next();     // Catch: Throwable -> L60
        if ((!r39.contains((String) r124)) == false) goto L46;
        r123.add(r124);     // Catch: Throwable -> L60
        goto L46
    L50:
        Iterator r42 = r123.iterator();     // Catch: Throwable -> L60
    L52:
        if (r42.hasNext() == false) goto L54;
        String r43 = (String) r42.next();     // Catch: Throwable -> L60
        r122.appendQueryParameter(r43, UriProtector.getQueryParameter(r38, r43));     // Catch: Throwable -> L60
        goto L52
    L54:
        Iterator r125 = r114.entrySet().iterator();     // Catch: Throwable -> L60
    L56:
        if (r125.hasNext() == false) goto L58;
        Map.Entry r44 = (Map.Entry) r125.next();     // Catch: Throwable -> L60
        r122.appendQueryParameter((String) r44.getKey(), (String) r44.getValue());     // Catch: Throwable -> L60
        goto L56
    L58:
        r7 = r122.build().toString();     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L62
    L40:
        ToolsKt.z(this.a, this.b, r113, new JSONObject().put("type", "video"));
    L23:
        r6 = MapsKt.emptyMap();
    L16:
        r112 = "c9582.d3197";
        goto L17
    L11:
        r3 = null;
    L7:
        r110 = null;
        goto L8
    }
}
