package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.core.view.NestedScrollingParent2;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.common.CastMonitor;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u000f\u0018\u0000 o2\u00020\u00012\u00020\u0002:\u0002opB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010-\u001a\u00020*2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010.\u001a\u00020*2\u0006\u0010!\u001a\u00020\nJ\u001a\u0010/\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\nJ\u000e\u00101\u001a\u00020*2\u0006\u0010$\u001a\u00020\u0019J>\u00102\u001a\u00020*26\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020*0)J>\u00107\u001a\u00020*26\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020*0)J\b\u00108\u001a\u00020*H\u0014J\b\u00109\u001a\u00020*H\u0014J0\u0010:\u001a\u00020*2\u0006\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\u00192\u0006\u0010?\u001a\u00020\u0019H\u0014J(\u0010@\u001a\u00020*2\u0006\u0010A\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u00192\u0006\u0010C\u001a\u00020\u00192\u0006\u0010D\u001a\u00020\u0019H\u0014J\b\u0010E\u001a\u00020*H\u0002J\u0018\u0010F\u001a\u00020*2\u0006\u0010G\u001a\u00020\u00192\u0006\u0010H\u001a\u00020\u0019H\u0016J\u000e\u0010I\u001a\u00020*2\u0006\u0010J\u001a\u00020\u0011J(\u0010K\u001a\u00020\u00112\u0006\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u0019H\u0016J(\u0010P\u001a\u00020*2\u0006\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u0019H\u0016J\u0018\u0010Q\u001a\u00020*2\u0006\u0010M\u001a\u00020\n2\u0006\u0010O\u001a\u00020\u0019H\u0016J8\u0010R\u001a\u00020*2\u0006\u0010M\u001a\u00020\n2\u0006\u0010S\u001a\u00020\u00192\u0006\u0010T\u001a\u00020\u00192\u0006\u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u0019H\u0016J \u0010W\u001a\u00020\u00112\u0006\u0010M\u001a\u00020\n2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020YH\u0016J(\u0010[\u001a\u00020*2\u0006\u0010<\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u00192\u0006\u0010\\\u001a\u00020\u00192\u0006\u0010]\u001a\u00020\u0019H\u0014J0\u0010^\u001a\u00020*2\u0006\u0010M\u001a\u00020\n2\u0006\u0010_\u001a\u00020\u00192\u0006\u0010`\u001a\u00020\u00192\u0006\u0010a\u001a\u00020b2\u0006\u0010O\u001a\u00020\u0019H\u0016J\b\u0010c\u001a\u00020*H\u0016J\u0006\u0010d\u001a\u00020*J\u0006\u0010e\u001a\u00020*J\b\u0010f\u001a\u00020*H\u0002J\n\u0010g\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010h\u001a\u00020\u00192\u0006\u00100\u001a\u00020\n2\u0006\u0010i\u001a\u00020\u0019H\u0002J\u0012\u0010j\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010k\u001a\u00020*H\u0002J\b\u0010l\u001a\u00020*H\u0002J\u0010\u0010m\u001a\u00020\u00192\u0006\u00100\u001a\u00020\nH\u0002J\u0010\u0010n\u001a\u00020\u00192\u0006\u00100\u001a\u00020\nH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00190&X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010'\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020*0)0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006q"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmRecordingNavLayout;", "Landroid/widget/LinearLayout;", "Landroidx/core/view/NestedScrollingParent2;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "titleNameView", "Landroid/view/View;", "titleTextView", "tabView", "middleContainer", "listener", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmRecordingNavLayout$IMmStickNavListener;", "value", "", "isForceHideTopView", "()Z", "setForceHideTopView", "(Z)V", "smoothScroller", "Landroid/widget/Scroller;", "magic20", "", "highThreshold", "titleVisibilityHysteresis", "scrolledDistance", "controlsVisible", "topHeaderVisibleHeight", "topHeaderScrollRange", "isEnableScroll", "topBarView", "topBarBottom", "wasTitleVisible", "contentTopInsetPx", "titleBaseTopMargins", "Ljava/util/WeakHashMap;", "onScrollChangedListeners", "", "Lkotlin/Function2;", "", "updateMiddleContainerRunnable", "Ljava/lang/Runnable;", "setListener", "setTopBarView", "bindSlotViews", "titleView", "setContentTopInsetPx", "addOnScrollChangedListener", "Lkotlin/ParameterName;", "name", "scrollY", "oldScrollY", "removeOnScrollChangedListener", "onDetachedFromWindow", "onFinishInflate", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "l", "t", "r", "b", "onSizeChanged", "w", "h", "oldw", "oldh", "updateTopBarBottom", "scrollTo", "x", "y", "setEnableScroll", "enableScroll", "onStartNestedScroll", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, PickerReporterConstants.KEY.TARGET, "axes", "type", "onNestedScrollAccepted", "onStopNestedScroll", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedPreFling", "velocityX", "", "velocityY", "onScrollChanged", "oldl", "oldt", "onNestedPreScroll", "dx", "dy", "consumed", "", "computeScroll", "hideTopView", "showTopView", "checkTitleVisibility", "getTitleTextView", "getTitleContentBottom", "titleTopOnScreen", "applyContentTopInset", "updateTopHeaderMetrics", "updateMiddleContainerHeight", "getTopHeaderVisibleHeight", "getTopHeaderScrollRange", "Companion", "IMmStickNavListener", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmRecordingNavLayout extends LinearLayout implements NestedScrollingParent2 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f435672v = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f435673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f435674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f435675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f435676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f435677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f435678f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Scroller f435679g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f435680h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f435681i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f435682j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f435683k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f435684l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f435685m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f435686n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f435687o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f435688p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f435689q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f435690r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final WeakHashMap<View, Integer> f435691s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Set<Function2<Integer, Integer, Unit>> f435692t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final c f435693u;

    public static final class a {
    }

    public interface b {
        void a();

        void b();

        void c(boolean r100);

        void d();

        void e();

        void f();
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmRecordingNavLayout f435694a;

        public c(MmRecordingNavLayout r100) {
            this.f435694a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MmRecordingNavLayout r100 = this.f435694a;     // Catch: Throwable -> L4
            int r101 = MmRecordingNavLayout.f435672v;     // Catch: Throwable -> L4
            r100.c();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if ((r102 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final View getTitleTextView() {
        View r100 = this.f435674b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        View r101 = this.f435673a;
        if (r101 != null) goto L8;
        r101 = findViewById(R.id.mmTitleNameView);
        this.f435673a = r101;
    L8:
        if (r101 == null) goto L12;
        View r102 = r101.findViewById(R.id.tvTopic);
        if (r102 == null) goto L12;
        this.f435674b = r102;
        return r102;
    L12:
        return null;
    }

    public final void c() {
        View r100 = this.f435676d;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = RangesKt.coerceAtLeast(this.f435684l - getScrollY(), 0);
        int r102 = getMeasuredHeight() - r101;
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        int r104 = bwb.b.f21271a;
        MmUiLogScene r105 = MmUiLogScene.FOUNDATION;
        bwb.b.b(r105, "updateMiddleContainerHeight", "measuredHeight=" + getMeasuredHeight() + ", scrollY=" + getScrollY() + ", topHeaderVisibleHeight=" + this.f435684l + ", topHeaderScrollRange=" + this.f435685m + ", topVisibleHeight=" + r101 + ", targetHeight=" + r102 + ", middleCurrentHeight=" + r100.getHeight() + ", middleLpHeight=" + r103.height, null, 8);
        if (r103.height == r102) goto L9;
        r103.height = r102;
        r100.setLayoutParams(r103);
        bwb.b.b(r105, "updateMiddleContainerHeight", "height: " + r102 + ", topVisibleHeight: " + r101, null, 8);
        return;
    }

    public final void d() {
        View r100 = this.f435673a;
        if (r100 == null) goto L31;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        ViewGroup.MarginLayoutParams r102 = null;
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r101;
    L8:
        int r104 = r100.getMeasuredHeight();
        int r105 = 0;
        if (r103 == null) goto L11;
        int r106 = r103.topMargin;
    L12:
        int r107 = r104 + r106;
        if (r103 == null) goto L15;
        int r108 = r103.bottomMargin;
    L16:
        int r109 = r107 + r108;
        ViewGroup.LayoutParams r110 = r100.getLayoutParams();
        if ((r110 instanceof ViewGroup.MarginLayoutParams) == false) goto L19;
        r102 = (ViewGroup.MarginLayoutParams) r110;
    L19:
        int r111 = r100.getMeasuredHeight();
        if (r102 == null) goto L22;
        r105 = r102.bottomMargin;
    L22:
        int r112 = r111 + r105;
        if (this.f435684l == r109) goto L25;
    L26:
        this.f435684l = r109;
        this.f435685m = r112;
        if (getScrollY() <= this.f435685m) goto L29;
        scrollTo(getScrollX(), this.f435685m);
    L29:
        removeCallbacks(this.f435693u);
        post(this.f435693u);
        return;
    L25:
        if (this.f435685m != r112) goto L26;
        return;
    L15:
        r108 = 0;
        goto L16
    L11:
        r106 = 0;
        goto L12
    L7:
        r103 = null;
        goto L8
    }

    public final void b() {
        View r100 = getTitleTextView();
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.getVisibility() == 0) goto L8;
        return;
    L8:
        boolean r101 = true;
        if (this.f435688p != 0) goto L14;
        View r102 = this.f435687o;
        if (r102 == null) goto L14;
        int[] r103 = new int[2];
        r102.getLocationOnScreen(r103);
        this.f435688p = r103[1] + r102.getHeight();
    L14:
        int[] r104 = new int[2];
        r100.getLocationOnScreen(r104);
        int r105 = r104[1];
        if ((r100 instanceof TextView) == false) goto L17;
        TextView r106 = (TextView) r100;
    L18:
        if (r106 != null) goto L20;
        int r107 = r100.getHeight();
    L27:
        int r108 = r105 + r107;
        boolean r109 = this.f435689q;
        if (r109 == false) goto L30;
        int r110 = this.f435688p;
    L31:
        if (r108 > r110) goto L34;
        r101 = false;
    L34:
        if (r109 != r101) goto L36;
        return;
    L36:
        if (this.f435677e == null) goto L42;
        int r111 = bwb.b.f21271a;
        bwb.b.b(MmUiLogScene.FOUNDATION, "checkTitleVisibility", "titleBottom=" + r108 + ", topBarBottom=" + this.f435688p + ", visibleThreshold=" + r110 + ", isTitleVisible=" + r101 + ", listener=" + this.f435677e, null, 8);
        this.f435689q = r101;
        b r112 = this.f435677e;
        if (r112 == null) goto L43;
        r112.c(r101);
        return;
    L43:
        return;
    L42:
        return;
    L30:
        r110 = this.f435688p + this.f435681i;
        goto L31
    L20:
        Layout r113 = r106.getLayout();
        if (r113 != null) goto L24;
        r107 = ((TextView) r100).getHeight();
        goto L27
    L24:
        if (r113.getLineCount() > 0) goto L26;
        r107 = ((TextView) r100).getHeight();
        goto L27
    L26:
        r107 = r113.getLineBottom(r113.getLineCount() - 1);
        r105 = r105 + r106.getTotalPaddingTop();
        goto L27
    L17:
        r106 = null;
        goto L18
    }

    @Override // android.view.View
    public final void computeScroll() {
        super.computeScroll();
        if (this.f435679g.computeScrollOffset() == false) goto L6;
        scrollTo(this.f435679g.getCurrX(), this.f435679g.getCurrY());
        postInvalidate();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f435693u);
        this.f435674b = null;
        this.f435677e = null;
        this.f435692t.clear();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        View r100 = findViewById(R.id.mmTitleNameView);
        this.f435673a = r100;
        if (r100 == null) goto L5;
        View r101 = r100.findViewById(R.id.tvTopic);
    L6:
        this.f435674b = r101;
        this.f435675c = findViewById(R.id.mmTabLayoutContainerFl);
        this.f435676d = findViewById(R.id.mmMiddleContainerArea);
        int r102 = bwb.b.f21271a;
        bwb.b.b(MmUiLogScene.FOUNDATION, "onFinishInflate", null, null, 12);
        removeCallbacks(this.f435693u);
        postDelayed(this.f435693u, 100);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public MmRecordingNavLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void a(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
    L8:
        if (r102 != null) goto L10;
        return;
    L10:
        WeakHashMap<View, Integer> r103 = this.f435691s;
        Integer r104 = r103.get(r100);
        if (r104 != null) goto L13;
        r104 = Integer.valueOf(r102.topMargin);
        r103.put(r100, r104);
    L13:
        int r105 = r104.intValue() + this.f435690r;
        if (r102.topMargin == r105) goto L17;
        r102.topMargin = r105;
        r100.setLayoutParams(r102);
        return;
    L17:
        return;
    L7:
        r102 = null;
        goto L8
    }

    public final void setContentTopInsetPx(int r100) {
        int r101 = RangesKt.coerceAtLeast(r100, 0);
        if (this.f435690r != r101) goto L5;
        return;
    L5:
        this.f435690r = r101;
        a(this.f435673a);
        d();
        removeCallbacks(this.f435693u);
        post(this.f435693u);
        requestLayout();
    }

    public final void setEnableScroll(boolean r100) {
        this.f435686n = r100;
    }

    public final void setForceHideTopView(boolean r100) {
        this.f435678f = r100;
        if (r100 == false) goto L10;
        int r101 = getScrollY();
        int r102 = this.f435685m;
        if (r101 >= r102) goto L11;
        scrollBy(0, r102 - getScrollY());
        b r103 = this.f435677e;
        if (r103 == null) goto L12;
        getScrollY();
        r103.e();
        r103.d();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f435677e = r100;
    }

    public final void setTopBarView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "topBarView");
        this.f435687o = r100;
    }

    public MmRecordingNavLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f435679g = new Scroller(r100);
        this.f435680h = UIUtils.dp2px(r100, 20);
        this.f435681i = UIUtils.dp2px(r100, 8.0f);
        this.f435683k = true;
        this.f435686n = true;
        this.f435689q = true;
        this.f435691s = new WeakHashMap();
        this.f435692t = new LinkedHashSet();
        this.f435693u = new c(this);
        setOrientation(1);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        int r102 = bwb.b.f21271a;
        bwb.b.b(MmUiLogScene.FOUNDATION, "onStopNestedScroll", "type=" + r101 + ", scrollY=" + getScrollY() + ", topHeaderVisibleHeight=" + this.f435684l + ", topHeaderScrollRange=" + this.f435685m, null, 8);
    }

    @Override // android.view.View
    public final void scrollTo(int r100, int r101) {
        if (r101 >= 0) goto L4;
        r101 = 0;
    L4:
        int r102 = this.f435685m;
        if (r101 <= r102) goto L8;
        r101 = r102;
    L8:
        if (r101 == getScrollY()) goto L11;
        super.scrollTo(r100, r101);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        if (getScrollY() >= this.f435685m) goto L7;
        return false;
    L7:
        return super.onNestedPreFling(r100, r101, r102);
    }

    @Override // android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        int r104 = bwb.b.f21271a;
        bwb.b.b(MmUiLogScene.FOUNDATION, "onScrollChanged", "current t: " + r101 + ", oldt: " + r103, null, 8);
        Iterator<T> r105 = this.f435692t.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        ((Function2) r105.next()).invoke(Integer.valueOf(r101), Integer.valueOf(r103));
        goto L4
    L6:
        int r106 = r101 - r103;
        int r107 = this.f435682j;
        int r108 = this.f435680h;
        if (r107 <= r108) goto L15;
        if (this.f435683k == false) goto L15;
        b r109 = this.f435677e;
        if (r109 == null) goto L13;
        r109.b();
    L13:
        this.f435683k = false;
        this.f435682j = 0;
    L22:
        boolean r110 = this.f435683k;
        if (r110 == false) goto L25;
        if (r106 <= 0) goto L25;
    L27:
        this.f435682j += r106;
    L28:
        c();
        b();
        return;
    L25:
        if (r110 == true) goto L28;
        if (r106 >= 0) goto L28;
    L15:
        if (r107 >= (-r108)) goto L22;
        if (this.f435683k == true) goto L22;
        b r111 = this.f435677e;
        if (r111 == null) goto L21;
        r111.a();
    L21:
        this.f435683k = true;
        this.f435682j = 0;
        goto L22
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        int r104 = bwb.b.f21271a;
        bwb.b.b(MmUiLogScene.FOUNDATION, "onSizeChanged", "w: " + r100 + ", h: " + r101, null, 8);
        removeCallbacks(this.f435693u);
        postDelayed(this.f435693u, 100);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        a(this.f435673a);
        d();
        View r105 = this.f435687o;
        if (r105 == null) goto L6;
        int[] r106 = new int[2];
        r105.getLocationOnScreen(r106);
        this.f435688p = r106[1] + r105.getHeight();
    L6:
        b();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r110, int[] r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r111, "consumed");
        if (this.f435686n == true) goto L6;
        return;
    L6:
        if (r112 != 0) goto L9;
        getParent().requestDisallowInterceptTouchEvent(true);
    L9:
        if (this.f435678f == false) goto L18;
        if (getScrollY() < this.f435685m) goto L18;
        if (r112 != 1) goto L44;
        b r102 = this.f435677e;
        if (r102 == null) goto L45;
        r102.f();
        return;
    L45:
        return;
    L44:
        return;
    L18:
        if (r110 > 0) goto L20;
    L22:
        boolean r103 = false;
    L23:
        if (r110 < 0) goto L25;
    L29:
        boolean r104 = false;
    L30:
        int r105 = bwb.b.f21271a;
        bwb.b.b(MmUiLogScene.FOUNDATION, "onNestedPreScroll", "hiddenTop: " + r103 + ", showTop: " + r104 + ", scrollY: " + getScrollY() + ", topHeaderVisibleHeight=" + this.f435684l + ", topHeaderScrollRange=" + this.f435685m, null, 8);
        b r106 = this.f435677e;
        if (r106 == null) goto L38;
        getScrollY();
        r106.e();
        getScrollY();
        r106.d();
        if (r112 != 1) goto L38;
        if (getScrollY() != 0) goto L38;
        r106.f();
    L38:
        if (getScrollY() != 0) goto L40;
        this.f435679g.abortAnimation();
    L40:
        if (r103 == true) goto L42;
        if (r104 == true) goto L42;
        return;
    L42:
        scrollBy(0, r110);
        r111[1] = r110;
        return;
    L25:
        if (getScrollY() < 0) goto L29;
        if (r100.canScrollVertically(-1) == true) goto L29;
        r104 = true;
        goto L30
    L20:
        if (getScrollY() >= this.f435685m) goto L22;
        r103 = true;
        goto L23
    }
}
