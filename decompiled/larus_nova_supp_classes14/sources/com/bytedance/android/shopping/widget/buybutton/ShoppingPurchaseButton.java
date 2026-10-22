package com.bytedance.android.shopping.widget.buybutton;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.c2;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.model.ButtonTime;
import com.bytedance.android.ec.model.ButtonType;
import com.bytedance.android.ec.model.ClickButtonParam;
import com.bytedance.android.ec.model.SingleClickParam;
import com.bytedance.android.ec.model.promotion.ECResultDialogContentVO;
import com.bytedance.android.ec.model.response.anchorv3.ButtonTipsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductLink;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.abtest.SettingKeys;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.threed.repository.dto.BasicComponent;
import com.bytedance.android.shopping.threed.repository.dto.BuyButtonComponent;
import com.bytedance.android.shopping.threed.repository.dto.NameComponent;
import com.bytedance.android.shopping.threed.repository.dto.TrackComponent;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0007J\b\u0010\u000f\u001a\u00020\u0006H\u0007J\b\u0010\u0010\u001a\u00020\u0006H\u0007¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/widget/buybutton/ShoppingPurchaseButton;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/widget/buybutton/c;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/view/View$OnClickListener;", "listener", "", "setProductTitleClickListener", "", "listeners", "setBuyButtonClickListener", "", "isVisible", "setProductAreaVisible", "resumeCountDown", "pauseCountDown", "stopCountDown", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShoppingPurchaseButton extends LinearLayout implements c, LifecycleObserver {
    public final View a;
    public final TextView b;
    public final View c;
    public final ViewGroup d;
    public final View e;
    public final g f;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ShoppingPurchaseButton a;

        public b(ShoppingPurchaseButton r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if ((this.a.getContext() instanceof LifecycleOwner) == false) goto L12;
            LifecycleOwner r0 = this.a.getContext();     // Catch: Throwable -> L9
            if (r0 == null) goto L8;
            r0.getLifecycle().removeObserver(this.a);     // Catch: Throwable -> L9
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");     // Catch: Throwable -> L9
        }
    }

    static {
    }

    public ShoppingPurchaseButton(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ShoppingPurchaseButton(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void j() {
        View r0 = this.e;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r1 = null;
    L5:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        if (r2 == null) goto L8;
        r2.leftMargin = 0;
        r2.rightMargin = 0;
        r2.topMargin = 0;
        r2.bottomMargin = 0;
        r0.setLayoutParams(r2);
    L8:
        this.e.setPadding(0, 0, 0, 0);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void pauseCountDown() {
        l1 r0 = this.f.c;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void resumeCountDown() {
        l1 r0 = this.f.c;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void stopCountDown() {
        g r0 = this.f;
        l1 r1 = r0.c;
        if (r1 == null) goto L5;
        r1.a();
    L5:
        r0.c = null;
        post(new b(this));
    }

    @Override // com.bytedance.android.shopping.widget.buybutton.c
    public final void c(com.bytedance.android.shopping.widget.buybutton.a r20) {
        Intrinsics.checkNotNullParameter(r20, "buttonVO");
        this.d.removeAllViews();
        g r2 = this.f;
        l1 r3 = r2.c;
        if (r3 == null) goto L5;
        ((ArrayList) r3.j).remove(r2);
    L5:
        Long r4 = null;
        r2.c = null;
        r2.d = -1;
        String r5 = r20.a;
        if (r5 != null) goto L8;
    L11:
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        this.a.setVisibility(8);
    L16:
        Iterator<T> r7 = r20.b.iterator();
        int r8 = 0;
    L18:
        if (r7.hasNext() == false) goto L101;
        l r9 = (l) r7.next();
        boolean r10 = com.bytedance.android.ec.model.b.a(r9.f);
        j r11 = new j(getContext(), r10);
        r11.getBuyText().setText(r9.a);
        String r0 = r9.b;
        if (r0 != null) goto L22;
    L25:
        boolean r1 = true;
    L26:
        if (r1 == false) goto L41;
        r11.getSubBuyText().setVisibility(8);
        View r12 = r11.getSubBuyTextContainer();
        if (r12 == null) goto L30;
        r12.setVisibility(8);
    L30:
        View r13 = r11.getTriangleView();
        if (r13 == null) goto L33;
        r13.setVisibility(8);
    L33:
        View r14 = r11.getBuyTextContainer();
        if (r14 == null) goto L48;
        Object r15 = r14.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == true) goto L38;
        r15 = r4;
    L38:
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        if (r16 == null) goto L48;
        r16.topMargin = 0;
        r16.rightMargin = 0;
        r14.setLayoutParams(r16);
    L48:
        String r17 = r9.c;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L51
        Object r19 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r17)));     // Catch: Throwable -> L51
    L54:
        if (Result.isFailure-impl(r19) == false) goto L56;
        r19 = r4;
    L56:
        Integer r21 = (Integer) r19;
        if (r21 == null) goto L61;
        int r22 = r21.intValue();
        r11.getBuyText().setTextColor(r22);
        if (r10 == true) goto L61;
        r11.getSubBuyText().setTextColor(r22);
    L61:
        Integer r23 = r9.g;
        if (r23 == null) goto L64;
        int r24 = r23.intValue();
        r11.getProductButtonContainer().setBackgroundResource(r24);
    L64:
        ButtonType r25 = r9.f;
        Intrinsics.checkNotNullParameter(r25, "$this$isDepositPresalePromotion");
        if (r25 != ButtonType.DepositPresale) goto L67;
        boolean r26 = true;
    L68:
        if (r26 == false) goto L85;
        g r27 = this.f;
        ButtonTime r110 = r9.e;
        if (r110 == null) goto L72;
        Long r111 = r110.getServerTime();
    L73:
        ButtonTime r112 = r9.e;
        if (r112 == null) goto L76;
        Long r113 = r112.getEndTime();
    L77:
        r27.getClass();
        if (r111 == null) goto L85;
        r111.longValue();
        if (r113 == null) goto L85;
        r113.longValue();
        if (r27.c != null) goto L85;
        TimeUnit r114 = TimeUnit.SECONDS;
        l1 r115 = new l1(r114.toMillis(r113.longValue() - r111.longValue()), r114.toMillis(1), r27);
        r27.c = r115;
        r115.d();
        r27.d = r8;
        goto L85
    L76:
        r113 = r4;
        goto L77
    L72:
        r111 = r4;
    L85:
        Boolean r28 = r9.d;
        if (r28 != null) goto L88;
    L92:
        ViewGroup r29 = this.d;
        if (r10 == false) goto L95;
        int r30 = 50;
    L96:
        LinearLayout.LayoutParams r31 = new LinearLayout.LayoutParams(0, vf4.a.b(Integer.valueOf(r30)), 1.0f);
        if (r8 <= 0) goto L99;
        int r32 = vf4.a.b(9);
    L100:
        r31.setMarginStart(r32);
        Unit r33 = Unit.INSTANCE;
        r29.addView(r11, r31);
        r8 = r8 + 1;
        r4 = null;
        goto L18
    L99:
        r32 = 0;
        goto L100
    L95:
        r30 = 44;
        goto L96
    L88:
        if (r28.booleanValue() == false) goto L90;
        float r34 = 0.5f;
    L91:
        r11.setAlpha(r34);
        goto L92
    L90:
        r34 = 1.0f;
        goto L91
    L67:
        r26 = false;
    L51:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L54
    L41:
        r11.getSubBuyText().setVisibility(0);
        View r35 = r11.getSubBuyTextContainer();
        if (r35 == null) goto L44;
        r35.setVisibility(0);
    L44:
        View r36 = r11.getTriangleView();
        if (r36 == null) goto L47;
        r36.setVisibility(0);
    L47:
        r11.getSubBuyText().setText(r9.b);
        goto L48
    L22:
        if (r0.length() == 0) goto L25;
        r1 = false;
        goto L26
    L101:
        return;
    L15:
        this.a.setVisibility(0);
        this.b.setText(r20.a);
        goto L16
    L8:
        if (r5.length() == 0) goto L11;
        r6 = false;
        goto L13
    }

    @Override // com.bytedance.android.shopping.widget.buybutton.c
    public final void d(ECResultDialogContentVO r9) {
        Intrinsics.checkNotNullParameter(r9, "appointContent");
        int r0 = ECSdk.a;
        IECCommonService r1 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r1 == null) goto L6;
        IECCommonService.a.c(r1, getContext(), r9, null, null, null, 96);
        return;
    }

    @Override // com.bytedance.android.shopping.widget.buybutton.c
    public final void f(String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Activity r0 = d0.a.getActivity(getContext());
        if (r0 != null) goto L7;
        return;
    L7:
        com.bytedance.android.shopping.router.c.a(r3, r0, "");
    }

    @Override // com.bytedance.android.shopping.widget.buybutton.c
    public final void g(String r8) {
        Context r0 = getContext();
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        ECLiveHybridUtil.k(r0, r8, false, false, false, null, 252);
    }

    public final void i(zk3.a r70) {
        Intrinsics.checkNotNullParameter(r70, "data");
        g r3 = this.f;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r70, "data");
        int r4 = e.u;
        e r5 = r3.a;
        Intrinsics.checkNotNullParameter(r5, "model");
        Intrinsics.checkNotNullParameter(r70, "data");
        NameComponent r1 = r70.b;
        List<BuyButtonComponent> r6 = r70.a;
        if (r6 != null) goto L5;
        r6 = CollectionsKt.emptyList();
    L5:
        Map<String, String> r7 = r70.f;
        BasicComponent r8 = r70.c;
        TrackComponent r9 = r70.d;
        if (r1 == null) goto L8;
        String r13 = r1.getName();
    L9:
        if (r1 == null) goto L11;
        String r14 = r1.getSchema();
    L12:
        if (r8 == null) goto L14;
        String r26 = r8.getPromotionSource();
    L15:
        if (r9 == null) goto L17;
        String r20 = r9.getGroupId();
    L19:
        if (r8 == null) goto L22;
        String r10 = r8.getShopId();
        if (r10 == null) goto L22;
    L23:
        String r11 = r7.get("author_id");
        if (r11 != null) goto L26;
        String r15 = "";
    L27:
        String r12 = r7.get("sec_author_id");
        if (r12 != null) goto L30;
        r12 = "";
    L30:
        if (r8 == null) goto L33;
        String r16 = r8.getProductId();
        if (r16 == null) goto L33;
    L34:
        if (r8 == null) goto L37;
        String r17 = r8.getPromotionId();
        if (r17 == null) goto L37;
    L38:
        String r18 = r7.get("item_id");
        if (r18 != null) goto L41;
        String r23 = "";
    L42:
        String r19 = r7.get("meta_params");
        if (r19 != null) goto L45;
        String r24 = "";
    L46:
        String r21 = r7.get("entrance_info");
        if (r21 != null) goto L49;
        String r25 = "";
    L50:
        String r22 = r7.get("marketing_channel");
        if (r22 != null) goto L53;
        r22 = "";
        String r32 = r22;
    L54:
        String r2 = r7.get("live_room_id");
        if (r2 != null) goto L57;
        String r27 = r32;
    L58:
        String r28 = r7.get("enter_from");
        if (r28 != null) goto L61;
        String r29 = r32;
    L62:
        if (r9 == null) goto L64;
        String r210 = r9.getLogExtra();
    L65:
        String r30 = r7.get("track_additions");
        if (r30 != null) goto L68;
        String r211 = r32;
    L69:
        List<PromotionDiscountLabel> r31 = r70.e;
        List<BuyButtonComponent> r33 = r6;
        ArrayList r34 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r33, 10));
        Iterator r35 = r33.iterator();
    L71:
        if (r35.hasNext() == false) goto L161;
        BuyButtonComponent r36 = (BuyButtonComponent) r35.next();
        PromotionProductLink r37 = r36.getLinks();
        String r38 = r36.getText();
        String r39 = r36.getSubText();
        Integer r310 = r36.getOrderStatus();
        String r311 = r36.getTips();
        Integer r312 = r36.getApplyCoupon();
        Boolean r41 = r36.getAlreadyBuy();
        Boolean r42 = r36.getNeedCheckSku();
        Long r40 = r36.getApplyCouponPrice();
        Integer r43 = r36.getPayType();
        ButtonTipsStruct r44 = r36.getButtonTips();
        String r45 = r36.getWordColor();
        Boolean r46 = r36.getGrayButton();
        ButtonTime r47 = r36.getButtonTime();
        Integer r48 = r36.getButtonType();
        if (r48 != null) goto L76;
    L78:
        if (r48 != null) goto L80;
        Iterator r110 = r35;
        String r111 = r16;
    L83:
        if (r48 != null) goto L86;
    L88:
        if (r48 != null) goto L91;
    L93:
        if (r48 != null) goto L96;
    L98:
        if (r48 != null) goto L101;
    L103:
        if (r48 != null) goto L106;
    L108:
        if (r48 != null) goto L111;
    L113:
        if (r48 != null) goto L116;
    L118:
        if (r48 != null) goto L121;
    L123:
        if (r48 != null) goto L126;
    L128:
        if (r48 != null) goto L131;
    L133:
        if (r48 != null) goto L136;
    L138:
        if (r48 != null) goto L141;
    L143:
        if (r48 != null) goto L146;
    L148:
        if (r48 != null) goto L151;
    L153:
        if (r48 != null) goto L156;
    L158:
        ButtonType r49 = ButtonType.NORMAL;
    L159:
        ButtonType r410 = r49;
    L160:
        r34.add(new k(r310, r37, r38, r39, r311, r312, r40, r41, r42, r43, r44, r45, r46, r47, r410));
        r35 = r110;
        r16 = r111;
        goto L71
    L156:
        if (r48.intValue() != 15) goto L158;
        r49 = ButtonType.MatchPurchase;
        goto L159
    L151:
        if (r48.intValue() != 13) goto L153;
        r49 = ButtonType.MultiChannelSale;
        goto L159
    L146:
        if (r48.intValue() != 3) goto L148;
        r49 = ButtonType.DepositFindGoods;
        goto L159
    L141:
        if (r48.intValue() != 2) goto L143;
        r49 = ButtonType.Presale;
        goto L159
    L136:
        if (r48.intValue() != 14) goto L138;
        r49 = ButtonType.UserLimit;
        goto L159
    L131:
        if (r48.intValue() != 102) goto L133;
        r49 = ButtonType.DepositPresaleNotAppointed;
        goto L159
    L126:
        if (r48.intValue() != 101) goto L128;
        r49 = ButtonType.DepositPresaleAppointed;
        goto L159
    L121:
        if (r48.intValue() != 10) goto L123;
        r49 = ButtonType.DepositPresale;
        goto L159
    L116:
        if (r48.intValue() != 121) goto L118;
        r49 = ButtonType.GroupBuyAlone;
        goto L159
    L111:
        if (r48.intValue() != 120) goto L113;
        r49 = ButtonType.GroupBuy;
        goto L159
    L106:
        if (r48.intValue() != 7) goto L108;
        r49 = ButtonType.Seckill;
        goto L159
    L101:
        if (r48.intValue() != 12) goto L103;
        r49 = ButtonType.Auction;
        goto L159
    L96:
        if (r48.intValue() != 72) goto L98;
        r49 = ButtonType.MillionSubsid;
        goto L159
    L91:
        if (r48.intValue() != 142) goto L93;
        r49 = ButtonType.TimingSaleNotAppointed;
        goto L159
    L86:
        if (r48.intValue() != 141) goto L88;
        r49 = ButtonType.TimingSaleAppointed;
        goto L159
    L80:
        r110 = r35;
        r111 = r16;
        if (r48.intValue() != 140) goto L83;
        r49 = ButtonType.TimingSale;
        goto L159
    L76:
        if (r48.intValue() != 0) goto L78;
        r110 = r35;
        r410 = ButtonType.NORMAL;
        r111 = r16;
        goto L160
    L161:
        String r112 = r16;
        d r50 = r5.a;
        Intrinsics.checkNotNullParameter(r50, "presenter");
        Intrinsics.checkNotNullParameter(r112, "productId");
        Intrinsics.checkNotNullParameter(r17, "promotionId");
        Intrinsics.checkNotNullParameter(r10, "shopId");
        Intrinsics.checkNotNullParameter(r15, "authorId");
        Intrinsics.checkNotNullParameter(r12, "secAuthorId");
        Intrinsics.checkNotNullParameter(r22, "marketingChannel");
        Intrinsics.checkNotNullParameter(r34, "buttonModelList");
        String r113 = r17;
        String r114 = r10;
        e r51 = new e(r50, r13, r14, r112, r113, r114, r15, r12, r20, r22, r27, r23, r24, r25, r26, r29, r210, r211, r31, r34);
        r3.a = r51;
        String r52 = r51.d;
        String r53 = r51.e;
        String r54 = r51.g;
        String r55 = r51.h;
        String r56 = r51.i;
        String r57 = r51.f;
        String r58 = r51.l;
        String r115 = r51.m;
        String r116 = r51.k;
        boolean r60 = SettingKeys.getENABLE_3D_BUTTON_CLICK();
        String r117 = r51.c;
        String r118 = r51.p;
        Map r64 = e.b(r51.q);
        Map r65 = e.b(r51.r);
        String r119 = r51.j;
        String r120 = r51.n;
        if (r120 != null) goto L164;
        String r66 = r32;
    L165:
        String r121 = r51.o;
        List<PromotionDiscountLabel> r0 = r51.s;
        List<k> r59 = r51.t;
        ArrayList r61 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r59, 10));
        Iterator r62 = r59.iterator();
    L166:
        boolean r122 = false;
        long r212 = 0;
        if (r62.hasNext() == false) goto L215;
        k r63 = (k) r62.next();
        Iterator r213 = r62;
        Boolean r67 = r63.m;
        if (r67 == null) goto L171;
        boolean r313 = r67.booleanValue();
    L172:
        Boolean r68 = r63.i;
        if (r68 == null) goto L175;
        boolean r314 = r68.booleanValue();
    L176:
        Integer r69 = r63.f;
        if (r69 != null) goto L179;
        String r214 = r118;
    L182:
        boolean r315 = false;
    L183:
        Long r71 = r63.g;
        if (r71 == null) goto L186;
        long r316 = r71.longValue();
    L187:
        PromotionProductLink r72 = r63.b;
        ButtonType r123 = r63.o;
        String r215 = r117;
        Integer r124 = r63.a;
        String r216 = r116;
        ButtonTime r125 = r63.n;
        String r217 = r115;
        Intrinsics.checkNotNullParameter(r123, "$this$isInSecKillActivity");
        Intrinsics.checkNotNullParameter(r123, "$this$isSecKillProduct");
        if (r123 != ButtonType.Seckill) goto L190;
        boolean r126 = true;
    L191:
        if (r126 == true) goto L193;
        boolean r411 = false;
    L214:
        r61.add(new SingleClickParam(r313, r314, r315, r316, r72, null, r123, r124, r411, r63.k, 32, null));
        r62 = r213;
        r118 = r214;
        r117 = r215;
        r116 = r216;
        r115 = r217;
        goto L166
    L193:
        if (r125 == null) goto L197;
        Long r127 = r125.getServerTime();
        if (r127 == null) goto L197;
        long r218 = r127.longValue();
    L198:
        if (r125 == null) goto L202;
        Long r128 = r125.getPreBeginTime();
        if (r128 == null) goto L202;
        long r317 = r128.longValue();
    L203:
        if (r125 == null) goto L208;
        Long r129 = r125.getEndTime();
        if (r129 == null) goto L208;
        r212 = r129.longValue();
    L208:
        if (r317 <= r218) goto L211;
    L213:
        r411 = r122;
        goto L214
    L211:
        if (r212 <= r218) goto L213;
        r122 = true;
    L202:
        r317 = 0;
    L197:
        r218 = 0;
        goto L198
    L190:
        r126 = false;
        goto L191
    L186:
        r316 = 0;
        goto L187
    L179:
        r214 = r118;
        if (r69.intValue() != 1) goto L182;
        r315 = true;
        goto L183
    L175:
        r314 = false;
        goto L176
    L171:
        r313 = true;
        goto L172
    L215:
        ClickButtonParam r73 = new ClickButtonParam(r52, r53, r121, r54, r55, r56, r57, r58, r115, r116, r60, r117, r118, r119, r64, r65, r66, r0, r61);
        c r74 = r3.e;
        if (r70.b == null) goto L218;
        boolean r130 = true;
    L219:
        r74.setProductAreaVisible(r130);
        c r75 = r3.e;
        e r76 = r3.a;
        String r77 = r76.b;
        List<k> r78 = r76.t;
        ArrayList r79 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r78, 10));
        Iterator<T> r80 = r78.iterator();
        int r81 = 0;
    L221:
        if (r80.hasNext() == false) goto L282;
        Object r82 = r80.next();
        int r83 = r81 + 1;
        if (r81 >= 0) goto L225;
        CollectionsKt.throwIndexOverflow();
    L225:
        k r84 = (k) r82;
        String r131 = r84.c;
        String r132 = r84.d;
        String r133 = r84.l;
        Boolean r134 = r84.m;
        ButtonTime r135 = r84.n;
        ButtonType r136 = r84.o;
        if (r135 == null) goto L230;
        Long r85 = r135.getServerTime();
        if (r85 == null) goto L230;
        long r137 = r85.longValue();
    L231:
        if (r135 == null) goto L235;
        Long r86 = r135.getPreBeginTime();
        if (r86 == null) goto L235;
        long r219 = r86.longValue();
    L236:
        if (r135 == null) goto L240;
        Long r87 = r135.getBeginTime();
        if (r87 == null) goto L240;
        long r220 = r87.longValue();
    L241:
        if (r135 == null) goto L245;
        Long r88 = r135.getEndTime();
        if (r88 == null) goto L245;
        long r221 = r88.longValue();
    L247:
        switch(f.a[r84.o.ordinal()]) {
            case 1: goto L278;
            case 2: goto L277;
            case 3: goto L277;
            case 4: goto L277;
            case 5: goto L263;
            case 6: goto L263;
            case 7: goto L263;
            case 8: goto L262;
            case 9: goto L261;
            case 10: goto L260;
            case 11: goto L250;
            case 12: goto L249;
            default: goto L280;
        };
    L249:
        int r89 = 2131247967;
    L279:
        Integer r138 = r89;
    L281:
        r79.add(new l(r131, r132, r133, r134, r135, r136, r138));
        r81 = r83;
        goto L221
    L250:
        if (r135 != null) goto L253;
    L258:
        int r90 = 2131247965;
    L259:
        r89 = Integer.valueOf(r90);
        goto L279
    L253:
        if (r220 > r137) goto L258;
        if (r221 < r137) goto L258;
        r90 = 2131247966;
        goto L259
    L260:
        r89 = 2131234422;
        goto L279
    L261:
        r89 = 2131234424;
        goto L279
    L262:
        r89 = 2131233350;
        goto L279
    L263:
        if (r135 == null) goto L280;
        if (r137 < r221) goto L269;
        r89 = 2131231243;
        goto L279
    L269:
        if (r220 > r137) goto L275;
        if (r221 < r137) goto L275;
        r89 = 2131231241;
    L275:
        if (r137 < r219) goto L280;
        r89 = 2131231241;
        goto L279
    L277:
        r89 = 2131234352;
        goto L279
    L278:
        r89 = 2131234360;
    L280:
        r138 = null;
    L245:
        r221 = 0;
    L240:
        r220 = 0;
    L235:
        r219 = 0;
    L230:
        r137 = 0;
        goto L231
    L282:
        r75.c(new com.bytedance.android.shopping.widget.buybutton.a(r77, r79));
        r3.e.setProductTitleClickListener(new h(r3, r73));
        ArrayList r91 = new ArrayList();
        Iterator r92 = r73.getSingleClickParams().iterator();
        int r93 = 0;
    L284:
        if (r92.hasNext() == false) goto L286;
        r91.add(new i(r3, (SingleClickParam) r92.next(), r73, r93));
        r93 = r93 + 1;
        goto L284
    L286:
        r3.e.setBuyButtonClickListener(r91);
        return;
    L218:
        r130 = false;
        goto L219
    L164:
        r66 = r120;
        goto L165
    L68:
        r211 = r30;
        goto L69
    L64:
        r210 = null;
        goto L65
    L61:
        r29 = r28;
        goto L62
    L57:
        r27 = r2;
        goto L58
    L53:
        r32 = "";
        goto L54
    L49:
        r25 = r21;
        goto L50
    L45:
        r24 = r19;
        goto L46
    L41:
        r23 = r18;
    L37:
        r17 = "";
    L33:
        r16 = "";
        goto L34
    L26:
        r15 = r11;
    L22:
        r10 = "";
        goto L23
    L17:
        r20 = null;
        goto L19
    L14:
        r26 = null;
        goto L15
    L11:
        r14 = null;
        goto L12
    L8:
        r13 = null;
        goto L9
    }

    @Override // com.bytedance.android.shopping.widget.buybutton.c
    public final boolean openMiniApp(String r3) {
        return com.bytedance.android.ec.sdk.helper.m.a.a(getContext(), r3);
    }

    @Override // com.bytedance.android.shopping.widget.buybutton.c
    public void setBuyButtonClickListener(List<? extends View.OnClickListener> r5) {
        Intrinsics.checkNotNullParameter(r5, "listeners");
        Iterator r0 = com.bytedance.commerce.base.view.b.a(this.d).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        ((View) r0.next()).setOnClickListener((View.OnClickListener) CollectionsKt.getOrNull(r5, r1));
        r1 = r1 + 1;
        goto L4
    }

    @Override // com.bytedance.android.shopping.widget.buybutton.c
    public void setProductAreaVisible(boolean r2) {
        if (r2 == false) goto L4;
        this.a.setVisibility(0);
        return;
    L4:
        this.a.setVisibility(8);
    }

    @Override // com.bytedance.android.shopping.widget.buybutton.c
    public void setProductTitleClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.setOnClickListener(r2);
    }

    @Override // com.bytedance.android.shopping.widget.buybutton.c
    public final void e(int r7, long r8) {
        if (r7 >= 0) goto L4;
        return;
    L4:
        View r9 = this.d.getChildAt(r7);
        if ((r9 instanceof j) == true) goto L7;
        r9 = null;
    L7:
        j r10 = (j) r9;
        if (r10 != null) goto L10;
        return;
    L10:
        int r0 = c2.h;
        c2 r11 = c2.a.a(getContext(), r8, false);
        if (r10.getSubBuyText().getVisibility() != 0) goto L13;
        boolean r12 = true;
    L14:
        if (r12 == true) goto L17;
        r10.getSubBuyText().setVisibility(0);
    L17:
        if (r11.a <= 0) goto L19;
        TextView r13 = r10.getSubBuyText();
        int r14 = g1.a;
        r13.setText(g1.a.c(getContext(), 2131913951, new Object[]{Integer.valueOf(r11.a), r11.c, r11.d, r11.e}));
        return;
    L19:
        TextView r15 = r10.getSubBuyText();
        int r16 = g1.a;
        r15.setText(g1.a.c(getContext(), 2131913950, new Object[]{r11.c, r11.d, r11.e}));
        return;
    L13:
        r12 = false;
        goto L14
    }

    @Override // com.bytedance.android.shopping.widget.buybutton.c
    public final void h(String r5, Integer r6) {
        if (a2.b(r5) == false) goto L8;
        com.bytedance.android.ec.sdk.helper.i r7 = com.bytedance.android.ec.sdk.helper.i.a;
        Context r0 = getContext();
        if (r5 != null) goto L7;
        r5 = "";
    L7:
        r7.e(r0, r5, false, false);
        return;
    L8:
        if (r6 == null) goto L12;
        com.bytedance.android.ec.sdk.helper.i r8 = com.bytedance.android.ec.sdk.helper.i.a;
        Context r1 = getContext();
        int r2 = g1.a;
        r8.e(r1, g1.a.c(getContext(), r6.intValue(), new Object[0]), false, false);
        return;
    }

    public ShoppingPurchaseButton(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.f = new g(this);
        LayoutInflater.from(r2).inflate(2131564617, this);
        this.a = findViewById(2131383180);
        this.b = (TextView) findViewById(2131383179);
        this.c = findViewById(2131383169);
        this.d = (ViewGroup) findViewById(2131386553);
        this.e = findViewById(2131364505);
    }

    @Override // com.bytedance.android.shopping.widget.buybutton.c
    public final void a(SingleClickParam r129, ClickButtonParam r130, com.bytedance.android.btm.api.model.d r131) {
        Intrinsics.checkNotNullParameter(r129, "singleClickParam");
        Intrinsics.checkNotNullParameter(r130, "param");
        Intrinsics.checkNotNullParameter(r131, "btmModel");
        Activity r0 = d0.a.getActivity(this);
        String r6 = null;
        if ((r0 instanceof FragmentActivity) == true) goto L5;
        r0 = null;
    L5:
        FragmentActivity r1 = (FragmentActivity) r0;
        if (r1 == null) goto L37;
        FragmentManager r2 = r1.getSupportFragmentManager();
        if (r2 == null) goto L39;
        int r4 = ECSdk.a;
        IECCommonService r18 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r18 == null) goto L38;
        PromotionProductLink r5 = r129.getLinks();
        if (r5 == null) goto L15;
        r6 = r5.getH5Url();
    L15:
        String r49 = r6;
        boolean r50 = r129.getApplyCoupon();
        String r51 = r130.getSchema();
        String r7 = r130.getPromotionId();
        String r8 = "";
        if (r7 != null) goto L18;
        String r35 = "";
    L19:
        String r34 = r130.getProductId();
        int r46 = ul.d.b(5, false, 6);
        String r9 = r130.getAuthorId();
        if (r9 != null) goto L22;
        String r40 = "";
    L23:
        String r10 = r130.getSecAuthorId();
        if (r10 != null) goto L26;
        String r41 = "";
    L27:
        String r43 = r130.getGroupId();
        String r38 = r130.getShopId();
        String r44 = r130.getRoomId();
        ButtonType r3 = r129.getButtonType();
        Intrinsics.checkNotNullParameter(r3, "$this$isGroupBuy");
        if (r3 != ButtonType.GroupBuy) goto L30;
        boolean r45 = true;
    L31:
        SkuExtraData r21 = new SkuExtraData(null, null, false, null, null, null, null, null, null, null, r130.getMarketingChannel(), null, null, 7167, null);
        String r85 = r130.getEntranceInfo();
        Pair[] r11 = new Pair[1];
        String r12 = r130.getEnterFrom();
        if (r12 == null) goto L35;
        r8 = r12;
    L35:
        r11[0] = TuplesKt.to("source_3d", r8);
        IECCommonService.a.d(r18, r2, new SkuParams(null, r21, null, null, null, 0, null, null, null, false, false, null, null, false, r34, r35, r130.getPromotionSource(), false, r38, null, r40, r41, null, r43, r44, r45, r46, 601, null, r49, r50 ? 1 : 0, r51, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, false, false, null, null, null, null, 0.0f, null, null, null, null, null, null, r85, null, MapsKt.hashMapOf(r11), null, null, null, 0, "ShoppingPurchaseButton-openSkuPanel", null, null, null, null, null, false, null, null, null, null, null, null, null, 0, 0, false, null, null, null, false, null, null, null, null, null, null, null, null, 273301501, -1, -4210955, 31, null), null, r131, null, null, null, null, null, null, null, 0, null, null, null, 30720);
        return;
    L30:
        r45 = false;
        goto L31
    L26:
        r41 = r10;
        goto L27
    L22:
        r40 = r9;
        goto L23
    L18:
        r35 = r7;
        goto L19
    L38:
        return;
    L39:
        return;
    }

    @Override // com.bytedance.android.shopping.widget.buybutton.c
    public final void b(String r4, Map<String, String> r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "mergeParams");
        if (r4 != null) goto L5;
        return;
    L5:
        Uri r7 = UriProtector.parse(r4);
        Iterator<Map.Entry<String, String>> r8 = r5.entrySet().iterator();
    L7:
        if (r8.hasNext() == false) goto L11;
        Map.Entry<String, String> r0 = r8.next();
        String r1 = r0.getKey();
        String r2 = r0.getValue();
        if (r6.containsKey(r1) == true) goto L7;
        r7 = p0.e(r7, r1, r2);
        goto L7
    L11:
        String r9 = r7.toString();
        Iterator<Map.Entry<String, String>> r10 = r6.entrySet().iterator();
    L13:
        if (r10.hasNext() == false) goto L15;
        Map.Entry<String, String> r11 = r10.next();
        r9 = p0.g(r9, r11.getKey(), r11.getValue());
        goto L13
    L15:
        Map r12 = bf.a.a;
        bf.a.c(getContext(), UriProtector.parse(r9), false, false);
    }

    public /* synthetic */ ShoppingPurchaseButton(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
