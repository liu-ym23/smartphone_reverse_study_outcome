package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.StyleEdgeTransparentView2;
import com.bytedance.awemeopen.apps.framework.utils.b0;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import java.util.LinkedHashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003\"#$B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006J\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010R0\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/progress/StoryListProgressBar;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/progress/b;", "config", "", "setProgressBarConfig", "", "enabled", "setClickEnabled", "", "getCurrentPosition", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/progress/StoryListProgressBar$b;", "listener", "setProgressBarGestureListener", "isTouchable", "setIsTouchable", "Landroid/view/View;", "maskView", "setMaskView", "Lkotlin/Function1;", "q", "Lkotlin/jvm/functions/Function1;", "getOnProgressBarSelected", "()Lkotlin/jvm/functions/Function1;", "setOnProgressBarSelected", "(Lkotlin/jvm/functions/Function1;)V", "onProgressBarSelected", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "MaskState", "b", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class StoryListProgressBar extends LinearLayout {
    public static final /* synthetic */ int C = 0;
    public boolean A;
    public final l B;
    public int a;
    public final Context b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public final float i;
    public float j;
    public boolean k;
    public boolean l;
    public float m;
    public int n;
    public int o;
    public boolean p;
    public Function1<? super Boolean, Unit> q;
    public boolean r;
    public final Scroller s;
    public StyleEdgeTransparentView2 t;
    public MaskState u;
    public final int v;
    public final int w;
    public float x;
    public b y;
    public boolean z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/progress/StoryListProgressBar$MaskState;", "", "NONE", "ONLY_LEFT", "ONLY_RIGHT", "BOTH_SIDES", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum MaskState extends Enum<MaskState> {
        public static final MaskState BOTH_SIDES = null;
        public static final MaskState NONE = null;
        public static final MaskState ONLY_LEFT = null;
        public static final MaskState ONLY_RIGHT = null;
        public static final /* synthetic */ MaskState[] a = null;

        public static MaskState valueOf(String r1) {
            return (MaskState) r27.a.a(MaskState.class, r1);
        }

        public static MaskState[] values() {
            return (MaskState[]) a.clone();
        }

        static {
            MaskState r0 = new MaskState("NONE", 0);
            NONE = r0;
            MaskState r1 = new MaskState("ONLY_LEFT", 1);
            ONLY_LEFT = r1;
            MaskState r3 = new MaskState("ONLY_RIGHT", 2);
            ONLY_RIGHT = r3;
            MaskState r5 = new MaskState("BOTH_SIDES", 3);
            BOTH_SIDES = r5;
            a = new MaskState[]{r0, r1, r3, r5};
        }

        public MaskState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public interface b {
        void M0();

        void N0(MotionEvent r1);

        void O0(boolean r1);

        void onDown(MotionEvent r1);
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MaskState.values().length];
            r0[MaskState.ONLY_RIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[MaskState.ONLY_LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[MaskState.BOTH_SIDES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[MaskState.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ StoryListProgressBar a;
        public final /* synthetic */ int b;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            int r0 = this.a.getChildCount();
            this.a.e();
            this.a.j(r0);
            this.a.h(this.b, 0.0f);
            ViewTreeObserver r1 = this.a.getViewTreeObserver();
            if (r1 == null) goto L6;
            r1.removeOnGlobalLayoutListener(this);
            return;
        }

        public d(StoryListProgressBar r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public StoryListProgressBar(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "ctx");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public StoryListProgressBar(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "ctx");
        this(r3, r4, 4, 0);
    }

    public final void e() {
        this.c = 0;
        this.n = 0;
        this.o = 0;
        this.j = this.i;
        if (this.l == false) goto L5;
        this.r = false;
        this.h = 0;
        this.a = 0;
        this.f = 0;
        this.g = this.e - 1;
        scrollTo(0, 0);
    L5:
        f(0);
        removeAllViews();
    }

    public final void setProgressBarConfig(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.b r1) {
    }

    public final void b() {
        MaskState r0 = this.u;
        int r1 = this.c;
        if (this.r == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        MaskState r3 = MaskState.NONE;
    L17:
        this.u = r3;
        if (r0 == r3) goto L20;
    L21:
        StyleEdgeTransparentView2 r4 = this.t;
        if (r4 == null) goto L38;
        int r5 = c.a[r3.ordinal()];
        if (r5 != 1) goto L26;
        r4.b = r4.h;
        r4.invalidate();
    L35:
        r4.setLeftDrawSize((this.n + this.j) - this.a);
        r4.setRightDrawSize((this.n + this.j) * 3);
        return;
    L26:
        if (r5 == 2) goto L33;
        if (r5 != 3) goto L29;
        r4.b = r4.i | r4.h;
        r4.invalidate();
        goto L35
    L29:
        if (r5 != 4) goto L35;
        r4.b = r4.j;
        r4.invalidate();
        goto L35
    L33:
        r4.b = r4.i;
        r4.invalidate();
        goto L35
    L38:
        return;
    L20:
        if (this.a != 0) goto L21;
        return;
    L10:
        if (r1 < (getChildCount() - 5)) goto L13;
        r3 = MaskState.ONLY_LEFT;
        goto L17
    L13:
        if (r1 < (this.e - 5)) goto L15;
        r3 = MaskState.BOTH_SIDES;
        goto L17
    L15:
        r3 = MaskState.ONLY_RIGHT;
        goto L17
    L5:
        if (this.l == false) goto L7;
        r2 = true;
        goto L8
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.r == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L12;
        super.computeScroll();
        return;
    L12:
        if (this.s.computeScrollOffset() == false) goto L14;
        scrollTo(this.s.getCurrX(), this.s.getCurrY());
        postInvalidate();
        return;
    L14:
        int r1 = (int) (this.f * (this.n + this.j));
        Math.max(0, r1);
        int r2 = Math.min(this.h, r1);
        scrollTo(r2, 0);
        this.a = r2 - r1;
        b();
        return;
    L5:
        if (this.l == false) goto L7;
        r0 = true;
        goto L8
    }

    public final boolean d() {
        if (getOrientation() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void i() {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        View r2 = getChildAt(r1);
        StringBuilder r3 = new StringBuilder("图片");
        r1 = r1 + 1;
        r3.append(r1);
        r3.append("，按钮");
        r2.setContentDescription(r3.toString());
        goto L3
    }

    public final int getCurrentPosition() {
        return this.c;
    }

    public final Function1<Boolean, Unit> getOnProgressBarSelected() {
        return this.q;
    }

    public final void a(int r8) {
        if (r8 > 0) goto L4;
        return;
    L4:
        this.j = this.i;
        if (d() == false) goto L21;
        int r0 = getMeasuredWidth();
        if (r0 > 0) goto L9;
        return;
    L9:
        this.o = getMeasuredHeight();
        float r2 = r0;
        float r3 = this.j;
        float r4 = r8 - 1;
        int r5 = (int) ((r2 - (r3 * r4)) / r8);
        this.n = r5;
        float r6 = r5;
        if (r6 < r3) goto L16;
        if (r6 < this.m) goto L14;
        return;
    L14:
        if (this.l == true) goto L16;
        return;
    L16:
        if (this.l == true) goto L18;
        int r1 = (r0 / ((r8 * 2) - 1)) + 1;
        this.n = r1;
        this.j = r1;
        return;
    L18:
        int r7 = (int) this.m;
        this.n = r7;
        float r9 = (int) this.i;
        this.j = r9;
        this.r = true;
        int r10 = (int) ((r2 + r9) / (r7 + r9));
        this.e = r10;
        this.h = (int) (((r7 * r8) + (r9 * r4)) - r2);
        this.f = 0;
        this.g = r10 - 1;
        b();
        int r11 = this.d;
        int r12 = this.c;
        if (r11 == r12) goto L31;
        k(r12, r11);
        return;
    L31:
        return;
    L21:
        int r13 = getMeasuredHeight();
        if (r13 > 0) goto L24;
        return;
    L24:
        this.n = getMeasuredWidth();
        float r14 = this.j;
        int r15 = (int) ((r13 - ((r8 - 1) * r14)) / r8);
        this.o = r15;
        if (r15 >= r14) goto L33;
        int r16 = (r13 / ((r8 * 2) - 1)) + 1;
        this.o = r16;
        this.j = r16;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "ev");
        if (this.y == null) goto L5;
        r6.getAction();
        r6.getX();
        r6.getY();
        int r0 = r6.getActionMasked();
        boolean r1 = false;
        if (r0 != 0) goto L9;
        this.x = r6.getRawX();
        r6.getRawY();
        b r2 = this.y;
        if (r2 == null) goto L54;
        r2.onDown(r6);
    L54:
        Handler r3 = getHandler();
        if (r3 == null) goto L57;
        r3.postDelayed(this.B, this.w);
    L57:
        this.z = false;
        return super.dispatchTouchEvent(r6);
    L9:
        if (r0 == 1) goto L33;
        if (r0 == 2) goto L22;
        if (r0 == 3) goto L33;
        if (this.z == false) goto L17;
    L18:
        r1 = true;
    L20:
        return r1;
    L17:
        if (super.dispatchTouchEvent(r6) == false) goto L20;
    L22:
        if (Math.abs(r6.getRawX() - this.x) > this.v) goto L24;
    L30:
        super.dispatchTouchEvent(r6);
        return this.z;
    L24:
        if (this.A == true) goto L26;
        return false;
    L26:
        b r4 = this.y;
        if (r4 == null) goto L29;
        r4.N0(r6);
    L29:
        this.z = true;
    L33:
        if (this.z == false) goto L45;
        b r5 = this.y;
        if (r5 != null) goto L37;
    L41:
        Handler r7 = getHandler();
        if (r7 == null) goto L45;
        r7.removeCallbacks(this.B);
        goto L45
    L37:
        if (r6.getActionMasked() != 1) goto L39;
        boolean r8 = true;
    L40:
        r5.O0(r8);
        goto L41
    L39:
        r8 = false;
    L45:
        if (this.z == false) goto L47;
    L48:
        r1 = true;
    L50:
        return r1;
    L47:
        if (super.dispatchTouchEvent(r6) == false) goto L50;
    L5:
        return super.dispatchTouchEvent(r6);
    }

    public final void f(int r9) {
        int r0 = getChildCount();
        this.d = r9;
        if (r9 <= this.c) goto L13;
        int r1 = 0;
    L5:
        if (r1 >= r9) goto L22;
        View r2 = getChildAt(r1);
        if ((r2 instanceof StoryProgressBar) == false) goto L12;
        if (r1 >= r9) goto L10;
        float r5 = 1.0f;
    L11:
        int r6 = StoryProgressBar.o;
        ((StoryProgressBar) r2).b(r5, false);
        goto L12
    L10:
        r5 = 0.0f;
    L12:
        r1 = r1 + 1;
        goto L5
    L22:
        return;
    L13:
        int r3 = r0 - 1;
    L14:
        if ((-1) >= r3) goto L29;
        View r7 = getChildAt(r3);
        if ((r7 instanceof StoryProgressBar) == false) goto L21;
        if (r3 < r9) goto L19;
        float r8 = 0.0f;
    L20:
        int r10 = StoryProgressBar.o;
        ((StoryProgressBar) r7).b(r8, false);
        goto L21
    L19:
        r8 = 1.0f;
    L21:
        r3 = r3 - 1;
        goto L14
    }

    public final void j(final int r10) {
        int r0 = getChildCount();
        if (r0 != r10) goto L5;
        return;
    L5:
        int r2 = 0;
        if (r0 > 0) goto L8;
    L42:
        e();
        a(r10);
    L43:
        if (r2 >= r10) goto L58;
        StoryProgressBar r1 = c(r2, r10);
        addView(r1);
        if (r10 != 1) goto L47;
        r1.setMChapterStoryProgressBarDrawer(new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.a(r1));
    L47:
        r2 = r2 + 1;
        goto L43
    L58:
        return;
    L8:
        if (this.k == true) goto L42;
        if (r0 >= r10) goto L28;
        final int r3 = getChildCount();
        if (r10 > r3) goto L15;
        return;
    L15:
        if (this.l == false) goto L17;
        this.c = 0;
    L17:
        View r6 = getChildAt(r3 - 1);
        if (r6 == null) goto L55;
        int r7 = r3;
    L21:
        if (r7 >= r10) goto L23;
        addView(c(r7, r10));
        r7 = r7 + 1;
        goto L21
    L23:
        a(r10);
        if (d() == false) goto L26;
        ViewGroup.LayoutParams r8 = r6.getLayoutParams();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r9 = (LinearLayout.LayoutParams) r8;
        int r4 = (int) this.j;
        r9.rightMargin = r4;
        r9.setMarginEnd(r4);
        r6.setLayoutParams(r9);
        float r5 = r6.getMeasuredWidth();
        float r11 = this.n;
        ValueAnimator r12 = ObjectAnimator.ofFloat(new float[]{r5, r11});
        r12.addUpdateListener(new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.c(r3, this));
        ValueAnimator r13 = ObjectAnimator.ofFloat(new float[]{0.0f, r11});
        r13.addUpdateListener(new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.d(r3, r10, this));
    L27:
        AnimatorSet r14 = new AnimatorSet();
        r14.play(r12).with(r13);
        r14.start();
        return;
    L26:
        ViewGroup.LayoutParams r15 = r6.getLayoutParams();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r16 = (LinearLayout.LayoutParams) r15;
        r16.bottomMargin = (int) this.j;
        r6.setLayoutParams(r16);
        float r17 = r6.getMeasuredHeight();
        float r18 = this.o;
        r12 = ObjectAnimator.ofFloat(new float[]{r17, r18});
        r12.addUpdateListener(new e(r3, this));
        r13 = ObjectAnimator.ofFloat(new float[]{0.0f, r18});
        r13.addUpdateListener(new f(r3, r10, this));
        goto L27
    L55:
        return;
    L28:
        final int r19 = getChildCount();
        if (r10 >= r19) goto L56;
        View r20 = getChildAt(r10 - 1);
        if (r20 != null) goto L35;
        return;
    L35:
        if (this.l == false) goto L37;
        this.c = 0;
    L37:
        a(r10);
        if (d() == false) goto L40;
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r22 = (LinearLayout.LayoutParams) r21;
        r22.rightMargin = 0;
        r22.setMarginEnd(0);
        r20.setLayoutParams(r22);
        float r23 = r20.getMeasuredWidth();
        ValueAnimator r24 = ObjectAnimator.ofFloat(new float[]{r23, this.n});
        r24.addUpdateListener(new g(r10, this));
        ValueAnimator r25 = ObjectAnimator.ofFloat(new float[]{r23, 0.0f});
        r25.addUpdateListener(new h(r10, r19, this));
    L41:
        AnimatorSet r26 = new AnimatorSet();
        r26.play(r25).with(r24);
        r26.addListener(new m(r19, r10, this));
        r26.start();
        return;
    L40:
        ViewGroup.LayoutParams r27 = r20.getLayoutParams();
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r28 = (LinearLayout.LayoutParams) r27;
        r28.bottomMargin = 0;
        r20.setLayoutParams(r28);
        float r29 = r20.getMeasuredHeight();
        float r30 = this.o;
        ValueAnimator r31 = ObjectAnimator.ofFloat(new float[]{r29, r30});
        r31.addUpdateListener(new i(r10, this));
        r25 = ObjectAnimator.ofFloat(new float[]{r30, 0.0f});
        r25.addUpdateListener(new j(r10, r19, this));
        r24 = r31;
        goto L41
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r7) {
        super.onConfigurationChanged(r7);
        int r8 = b0.a;
        Context r9 = getContext();
        Intrinsics.checkNotNullParameter(r9, "context");
        int r0 = b0.a;
        boolean r2 = false;
        if (r0 <= (-1)) goto L6;
        if (r0 <= 0) goto L88;
    L5:
        r2 = true;
    L88:
        if (r2 == false) goto L97;
        int r10 = this.c;
        ViewTreeObserver r1 = getViewTreeObserver();
        if (r1 == null) goto L98;
        r1.addOnGlobalLayoutListener(new d(this, r10));
        return;
    L98:
        return;
    L97:
        return;
    L6:
        b0.a = 0;
        if (StringsKt.equals("samsung", Build.BRAND, true) == false) goto L9;
    L12:
        boolean r3 = true;
    L14:
        if (r3 == false) goto L27;
        String r4 = Build.MODEL;
        if (TextUtils.isEmpty(r4) == false) goto L19;
    L23:
        boolean r5 = false;
    L25:
        if (r5 == false) goto L27;
        b0.a = 1;
    L86:
        if (b0.a <= 0) goto L88;
    L19:
        if (StringsKt.startsWith$default(r4, "SM-F9", false, 2, null) == false) goto L21;
    L24:
        r5 = true;
        goto L25
    L21:
        if (StringsKt.startsWith$default(r4, "SM-W202", false, 2, null) == false) goto L23;
    L27:
        String r6 = Build.MANUFACTURER;
        if (r6 != null) goto L30;
    L32:
        boolean r11 = false;
    L33:
        if (r11 == false) goto L59;
        String r12 = Build.DEVICE;
        if (TextUtils.equals(r12, "HWTAH") == false) goto L38;
    L45:
        boolean r13 = true;
    L47:
        if (r13 == true) goto L57;
        if (r9 != null) goto L95;
    L55:
        boolean r14 = false;
    L56:
        if (r14 == false) goto L59;
    L95:
        if (r9.getPackageManager() == null) goto L55;
        if (r9.getPackageManager().hasSystemFeature("com.huawei.hardware.sensor.posture") == false) goto L55;
        r14 = true;
    L57:
        b0.a = 1;
        goto L86
    L38:
        if (TextUtils.equals(r12, "unknownRLI") == true) goto L45;
        if (TextUtils.equals(r12, "unknownRHA") == true) goto L45;
        if (TextUtils.equals(r12, "HWTAH-C") == true) goto L45;
        r13 = TextUtils.equals(r12, "unknownTXL");
    L59:
        if (r9.getPackageManager().hasSystemFeature("oplus.feature.largescreen") == false) goto L61;
        b0.a = 1;
        goto L86
    L61:
        String r15 = Build.MANUFACTURER;
        if (r15 != null) goto L64;
    L66:
        boolean r16 = false;
    L67:
        if (r16 == false) goto L86;
        String r17 = Build.DEVICE;
        if (StringsKt.equals("DIA-AN00", r17, true) == false) goto L71;
    L74:
        boolean r18 = true;
    L75:
        if (r18 == false) goto L93;
    L84:
        b0.a = 1;
        goto L86
    L93:
        if (r9.getPackageManager() == null) goto L82;
        if (r9.getPackageManager().hasSystemFeature("com.hihonor.hardware.sensor.posture") == false) goto L82;
        boolean r19 = true;
    L83:
        if (r19 == false) goto L86;
    L82:
        r19 = false;
        goto L83
    L71:
        if (StringsKt.equals("MGI-AN00", r17, true) == true) goto L74;
        r18 = false;
        goto L75
    L64:
        if (StringsKt.contains$default(r15.toUpperCase(Locale.getDefault()), "HONOR", false, 2, null) == false) goto L66;
        r16 = true;
        goto L67
    L30:
        if (StringsKt.contains$default(r6.toUpperCase(Locale.getDefault()), "HUAWEI", false, 2, null) == false) goto L32;
        r11 = true;
        goto L33
    L9:
        if (StringsKt.equals("samsung", Build.MANUFACTURER, true) == true) goto L12;
        r3 = false;
        goto L14
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.A == true) goto L7;
        return false;
    L7:
        return super.onInterceptTouchEvent(r2);
    }

    public final void setClickEnabled(boolean r1) {
        this.p = r1;
    }

    public final void setIsTouchable(boolean r1) {
        this.A = r1;
    }

    public final void setMaskView(View r2) {
        if ((r2 instanceof StyleEdgeTransparentView2) == false) goto L8;
        StyleEdgeTransparentView2 r3 = (StyleEdgeTransparentView2) r2;
        this.t = r3;
        if (r3 == null) goto L9;
        r3.b = r3.j;
        r3.invalidate();
        return;
    L9:
        return;
    }

    public final void setOnProgressBarSelected(Function1<? super Boolean, Unit> r1) {
        this.q = r1;
    }

    public final void setProgressBarGestureListener(b r1) {
        this.y = r1;
    }

    public final StoryProgressBar c(final int r6, int r7) {
        StoryProgressBar r0 = new StoryProgressBar(this.b, null, 6, 0);
        if (d() == false) goto L7;
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-2, -1);
        r1.width = this.n;
        if (r6 >= (r7 - 1)) goto L10;
        int r8 = (int) this.j;
        r1.rightMargin = r8;
        r1.setMarginEnd(r8);
    L10:
        r0.setLayoutParams(r1);
        if (this.p == true) goto L13;
    L15:
        return r0;
    L13:
        if (d() == false) goto L15;
        r0.setOnClickListener(new k(this, r6));
        goto L15
    L7:
        r0.setOrientation(1);
        r1 = new LinearLayout.LayoutParams(-1, -2);
        r1.height = this.o;
        r1.width = this.n;
        if (r6 >= (r7 - 1)) goto L10;
        r1.bottomMargin = (int) this.j;
        goto L10
    }

    public final void h(int r13, float r14) {
        g(this, r13, 0.0f, 0, 12);
        g(this, r13, r14, 0, 12);
    }

    public final void k(int r4, int r5) {
        if (this.r == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
        return;
    L10:
        int r1 = getChildCount() - 1;
        int r6 = r5 - r4;
        if (r6 <= 0) goto L13;
        r6 = Math.min(Math.max(0, (r5 - this.g) + 5), r1 - this.g);
    L15:
        if (r6 == 0) goto L23;
        this.f += r6;
        this.g += r6;
        int r7 = (int) ((this.n + this.j) * r6);
        if (r5 != 0) goto L19;
        this.f = 0;
        this.g = this.e - 1;
        scrollTo(0, 0);
        goto L23
    L19:
        int r8 = getScrollX() + r7;
        int r2 = this.h;
        if (r8 <= r2) goto L22;
        r7 = r2 - getScrollX();
    L22:
        this.s.startScroll(getScrollX(), getScrollY(), r7, 0);
        invalidate();
    L23:
        getChildCount();
        return;
    L13:
        if (r6 >= 0) goto L15;
        r6 = Math.max(-this.f, Math.min(0, (r5 - this.g) + 5));
        goto L15
    L5:
        if (this.l == false) goto L7;
        r0 = true;
        goto L8
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r6, int r7) {
        super.onMeasure(r6, r7);
        int r8 = getChildCount();
        if (r8 <= 0) goto L21;
        a(r8);
        int r0 = 0;
    L5:
        if (r0 >= r8) goto L16;
        View r1 = getChildAt(r0);
        if (r1 == null) goto L15;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) r2;
        r3.height = this.o;
        r3.width = this.n;
        if (r0 < (r8 - 1)) goto L11;
    L14:
        r1.setLayoutParams(r3);
        goto L15
    L11:
        if (d() == false) goto L13;
        float r4 = this.j;
        r3.rightMargin = (int) r4;
        r3.setMarginEnd((int) r4);
        goto L14
    L13:
        r3.bottomMargin = (int) this.j;
    L15:
        r0 = r0 + 1;
        goto L5
    L16:
        this.k = false;
        return;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.l] */
    public StoryListProgressBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        new LinkedHashMap();
        super(r2, r3, r4);
        Context r5 = getContext();
        this.b = r5;
        float r0 = n0.a(r5, 3.0f);
        this.i = r0;
        this.j = r0;
        this.k = true;
        this.l = true;
        this.m = n0.a(r5, 3.0f);
        this.s = new Scroller(r2);
        this.u = MaskState.NONE;
        this.v = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.w = ViewConfiguration.getLongPressTimeout();
        this.A = true;
        this.B = new l(this);
    }

    public /* synthetic */ StoryListProgressBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static void g(StoryListProgressBar r6, int r7, float r8, long r9, int r11) {
        if ((r11 & 4) == 0) goto L5;
        r9 = 300;
    L5:
        boolean r0 = true;
        if ((r11 & 8) == 0) goto L8;
        boolean r12 = true;
    L9:
        r6.getClass();
        int r2 = r6.c;
        r6.d = r7;
        if (r2 != r7) goto L12;
        int r3 = r7 + 1;
        int r4 = r6.getChildCount();
    L20:
        if (r3 >= r4) goto L25;
        View r5 = r6.getChildAt(r3);
        if ((r5 instanceof StoryProgressBar) == false) goto L24;
        int r10 = StoryProgressBar.o;
        ((StoryProgressBar) r5).b(0.0f, false);
    L24:
        r3 = r3 + 1;
        goto L20
    L25:
        if (r7 >= 0) goto L27;
    L29:
        r0 = false;
    L30:
        if (r0 == false) goto L34;
        View r1 = r6.getChildAt(r7);
        if ((r1 instanceof StoryProgressBar) == false) goto L34;
        StoryProgressBar r13 = (StoryProgressBar) r1;
        r13.setAnimationInterval(r9);
        r13.b(r8, r12);
    L34:
        r6.c = r7;
        return;
    L27:
        if (r7 >= r6.getChildCount()) goto L29;
    L12:
        if (r8 == 1.0f) goto L15;
        r0 = false;
    L15:
        if (r0 == false) goto L17;
        r6.h(r7, r8);
    L18:
        r6.k(r6.c, r7);
        goto L34
    L17:
        r6.f(r7);
        goto L18
    L8:
        r12 = false;
        goto L9
    }
}
