package com.larus.dora.o.impl.simul;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010!\u001a\u00020\fH\u0016J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/dora/o/impl/simul/OSimulSliderHandleView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "touchSlop", "isDragging", "", "downRawY", "", "onDragStart", "Lkotlin/Function0;", "", "getOnDragStart", "()Lkotlin/jvm/functions/Function0;", "setOnDragStart", "(Lkotlin/jvm/functions/Function0;)V", "onDrag", "Lkotlin/Function1;", "getOnDrag", "()Lkotlin/jvm/functions/Function1;", "setOnDrag", "(Lkotlin/jvm/functions/Function1;)V", "onDragEnd", "getOnDragEnd", "setOnDragEnd", "barView", "Landroid/view/View;", "performClick", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "dp", "value", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OSimulSliderHandleView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f338866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f338867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f338868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f338869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super Float, Unit> f338870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super Float, Unit> f338871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f338872g;

    public OSimulSliderHandleView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OSimulSliderHandleView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final boolean performClick() {
        super.performClick();
        return true;
    }

    public final Function1<Float, Unit> getOnDrag() {
        return this.f338870e;
    }

    public final Function1<Float, Unit> getOnDragEnd() {
        return this.f338871f;
    }

    public final Function0<Unit> getOnDragStart() {
        return this.f338869d;
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
        if (this.f338867b == false) goto L35;
        Function1<? super Float, Unit> r103 = this.f338871f;
        if (r103 == null) goto L36;
        r103.invoke(Float.valueOf(r100.getRawY() - this.f338868c));
    L36:
        this.f338872g.setPressed(false);
        this.f338867b = false;
        return true;
    L35:
        super.performClick();
        goto L36
    L6:
        if (r101 != 2) goto L8;
        float r104 = r100.getRawY() - this.f338868c;
        if (this.f338867b == true) goto L22;
        if (Math.abs(r104) <= this.f338866a) goto L22;
        this.f338867b = true;
    L22:
        if (this.f338867b == false) goto L26;
        Function1<? super Float, Unit> r105 = this.f338870e;
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
        this.f338872g.setPressed(false);
        this.f338867b = false;
        return true;
    L10:
        return super.onTouchEvent(r100);
    L38:
        this.f338868c = r100.getRawY();
        this.f338872g.setPressed(true);
        this.f338867b = false;
        ViewParent r107 = getParent();
        if (r107 == null) goto L41;
        r107.requestDisallowInterceptTouchEvent(true);
    L41:
        Function0<Unit> r108 = this.f338869d;
        if (r108 == null) goto L44;
        r108.invoke();
    L44:
        return true;
    }

    public final void setOnDrag(Function1<? super Float, Unit> r100) {
        this.f338870e = r100;
    }

    public final void setOnDragEnd(Function1<? super Float, Unit> r100) {
        this.f338871f = r100;
    }

    public final void setOnDragStart(Function0<Unit> r100) {
        this.f338869d = r100;
    }

    public OSimulSliderHandleView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f338866a = ViewConfiguration.get(r100).getScaledTouchSlop();
        View r103 = new View(r100);
        r103.setBackgroundResource(R.drawable.dora_o_bg_simul_slider_bar);
        this.f338872g = r103;
        setClickable(true);
        setFocusable(true);
        Resources r104 = getResources();
        int r105 = (int) ((WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density * 36) + 0.5f);
        Resources r106 = getResources();
        addView(r103, new FrameLayout.LayoutParams(r105, (int) ((WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).density * 8) + 0.5f), 17));
    }

    public /* synthetic */ OSimulSliderHandleView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
