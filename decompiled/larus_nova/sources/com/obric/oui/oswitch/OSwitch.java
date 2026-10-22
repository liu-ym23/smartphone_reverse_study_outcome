package com.obric.oui.oswitch;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import pla.d;
import pla.j;
import vma.c;
import wma.b;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001!B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0016¢\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0016R\u0014\u0010\u0011\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\""}, d2 = {"Lcom/obric/oui/oswitch/OSwitch;", "Lcom/obric/oui/oswitch/SwitchCompat;", "Landroid/graphics/drawable/Drawable;", "getUncheckedDrawable", "getCheckedDrawable", "", "change", "", "setChangeAlphaWhenDisable", "enabled", "setEnabled", "checked", "setCheckedWithoutFeedback", "setChecked", "setCheckedNoAnim", "getTargetCheckedState", "()Z", "targetCheckedState", "", "getThumbPosition", "()F", "thumbPosition", "", "getTouchMode", "()I", "touchMode", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OSwitch extends SwitchCompat {
    public final int Q;
    public final int R;
    public boolean S;

    public static final class a {
    }

    static {
    }

    public OSwitch(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OSwitch(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final Drawable getCheckedDrawable() {
        if (this.R != 0) goto L5;
        Drawable r100 = ContextCompat.getDrawable(getContext(), R.drawable.o_switch_track_checked);
        Intrinsics.checkNotNull(r100);
        return r100.mutate();
    L5:
        Drawable r101 = ContextCompat.getDrawable(getContext(), this.R);
        Intrinsics.checkNotNull(r101);
        return r101.mutate();
    }

    private final float getThumbPosition() {
        Field r100 = SwitchCompat.class.getDeclaredField("w");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        r100.setAccessible(true);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        Object r101 = r100.get(this);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        if (r101 == null) goto L6;
        return ((Float) r101).floatValue();
    L6:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
    L7:
        e = move-exception;
        e.printStackTrace();
    L11:
        return 0.0f;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    private final int getTouchMode() {
        Field r100 = SwitchCompat.class.getDeclaredField("q");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        r100.setAccessible(true);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        Object r101 = r100.get(this);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        if (r101 == null) goto L6;
        return ((Integer) r101).intValue();
    L6:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
    L7:
        e = move-exception;
        e.printStackTrace();
    L11:
        return 0;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    private final Drawable getUncheckedDrawable() {
        if (this.Q != 0) goto L5;
        Drawable r100 = ContextCompat.getDrawable(getContext(), R.drawable.o_switch_track_unchecked);
        Intrinsics.checkNotNull(r100);
        return r100.mutate();
    L5:
        Drawable r101 = ContextCompat.getDrawable(getContext(), this.Q);
        Intrinsics.checkNotNull(r101);
        return r101.mutate();
    }

    public final void d() {
        if (this.S == true) goto L5;
        Drawable r100 = getTrackDrawable();
        if (r100 == null) goto L36;
        r100.setAlpha(255);
    L36:
        Drawable r101 = getThumbDrawable();
        if (r101 == null) goto L47;
        r101.setAlpha(255);
        return;
    L47:
        return;
    L5:
        if (isEnabled() == false) goto L15;
        Drawable r102 = getTrackDrawable();
        if (r102 == null) goto L10;
        r102.setAlpha(255);
    L10:
        Drawable r103 = getThumbDrawable();
        if (r103 == null) goto L44;
        r103.setAlpha(255);
        return;
    L44:
        return;
    L15:
        if (isChecked() == false) goto L24;
        Drawable r104 = getTrackDrawable();
        if (r104 == null) goto L20;
        r104.setAlpha(76);
    L20:
        Drawable r105 = getThumbDrawable();
        if (r105 == null) goto L45;
        r105.setAlpha(127);
        return;
    L45:
        return;
    L24:
        Drawable r106 = getTrackDrawable();
        if (r106 == null) goto L28;
        r106.setAlpha(76);
    L28:
        Drawable r107 = getThumbDrawable();
        if (r107 == null) goto L46;
        r107.setAlpha(255);
        return;
    }

    private final boolean getTargetCheckedState() {
        if (getThumbPosition() <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        measure(0, 0);     // Catch: Exception -> L22
        int r100 = getMeasuredWidth();     // Catch: Exception -> L22
        int r101 = getMeasuredHeight();     // Catch: Exception -> L22
        if (r100 <= 0) goto L27;
        if (r101 <= 0) goto L28;
        int r102 = r100 + d.n(this, 20);     // Catch: Exception -> L22
        int r103 = r101 + d.n(this, 20);     // Catch: Exception -> L22
        int r104 = c.f556351a;     // Catch: Exception -> L22
        ViewParent r105 = getParent();     // Catch: Exception -> L22
        if (r105 != null) goto L11;
    L13:
        r105 = null;
    L14:
        ViewGroup r106 = (ViewGroup) r105;     // Catch: Exception -> L22
        if (r106 == null) goto L20;
        r106.measure(0, 0);     // Catch: Exception -> L22
        int r107 = r106.getMeasuredWidth();     // Catch: Exception -> L22
        if (r103 > r106.getMeasuredHeight()) goto L19;
        if (r102 <= r107) goto L20;
    L19:
        j.b(r106, r102, r103, false);     // Catch: Exception -> L22
    L20:
        j.b(this, r102, r103, false);     // Catch: Exception -> L22
        return;
    L11:
        if ((r105 instanceof ViewGroup) == false) goto L13;
    L28:
        return;
    L27:
        return;
    L22:
        e = move-exception;
        b.c("OSwitch", "increaseTouchArea, error", e);
    }

    public final void c(boolean r100) {
        Drawable r101 = getTrackDrawable();
        if ((r101 instanceof TransitionDrawable) == false) goto L12;
        if (r100 == false) goto L10;
        TransitionDrawable r102 = (TransitionDrawable) r101;
        Method r103 = TransitionDrawable.class.getDeclaredMethod("showSecondLayer", new Class[0]);     // Catch: Exception -> L8
        r103.setAccessible(true);     // Catch: Exception -> L8
        r103.invoke(r102, new Object[0]);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        b.c("OSwitch", "reflectShowSecondLayer, error", e);
        Unit r104 = Unit.INSTANCE;
        return;
    L10:
        ((TransitionDrawable) r101).resetTransition();
        return;
    L12:
        if ((r101 instanceof fma.a) == false) goto L21;
        if (r100 == false) goto L15;
        fma.a r105 = (fma.a) r101;
        r105.f477885h = 255;
        r105.f477880c = 0;
        r105.invalidateSelf();
        return;
    L15:
        fma.a r106 = (fma.a) r101;
        r106.f477885h = 0;
        r106.f477880c = 0;
        r106.invalidateSelf();
        return;
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (r100.getAction() == 3) goto L7;
        if (r100.getAction() == 1) goto L7;
    L30:
        return super.onTouchEvent(r100);
    L7:
        if (getTouchMode() != 2) goto L30;
        Field r101 = SwitchCompat.class.getDeclaredField("q");     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
        r101.setAccessible(true);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
        r101.set(this, 0);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
    L16:
        if (r100.getAction() == 1) goto L18;
    L20:
        boolean r102 = false;
    L21:
        boolean r103 = isChecked();
        if (r102 == false) goto L24;
        boolean r104 = getTargetCheckedState();
    L25:
        if (r104 == r103) goto L27;
        playSoundEffect(0);
    L27:
        setChecked(r104);
        MotionEvent r105 = MotionEvent.obtain(r100);
        r105.setAction(3);
        super.onTouchEvent(r105);
        r105.recycle();
        super.onTouchEvent(r100);
        return true;
    L24:
        r104 = r103;
        goto L25
    L18:
        if (isEnabled() == false) goto L20;
        r102 = true;
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public final void setChangeAlphaWhenDisable(boolean r100) {
        if (this.S == r100) goto L6;
        this.S = r100;
        d();
        return;
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r110) {
        boolean r100 = isChecked();
        super.setChecked(r110);
        boolean r111 = isChecked();
        d();
        if (getWindowToken() == null) goto L37;
        int r101 = 0;
        if (getWidth() > 0) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L37;
        if (r100 == r111) goto L39;
        Drawable r103 = getTrackDrawable();
        if ((r103 instanceof TransitionDrawable) == false) goto L18;
        if (r111 == false) goto L16;
        ((TransitionDrawable) r103).startTransition(260);
        return;
    L16:
        ((TransitionDrawable) r103).reverseTransition(100);
        return;
    L18:
        if ((r103 instanceof fma.a) == true) goto L20;
        return;
    L20:
        if (r111 == false) goto L22;
        fma.a r104 = (fma.a) r103;
        r104.f477883f = 0;
        r104.f477884g = 255;
        r104.f477885h = 0;
        r104.f477882e = 260;
        r104.f477886i = false;
        r104.f477880c = 1;
        r104.invalidateSelf();
        return;
    L22:
        fma.a r105 = (fma.a) r103;
        r105.getClass();
        long r106 = SystemClock.uptimeMillis();
        if (r105.f477880c != 2) goto L36;
        long r107 = r106 - r105.f477881d;
        int r112 = r105.f477882e;
        if (r107 > r112) goto L36;
        boolean r108 = !r105.f477886i;
        r105.f477886i = r108;
        r105.f477883f = r105.f477885h;
        if (r108 == true) goto L31;
        r101 = 255;
    L31:
        r105.f477884g = r101;
        if (r108 == false) goto L34;
        int r113 = (int) r107;
    L35:
        r105.f477882e = r113;
        r105.f477880c = 1;
        r105.invalidateSelf();
        return;
    L34:
        r113 = r112 - ((int) r107);
    L36:
        r105.f477883f = 255;
        r105.f477884g = 0;
        r105.f477885h = 255;
        r105.f477882e = 100;
        r105.f477886i = true;
        r105.f477880c = 1;
        r105.invalidateSelf();
        return;
    L39:
        return;
    L7:
        if (getHeight() <= 0) goto L9;
        r102 = true;
    L37:
        c(r111);
    }

    @Override // com.obric.oui.oswitch.SwitchCompat
    public void setCheckedNoAnim(boolean r100) {
        super.setCheckedNoAnim(r100);
        c(r100);
    }

    @Deprecated(message = "use setHapticFeedbackEnabled instead")
    public final void setCheckedWithoutFeedback(boolean r100) {
        if (r100 != isChecked()) goto L5;
    L18:
        super.setChecked(r100);
        return;
    L5:
        if ((getTrackDrawable() instanceof TransitionDrawable) == false) goto L18;
        if (r100 == false) goto L13;
        Drawable r101 = getTrackDrawable();
        if (r101 == null) goto L12;
        ((TransitionDrawable) r101).startTransition(180);
        goto L18
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L13:
        Drawable r102 = getTrackDrawable();
        if (r102 == null) goto L17;
        ((TransitionDrawable) r102).reverseTransition(180);
        goto L18
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        d();
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public OSwitch(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.S = true;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.oui_disabledAlpha, R.attr.oui_isAlwaysDark, R.attr.oui_isAlwaysLight, R.attr.oui_trackChecked, R.attr.oui_trackUnchecked}, r102, 0);
        this.Q = r103.getResourceId(4, 0);
        this.R = r103.getResourceId(3, 0);
        this.S = r103.getBoolean(0, true);
        r103.recycle();
        if (getThumbDrawable() != null) goto L6;
        setThumbDrawable(ContextCompat.getDrawable(r100, R.drawable.o_switch_thumb));
    L6:
        if (getTrackDrawable() != null) goto L12;
        boolean r104 = isChecked();
        fma.a r105 = new fma.a(getUncheckedDrawable(), getCheckedDrawable());
        if (r104 == false) goto L10;
        r105.f477883f = 0;
        r105.f477884g = 255;
        r105.f477885h = 0;
        r105.f477882e = 0;
        r105.f477886i = false;
        r105.f477880c = 1;
        r105.invalidateSelf();
    L11:
        setTrackDrawable(r105);
        goto L12
    L10:
        r105.f477885h = 0;
        r105.f477880c = 0;
        r105.invalidateSelf();
    L12:
        setEnabled(isEnabled());
    }

    public /* synthetic */ OSwitch(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        int r104 = R.attr.OUISwitchStyle;
    L9:
        this(r100, r101, r104);
        return;
    L8:
        r104 = 0;
        goto L9
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
