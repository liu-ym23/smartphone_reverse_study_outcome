package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.PromotionListEventActionImplV2;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import sl.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/widget/PromotionCardGuideView;", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/LivePromotionCardArgsV2;", "argument", "", "setArgument", "Ljava/lang/Runnable;", "d", "Lkotlin/Lazy;", "getHideRunnable", "()Ljava/lang/Runnable;", "hideRunnable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionCardGuideView extends ECDraweeView {
    public static final /* synthetic */ int e = 0;
    public LivePromotionCardArgsV2 a;
    public Function0<Unit> b;
    public g c;
    public final Lazy d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ PromotionCardGuideView a;

        public a(PromotionCardGuideView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            PromotionCardGuideView r3 = this.a;
            int r0 = PromotionCardGuideView.e;
            r3.j(true);
        }
    }

    public PromotionCardGuideView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PromotionCardGuideView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final Runnable getHideRunnable() {
        return (Runnable) this.d.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(boolean r7) {
        removeCallbacks(getHideRunnable());
        if (getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L19;
        g r1 = this.c;
        if (r1 == null) goto L19;
        LivePromotionCardArgsV2 r2 = this.a;
        if (r2 == null) goto L19;
        PromotionListEventActionImplV2 r3 = r2.j;
        if (r3 == null) goto L19;
        if (r2 == null) goto L17;
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r4 = r2.a;
        if (r4 == null) goto L17;
        String r5 = r4.a(PromotionCardGuideView$hideGuide$1$1.INSTANCE, r1.a.getIronIndex());
    L18:
        r3.j(true, r1, r7, r5);
    L17:
        r5 = null;
    L19:
        setVisibility(8);
        Function0<Unit> r8 = this.b;
        if (r8 == null) goto L23;
        Unit r9 = (Unit) r8.invoke();
        return;
    L23:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setArgument(LivePromotionCardArgsV2 r2) {
        Intrinsics.checkNotNullParameter(r2, "argument");
        this.a = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(g r11, Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r11, "promotionParams");
        this.c = r11;
        this.b = r12;
        q r13 = r11.a.getClientData().e;
        String r0 = null;
        if (r13 == null) goto L5;
        String r1 = r13.a();
    L7:
        if (r1 != null) goto L9;
    L26:
        j(false);
        return;
    L9:
        if (r13.e() == null) goto L26;
        if (getVisibility() != 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L26;
        LivePromotionCardArgsV2 r3 = this.a;
        if (r3 == null) goto L24;
        PromotionListEventActionImplV2 r4 = r3.j;
        if (r4 == null) goto L24;
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r5 = r3.a;
        if (r5 == null) goto L23;
        r0 = r5.a(PromotionCardGuideView$bindData$1.INSTANCE, r11.a.getIronIndex());
    L23:
        r4.j(false, r11, false, r0);
    L24:
        setVisibility(0);
        String r6 = r13.e();
        int r14 = r.h;
        h0.e(this, r6, r.a.b("ec_live_promotion_list_guide_image"), null, null, 120);
        postDelayed(getHideRunnable(), r13.d());
        return;
    L13:
        r2 = false;
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PromotionCardGuideView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = LazyKt.lazy(new PromotionCardGuideView$hideRunnable$2(this));
        setOnClickListener(new a(this));
        setAutoPlayAnimation(true);
    }

    public /* synthetic */ PromotionCardGuideView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
