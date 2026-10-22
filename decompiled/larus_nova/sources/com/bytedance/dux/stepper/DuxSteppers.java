package com.bytedance.dux.stepper;

import am4.c;
import am4.d;
import am4.e;
import am4.f;
import am4.g;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.amap.api.col.s.ce;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002!\"J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002R$\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00028\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00028\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00028\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00028\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/dux/stepper/DuxSteppers;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "getValue", "value", "", "setValue", "getMinValue", "setMinValue", "getMaxValue", "setMaxValue", "setStepValue", "h", "I", "setMValue", "(I)V", "mValue", RXScreenCaptureService.KEY_INDEX, "setMMinValue", "mMinValue", ce.f26395j, "setMMaxValue", "mMaxValue", ce.f26396k, "setMStepValue", "mStepValue", "Lcom/bytedance/dux/stepper/DuxSteppers$b;", "onValueChangeListener", "Lcom/bytedance/dux/stepper/DuxSteppers$b;", "getOnValueChangeListener", "()Lcom/bytedance/dux/stepper/DuxSteppers$b;", "setOnValueChangeListener", "(Lcom/bytedance/dux/stepper/DuxSteppers$b;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxSteppers extends ConstraintLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f205659l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatImageView f205660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f205661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f205662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f205663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EditText f205664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f205665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f205666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f205667h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f205668i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f205669j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f205670k;

    public static final class a {
    }

    public interface b {
    }

    static {
    }

    public DuxSteppers(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 6);
    }

    public DuxSteppers(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4);
    }

    public final b getOnValueChangeListener() {
        return null;
    }

    public final void setOnValueChangeListener(b r100) {
    }

    public final void S5() {
        ViewGroup r100 = this.f205662c;
        boolean r101 = true;
        if (getValue() >= this.f205669j) goto L5;
        boolean r102 = true;
    L6:
        r100.setEnabled(r102);
        ViewGroup r103 = this.f205662c;
        if (getValue() >= this.f205669j) goto L9;
        boolean r104 = true;
    L10:
        r103.setClickable(r104);
        this.f205660a.setEnabled(this.f205662c.isEnabled());
        ViewGroup r105 = this.f205663d;
        if (getValue() <= this.f205668i) goto L13;
        boolean r106 = true;
    L14:
        r105.setEnabled(r106);
        ViewGroup r107 = this.f205663d;
        if (getValue() > this.f205668i) goto L18;
        r101 = false;
    L18:
        r107.setClickable(r101);
        this.f205661b.setEnabled(this.f205663d.isEnabled());
        return;
    L13:
        r106 = false;
        goto L14
    L9:
        r104 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public final void T5() {
        this.f205664e.setText(String.valueOf(this.f205667h), TextView.BufferType.EDITABLE);
        S5();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        super.clearFocus();
        this.f205664e.clearFocus();
    }

    public final int getMaxValue() {
        return this.f205669j;
    }

    public final int getMinValue() {
        return this.f205668i;
    }

    public final int getValue() {
        return this.f205667h;
    }

    private final void setMMaxValue(int r100) {
        this.f205669j = r100;
        this.f205664e.setFilters(new g[]{new g(this.f205668i, r100, new f(this))});
        T5();
    }

    private final void setMMinValue(int r100) {
        this.f205668i = r100;
        this.f205664e.setFilters(new g[]{new g(r100, this.f205669j, new f(this))});
        T5();
    }

    private final void setMStepValue(int r100) {
        this.f205670k = r100;
        T5();
    }

    private final void setMValue(int r100) {
        if (this.f205667h != r100) goto L5;
        return;
    L5:
        this.f205667h = r100;
        T5();
    }

    public final void setMaxValue(int r100) {
        setMMaxValue(r100);
        setMValue(Math.min(r100, this.f205667h));
    }

    public final void setMinValue(int r100) {
        setMMinValue(r100);
        setMValue(Math.max(r100, this.f205667h));
    }

    public final void setStepValue(int r100) {
        if (this.f205670k <= 0) goto L7;
        setMStepValue(r100);
        return;
    L7:
        throw new IllegalArgumentException("step value should be a positive integer");
    }

    public final void setValue(int r100) {
        if (r100 < this.f205668i) goto L9;
        if (r100 > this.f205669j) goto L9;
        setMValue(r100);
        return;
    L9:
        throw new IllegalArgumentException(r100 + " is not in [" + this.f205668i + ", " + this.f205669j + "].");
    }

    public static final /* synthetic */ void R5(DuxSteppers r100, int r101) {
        r100.setMValue(r101);
    }

    public DuxSteppers(Context r110, AttributeSet r111, int r112) {
        if ((r112 & 2) == 0) goto L5;
        r111 = null;
    L5:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        this.f205669j = 100;
        this.f205670k = 1;
        setFocusable(true);
        setFocusableInTouchMode(true);
        setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        LayoutInflater.from(r110).inflate(R.layout.dux_widget_steppers, this);
        AppCompatImageView r100 = (AppCompatImageView) findViewById(R.id.tv_add);
        this.f205660a = r100;
        AppCompatImageView r101 = (AppCompatImageView) findViewById(R.id.tv_dec);
        this.f205661b = r101;
        ViewGroup r102 = (ViewGroup) findViewById(R.id.fl_add);
        this.f205662c = r102;
        ViewGroup r103 = (ViewGroup) findViewById(R.id.fl_dec);
        this.f205663d = r103;
        EditText r104 = (EditText) findViewById(R.id.et_counter);
        this.f205664e = r104;
        ViewGroup r105 = (ViewGroup) findViewById(R.id.increase_container);
        this.f205665f = r105;
        ViewGroup r106 = (ViewGroup) findViewById(R.id.decrease_container);
        this.f205666g = r106;
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.btn_text_color, R.attr.left_btn_background, R.attr.limitLargeFontScale, R.attr.max_value, R.attr.min_value, R.attr.right_btn_background, R.attr.step, R.attr.stepper_background, R.attr.stepper_value}, 0, 0);
        setMValue(r113.getInt(8, 0));
        setMMinValue(r113.getInt(4, Integer.MIN_VALUE));
        setMMaxValue(r113.getInt(3, Integer.MAX_VALUE));
        setMStepValue(r113.getInt(6, 1));
        ColorStateList r107 = r113.getColorStateList(0);
        if (r107 != null) goto L8;
        r107 = ContextCompat.getColorStateList(r110, R.color.dux_stepper_btn);
    L8:
        r101.setImageTintList(r107);
        r100.setImageTintList(r107);
        Drawable r108 = r113.getDrawable(7);
        if (r108 != null) goto L11;
        r108 = ContextCompat.getDrawable(r110, R.drawable.dux_bg_steppers);
    L11:
        setBackground(r108);
        Drawable r114 = r113.getDrawable(1);
        if (r114 != null) goto L14;
        r114 = ContextCompat.getDrawable(r110, R.drawable.dux_bg_steppers_btn_left);
    L14:
        r103.setBackground(r114);
        Drawable r115 = r113.getDrawable(5);
        if (r115 != null) goto L17;
        r115 = ContextCompat.getDrawable(r110, R.drawable.dux_bg_steppers_btn_right);
    L17:
        r102.setBackground(r115);
        boolean r116 = r113.getBoolean(2, false);
        r113.recycle();
        if (r116 == false) goto L21;
        com.bytedance.dux.largefont.a.a(r101, 12, 12);
        com.bytedance.dux.largefont.a.a(r100, 12, 12);
        com.bytedance.dux.largefont.a.c(r104, 15.0f);
    L21:
        r102.setOnClickListener(new am4.a(this));
        r103.setOnClickListener(new am4.b(this));
        r105.setOnClickListener(new c(this));
        r106.setOnClickListener(new d(this));
        r104.addTextChangedListener(new e(this));
        T5();
    }
}
