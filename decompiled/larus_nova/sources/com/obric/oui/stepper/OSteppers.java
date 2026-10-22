package com.obric.oui.stepper;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.obric.oui.button.OButton;
import com.obric.oui.layout.OUIConstraintLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nma.c;
import nma.e;
import nma.f;
import nma.g;
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002'(B\u001d\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b%\u0010&J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002R$\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00028\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00028\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00028\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00028\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006)"}, d2 = {"Lcom/obric/oui/stepper/OSteppers;", "Lcom/obric/oui/layout/OUIConstraintLayout;", "", "getValue", "value", "", "setValue", "getMinValue", "setMinValue", "getMaxValue", "setMaxValue", "setStepValue", "m", "I", "setMValue", "(I)V", "mValue", OfficeSDKRequestTag.KEY_NEW_USER, "setMMinValue", "mMinValue", "o", "setMMaxValue", "mMaxValue", "p", "setMStepValue", "mStepValue", "Lcom/obric/oui/stepper/OSteppers$b;", "onValueChangeListener", "Lcom/obric/oui/stepper/OSteppers$b;", "getOnValueChangeListener", "()Lcom/obric/oui/stepper/OSteppers$b;", "setOnValueChangeListener", "(Lcom/obric/oui/stepper/OSteppers$b;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OSteppers extends OUIConstraintLayout {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f403043q = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final OButton f403044h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OButton f403045i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final EditText f403046j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewGroup f403047k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ViewGroup f403048l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f403049m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f403050n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f403051o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f403052p;

    public static final class a {
    }

    public interface b {
    }

    static {
    }

    public final b getOnValueChangeListener() {
        return null;
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, com.obric.oui.common.style.a
    public /* bridge */ /* synthetic */ void setChangeAlphaWhenEnabledChanged(boolean r100) {
    }

    public final void setOnValueChangeListener(b r100) {
    }

    public final void V5() {
        OButton r100 = this.f403044h;
        boolean r101 = true;
        if (getValue() >= this.f403051o) goto L5;
        boolean r102 = true;
    L6:
        r100.setEnabled(r102);
        OButton r103 = this.f403044h;
        if (getValue() >= this.f403051o) goto L9;
        boolean r104 = true;
    L10:
        r103.setClickable(r104);
        OButton r105 = this.f403045i;
        if (getValue() <= this.f403050n) goto L13;
        boolean r106 = true;
    L14:
        r105.setEnabled(r106);
        OButton r107 = this.f403045i;
        if (getValue() > this.f403050n) goto L18;
        r101 = false;
    L18:
        r107.setClickable(r101);
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

    public final void Y5() {
        this.f403046j.setText(String.valueOf(this.f403049m), TextView.BufferType.EDITABLE);
        V5();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        super.clearFocus();
        this.f403046j.clearFocus();
    }

    public final int getMaxValue() {
        return this.f403051o;
    }

    public final int getMinValue() {
        return this.f403050n;
    }

    public final int getValue() {
        return this.f403049m;
    }

    public OSteppers(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static void S5(OSteppers r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        int r101 = r100.f403049m + r100.f403052p;
        if (r101 >= r100.f403050n) goto L5;
        return;
    L5:
        if (r101 > r100.f403051o) goto L10;
        r100.setMValue(r101);
        r100.f403046j.clearFocus();
        bma.a.c(r100.getContext(), 3);
        return;
    }

    public static void T5(OSteppers r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        int r101 = r100.f403049m - r100.f403052p;
        if (r101 >= r100.f403050n) goto L5;
        return;
    L5:
        if (r101 > r100.f403051o) goto L10;
        r100.setMValue(r101);
        r100.f403046j.clearFocus();
        bma.a.c(r100.getContext(), 3);
        return;
    }

    private final void setMMaxValue(int r100) {
        this.f403051o = r100;
        this.f403046j.setFilters(new nma.a[]{new nma.a(this.f403050n, r100, new f(this))});
        Y5();
    }

    private final void setMMinValue(int r100) {
        this.f403050n = r100;
        this.f403046j.setFilters(new nma.a[]{new nma.a(r100, this.f403051o, new f(this))});
        Y5();
    }

    private final void setMStepValue(int r100) {
        this.f403052p = r100;
        Y5();
    }

    private final void setMValue(int r100) {
        if (this.f403049m != r100) goto L5;
        return;
    L5:
        this.f403049m = r100;
        Y5();
    }

    public final void setMaxValue(int r100) {
        setMMaxValue(r100);
        setMValue(Math.min(r100, this.f403049m));
    }

    public final void setMinValue(int r100) {
        setMMinValue(r100);
        setMValue(Math.max(r100, this.f403049m));
    }

    public final void setStepValue(int r100) {
        if (this.f403052p <= 0) goto L7;
        setMStepValue(r100);
        return;
    L7:
        throw new IllegalArgumentException("step value should be a positive integer");
    }

    public final void setValue(int r100) {
        if (r100 < this.f403050n) goto L9;
        if (r100 > this.f403051o) goto L9;
        setMValue(r100);
        return;
    L9:
        throw new IllegalArgumentException(r100 + " is not in [" + this.f403050n + ", " + this.f403051o + "].");
    }

    public OSteppers(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, 0, 12);
        this.f403051o = 100;
        this.f403052p = 1;
        setFocusable(true);
        setFocusableInTouchMode(true);
        setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        LayoutInflater.from(r110).inflate(R.layout.o_widget_steppers, this);
        OButton r100 = (OButton) findViewById(R.id.tv_add);
        this.f403044h = r100;
        OButton r101 = (OButton) findViewById(R.id.tv_dec);
        this.f403045i = r101;
        EditText r102 = (EditText) findViewById(R.id.et_counter);
        this.f403046j = r102;
        ViewGroup r103 = (ViewGroup) findViewById(R.id.increase_container);
        this.f403047k = r103;
        ViewGroup r104 = (ViewGroup) findViewById(R.id.decrease_container);
        this.f403048l = r104;
        TypedArray r112 = r110.obtainStyledAttributes(r111, new int[]{R.attr.oui_max_value, R.attr.oui_min_value, R.attr.oui_step, R.attr.oui_stepper_value}, 0, 0);
        setMValue(r112.getInt(3, 0));
        setMMinValue(r112.getInt(1, Integer.MIN_VALUE));
        setMMaxValue(r112.getInt(0, Integer.MAX_VALUE));
        setMStepValue(r112.getInt(2, 1));
        r112.recycle();
        int r113 = d.n(this, 4);
        setPadding(r113, r113, r113, r113);
        setRadius(r110.getResources().getDimensionPixelSize(R.dimen.oui_r_m2_rect));
        setBackgroundResource(R.color.oui_fill_sunken_variable);
        r100.setOnClickListener(new nma.b(this));
        r101.setOnClickListener(new c(this));
        r103.setOnClickListener(new nma.d(this));
        r104.setOnClickListener(new e(this));
        r102.addTextChangedListener(new g(this));
        Y5();
    }

    public static final /* synthetic */ void U5(OSteppers r100, int r101) {
        r100.setMValue(r101);
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
