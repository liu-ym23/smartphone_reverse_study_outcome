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
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.StyleEdgeTransparentView2;
import com.bytedance.awemeopen.apps.framework.utils.b0;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.huawei.hms.android.SystemUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003\"#$B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006J\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010R0\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/progress/StoryListProgressBar;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/progress/b;", "config", "", "setProgressBarConfig", "", "enabled", "setClickEnabled", "", "getCurrentPosition", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/progress/StoryListProgressBar$b;", "listener", "setProgressBarGestureListener", "isTouchable", "setIsTouchable", "Landroid/view/View;", "maskView", "setMaskView", "Lkotlin/Function1;", "q", "Lkotlin/jvm/functions/Function1;", "getOnProgressBarSelected", "()Lkotlin/jvm/functions/Function1;", "setOnProgressBarSelected", "(Lkotlin/jvm/functions/Function1;)V", "onProgressBarSelected", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "MaskState", "b", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class StoryListProgressBar extends LinearLayout {
    public static final /* synthetic */ int C = 0;
    public boolean A;
    public final l B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f195296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f195297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f195298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f195299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f195300e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f195301f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f195302g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f195303h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f195304i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f195305j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f195306k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f195307l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f195308m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f195309n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f195310o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f195311p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f195312q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f195313r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Scroller f195314s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public StyleEdgeTransparentView2 f195315t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public MaskState f195316u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f195317v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f195318w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f195319x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public b f195320y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f195321z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/progress/StoryListProgressBar$MaskState;", "", UserProfileEvent.POSITION_NONE, "ONLY_LEFT", "ONLY_RIGHT", "BOTH_SIDES", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum MaskState extends Enum<MaskState> {
        public static final MaskState BOTH_SIDES = null;
        public static final MaskState NONE = null;
        public static final MaskState ONLY_LEFT = null;
        public static final MaskState ONLY_RIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MaskState[] f195322a = null;

        public static MaskState valueOf(String r100) {
            return (MaskState) r27.a.a(MaskState.class, r100);
        }

        public static MaskState[] values() {
            return (MaskState[]) f195322a.clone();
        }

        static {
            MaskState r100 = new MaskState(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            MaskState r101 = new MaskState("ONLY_LEFT", 1);
            ONLY_LEFT = r101;
            MaskState r102 = new MaskState("ONLY_RIGHT", 2);
            ONLY_RIGHT = r102;
            MaskState r103 = new MaskState("BOTH_SIDES", 3);
            BOTH_SIDES = r103;
            f195322a = new MaskState[]{r100, r101, r102, r103};
        }

        public MaskState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public interface b {
        void M0();

        void N0(MotionEvent r100);

        void O0(boolean r100);

        void onDown(MotionEvent r100);
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f195323a = null;

        static {
            int[] r100 = new int[MaskState.values().length];
            r100[MaskState.ONLY_RIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[MaskState.ONLY_LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[MaskState.BOTH_SIDES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[MaskState.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f195323a = r100;
        }
    }

    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StoryListProgressBar f195324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f195325b;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            int r100 = this.f195324a.getChildCount();
            this.f195324a.e();
            this.f195324a.j(r100);
            this.f195324a.h(this.f195325b, 0.0f);
            ViewTreeObserver r101 = this.f195324a.getViewTreeObserver();
            if (r101 == null) goto L6;
            r101.removeOnGlobalLayoutListener(this);
            return;
        }

        public d(StoryListProgressBar r100, int r101) {
            this.f195324a = r100;
            this.f195325b = r101;
        }
    }

    static {
    }

    public StoryListProgressBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StoryListProgressBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this(r100, r101, 4, 0);
    }

    public final void e() {
        this.f195298c = 0;
        this.f195309n = 0;
        this.f195310o = 0;
        this.f195305j = this.f195304i;
        if (this.f195307l == false) goto L5;
        this.f195313r = false;
        this.f195303h = 0;
        this.f195296a = 0;
        this.f195301f = 0;
        this.f195302g = this.f195300e - 1;
        scrollTo(0, 0);
    L5:
        f(0);
        removeAllViews();
    }

    public final void setProgressBarConfig(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.b r100) {
    }

    public final void b() {
        MaskState r100 = this.f195316u;
        int r101 = this.f195298c;
        if (this.f195313r == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        MaskState r103 = MaskState.NONE;
    L17:
        this.f195316u = r103;
        if (r100 == r103) goto L20;
    L21:
        StyleEdgeTransparentView2 r104 = this.f195315t;
        if (r104 == null) goto L38;
        int r105 = c.f195323a[r103.ordinal()];
        if (r105 != 1) goto L26;
        r104.f195283b = r104.f195289h;
        r104.invalidate();
    L35:
        r104.setLeftDrawSize((this.f195309n + this.f195305j) - this.f195296a);
        r104.setRightDrawSize((this.f195309n + this.f195305j) * 3);
        return;
    L26:
        if (r105 == 2) goto L33;
        if (r105 != 3) goto L29;
        r104.f195283b = r104.f195290i | r104.f195289h;
        r104.invalidate();
        goto L35
    L29:
        if (r105 != 4) goto L35;
        r104.f195283b = r104.f195291j;
        r104.invalidate();
        goto L35
    L33:
        r104.f195283b = r104.f195290i;
        r104.invalidate();
        goto L35
    L38:
        return;
    L20:
        if (this.f195296a != 0) goto L21;
        return;
    L10:
        if (r101 < (getChildCount() - 5)) goto L13;
        r103 = MaskState.ONLY_LEFT;
        goto L17
    L13:
        if (r101 < (this.f195300e - 5)) goto L15;
        r103 = MaskState.BOTH_SIDES;
        goto L17
    L15:
        r103 = MaskState.ONLY_RIGHT;
        goto L17
    L5:
        if (this.f195307l == false) goto L7;
        r102 = true;
        goto L8
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.f195313r == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == true) goto L12;
        super.computeScroll();
        return;
    L12:
        if (this.f195314s.computeScrollOffset() == false) goto L14;
        scrollTo(this.f195314s.getCurrX(), this.f195314s.getCurrY());
        postInvalidate();
        return;
    L14:
        int r101 = (int) (this.f195301f * (this.f195309n + this.f195305j));
        Math.max(0, r101);
        int r102 = Math.min(this.f195303h, r101);
        scrollTo(r102, 0);
        this.f195296a = r102 - r101;
        b();
        return;
    L5:
        if (this.f195307l == false) goto L7;
        r100 = true;
        goto L8
    }

    public final boolean d() {
        if (getOrientation() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void i() {
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        View r102 = getChildAt(r101);
        StringBuilder r103 = new StringBuilder("图片");
        r101 = r101 + 1;
        r103.append(r101);
        r103.append("，按钮");
        r102.setContentDescription(r103.toString());
        goto L3
    }

    public final int getCurrentPosition() {
        return this.f195298c;
    }

    public final Function1<Boolean, Unit> getOnProgressBarSelected() {
        return this.f195312q;
    }

    public final void a(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        this.f195305j = this.f195304i;
        if (d() == false) goto L21;
        int r101 = getMeasuredWidth();
        if (r101 > 0) goto L9;
        return;
    L9:
        this.f195310o = getMeasuredHeight();
        float r102 = r101;
        float r103 = this.f195305j;
        float r104 = r100 - 1;
        int r105 = (int) ((r102 - (r103 * r104)) / r100);
        this.f195309n = r105;
        float r106 = r105;
        if (r106 < r103) goto L16;
        if (r106 < this.f195308m) goto L14;
        return;
    L14:
        if (this.f195307l == true) goto L16;
        return;
    L16:
        if (this.f195307l == true) goto L18;
        int r107 = (r101 / ((r100 * 2) - 1)) + 1;
        this.f195309n = r107;
        this.f195305j = r107;
        return;
    L18:
        int r108 = (int) this.f195308m;
        this.f195309n = r108;
        float r109 = (int) this.f195304i;
        this.f195305j = r109;
        this.f195313r = true;
        int r110 = (int) ((r102 + r109) / (r108 + r109));
        this.f195300e = r110;
        this.f195303h = (int) (((r108 * r100) + (r109 * r104)) - r102);
        this.f195301f = 0;
        this.f195302g = r110 - 1;
        b();
        int r111 = this.f195299d;
        int r112 = this.f195298c;
        if (r111 == r112) goto L31;
        k(r112, r111);
        return;
    L31:
        return;
    L21:
        int r113 = getMeasuredHeight();
        if (r113 > 0) goto L24;
        return;
    L24:
        this.f195309n = getMeasuredWidth();
        float r114 = this.f195305j;
        int r115 = (int) ((r113 - ((r100 - 1) * r114)) / r100);
        this.f195310o = r115;
        if (r115 >= r114) goto L33;
        int r116 = (r113 / ((r100 * 2) - 1)) + 1;
        this.f195310o = r116;
        this.f195305j = r116;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f195320y == null) goto L5;
        r100.getAction();
        r100.getX();
        r100.getY();
        int r101 = r100.getActionMasked();
        boolean r102 = false;
        if (r101 != 0) goto L9;
        this.f195319x = r100.getRawX();
        r100.getRawY();
        b r103 = this.f195320y;
        if (r103 == null) goto L54;
        r103.onDown(r100);
    L54:
        Handler r104 = getHandler();
        if (r104 == null) goto L57;
        r104.postDelayed(this.B, this.f195318w);
    L57:
        this.f195321z = false;
        return super.dispatchTouchEvent(r100);
    L9:
        if (r101 == 1) goto L33;
        if (r101 == 2) goto L22;
        if (r101 == 3) goto L33;
        if (this.f195321z == false) goto L17;
    L18:
        r102 = true;
    L20:
        return r102;
    L17:
        if (super.dispatchTouchEvent(r100) == false) goto L20;
    L22:
        if (Math.abs(r100.getRawX() - this.f195319x) > this.f195317v) goto L24;
    L30:
        super.dispatchTouchEvent(r100);
        return this.f195321z;
    L24:
        if (this.A == true) goto L26;
        return false;
    L26:
        b r105 = this.f195320y;
        if (r105 == null) goto L29;
        r105.N0(r100);
    L29:
        this.f195321z = true;
    L33:
        if (this.f195321z == false) goto L45;
        b r106 = this.f195320y;
        if (r106 != null) goto L37;
    L41:
        Handler r107 = getHandler();
        if (r107 == null) goto L45;
        r107.removeCallbacks(this.B);
        goto L45
    L37:
        if (r100.getActionMasked() != 1) goto L39;
        boolean r108 = true;
    L40:
        r106.O0(r108);
        goto L41
    L39:
        r108 = false;
    L45:
        if (this.f195321z == false) goto L47;
    L48:
        r102 = true;
    L50:
        return r102;
    L47:
        if (super.dispatchTouchEvent(r100) == false) goto L50;
    L5:
        return super.dispatchTouchEvent(r100);
    }

    public final void f(int r100) {
        int r101 = getChildCount();
        this.f195299d = r100;
        if (r100 <= this.f195298c) goto L13;
        int r102 = 0;
    L5:
        if (r102 >= r100) goto L22;
        View r103 = getChildAt(r102);
        if ((r103 instanceof StoryProgressBar) == false) goto L12;
        if (r102 >= r100) goto L10;
        float r104 = 1.0f;
    L11:
        int r105 = StoryProgressBar.f195326o;
        ((StoryProgressBar) r103).b(r104, false);
        goto L12
    L10:
        r104 = 0.0f;
    L12:
        r102 = r102 + 1;
        goto L5
    L22:
        return;
    L13:
        int r106 = r101 - 1;
    L14:
        if ((-1) >= r106) goto L29;
        View r107 = getChildAt(r106);
        if ((r107 instanceof StoryProgressBar) == false) goto L21;
        if (r106 < r100) goto L19;
        float r108 = 0.0f;
    L20:
        int r109 = StoryProgressBar.f195326o;
        ((StoryProgressBar) r107).b(r108, false);
        goto L21
    L19:
        r108 = 1.0f;
    L21:
        r106 = r106 - 1;
        goto L14
    }

    public final void j(final int r110) {
        int r100 = getChildCount();
        if (r100 != r110) goto L5;
        return;
    L5:
        int r101 = 0;
        if (r100 > 0) goto L8;
    L42:
        e();
        a(r110);
    L43:
        if (r101 >= r110) goto L58;
        StoryProgressBar r102 = c(r101, r110);
        addView(r102);
        if (r110 != 1) goto L47;
        r102.setMChapterStoryProgressBarDrawer(new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.a(r102));
    L47:
        r101 = r101 + 1;
        goto L43
    L58:
        return;
    L8:
        if (this.f195306k == true) goto L42;
        if (r100 >= r110) goto L28;
        final int r103 = getChildCount();
        if (r110 > r103) goto L15;
        return;
    L15:
        if (this.f195307l == false) goto L17;
        this.f195298c = 0;
    L17:
        View r104 = getChildAt(r103 - 1);
        if (r104 == null) goto L55;
        int r105 = r103;
    L21:
        if (r105 >= r110) goto L23;
        addView(c(r105, r110));
        r105 = r105 + 1;
        goto L21
    L23:
        a(r110);
        if (d() == false) goto L26;
        ViewGroup.LayoutParams r106 = r104.getLayoutParams();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r107 = (LinearLayout.LayoutParams) r106;
        int r108 = (int) this.f195305j;
        r107.rightMargin = r108;
        r107.setMarginEnd(r108);
        r104.setLayoutParams(r107);
        float r109 = r104.getMeasuredWidth();
        float r111 = this.f195309n;
        ValueAnimator r112 = ObjectAnimator.ofFloat(new float[]{r109, r111});
        r112.addUpdateListener(new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.c(r103, this));
        ValueAnimator r113 = ObjectAnimator.ofFloat(new float[]{0.0f, r111});
        r113.addUpdateListener(new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.d(r103, r110, this));
    L27:
        AnimatorSet r114 = new AnimatorSet();
        r114.play(r112).with(r113);
        r114.start();
        return;
    L26:
        ViewGroup.LayoutParams r115 = r104.getLayoutParams();
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r116 = (LinearLayout.LayoutParams) r115;
        r116.bottomMargin = (int) this.f195305j;
        r104.setLayoutParams(r116);
        float r117 = r104.getMeasuredHeight();
        float r118 = this.f195310o;
        r112 = ObjectAnimator.ofFloat(new float[]{r117, r118});
        r112.addUpdateListener(new e(r103, this));
        r113 = ObjectAnimator.ofFloat(new float[]{0.0f, r118});
        r113.addUpdateListener(new f(r103, r110, this));
        goto L27
    L55:
        return;
    L28:
        final int r119 = getChildCount();
        if (r110 >= r119) goto L56;
        View r120 = getChildAt(r110 - 1);
        if (r120 != null) goto L35;
        return;
    L35:
        if (this.f195307l == false) goto L37;
        this.f195298c = 0;
    L37:
        a(r110);
        if (d() == false) goto L40;
        ViewGroup.LayoutParams r121 = r120.getLayoutParams();
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r122 = (LinearLayout.LayoutParams) r121;
        r122.rightMargin = 0;
        r122.setMarginEnd(0);
        r120.setLayoutParams(r122);
        float r123 = r120.getMeasuredWidth();
        ValueAnimator r124 = ObjectAnimator.ofFloat(new float[]{r123, this.f195309n});
        r124.addUpdateListener(new g(r110, this));
        ValueAnimator r125 = ObjectAnimator.ofFloat(new float[]{r123, 0.0f});
        r125.addUpdateListener(new h(r110, r119, this));
    L41:
        AnimatorSet r126 = new AnimatorSet();
        r126.play(r125).with(r124);
        r126.addListener(new m(r119, r110, this));
        r126.start();
        return;
    L40:
        ViewGroup.LayoutParams r127 = r120.getLayoutParams();
        Intrinsics.checkNotNull(r127, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r128 = (LinearLayout.LayoutParams) r127;
        r128.bottomMargin = 0;
        r120.setLayoutParams(r128);
        float r129 = r120.getMeasuredHeight();
        float r130 = this.f195310o;
        ValueAnimator r131 = ObjectAnimator.ofFloat(new float[]{r129, r130});
        r131.addUpdateListener(new i(r110, this));
        r125 = ObjectAnimator.ofFloat(new float[]{r130, 0.0f});
        r125.addUpdateListener(new j(r110, r119, this));
        r124 = r131;
        goto L41
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        int r101 = b0.f197678a;
        Context r102 = getContext();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r103 = b0.f197678a;
        boolean r104 = false;
        if (r103 <= (-1)) goto L6;
        if (r103 <= 0) goto L88;
    L5:
        r104 = true;
    L88:
        if (r104 == false) goto L97;
        int r105 = this.f195298c;
        ViewTreeObserver r106 = getViewTreeObserver();
        if (r106 == null) goto L98;
        r106.addOnGlobalLayoutListener(new d(this, r105));
        return;
    L98:
        return;
    L97:
        return;
    L6:
        b0.f197678a = 0;
        if (StringsKt.equals(SmEditTextLeakOpt.SAMSUNG, Build.BRAND, true) == false) goto L9;
    L12:
        boolean r107 = true;
    L14:
        if (r107 == false) goto L27;
        String r108 = Build.MODEL;
        if (TextUtils.isEmpty(r108) == false) goto L19;
    L23:
        boolean r109 = false;
    L25:
        if (r109 == false) goto L27;
        b0.f197678a = 1;
    L86:
        if (b0.f197678a <= 0) goto L88;
    L19:
        if (StringsKt.startsWith$default(r108, "SM-F9", false, 2, null) == false) goto L21;
    L24:
        r109 = true;
        goto L25
    L21:
        if (StringsKt.startsWith$default(r108, "SM-W202", false, 2, null) == false) goto L23;
    L27:
        String r110 = Build.MANUFACTURER;
        if (r110 != null) goto L30;
    L32:
        boolean r111 = false;
    L33:
        if (r111 == false) goto L59;
        String r112 = Build.DEVICE;
        if (TextUtils.equals(r112, "HWTAH") == false) goto L38;
    L45:
        boolean r113 = true;
    L47:
        if (r113 == true) goto L57;
        if (r102 != null) goto L95;
    L55:
        boolean r114 = false;
    L56:
        if (r114 == false) goto L59;
    L95:
        if (r102.getPackageManager() == null) goto L55;
        if (r102.getPackageManager().hasSystemFeature("com.huawei.hardware.sensor.posture") == false) goto L55;
        r114 = true;
    L57:
        b0.f197678a = 1;
        goto L86
    L38:
        if (TextUtils.equals(r112, "unknownRLI") == true) goto L45;
        if (TextUtils.equals(r112, "unknownRHA") == true) goto L45;
        if (TextUtils.equals(r112, "HWTAH-C") == true) goto L45;
        r113 = TextUtils.equals(r112, "unknownTXL");
    L59:
        if (r102.getPackageManager().hasSystemFeature("oplus.feature.largescreen") == false) goto L61;
        b0.f197678a = 1;
        goto L86
    L61:
        String r115 = Build.MANUFACTURER;
        if (r115 != null) goto L64;
    L66:
        boolean r116 = false;
    L67:
        if (r116 == false) goto L86;
        String r117 = Build.DEVICE;
        if (StringsKt.equals("DIA-AN00", r117, true) == false) goto L71;
    L74:
        boolean r118 = true;
    L75:
        if (r118 == false) goto L93;
    L84:
        b0.f197678a = 1;
        goto L86
    L93:
        if (r102.getPackageManager() == null) goto L82;
        if (r102.getPackageManager().hasSystemFeature("com.hihonor.hardware.sensor.posture") == false) goto L82;
        boolean r119 = true;
    L83:
        if (r119 == false) goto L86;
    L82:
        r119 = false;
        goto L83
    L71:
        if (StringsKt.equals("MGI-AN00", r117, true) == true) goto L74;
        r118 = false;
        goto L75
    L64:
        if (StringsKt.contains$default(r115.toUpperCase(Locale.getDefault()), SystemUtils.PRODUCT_HONOR, false, 2, null) == false) goto L66;
        r116 = true;
        goto L67
    L30:
        if (StringsKt.contains$default(r110.toUpperCase(Locale.getDefault()), SystemUtils.PRODUCT_HUAWEI, false, 2, null) == false) goto L32;
        r111 = true;
        goto L33
    L9:
        if (StringsKt.equals(SmEditTextLeakOpt.SAMSUNG, Build.MANUFACTURER, true) == true) goto L12;
        r107 = false;
        goto L14
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.A == true) goto L7;
        return false;
    L7:
        return super.onInterceptTouchEvent(r100);
    }

    public final void setClickEnabled(boolean r100) {
        this.f195311p = r100;
    }

    public final void setIsTouchable(boolean r100) {
        this.A = r100;
    }

    public final void setMaskView(View r100) {
        if ((r100 instanceof StyleEdgeTransparentView2) == false) goto L8;
        StyleEdgeTransparentView2 r101 = (StyleEdgeTransparentView2) r100;
        this.f195315t = r101;
        if (r101 == null) goto L9;
        r101.f195283b = r101.f195291j;
        r101.invalidate();
        return;
    L9:
        return;
    }

    public final void setOnProgressBarSelected(Function1<? super Boolean, Unit> r100) {
        this.f195312q = r100;
    }

    public final void setProgressBarGestureListener(b r100) {
        this.f195320y = r100;
    }

    public final StoryProgressBar c(final int r100, int r101) {
        StoryProgressBar r102 = new StoryProgressBar(this.f195297b, null, 6, 0);
        if (d() == false) goto L7;
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-2, -1);
        r103.width = this.f195309n;
        if (r100 >= (r101 - 1)) goto L10;
        int r104 = (int) this.f195305j;
        r103.rightMargin = r104;
        r103.setMarginEnd(r104);
    L10:
        r102.setLayoutParams(r103);
        if (this.f195311p == true) goto L13;
    L15:
        return r102;
    L13:
        if (d() == false) goto L15;
        r102.setOnClickListener(new k(this, r100));
        goto L15
    L7:
        r102.setOrientation(1);
        r103 = new LinearLayout.LayoutParams(-1, -2);
        r103.height = this.f195310o;
        r103.width = this.f195309n;
        if (r100 >= (r101 - 1)) goto L10;
        r103.bottomMargin = (int) this.f195305j;
        goto L10
    }

    public final void h(int r110, float r111) {
        g(this, r110, 0.0f, 0, 12);
        g(this, r110, r111, 0, 12);
    }

    public final void k(int r100, int r101) {
        if (this.f195313r == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        return;
    L10:
        int r103 = getChildCount() - 1;
        int r104 = r101 - r100;
        if (r104 <= 0) goto L13;
        r104 = Math.min(Math.max(0, (r101 - this.f195302g) + 5), r103 - this.f195302g);
    L15:
        if (r104 == 0) goto L23;
        this.f195301f += r104;
        this.f195302g += r104;
        int r105 = (int) ((this.f195309n + this.f195305j) * r104);
        if (r101 != 0) goto L19;
        this.f195301f = 0;
        this.f195302g = this.f195300e - 1;
        scrollTo(0, 0);
        goto L23
    L19:
        int r106 = getScrollX() + r105;
        int r107 = this.f195303h;
        if (r106 <= r107) goto L22;
        r105 = r107 - getScrollX();
    L22:
        this.f195314s.startScroll(getScrollX(), getScrollY(), r105, 0);
        invalidate();
    L23:
        getChildCount();
        return;
    L13:
        if (r104 >= 0) goto L15;
        r104 = Math.max(-this.f195301f, Math.min(0, (r101 - this.f195302g) + 5));
        goto L15
    L5:
        if (this.f195307l == false) goto L7;
        r102 = true;
        goto L8
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = getChildCount();
        if (r102 <= 0) goto L21;
        a(r102);
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L16;
        View r104 = getChildAt(r103);
        if (r104 == null) goto L15;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r106 = (LinearLayout.LayoutParams) r105;
        r106.height = this.f195310o;
        r106.width = this.f195309n;
        if (r103 < (r102 - 1)) goto L11;
    L14:
        r104.setLayoutParams(r106);
        goto L15
    L11:
        if (d() == false) goto L13;
        float r107 = this.f195305j;
        r106.rightMargin = (int) r107;
        r106.setMarginEnd((int) r107);
        goto L14
    L13:
        r106.bottomMargin = (int) this.f195305j;
    L15:
        r103 = r103 + 1;
        goto L5
    L16:
        this.f195306k = false;
        return;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.l] */
    public StoryListProgressBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        new LinkedHashMap();
        super(r100, r101, r102);
        Context r103 = getContext();
        this.f195297b = r103;
        float r104 = n0.a(r103, 3.0f);
        this.f195304i = r104;
        this.f195305j = r104;
        this.f195306k = true;
        this.f195307l = true;
        this.f195308m = n0.a(r103, 3.0f);
        this.f195314s = new Scroller(r100);
        this.f195316u = MaskState.NONE;
        this.f195317v = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f195318w = ViewConfiguration.getLongPressTimeout();
        this.A = true;
        this.B = new l(this);
    }

    public /* synthetic */ StoryListProgressBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void g(StoryListProgressBar r100, int r101, float r102, long r103, int r110) {
        if ((r110 & 4) == 0) goto L5;
        r103 = 300;
    L5:
        boolean r104 = true;
        if ((r110 & 8) == 0) goto L8;
        boolean r111 = true;
    L9:
        r100.getClass();
        int r105 = r100.f195298c;
        r100.f195299d = r101;
        if (r105 != r101) goto L12;
        int r106 = r101 + 1;
        int r107 = r100.getChildCount();
    L20:
        if (r106 >= r107) goto L25;
        View r108 = r100.getChildAt(r106);
        if ((r108 instanceof StoryProgressBar) == false) goto L24;
        int r109 = StoryProgressBar.f195326o;
        ((StoryProgressBar) r108).b(0.0f, false);
    L24:
        r106 = r106 + 1;
        goto L20
    L25:
        if (r101 >= 0) goto L27;
    L29:
        r104 = false;
    L30:
        if (r104 == false) goto L34;
        View r112 = r100.getChildAt(r101);
        if ((r112 instanceof StoryProgressBar) == false) goto L34;
        StoryProgressBar r113 = (StoryProgressBar) r112;
        r113.setAnimationInterval(r103);
        r113.b(r102, r111);
    L34:
        r100.f195298c = r101;
        return;
    L27:
        if (r101 >= r100.getChildCount()) goto L29;
    L12:
        if (r102 == 1.0f) goto L15;
        r104 = false;
    L15:
        if (r104 == false) goto L17;
        r100.h(r101, r102);
    L18:
        r100.k(r100.f195298c, r101);
        goto L34
    L17:
        r100.f(r101);
        goto L18
    L8:
        r111 = false;
        goto L9
    }
}
