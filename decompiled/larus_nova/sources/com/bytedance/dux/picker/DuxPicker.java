package com.bytedance.dux.picker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.dux.api.DuxComponent;
import com.bytedance.dux.largefont.DuxLargeFontHelper;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import em4.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u001dJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u001b\u0010\u000e\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0011\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001b\u0010\u0014\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001b\u0010\u0019\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001c\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/bytedance/dux/picker/DuxPicker;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "enable", "", "setAdaptLargeFontInternal", "(Ljava/lang/Boolean;)V", "", "Lcom/bytedance/dux/picker/WheelView;", "getWheelViews", "b", "Lkotlin/Lazy;", "getWheelView1", "()Lcom/bytedance/dux/picker/WheelView;", "wheelView1", "c", "getWheelView2", "wheelView2", "d", "getWheelView3", "wheelView3", "Landroid/view/View;", "e", "getTopMask", "()Landroid/view/View;", "topMask", "f", "getBottomMask", "bottomMask", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxPicker extends ConstraintLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final DuxComponent f205396h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f205397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f205398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f205399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f205400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f205401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f205402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f205403g;

    public static final class a {
    }

    public DuxPicker(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 30);
    }

    public DuxPicker(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 28);
    }

    public DuxPicker(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 24);
    }

    static {
        f205396h = DuxComponent.PICKER;
    }

    private final View getBottomMask() {
        return (View) this.f205402f.getValue();
    }

    private final View getTopMask() {
        return (View) this.f205401e.getValue();
    }

    private final WheelView getWheelView1() {
        return (WheelView) this.f205398b.getValue();
    }

    private final WheelView getWheelView2() {
        return (WheelView) this.f205399c.getValue();
    }

    private final WheelView getWheelView3() {
        return (WheelView) this.f205400d.getValue();
    }

    public final List<WheelView> getWheelViews() {
        ArrayList r100 = new ArrayList();
        if (n.d(getWheelView1()) == false) goto L6;
        r100.add(getWheelView1());
    L6:
        if (n.d(getWheelView2()) == false) goto L9;
        r100.add(getWheelView2());
    L9:
        if (n.d(getWheelView3()) == false) goto L11;
        r100.add(getWheelView3());
    L11:
        return r100;
    }

    public static DisplayMetrics R5(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private final void setAdaptLargeFontInternal(Boolean r100) {
        Lazy r101 = DuxLargeFontHelper.f205243a;
        this.f205403g = DuxLargeFontHelper.a(f205396h, r100);
    }

    public final List<WheelView> S5(List<String> r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "firstColumnEntries");
        Intrinsics.checkNotNullParameter(r101, "secondColumnEntries");
        getWheelView1().setShowTopRightCorner(false);
        getWheelView1().setShowBottomRightCorner(false);
        n.f(getWheelView2());
        n.e(getWheelView3());
        float r102 = 32;
        getWheelView1().setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r102, R5(Resources.getSystem()))), 0, 0, 0);
        getWheelView2().setPadding(0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r102, R5(Resources.getSystem()))), 0);
        getWheelView1().setShowTopRightCorner(false);
        getWheelView1().setShowBottomRightCorner(false);
        getWheelView2().setShowTopLeftCorner(false);
        getWheelView2().setShowBottomLeftCorner(false);
        getWheelView1().setEntries(r100);
        getWheelView2().setEntries(r101);
        return CollectionsKt.listOf(new WheelView[]{getWheelView1(), getWheelView2()});
    }

    public DuxPicker(Context r100, AttributeSet r101, int r102, int r110) {
        if ((r110 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r110 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f205397a = false;
        this.f205398b = LazyKt.lazy(new DuxPicker$wheelView1$2(this));
        this.f205399c = LazyKt.lazy(new DuxPicker$wheelView2$2(this));
        this.f205400d = LazyKt.lazy(new DuxPicker$wheelView3$2(this));
        this.f205401e = LazyKt.lazy(new DuxPicker$topMask$2(this));
        this.f205402f = LazyKt.lazy(new DuxPicker$bottomMask$2(this));
        Lazy r103 = DuxLargeFontHelper.f205243a;
        this.f205403g = DuxLargeFontHelper.a(f205396h, null);
        LayoutInflater.from(r100).inflate(R.layout.dux_picker, this);
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.adaptLargeFontMode, R.attr.limitLargeFontScale, R.attr.pickerHighlightColor, R.attr.pickerShowHighlight});
        if (r104.hasValue(0) == false) goto L11;
        setAdaptLargeFontInternal(Boolean.valueOf(r104.getBoolean(0, false)));
    L11:
        boolean r105 = r104.getBoolean(1, false);
        this.f205397a = r105;
        r104.recycle();
        Function1<WheelView, Unit> r106 = new DuxPicker$wheelInitFunc$1(this);
        if (this.f205403g == false) goto L29;
        r106.invoke(getWheelView1());
        r106.invoke(getWheelView2());
        r106.invoke(getWheelView3());
        View r107 = getTopMask();
        ViewGroup.LayoutParams r111 = r107.getLayoutParams();
        if (r111 == null) goto L28;
        if (r105 == false) goto L18;
        int r108 = MathKt.roundToInt(TypedValue.applyDimension(1, 24 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), R5(Resources.getSystem())));
    L19:
        r111.height = r108;
        r107.setLayoutParams(r111);
        View r109 = getBottomMask();
        ViewGroup.LayoutParams r112 = r109.getLayoutParams();
        if (r112 == null) goto L26;
        if (r105 == false) goto L23;
        int r113 = MathKt.roundToInt(TypedValue.applyDimension(1, 24 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), R5(Resources.getSystem())));
    L24:
        r112.height = r113;
        r109.setLayoutParams(r112);
        return;
    L23:
        r113 = MathKt.roundToInt(TypedValue.applyDimension(2, 24, R5(Resources.getSystem())));
        goto L24
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L18:
        r108 = MathKt.roundToInt(TypedValue.applyDimension(2, 24, R5(Resources.getSystem())));
        goto L19
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
