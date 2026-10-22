package com.larus.common_ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\fH\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/larus/common_ui/view/NestedScrollableHost;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "touchSlop", "", "initialX", "", "initialY", "parentViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getParentViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "getChild", "()Landroid/view/View;", "canChildScroll", "", "orientation", "delta", "onInterceptTouchEvent", "e", "Landroid/view/MotionEvent;", "handleInterceptTouchEvent", "", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class NestedScrollableHost extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f328244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f328245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f328246c;

    public static final class a {
    }

    static {
    }

    private final View getChild() {
        if (getChildCount() > 0) goto L7;
        return null;
    L7:
        return getChildAt(0);
    }

    private final ViewPager2 getParentViewPager() {
        Object r100 = getParent();
        if ((r100 instanceof View) == false) goto L5;
        View r101 = (View) r100;
    L6:
        if (r101 == null) goto L13;
        if ((r101 instanceof ViewPager2) == true) goto L13;
        Object r102 = r101.getParent();
        if ((r102 instanceof View) == false) goto L5;
        r101 = (View) r102;
        goto L6
    L5:
        r101 = null;
    L13:
        if ((r101 instanceof ViewPager2) == true) goto L15;
        return null;
    L15:
        return (ViewPager2) r101;
    L16:
        r101 = null;
        goto L6
    }

    public NestedScrollableHost(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f328244a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "e");
        ViewPager2 r100 = getParentViewPager();
        if (r100 == null) goto L44;
        int r101 = r100.getOrientation();
        float r102 = 1.0f;
        if (a(r101, -1.0f) == true) goto L10;
        if (a(r101, 1.0f) == false) goto L44;
    L10:
        if (r110.getAction() != 0) goto L13;
        this.f328245b = r110.getX();
        this.f328246c = r110.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L44
    L13:
        if (r110.getAction() != 2) goto L44;
        float r103 = r110.getX() - this.f328245b;
        float r104 = r110.getY() - this.f328246c;
        if (r101 != 0) goto L17;
        boolean r105 = true;
    L18:
        float r106 = Math.abs(r103);
        if (r105 == false) goto L21;
        float r107 = 0.5f;
    L22:
        float r108 = r106 * r107;
        float r109 = Math.abs(r104);
        if (r105 == true) goto L26;
        r102 = 0.5f;
    L26:
        float r111 = r109 * r102;
        float r112 = this.f328244a;
        if (r108 > r112) goto L31;
        if (r111 <= r112) goto L44;
    L31:
        if (r111 <= r108) goto L33;
        boolean r113 = true;
    L34:
        if (r105 != r113) goto L36;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L44
    L36:
        if (r105 == true) goto L40;
        r103 = r104;
    L40:
        if (a(r101, r103) == false) goto L42;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L44
    L42:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L44
    L33:
        r113 = false;
        goto L34
    L21:
        r107 = 1.0f;
        goto L22
    L17:
        r105 = false;
    L44:
        return super.onInterceptTouchEvent(r110);
    }

    public NestedScrollableHost(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f328244a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public boolean a(int r100, float r101) {
        int r102 = -((int) Math.signum(r101));
        if (r100 != 0) goto L5;
        View r103 = getChild();
        if (r103 != null) goto L13;
        return false;
    L13:
        return r103.canScrollHorizontally(r102);
    L5:
        if (r100 == 1) goto L7;
        FLogger.f375446a.e("NestedScrollableHost", "orientation param illegal");
        return false;
    L7:
        View r104 = getChild();
        if (r104 != null) goto L16;
        return false;
    L16:
        return r104.canScrollVertically(r102);
    }
}
