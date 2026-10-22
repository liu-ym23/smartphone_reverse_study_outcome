package com.larksuite.component.universe_design.udswitch;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010*\u0002 #\b\u0017\u0018\u0000 I2\u00020\u0001:\u0002HIB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ*\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u000e\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0010J\b\u0010)\u001a\u0004\u0018\u00010\u0010J\u000e\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020\nJ\u000e\u0010/\u001a\u00020&2\u0006\u0010.\u001a\u00020\nJ(\u00100\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\nH\u0002J\u0018\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\nH\u0014J\u0010\u00108\u001a\u00020&2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020&2\u0006\u0010<\u001a\u00020:H\u0014J\b\u0010=\u001a\u000202H\u0002J\u0010\u0010>\u001a\u00020&2\u0006\u00101\u001a\u000202H\u0002J\b\u0010?\u001a\u00020\u0016H\u0016J\b\u0010@\u001a\u00020&H\u0002J\b\u0010A\u001a\u00020&H\u0002J\u0010\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u00020\u0016H\u0002J\u000e\u0010D\u001a\u00020&2\u0006\u0010E\u001a\u00020\u0016J\u000e\u0010F\u001a\u00020&2\u0006\u0010G\u001a\u00020\u001eR\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$¨\u0006J"}, d2 = {"Lcom/larksuite/component/universe_design/udswitch/UDSwitchWithLoading;", "Lcom/larksuite/component/universe_design/udswitch/UDSwitch;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mLoadingWidth", "mLoadingDrawable", "Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;", "mLoadingCheckedColor", "mLoadingUnCheckedColor", "mLoadingTintMode", "Landroid/graphics/PorterDuff$Mode;", "mHasLoadingTint", "", "mHasLoadingTintMode", "mLoadingRadius", "mLoadingStrokeWidth", "mTempRect", "Landroid/graphics/Rect;", "mLoadingState", "mLoadingStatusChangeListener", "Lcom/larksuite/component/universe_design/udswitch/UDSwitchWithLoading$OnLoadingStatusChangeListener;", "mLoadingAnimatorCallback", "com/larksuite/component/universe_design/udswitch/UDSwitchWithLoading$mLoadingAnimatorCallback$1", "Lcom/larksuite/component/universe_design/udswitch/UDSwitchWithLoading$mLoadingAnimatorCallback$1;", "drawablesAttachListener", "com/larksuite/component/universe_design/udswitch/UDSwitchWithLoading$drawablesAttachListener$1", "Lcom/larksuite/component/universe_design/udswitch/UDSwitchWithLoading$drawablesAttachListener$1;", "initView", "", "setLoadingDrawable", "loading", "getLoadingDrawable", "setLoadingTintList", "tint", "Landroid/content/res/ColorStateList;", "setLoadingRadius", "pixels", "setLoadingStrokeWidth", "generateProgressDrawable", "progressColors", "", "progressRadiusPx", "progressStrokePx", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "draw", "c", "Landroid/graphics/Canvas;", "onDraw", "canvas", "getStateColor", "changeColor", "performClick", "stopLoading", "startLoading", "setLoadingState", "isLoading", "submitLoadingStatus", "checked", "setOnLoadingStatusChangeListener", "listener", "OnLoadingStatusChangeListener", "Companion", "universe-ui-switch_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UDSwitchWithLoading extends UDSwitch {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final int[] f285458J = null;
    public static final int[] K = null;
    public CircularProgressDrawable B;
    public int C;
    public int D;
    public int E;
    public int F;
    public final Rect G;
    public boolean H;
    public b I;

    public static final class a {
    }

    public interface b {
        void a();
    }

    public static final class c implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDSwitchWithLoading f285459a;

        public c(UDSwitchWithLoading r100) {
            this.f285459a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            UDSwitchWithLoading r101 = this.f285459a;
            if (r101.H == false) goto L6;
            r101.c();
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            UDSwitchWithLoading r101 = this.f285459a;
            int[] r102 = UDSwitchWithLoading.f285458J;
            CircularProgressDrawable r103 = r101.B;
            if (r103 == null) goto L6;
            r103.stop();
            return;
        }
    }

    public static final class d implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDSwitchWithLoading f285460a;

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "who");
            Intrinsics.checkNotNullParameter(r101, "what");
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable r100, Runnable r101) {
            Intrinsics.checkNotNullParameter(r100, "who");
            Intrinsics.checkNotNullParameter(r101, "what");
        }

        public d(UDSwitchWithLoading r100) {
            this.f285460a = r100;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable r100) {
            Intrinsics.checkNotNullParameter(r100, "who");
            this.f285460a.invalidate();
        }
    }

    private final int[] getStateColor() {
        int[] r100 = new int[1];
        if (isChecked() == false) goto L5;
        int r101 = this.C;
    L6:
        r100[0] = r101;
        return r100;
    L5:
        r101 = this.D;
        goto L6
    }

    @Override // android.widget.CompoundButton, android.view.View
    public final boolean performClick() {
        setLoadingState(true);
        return true;
    }

    static {
        f285458J = new int[]{-16842910, R.attr.state_checked};
        K = new int[]{-16842910};
    }

    public final void c() {
        CircularProgressDrawable r100 = this.B;
        if (r100 == null) goto L15;
        int[] r101 = getStateColor();
        if (r101.length != 0) goto L7;
        boolean r102 = true;
    L9:
        if ((!r102) == false) goto L13;
        CircularProgressDrawable r103 = this.B;
        if (r103 == null) goto L13;
        r103.setColorSchemeColors(Arrays.copyOf(r101, r101.length));
    L13:
        r100.start();
        return;
    L7:
        r102 = false;
        goto L9
    }

    public final CircularProgressDrawable getLoadingDrawable() {
        return this.B;
    }

    public UDSwitchWithLoading(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    private final void setLoadingState(boolean r100) {
        if (this.H == r100) goto L14;
        this.H = r100;
        if (r100 == false) goto L10;
        b r101 = this.I;
        if (r101 == null) goto L9;
        isChecked();
        r101.a();
    L9:
        setEnabled(false);
        c();
        return;
    L10:
        setEnabled(true);
        CircularProgressDrawable r102 = this.B;
        if (r102 == null) goto L16;
        r102.stop();
        return;
    L16:
        return;
    }

    public final void d(boolean r100) {
        if (this.H == false) goto L6;
        setLoadingState(false);
        setChecked(r100);
        invalidate();
        return;
    }

    @Override // com.larksuite.component.universe_design.udswitch.UDSwitch, android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "c");
        super.draw(r100);
        Rect r101 = this.G;
        if (this.H == false) goto L10;
        CircularProgressDrawable r102 = this.B;
        if (r102 == null) goto L11;
        r102.getPadding(r101);
        int r103 = ((int) (r102.getCenterRadius() + r102.getStrokeWidth())) * 2;
        int r104 = getThumbInitialLeft() + ((getMThumbWidth() - r103) / 2);
        int r105 = r104 - r101.left;
        int r106 = (r104 + r103) + r101.right;
        r102.setBounds(r105, getMSwitchTop(), r106, getMSwitchBottom());
        Drawable r107 = getBackground();
        if (r107 == null) goto L12;
        DrawableCompat.setHotspotBounds(r107, r105, getMSwitchTop(), r106, getMSwitchBottom());
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.larksuite.component.universe_design.udswitch.UDSwitch, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.H == false) goto L9;
        CircularProgressDrawable r101 = this.B;
        int r102 = r100.save();
        if (r101 == null) goto L7;
        r101.draw(r100);
    L7:
        r100.restoreToCount(r102);
        return;
    }

    public final void setLoadingDrawable(CircularProgressDrawable r100) {
        Intrinsics.checkNotNullParameter(r100, "loading");
        this.B = r100;
        invalidate();
    }

    public final void setLoadingRadius(int r100) {
        CircularProgressDrawable r101 = this.B;
        if (r101 == null) goto L6;
        r101.setCenterRadius(r100 - r101.getStrokeWidth());
        int r102 = ((int) r101.getCenterRadius()) * 2;
        r101.setBounds(0, 0, r102, r102);
        return;
    }

    public final void setLoadingStrokeWidth(int r100) {
        CircularProgressDrawable r101 = this.B;
        if (r101 == null) goto L6;
        r101.setStrokeWidth(r100);
        return;
    }

    public final void setLoadingTintList(ColorStateList r100) {
        Intrinsics.checkNotNullParameter(r100, "tint");
        boolean r101 = false;
        this.C = r100.getColorForState(f285458J, 0);
        this.D = r100.getColorForState(K, 0);
        int[] r102 = getStateColor();
        if (r102.length != 0) goto L6;
        r101 = true;
    L6:
        if ((!r101) == false) goto L11;
        CircularProgressDrawable r103 = this.B;
        if (r103 == null) goto L12;
        r103.setColorSchemeColors(Arrays.copyOf(r102, r102.length));
        return;
    L12:
        return;
    }

    public final void setOnLoadingStatusChangeListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.I = r100;
    }

    public UDSwitchWithLoading(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // com.larksuite.component.universe_design.udswitch.UDSwitch, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        Rect r102 = this.G;
        if (this.H == false) goto L7;
        CircularProgressDrawable r103 = this.B;
        if (r103 == null) goto L7;
        Intrinsics.checkNotNull(r103);
        r103.getPadding(r102);
        CircularProgressDrawable r104 = this.B;
        Intrinsics.checkNotNull(r104);
        r104.getIntrinsicWidth();
        int r105 = r102.left;
        CircularProgressDrawable r106 = this.B;
        Intrinsics.checkNotNull(r106);
        r106.getIntrinsicHeight();
    L7:
        super.onMeasure(r100, r101);
    }

    public UDSwitchWithLoading(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111, 0);
        this.G = new Rect();
        d r101 = new d(this);
        c r102 = new c(this);
        TypedArray r112 = r100.obtainStyledAttributes(r110, new int[]{com.larus.nova.R.attr.ud_switch_loading, com.larus.nova.R.attr.ud_switch_loadingRadius, com.larus.nova.R.attr.ud_switch_loadingStrokeWidth, com.larus.nova.R.attr.ud_switch_loadingTint}, r111, com.larus.nova.R.style.UDSwitch);
        ColorStateList r113 = r112.getColorStateList(3);
        if (r113 == null) goto L5;
        int r103 = r113.getColorForState(f285458J, 0);
    L6:
        this.C = r103;
        if (r113 == null) goto L9;
        int r114 = r113.getColorForState(K, 0);
    L10:
        this.D = r114;
        this.E = r112.getDimensionPixelSize(1, (int) h18.d.a(r100, 5.43f));
        this.F = r112.getDimensionPixelSize(2, (int) h18.d.a(r100, 1.43f));
        Drawable r115 = r112.getDrawable(0);
        if ((r115 instanceof CircularProgressDrawable) == false) goto L13;
        this.B = (CircularProgressDrawable) r115;
    L21:
        CircularProgressDrawable r104 = this.B;
        if (r104 == null) goto L24;
        r104.setCallback(r101);
    L24:
        r112.recycle();
        addOnAttachStateChangeListener(r102);
        return;
    L13:
        int[] r116 = getStateColor();
        int r105 = this.E;
        int r106 = this.F;
        CircularProgressDrawable r107 = new CircularProgressDrawable(r100);
        r107.setStyle(1);
        if (r116.length != 0) goto L16;
        boolean r108 = true;
    L18:
        if ((!r108) == false) goto L20;
        r107.setColorSchemeColors(Arrays.copyOf(r116, r116.length));
    L20:
        r107.setStrokeCap(Paint.Cap.ROUND);
        float r117 = r106;
        r107.setCenterRadius(r105 - r117);
        r107.setStrokeWidth(r117);
        int r109 = ((int) r107.getCenterRadius()) * 2;
        r107.setBounds(0, 0, r109, r109);
        this.B = r107;
        goto L21
    L16:
        r108 = false;
        goto L18
    L9:
        r114 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }
}
