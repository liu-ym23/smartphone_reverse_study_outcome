package com.larksuite.component.ui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import j08.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 12\u00020\u00012\u00020\u0002:\u000212B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0014J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\u0018\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0012H\u0002J\b\u0010!\u001a\u00020\u0016H\u0014J\b\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\u0016H\u0016J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u000eH\u0016J\b\u0010&\u001a\u00020\u000eH\u0016J\u0006\u0010'\u001a\u00020\u000eJ\u000e\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u000eJ\u0010\u0010*\u001a\u00020\u00162\b\u0010+\u001a\u0004\u0018\u00010\u0014J\b\u0010,\u001a\u00020\u000bH\u0003J\b\u0010-\u001a\u00020\u000bH\u0003J\b\u0010.\u001a\u00020\u000bH\u0003J\u0012\u0010/\u001a\u00020\u00122\b\b\u0001\u00100\u001a\u00020\u000bH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/larksuite/component/ui/button/LKUICheckBox2;", "Landroid/view/View;", "Landroid/widget/Checkable;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mIsRadio", "", "mIsChecked", "mDrawableSize", "mCurrDrawable", "Landroid/graphics/drawable/Drawable;", "mOnCheckedChangeListener", "Lcom/larksuite/component/ui/button/LKUICheckBox2$OnCheckedChangeListener;", "init", "", "setupAttrs", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setupCurrDrawable", "doDrawCheckBox", "drawable", "drawableStateChanged", "isChecked", "toggle", "setChecked", "checked", "performClick", "isRadio", "setRadio", "value", "setOnCheckedChangeListener", "listener", "getCheckBoxDrawableRes", "getRadioButtonDrawableRes", "getDrawableRes", "getDrawable", "resId", "Companion", "OnCheckedChangeListener", "suite-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LKUICheckBox2 extends View implements Checkable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final SparseArray<Drawable> f284071f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f284072g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f284073h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f284074i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f284075j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f284076k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f284077l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f284078m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f284079n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f284080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f284081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f284082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f284083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f284084e;

    public static final class a {
    }

    public interface b {
        void a(LKUICheckBox2 r100, boolean r101);
    }

    static {
        f284071f = new SparseArray();
        f284072g = R.drawable.lkui_checkbox_enable_checked;
        f284073h = R.drawable.lkui_checkbox_enable_unchecked;
        f284074i = R.drawable.lkui_checkbox_disable_checked;
        f284075j = R.drawable.lkui_checkbox_disable_unchecked;
        f284076k = R.drawable.lkui_radio_button_enable_checked;
        f284077l = R.drawable.lkui_radio_button_enable_unchecked;
        f284078m = R.drawable.lkui_radio_button_disable_checked;
        f284079n = R.drawable.lkui_radio_button_disable_unchecked;
    }

    private final int getDrawableRes() {
        if (this.f284080a == false) goto L6;
        return getRadioButtonDrawableRes();
    L6:
        return getCheckBoxDrawableRes();
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f284081b);
    }

    private final int getCheckBoxDrawableRes() {
        if (isEnabled() == false) goto L9;
        if (this.f284081b == false) goto L14;
        return f284072g;
    L14:
        return f284073h;
    L9:
        if (this.f284081b == false) goto L12;
        return f284074i;
    L12:
        return f284075j;
    }

    private final int getRadioButtonDrawableRes() {
        if (isEnabled() == false) goto L9;
        if (this.f284081b == false) goto L14;
        return f284076k;
    L14:
        return f284077l;
    L9:
        if (this.f284081b == false) goto L12;
        return f284078m;
    L12:
        return f284079n;
    }

    public final void b() {
        int r100 = getDrawableRes();
        SparseArray<Drawable> r101 = f284071f;
        Drawable r102 = r101.get(r100);
        if (r102 != null) goto L5;
        r102 = d.b(getContext(), r100);
        r101.put(r100, r102);
    L5:
        this.f284083d = r102;
        invalidate();
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        b();
        invalidate();
    }

    @Override // android.view.View
    public final boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f284081b;
    }

    public LKUICheckBox2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    private final void setupAttrs(AttributeSet r100) {
        setClickable(r100.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "clickable", true));
        setChecked(r100.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "checked", this.f284081b));
        setEnabled(r100.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "enabled", isEnabled()));
    }

    public final void a(AttributeSet r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        setupAttrs(r100);
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.isRadio});
        this.f284080a = r101.getBoolean(0, this.f284080a);
        r101.recycle();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f284083d != null) goto L5;
        b();
    L5:
        Drawable r101 = this.f284083d;
        if (r101 == null) goto L9;
        r101.setBounds(new Rect(getPaddingLeft(), getPaddingTop(), this.f284082c + getPaddingLeft(), this.f284082c + getPaddingTop()));
        r101.draw(r100);
        r100.save();
        return;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r100) {
        if (this.f284081b != r100) goto L5;
        return;
    L5:
        this.f284081b = r100;
        b r101 = this.f284084e;
        if (r101 == null) goto L8;
        r101.a(this, r100);
    L8:
        refreshDrawableState();
    }

    public final void setOnCheckedChangeListener(b r100) {
        this.f284084e = r100;
    }

    public final void setRadio(boolean r100) {
        if (this.f284080a != r100) goto L5;
        return;
    L5:
        this.f284080a = r100;
        b();
    }

    public LKUICheckBox2(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        a(r101);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        ViewGroup.LayoutParams r102 = getLayoutParams();
        if (r102 == null) goto L10;
        int r103 = (int) j08.b.a(getContext(), 18.0f);
        if (r102.width != (-2)) goto L8;
        r100 = View.MeasureSpec.makeMeasureSpec((getPaddingLeft() + r103) + getPaddingRight(), 1073741824);
    L8:
        if (r102.height != (-2)) goto L10;
        r101 = View.MeasureSpec.makeMeasureSpec((r103 + getPaddingTop()) + getPaddingBottom(), 1073741824);
    L10:
        this.f284082c = Math.min((View.MeasureSpec.getSize(r100) - getPaddingLeft()) - getPaddingRight(), (View.MeasureSpec.getSize(r101) - getPaddingTop()) - getPaddingBottom());
        super.onMeasure(r100, r101);
    }

    public LKUICheckBox2(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        a(r101);
    }
}
