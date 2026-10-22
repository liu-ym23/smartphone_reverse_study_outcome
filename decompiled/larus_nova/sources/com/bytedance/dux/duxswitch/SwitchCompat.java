package com.bytedance.dux.duxswitch;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
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
import android.widget.CompoundButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.core.widget.TextViewCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\r\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0001yB)\b\u0007\u0012\b\u0010s\u001a\u0004\u0018\u00010r\u0012\n\b\u0002\u0010u\u001a\u0004\u0018\u00010t\u0012\b\b\u0002\u0010v\u001a\u00020\u0006¢\u0006\u0004\bw\u0010xJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\"\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010*\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u00100\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00103\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R$\u00107\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b5\u0010-\"\u0004\b6\u0010/R$\u0010:\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b8\u0010-\"\u0004\b9\u0010/R$\u0010=\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b;\u0010-\"\u0004\b<\u0010/R(\u0010D\u001a\u0004\u0018\u00010>2\b\u0010?\u001a\u0004\u0018\u00010>8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR(\u0010K\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010E8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR(\u0010R\u001a\u0004\u0018\u00010L2\b\u0010M\u001a\u0004\u0018\u00010L8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR(\u0010V\u001a\u0004\u0018\u00010>2\b\u0010S\u001a\u0004\u0018\u00010>8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bT\u0010A\"\u0004\bU\u0010CR(\u0010Y\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010E8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bW\u0010H\"\u0004\bX\u0010JR(\u0010\\\u001a\u0004\u0018\u00010L2\b\u0010M\u001a\u0004\u0018\u00010L8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bZ\u0010O\"\u0004\b[\u0010QR$\u0010]\u001a\u00020\r2\u0006\u0010]\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u0010'\"\u0004\b_\u0010)R(\u0010a\u001a\u0004\u0018\u00010`2\b\u0010a\u001a\u0004\u0018\u00010`8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR(\u0010f\u001a\u0004\u0018\u00010`2\b\u0010f\u001a\u0004\u0018\u00010`8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bg\u0010c\"\u0004\bh\u0010eR$\u0010i\u001a\u00020\r2\u0006\u0010i\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bj\u0010'\"\u0004\bk\u0010)R\u0014\u0010m\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bl\u0010'R\u0014\u0010o\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bn\u0010-R\u0014\u0010q\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bp\u0010-¨\u0006z"}, d2 = {"Lcom/bytedance/dux/duxswitch/SwitchCompat;", "Landroid/widget/CompoundButton;", "Landroid/graphics/Typeface;", "typeface", "", "setSwitchTypeface", "", "resId", "setTrackResource", "setThumbResource", "", "position", "setThumbPosition", "", "checked", "setChecked", "getCompoundPaddingLeft", "getCompoundPaddingRight", "Landroid/view/ActionMode$Callback;", "actionModeCallback", "setCustomSelectionActionModeCallback", "x", FaceService.girlLabel, "getMThumbPosition", "()F", "setMThumbPosition", "(F)V", "mThumbPosition", "Landroid/animation/ObjectAnimator;", "L", "Landroid/animation/ObjectAnimator;", "getMPositionAnimator", "()Landroid/animation/ObjectAnimator;", "setMPositionAnimator", "(Landroid/animation/ObjectAnimator;)V", "mPositionAnimator", "P", "Z", "getAutoCheck", "()Z", "setAutoCheck", "(Z)V", "autoCheck", "value", "getThumbConstraintLeft", "()I", "setThumbConstraintLeft", "(I)V", "thumbConstraintLeft", "getThumbConstraintRight", "setThumbConstraintRight", "thumbConstraintRight", "pixels", "getSwitchPadding", "setSwitchPadding", "switchPadding", "getSwitchMinWidth", "setSwitchMinWidth", "switchMinWidth", "getThumbTextPadding", "setThumbTextPadding", "thumbTextPadding", "Landroid/graphics/drawable/Drawable;", GXTemplateKey.GAIAX_TRACK, "getTrackDrawable", "()Landroid/graphics/drawable/Drawable;", "setTrackDrawable", "(Landroid/graphics/drawable/Drawable;)V", "trackDrawable", "Landroid/content/res/ColorStateList;", "tint", "getTrackTintList", "()Landroid/content/res/ColorStateList;", "setTrackTintList", "(Landroid/content/res/ColorStateList;)V", "trackTintList", "Landroid/graphics/PorterDuff$Mode;", "tintMode", "getTrackTintMode", "()Landroid/graphics/PorterDuff$Mode;", "setTrackTintMode", "(Landroid/graphics/PorterDuff$Mode;)V", "trackTintMode", "thumb", "getThumbDrawable", "setThumbDrawable", "thumbDrawable", "getThumbTintList", "setThumbTintList", "thumbTintList", "getThumbTintMode", "setThumbTintMode", "thumbTintMode", "splitTrack", "getSplitTrack", "setSplitTrack", "", "textOn", "getTextOn", "()Ljava/lang/CharSequence;", "setTextOn", "(Ljava/lang/CharSequence;)V", "textOff", "getTextOff", "setTextOff", "showText", "getShowText", "setShowText", "getTargetCheckedState", "targetCheckedState", "getThumbOffset", "thumbOffset", "getThumbScrollRange", "thumbScrollRange", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "dux_release"}, k = 1, mv = {1, 7, 1})
public class SwitchCompat extends CompoundButton {
    public static final a R = null;
    public static final int[] S = null;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public final TextPaint G;
    public ColorStateList H;
    public Layout I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public Layout f205019J;
    public AllCapsTransformationMethod K;
    public ObjectAnimator L;
    public final Rect M;
    public int N;
    public int O;
    public boolean P;
    public float Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f205020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f205021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f205022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f205023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f205024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f205025f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f205026g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f205027h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f205028i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f205029j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f205030k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f205031l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f205032m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f205033n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f205034o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f205035p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f205036q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f205037r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f205038s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f205039t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f205040u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final VelocityTracker f205041v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f205042w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f205043x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f205044y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f205045z;

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

