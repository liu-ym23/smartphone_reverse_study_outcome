package com.bytedance.android.shopping.feed.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductButtonStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPageConfigStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.android.shopping.feed.banner.VideoProductFeedBanner;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.utils.i0;
import com.bytedance.android.shopping.feed.utils.x;
import com.bytedance.android.shopping.feed.utils.y;
import com.bytedance.android.shopping.feed.utils.z;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/InflowBottomCartView;", "Landroid/widget/FrameLayout;", "", "", "getJumpUrl", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "getPromotion", "Lsc3/a;", "a", "Lsc3/a;", "getAddCartListener", "()Lsc3/a;", "addCartListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InflowBottomCartView extends FrameLayout {
    public static final /* synthetic */ int f = 0;
    public final a a;
    public final ImageView b;
    public PromotionProductStruct c;
    public PromotionProductButtonStruct d;
    public VideoProductFeedBanner e;

    public static final class a implements sc3.a {
        public final /* synthetic */ InflowBottomCartView a;
        public final /* synthetic */ Context b;

        @Override // sc3.a
        public final void onSuccess() {
            WeakReference<View> r0 = com.bytedance.android.shopping.feed.utils.i.a;
            if (r0 == null) goto L5;
            View r1 = r0.get();
        L6:
            if (r1 == null) goto L9;
            int r2 = ld3.c.a;
            InflowBottomCartView r3 = this.a;
            int r4 = InflowBottomCartView.f;
            r3.b(null);
            FeedProductEventTracker r5 = FeedProductEventTracker.a;
            Context r6 = this.b;
            this.a.getClass();
            r5.getClass();
            FeedProductEventTracker.i(r6, null);
            return;
        L9:
            return;
        L5:
            r1 = null;
            goto L6
        }

        public a(InflowBottomCartView r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b {
    }

    static {
    }

    public InflowBottomCartView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InflowBottomCartView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public String getJumpUrl() {
        PromotionProductButtonStruct r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getOrderUrl();
    }

    public final sc3.a getAddCartListener() {
        return this.a;
    }

    public PromotionProductStruct getPromotion() {
        return this.c;
    }

    public final void b(String r26) {
        VideoProductFeedBanner r1 = this.e;
        if (r1 == null) goto L37;
        View r2 = r1.getCenterView();
        if (r2 == null) goto L38;
        WeakReference<View> r3 = com.bytedance.android.shopping.feed.utils.i.a;
        Object r4 = null;
        if (r3 == null) goto L9;
        View r5 = r3.get();
    L10:
        if (r5 == null) goto L39;
        int r6 = z.a;
        if (r26 != null) goto L17;
        VideoProductFeedBanner r7 = this.e;
        if (r7 == null) goto L16;
        String r8 = r7.getFirstImgUrl();
    L18:
        if (r8 != null) goto L20;
        r8 = "";
    L20:
        String r9 = r8;
        int r10 = r2.getWidth();
        InflowBottomCartView$startNewAddCardMotion$1$1$1 r11 = InflowBottomCartView$startNewAddCardMotion$1$1$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r2, "sourceView");
        Intrinsics.checkNotNullParameter(r5, "destinationView");
        Intrinsics.checkNotNullParameter(r9, "coverImg");
        Context r12 = r5.getContext();
        if (r12 == null) goto L23;
        Object r13 = r12.getSystemService("window");
    L25:
        if ((r13 instanceof WindowManager) == false) goto L28;
        r4 = r13;
    L28:
        WindowManager r14 = (WindowManager) r4;
        int[] r15 = new int[2];
        r2.getLocationOnScreen(r15);
        Ref.FloatRef r16 = new Ref.FloatRef();
        r16.element = r15[0];
        Ref.FloatRef r17 = new Ref.FloatRef();
        r17.element = r15[1];
        int[] r18 = new int[2];
        r5.getLocationOnScreen(r18);
        Ref.FloatRef r19 = new Ref.FloatRef();
        r19.element = r18[0];
        Ref.FloatRef r110 = new Ref.FloatRef();
        r110.element = r18[1];
        vf4.a.a(r2.getContext(), 5.0f);
        r2.getContext();
        float r20 = r16.element;
        float r21 = r17.element;
        int r22 = r2.getWidth();
        int r23 = r2.getHeight();
        WindowManager.LayoutParams r111 = new WindowManager.LayoutParams();
        r111.width = r22;
        r111.height = r23;
        r111.x = (int) r20;
        r111.y = (int) r21;
        r111.flags = 664;
        r111.format = -3;
        r111.gravity = 8388659;
        r111.type = 99;
        ECDraweeView r24 = new ECDraweeView(r2.getContext(), null, 0, 6, null);
        h0.e(r24, r9, new com.bytedance.android.ec.core.imagex.r("ec_goods_feed", "ec_goods_feed_banner"), Integer.valueOf(r2.getWidth()), Integer.valueOf(r2.getWidth()), 96);
        r24.setCornerRadius(r10 / 2);
        if (r14 == null) goto L31;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r24, r111);
        r14.addView(r24, r111);
    L31:
        Float[] r25 = {Float.valueOf(0.22f), Float.valueOf(0.28f)};
        ValueAnimator r27 = ValueAnimator.ofObject(new com.bytedance.android.shopping.feed.utils.p(), new Object[]{new PointF(1.0f, 1.0f), new PointF(r25[0].floatValue(), 1.0f)});
        r27.addUpdateListener(new com.bytedance.android.shopping.feed.utils.v(r24));
        r27.setDuration(200);
        ValueAnimator r28 = ValueAnimator.ofObject(new com.bytedance.android.shopping.feed.utils.p(), new Object[]{new PointF(r25[0].floatValue(), 1.0f), new PointF(r25[1].floatValue(), 1.0f)});
        r28.addUpdateListener(new com.bytedance.android.shopping.feed.utils.w(r24));
        r28.setDuration(50);
        int r29 = r2.getWidth();
        int r30 = r2.getHeight();
        r19.element -= r29 / 2.0f;
        float r112 = r110.element - (r30 / 2.0f);
        r110.element = r112;
        if (r112 >= r17.element) goto L34;
        TypeEvaluator r31 = new i0(new PointF(r16.element, r110.element));
    L35:
        ValueAnimator r32 = ValueAnimator.ofObject(r31, new Object[]{new PointF(r16.element, r17.element), new PointF(r19.element, r110.element)});
        dm.a.a("inflow_anim").i("destinationX: " + r19.element + ",  destinationY: " + r110.element + "controlPointX: " + r16.element + ", controlPointY: " + r110.element + " sourceX,y: (" + r16.element + ", " + r17.element + ')');
        dm.a.b r33 = dm.a.a("inflow_anim");
        StringBuilder r34 = new StringBuilder("motionLayoutX: ");
        r34.append(r24.getX());
        r34.append(",  motionLayoutY: ");
        r34.append(r24.getY());
        r33.i(r34.toString());
        r32.addUpdateListener(new x(r32, r24, r14, r111));
        r32.setDuration(400);
        AnimatorSet r35 = new AnimatorSet();
        r35.setInterpolator(new DecelerateInterpolator());
        r35.setStartDelay(50);
        r35.addListener(new y(r24, r11, r14));
        r35.playSequentially(new Animator[]{r27, r28, r32});
        r35.start();
        return;
    L34:
        r31 = new com.bytedance.android.shopping.feed.utils.h0();
        goto L35
    L23:
        r13 = null;
        goto L25
    L16:
        r8 = null;
        goto L18
    L17:
        r8 = r26;
        goto L18
    L39:
        return;
    L9:
        r5 = null;
        goto L10
    L38:
        return;
    }

    public InflowBottomCartView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        boolean r7 = ld3.d.e(ld3.d.b());
        ImageView r8 = new ImageView(r4);
        this.b = r8;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(24), com.bytedance.android.shopping.extensions.b.b(24));
        r0.gravity = 17;
        Unit r1 = Unit.INSTANCE;
        r8.setLayoutParams(r0);
        r8.setImageResource(2131247968);
        if (r7 == false) goto L5;
        int r9 = com.bytedance.android.shopping.extensions.b.b(60);
    L6:
        setLayoutParams(new FrameLayout.LayoutParams(r9, -1));
        se3.a.b(r8);
        addView(r8);
        setBackgroundResource(2131234850);
        this.a = new a(this, r4);
        return;
    L5:
        r9 = com.bytedance.android.shopping.extensions.b.b(50);
        goto L6
    }

    public /* synthetic */ InflowBottomCartView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void a(PromotionProductStruct r5, PromotionProductButtonStruct r6, final View.OnClickListener r7, rd3.a r8) {
        Intrinsics.checkNotNullParameter(r5, "promotion");
        this.c = r5;
        this.d = r6;
        ActivityVO r9 = f53.a.c(r5);
        PromotionProductPageConfigStruct r10 = r5.getPageComsConfig();
        if (r10 != null) goto L5;
    L26:
        setVisibility(8);
    L27:
        com.bytedance.android.ec.core.widget.f.c(this, null, null, new InflowBottomCartView$bind$1(r7), 3);
        return;
    L5:
        if (r10.getShoppingCart() != true) goto L26;
        setVisibility(0);
        PromotionProductPageConfigStruct r11 = r5.getPageComsConfig();
        if (r11 != null) goto L9;
    L18:
        PromotionDepositPresaleActivity r12 = r9.getDepositPresaleActivity();
        if (r12 != null) goto L21;
    L25:
        this.b.setImageResource(2131247968);
        this.b.setAlpha(1.0f);
        goto L27
    L21:
        if (com.bytedance.android.ec.model.n.b(r12) != true) goto L25;
        if (a53.a.a() != 1) goto L25;
        this.b.setImageResource(2131247969);
        setBackgroundResource(2131234851);
        this.b.setAlpha(1.0f);
        goto L27
    L9:
        if (r11.getSetCartGray() != true) goto L18;
        setOnClickListener(null);
        PromotionDepositPresaleActivity r13 = r9.getDepositPresaleActivity();
        if (r13 != null) goto L13;
    L17:
        this.b.setImageResource(2131247968);
        this.b.setAlpha(0.34f);
        goto L27
    L13:
        if (com.bytedance.android.ec.model.n.b(r13) != true) goto L17;
        if (a53.a.a() != 1) goto L17;
        this.b.setImageResource(2131247969);
        setBackgroundResource(2131234851);
        this.b.setAlpha(0.34f);
        goto L27
    }
}
