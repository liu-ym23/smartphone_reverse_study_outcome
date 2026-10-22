package com.obric.oui.checkbox;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import pla.d;
import pla.j;
import vma.g;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0003()*B\u0011\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"B\u001b\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b!\u0010%B#\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010&\u001a\u00020\u0003¢\u0006\u0004\b!\u0010'J\u0010\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0003J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\tJ\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0014\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0013R0\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00038\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006+"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBox;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/widget/Checkable;", "", "styleRes", "", "setStyle", "color", "setPrimaryColor", "", "light", "setAlwaysLight", "enableExpand", "setEnableExpandTouchRect", "checked", "setChecked", "Lcom/obric/oui/checkbox/OCheckBox$b;", "listener", "setOnCheckedStateChangedListener", "Lcom/obric/oui/checkbox/OCheckBox$a;", "setOnCheckedChangeListener", "value", "d", "I", "getCheckedState", "()I", "setCheckedState", "(I)V", "getCheckedState$annotations", "()V", "checkedState", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OCheckBox extends AppCompatImageView implements Checkable {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f399381n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f399382o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f399383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f399384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f399385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f399386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f399387e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f399388f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorFilter f399389g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ColorFilter f399390h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f399391i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f399392j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f399393k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f399394l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f399395m;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBox$Companion$CheckedState;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface CheckedState {
        }
    }

    public interface a {
        void a(OCheckBox r100, boolean r101);
    }

    public interface b {
    }

    public static /* synthetic */ void getCheckedState$annotations() {
    }

    public final void setOnCheckedStateChangedListener(b r100) {
    }

    static {
        f399381n = new int[]{R.attr.state_checked};
        f399382o = new int[]{com.larus.nova.R.attr.oui_state_indeterminate};
    }

    public final void createColorFilter() {
        int r100 = this.f399393k;
        if (r100 == (-1)) goto L6;
        this.f399389g = new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, Color.red(r100), 0.0f, 1.0f, 0.0f, 0.0f, Color.green(r100), 0.0f, 0.0f, 1.0f, 0.0f, Color.blue(r100), 0.0f, 0.0f, 0.0f, (Color.alpha(r100) * 1.0f) / 255, 0.0f});
    L6:
        if (this.f399394l == (-1)) goto L9;
        this.f399390h = new PorterDuffColorFilter(this.f399394l, PorterDuff.Mode.SRC_IN);
        return;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        if (this.f399386d == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void syncDrawableStyle() {
        if (this.f399388f == false) goto L6;
        Drawable r100 = getResources().getDrawable(com.larus.nova.R.drawable.o_checkbox_circle_always_light, null);
    L12:
        int r101 = this.f399392j;
        if (r101 != (-1)) goto L15;
    L31:
        setImageDrawable(r100);
        return;
    L15:
        if ((r100 instanceof StateListDrawable) == false) goto L31;
        if (Build.VERSION.SDK_INT < 29) goto L31;
        int r102 = g.f556352a;
        StateListDrawable r103 = (StateListDrawable) r100;
        Intrinsics.checkNotNullParameter(r103, "drawable");
        Intrinsics.checkNotNullParameter("primary_shape", "pathName");
        int r104 = r103.getStateCount();
        int r105 = 0;
    L19:
        if (r105 >= r104) goto L31;
        int r106 = r105 + 1;
        Drawable r107 = r103.getStateDrawable(r105);
        if ((r107 instanceof VectorDrawable) == false) goto L27;
        VectorDrawable r108 = (VectorDrawable) r107;
        g.b(r108, r101);     // Catch: Exception -> L25
        r108.invalidateSelf();     // Catch: Exception -> L25
    L30:
        r105 = r106;
        goto L19
    L27:
        if ((r107 instanceof AnimatedVectorDrawable) == false) goto L30;
        AnimatedVectorDrawable r109 = (AnimatedVectorDrawable) r107;
        g.c(r109, r101);     // Catch: Exception -> L25
        r109.invalidateSelf();     // Catch: Exception -> L25
        goto L30
    L6:
        if (this.f399384b != 1) goto L8;
        r100 = getResources().getDrawable(com.larus.nova.R.drawable.o_checkbox_circle_on_image, null);
        goto L12
    L8:
        r100 = this.f399383a;
        if (r100 != null) goto L12;
        r100 = getResources().getDrawable(com.larus.nova.R.drawable.o_checkbox_circle, null);
        goto L12
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f399395m == false) goto L6;
        j.a(this, d.n(this, 44));
        return;
    }

    @Override // android.view.View
    public final boolean performClick() {
        toggle();
        boolean r100 = super.performClick();
        if (r100 == true) goto L6;
        playSoundEffect(0);
    L6:
        if (isChecked() == false) goto L8;
        bma.a.c(getContext(), 1);
    L8:
        return r100;
    }

    public final void syncButtonCheckState() {
        Drawable r100 = getDrawable();
        if (r100 == null) goto L6;
        r100.clearColorFilter();
    L6:
        createColorFilter();
        Drawable r101 = getDrawable();
        if (r101 != null) goto L10;
        return;
    L10:
        if (isChecked() == false) goto L12;
        ColorFilter r102 = this.f399389g;
    L13:
        r101.setColorFilter(r102);
        return;
    L12:
        r102 = this.f399390h;
        goto L13
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    public final int getCheckedState() {
        return this.f399386d;
    }

    public OCheckBox(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void j(TypedArray r100) {
        this.f399384b = r100.getInt(4, 0);
        this.f399392j = r100.getColor(5, -1);
        this.f399393k = r100.getColor(3, -1);
        this.f399394l = r100.getColor(6, -1);
        Drawable r101 = r100.getDrawable(2);
        if (r101 != null) goto L5;
        r101 = null;
    L5:
        this.f399383a = r101;
        this.f399388f = r100.getBoolean(1, false);
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int r100) {
        int[] r101 = super.onCreateDrawableState(r100 + 2);
        if (this.f399386d != 2) goto L6;
        ImageView.mergeDrawableStates(r101, f399382o);
    L6:
        if (isChecked() == false) goto L8;
        View.mergeDrawableStates(r101, f399381n);
    L8:
        return r101;
    }

    public final void setAlwaysLight(boolean r100) {
        this.f399388f = r100;
        syncDrawableStyle();
        invalidate();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r100) {
        setCheckedState(r100 ? 1 : 0);
    }

    public final void setCheckedState(int r100) {
        if (this.f399386d == r100) goto L15;
        this.f399386d = r100;
        syncButtonCheckState();
        refreshDrawableState();
        if (this.f399387e == false) goto L7;
        return;
    L7:
        this.f399387e = true;
        if (this.f399386d == 2) goto L13;
        a r101 = this.f399391i;
        if (r101 == null) goto L13;
        r101.a(this, isChecked());
    L13:
        this.f399387e = false;
        return;
    }

    public final void setEnableExpandTouchRect(boolean r100) {
        this.f399395m = r100;
    }

    public final void setOnCheckedChangeListener(a r100) {
        this.f399391i = r100;
    }

    public final void setPrimaryColor(int r100) {
        this.f399392j = r100;
        syncDrawableStyle();
        invalidate();
    }

    public final void setStyle(int r100) {
        TypedArray r101 = getContext().obtainStyledAttributes(null, new int[]{com.larus.nova.R.attr.oui_adapt_for_csr, com.larus.nova.R.attr.oui_checkBoxAlwaysLight, com.larus.nova.R.attr.oui_checkBoxButton, com.larus.nova.R.attr.oui_checkBoxCheckedColor, com.larus.nova.R.attr.oui_checkBoxColorStyle, com.larus.nova.R.attr.oui_checkBoxPrimaryColor, com.larus.nova.R.attr.oui_checkBoxUncheckedColor, com.larus.nova.R.attr.oui_checkedState, com.larus.nova.R.attr.oui_state_indeterminate}, 0, r100);
        j(r101);
        r101.recycle();
        createColorFilter();
        syncDrawableStyle();
        syncButtonCheckState();
        invalidate();
    }

    public OCheckBox(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, com.larus.nova.R.attr.OCheckBoxStyle);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.makeMeasureSpec(this.f399385c, 1073741824);
        super.onMeasure(r102, r102);
    }

    public OCheckBox(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f399385c = d.n(this, 18);
        this.f399392j = -1;
        this.f399393k = -1;
        this.f399394l = -1;
        this.f399395m = true;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{com.larus.nova.R.attr.oui_adapt_for_csr, com.larus.nova.R.attr.oui_checkBoxAlwaysLight, com.larus.nova.R.attr.oui_checkBoxButton, com.larus.nova.R.attr.oui_checkBoxCheckedColor, com.larus.nova.R.attr.oui_checkBoxColorStyle, com.larus.nova.R.attr.oui_checkBoxPrimaryColor, com.larus.nova.R.attr.oui_checkBoxUncheckedColor, com.larus.nova.R.attr.oui_checkedState, com.larus.nova.R.attr.oui_state_indeterminate}, r102, com.larus.nova.R.style.OStyleV2_OCheckBox_DayNight);
        j(r103);
        this.f399395m = r103.getBoolean(0, true);
        if (r103.hasValue(7) == false) goto L5;
        setCheckedState(r103.getInt(7, 0));
    L5:
        r103.recycle();
        createColorFilter();
        syncDrawableStyle();
        setBackground(null);
        syncButtonCheckState();
        setClickable(true);
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
