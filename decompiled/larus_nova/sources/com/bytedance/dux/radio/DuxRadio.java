package com.bytedance.dux.radio;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.dux.api.DuxComponent;
import com.bytedance.dux.largefont.DuxLargeFontHelper;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import em4.n;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0017\u0018J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0017\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0006J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002R\"\u0010\u0003\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u000f\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/dux/radio/DuxRadio;", "Landroidx/appcompat/widget/AppCompatRadioButton;", "", "adaptLargeFont", "", "setAdaptLargeFontInternal", "(Ljava/lang/Boolean;)V", "Landroid/graphics/drawable/Drawable;", "getCheckDrawableNew", "getRoundDrawableNew", "checked", "setChecked", "", "style", "setStyle", "setAdaptLargeFont", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "setLimitLargeFontScale", "f", "Z", "getAdaptLargeFont", "()Z", "(Z)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "dux_release"}, k = 1, mv = {1, 7, 1})
public class DuxRadio extends AppCompatRadioButton {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final DuxComponent f205543g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f205544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f205545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f205546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f205547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f205548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f205549f;

    public static final class a {
    }

    public final class b extends StateListDrawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxRadio f205550a;

        @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
        public final int getIntrinsicHeight() {
            if (this.f205550a.getAdaptLargeFont() == false) goto L8;
            if (this.f205550a.f205545b == false) goto L8;
            return MathKt.roundToInt(TypedValue.applyDimension(1, 20 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), a(Resources.getSystem())));
        L8:
            if (this.f205550a.getAdaptLargeFont() == false) goto L13;
            if (this.f205550a.f205545b == true) goto L13;
            return MathKt.roundToInt(TypedValue.applyDimension(2, 20, a(Resources.getSystem())));
        L13:
            return MathKt.roundToInt(TypedValue.applyDimension(1, 20, a(Resources.getSystem())));
        }

        @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
        public final int getIntrinsicWidth() {
            if (this.f205550a.getAdaptLargeFont() == false) goto L8;
            if (this.f205550a.f205545b == false) goto L8;
            return MathKt.roundToInt(TypedValue.applyDimension(1, 20 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), a(Resources.getSystem())));
        L8:
            if (this.f205550a.getAdaptLargeFont() == false) goto L13;
            if (this.f205550a.f205545b == true) goto L13;
            return MathKt.roundToInt(TypedValue.applyDimension(2, 20, a(Resources.getSystem())));
        L13:
            return MathKt.roundToInt(TypedValue.applyDimension(1, 20, a(Resources.getSystem())));
        }

        public b(DuxRadio r100) {
            this.f205550a = r100;
        }

        public static DisplayMetrics a(Resources r100) {
            return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
        }

        public final Drawable b(Integer r100) {
            if (r100 == null) goto L4;
            DuxRadio r101 = this.f205550a;
            r100.intValue();
            return AppCompatResources.getDrawable(r101.getContext(), r100.intValue());
        L4:
            return null;
        }

        public final void c(Integer r100, Integer r101, Integer r102, Integer r110) {
            if (r102 == null) goto L6;
            if (r110 == null) goto L6;
            addState(new int[]{R.attr.state_checked, R.attr.state_enabled}, b(r100));
            addState(new int[]{R.attr.state_checked, -16842910}, b(r101));
            addState(new int[]{-16842912, R.attr.state_enabled}, b(r102));
            addState(new int[]{-16842912, -16842910}, b(r110));
            return;
        L6:
            addState(new int[]{R.attr.state_enabled}, b(r100));
            addState(new int[]{-16842910}, b(r101));
        }
    }

    public DuxRadio(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 62);
    }

    public DuxRadio(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 60);
    }

    public DuxRadio(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 56);
    }

    static {
        f205543g = DuxComponent.RADIO;
    }

    private final Drawable getCheckDrawableNew() {
        b r100 = new b(this);
        r100.c(Integer.valueOf(com.larus.nova.R.drawable.dux_ic_radio_tick_checked_new), Integer.valueOf(com.larus.nova.R.drawable.dux_ic_radio_tick_checked_disabled_new), null, null);
        return r100;
    }

    private final Drawable getRoundDrawableNew() {
        b r100 = new b(this);
        boolean r101 = this.f205546c;
        Integer r102 = Integer.valueOf(com.larus.nova.R.drawable.dux_radio_checked_enabled);
        if (r101 == false) goto L5;
        r100.c(r102, Integer.valueOf(com.larus.nova.R.drawable.dux_radio_checked_disabled_light), Integer.valueOf(com.larus.nova.R.drawable.dux_ic_radio_round_unchecked_normal_always_light), Integer.valueOf(com.larus.nova.R.drawable.dux_ic_radio_round_unchecked_disabled_always_light));
    L6:
        return r100;
    L5:
        r100.c(r102, Integer.valueOf(com.larus.nova.R.drawable.dux_radio_checked_disabled), Integer.valueOf(com.larus.nova.R.drawable.dux_ic_radio_round_unchecked_normal), Integer.valueOf(com.larus.nova.R.drawable.dux_ic_radio_round_unchecked_disabled));
        goto L6
    }

    public final void a() {
        if (this.f205544a == false) goto L6;
        return;
    L6:
        if (this.f205548e != 1) goto L13;
        if (this.f205549f == false) goto L10;
        Drawable r100 = getCheckDrawableNew();
    L11:
        setButtonDrawable(r100);
    L21:
        setChecked(isChecked());
        return;
    L10:
        r100 = AppCompatResources.getDrawable(getContext(), com.larus.nova.R.drawable.dux_radio_check);
        goto L11
    L13:
        if (this.f205549f == false) goto L15;
        Drawable r101 = getRoundDrawableNew();
    L20:
        setButtonDrawable(r101);
        goto L21
    L15:
        Context r102 = getContext();
        if (this.f205546c == false) goto L18;
        int r103 = com.larus.nova.R.drawable.dux_radio_round_always_light;
    L19:
        r101 = AppCompatResources.getDrawable(r102, r103);
        goto L20
    L18:
        r103 = com.larus.nova.R.drawable.dux_radio_round;
        goto L19
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f205544a == false) goto L6;
        return;
    L6:
        if (this.f205547d == false) goto L9;
        Resources r100 = Resources.getSystem();
        n.a(this, MathKt.roundToInt(TypedValue.applyDimension(1, 44, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()))));
        return;
    }

    public final boolean getAdaptLargeFont() {
        return this.f205549f;
    }

    private final void setAdaptLargeFontInternal(Boolean r100) {
        Lazy r101 = DuxLargeFontHelper.f205243a;
        this.f205549f = DuxLargeFontHelper.a(f205543g, r100);
    }

    public final void setAdaptLargeFont(Boolean r100) {
        setAdaptLargeFontInternal(r100);
        a();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r100) {
        super.setChecked(r100);
        if (this.f205544a == false) goto L6;
        return;
    L6:
        if (this.f205548e != 1) goto L12;
        if (r100 == false) goto L9;
        int r101 = 0;
    L10:
        setVisibility(r101);
        return;
    L9:
        r101 = 4;
        goto L10
    }

    public final void setLimitLargeFontScale(boolean r100) {
        this.f205545b = r100;
        a();
    }

    public final void setStyle(int r100) {
        if (this.f205544a == false) goto L5;
        return;
    L5:
        this.f205548e = r100;
        a();
    }

    public final void setAdaptLargeFont(boolean r100) {
        this.f205549f = r100;
    }

    @Override // android.widget.TextView
    @Deprecated(message = "Use DuxTextView individually", replaceWith = @ReplaceWith(expression = "DuxTextView", imports = {}))
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        super.setText(r100, r101);
    }

    public DuxRadio(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f205544a = false;
        this.f205545b = false;
        this.f205547d = true;
        Lazy r104 = DuxLargeFontHelper.f205243a;
        this.f205549f = DuxLargeFontHelper.a(f205543g, null);
        if (r101 == null) goto L18;
        TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{com.larus.nova.R.attr.adaptLargeFontMode, com.larus.nova.R.attr.adapt_for_csr, com.larus.nova.R.attr.dux_radioAlwaysLight, com.larus.nova.R.attr.fitOld, com.larus.nova.R.attr.limitLargeFontScale, com.larus.nova.R.attr.radioStyle}, r102, 0);
        this.f205544a = r105.getBoolean(3, false);
        this.f205548e = r105.getInt(5, 0);
        this.f205547d = r105.getBoolean(1, true);
        this.f205546c = r105.getBoolean(2, false);
        if (r105.hasValue(0) == false) goto L14;
        setAdaptLargeFontInternal(Boolean.valueOf(r105.getBoolean(0, false)));
    L14:
        if (r105.hasValue(4) == false) goto L16;
        this.f205545b = r105.getBoolean(4, this.f205545b);
    L16:
        r105.recycle();
    L18:
        if (this.f205544a == true) goto L20;
        a();
        return;
    L20:
        setClickable(true);
    }
}
