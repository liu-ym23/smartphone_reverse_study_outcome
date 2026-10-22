package com.bytedance.ee.bear.bitable.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bitable.anniex.holder.BitableLynxViewHolder;
import com.bytedance.ee.bear.bitable.app.model.AppTheme;
import com.bytedance.ee.bear.bitable.app.model.ShowTitleHeaderData;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.q1;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 b2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001bBE\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010B\u001a\u00020+H\u0007J\u0006\u0010C\u001a\u00020+J\u0012\u0010D\u001a\u00020+2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010E\u001a\u00020+2\u0006\u0010F\u001a\u00020\u0015H\u0002J\b\u0010G\u001a\u00020+H\u0002J\b\u0010H\u001a\u00020\u001eH\u0002J\b\u0010I\u001a\u00020+H\u0002J\u001c\u0010J\u001a\u00020+2\b\u0010K\u001a\u0004\u0018\u00010L2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\fJ\u0006\u0010N\u001a\u00020\u0015J\b\u0010O\u001a\u00020\fH\u0016J \u0010P\u001a\u00020+2\u0016\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010S\u0018\u00010RH\u0016J\u0006\u0010T\u001a\u00020+J\b\u0010U\u001a\u00020+H\u0002J\u0006\u0010V\u001a\u00020+J\b\u0010W\u001a\u00020+H\u0016J\u0006\u0010\u0014\u001a\u00020\u0015J\u001a\u0010X\u001a\u00020+2\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020+0*J\u001a\u0010Z\u001a\u00020+2\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020+0*J0\u0010[\u001a\u00020+2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020]2\b\u0010_\u001a\u0004\u0018\u00010]2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020+0\u000bH\u0002J\f\u0010a\u001a\u00020+*\u00020]H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020+\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020+\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00100\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0004\n\u0002\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00110?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/bytedance/ee/bear/bitable/app/BitableAppDrawerManager;", "Lcom/bytedance/ee/bear/bitable/lynx/ILynxToJSBridgeService;", "Lcom/bytedance/ee/bear/bitable/app/AppDrawerHolder;", "Landroidx/lifecycle/LifecycleObserver;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "tokenProvider", "Lkotlin/Function0;", "", "viewPort", "Lcom/bytedance/ee/bear/bitable/app/BitableAppDrawerViewPort;", "theme", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/ee/bear/bitable/app/model/AppTheme;", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Lcom/bytedance/ee/bear/bitable/app/BitableAppDrawerViewPort;Landroidx/lifecycle/LiveData;)V", "isDrawerOpen", "", "contentView", "Landroid/view/View;", "drawerContainer", "Landroid/widget/FrameLayout;", "contentContainer", "contentInnerContainer", "appBar", "drawerWidth", "", "overlayView", "touchSlop", "getTouchSlop", "()I", "touchSlop$delegate", "Lkotlin/Lazy;", "downRawX", "", "downRawY", "isDragging", "onDrawerStateChanged", "Lkotlin/Function1;", "", "onDrawerVisibilityChanged", "overlayClickListener", "Landroid/view/View$OnClickListener;", "isNeedToChangeDrawerWidth", "oldContentViewWidth", "Ljava/lang/Integer;", "viewWidthChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "lynxViewHolder", "Lcom/bytedance/ee/bear/anniex/IBitableLarkLynxKitViewHolder;", "callBack", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "cachedTheme", "lynxLoadSucceed", "destroyed", "activeAnimators", "", "Landroid/animation/Animator;", "themeObserver", "Landroidx/lifecycle/Observer;", "layoutInitializer", "Ljava/lang/Runnable;", LiveCommonConstants.REASON_ON_DEDTROY, MapMonitorConst.EVENT_DESTROY, "setTheme2Lynx", "setHideTitleHeader2Lynx", "isHide", "initializeViews", "getStatusBarHeight", "createOverlayView", "loadData", "content", "Lcom/bytedance/ee/bear/bitable/app/model/DrawerContentModel;", "headerData", "isLynxContentLoaded", "getBridgeName", "onCallback", "params", "", "", "toggleDrawer", "updateDrawerLayout", "openDrawer", "closeDrawer", "setOnDrawerStateChangedListener", "listener", "setOnDrawerVisibilityChangedListener", "setupAnimators", "drawerAnimator", "Landroid/animation/ObjectAnimator;", "contentAnimator", "appBarAnimator", "onEnd", "startTracked", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableAppDrawerManager implements com.bytedance.ee.bear.bitable.lynx.h, com.bytedance.ee.bear.bitable.app.a, LifecycleObserver {
    public AppTheme A;
    public boolean B;
    public boolean C;
    public final Set<Animator> D;
    public final f E;
    public final com.bytedance.ee.bear.bitable.app.d F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f206802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lifecycle f206803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleOwner f206804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<String> f206805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f206806e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LiveData<AppTheme> f206807f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f206808g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f206809h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FrameLayout f206810i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f206811j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f206812k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f206813l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f206814m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f206815n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f206816o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f206817p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f206818q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f206819r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f206820s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f206821t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final e f206822u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f206823v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Integer f206824w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.app.c f206825x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public BitableLynxViewHolder f206826y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public tb5.m f206827z;

    public static final class a {
    }

    public static final class b extends q1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableAppDrawerManager f206828a;

        @Override // com.lynx.tasm.q1
        public final void onLoadSuccess() {
            super.onLoadSuccess();
            BitableAppDrawerManager r100 = this.f206828a;
            if (r100.C == false) goto L5;
            return;
        L5:
            r100.B = true;
            AppTheme r101 = r100.A;
            if (r101 == null) goto L11;
            BitableLynxViewHolder r102 = r100.f206826y;
            if (r102 == null) goto L12;
            r102.k("bitable.setAppDrawerTheme", mu5.b.e(r101));
            return;
        L12:
            return;
        }

        public b(BitableAppDrawerManager r100) {
            this.f206828a = r100;
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableAppDrawerManager f206829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f206830b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f206829a.C == true) goto L6;
            this.f206830b.invoke();
            return;
        }

        public c(BitableAppDrawerManager r100, Function0<Unit> r101) {
            this.f206829a = r100;
            this.f206830b = r101;
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableAppDrawerManager f206831a;

        public d(BitableAppDrawerManager r100) {
            this.f206831a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f206831a.D.remove(r100);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f206831a.D.remove(r100);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.lynx.h
    public final String Hk() {
        return BitableAppFrameworkPlugin.HANDLER_SET_APP_DRAWER;
    }

    public final void a() {
        if (this.C == false) goto L5;
        return;
    L5:
        this.C = true;
        tt5.a.h("BitableAppDrawerManager", "destroy: clear drawer resources");
        this.f206807f.removeObserver(this.E);
        this.f206803b.removeObserver(this);
        this.f206809h.removeCallbacks(this.F);
        com.bytedance.ee.bear.bitable.app.c r100 = this.f206825x;
        if (r100 == null) goto L8;
        this.f206809h.removeOnLayoutChangeListener(r100);
    L8:
        this.f206825x = null;
        Iterator r101 = CollectionsKt.toList(this.D).iterator();
    L10:
        if (r101.hasNext() == false) goto L12;
        ((Animator) r101.next()).cancel();
        goto L10
    L12:
        this.D.clear();
        View r102 = this.f206815n;
        if (r102 == null) goto L15;
        r102.setOnClickListener(null);
    L15:
        View r103 = this.f206815n;
        if (r103 == null) goto L18;
        r103.setOnTouchListener(null);
    L18:
        View r104 = this.f206815n;
        if (r104 == null) goto L21;
        ViewParent r105 = r104.getParent();
    L23:
        if ((r105 instanceof ViewGroup) == false) goto L25;
        ViewGroup r106 = (ViewGroup) r105;
    L26:
        if (r106 == null) goto L28;
        r106.removeView(this.f206815n);
    L28:
        this.f206815n = null;
        this.f206827z = null;
        this.f206820s = null;
        this.f206821t = null;
        BitableLynxViewHolder r107 = this.f206826y;
        this.f206826y = null;
        if (r107 == null) goto L33;
        r107.b();
        return;
    L33:
        return;
    L25:
        r106 = null;
        goto L26
    L21:
        r105 = null;
        goto L23
    }

    public final int b() {
        int r100 = this.f206802a.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r100 > 0) goto L7;
        return 0;
    L7:
        return this.f206802a.getResources().getDimensionPixelSize(r100);
    }

    public final boolean c() {
        if (this.f206826y == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void h() {
        boolean r100 = this.f206808g;
        if (r100 == false) goto L6;
        y();
        return;
    L6:
        if (this.C == true) goto L57;
        if (r100 == true) goto L59;
        FrameLayout r101 = this.f206810i;
        if (r101 == null) goto L60;
        View r102 = this.f206811j;
        if (r102 != null) goto L16;
        return;
    L16:
        if (this.f206823v == true) goto L18;
    L29:
        Function1<? super Boolean, Unit> r103 = this.f206821t;
        if (r103 == null) goto L32;
        r103.invoke(Boolean.TRUE);
    L32:
        r101.setVisibility(0);
        if (this.f206809h.getWidth() > com.bytedance.ee.util.ui.n.d(600)) goto L35;
        final boolean r104 = true;
    L36:
        ObjectAnimator r105 = null;
        if (r104 == false) goto L47;
        View r106 = this.f206815n;
        if (r106 == null) goto L47;
        r106.setVisibility(0);
        Resources r107 = this.f206802a.getResources();
        int r108 = WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()).widthPixels - this.f206814m;
        ViewGroup.LayoutParams r109 = r106.getLayoutParams();
        r109.width = r108;
        r109.height = -1;
        if ((r109 instanceof ViewGroup.MarginLayoutParams) == false) goto L43;
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r109;
    L44:
        if (r110 == null) goto L46;
        r110.leftMargin = this.f206814m;
    L46:
        r106.setLayoutParams(r109);
        goto L47
    L43:
        r110 = null;
    L47:
        ObjectAnimator r111 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{-this.f206814m, 0.0f});
        ObjectAnimator r112 = ObjectAnimator.ofFloat(r102, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, this.f206814m});
        if (r104 == false) goto L52;
        View r113 = this.f206813l;
        if (r113 == null) goto L52;
        r105 = ObjectAnimator.ofFloat(r113, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, this.f206814m});
    L52:
        Intrinsics.checkNotNull(r111);
        Intrinsics.checkNotNull(r112);
        f(r111, r112, r105, new BitableAppDrawerManager$openDrawer$2(this, r104));
        g(r111);
        g(r112);
        if (r105 == null) goto L58;
        g(r105);
        return;
    L58:
        return;
    L35:
        r104 = false;
        goto L36
    L18:
        if (this.f206809h.getWidth() <= com.bytedance.ee.util.ui.n.d(600)) goto L24;
        this.f206814m = com.bytedance.ee.util.ui.n.d(260);
        View r114 = this.f206813l;
        if (r114 == null) goto L22;
        int r115 = r114.getMeasuredHeight();
    L23:
        e(true);
    L25:
        FrameLayout r116 = this.f206810i;
        if (r116 == null) goto L28;
        ViewGroup.LayoutParams r117 = r116.getLayoutParams();
        r117.width = this.f206814m;
        r116.setLayoutParams(r117);
        r116.setTranslationX(-this.f206814m);
        r116.setPadding(r116.getPaddingLeft(), r115, r116.getPaddingRight(), r116.getPaddingBottom());
    L28:
        this.f206823v = false;
        goto L29
    L22:
        r115 = b();
        goto L23
    L24:
        this.f206814m = (int) (this.f206809h.getWidth() * 0.88f);
        r115 = b();
        e(false);
        goto L25
    L60:
        return;
    L59:
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.app.a
    public final void y() {
        if (this.C == false) goto L5;
        return;
    L5:
        if (this.f206808g == false) goto L33;
        final FrameLayout r100 = this.f206810i;
        if (r100 != null) goto L10;
        return;
    L10:
        View r101 = this.f206811j;
        if (r101 != null) goto L13;
        return;
    L13:
        View r102 = this.f206813l;
        ObjectAnimator r103 = null;
        if (r102 == null) goto L21;
        if (r102 == null) goto L17;
        Float r104 = Float.valueOf(r102.getTranslationX());
    L19:
        if (Intrinsics.areEqual(r104, 0.0f) == true) goto L21;
        boolean r105 = true;
    L22:
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r100.getTranslationX(), -this.f206814m});
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r101.getTranslationX(), 0.0f});
        if (r105 == false) goto L27;
        View r108 = this.f206813l;
        if (r108 == null) goto L27;
        r103 = ObjectAnimator.ofFloat(r108, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r108.getTranslationX(), 0.0f});
    L27:
        Intrinsics.checkNotNull(r106);
        Intrinsics.checkNotNull(r107);
        f(r106, r107, r103, new BitableAppDrawerManager$closeDrawer$1(r100, this));
        g(r106);
        g(r107);
        if (r103 == null) goto L32;
        g(r103);
        return;
    L32:
        return;
    L17:
        r104 = null;
    L21:
        r105 = false;
        goto L22
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        a();
    }

    @Override // com.bytedance.ee.bear.bitable.lynx.h
    public final void Gu(Map<String, ? extends Object> r100) {
        if (this.C == false) goto L5;
        return;
    L5:
        tt5.a.h("BitableAppDrawerManager", "onCallBack: " + r100);
        JSONObject r101 = new JSONObject(r100);
        tb5.m r102 = this.f206827z;
        if (r102 == null) goto L9;
        r102.b(r101);
        return;
    }

    public final void e(boolean r100) {
        BitableLynxViewHolder r101 = this.f206826y;
        if (r101 == null) goto L6;
        r101.k("bitable.app.showTitleHeader", mu5.b.e(new ShowTitleHeaderData(r100)));
        return;
    }

    public final void g(ObjectAnimator r100) {
        if (this.C == false) goto L5;
        return;
    L5:
        this.D.add(r100);
        r100.addListener(new d(this));
        r100.start();
    }

    public final void d(qo4.a r100, String r110) {
        if (this.C == false) goto L5;
        return;
    L5:
        if (r110 != null) goto L9;
        if (r100 != null) goto L9;
        return;
    L9:
        if (c() == true) goto L27;
        if (r100 != null) goto L12;
        return;
    L12:
        this.f206827z = r100.f534168b;
        fo4.a r101 = new fo4.a(this.f206802a, 6);
        r101.a(TemplateData.fromMap(MapsKt.mapOf(new Pair[]{TuplesKt.to("appDrawer", r100.f534167a), TuplesKt.to("appTitle", r110), TuplesKt.to("appToken", this.f206805d.invoke())})));
        b r102 = new b(this);
        Intrinsics.checkNotNullParameter(r102, "lynxViewClient");
        r101.f478120e = r102;
        BitableLynxViewHolder r103 = eo4.a.a(r101);
        this.f206826y = r103;
        View r104 = r103.c(true);
        if (r104 == null) goto L17;
        r104.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        FrameLayout r111 = this.f206810i;
        if (r111 == null) goto L17;
        r111.addView(r104);
    L17:
        BitableLynxViewHolder r105 = this.f206826y;
        if (r105 == null) goto L20;
        r105.i(com.bytedance.ee.bear.bitable.lynx.h.class, this);
    L20:
        BitableLynxViewHolder r106 = this.f206826y;
        if (r106 == null) goto L24;
        r106.i(com.bytedance.ee.bear.bitable.app.a.class, this);
    L24:
        if (this.f206809h.getWidth() <= com.bytedance.ee.util.ui.n.d(600)) goto L26;
        e(true);
        return;
    L26:
        e(false);
        return;
    L27:
        if (r100 == null) goto L30;
        if (r110 == null) goto L30;
        Map<String, ? extends Object> r112 = MapsKt.mapOf(new Pair[]{TuplesKt.to("appDrawer", r100.f534167a), TuplesKt.to("appTitle", r110)});
    L35:
        BitableLynxViewHolder r107 = this.f206826y;
        if (r107 == null) goto L38;
        r107.l(r112);
        Unit r113 = Unit.INSTANCE;
    L38:
        if (r100 == null) goto L43;
        this.f206827z = r100.f534168b;
        return;
    L43:
        return;
    L30:
        if (r100 == null) goto L32;
        r112 = MapsKt.mapOf(TuplesKt.to("appDrawer", r100.f534167a));
        goto L35
    L32:
        if (r110 == null) goto L34;
        r112 = MapsKt.mapOf(TuplesKt.to("appTitle", r110));
        goto L35
    L34:
        r112 = MapsKt.emptyMap();
        goto L35
    }

    public final void f(ObjectAnimator r100, ObjectAnimator r101, ObjectAnimator r102, Function0<Unit> r103) {
        Iterator r104 = CollectionsKt.listOfNotNull(new ObjectAnimator[]{r100, r101, r102}).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ObjectAnimator r105 = (ObjectAnimator) r104.next();
        r105.setDuration(250);
        r105.setInterpolator(new AccelerateInterpolator());
        goto L4
    L6:
        r100.addListener(new c(this, r103));
    }

    public BitableAppDrawerManager(Context r100, Lifecycle r101, LifecycleOwner r102, Function0 r103, g r104, MutableLiveData r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r103, "tokenProvider");
        Intrinsics.checkNotNullParameter(r104, "viewPort");
        Intrinsics.checkNotNullParameter(r105, "theme");
        this.f206802a = r100;
        this.f206803b = r101;
        this.f206804c = r102;
        this.f206805d = r103;
        this.f206806e = r104;
        this.f206807f = r105;
        View r106 = r104.f206931a;
        this.f206809h = r106;
        this.f206810i = r104.f206933c;
        this.f206811j = r104.f206934d;
        this.f206812k = r104.f206935e;
        this.f206813l = r104.f206936f;
        this.f206816o = LazyKt.lazy(LazyThreadSafetyMode.NONE, new BitableAppDrawerManager$touchSlop$2(this));
        e r107 = new e(this);
        this.f206822u = r107;
        this.D = new LinkedHashSet();
        f r108 = new f(this);
        this.E = r108;
        com.bytedance.ee.bear.bitable.app.d r109 = new com.bytedance.ee.bear.bitable.app.d(this);
        this.F = r109;
        r106.post(r109);
        com.bytedance.ee.bear.bitable.app.c r110 = new com.bytedance.ee.bear.bitable.app.c(this);
        this.f206825x = r110;
        r106.addOnLayoutChangeListener(r110);
        ViewGroup r111 = r104.f206932b;
        if (r111 == null) goto L6;
        View r112 = new View(r100);
        r112.setBackgroundColor(0);
        r112.setOnClickListener(r107);
        r112.setOnTouchListener(new com.bytedance.ee.bear.bitable.app.b(this));
        r112.setVisibility(8);
        this.f206815n = r112;
        r111.addView(r112);
    L6:
        r105.observe(r102, r108);
        r101.addObserver(this);
    }
}
