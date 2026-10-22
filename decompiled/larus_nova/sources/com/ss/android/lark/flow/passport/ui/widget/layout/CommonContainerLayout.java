package com.ss.android.lark.flow.passport.ui.widget.layout;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0001[B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010H\u001a\u00020*H\u0002J\b\u0010I\u001a\u00020*H\u0002J\b\u0010J\u001a\u00020*H\u0002J \u0010K\u001a\u00020*2\b\u00102\u001a\u0004\u0018\u0001012\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\bJ\u000e\u0010L\u001a\u00020*2\u0006\u0010M\u001a\u000203J \u0010N\u001a\u00020*2\b\u00102\u001a\u0004\u0018\u0001012\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\bJ\u0018\u0010O\u001a\u00020\b2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\bH\u0002J\u0018\u0010P\u001a\u00020\u00162\u0006\u0010Q\u001a\u0002012\u0006\u0010R\u001a\u00020\bH\u0002J\u0012\u0010S\u001a\u00020\b2\b\u0010Q\u001a\u0004\u0018\u000101H\u0002J\b\u0010T\u001a\u00020*H\u0014J\u0010\u0010W\u001a\u00020*2\b\b\u0001\u0010X\u001a\u00020\bJ\u0018\u0010W\u001a\u00020*2\u0006\u0010Q\u001a\u0002012\b\u0010Y\u001a\u0004\u0018\u00010ZR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u001f\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R7\u0010%\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020*\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.Ra\u0010/\u001aI\u0012\u0015\u0012\u0013\u0018\u000101¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u001103¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\b¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020*00X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R7\u0010:\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020*\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010,\"\u0004\b<\u0010.R\u001a\u0010=\u001a\u00020>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u000203X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0014\u0010U\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010\u000e¨\u0006\\"}, d2 = {"Lcom/ss/android/lark/flow/passport/ui/widget/layout/CommonContainerLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/lifecycle/LifecycleOwner;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lifecycleRegistry", "Landroidx/lifecycle/Lifecycle;", "getLifecycleRegistry", "()Landroidx/lifecycle/Lifecycle;", "lifecycleRegistry$delegate", "Lkotlin/Lazy;", "tvTitle", "Landroid/widget/TextView;", "locationOnScreen", "", "paddingUpdateAnimator", "Landroid/animation/ValueAnimator;", "titleBarContainer", "Landroid/widget/LinearLayout;", "getTitleBarContainer", "()Landroid/widget/LinearLayout;", "headerContainer", "getHeaderContainer", "contentContainer", "getContentContainer", "footerContainer", "getFooterContainer", "contentScrollView", "Lcom/ss/android/lark/flow/passport/ui/widget/layout/BlockedNestedScrollView;", "getContentScrollView", "()Lcom/ss/android/lark/flow/passport/ui/widget/layout/BlockedNestedScrollView;", "onContentScrollListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "titleTopToToolBarBottom", "", "getOnContentScrollListener", "()Lkotlin/jvm/functions/Function1;", "setOnContentScrollListener", "(Lkotlin/jvm/functions/Function1;)V", "onImeChangeHandler", "Lkotlin/Function3;", "Landroid/view/View;", "focusedView", "", "imeShowing", "imeHeight", "getOnImeChangeHandler", "()Lkotlin/jvm/functions/Function3;", "setOnImeChangeHandler", "(Lkotlin/jvm/functions/Function3;)V", "onImeChangedEndListener", "getOnImeChangedEndListener", "setOnImeChangedEndListener", "onImeChangedExtraHeightProvider", "Lcom/ss/android/lark/flow/passport/ui/widget/layout/OnImeChangedExtraHeightProvider;", "getOnImeChangedExtraHeightProvider", "()Lcom/ss/android/lark/flow/passport/ui/widget/layout/OnImeChangedExtraHeightProvider;", "setOnImeChangedExtraHeightProvider", "(Lcom/ss/android/lark/flow/passport/ui/widget/layout/OnImeChangedExtraHeightProvider;)V", "intercept", "getIntercept", "()Z", "setIntercept", "(Z)V", "onFirstLayout", "observeScroll", "observeIme", "onImeChanged", "setContentScrollable", "scrollable", "handleImeChanged", "measureAvailablePaddingBottom", "smoothUpdatePaddingBottom", "view", RemoteMessageConst.TO, "computeViewBottomInScreen", "onDetachedFromWindow", NewBroadcastMonitor.STAGE.LIFECYCLE, "getLifecycle", "inflatePartialLayout", "layoutId", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "flow-passport-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonContainerLayout extends ConstraintLayout implements LifecycleOwner {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f423860o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f423861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f423862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f423863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f423864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f423865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f423866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinearLayout f423867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinearLayout f423868h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BlockedNestedScrollView f423869i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function1<? super Integer, Unit> f423870j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function3<? super View, ? super Boolean, ? super Integer, Unit> f423871k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f423872l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public g f423873m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f423874n;

    public static final class a {
    }

    public static final class b implements g {
        public b() {
        }

        @Override // com.ss.android.lark.flow.passport.ui.widget.layout.g
        public final /* synthetic */ void a() {
        }

        @Override // com.ss.android.lark.flow.passport.ui.widget.layout.g
        public final /* synthetic */ void b() {
        }

        @Override // com.ss.android.lark.flow.passport.ui.widget.layout.g
        public final /* synthetic */ void c() {
        }
    }

    public static final class c implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonContainerLayout f423875a;

        public c(CommonContainerLayout r100) {
            this.f423875a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            Intrinsics.checkNotNullParameter(r100, "view");
            r100.removeOnLayoutChangeListener(this);
            CommonContainerLayout r109 = this.f423875a;
            int r110 = CommonContainerLayout.f423860o;
            r109.getClass();
            Intrinsics.checkNotNullParameter(r109, "<this>");
            Intrinsics.checkNotNullParameter(r109, "<this>");
            if (r109.isAttachedToWindow() == false) goto L12;
            Context r111 = r109.getContext();
        L7:
            if ((r111 instanceof ContextWrapper) == false) goto L12;
            if ((r111 instanceof Activity) == true) goto L10;
            r111 = ((ContextWrapper) r111).getBaseContext();
            goto L7
        L10:
            Window r112 = ((Activity) r111).getWindow();
        L13:
            if (r112 == null) goto L22;
            Intrinsics.checkNotNullParameter(r112, "<this>");
            int r113 = r112.getAttributes().flags & 67108864;
            View r114 = r112.getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L20;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r115 = ThreadMethodProxy.currentThread();
            if (r115 == com.larus.home.impl.utils.c.f346341a) goto L20;
            com.larus.home.impl.utils.c.a(r115, "getDecorView");
        L20:
            if ((r113 | (r114.getSystemUiVisibility() & 1024)) == 0) goto L22;
            boolean r116 = true;
        L23:
            if (r116 == false) goto L25;
            int r117 = uzb.b.f552237f;
            Intrinsics.checkNotNullParameter(r109, "view");
            new uzb.b(r109).f552242e.observe(r109, new com.ss.android.lark.flow.passport.ui.widget.layout.c(r109));
        L25:
            View r118 = r109.findViewById(R.id.signin_sdk_widget_space_title_bar);
            Intrinsics.checkNotNull(r118);
            ViewGroup.LayoutParams r119 = r118.getLayoutParams();
            if (r119 == null) goto L30;
            r119.height = r109.f423865e.getHeight();
            r118.setLayoutParams(r119);
            return;
        L30:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        L22:
            r116 = false;
        L12:
            r112 = null;
            goto L13
        }
    }

    static {
    }

    public CommonContainerLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommonContainerLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final Lifecycle getLifecycleRegistry() {
        return (Lifecycle) this.f423861a.getValue();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return getLifecycleRegistry();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r100 = this.f423864d;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        qyb.d.c(this, 0);
    }

    public final LinearLayout getContentContainer() {
        return this.f423867g;
    }

    public final BlockedNestedScrollView getContentScrollView() {
        return this.f423869i;
    }

    public final LinearLayout getFooterContainer() {
        return this.f423868h;
    }

    public final LinearLayout getHeaderContainer() {
        return this.f423866f;
    }

    public final boolean getIntercept() {
        return this.f423874n;
    }

    public final Function1<Integer, Unit> getOnContentScrollListener() {
        return this.f423870j;
    }

    public final Function3<View, Boolean, Integer, Unit> getOnImeChangeHandler() {
        return this.f423871k;
    }

    public final Function1<Boolean, Unit> getOnImeChangedEndListener() {
        return this.f423872l;
    }

    public final g getOnImeChangedExtraHeightProvider() {
        return this.f423873m;
    }

    public final LinearLayout getTitleBarContainer() {
        return this.f423865e;
    }

    public final int R5(View r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
    L18:
        return 0;
    L5:
        if (r100.getVisibility() != 8) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L18;
        r100.getLocationOnScreen(this.f423863c);
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
    L14:
        if (r104 == null) goto L17;
        r101 = r104.bottomMargin;
    L17:
        return (this.f423863c[1] + r100.getHeight()) + r101;
    L13:
        r104 = null;
        goto L14
    L7:
        r102 = false;
        goto L8
    }

    public final void setContentScrollable(boolean r100) {
        if (r100 == false) goto L4;
        this.f423869i.f423859a = true;
        return;
    L4:
        this.f423869i.f423859a = false;
    }

    public final void setIntercept(boolean r100) {
        this.f423874n = r100;
    }

    public final void setOnContentScrollListener(Function1<? super Integer, Unit> r100) {
        this.f423870j = r100;
    }

    public final void setOnImeChangeHandler(Function3<? super View, ? super Boolean, ? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f423871k = r100;
    }

    public final void setOnImeChangedEndListener(Function1<? super Boolean, Unit> r100) {
        this.f423872l = r100;
    }

    public final void setOnImeChangedExtraHeightProvider(g r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f423873m = r100;
    }

    public CommonContainerLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f423861a = LazyKt.lazy(new CommonContainerLayout$lifecycleRegistry$2(this));
        this.f423863c = new int[2];
        this.f423871k = new CommonContainerLayout$onImeChangeHandler$1(this);
        this.f423873m = new b();
        View.inflate(r100, R.layout.passport_flow_common_layout_root_merge, this);
        this.f423866f = (LinearLayout) findViewById(R.id.signin_sdk_widget_header_container);
        BlockedNestedScrollView r103 = (BlockedNestedScrollView) findViewById(R.id.signin_sdk_widget_scrollable_content_container);
        this.f423869i = r103;
        this.f423867g = (LinearLayout) findViewById(R.id.signin_sdk_widget_content_container);
        this.f423868h = (LinearLayout) findViewById(R.id.signin_sdk_widget_footer_container);
        this.f423865e = (LinearLayout) findViewById(R.id.signin_sdk_widget_title_bar_container);
        this.f423862b = (TextView) findViewById(R.id.signin_sdk_widget_title);
        r103.setOnScrollChangeListener(new d(this));
        addOnLayoutChangeListener(new c(this));
    }

    public /* synthetic */ CommonContainerLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
