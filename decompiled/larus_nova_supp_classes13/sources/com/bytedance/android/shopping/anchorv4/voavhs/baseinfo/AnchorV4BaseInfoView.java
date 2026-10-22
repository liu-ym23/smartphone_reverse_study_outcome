package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.c2;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ec.core.widget.RoundedLinearLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionSubsidizedActivity;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.shopping.anchorv4.dto.base.Border;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.SkuBaseInfoDataModel;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.SkuBaseInfoComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.MediaBoxElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.PriceElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.LongContentLabelComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.SkuBaseInfoComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.TagsScrollBoxComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.MediaBoxElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\"B)\b\u0007\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002R(\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR(\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u000e8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R(\u0010\u0019\u001a\u0004\u0018\u00010\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u00148\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/AnchorV4BaseInfoView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/ec/core/utils/l1$a;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/c;", "data", "", "update", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/SkuBaseInfoComponentView;", "<set-?>", "g", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/SkuBaseInfoComponentView;", "getSkuView", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/SkuBaseInfoComponentView;", "skuView", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/TagsScrollBoxComponentView;", "h", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/TagsScrollBoxComponentView;", "getLikeView", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/TagsScrollBoxComponentView;", "likeView", "Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/PriceAndSalesLayout;", "i", "Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/PriceAndSalesLayout;", "getPriceAndSalesLayout", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/PriceAndSalesLayout;", "priceAndSalesLayout", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BaseInfoLayoutOnHierarchyChangeListener", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4BaseInfoView extends LinearLayout implements l1.a {
    public Map<Integer, View> a;
    public boolean b;
    public View c;
    public c d;
    public final List<LongContentLabelComponentView> e;
    public final List<LongContentLabelComponentView> f;
    public SkuBaseInfoComponentView g;
    public TagsScrollBoxComponentView h;
    public PriceAndSalesLayout i;

    public static final class BaseInfoLayoutOnHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        public BaseInfoLayoutOnHierarchyChangeListener() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewAdded(View r1, View r2) {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewRemoved(View r3, View r4) {
            if ((r4 instanceof SkuBaseInfoComponentView) == true) goto L5;
            return;
        L5:
            if ((r3 instanceof ViewGroup) == false) goto L28;
            boolean r0 = true;
            if (com.bytedance.android.ec.core.opt.ab.w.a() == 1) goto L10;
            r0 = false;
        L10:
            if (r0 == false) goto L29;
            ArrayList r5 = new ArrayList();
            ExtensionsKt.c((ViewGroup) r4, r5, AnchorV4BaseInfoView$BaseInfoLayoutOnHierarchyChangeListener$onChildViewRemoved$$inlined$cacheSimpleDraweeView$1.INSTANCE);
            ArrayList r6 = new ArrayList();
            Iterator r7 = r5.iterator();
        L13:
            if (r7.hasNext() == false) goto L17;
            Object r1 = r7.next();
            if ((r1 instanceof MediaBoxElementView) == false) goto L13;
            r6.add(r1);
            goto L13
        L17:
            Iterator r8 = r6.iterator();
        L19:
            if (r8.hasNext() == false) goto L30;
            ((com.bytedance.android.shopping.anchorv4.voavhs.base.design.b) r8.next()).a();
            goto L19
        L30:
            return;
        L29:
            return;
        }
    }

    public static final class a extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ AnchorV4BaseInfoView g;
        public final /* synthetic */ AnchorV4VM h;
        public final /* synthetic */ View i;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.AnchorV4BaseInfoView$a$a, reason: collision with other inner class name */
        public static final class RunnableC0005a implements Runnable {
            public final /* synthetic */ a a;

            public RunnableC0005a(a r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.i.setVisibility(8);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final void a(View r8) {
            Intrinsics.checkNotNullParameter(r8, "v");
            this.h.stopCollapseDetail();
            this.g.b = true;
            r8.post(new RunnableC0005a(this));
            int r9 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
            AnchorV4TrackerImpl r0 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.h);
            if (r0 == null) goto L6;
            AnchorV4TrackerImpl.b(r0, "full_product_detail_click", false, null, false, null, 30);
            return;
        }

        public a(AnchorV4BaseInfoView r1, AnchorV4VM r2, View r3) {
            this.g = r1;
            this.h = r2;
            this.i = r3;
            super(null, null, 3);
        }
    }

    public AnchorV4BaseInfoView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV4BaseInfoView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final boolean update(c r1) {
        return false;
    }

    public final void onFinish() {
    }

    public final void onStart() {
    }

    public final TagsScrollBoxComponentView getLikeView() {
        return this.h;
    }

    public final PriceAndSalesLayout getPriceAndSalesLayout() {
        return this.i;
    }

    public final SkuBaseInfoComponentView getSkuView() {
        return this.g;
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

    public final void onTick(long r3) {
        int r0 = c2.h;
        c2 r4 = c2.a.a(getContext(), r3, false);
        View r5 = this.c;
        if ((r5 instanceof TextWithOneIconElementView) == true) goto L5;
        r5 = null;
    L5:
        TextWithOneIconElementView r6 = (TextWithOneIconElementView) r5;
        if (r6 == null) goto L11;
        AppCompatTextView r7 = r6.getTextElementView();
        if (r7 == null) goto L12;
        r7.setText(r4.d + ':' + r4.e);
        return;
    L12:
        return;
    }

    public AnchorV4BaseInfoView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new LinkedHashMap();
        if (r1 == null) goto L5;
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r1).aU(2131564599, this, true);
    L5:
        setOrientation(1);
        a(2131363995).setShowDividers(2);
        a(2131363995).setDividerDrawable(com.bytedance.commerce.base.drawable.a.a(AnonymousClass2.INSTANCE));
        a(2131363995).setOnHierarchyChangeListener(new BaseInfoLayoutOnHierarchyChangeListener());
        this.e = new ArrayList();
        this.f = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [android.view.View, com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.GoodTitleComponentView, com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.InlineLongTitleComponentView] */
    /* JADX WARN: Type inference failed for: r5v6, types: [android.view.View, com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.PriceAndSalesLayout] */
    public final void b(c r44, FragmentActivity r45, AnchorV4VM r46) {
        Intrinsics.checkNotNullParameter(r45, "context");
        Intrinsics.checkNotNullParameter(r46, "viewModel");
        if (r44 == null) goto L213;
        AnchorV4BaseInfoDisplay r3 = r44.b;
        if (r3 == null) goto L213;
        BaseInfoVO r10 = r3.getBaseInfo();
        if (r10 == null) goto L213;
        c r4 = this.d;
        if (r4 == null) goto L35;
        ComponentDTO r5 = r4.d;
        if (r5 == null) goto L16;
        VO r6 = r5.getVo();
        if (r6 == null) goto L16;
        String r7 = r6.getDisplayMd5();
    L17:
        if (r7 == null) goto L35;
        ComponentDTO r8 = r4.d;
        if (r8 == null) goto L23;
        VO r9 = r8.getVo();
        if (r9 == null) goto L23;
        String r11 = r9.getDisplayMd5();
    L24:
        ComponentDTO r12 = r44.d;
        if (r12 == null) goto L29;
        VO r13 = r12.getVo();
        if (r13 == null) goto L29;
        String r14 = r13.getDisplayMd5();
    L31:
        if (Intrinsics.areEqual(r11, r14) == false) goto L35;
        this.d = r44;
        if (update(r44) == false) goto L35;
        return;
    L29:
        r14 = null;
    L23:
        r11 = null;
    L16:
        r7 = null;
    L35:
        this.d = r44;
        AnchorV4ActivityLayout r15 = (AnchorV4ActivityLayout) a(2131363993);
        AnchorV4BaseInfoDisplay r16 = r44.b;
        if (r16 == null) goto L38;
        ActivityVO r17 = r16.getActivityInfo();
    L40:
        if (com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.a.a(r17) == false) goto L78;
        SkuRestoreState r18 = r46.skuStore();
        if (r18 == null) goto L44;
        String[] r19 = r18.getSelectSkuKeys();
    L45:
        if (r19 == null) goto L75;
        String r20 = (String) ArraysKt.firstOrNull(r19);
        if (r20 == null) goto L75;
        AnchorV4BaseInfoDisplay r21 = r44.b;
        if (r21 == null) goto L75;
        ActivityVO r22 = r21.getActivityInfo();
        if (r22 == null) goto L75;
        SkuBaseInfoComponent r23 = r22.getSkuInfo();
        if (r23 == null) goto L75;
        List r24 = r23.getSkuPriceList();
        if (r24 == null) goto L75;
        Iterator r25 = r24.iterator();
    L58:
        if (r25.hasNext() == false) goto L75;
        SkuBaseInfoDataModel r26 = (SkuBaseInfoDataModel) r25.next();
        PriceElement r27 = r26.getEffectivePrice();
        PriceElement r28 = r26.getDiscountPrice();
        PriceElement r29 = r26.getMarketPrice();
        if (Intrinsics.areEqual(r26.getSpecId(), r20) == false) goto L58;
        if (r27 != null) goto L64;
        if (r28 != null) goto L64;
        if (r29 == null) goto L58;
    L64:
        AnchorV4BaseInfoDisplay r30 = r44.b;
        if (r30 == null) goto L78;
        ActivityVO r110 = r30.getActivityInfo();
        if (r110 == null) goto L78;
        AnchorV4BaseInfoDisplay r31 = r44.b;
        if (r31 == null) goto L73;
        ActivityVO r32 = r31.getActivityInfo();
        if (r32 == null) goto L73;
        PromotionSubsidizedActivity r33 = r32.getSubsidy();
    L74:
        ActivityVO r34 = ActivityVO.copy$default(r110, null, 0, null, null, null, null, null, r27, r29, r28, null, 0, 0, 0, 0, 0, 0, null, null, null, 0, r46.getNewSubsidyPrice(r33, r26), null, false, 14679167, null);
    L79:
        r15.b(r34, r45, r46);
        a(2131363995).removeAllViews();
        AnchorV4BaseInfoDisplay r35 = r44.b;
        if (r35 == null) goto L116;
        BaseInfoVO r36 = r35.getBaseInfo();
        if (r36 == null) goto L116;
        SkuBaseInfoComponent r37 = r36.getSkuInfo();
        if (r37 == null) goto L116;
        SkuBaseInfoComponentView r38 = new SkuBaseInfoComponentView(r45, null, 6);
        r38.a(r37);
        this.g = r38;
        RoundedLinearLayout r39 = a(2131363995);
        SkuBaseInfoComponentView r40 = this.g;
        MediaBoxElement r41 = r37.getMainSkuImage();
        if (r41 == null) goto L92;
        ImageModel r42 = r41.getImageModel();
        if (r42 == null) goto L92;
        ECUrlModel r43 = r42.getRemote();
        if (r43 == null) goto L92;
        Integer r47 = Integer.valueOf(r43.getHeight());
    L93:
        MediaBoxElement r48 = r37.getMainSkuImage();
        if (r48 == null) goto L98;
        Border r49 = r48.getOutBorder();
        if (r49 == null) goto L98;
        Integer r50 = Integer.valueOf(r49.getBorderWidth());
    L99:
        if (r47 == null) goto L102;
        if (r50 == null) goto L102;
        Integer r51 = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r47.intValue() + (r50.intValue() * 2))));
    L103:
        if (r51 == null) goto L105;
        int r52 = r51.intValue();
    L106:
        r39.addView(r40, new LinearLayout.LayoutParams(-1, r52));
        SkuBaseInfoComponentView r53 = this.g;
        if (r53 == null) goto L116;
        SkuRestoreState r54 = r46.skuStore();
        if (r54 == null) goto L115;
        String[] r55 = r54.getSelectSkuKeys();
        if (r55 == null) goto L115;
        String r56 = (String) ArraysKt.firstOrNull(r55);
        if (r56 == null) goto L115;
        r53.b(r56);
    L115:
        r53.b("");
        goto L116
    L105:
        Integer r57 = -2;
        r52 = r57.intValue();
    L102:
        r51 = null;
    L98:
        r50 = null;
    L92:
        r47 = null;
    L116:
        AnchorV4BaseInfoDisplay r58 = r44.b;
        if (r58 == null) goto L119;
        ActivityVO r59 = r58.getActivityInfo();
    L121:
        if (com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.a.a(r59) == true) goto L173;
        this.i = new PriceAndSalesLayout(r45, null);
        SkuRestoreState r60 = r46.skuStore();
        if (r60 == null) goto L149;
        String[] r61 = r60.getSelectSkuKeys();
        if (r61 == null) goto L149;
        String r62 = (String) ArraysKt.firstOrNull(r61);
        if (r62 == null) goto L149;
        AnchorV4BaseInfoDisplay r63 = r44.b;
        if (r63 == null) goto L149;
        BaseInfoVO r64 = r63.getBaseInfo();
        if (r64 == null) goto L149;
        SkuBaseInfoComponent r65 = r64.getSkuInfo();
        if (r65 == null) goto L149;
        List r66 = r65.getSkuPriceList();
        if (r66 == null) goto L149;
        Iterator r67 = r66.iterator();
    L138:
        if (r67.hasNext() == false) goto L149;
        SkuBaseInfoDataModel r68 = (SkuBaseInfoDataModel) r67.next();
        PriceElement r210 = r68.getEffectivePrice();
        PriceElement r211 = r68.getDiscountPrice();
        PriceElement r212 = r68.getMarketPrice();
        if (Intrinsics.areEqual(r68.getSpecId(), r62) == false) goto L138;
        if (r210 != null) goto L144;
        if (r211 != null) goto L144;
        if (r212 == null) goto L138;
    L144:
        AnchorV4BaseInfoDisplay r69 = r44.b;
        if (r69 == null) goto L152;
        BaseInfoVO r111 = r69.getBaseInfo();
        if (r111 == null) goto L152;
        BaseInfoVO r70 = BaseInfoVO.copy$default(r111, null, null, null, null, r212, r211, r210, null, null, 399, null);
    L153:
        ?? r71 = this.i;
        if (r71 == 0) goto L173;
        if (r70 == null) goto L157;
        PriceElement r72 = r70.getPrice();
    L158:
        if (r70 == null) goto L160;
        PriceElement r73 = r70.getDiscountPrice();
    L161:
        if (r70 == null) goto L163;
        PriceElement r112 = r70.getMarketPrice();
    L164:
        if (r70 == null) goto L166;
        TextElement r74 = r70.getSales();
    L167:
        if (r72 != null) goto L171;
        if (r73 != null) goto L171;
        if (r112 != null) goto L171;
        r71.setVisibility(8);
    L172:
        RoundedLinearLayout r2 = (RoundedLinearLayout) a(2131363995);
        LinearLayout.LayoutParams r75 = new LinearLayout.LayoutParams(-1, -2);
        r75.bottomMargin = com.bytedance.android.shopping.extensions.b.b(-4);
        Unit r76 = Unit.INSTANCE;
        r2.addView(r71, r75);
    L171:
        r71.setVisibility(0);
        r71.R5(r72, r73, r112);
        ((TextElementView) r71._$_findCachedViewById(2131363999)).x(r74);
        goto L172
    L166:
        r74 = null;
        goto L167
    L163:
        r112 = null;
        goto L164
    L160:
        r73 = null;
        goto L161
    L157:
        r72 = null;
    L152:
        r70 = null;
    L149:
        AnchorV4BaseInfoDisplay r77 = r44.b;
        if (r77 == null) goto L152;
        r70 = r77.getBaseInfo();
    L173:
        ((ArrayList) this.e).clear();
        List<LongContentLabelComponent> r78 = r10.getTagsList();
        if (r78 == null) goto L179;
        Iterator<T> r113 = r78.iterator();
    L177:
        if (r113.hasNext() == false) goto L179;
        LongContentLabelComponent r79 = (LongContentLabelComponent) r113.next();
        LongContentLabelComponentView r80 = new LongContentLabelComponentView(r45, null, null, 6, null);
        r80.bind(r79);
        a(2131363995).addView(r80, new LinearLayout.LayoutParams(-2, -2));
        ((ArrayList) this.e).add(r80);
    L179:
        RoundedLinearLayout r81 = (RoundedLinearLayout) a(2131363995);
        ?? r82 = new GoodTitleComponentView(r45, null);
        r82.x(r10.getGoodsTitle());
        r81.addView(r82);
        List<LongContentLabelComponent> r84 = r10.getBottomTagsList();
        if (r84 == null) goto L185;
        Iterator<T> r114 = r84.iterator();
    L183:
        if (r114.hasNext() == false) goto L185;
        LongContentLabelComponent r115 = (LongContentLabelComponent) r114.next();
        LongContentLabelComponentView r116 = new LongContentLabelComponentView(r45, null, null, 6, null);
        r116.bind(r115);
        a(2131363995).addView(r116);
        ((ArrayList) this.f).add(r116);
    L185:
        View r85 = ExtensionsKt.g((ViewGroup) a(2131363995), "id_referer_name");
        if (r85 != null) goto L188;
    L194:
        View r86 = ExtensionsKt.g((ViewGroup) a(2131363995), "tag_auction_countdown");
        this.c = r86;
        if (r86 == null) goto L198;
        r46.listenActivityTick(this);
    L198:
        if (r44.e == true) goto L200;
    L205:
        AnchorV4BaseInfoDisplay r1 = r44.b;
        if (r1 == null) goto L233;
        BaseInfoVO r87 = r1.getBaseInfo();
        if (r87 == null) goto L234;
        TagsScrollBoxComponent r88 = r87.getUserLike();
        if (r88 == null) goto L235;
        TagsScrollBoxComponentView r89 = new TagsScrollBoxComponentView(r45, null, 0, 14);
        TagsScrollBoxComponentView.b(r89, r88, null, 14);
        this.h = r89;
        RoundedLinearLayout r90 = a(2131363995);
        TagsScrollBoxComponentView r91 = this.h;
        LinearLayout.LayoutParams r92 = new LinearLayout.LayoutParams(-2, -2);
        r92.gravity = 1;
        r92.topMargin = com.bytedance.android.shopping.extensions.b.b(6);
        r92.bottomMargin = com.bytedance.android.shopping.extensions.b.b(6);
        Unit r94 = Unit.INSTANCE;
        r90.addView(r91, r92);
        return;
    L235:
        return;
    L234:
        return;
    L233:
        return;
    L200:
        if (this.b == true) goto L205;
        ShoppingAsyncInflater.e.getClass();
        View r95 = ShoppingAsyncInflater.a.a(r45).aU(2131564604, (ViewGroup) a(2131363995), false);
        r95.setBackground(com.bytedance.commerce.base.drawable.a.a(AnchorV4BaseInfoView$bind$8.INSTANCE));
        r95.setVisibility(0);
        int r96 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r213 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r46);
        if (r213 == null) goto L204;
        AnchorV4TrackerImpl.b(r213, "full_product_detail_show", false, null, false, null, 28);
    L204:
        r95.setOnClickListener(new a(this, r46, r95));
        a(2131363995).addView(r95);
        goto L205
    L188:
        if ((r85 instanceof TextView) == true) goto L190;
        View r97 = null;
    L191:
        TextView r98 = (TextView) r97;
        if (r98 == null) goto L194;
        r98.setMaxWidth((int) (k1.m(r85.getContext()) * 0.4f));
        goto L194
    L190:
        r97 = r85;
        goto L191
    L119:
        r59 = null;
    L73:
        r33 = null;
    L75:
        AnchorV4BaseInfoDisplay r99 = r44.b;
        if (r99 == null) goto L78;
        r34 = r99.getActivityInfo();
        goto L79
    L44:
        r19 = null;
    L78:
        r34 = null;
        goto L79
    L38:
        r17 = null;
    L213:
        setVisibility(8);
    }

    public /* synthetic */ AnchorV4BaseInfoView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
