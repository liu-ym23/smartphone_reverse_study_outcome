package com.larus.avlink.simulInterpret.page.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.avlink.impl.databinding.LarusDoraAvlinkSliderTouchViewBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010!\u001a\u00020\u000eH\u0016J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u0006%"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/ui/SliderTouchView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LarusDoraAvlinkSliderTouchViewBinding;", "touchSlop", "isDragging", "", "downRawY", "", "onDragStart", "Lkotlin/Function0;", "", "getOnDragStart", "()Lkotlin/jvm/functions/Function0;", "setOnDragStart", "(Lkotlin/jvm/functions/Function0;)V", "onDrag", "Lkotlin/Function1;", "getOnDrag", "()Lkotlin/jvm/functions/Function1;", "setOnDrag", "(Lkotlin/jvm/functions/Function1;)V", "onDragEnd", "getOnDragEnd", "setOnDragEnd", "performClick", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SliderTouchView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusDoraAvlinkSliderTouchViewBinding f294535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f294536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f294537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f294538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f294539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super Float, Unit> f294540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super Float, Unit> f294541g;

    public SliderTouchView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SliderTouchView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final boolean performClick() {
        super.performClick();
        return true;
    }

    public final Function1<Float, Unit> getOnDrag() {
        return this.f294540f;
    }

    public final Function1<Float, Unit> getOnDragEnd() {
        return this.f294541g;
    }

    public final Function0<Unit> getOnDragStart() {
        return this.f294539e;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getActionMasked();
        if (r101 == 0) goto L38;
        if (r101 != 1) goto L6;
        ViewParent r102 = getParent();
        if (r102 == null) goto L31;
        r102.requestDisallowInterceptTouchEvent(false);
    L31:
        if (this.f294537c == false) goto L35;
        Function1<? super Float, Unit> r103 = this.f294541g;
        if (r103 == null) goto L36;
        r103.invoke(Float.valueOf(r100.getRawY() - this.f294538d));
    L36:
        this.f294535a.f293194b.setPressed(false);
        this.f294537c = false;
        return true;
    L35:
        super.performClick();
        goto L36
    L6:
        if (r101 != 2) goto L8;
        float r104 = r100.getRawY() - this.f294538d;
        if (this.f294537c == true) goto L22;
        if (Math.abs(r104) <= this.f294536b) goto L22;
        this.f294537c = true;
    L22:
        if (this.f294537c == false) goto L26;
        Function1<? super Float, Unit> r105 = this.f294540f;
        if (r105 == null) goto L26;
        r105.invoke(Float.valueOf(r104));
    L26:
        return true;
    L8:
        if (r101 != 3) goto L10;
        ViewParent r106 = getParent();
        if (r106 == null) goto L14;
        r106.requestDisallowInterceptTouchEvent(false);
    L14:
        this.f294535a.f293194b.setPressed(false);
        this.f294537c = false;
        return true;
    L10:
        return super.onTouchEvent(r100);
    L38:
        this.f294538d = r100.getRawY();
        this.f294535a.f293194b.setPressed(true);
        this.f294537c = false;
        ViewParent r107 = getParent();
        if (r107 == null) goto L41;
        r107.requestDisallowInterceptTouchEvent(true);
    L41:
        Function0<Unit> r108 = this.f294539e;
        if (r108 == null) goto L44;
        r108.invoke();
    L44:
        return true;
    }

    public final void setOnDrag(Function1<? super Float, Unit> r100) {
        this.f294540f = r100;
    }

    public final void setOnDragEnd(Function1<? super Float, Unit> r100) {
        this.f294541g = r100;
    }

    public final void setOnDragStart(Function0<Unit> r100) {
        this.f294539e = r100;
    }

    public SliderTouchView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.larus_dora_avlink_slider_touch_view, this, false);
        addView(r103);
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r103, R.id.slider);
        if (r104 == null) goto L7;
        this.f294535a = new LarusDoraAvlinkSliderTouchViewBinding((ConstraintLayout) r103, r104);
        this.f294536b = ViewConfiguration.get(r100).getScaledTouchSlop();
        setClickable(true);
        setFocusable(true);
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(R.id.slider)));
    }

    public /* synthetic */ SliderTouchView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
