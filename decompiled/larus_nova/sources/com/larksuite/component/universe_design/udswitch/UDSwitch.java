package com.larksuite.component.universe_design.udswitch;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.CompoundButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.common.CastMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\f\b\u0017\u0018\u0000 \u008a\u00012\u00020\u0001:\u0002\u008a\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ*\u0010C\u001a\u00020D2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\b\u0010E\u001a\u00020DH\u0002J\b\u0010F\u001a\u00020DH\u0002J\u0010\u0010G\u001a\u00020D2\b\u0010H\u001a\u0004\u0018\u00010'J\u000e\u0010I\u001a\u00020D2\u0006\u0010J\u001a\u00020\nJ\b\u0010K\u001a\u0004\u0018\u00010'J\u000e\u0010L\u001a\u00020D2\u0006\u0010M\u001a\u00020)J\b\u0010N\u001a\u0004\u0018\u00010)J\u0010\u0010O\u001a\u00020D2\b\u0010P\u001a\u0004\u0018\u00010'J\u000e\u0010Q\u001a\u00020D2\u0006\u0010J\u001a\u00020\nJ\b\u0010R\u001a\u0004\u0018\u00010'J\u000e\u0010S\u001a\u00020D2\u0006\u0010M\u001a\u00020)J\b\u0010T\u001a\u0004\u0018\u00010)J\u000e\u0010U\u001a\u00020D2\u0006\u0010V\u001a\u00020\nJ\u0018\u0010W\u001a\u00020D2\u0006\u0010X\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\nH\u0014J\u0018\u0010Z\u001a\u00020-2\u0006\u0010[\u001a\u00020\u001f2\u0006\u0010\\\u001a\u00020\u001fH\u0002J\b\u0010]\u001a\u00020\nH\u0002J\b\u0010^\u001a\u00020\nH\u0002J\u0010\u0010_\u001a\u00020-2\u0006\u0010`\u001a\u00020aH\u0016J\u0010\u0010b\u001a\u00020D2\u0006\u0010`\u001a\u00020aH\u0002J\u0010\u0010c\u001a\u00020D2\u0006\u0010`\u001a\u00020aH\u0002J\b\u0010d\u001a\u00020-H\u0002J\u0010\u0010e\u001a\u00020D2\u0006\u0010f\u001a\u00020\u001fH\u0016J\b\u0010g\u001a\u00020DH\u0016J\u0010\u0010h\u001a\u00020D2\u0006\u0010i\u001a\u00020-H\u0016J\u000e\u0010j\u001a\u00020D2\u0006\u0010i\u001a\u00020-J\u000e\u0010k\u001a\u00020D2\u0006\u0010i\u001a\u00020-J\u0012\u0010l\u001a\u00020D2\b\u0010m\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010n\u001a\u00020D2\u0006\u0010o\u001a\u00020-H\u0002J\b\u0010p\u001a\u00020DH\u0002J0\u0010q\u001a\u00020D2\u0006\u0010r\u001a\u00020-2\u0006\u0010s\u001a\u00020\n2\u0006\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020\n2\u0006\u0010v\u001a\u00020\nH\u0014J\u0010\u0010w\u001a\u00020D2\u0006\u0010x\u001a\u00020yH\u0016J\u0010\u0010z\u001a\u00020D2\u0006\u0010{\u001a\u00020yH\u0014J\b\u0010|\u001a\u00020\nH\u0016J\b\u0010}\u001a\u00020\nH\u0016J\u0013\u0010~\u001a\u0004\u0018\u00010\u007f2\u0007\u0010\u0080\u0001\u001a\u00020\nH\u0014J\t\u0010\u0081\u0001\u001a\u00020DH\u0014J\u0019\u0010\u0082\u0001\u001a\u00020D2\u0006\u0010[\u001a\u00020\u001f2\u0006\u0010\\\u001a\u00020\u001fH\u0016J\u0012\u0010\u0083\u0001\u001a\u00020-2\u0007\u0010\u0084\u0001\u001a\u00020'H\u0014J\t\u0010\u0085\u0001\u001a\u00020DH\u0016J$\u0010\u0086\u0001\u001a\u00020\u001f2\u0007\u0010\u0087\u0001\u001a\u00020\u001f2\u0007\u0010\u0088\u0001\u001a\u00020\u001f2\u0007\u0010\u0089\u0001\u001a\u00020\u001fH\u0002R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001a\u0010#\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00103\u001a\n 5*\u0004\u0018\u00010404X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008b\u0001"}, d2 = {"Lcom/larksuite/component/universe_design/udswitch/UDSwitch;", "Landroid/widget/CompoundButton;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mSwitchWidth", "mSwitchHeight", "mSwitchLeft", "getMSwitchLeft", "()I", "setMSwitchLeft", "(I)V", "mSwitchTop", "getMSwitchTop", "setMSwitchTop", "mSwitchRight", "getMSwitchRight", "setMSwitchRight", "mSwitchBottom", "getMSwitchBottom", "setMSwitchBottom", "mThumbPosition", "", "thumbInitialLeft", "getThumbInitialLeft", "setThumbInitialLeft", "mThumbWidth", "getMThumbWidth", "setMThumbWidth", "mThumbDrawable", "Landroid/graphics/drawable/Drawable;", "mThumbTintList", "Landroid/content/res/ColorStateList;", "mThumbTintMode", "Landroid/graphics/PorterDuff$Mode;", "mHasThumbTint", "", "mHasThumbTintMode", "mTouchMode", "mTouchSlop", "mTouchX", "mTouchY", "mVelocityTracker", "Landroid/view/VelocityTracker;", "kotlin.jvm.PlatformType", "mMinFlingVelocity", "mTrackDrawable", "mTrackTintList", "mTrackTintMode", "mHasTrackTint", "mHasTrackTintMode", "mSwitchMinWidth", "mTempRect", "Landroid/graphics/Rect;", "mPositionAnimator", "Landroid/animation/ObjectAnimator;", "mOnCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "initView", "", "applyTrackTint", "applyThumbTint", "setThumbDrawable", "thumb", "setThumbResource", "resId", "getThumbDrawable", "setThumbTintList", "tint", "getThumbTintList", "setTrackDrawable", GXTemplateKey.GAIAX_TRACK, "setTrackResource", "getTrackDrawable", "setTrackTintList", "getTrackTintList", "setSwitchMinWidth", "pixels", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "hitThumb", "x", "y", "getThumbOffset", "getThumbScrollRange", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "cancelSuperTouch", "stopDrag", "getTargetCheckedState", "setThumbPosition", "position", "toggle", "setChecked", "checked", "setCheckedImmediately", "setCheckedIgnoreEvent", "setOnCheckedChangeListener", "listener", "animateThumbToCheckedState", "newCheckedState", "cancelPositionAnimator", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "draw", "c", "Landroid/graphics/Canvas;", "onDraw", "canvas", "getCompoundPaddingLeft", "getCompoundPaddingRight", "onCreateDrawableState", "", "extraSpace", "drawableStateChanged", "drawableHotspotChanged", "verifyDrawable", "who", "jumpDrawablesToCurrentState", "constrain", "amount", "low", "high", "Companion", "universe-ui-switch_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UDSwitch extends CompoundButton {
    public static final a A = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int[] f285432z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f285433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f285434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f285435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f285436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f285437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f285438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f285439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f285440h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f285441i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f285442j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f285443k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f285444l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f285445m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f285446n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f285447o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f285448p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final VelocityTracker f285449q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f285450r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Drawable f285451s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ColorStateList f285452t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f285453u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f285454v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Rect f285455w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ObjectAnimator f285456x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f285457y;

    public static final class a extends Property<UDSwitch, Float> {
        public a(Class<Float> r100) {
            super(r100, "thumbPos");
        }

        @Override // android.util.Property
        public final Float get(UDSwitch r100) {
            UDSwitch r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "udSwitch");
            return Float.valueOf(r101.f285439g);
        }

        @Override // android.util.Property
        public final void set(UDSwitch r100, Float r101) {
            UDSwitch r102 = r100;
            float r103 = r101.floatValue();
            Intrinsics.checkNotNullParameter(r102, "udSwitch");
            r102.setThumbPosition(r103);
        }
    }

    public static final class b {
    }

    static {
        f285432z = new int[]{R.attr.state_checked};
        A = new a(Float.TYPE);
    }

    private final boolean getTargetCheckedState() {
        if (this.f285439g <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final int getThumbScrollRange() {
        Drawable r100 = this.f285451s;
        if (r100 == null) goto L9;
        Rect r101 = this.f285455w;
        Intrinsics.checkNotNull(r100);
        r100.getPadding(r101);
        Drawable r102 = this.f285442j;
        if (r102 == null) goto L7;
        Rect r103 = h18.a.b(r102);
    L8:
        Intrinsics.checkNotNull(r103);
        return ((((this.f285433a - this.f285441i) - r101.left) - r101.right) - r103.left) - r103.right;
    L7:
        r103 = h18.a.f483536a;
        goto L8
    L9:
        return 0;
    }

    public final void a() {
        Drawable r100 = this.f285442j;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f285444l == false) goto L16;
        Intrinsics.checkNotNull(r100);
        Drawable r101 = DrawableCompat.wrap(r100).mutate();
        this.f285442j = r101;
        if (this.f285444l == false) goto L10;
        Intrinsics.checkNotNull(r101);
        DrawableCompat.setTintList(r101, this.f285443k);
    L10:
        Drawable r102 = this.f285442j;
        Intrinsics.checkNotNull(r102);
        if (r102.isStateful() == false) goto L15;
        Drawable r103 = this.f285442j;
        Intrinsics.checkNotNull(r103);
        r103.setState(getDrawableState());
        return;
    L15:
        return;
    }

    public final void b() {
        Drawable r100 = this.f285451s;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f285453u == false) goto L16;
        Intrinsics.checkNotNull(r100);
        Drawable r101 = DrawableCompat.wrap(r100).mutate();
        this.f285451s = r101;
        if (this.f285453u == false) goto L10;
        Intrinsics.checkNotNull(r101);
        DrawableCompat.setTintList(r101, this.f285452t);
    L10:
        Drawable r102 = this.f285451s;
        Intrinsics.checkNotNull(r102);
        if (r102.isStateful() == false) goto L15;
        Drawable r103 = this.f285451s;
        Intrinsics.checkNotNull(r103);
        r103.setState(getDrawableState());
        return;
    L15:
        return;
    }

    private final int getThumbOffset() {
        if (h.a(this) == false) goto L5;
        float r100 = 1.0f - this.f285439g;
    L7:
        return (int) ((r100 * getThumbScrollRange()) + 0.5f);
    L5:
        r100 = this.f285439g;
        goto L7
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r100 = getDrawableState();
        Drawable r101 = this.f285442j;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        Drawable r103 = this.f285451s;
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
        if (h.a(this) == true) goto L7;
        return super.getCompoundPaddingLeft();
    L7:
        return super.getCompoundPaddingLeft() + this.f285433a;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (h.a(this) == false) goto L7;
        return super.getCompoundPaddingRight();
    L7:
        return super.getCompoundPaddingRight() + this.f285433a;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r100 = this.f285442j;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
        r100.jumpToCurrentState();
    L5:
        Drawable r101 = this.f285451s;
        if (r101 == null) goto L8;
        Intrinsics.checkNotNull(r101);
        r101.jumpToCurrentState();
    L8:
        ObjectAnimator r102 = this.f285456x;
        if (r102 == null) goto L14;
        Intrinsics.checkNotNull(r102);
        if (r102.isStarted() == false) goto L15;
        ObjectAnimator r103 = this.f285456x;
        Intrinsics.checkNotNull(r103);
        r103.end();
        this.f285456x = null;
        return;
    L15:
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    public final int getMSwitchBottom() {
        return this.f285438f;
    }

    public final int getMSwitchLeft() {
        return this.f285435c;
    }

    public final int getMSwitchRight() {
        return this.f285437e;
    }

    public final int getMSwitchTop() {
        return this.f285436d;
    }

    public final int getMThumbWidth() {
        return this.f285441i;
    }

    public final Drawable getThumbDrawable() {
        return this.f285442j;
    }

    public final int getThumbInitialLeft() {
        return this.f285440h;
    }

    public final ColorStateList getThumbTintList() {
        return this.f285443k;
    }

    public final Drawable getTrackDrawable() {
        return this.f285451s;
    }

    public final ColorStateList getTrackTintList() {
        return this.f285452t;
    }

    public UDSwitch(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.View
    public void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "c");
        Rect r100 = this.f285455w;
        int r101 = this.f285435c;
        int r102 = this.f285436d;
        int r103 = this.f285437e;
        int r104 = this.f285438f;
        this.f285440h = getThumbOffset() + r101;
        Drawable r105 = this.f285442j;
        if (r105 == null) goto L5;
        Rect r106 = h18.a.b(r105);
    L6:
        Drawable r107 = this.f285451s;
        if (r107 == null) goto L26;
        r107.getPadding(r100);
        int r108 = this.f285440h;
        int r109 = r100.left;
        this.f285440h = r108 + r109;
        if (r106 == null) goto L23;
        int r111 = r106.left;
        if (r111 <= r109) goto L13;
        r101 = r101 + (r111 - r109);
    L13:
        int r112 = r106.top;
        int r113 = r100.top;
        if (r112 <= r113) goto L16;
        int r114 = (r112 - r113) + r102;
    L17:
        int r115 = r106.right;
        int r116 = r100.right;
        if (r115 <= r116) goto L20;
        r103 = r103 - (r115 - r116);
    L20:
        int r117 = r106.bottom;
        int r118 = r100.bottom;
        if (r117 <= r118) goto L24;
        int r119 = r104 - (r117 - r118);
    L25:
        r107.setBounds(r101, r114, r103, r119);
    L24:
        r119 = r104;
        goto L25
    L16:
        r114 = r102;
        goto L17
    L23:
        r114 = r102;
    L26:
        Drawable r120 = this.f285442j;
        if (r120 == null) goto L31;
        r120.getPadding(r100);
        int r121 = this.f285440h;
        int r122 = r121 - r100.left;
        int r123 = (r121 + this.f285441i) + r100.right;
        r120.setBounds(r122, r102, r123, r104);
        Drawable r124 = getBackground();
        if (r124 == null) goto L31;
        DrawableCompat.setHotspotBounds(r124, r122, r102, r123, r104);
    L31:
        super.draw(r110);
        return;
    L5:
        r106 = h18.a.f483536a;
        goto L6
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int r100) {
        int[] r101 = super.onCreateDrawableState(r100 + 1);
        if (isChecked() == false) goto L5;
        View.mergeDrawableStates(r101, f285432z);
    L5:
        return r101;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        Rect r101 = this.f285455w;
        Drawable r102 = this.f285451s;
        if (r102 == null) goto L5;
        r102.getPadding(r101);
    L6:
        Drawable r103 = this.f285442j;
        if (r102 == null) goto L9;
        r102.draw(r100);
    L9:
        int r104 = r100.save();
        if (r103 == null) goto L12;
        r103.draw(r100);
    L12:
        r100.restoreToCount(r104);
        return;
    L5:
        r101.setEmpty();
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        this.f285449q.addMovement(r110);
        int r100 = r110.getActionMasked();
        boolean r101 = false;
        if (r100 == 0) goto L67;
        float r102 = 0.0f;
        if (r100 == 1) goto L43;
        if (r100 == 2) goto L9;
        if (r100 == 3) goto L43;
    L84:
        return super.onTouchEvent(r110);
    L9:
        int r103 = this.f285445m;
        if (r103 == 1) goto L36;
        if (r103 != 2) goto L84;
        float r111 = r110.getX();
        int r104 = getThumbScrollRange();
        float r105 = r111 - this.f285447o;
        if (r104 == 0) goto L17;
        float r106 = r105 / r104;
    L21:
        if (h.a(this) == false) goto L23;
        r106 = -r106;
    L23:
        float r107 = this.f285439g;
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
        this.f285447o = r111;
        setThumbPosition(r102);
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
        if (Math.abs(r109 - this.f285447o) <= this.f285446n) goto L39;
    L40:
        this.f285445m = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f285447o = r109;
        this.f285448p = r112;
        return true;
    L39:
        if (Math.abs(r112 - this.f285448p) <= this.f285446n) goto L84;
    L43:
        if (this.f285445m != 2) goto L66;
        this.f285445m = 0;
        if (r110.getAction() == 1) goto L47;
    L49:
        boolean r113 = false;
    L50:
        boolean r114 = isChecked();
        if (r113 == false) goto L64;
        this.f285449q.computeCurrentVelocity(1000);
        float r115 = this.f285449q.getXVelocity();
        if (Math.abs(r115) > this.f285450r) goto L55;
        r114 = getTargetCheckedState();
        goto L64
    L55:
        if (h.a(this) == false) goto L60;
        if (r115 < 0.0f) goto L61;
    L62:
        r114 = r101;
    L61:
        r101 = true;
        goto L62
    L60:
        if (r115 <= 0.0f) goto L62;
    L64:
        setChecked(r114);
        MotionEvent r116 = MotionEvent.obtain(r110);
        r116.setAction(3);
        super.onTouchEvent(r116);
        r116.recycle();
        super.onTouchEvent(r110);
        return true;
    L47:
        if (isEnabled() == false) goto L49;
        r113 = true;
        goto L50
    L66:
        this.f285445m = 0;
        this.f285449q.clear();
        goto L84
    L67:
        float r117 = r110.getX();
        float r118 = r110.getY();
        if (isEnabled() == false) goto L84;
        if (this.f285442j == null) goto L81;
        int r119 = getThumbOffset();
        Drawable r120 = this.f285442j;
        Intrinsics.checkNotNull(r120);
        r120.getPadding(this.f285455w);
        int r121 = this.f285436d;
        int r122 = this.f285446n;
        int r123 = r121 - r122;
        int r124 = (this.f285435c + r119) - r122;
        int r125 = this.f285441i + r124;
        Rect r126 = this.f285455w;
        int r127 = ((r125 + r126.left) + r126.right) + r122;
        int r128 = this.f285438f + r122;
        if (r117 <= r124) goto L81;
        if (r117 >= r127) goto L81;
        if (r118 <= r123) goto L81;
        if (r118 >= r128) goto L81;
        r101 = true;
    L81:
        if (r101 == false) goto L84;
        this.f285445m = 1;
        this.f285447o = r117;
        this.f285448p = r118;
        goto L84
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r100) {
        super.setChecked(r100);
        boolean r101 = isChecked();
        float r102 = 0.0f;
        if (getWindowToken() != null) goto L5;
    L11:
        ObjectAnimator r103 = this.f285456x;
        if (r103 == null) goto L14;
        r103.cancel();
    L14:
        if (r101 == false) goto L16;
        r102 = 1.0f;
    L16:
        setThumbPosition(r102);
        return;
    L5:
        if (ViewCompat.isLaidOut(this) == false) goto L11;
        if (r101 == false) goto L8;
        r102 = 1.0f;
    L8:
        ObjectAnimator r104 = ObjectAnimator.ofFloat(this, A, new float[]{r102});
        this.f285456x = r104;
        if (r104 == null) goto L18;
        r104.setDuration(250);
        r104.setAutoCancel(true);
        r104.start();
        return;
    }

    public final void setCheckedIgnoreEvent(boolean r100) {
        if (this.f285457y != null) goto L5;
        setChecked(r100);
        return;
    L5:
        super.setOnCheckedChangeListener(null);
        setChecked(r100);
        super.setOnCheckedChangeListener(this.f285457y);
    }

    public final void setCheckedImmediately(boolean r100) {
        if (r100 == false) goto L4;
        float r101 = 1.0f;
    L5:
        setThumbPosition(r101);
        return;
    L4:
        r101 = 0.0f;
        goto L5
    }

    public final void setMSwitchBottom(int r100) {
        this.f285438f = r100;
    }

    public final void setMSwitchLeft(int r100) {
        this.f285435c = r100;
    }

    public final void setMSwitchRight(int r100) {
        this.f285437e = r100;
    }

    public final void setMSwitchTop(int r100) {
        this.f285436d = r100;
    }

    public final void setMThumbWidth(int r100) {
        this.f285441i = r100;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r100) {
        super.setOnCheckedChangeListener(r100);
        this.f285457y = r100;
    }

    public final void setSwitchMinWidth(int r100) {
        this.f285454v = r100;
        requestLayout();
    }

    public final void setThumbDrawable(Drawable r100) {
        Drawable r101 = this.f285442j;
        if (r101 == null) goto L5;
        r101.setCallback(null);
    L5:
        this.f285442j = r100;
        if (r100 == null) goto L8;
        r100.setCallback(this);
    L8:
        requestLayout();
    }

    public final void setThumbInitialLeft(int r100) {
        this.f285440h = r100;
    }

    public void setThumbPosition(float r100) {
        this.f285439g = r100;
        invalidate();
    }

    public final void setThumbResource(int r100) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), r100));
    }

    public final void setThumbTintList(ColorStateList r100) {
        Intrinsics.checkNotNullParameter(r100, "tint");
        this.f285443k = r100;
        this.f285444l = true;
        a();
    }

    public final void setTrackDrawable(Drawable r100) {
        Drawable r101 = this.f285451s;
        if (r101 == null) goto L5;
        r101.setCallback(null);
    L5:
        this.f285451s = r100;
        if (r100 == null) goto L8;
        r100.setCallback(this);
    L8:
        requestLayout();
    }

    public final void setTrackResource(int r100) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), r100));
    }

    public final void setTrackTintList(ColorStateList r100) {
        Intrinsics.checkNotNullParameter(r100, "tint");
        this.f285452t = r100;
        this.f285453u = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        if (super.verifyDrawable(r100) == false) goto L5;
    L10:
        return true;
    L5:
        if (r100 == this.f285442j) goto L10;
        if (r100 == this.f285451s) goto L10;
        return false;
    }

    public UDSwitch(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float r100, float r101) {
        super.drawableHotspotChanged(r100, r101);
        Drawable r102 = this.f285442j;
        if (r102 == null) goto L5;
        Intrinsics.checkNotNull(r102);
        DrawableCompat.setHotspot(r102, r100, r101);
    L5:
        Drawable r103 = this.f285451s;
        if (r103 == null) goto L9;
        Intrinsics.checkNotNull(r103);
        DrawableCompat.setHotspot(r103, r100, r101);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r100, int r101) {
        Rect r102 = this.f285455w;
        Drawable r103 = this.f285442j;
        int r104 = 0;
        if (r103 == null) goto L5;
        Intrinsics.checkNotNull(r103);
        r103.getPadding(r102);
        Drawable r105 = this.f285442j;
        Intrinsics.checkNotNull(r105);
        int r106 = (r105.getIntrinsicWidth() - r102.left) - r102.right;
        Drawable r107 = this.f285442j;
        Intrinsics.checkNotNull(r107);
        int r108 = r107.getIntrinsicHeight();
    L6:
        this.f285441i = r106;
        Drawable r109 = this.f285451s;
        if (r109 == null) goto L9;
        Intrinsics.checkNotNull(r109);
        r109.getPadding(r102);
        Drawable r110 = this.f285451s;
        Intrinsics.checkNotNull(r110);
        r104 = r110.getIntrinsicHeight();
    L10:
        int r111 = r102.left;
        int r112 = r102.right;
        Drawable r113 = this.f285442j;
        if (r113 == null) goto L13;
        Rect r114 = h18.a.b(r113);
        r111 = Math.max(r111, r114.left);
        r112 = Math.max(r112, r114.right);
    L13:
        int r115 = (int) Math.max(this.f285454v * 1.0f, ((this.f285441i * 1.6f) + r111) + r112);
        int r116 = Math.max(r104, r108);
        this.f285433a = r115;
        this.f285434b = r116;
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

    public UDSwitch(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 0);
    }

    public UDSwitch(Context r100, AttributeSet r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, com.larus.nova.R.style.UDSwitch);
        this.f285449q = VelocityTracker.obtain();
        this.f285455w = new Rect();
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.thumb, com.larus.nova.R.attr.ud_switch_minWidth, com.larus.nova.R.attr.ud_switch_thumbTint, com.larus.nova.R.attr.ud_switch_track, com.larus.nova.R.attr.ud_switch_trackTint}, r102, com.larus.nova.R.style.UDSwitch);
        this.f285442j = r104.getDrawable(0);
        ColorStateList r105 = r104.getColorStateList(2);
        this.f285443k = r105;
        if (r105 == null) goto L5;
        this.f285444l = true;
        a();
    L5:
        this.f285451s = r104.getDrawable(3);
        this.f285452t = r104.getColorStateList(4);
        if (this.f285443k == null) goto L8;
        this.f285453u = true;
        b();
    L8:
        this.f285454v = r104.getDimensionPixelSize(1, 0);
        r104.recycle();
        ViewConfiguration r106 = ViewConfiguration.get(r100);
        this.f285446n = r106.getScaledTouchSlop();
        this.f285450r = r106.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = 0;
        if (this.f285442j == null) goto L9;
        Rect r106 = this.f285455w;
        Drawable r107 = this.f285451s;
        if (r107 == null) goto L7;
        Intrinsics.checkNotNull(r107);
        r107.getPadding(r106);
    L8:
        Rect r108 = h18.a.b(this.f285442j);
        int r109 = Math.max(0, r108.left - r106.left);
        r105 = Math.max(0, r108.right - r106.right);
    L11:
        if (h.a(this) == false) goto L13;
        int r110 = getPaddingLeft() + r109;
        int r111 = ((this.f285433a + r110) - r109) - r105;
    L14:
        int r112 = getGravity() & 112;
        if (r112 != 16) goto L17;
        int r113 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
        int r114 = this.f285434b;
        int r115 = r113 - (r114 / 2);
    L24:
        int r116 = r114 + r115;
    L25:
        this.f285435c = r110;
        this.f285436d = r115;
        this.f285438f = r116;
        this.f285437e = r111;
        return;
    L17:
        if (r112 != 48) goto L19;
        r115 = getPaddingTop();
        r114 = this.f285434b;
        goto L24
    L19:
        if (r112 == 80) goto L21;
        r115 = getPaddingTop();
        r114 = this.f285434b;
        goto L24
    L21:
        r116 = getHeight() - getPaddingBottom();
        r115 = r116 - this.f285434b;
        goto L25
    L13:
        r111 = (getWidth() - getPaddingRight()) - r105;
        r110 = ((r111 - this.f285433a) + r109) + r105;
        goto L14
    L7:
        r106.setEmpty();
        goto L8
    L9:
        r109 = 0;
        goto L11
    }
}
