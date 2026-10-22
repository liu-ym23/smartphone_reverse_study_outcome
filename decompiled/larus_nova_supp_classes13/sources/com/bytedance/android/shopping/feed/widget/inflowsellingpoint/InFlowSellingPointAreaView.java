package com.bytedance.android.shopping.feed.widget.inflowsellingpoint;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.ProductLeaderBoardEntryStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductAuthorEntriesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductLogisticsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesFirstAreaStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesTextConfigStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductServiceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.SellingPointInfoStruct;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.extensions.b;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.feed.view.c;
import com.bytedance.android.shopping.inflow.view.InFlowRankLayout;
import com.bytedance.android.shopping.inflow.view.InflowAnchorV3LogisticsLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import ld3.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u0004¢\u0006\u0004\b!\u0010\"J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\"\u0010\u001b\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/inflowsellingpoint/InFlowSellingPointAreaView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/feed/view/c;", "", "", "getDefaultColor", "Landroid/view/View;", "getSeparatorView", "maxWidth", "", "setViewMaxWidth", "color", "setContentColor", "", "size", "setSellTextSize", "weight", "setSellTextStyle", "", "isBold", "setLogisticsTextViewBold", "a", "Z", "getShowMoreService", "()Z", "setShowMoreService", "(Z)V", "showMoreService", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFlowSellingPointAreaView extends LinearLayout implements c {
    public boolean a;
    public boolean b;
    public int c;
    public int d;
    public Float e;
    public int f;
    public boolean g;

    public static final class a {
    }

    static {
    }

    public InFlowSellingPointAreaView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InFlowSellingPointAreaView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.view.c
    public final void a() {
    }

    private final int getDefaultColor() {
        if (this.d == 0) goto L5;
        int r0 = g1.a;
        return g1.a.a(getContext(), this.d);
    L5:
        int r1 = g1.a;
        return g1.a.a(getContext(), 2131101191);
    }

    private final View getSeparatorView() {
        View r0 = new View(getContext());
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, (float) 0.5d, b(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, 10, b(Resources.getSystem()))));
        r1.gravity = 16;
        Unit r2 = Unit.INSTANCE;
        r0.setLayoutParams(r1);
        float r3 = 6;
        wg.a.f(r0, MathKt.roundToInt(TypedValue.applyDimension(1, r3, b(Resources.getSystem()))), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r3, b(Resources.getSystem()))), 0);
        r0.setBackgroundColor(getDefaultColor());
        return r0;
    }

    public final boolean getShowMoreService() {
        return this.a;
    }

    public static DisplayMetrics b(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public void setContentColor(int r1) {
        this.d = r1;
    }

    public void setLogisticsTextViewBold(boolean r1) {
        this.g = r1;
    }

    public void setSellTextSize(float r1) {
        this.e = Float.valueOf(r1);
    }

    public void setSellTextStyle(int r1) {
        this.f = r1;
    }

    public final void setShowMoreService(boolean r1) {
        this.a = r1;
    }

    public void setViewMaxWidth(int r3) {
        if (this.c != (-1)) goto L5;
    L8:
        this.c = r3;
        return;
    L5:
        if (ld3.c.h() == false) goto L8;
        r3 = Math.min(this.c, r3);
        goto L8
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r13, int r14) {
        super.onMeasure(r13, r14);
        if (getChildCount() > 0) goto L5;
    L7:
        int r0 = this.c;
        if (r0 != (-1)) goto L11;
        r0 = k1.m(getContext()) - b.a(24);
    L11:
        Iterator r4 = com.bytedance.commerce.base.view.b.a(this).iterator();
        int r6 = 0;
        int r7 = 0;
    L13:
        if (r4.hasNext() == false) goto L33;
        View r8 = (View) r4.next();
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == true) goto L17;
        r9 = null;
    L17:
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r9;
        measureChild(r8, r13, r14);
        int r11 = r8.getMeasuredWidth();
        if (r10 == null) goto L20;
        int r12 = r10.leftMargin;
    L21:
        int r15 = r11 + r12;
        if (r10 == null) goto L24;
        int r16 = r10.rightMargin;
    L25:
        r6 = r6 + (r15 + r16);
        if (r6 <= r0) goto L32;
        r8.setVisibility(8);
        if (r7 <= 1) goto L32;
        int r17 = r7 - 1;
        if (Intrinsics.areEqual(((View) ListProtector.get(com.bytedance.commerce.base.view.b.a(this), r17)).getTag(), "dot") == false) goto L32;
        ((View) ListProtector.get(com.bytedance.commerce.base.view.b.a(this), r17)).setVisibility(8);
    L32:
        r7 = r7 + 1;
        goto L13
    L24:
        r16 = 0;
        goto L25
    L20:
        r12 = 0;
        goto L21
    L33:
        return;
    L5:
        if (Intrinsics.areEqual(((View) ListProtector.get(com.bytedance.commerce.base.view.b.a(this), getChildCount() - 1)).getTag(), "dot") == false) goto L7;
        ((View) ListProtector.get(com.bytedance.commerce.base.view.b.a(this), getChildCount() - 1)).setVisibility(8);
        goto L7
    }

    public InFlowSellingPointAreaView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = true;
        this.c = -1;
        this.f = -1;
        this.g = true;
        setOrientation(0);
        setGravity(16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r0v23, types: [android.widget.FrameLayout, com.bytedance.android.shopping.inflow.view.InFlowRankLayout] */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [android.widget.LinearLayout, com.bytedance.android.shopping.feed.widget.inflowsellingpoint.InFlowSellingPointAreaView] */
    public final void c(rd3.a r13, PromotionProductStruct r14, AnchorV3Param r15) {
        Intrinsics.checkNotNullParameter(r13, "anchorInflowFeedItem");
        Intrinsics.checkNotNullParameter(r14, "promotion");
        PromotionProductPrivilegesStruct r0 = r14.getPrivilegeInfo();
        if (r0 == null) goto L7;
        PromotionProductPrivilegesFirstAreaStruct r1 = r0.getPrivilegeFirstAreaInfo();
        if (r1 == null) goto L7;
        PromotionProductPrivilegesTextConfigStruct r2 = r1.getTextConfig();
    L8:
        String r5 = "";
        if (r2 != null) goto L11;
    L16:
        PromotionProductAuthorEntriesStruct r3 = r14.getEntryInfo();
        if (r3 == null) goto L19;
        ProductLeaderBoardEntryStruct r4 = r3.getLeaderBoardEntry();
    L20:
        int r7 = 2;
        if (r4 == null) goto L63;
        PromotionProductAuthorEntriesStruct r6 = r14.getEntryInfo();
        if (r6 == null) goto L29;
        ProductLeaderBoardEntryStruct r8 = r6.getLeaderBoardEntry();
        if (r8 == null) goto L29;
        if (r8.isShowProductLeaderBoard() != true) goto L29;
        boolean r9 = true;
    L30:
        if (r9 == false) goto L114;
        ?? r10 = new InFlowRankLayout(getContext(), null, 6, 0);
        if (r13.e == false) goto L34;
        String r16 = "c3865.d58821";
    L35:
        r10.setTextSize(this.e);
        r10.setTextStyle(this.f);
        PromotionProductAuthorEntriesStruct r11 = r14.getEntryInfo();
        Intrinsics.checkNotNull(r11);
        ProductLeaderBoardEntryStruct r12 = r11.getLeaderBoardEntry();
        Intrinsics.checkNotNull(r12);
        Intrinsics.checkNotNullParameter(r12, "leaderBoardEntry");
        r10.a = r12.getSchema();
        ImageView r17 = (ImageView) r10.findViewById(2131362704);
        TextView r18 = (TextView) r10.findViewById(2131362730);
        if (r18 == null) goto L41;
        r10.b(r18);
        String r19 = r12.getContent();
        if (r19 == null) goto L40;
        r5 = r19;
    L40:
        r18.setText(r5);
    L41:
        Integer r20 = r12.getRank();
        if (r20 == null) goto L44;
        int r21 = r20.intValue();
    L45:
        if (r21 <= 0) goto L58;
        if (k.c(r12.getSchema()) == false) goto L58;
        TextView r22 = (TextView) r10.findViewById(2131362728);
        if (r22 == null) goto L51;
        r10.b(r22);
        r22.setText("第" + r21 + 21517);
    L51:
        LinearLayout r23 = (LinearLayout) r10.findViewById(2131362729);
        if (r23 == null) goto L54;
        r23.setVisibility(0);
    L54:
        TextView r24 = (TextView) r10.findViewById(2131362731);
        if (r24 == null) goto L58;
        r10.b(r24);
        r24.setVisibility(0);
    L58:
        if (k.c(r12.getSchema()) == false) goto L60;
        r10.setOnClickListener(new com.bytedance.android.shopping.inflow.view.b(r10, r15, r16));
        ?? r25 = r10;
    L115:
        if (r25 == 0) goto L118;
        addView(r25);
        this.b = true;
        View r110 = getSeparatorView();
        r110.setTag("dot");
        addView(r110);
        this.b = true;
        this.a = false;
    L118:
        if (d.e(d.c()) == false) goto L120;
    L121:
        ArrayList r111 = new ArrayList();
        if (this.a == false) goto L125;
        r7 = 4;
    L125:
        if (d.e(d.c()) == false) goto L151;
        PromotionProductBaseStruct r112 = r14.getBaseInfo();
        if (r112 == null) goto L138;
        List r113 = r112.getSellingPointInfo();
        if (r113 == null) goto L138;
        Iterator r114 = r113.iterator();
    L132:
        if (r114.hasNext() == false) goto L138;
        SellingPointInfoStruct r26 = (SellingPointInfoStruct) r114.next();
        if (r111.size() >= r7) goto L132;
        String r27 = r26.getContent();
        if (r27 == null) goto L132;
        r111.add(r27);
    L138:
        PromotionProductPrivilegesStruct r115 = r14.getPrivilegeInfo();
        if (r115 == null) goto L151;
        List r116 = r115.getServices();
        if (r116 == null) goto L151;
        Iterator r117 = r116.iterator();
    L144:
        if (r117.hasNext() == false) goto L151;
        PromotionProductServiceStruct r28 = (PromotionProductServiceStruct) r117.next();
        if (r111.size() >= r7) goto L144;
        String r29 = r28.getTitle();
        if (r29 == null) goto L144;
        r111.add(r29);
    L151:
        if (d.e(d.d()) == false) goto L165;
        PromotionProductPrivilegesStruct r118 = r14.getPrivilegeInfo();
        if (r118 == null) goto L165;
        List r119 = r118.getServices();
        if (r119 == null) goto L165;
        Iterator r120 = r119.iterator();
    L158:
        if (r120.hasNext() == false) goto L165;
        PromotionProductServiceStruct r121 = (PromotionProductServiceStruct) r120.next();
        if (r111.size() >= r7) goto L158;
        String r122 = r121.getTitle();
        if (r122 == null) goto L158;
        r111.add(r122);
    L165:
        if (r111.size() <= 0) goto L193;
        Iterator r123 = r111.iterator();
    L168:
        if (r123.hasNext() == false) goto L194;
        addView(d((String) r123.next(), Boolean.FALSE, null));
        this.b = true;
        View r124 = getSeparatorView();
        r124.setTag("dot");
        addView(r124);
        this.b = true;
        goto L168
    L194:
        return;
    L193:
        return;
    L120:
        if (d.e(d.d()) == true) goto L121;
        return;
    L60:
        if (r17 == null) goto L62;
        r17.setVisibility(8);
    L62:
        r10.setOnClickListener(null);
        r25 = r10;
        goto L115
    L44:
        r21 = 0;
        goto L45
    L34:
        r16 = "c4701.d20783";
    L114:
        r25 = 0;
    L29:
        r9 = false;
        goto L30
    L63:
        PromotionProductPrivilegesStruct r125 = r14.getPrivilegeInfo();
        if (r125 == null) goto L114;
        PromotionProductLogisticsStruct r126 = r125.getLogistics();
        if (r126 == null) goto L114;
        List r127 = r126.getLogisticText();
        if (r127 == null) goto L114;
        String r128 = (String) CollectionsKt.firstOrNull(r127);
        if (r128 == null) goto L114;
        if (r128.length() <= 0) goto L74;
        boolean r129 = true;
    L75:
        if (r129 != true) goto L114;
        InflowAnchorV3LogisticsLayout r30 = new InflowAnchorV3LogisticsLayout(getContext(), null, 6, 0);
        PromotionProductPrivilegesStruct r130 = r14.getPrivilegeInfo();
        if (r130 == null) goto L79;
        PromotionProductLogisticsStruct r131 = r130.getLogistics();
    L80:
        if (r131 == null) goto L91;
        List r31 = r131.getLogisticText();
        if (r31 == null) goto L85;
        String r32 = (String) ListProtector.get(r31, 0);
    L87:
        if (TextUtils.isEmpty(r32) == true) goto L91;
        r30.b.setText(r32);
        ECUrlModel r132 = r131.getPrefixIcon();
        if (r132 == null) goto L91;
        r30.a.setVisibility(0);
        y.a(r30.a, r132);
        goto L91
    L85:
        r32 = null;
    L91:
        Float r133 = this.e;
        if (r133 == null) goto L94;
        float r134 = r133.floatValue();
    L95:
        boolean r33 = this.g;
        r30.b.setTextSize(r134);
        if (r33 == false) goto L98;
        r30.b.setTypeface(null, 1);
    L99:
        float r34 = se3.a.a;
        se3.a.c(r30.b, 2, r134);
        int r135 = this.f;
        if (r135 >= 0) goto L103;
        r135 = 500;
    L103:
        r30.setFontWeight(r135);
        r30.setTextColor(getDefaultColor());
        PromotionProductPrivilegesStruct r136 = r14.getPrivilegeInfo();
        r25 = r30;
        if (r136 == null) goto L115;
        PromotionProductLogisticsStruct r137 = r136.getLogistics();
        r25 = r30;
        if (r137 == null) goto L115;
        String r138 = r137.getExtraLog();
        r25 = r30;
        if (r138 == null) goto L115;
        JSONObject r139 = k.w(r138);
        r25 = r30;
        if (r139 == null) goto L115;
        String r140 = r139.optString("product_promise_info");
        r25 = r30;
        if (r140 == null) goto L115;
        r13.k.put("product_promise_info", r140);
        r25 = r30;
        goto L115
    L98:
        r30.b.setTypeface(null, 0);
        goto L99
    L94:
        r134 = 13.0f;
        goto L95
    L79:
        r131 = null;
        goto L80
    L74:
        r129 = false;
        goto L75
    L19:
        r4 = null;
        goto L20
    L11:
        if (k.c(r2.getText()) == false) goto L16;
        String r35 = r2.getText();
        if (r35 != null) goto L15;
        r35 = "";
    L15:
        addView(d(r35, Boolean.FALSE, r2.getTextColor()));
        View r36 = getSeparatorView();
        r36.setTag("dot");
        addView(r36);
        this.b = true;
        this.a = false;
    L7:
        r2 = null;
        goto L8
    }

    public final View d(String r6, Boolean r7, String r8) {
        TextView r0 = new TextView(getContext());
        r0.setIncludeFontPadding(false);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L5;
        float r9 = 2;
        wg.a.f(r0, MathKt.roundToInt(TypedValue.applyDimension(1, r9, b(Resources.getSystem()))), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r9, b(Resources.getSystem()))), 0);
    L5:
        if (r8 != null) goto L31;
        int r10 = getDefaultColor();
    L18:
        r0.setTextColor(r10);
        Float r11 = this.e;
        float r12 = 13.0f;
        if (r11 == null) goto L21;
        float r13 = r11.floatValue();
    L22:
        r0.setTextSize(1, r13);
        r0.setText(r6);
        r0.setSingleLine();
        TextPaint r14 = r0.getPaint();
        int r15 = this.f;
        if (r15 >= 0) goto L26;
        r15 = 500;
    L26:
        ViewExtensionsKt.e(r0, r14, r15);
        float r16 = se3.a.a;
        Float r17 = this.e;
        if (r17 == null) goto L29;
        r12 = r17.floatValue();
    L29:
        se3.a.c(r0, 1, r12);
        return r0;
    L21:
        r13 = 13.0f;
        goto L22
    L31:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L8
        Object r19 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r8)));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r19) == false) goto L13;
        r19 = null;
    L13:
        Integer r20 = (Integer) r19;
        if (r20 == null) goto L16;
        r10 = r20.intValue();
        goto L18
    L16:
        r10 = getDefaultColor();
    L8:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public /* synthetic */ InFlowSellingPointAreaView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