    static {
        R = new a(Float.TYPE);
        S = new int[]{R.attr.state_checked};
    }

    private final boolean getTargetCheckedState() {
        if (this.Q <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final int getThumbScrollRange() {
        Drawable r100 = this.f205025f;
        if (r100 == null) goto L9;
        Rect r101 = this.M;
        Intrinsics.checkNotNull(r100);
        r100.getPadding(r101);
        Drawable r102 = this.f205020a;
        if (r102 == null) goto L7;
        Rect r103 = DrawableUtils.getOpticalBounds(r102);
    L11:
        return ((((((this.f205044y - this.A) - r101.left) - r101.right) - r103.left) - r103.right) - this.O) - this.N;
    L7:
        r103 = DrawableUtils.INSETS_NONE;
        goto L11
    L9:
        return 0;
    }

    public final void a() {
        Drawable r100 = this.f205020a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f205023d == false) goto L7;
    L8:
        Intrinsics.checkNotNull(r100);
        Drawable r101 = r100.mutate();
        this.f205020a = r101;
        if (this.f205023d == false) goto L12;
        Intrinsics.checkNotNull(r101);
        DrawableCompat.setTintList(r101, this.f205021b);
    L12:
        if (this.f205024e == false) goto L14;
        Drawable r102 = this.f205020a;
        Intrinsics.checkNotNull(r102);
        PorterDuff.Mode r103 = this.f205022c;
        Intrinsics.checkNotNull(r103);
        DrawableCompat.setTintMode(r102, r103);
    L14:
        Drawable r104 = this.f205020a;
        Intrinsics.checkNotNull(r104);
        if (r104.isStateful() == false) goto L20;
        Drawable r105 = this.f205020a;
        Intrinsics.checkNotNull(r105);
        r105.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.f205024e == true) goto L8;
    }

