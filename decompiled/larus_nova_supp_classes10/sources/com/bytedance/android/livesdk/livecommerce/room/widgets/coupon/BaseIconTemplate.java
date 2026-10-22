package com.bytedance.android.livesdk.livecommerce.room.widgets.coupon;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalIconTemplate;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import th.a;
import yd.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR.\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/coupon/BaseIconTemplate;", "Landroid/widget/FrameLayout;", "Lyd/c;", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/sti/IExternalIconTemplate;", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/coupon/SquircleIconContent;", "c", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/coupon/SquircleIconContent;", "getContentContainer", "()Lcom/bytedance/android/livesdk/livecommerce/room/widgets/coupon/SquircleIconContent;", "contentContainer", "", "value", "d", "Ljava/lang/String;", "getSuperscript", "()Ljava/lang/String;", "setSuperscript", "(Ljava/lang/String;)V", "superscript", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseIconTemplate extends FrameLayout implements c, IExternalIconTemplate {
    public final TextView a;
    public final TextView b;
    public final SquircleIconContent c;
    public String d;

    public BaseIconTemplate(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BaseIconTemplate(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public View getView() {
        return this;
    }

    public final SquircleIconContent getContentContainer() {
        return this.c;
    }

    public final String getSuperscript() {
        return this.d;
    }

    public final Animator getEntryAnimation(long r12) {
        this.c.setScaleX(0.0f);
        this.c.setScaleY(0.0f);
        this.a.setAlpha(0.0f);
        this.b.setAlpha(0.0f);
        SquircleIconContent r0 = this.c;
        float[] r2 = {1.0f};
        Intrinsics.checkNotNullParameter(r0, "target");
        Intrinsics.checkNotNullParameter(r2, "values");
        AnimatorSet r5 = new AnimatorSet();
        r5.playTogether(new Animator[]{ObjectAnimator.ofFloat(r0, "scaleX", Arrays.copyOf(r2, 1)), ObjectAnimator.ofFloat(r0, "scaleY", Arrays.copyOf(r2, 1))});
        r5.setDuration(250);
        r5.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.a, "alpha", new float[]{1.0f});
        r1.setDuration(200);
        r1.setStartDelay(400);
        r1.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator r3 = ObjectAnimator.ofFloat(this.b, "alpha", new float[]{1.0f});
        r3.setDuration(200);
        r3.setStartDelay(400);
        r3.setInterpolator(new DecelerateInterpolator());
        AnimatorSet r4 = new AnimatorSet();
        r4.setStartDelay(r12);
        r4.play(r1).with(r3).after(r5);
        return r4;
    }

    public final void setSuperscript(String r2) {
        this.d = r2;
        if (r2 != null) goto L5;
        this.b.setVisibility(8);
        return;
    L5:
        this.b.setText(r2);
        this.b.setVisibility(0);
    }

    public BaseIconTemplate(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        SquircleIconContent r10 = new SquircleIconContent(r7, null, 6, 0);
        addView(r10);
        Unit r0 = Unit.INSTANCE;
        o0.f(r10, -1);
        o0.d(r10, -1);
        this.c = r10;
        TextView r11 = new TextView(r7);
        addView(r11);
        o0.f(r11, UtilityKotlinExtentionsKt.d(30));
        o0.d(r11, UtilityKotlinExtentionsKt.d(10));
        o0.c(r11, 81);
        r11.setGravity(17);
        r11.setBackgroundDrawable(ContextCompat.getDrawable(r7, 2131234782));
        r11.setTextColor(-1);
        r11.setTextSize(1, 8.0f);
        r11.setIncludeFontPadding(false);
        r11.setVisibility(8);
        this.a = r11;
        TextView r12 = new TextView(r7);
        addView(r12);
        o0.f(r12, -2);
        o0.d(r12, UtilityKotlinExtentionsKt.d(12));
        r12.setMinWidth(UtilityKotlinExtentionsKt.d(12));
        r12.setPadding(UtilityKotlinExtentionsKt.d(2), 0, UtilityKotlinExtentionsKt.d(2), 0);
        o0.c(r12, 53);
        r12.setGravity(17);
        r12.setBackground(ContextCompat.getDrawable(r7, 2131234783));
        r12.setTextColor(a.a(r7, 2131106181));
        r12.setTextSize(1, 9.0f);
        r12.setIncludeFontPadding(false);
        r12.setVisibility(8);
        r12.setImportantForAccessibility(2);
        this.b = r12;
    }

    public /* synthetic */ BaseIconTemplate(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
