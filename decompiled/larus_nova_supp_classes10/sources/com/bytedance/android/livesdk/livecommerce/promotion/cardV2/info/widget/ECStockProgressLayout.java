package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.bytedance.android.livesdk.livecommerce.view.ECLottieAnimationView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/info/widget/ECStockProgressLayout;", "Landroid/widget/FrameLayout;", "", "progressText", "", "setTxStockDes", "label", "setLabel", "Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/LivePromotionCardArgsV2;", "arg", "setPromotionCardArg", "", "g", "Lkotlin/Lazy;", "getBasicWidth", "()I", "basicWidth", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStockProgressLayout extends FrameLayout {
    public View a;
    public TextView b;
    public ECLottieAnimationView c;
    public TextView d;
    public LivePromotionCardArgsV2 e;
    public final Lazy f;
    public final Lazy g;
    public float h;

    public static final class a {
    }

    static {
    }

    public ECStockProgressLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECStockProgressLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final int getBasicWidth() {
        return ((Number) this.g.getValue()).intValue();
    }

    public static final /* synthetic */ int a(ECStockProgressLayout r0) {
        return r0.getBasicWidth();
    }

    private final void setLabel(String r4) {
        TextView r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L5:
        r0.setContentDescription(r4);
        if (TextUtils.isEmpty(r4) == false) goto L11;
        TextView r5 = this.d;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L10:
        r5.setVisibility(4);
        return;
    L11:
        TextView r1 = this.d;
        if (r1 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L15:
        if (Intrinsics.areEqual(r1.getText(), r4) == false) goto L21;
        TextView r2 = this.d;
        if (r2 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L20:
        if (r2.getVisibility() != 0) goto L21;
        return;
    L21:
        TextView r3 = this.d;
        if (r3 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L24:
        r3.setText(r4);
        TextView r6 = this.d;
        if (r6 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L27:
        r6.setVisibility(4);
    }

    private final void setTxStockDes(String r4) {
        TextView r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L5:
        r0.setContentDescription(r4);
        if (TextUtils.isEmpty(r4) == false) goto L11;
        TextView r5 = this.b;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L10:
        r5.setVisibility(8);
        return;
    L11:
        TextView r1 = this.b;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L14:
        r1.setVisibility(0);
        TextView r2 = this.b;
        if (r2 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L17:
        r2.setText(r4);
    }

    public final void setPromotionCardArg(LivePromotionCardArgsV2 r2) {
        Intrinsics.checkNotNullParameter(r2, "arg");
        this.e = r2;
    }

    public static final void b(ECStockProgressLayout r7, float r8) {
        View r0 = r7.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        ql.a r3 = null;
        if ((r1 instanceof FrameLayout.LayoutParams) == true) goto L8;
        r1 = null;
    L8:
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;
        if (r2 == null) goto L17;
        r2.width = (int) r8;
        View r4 = r7.a;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L13:
        r4.setLayoutParams(r2);
        View r5 = r7.a;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L16:
        r5.setVisibility(0);
    L17:
        LivePromotionCardArgsV2 r6 = r7.e;
        if (r6 == null) goto L54;
        ILivePromotionCardContainerHandler r9 = r6.b;
        if (r9 == null) goto L55;
        Function0<com.bytedance.android.ec.common.api.jump.model.g> r10 = r6.k;
        if (r10 == null) goto L27;
        com.bytedance.android.ec.common.api.jump.model.g r11 = (com.bytedance.android.ec.common.api.jump.model.g) r10.invoke();
        if (r11 == null) goto L27;
        r3 = r11.a;
    L27:
        if (r9.i(r3, 2, false) == true) goto L29;
        return;
    L29:
        if (r8 <= r7.getBasicWidth()) goto L40;
        float r12 = (int) (r8 - r7.getBasicWidth());
        Resources r13 = Resources.getSystem();
        float r14 = 200 + (13 * (r12 / WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics()).density));
        float r15 = r7.getBasicWidth() / r8;
        View r16 = r7.a;
        if (r16 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L33:
        r16.setPivotX(0.0f);
        View r17 = r7.a;
        if (r17 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L36:
        r17.setScaleX(r15);
        View r18 = r7.a;
        if (r18 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L39:
        r18.animate().scaleX(1.0f).setDuration((long) r14).setInterpolator(new PathInterpolator(0.0f, 0.46f, 0.25f, 1.0f)).withEndAction(new j(r7)).start();
    L40:
        ECLottieAnimationView r19 = r7.c;
        if (r19 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressLottie");
    L43:
        r19.setAnimation("ec_live_list_card_seckill_progress.json");
        ECLottieAnimationView r20 = r7.c;
        if (r20 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressLottie");
    L46:
        r20.setRepeatCount(0);
        ECLottieAnimationView r21 = r7.c;
        if (r21 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressLottie");
    L49:
        r21.playAnimation();
        ECLottieAnimationView r22 = r7.c;
        if (r22 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressLottie");
    L52:
        r22.addAnimatorListener(new k(r7));
        return;
    L55:
        return;
    }

    public ECStockProgressLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View r5 = th.a.c(r2, 2131564759, this, true);
        r5.setBackgroundResource(2131234298);
        this.a = r5.findViewById(2131370498);
        this.c = (ECLottieAnimationView) r5.findViewById(2131379216);
        this.b = (TextView) r5.findViewById(2131371239);
        this.d = (TextView) r5.findViewById(2131370759);
        this.f = LazyKt.lazy(ECStockProgressLayout$isLargeMode$2.INSTANCE);
        this.g = LazyKt.lazy(new ECStockProgressLayout$basicWidth$2(this));
        this.h = 10.0f;
    }

    public final void c(String r1, Float r2, String r3) {
        setLabel(r3);
        post(new l(this, r2, r1));
        setTxStockDes(r1);
    }

    public /* synthetic */ ECStockProgressLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
