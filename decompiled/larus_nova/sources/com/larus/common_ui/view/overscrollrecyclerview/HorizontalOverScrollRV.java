package com.larus.common_ui.view.overscrollrecyclerview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 92\u00020\u00012\u00020\u0002:\u000556789B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u001f\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020%H\u0014J\u0010\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u001aH\u0002J \u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010,\u001a\u00020%2\u0006\u0010)\u001a\u00020!2\u0006\u0010-\u001a\u00020\u001eH\u0002J\u0010\u0010.\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020!H\u0002J\u0010\u0010/\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020!H\u0002J \u00100\u001a\u00020%2\u0006\u0010)\u001a\u00020!2\u0006\u0010-\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u00101\u001a\u00020%H\u0007J\b\u00102\u001a\u00020%H\u0007J\u0010\u00103\u001a\u00020%2\b\u00104\u001a\u0004\u0018\u00010\fJ\u0006\u0010\r\u001a\u00020%R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00060\u0010R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00060\u0012R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0013\u001a\u00060\u0014R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/larus/common_ui/view/overscrollrecyclerview/HorizontalOverScrollRV;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/view/View$OnTouchListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "overScrollListener", "Lcom/larus/common_ui/view/overscrollrecyclerview/OverScrollListener;", "forceBackToIdle", "", "defaultState", "Lcom/larus/common_ui/view/overscrollrecyclerview/HorizontalOverScrollRV$DefaultState;", "overScrollingState", "Lcom/larus/common_ui/view/overscrollrecyclerview/HorizontalOverScrollRV$OverScrollingState;", "bouncingBackState", "Lcom/larus/common_ui/view/overscrollrecyclerview/HorizontalOverScrollRV$BounceBackState;", "getBouncingBackState", "()Lcom/larus/common_ui/view/overscrollrecyclerview/HorizontalOverScrollRV$BounceBackState;", "bouncingBackState$delegate", "Lkotlin/Lazy;", "curUIState", "Lcom/larus/common_ui/view/overscrollrecyclerview/HorizontalOverScrollRV$IUIState;", "initParam", "Lcom/larus/common_ui/view/overscrollrecyclerview/OverScrollInitParams;", "speed", "", "onTouch", BaseSwitches.V, "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "onDetachedFromWindow", "", "handleSwiftState", "state", "initMotionParams", "view", "params", "Lcom/larus/common_ui/view/overscrollrecyclerview/OffsetParams;", "moveView", "offset", "isInAbsStart", "isInAbsEnd", "moveViewWithEvent", LynxViewpagerItem.BIND_ON_ATTACH, "detach", "setOverScrollListener", "listener", "IUIState", "BounceBackState", "DefaultState", "OverScrollingState", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class HorizontalOverScrollRV extends RecyclerView implements View.OnTouchListener {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f328348h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f328349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f328350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f328351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f328352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f328353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y19.d f328354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f328355g;

    public final class a implements d, Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView f328356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final y19.a f328357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Interpolator f328358c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f328359d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f328360e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ HorizontalOverScrollRV f328361f;

        @Override // com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV.d
        public final boolean N0(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            return true;
        }

        @Override // com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV.d
        public final boolean a(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            return true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV.d
        public final void b(d r100) {
            Intrinsics.checkNotNullParameter(r100, "preUIState");
            this.f328357b.f565671c = this.f328356a.getTranslationX();
            this.f328357b.f565670b = this.f328356a.getWidth();
            y19.a r101 = this.f328357b;
            r101.f565669a = ViewGroup.TRANSLATION_X;
            HorizontalOverScrollRV r102 = this.f328361f;
            float r103 = r102.f328355g;
            if (r103 != 0.0f) goto L5;
            boolean r104 = true;
        L6:
            if (r104 == true) goto L16;
            if (r103 >= 0.0f) goto L11;
            if (r102.f328354f.f565678c == true) goto L16;
        L11:
            if (r103 > 0.0f) goto L13;
        L15:
            float r105 = RangesKt.coerceAtLeast(0.0f, (0 - r103) / this.f328359d);
            float r106 = this.f328361f.f328355g;
            float r107 = ((-r106) * r106) / this.f328360e;
            y19.a r108 = this.f328357b;
            float r109 = r107 + r108.f565671c;
            ObjectAnimator r110 = ObjectAnimator.ofFloat(this.f328356a, r108.f565669a, new float[]{r109});
            r110.setInterpolator(this.f328358c);
            r110.setDuration((int) r105);
            r110.addUpdateListener(this);
            Intrinsics.checkNotNull(r110);
            ObjectAnimator r111 = d(r109);
            AnimatorSet r112 = new AnimatorSet();
            r112.playSequentially(new Animator[]{r110, r111});
            Animator r113 = r112;
        L17:
            r113.addListener(this);
            r113.start();
            return;
        L13:
            if (r102.f328354f.f565678c == true) goto L15;
        L16:
            r113 = d(r101.f565671c);
            goto L17
        L5:
            r104 = false;
            goto L6
        }

        public final ObjectAnimator d(float r100) {
            ObjectAnimator r101 = ObjectAnimator.ofFloat(this.f328356a, this.f328357b.f565669a, new float[]{this.f328361f.f328354f.f565677b});
            float r102 = (Math.abs(r100) / this.f328357b.f565670b) * 800;
            r101.setInterpolator(this.f328358c);
            r101.setDuration(RangesKt.coerceAtLeast((int) r102, 200));
            r101.addUpdateListener(this);
            Intrinsics.checkNotNull(r101);
            return r101;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            HorizontalOverScrollRV r101 = this.f328361f;
            int r102 = HorizontalOverScrollRV.f328348h;
            r101.getClass();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            HorizontalOverScrollRV r101 = this.f328361f;
            HorizontalOverScrollRV.t(r101, r101.f328350b);
            this.f328361f.getClass();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            HorizontalOverScrollRV r101 = this.f328361f;
            int r102 = HorizontalOverScrollRV.f328348h;
            r101.getClass();
        }

        public a(HorizontalOverScrollRV r100, HorizontalOverScrollRV r101) {
            Intrinsics.checkNotNullParameter(r101, "recyclerView");
            this.f328361f = r100;
            this.f328356a = r101;
            this.f328357b = new y19.a();
            this.f328358c = new DecelerateInterpolator();
            this.f328359d = -1.0f;
            this.f328360e = -2.0f;
        }
    }

    public static final class b {
    }

    public final class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y19.c f328362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HorizontalOverScrollRV f328363b;

        @Override // com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV.d
        public final boolean a(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            return false;
        }

        @Override // com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV.d
        public final void b(d r100) {
            Intrinsics.checkNotNullParameter(r100, "preUIState");
        }

        public c(HorizontalOverScrollRV r100) {
            this.f328363b = r100;
            this.f328362a = new y19.c();
        }

        @Override // com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV.d
        public final boolean N0(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            HorizontalOverScrollRV r101 = this.f328363b;
            if (HorizontalOverScrollRV.u(r101, r101, this.f328362a, r100) == true) goto L5;
            return false;
        L5:
            HorizontalOverScrollRV r102 = this.f328363b;
            r102.getClass();
            if ((!r102.canScrollHorizontally(-1)) == true) goto L8;
        L9:
            HorizontalOverScrollRV r103 = this.f328363b;
            r103.getClass();
            if ((!r103.canScrollHorizontally(1)) == true) goto L12;
        L16:
            return false;
        L12:
            if (this.f328362a.f565673a == true) goto L16;
        L14:
            this.f328363b.f328354f.f565676a = r100.getPointerId(0);
            HorizontalOverScrollRV r104 = this.f328363b;
            y19.d r105 = r104.f328354f;
            y19.c r106 = this.f328362a;
            r105.f565677b = r106.f565674b;
            r105.f565678c = r106.f565673a;
            d r107 = r104.f328351c;
            r104.f328353e = r107;
            r107.b(r107);
            this.f328363b.getClass();
            this.f328363b.f328351c.N0(r100);
            return true;
        L8:
            if (this.f328362a.f565673a == true) goto L14;
            goto L9
        }
    }

    public interface d {
        boolean N0(MotionEvent r100);

        boolean a(MotionEvent r100);

        void b(d r100);
    }

    public final class e implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y19.c f328364a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HorizontalOverScrollRV f328365b;

        @Override // com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV.d
        public final void b(d r100) {
            Intrinsics.checkNotNullParameter(r100, "preUIState");
        }

        public e(HorizontalOverScrollRV r100) {
            this.f328365b = r100;
            this.f328364a = new y19.c();
        }

        @Override // com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV.d
        public final boolean N0(MotionEvent r110) {
            Intrinsics.checkNotNullParameter(r110, "event");
            HorizontalOverScrollRV r100 = this.f328365b;
            y19.d r101 = r100.f328354f;
            if (r100.f328349a == false) goto L7;
            float r102 = r101.f565677b;
            r100.setTranslationX(r102);
            r110.offsetLocation(r102 - r110.getX(0), 0.0f);
            HorizontalOverScrollRV r111 = this.f328365b;
            d r103 = r111.f328350b;
            r111.f328353e = r103;
            r103.b(r103);
            this.f328365b.f328349a = false;
            return true;
        L7:
            if (r101.f565676a == r110.getPointerId(0)) goto L10;
            HorizontalOverScrollRV r112 = this.f328365b;
            d r104 = HorizontalOverScrollRV.r(r112);
            r112.f328353e = r104;
            r104.b(r104);
            return true;
        L10:
            HorizontalOverScrollRV r105 = this.f328365b;
            if (HorizontalOverScrollRV.u(r105, r105, this.f328364a, r110) == true) goto L13;
            return true;
        L13:
            y19.c r106 = this.f328364a;
            float r107 = r106.f565675c / 2.0f;
            float r108 = r106.f565674b + r107;
            boolean r109 = r101.f565678c;
            if (r109 == true) goto L16;
        L19:
            if (r109 == true) goto L27;
            if (r106.f565673a == false) goto L27;
            if (r108 < r101.f565677b) goto L27;
        L24:
            HorizontalOverScrollRV r113 = this.f328365b;
            float r114 = r101.f565677b;
            r113.getClass();
            r113.setTranslationX(r114);
            r110.offsetLocation(r114 - r110.getX(0), 0.0f);
            HorizontalOverScrollRV r115 = this.f328365b;
            d r116 = r115.f328350b;
            r115.f328353e = r116;
            r116.b(r116);
            return true;
        L27:
            if (this.f328365b.getParent() == null) goto L29;
            this.f328365b.getParent().requestDisallowInterceptTouchEvent(true);
        L29:
            long r117 = r110.getEventTime() - r110.getHistoricalEventTime(0);
            if (r117 <= 0) goto L32;
            this.f328365b.f328355g = r107 / r117;
        L32:
            HorizontalOverScrollRV r118 = this.f328365b;
            r118.getClass();
            r118.setTranslationX(r108);
            return true;
        L16:
            if (r106.f565673a == true) goto L19;
            if (r108 <= r101.f565677b) goto L24;
            goto L19
        }

        @Override // com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV.d
        public final boolean a(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            HorizontalOverScrollRV r101 = this.f328365b;
            HorizontalOverScrollRV.t(r101, HorizontalOverScrollRV.r(r101));
            return false;
        }
    }

    static {
    }

    public HorizontalOverScrollRV(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HorizontalOverScrollRV(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setOverScrollListener(y19.e r100) {
    }

    private final a getBouncingBackState() {
        return (a) this.f328352d.getValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setOnTouchListener(null);
        setOverScrollMode(0);
    }

    public static final /* synthetic */ a r(HorizontalOverScrollRV r100) {
        return r100.getBouncingBackState();
    }

    public static final void t(HorizontalOverScrollRV r100, d r101) {
        r100.f328353e = r101;
        r101.b(r101);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r101 == null) goto L4;
        Integer r102 = Integer.valueOf(r101.getActionMasked());
    L5:
        if (r102 != null) goto L8;
    L10:
        if (r102 != null) goto L13;
    L14:
        if (r102 != null) goto L17;
    L19:
        return false;
    L17:
        if (r102.intValue() != 3) goto L19;
    L21:
        return this.f328353e.a(r101);
    L13:
        if (r102.intValue() == 1) goto L21;
    L8:
        if (r102.intValue() != 2) goto L10;
        return this.f328353e.N0(r101);
    L4:
        r102 = null;
        goto L5
    }

    public HorizontalOverScrollRV(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        c r103 = new c(this);
        this.f328350b = r103;
        this.f328351c = new e(this);
        this.f328352d = LazyKt.lazy(new y19.b(this));
        this.f328353e = r103;
        this.f328354f = new y19.d();
        setOnTouchListener(this);
        setOverScrollMode(2);
    }

    public /* synthetic */ HorizontalOverScrollRV(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static final boolean u(HorizontalOverScrollRV r100, HorizontalOverScrollRV r101, y19.c r102, MotionEvent r103) {
        r100.getClass();
        boolean r104 = false;
        if (r103.getHistorySize() == 0) goto L13;
        float r105 = r103.getX(0) - r103.getHistoricalX(0, 0);
        if (Math.abs(r103.getY(0) - r103.getHistoricalY(0, 0)) < Math.abs(r105)) goto L9;
        return false;
    L9:
        if (r102.f565675c <= 0.0f) goto L11;
        r104 = true;
    L11:
        r102.f565673a = r104;
        r102.f565674b = r101.getTranslationX();
        r102.f565675c = r105;
        return true;
    L13:
        return false;
    }
}
