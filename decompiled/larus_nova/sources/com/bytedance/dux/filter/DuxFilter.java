package com.bytedance.dux.filter;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.dux.api.DuxComponent;
import com.bytedance.dux.largefont.DuxLargeFontHelper;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0017\u0018J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0016\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/dux/filter/DuxFilter;", "Lcom/bytedance/dux/filter/DrawableCenterButton;", "", "enabled", "", "setAdaptLargeFontInternal", "(Ljava/lang/Boolean;)V", "selected", "setSelected", "", "getStyle", "isAlwaysLight", "setAlwaysLight", "getIsAlwaysLight", "setEnabled", "Lcom/bytedance/dux/filter/DuxFilter$b;", "listener", "setSelectChangeListener", "setAdaptLargeFont", "", "getFontScale", "()F", "fontScale", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "dux_release"}, k = 1, mv = {1, 7, 1})
public class DuxFilter extends DrawableCenterButton {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final DuxComponent f205051m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f205052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f205053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f205054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f205055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f205056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f205057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f205058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f205059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f205060i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f205061j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f205062k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f205063l;

    public static final class a {
    }

    public interface b {
        void a(DuxFilter r100, boolean r101);
    }

    public DuxFilter(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, false, false, 62);
    }

    public DuxFilter(Context r100, AttributeSet r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r110, 0, false, false, 60);
    }

    public DuxFilter(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r110, r111, false, false, 56);
    }

    static {
        f205051m = DuxComponent.FILTER;
    }

    private final float getFontScale() {
        boolean r100 = this.f205063l;
        if (r100 == true) goto L5;
    L7:
        if (r100 == true) goto L9;
    L11:
        return 1.0f;
    L9:
        if (this.f205052a == true) goto L11;
        return getContext().getResources().getConfiguration().fontScale;
    L5:
        if (this.f205052a == false) goto L7;
        return RangesKt.coerceAtMost(getContext().getResources().getConfiguration().fontScale, 1.15f);
    }

    public final void b() {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        int r100 = this.f205057f;
        if (r100 == 1) goto L10;
        if (r100 == 2) goto L10;
        int r101 = -1;
    L11:
        setMinHeight(r101);
        boolean r102 = isSelected();
        int r103 = R.color.Transparent;
        int r104 = R.color.TextReverse;
        if (r102 == false) goto L47;
        int r105 = this.f205057f;
        if (r105 == 1) goto L39;
        r103 = R.color.BGInput;
        if (r105 == 2) goto L28;
        boolean r106 = this.f205060i;
        if (r106 == false) goto L20;
        int r107 = R.color.BGInputReverse;
    L21:
        if (r106 == true) goto L24;
        r104 = R.color.TextPrimary;
    L24:
        this.f205061j = r104;
        if (r106 == false) goto L27;
        r103 = R.color.BGInputReverse;
    L27:
        setTypeface(null, 1);
    L77:
        GradientDrawable r108 = new GradientDrawable();
        r108.setShape(0);
        if (this.f205057f != 0) goto L80;
        float r109 = 4;
        DisplayMetrics r110 = a(Resources.getSystem());
    L81:
        r108.setCornerRadius(MathKt.roundToInt(TypedValue.applyDimension(1, r109, r110)));
        int r111 = this.f205057f;
        if (r111 == 1) goto L86;
        if (r111 == 2) goto L85;
    L87:
        r108.setColor(ContextCompat.getColor(getContext(), r103));
        setBackground(r108);
        setTextColor(ContextCompat.getColor(getContext(), this.f205061j));
        if (this.f205059h == true) goto L90;
        setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        int r112 = this.f205053b;
        int r113 = this.f205054c;
        setPadding(r112, r113, r112, r113);
        setGravity(17);
        return;
    L90:
        if (this.f205058g != null) goto L96;
        Drawable r114 = ContextCompat.getDrawable(getContext(), R.drawable.dux_arrow_forward_filter);
        if (r114 == null) goto L94;
        Drawable r115 = r114.mutate();
    L95:
        this.f205058g = r115;
        goto L96
    L94:
        r115 = null;
    L96:
        Drawable r116 = this.f205058g;
        Intrinsics.checkNotNull(r116);
        Drawable r117 = DrawableCompat.wrap(r116);
        DrawableCompat.setTintMode(r117, PorterDuff.Mode.SRC_IN);
        DrawableCompat.setTint(r117, ContextCompat.getColor(getContext(), this.f205061j));
        r117.setBounds(0, 0, (int) (r117.getIntrinsicWidth() * getFontScale()), (int) (r117.getIntrinsicHeight() * getFontScale()));
        setGravity(8388629);
        setCompoundDrawables(null, null, r117, null);
        int r118 = this.f205055d;
        int r119 = this.f205056e;
        setPadding(r118, r119, r118, r119);
        return;
    L85:
        if (isSelected() == true) goto L87;
    L86:
        r108.setStroke(MathKt.roundToInt(TypedValue.applyDimension(1, (float) 0.5d, a(Resources.getSystem()))), ContextCompat.getColor(getContext(), r107));
        goto L87
    L80:
        r109 = 8;
        r110 = a(Resources.getSystem());
        goto L81
    L20:
        r107 = R.color.BGInput;
        goto L21
    L28:
        boolean r120 = this.f205060i;
        if (r120 == false) goto L31;
        r107 = R.color.BGInputReverse;
    L32:
        if (r120 == true) goto L35;
        r104 = R.color.TextPrimary;
    L35:
        this.f205061j = r104;
        if (r120 == false) goto L38;
        r103 = R.color.BGInputReverse;
    L38:
        setTypeface(null, 1);
        goto L77
    L31:
        r107 = R.color.BGInput;
        goto L32
    L39:
        boolean r121 = this.f205060i;
        int r122 = R.color.Primary;
        if (r121 == false) goto L42;
        r107 = R.color.Primary;
    L43:
        if (r121 == true) goto L46;
        r122 = R.color.Secondary2;
    L46:
        this.f205061j = r122;
        setTypeface(null, 1);
        goto L77
    L42:
        r107 = R.color.Secondary2;
        goto L43
    L47:
        int r123 = this.f205057f;
        r107 = R.color.LineReverse;
        if (r123 == 1) goto L69;
        if (r123 == 2) goto L61;
        boolean r124 = this.f205060i;
        r103 = R.color.BGPlaceholderDefault;
        if (r124 == false) goto L53;
        r107 = R.color.BGInputReverse;
    L54:
        if (r124 == false) goto L56;
        int r125 = R.color.TextReverse3;
    L57:
        this.f205061j = r125;
        if (r124 == false) goto L60;
        r103 = R.color.BGInputReverse;
    L60:
        setTypeface(null, 0);
        goto L77
    L56:
        r125 = R.color.TextTertiary;
        goto L57
    L53:
        r107 = R.color.BGPlaceholderDefault;
        goto L54
    L61:
        boolean r126 = this.f205060i;
        if (r126 == true) goto L65;
        r107 = R.color.LinePrimary2;
    L65:
        if (r126 == true) goto L68;
        r104 = R.color.TextPrimary;
    L68:
        this.f205061j = r104;
        setTypeface(null, 0);
        goto L77
    L69:
        boolean r127 = this.f205060i;
        if (r127 == true) goto L73;
        r107 = R.color.LinePrimary2;
    L73:
        if (r127 == true) goto L76;
        r104 = R.color.TextPrimary;
    L76:
        this.f205061j = r104;
        setTypeface(null, 0);
    L10:
        r101 = MathKt.roundToInt(TypedValue.applyDimension(1, 36, a(Resources.getSystem())));
        goto L11
    }

    public final boolean getIsAlwaysLight() {
        return this.f205060i;
    }

    public final int getStyle() {
        return this.f205057f;
    }

    public static DisplayMetrics a(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private final void setAdaptLargeFontInternal(Boolean r100) {
        Lazy r101 = DuxLargeFontHelper.f205243a;
        this.f205063l = DuxLargeFontHelper.a(f205051m, r100);
    }

    public final void setAdaptLargeFont(Boolean r100) {
        setAdaptLargeFontInternal(r100);
        if (this.f205063l == false) goto L5;
        float r101 = 12;
        DisplayMetrics r102 = a(Resources.getSystem());
    L6:
        int r103 = MathKt.roundToInt(TypedValue.applyDimension(1, r101, r102));
        int r104 = MathKt.roundToInt(TypedValue.applyDimension(1, 7, a(Resources.getSystem())));
        this.f205055d = r103;
        this.f205056e = r104;
        b();
        return;
    L5:
        r101 = 16;
        r102 = a(Resources.getSystem());
        goto L6
    }

    public final void setAlwaysLight(boolean r100) {
        this.f205060i = r100;
        b();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        if (r100 == false) goto L5;
        setAlpha(1.0f);
        b();
        return;
    L5:
        setAlpha(0.5f);
    }

    public final void setSelectChangeListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f205062k = r100;
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        b();
        b r101 = this.f205062k;
        if (r101 == null) goto L6;
        r101.a(this, r100);
        return;
    }

    public DuxFilter(Context r100, AttributeSet r101, int r110, boolean r111, boolean r112, int r113) {
        if ((r113 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r113 & 4) == 0) goto L9;
        r110 = 0;
    L9:
        if ((r113 & 8) == 0) goto L12;
        r111 = false;
    L12:
        if ((r113 & 32) == 0) goto L14;
        r112 = false;
    L14:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        this.f205052a = r112;
        float r114 = 12;
        this.f205053b = MathKt.roundToInt(TypedValue.applyDimension(1, r114, a(Resources.getSystem())));
        this.f205054c = MathKt.roundToInt(TypedValue.applyDimension(1, 5, a(Resources.getSystem())));
        float r102 = 16;
        this.f205055d = MathKt.roundToInt(TypedValue.applyDimension(1, r102, a(Resources.getSystem())));
        float r103 = 7;
        this.f205056e = MathKt.roundToInt(TypedValue.applyDimension(1, r103, a(Resources.getSystem())));
        Lazy r104 = DuxLargeFontHelper.f205243a;
        this.f205063l = DuxLargeFontHelper.a(f205051m, null);
        TypedArray r105 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.adaptLargeFontMode, R.attr.filterStyle, R.attr.isAlwaysLight, R.attr.limitLargeFontScale, R.attr.showIcon}, r110, 0);
        this.f205057f = r105.getInt(1, 0);     // Catch: Throwable -> L29
        this.f205059h = r105.getBoolean(4, false);     // Catch: Throwable -> L29
        this.f205060i = r105.getBoolean(2, r111);     // Catch: Throwable -> L29
        if (r105.hasValue(0) == false) goto L18;
        setAdaptLargeFontInternal(Boolean.valueOf(r105.getBoolean(0, false)));     // Catch: Throwable -> L29
    L18:
        boolean r115 = r105.getBoolean(3, r112);     // Catch: Throwable -> L29
        this.f205052a = r115;     // Catch: Throwable -> L29
        r105.recycle();
        setSingleLine();
        setTextSize(0, r100.getResources().getDimension(R.dimen.dux_filter_text_size));
        setCompoundDrawablePadding(r100.getResources().getDimensionPixelSize(R.dimen.dux_filter_drawable_padding));
        if (this.f205063l == false) goto L22;
        float r106 = TypedValue.applyDimension(1, r114, a(Resources.getSystem()));
    L23:
        int r107 = MathKt.roundToInt(r106);
        int r108 = MathKt.roundToInt(TypedValue.applyDimension(1, r103, a(Resources.getSystem())));
        this.f205055d = r107;
        this.f205056e = r108;
        setGravity(17);
        if (r115 == false) goto L27;
        com.bytedance.dux.largefont.a.c(this, 13.0f);
    L27:
        b();
        return;
    L22:
        r106 = TypedValue.applyDimension(1, r102, a(Resources.getSystem()));
    L29:
        th = move-exception;
        r105.recycle();
        throw th;
    }
}
