package com.bytedance.android.livesdk.livecommerce.intro.card.widget.info;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.ECLottieAnimationView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/info/IntroStockProgressLayout;", "Landroid/widget/FrameLayout;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
final class IntroStockProgressLayout extends FrameLayout {
    public View a;
    public TextView b;
    public TextView c;
    public final int d;
    public final float e;
    public Float f;

    public static final class a {
    }

    static {
    }

    public final void a(float r4) {
        View r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof FrameLayout.LayoutParams) == true) goto L8;
        r1 = null;
    L8:
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;
        if (r2 == null) goto L18;
        r2.width = (int) r4;
        View r5 = this.a;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L13:
        r5.setLayoutParams(r2);
        View r6 = this.a;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L16:
        r6.setVisibility(0);
        return;
    }

    public IntroStockProgressLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public IntroStockProgressLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View r5 = th.a.c(r2, 2131560755, this, true);
        r5.setBackgroundResource(2131234266);
        this.a = r5.findViewById(2131370498);
        ECLottieAnimationView r6 = (ECLottieAnimationView) r5.findViewById(2131379216);
        this.b = (TextView) r5.findViewById(2131371239);
        this.c = (TextView) r5.findViewById(2131370759);
        this.d = UtilityKotlinExtentionsKt.d(48);
        this.e = 10.0f;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        super.onLayout(r5, r6, r7, r8, r9);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_INFO_PROGRESS_FIX() == true) goto L5;
        return;
    L5:
        Float r10 = this.f;
        if (r10 == null) goto L11;
        float r11 = 10;
        if (r10.floatValue() > r11) goto L10;
        float r12 = this.d;
        a(r12);
    L12:
        TextView r13 = this.c;
        if (r13 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L15:
        boolean r14 = false;
        if (r12 < r13.getLeft()) goto L21;
        TextView r15 = this.c;
        if (r15 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L20:
        r15.setVisibility(4);
    L25:
        TextView r16 = this.b;
        if (r16 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L28:
        CharSequence r17 = r16.getText();
        if (r17 == null) goto L57;
        String r18 = r17.toString();
        if (r18 != null) goto L33;
        return;
    L33:
        if (r18.length() <= 3) goto L35;
        boolean r19 = true;
    L36:
        Integer r0 = null;
        if (r19 == true) goto L40;
        r18 = null;
    L40:
        if (r18 == null) goto L59;
        TextView r20 = this.b;
        if (r20 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L45:
        if ((r20.getPaint().measureText(r18) + (UtilityKotlinExtentionsKt.d(6) * 2)) <= r12) goto L60;
        Integer r21 = Integer.valueOf((int) this.e);
        if (r21.intValue() <= 1) goto L49;
        r14 = true;
    L49:
        if (r14 == false) goto L51;
        r0 = r21;
    L51:
        if (r0 == null) goto L61;
        int r22 = r0.intValue();
        int r23 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.a;
        int r24 = ((int) r12) - (UtilityKotlinExtentionsKt.d(6) * 2);
        TextView r25 = this.b;
        if (r25 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L55:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.a(r22, r24, r18, r25);
        return;
    L61:
        return;
    L60:
        return;
    L59:
        return;
    L35:
        r19 = false;
        goto L36
    L57:
        return;
    L21:
        TextView r26 = this.c;
        if (r26 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L24:
        r26.setVisibility(0);
        goto L25
    L10:
        float r27 = this.d;
        r12 = (((r10.floatValue() - r11) / 90) * (getWidth() - r27)) + r27;
        a(r12);
        goto L12
    L11:
        r12 = 0.0f;
        goto L12
    }
}
