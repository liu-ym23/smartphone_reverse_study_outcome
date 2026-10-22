package com.larus.common_ui.floatwindow.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.floatwindow.manager.IFloatWindowHostProvider;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes27.dex */
public final class FullScreenFloatWindowHandler implements v {
    public m A;
    public WeakReference<ViewGroup> B;
    public boolean C;
    public final WeakHashMap<Dialog, DialogInterface.OnKeyListener> D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f327419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f327420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<FrameLayout> f327421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e19.h f327422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e19.b f327423e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f327424f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HorizontalDragFrameLayout f327425g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f327426h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WeakReference<Context> f327427i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WeakReference<Context> f327428j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f327429k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f327430l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f327431m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IntRange f327432n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public IntRange f327433o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public IntRange f327434p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public IntRange f327435q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Integer f327436r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Float f327437s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f327438t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final OvershootInterpolator f327439u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final PathInterpolator f327440v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final PathInterpolator f327441w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public FullScreenFloatWindowHandler$setupInActivity$3$callback$1 f327442x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public FragmentManager f327443y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public FullScreenFloatWindowHandler$ensureFragmentLifecycleCallbacks$callback$1 f327444z;

    public static final class a implements f09.a.InterfaceC5845a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FullScreenFloatWindowHandler f327445a;

        @Override // f09.a.InterfaceC5845a
        public final void onPaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        public a(FullScreenFloatWindowHandler r100) {
            this.f327445a = r100;
        }

