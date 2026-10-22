package com.bytedance.android.shopping.prepurchase.business.pdp.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ec.core.widget.ECLottieAnimationView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonConfig;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonElement;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonMeta;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonVO;
import com.bytedance.android.shopping.anchorv4.bottom.BottomTipMeta;
import com.bytedance.android.shopping.anchorv4.bottom.CartNumberComponent;
import com.bytedance.android.shopping.anchorv4.bottom.EnterCartMeta;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.components.LynxCardComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.helper.PdpBottomNavBarHelper;
import com.bytedance.android.shopping.anchorv4.helper.w;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.TagsScrollBoxComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ImageExtensionsKt;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.BottomTipComponent;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0012B'\b\u0007\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010;\u001a\u00020\u000b¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0017\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\b\u0010\u000f\u001a\u0004\u0018\u00010\rR#\u0010\u0016\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R#\u0010\u001a\u001a\n \u0011*\u0004\u0018\u00010\u00030\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0019R#\u0010\u001d\u001a\n \u0011*\u0004\u0018\u00010\u00030\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0019R#\u0010 \u001a\n \u0011*\u0004\u0018\u00010\u00030\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0019R#\u0010$\u001a\n \u0011*\u0004\u0018\u00010\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0013\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0013\u001a\u0004\b,\u0010-R$\u00106\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006>"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/business/pdp/view/BottomButtonView;", "Landroid/widget/FrameLayout;", "Lti/k;", "Landroid/widget/LinearLayout;", "enlargedView", "", "setEnlargedConfig", "", "isVisible", "setTipsVisible", "(Ljava/lang/Boolean;)V", "", "getLynxLocationY", "Landroid/view/View;", "getSuperMarketLynxView", "getCartIcon", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/TagsScrollBoxComponentView;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getLeftGroupItems", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/TagsScrollBoxComponentView;", "leftGroupItems", "b", "getRightGroupButtons", "()Landroid/widget/LinearLayout;", "rightGroupButtons", "c", "getScaleContent", "scaleContent", "d", "getNormalButtons", "normalButtons", "e", "getSuperMarketButtons", "()Landroid/widget/FrameLayout;", "superMarketButtons", "Lcom/bytedance/android/shopping/anchorv4/bottom/CartNumberComponent;", "g", "getCartNumberComponent", "()Lcom/bytedance/android/shopping/anchorv4/bottom/CartNumberComponent;", "cartNumberComponent", "Lcom/bytedance/android/shopping/prepurchase/business/pdp/components/layer/nav/legacy/BottomTipComponent;", "h", "getBottomTipComponent", "()Lcom/bytedance/android/shopping/prepurchase/business/pdp/components/layer/nav/legacy/BottomTipComponent;", "bottomTipComponent", "Lcom/bytedance/android/shopping/prepurchase/business/pdp/view/BottomButtonElementView;", "k", "Lcom/bytedance/android/shopping/prepurchase/business/pdp/view/BottomButtonElementView;", "getFirstButtonElementView", "()Lcom/bytedance/android/shopping/prepurchase/business/pdp/view/BottomButtonElementView;", "setFirstButtonElementView", "(Lcom/bytedance/android/shopping/prepurchase/business/pdp/view/BottomButtonElementView;)V", "firstButtonElementView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomButtonView extends FrameLayout implements ti.k {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public BottomButtonVO f;
    public final Lazy g;
    public final Lazy h;
    public ti.l i;
    public com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d j;
    public BottomButtonElementView k;
    public final int l;
    public boolean m;
    public ECLottieAnimationView n;
    public View o;

    public static final class a {
    }

    public static final class b implements View.OnTouchListener {
        public final /* synthetic */ View a;

        public b(View r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r2, MotionEvent r3) {
            if (r3 == null) goto L4;
            Integer r4 = Integer.valueOf(r3.getAction());
        L6:
            if (r4 != null) goto L9;
        L11:
            if (r4 != null) goto L14;
        L16:
            this.a.setVisibility(8);
        L17:
            return false;
        L14:
            if (r4.intValue() != 2) goto L16;
        L15:
            this.a.setVisibility(0);
            goto L17
        L9:
            if (r4.intValue() != 0) goto L11;
        L4:
            r4 = null;
            goto L6
        }
    }

    static {
    }

    public BottomButtonView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BottomButtonView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final BottomTipComponent getBottomTipComponent() {
        return (BottomTipComponent) this.h.getValue();
    }

    private final CartNumberComponent getCartNumberComponent() {
        return (CartNumberComponent) this.g.getValue();
    }

    private final TagsScrollBoxComponentView getLeftGroupItems() {
        return (TagsScrollBoxComponentView) this.a.getValue();
    }

    private final LinearLayout getNormalButtons() {
        return (LinearLayout) this.d.getValue();
    }

    private final LinearLayout getRightGroupButtons() {
        return (LinearLayout) this.b.getValue();
    }

    private final LinearLayout getScaleContent() {
        return (LinearLayout) this.c.getValue();
    }

    private final FrameLayout getSuperMarketButtons() {
        return (FrameLayout) this.e.getValue();
    }

    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        Intrinsics.checkNotNullParameter("", "errorMessage");
    }

    public final int getLynxLocationY() {
        ti.l r0 = this.i;
        if (r0 == null) goto L6;
        View r1 = r0.getHybridView();
        if (r1 == null) goto L6;
    L10:
        if (r1 == null) goto L13;
        int[] r2 = new int[2];
        r1.getLocationOnScreen(r2);
        return r2[1];
    L13:
        return 0;
    L6:
        ti.l r3 = this.i;
        if (r3 == null) goto L9;
        r1 = r3.b();
        goto L10
    L9:
        r1 = null;
        goto L10
    }

    public final View getSuperMarketLynxView() {
        ti.l r0 = this.i;
        if (r0 == null) goto L6;
        View r1 = r0.getHybridView();
        if (r1 == null) goto L6;
        return r1;
    L6:
        ti.l r2 = this.i;
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.b();
    }

    public final void d() {
        getCartNumberComponent().getClass();
        ti.l r0 = this.i;
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    public final View getCartIcon() {
        return this.o;
    }

    public final BottomButtonElementView getFirstButtonElementView() {
        return this.k;
    }

    private final void setEnlargedConfig(LinearLayout r3) {
        float r0 = k1.m(r3.getContext()) / q.a(375);
        r3.setPivotX(0.0f);
        r3.setPivotY(0.0f);
        r3.setScaleX(r0);
        r3.setScaleY(r0);
    }

    public final void f(boolean r5) {
        ti.l r0 = this.i;
        if (r0 == null) goto L10;
        JSONObject r1 = new JSONObject();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        Result.constructor-impl(r1.put("visible", r5));     // Catch: Throwable -> L7
    L9:
        Unit r3 = Unit.INSTANCE;
        r0.sendJsEvent("pageVisibilityChange", r1);
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L10:
        if (r5 == true) goto L20;
        ECLiveHybridUtil.f("androidInstantProductDetailHide", new JSONObject());     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    }

    public final void h(int r2) {
        getCartNumberComponent().c(r2);
    }

    public final void onFirstScreen(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
    }

    public final void onLoadSuccess(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
    }

    public final void onRuntimeReady(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
    }

    public final void setFirstButtonElementView(BottomButtonElementView r1) {
        this.k = r1;
    }

    public final void setTipsVisible(Boolean r3) {
        BottomTipComponent r0 = getBottomTipComponent();
        r0.getClass();
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L6;
        r0.d.setVisibility(0);
        return;
    L6:
        if (Intrinsics.areEqual(r3, Boolean.FALSE) == false) goto L10;
        r0.d.setVisibility(8);
        return;
    }

    public final void a(BottomButtonVO r21, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d r22) {
        if (PdpBottomNavBarHelper.d == false) goto L5;
        setPadding(0, 0, 0, com.bytedance.android.shopping.extensions.b.a(4));
    L5:
        LinearLayout r1 = getNormalButtons();
        if (r1 == null) goto L8;
        r1.setVisibility(0);
    L8:
        LinearLayout r2 = getRightGroupButtons();
        if (r2 == null) goto L11;
        r2.setVisibility(0);
    L11:
        getLeftGroupItems().removeAllViews();
        getRightGroupButtons().removeAllViews();
        TagsScrollBoxComponent r3 = r21.getLeftItems();
        Radius r4 = null;
        if (r3 == null) goto L14;
        getLeftGroupItems().a(r3, null, true, r22.getSessionId());
    L14:
        Object r5 = CollectionsKt.getOrNull(com.bytedance.commerce.base.view.b.a(getLeftGroupItems()), 0);
        if ((r5 instanceof ViewGroup) == true) goto L17;
        r5 = null;
    L17:
        ViewGroup r6 = (ViewGroup) r5;
        if (r6 == null) goto L46;
        List r7 = com.bytedance.commerce.base.view.b.a(r6);
        if (r7 == null) goto L46;
        Iterator r8 = r7.iterator();
        int r9 = 0;
    L23:
        if (r8.hasNext() == false) goto L46;
        Object r10 = r8.next();
        int r11 = r9 + 1;
        if (r9 >= 0) goto L27;
        CollectionsKt.throwIndexOverflow();
    L27:
        View r12 = (View) r10;
        TagsScrollBoxComponent r13 = r21.getLeftItems();
        if (r13 == null) goto L30;
        int r14 = r13.getSpace();
    L31:
        if (r14 <= 0) goto L45;
        if (r9 <= 0) goto L45;
        ViewGroup.LayoutParams r15 = r12.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == true) goto L36;
        r15 = null;
    L36:
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        if (r16 == null) goto L39;
        r16.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r14));
        r12.setLayoutParams(r16);
    L39:
        int r17 = com.bytedance.android.shopping.extensions.b.b(12);
        Object r18 = r12.getParent();
        if ((r18 instanceof View) == true) goto L42;
        r18 = null;
    L42:
        View r19 = (View) r18;
        if (r19 == null) goto L45;
        r19.post(new g(r12, r17, r19));
    L45:
        r9 = r11;
        goto L23
    L30:
        r14 = 0;
    L46:
        List r20 = r21.getRightButtons();
        r22.l();
        if (r20 == null) goto L96;
        Iterator r23 = r20.iterator();
        int r24 = 0;
    L50:
        if (r23.hasNext() == false) goto L107;
        Object r25 = r23.next();
        int r26 = r24 + 1;
        if (r24 >= 0) goto L54;
        CollectionsKt.throwIndexOverflow();
    L54:
        BottomButtonElement r27 = (BottomButtonElement) r25;
        if (r24 >= 1) goto L57;
    L71:
        Context r110 = getContext();
        if (com.bytedance.android.shopping.anchorv4.experiment.h.c != 1) goto L74;
        boolean r111 = true;
    L75:
        if (r111 == false) goto L77;
        Radius r112 = "DouyinNumberABC";
    L78:
        BottomButtonElementView r113 = new BottomButtonElementView(r110, null, 0, r112, 14);
        r113.a(r27, r21, r22);
        if (r24 != 0) goto L81;
        this.k = r113;
    L81:
        Background r28 = r27.getBackground();
        if (r28 == null) goto L84;
        Radius r29 = r28.getRadius();
    L85:
        String r114 = r27.getClickMaskColor();
        if (r29 != null) goto L97;
        Radius r115 = r4;
    L91:
        View r30 = new View(getContext());
        Intrinsics.checkNotNullParameter(r30, "$this$setBackgroundCompat");
        r30.setBackground(r115);
        FrameLayout r31 = new FrameLayout(getContext());
        r31.addView(r113, new FrameLayout.LayoutParams(-1, -1));
        r31.addView(r30, new FrameLayout.LayoutParams(-1, -1));
        r30.setVisibility(8);
        LinearLayout r116 = getRightGroupButtons();
        LinearLayout.LayoutParams r117 = new LinearLayout.LayoutParams(0, -1);
        Float r32 = r27.getWeight();
        if (r32 == null) goto L94;
        float r33 = r32.floatValue();
    L95:
        r117.weight = r33;
        Unit r34 = Unit.INSTANCE;
        r116.addView(r31, r117);
        r113.setOnTouchListener(new b(r30));
        r24 = r26;
        r4 = null;
        goto L50
    L94:
        r33 = 1.0f;
        goto L95
    L97:
        r115 = new GradientDrawable();     // Catch: Exception -> L90
        r115.setCornerRadii(new float[]{com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r29.getTopLeft())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r29.getTopLeft())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r29.getTopRight())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r29.getTopRight())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r29.getBottomRight())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r29.getBottomRight())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r29.getBottomLeft())), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r29.getBottomLeft()))});     // Catch: Exception -> L90
        r115.setColor(Color.parseColor(r114));     // Catch: Exception -> L90
    L90:
        r115 = null;
        goto L91
    L84:
        r29 = r4;
        goto L85
    L77:
        r112 = r4;
        goto L78
    L74:
        r111 = false;
        goto L75
    L57:
        if (r21.getRightButtonDivider() == null) goto L71;
        LinearLayout r118 = getRightGroupButtons();
        FrameLayout r119 = new FrameLayout(getContext());
        ExtensionsKt.j(r119, r21.getRightButtonDivider().getBackground());
        SimpleDraweeView r120 = new SimpleDraweeView(getContext());
        ImageModel r121 = r21.getRightButtonDivider().getImage();
        if (r121 == null) goto L63;
        ECUrlModel r122 = r121.getRemote();
        if (r122 == null) goto L63;
        int r123 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r122.getWidth()));
    L64:
        ImageModel r124 = r21.getRightButtonDivider().getImage();
        if (r124 == null) goto L69;
        ECUrlModel r125 = r124.getRemote();
        if (r125 == null) goto L69;
        int r126 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r125.getHeight()));
    L70:
        FrameLayout.LayoutParams r127 = new FrameLayout.LayoutParams(r123, r126);
        r127.gravity = 16;
        Unit r128 = Unit.INSTANCE;
        r120.setLayoutParams(r127);
        ImageExtensionsKt.d(r120, r21.getRightButtonDivider().getImage(), r4);
        r119.addView(r120);
        r118.addView(r119, new FrameLayout.LayoutParams(-2, -1));
    L69:
        r126 = 0;
    L63:
        r123 = 0;
        goto L64
    L107:
        return;
    }

    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v8, types: [boolean, int] */
    public final void c(BottomButtonVO r20, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d r21) {
        Intrinsics.checkNotNullParameter(r20, "bottomButtonVO");
        Intrinsics.checkNotNullParameter(r21, "anchorV4VM");
        this.f = r20;
        this.j = r21;
        TextWithOneIconElement r16 = null;
        if (r20.getSuperMarketVO() == null) goto L45;
        setPadding(0, 0, 0, 0);
        setBackgroundColor(0);
        FrameLayout r0 = getSuperMarketButtons();
        if (r0 == null) goto L7;
        r0.setVisibility(0);
    L7:
        LynxCardComponent r1 = r20.getSuperMarketVO();
        if (r1 == null) goto L14;
        String r2 = r1.getData();
        if (r2 == null) goto L14;
        JSONObject r3 = com.bytedance.android.shopping.extensions.k.w(r2);
        if (r3 == null) goto L14;
        Map<String, Object> r4 = com.bytedance.android.shopping.hybrid.a.b(r3);
    L16:
        if (getSuperMarketButtons().getChildCount() <= 0) goto L35;
        ti.l r5 = this.i;
        if (r5 == null) goto L34;
        JSONObject r6 = new JSONObject();
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L31
        if (r4 == null) goto L24;
        Object r8 = r4.get("product_status");     // Catch: Throwable -> L31
    L25:
        r6.put("product_status", r8);     // Catch: Throwable -> L31
        LynxCardComponent r9 = r20.getSuperMarketVO();     // Catch: Throwable -> L31
        if (r9 == null) goto L28;
        String r10 = r9.getSchema();     // Catch: Throwable -> L31
    L29:
        Result.constructor-impl(r6.put("schema", r10));     // Catch: Throwable -> L31
    L33:
        Unit r11 = Unit.INSTANCE;
        r5.sendJsEvent("refresh_market_cart", r6);
        goto L34
    L28:
        r10 = null;
        goto L29
    L24:
        r8 = null;
    L31:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L34:
        int r14 = 8;
    L44:
        ?? r13 = 1;
    L71:
        BottomButtonVO r15 = this.f;
        if (r15 == null) goto L74;
        TextWithOneIconElement r17 = r15.getAddCartComponent();
    L75:
        BottomButtonVO r18 = this.f;
        if (r18 == null) goto L80;
        BottomButtonMeta r19 = r18.getBottomButtonMetaValue();
        if (r19 == null) goto L80;
        EnterCartMeta r22 = r19.getEnterCartMeta();
    L81:
        if (r22 != null) goto L83;
    L82:
        int r23 = 0;
    L120:
        BottomTipComponent r24 = getBottomTipComponent();
        TextWithOneIconElement r25 = r20.getTipVO();
        LynxCardComponent r26 = r20.getLynxTip();
        BottomButtonMeta r27 = r20.getBottomButtonMetaValue();
        if (r27 == null) goto L123;
        BottomTipMeta r28 = r27.getTipMeta();
    L124:
        r24.a(r25, r26, r28, r21);
        CommonMeta r29 = r21.a();
        if (r29 == null) goto L127;
        r29.setBottomTipExist(r13);
    L127:
        CommonMeta r30 = r21.a();
        if (r30 == null) goto L130;
        Boolean r31 = Boolean.valueOf(r30.getEnablePDPOptimize());
    L132:
        if (com.bytedance.android.shopping.extensions.k.i(r31) == false) goto L143;
        BottomButtonVO r32 = this.f;
        if (r32 == null) goto L136;
        LynxCardComponent r33 = r32.getLynxTip();
    L137:
        if (r33 != null) goto L143;
        BottomButtonVO r34 = this.f;
        if (r34 == null) goto L141;
        r16 = r34.getTipVO();
    L141:
        if (r16 != null) goto L143;
        findViewById(2131365056).setVisibility(r23);
        return;
    L136:
        r33 = null;
    L143:
        findViewById(2131365056).setVisibility(r14);
        return;
    L130:
        r31 = null;
        goto L132
    L123:
        r28 = null;
        goto L124
    L83:
        TextView r35 = getCartNumberComponent().b(r22);
        View r36 = ExtensionsKt.k(getLeftGroupItems(), "ref_cart");
        if ((r36 instanceof TextWithOneIconElementView) == true) goto L86;
        r36 = null;
    L86:
        TextWithOneIconElementView r37 = (TextWithOneIconElementView) r36;
        if (r37 == null) goto L82;
        this.o = r37.getIconView();
        r23 = 0;
        r37.setClipChildren(false);
        r37.setClipToPadding(false);
        getLeftGroupItems().setClipChildren(false);
        getLeftGroupItems().setClipToPadding(false);
        ECLottieAnimationView r38 = new ECLottieAnimationView(r37.getContext());
        this.n = r38;
        r38.setVisibility(4);
        if (com.bytedance.android.shopping.anchorv4.experiment.h.c != r13) goto L91;
        boolean r110 = true;
    L92:
        if (r110 == false) goto L94;
        r38.setAnimation("ec_commerce_cart_lottie_opt.json");
    L95:
        r38.setImageAssetsFolder("images");
        r38.setBackgroundColor(-1);
        r38.addAnimatorListener(new h(this));
        FrameLayout.LayoutParams r39 = new FrameLayout.LayoutParams(-2, -2);
        if (r17 == null) goto L102;
        ImageModel r40 = r17.getIcon();
        if (r40 == null) goto L102;
        ECUrlModel r41 = r40.getRemote();
        if (r41 == null) goto L102;
        int r42 = Integer.valueOf(r41.getWidth());
    L103:
        r39.width = com.bytedance.android.shopping.extensions.b.b(r42);
        if (r17 == null) goto L110;
        ImageModel r43 = r17.getIcon();
        if (r43 == null) goto L110;
        ECUrlModel r44 = r43.getRemote();
        if (r44 == null) goto L110;
        int r45 = Integer.valueOf(r44.getHeight());
    L111:
        r39.height = com.bytedance.android.shopping.extensions.b.b(r45);
        r39.gravity = r13;
        Unit r46 = Unit.INSTANCE;
        r37.a(r38, r39);
        ViewGroup.MarginLayoutParams r47 = new ViewGroup.MarginLayoutParams(-2, -2);
        if (r17 == null) goto L118;
        ImageModel r48 = r17.getIcon();
        if (r48 == null) goto L118;
        ECUrlModel r49 = r48.getRemote();
        if (r49 == null) goto L118;
        int r50 = Integer.valueOf(r49.getWidth());
    L119:
        r47.leftMargin = ((com.bytedance.android.shopping.extensions.b.b(r50) - com.bytedance.android.shopping.extensions.b.b(22)) / 2) + com.bytedance.android.shopping.extensions.b.b(14);
        r47.topMargin = com.bytedance.android.shopping.extensions.b.b(-5);
        r37.a(r35, r47);
    L118:
        r50 = 22;
    L110:
        r45 = 22;
    L102:
        r42 = 22;
        goto L103
    L94:
        r38.setAnimation("ec_commerce_cart_lottie.json");
        goto L95
    L91:
        r110 = false;
    L80:
        r22 = null;
        goto L81
    L74:
        r17 = null;
        goto L75
    L35:
        Activity r51 = d0.a.getActivity(getContext());
        if (r51 == null) goto L34;
        LynxCardComponent r52 = r20.getSuperMarketVO();
        if (r52 == null) goto L34;
        String r53 = r52.getSchema();
        if (r53 == null) goto L34;
        r14 = 8;
        ti.l r54 = ECLiveHybridUtil.b(r51, r53, r4, getSuperMarketButtons(), this, null, null, false, null, null, false, 4064);
        w.a.e(w.b, r54, getContext(), Boolean.valueOf(r21.C()), 8);
        Unit r55 = Unit.INSTANCE;
        this.i = r54;
    L14:
        r4 = null;
        goto L16
    L45:
        r14 = 8;
        BottomButtonConfig r56 = r20.getBottomButtonConfig();
        if (r56 == null) goto L48;
        Boolean r57 = r56.getNeedEnlarged();
    L50:
        if (Intrinsics.areEqual(r57, Boolean.TRUE) == true) goto L52;
    L70:
        r13 = 1;
        a(r20, r21);
        goto L71
    L52:
        if (this.l <= com.bytedance.android.shopping.extensions.b.b(375)) goto L70;
        if (this.m == true) goto L68;
        LinearLayout r58 = getNormalButtons();
        ViewGroup.LayoutParams r59 = r58.getLayoutParams();
        r59.width = com.bytedance.android.shopping.extensions.b.b(375);
        r59.height = com.bytedance.android.shopping.extensions.b.b(60);
        Unit r60 = Unit.INSTANCE;
        r58.setLayoutParams(r59);
        LinearLayout r61 = getScaleContent();
        ViewGroup.LayoutParams r62 = r61.getLayoutParams();
        float r63 = com.bytedance.android.shopping.extensions.b.b(60);
        float r64 = this.l;
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d r65 = this.j;
        if (r65 == null) goto L60;
        CommonMeta r66 = r65.a();
        if (r66 == null) goto L60;
        float r67 = h73.a.f(r66);
    L61:
        r62.height = (int) (r63 * (r64 / q.a(Float.valueOf(r67))));
        r61.setLayoutParams(r62);
        setEnlargedConfig(getNormalButtons());
        BottomButtonVO r68 = this.f;
        if (r68 == null) goto L64;
        LynxCardComponent r69 = r68.getLynxTip();
    L65:
        if (r69 != null) goto L67;
        LinearLayout r70 = getBottomTipComponent().d;
        ViewGroup.LayoutParams r71 = r70.getLayoutParams();
        r71.width = com.bytedance.android.shopping.extensions.b.b(375);
        r70.setLayoutParams(r71);
        setEnlargedConfig(getBottomTipComponent().d);
    L67:
        boolean r72 = true;
        this.m = true;
    L69:
        a(r20, r21);
        r13 = r72;
        goto L71
    L64:
        r69 = null;
    L60:
        r67 = 375.0f;
        goto L61
    L68:
        r72 = true;
        goto L69
    L48:
        r57 = null;
        goto L50
    }

    public final void e(int r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "showToast");
        ECLottieAnimationView r0 = this.n;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        ECLottieAnimationView r1 = this.n;
        if (r1 == null) goto L8;
        r1.playAnimation();
    L8:
        getCartNumberComponent().d(r3, r4);
    }

    public final void g(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
    }

    public final void onLoadFailed(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "lynxView");
        Intrinsics.checkNotNullParameter(r1, "lynxView");
    }

    public final void onPageStart(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "lynxView");
        Intrinsics.checkNotNullParameter(r1, "lynxView");
    }

    public BottomButtonView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new BottomButtonView$leftGroupItems$2(this));
        this.b = LazyKt.lazy(new BottomButtonView$rightGroupButtons$2(this));
        this.c = LazyKt.lazy(new BottomButtonView$scaleContent$2(this));
        this.d = LazyKt.lazy(new BottomButtonView$normalButtons$2(this));
        this.e = LazyKt.lazy(new BottomButtonView$superMarketButtons$2(this));
        this.g = LazyKt.lazy(new BottomButtonView$cartNumberComponent$2(r2));
        this.h = LazyKt.lazy(new BottomButtonView$bottomTipComponent$2(this));
        this.l = k1.m(r2);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560479, this, true);
        setBackgroundColor(-1);
    }

    public final void s(View r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
    }

    public /* synthetic */ BottomButtonView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
