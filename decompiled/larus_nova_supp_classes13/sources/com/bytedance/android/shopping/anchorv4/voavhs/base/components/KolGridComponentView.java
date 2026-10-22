package com.bytedance.android.shopping.anchorv4.voavhs.base.components;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.elements.KolReviewElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.ScaleFrame;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.KolReviewElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/KolGridComponentView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class KolGridComponentView extends FrameLayout {
    public final b a;
    public List<KolReviewElement> b;

    public KolGridComponentView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KolGridComponentView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        this.a.e(r2);
        super.draw(r2);
        this.a.d(r2);
    }

    public final void a(List r7, Function0 r8) {
        removeAllViews();
        this.b = r7;
        if (r7 == null) goto L10;
        List r9 = CollectionsKt.filterNotNull(r7);
        if (r9 == null) goto L10;
        Iterator r10 = r9.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        KolReviewElement r0 = (KolReviewElement) r10.next();
        KolReviewElementView r1 = new KolReviewElementView(getContext(), null, 0, 14);
        r1.a(r0, new FrameLayout.LayoutParams(-1, -1));
        Unit r2 = Unit.INSTANCE;
        addView(r1);
    L10:
        post(new a(r8));
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r5, int r6) {
        super.onMeasure(r5, r6);
        Iterator r7 = com.bytedance.commerce.base.view.b.a(this).iterator();
        int r8 = 0;
    L4:
        if (r7.hasNext() == false) goto L20;
        Object r0 = r7.next();
        int r1 = r8 + 1;
        if (r8 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r2 = (View) r0;
        List<KolReviewElement> r3 = this.b;
        if (r3 == null) goto L11;
        KolReviewElement r9 = (KolReviewElement) CollectionsKt.getOrNull(r3, r8);
    L12:
        if (r9 == null) goto L18;
        ScaleFrame r10 = r9.getScaleFrame();
        if (r10 == null) goto L18;
        Float r11 = r10.getScaleWidth();
        if (r11 == null) goto L18;
        float r12 = r11.floatValue();
    L19:
        int r13 = (int) (r12 * getMeasuredWidth());
        r2.measure(View.MeasureSpec.makeMeasureSpec(r13, 1073741824), View.MeasureSpec.makeMeasureSpec(r13, 1073741824));
        r8 = r1;
    L18:
        r12 = 0.0f;
        goto L19
    L11:
        r9 = null;
        goto L12
    }

    public KolGridComponentView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        b r5 = new b(this);
        this.a = r5;
        ViewParent r6 = getParent();
        if ((r6 instanceof FrameLayout) == true) goto L5;
        r6 = null;
    L5:
        FrameLayout r7 = (FrameLayout) r6;
        if (r7 == null) goto L8;
        int r0 = g1.a;
        r7.setBackgroundColor(g1.a.a(r2, 2131106022));
    L8:
        r5.f(new Radius(10, 10, 10, 10));
    }

    public /* synthetic */ KolGridComponentView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.a.c(r1, r2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        super.onLayout(r7, r8, r9, r8 + getMeasuredWidth(), r9 + getMeasuredWidth());
        Iterator r12 = com.bytedance.commerce.base.view.b.a(this).iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L38;
        Object r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r16 = (View) r14;
        List<KolReviewElement> r17 = this.b;
        if (r17 == null) goto L13;
        KolReviewElement r18 = (KolReviewElement) CollectionsKt.getOrNull(r17, r13);
        if (r18 == null) goto L13;
        ScaleFrame r19 = r18.getScaleFrame();
    L14:
        float r110 = 0.0f;
        if (r19 == null) goto L19;
        Float r0 = r19.getScaleX();
        if (r0 == null) goto L19;
        float r1 = r0.floatValue();
    L20:
        int r2 = (int) (r1 * getMeasuredWidth());
        if (r19 == null) goto L25;
        Float r3 = r19.getScaleY();
        if (r3 == null) goto L25;
        float r4 = r3.floatValue();
    L26:
        int r5 = (int) (r4 * getMeasuredWidth());
        if (r19 == null) goto L31;
        Float r6 = r19.getScaleX();
        if (r6 == null) goto L31;
        float r20 = r6.floatValue();
    L32:
        int r21 = ((int) (r20 * getMeasuredWidth())) + r16.getMeasuredWidth();
        if (r19 == null) goto L37;
        Float r22 = r19.getScaleY();
        if (r22 == null) goto L37;
        r110 = r22.floatValue();
    L37:
        r16.layout(r2, r5, r21, ((int) (r110 * getMeasuredWidth())) + r16.getMeasuredWidth());
        r13 = r15;
    L31:
        r20 = 0.0f;
    L25:
        r4 = 0.0f;
    L19:
        r1 = 0.0f;
    L13:
        r19 = null;
        goto L14
    }
}
