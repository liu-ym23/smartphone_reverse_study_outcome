package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.ExplainingPromotionBar;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import sg2.v;
import xi2.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\t\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002J\b\u0010\r\u001a\u0004\u0018\u00010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/ECPromotionListHintBannerView;", "Landroid/widget/FrameLayout;", "", "roomId", "", "setRoomId", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/PromotionListController;", "listController", "setPromotionListController", "getCurrentPromotionId", "promotionId", "setPreviousPromotionId", "Landroid/view/View;", "getCartAddMotionDestination", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionListHintBannerView extends FrameLayout {
    public static final /* synthetic */ int k = 0;
    public String a;
    public ECPromotionList.p b;
    public final RelativeLayout c;
    public final ExplainingPromotionBar d;
    public final ECDraweeView e;
    public final ECCustomizedElementView f;
    public final ECCustomizedElementView g;
    public final ECDraweeView h;
    public PromotionListController i;
    public final int j;

    public static final class a {
    }

    static {
    }

    public ECPromotionListHintBannerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECPromotionListHintBannerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void d() {
        this.f.e();
        this.g.e();
        this.c.setVisibility(8);
    }

    public final String getCurrentPromotionId() {
        ExplainingPromotionBar r0 = this.d;
        if (r0.getVisibility() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L12;
        String r2 = r0.getCurrentPromotionId();
        if (r2 == null) goto L12;
        return r2;
    L12:
        return "";
    L5:
        r1 = false;
        goto L6
    }

    public final boolean e() {
        if (getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return false;
    L8:
        if (this.d.getVisibility() != 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L13;
    L17:
        return true;
    L13:
        if (this.c.getVisibility() != 0) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == true) goto L17;
        return false;
    L15:
        r2 = false;
        goto L16
    L10:
        r1 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public final View getCartAddMotionDestination() {
        Object r1 = null;
        if (e() == true) goto L5;
        return null;
    L5:
        Iterator r0 = com.bytedance.commerce.base.view.b.a(this.f).iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        Object r2 = r0.next();
        if (Intrinsics.areEqual(((View) r2).getTag(), "cart_add_destination") == false) goto L7;
    L12:
        View r3 = (View) r2;
        if (r3 != null) goto L28;
        Iterator r4 = com.bytedance.commerce.base.view.b.a(this.g).iterator();
    L16:
        if (r4.hasNext() == false) goto L21;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((View) r5).getTag(), "cart_add_destination") == false) goto L16;
        r1 = r5;
    L21:
        return (View) r1;
    L28:
        return r3;
    L11:
        r2 = null;
        goto L12
    }

    public final void f(int r3) {
        ECPromotionList.p r4 = this.b;
        if (r4 == null) goto L8;
        List<com.bytedance.android.ec.model.live.b> r5 = r4.leftContent;
        if (r5 == null) goto L9;
        ControllerExtensionsKt.b(this.i, this.a).getClass();
        this.f.b(r5, true);
        return;
    L9:
        return;
    }

    public final void h(int r5) {
        ViewGroup.LayoutParams r0 = this.f.getLayoutParams();
        if (r0 == null) goto L7;
        RelativeLayout.LayoutParams r1 = (RelativeLayout.LayoutParams) r0;
        r1.setMargins(r1.leftMargin, r1.topMargin, r5, r1.bottomMargin);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    public final void setPreviousPromotionId(String r2) {
        this.d.setPreviousPromotionId(r2);
    }

    public final void setPromotionListController(PromotionListController r1) {
        this.i = r1;
    }

    public final void setRoomId(String r1) {
        this.a = r1;
    }

    public final void g(int r3, int r4) {
        wg.a.f(this.c, 0, r3, 0, r4);
        wg.a.f(this.d, 0, r3, 0, r4);
    }

    public ECPromotionListHintBannerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.j = UtilityKotlinExtentionsKt.d(Float.valueOf(26.0f));
        th.a.c(r2, 2131564725, this, true);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.c = (RelativeLayout) findViewById(2131384680);
        this.d = (ExplainingPromotionBar) findViewById(2131371730);
        this.e = findViewById(2131370421);
        ECCustomizedElementView r5 = (ECCustomizedElementView) findViewById(2131365441);
        this.f = r5;
        ECCustomizedElementView r6 = (ECCustomizedElementView) findViewById(2131365442);
        this.g = r6;
        this.h = findViewById(2131392520);
        r5.setCountDownEndCallback(new AnonymousClass1(this));
        r6.setCountDownEndCallback(new AnonymousClass2(this));
    }

    public /* synthetic */ ECPromotionListHintBannerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        boolean r6 = true;
        if (this.c.getVisibility() != 0) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L21;
        ECPromotionList.p r8 = this.b;
        if (r8 == null) goto L12;
        if (r8.bannerType != 5) goto L12;
        return;
    L12:
        if ((this.g.getLeft() - this.f.getRight()) >= this.j) goto L15;
        ECCustomizedElementView r9 = this.g;
        r9.layout(r9.getLeft(), 0, this.g.getLeft(), 0);
        return;
    L15:
        if (this.h.getVisibility() == 0) goto L18;
        r6 = false;
    L18:
        if (r6 == false) goto L24;
        ECDraweeView r10 = this.h;
        r10.layout(r10.getLeft(), 0, this.h.getLeft(), 0);
        return;
    L24:
        return;
    L21:
        return;
    L5:
        r7 = false;
        goto L6
    }

    public static /* synthetic */ void c(ECPromotionListHintBannerView r7, ECPromotionList.p r8, JSONObject r9, boolean r10, int r11, gi2.a r12) {
        r7.e();
        r7.b(r8, r9, false, r10, r11, r12);
    }

    public final void b(final ECPromotionList.p r15, JSONObject r16, final boolean r17, boolean r18, int r19, gi2.a r20) {
        if (ECLiveABUtils.INSTANCE.getECOM_LIVE_PROMOTION_LIST_HINT_HAR_OPT_CONFIG().a() != 2) goto L6;
        if (r18 == true) goto L6;
        return;
    L6:
        if (r15 != null) goto L8;
    L13:
        boolean r3 = true;
        if ((!Intrinsics.areEqual(this.b, r15)) == true) goto L16;
        if (r17 == true) goto L16;
        return;
    L16:
        this.b = r15;
        boolean r4 = false;
        if (this.d.getVisibility() != 0) goto L19;
        boolean r1 = true;
    L20:
        if (r1 == false) goto L28;
        if (r15 != null) goto L23;
        return;
    L23:
        if (r15.priority <= 40) goto L25;
        r4 = true;
    L25:
        if (r4 != true) goto L104;
        this.d.b();
        return;
    L104:
        return;
    L28:
        if (r15 != null) goto L31;
        d();
        return;
    L31:
        this.c.setVisibility(0);
        Map<String, String> r8 = null;
        if (r15.bannerType != 7) goto L52;
        setVisibility(0);
        ECPromotionList.p r2 = this.b;
        int r5 = -1;
        if (r2 == null) goto L51;
        List<com.bytedance.android.ec.model.live.b> r6 = r2.leftContent;
        if (r6 == null) goto L51;
        Iterator<T> r7 = r6.iterator();
        int r9 = 0;
    L39:
        if (r7.hasNext() == false) goto L51;
        Object r10 = r7.next();
        int r11 = r9 + 1;
        if (r9 >= 0) goto L43;
        CollectionsKt.throwIndexOverflow();
    L43:
        com.bytedance.android.ec.model.live.b r12 = (com.bytedance.android.ec.model.live.b) r10;
        if (r12.o() != 2) goto L50;
        String r13 = r12.s();
        if (r13 == null) goto L50;
        if (StringsKt.contains$default(r13, "#{left_time}", false, 2, null) != true) goto L50;
        r12.s();
        r5 = r9;
    L50:
        r9 = r11;
    L51:
        ControllerExtensionsKt.b(this.i, this.a).getClass();
        f(r5);
    L56:
        this.e.setCornerRadius(UtilityKotlinExtentionsKt.c(8));
        y.d(this.e, r15.bgImageUrl);
        List<com.bytedance.android.ec.model.live.b> r14 = r15.rightContent;
        if (r14 == null) goto L78;
        this.g.setVisibility(0);
        this.g.b(r14, r17);
        if (r15.bannerType != 4) goto L61;
        com.bytedance.android.ec.core.widget.f.c(this.g, null, null, new ECPromotionListHintBannerView$bindListBannerInfo$$inlined$also$lambda$1(this, r17, r15), 3);
        com.bytedance.android.ec.core.widget.f.c(this.h, null, null, new ECPromotionListHintBannerView$bindListBannerInfo$$inlined$also$lambda$2(this, r17, r15), 3);
    L62:
        com.bytedance.android.ec.model.live.b r0 = (com.bytedance.android.ec.model.live.b) CollectionsKt.lastOrNull(r14);
        if (r0 != null) goto L65;
    L77:
        this.h.setVisibility(8);
        h(UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f)));
        Unit r21 = Unit.INSTANCE;
    L80:
        if (a2.b(r15.jumpUrl) == false) goto L82;
        setOnClickListener(new g(this, r15, r16, r20, r19));
    L84:
        if (r15.a == true) goto L106;
        StringBuilder r22 = new StringBuilder("livesdk_show_");
        m0 r23 = r15.trackInfo;
        if (r23 == null) goto L88;
        String r24 = r23.b();
    L89:
        r22.append(r24);
        String r25 = r22.toString();
        oh.a.c(r25, new h(this, r25, r15, r16));
        com.bytedance.android.btm.api.model.d r26 = BtmUtilsKt.e("a1.b0715.c298306.d93817", PageFinder.via(this));
        if (r20 == null) goto L92;
        gi2.a r27 = r20;
    L93:
        v r28 = new v("livesdk_common_banner_show", r27);
        m0 r29 = r15.trackInfo;
        if (r29 == null) goto L96;
        r8 = r29.c();
    L96:
        r28.d(r8);
        r28.a("banner_type", r15.bannerType);
        r28.i(r26.a);
        return;
    L92:
        r27 = com.bytedance.android.ec.common.api.jump.model.b.a;
        goto L93
    L88:
        r24 = null;
        goto L89
    L106:
        return;
    L82:
        setOnClickListener(null);
        goto L84
    L65:
        if (r0.o() == 4) goto L68;
        r3 = false;
    L68:
        if (r3 == true) goto L71;
        r0 = null;
    L71:
        if (r0 == null) goto L77;
        this.h.setVisibility(0);
        y.a(this.h, r0.q());
        ECUrlModel r30 = r0.q();
        if (r30 == null) goto L75;
        int r31 = r30.getWidth();
    L76:
        h(UtilityKotlinExtentionsKt.d(Integer.valueOf(r31 + 30)));
        goto L80
    L75:
        r31 = 16;
        goto L76
    L61:
        this.g.setClickable(false);
        this.h.setClickable(false);
        goto L62
    L78:
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        h(UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f)));
        goto L80
    L52:
        ControllerExtensionsKt.b(this.i, this.a).getClass();
        List<com.bytedance.android.ec.model.live.b> r32 = r15.leftContent;
        if (r32 == null) goto L55;
        this.f.setVisibility(0);
        this.f.b(r32, r17);
        goto L56
    L55:
        this.f.setVisibility(8);
        goto L56
    L19:
        r1 = false;
        goto L20
    L8:
        if (r15.bannerType != 14) goto L13;
        if (e() == false) goto L13;
        if (r17 == true) goto L13;
    }

    public final void a(ql.a r15, final JSONObject r16, final boolean r17, final int r18, final gi2.a r19, Function0<Unit> r20, final Function0<Unit> r21) {
        Intrinsics.checkNotNullParameter(r15, "promotion");
        Intrinsics.checkNotNullParameter(r16, "entranceInfo");
        Intrinsics.checkNotNullParameter(r20, "clickListener");
        Intrinsics.checkNotNullParameter(r21, "extraHideListener");
        ExplainingPromotionBar r12 = this.d;
        Function0<Unit> r13 = new ECPromotionListHintBannerView$bindExplainingPromotionBar$1(this, r21, r16, r17, r18, r19);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r15, "promotion");
        Intrinsics.checkNotNullParameter(r20, "clickListener");
        Intrinsics.checkNotNullParameter(r13, "hideListener");
        r12.d = r15.getPromotionId();
        r12.a.setText(String.valueOf(r15.getIronIndex()));
        r12.b.setText(r15.getTitle());
        r12.setOnClickListener(new com.bytedance.android.livesdk.livecommerce.iron.widgets.d(r20));
        r12.e = r13;
    }
}
