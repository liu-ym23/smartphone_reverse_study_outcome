package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010<\u001a\u0004\u0018\u00010;¢\u0006\u0004\b=\u0010>B\u001d\b\u0016\u0012\b\u0010<\u001a\u0004\u0018\u00010;\u0012\b\u0010@\u001a\u0004\u0018\u00010?¢\u0006\u0004\b=\u0010AB%\b\u0016\u0012\b\u0010<\u001a\u0004\u0018\u00010;\u0012\b\u0010@\u001a\u0004\u0018\u00010?\u0012\u0006\u0010B\u001a\u00020\t¢\u0006\u0004\b=\u0010CJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R*\u0010)\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\r\u001a\u0004\b'\u0010\u000f\"\u0004\b(\u0010\u0011R$\u00100\u001a\u00020*2\u0006\u0010+\u001a\u00020*8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\"\u00104\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\r\u001a\u0004\b2\u0010\u000f\"\u0004\b3\u0010\u0011R\u0011\u00108\u001a\u0002058F¢\u0006\u0006\u001a\u0004\b6\u00107R\u0011\u0010:\u001a\u0002058F¢\u0006\u0006\u001a\u0004\b9\u00107¨\u0006D"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/CustomizedUISeekBar;", "Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/NoAnchorSeekBar;", "", "show", "", "setBufferLoading", "", "progress", "setProgress", "", "visibility", "setVisibility", "n", "Z", "getHasTouchDelegate", "()Z", "setHasTouchDelegate", "(Z)V", "hasTouchDelegate", "r", "Ljava/lang/Float;", "getPlayerProgress", "()Ljava/lang/Float;", "setPlayerProgress", "(Ljava/lang/Float;)V", "playerProgress", "s", "I", "getScreenWidth", "()I", "setScreenWidth", "(I)V", "screenWidth", "v", "getCanModifyAlpha", "setCanModifyAlpha", "canModifyAlpha", "value", "w", "getEnableAutoHide", "setEnableAutoHide", "enableAutoHide", "Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/SeekBarAnimateState;", "<set-?>", "F", "Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/SeekBarAnimateState;", "getCurrentAnimateState", "()Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/SeekBarAnimateState;", "currentAnimateState", "J", "getRestrictDyWhenDrag", "setRestrictDyWhenDrag", "restrictDyWhenDrag", "Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/SeekBarState$State;", "getState", "()Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/SeekBarState$State;", "state", "getPreviousState", "previousState", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CustomizedUISeekBar extends NoAnchorSeekBar {
    public static final /* synthetic */ int M = 0;
    public final SeekBarAnimateState A;
    public final int B;
    public final int C;
    public LayerDrawable D;
    public GradientDrawable E;
    public SeekBarAnimateState F;
    public Animator G;
    public Drawable H;
    public Drawable I;
    public boolean J;
    public yx3.b K;
    public boolean L;
    public final String m;
    public boolean n;
    public boolean o;
    public float p;
    public float q;
    public Float r;
    public int s;
    public int t;
    public int u;
    public boolean v;
    public boolean w;
    public final SeekBarState x;
    public final SeekBarAnimateState y;
    public final SeekBarAnimateState z;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[SeekBarState.Action.values().length];
            r0[SeekBarState.Action.VIDEO_CHANGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[SeekBarState.Action.RENDER_FIRST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L51:
            r0[SeekBarState.Action.RESUME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L39:
            r0[SeekBarState.Action.TIMEOUT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L41:
            r0[SeekBarState.Action.PAUSE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L31:
            r0[SeekBarState.Action.SEARCH_SEEK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L43:
            r0[SeekBarState.Action.RELEASE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L13:
            a = r0;
            int[] r1 = new int[SeekBarState.State.values().length];
            r1[SeekBarState.State.FROZEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L35:
            r1[SeekBarState.State.DEFAULT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L45:
            r1[SeekBarState.State.ACTIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L33:
            r1[SeekBarState.State.DRAGGING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L18:
            b = r1;
        }
    }

    public static final class b implements com.bytedance.awemeopen.apps.framework.utils.a.b {
        public final /* synthetic */ CustomizedUISeekBar a;

        @Override // com.bytedance.awemeopen.apps.framework.utils.a.b
        public final void onAppBackground() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.SeekBar, com.bytedance.awemeopen.apps.framework.base.view.seekbar.CustomizedUISeekBar] */
        @Override // com.bytedance.awemeopen.apps.framework.utils.a.b
        public final void onAppForeground() {
            final ?? r0 = this.a;
            r0.post(new c(r0));
        }

        public b(CustomizedUISeekBar r1) {
            this.a = r1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f() {
        if (this.w == true) goto L6;
        return;
    L6:
        if (getVisibility() == 0) goto L8;
        setVisibility(0);
    L8:
        setAlpha(0.0f);
    }

    public final SeekBarState.State getPreviousState() {
        return this.x.c;
    }

    public final SeekBarState.State getState() {
        return this.x.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h() {
        if (this.w == true) goto L6;
        return;
    L6:
        if (getVisibility() == 0) goto L8;
        setVisibility(0);
    L8:
        setAlpha(1.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        yx3.b r0 = this.K;
        if (r0 == null) goto L6;
        r0.d(false);
    L6:
        super/*android.widget.SeekBar*/.onDetachedFromWindow();
    }

    public final boolean getCanModifyAlpha() {
        return this.v;
    }

    public final SeekBarAnimateState getCurrentAnimateState() {
        return this.F;
    }

    public final boolean getEnableAutoHide() {
        return this.w;
    }

    public final boolean getHasTouchDelegate() {
        return this.n;
    }

    public final Float getPlayerProgress() {
        return this.r;
    }

    public final boolean getRestrictDyWhenDrag() {
        return this.J;
    }

    public final int getScreenWidth() {
        return this.s;
    }

    public CustomizedUISeekBar(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(SeekBarAnimateState r8) {
        if (this.v == false) goto L9;
        Lazy<h> r0 = SeekBarAnimateState.p;
        if (Intrinsics.areEqual(r8, SeekBarAnimateState.w) == false) goto L7;
        float r1 = Math.max(r8.b, 0.6f);
    L8:
        setAlpha(r1);
        goto L9
    L7:
        r1 = r8.b;
    L9:
        ViewGroup.LayoutParams r2 = getLayoutParams();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        int r4 = r8.d;
        r3.leftMargin = r4;
        r3.rightMargin = r4;
        r3.height = r8.e;
        GradientDrawable r5 = this.E;
        if (r5 == null) goto L13;
        r5.setAlpha(r8.h);
    L13:
        GradientDrawable r6 = this.E;
        if (r6 == null) goto L16;
        r6.setSize(r8.i, r8.j);
    L16:
        LayerDrawable r7 = this.D;
        if (r7 == null) goto L36;
        int r9 = r7.getNumberOfLayers();
        int r10 = 0;
    L19:
        if (r10 >= r9) goto L36;
        if (r7.getId(r10) != this.B) goto L24;
        r7.getDrawable(r10).setAlpha(r8.f);
    L35:
        r10 = r10 + 1;
        goto L19
    L24:
        if (r7.getId(r10) != this.C) goto L35;
        Drawable r11 = r7.getDrawable(r10);
        if ((r11 instanceof GradientDrawable) == false) goto L28;
        GradientDrawable r12 = (GradientDrawable) r11;
    L29:
        if (r12 == null) goto L35;
        r12.setColor(r8.g);
        if (r8.l == false) goto L33;
        int r13 = 2;
    L34:
        r12.setStroke(r13, 352321535);
        goto L35
    L33:
        r13 = 0;
        goto L34
    L28:
        r12 = null;
    L36:
        setTranslationY(r8.k);
        requestLayout();
    }

    public final void d(SeekBarState.Action r7) {
        Intrinsics.checkNotNullParameter(r7, "action");
        SeekBarState r1 = this.x;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r7, "action");
        SeekBarState.State r0 = r1.b;
        switch(SeekBarState.a.b[r7.ordinal()]) {
            case 1: goto L36;
            case 2: goto L35;
            case 3: goto L35;
            case 4: goto L31;
            case 5: goto L27;
            case 6: goto L22;
            case 7: goto L18;
            case 8: goto L14;
            case 9: goto L10;
            case 10: goto L6;
            default: goto L5;
        };
    L6:
        SeekBarState.State r2 = r1.b;
        if (SeekBarState.a.a[r2.ordinal()] != 1) goto L9;
        SeekBarState.State r3 = SeekBarState.State.ACTIVE;
    L37:
        r1.b = r3;
        r7.name();
        r0.name();
        r1.b.name();
        SeekBarState.State r4 = r1.b;
        if (r0 == r4) goto L40;
    L41:
        r1.c = r0;
        r1.a.invoke(r4, r7);
        return;
    L40:
        if (r7 == SeekBarState.Action.VIDEO_CHANGE) goto L41;
        return;
    L9:
        r3 = r1.b;
        goto L37
    L10:
        SeekBarState.State r5 = r1.b;
        if (SeekBarState.a.a[r5.ordinal()] != 2) goto L13;
        r3 = SeekBarState.State.DEFAULT;
        goto L37
    L13:
        r3 = r1.b;
        goto L37
    L14:
        SeekBarState.State r6 = r1.b;
        if (SeekBarState.a.a[r6.ordinal()] != 2) goto L17;
        r3 = SeekBarState.State.DEFAULT;
        goto L37
    L17:
        r3 = r1.b;
        goto L37
    L18:
        SeekBarState.State r8 = r1.b;
        if (SeekBarState.a.a[r8.ordinal()] != 3) goto L21;
        r3 = SeekBarState.State.ACTIVE;
        goto L37
    L21:
        r3 = r1.b;
        goto L37
    L22:
        SeekBarState.State r9 = r1.b;
        int r10 = SeekBarState.a.a[r9.ordinal()];
        if (r10 == 1) goto L26;
        if (r10 == 2) goto L26;
        r3 = r1.b;
    L26:
        r3 = SeekBarState.State.DRAGGING;
        goto L37
    L27:
        SeekBarState.State r11 = r1.b;
        if (SeekBarState.a.a[r11.ordinal()] != 2) goto L30;
        r3 = SeekBarState.State.DEFAULT;
        goto L37
    L30:
        r3 = r1.b;
        goto L37
    L31:
        SeekBarState.State r12 = r1.b;
        if (SeekBarState.a.a[r12.ordinal()] != 1) goto L34;
        r3 = SeekBarState.State.ACTIVE;
        goto L37
    L34:
        r3 = r1.b;
        goto L37
    L35:
        r3 = SeekBarState.State.DEFAULT;
        goto L37
    L36:
        r3 = SeekBarState.State.FROZEN;
        goto L37
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final void e(final SeekBarAnimateState r9) {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r0.setDuration(r9.c);
        r0.setInterpolator(r9.m);
        final SeekBarAnimateState r1 = SeekBarAnimateState.b(this.F, 0, 0, 0, 0, 32767);
        r0.addUpdateListener(new com.bytedance.awemeopen.apps.framework.base.view.seekbar.b(r1, r9, this));
        r0.start();
        this.G = r0;
    }

    public final void g(Context r4) {
        this.s = d0.d(r4);
        Resources r1 = Resources.getSystem();
        MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics())));
        if (r4 == null) goto L6;
        this.H = ContextCompat.getDrawable(r4, 2131231421);
        this.I = ContextCompat.getDrawable(r4, 2131231419);
        Drawable r0 = ContextCompat.getDrawable(r4, 2131231420);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        this.D = (LayerDrawable) r0;
        Drawable r2 = ContextCompat.getDrawable(r4, 2131231422);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        this.E = (GradientDrawable) r2;
        ContextCompat.getDrawable(r4, 2131231417);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.base.view.seekbar.NoAnchorSeekBar
    public final boolean onTouchEvent(MotionEvent r9) {
        if (r9 == null) goto L5;
        r9.getAction();
    L5:
        getVisibility();
        if (r9 != null) goto L9;
        return false;
    L9:
        if (isShown() == true) goto L11;
    L45:
        return false;
    L11:
        if (this.x.b == SeekBarState.State.FROZEN) goto L45;
        int r1 = r9.getAction();
        if (r1 == 0) goto L42;
        if (r1 == 1) goto L39;
        if (r1 != 2) goto L19;
        boolean r2 = this.J;
        if (r2 == false) goto L28;
        if (r2 == true) goto L25;
    L27:
        boolean r3 = false;
    L30:
        if (this.o == false) goto L32;
    L36:
        this.o = true;
        super.onTouchEvent(r9);
        return true;
    L32:
        if (Math.abs(this.p - r9.getRawX()) <= getScaledTouchSlop()) goto L35;
        if (r3 == true) goto L36;
    L35:
        this.o = false;
        return false;
    L25:
        if (Math.abs(this.q - r9.getRawY()) >= 10.0f) goto L27;
    L28:
        r3 = true;
        goto L30
    L19:
        if (r1 == 3) goto L39;
    L44:
        return !this.n;
    L39:
        if (this.o == false) goto L47;
        super.onTouchEvent(r9);
        this.o = false;
        return true;
    L47:
        return false;
    L42:
        int r4 = this.t;
        int r5 = this.u;
        Resources r6 = Resources.getSystem();
        int r7 = MathKt.roundToInt(TypedValue.applyDimension(1, 20, WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics())));
        new Rect(r4 - r7, r5 - r7, r4 + r7, r5 + r7).contains((int) r9.getX(), (int) r9.getRawY());
        this.o = false;
        this.p = r9.getRawX();
        this.q = r9.getRawY();
        super.onTouchEvent(r9);
        goto L44
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setBufferLoading(boolean r3) {
        if (this.w == true) goto L5;
    L17:
        yx3.b r0 = this.K;
        if (r0 != null) goto L20;
        r0 = new yx3.b(this);
        this.K = r0;
    L20:
        r0.d(r3);
        return;
    L5:
        if (r3 == false) goto L13;
        if (this.L == true) goto L17;
        this.L = true;
        if (getVisibility() == 0) goto L11;
        setVisibility(0);
    L11:
        setAlpha(1.0f);
        goto L17
    L13:
        if (this.L == false) goto L17;
        this.L = false;
        if (getState() != SeekBarState.State.DEFAULT) goto L17;
        f();
        goto L17
    }

    public final void setCanModifyAlpha(boolean r1) {
        this.v = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setEnableAutoHide(boolean r2) {
        this.w = r2;
        if (r2 == false) goto L8;
        this.v = false;
        if (getVisibility() == 0) goto L7;
        setVisibility(0);
    L7:
        f();
        return;
    L8:
        this.v = true;
        setAlpha(1.0f);
        c(this.F);
    }

    public final void setHasTouchDelegate(boolean r1) {
        this.n = r1;
    }

    public final void setPlayerProgress(Float r1) {
        this.r = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setProgress(float r4) {
        this.r = Float.valueOf(r4);
        if (Build.VERSION.SDK_INT < 24) goto L5;
        setProgress((int) (r4 * 100.0f), false);
    L6:
        this.t = (int) ((this.s * (r4 / 100.0f)) + (this.F.i / 2.0f));
        this.u = (getTop() + getBottom()) / 2;
        return;
    L5:
        setProgress((int) (r4 * 100.0f));
        goto L6
    }

    public final void setRestrictDyWhenDrag(boolean r1) {
        this.J = r1;
    }

    public final void setScreenWidth(int r1) {
        this.s = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setVisibility(int r3) {
        super/*android.widget.SeekBar*/.setVisibility(r3);
        Intrinsics.checkNotNullParameter("visible  " + r3, "msg");
    }

    public CustomizedUISeekBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomizedUISeekBar(Context r6, AttributeSet r7, int r8) {
        new LinkedHashMap();
        super(r6, r7, r8);
        this.m = "CustomizedUISeekBar";
        this.v = true;
        this.x = new SeekBarState(new CustomizedUISeekBar$seekBarState$1(this));
        if (getResources().getConfiguration().orientation != 2) goto L5;
        boolean r9 = true;
    L6:
        Lazy<h> r0 = SeekBarAnimateState.p;
        if (r9 == false) goto L9;
        SeekBarAnimateState r1 = SeekBarAnimateState.t;
    L10:
        this.y = r1;
        if (r9 == false) goto L13;
        SeekBarAnimateState r2 = SeekBarAnimateState.u;
    L14:
        this.z = r2;
        if (r9 == false) goto L17;
        SeekBarAnimateState r10 = SeekBarAnimateState.v;
    L18:
        this.A = r10;
        this.B = getResources().getIdentifier("progress", "id", "android");
        this.C = getResources().getIdentifier("background", "id", "android");
        this.F = r1;
        b r11 = new b(this);
        this.J = true;
        g(r6);     // Catch: Throwable -> L21
        com.bytedance.awemeopen.apps.framework.utils.a.a(r11);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        AoLogger.c(this.m, new Object[]{th});
        return;
    L17:
        r10 = SeekBarAnimateState.s;
        goto L18
    L13:
        r2 = SeekBarAnimateState.r;
        goto L14
    L9:
        r1 = SeekBarAnimateState.q;
        goto L10
    L5:
        r9 = false;
        goto L6
    }
}
