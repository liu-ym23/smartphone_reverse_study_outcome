package com.bytedance.android.shopping.anchorv4.voavhs.logistics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.FontStyle;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.dto.components.GradientTextWithIconsComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.LongTitleComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.MultiGradientTextWithIconsComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.LongContentLabelComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.anchorv4.voavhs.processflow.AnchorV4PathEffectFlowLayout;
import com.bytedance.android.shopping.buynow.data.model.ErrorPageButtonAction;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/AnchorV4LogisticsAndCouponView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/a;", "data", "", "update", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4LogisticsAndCouponView extends LinearLayout {
    public Map<Integer, View> a;
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b b;
    public com.bytedance.android.shopping.anchorv4.voavhs.logistics.a c;

    public static final class a implements Runnable {
        public final /* synthetic */ Background a;
        public final /* synthetic */ AnchorV4LogisticsAndCouponView b;
        public final /* synthetic */ Function0 c;

        public a(Background r1, AnchorV4LogisticsAndCouponView r2, Function0 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ExtensionsKt.j(this.b.a(2131385945), this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public AnchorV4LogisticsAndCouponView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV4LogisticsAndCouponView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final boolean update(com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r1) {
        return false;
    }

    public final View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    @Override // android.view.View
    public final void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        this.b.e(r2);
        super.draw(r2);
        this.b.d(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final void onViewRemoved(View r2) {
        super.onViewRemoved(r2);
        if ((r2 instanceof AnchorV4LogisticsServiceDetailView) == false) goto L6;
        ((AnchorV4LogisticsServiceDetailView) r2).removeAllViewsInLayout();
        return;
    }

    public AnchorV4LogisticsAndCouponView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b r5 = new com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b(this);
        this.b = r5;
        LayoutInflater.from(r2).inflate(2131560503, this, true);
        r5.f(new Radius(8, 8, 8, 8));
        setBackgroundColor(-1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v31 */
    /* JADX WARN: Type inference failed for: r6v8, types: [android.view.View, android.view.ViewGroup, com.bytedance.android.shopping.anchorv4.voavhs.logistics.AnchorV4LogisticsServiceDetailView] */
    /* JADX WARN: Type inference failed for: r8v14, types: [android.view.View, androidx.constraintlayout.widget.ConstraintLayout, com.bytedance.android.shopping.anchorv4.voavhs.processflow.AnchorV4PathEffectFlowLayout] */
    public final void b(final com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r29, AnchorV4VM r30, Function0<Unit> r31) {
        Intrinsics.checkNotNullParameter(r30, "viewModel");
        Intrinsics.checkNotNullParameter(r31, ErrorPageButtonAction.REFRESH);
        com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r3 = this.c;
        AttributeSet r5 = null;
        if (r3 == null) goto L29;
        ComponentDTO r6 = r3.d;
        if (r6 == null) goto L9;
        VO r7 = r6.getVo();
        if (r7 == null) goto L9;
        String r8 = r7.getDisplayMd5();
    L10:
        if (r8 == null) goto L29;
        ComponentDTO r4 = r3.d;
        if (r4 == null) goto L16;
        VO r9 = r4.getVo();
        if (r9 == null) goto L16;
        String r10 = r9.getDisplayMd5();
    L17:
        if (r29 == null) goto L23;
        ComponentDTO r11 = r29.d;
        if (r11 == null) goto L23;
        VO r12 = r11.getVo();
        if (r12 == null) goto L23;
        String r13 = r12.getDisplayMd5();
    L25:
        if (Intrinsics.areEqual(r10, r13) == false) goto L29;
        this.c = r29;
        if (update(r29) == false) goto L29;
        return;
    L23:
        r13 = null;
    L16:
        r10 = null;
    L9:
        r8 = null;
    L29:
        this.c = r29;
        int r14 = 2;
        ((LinearLayout) a(2131385944)).setShowDividers(2);
        ((LinearLayout) a(2131385944)).setDividerDrawable(com.bytedance.commerce.base.drawable.a.a(new AnchorV4LogisticsAndCouponView$bind$2(r29)));
        ((LinearLayout) a(2131385945)).removeAllViews();
        ((LinearLayout) a(2131385944)).removeAllViews();
        if (r29 == null) goto L208;
        AnchorV4LogisticsAndCouponDisplay r15 = r29.b;
        if (r15 == null) goto L233;
        Background r16 = r15.getBackground();
        if (r16 == null) goto L36;
        post(new a(r16, this, r31));
    L36:
        LongContentLabelComponent r17 = r15.getGuaranteeHeader();
        int r18 = 8;
        ?? r19 = 0;
        if (r17 == null) goto L49;
        LongContentLabelComponentView r110 = new LongContentLabelComponentView(getContext(), null, null, 6, null);
        r110.bind(r17);
        LinearLayout r111 = (LinearLayout) a(2131385945);
        if (r111 == null) goto L42;
        r111.addView(r110);
    L42:
        if (Intrinsics.areEqual(r17.isHide(), Boolean.TRUE) == false) goto L44;
        r110.setVisibility(8);
    L44:
        a(2131385945).setVisibility(0);
        int r20 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r112 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r30);
        if (r112 == null) goto L47;
        AnchorV4TrackerImpl.b(r112, "wuyou_service_info_bar_show", false, null, false, null, 28);
        Unit r21 = Unit.INSTANCE;
    L48:
        if (r21 == null) goto L49;
    L50:
        List<ServiceComponent> r22 = r15.getServiceDetail();
        if (r22 == null) goto L234;
        Iterator<T> r23 = r22.iterator();
        int r24 = 0;
    L54:
        if (r23.hasNext() == false) goto L235;
        Object r25 = r23.next();
        int r26 = r24 + 1;
        if (r24 >= 0) goto L58;
        CollectionsKt.throwIndexOverflow();
    L58:
        ServiceComponent r27 = (ServiceComponent) r25;
        ECAppInfoService r28 = ECAppInfoService.e;
        if (r28.f() == true) goto L61;
    L97:
        ?? r32 = new AnchorV4LogisticsServiceDetailView(getContext(), r5, 6, r19);
        r32.setRefresh(r31);
        if (r27.getServiceType() != ServiceType.SPEC_INFO.getValue()) goto L149;
        CommonMeta r113 = r30.commonMeta();
        if (r113 == null) goto L120;
        SkuRestoreState r114 = r30.skuStore();
        if (r114 == null) goto L104;
        String[] r115 = r114.getSelectSkuKeys();
    L105:
        String r116 = h73.a.e(r113, r115);
        if (r116 == null) goto L120;
        List<LongContentLabelComponent> r117 = r27.getDetailContent();
        if (r117 == null) goto L120;
        LongContentLabelComponent r118 = (LongContentLabelComponent) CollectionsKt.getOrNull(r117, r19);
        if (r118 == null) goto L120;
        TagsScrollBoxComponent r119 = r118.getHeadButtons();
        if (r119 == null) goto L120;
        List r120 = r119.getButtonList();
        if (r120 == null) goto L120;
        TextWithOneIconElement r121 = (TextWithOneIconElement) CollectionsKt.getOrNull(r120, r19);
        if (r121 == null) goto L120;
        TextElement r122 = r121.getContent();
        if (r122 == null) goto L120;
        r122.setText(r116);
        goto L120
    L104:
        r115 = r5;
    L120:
        SkuRestoreState r123 = r30.skuStore();
        if (r123 != null) goto L123;
    L125:
        boolean r124 = false;
    L126:
        TextWithOneIconElement r125 = r27.getHeader();
        if (r125 == null) goto L134;
        TextElement r126 = r125.getContent();
        if (r126 == null) goto L134;
        if (r124 == false) goto L132;
        String r127 = ag4.a.d(2131913945);
    L133:
        r126.setText(r127);
        goto L134
    L132:
        r127 = ag4.a.d(2131913944);
    L134:
        List<LongContentLabelComponent> r33 = r27.getDetailContent();
        if (r33 == null) goto L149;
        Iterator<T> r34 = r33.iterator();
    L138:
        if (r34.hasNext() == false) goto L149;
        LongContentLabelComponent r128 = (LongContentLabelComponent) r34.next();
        if (r124 == true) goto L142;
    L143:
        if (r124 == false) goto L145;
    L147:
        boolean r35 = false;
    L148:
        r128.setHide(Boolean.valueOf(r35));
        goto L138
    L145:
        if ((!Intrinsics.areEqual(r128.getTag(), "specs")) == false) goto L147;
    L146:
        r35 = true;
        goto L148
    L142:
        if ((!Intrinsics.areEqual(r128.getTag(), "spec_selected_text")) == true) goto L146;
    L123:
        if (r123.hasSelectedSku() != true) goto L125;
        r124 = true;
    L149:
        LinearLayout r36 = (LinearLayout) a(2131385944);
        if (r36 == 0) goto L152;
        r36.addView(r32, new LinearLayout.LayoutParams(-1, -2));
    L152:
        View r37 = a(2131385944);
        Intrinsics.checkNotNullParameter(r37, FreqActions.ACTION_VIEW);
        new Path();
        new RectF();
        Radius r129 = new Radius(r18, r18, r18, r18);
        if (com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b.b(r129) == true) goto L155;
    L157:
        boolean r130 = false;
    L158:
        if (r130 == true) goto L161;
        r129 = null;
    L161:
        if (r129 == null) goto L163;
        r37.setClipToOutline(true);
        r37.setOutlineProvider(new com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b.a(r129));
    L164:
        r37.invalidate();
        AnchorV4LogisticsAndCouponMeta r38 = r29.c;
        if (r38 == null) goto L167;
        r38.getBusinessMeta();
    L167:
        Intrinsics.checkNotNullParameter(r27, "data");
        r32.h = r27;
        List<LongContentLabelComponent> r39 = r27.getDetailContent();
        if (r39 != null) goto L170;
    L173:
        boolean r40 = true;
    L174:
        if (r40 == false) goto L177;
        r32.setVisibility(r18);
    L176:
        AttributeSet r131 = null;
    L207:
        r24 = r26;
        r5 = r131;
        r14 = 2;
        r19 = 0;
        goto L54
    L177:
        r32.setVisibility(r19);
        r32.removeAllViews();
        ((ArrayList) r32.f).clear();
        TextView r41 = r32.a;
        ConstraintLayout.LayoutParams r42 = new ConstraintLayout.LayoutParams(-2, -2);
        r42.topToTop = r19;
        r42.startToStart = r19;
        Unit r132 = Unit.INSTANCE;
        r32.addView(r41, r42);
        TextWithOneIconElementView.b(r32.b, r27.getHeader(), null, false, null, 14);
        TextWithOneIconElementView r43 = r32.b;
        ConstraintLayout.LayoutParams r133 = new ConstraintLayout.LayoutParams(-2, -2);
        r133.startToStart = r19;
        r133.topToTop = r32.a.getId();
        r133.bottomToBottom = r32.a.getId();
        r32.addView(r43, r133);
        TextWithOneIconElementView.b(r32.c, r27.getSuffix(), null, false, null, 14);
        TextWithOneIconElementView r44 = r32.c;
        ConstraintLayout.LayoutParams r45 = new ConstraintLayout.LayoutParams(-2, -2);
        r45.endToEnd = r19;
        r45.topToTop = r32.a.getId();
        r45.bottomToBottom = r32.a.getId();
        r32.addView(r44, r45);
        Ref.IntRef r46 = new Ref.IntRef();
        r46.element = -1;
        r32.i = Integer.valueOf(r27.getServiceType());
        Iterator<T> r47 = r27.getDetailContent().iterator();
        int r134 = 0;
    L179:
        if (r47.hasNext() == false) goto L197;
        Object r135 = r47.next();
        int r136 = r134 + 1;
        if (r134 >= 0) goto L183;
        CollectionsKt.throwIndexOverflow();
    L183:
        LongContentLabelComponent r137 = (LongContentLabelComponent) r135;
        LongContentLabelComponentView r138 = new LongContentLabelComponentView(r32.getContext(), null, null, 6, null);
        if (r134 == 1) goto L186;
    L188:
        r138.setMinimumHeight(com.bytedance.android.shopping.extensions.b.b(20));
        r138.bind(r137);
        if (r134 != 0) goto L191;
        r138.setId(r32.d);
    L192:
        ConstraintLayout.LayoutParams r139 = new ConstraintLayout.LayoutParams(0, -2);
        ((ViewGroup.MarginLayoutParams) r139).topMargin = com.bytedance.android.shopping.extensions.b.b(5);
        r139.topToBottom = r46.element;
        r139.startToEnd = r32.b.getId();
        r139.endToStart = r32.c.getId();
        r139.constrainedWidth = true;
        r139.horizontalBias = 0.0f;
        ((ViewGroup.MarginLayoutParams) r139).leftMargin = com.bytedance.android.shopping.extensions.b.b(12);
        Unit r140 = Unit.INSTANCE;
        r32.addView(r138, r139);
        r46.element = r138.getId();
        ((ArrayList) r32.f).add(r138);
        if (Intrinsics.areEqual(r137.isHide(), Boolean.TRUE) == false) goto L196;
        r138.setVisibility(8);
    L196:
        r134 = r136;
        goto L179
    L191:
        r138.setId(ViewCompat.generateViewId());
        goto L192
    L186:
        if (r27.getServiceType() != ServiceType.SPEC_INFO.getValue()) goto L188;
        r138.setSkuSpecText(new b(r138, r32));
        goto L188
    L197:
        r18 = 8;
        r32.R5();
        TagsScrollBoxComponent r48 = r27.getProcessItems();
        if (r48 == null) goto L176;
        List r49 = r48.getButtonList();
        if (r49 == null) goto L176;
        if ((!r49.isEmpty()) == true) goto L205;
        r49 = null;
    L205:
        if (r49 == null) goto L176;
        r131 = null;
        ?? r50 = new AnchorV4PathEffectFlowLayout(r32.getContext(), null, 6, 0);
        r32.g = r50;
        r50.R5(r49);
        r50.setId(r32.e);
        ConstraintLayout.LayoutParams r51 = new ConstraintLayout.LayoutParams(0, -2);
        ((ViewGroup.MarginLayoutParams) r51).topMargin = com.bytedance.android.shopping.extensions.b.b(10);
        r51.topToBottom = r46.element;
        r51.bottomToBottom = 0;
        r51.startToStart = 0;
        r51.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) r51).leftMargin = com.bytedance.android.shopping.extensions.b.b(38);
        ((ViewGroup.MarginLayoutParams) r51).rightMargin = com.bytedance.android.shopping.extensions.b.b(42);
        Unit r52 = Unit.INSTANCE;
        r32.addView(r50, r51);
        goto L207
    L170:
        if (r39.isEmpty() == true) goto L173;
        r40 = false;
        goto L174
    L163:
        r37.setClipToOutline(r19);
        goto L164
    L155:
        if (com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b.a(r129) == false) goto L157;
        r130 = true;
        goto L158
    L61:
        if (r27.getServiceType() != ServiceType.GUARANTEE.getValue()) goto L74;
        Float r53 = r28.getCurrentFontScale();
        if (r53 == null) goto L65;
        float r54 = r53.floatValue();
    L66:
        TextWithOneIconElement r141 = r27.getHeader();
        if (r141 == null) goto L97;
        ImageModel r142 = r141.getIcon();
        if (r142 == null) goto L97;
        ECUrlModel r143 = r142.getRemote();
        if (r143 == null) goto L97;
        r143.setWidth((int) (r143.getWidth() * r54));
        r143.setHeight((int) (r143.getHeight() * r54));
        goto L97
    L65:
        r54 = 1;
        goto L66
    L74:
        if (r27.getServiceType() != ServiceType.ACTIVITY.getValue()) goto L97;
        List<LongContentLabelComponent> r55 = r27.getDetailContent();
        if (r55 == null) goto L97;
        Iterator<T> r56 = r55.iterator();
    L79:
        if (r56.hasNext() == false) goto L97;
        MultiGradientTextWithIconsComponent r144 = ((LongContentLabelComponent) r56.next()).getHeadLabels();
        if (r144 == null) goto L79;
        List r145 = r144.getLabelList();
        if (r145 == null) goto L79;
        Iterator r146 = r145.iterator();
    L86:
        if (r146.hasNext() == false) goto L79;
        GradientTextWithIconsComponent r147 = (GradientTextWithIconsComponent) r146.next();
        LongTitleComponent r148 = r147.getContent();
        if (r148 == null) goto L90;
        r148.setInline(true);
    L90:
        LongTitleComponent r149 = r147.getContent();
        if (r149 == null) goto L86;
        TextElement r150 = r149.getContent();
        if (r150 == null) goto L86;
        FontStyle r151 = r150.getFontStyle();
        if (r151 == null) goto L86;
        r151.setLine(r14);
        goto L86
    L235:
        return;
    L234:
        return;
    L47:
        r21 = null;
    L49:
        a(2131385945).setVisibility(8);
        Unit r57 = Unit.INSTANCE;
        goto L50
    L233:
        return;
    }

    public /* synthetic */ AnchorV4LogisticsAndCouponView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.b.c(r1, r2);
    }
}
