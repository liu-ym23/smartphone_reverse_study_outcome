package com.obric.oui.oswitch;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import fma.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.d;
import pla.j;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/oswitch/OSwitchBak;", "Lcom/obric/oui/oswitch/SwitchCompat;", "", "checked", "", "setChecked", "setCheckedWithoutFeedback", "enabled", "setEnabled", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OSwitchBak extends SwitchCompat {
    public final boolean Q;

    public OSwitchBak(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OSwitchBak(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.Q == false) goto L6;
        j.a(this, d.n(this, 45));
        return;
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r100) {
        c(r100, true);
    }

    public final void setCheckedWithoutFeedback(boolean r100) {
        c(r100, false);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        if (r100 == false) goto L5;
        float r101 = 1.0f;
    L6:
        setAlpha(r101);
        return;
    L5:
        r101 = 0.5f;
        goto L6
    }

    public final void c(boolean r100, boolean r101) {
        if (r100 != isChecked()) goto L5;
    L20:
        super.setChecked(r100);
        return;
    L5:
        if ((getTrackDrawable() instanceof TransitionDrawable) == false) goto L20;
        if (r100 == false) goto L13;
        Drawable r102 = getTrackDrawable();
        if (r102 == null) goto L12;
        ((TransitionDrawable) r102).startTransition(180);
    L16:
        if (r101 == false) goto L20;
        performHapticFeedback(1, 2);
        goto L20
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L13:
        Drawable r103 = getTrackDrawable();
        if (r103 == null) goto L19;
        ((TransitionDrawable) r103).reverseTransition(180);
        goto L16
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    }

    public OSwitchBak(Context r210, AttributeSet r211, int r212) {
        super(r210, r211, r212);
        this.Q = true;
        if (r210 == null) goto L7;
        Resources.Theme r100 = r210.getTheme();
        if (r100 == null) goto L7;
        TypedArray r101 = r100.obtainStyledAttributes(r211, new int[]{R.attr.oui_disabledAlpha, R.attr.oui_isAlwaysDark, R.attr.oui_isAlwaysLight, R.attr.oui_trackChecked, R.attr.oui_trackUnchecked}, 0, 0);
    L10:
        if (r101 != null) goto L42;
        boolean r102 = false;
    L13:
        if (r101 != null) goto L15;
        boolean r103 = false;
    L16:
        if (r101 == null) goto L19;
        r101.recycle();
    L19:
        setLayerType(1, null);
        ShapeDrawable r104 = new ShapeDrawable(new b(r210));
        r104.setIntrinsicHeight(d.n(this, 21));
        r104.setIntrinsicWidth(d.n(this, 21));
        setThumbDrawable(r104);
        ShapeDrawable r105 = new ShapeDrawable();
        r105.setIntrinsicHeight(d.n(this, 24));
        r105.setIntrinsicWidth(d.n(this, 36));
        r105.setShape(new RoundRectShape(new float[]{d.o(this, 12.5d), d.o(this, 12.5d), d.o(this, 12.5d), d.o(this, 12.5d), d.o(this, 12.5d), d.o(this, 12.5d), d.o(this, 12.5d), d.o(this, 12.5d)}, new RectF(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}));
        if (r102 == false) goto L22;
        int r106 = R.color.LineReverse;
    L25:
        Intrinsics.checkNotNull(r210);
        DrawableCompat.setTint(r105, ContextCompat.getColor(r210, r106));
        ShapeDrawable r107 = new ShapeDrawable();
        r107.setIntrinsicHeight(d.n(this, 25));
        r107.setIntrinsicWidth(d.n(this, 43));
        r107.setShape(new RoundRectShape(new float[]{d.o(this, 12.5d), d.o(this, 12.5d), d.o(this, 12.5d), d.o(this, 12.5d), d.o(this, 12.5d), d.o(this, 12.5d), d.o(this, 12.5d), d.o(this, 12.5d)}, new RectF(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}));
        DrawableCompat.setTint(r107, ContextCompat.getColor(r210, R.color.blue_2761f2_100));
        TransitionDrawable r108 = new TransitionDrawable(new ShapeDrawable[]{r105, r107});
        r108.setCrossFadeEnabled(true);
        setTrackDrawable(r108);
        Drawable r109 = getTrackDrawable();
        if (r109 == null) goto L36;
        ((TransitionDrawable) r109).resetTransition();
        setThumbConstraintRight(d.n(this, 2));
        setThumbConstraintLeft(d.n(this, 2));
        if (isChecked() == false) goto L34;
        Drawable r110 = getTrackDrawable();
        if (r110 == null) goto L33;
        ((TransitionDrawable) r110).startTransition(180);
        return;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L34:
        return;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L22:
        if (r103 == false) goto L24;
        r106 = R.color.ConstLineInverse;
        goto L25
    L24:
        r106 = R.color.LinePrimary2;
        goto L25
    L15:
        r103 = r101.getBoolean(1, false);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        if (r101 == null) goto L41;
        r101.recycle();
    L41:
        throw th;
    L42:
        r102 = r101.getBoolean(2, false);     // Catch: Throwable -> L37
    L7:
        r101 = null;
        goto L10
    }

    public /* synthetic */ OSwitchBak(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
