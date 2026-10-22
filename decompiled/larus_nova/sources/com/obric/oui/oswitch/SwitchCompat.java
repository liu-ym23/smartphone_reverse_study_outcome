package com.obric.oui.oswitch;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import android.widget.CompoundButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.TextViewCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0001}B)\b\u0007\u0012\b\u0010w\u001a\u0004\u0018\u00010v\u0012\n\b\u0002\u0010y\u001a\u0004\u0018\u00010x\u0012\b\b\u0002\u0010z\u001a\u00020\u0006¢\u0006\u0004\b{\u0010|J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0017J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010.\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0014\u00100\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u0010+R\u0014\u00103\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00105\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00102R$\u0010:\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b7\u00102\"\u0004\b8\u00109R$\u0010=\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b;\u00102\"\u0004\b<\u00109R$\u0010A\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u00102\"\u0004\b@\u00109R$\u0010D\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u00102\"\u0004\bC\u00109R$\u0010G\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u00102\"\u0004\bF\u00109R(\u0010N\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010H8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR(\u0010U\u001a\u0004\u0018\u00010O2\b\u0010P\u001a\u0004\u0018\u00010O8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR(\u0010\\\u001a\u0004\u0018\u00010V2\b\u0010W\u001a\u0004\u0018\u00010V8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R(\u0010`\u001a\u0004\u0018\u00010H2\b\u0010]\u001a\u0004\u0018\u00010H8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u0010K\"\u0004\b_\u0010MR(\u0010c\u001a\u0004\u0018\u00010O2\b\u0010P\u001a\u0004\u0018\u00010O8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\ba\u0010R\"\u0004\bb\u0010TR(\u0010f\u001a\u0004\u0018\u00010V2\b\u0010W\u001a\u0004\u0018\u00010V8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bd\u0010Y\"\u0004\be\u0010[R$\u0010g\u001a\u00020\r2\u0006\u0010g\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bh\u0010+\"\u0004\bi\u0010-R(\u0010k\u001a\u0004\u0018\u00010j2\b\u0010k\u001a\u0004\u0018\u00010j8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR(\u0010p\u001a\u0004\u0018\u00010j2\b\u0010p\u001a\u0004\u0018\u00010j8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bq\u0010m\"\u0004\br\u0010oR$\u0010s\u001a\u00020\r2\u0006\u0010s\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bt\u0010+\"\u0004\bu\u0010-¨\u0006~"}, d2 = {"Lcom/obric/oui/oswitch/SwitchCompat;", "Landroid/widget/CompoundButton;", "Landroid/graphics/Typeface;", "typeface", "", "setSwitchTypeface", "", "resId", "setTrackResource", "setThumbResource", "", "position", "setThumbPosition", "", "checked", "setChecked", "setCheckedNoAnim", "getCompoundPaddingLeft", "getCompoundPaddingRight", "Landroid/view/ActionMode$Callback;", "actionModeCallback", "setCustomSelectionActionModeCallback", "q", "I", "mTouchMode", "w", FaceService.girlLabel, "getMThumbPosition", "()F", "setMThumbPosition", "(F)V", "mThumbPosition", "Landroid/animation/ObjectAnimator;", FaceService.neutralLabel, "Landroid/animation/ObjectAnimator;", "getMPositionAnimator", "()Landroid/animation/ObjectAnimator;", "setMPositionAnimator", "(Landroid/animation/ObjectAnimator;)V", "mPositionAnimator", "L", "Z", "getAutoCheck", "()Z", "setAutoCheck", "(Z)V", "autoCheck", "getTargetCheckedState", "targetCheckedState", "getThumbOffset", "()I", "thumbOffset", "getThumbScrollRange", "thumbScrollRange", "value", "getThumbConstraintLeft", "setThumbConstraintLeft", "(I)V", "thumbConstraintLeft", "getThumbConstraintRight", "setThumbConstraintRight", "thumbConstraintRight", "pixels", "getSwitchPadding", "setSwitchPadding", "switchPadding", "getSwitchMinWidth", "setSwitchMinWidth", "switchMinWidth", "getThumbTextPadding", "setThumbTextPadding", "thumbTextPadding", "Landroid/graphics/drawable/Drawable;", GXTemplateKey.GAIAX_TRACK, "getTrackDrawable", "()Landroid/graphics/drawable/Drawable;", "setTrackDrawable", "(Landroid/graphics/drawable/Drawable;)V", "trackDrawable", "Landroid/content/res/ColorStateList;", "tint", "getTrackTintList", "()Landroid/content/res/ColorStateList;", "setTrackTintList", "(Landroid/content/res/ColorStateList;)V", "trackTintList", "Landroid/graphics/PorterDuff$Mode;", "tintMode", "getTrackTintMode", "()Landroid/graphics/PorterDuff$Mode;", "setTrackTintMode", "(Landroid/graphics/PorterDuff$Mode;)V", "trackTintMode", "thumb", "getThumbDrawable", "setThumbDrawable", "thumbDrawable", "getThumbTintList", "setThumbTintList", "thumbTintList", "getThumbTintMode", "setThumbTintMode", "thumbTintMode", "splitTrack", "getSplitTrack", "setSplitTrack", "", "textOn", "getTextOn", "()Ljava/lang/CharSequence;", "setTextOn", "(Ljava/lang/CharSequence;)V", "textOff", "getTextOff", "setTextOff", "showText", "getShowText", "setShowText", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class SwitchCompat extends CompoundButton {
    public static final a O = null;
    public static final int[] P = null;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public final TextPaint G;
    public ObjectAnimator H;
    public final Rect I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f401970J;
    public int K;
    public boolean L;
    public final PathInterpolator M;
    public float N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f401971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f401972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f401973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f401974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f401975e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f401976f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f401977g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f401978h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f401979i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f401980j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f401981k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f401982l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f401983m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f401984n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f401985o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f401986p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f401987q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f401988r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f401989s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f401990t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final VelocityTracker f401991u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f401992v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f401993w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f401994x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f401995y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f401996z;

    public static final class a extends Property<SwitchCompat, Float> {
        public a(Class<Float> r100) {
            super(r100, "thumbPos");
        }

        @Override // android.util.Property
        public final Float get(SwitchCompat r100) {
            SwitchCompat r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "object");
            return Float.valueOf(r101.getMThumbPosition());
        }

        @Override // android.util.Property
        public final void set(SwitchCompat r100, Float r101) {
            SwitchCompat r102 = r100;
            float r103 = r101.floatValue();
            Intrinsics.checkNotNullParameter(r102, "object");
            r102.setThumbPosition(r103);
        }
    }

    public static final class b {
    }

    public SwitchCompat(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SwitchCompat(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final boolean getShowText() {
        return false;
    }

    public final void setShowText(boolean r100) {
    }

    static {
        O = new a(Float.TYPE);
        P = new int[]{R.attr.state_checked};
    }

    private final boolean getTargetCheckedState() {
        if (this.N <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final int getThumbScrollRange() {
        Drawable r100 = this.f401976f;
        if (r100 == null) goto L9;
        Rect r101 = this.I;
        Intrinsics.checkNotNull(r100);
        r100.getPadding(r101);
        Drawable r102 = this.f401971a;
        if (r102 == null) goto L7;
        Rect r103 = DrawableUtils.getOpticalBounds(r102);
    L11:
        return ((((((this.f401994x - this.A) - r101.left) - r101.right) - r103.left) - r103.right) - this.K) - this.f401970J;
    L7:
        r103 = DrawableUtils.INSETS_NONE;
        goto L11
    L9:
        return 0;
    }

    public final void a() {
        Drawable r100 = this.f401971a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f401974d == false) goto L7;
    L8:
        Intrinsics.checkNotNull(r100);
        Drawable r101 = r100.mutate();
        this.f401971a = r101;
        if (this.f401974d == false) goto L12;
        Intrinsics.checkNotNull(r101);
        DrawableCompat.setTintList(r101, this.f401972b);
    L12:
        if (this.f401975e == false) goto L14;
        Drawable r102 = this.f401971a;
        Intrinsics.checkNotNull(r102);
        PorterDuff.Mode r103 = this.f401973c;
        Intrinsics.checkNotNull(r103);
        DrawableCompat.setTintMode(r102, r103);
    L14:
        Drawable r104 = this.f401971a;
        Intrinsics.checkNotNull(r104);
        if (r104.isStateful() == false) goto L20;
        Drawable r105 = this.f401971a;
        Intrinsics.checkNotNull(r105);
        r105.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.f401975e == true) goto L8;
    }

    public final void b() {
        Drawable r100 = this.f401976f;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f401979i == false) goto L7;
    L8:
        Intrinsics.checkNotNull(r100);
        Drawable r101 = r100.mutate();
        this.f401976f = r101;
        if (this.f401979i == false) goto L12;
        Intrinsics.checkNotNull(r101);
        DrawableCompat.setTintList(r101, this.f401977g);
    L12:
        if (this.f401980j == false) goto L14;
        Drawable r102 = this.f401976f;
        Intrinsics.checkNotNull(r102);
        PorterDuff.Mode r103 = this.f401978h;
        Intrinsics.checkNotNull(r103);
        DrawableCompat.setTintMode(r102, r103);
    L14:
        Drawable r104 = this.f401976f;
        Intrinsics.checkNotNull(r104);
        if (r104.isStateful() == false) goto L20;
        Drawable r105 = this.f401976f;
        Intrinsics.checkNotNull(r105);
        r105.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.f401980j == true) goto L8;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        if (this.L == false) goto L6;
        setChecked(!isChecked());
        return;
    }

    private final int getThumbOffset() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L5;
        float r100 = 1 - this.f401993w;
    L7:
        return (int) ((r100 * getThumbScrollRange()) + 0.5f);
    L5:
        r100 = this.f401993w;
        goto L7
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r100 = getDrawableState();
        Drawable r101 = this.f401971a;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        Drawable r103 = this.f401976f;
        if (r103 != null) goto L10;
    L12:
        if (r102 == false) goto L15;
        invalidate();
        return;
    L15:
        return;
    L10:
        if (r103.isStateful() == false) goto L12;
        r102 = r102 | r103.setState(r100);
        goto L12
    L5:
        if (r101.isStateful() == false) goto L7;
        r102 = false | r101.setState(r100);
        goto L7
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L5;
        int r100 = super.getCompoundPaddingLeft() + this.f401994x;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r100;
    L9:
        return r100 + this.f401983m;
    L5:
        return super.getCompoundPaddingLeft();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this) == true) goto L5;
        int r100 = super.getCompoundPaddingRight() + this.f401994x;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r100;
    L9:
        return r100 + this.f401983m;
    L5:
        return super.getCompoundPaddingRight();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r100 = this.f401971a;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
        r100.jumpToCurrentState();
    L5:
        Drawable r101 = this.f401976f;
        if (r101 == null) goto L8;
        Intrinsics.checkNotNull(r101);
        r101.jumpToCurrentState();
    L8:
        ObjectAnimator r102 = this.H;
        if (r102 == null) goto L14;
        Intrinsics.checkNotNull(r102);
        if (r102.isStarted() == false) goto L15;
        ObjectAnimator r103 = this.H;
        Intrinsics.checkNotNull(r103);
        r103.end();
        this.H = null;
        return;
    L15:
        return;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public final boolean performClick() {
        boolean r100 = super.performClick();
        if (isHapticFeedbackEnabled() == true) goto L5;
    L8:
        return r100;
    L5:
        if (isChecked() == false) goto L7;
        bma.a.c(getContext(), 4);
        goto L8
    L7:
        bma.a.c(getContext(), 5);
        goto L8
    }

    public final boolean getAutoCheck() {
        return this.L;
    }

    public final ObjectAnimator getMPositionAnimator() {
        return this.H;
    }

    public final float getMThumbPosition() {
        return this.f401993w;
    }

    public final boolean getSplitTrack() {
        return this.f401984n;
    }

    public final int getSwitchMinWidth() {
        return this.f401982l;
    }

    public final int getSwitchPadding() {
        return this.f401983m;
    }

    public final CharSequence getTextOff() {
        return this.f401986p;
    }

    public final CharSequence getTextOn() {
        return this.f401985o;
    }

    public final int getThumbConstraintLeft() {
        return this.f401970J;
    }

    public final int getThumbConstraintRight() {
        return this.K;
    }

    public final Drawable getThumbDrawable() {
        return this.f401971a;
    }

    public final int getThumbTextPadding() {
        return this.f401981k;
    }

    public final ColorStateList getThumbTintList() {
        return this.f401972b;
    }

    public final PorterDuff.Mode getThumbTintMode() {
        return this.f401973c;
    }

    public final Drawable getTrackDrawable() {
        return this.f401976f;
    }

    public final ColorStateList getTrackTintList() {
        return this.f401977g;
    }

    public final PorterDuff.Mode getTrackTintMode() {
        return this.f401978h;
    }

    @Override // android.view.View
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "c");
        Rect r100 = this.I;
        int r101 = this.C;
        int r102 = this.D;
        int r103 = this.E;
        int r104 = this.F;
        int r105 = getThumbOffset() + r101;
        Drawable r106 = this.f401971a;
        if (r106 == null) goto L5;
        Rect r107 = DrawableUtils.getOpticalBounds(r106);
    L6:
        Drawable r108 = this.f401976f;
        if (r108 == null) goto L26;
        Intrinsics.checkNotNull(r108);
        r108.getPadding(r100);
        int r109 = r100.left;
        r105 = r105 + r109;
        if (r107 == null) goto L23;
        int r111 = r107.left;
        if (r111 <= r109) goto L13;
        r101 = r101 + (r111 - r109);
    L13:
        int r112 = r107.top;
        int r113 = r100.top;
        if (r112 <= r113) goto L16;
        int r114 = (r112 - r113) + r102;
    L17:
        int r115 = r107.right;
        int r116 = r100.right;
        if (r115 <= r116) goto L20;
        r103 = r103 - (r115 - r116);
    L20:
        int r117 = r107.bottom;
        int r118 = r100.bottom;
        if (r117 <= r118) goto L24;
        int r119 = r104 - (r117 - r118);
    L25:
        Drawable r120 = this.f401976f;
        Intrinsics.checkNotNull(r120);
        r120.setBounds(r101, r114, r103, r119);
    L24:
        r119 = r104;
        goto L25
    L16:
        r114 = r102;
        goto L17
    L23:
        r114 = r102;
    L26:
        Drawable r121 = this.f401971a;
        if (r121 == null) goto L31;
        Intrinsics.checkNotNull(r121);
        r121.getPadding(r100);
        int r122 = r105 - r100.left;
        int r123 = this.f401970J;
        int r124 = r122 + r123;
        int r125 = ((r105 + this.A) + r100.right) + r123;
        int r126 = ((r104 - r102) - this.B) / 2;
        Drawable r127 = this.f401971a;
        Intrinsics.checkNotNull(r127);
        r127.setBounds(r124, r126, r125, this.B + r126);
        Drawable r128 = getBackground();
        if (r128 == null) goto L31;
        DrawableCompat.setHotspotBounds(r128, r124, r102, r125, r104);
    L31:
        super.draw(r110);
        return;
    L5:
        r107 = DrawableUtils.INSETS_NONE;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.f401995y = d.n(this, 4);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int r100) {
        int[] r101 = super.onCreateDrawableState(r100 + 1);
        if (isChecked() == false) goto L5;
        View.mergeDrawableStates(r101, P);
    L5:
        return r101;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        Rect r101 = this.I;
        Drawable r102 = this.f401976f;
        if (r102 != null) goto L5;
        Boolean r103 = null;
    L6:
        if (r103 != null) goto L8;
        r101.setEmpty();
        Unit r104 = Unit.INSTANCE;
    L8:
        int r105 = r101.top;
        Drawable r106 = this.f401971a;
        if (r102 != null) goto L11;
    L15:
        int r107 = r100.save();
        if (r106 == null) goto L19;
        r106.draw(r100);
    L19:
        getTargetCheckedState();
        r100.restoreToCount(r107);
        return;
    L11:
        if (this.f401984n == false) goto L14;
        if (r106 == null) goto L14;
        Rect r108 = DrawableUtils.getOpticalBounds(r106);
        r106.copyBounds(r101);
        r101.left += r108.left;
        r101.right -= r108.right;
        int r109 = r100.save();
        r100.clipRect(r101, Region.Op.DIFFERENCE);
        r102.draw(r100);
        r100.restoreToCount(r109);
    L14:
        r102.draw(r100);
        goto L15
    L5:
        r103 = Boolean.valueOf(r102.getPadding(r101));
        goto L6
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super.onInitializeAccessibilityEvent(r100);
        r100.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        super.onInitializeAccessibilityNodeInfo(r100);
        r100.setClassName("android.widget.Switch");
        if (isChecked() == false) goto L5;
        CharSequence r101 = this.f401985o;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L13;
        CharSequence r102 = r100.getText();
        if (TextUtils.isEmpty(r102) == false) goto L11;
        r100.setText(r101);
        return;
    L11:
        StringBuilder r103 = new StringBuilder();
        r103.append(r102);
        r103.append(' ');
        r103.append(r101);
        r100.setText(r103);
        return;
    L13:
        return;
    L5:
        r101 = this.f401986p;
        goto L7
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super.onPopulateAccessibilityEvent(r100);
        if (isChecked() == false) goto L5;
        CharSequence r101 = this.f401985o;
    L6:
        if (r101 == null) goto L9;
        r100.getText().add(r101);
        return;
    L9:
        return;
    L5:
        r101 = this.f401986p;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        this.f401991u.addMovement(r110);
        int r100 = r110.getActionMasked();
        boolean r101 = false;
        if (r100 == 0) goto L70;
        float r102 = 0.0f;
        if (r100 == 1) goto L43;
        if (r100 == 2) goto L9;
        if (r100 == 3) goto L43;
    L87:
        return super.onTouchEvent(r110);
    L9:
        int r103 = this.f401987q;
        if (r103 == 1) goto L36;
        if (r103 != 2) goto L87;
        float r111 = r110.getX();
        int r104 = getThumbScrollRange();
        float r105 = r111 - this.f401989s;
        if (r104 == 0) goto L17;
        float r106 = r105 / r104;
    L21:
        if (ViewUtils.isLayoutRtl(this) == false) goto L23;
        r106 = -r106;
    L23:
        float r107 = this.N;
        float r108 = r106 + r107;
        if (r108 < 0.0f) goto L31;
        if (r108 <= 1.0f) goto L29;
        r102 = 1.0f;
        goto L31
    L29:
        r102 = r108;
    L31:
        if (r102 != r107) goto L33;
        r101 = true;
    L33:
        if (r101 == true) goto L35;
        this.f401989s = r111;
        this.N = r102;
    L35:
        return true;
    L17:
        if (r105 <= 0.0f) goto L19;
        r106 = 1.0f;
        goto L21
    L19:
        r106 = -1.0f;
        goto L21
    L36:
        float r109 = r110.getX();
        float r112 = r110.getY();
        if (Math.abs(r109 - this.f401989s) <= this.f401988r) goto L39;
    L40:
        this.f401987q = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f401989s = r109;
        this.f401990t = r112;
        return true;
    L39:
        if (Math.abs(r112 - this.f401990t) <= this.f401988r) goto L87;
    L43:
        if (this.f401987q != 2) goto L69;
        this.f401987q = 0;
        if (r110.getAction() == 1) goto L47;
    L49:
        boolean r113 = false;
    L50:
        boolean r114 = isChecked();
        if (r113 == false) goto L64;
        this.f401991u.computeCurrentVelocity(1000);
        float r115 = this.f401991u.getXVelocity();
        if (Math.abs(r115) > this.f401992v) goto L55;
        boolean r116 = getTargetCheckedState();
    L65:
        if (r116 == r114) goto L67;
        playSoundEffect(0);
    L67:
        setChecked(r116);
        MotionEvent r117 = MotionEvent.obtain(r110);
        r117.setAction(3);
        super.onTouchEvent(r117);
        r117.recycle();
        super.onTouchEvent(r110);
        return true;
    L55:
        if (ViewUtils.isLayoutRtl(this) == false) goto L60;
        if (r115 < 0.0f) goto L61;
    L62:
        r116 = false;
    L61:
        r116 = true;
        goto L65
    L60:
        if (r115 <= 0.0f) goto L62;
    L64:
        r116 = r114;
        goto L65
    L47:
        if (isEnabled() == false) goto L49;
        r113 = true;
        goto L50
    L69:
        this.f401987q = 0;
        this.f401991u.clear();
        goto L87
    L70:
        float r118 = r110.getX();
        float r119 = r110.getY();
        if (isEnabled() == false) goto L87;
        if (this.f401971a == null) goto L84;
        int r120 = getThumbOffset();
        Drawable r121 = this.f401971a;
        Intrinsics.checkNotNull(r121);
        r121.getPadding(this.I);
        int r122 = this.D;
        int r123 = this.f401988r;
        int r124 = r122 - r123;
        int r125 = (this.C + r120) - r123;
        int r126 = this.A + r125;
        Rect r127 = this.I;
        int r128 = ((r126 + r127.left) + r127.right) + r123;
        int r129 = this.F + r123;
        if (r118 <= r125) goto L84;
        if (r118 >= r128) goto L84;
        if (r119 <= r124) goto L84;
        if (r119 >= r129) goto L84;
        r101 = true;
    L84:
        if (r101 == false) goto L87;
        this.f401987q = 1;
        this.f401989s = r118;
        this.f401990t = r119;
        goto L87
    }

    public final void setAutoCheck(boolean r100) {
        this.L = r100;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r100) {
        super.setChecked(r100);
        boolean r101 = isChecked();
        float r102 = 0.0f;
        if (getWindowToken() != null) goto L5;
    L29:
        ObjectAnimator r103 = this.H;
        if (r103 == null) goto L32;
        Intrinsics.checkNotNull(r103);
        r103.cancel();
    L32:
        if (r101 == false) goto L34;
        r102 = 1.0f;
    L34:
        setThumbPosition(r102);
        return;
    L5:
        if (getWidth() > 0) goto L7;
    L9:
        boolean r104 = false;
    L10:
        if (r104 == false) goto L29;
        if (r101 == false) goto L13;
        r102 = 1.0f;
    L13:
        ObjectAnimator r105 = ObjectAnimator.ofFloat(this, O, new float[]{r102});
        this.H = r105;
        if (r105 == null) goto L17;
        r105.setDuration(443);
    L17:
        ObjectAnimator r106 = this.H;
        if (r106 == null) goto L21;
        r106.setAutoCancel(true);
    L21:
        ObjectAnimator r107 = this.H;
        if (r107 == null) goto L25;
        r107.setInterpolator(this.M);
    L25:
        ObjectAnimator r108 = this.H;
        if (r108 == null) goto L37;
        r108.start();
        return;
    L37:
        return;
    L7:
        if (getHeight() <= 0) goto L9;
        r104 = true;
        goto L10
    }

    public void setCheckedNoAnim(boolean r100) {
        super.setChecked(r100);
        ObjectAnimator r101 = this.H;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNull(r101);
        r101.cancel();
    L6:
        if (isChecked() == false) goto L8;
        float r102 = 1.0f;
    L9:
        setThumbPosition(r102);
        return;
    L8:
        r102 = 0.0f;
        goto L9
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r100) {
        Intrinsics.checkNotNullParameter(r100, "actionModeCallback");
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, r100));
    }

    public final void setMPositionAnimator(ObjectAnimator r100) {
        this.H = r100;
    }

    public final void setMThumbPosition(float r100) {
        this.f401993w = r100;
    }

    public final void setSplitTrack(boolean r100) {
        this.f401984n = r100;
        invalidate();
    }

    public final void setSwitchMinWidth(int r100) {
        this.f401982l = r100;
        requestLayout();
    }

    public final void setSwitchPadding(int r100) {
        this.f401983m = r100;
        requestLayout();
    }

    public final void setSwitchTypeface(Typeface r100) {
        if (this.G.getTypeface() == null) goto L7;
        if (Intrinsics.areEqual(this.G.getTypeface(), r100) == true) goto L7;
    L9:
        this.G.setTypeface(r100);
        requestLayout();
        invalidate();
        return;
    L7:
        if (this.G.getTypeface() != null) goto L11;
        if (r100 != null) goto L9;
        return;
    }

    public final void setTextOff(CharSequence r100) {
        this.f401986p = r100;
        requestLayout();
    }

    public final void setTextOn(CharSequence r100) {
        this.f401985o = r100;
        requestLayout();
    }

    public final void setThumbConstraintLeft(int r100) {
        this.f401970J = r100;
    }

    public final void setThumbConstraintRight(int r100) {
        this.K = r100;
    }

    public final void setThumbDrawable(Drawable r100) {
        Drawable r101 = this.f401971a;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r101.setCallback(null);
    L5:
        this.f401971a = r100;
        if (r100 == null) goto L8;
        r100.setCallback(this);
    L8:
        requestLayout();
    }

    public final void setThumbPosition(float r100) {
        this.f401993w = r100;
        invalidate();
    }

    public final void setThumbResource(int r100) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), r100));
    }

    public final void setThumbTextPadding(int r100) {
        this.f401981k = r100;
        requestLayout();
    }

    public final void setThumbTintList(ColorStateList r100) {
        this.f401972b = r100;
        this.f401974d = true;
        a();
    }

    public final void setThumbTintMode(PorterDuff.Mode r100) {
        this.f401973c = r100;
        this.f401975e = true;
        a();
    }

    public final void setTrackDrawable(Drawable r100) {
        Drawable r101 = this.f401976f;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r101.setCallback(null);
    L5:
        this.f401976f = r100;
        if (r100 == null) goto L8;
        r100.setCallback(this);
    L8:
        requestLayout();
    }

    public final void setTrackResource(int r100) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), r100));
    }

    public final void setTrackTintList(ColorStateList r100) {
        this.f401977g = r100;
        this.f401979i = true;
        b();
    }

    public final void setTrackTintMode(PorterDuff.Mode r100) {
        this.f401978h = r100;
        this.f401980j = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        if (super.verifyDrawable(r100) == false) goto L5;
    L10:
        return true;
    L5:
        if (r100 == this.f401971a) goto L10;
        if (r100 == this.f401976f) goto L10;
        return false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float r100, float r101) {
        super.drawableHotspotChanged(r100, r101);
        Drawable r102 = this.f401971a;
        if (r102 == null) goto L5;
        Intrinsics.checkNotNull(r102);
        DrawableCompat.setHotspot(r102, r100, r101);
    L5:
        Drawable r103 = this.f401976f;
        if (r103 == null) goto L9;
        Intrinsics.checkNotNull(r103);
        DrawableCompat.setHotspot(r103, r100, r101);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r100, int r101) {
        Rect r102 = this.I;
        Drawable r103 = this.f401971a;
        int r104 = 0;
        if (r103 == null) goto L5;
        Intrinsics.checkNotNull(r103);
        r103.getPadding(r102);
        Drawable r105 = this.f401971a;
        Intrinsics.checkNotNull(r105);
        int r106 = (r105.getIntrinsicWidth() - r102.left) - r102.right;
        Drawable r107 = this.f401971a;
        Intrinsics.checkNotNull(r107);
        int r108 = r107.getIntrinsicHeight();
    L6:
        this.A = Math.max(0, r106);
        this.B = r108;
        Drawable r109 = this.f401976f;
        if (r109 == null) goto L9;
        Intrinsics.checkNotNull(r109);
        r109.getPadding(r102);
        Drawable r110 = this.f401976f;
        Intrinsics.checkNotNull(r110);
        r104 = r110.getIntrinsicHeight();
    L10:
        int r111 = r102.left;
        int r112 = r102.right;
        Drawable r113 = this.f401971a;
        if (r113 == null) goto L13;
        Rect r114 = DrawableUtils.getOpticalBounds(r113);
        r111 = Math.max(r111, r114.left);
        r112 = Math.max(r112, r114.right);
    L13:
        int r115 = Math.max(this.f401982l, ((this.A * 2) + r111) + r112);
        int r116 = Math.max(r104, r108);
        this.f401994x = r115 - this.f401995y;
        this.f401996z = r116;
        super.onMeasure(r100, r101);
        if (getMeasuredHeight() >= r116) goto L17;
        setMeasuredDimension(getMeasuredWidthAndState(), r116);
        return;
    L17:
        return;
    L9:
        r102.setEmpty();
        goto L10
    L5:
        r106 = 0;
        r108 = 0;
        goto L6
    }

    public SwitchCompat(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.f401991u = VelocityTracker.obtain();
        this.I = new Rect();
        boolean r100 = true;
        this.L = true;
        this.M = new PathInterpolator(0.33f, 1.3f, 0.15f, 1.0f);
        this.f401995y = d.n(this, 4);
        TextPaint r101 = new TextPaint(1);
        this.G = r101;
        Resources r102 = getResources();
        r101.density = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
        TintTypedArray r113 = TintTypedArray.obtainStyledAttributes(r110, r111, new int[]{R.attr.textOn, R.attr.textOff, R.attr.thumb, com.larus.nova.R.attr.showText, com.larus.nova.R.attr.splitTrack, com.larus.nova.R.attr.switchMinWidth, com.larus.nova.R.attr.switchPadding, com.larus.nova.R.attr.switchTextAppearance, com.larus.nova.R.attr.thumbTextPadding, com.larus.nova.R.attr.thumbTint, com.larus.nova.R.attr.thumbTintMode, com.larus.nova.R.attr.track, com.larus.nova.R.attr.trackTint, com.larus.nova.R.attr.trackTintMode}, r112, 0);
        Drawable r103 = r113.getDrawable(2);
        this.f401971a = r103;
        if (r103 == null) goto L5;
        Intrinsics.checkNotNull(r103);
        r103.setCallback(this);
    L5:
        Drawable r104 = r113.getDrawable(11);
        this.f401976f = r104;
        if (r104 == null) goto L8;
        Intrinsics.checkNotNull(r104);
        r104.setCallback(this);
    L8:
        this.f401985o = r113.getText(0);
        this.f401986p = r113.getText(1);
        this.f401981k = r113.getDimensionPixelSize(8, 0);
        this.f401982l = r113.getDimensionPixelSize(5, 0);
        this.f401983m = r113.getDimensionPixelSize(6, 0);
        this.f401984n = r113.getBoolean(4, false);
        ColorStateList r105 = r113.getColorStateList(9);
        if (r105 == null) goto L11;
        this.f401972b = r105;
        this.f401974d = true;
    L11:
        Typeface r106 = null;
        PorterDuff.Mode r107 = DrawableUtils.parseTintMode(r113.getInt(10, -1), null);
        if (this.f401973c == r107) goto L15;
        this.f401973c = r107;
        this.f401975e = true;
    L15:
        if (this.f401974d == false) goto L17;
    L18:
        a();
    L19:
        ColorStateList r108 = r113.getColorStateList(12);
        if (r108 == null) goto L22;
        this.f401977g = r108;
        this.f401979i = true;
    L22:
        PorterDuff.Mode r109 = DrawableUtils.parseTintMode(r113.getInt(13, -1), null);
        if (this.f401978h == r109) goto L26;
        this.f401978h = r109;
        this.f401980j = true;
    L26:
        if (this.f401979i == false) goto L28;
    L29:
        b();
    L30:
        int r114 = r113.getResourceId(7, 0);
        if (r114 == 0) goto L73;
        TintTypedArray r115 = TintTypedArray.obtainStyledAttributes(r110, r114, new int[]{R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor, R.attr.textColorHint, R.attr.textColorLink, R.attr.shadowColor, R.attr.shadowDx, R.attr.shadowDy, R.attr.shadowRadius, R.attr.fontFamily, R.attr.textFontWeight, com.larus.nova.R.attr.fontFamily, com.larus.nova.R.attr.fontVariationSettings, com.larus.nova.R.attr.textAllCaps, com.larus.nova.R.attr.textLocale});
        if (r115.getColorStateList(3) != null) goto L35;
        getTextColors();
    L35:
        int r116 = r115.getDimensionPixelSize(0, 0);
        if (r116 == 0) goto L43;
        float r117 = r116;
        if (r117 != r101.getTextSize()) goto L40;
        boolean r118 = true;
    L41:
        if (r118 == true) goto L43;
        r101.setTextSize(r117);
        requestLayout();
        goto L43
    L40:
        r118 = false;
    L43:
        int r119 = r115.getInt(1, -1);
        int r120 = r115.getInt(2, -1);
        if (r119 == 1) goto L50;
        if (r119 == 2) goto L49;
        if (r119 != 3) goto L51;
        r106 = Typeface.MONOSPACE;
    L51:
        float r121 = 0.0f;
        if (r120 <= 0) goto L68;
        if (r106 != null) goto L55;
        Typeface r122 = Typeface.defaultFromStyle(r120);
    L56:
        setSwitchTypeface(r122);
        if (r122 != null) goto L59;
        int r123 = 0;
    L60:
        int r124 = r120 & (~r123);
        if ((r124 & 1) != 0) goto L64;
        r100 = false;
    L64:
        r101.setFakeBoldText(r100);
        if ((2 & r124) == 0) goto L67;
        r121 = -0.25f;
    L67:
        r101.setTextSkewX(r121);
    L70:
        if (r115.getBoolean(14, false) == false) goto L72;
        new AllCapsTransformationMethod(getContext());
    L72:
        r115.recycle();
        goto L73
    L59:
        r123 = r122.getStyle();
        goto L60
    L55:
        r122 = Typeface.create(r106, r120);
        goto L56
    L68:
        r101.setFakeBoldText(false);
        r101.setTextSkewX(0.0f);
        setSwitchTypeface(r106);
        goto L70
    L49:
        r106 = Typeface.SERIF;
        goto L51
    L50:
        r106 = Typeface.SANS_SERIF;
    L73:
        r113.recycle();
        if (r110 == null) goto L76;
        ViewConfiguration r125 = ViewConfiguration.get(r110);
        this.f401988r = r125.getScaledTouchSlop();
        this.f401992v = r125.getScaledMinimumFlingVelocity();
    L77:
        refreshDrawableState();
        setChecked(isChecked());
        return;
    L76:
        this.f401988r = 0;
        this.f401992v = 0;
        goto L77
    L28:
        if (this.f401980j == false) goto L30;
    L17:
        if (this.f401975e == false) goto L19;
        goto L18
    }

    public /* synthetic */ SwitchCompat(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        int r104 = com.larus.nova.R.attr.switchStyle;
    L9:
        this(r100, r101, r104);
        return;
    L8:
        r104 = 0;
        goto L9
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = 0;
        if (this.f401971a == null) goto L9;
        Rect r106 = this.I;
        Drawable r107 = this.f401976f;
        if (r107 == null) goto L7;
        Intrinsics.checkNotNull(r107);
        r107.getPadding(r106);
    L8:
        Rect r108 = DrawableUtils.getOpticalBounds(this.f401971a);
        int r109 = Math.max(0, r108.left - r106.left);
        r105 = Math.max(0, r108.right - r106.right);
    L11:
        if (ViewUtils.isLayoutRtl(this) == false) goto L13;
        int r110 = getPaddingLeft() + r109;
        int r111 = ((this.f401994x + r110) - r109) - r105;
    L14:
        int r112 = getGravity() & 112;
        if (r112 != 16) goto L17;
        int r113 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
        int r114 = this.f401996z;
        int r115 = r113 - (r114 / 2);
    L24:
        int r116 = r114 + r115;
    L25:
        this.C = r110;
        this.D = r115;
        this.F = r116;
        this.E = r111;
        return;
    L17:
        if (r112 != 48) goto L19;
        r115 = getPaddingTop();
        r114 = this.f401996z;
        goto L24
    L19:
        if (r112 == 80) goto L21;
        r115 = getPaddingTop();
        r114 = this.f401996z;
        goto L24
    L21:
        r116 = getHeight() - getPaddingBottom();
        r115 = r116 - this.f401996z;
        goto L25
    L13:
        r111 = (getWidth() - getPaddingRight()) - r105;
        r110 = ((r111 - this.f401994x) + r109) + r105;
        goto L14
    L7:
        r106.setEmpty();
        goto L8
    L9:
        r109 = 0;
        goto L11
    }
}
