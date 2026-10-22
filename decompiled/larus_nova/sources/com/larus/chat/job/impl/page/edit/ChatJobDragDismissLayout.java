package com.larus.chat.job.impl.page.edit;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.common.result.recycler.ECSaasScrollViewController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001f\u001a\u00020\fH\u0014J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H\u0002J\u0006\u0010$\u001a\u00020\fJ\b\u0010%\u001a\u00020\fH\u0002J\b\u0010&\u001a\u00020\u0012H\u0002J\b\u0010'\u001a\u00020\fH\u0002J\b\u0010(\u001a\u00020\fH\u0002J\u0018\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u0012H\u0002J\u0018\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u0012H\u0002J\u0010\u00102\u001a\u00020+2\u0006\u00100\u001a\u00020\u0012H\u0002J\n\u00103\u001a\u0004\u0018\u000104H\u0002J\u001a\u00105\u001a\u0004\u0018\u00010\u001e2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0002J\"\u00108\u001a\u0004\u0018\u00010\u001e2\u0006\u00109\u001a\u0002042\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0002R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/larus/chat/job/impl/page/edit/ChatJobDragDismissLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onDragDismiss", "Lkotlin/Function0;", "", "getOnDragDismiss", "()Lkotlin/jvm/functions/Function0;", "setOnDragDismiss", "(Lkotlin/jvm/functions/Function0;)V", "density", "", "touchSlop", "downX", "downY", ECSaasScrollViewController.SEARCH_SCROLL_STATE_DRAGGING, "", "dismissing", "scrimAnimator", "Landroid/animation/ValueAnimator;", "velocityTracker", "Landroid/view/VelocityTracker;", "touchedScrollableEditText", "Landroid/widget/EditText;", "onFinishInflate", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "cancelChildTouch", "resetDrag", "settleDrag", "currentYVelocity", "recycleVelocityTracker", "resetScrim", "fadeOutScrim", "duration", "", "interpolator", "Landroid/view/animation/AccelerateInterpolator;", "dismissThreshold", "dismissDuration", "currentTranslation", "yVelocity", "resetDuration", "activeDragTarget", "Landroid/view/View;", "findScrollableEditText", "rawX", "rawY", "findScrollableEditTextUnder", "view", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatJobDragDismissLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f325150k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f325151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f325152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f325153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f325154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f325155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f325156f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f325157g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ValueAnimator f325158h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public VelocityTracker f325159i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public EditText f325160j;

    public static final class a {
    }

    static {
    }

    public ChatJobDragDismissLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChatJobDragDismissLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public static /* synthetic */ void R5(ChatJobDragDismissLayout r100) {
        settleDrag$lambda$2(r100);
    }

    public final float T5() {
        return Math.max(this.f325153c * 4.0f, Math.min(getHeight() * 0.18f, this.f325152b * 160.0f));
    }

    public final void Y5() {
        ValueAnimator r100 = this.f325158h;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f325158h = null;
        Drawable r101 = getBackground();
        if (r101 == null) goto L9;
        r101.setAlpha(255);
        return;
    }

    public final View S5() {
        int r100 = getChildCount();
    L3:
        r100 = r100 - 1;
        if ((-1) >= r100) goto L9;
        View r101 = getChildAt(r100);
        if (r101.getVisibility() != 0) goto L3;
        return r101;
    L9:
        return null;
    }

    public final void V5() {
        View r100 = S5();
        if (r100 == null) goto L7;
        ViewPropertyAnimator r101 = r100.animate();
        if (r101 == null) goto L7;
        r101.cancel();
    L7:
        View r102 = S5();
        if (r102 == null) goto L10;
        r102.setTranslationY(0.0f);
    L10:
        Y5();
        this.f325156f = false;
        this.f325157g = false;
        this.f325160j = null;
        VelocityTracker r103 = this.f325159i;
        if (r103 == null) goto L13;
        r103.recycle();
    L13:
        this.f325159i = null;
        ViewParent r104 = getParent();
        if (r104 == null) goto L17;
        r104.requestDisallowInterceptTouchEvent(false);
        return;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        Drawable r100 = getBackground();
        if (r100 == null) goto L7;
        Drawable r101 = r100.mutate();
        if (r101 == null) goto L7;
        setBackground(r101);
    L7:
        Y5();
    }

    public final Function0<Unit> getOnDragDismiss() {
        return this.f325151a;
    }

    private static final void settleDrag$lambda$2(ChatJobDragDismissLayout r100) {
        r100.f325157g = false;
        Function0<Unit> r101 = r100.f325151a;
        if (r101 == null) goto L6;
        r101.invoke();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (this.f325157g == false) goto L5;
        return true;
    L5:
        int r100 = r110.getActionMasked();
        boolean r101 = false;
        if (r100 != 0) goto L8;
        View r102 = S5();
        if (r102 == null) goto L98;
        ViewPropertyAnimator r103 = r102.animate();
        if (r103 == null) goto L98;
        r103.cancel();
    L98:
        Y5();
        this.f325154d = r110.getRawX();
        this.f325155e = r110.getRawY();
        this.f325156f = false;
        this.f325160j = U5(this, (int) r110.getRawX(), (int) r110.getRawY());
        VelocityTracker r104 = this.f325159i;
        if (r104 == null) goto L101;
        r104.recycle();
    L101:
        VelocityTracker r105 = VelocityTracker.obtain();
        this.f325159i = r105;
        if (r105 == null) goto L105;
        r105.addMovement(r110);
    L105:
        return super.dispatchTouchEvent(r110);
    L8:
        if (r100 == 1) goto L50;
        if (r100 == 2) goto L15;
        if (r100 != 3) goto L105;
        V5();
        goto L105
    L15:
        if (this.f325157g == false) goto L17;
        return true;
    L17:
        VelocityTracker r106 = this.f325159i;
        if (r106 == null) goto L20;
        r106.addMovement(r110);
    L20:
        float r107 = r110.getRawX() - this.f325154d;
        float r108 = r110.getRawY() - this.f325155e;
        if (this.f325156f == true) goto L35;
        EditText r109 = this.f325160j;
        int r111 = this.f325153c;
        if (r109 == null) goto L31;
        float r112 = r111;
        if (r108 >= (-r112)) goto L29;
        r101 = r109.canScrollVertically(1);
        goto L31
    L29:
        if (r108 <= r112) goto L31;
        r101 = r109.canScrollVertically(-1);
    L31:
        if (r101 == false) goto L35;
        return super.dispatchTouchEvent(r110);
    L35:
        if (this.f325156f == true) goto L44;
        if (r108 <= this.f325153c) goto L44;
        if (r108 <= Math.abs(r107)) goto L44;
        this.f325156f = true;
        MotionEvent r113 = MotionEvent.obtain(r110);
        r113.setAction(3);
        super.dispatchTouchEvent(r113);
        r113.recycle();
        ViewParent r114 = getParent();
        if (r114 == null) goto L44;
        r114.requestDisallowInterceptTouchEvent(true);
    L44:
        if (this.f325156f == false) goto L105;
        View r115 = S5();
        if (r115 == null) goto L48;
        r115.setTranslationY(Math.max(0.0f, r108));
    L48:
        return true;
    L50:
        if (this.f325156f == false) goto L86;
        View r116 = S5();
        if (r116 != null) goto L54;
        V5();
    L85:
        return true;
    L54:
        VelocityTracker r117 = this.f325159i;
        if (r117 != null) goto L57;
        float r118 = 0.0f;
    L58:
        this.f325156f = false;
        VelocityTracker r119 = this.f325159i;
        if (r119 == null) goto L61;
        r119.recycle();
    L61:
        this.f325159i = null;
        ViewParent r120 = getParent();
        if (r120 == null) goto L64;
        r120.requestDisallowInterceptTouchEvent(false);
    L64:
        long r121 = 120;
        if (r116.getTranslationY() < T5()) goto L67;
    L70:
        this.f325157g = true;
        float r122 = r116.getTranslationY();
        if (r118 > 1600.0f) goto L74;
        r121 = (long) (140 + (80 * (1.0f - RangesKt.coerceIn(r122 / RangesKt.coerceAtLeast(getHeight(), 1), 0.0f, 1.0f))));
    L74:
        AccelerateInterpolator r123 = new AccelerateInterpolator();
        if (r116.getId() != R.id.larus_chat_job_edit_content) goto L84;
        ValueAnimator r124 = this.f325158h;
        if (r124 == null) goto L79;
        r124.cancel();
    L79:
        int[] r125 = new int[2];
        Drawable r126 = getBackground();
        if (r126 == null) goto L82;
        int r127 = r126.getAlpha();
    L83:
        r125[0] = r127;
        r125[1] = 0;
        ValueAnimator r128 = ValueAnimator.ofInt(r125);
        r128.setDuration(r121);
        r128.setInterpolator(r123);
        r128.addUpdateListener(new d(this));
        r128.start();
        this.f325158h = r128;
        goto L84
    L82:
        r127 = 255;
    L84:
        r116.animate().translationY(getHeight()).setDuration(r121).setInterpolator(r123).withEndAction(new c(this)).start();
        goto L85
    L67:
        if (r118 > 1600.0f) goto L70;
        r116.animate().translationY(0.0f).setDuration((long) (120 + (100 * RangesKt.coerceIn(r116.getTranslationY() / T5(), 0.0f, 1.0f)))).setInterpolator(new DecelerateInterpolator()).start();
        goto L85
    L57:
        r117.computeCurrentVelocity(1000);
        r118 = r117.getYVelocity();
        goto L58
    L86:
        VelocityTracker r129 = this.f325159i;
        if (r129 == null) goto L89;
        r129.recycle();
    L89:
        this.f325159i = null;
        ViewParent r130 = getParent();
        if (r130 == null) goto L92;
        r130.requestDisallowInterceptTouchEvent(false);
    L92:
        this.f325160j = null;
        goto L105
    }

    public final void setOnDragDismiss(Function0<Unit> r100) {
        this.f325151a = r100;
    }

    public ChatJobDragDismissLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Resources r103 = getResources();
        this.f325152b = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density;
        this.f325153c = ViewConfiguration.get(r100).getScaledTouchSlop();
    }

    public static EditText U5(View r100, int r101, int r102) {
        if (r100.getVisibility() != 0) goto L31;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int[] r103 = new int[2];
        r100.getLocationOnScreen(r103);
        boolean r104 = false;
        int r105 = r103[0];
        if (r101 >= r105) goto L7;
    L13:
        if (r104 == true) goto L16;
        return null;
    L16:
        if ((r100 instanceof EditText) == false) goto L24;
        if (r100.canScrollVertically(-1) == true) goto L22;
        if (r100.canScrollVertically(1) == false) goto L24;
    L22:
        return (EditText) r100;
    L24:
        if ((r100 instanceof ViewGroup) == false) goto L35;
        ViewGroup r106 = (ViewGroup) r100;
        int r107 = r106.getChildCount() - 1;
    L26:
        if ((-1) >= r107) goto L37;
        EditText r108 = U5(r106.getChildAt(r107), r101, r102);
        if (r108 != null) goto L29;
        r107 = r107 - 1;
        goto L26
    L29:
        return r108;
    L37:
        return null;
    L35:
        return null;
    L7:
        if (r101 >= (r105 + r100.getWidth())) goto L13;
        int r109 = r103[1];
        if (r102 < r109) goto L13;
        if (r102 >= (r109 + r100.getHeight())) goto L13;
        r104 = true;
        goto L13
    L31:
        return null;
    }

    public /* synthetic */ ChatJobDragDismissLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