        @Override // f09.a.InterfaceC5845a
        public final void onPreDestroyed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // f09.a.InterfaceC5845a
        public final void onResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            FullScreenFloatWindowHandler r101 = this.f327445a;
            r101.v(r100, r101.f327422d, "activity-resumed");
        }

        @Override // f09.a.InterfaceC5845a
        public final void onStart(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // f09.a.InterfaceC5845a
        public final void onStopped(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // f09.a.InterfaceC5845a
        public final void onCreate(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f327446a = null;

        static {
            int[] r100 = new int[SingleFloatWindowState.values().length];
            r100[SingleFloatWindowState.MAXIMIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[SingleFloatWindowState.MINIMIZE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f327446a = r100;
        }
    }

    public static final class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FullScreenFloatWindowHandler f327447a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public d(FullScreenFloatWindowHandler r100) {
            this.f327447a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f327447a.f327429k = false;
        }
    }

    public static final class e implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FullScreenFloatWindowHandler f327448a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public e(FullScreenFloatWindowHandler r100) {
            this.f327448a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f327448a.f327429k = true;
        }
    }

    static {
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void c() {
        View r100 = this.f327426h;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNullParameter(r100, "view");
        w();
        return;
    L5:
        w();
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final SingleFloatWindowState d() {
        if (this.f327429k == false) goto L6;
        return SingleFloatWindowState.MAXIMIZE;
    L6:
        return SingleFloatWindowState.MINIMIZE;
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void e() {
        HorizontalDragFrameLayout r100 = this.f327425g;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.animate().cancel();
        float r101 = 0.0f;
        r100.setAlpha(0.0f);
        r100.setVisibility(0);
        if (this.f327429k == false) goto L8;
        r101 = 1.0f;
    L8:
        y(r101, false);
        r100.animate().alpha(1.0f).setDuration(150).setInterpolator(this.f327441w).start();
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void g() {
        v(AppHost.f326268a.a().getCurrentActivity(), this.f327422d, "reset-pos");
        if (this.f327429k == false) goto L5;
        float r100 = 1.0f;
    L6:
        y(r100, false);
        return;
    L5:
        r100 = 0.0f;
        goto L6
    }

    public final void m() {
        float r100 = this.f327430l;
        PathInterpolator r101 = this.f327440v;
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{r100, 0.0f});
        r102.setDuration(200);
        r102.setInterpolator(r101);
        r102.addUpdateListener(new j(this));
        Intrinsics.checkNotNull(r102);
        r102.addListener(new d(this));
        r102.start();
    }

    public final void n() {
        ValueAnimator r100 = ValueAnimator.ofFloat(new float[]{this.f327430l, 1.0f});
        r100.setDuration(350);
        r100.setInterpolator(this.f327439u);
        r100.addUpdateListener(new l(this));
        Intrinsics.checkNotNull(r100);
        r100.addListener(new e(this));
        r100.start();
    }

    public final void w() {
        FLogger.f375446a.d("FullScreenFloatWindowHandler", "hideFloatWindow");
        View r100 = this.f327424f;
        if (r100 == null) goto L10;
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L7;
        ViewGroup r102 = (ViewGroup) r101;
    L8:
        if (r102 == null) goto L10;
        r102.removeView(r100);
        goto L10
    L7:
        r102 = null;
    L10:
        this.f327424f = null;
        HorizontalDragFrameLayout r103 = this.f327425g;
        if (r103 == null) goto L18;
        ViewParent r104 = r103.getParent();
        if ((r104 instanceof ViewGroup) == false) goto L15;
        ViewGroup r105 = (ViewGroup) r104;
    L16:
        if (r105 == null) goto L18;
        r105.removeView(r103);
        goto L18
    L15:
        r105 = null;
    L18:
        this.f327425g = null;
        this.f327426h = null;
        this.f327422d = null;
        this.f327423e = null;
        this.f327429k = false;
        this.f327430l = 0.0f;
        FullScreenFloatWindowHandler$setupInActivity$3$callback$1 r106 = this.f327442x;
        if (r106 == null) goto L21;
        r106.remove();
    L21:
        this.f327442x = null;
        Iterator<Map.Entry<Dialog, DialogInterface.OnKeyListener>> r107 = this.D.entrySet().iterator();
    L23:
        if (r107.hasNext() == false) goto L32;
        Map.Entry<Dialog, DialogInterface.OnKeyListener> r108 = r107.next();
        Dialog r109 = r108.getKey();
        DialogInterface.OnKeyListener r110 = r108.getValue();
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L27
        r109.setOnKeyListener(r110);     // Catch: Throwable -> L27
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L23;
        FLogger.f375446a.e("FullScreenFloatWindowHandler", "restore dialog onKeyListener failed: " + r113);
    L27:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    L32:
        this.D.clear();
        FragmentManager r115 = this.f327443y;
        if (r115 == null) goto L37;
        FullScreenFloatWindowHandler$ensureFragmentLifecycleCallbacks$callback$1 r116 = this.f327444z;
        if (r116 == null) goto L37;
        r115.unregisterFragmentLifecycleCallbacks(r116);
    L37:
        this.f327443y = null;
        this.f327444z = null;
        m r117 = this.A;
        if (r117 == null) goto L44;
        WeakReference<ViewGroup> r118 = this.B;
        if (r118 == null) goto L44;
        ViewGroup r119 = r118.get();
        if (r119 == null) goto L44;
        r119.removeOnLayoutChangeListener(r117);
    L44:
        this.A = null;
        this.B = null;
        this.C = false;
        this.f327421c = null;
    }

    public FullScreenFloatWindowHandler(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        this.f327419a = r100;
        AppHost.Companion r101 = AppHost.f326268a;
        this.f327420b = r101.getApplication().getApplicationContext();
        this.f327431m = r100.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_16, null, R.dimen.larus_dp_16));
        this.f327438t = com.larus.utils.m0.b(r100);
        this.f327439u = new OvershootInterpolator(1.0f);
        new AnticipateInterpolator(1.0f);
        this.f327440v = new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f);
        this.f327441w = new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f);
        this.D = new WeakHashMap();
        r101.a().e(new a(this));
    }

    public static View j(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static final void k(final FullScreenFloatWindowHandler r100) {
        r100.getClass();
        final Activity r101 = AppHost.f326268a.a().getCurrentActivity();
        if (r101 == null) goto L13;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L11;
        View r103 = j(r102);
        if (r103 == null) goto L12;
        r103.post(new k(r100, r101));
        return;
    L12:
        return;
    L11:
        return;
    }

    public static String s(e19.b r100) {
        return r100.f470715a + '@' + System.identityHashCode(r100.f470716b) + "(parent=" + r100.f470716b.getClass().getSimpleName() + ", local=" + r100.f470717c + ", screen=" + r100.f470718d + ", orientation=" + r100.f470719e + ')';
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void a(final Function0<Unit> r100) {
        final HorizontalDragFrameLayout r101 = this.f327425g;
        if (r101 != null) goto L9;
        View r102 = this.f327424f;
        if (r102 == null) goto L7;
        r102.setVisibility(8);
    L7:
        r100.invoke();
        return;
    L9:
        r101.animate().cancel();
        r101.setAlpha(1.0f);
        r101.animate().alpha(0.0f).setDuration(150).setInterpolator(this.f327441w).withEndAction(new r(r101, this, r100)).start();
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final Rect f(boolean r100) {
        Rect r101 = new Rect();
        HorizontalDragFrameLayout r102 = this.f327425g;
        if (r102 == null) goto L5;
        int[] r103 = new int[2];
        r102.getLocationOnScreen(r103);
        int r104 = r103[0];
        r101.set(r104, r103[1], r102.getWidth() + r104, r103[1] + r102.getHeight());
    L5:
        return r101;
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void i(AppCompatActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        FLogger r101 = FLogger.f375446a;
        r101.d("FullScreenFloatWindowHandler", "forwardSwitch activity: " + r100);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Activity r103 = com.larus.common_ui.floatwindow.view.e.b(r100);     // Catch: Throwable -> L5
        r101.d("FullScreenFloatWindowHandler", "forwardSwitch forwardActivity: " + r103);     // Catch: Throwable -> L5
        v(r103, this.f327422d, "forward-switch");     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L13;
        FLogger.f375446a.d("FullScreenFloatWindowHandler", "forwardSwitch crash. throwable:" + r105.getMessage());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void removeView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        w();
    }

    public final DialogFragment t(Fragment r100) {
        if (r100.isAdded() == true) goto L5;
    L93:
        return null;
    L5:
        if (r100.isDetached() == true) goto L93;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        Object r102 = Result.m9449constructorimpl(u(r100.getChildFragmentManager()));     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r102) == false) goto L14;
        r102 = null;
    L14:
        DialogFragment r103 = (DialogFragment) r102;
        if (r103 == null) goto L17;
        return r103;
    L17:
        e19.h r104 = this.f327422d;
        if (r104 == null) goto L21;
        List<String> r105 = r104.d();
        if (r105 == null) goto L21;
    L23:
        if ((r100 instanceof DialogFragment) == false) goto L93;
        DialogFragment r106 = (DialogFragment) r100;
        if (r106.isAdded() == false) goto L93;
        if (r106.isDetached() == true) goto L93;
        Dialog r107 = r106.getDialog();
        boolean r108 = false;
        boolean r109 = true;
        if (r107 != null) goto L31;
    L33:
        boolean r110 = false;
    L34:
        if (r110 == false) goto L93;
        if (CollectionsKt.contains(r105, r106.getTag()) == true) goto L93;
        Dialog r111 = r106.getDialog();
        if (r111 == null) goto L42;
        Window r112 = r111.getWindow();
        if (r112 == null) goto L42;
        View r113 = j(r112);
    L44:
        if ((r113 instanceof ViewGroup) == false) goto L46;
        ViewGroup r114 = (ViewGroup) r113;
    L47:
        if (r114 != null) goto L49;
    L51:
        boolean r115 = false;
    L52:
        if (r115 == false) goto L93;
        Context r116 = r114.getContext();
        if (r116 != null) goto L56;
        r116 = this.f327419a;
    L56:
        int r117 = com.larus.utils.m0.b(r116);
        int r118 = com.larus.utils.m0.a(r116);
        int r119 = r114.getWidth();
        int r120 = r114.getHeight();
        if (r119 == 0) goto L90;
        if (r120 == 0) goto L90;
        if (r119 != r117) goto L62;
        boolean r121 = true;
    L63:
        if (r120 != r118) goto L65;
        boolean r122 = true;
    L66:
        if (r121 == false) goto L69;
        if (r122 == false) goto L69;
    L91:
        if (r109 == false) goto L93;
        return r106;
    L69:
        Dialog r123 = r106.getDialog();
        if (r123 == null) goto L74;
        Window r124 = r123.getWindow();
        if (r124 == null) goto L74;
        WindowManager.LayoutParams r125 = r124.getAttributes();
    L76:
        if (r125 != null) goto L78;
    L80:
        boolean r126 = false;
    L81:
        if (r125 != null) goto L83;
    L85:
        boolean r127 = false;
    L86:
        if (r126 == false) goto L90;
        if (r127 == false) goto L90;
        if (r121 == false) goto L90;
        r108 = true;
        goto L90
    L83:
        if (r125.height != (-1)) goto L85;
        r127 = true;
        goto L86
    L78:
        if (r125.width != (-1)) goto L80;
        r126 = true;
    L74:
        r125 = null;
        goto L76
    L65:
        r122 = false;
        goto L66
    L62:
        r121 = false;
    L90:
        r109 = r108;
        goto L91
    L49:
        if (r114.isAttachedToWindow() != true) goto L51;
        r115 = true;
        goto L52
    L46:
        r114 = null;
    L42:
        r113 = null;
        goto L44
    L31:
        if (r107.isShowing() != true) goto L33;
        r110 = true;
    L21:
        r105 = CollectionsKt.emptyList();
    L9:
        th = move-exception;
        Result.Companion r128 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final DialogFragment u(FragmentManager r100) {
        Iterator r101 = CollectionsKt.asReversedMutable(r100.getFragments()).iterator();
    L3:
        DialogFragment r102 = null;
        if (r101.hasNext() == false) goto L11;
        Fragment r103 = (Fragment) r101.next();
        if (r103.isAdded() == false) goto L10;
        if (r103.isDetached() == true) goto L10;
        Intrinsics.checkNotNull(r103);
        r102 = t(r103);
    L10:
        if (r102 == null) goto L3;
    L11:
        return r102;
    }

    public static boolean o(FrameLayout r100, e19.b r101) {
        Rect r102 = r101.f470717c;
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
    L6:
        if (r104 != null) goto L9;
        r104 = new FrameLayout.LayoutParams(r102.width(), r102.height());
    L9:
        if (r104.width == r102.width()) goto L11;
    L22:
        r104.width = r102.width();
        r104.height = r102.height();
        r104.leftMargin = r102.left;
        r104.topMargin = r102.top;
        r104.rightMargin = 0;
        r104.bottomMargin = 0;
        r100.setLayoutParams(r104);
        return true;
    L11:
        if (r104.height != r102.height()) goto L22;
        if (r104.leftMargin != r102.left) goto L22;
        if (r104.topMargin != r102.top) goto L22;
        if (r104.rightMargin != 0) goto L22;
        if (r104.bottomMargin != 0) goto L22;
        return false;
    L5:
        r104 = null;
        goto L6
    }

    public static void q(FrameLayout r100, View r101) {
        FrameLayout.LayoutParams r102 = null;
        ViewGroup r103 = null;
        if (r101.getParent() == r100) goto L11;
        ViewParent r104 = r101.getParent();
        if ((r104 instanceof ViewGroup) == false) goto L7;
        r103 = (ViewGroup) r104;
    L7:
        if (r103 == null) goto L9;
        r103.removeView(r101);
    L9:
        r100.addView(r101, 0, new FrameLayout.LayoutParams(-1, -1));
        return;
    L11:
        ViewGroup.LayoutParams r105 = r101.getLayoutParams();
        if ((r105 instanceof FrameLayout.LayoutParams) == false) goto L14;
        r102 = (FrameLayout.LayoutParams) r105;
    L14:
        if (r102 != null) goto L17;
        return;
    L17:
        if (r102.width == (-1)) goto L19;
    L20:
        r102.width = -1;
        r102.height = -1;
        r101.setLayoutParams(r102);
        return;
    L19:
        if (r102.height != (-1)) goto L20;
    }

    public static void r(ViewGroup r100, FrameLayout r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101.getParent() == r100) goto L7;
        return;
    L7:
        if (r100.indexOfChild(r101) == (r100.getChildCount() - 1)) goto L11;
        r101.bringToFront();
        r100.invalidate();
        return;
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void b(SingleFloatWindowState r100, boolean r101) {
        if (r100 != null) goto L4;
        int r102 = -1;
    L6:
        if (r102 == 1) goto L17;
        if (r102 == 2) goto L11;
        return;
    L11:
        if (this.f327429k == true) goto L13;
        return;
    L13:
        if (r101 == false) goto L15;
        m();
        return;
    L15:
        this.f327429k = false;
        y(0.0f, false);
        return;
    L17:
        if (this.f327429k == false) goto L19;
        return;
    L19:
        if (r101 == false) goto L21;
        n();
        return;
    L21:
        this.f327429k = true;
        y(1.0f, false);
        return;
    L4:
        r102 = c.f327446a[r100.ordinal()];
        goto L6
    }

    public final void l(Context r100, e19.h r101) {
        r101.a();
        HorizontalDragFrameLayout r102 = this.f327425g;
        if (r102 == null) goto L19;
        View r103 = this.f327426h;
        ViewGroup r104 = null;
        if (r103 == null) goto L12;
        ViewParent r105 = r103.getParent();
        if ((r105 instanceof ViewGroup) == false) goto L9;
        ViewGroup r106 = (ViewGroup) r105;
    L10:
        if (r106 == null) goto L12;
        r106.removeView(r103);
        goto L12
    L9:
        r106 = null;
    L12:
        View r107 = r101.l(r100);
        this.f327426h = r107;
        ViewParent r108 = r107.getParent();
        if ((r108 instanceof ViewGroup) == false) goto L15;
        r104 = (ViewGroup) r108;
    L15:
        if (r104 == null) goto L17;
        r104.removeView(r107);
    L17:
        r102.removeAllViews();
        r102.addView(r107, new FrameLayout.LayoutParams(this.f327438t, -1));
        r101.b();
        return;
    }

    public final void p(FrameLayout r100, HorizontalDragFrameLayout r101) {
        FrameLayout.LayoutParams r102 = null;
        ViewGroup r103 = null;
        if (r101.getParent() == r100) goto L11;
        ViewParent r104 = r101.getParent();
        if ((r104 instanceof ViewGroup) == false) goto L7;
        r103 = (ViewGroup) r104;
    L7:
        if (r103 == null) goto L9;
        r103.removeView(r101);
    L9:
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(this.f327438t, -1);
        r105.gravity = GravityCompat.END;
        r100.addView(r101, r105);
        return;
    L11:
        ViewGroup.LayoutParams r106 = r101.getLayoutParams();
        if ((r106 instanceof FrameLayout.LayoutParams) == false) goto L14;
        r102 = (FrameLayout.LayoutParams) r106;
    L14:
        if (r102 == null) goto L23;
        int r107 = r102.width;
        int r108 = this.f327438t;
        if (r107 == r108) goto L18;
    L21:
        r102.width = r108;
        r102.height = -1;
        r102.gravity = GravityCompat.END;
        r101.setLayoutParams(r102);
        return;
    L18:
        if (r102.height != (-1)) goto L21;
        if (r102.gravity != 8388613) goto L21;
        return;
    }

    public final void y(float r100, boolean r101) {
        float r102 = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        this.f327430l = r102;
        View r103 = this.f327424f;
        if (r103 == null) goto L9;
        r103.setAlpha(r102);
        if (r102 <= 0.0f) goto L7;
        int r104 = 0;
    L8:
        r103.setVisibility(r104);
        goto L9
    L7:
        r104 = 8;
    L9:
        HorizontalDragFrameLayout r105 = this.f327425g;
        i r106 = null;
        if (r105 != null) goto L12;
    L28:
        HorizontalDragFrameLayout r107 = this.f327425g;
        if (r107 == null) goto L33;
        Sequence<View> r108 = ViewGroupKt.getChildren(r107);
        if (r108 == null) goto L33;
        View r109 = (View) SequencesKt.firstOrNull(r108);
    L35:
        if ((r109 instanceof i) == false) goto L37;
        r106 = (i) r109;
    L37:
        if (r106 == null) goto L40;
        r106.a(r102, r101);
        return;
    L40:
        return;
    L33:
        r109 = null;
        goto L35
    L12:
        if (r102 > 0.0f) goto L14;
        IntRange r110 = this.f327432n;
    L15:
        r105.setDragHotArea(r110);
        if (r102 > 0.0f) goto L18;
        IntRange r111 = this.f327433o;
    L19:
        r105.setDragHotAreaX(r111);
        if (r102 > 0.0f) goto L22;
        IntRange r112 = this.f327434p;
    L23:
        r105.setClickHotArea(r112);
        if (r102 > 0.0f) goto L26;
        IntRange r113 = this.f327435q;
    L27:
        r105.setClickHotAreaX(r113);
        r105.setTranslationX(RangesKt.coerceAtLeast(this.f327438t - this.f327431m, 0.0f) * (1.0f - r102));
        goto L28
    L26:
        r113 = null;
        goto L27
    L22:
        r112 = null;
        goto L23
    L18:
        r111 = null;
        goto L19
    L14:
        r110 = null;
        goto L15
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void h(e19.h r100, SingleFloatWindowState r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "request");
        e19.h r101 = this.f327422d;
        this.f327422d = r100;
        float r102 = 0.0f;
        if (r101 == r100) goto L5;
        this.f327429k = false;
        this.f327430l = 0.0f;
    L5:
        Activity r103 = AppHost.f326268a.a().getCurrentActivity();
        if (r103 != null) goto L8;
        return;
    L8:
        FrameLayout r104 = x(r103, r100, "update-view");
        if (r104 != null) goto L11;
        return;
    L11:
        View r105 = this.f327424f;
        if (r105 != null) goto L14;
        r105 = new View(this.f327420b);
        r105.setTag("fullscreen_mask");
        r105.setAlpha(0.0f);
        r105.setVisibility(8);
        r105.setImportantForAccessibility(2);
        r105.setOnClickListener(new o(this));
        this.f327424f = r105;
    L14:
        r105.setBackgroundColor(r100.c());
        q(r104, r105);
        HorizontalDragFrameLayout r106 = this.f327425g;
        IntRange r107 = null;
        if (r106 != null) goto L18;
        r106 = new HorizontalDragFrameLayout(this.f327420b, null, 6, 0);
        r106.setTag("fullscreen_content");
        this.f327425g = r106;
        r106.setOnDragListener(new t(r106, this));
    L18:
        if (this.f327430l > 0.0f) goto L20;
        IntRange r108 = this.f327432n;
    L21:
        r106.setDragHotArea(r108);
        if (this.f327430l > 0.0f) goto L24;
        IntRange r109 = this.f327433o;
    L25:
        r106.setDragHotAreaX(r109);
        if (this.f327430l > 0.0f) goto L28;
        IntRange r112 = this.f327434p;
    L29:
        r106.setClickHotArea(r112);
        if (this.f327430l > 0.0f) goto L32;
        r107 = this.f327435q;
    L32:
        r106.setClickHotAreaX(r107);
        r106.setOnClickHotAreaListener(new s(this));
        l(r103, r100);
        p(r104, r106);
        if (this.f327429k == false) goto L35;
        r102 = 1.0f;
    L35:
        y(r102, false);
        b(r110, r111);
        return;
    L28:
        r112 = null;
        goto L29
    L24:
        r109 = null;
        goto L25
    L20:
        r108 = null;
        goto L21
    }

    public final void v(Activity r100, e19.h r101, String r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101 != this.f327422d) goto L9;
        x(r100, r101, r102);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v31, types: [android.view.ViewGroup, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v43, types: [androidx.activity.OnBackPressedCallback, com.larus.common_ui.floatwindow.view.FullScreenFloatWindowHandler$setupInActivity$3$callback$1] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.fragment.app.FragmentManager] */
    /* JADX WARN: Type inference failed for: r0v82 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v3, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r2v18, types: [androidx.activity.OnBackPressedDispatcher] */
    /* JADX WARN: Type inference failed for: r2v38, types: [androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks, com.larus.common_ui.floatwindow.view.FullScreenFloatWindowHandler$ensureFragmentLifecycleCallbacks$callback$1] */
    /* JADX WARN: Type inference failed for: r4v19, types: [com.larus.common_ui.floatwindow.view.m] */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v9, types: [android.view.View$OnLayoutChangeListener] */
    public final FrameLayout x(Activity r210, e19.h r211, String r212) {
        Activity r100 = com.larus.common_ui.floatwindow.view.e.a(r210);
        if (r100 != null) goto L5;
        return null;
    L5:
        v19.f.a(r100.getTheme());
        if (r211 != null) goto L8;
        return null;
    L8:
        boolean r110 = r100 instanceof FragmentActivity;
        if (r110 == false) goto L11;
        FragmentActivity r101 = (FragmentActivity) r100;
    L12:
        if (r101 == null) goto L32;
        FragmentManager r102 = r101.getSupportFragmentManager();
        if (r102 == null) goto L32;
        Iterator r103 = CollectionsKt.asReversedMutable(r102.getFragments()).iterator();
    L17:
        if (r103.hasNext() == false) goto L32;
        Fragment r104 = (Fragment) r103.next();
        Intrinsics.checkNotNull(r104);
        DialogFragment r105 = t(r104);
        if (r105 == null) goto L25;
        Dialog r106 = r105.getDialog();
        if (r106 == null) goto L25;
        Window r107 = r106.getWindow();
        if (r107 == null) goto L25;
        View r108 = j(r107);
    L27:
        if ((r108 instanceof ViewGroup) == false) goto L29;
        ViewGroup r109 = (ViewGroup) r108;
    L30:
        if (r109 == null) goto L17;
    L33:
        if (r109 != null) goto L42;
        Window r111 = r100.getWindow();
        if (r111 == null) goto L37;
        View r112 = j(r111);
    L39:
        if ((r112 instanceof ViewGroup) == false) goto L41;
        ViewGroup r113 = (ViewGroup) r112;
    L43:
        if (r113 != null) goto L45;
        return null;
    L45:
        if (r110 == false) goto L47;
        FragmentActivity r114 = (FragmentActivity) r100;
    L48:
        if (r114 == null) goto L50;
        ?? r115 = r114.getSupportFragmentManager();
    L51:
        FragmentManager r116 = this.f327443y;
        boolean r117 = true;
        if (r116 == r115) goto L62;
        if (r116 == null) goto L58;
        FullScreenFloatWindowHandler$ensureFragmentLifecycleCallbacks$callback$1 r118 = this.f327444z;
        if (r118 == null) goto L58;
        r116.unregisterFragmentLifecycleCallbacks(r118);
    L58:
        this.f327443y = r115;
        if (r115 != 0) goto L61;
        this.f327444z = null;
        goto L62
    L61:
        ?? r119 = new FullScreenFloatWindowHandler$ensureFragmentLifecycleCallbacks$callback$1(this);
        r115.registerFragmentLifecycleCallbacks(r119, true);
        this.f327444z = r119;
    L62:
        e19.b r120 = this.f327423e;
        int r121 = e19.e.f470725a;
        e19.c r122 = new e19.c(r211, r100, r113, r120, r212);
        Intrinsics.checkNotNullParameter(r122, PerfLog.PARAM_KEY_CONTEXT_ID);
        Iterator r123 = CollectionsKt.sortedWith(CollectionsKt.toList(ServiceManager.get().getServices(IFloatWindowHostProvider.class)), new e19.d()).iterator();
    L64:
        if (r123.hasNext() == false) goto L100;
        IFloatWindowHostProvider r124 = (IFloatWindowHostProvider) r123.next();
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L68
        Object r126 = Result.m9449constructorimpl(r124.provideFloatWindowHost(r122));     // Catch: Throwable -> L68
    L70:
        Throwable r127 = Result.m9452exceptionOrNullimpl(r126);
        if (r127 == null) goto L78;
        FLogger r128 = FLogger.f375446a;
        StringBuilder r129 = new StringBuilder("provider failed, provider=");
        r129.append(r124.getClass().getSimpleName());
        r129.append(", bizSource=");
        e19.h r130 = r122.f470720a;
        if (r130 == null) goto L75;
        String r131 = r130.k();
    L76:
        r129.append(r131);
        r129.append(", reason=");
        r129.append(r122.f470724e);
        r128.e("FloatWindowHostResolver", r129.toString(), r127);
        goto L78
    L75:
        r131 = null;
    L78:
        if (Result.m9455isFailureimpl(r126) == false) goto L80;
        r126 = null;
    L80:
        e19.b r132 = (e19.b) r126;
        if (r132 == null) goto L96;
        Rect r133 = new Rect(r132.f470717c);
        Rect r134 = new Rect(r132.f470718d);
        String r135 = r132.f470715a;
        ViewGroup r136 = r132.f470716b;
        int r137 = r132.f470719e;
        Intrinsics.checkNotNullParameter(r135, "hostId");
        Intrinsics.checkNotNullParameter(r136, "parent");
        Intrinsics.checkNotNullParameter(r133, "localBounds");
        Intrinsics.checkNotNullParameter(r134, "screenBounds");
        e19.b r138 = new e19.b(r135, r136, r133, r134, r137);
        if (r138.f470716b.isAttachedToWindow() == true) goto L85;
    L93:
        boolean r139 = false;
    L94:
        if (r139 == false) goto L96;
        final e19.b r140 = r138;
    L97:
        if (r140 == null) goto L64;
    L101:
        if (r140 != null) goto L137;
        ViewGroup r141 = r122.f470722c;
        if (r141 == null) goto L135;
        Context r142 = r141.getContext();
        Integer r143 = Integer.valueOf(r141.getWidth());
        if (r143.intValue() <= 0) goto L109;
        boolean r144 = true;
    L110:
        if (r144 == true) goto L113;
        r143 = null;
    L113:
        if (r143 == null) goto L115;
        int r145 = r143.intValue();
    L116:
        Integer r146 = Integer.valueOf(r141.getHeight());
        if (r146.intValue() <= 0) goto L119;
        boolean r147 = true;
    L120:
        if (r147 == true) goto L123;
        r146 = null;
    L123:
        if (r146 == null) goto L125;
        int r148 = r146.intValue();
    L126:
        if (r145 <= 0) goto L135;
        if (r148 <= 0) goto L135;
        Rect r149 = new Rect(0, -r141.getPaddingTop(), r145, r148 + r141.getPaddingBottom());
        Rect r150 = new Rect();
        if (r141.getGlobalVisibleRect(r150) == true) goto L132;
    L133:
        int[] r151 = new int[2];
        r141.getLocationOnScreen(r151);
        int r152 = r151[0];
        int r153 = r151[1];
        r150.set(r152, r149.top + r153, r149.right + r152, r153 + r149.bottom);
    L134:
        r140 = new e19.b("activity_decor", r141, r149, r150, r141.getResources().getConfiguration().orientation);
        goto L137
    L132:
        if (r150.isEmpty() == false) goto L134;
    L125:
        r148 = com.larus.utils.m0.a(r142);
        goto L126
    L119:
        r147 = false;
        goto L120
    L115:
        r145 = com.larus.utils.m0.b(r142);
        goto L116
    L109:
        r144 = false;
    L135:
        r140 = null;
    L137:
        if (r140 != null) goto L139;
        return null;
    L139:
        if (r120 == null) goto L141;
        String r154 = r120.f470715a;
    L143:
        if (Intrinsics.areEqual(r154, r140.f470715a) == true) goto L145;
    L151:
        boolean r155 = false;
    L152:
        boolean r156 = !r155;
        this.f327423e = r140;
        if (r156 == false) goto L159;
        FLogger r157 = FLogger.f375446a;
        StringBuilder r158 = new StringBuilder("float host changed. reason=");
        r158.append(r212);
        r158.append(", from=");
        if (r120 == null) goto L157;
        String r159 = s(r120);
    L158:
        r158.append(r159);
        r158.append(", to=");
        r158.append(s(r140));
        r158.append(", activity=");
        r158.append(r100.getClass().getSimpleName());
        r158.append('@');
        r158.append(System.identityHashCode(r100));
        r158.append(", bizSource=");
        r158.append(r211.k());
        r157.i("FullScreenFloatWindowHandler", r158.toString());
        r211.j(r140);
        goto L159
    L157:
        r159 = null;
    L159:
        e19.f r160 = r211.h();
        this.f327431m = r160.f470726a;
        this.f327432n = r160.f470727b;
        this.f327433o = r160.f470728c;
        this.f327434p = r160.f470729d;
        this.f327435q = r160.f470730e;
        this.f327436r = r160.f470731f;
        this.f327437s = r160.f470732g;
        int r161 = r140.f470717c.width();
        if (r161 <= 0) goto L162;
        int r162 = RangesKt.coerceAtMost(r211.getWidth(), r161);
    L163:
        this.f327438t = RangesKt.coerceAtLeast(r162, 0);
        ?? r163 = r140.f470716b;
        m r164 = this.A;
        ?? r165 = r164;
        if (r164 != null) goto L166;
        ?? r166 = new m(this);
        this.A = r166;
        r165 = r166;
    L166:
        WeakReference<ViewGroup> r167 = this.B;
        if (r167 == null) goto L169;
        ?? r168 = r167.get();
    L170:
        if (r168 == r163) goto L174;
        if (r168 == 0) goto L173;
        r168.removeOnLayoutChangeListener(r165);
    L173:
        r163.addOnLayoutChangeListener(r165);
        this.B = new WeakReference(r163);
    L174:
        final ViewGroup r169 = r140.f470716b;
        WeakReference<FrameLayout> r170 = this.f327421c;
        if (r170 == null) goto L177;
        final FrameLayout r171 = r170.get();
    L178:
        Iterator<View> r172 = ViewGroupKt.getChildren(r169).iterator();
    L180:
        if (r172.hasNext() == false) goto L188;
        View r173 = r172.next();
        if (r173.getTag() != "global.fullscreen_float_container") goto L184;
        boolean r174 = true;
    L185:
        if (r174 == false) goto L180;
    L190:
        if ((r173 instanceof FrameLayout) == false) goto L192;
        FrameLayout r175 = (FrameLayout) r173;
    L193:
        if (r175 != null) goto L196;
        if (r171 != null) goto L197;
        r171 = new FrameLayout(this.f327420b);
        r171.setTag("global.fullscreen_float_container");
    L197:
        r171.setClipChildren(true);
        r171.setClipToPadding(true);
        if (r171.getParent() == r169) goto L202;
        r117 = false;
    L202:
        if (r171.getParent() == r169) goto L219;
        ViewParent r176 = r171.getParent();
        if ((r176 instanceof ViewGroup) == false) goto L206;
        ViewGroup r177 = (ViewGroup) r176;
    L207:
        FLogger r178 = FLogger.f375446a;
        StringBuilder r179 = new StringBuilder("float container reparent. from=");
        if (r177 == null) goto L210;
        String r180 = r177.getClass().getSimpleName();
    L211:
        r179.append(r180);
        r179.append('@');
        if (r177 == null) goto L214;
        Integer r181 = Integer.valueOf(System.identityHashCode(r177));
    L215:
        r179.append(r181);
        r179.append(", to=");
        r179.append(r169.getClass().getSimpleName());
        r179.append('@');
        r179.append(System.identityHashCode(r169));
        r179.append(", host=");
        r179.append(s(r140));
        r178.i("FullScreenFloatWindowHandler", r179.toString());
        if (r177 == null) goto L218;
        r177.removeView(r171);
    L218:
        r169.addView(r171, new ViewGroup.MarginLayoutParams(r140.f470717c.width(), r140.f470717c.height()));
        goto L219
    L214:
        r181 = null;
        goto L215
    L210:
        r180 = null;
        goto L211
    L206:
        r177 = null;
    L219:
        boolean r182 = o(r171, r140);
        if (r117 == false) goto L224;
        if (r182 == true) goto L224;
        r(r169, r171);
    L225:
        this.f327421c = new WeakReference(r171);
        View r183 = this.f327424f;
        if (r183 == null) goto L228;
        q(r171, r183);
    L228:
        HorizontalDragFrameLayout r184 = this.f327425g;
        if (r184 == null) goto L231;
        p(r171, r184);
    L231:
        Context r185 = r140.f470716b.getContext();
        WeakReference<Context> r186 = this.f327428j;
        if (r186 == null) goto L234;
        Context r187 = r186.get();
    L235:
        WeakReference<Context> r188 = this.f327427i;
        if (r188 == null) goto L238;
        Context r189 = r188.get();
    L239:
        if (r189 != r185) goto L242;
        if (r187 == null) goto L242;
    L243:
        l(r187, r211);
        if (this.f327429k == false) goto L246;
        float r190 = 1.0f;
    L247:
        y(r190, false);
        if (r110 == false) goto L250;
        final FragmentActivity r191 = (FragmentActivity) r100;
    L251:
        if (r191 == null) goto L256;
        FullScreenFloatWindowHandler$setupInActivity$3$callback$1 r192 = this.f327442x;
        if (r192 == null) goto L255;
        r192.remove();
    L255:
        ?? r193 = new FullScreenFloatWindowHandler$setupInActivity$3$callback$1(this, r191);
        r191.getOnBackPressedDispatcher().addCallback(r191, r193);
        this.f327442x = r193;
    L256:
        return r171;
    L250:
        r191 = null;
        goto L251
    L246:
        r190 = 0.0f;
    L242:
        r187 = v19.f.d(r185);
        this.f327427i = new WeakReference(r185);
        this.f327428j = new WeakReference(r187);
        goto L243
    L238:
        r189 = null;
        goto L239
    L234:
        r187 = null;
    L224:
        r169.post(new p(r171, r169, this, r140));
        goto L225
    L196:
        r171 = r175;
        goto L197
    L192:
        r175 = null;
        goto L193
    L184:
        r174 = false;
        goto L185
    L188:
        r173 = null;
        goto L190
    L177:
        r171 = null;
        goto L178
    L169:
        r168 = 0;
        goto L170
    L162:
        r162 = r211.getWidth();
        goto L163
    L145:
        if (r120.f470716b != r140.f470716b) goto L151;
        if (Intrinsics.areEqual(r120.f470717c, r140.f470717c) == false) goto L151;
        if (r120.f470719e != r140.f470719e) goto L151;
        r155 = true;
        goto L152
    L141:
        r154 = null;
        goto L143
    L85:
        if (r138.f470717c.width() <= 0) goto L93;
        if (r138.f470717c.height() <= 0) goto L93;
        if (r138.f470718d.width() <= 0) goto L93;
        if (r138.f470718d.height() <= 0) goto L93;
        r139 = true;
    L96:
        r140 = null;
    L68:
        th = move-exception;
        Result.Companion r194 = Result.Companion;
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L70
    L100:
        r140 = null;
        goto L101
    L50:
        r115 = 0;
        goto L51
    L47:
        r114 = null;
        goto L48
    L41:
        r113 = null;
        goto L43
    L37:
        r112 = null;
        goto L39
    L42:
        r113 = r109;
        goto L43
    L29:
        r109 = null;
    L25:
        r108 = null;
    L32:
        r109 = null;
        goto L33
    L11:
        r101 = null;
        goto L12
    }
}
