package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.PriceView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.GroupInfo;
import com.bytedance.android.ec.model.response.anchorv3.PromotionSubsidizedActivity;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.FontStyle;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.LocalImage;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.PriceElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ImageExtensionsKt;
import com.bytedance.android.shopping.anchorv4.widgets.CountDownLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/AnchorV4ActivityLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/core/utils/l1$a;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityVO;", "vo", "", "update", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "setActionHub", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ActivityLayout extends FrameLayout implements l1.a, ActionHubAccessor {
    public Map<Integer, View> a;
    public ActivityVO b;
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a c;
    public final QUIManager d;
    public g e;
    public FragmentActivity f;
    public AnchorV4ActivityGroupPresenter g;
    public AnchorV4VM h;

    public static final class a<T> implements y.c {
        public final /* synthetic */ AnchorV4ActivityLayout a;

        public a(AnchorV4ActivityLayout r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.post(new com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.b(this, (Bitmap) r3));
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ AnchorV4ActivityLayout a;

        public b(AnchorV4ActivityLayout r1) {
            this.a = r1;
        }

        public final void a() {
            if (ECAppInfoService.e.f() == false) goto L18;
            ((AnchorV4PriceViewContainer) this.a.a(2131362183)).setMaxWidth((k1.m(this.a.getContext()) - com.bytedance.android.shopping.extensions.b.b(32)) - ((LinearLayout) this.a.a(2131362188)).getMeasuredWidth());
            ViewGroup.LayoutParams r0 = ((AnchorV4PriceViewContainer) this.a.a(2131362183)).getLayoutParams();
            ViewGroup.LayoutParams r2 = null;
            if ((r0 instanceof ConstraintLayout.LayoutParams) == true) goto L7;
            r0 = null;
        L7:
            ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
            if (r1 == null) goto L10;
            r1.topToBottom = 2131362185;
        L10:
            View r3 = this.a.a(2131362175);
            ViewGroup.LayoutParams r4 = r3.getLayoutParams();
            if ((r4 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
            r2 = r4;
        L14:
            ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r2;
            if (r5 == null) goto L19;
            r5.topMargin = com.bytedance.android.shopping.extensions.b.b(9);
            r3.setLayoutParams(r5);
            return;
        L19:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return null;
    }

    public final void onStart() {
    }

    public final void onFinish() {
        AnchorV4VM r0 = this.h;
        if (r0 == null) goto L6;
        AnchorV4VM.refresh$default(r0, false, false, null, 7, null);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.c;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    public AnchorV4ActivityLayout(Context r2) {
        this(r2, null);
    }

    public static boolean c(ActivityTime r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        long r1 = System.currentTimeMillis() / ((long) 1000);
        long r3 = r7.getStartTime();
        long r5 = r7.getEndTime();
        if (r3 <= r1) goto L9;
        return false;
    L9:
        if (r5 < r1) goto L12;
        return true;
    L12:
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

    public final void d(ActivityVO r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.getActivityIconImage() != null) goto L7;
        a(2131362175).setVisibility(8);
    L26:
        if (r8.getActivityTime() != null) goto L28;
        a(2131362188).setVisibility(8);
    L30:
        if (r8.getActivityHintText() == null) goto L41;
        a(2131362191).setVisibility(0);
        if (ECAppInfoService.e.f() == false) goto L37;
        FontStyle r0 = r8.getActivityHintText().getFontStyle();
        if (r0 == null) goto L36;
        r0.setLine(2);
    L36:
        ((TextElementView) a(2131362191)).setMaxWidth(((k1.m(getContext()) - com.bytedance.android.shopping.extensions.b.b(24)) / 2) - com.bytedance.android.shopping.extensions.b.b(12));
        ((TextElementView) a(2131362191)).setGravity(8388613);
    L37:
        ((TextElementView) a(2131362191)).x(r8.getActivityHintText());
        CountDownLayout r1 = (CountDownLayout) a(2131362189);
        if (r1 == null) goto L51;
        r1.setVisibility(8);
    L51:
        e(r8);
        return;
    L41:
        if (c(r8.getActivityTime()) == false) goto L48;
        a(2131362191).setVisibility(8);
        CountDownLayout r2 = (CountDownLayout) a(2131362189);
        if (r2 == null) goto L45;
        r2.setVisibility(0);
    L45:
        CountDownLayout r3 = (CountDownLayout) a(2131362189);
        if (r3 == null) goto L51;
        r3.b(r8.getActivityTime());
        goto L51
    L48:
        CountDownLayout r4 = (CountDownLayout) a(2131362189);
        if (r4 == null) goto L51;
        r4.setVisibility(8);
        goto L51
    L28:
        a(2131362188).setVisibility(0);
        goto L30
    L7:
        ViewGroup.LayoutParams r5 = null;
        if (r8.getActivityTime() == null) goto L10;
    L18:
        a(2131362175).setVisibility(0);
        ViewGroup.LayoutParams r6 = a(2131362175).getLayoutParams();
        if ((r6 instanceof ConstraintLayout.LayoutParams) == false) goto L22;
        r5 = r6;
    L22:
        ViewGroup.LayoutParams r7 = (ConstraintLayout.LayoutParams) r5;
        if (r7 == null) goto L26;
        ((ConstraintLayout.LayoutParams) r7).topToTop = 0;
        ((ConstraintLayout.LayoutParams) r7).topToBottom = 2131362188;
        ((ConstraintLayout.LayoutParams) r7).bottomToBottom = -1;
        a(2131362175).setLayoutParams(r7);
        goto L26
    L10:
        if (r8.getActivityHintText() != null) goto L18;
        a(2131362175).setVisibility(0);
        ViewGroup.LayoutParams r9 = a(2131362175).getLayoutParams();
        if ((r9 instanceof ConstraintLayout.LayoutParams) == false) goto L15;
        r5 = r9;
    L15:
        ViewGroup.LayoutParams r10 = (ConstraintLayout.LayoutParams) r5;
        if (r10 == null) goto L26;
        ((ConstraintLayout.LayoutParams) r10).topToTop = 0;
        ((ConstraintLayout.LayoutParams) r10).bottomToBottom = 0;
        a(2131362175).setLayoutParams(r10);
        goto L26
    }

    public final void e(ActivityVO r5) {
        ActivityTime r0 = null;
        if (r5 == null) goto L5;
        ActivityTime r1 = r5.getActivityTime();
    L7:
        if (c(r1) == false) goto L16;
        CountDownLayout r2 = (CountDownLayout) findViewById(2131387601);
        if (r2 == null) goto L11;
        r2.setVisibility(0);
    L11:
        CountDownLayout r3 = (CountDownLayout) findViewById(2131387601);
        if (r3 == null) goto L20;
        if (r5 == null) goto L15;
        r0 = r5.getActivityTime();
    L15:
        r3.b(r0);
        return;
    L20:
        return;
    L16:
        CountDownLayout r6 = (CountDownLayout) findViewById(2131387601);
        if (r6 == null) goto L22;
        r6.setVisibility(8);
        return;
    L22:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        return ActionHubAccessor.DefaultImpls.c(r2);
    }

    public final void onTick(long r1) {
        d(this.b);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r2) {
        Intrinsics.checkNotNullParameter(r2, "hub");
        this.c = r2;
    }

    public final void update(ActivityVO r2) {
        this.b = r2;
        AnchorV4VM r0 = this.h;
        if (r0 == null) goto L5;
        r0.listenActivityTick(this);
    L5:
        d(r2);
    }

    public AnchorV4ActivityLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new LinkedHashMap();
        this.d = new QUIManager();
        FrameLayout.inflate(r2, 2131564598, this);
    }

    public final void b(ActivityVO r33, FragmentActivity r34, AnchorV4VM r35) {
        Intrinsics.checkNotNullParameter(r34, "activity");
        Intrinsics.checkNotNullParameter(r35, "viewModel");
        ConstraintLayout r5 = a(2131362186);
        if (r5 == null) goto L16;
        List r6 = com.bytedance.commerce.base.view.b.a(r5);
        if (r6 == null) goto L16;
        Iterator r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L16;
        View r10 = (View) r7.next();
        if (Intrinsics.areEqual(r10, (ViewStub) a(2131362190)) == true) goto L15;
        if (Intrinsics.areEqual(r10, findViewById(2131362714)) == true) goto L15;
        r10.setVisibility(0);
    L15:
        r10.setVisibility(8);
    L16:
        this.b = r33;
        this.f = r34;
        this.h = r35;
        r35.listenActivityTick(this);
        if (r33 != null) goto L19;
    L203:
        setVisibility(8);
        return;
    L19:
        if (com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.a.a(r33) == false) goto L203;
        setVisibility(0);
        ImageModel r8 = r33.getActivityBgUrl();
        ViewGroup.LayoutParams r11 = null;
        if (r8 == null) goto L24;
        ECUrlModel r9 = r8.getRemote();
    L26:
        if (r9 == null) goto L28;
        y.l(r33.getActivityBgUrl().getRemote(), -1, -1, new a(this));
    L34:
        ImageExtensionsKt.d(a(2131362175), r33.getActivityIconImage(), null);
        d(r33);
        ((LinearLayout) a(2131362188)).post(new b(this));
        TextElement r12 = r33.getPriceDesc();
        if (r12 != null) goto L37;
    L42:
        a(2131362184).setVisibility(8);
    L43:
        TextElement r13 = r33.getSales();
        if (r13 == null) goto L46;
        ((TextElementView) a(2131362187)).x(r13);
        a(2131362187).setVisibility(0);
    L47:
        ((TextElementView) a(2131362187)).setBackground(com.bytedance.commerce.base.drawable.a.a(AnchorV4ActivityLayout$bind$9.INSTANCE));
        ((PriceElementView) a(2131362182)).D(r33.getPrice());
        ViewGroup.LayoutParams r14 = ((PriceElementView) a(2131362182)).getLayoutParams();
        if ((r14 instanceof ConstraintLayout.LayoutParams) == true) goto L50;
        r14 = null;
    L50:
        ConstraintLayout.LayoutParams r15 = (ConstraintLayout.LayoutParams) r14;
        if (r15 == null) goto L57;
        if (r33.getDiscountPrice() != null) goto L55;
        ((ViewGroup.MarginLayoutParams) r15).bottomMargin = com.bytedance.android.shopping.extensions.b.b(6);
        goto L57
    L55:
        ((ViewGroup.MarginLayoutParams) r15).bottomMargin = com.bytedance.android.shopping.extensions.b.b(8);
    L57:
        if (r33.getDepositPrice() == null) goto L59;
        ((PriceElementView) a(2131362170)).D(r33.getDepositPrice());
        ((PriceElementView) a(2131362170)).C(AnchorV4ActivityLayout$bind$11.INSTANCE);
        a(2131362170).setVisibility(0);
    L61:
        if (r33.getDiscountPrice() == null) goto L73;
        a(2131362172).setVisibility(0);
        ((PriceElementView) a(2131362172)).D(r33.getDiscountPrice());
        ((PriceElementView) a(2131362172)).C(AnchorV4ActivityLayout$bind$12.INSTANCE);
        if (r33.getDiscountPrice().getBgType() != 1) goto L66;
        ((PriceElementView) a(2131362172)).setBackground(com.bytedance.commerce.base.drawable.a.a(AnchorV4ActivityLayout$bind$13.INSTANCE));
    L66:
        if (r33.getDiscountPrice().getBgType() != 0) goto L75;
        View r16 = a(2131362172);
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == true) goto L70;
        r17 = null;
    L70:
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
        if (r18 == null) goto L75;
        r18.setMarginStart(0);
        r16.setLayoutParams(r18);
    L75:
        if (r33.getMarketPrice() == null) goto L77;
        a(2131362180).setVisibility(0);
        ((PriceElementView) a(2131362180)).D(r33.getMarketPrice());
        ((PriceElementView) a(2131362180)).C(AnchorV4ActivityLayout$bind$15.INSTANCE);
    L79:
        if (this.g != null) goto L81;
        this.g = new AnchorV4ActivityGroupPresenter(r34);
    L81:
        AnchorV4ActivityGroupPresenter r2 = this.g;
        Intrinsics.checkNotNull(r2);
        ActivityVO r19 = this.b;
        CommonMeta r110 = r35.commonMeta();
        if (r19 != null) goto L84;
        ((AnchorV4ActivityGroupViewModel) r2.e.getValue()).getGroupInfo().g(null);
    L87:
        ((AnchorV4ActivityGroupViewModel) r2.e.getValue()).getCommonMeta().g(r110);
        r2.f = r19;
        AnchorV4ActivityGroupPresenter r3 = this.g;
        Intrinsics.checkNotNull(r3);
        r35.watchPageStatusChange(r3);
        long r111 = 0;
        if (r33.getGroupId() != 0) goto L90;
        a(2131373931).setVisibility(8);
    L95:
        PromotionSubsidizedActivity r4 = r33.getSubsidy();
        if (r4 == null) goto L199;
        ConstraintLayout r20 = a(2131362186);
        if (r20 == null) goto L100;
        r20.setBackground(null);
    L100:
        ConstraintLayout r21 = a(2131362186);
        if (r21 == null) goto L108;
        List r22 = com.bytedance.commerce.base.view.b.a(r21);
        if (r22 == null) goto L108;
        Iterator r23 = r22.iterator();
    L106:
        if (r23.hasNext() == false) goto L108;
        ((View) r23.next()).setVisibility(8);
    L108:
        ViewStub r24 = (ViewStub) a(2131362190);
        if (r24 == null) goto L111;
        r24.setVisibility(0);
    L111:
        findViewById(2131362714).setVisibility(0);
        View r25 = findViewById(2131362690);
        TextView r26 = (TextView) findViewById(2131362687);
        if (r33.getSales() == null) goto L119;
        if (r25 == null) goto L115;
        r25.setVisibility(0);
    L115:
        if (r26 == null) goto L117;
        r26.setVisibility(0);
    L117:
        if (r26 == null) goto L123;
        r26.setText(r33.getSales().getText());
    L123:
        e(r33);
        SimpleDraweeView r1 = findViewById(2131362712);
        if (r1 == null) goto L131;
        ECUrlModel r27 = r4.getLogoBackground();
        if (r27 == null) goto L131;
        ViewGroup.LayoutParams r28 = r1.getLayoutParams();
        if (r28 == null) goto L130;
        r28.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r27.getWidth()));
        r28.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r27.getHeight()));
        r1.setLayoutParams(r28);
    L130:
        y.a(r1, r27);
    L131:
        SimpleDraweeView r29 = findViewById(2131362691);
        if (r29 == null) goto L134;
        y.a(r29, r4.getBeltBackground());
    L134:
        SimpleDraweeView r30 = findViewById(2131362689);
        if (r30 == null) goto L142;
        ECUrlModel r31 = r4.getSellPriceIcon();
        if (r31 == null) goto L141;
        ViewGroup.LayoutParams r32 = r30.getLayoutParams();
        if (r32 == null) goto L141;
        r32.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r31.getWidth()));
        r32.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r31.getHeight()));
        r30.setLayoutParams(r32);
    L141:
        y.a(r30, r4.getSellPriceIcon());
    L142:
        PriceView r36 = findViewById(2131362688);
        if (r36 == null) goto L177;
        int r37 = com.bytedance.android.shopping.utils.g.a;
        Long r38 = r4.getSellPrice();
        if (r38 == null) goto L147;
        r111 = r38.longValue();
    L147:
        r36.setPriceText(com.bytedance.android.shopping.utils.g.d(r111));
        if (r4.getSellPrice() != null) goto L150;
    L154:
        r36.setExtraText("");
    L155:
        ECUrlModel r39 = r4.getLogoBackground();
        if (r39 == null) goto L177;
        int r40 = r39.getWidth();
        Long r41 = r4.getSellPrice();
        if (r41 != null) goto L160;
    L175:
        r36.setMaxWidth(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r40)) - com.bytedance.android.shopping.extensions.b.b(18));
        goto L177
    L160:
        if ((r41.longValue() / ((long) 100)) <= 10000) goto L168;
        ViewGroup.LayoutParams r42 = r36.getLayoutParams();
        if ((r42 instanceof ConstraintLayout.LayoutParams) == false) goto L165;
        r11 = r42;
    L165:
        ConstraintLayout.LayoutParams r112 = (ConstraintLayout.LayoutParams) r11;
        if (r112 == null) goto L175;
        ((ViewGroup.MarginLayoutParams) r112).leftMargin = 0;
        r112.startToStart = 0;
        r112.endToEnd = 0;
        r36.setLayoutParams(r112);
        goto L175
    L168:
        ViewGroup.LayoutParams r43 = r36.getLayoutParams();
        if ((r43 instanceof ConstraintLayout.LayoutParams) == false) goto L172;
        r11 = r43;
    L172:
        ConstraintLayout.LayoutParams r113 = (ConstraintLayout.LayoutParams) r11;
        if (r113 == null) goto L175;
        ((ViewGroup.MarginLayoutParams) r113).leftMargin = com.bytedance.android.shopping.extensions.b.b(12);
        r113.startToStart = 0;
        r113.endToEnd = -1;
        r36.setLayoutParams(r113);
        goto L175
    L150:
        if (r4.getMaxSellPrice() == null) goto L154;
        if ((!Intrinsics.areEqual(r4.getMaxSellPrice(), r4.getSellPrice())) == false) goto L154;
        r36.setExtraText(getResources().getString(2131895957));
    L177:
        if (com.bytedance.android.shopping.extensions.k.c(r4.getSubsidizedPriceDesc()) == false) goto L184;
        TextView r44 = (TextView) findViewById(2131362739);
        if (r44 == null) goto L181;
        r44.setVisibility(0);
    L181:
        TextView r45 = (TextView) findViewById(2131362739);
        if (r45 == null) goto L187;
        r45.setText(r4.getSubsidizedPriceDesc());
    L187:
        TextView r46 = (TextView) findViewById(2131362722);
        String r47 = r4.getMarketPriceDesc();
        if (r47 == null) goto L195;
        String r48 = a2.d(r47);
        if (r48 == null) goto L195;
        if (r46 == null) goto L193;
        r46.setVisibility(0);
    L193:
        if (r46 == null) goto L213;
        r46.setText(r48);
        return;
    L213:
        return;
    L195:
        if (r46 == null) goto L197;
        r46.setVisibility(8);
    L197:
        if (r25 == null) goto L215;
        r25.setVisibility(8);
        return;
    L215:
        return;
    L184:
        TextView r49 = (TextView) findViewById(2131362739);
        if (r49 == null) goto L187;
        r49.setVisibility(8);
        goto L187
    L119:
        if (r25 == null) goto L121;
        r25.setVisibility(8);
    L121:
        if (r26 == null) goto L123;
        r26.setVisibility(8);
        goto L123
    L199:
        View r50 = findViewById(2131362714);
        if (r50 == null) goto L217;
        r50.setVisibility(8);
        return;
    L217:
        return;
    L90:
        a(2131373931).setVisibility(0);
        if (this.e != null) goto L95;
        FragmentActivity r51 = this.f;
        if (r51 == null) goto L95;
        Intrinsics.checkNotNull(r51);
        g r52 = new g(r51, this.h);
        this.e = r52;
        QUIManager r53 = this.d;
        Intrinsics.checkNotNull(r52);
        r53.l(r52, getContext(), false);
        this.d.c(g.class, null);
        ((ViewGroup) findViewById(2131373931)).addView(this.d.p());
        goto L95
    L84:
        if ((!Intrinsics.areEqual(r19, r2.f)) == false) goto L87;
        ((AnchorV4ActivityGroupViewModel) r2.e.getValue()).getGroupInfo().g(new GroupInfo(0, null, r19.getJoined(), r19.getGroupSize(), r19.getPercent(), r19.getSkuMinPrice(), r19.getSkuMaxPrice(), r19.getGroupId(), null, null, 771, null));
        goto L87
    L77:
        a(2131362180).setVisibility(8);
        goto L79
    L73:
        a(2131362172).setVisibility(8);
        goto L75
    L59:
        a(2131362170).setVisibility(8);
        goto L61
    L46:
        a(2131362187).setVisibility(8);
        goto L47
    L37:
        if (com.bytedance.android.shopping.extensions.k.c(r12.getText()) == true) goto L40;
        r12 = null;
    L40:
        if (r12 == null) goto L42;
        ((TextElementView) a(2131362184)).x(r12);
        a(2131362184).setVisibility(0);
        goto L43
    L28:
        ImageModel r54 = r33.getActivityBgUrl();
        if (r54 == null) goto L31;
        LocalImage r55 = r54.getLocal();
    L32:
        if (r55 == null) goto L34;
        a(2131362186).setBackground(ImageExtensionsKt.b(r33.getActivityBgUrl().getLocal(), getContext()));
        goto L34
    L31:
        r55 = null;
        goto L32
    L24:
        r9 = null;
        goto L26
    }
}
