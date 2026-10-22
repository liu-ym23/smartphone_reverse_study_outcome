package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.PromotionListEventActionImpl;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import sl.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/module/ListItemGuideModule;", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/model/LivePromotionCardArgs;", "argument", "", "setArgument", "Ljava/lang/Runnable;", "d", "Lkotlin/Lazy;", "getHideRunnable", "()Ljava/lang/Runnable;", "hideRunnable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ListItemGuideModule extends ECDraweeView {
    public static final /* synthetic */ int e = 0;
    public LivePromotionCardArgs a;
    public Function0<Unit> b;
    public com.bytedance.android.ec.common.api.jump.model.e c;
    public final Lazy d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ListItemGuideModule a;

        public a(ListItemGuideModule r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ListItemGuideModule r3 = this.a;
            int r0 = ListItemGuideModule.e;
            r3.j(true);
        }
    }

    public ListItemGuideModule(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ListItemGuideModule(Context r3, AttributeSet r4) {
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
        if (r0 == false) goto L20;
        com.bytedance.android.ec.common.api.jump.model.e r1 = this.c;
        if (r1 == null) goto L20;
        LivePromotionCardArgs r2 = this.a;
        if (r2 == null) goto L20;
        PromotionListEventActionImpl r3 = r2.h;
        if (r3 == null) goto L20;
        g r4 = r1.b;
        if (r2 == null) goto L18;
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r5 = r2.a;
        if (r5 == null) goto L18;
        String r6 = r5.a(ListItemGuideModule$hideGuide$1$1.INSTANCE, r1.a.getIronIndex());
    L19:
        r3.i(true, r4, r7, r6);
    L18:
        r6 = null;
    L20:
        setVisibility(8);
        Function0<Unit> r8 = this.b;
        if (r8 == null) goto L24;
        Unit r9 = (Unit) r8.invoke();
        return;
    L24:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setArgument(LivePromotionCardArgs r2) {
        Intrinsics.checkNotNullParameter(r2, "argument");
        this.a = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(com.bytedance.android.ec.common.api.jump.model.e r12, Function0<Unit> r13) {
        Intrinsics.checkNotNullParameter(r12, "promotionParams");
        Intrinsics.checkNotNullParameter(r13, "clearGuideData");
        this.c = r12;
        this.b = r13;
        q r14 = r12.a.getClientData().e;
        String r0 = null;
        if (r14 == null) goto L5;
        String r1 = r14.a();
    L7:
        if (r1 != null) goto L9;
    L26:
        j(false);
        return;
    L9:
        if (r14.e() == null) goto L26;
        if (getVisibility() != 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L26;
        LivePromotionCardArgs r3 = this.a;
        if (r3 == null) goto L24;
        PromotionListEventActionImpl r4 = r3.h;
        if (r4 == null) goto L24;
        g r5 = r12.b;
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r6 = r3.a;
        if (r6 == null) goto L23;
        r0 = r6.a(ListItemGuideModule$bindData$1.INSTANCE, r12.a.getIronIndex());
    L23:
        r4.i(false, r5, false, r0);
    L24:
        setVisibility(0);
        String r7 = r14.e();
        int r15 = r.h;
        h0.e(this, r7, r.a.b("ec_live_promotion_list_guide_image"), null, null, 120);
        postDelayed(getHideRunnable(), r14.d());
        return;
    L13:
        r2 = false;
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ListItemGuideModule(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = LazyKt.lazy(new ListItemGuideModule$hideRunnable$2(this));
        setOnClickListener(new a(this));
        setAutoPlayAnimation(true);
    }

    public /* synthetic */ ListItemGuideModule(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
