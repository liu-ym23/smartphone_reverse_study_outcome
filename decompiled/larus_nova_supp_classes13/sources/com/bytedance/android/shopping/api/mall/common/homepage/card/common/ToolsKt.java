package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.hybrid.list.ability.v;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.n;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.mall.homepage.card.AbstractNativeCard;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ToolsKt {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(ToolsKt$systemWidthPixelsEnable$2.INSTANCE);
        b = LazyKt.lazy(ToolsKt$isLargeDevice$2.INSTANCE);
    }

    public static final void D(SimpleDraweeView r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$startAnimation");
        DraweeController r2 = r1.getController();
        if (r2 == null) goto L13;
        Animatable r3 = r2.getAnimatable();
        if (r3 != null) goto L7;
        return;
    L7:
        if ((!r3.isRunning()) == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L15;
        r3.start();
        return;
    L15:
        return;
    }

    public static final void E(SimpleDraweeView r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$stopAnimation");
        DraweeController r2 = r1.getController();
        if (r2 == null) goto L13;
        Animatable r3 = r2.getAnimatable();
        if (r3 != null) goto L7;
        return;
    L7:
        if (r3.isRunning() == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L15;
        r3.stop();
        return;
    L15:
        return;
    }

    public static final void b(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$cancelAccessibility");
        r1.setImportantForAccessibility(2);
    }

    public static final String f(BaseViewHolder r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$getEnterFrom");
        Object r2 = i(k(r1), SimilarProductParam.ENTER_FROM);
        if ((r2 instanceof String) == true) goto L5;
        r2 = null;
    L5:
        String r3 = (String) r2;
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3;
    }

    public static final int g(BaseViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getIndex");
        com.bytedance.android.ec.hybrid.list.ability.a r0 = r2.b;
        if (r0 == null) goto L7;
        v r1 = (v) r0.getAbility(v.class);
        if (r1 == null) goto L7;
        return r1.Qc(r2.getAdapterPosition());
    L7:
        return -1;
    }

    public static final String j(BaseViewHolder r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$getPageName");
        Object r2 = i(k(r1), PdpOpenThirdParam.KEY_PAGE_NAME);
        if ((r2 instanceof String) == true) goto L5;
        r2 = null;
    L5:
        String r3 = (String) r2;
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3;
    }

    public static final Map<String, Object> k(BaseViewHolder r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$getQueryMap");
        com.bytedance.android.ec.hybrid.list.ability.a r2 = r1.b;
        if (r2 == null) goto L9;
        k93.e r3 = (k93.e) r2.getAbility(k93.e.class);
        if (r3 == null) goto L9;
        Map<String, Object> r4 = r3.a();
        if (r4 == null) goto L9;
        return r4;
    L9:
        return new LinkedHashMap();
    }

    public static final String l(BaseViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getRequestId");
        ECHybridListItemVO r3 = r2.c;
        Object r0 = null;
        if (r3 == null) goto L9;
        n r4 = r3.o;
        if (r4 == null) goto L9;
        HashMap r5 = r4.b;
        if (r5 == null) goto L9;
        Object r6 = i(r5, "request_id");
    L11:
        if ((r6 instanceof String) == false) goto L14;
        r0 = r6;
    L14:
        String r1 = (String) r0;
        if (r1 != null) goto L18;
        return "";
    L18:
        return r1;
    L9:
        r6 = null;
        goto L11
    }

    public static final String m(BaseViewHolder r7) {
        Intrinsics.checkNotNullParameter(r7, "$this$getSceneId");
        Lazy r0 = HybridAppInfoService.a;
        boolean r1 = true;
        Object r3 = null;
        if (HybridAppInfoService.i() == false) goto L17;
        Intrinsics.checkNotNullParameter(r7, "$this$awemeEcSceneId");
        com.bytedance.android.ec.hybrid.list.ability.a r2 = r7.b;
        if (r2 == null) goto L9;
        k93.c r4 = (k93.c) r2.getAbility(k93.c.class);
        if (r4 == null) goto L9;
        String r5 = r4.a();
    L10:
        if (r5 == null) goto L17;
        if (r5.length() <= 0) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == false) goto L17;
        return r5;
    L14:
        r6 = false;
    L9:
        r5 = null;
    L17:
        Map<String, Object> r8 = k(r7);
        String r9 = "";
        if (r8.containsKey("cachedSceneId") == false) goto L28;
        Object r10 = r8.get("cachedSceneId");
        if ((r10 instanceof String) == false) goto L23;
        r3 = r10;
    L23:
        String r11 = (String) r3;
        if (r11 != null) goto L27;
        return "";
    L27:
        return r11;
    L28:
        Intrinsics.checkNotNullParameter(r7, "$this$getEntranceInfo");
        Object r12 = i(k(r7), "entrance_info");
        if ((r12 instanceof String) == true) goto L31;
        r12 = null;
    L31:
        String r13 = (String) r12;
        if (r13 != null) goto L34;
        r13 = "";
    L34:
        int r14 = a.a;
        if (r13.length() == 0) goto L38;
        r1 = false;
    L38:
        if (r1 == false) goto L67;
        String r15 = a.a("");
    L61:
        Map r16 = MapsKt.mapOf(TuplesKt.to("cachedSceneId", r15));
        Intrinsics.checkNotNullParameter(r7, "$this$updateQueryMap");
        Intrinsics.checkNotNullParameter(r16, "insertKeyValues");
        com.bytedance.android.ec.hybrid.list.ability.a r17 = r7.b;
        if (r17 == null) goto L66;
        k93.h r18 = (k93.h) r17.getAbility(k93.h.class);
        if (r18 == null) goto L66;
        r18.a(r16);
    L66:
        return r15;
    L67:
        HashMap r19 = (HashMap) new Gson().fromJson(r13, HashMap.class);     // Catch: Throwable -> L42
    L47:
        if (r19 != null) goto L50;
        r15 = a.a("");
        goto L61
    L50:
        if (r19.containsKey("ecom_scene_id") == false) goto L60;
        Object r20 = r19.get("ecom_scene_id");
        if ((r20 instanceof String) == false) goto L55;
        r3 = r20;
    L55:
        String r21 = (String) r3;
        if (r21 == null) goto L59;
        r9 = r21;
    L59:
        r15 = a.a(r9);
        goto L61
    L60:
        r15 = a.a("");
    L42:
        th = move-exception;
        String r22 = th.getMessage();
        if (r22 != null) goto L46;
        r22 = "none";
    L46:
        Logger.d("puffone-CardSchemaUtils.getEcomSceneId", r22);
        r19 = null;
        goto L47
    }

    public static final int o(Context r2) {
        Resources r0 = Resources.getSystem();
        if (WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density <= 0) goto L6;
        float r3 = p(r2);
        Resources r1 = Resources.getSystem();
        return (int) ((r3 / WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density) + 0.5f);
    L6:
        return -1;
    }

    public static final int p(Context r1) {
        if (((Boolean) a.getValue()).booleanValue() == false) goto L7;
        Resources r2 = Resources.getSystem();
        return WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).widthPixels;
    L7:
        return UIUtils.getScreenWidth(r1);
    }

    public static final int q(BaseViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getSection");
        com.bytedance.android.ec.hybrid.list.ability.a r0 = r2.b;
        if (r0 == null) goto L7;
        v r1 = (v) r0.getAbility(v.class);
        if (r1 == null) goto L7;
        return r1.E90(r2.getAdapterPosition());
    L7:
        return -1;
    }

    public static final String r(BaseViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getTabId");
        ECHybridListItemVO r3 = r2.c;
        Object r0 = null;
        if (r3 == null) goto L9;
        n r4 = r3.o;
        if (r4 == null) goto L9;
        HashMap r5 = r4.b;
        if (r5 == null) goto L9;
        Object r6 = i(r5, "tab_id");
    L11:
        if ((r6 instanceof String) == false) goto L14;
        r0 = r6;
    L14:
        String r1 = (String) r0;
        if (r1 != null) goto L18;
        return "";
    L18:
        return r1;
    L9:
        r6 = null;
        goto L11
    }

    public static final String s(BaseViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getTabName");
        ECHybridListItemVO r3 = r2.c;
        Object r0 = null;
        if (r3 == null) goto L9;
        n r4 = r3.o;
        if (r4 == null) goto L9;
        HashMap r5 = r4.b;
        if (r5 == null) goto L9;
        Object r6 = i(r5, "tab_name");
    L11:
        if ((r6 instanceof String) == false) goto L14;
        r0 = r6;
    L14:
        String r1 = (String) r0;
        if (r1 != null) goto L18;
        return "";
    L18:
        return r1;
    L9:
        r6 = null;
        goto L11
    }

    public static final void B(View r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$setDimensionRatio");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof ConstraintLayout.LayoutParams) == true) goto L5;
        r0 = null;
    L5:
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        if ((!Intrinsics.areEqual(r1.dimensionRatio, r3)) == false) goto L12;
        r1.dimensionRatio = r3;
        r2.requestLayout();
        return;
    }

    public static final void C(Map<String, Object> r2, ECHybridListItemVO r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        if (r3 != null) goto L5;
        return;
    L5:
        n r4 = r3.o;
        if (r4 == null) goto L13;
        HashMap r5 = r4.b;
        if (r5 == null) goto L15;
        Iterator r6 = r5.entrySet().iterator();
    L11:
        if (r6.hasNext() == false) goto L16;
        Map.Entry r0 = (Map.Entry) r6.next();
        r2.put((String) r0.getKey(), r0.getValue());
        goto L11
    L16:
        return;
    L15:
        return;
    }

    public static final void F(ECGradientView r4, CommonModel$CommonColorStyle r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$updateColor");
        Intrinsics.checkNotNullParameter(r5, "maskStyle");
        String r0 = r5.getColorFrom();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L35;
        String r3 = r5.getColorTo();
        if (r3 != null) goto L14;
    L17:
        if (r1 == false) goto L35;
        r4.setVisibility(8);
        return;
    L14:
        if (r3.length() == 0) goto L17;
        r1 = false;
    L35:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L32
        r4.setVisibility(8);     // Catch: Throwable -> L32
        String r7 = r5.getColorFrom();     // Catch: Throwable -> L32
        String r8 = r5.getColorTo();     // Catch: Throwable -> L32
        if (r7 == null) goto L24;
        if (r8 == null) goto L24;
        r4.a(Color.parseColor(r7), Color.parseColor(r8));     // Catch: Throwable -> L32
        return;
    L24:
        int r9 = com.bytedance.forest.utils.h.a;     // Catch: Throwable -> L32
        if (com.bytedance.forest.utils.h.a(r5.getColorFrom()) == false) goto L28;
        int r10 = Color.parseColor(r5.getColorFrom());     // Catch: Throwable -> L32
        r4.a(r10, r10);     // Catch: Throwable -> L32
    L30:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L32
        return;
    L28:
        if (com.bytedance.forest.utils.h.a(r5.getColorTo()) == false) goto L30;
        int r11 = Color.parseColor(r5.getColorTo());     // Catch: Throwable -> L32
        r4.a(r11, r11);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    public static final String H(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$windVaneParamsFillRC");
        Intrinsics.checkNotNullParameter(r3, "recommendInfo");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
        JSONObject r4 = new JSONObject(r2);     // Catch: Throwable -> L15
        String r5 = r4.optString("recommend_info");     // Catch: Throwable -> L15
        if (r5 != null) goto L7;
    L10:
        boolean r6 = true;
    L11:
        if (r6 == false) goto L13;
        r4.putOpt("recommend_info", r3);     // Catch: Throwable -> L15
    L13:
        return r4.toString();
    L7:
        if (r5.length() == 0) goto L10;
        r6 = false;
    L15:
        th = move-exception;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L18
        Result.constructor-impl(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(th))));     // Catch: Throwable -> L18
        return null;
    L18:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    }

    public static final void a(SimpleDraweeView r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$bottomRadius");
        RoundingParams r0 = r2.getHierarchy().getRoundingParams();
        if (r0 != null) goto L5;
        r0 = new RoundingParams();
    L5:
        r0.setCornersRadii(0.0f, 0.0f, r3, r3);
        r2.getHierarchy().setRoundingParams(r0);
    }

    public static final Map<String, Object> c(BaseViewHolder r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$constructWindVaneExtra");
        Pair[] r0 = new Pair[3];
        r0[0] = TuplesKt.to("cardOffset", Integer.valueOf(r3));
        ECHybridListItemVO r4 = r2.c;
        if (r4 == null) goto L6;
        String r5 = r4.d;
        if (r5 == null) goto L6;
    L7:
        r0[1] = TuplesKt.to("itemId", r5);
        r0[2] = TuplesKt.to("index", Integer.valueOf(g(r2)));
        return MapsKt.mutableMapOf(r0);
    L6:
        r5 = "";
        goto L7
    }

    public static final PipelineDraweeControllerBuilder e(SimpleDraweeView r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r2, "url");
        f r0 = new f(r1);
        return Fresco.newDraweeControllerBuilder().setControllerListener(r0).setUri(r2);
    }

    public static final String h(BaseViewHolder r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$getInsertCardPreviousPage");
        StringBuilder r0 = new StringBuilder();
        Intrinsics.checkNotNullParameter(r2, "$this$getPreviousPage");
        r0.append(f(r2));
        r0.append(".");
        r0.append(j(r2));
        r0.append(".moduleinsert_card.component");
        r0.append(r3);
        return r0.toString();
    }

    public static final Object i(Map r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$getOrDefaultValue");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter("", "default");
        if (r2.containsKey(r3) == false) goto L9;
        Object r4 = r2.get(r3);
        if (r4 != null) goto L8;
        return "";
    L8:
        return r4;
    L9:
        return "";
    }

    public static final String n(String r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r4, "scheme");
        if (StringsKt.contains$default(r4, "thread_strategy", false, 2, null) == false) goto L5;
        return r4;
    L5:
        if (r5 != null) goto L7;
        return r4;
    L7:
        if (r5.intValue() > 0) goto L9;
        return r4;
    L9:
        if (com.bytedance.forest.utils.h.a(r4) == true) goto L11;
        return r4;
    L11:
        if (StringsKt.endsWith$default(r4, "&", false, 2, null) == false) goto L14;
        return "{" + r4 + "}thread_strategy=" + r5;
    L14:
        return r4 + "&thread_strategy=" + r5;
    }

    public static final String u(String r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r11, "query");
        if (r10.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return "";
    L9:
        StringBuilder r1 = new StringBuilder(r10);
        if (r1.indexOf("?") != (-1)) goto L12;
        r1.append("?");
    L13:
        ArrayList r2 = new ArrayList(r11.size());
        Iterator r12 = ((LinkedHashMap) r11).entrySet().iterator();
    L15:
        if (r12.hasNext() == false) goto L17;
        Map.Entry r13 = (Map.Entry) r12.next();
        r2.add(((String) r13.getKey()) + '=' + r13.getValue());
        goto L15
    L17:
        r1.append(CollectionsKt.joinToString$default(r2, "&", null, null, 0, null, null, 62, null));
        return r1.toString();
    L12:
        r1.append("&");
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public static final void w(TextView r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$safeSetViewColor");
        if (r5 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        if (StringsKt.startsWith$default(r5, "#", false, 2, null) == false) goto L25;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        r4.setTextColor(Color.parseColor(r5));     // Catch: Throwable -> L15
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L24;
        EnsureManager.ensureNotReachHere(r7);
        return;
    L24:
        return;
    L15:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L25:
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static final void y(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$setAccessibility");
        Intrinsics.checkNotNullParameter(r2, "contentDescription");
        r1.setImportantForAccessibility(1);
        r1.setFocusable(true);
        r1.setContentDescription(r2);
    }

    public static final CommonModel$Price t(long r13, Long r15, String r16) {
        if (r13 < 1000000) goto L8;
        String r7 = String.valueOf(r13 / 1000000);
        long r5 = (r13 % 1000000) / 100000;
        String r8 = "万";
        if (r5 == 0) goto L7;
        String r6 = "." + r5;
    L19:
        if (r15 != null) goto L21;
    L27:
        String r9 = "";
    L29:
        if (TextUtils.isEmpty(r16) == true) goto L31;
        String r10 = r16;
    L33:
        return new CommonModel$Price("¥", r7, r6, r8, r9, r10);
    L31:
        r10 = "";
        goto L33
    L21:
        if (r15.longValue() == 0) goto L27;
        if (r15.longValue() == r13) goto L27;
        if ((r7.length() + r6.length()) > 5) goto L27;
        r9 = "起";
        goto L29
    L7:
        r6 = "";
        goto L19
    L8:
        r7 = String.valueOf(r13 / 100);
        long r11 = r13 % 100;
        if (r11 != 0) goto L11;
        r6 = "";
        r8 = r6;
        goto L19
    L11:
        if (r11 >= 10) goto L13;
        String r0 = ".0" + r11;
    L17:
        r6 = r0;
        r8 = "";
        goto L19
    L13:
        if ((r11 % 10) != 0) goto L15;
        r11 = r11 / 10;
    L15:
        r0 = "." + r11;
        goto L17
    }

    public static final void v(AbstractNativeCard r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$reportSchemaDiff");
        Intrinsics.checkNotNullParameter(r3, "schema");
        Intrinsics.checkNotNullParameter(r4, "scene");
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        com.bytedance.android.ec.hybrid.a.d().submit(new j(r2, r3, r4));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static final int d(Number r1, Context r2, boolean r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r1, "$this$dp2btpxV2");
        boolean r0 = true;
        if (r3 == false) goto L16;
        if (r4 != null) goto L6;
    L14:
        int r5 = p(r2);
    L18:
        return Math.round((r1.floatValue() * r5) / 375);
    L6:
        if (r4.intValue() > 0) goto L9;
        r0 = false;
    L9:
        if (r0 == true) goto L12;
        r4 = null;
    L12:
        if (r4 == null) goto L14;
        r5 = r4.intValue();
        goto L18
    L16:
        int r6 = com.bytedance.android.ec.hybrid.list.util.c.a;
        return com.bytedance.android.ec.hybrid.list.util.c.c(r1, r2, true);
    }

    public static final void z(BaseViewHolder r2, View r3, String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r2, "$this$setBtmBeforeOpen");
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r4, "btm");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("btm", r4);
        r1.put("bcm", r5);
        int r6 = f93.a.a;
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        f93.a.b(r1, PageFinder.via(r3), true);
    }

    public static final void x(BaseViewHolder r3, String r4, String r5, Map<String, ? extends Object> r6, JSONObject r7) {
        Intrinsics.checkNotNullParameter(r3, "$this$sendLog");
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r6, "params");
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("eventName", r4);
        if (r5 != null) goto L5;
    L8:
        boolean r8 = true;
    L9:
        if (r8 == true) goto L11;
        r2.put("btm", r5);
    L11:
        if (r7 == null) goto L13;
        r2.put("bcm", r7);
    L13:
        r2.put("params", r6);
        com.bytedance.android.ec.hybrid.list.ability.a r9 = r3.b;
        if (r9 == null) goto L19;
        k93.g r10 = (k93.g) r9.getAbility(k93.g.class);
        if (r10 == null) goto L20;
        k93.g.a.a(r10, r2, null, null, 14);
        return;
    L20:
        return;
    L19:
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r8 = false;
        goto L9
    }

    public static final boolean G(View r0, float r1, Integer r2, Integer r3, MutablePropertyReference0Impl r4, boolean r5, boolean r6, Integer r7) {
        if (r2 == null) goto L15;
        r2.intValue();
        if (r3 == null) goto L6;
        int r8 = r3.intValue();
    L7:
        float r9 = r8 * r1;
        if (r6 == false) goto L10;
        int r10 = d(Float.valueOf(r9), r0.getContext(), true, r7);
    L12:
        if (r10 == ((Number) r4.get()).intValue()) goto L15;
        r4.set(Integer.valueOf(r10));
        return true;
    L10:
        r10 = (int) r9;
        goto L12
    L6:
        r8 = r2.intValue();
    L15:
        return r5;
    }

    public static void A(View r16, float r17, CommonModel$LayoutStyle r18, Integer r19, Integer r20, Integer r21, Integer r22, Integer r23, Integer r24, boolean r25, Integer r26, int r27) {
        if ((r27 & 1) == 0) goto L5;
        float r1 = 1.0f;
    L7:
        if ((r27 & 2) == 0) goto L9;
        CommonModel$LayoutStyle r2 = null;
    L11:
        if ((r27 & 4) == 0) goto L13;
        Integer r4 = null;
    L15:
        if ((r27 & 8) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r27 & 16) == 0) goto L21;
        Integer r6 = null;
    L23:
        if ((r27 & 32) == 0) goto L25;
        Integer r7 = null;
    L27:
        if ((r27 & 64) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r27 & 128) == 0) goto L33;
        Integer r9 = null;
    L35:
        if ((r27 & 256) == 0) goto L37;
        boolean r10 = false;
    L39:
        if ((r27 & 512) == 0) goto L41;
        Integer r0 = null;
    L42:
        Intrinsics.checkNotNullParameter(r16, "$this$setCusScale");
        ViewGroup.LayoutParams r11 = r16.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == true) goto L45;
        r11 = null;
    L45:
        final ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        if (r12 != null) goto L48;
        return;
    L48:
        if (r2 == null) goto L50;
        Integer r14 = r2.getWidth();
    L51:
        boolean r13 = G(r16, r1, r4, r14, new ToolsKt$setCusScale$1$1(r12), false, r10, r0);
        if (r2 == null) goto L54;
        Integer r15 = r2.getHeight();
    L55:
        boolean r28 = G(r16, r1, r5, r15, new ToolsKt$setCusScale$1$2(r12), r13, r10, r0);
        if (r2 == null) goto L58;
        Integer r29 = r2.getLeft();
    L59:
        boolean r30 = G(r16, r1, r6, r29, new ToolsKt$setCusScale$1$3(r12), r28, r10, r0);
        if (r2 == null) goto L62;
        Integer r31 = r2.getTop();
    L63:
        boolean r32 = G(r16, r1, r7, r31, new ToolsKt$setCusScale$1$4(r12), r30, r10, r0);
        if (r2 == null) goto L66;
        Integer r33 = r2.getRight();
    L67:
        boolean r34 = G(r16, r1, r8, r33, new ToolsKt$setCusScale$1$5(r12), r32, r10, r0);
        if (r2 == null) goto L70;
        Integer r3 = r2.getBottom();
    L72:
        if (G(r16, r1, r9, r3, new ToolsKt$setCusScale$1$6(r12), r34, r10, r0) == false) goto L76;
        r16.requestLayout();
        return;
    L76:
        return;
    L70:
        r3 = null;
        goto L72
    L66:
        r33 = null;
        goto L67
    L62:
        r31 = null;
        goto L63
    L58:
        r29 = null;
        goto L59
    L54:
        r15 = null;
        goto L55
    L50:
        r14 = null;
        goto L51
    L41:
        r0 = r26;
        goto L42
    L37:
        r10 = r25;
        goto L39
    L33:
        r9 = r24;
        goto L35
    L29:
        r8 = r23;
        goto L31
    L25:
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r2 = r18;
        goto L11
    L5:
        r1 = r17;
        goto L7
    }
}
