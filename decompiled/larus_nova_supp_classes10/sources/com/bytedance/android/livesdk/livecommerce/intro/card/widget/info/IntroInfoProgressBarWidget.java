package com.bytedance.android.livesdk.livecommerce.intro.card.widget.info;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.response.k;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.i0;
import com.bytedance.android.livesdk.livecommerce.promotion.card.view.CountDownView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u001a\u0010\n\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/info/IntroInfoProgressBarWidget;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/info/a;", "", "getCurrentContentDescription", "", "a", "I", "getType", "()I", LocationMonitorConst.TYPE, "Loh2/e;", "b", "Loh2/e;", "getArgument", "()Loh2/e;", "setArgument", "(Loh2/e;)V", "argument", "Loh2/c;", "c", "Loh2/c;", "getContainerAbility", "()Loh2/c;", "setContainerAbility", "(Loh2/c;)V", "containerAbility", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroInfoProgressBarWidget extends FrameLayout implements com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a {
    public final int a;
    public oh2.e b;
    public oh2.c c;
    public i0 d;
    public final a e;

    public static final class a implements q83.a {
        public final /* synthetic */ IntroInfoProgressBarWidget a;

        public a(IntroInfoProgressBarWidget r1) {
            this.a = r1;
        }

        public final boolean onTick(long r10) {
            i0 r0 = this.a.d;
            if (r0 == null) goto L23;
            k r1 = r0.b();
            if (r1 == null) goto L23;
            oh2.c r2 = this.a.getContainerAbility();
            if (r2 == null) goto L11;
            Long r3 = r2.b(r1.c(), r1.a());
            if (r3 == null) goto L11;
            long r5 = r3.longValue();
        L12:
            IntroInfoProgressBarWidget r4 = this.a;
            long r6 = r5 - r10;
            CountDownView r11 = (CountDownView) r4.findViewById(2131368046);
            if (r6 <= 0) goto L15;
            r11.setVisibility(0);
            r11.a(r6);
            return true;
        L15:
            r11.setVisibility(4);
            oh2.e r12 = r4.getArgument();
            if (r12 == null) goto L20;
            oh2.d r13 = r12.d;
            if (r13 == null) goto L20;
            r13.a();
        L20:
            com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(r4.e);
            return true;
        L11:
            r5 = 0;
        L23:
            return false;
        }
    }

    public IntroInfoProgressBarWidget(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IntroInfoProgressBarWidget(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public String getCurrentContentDescription() {
        return "";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public final void release() {
        oh2.e r0 = getArgument();
        if (r0 == null) goto L7;
        oh2.d r1 = r0.d;
        if (r1 == null) goto L7;
        r1.a();
    L7:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(this.e);
        this.d = null;
    }

    public oh2.e getArgument() {
        return this.b;
    }

    public oh2.c getContainerAbility() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public int getType() {
        return this.a;
    }

    public final void a(i0 r10) {
        Intrinsics.checkNotNullParameter(r10, "progressBar");
        if (Intrinsics.areEqual(this.d, r10) == false) goto L5;
        return;
    L5:
        this.d = r10;
        IntroStockProgressLayout r0 = (IntroStockProgressLayout) findViewById(2131365111);
        String r1 = r10.c();
        Long r2 = r10.d();
        if (r2 == null) goto L8;
        Float r3 = Float.valueOf(r2.longValue());
    L9:
        String r4 = r10.e();
        String r5 = r10.f();
        String r6 = r10.a();
        TextView r7 = r0.c;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L12:
        r7.setContentDescription(r4);
        if (TextUtils.isEmpty(r4) == false) goto L18;
        TextView r8 = r0.c;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L17:
        r8.setVisibility(4);
    L35:
        TextView r9 = r0.c;
        if (r9 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L38:
        int r11 = s.a;
        r9.setTextColor(s.a(r5, th.a.a(r0.getContext(), 2131106050)));
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_INFO_PROGRESS_FIX() == false) goto L41;
        r0.f = r3;
    L42:
        TextView r12 = r0.b;
        if (r12 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L45:
        r12.setContentDescription(r1);
        if (TextUtils.isEmpty(r1) == false) goto L51;
        TextView r13 = r0.b;
        if (r13 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L50:
        r13.setVisibility(8);
    L61:
        Integer r14 = s.b(r6);
        if (r14 == null) goto L64;
        int r15 = r14.intValue();
        GradientDrawable r16 = new GradientDrawable();
        r16.setColor(r15);
        r16.setCornerRadius(UtilityKotlinExtentionsKt.c(10));
        Drawable r17 = r16;
    L65:
        r0.setBackground(r17);
        k r18 = r10.b();
        if (r18 == null) goto L76;
        CountDownView r19 = (CountDownView) findViewById(2131368046);
        if (r19 == null) goto L70;
        r19.b(r18);
    L70:
        oh2.e r110 = getArgument();
        if (r110 == null) goto L75;
        oh2.d r111 = r110.d;
        if (r111 == null) goto L75;
        r111.a();
    L75:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.a(this.e);
        return;
    L76:
        CountDownView r112 = (CountDownView) findViewById(2131368046);
        if (r112 == null) goto L79;
        r112.setVisibility(4);
    L79:
        oh2.e r113 = getArgument();
        if (r113 == null) goto L84;
        oh2.d r114 = r113.d;
        if (r114 == null) goto L84;
        r114.a();
    L84:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(this.e);
        Unit r115 = Unit.INSTANCE;
        return;
    L64:
        r17 = th.a.b(r0.getContext(), 2131234266);
        goto L65
    L51:
        TextView r20 = r0.b;
        if (r20 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L54:
        r20.setVisibility(0);
        TextView r21 = r0.b;
        if (r21 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L57:
        r21.setText(r1);
        TextView r22 = r0.b;
        if (r22 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L60:
        r22.setTextSize(1, r0.e);
        goto L61
    L41:
        r0.post(new e(r0, r3, r1));
        goto L42
    L18:
        TextView r23 = r0.c;
        if (r23 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L22:
        if (Intrinsics.areEqual(r23.getText(), r4) == false) goto L28;
        TextView r24 = r0.c;
        if (r24 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L27:
        if (r24.getVisibility() == 0) goto L35;
    L28:
        TextView r25 = r0.c;
        if (r25 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L31:
        r25.setText(r4);
        TextView r26 = r0.c;
        if (r26 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L34:
        r26.setVisibility(4);
        goto L35
    L8:
        r3 = null;
        goto L9
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View r1) {
        super.onViewRemoved(r1);
        release();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public void setArgument(oh2.e r1) {
        this.b = r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public void setContainerAbility(oh2.c r1) {
        this.c = r1;
    }

    public IntroInfoProgressBarWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = 4;
        ShoppingAsyncInflater.e.getClass();
        addView(ShoppingAsyncInflater.a.a(r2).aU(2131560754, this, false), new FrameLayout.LayoutParams(-1, -2));
        IntroStockProgressLayout r5 = (IntroStockProgressLayout) findViewById(2131365111);
        getArgument();
        r5.getClass();
        getContainerAbility();
        r5.getClass();
        this.e = new a(this);
    }

    public /* synthetic */ IntroInfoProgressBarWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