    public final void b() {
        Drawable r100 = this.f205025f;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f205028i == false) goto L7;
    L8:
        Intrinsics.checkNotNull(r100);
        Drawable r101 = r100.mutate();
        this.f205025f = r101;
        if (this.f205028i == false) goto L12;
        Intrinsics.checkNotNull(r101);
        DrawableCompat.setTintList(r101, this.f205026g);
    L12:
        if (this.f205029j == false) goto L14;
        Drawable r102 = this.f205025f;
        Intrinsics.checkNotNull(r102);
        PorterDuff.Mode r103 = this.f205027h;
        Intrinsics.checkNotNull(r103);
        DrawableCompat.setTintMode(r102, r103);
    L14:
        Drawable r104 = this.f205025f;
        Intrinsics.checkNotNull(r104);
        if (r104.isStateful() == false) goto L20;
        Drawable r105 = this.f205025f;
        Intrinsics.checkNotNull(r105);
        r105.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.f205029j == true) goto L8;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        if (this.P == false) goto L6;
        setChecked(!isChecked());
        return;
    }

    private final int getThumbOffset() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L5;
        float r100 = 1 - this.f205043x;
    L7:
        return (int) ((r100 * getThumbScrollRange()) + 0.5f);
    L5:
        r100 = this.f205043x;
        goto L7
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r100 = getDrawableState();
        Drawable r101 = this.f205020a;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        Drawable r103 = this.f205025f;
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
        int r100 = super.getCompoundPaddingLeft() + this.f205044y;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r100;
    L9:
        return r100 + this.f205032m;
    L5:
        return super.getCompoundPaddingLeft();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this) == true) goto L5;
        int r100 = super.getCompoundPaddingRight() + this.f205044y;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r100;
    L9:
        return r100 + this.f205032m;
    L5:
        return super.getCompoundPaddingRight();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r100 = this.f205020a;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
        r100.jumpToCurrentState();
    L5:
        Drawable r101 = this.f205025f;
        if (r101 == null) goto L8;
        Intrinsics.checkNotNull(r101);
        r101.jumpToCurrentState();
    L8:
        ObjectAnimator r102 = this.L;
        if (r102 == null) goto L14;
        Intrinsics.checkNotNull(r102);
        if (r102.isStarted() == false) goto L15;
        ObjectAnimator r103 = this.L;
        Intrinsics.checkNotNull(r103);
        r103.end();
        this.L = null;
        return;
    L15:
        return;
    }

    public final boolean getAutoCheck() {
        return this.P;
    }

    public final ObjectAnimator getMPositionAnimator() {
        return this.L;
    }

    public final float getMThumbPosition() {
        return this.f205043x;
    }

    public final boolean getShowText() {
        return this.f205036q;
    }

    public final boolean getSplitTrack() {
        return this.f205033n;
    }

    public final int getSwitchMinWidth() {
        return this.f205031l;
    }

    public final int getSwitchPadding() {
        return this.f205032m;
    }

    public final CharSequence getTextOff() {
        return this.f205035p;
    }

    public final CharSequence getTextOn() {
        return this.f205034o;
    }

    public final int getThumbConstraintLeft() {
        return this.N;
    }

    public final int getThumbConstraintRight() {
        return this.O;
    }

    public final Drawable getThumbDrawable() {
        return this.f205020a;
    }

    public final int getThumbTextPadding() {
        return this.f205030k;
    }

    public final ColorStateList getThumbTintList() {
        return this.f205021b;
    }

    public final PorterDuff.Mode getThumbTintMode() {
        return this.f205022c;
    }

    public final Drawable getTrackDrawable() {
        return this.f205025f;
    }

    public final ColorStateList getTrackTintList() {
        return this.f205026g;
    }

    public final PorterDuff.Mode getTrackTintMode() {
        return this.f205027h;
    }

    public final Layout c(CharSequence r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        AllCapsTransformationMethod r101 = this.K;
        if (r101 == null) goto L8;
        Intrinsics.checkNotNull(r101);
        r100 = r101.getTransformation(r100, this);
    L8:
        CharSequence r102 = r100;
        TextPaint r103 = this.G;
        if (r102 == null) goto L11;
        int r104 = (int) Math.ceil(Layout.getDesiredWidth(r102, r103));
    L13:
        return new StaticLayout(r102, r103, r104, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    L11:
        r104 = 0;
        goto L13
    }

    @Override // android.view.View
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "c");
        Rect r100 = this.M;
        int r101 = this.C;
        int r102 = this.D;
        int r103 = this.E;
        int r104 = this.F;
        int r105 = getThumbOffset() + r101;
        Drawable r106 = this.f205020a;
        if (r106 == null) goto L5;
        Rect r107 = DrawableUtils.getOpticalBounds(r106);
    L6:
        Drawable r108 = this.f205025f;
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
        Drawable r120 = this.f205025f;
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
        Drawable r121 = this.f205020a;
        if (r121 == null) goto L31;
        Intrinsics.checkNotNull(r121);
        r121.getPadding(r100);
        int r122 = r105 - r100.left;
        int r123 = this.N;
        int r124 = r122 + r123;
        int r125 = ((r105 + this.A) + r100.right) + r123;
        int r126 = ((r104 - r102) - this.B) / 2;
        Drawable r127 = this.f205020a;
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

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int r100) {
        int[] r101 = super.onCreateDrawableState(r100 + 1);
        if (isChecked() == false) goto L5;
        View.mergeDrawableStates(r101, S);
    L5:
        return r101;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        Rect r100 = this.M;
        Drawable r101 = this.f205025f;
        if (r101 == null) goto L5;
        r101.getPadding(r100);
    L6:
        int r102 = this.D;
        int r103 = this.F;
        int r104 = r102 + r100.top;
        int r105 = r103 - r100.bottom;
        Drawable r106 = this.f205020a;
        if (r101 != null) goto L9;
    L13:
        int r107 = r110.save();
        if (r106 == null) goto L17;
        r106.draw(r110);
    L17:
        if (getTargetCheckedState() == false) goto L19;
        Layout r108 = this.I;
    L20:
        if (r108 == null) goto L29;
        int[] r109 = getDrawableState();
        ColorStateList r111 = this.H;
        if (r111 == null) goto L24;
        TextPaint r112 = this.G;
        Intrinsics.checkNotNull(r111);
        r112.setColor(r111.getColorForState(r109, 0));
    L24:
        this.G.drawableState = r109;
        if (r106 == null) goto L27;
        Rect r113 = r106.getBounds();
        int r114 = r113.left + r113.right;
    L28:
        r110.translate((r114 / 2) - (r108.getWidth() / 2), ((r104 + r105) / 2) - (r108.getHeight() / 2));
        r108.draw(r110);
        goto L29
    L27:
        r114 = getWidth();
    L29:
        r110.restoreToCount(r107);
        return;
    L19:
        r108 = this.f205019J;
        goto L20
    L9:
        if (this.f205033n == false) goto L12;
        if (r106 == null) goto L12;
        Rect r115 = DrawableUtils.getOpticalBounds(r106);
        r106.copyBounds(r100);
        r100.left += r115.left;
        r100.right -= r115.right;
        int r116 = r110.save();
        r110.clipRect(r100, Region.Op.DIFFERENCE);
        r101.draw(r110);
        r110.restoreToCount(r116);
    L12:
        r101.draw(r110);
        goto L13
    L5:
        r100.setEmpty();
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
        CharSequence r101 = this.f205034o;
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
        r101 = this.f205035p;
        goto L7
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super.onPopulateAccessibilityEvent(r100);
        if (isChecked() == false) goto L5;
        CharSequence r101 = this.f205034o;
    L6:
        if (r101 == null) goto L9;
        r100.getText().add(r101);
        return;
    L9:
        return;
    L5:
        r101 = this.f205035p;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        this.f205041v.addMovement(r110);
        int r100 = r110.getActionMasked();
        boolean r101 = false;
        if (r100 != 0) goto L5;
        float r102 = r110.getX();
        float r103 = r110.getY();
        if (isEnabled() == true) goto L73;
    L87:
        return super.onTouchEvent(r110);
    L73:
        if (this.f205020a == null) goto L84;
        int r104 = getThumbOffset();
        Drawable r105 = this.f205020a;
        Intrinsics.checkNotNull(r105);
        r105.getPadding(this.M);
        int r106 = this.D;
        int r107 = this.f205038s;
        int r108 = r106 - r107;
        int r109 = (this.C + r104) - r107;
        int r111 = this.A + r109;
        Rect r112 = this.M;
        int r113 = ((r111 + r112.left) + r112.right) + r107;
        int r114 = this.F + r107;
        if (r102 <= r109) goto L84;
        if (r102 >= r113) goto L84;
        if (r103 <= r108) goto L84;
        if (r103 >= r114) goto L84;
        r101 = true;
    L84:
        if (r101 == false) goto L87;
        this.f205037r = 1;
        this.f205039t = r102;
        this.f205040u = r103;
        goto L87
    L5:
        if (r100 == 1) goto L43;
        if (r100 == 2) goto L9;
        if (r100 == 3) goto L43;
    L9:
        int r115 = this.f205037r;
        if (r115 == 1) goto L36;
        if (r115 != 2) goto L87;
        float r116 = r110.getX();
        int r117 = getThumbScrollRange();
        float r118 = r116 - this.f205039t;
        float r119 = 1.0f;
        if (r117 == 0) goto L17;
        float r120 = r118 / r117;
    L21:
        if (ViewUtils.isLayoutRtl(this) == false) goto L23;
        r120 = -r120;
    L23:
        float r121 = this.Q;
        float r122 = r120 + r121;
        if (r122 >= 0.0f) goto L27;
        r119 = 0.0f;
    L31:
        if (r119 != r121) goto L33;
        r101 = true;
    L33:
        if (r101 == true) goto L35;
        this.f205039t = r116;
        this.Q = r119;
    L35:
        return true;
    L27:
        if (r122 > 1.0f) goto L31;
        r119 = r122;
        goto L31
    L17:
        if (r118 <= 0) goto L19;
        r120 = 1.0f;
        goto L21
    L19:
        r120 = -1.0f;
        goto L21
    L36:
        float r123 = r110.getX();
        float r124 = r110.getY();
        if (Math.abs(r123 - this.f205039t) <= this.f205038s) goto L39;
    L40:
        this.f205037r = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f205039t = r123;
        this.f205040u = r124;
        return true;
    L39:
        if (Math.abs(r124 - this.f205040u) <= this.f205038s) goto L87;
    L43:
        if (this.f205037r != 2) goto L69;
        this.f205037r = 0;
        if (r110.getAction() == 1) goto L47;
    L49:
        boolean r125 = false;
    L50:
        boolean r126 = isChecked();
        if (r125 == false) goto L64;
        this.f205041v.computeCurrentVelocity(1000);
        float r127 = this.f205041v.getXVelocity();
        if (Math.abs(r127) > this.f205042w) goto L55;
        boolean r128 = getTargetCheckedState();
    L65:
        if (r128 == r126) goto L67;
        playSoundEffect(0);
    L67:
        setChecked(r128);
        MotionEvent r129 = MotionEvent.obtain(r110);
        r129.setAction(3);
        super.onTouchEvent(r129);
        r129.recycle();
        super.onTouchEvent(r110);
        return true;
    L55:
        if (ViewUtils.isLayoutRtl(this) == false) goto L60;
        if (r127 < 0) goto L61;
    L62:
        r128 = false;
    L61:
        r128 = true;
        goto L65
    L60:
        if (r127 <= 0) goto L62;
    L64:
        r128 = r126;
        goto L65
    L47:
        if (isEnabled() == false) goto L49;
        r125 = true;
        goto L50
    L69:
        this.f205037r = 0;
        this.f205041v.clear();
        goto L87
    }

    public final void setAutoCheck(boolean r100) {
        this.P = r100;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r100) {
        super.setChecked(r100);
        boolean r101 = isChecked();
        float r102 = 1.0f;
        if (getWindowToken() != null) goto L5;
    L23:
        ObjectAnimator r103 = this.L;
        if (r103 == null) goto L26;
        Intrinsics.checkNotNull(r103);
        r103.cancel();
    L26:
        if (r101 == true) goto L29;
        r102 = 0;
    L29:
        setThumbPosition(r102);
        return;
    L5:
        if (ViewCompat.isLaidOut(this) == false) goto L23;
        if (r101 == true) goto L9;
        r102 = 0;
    L9:
        ObjectAnimator r104 = ObjectAnimator.ofFloat(this, R, new float[]{r102});
        this.L = r104;
        if (r104 == null) goto L13;
        r104.setDuration(260);
    L13:
        ObjectAnimator r105 = this.L;
        if (r105 == null) goto L16;
        r105.setAutoCancel(true);
    L16:
        ObjectAnimator r106 = this.L;
        if (r106 == null) goto L20;
        r106.setInterpolator(PathInterpolatorCompat.create(0.46f, 0.81f));
    L20:
        ObjectAnimator r107 = this.L;
        if (r107 == null) goto L31;
        r107.start();
        return;
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r100) {
        Intrinsics.checkNotNullParameter(r100, "actionModeCallback");
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, r100));
    }

    public final void setMPositionAnimator(ObjectAnimator r100) {
        this.L = r100;
    }

    public final void setMThumbPosition(float r100) {
        this.f205043x = r100;
    }

    public final void setShowText(boolean r100) {
        if (this.f205036q == r100) goto L6;
        this.f205036q = r100;
        requestLayout();
        return;
    }

    public final void setSplitTrack(boolean r100) {
        this.f205033n = r100;
        invalidate();
    }

    public final void setSwitchMinWidth(int r100) {
        this.f205031l = r100;
        requestLayout();
    }

    public final void setSwitchPadding(int r100) {
        this.f205032m = r100;
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
        this.f205035p = r100;
        requestLayout();
    }

    public final void setTextOn(CharSequence r100) {
        this.f205034o = r100;
        requestLayout();
    }

    public final void setThumbConstraintLeft(int r100) {
        this.N = r100;
    }

    public final void setThumbConstraintRight(int r100) {
        this.O = r100;
    }

    public final void setThumbDrawable(Drawable r100) {
        Drawable r101 = this.f205020a;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r101.setCallback(null);
    L5:
        this.f205020a = r100;
        if (r100 == null) goto L8;
        r100.setCallback(this);
    L8:
        requestLayout();
    }

    public final void setThumbPosition(float r100) {
        this.f205043x = r100;
        invalidate();
    }

    public final void setThumbResource(int r100) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), r100));
    }

    public final void setThumbTextPadding(int r100) {
        this.f205030k = r100;
        requestLayout();
    }

    public final void setThumbTintList(ColorStateList r100) {
        this.f205021b = r100;
        this.f205023d = true;
        a();
    }

    public final void setThumbTintMode(PorterDuff.Mode r100) {
        this.f205022c = r100;
        this.f205024e = true;
        a();
    }

    public final void setTrackDrawable(Drawable r100) {
        Drawable r101 = this.f205025f;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r101.setCallback(null);
    L5:
        this.f205025f = r100;
        if (r100 == null) goto L8;
        r100.setCallback(this);
    L8:
        requestLayout();
    }

    public final void setTrackResource(int r100) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), r100));
    }

    public final void setTrackTintList(ColorStateList r100) {
        this.f205026g = r100;
        this.f205028i = true;
        b();
    }

    public final void setTrackTintMode(PorterDuff.Mode r100) {
        this.f205027h = r100;
        this.f205029j = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        if (super.verifyDrawable(r100) == false) goto L5;
    L10:
        return true;
    L5:
        if (r100 == this.f205020a) goto L10;
        if (r100 == this.f205025f) goto L10;
        return false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float r100, float r101) {
        super.drawableHotspotChanged(r100, r101);
        Drawable r102 = this.f205020a;
        if (r102 == null) goto L5;
        Intrinsics.checkNotNull(r102);
        DrawableCompat.setHotspot(r102, r100, r101);
    L5:
        Drawable r103 = this.f205025f;
        if (r103 == null) goto L9;
        Intrinsics.checkNotNull(r103);
        DrawableCompat.setHotspot(r103, r100, r101);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f205036q == true) goto L5;
    L10:
        Rect r102 = this.M;
        Drawable r103 = this.f205020a;
        int r104 = 0;
        if (r103 == null) goto L13;
        Intrinsics.checkNotNull(r103);
        r103.getPadding(r102);
        Drawable r105 = this.f205020a;
        Intrinsics.checkNotNull(r105);
        int r106 = (r105.getIntrinsicWidth() - r102.left) - r102.right;
        Drawable r107 = this.f205020a;
        Intrinsics.checkNotNull(r107);
        int r108 = r107.getIntrinsicHeight();
    L15:
        if (this.f205036q == false) goto L25;
        Layout r109 = this.I;
        if (r109 == null) goto L19;
        int r110 = r109.getWidth();
    L20:
        Layout r111 = this.f205019J;
        if (r111 == null) goto L23;
        int r112 = r111.getWidth();
    L24:
        int r113 = Math.max(r110, r112) + (this.f205030k * 2);
    L26:
        this.A = Math.max(r113, r106);
        this.B = r108;
        Drawable r114 = this.f205025f;
        if (r114 == null) goto L29;
        Intrinsics.checkNotNull(r114);
        r114.getPadding(r102);
        Drawable r115 = this.f205025f;
        Intrinsics.checkNotNull(r115);
        r104 = r115.getIntrinsicHeight();
    L30:
        int r116 = r102.left;
        int r117 = r102.right;
        Drawable r118 = this.f205020a;
        if (r118 == null) goto L33;
        Rect r119 = DrawableUtils.getOpticalBounds(r118);
        r116 = Math.max(r116, r119.left);
        r117 = Math.max(r117, r119.right);
    L33:
        int r120 = Math.max(this.f205031l, ((this.A * 2) + r116) + r117);
        int r121 = Math.max(r104, r108);
        this.f205044y = r120;
        this.f205045z = r121;
        super.onMeasure(r100, r101);
        if (getMeasuredHeight() >= r121) goto L37;
        setMeasuredDimension(getMeasuredWidthAndState(), r121);
        return;
    L37:
        return;
    L29:
        r102.setEmpty();
        goto L30
    L23:
        r112 = 0;
        goto L24
    L19:
        r110 = 0;
        goto L20
    L25:
        r113 = 0;
        goto L26
    L13:
        r106 = 0;
        r108 = 0;
        goto L15
    L5:
        if (this.I != null) goto L8;
        this.I = c(this.f205034o);
    L8:
        if (this.f205019J != null) goto L10;
        this.f205019J = c(this.f205035p);
        goto L10
    }

    public SwitchCompat(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.f205041v = VelocityTracker.obtain();
        this.M = new Rect();
        boolean r100 = true;
        this.P = true;
        TextPaint r101 = new TextPaint(1);
        this.G = r101;
        Resources r102 = getResources();
        r101.density = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
        TintTypedArray r113 = TintTypedArray.obtainStyledAttributes(r110, r111, new int[]{R.attr.textOn, R.attr.textOff, R.attr.thumb, com.larus.nova.R.attr.showText, com.larus.nova.R.attr.splitTrack, com.larus.nova.R.attr.switchMinWidth, com.larus.nova.R.attr.switchPadding, com.larus.nova.R.attr.switchTextAppearance, com.larus.nova.R.attr.thumbTextPadding, com.larus.nova.R.attr.thumbTint, com.larus.nova.R.attr.thumbTintMode, com.larus.nova.R.attr.track, com.larus.nova.R.attr.trackTint, com.larus.nova.R.attr.trackTintMode}, r112, 0);
        Drawable r103 = r113.getDrawable(2);
        this.f205020a = r103;
        if (r103 == null) goto L5;
        Intrinsics.checkNotNull(r103);
        r103.setCallback(this);
    L5:
        Drawable r104 = r113.getDrawable(11);
        this.f205025f = r104;
        if (r104 == null) goto L8;
        Intrinsics.checkNotNull(r104);
        r104.setCallback(this);
    L8:
        this.f205034o = r113.getText(0);
        this.f205035p = r113.getText(1);
        this.f205036q = r113.getBoolean(3, true);
        this.f205030k = r113.getDimensionPixelSize(8, 0);
        this.f205031l = r113.getDimensionPixelSize(5, 0);
        this.f205032m = r113.getDimensionPixelSize(6, 0);
        this.f205033n = r113.getBoolean(4, false);
        ColorStateList r105 = r113.getColorStateList(9);
        if (r105 == null) goto L11;
        this.f205021b = r105;
        this.f205023d = true;
    L11:
        ViewConfiguration r106 = null;
        PorterDuff.Mode r107 = DrawableUtils.parseTintMode(r113.getInt(10, -1), null);
        if (this.f205022c == r107) goto L15;
        this.f205022c = r107;
        this.f205024e = true;
    L15:
        if (this.f205023d == false) goto L17;
    L18:
        a();
    L19:
        ColorStateList r108 = r113.getColorStateList(12);
        if (r108 == null) goto L22;
        this.f205026g = r108;
        this.f205028i = true;
    L22:
        PorterDuff.Mode r109 = DrawableUtils.parseTintMode(r113.getInt(13, -1), null);
        if (this.f205027h == r109) goto L26;
        this.f205027h = r109;
        this.f205029j = true;
    L26:
        if (this.f205028i == false) goto L28;
    L29:
        b();
    L30:
        int r114 = r113.getResourceId(7, 0);
        if (r114 == 0) goto L74;
        TintTypedArray r115 = TintTypedArray.obtainStyledAttributes(r110, r114, new int[]{R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor, R.attr.textColorHint, R.attr.textColorLink, R.attr.shadowColor, R.attr.shadowDx, R.attr.shadowDy, R.attr.shadowRadius, R.attr.fontFamily, R.attr.textFontWeight, com.larus.nova.R.attr.fontFamily, com.larus.nova.R.attr.fontVariationSettings, com.larus.nova.R.attr.textAllCaps, com.larus.nova.R.attr.textLocale});
        ColorStateList r116 = r115.getColorStateList(3);
        if (r116 != null) goto L35;
        r116 = getTextColors();
    L35:
        this.H = r116;
        int r117 = r115.getDimensionPixelSize(0, 0);
        if (r117 == 0) goto L43;
        float r118 = r117;
        if (r118 != r101.getTextSize()) goto L40;
        boolean r119 = true;
    L41:
        if (r119 == true) goto L43;
        r101.setTextSize(r118);
        requestLayout();
        goto L43
    L40:
        r119 = false;
    L43:
        int r120 = r115.getInt(1, -1);
        int r121 = r115.getInt(2, -1);
        if (r120 == 1) goto L50;
        if (r120 == 2) goto L49;
        if (r120 == 3) goto L48;
        Typeface r122 = null;
    L51:
        float r123 = 0.0f;
        if (r121 <= 0) goto L68;
        if (r122 != null) goto L55;
        Typeface r124 = Typeface.defaultFromStyle(r121);
    L56:
        setSwitchTypeface(r124);
        if (r124 == null) goto L59;
        int r125 = r124.getStyle();
    L60:
        int r126 = (~r125) & r121;
        if ((r126 & 1) != 0) goto L64;
        r100 = false;
    L64:
        r101.setFakeBoldText(r100);
        if ((2 & r126) == 0) goto L67;
        r123 = -0.25f;
    L67:
        r101.setTextSkewX(r123);
    L70:
        if (r115.getBoolean(14, false) == false) goto L72;
        AllCapsTransformationMethod r127 = new AllCapsTransformationMethod(getContext());
    L73:
        this.K = r127;
        r115.recycle();
        goto L74
    L72:
        r127 = null;
        goto L73
    L59:
        r125 = 0;
        goto L60
    L55:
        r124 = Typeface.create(r122, r121);
        goto L56
    L68:
        r101.setFakeBoldText(false);
        r101.setTextSkewX(0.0f);
        setSwitchTypeface(r122);
        goto L70
    L48:
        r122 = Typeface.MONOSPACE;
        goto L51
    L49:
        r122 = Typeface.SERIF;
        goto L51
    L50:
        r122 = Typeface.SANS_SERIF;
    L74:
        r113.recycle();
        if (r110 == null) goto L77;
        r106 = ViewConfiguration.get(r110);
    L77:
        if (r106 == null) goto L79;
        this.f205038s = r106.getScaledTouchSlop();
        this.f205042w = r106.getScaledMinimumFlingVelocity();
    L79:
        refreshDrawableState();
        setChecked(isChecked());
        return;
    L28:
        if (this.f205029j == false) goto L30;
    L17:
        if (this.f205024e == false) goto L19;
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
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = 0;
        if (this.f205020a == null) goto L9;
        Rect r106 = this.M;
        Drawable r107 = this.f205025f;
        if (r107 == null) goto L7;
        Intrinsics.checkNotNull(r107);
        r107.getPadding(r106);
    L8:
        Rect r108 = DrawableUtils.getOpticalBounds(this.f205020a);
        int r109 = Math.max(0, r108.left - r106.left);
        r105 = Math.max(0, r108.right - r106.right);
    L11:
        if (ViewUtils.isLayoutRtl(this) == false) goto L13;
        int r110 = getPaddingLeft() + r109;
        int r111 = ((this.f205044y + r110) - r109) - r105;
    L14:
        int r112 = getGravity() & 112;
        if (r112 != 16) goto L17;
        int r113 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
        int r114 = this.f205045z;
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
        r114 = this.f205045z;
        goto L24
    L19:
        if (r112 == 80) goto L21;
        r115 = getPaddingTop();
        r114 = this.f205045z;
        goto L24
    L21:
        r116 = getHeight() - getPaddingBottom();
        r115 = r116 - this.f205045z;
        goto L25
    L13:
        r111 = (getWidth() - getPaddingRight()) - r105;
        r110 = ((r111 - this.f205044y) + r109) + r105;
        goto L14
    L7:
        r106.setEmpty();
        goto L8
    L9:
        r109 = 0;
        goto L11
    }
}
