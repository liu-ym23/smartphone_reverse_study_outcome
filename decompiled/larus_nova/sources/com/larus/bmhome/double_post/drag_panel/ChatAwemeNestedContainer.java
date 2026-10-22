package com.larus.bmhome.double_post.drag_panel;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.platform.model.chat.ChatAwemeFeedConfig;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 i2\u00020\u00012\u00020\u0002:\u0003ijkB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0011J\u0006\u0010-\u001a\u00020\u0011J\u000e\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020\u0013J\u0018\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020\u00112\b\u00102\u001a\u0004\u0018\u000103J\b\u00104\u001a\u00020+H\u0002J\u0012\u00105\u001a\u00020+2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\"\u00106\u001a\u00020+2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\f\u00108\u001a\b\u0012\u0004\u0012\u00020\b0\u0018J\b\u00109\u001a\u00020\bH\u0002J\b\u0010:\u001a\u00020+H\u0014J\u0010\u0010;\u001a\u00020+2\b\b\u0002\u0010<\u001a\u00020\u0011J\u0006\u0010=\u001a\u00020+J\u0018\u0010>\u001a\u00020+2\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\bH\u0014J\u0018\u0010A\u001a\u00020+2\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\bH\u0016J(\u0010D\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020\u000e2\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\bH\u0016J(\u0010I\u001a\u00020+2\u0006\u0010E\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020\u000e2\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\bH\u0016J\u0018\u0010J\u001a\u00020+2\u0006\u0010F\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\bH\u0016J0\u0010K\u001a\u00020+2\u0006\u0010F\u001a\u00020\u000e2\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020O2\u0006\u0010H\u001a\u00020\bH\u0016J\u000e\u0010P\u001a\u00020+2\u0006\u0010Q\u001a\u00020\u0011J\u000e\u0010R\u001a\u00020+2\u0006\u0010S\u001a\u00020\u0011J8\u0010T\u001a\u00020+2\u0006\u0010F\u001a\u00020\u000e2\u0006\u0010U\u001a\u00020\b2\u0006\u0010V\u001a\u00020\b2\u0006\u0010W\u001a\u00020\b2\u0006\u0010X\u001a\u00020\b2\u0006\u0010H\u001a\u00020\bH\u0016J\u0006\u0010Y\u001a\u00020+J \u0010Z\u001a\u00020\u00112\u0006\u0010F\u001a\u00020\u000e2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\\H\u0016J(\u0010^\u001a\u00020\u00112\u0006\u0010F\u001a\u00020\u000e2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\\2\u0006\u0010N\u001a\u00020\u0011H\u0016J\b\u0010_\u001a\u00020+H\u0016J\u0010\u0010`\u001a\u00020+2\u0006\u0010M\u001a\u00020\bH\u0002J\u000e\u0010a\u001a\u00020\u00112\u0006\u0010b\u001a\u00020cJ\u0014\u0010d\u001a\u0004\u0018\u00010c2\b\u0010e\u001a\u0004\u0018\u00010\u000eH\u0002J\u001c\u0010f\u001a\u00020\u00112\b\u0010g\u001a\u0004\u0018\u00010\u000e2\b\u0010E\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010h\u001a\u00020\u0011H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006l"}, d2 = {"Lcom/larus/bmhome/double_post/drag_panel/ChatAwemeNestedContainer;", "Landroid/widget/LinearLayout;", "Landroidx/core/view/NestedScrollingParent2;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mScroller", "Landroid/widget/OverScroller;", "mTopView", "Landroid/view/View;", "mBottomView", "mEnable", "", "mListener", "Lcom/larus/bmhome/double_post/drag_panel/ChatAwemeNestedContainer$IScrollListener;", "mContainerHeight", "mHeightOffset", "mLastFlingY", "mMaxScrollHeightProvider", "Lkotlin/Function0;", "mPreEnterFullScreenHeightProvider", "mRecoverAnimator", "Landroid/animation/ValueAnimator;", "mTopViewHeight", "lastFullScreenStatus", "mBottomViewVisible", "mBottomViewFullScreen", "mBottomViewCanScrollUp", "chatAwemeFeedConfig", "Lcom/larus/platform/model/chat/ChatAwemeFeedConfig;", "getChatAwemeFeedConfig", "()Lcom/larus/platform/model/chat/ChatAwemeFeedConfig;", "chatAwemeFeedConfig$delegate", "Lkotlin/Lazy;", "mBottomOffsetFourCard", "getMBottomOffsetFourCard", "()I", "setEnable", "", "enable", "getEnable", "setScrollListener", "listener", "scrollToChat", "withAnim", "callback", "Lcom/larus/bmhome/double_post/drag_panel/ChatAwemeNestedContainer$IBackToChatCallback;", "scrollToChatWithoutAnim", "scrollToChatWithAnim", "setHeightConfig", "maxScrollHeightProvider", "preEnterFullScreenHeight", "getAvailableScrollHeight", "onFinishInflate", "updateTopView", "enableMoreHeight", "alignTopView", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "scrollTo", "x", "y", "onStartNestedScroll", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, PickerReporterConstants.KEY.TARGET, "axes", "type", "onNestedScrollAccepted", "onStopNestedScroll", "onNestedPreScroll", "dx", "dy", "consumed", "", "onUnlimitedFlowFullScreen", "isFullScreen", "onUnlimitedFlowVisible", "visible", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "abortNestedContainerAnimation", "onNestedPreFling", "velocityX", "", "velocityY", "onNestedFling", "computeScroll", "dispatchScrollY", "isAtBottomDeepCheck", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "findScrollableRv", RootDescription.ROOT_ELEMENT, "isDescendantOf", "parentView", "isEnterFullScreen", "Companion", "IScrollListener", "IBackToChatCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatAwemeNestedContainer extends LinearLayout implements NestedScrollingParent2 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f311474q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OverScroller f311475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f311476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f311477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f311478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f311479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f311480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f311481g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<Integer> f311482h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Integer> f311483i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ValueAnimator f311484j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f311485k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f311486l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f311487m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f311488n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f311489o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f311490p;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes26.dex */
    public interface b {
        void a(boolean r100);

        void b();

        boolean c();

        void d(boolean r100);

        void e(int r100, boolean r101, int r102);

        void f(boolean r100);

        void g(boolean r100);
    }

    /* JADX INFO: loaded from: classes26.dex */
    public static final class c implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatAwemeNestedContainer f311491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f311492b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f311493c;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            View r100 = this.f311491a.f311476b;
            if (r100 == null) goto L5;
            ViewTreeObserver r101 = r100.getViewTreeObserver();
        L7:
            if (r101 != null) goto L9;
        L11:
            boolean r102 = false;
        L12:
            if (r102 == false) goto L14;
            r101.removeOnPreDrawListener(this);
        L14:
            ChatAwemeNestedContainer r103 = this.f311491a;
            r103.scrollTo(0, r103.getScrollY() + (this.f311492b - this.f311493c));
            return true;
        L9:
            if (r101.isAlive() != true) goto L11;
            r102 = true;
            goto L12
        L5:
            r101 = null;
            goto L7
        }

        public c(ChatAwemeNestedContainer r100, int r101, int r102) {
            this.f311491a = r100;
            this.f311492b = r101;
            this.f311493c = r102;
        }
    }

    static {
    }

    public ChatAwemeNestedContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChatAwemeNestedContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
    }

    private final int getAvailableScrollHeight() {
        int r100 = 0;
        if (this.f311478d == false) goto L9;
        int r101 = this.f311485k + getPaddingTop();
        Function0<Integer> r102 = this.f311482h;
        if (r102 == null) goto L8;
        r100 = r102.invoke().intValue();
    L8:
        return Math.min(r101, r100);
    L9:
        return 0;
    }

    private final ChatAwemeFeedConfig getChatAwemeFeedConfig() {
        return (ChatAwemeFeedConfig) this.f311490p.getValue();
    }

    public final void a() {
        View r100 = this.f311476b;
        int r101 = 0;
        if (r100 == null) goto L7;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L7;
        int r103 = r102.height;
    L8:
        ViewGroup.LayoutParams r104 = null;
        if (this.f311478d == false) goto L21;
        View r105 = this.f311476b;
        if ((r105 instanceof ChatMessageList) == false) goto L13;
        ChatMessageList r106 = (ChatMessageList) r105;
    L14:
        if (r106 == null) goto L18;
        boolean r107 = true;
        if (r106.T() != true) goto L18;
    L19:
        if (r107 == false) goto L21;
        r101 = getMBottomOffsetFourCard();
    L18:
        r107 = false;
        goto L19
    L13:
        r106 = null;
    L21:
        int r108 = (this.f311480f - getPaddingTop()) + r101;
        if (r103 == r108) goto L38;
        this.f311485k = r108;
        View r109 = this.f311476b;
        if (r109 == null) goto L26;
        r104 = r109.getLayoutParams();
    L26:
        if (r104 == null) goto L28;
        r104.height = r108;
    L28:
        View r110 = this.f311476b;
        if (r110 == null) goto L31;
        r110.setLayoutParams(r104);
    L31:
        if (r103 >= r108) goto L39;
        View r111 = this.f311476b;
        if (r111 == null) goto L40;
        ViewTreeObserver r112 = r111.getViewTreeObserver();
        if (r112 == null) goto L41;
        r112.addOnPreDrawListener(new c(this, r108, r103));
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L7:
        r103 = 0;
        goto L8
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.f311475a.computeScrollOffset() == false) goto L74;
        int r100 = this.f311475a.getCurrY();
        int r101 = r100 - this.f311481g;
        this.f311481g = r100;
        FLogger.f375446a.d("ChatAwemeNestedContainer", "computeScroll, dispatchScrollY dy: " + r101);
        b r102 = this.f311479e;
        if (r102 == null) goto L7;
        r102.e(r101, e(), getScrollY());
    L7:
        boolean r103 = true;
        if (r101 <= 0) goto L44;
        View r104 = this.f311476b;
        if (r104 != null) goto L12;
    L14:
        boolean r105 = false;
    L15:
        if (r105 == false) goto L20;
        View r106 = this.f311476b;
        if (r106 == null) goto L72;
        r106.scrollBy(0, r101);
    L72:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L20:
        if (getScrollY() >= getAvailableScrollHeight()) goto L28;
        int r107 = getAvailableScrollHeight() - getScrollY();
        if (r101 > r107) goto L25;
        r107 = r101;
    L25:
        scrollBy(0, r107);
        r101 = r101 - r107;
        if (r101 == 0) goto L72;
    L28:
        RecyclerView r108 = b(this.f311477c);
        if (r108 != null) goto L31;
    L36:
        boolean r109 = false;
    L37:
        if (r109 == true) goto L39;
    L43:
        this.f311475a.abortAnimation();
        goto L72
    L39:
        if (getScrollY() <= (i5.l0() + getMBottomOffsetFourCard())) goto L43;
        if (r108.canScrollVertically(1) != true) goto L43;
        r108.scrollBy(0, r101);
        goto L72
    L31:
        if (r108.getVisibility() != 0) goto L33;
        boolean r110 = true;
    L34:
        if (r110 != true) goto L36;
        r109 = true;
        goto L37
    L33:
        r110 = false;
        goto L34
    L12:
        if (r104.canScrollVertically(1) != true) goto L14;
        r105 = true;
        goto L15
    L44:
        if (r101 >= 0) goto L72;
        RecyclerView r111 = b(this.f311477c);
        if (r111 != null) goto L48;
    L50:
        boolean r112 = false;
    L51:
        if (r112 == false) goto L54;
        r111.scrollBy(0, r101);
        goto L72
    L54:
        if (getScrollY() <= 0) goto L62;
        int r113 = getScrollY();
        if (Math.abs(r101) <= r113) goto L58;
        int r114 = -r113;
    L59:
        scrollBy(0, r114);
        r101 = r101 - r114;
        if (r101 != 0) goto L62;
    L58:
        r114 = r101;
    L62:
        View r115 = this.f311476b;
        if (r115 != null) goto L65;
    L67:
        r103 = false;
    L68:
        if (r103 == false) goto L72;
        View r116 = this.f311476b;
        if (r116 == null) goto L72;
        r116.scrollBy(0, r101);
        goto L72
    L65:
        if (r115.canScrollVertically(-1) != true) goto L67;
    L48:
        if (r111.canScrollVertically(-1) != true) goto L50;
        r112 = true;
        goto L51
    }

    public final boolean e() {
        int r100 = this.f311485k + getPaddingTop();
        Function0<Integer> r101 = this.f311483i;
        boolean r102 = false;
        if (r101 == null) goto L5;
        int r103 = r101.invoke().intValue();
    L6:
        int r104 = (r100 - r103) + getMBottomOffsetFourCard();
        if (getScrollY() < Math.max(i5.A(), r104)) goto L9;
        boolean r105 = true;
    L11:
        if (this.f311486l == r105) goto L15;
        this.f311486l = r105;
        b r106 = this.f311479e;
        if (r106 == null) goto L15;
        r106.a(r105);
    L15:
        RecyclerView r107 = b(this.f311477c);
        if (r107 == null) goto L21;
        if (r107.canScrollVertically(-1) != true) goto L21;
        r102 = true;
    L21:
        if (this.f311489o == r102) goto L25;
        this.f311489o = r102;
        b r108 = this.f311479e;
        if (r108 == null) goto L25;
        r108.g(r102);
    L25:
        return r105;
    L9:
        r105 = false;
        goto L11
    L5:
        r103 = 0;
        goto L6
    }

    private final int getMBottomOffsetFourCard() {
        return com.larus.bmhome.double_post.utils.c.a();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() < 2) goto L6;
        this.f311476b = getChildAt(0);
        this.f311477c = getChildAt(1);
        return;
    }

    public final boolean getEnable() {
        return this.f311478d;
    }

    public static RecyclerView b(View r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof RecyclerView) == false) goto L10;
        return (RecyclerView) r100;
    L10:
        if ((r100 instanceof ViewGroup) == false) goto L17;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L12:
        if (r103 >= r102) goto L17;
        RecyclerView r104 = b(r101.getChildAt(r103));
        if (r104 != null) goto L15;
        r103 = r103 + 1;
        goto L12
    L15:
        return r104;
    L17:
        return null;
    }

    public static boolean c(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "rv");
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if ((r101 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r102 = (LinearLayoutManager) r101;
    L7:
        if (r102 != null) goto L9;
        return false;
    L9:
        RecyclerView.Adapter r103 = r100.getAdapter();
        if (r103 != null) goto L12;
        return false;
    L12:
        int r104 = r103.getItemCount();
        if (r104 != 0) goto L16;
        return false;
    L16:
        if (r102.findFirstVisibleItemPosition() == 0) goto L18;
        return false;
    L18:
        int r105 = r100.computeVerticalScrollOffset();
        int r106 = r100.computeVerticalScrollExtent();
        int r107 = r100.computeVerticalScrollRange();
        if (r105 != 0) goto L23;
        if (r104 <= 1) goto L23;
        return false;
    L23:
        if ((r105 + r106) < (r107 - 5)) goto L26;
        return true;
    L26:
        return false;
    L5:
        r102 = null;
        goto L7
    }

    public final void f(boolean r100) {
        if (r100 == false) goto L9;
        if (this.f311488n == true) goto L14;
        this.f311488n = true;
        b r101 = this.f311479e;
        if (r101 == null) goto L15;
        r101.f(true);
        return;
    L15:
        return;
    L14:
        return;
    L9:
        if (this.f311488n == false) goto L17;
        this.f311488n = false;
        b r102 = this.f311479e;
        if (r102 == null) goto L18;
        r102.f(false);
        return;
    L18:
        return;
    }

    public final void g(boolean r100) {
        if (r100 == false) goto L9;
        if (this.f311487m == false) goto L14;
        this.f311487m = false;
        b r101 = this.f311479e;
        if (r101 == null) goto L15;
        r101.d(false);
        return;
    L15:
        return;
    L14:
        return;
    L9:
        if (this.f311487m == true) goto L17;
        this.f311487m = true;
        b r102 = this.f311479e;
        if (r102 == null) goto L18;
        r102.d(true);
        return;
    L18:
        return;
    }

    public final void h(boolean r100) {
        this.f311475a.abortAnimation();
        if (r100 == false) goto L16;
        final RecyclerView r101 = b(this.f311477c);
        if (r101 == null) goto L7;
        int r102 = r101.computeVerticalScrollOffset();
    L8:
        int r103 = getScrollY();
        if (r102 > 0) goto L12;
        if (r103 > 0) goto L12;
        return;
    L12:
        this.f311475a.abortAnimation();
        ValueAnimator r104 = this.f311484j;
        if (r104 == null) goto L15;
        r104.cancel();
    L15:
        final Ref.IntRef r105 = new Ref.IntRef();
        ValueAnimator r106 = ValueAnimator.ofInt(new int[]{0, r102 + r103});
        r106.setDuration(100);
        r106.addUpdateListener(new j0(r105, r101, this));
        r106.addListener(new k0(this));
        r106.start();
        this.f311484j = r106;
        return;
    L7:
        r102 = 0;
        goto L8
    L16:
        scrollTo(0, 0);
        RecyclerView r107 = b(this.f311477c);
        if (r107 == null) goto L19;
        r107.scrollTo(0, 0);
    L19:
        RecyclerView r108 = b(this.f311477c);
        if (r108 == null) goto L22;
        int r109 = r108.computeVerticalScrollOffset();
    L23:
        if (r109 <= 0) goto L28;
        if (r108 == null) goto L29;
        r108.scrollBy(0, -r109);
        return;
    L29:
        return;
    L28:
        return;
    L22:
        r109 = 0;
        goto L23
    }

    public final void i(boolean r100) {
        View r101 = this.f311476b;
        int r102 = 0;
        if (r101 == null) goto L7;
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        if (r103 == null) goto L7;
        int r104 = r103.height;
    L8:
        if (r100 == true) goto L10;
    L22:
        int r105 = (this.f311480f - getPaddingTop()) + r102;
        if (r104 == r105) goto L32;
        this.f311485k = r105;
        View r106 = this.f311476b;
        if (r106 == null) goto L29;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if (r107 == null) goto L29;
        r107.height = this.f311485k;
    L29:
        View r108 = this.f311476b;
        if (r108 == null) goto L32;
        r108.requestLayout();
    L32:
        requestLayout();
        return;
    L10:
        if (this.f311478d == false) goto L22;
        View r109 = this.f311476b;
        if ((r109 instanceof ChatMessageList) == false) goto L14;
        ChatMessageList r110 = (ChatMessageList) r109;
    L15:
        if (r110 == null) goto L19;
        boolean r111 = true;
        if (r110.T() != true) goto L19;
    L20:
        if (r111 == false) goto L22;
        r102 = getMBottomOffsetFourCard();
    L19:
        r111 = false;
        goto L20
    L14:
        r110 = null;
    L7:
        r104 = 0;
        goto L8
    }

    public final void setEnable(boolean r100) {
        this.f311478d = r100;
    }

    public final void setScrollListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f311479e = r100;
    }

    public static boolean d(View r100, View r101) {
        if (r100 == null) goto L14;
        if (r101 == null) goto L23;
    L5:
        if (r101 == null) goto L24;
        if (Intrinsics.areEqual(r101, r100) == true) goto L8;
        Object r102 = r101.getParent();
        if ((r102 instanceof View) == true) goto L12;
        r101 = null;
        goto L5
    L12:
        r101 = (View) r102;
        goto L5
    L8:
        return true;
    L24:
        return false;
    L23:
        return false;
    L14:
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (getChatAwemeFeedConfig().canEntryAwemeFeed() == true) goto L6;
        super.onMeasure(r100, r101);
        return;
    L6:
        int r102 = View.MeasureSpec.getSize(r101);
        FLogger.f375446a.d("ChatAwemeNestedContainer", "onMeasure heightSize: " + r102 + ", mContainerHeight: " + this.f311480f);
        this.f311480f = r102;
        if (getScrollY() > getMBottomOffsetFourCard()) goto L36;
        View r103 = this.f311476b;
        if (r103 == null) goto L13;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L13;
        int r105 = r104.height;
    L15:
        if (this.f311478d == false) goto L27;
        View r106 = this.f311476b;
        if ((r106 instanceof ChatMessageList) == false) goto L19;
        ChatMessageList r107 = (ChatMessageList) r106;
    L20:
        if (r107 == null) goto L24;
        boolean r108 = true;
        if (r107.T() != true) goto L24;
    L25:
        if (r108 == false) goto L27;
        int r109 = getMBottomOffsetFourCard();
    L28:
        int r110 = (this.f311480f - getPaddingTop()) + r109;
        if (r105 == r110) goto L36;
        this.f311485k = r110;
        View r111 = this.f311476b;
        if (r111 == null) goto L36;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        if (r112 == null) goto L36;
        r112.height = this.f311485k;
    L24:
        r108 = false;
        goto L25
    L19:
        r107 = null;
    L27:
        r109 = 0;
    L13:
        r105 = 0;
    L36:
        if (this.f311478d == false) goto L38;
        int r113 = this.f311480f;
    L39:
        View r114 = this.f311477c;
        if (r114 == null) goto L44;
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
        if (r115 == null) goto L44;
        r115.height = r113;
    L44:
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(this.f311485k + r113, 1073741824));
        int r116 = this.f311485k + getPaddingTop();
        if (getScrollY() <= r116) goto L48;
        if (r116 <= 0) goto L48;
        scrollTo(0, r116);
    L48:
        setMeasuredDimension(getMeasuredWidth(), this.f311480f);
        return;
    L38:
        r113 = 0;
        goto L39
    }

    @Override // android.view.View
    public final void scrollTo(int r100, int r101) {
        boolean r102 = false;
        if (this.f311478d == true) goto L5;
        super.scrollTo(r100, r101);
    L11:
        e();
        if (getScrollY() > getMBottomOffsetFourCard()) goto L14;
        boolean r103 = true;
    L15:
        g(r103);
        if (getScrollY() < (this.f311485k + getPaddingTop())) goto L18;
        r102 = true;
    L18:
        f(r102);
        return;
    L14:
        r103 = false;
        goto L15
    L5:
        int r104 = RangesKt.coerceIn(r101, 0, getAvailableScrollHeight());
        if (r104 <= 0) goto L10;
        b r105 = this.f311479e;
        if (r105 == null) goto L10;
        r105.b();
    L10:
        super.scrollTo(r100, r104);
        goto L11
    }

    public ChatAwemeNestedContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f311475a = new OverScroller(r100);
        this.f311490p = LazyKt.lazy(new i0());
        setOrientation(1);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r110, float r111, float r112) {
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        if (this.f311478d == false) goto L5;
        this.f311475a.abortAnimation();
        this.f311481g = 0;
        this.f311475a.fling(0, 0, 0, (int) r112, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    L5:
        return super.onNestedPreFling(r110, r111, r112);
    }

    public /* synthetic */ ChatAwemeNestedContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        if (this.f311478d == false) goto L5;
        if (r103 == true) goto L9;
        onNestedPreFling(r100, r101, r102);
        return true;
    L9:
        return false;
    L5:
        return super.onNestedFling(r100, r101, r102, r103);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        this.f311475a.abortAnimation();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("onStartNestedScroll: axes = ");
        r105.append(r102);
        r105.append(", height = ");
        View r106 = this.f311476b;
        Integer r107 = null;
        if ((r106 instanceof ViewGroup) == false) goto L5;
        ViewGroup r108 = (ViewGroup) r106;
    L7:
        if (r108 == null) goto L11;
        View r109 = r108.getChildAt(0);
        if (r109 == null) goto L11;
        r107 = Integer.valueOf(r109.getHeight());
    L11:
        r105.append(r107);
        r104.d("ChatAwemeNestedContainer", r105.toString());
        if (this.f311478d == true) goto L14;
        return false;
    L14:
        if ((r102 & 2) == 0) goto L25;
        b r110 = this.f311479e;
        if (r110 != null) goto L18;
    L20:
        boolean r111 = false;
    L21:
        if (r111 == true) goto L26;
        return true;
    L26:
        return false;
    L18:
        if (r110.c() == true) goto L20;
        r111 = true;
        goto L21
    L25:
        return false;
    L5:
        r108 = null;
        goto L7
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r110, "consumed");
        boolean r103 = true;
        if (r111 != 1) goto L5;
        return;
    L5:
        boolean r112 = d(this.f311476b, r100);
        boolean r104 = d(this.f311477c, r100);
        FLogger r105 = FLogger.f375446a;
        r105.d("ChatAwemeNestedContainer", "onNestedPreScroll: dy = " + r102 + ", scrollY = " + getScrollY() + ", getAvailableScrollHeight() = " + getAvailableScrollHeight());
        if (r102 > 0) goto L8;
        if (r102 >= 0) goto L45;
        if (r104 == true) goto L33;
    L35:
        boolean r106 = false;
    L37:
        if (getScrollY() <= 0) goto L45;
        if (r106 == true) goto L40;
        if (r112 == false) goto L45;
    L40:
        int r107 = getScrollY();
        if (Math.abs(r102) <= r107) goto L43;
        int r108 = -r107;
    L44:
        requestDisallowInterceptTouchEvent(true);
        scrollBy(0, r108);
        r110[1] = r108;
        goto L45
    L43:
        r108 = r102;
        goto L44
    L33:
        if (r100.canScrollVertically(-1) == true) goto L35;
        r106 = true;
    L45:
        b r109 = this.f311479e;
        if (r109 == null) goto L49;
        r109.e(r102, e(), getScrollY());
    L49:
        if (getScrollY() > getMBottomOffsetFourCard()) goto L51;
        boolean r113 = true;
    L52:
        g(r113);
        if (getScrollY() >= (this.f311485k + getPaddingTop())) goto L56;
        r103 = false;
    L56:
        f(r103);
        return;
    L51:
        r113 = false;
        goto L52
    L8:
        if ((r100 instanceof RecyclerView) == false) goto L10;
        RecyclerView r114 = (RecyclerView) r100;
    L11:
        if (r114 != null) goto L13;
    L15:
        boolean r115 = false;
    L16:
        if (r112 == false) goto L19;
        if (r115 == false) goto L19;
        boolean r116 = true;
    L20:
        r105.d("ChatAwemeNestedContainer", "onNestedPreScroll:  isAtBottomRefined:" + r115);
        if (r116 == true) goto L24;
        if (r104 == false) goto L45;
    L24:
        if (getScrollY() >= getAvailableScrollHeight()) goto L45;
        int r117 = getAvailableScrollHeight() - getScrollY();
        if (r102 > r117) goto L29;
        r117 = r102;
    L29:
        requestDisallowInterceptTouchEvent(true);
        scrollBy(0, r117);
        r110[1] = r117;
    L19:
        r116 = false;
        goto L20
    L13:
        if (c(r114) != true) goto L15;
        r115 = true;
        goto L16
    L10:
        r114 = null;
        goto L11
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        if (r105 != 1) goto L5;
        return;
    L5:
        FLogger.f375446a.d("ChatAwemeNestedContainer", "onNestedScroll: dyUnconsumed = " + r104 + ", scrollY = " + getScrollY());
        if (r104 <= 0) goto L27;
        boolean r106 = d(this.f311476b, r100);
        if ((r100 instanceof RecyclerView) == false) goto L10;
        RecyclerView r107 = (RecyclerView) r100;
    L11:
        if (r107 != null) goto L13;
    L15:
        boolean r108 = false;
    L16:
        if (r106 == false) goto L19;
        if (r108 == false) goto L19;
        boolean r109 = true;
    L21:
        if (getScrollY() >= getAvailableScrollHeight()) goto L35;
        if (r109 == false) goto L36;
        int r110 = getAvailableScrollHeight() - getScrollY();
        if (r104 <= r110) goto L26;
        r104 = r110;
    L26:
        requestDisallowInterceptTouchEvent(true);
        scrollBy(0, r104);
        return;
    L36:
        return;
    L35:
        return;
    L19:
        r109 = false;
        goto L21
    L13:
        if (c(r107) != true) goto L15;
        r108 = true;
        goto L16
    L10:
        r107 = null;
        goto L11
    L27:
        if (r104 < 0) goto L29;
        return;
    L29:
        if (getScrollY() <= 0) goto L39;
        int r111 = getScrollY();
        if (Math.abs(r104) <= r111) goto L33;
        r104 = -r111;
    L33:
        requestDisallowInterceptTouchEvent(true);
        scrollBy(0, r104);
        return;
    }
}
