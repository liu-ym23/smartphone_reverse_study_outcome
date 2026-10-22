package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.widget;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.core.widget.ECAutoScaleLayout;
import com.bytedance.android.ec.model.response.v0;
import com.bytedance.android.ec.model.response.w0;
import com.bytedance.android.ec.model.response.x0;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.drawable.ScalingUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import th.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0016\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015B\u001d\b\u0016\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0014\u0010\u0018B%\b\u0016\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u001aRT\u0010\u0011\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/widget/ECProductBottomView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View$OnClickListener;", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "clickIndex", "", "a", "Lkotlin/jvm/functions/Function2;", "getClickListener", "()Lkotlin/jvm/functions/Function2;", "setClickListener", "(Lkotlin/jvm/functions/Function2;)V", "clickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECProductBottomView extends ConstraintLayout implements View.OnClickListener {
    public Function2<? super View, ? super Integer, Unit> a;
    public final Guideline b;
    public final ECDraweeView c;
    public final List<View> d;
    public int e;
    public final TextView f;
    public final ECAutoScaleLayout g;
    public final ECDraweeView h;
    public final ECDraweeView i;

    public final Function2<View, Integer, Unit> getClickListener() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECProductBottomView(Context r19) {
        super(r19);
        Guideline r1 = new Guideline(getContext());
        r1.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r2 = new ConstraintLayout.LayoutParams(-2, -2);
        r2.orientation = 0;
        Unit r5 = Unit.INSTANCE;
        r1.setLayoutParams(r2);
        this.b = r1;
        ECDraweeView r3 = new ECDraweeView(getContext(), null, 0, 6, null);
        r3.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r6 = new ConstraintLayout.LayoutParams(UtilityKotlinExtentionsKt.d(16), -2);
        r6.setMargins(UtilityKotlinExtentionsKt.d(13), UtilityKotlinExtentionsKt.d(13), 0, 0);
        r3.setLayoutParams(r6);
        r3.setAdjustMode(2);
        this.c = r3;
        this.d = new ArrayList();
        TextView r7 = new TextView(getContext());
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(-2, -1);
        r8.gravity = 5;
        r7.setLayoutParams(r8);
        r7.setTextSize(1, 12.0f);
        r7.setTextColor(a.a(r7.getContext(), 2131105989));
        this.f = r7;
        ECAutoScaleLayout r9 = new ECAutoScaleLayout(getContext());
        r9.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r11 = new ConstraintLayout.LayoutParams(0, -2);
        r11.setMargins(UtilityKotlinExtentionsKt.d(16), UtilityKotlinExtentionsKt.d(Double.valueOf(19.3d)), UtilityKotlinExtentionsKt.d(1), 0);
        r9.setLayoutParams(r11);
        r9.setScaleType(2);
        r9.addView(r7);
        this.g = r9;
        ECDraweeView r4 = new ECDraweeView(getContext(), null, 0, 6, null);
        r4.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r10 = new ConstraintLayout.LayoutParams(UtilityKotlinExtentionsKt.d(9), UtilityKotlinExtentionsKt.d(9));
        r10.setMargins(0, 0, UtilityKotlinExtentionsKt.d(8), 0);
        r4.setLayoutParams(r10);
        this.h = r4;
        ECDraweeView r12 = new ECDraweeView(getContext(), null, 0, 6, null);
        r12.setId(ViewCompat.generateViewId());
        r12.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        r12.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        this.i = r12;
        addView(r12);
        addView(r1);
        addView(r3);
        addView(r9);
        addView(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(v0 r25) {
        Intrinsics.checkNotNullParameter(r25, "promotionExtend");
        int r1 = UtilityKotlinExtentionsKt.d(42);
        int r4 = UtilityKotlinExtentionsKt.d(8);
        int r7 = UtilityKotlinExtentionsKt.d(6);
        int r6 = UtilityKotlinExtentionsKt.d(6);
        this.g.setVisibility(0);
        this.h.setVisibility(0);
        h0.e(this.h, r25.h(), null, null, null, 120);
        TextView r8 = this.f;
        SpannableStringBuilder r10 = new SpannableStringBuilder();
        List r11 = r25.i();
        if (r11 == null) goto L11;
        Iterator r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L11;
        x0 r13 = (x0) r12.next();
        String r14 = r13.b();
        int r15 = s.a;
        Integer r16 = s.b(r13.a());
        if (r14 == null) goto L6;
        if (r16 == null) goto L6;
        int r17 = r16.intValue();
        int r18 = r10.length();
        r10.append(r14);
        r10.setSpan(new ForegroundColorSpan(r17), r18, r10.length(), 33);
    L11:
        Unit r19 = Unit.INSTANCE;
        r8.setText(r10);
        h0.e(this.c, r25.f(), null, null, null, 120);
        h0.e(this.i, r25.b(), null, null, null, 120);
        List r9 = r25.g();
        if (r9 == null) goto L26;
        Iterator r20 = r9.iterator();
        int r110 = 0;
    L15:
        if (r20.hasNext() == false) goto L26;
        Object r111 = r20.next();
        int r112 = r110 + 1;
        if (r110 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        w0 r113 = (w0) r111;
        if (r110 < ((ArrayList) this.d).size()) goto L22;
        View r114 = LayoutInflater.from(getContext()).inflate(2131564709, null);
        r114.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r115 = new ConstraintLayout.LayoutParams(r1, r1);
        r115.setMargins(r4, r7, 0, r6);
        Unit r116 = Unit.INSTANCE;
        r114.setLayoutParams(r115);
        this.e++;
        ((ArrayList) this.d).add(r114);
        addView(r114);
    L22:
        int r117 = this.e;
        if (r110 < r117) goto L25;
        this.e = r117 + 1;
        ((View) ListProtector.get(this.d, r110)).setVisibility(0);
    L25:
        ECLiveImageUtils.i(((View) ListProtector.get(this.d, r110)).findViewById(2131376519), r113.a(), 2, 0);
        ((View) ListProtector.get(this.d, r110)).setOnClickListener(this);
        ((View) ListProtector.get(this.d, r110)).findViewById(2131372824).setVisibility(8);
        r110 = r112;
    L26:
        List r2 = r25.g();
        if (r2 != null) goto L30;
        r2 = CollectionsKt.emptyList();
    L30:
        if (this.e <= r2.size()) goto L34;
        int r3 = r2.size();
        int r5 = this.e;
    L32:
        if (r3 >= r5) goto L34;
        this.e--;
        ((View) ListProtector.get(this.d, r3)).setVisibility(8);
        r3 = r3 + 1;
    L34:
        setOnClickListener(this);
        ConstraintSet r21 = new ConstraintSet();
        r21.clone(this);
        r21.connect(this.b.getId(), 3, 0, 3);
        r21.connect(this.i.getId(), 6, 0, 6);
        r21.connect(this.i.getId(), 3, 0, 3);
        r21.connect(this.c.getId(), 6, 0, 6);
        r21.connect(this.c.getId(), 3, this.b.getId(), 4);
        int r22 = this.c.getId();
        int r23 = this.e;
        int r24 = 0;
    L36:
        if (r24 >= r23) goto L38;
        int r118 = ((View) ListProtector.get(this.d, r24)).getId();
        r21.connect(r118, 6, r22, 7);
        r21.connect(r118, 3, this.b.getId(), 4);
        r21.connect(r118, 4, 0, 4);
        r24 = r24 + 1;
        r22 = r118;
        goto L36
    L38:
        r21.connect(this.g.getId(), 6, r22, 7);
        r21.connect(this.g.getId(), 7, this.h.getId(), 6);
        r21.connect(this.g.getId(), 3, this.b.getId(), 4);
        r21.connect(this.h.getId(), 6, this.g.getId(), 7);
        r21.connect(this.h.getId(), 7, 0, 7);
        r21.connect(this.h.getId(), 3, this.g.getId(), 3);
        r21.connect(this.h.getId(), 4, this.g.getId(), 4);
        r21.applyTo(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        Intrinsics.checkNotNullParameter(r6, "v");
        Function2<? super View, ? super Integer, Unit> r0 = this.a;
        if (r0 == null) goto L14;
        int r1 = this.e;
        int r2 = 0;
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L10;
        if (Intrinsics.areEqual((View) ListProtector.get(this.d, r3), r6) == true) goto L8;
        r3 = r3 + 1;
        goto L5
    L8:
        r2 = r3 + 1;
    L10:
        Unit r7 = (Unit) r0.invoke(r6, Integer.valueOf(r2));
        return;
    }

    public final void setClickListener(Function2<? super View, ? super Integer, Unit> r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECProductBottomView(Context r19, AttributeSet r20) {
        super(r19, r20);
        Guideline r1 = new Guideline(getContext());
        r1.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r2 = new ConstraintLayout.LayoutParams(-2, -2);
        r2.orientation = 0;
        Unit r5 = Unit.INSTANCE;
        r1.setLayoutParams(r2);
        this.b = r1;
        ECDraweeView r3 = new ECDraweeView(getContext(), null, 0, 6, null);
        r3.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r6 = new ConstraintLayout.LayoutParams(UtilityKotlinExtentionsKt.d(16), -2);
        r6.setMargins(UtilityKotlinExtentionsKt.d(13), UtilityKotlinExtentionsKt.d(13), 0, 0);
        r3.setLayoutParams(r6);
        r3.setAdjustMode(2);
        this.c = r3;
        this.d = new ArrayList();
        TextView r7 = new TextView(getContext());
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(-2, -1);
        r8.gravity = 5;
        r7.setLayoutParams(r8);
        r7.setTextSize(1, 12.0f);
        r7.setTextColor(a.a(r7.getContext(), 2131105989));
        this.f = r7;
        ECAutoScaleLayout r9 = new ECAutoScaleLayout(getContext());
        r9.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r11 = new ConstraintLayout.LayoutParams(0, -2);
        r11.setMargins(UtilityKotlinExtentionsKt.d(16), UtilityKotlinExtentionsKt.d(Double.valueOf(19.3d)), UtilityKotlinExtentionsKt.d(1), 0);
        r9.setLayoutParams(r11);
        r9.setScaleType(2);
        r9.addView(r7);
        this.g = r9;
        ECDraweeView r4 = new ECDraweeView(getContext(), null, 0, 6, null);
        r4.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r10 = new ConstraintLayout.LayoutParams(UtilityKotlinExtentionsKt.d(9), UtilityKotlinExtentionsKt.d(9));
        r10.setMargins(0, 0, UtilityKotlinExtentionsKt.d(8), 0);
        r4.setLayoutParams(r10);
        this.h = r4;
        ECDraweeView r12 = new ECDraweeView(getContext(), null, 0, 6, null);
        r12.setId(ViewCompat.generateViewId());
        r12.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        r12.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        this.i = r12;
        addView(r12);
        addView(r1);
        addView(r3);
        addView(r9);
        addView(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECProductBottomView(Context r19, AttributeSet r20, int r21) {
        super(r19, r20, r21);
        Guideline r1 = new Guideline(getContext());
        r1.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r2 = new ConstraintLayout.LayoutParams(-2, -2);
        r2.orientation = 0;
        Unit r5 = Unit.INSTANCE;
        r1.setLayoutParams(r2);
        this.b = r1;
        ECDraweeView r3 = new ECDraweeView(getContext(), null, 0, 6, null);
        r3.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r6 = new ConstraintLayout.LayoutParams(UtilityKotlinExtentionsKt.d(16), -2);
        r6.setMargins(UtilityKotlinExtentionsKt.d(13), UtilityKotlinExtentionsKt.d(13), 0, 0);
        r3.setLayoutParams(r6);
        r3.setAdjustMode(2);
        this.c = r3;
        this.d = new ArrayList();
        TextView r7 = new TextView(getContext());
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(-2, -1);
        r8.gravity = 5;
        r7.setLayoutParams(r8);
        r7.setTextSize(1, 12.0f);
        r7.setTextColor(a.a(r7.getContext(), 2131105989));
        this.f = r7;
        ECAutoScaleLayout r9 = new ECAutoScaleLayout(getContext());
        r9.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r11 = new ConstraintLayout.LayoutParams(0, -2);
        r11.setMargins(UtilityKotlinExtentionsKt.d(16), UtilityKotlinExtentionsKt.d(Double.valueOf(19.3d)), UtilityKotlinExtentionsKt.d(1), 0);
        r9.setLayoutParams(r11);
        r9.setScaleType(2);
        r9.addView(r7);
        this.g = r9;
        ECDraweeView r4 = new ECDraweeView(getContext(), null, 0, 6, null);
        r4.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r10 = new ConstraintLayout.LayoutParams(UtilityKotlinExtentionsKt.d(9), UtilityKotlinExtentionsKt.d(9));
        r10.setMargins(0, 0, UtilityKotlinExtentionsKt.d(8), 0);
        r4.setLayoutParams(r10);
        this.h = r4;
        ECDraweeView r12 = new ECDraweeView(getContext(), null, 0, 6, null);
        r12.setId(ViewCompat.generateViewId());
        r12.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        r12.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        this.i = r12;
        addView(r12);
        addView(r1);
        addView(r3);
        addView(r9);
        addView(r4);
    }
}
