package com.bytedance.android.livesdk.livecommerce.intro.card.widget.info;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u001a\u0010\n\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/info/IntroInfoBenefitLabelWidget;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/info/a;", "", "getCurrentContentDescription", "", "a", "I", "getType", "()I", LocationMonitorConst.TYPE, "Loh2/e;", "b", "Loh2/e;", "getArgument", "()Loh2/e;", "setArgument", "(Loh2/e;)V", "argument", "Loh2/c;", "c", "Loh2/c;", "getContainerAbility", "()Loh2/c;", "setContainerAbility", "(Loh2/c;)V", "containerAbility", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroInfoBenefitLabelWidget extends LinearLayout implements a {
    public final int a;
    public oh2.e b;
    public oh2.c c;

    public IntroInfoBenefitLabelWidget(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IntroInfoBenefitLabelWidget(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public String getCurrentContentDescription() {
        return "";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public final void release() {
        Iterator r0 = com.bytedance.commerce.base.view.b.a(this).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        View r1 = (View) r0.next();
        if ((r1 instanceof IntroBenefitLabelView) == false) goto L4;
        ((IntroBenefitLabelView) r1).c();
        goto L4
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

    public final void a(List<PromotionBenefitLabel> r10) {
        Intrinsics.checkNotNullParameter(r10, "benefitLabels");
        Iterator<T> r11 = r10.iterator();
        int r1 = 0;
    L4:
        if (r11.hasNext() == false) goto L14;
        Object r2 = r11.next();
        int r4 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        PromotionBenefitLabel r3 = (PromotionBenefitLabel) r2;
        IntroBenefitLabelView r5 = new IntroBenefitLabelView(getContext(), null, 6, 0);
        r5.a = getArgument();
        r5.b = getContainerAbility();
        r5.setFocusable(true);
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(14));
        if (r1 != 0) goto L11;
        int r7 = 0;
    L12:
        r6.setMarginStart(UtilityKotlinExtentionsKt.d(r7));
        Unit r8 = Unit.INSTANCE;
        addView(r5, r6);
        r5.a(r3, null);
        r1 = r4;
        goto L4
    L11:
        r7 = 4;
        goto L12
    L14:
        if ((getChildAt(getChildCount() - 1) instanceof IntroBenefitLabelView) == false) goto L17;
        addView(new Space(getContext()), new LinearLayout.LayoutParams(1, 0));
        return;
    L17:
        if ((getChildAt(getChildCount() - 1) instanceof Space) == false) goto L26;
        View r12 = getChildAt(getChildCount() - 1);
        if (r12 == null) goto L27;
        r12.setVisibility(0);
        return;
    L27:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public void setArgument(oh2.e r1) {
        this.b = r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public void setContainerAbility(oh2.c r1) {
        this.c = r1;
    }

    public IntroInfoBenefitLabelWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = 3;
        int r5 = com.bytedance.android.ec.core.utils.a.a;
        Intrinsics.checkNotNullParameter(this, "view");
        if (Build.VERSION.SDK_INT < 26) goto L6;
        setImportantForAccessibility(4);
        return;
    }

    public /* synthetic */ IntroInfoBenefitLabelWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        super.onLayout(r2, r3, r4, r5, r6);
        int r7 = getChildCount() - 1;
    L3:
        if (r7 < 0) goto L13;
        View r8 = getChildAt(r7);
        if (r8 == null) goto L12;
        if (r8.getVisibility() == 8) goto L12;
        if ((r8.getLeft() + r8.getMeasuredWidth()) < getMeasuredWidth()) goto L19;
        r8.layout(r8.getLeft(), r8.getTop(), r8.getLeft(), r8.getBottom());
        goto L12
    L19:
        return;
    L12:
        r7 = r7 - 1;
        goto L3
    }
}
