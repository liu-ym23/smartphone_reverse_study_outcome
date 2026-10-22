package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.android.ec.model.response.BannerInfo;
import com.bytedance.android.ec.model.response.PromotionExtendType;
import com.bytedance.android.ec.model.response.v0;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardV2$containerAbility$1$eventAction$1;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.widget.ECProductBottomGeneralView;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.widget.ECProductBottomView;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/component/PromotionCardBottomComponent;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/LivePromotionCardArgsV2;", "argument", "", "setArgument", "Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/a;", "containerAbility", "setAbility", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionCardBottomComponent extends LinearLayout {
    public jj2.b a;
    public LivePromotionCardArgsV2 b;
    public com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a c;
    public final ECProductBottomView d;
    public final ECProductBottomGeneralView e;

    public PromotionCardBottomComponent(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PromotionCardBottomComponent(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(jj2.b r4) {
        Intrinsics.checkNotNullParameter(r4, "model");
        this.a = r4;
        final v0 r5 = r4.a;
        if (r5 != null) goto L5;
        setVisibility(8);
        return;
    L5:
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        setVisibility(0);
        PromotionExtendType r1 = r5.e();
        if (r1 == null) goto L37;
        int r2 = a.a[r1.ordinal()];
        if (r2 != 1) goto L11;
        this.d.setVisibility(0);
        this.d.setClickListener(new PromotionCardBottomComponent$updateProductBottom$1(this, r5));
        this.d.R5(r5);
        return;
    L11:
        if (r2 != 2) goto L13;
        this.d.setVisibility(0);
        this.d.setClickListener(new PromotionCardBottomComponent$updateProductBottom$2(this, r5));
        this.d.R5(r5);
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r6 = this.c;
        if (r6 == null) goto L34;
        LivePromotionCardV2$containerAbility$1$eventAction$1 r7 = r6.b();
        if (r7 == null) goto L35;
        r7.m();
        return;
    L35:
        return;
    L34:
        return;
    L13:
        if (r2 != 3) goto L38;
        BannerInfo r3 = r5.c();
        if (r3 == null) goto L39;
        this.e.setVisibility(0);
        this.e.a(r3, new b(this, r5));
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r8 = this.c;
        if (r8 == null) goto L31;
        LivePromotionCardV2$containerAbility$1$eventAction$1 r9 = r8.b();
        if (r9 == null) goto L32;
        r9.o();
        return;
    L32:
        return;
    L31:
        return;
    L39:
        return;
    L38:
        return;
    }

    public final void setAbility(com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "containerAbility");
        this.c = r2;
    }

    public final void setArgument(LivePromotionCardArgsV2 r4) {
        Intrinsics.checkNotNullParameter(r4, "argument");
        this.b = r4;
        Object r2 = null;
        List r5 = (List) r4.b.n(ILivePromotionCardContainerHandler.Scene.ExplainPromotionBackgroundRadius, Reflection.getOrCreateKotlinClass(List.class), null);
        if (r5 == null) goto L5;
        Object r6 = CollectionsKt.firstOrNull(r5);
    L7:
        if ((r6 instanceof Integer) == false) goto L10;
        r2 = r6;
    L10:
        Integer r3 = (Integer) r2;
        if (r3 == null) goto L13;
        int r7 = r3.intValue();
    L14:
        float r8 = r7 + 2;
        ViewExtensionsKt.g(this, 0.0f, 0.0f, r8, r8);
        return;
    L13:
        r7 = 16;
        goto L14
    L5:
        r6 = null;
        goto L7
    }

    public PromotionCardBottomComponent(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        th.a.c(r2, 2131564747, this, true);
        this.d = (ECProductBottomView) findViewById(2131382058);
        this.e = (ECProductBottomGeneralView) findViewById(2131382059);
    }

    public /* synthetic */ PromotionCardBottomComponent(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
