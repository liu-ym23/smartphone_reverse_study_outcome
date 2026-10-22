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
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010<\u001a\u0004\u0018\u00010;¢\u0006\u0004\b=\u0010>B\u001d\b\u0016\u0012\b\u0010<\u001a\u0004\u0018\u00010;\u0012\b\u0010@\u001a\u0004\u0018\u00010?¢\u0006\u0004\b=\u0010AB%\b\u0016\u0012\b\u0010<\u001a\u0004\u0018\u00010;\u0012\b\u0010@\u001a\u0004\u0018\u00010?\u0012\u0006\u0010B\u001a\u00020\t¢\u0006\u0004\b=\u0010CJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R*\u0010)\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\r\u001a\u0004\b'\u0010\u000f\"\u0004\b(\u0010\u0011R$\u00100\u001a\u00020*2\u0006\u0010+\u001a\u00020*8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\"\u00104\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\r\u001a\u0004\b2\u0010\u000f\"\u0004\b3\u0010\u0011R\u0011\u00108\u001a\u0002058F¢\u0006\u0006\u001a\u0004\b6\u00107R\u0011\u0010:\u001a\u0002058F¢\u0006\u0006\u001a\u0004\b9\u00107¨\u0006D"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/CustomizedUISeekBar;", "Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/NoAnchorSeekBar;", "", "show", "", "setBufferLoading", "", "progress", "setProgress", "", RemoteMessageConst.Notification.VISIBILITY, "setVisibility", OfficeSDKRequestTag.KEY_NEW_USER, "Z", "getHasTouchDelegate", "()Z", "setHasTouchDelegate", "(Z)V", "hasTouchDelegate", "r", "Ljava/lang/Float;", "getPlayerProgress", "()Ljava/lang/Float;", "setPlayerProgress", "(Ljava/lang/Float;)V", "playerProgress", "s", "I", "getScreenWidth", "()I", "setScreenWidth", "(I)V", "screenWidth", BaseSwitches.V, "getCanModifyAlpha", "setCanModifyAlpha", "canModifyAlpha", "value", "w", "getEnableAutoHide", "setEnableAutoHide", "enableAutoHide", "Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/SeekBarAnimateState;", "<set-?>", FaceService.girlLabel, "Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/SeekBarAnimateState;", "getCurrentAnimateState", "()Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/SeekBarAnimateState;", "currentAnimateState", "J", "getRestrictDyWhenDrag", "setRestrictDyWhenDrag", "restrictDyWhenDrag", "Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/SeekBarState$State;", "getState", "()Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/SeekBarState$State;", "state", "getPreviousState", "previousState", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
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

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f193589J;
    public yx3.b K;
    public boolean L;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f193590m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f193591n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f193592o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f193593p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f193594q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Float f193595r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f193596s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f193597t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f193598u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f193599v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f193600w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final SeekBarState f193601x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final SeekBarAnimateState f193602y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final SeekBarAnimateState f193603z;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f193604a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f193605b = null;

        static {
            int[] r100 = new int[SeekBarState.Action.values().length];
            r100[SeekBarState.Action.VIDEO_CHANGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L37:
            r100[SeekBarState.Action.RENDER_FIRST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L51:
            r100[SeekBarState.Action.RESUME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L39:
            r100[SeekBarState.Action.TIMEOUT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L41:
            r100[SeekBarState.Action.PAUSE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L31:
            r100[SeekBarState.Action.SEARCH_SEEK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L43:
            r100[SeekBarState.Action.RELEASE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L13:
            f193604a = r100;
            int[] r101 = new int[SeekBarState.State.values().length];
            r101[SeekBarState.State.FROZEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L35:
            r101[SeekBarState.State.DEFAULT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L45:
            r101[SeekBarState.State.ACTIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L33:
            r101[SeekBarState.State.DRAGGING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L18:
            f193605b = r101;
        }
    }

    public static final class b implements com.bytedance.awemeopen.apps.framework.utils.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomizedUISeekBar f193606a;

        @Override // com.bytedance.awemeopen.apps.framework.utils.a.b
        public final void onAppBackground() {
        }

        @Override // com.bytedance.awemeopen.apps.framework.utils.a.b
        public final void onAppForeground() {
            final CustomizedUISeekBar r100 = this.f193606a;
            r100.post(new c(r100));
        }

        public b(CustomizedUISeekBar r100) {
            this.f193606a = r100;
        }
    }

    public final void f() {
        if (this.f193600w == true) goto L6;
        return;
    L6:
        if (getVisibility() == 0) goto L8;
        setVisibility(0);
    L8:
        setAlpha(0.0f);
    }

    public final SeekBarState.State getPreviousState() {
        return this.f193601x.f193646c;
    }

    public final SeekBarState.State getState() {
        return this.f193601x.f193645b;
    }

    public final void h() {
        if (this.f193600w == true) goto L6;
        return;
    L6:
        if (getVisibility() == 0) goto L8;
        setVisibility(0);
    L8:
        setAlpha(1.0f);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onDetachedFromWindow() {
        yx3.b r100 = this.K;
        if (r100 == null) goto L6;
        r100.d(false);
    L6:
        super.onDetachedFromWindow();
    }

    public final boolean getCanModifyAlpha() {
        return this.f193599v;
    }

    public final SeekBarAnimateState getCurrentAnimateState() {
        return this.F;
    }

    public final boolean getEnableAutoHide() {
        return this.f193600w;
    }

    public final boolean getHasTouchDelegate() {
        return this.f193591n;
    }

    public final Float getPlayerProgress() {
        return this.f193595r;
    }

    public final boolean getRestrictDyWhenDrag() {
        return this.f193589J;
    }

    public final int getScreenWidth() {
        return this.f193596s;
    }

    public CustomizedUISeekBar(Context r100) {
        this(r100, null);
    }

    public final void c(SeekBarAnimateState r100) {
        if (this.f193599v == false) goto L9;
        Lazy<h> r101 = SeekBarAnimateState.f193619p;
        if (Intrinsics.areEqual(r100, SeekBarAnimateState.f193626w) == false) goto L7;
        float r102 = Math.max(r100.f193629b, 0.6f);
    L8:
        setAlpha(r102);
        goto L9
    L7:
        r102 = r100.f193629b;
    L9:
        ViewGroup.LayoutParams r103 = getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
        int r105 = r100.f193631d;
        r104.leftMargin = r105;
        r104.rightMargin = r105;
        r104.height = r100.f193632e;
        GradientDrawable r106 = this.E;
        if (r106 == null) goto L13;
        r106.setAlpha(r100.f193635h);
    L13:
        GradientDrawable r107 = this.E;
        if (r107 == null) goto L16;
        r107.setSize(r100.f193636i, r100.f193637j);
    L16:
        LayerDrawable r108 = this.D;
        if (r108 == null) goto L36;
        int r109 = r108.getNumberOfLayers();
        int r110 = 0;
    L19:
        if (r110 >= r109) goto L36;
        if (r108.getId(r110) != this.B) goto L24;
        r108.getDrawable(r110).setAlpha(r100.f193633f);
    L35:
        r110 = r110 + 1;
        goto L19
    L24:
        if (r108.getId(r110) != this.C) goto L35;
        Drawable r111 = r108.getDrawable(r110);
        if ((r111 instanceof GradientDrawable) == false) goto L28;
        GradientDrawable r112 = (GradientDrawable) r111;
    L29:
        if (r112 == null) goto L35;
        r112.setColor(r100.f193634g);
        if (r100.f193639l == false) goto L33;
        int r113 = 2;
    L34:
        r112.setStroke(r113, 352321535);
        goto L35
    L33:
        r113 = 0;
        goto L34
    L28:
        r112 = null;
    L36:
        setTranslationY(r100.f193638k);
        requestLayout();
    }

    public final void d(SeekBarState.Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        SeekBarState r101 = this.f193601x;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "action");
        SeekBarState.State r102 = r101.f193645b;
        switch(SeekBarState.a.f193650b[r100.ordinal()]) {
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
        SeekBarState.State r103 = r101.f193645b;
        if (SeekBarState.a.f193649a[r103.ordinal()] != 1) goto L9;
        SeekBarState.State r104 = SeekBarState.State.ACTIVE;
    L37:
        r101.f193645b = r104;
        r100.name();
        r102.name();
        r101.f193645b.name();
        SeekBarState.State r105 = r101.f193645b;
        if (r102 == r105) goto L40;
    L41:
        r101.f193646c = r102;
        r101.f193644a.invoke(r105, r100);
        return;
    L40:
        if (r100 == SeekBarState.Action.VIDEO_CHANGE) goto L41;
        return;
    L9:
        r104 = r101.f193645b;
        goto L37
    L10:
        SeekBarState.State r106 = r101.f193645b;
        if (SeekBarState.a.f193649a[r106.ordinal()] != 2) goto L13;
        r104 = SeekBarState.State.DEFAULT;
        goto L37
    L13:
        r104 = r101.f193645b;
        goto L37
    L14:
        SeekBarState.State r107 = r101.f193645b;
        if (SeekBarState.a.f193649a[r107.ordinal()] != 2) goto L17;
        r104 = SeekBarState.State.DEFAULT;
        goto L37
    L17:
        r104 = r101.f193645b;
        goto L37
    L18:
        SeekBarState.State r108 = r101.f193645b;
        if (SeekBarState.a.f193649a[r108.ordinal()] != 3) goto L21;
        r104 = SeekBarState.State.ACTIVE;
        goto L37
    L21:
        r104 = r101.f193645b;
        goto L37
    L22:
        SeekBarState.State r109 = r101.f193645b;
        int r110 = SeekBarState.a.f193649a[r109.ordinal()];
        if (r110 == 1) goto L26;
        if (r110 == 2) goto L26;
        r104 = r101.f193645b;
    L26:
        r104 = SeekBarState.State.DRAGGING;
        goto L37
    L27:
        SeekBarState.State r111 = r101.f193645b;
        if (SeekBarState.a.f193649a[r111.ordinal()] != 2) goto L30;
        r104 = SeekBarState.State.DEFAULT;
        goto L37
    L30:
        r104 = r101.f193645b;
        goto L37
    L31:
        SeekBarState.State r112 = r101.f193645b;
        if (SeekBarState.a.f193649a[r112.ordinal()] != 1) goto L34;
        r104 = SeekBarState.State.ACTIVE;
        goto L37
    L34:
        r104 = r101.f193645b;
        goto L37
    L35:
        r104 = SeekBarState.State.DEFAULT;
        goto L37
    L36:
        r104 = SeekBarState.State.FROZEN;
        goto L37
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final void e(final SeekBarAnimateState r100) {
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r101.setDuration(r100.f193630c);
        r101.setInterpolator(r100.f193640m);
        final SeekBarAnimateState r102 = SeekBarAnimateState.b(this.F, 0, 0, 0, 0, 32767);
        r101.addUpdateListener(new com.bytedance.awemeopen.apps.framework.base.view.seekbar.b(r102, r100, this));
        r101.start();
        this.G = r101;
    }

    public final void g(Context r100) {
        this.f193596s = d0.d(r100);
        Resources r101 = Resources.getSystem();
        MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics())));
        if (r100 == null) goto L6;
        this.H = ContextCompat.getDrawable(r100, R.drawable.aos_common_feed_video_seek_bar_layer_stable_progress);
        this.I = ContextCompat.getDrawable(r100, R.drawable.aos_common_feed_seek_bar_middle_circle_transparent);
        Drawable r102 = ContextCompat.getDrawable(r100, R.drawable.aos_common_feed_video_seek_bar_experiment_style);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        this.D = (LayerDrawable) r102;
        Drawable r103 = ContextCompat.getDrawable(r100, R.drawable.aos_common_feed_video_seek_bar_thumb_experiment_style);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        this.E = (GradientDrawable) r103;
        ContextCompat.getDrawable(r100, R.drawable.aos_common_feed_seek_bar_middle_circle_big);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.seekbar.NoAnchorSeekBar, android.widget.AbsSeekBar, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L5;
        r100.getAction();
    L5:
        getVisibility();
        if (r100 != null) goto L9;
        return false;
    L9:
        if (isShown() == true) goto L11;
    L45:
        return false;
    L11:
        if (this.f193601x.f193645b == SeekBarState.State.FROZEN) goto L45;
        int r101 = r100.getAction();
        if (r101 == 0) goto L42;
        if (r101 == 1) goto L39;
        if (r101 != 2) goto L19;
        boolean r102 = this.f193589J;
        if (r102 == false) goto L28;
        if (r102 == true) goto L25;
    L27:
        boolean r103 = false;
    L30:
        if (this.f193592o == false) goto L32;
    L36:
        this.f193592o = true;
        super.onTouchEvent(r100);
        return true;
    L32:
        if (Math.abs(this.f193593p - r100.getRawX()) <= getScaledTouchSlop()) goto L35;
        if (r103 == true) goto L36;
    L35:
        this.f193592o = false;
        return false;
    L25:
        if (Math.abs(this.f193594q - r100.getRawY()) >= 10.0f) goto L27;
    L28:
        r103 = true;
        goto L30
    L19:
        if (r101 == 3) goto L39;
    L44:
        return !this.f193591n;
    L39:
        if (this.f193592o == false) goto L47;
        super.onTouchEvent(r100);
        this.f193592o = false;
        return true;
    L47:
        return false;
    L42:
        int r104 = this.f193597t;
        int r105 = this.f193598u;
        Resources r106 = Resources.getSystem();
        int r107 = MathKt.roundToInt(TypedValue.applyDimension(1, 20, WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics())));
        new Rect(r104 - r107, r105 - r107, r104 + r107, r105 + r107).contains((int) r100.getX(), (int) r100.getRawY());
        this.f193592o = false;
        this.f193593p = r100.getRawX();
        this.f193594q = r100.getRawY();
        super.onTouchEvent(r100);
        goto L44
    }

    public final void setBufferLoading(boolean r100) {
        if (this.f193600w == true) goto L5;
    L17:
        yx3.b r101 = this.K;
        if (r101 != null) goto L20;
        r101 = new yx3.b(this);
        this.K = r101;
    L20:
        r101.d(r100);
        return;
    L5:
        if (r100 == false) goto L13;
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

    public final void setCanModifyAlpha(boolean r100) {
        this.f193599v = r100;
    }

    public final void setEnableAutoHide(boolean r100) {
        this.f193600w = r100;
        if (r100 == false) goto L8;
        this.f193599v = false;
        if (getVisibility() == 0) goto L7;
        setVisibility(0);
    L7:
        f();
        return;
    L8:
        this.f193599v = true;
        setAlpha(1.0f);
        c(this.F);
    }

    public final void setHasTouchDelegate(boolean r100) {
        this.f193591n = r100;
    }

    public final void setPlayerProgress(Float r100) {
        this.f193595r = r100;
    }

    public final void setProgress(float r100) {
        this.f193595r = Float.valueOf(r100);
        if (Build.VERSION.SDK_INT < 24) goto L5;
        setProgress((int) (r100 * 100.0f), false);
    L6:
        this.f193597t = (int) ((this.f193596s * (r100 / 100.0f)) + (this.F.f193636i / 2.0f));
        this.f193598u = (getTop() + getBottom()) / 2;
        return;
    L5:
        setProgress((int) (r100 * 100.0f));
        goto L6
    }

    public final void setRestrictDyWhenDrag(boolean r100) {
        this.f193589J = r100;
    }

    public final void setScreenWidth(int r100) {
        this.f193596s = r100;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        Intrinsics.checkNotNullParameter("visible  " + r100, "msg");
    }

    public CustomizedUISeekBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public CustomizedUISeekBar(Context r100, AttributeSet r101, int r102) {
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f193590m = "CustomizedUISeekBar";
        this.f193599v = true;
        this.f193601x = new SeekBarState(new CustomizedUISeekBar$seekBarState$1(this));
        if (getResources().getConfiguration().orientation != 2) goto L5;
        boolean r103 = true;
    L6:
        Lazy<h> r104 = SeekBarAnimateState.f193619p;
        if (r103 == false) goto L9;
        SeekBarAnimateState r105 = SeekBarAnimateState.f193623t;
    L10:
        this.f193602y = r105;
        if (r103 == false) goto L13;
        SeekBarAnimateState r106 = SeekBarAnimateState.f193624u;
    L14:
        this.f193603z = r106;
        if (r103 == false) goto L17;
        SeekBarAnimateState r107 = SeekBarAnimateState.f193625v;
    L18:
        this.A = r107;
        this.B = getResources().getIdentifier("progress", "id", "android");
        this.C = getResources().getIdentifier("background", "id", "android");
        this.F = r105;
        b r108 = new b(this);
        this.f193589J = true;
        g(r100);     // Catch: Throwable -> L21
        com.bytedance.awemeopen.apps.framework.utils.a.a(r108);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        AoLogger.c(this.f193590m, new Object[]{th});
        return;
    L17:
        r107 = SeekBarAnimateState.f193622s;
        goto L18
    L13:
        r106 = SeekBarAnimateState.f193621r;
        goto L14
    L9:
        r105 = SeekBarAnimateState.f193620q;
        goto L10
    L5:
        r103 = false;
        goto L6
    }
}
