package com.obric.oui.filter;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.larus.nova.R;
import com.obric.oui.common.style.r;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/filter/OFilter;", "Lcom/obric/oui/filter/DrawableCenterButton;", "", "selected", "", "setSelected", "", "getStyle", "isAlwaysLight", "setAlwaysLight", "getIsAlwaysLight", "enabled", "setEnabled", "Lcom/obric/oui/filter/OFilter$b;", "listener", "setSelectChangeListener", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OFilter extends DrawableCenterButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f400814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f400815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f400816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f400817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f400818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f400819f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f400820g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f400821h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f400822i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f400823j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f400824k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Paint f400825l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint f400826m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RectF f400827n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RectF f400828o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f400829p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f400830q;

    public static final class a {
    }

    public interface b {
        void a(OFilter r100, boolean r101);
    }

    static {
    }

    public OFilter(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, false, 14);
    }

    public OFilter(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, false, 12);
    }

    public OFilter(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r110, false, 8);
    }

    public final void a() {
        if (isEnabled() == true) goto L6;
        return;
    L6:
        if (this.f400818e != 1) goto L8;
        setMinHeight(d.n(this, 36));
    L9:
        boolean r100 = isSelected();
        int r101 = R.color.Transparent;
        if (r100 == false) goto L19;
        boolean r102 = this.f400821h;
        int r103 = R.color.primary;
        if (r102 == false) goto L15;
        this.f400822i = R.color.primary;
        setTypeface(null, 1);
        r101 = R.color.BGBrand;
    L25:
        this.f400825l.setColor(ContextCompat.getColor(getContext(), r101));
        this.f400826m.setColor(ContextCompat.getColor(getContext(), r103));
        setTextColor(ContextCompat.getColor(getContext(), this.f400822i));
        if (this.f400820g == true) goto L28;
        setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        int r104 = this.f400814a;
        int r105 = this.f400815b;
        setPadding(r104, r105, r104, r105);
        setGravity(17);
        return;
    L28:
        if (this.f400819f != null) goto L34;
        Drawable r106 = ContextCompat.getDrawable(getContext(), R.drawable.o_arrow_forward_filter);
        if (r106 != null) goto L32;
        Drawable r107 = null;
    L33:
        this.f400819f = r107;
        goto L34
    L32:
        r107 = r106.mutate();
    L34:
        Drawable r108 = this.f400819f;
        Intrinsics.checkNotNull(r108);
        Drawable r109 = DrawableCompat.wrap(r108);
        DrawableCompat.setTintMode(r109, PorterDuff.Mode.SRC_IN);
        DrawableCompat.setTint(r109, ContextCompat.getColor(getContext(), this.f400822i));
        r109.setBounds(0, 0, r109.getIntrinsicWidth(), r109.getIntrinsicHeight());
        setGravity(8388629);
        setCompoundDrawablesWithIntrinsicBounds(null, null, r109, null);
        int r110 = this.f400816c;
        int r111 = this.f400817d;
        setPadding(r110, r111, r110, r111);
        return;
    L15:
        if (this.f400818e != 1) goto L17;
        this.f400822i = R.color.primary;
        setTypeface(null, 1);
        goto L25
    L17:
        this.f400822i = R.color.TextPrimary;
        setTypeface(null, 1);
        r101 = R.color.BGInput;
        r103 = R.color.BGInput;
        goto L25
    L19:
        if (this.f400821h == false) goto L21;
        this.f400822i = R.color.TextReverse;
        setTypeface(null, 0);
        r103 = R.color.LineReverse2;
        goto L25
    L21:
        int r112 = this.f400818e;
        r103 = R.color.oui_basic_text_2;
        if (r112 != 1) goto L24;
        this.f400822i = R.color.oui_basic_text_2;
        setTypeface(null, 0);
        goto L25
    L24:
        this.f400822i = R.color.oui_basic_text_2;
        setTypeface(null, 0);
        r101 = R.color.oui_basic_text_4;
        goto L25
    L8:
        setMinHeight(-1);
        goto L9
    }

    public final boolean getIsAlwaysLight() {
        return this.f400821h;
    }

    public final int getStyle() {
        return this.f400818e;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.f400829p = d.n(this, 4);
        this.f400830q = d.n(this, 8);
        invalidate();
    }

    @Override // com.obric.oui.filter.DrawableCenterButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.save();
        r100.translate(getScrollX() * 1.0f, getScrollY() * 1.0f);
        if (this.f400818e != 0) goto L5;
        float r101 = this.f400829p;
    L6:
        this.f400827n.set(0.0f, 0.0f, getWidth(), getHeight());
        r.e(r100, this.f400827n, r101, this.f400825l);
        if (this.f400818e != 1) goto L9;
        float r102 = this.f400824k * 0.5f;
        this.f400828o.set(r102, r102, getWidth() - r102, getHeight() - r102);
        r.e(r100, this.f400828o, r101, this.f400826m);
    L9:
        r100.restore();
        super.onDraw(r100);
        return;
    L5:
        r101 = this.f400830q;
        goto L6
    }

    public final void setAlwaysLight(boolean r100) {
        this.f400821h = r100;
        a();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        if (r100 == false) goto L5;
        setAlpha(1.0f);
        a();
        return;
    L5:
        setAlpha(0.5f);
    }

    public final void setSelectChangeListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f400823j = r100;
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        a();
        b r101 = this.f400823j;
        if (r101 == null) goto L7;
        r101.a(this, r100);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public OFilter(Context r100, AttributeSet r101, int r102, boolean r103, int r110) {
        if ((r110 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r110 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r110 & 8) == 0) goto L11;
        r103 = false;
    L11:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f400814a = d.n(this, 12);
        this.f400815b = d.n(this, 5);
        this.f400816c = d.n(this, 16);
        this.f400817d = d.n(this, 7);
        float r111 = d.l(this, 0.5d);
        this.f400824k = r111;
        Paint r104 = new Paint(1);
        r104.setStyle(Paint.Style.FILL);
        this.f400825l = r104;
        Paint r105 = new Paint(1);
        r105.setStyle(Paint.Style.STROKE);
        r105.setStrokeWidth(r111);
        this.f400826m = r105;
        this.f400827n = new RectF();
        this.f400828o = new RectF();
        this.f400829p = d.n(this, 4);
        this.f400830q = d.n(this, 8);
        TypedArray r106 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.oui_filterStyle, R.attr.oui_isAlwaysLight, R.attr.showIcon}, r102, 0);
        this.f400818e = r106.getInt(0, 0);     // Catch: Throwable -> L15
        this.f400820g = r106.getBoolean(2, false);     // Catch: Throwable -> L15
        this.f400821h = r106.getBoolean(1, r103);     // Catch: Throwable -> L15
        r106.recycle();
        setSingleLine();
        setTextSize(0, r100.getResources().getDimension(R.dimen.oui_filter_text_size));
        setCompoundDrawablePadding(r100.getResources().getDimensionPixelSize(R.dimen.oui_filter_drawable_padding));
        setGravity(17);
        a();
        return;
    L15:
        th = move-exception;
        r106.recycle();
        throw th;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
