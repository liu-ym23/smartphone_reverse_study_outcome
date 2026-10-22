package com.obric.oui.pullrefresh;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.nova.R;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.oui.pullrefresh.header.ODefaultRefreshHeader;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u00017B'\b\u0007\u0012\u0006\u00101\u001a\u000200\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u0012\b\b\u0002\u00104\u001a\u00020\u000e¢\u0006\u0004\b5\u00106J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u001a\u0010\u0013\u001a\u00020\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050\u0014J\u0010\u0010\u0017\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0016J&\u0010\u0017\u001a\u00020\u00052\u001e\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0018J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000eJ\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010 \u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000eJ\u000e\u0010!\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000eJ\u000e\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"J\b\u0010%\u001a\u00020\u000eH\u0016R\"\u0010,\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0011\u0010/\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00068"}, d2 = {"Lcom/obric/oui/pullrefresh/OPullRefreshLayout;", "Landroid/view/ViewGroup;", "Landroidx/core/view/NestedScrollingParent3;", "Lcom/obric/oui/pullrefresh/RefreshState;", "newState", "", "setState", "", "dragDamping", "setDragDamping", "triggerRate", "setTriggerRate", "headerInsetStartDp", "setHeaderInsetStartDp", "", "headerInsetStartPx", "setHeaderInsetStartPx", "Lcom/obric/oui/pullrefresh/b;", "listener", "setOnRefreshListener", "Lkotlin/Function1;", "block", "Lcom/obric/oui/pullrefresh/c;", "setOnStateChangeListener", "Lkotlin/Function3;", "Ljma/a;", "header", "setRefreshHeader", "color", "setDefaultHeaderTextColor", "Landroid/content/res/ColorStateList;", "colors", "setDefaultHeaderIconColor", "setDefaultHeaderProgressBackgroundColor", "", "enabled", "setNestedScrollEnabledWhileAnimatingOffset", "getNestedScrollAxes", "C", "Z", "getRefreshEnable", "()Z", "setRefreshEnable", "(Z)V", "refreshEnable", "getState", "()Lcom/obric/oui/pullrefresh/RefreshState;", "state", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OPullRefreshLayout extends ViewGroup implements NestedScrollingParent3 {
    public static final /* synthetic */ int D = 0;
    public boolean A;
    public float B;
    public boolean C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NestedScrollingParentHelper f402545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public jma.a f402546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f402547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f402548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f402549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f402550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f402551g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f402552h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f402553i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RefreshState f402554j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.obric.oui.pullrefresh.b f402555k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.obric.oui.pullrefresh.c f402556l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public fja.d f402557m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f402558n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f402559o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f402560p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f402561q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f402562r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f402563s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f402564t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f402565u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f402566v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f402567w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f402568x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f402569y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f402570z;

    public static final class a implements jma.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f402571a;

        @Override // jma.a
        public final void a(OPullRefreshLayout r100, RefreshState r101, RefreshState r102) {
            Intrinsics.checkNotNullParameter(r100, "layout");
            Intrinsics.checkNotNullParameter(r101, "oldState");
            Intrinsics.checkNotNullParameter(r102, "newState");
        }

        @Override // jma.a
        public final void b(OPullRefreshLayout r100) {
            Intrinsics.checkNotNullParameter(r100, "layout");
        }

        @Override // jma.a
        public final void c(OPullRefreshLayout r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "layout");
        }

        @Override // jma.a
        public final View getView() {
            return this.f402571a;
        }

        public a(View r100) {
            this.f402571a = r100;
        }
    }

    public static final class b {
    }

    public static final class c implements com.obric.oui.pullrefresh.b, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f402572a;

        public c(Function1 r100) {
            this.f402572a = r100;
        }

        @Override // com.obric.oui.pullrefresh.b
        public final /* synthetic */ void a(OPullRefreshLayout r100) {
            this.f402572a.invoke(r100);
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f402572a;
        }

        public final int hashCode() {
            return this.f402572a.hashCode();
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof com.obric.oui.pullrefresh.b) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(this.f402572a, ((FunctionAdapter) r100).getFunctionDelegate());
        }
    }

    public static final class d implements com.obric.oui.pullrefresh.c, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function3 f402573a;

        public d(Function3 r100) {
            this.f402573a = r100;
        }

        @Override // com.obric.oui.pullrefresh.c
        public final /* synthetic */ void a(OPullRefreshLayout r100, RefreshState r101, RefreshState r102) {
            this.f402573a.invoke(r100, r101, r102);
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f402573a;
        }

        public final int hashCode() {
            return this.f402573a.hashCode();
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof com.obric.oui.pullrefresh.c) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(this.f402573a, ((FunctionAdapter) r100).getFunctionDelegate());
        }
    }

    static {
    }

    public OPullRefreshLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OPullRefreshLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        return false;
    }

    public final void c() {
        float r100 = this.f402551g;
        View r101 = this.f402547c;
        boolean r102 = true;
        if (r101 != null) goto L6;
    L11:
        View r103 = this.f402548d;
        if (r103 != null) goto L15;
        return;
    L15:
        if (r103.getTranslationY() == r100) goto L18;
        r102 = false;
    L18:
        if (r102 == true) goto L21;
        r103.setTranslationY(r100);
        return;
    L21:
        return;
    L6:
        if (r101.getTranslationY() != r100) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L11;
        r101.setTranslationY(r100);
        goto L11
    L8:
        r104 = false;
        goto L9
    }

    public final boolean d() {
        View r100 = this.f402549e;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.canScrollVertically(-1) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void f() {
        if (this.f402548d == null) goto L5;
        return;
    L5:
        int r100 = getChildCount();
        int r101 = 0;
    L6:
        if (r101 >= r100) goto L14;
        int r102 = r101 + 1;
        View r103 = getChildAt(r101);
        if (r103 != this.f402547c) goto L9;
        r101 = r102;
        goto L6
    L9:
        this.f402548d = r103;
        return;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f402545a.getNestedScrollAxes();
    }

    public final void h() {
        int r100 = this.f402550f;
        if (r100 > 0) goto L5;
        return;
    L5:
        int r101 = 0;
        if (this.f402551g < ((int) (r100 * this.f402553i))) goto L23;
        RefreshState r102 = this.f402554j;
        if (r102 != RefreshState.RELEASE_TO_REFRESH) goto L10;
    L11:
        if (r100 > 0) goto L19;
        View r103 = this.f402547c;
        if (r103 == null) goto L16;
        r101 = r103.getMeasuredHeight();
    L16:
        this.f402550f = r101;
        if (r101 > 0) goto L19;
        return;
    L19:
        setState(RefreshState.REFRESHING);
        b(this.f402550f, null);
        com.obric.oui.pullrefresh.b r104 = this.f402555k;
        if (r104 == null) goto L27;
        r104.a(this);
        return;
    L27:
        return;
    L10:
        if (r102 == RefreshState.PULL_TO_REFRESH) goto L11;
    L23:
        b(0, new OPullRefreshLayout$finishSpinner$1(this));
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        f();
        this.f402549e = g(this.f402548d);
    }

    public final boolean getRefreshEnable() {
        return this.C;
    }

    public final RefreshState getState() {
        return this.f402554j;
    }

    private final void setState(RefreshState r100) {
        RefreshState r101 = this.f402554j;
        if (r101 != r100) goto L5;
        return;
    L5:
        this.f402554j = r100;
        jma.a r102 = this.f402546b;
        if (r102 == null) goto L9;
        r102.a(this, r101, r100);
    L9:
        com.obric.oui.pullrefresh.c r103 = this.f402556l;
        if (r103 == null) goto L14;
        r103.a(this, r101, r100);
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof ViewGroup.MarginLayoutParams;
    }

    public final View g(View r100) {
        if (r100 != null) goto L5;
    L24:
        return null;
    L5:
        if (r100 == this.f402547c) goto L24;
        if ((r100 instanceof ScrollView) == false) goto L10;
    L23:
        return r100;
    L10:
        if ((r100 instanceof AbsListView) == true) goto L23;
        if ((r100 instanceof NestedScrollingChild) == true) goto L23;
        if ((r100 instanceof ViewGroup) == false) goto L22;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L17:
        if (r103 >= r102) goto L22;
        int r104 = r103 + 1;
        View r105 = g(r101.getChildAt(r103));
        if (r105 != null) goto L20;
        r103 = r104;
        goto L17
    L20:
        return r105;
    L22:
        return null;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new ViewGroup.MarginLayoutParams(getContext(), r100);
    }

    public final void i(int r110) {
        int r111 = Math.max(0, r110);
        if (r111 != this.f402551g) goto L5;
        return;
    L5:
        this.f402551g = r111;
        c();
        int r112 = this.f402550f;
        if (r112 <= 0) goto L20;
        float r113 = RangesKt.coerceIn(this.f402551g / r112, 0.0f, 1.0f);
        int r100 = this.f402551g;
        int r101 = this.f402550f;
        long r102 = SystemClock.uptimeMillis();
        if ((r102 - this.f402566v) >= 16) goto L13;
        if (r100 == 0) goto L13;
        if (r100 == r101) goto L13;
        boolean r103 = false;
    L14:
        if (r103 == false) goto L20;
        this.f402566v = r102;
        jma.a r104 = this.f402546b;
        if (r104 == null) goto L20;
        r104.c(this, r113);
    L13:
        r103 = true;
    L20:
        RefreshState r114 = this.f402554j;
        RefreshState r105 = RefreshState.REFRESHING;
        if (r114 == r105) goto L23;
    L31:
        if (r114 != r105) goto L33;
    L45:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L33:
        if (r114 == RefreshState.FINISH) goto L45;
        int r115 = (int) (this.f402550f * this.f402553i);
        int r106 = this.f402551g;
        if (r106 > 0) goto L38;
        RefreshState r116 = RefreshState.IDLE;
    L44:
        setState(r116);
        goto L45
    L38:
        if (r106 >= r115) goto L41;
        this.A = false;
        r116 = RefreshState.PULL_TO_REFRESH;
        goto L44
    L41:
        if (this.A == true) goto L43;
        this.A = true;
        bma.a.b(this, 4);
    L43:
        r116 = RefreshState.RELEASE_TO_REFRESH;
        goto L44
    L23:
        if (this.f402551g != 0) goto L31;
        if (r114 != r105) goto L26;
    L28:
        setState(RefreshState.FINISH);
        postDelayed(new com.obric.oui.pullrefresh.a(this), 200);
    L29:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L26:
        if (r114 == RefreshState.RELEASE_TO_REFRESH) goto L28;
        goto L28
    }

    public final void j(boolean r100) {
        View r101 = this.f402547c;
        View r102 = this.f402548d;
        int r103 = 0;
        if (r100 == false) goto L23;
        if (this.f402570z == true) goto L15;
        this.f402570z = true;
        this.f402567w = getLayerType();
        if (r101 != null) goto L9;
        int r104 = 0;
    L10:
        this.f402568x = r104;
        if (r102 == null) goto L14;
        r103 = r102.getLayerType();
    L14:
        this.f402569y = r103;
        goto L15
    L9:
        r104 = r101.getLayerType();
    L15:
        setLayerType(2, null);
        if (r101 == null) goto L19;
        r101.setLayerType(2, null);
    L19:
        if (r102 == null) goto L34;
        r102.setLayerType(2, null);
        return;
    L34:
        return;
    L23:
        if (this.f402570z == false) goto L33;
        this.f402570z = false;
        setLayerType(this.f402567w, null);
        if (r101 == null) goto L28;
        r101.setLayerType(this.f402568x, null);
    L28:
        if (r102 == null) goto L35;
        r102.setLayerType(this.f402569y, null);
        return;
    L35:
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        boolean r101 = false;
        if (isEnabled() == true) goto L5;
    L57:
        return false;
    L5:
        if (this.C == false) goto L57;
        int r102 = r100.getActionMasked();
        if (r102 != 0) goto L10;
        this.f402558n = false;
        this.f402559o = r100.getY();
        this.f402560p = r100.getX();
        this.f402561q = this.f402559o;
    L56:
        return this.f402558n;
    L10:
        if (r102 != 1) goto L12;
    L53:
        this.f402558n = false;
        goto L56
    L12:
        if (r102 == 2) goto L17;
        if (r102 == 3) goto L53;
    L17:
        if (this.f402558n == true) goto L56;
        float r103 = r100.getY() - this.f402559o;
        float r104 = r100.getX() - this.f402560p;
        float r105 = Math.abs(r103);
        float r106 = Math.abs(r104);
        if (r105 <= this.f402563s) goto L56;
        if (r105 <= r106) goto L56;
        if (this.f402549e != null) goto L25;
    L28:
        boolean r107 = true;
    L30:
        if (r103 <= 0.0f) goto L32;
        boolean r108 = true;
    L34:
        if (r103 < 0.0f) goto L36;
    L38:
        boolean r109 = false;
    L40:
        if ((this.f402549e instanceof NestedScrollingChild) == true) goto L42;
    L44:
        if (r108 == false) goto L47;
        if (r101 == true) goto L47;
        if (r107 == false) goto L47;
    L49:
        this.f402558n = true;
        this.f402561q = r100.getY();
        ViewParent r110 = getParent();
        if (r110 == null) goto L56;
        r110.requestDisallowInterceptTouchEvent(true);
    L47:
        if (r109 == false) goto L56;
        if (r101 == true) goto L56;
    L42:
        if ((this.f402548d instanceof CoordinatorLayout) == true) goto L44;
        r101 = true;
        goto L44
    L36:
        if (this.f402551g <= 0) goto L38;
        r109 = true;
        goto L40
    L32:
        r108 = false;
        goto L34
    L25:
        if (d() == false) goto L28;
        r107 = false;
        goto L30
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (isEnabled() == false) goto L64;
        if (this.C == false) goto L64;
        int r100 = r110.getActionMasked();
        boolean r101 = false;
        if (r100 == 0) goto L61;
        if (r100 == 1) goto L54;
        if (r100 != 2) goto L13;
        float r102 = r110.getY();
        float r103 = r102 - this.f402561q;
        this.f402561q = r102;
        if (this.f402558n == true) goto L32;
        float r104 = r102 - this.f402559o;
        float r105 = r110.getX() - this.f402560p;
        float r106 = Math.abs(r104);
        float r107 = Math.abs(r105);
        if (r106 <= this.f402563s) goto L32;
        if (r106 <= r107) goto L32;
        if (r104 <= 0.0f) goto L32;
        if (this.f402549e != null) goto L26;
    L27:
        this.f402558n = true;
        this.f402561q = r102;
        ViewParent r108 = getParent();
        if (r108 == null) goto L32;
        r108.requestDisallowInterceptTouchEvent(true);
        goto L32
    L26:
        if (d() == false) goto L27;
    L32:
        if (this.f402558n == true) goto L34;
    L60:
        return super.onTouchEvent(r110);
    L34:
        if (r103 < 0.0f) goto L36;
    L38:
        if (r103 >= 0.0f) goto L48;
        int r111 = Math.min((int) Math.abs(r103), this.f402551g);
        if (r111 <= 0) goto L42;
        i(this.f402551g - r111);
    L42:
        this.B = 0.0f;
        if (((int) Math.abs(r103)) <= r111) goto L46;
        this.f402558n = false;
        return false;
    L46:
        return true;
    L48:
        if (this.f402554j != RefreshState.REFRESHING) goto L50;
        r101 = true;
    L50:
        if (r101 == true) goto L52;
        int r112 = this.f402551g;
        i(r112 + e(r112, r103));
    L52:
        return true;
    L36:
        if (this.f402551g > 0) goto L38;
        return false;
    L13:
        if (r100 != 3) goto L60;
    L54:
        if (this.f402558n == false) goto L60;
        this.f402558n = false;
        if (this.f402554j == RefreshState.REFRESHING) goto L58;
        h();
    L58:
        return true;
    L61:
        this.f402558n = false;
        this.f402559o = r110.getY();
        this.f402560p = r110.getX();
        this.f402561q = this.f402559o;
        return true;
    L64:
        return super.onTouchEvent(r110);
    }

    public final void setDefaultHeaderIconColor(int r100) {
        jma.a r101 = this.f402546b;
        if ((r101 instanceof ODefaultRefreshHeader) == false) goto L5;
        ODefaultRefreshHeader r102 = (ODefaultRefreshHeader) r101;
    L6:
        if (r102 == null) goto L10;
        r102.setIconColor(r100);
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setDefaultHeaderProgressBackgroundColor(int r100) {
        jma.a r101 = this.f402546b;
        if ((r101 instanceof ODefaultRefreshHeader) == false) goto L5;
        ODefaultRefreshHeader r102 = (ODefaultRefreshHeader) r101;
    L6:
        if (r102 == null) goto L10;
        r102.setProgressBackgroundColor(r100);
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setDefaultHeaderTextColor(ColorStateList r100) {
        Intrinsics.checkNotNullParameter(r100, "colors");
        jma.a r101 = this.f402546b;
        if ((r101 instanceof ODefaultRefreshHeader) == false) goto L5;
        ODefaultRefreshHeader r102 = (ODefaultRefreshHeader) r101;
    L6:
        if (r102 == null) goto L10;
        r102.setTextColor(r100);
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setDragDamping(float r100) {
        this.f402552h = r100;
    }

    public final void setHeaderInsetStartDp(float r100) {
        this.f402562r = pla.d.m(this, r100);
    }

    public final void setHeaderInsetStartPx(int r100) {
        this.f402562r = r100;
    }

    public final void setNestedScrollEnabledWhileAnimatingOffset(boolean r100) {
        this.f402565u = r100;
    }

    public final void setOnRefreshListener(Function1<? super OPullRefreshLayout, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        this.f402555k = new c(r100);
    }

    public final void setOnStateChangeListener(Function3<? super OPullRefreshLayout, ? super RefreshState, ? super RefreshState, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        this.f402556l = new d(r100);
    }

    public final void setRefreshEnable(boolean r100) {
        this.C = r100;
    }

    public final void setRefreshHeader(jma.a r100) {
        Intrinsics.checkNotNullParameter(r100, "header");
        View r101 = this.f402547c;
        if (r101 == null) goto L6;
        removeView(r101);
    L6:
        this.f402546b = r100;
        View r102 = r100.getView();
        this.f402547c = r102;
        addView(r102, 0);
        requestLayout();
    }

    public final void setTriggerRate(float r100) {
        this.f402553i = r100;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new ViewGroup.MarginLayoutParams(r100);
    }

    public final void setDefaultHeaderTextColor(int r100) {
        jma.a r101 = this.f402546b;
        if ((r101 instanceof ODefaultRefreshHeader) == false) goto L5;
        ODefaultRefreshHeader r102 = (ODefaultRefreshHeader) r101;
    L6:
        if (r102 == null) goto L10;
        r102.setTextColor(r100);
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setOnRefreshListener(com.obric.oui.pullrefresh.b r100) {
        this.f402555k = r100;
    }

    public final void setOnStateChangeListener(com.obric.oui.pullrefresh.c r100) {
        this.f402556l = r100;
    }

    public static final /* synthetic */ void a(OPullRefreshLayout r100, RefreshState r101) {
        r100.setState(r101);
    }

    public final void b(int r100, final Function0<Unit> r101) {
        int r102 = this.f402551g;
        if (r102 != r100) goto L8;
        if (r101 == null) goto L30;
        r101.invoke();
        return;
    L30:
        return;
    L8:
        int r103 = Math.abs(r102 - r100);
        if (ViewCompat.isLaidOut(this) == true) goto L11;
    L21:
        fja.d r104 = this.f402557m;
        if (r104 == null) goto L25;
        int r105 = fja.d.f477533d;
        r104.a(false);
    L25:
        i(r100);
        if (r101 == null) goto L31;
        r101.invoke();
        return;
    L31:
        return;
    L11:
        if (isAttachedToWindow() == false) goto L21;
        if (r103 <= 2) goto L21;
        fja.d r106 = this.f402557m;
        if (r106 == null) goto L19;
        int r107 = fja.d.f477533d;
        r106.a(false);
    L19:
        com.obric.common.oea.foundation.animation.builder.d.a r108 = new com.obric.common.oea.foundation.animation.builder.d.a();
        r108.b(this.f402551g, r100, gja.b.c(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2), null);
        Function3<String, Object, Object, Unit> r109 = new OPullRefreshLayout$animateOffsetTo$1(this);
        Intrinsics.checkNotNullParameter(r109, "callback");
        r108.f396382d = r109;
        Function2<Boolean, Throwable, Unit> r110 = new OPullRefreshLayout$animateOffsetTo$2(this, r101);
        Intrinsics.checkNotNullParameter(r110, "callback");
        r108.f396383e = r110;
        this.f402557m = r108.a().a();
        this.f402564t = true;
        j(true);
    }

    public final int e(int r100, float r101) {
        int r102 = this.f402550f;
        if (r102 <= 0) goto L5;
        float r103 = r102 * 2.0f;
    L6:
        float r104 = r100;
        float r105 = RangesKt.coerceIn(this.f402552h, 0.01f, 1.0f);
        float r106 = Math.max(1.0f, r103);
        float r107 = (1.0f - (1.0f / (((r105 * r104) / r106) + 1.0f))) * r106;
        float r108 = RangesKt.coerceAtLeast(r104 + r101, 0.0f);
        float r109 = RangesKt.coerceIn(this.f402552h, 0.01f, 1.0f);
        float r110 = Math.max(1.0f, r103);
        float r111 = (((1.0f - (1.0f / (((r108 * r109) / r110) + 1.0f))) * r110) - r107) + this.B;
        int r112 = (int) r111;
        this.B = r111 - r112;
        return r112;
    L5:
        r103 = RangesKt.coerceAtLeast(getMeasuredHeight() * 2.0f, 1.0f);
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        f();
        int r102 = getMeasuredWidth();
        int r103 = getMeasuredHeight();
        if (r102 == 0) goto L19;
        if (r103 == 0) goto L21;
        int r104 = View.MeasureSpec.makeMeasureSpec((r102 - getPaddingLeft()) - getPaddingRight(), 1073741824);
        int r105 = View.MeasureSpec.makeMeasureSpec((r103 - getPaddingTop()) - getPaddingBottom(), 1073741824);
        View r106 = this.f402548d;
        if (r106 == null) goto L10;
        r106.measure(r104, r105);
    L10:
        View r107 = this.f402547c;
        if (r107 == null) goto L20;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if (r108 == null) goto L18;
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
        r107.measure(ViewGroup.getChildMeasureSpec(r100, ((getPaddingLeft() + getPaddingRight()) + r109.leftMargin) + r109.rightMargin, r109.width), ViewGroup.getChildMeasureSpec(r101, ((getPaddingTop() + getPaddingBottom()) + r109.topMargin) + r109.bottomMargin, r109.height));
        this.f402550f = r107.getMeasuredHeight();
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L20:
        return;
    L21:
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.f402545a.onStopNestedScroll(r100, r101);
        if (r101 == 0) goto L5;
        return;
    L5:
        if (this.f402554j == RefreshState.REFRESHING) goto L9;
        h();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OPullRefreshLayout(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f402545a = new NestedScrollingParentHelper(this);
        this.f402552h = 0.8f;
        this.f402553i = 1.0f;
        this.f402554j = RefreshState.IDLE;
        this.f402563s = ViewConfiguration.get(r110).getScaledTouchSlop();
        this.f402565u = true;
        this.C = true;
        setChildrenDrawingOrderEnabled(true);
        setClipToPadding(true);
        setClipChildren(true);
        ODefaultRefreshHeader r100 = null;
        if (r111 == null) goto L25;
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.o_pr_defaultHeaderIconColor, R.attr.o_pr_defaultHeaderProgressBackgroundColor, R.attr.o_pr_defaultHeaderTextColor, R.attr.o_pr_defaultHeaderTextPull, R.attr.o_pr_defaultHeaderTextRefreshing, R.attr.o_pr_defaultHeaderTextRelease, R.attr.o_pr_defaultHeaderTextSuccess, R.attr.o_pr_dragDamping, R.attr.o_pr_headerInsetStart, R.attr.o_pr_headerView, R.attr.o_pr_refreshEnable, R.attr.o_pr_triggerRate}, r112, 0);
        this.f402552h = RangesKt.coerceIn(r113.getFloat(7, 0.8f), 0.2f, 1.0f);
        this.f402553i = RangesKt.coerceAtLeast(r113.getFloat(11, 1.0f), 0.5f);
        this.f402562r = r113.getDimensionPixelOffset(8, 0);
        this.C = r113.getBoolean(10, true);
        String r114 = r113.getString(3);
        String r101 = r113.getString(5);
        String r102 = r113.getString(4);
        String r103 = r113.getString(6);
        if (r113.hasValue(2) == false) goto L7;
        Integer r104 = Integer.valueOf(r113.getColor(2, 0));
    L9:
        if (r113.hasValue(0) == false) goto L11;
        Integer r105 = Integer.valueOf(r113.getColor(0, 0));
    L13:
        if (r113.hasValue(1) == false) goto L15;
        Integer r106 = Integer.valueOf(r113.getColor(1, 0));
    L16:
        int r107 = r113.getResourceId(9, 0);
        r113.recycle();
        if (r107 == 0) goto L27;
        View r115 = ViewGroup.inflate(r110, r107, null);
        if ((r115 instanceof jma.a) == false) goto L21;
        jma.a r108 = (jma.a) r115;
    L22:
        if (r108 == null) goto L24;
        setRefreshHeader(r108);
        goto L27
    L24:
        setRefreshHeader(new a(r115));
        goto L27
    L21:
        r108 = null;
    L27:
        if (this.f402546b != null) goto L29;
        setRefreshHeader(new ODefaultRefreshHeader(r110, null));
    L29:
        jma.a r116 = this.f402546b;
        if ((r116 instanceof ODefaultRefreshHeader) == false) goto L32;
        r100 = (ODefaultRefreshHeader) r116;
    L32:
        if (r100 == null) goto L53;
        if (r114 == null) goto L36;
        r100.f402580e = r114;
    L36:
        if (r101 == null) goto L38;
        r100.f402581f = r101;
    L38:
        if (r102 == null) goto L40;
        r100.f402582g = r102;
    L40:
        if (r103 == null) goto L42;
        r100.f402583h = r103;
    L42:
        TextView r117 = r100.f402579d;
        if (r100.f402578c.getVisibility() != 0) goto L46;
        CharSequence r118 = r100.f402582g;
    L52:
        r117.setText(r118);
        goto L53
    L46:
        if (r100.f402577b.getVisibility() != 0) goto L49;
        r118 = r100.f402583h;
        goto L52
    L49:
        if (r100.f402584i == false) goto L51;
        r118 = r100.f402581f;
        goto L52
    L51:
        r118 = r100.f402580e;
    L53:
        if (r104 == null) goto L56;
        setDefaultHeaderTextColor(r104.intValue());
    L56:
        if (r106 == null) goto L59;
        setDefaultHeaderProgressBackgroundColor(r106.intValue());
    L59:
        if (r105 == null) goto L63;
        setDefaultHeaderIconColor(r105.intValue());
        return;
    L63:
        return;
    L15:
        r106 = null;
        goto L16
    L11:
        r105 = null;
        goto L13
    L7:
        r104 = null;
        goto L9
    L25:
        r114 = null;
        r101 = null;
        r102 = null;
        r106 = null;
        r103 = null;
        r104 = null;
        r105 = null;
        goto L27
    }

    public /* synthetic */ OPullRefreshLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        this.f402545a.onNestedScrollAccepted(r100, r101, r102, r103);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (isEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.C == false) goto L9;
        if ((r102 & 2) == 0) goto L9;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r110, int r111) {
        f();
        int r103 = getMeasuredWidth();
        int r104 = getMeasuredHeight();
        if (r103 == 0) goto L24;
        if (r104 == 0) goto L25;
        int r105 = getPaddingLeft();
        int r112 = getPaddingTop();
        int r106 = r103 - getPaddingRight();
        int r107 = r104 - getPaddingBottom();
        View r113 = this.f402547c;
        if (r113 == null) goto L12;
        ViewGroup.LayoutParams r108 = r113.getLayoutParams();
        if (r108 == null) goto L23;
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
        int r114 = r113.getMeasuredHeight();
        int r115 = r109.leftMargin + r105;
        int r116 = ((r112 - r114) + this.f402562r) + r109.topMargin;
        r113.layout(r115, r116, r113.getMeasuredWidth() + r115, r114 + r116);
        goto L12
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L12:
        View r117 = this.f402548d;
        if (r117 == null) goto L18;
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
        if (r118 == null) goto L21;
        ViewGroup.MarginLayoutParams r119 = (ViewGroup.MarginLayoutParams) r118;
        r117.layout(r105 + r119.leftMargin, r112 + r119.topMargin, r106 - r119.rightMargin, r107 - r119.bottomMargin);
        goto L18
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L18:
        c();
        return;
    L25:
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r103, "consumed");
        if (r104 == 0) goto L6;
        return;
    L6:
        if (this.C == true) goto L9;
        return;
    L9:
        if (this.f402565u == true) goto L14;
        if (this.f402564t == false) goto L14;
        return;
    L14:
        if (r102 <= 0) goto L18;
        int r105 = this.f402551g;
        if (r105 <= 0) goto L18;
        int r106 = Math.min(r102, r105);
        i(this.f402551g - r106);
        r103[1] = r106;
    L18:
        if (r102 < 0) goto L20;
        return;
    L20:
        if (d() == false) goto L22;
        return;
    L22:
        if (this.f402554j == RefreshState.REFRESHING) goto L29;
        int r107 = e(this.f402551g, Math.abs(r102));
        if (r107 <= 0) goto L30;
        i(this.f402551g + r107);
        r103[1] = r102;
        return;
    L30:
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r110, int r111, int r112, int r113, int r114, int r115) {
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        onNestedScroll(r110, r111, r112, r113, r114, r115, new int[2]);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105, int[] r106) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r106, "consumed");
        if (r105 == 0) goto L6;
        return;
    L6:
        if (this.C == true) goto L9;
        return;
    L9:
        if (this.f402565u == false) goto L11;
    L13:
        if (r104 < 0) goto L15;
        return;
    L15:
        if (d() == false) goto L17;
        return;
    L17:
        if (this.f402554j != RefreshState.REFRESHING) goto L19;
        boolean r107 = true;
    L20:
        if (r107 == true) goto L27;
        int r108 = e(this.f402551g, Math.abs(r104));
        if (r108 <= 0) goto L28;
        i(this.f402551g + r108);
        r106[1] = r106[1] + r104;
        return;
    L28:
        return;
    L27:
        return;
    L19:
        r107 = false;
        goto L20
    L11:
        if (this.f402564t == false) goto L13;
    }
}
