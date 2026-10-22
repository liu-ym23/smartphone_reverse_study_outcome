package com.larus.aweme.impl.main_bot;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/aweme/impl/main_bot/ViewPager2FixLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "pagingTouchSlop", "touchSlop", "initialX", "", "initialY", "parentViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getParentViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "parentViewPager$delegate", "Lkotlin/Lazy;", "viewPagerEnableScroll", "", "onInterceptTouchEvent", "e", "Landroid/view/MotionEvent;", "handleInterceptTouchEvent", "", BasicTestActionHandler.TEST_ACTION_RESET, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewPager2FixLayout extends FrameLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f294797g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f294798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f294799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f294800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f294801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f294802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f294803f;

    public static final class a {
    }

    static {
    }

    private final ViewPager2 getParentViewPager() {
        return (ViewPager2) this.f294802e.getValue();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "e");
        ViewPager2 r100 = getParentViewPager();
        if (r100 == null) goto L40;
        int r101 = r110.getAction() & r110.getActionMasked();
        if (r101 != 1) goto L8;
    L38:
        FLogger.f375446a.d("ViewPager2FixLayout", "action up or cancel reset status");
        this.f294803f = false;
        goto L40
    L8:
        if (r101 == 3) goto L38;
        if (r101 == 0) goto L14;
        if (this.f294803f == false) goto L14;
        FLogger.f375446a.d("ViewPager2FixLayout", "viewPagerEnableScroll is true,fast return");
    L14:
        if (r110.getAction() != 0) goto L17;
        this.f294800c = r110.getX();
        this.f294801d = r110.getY();
        this.f294803f = false;
        FLogger.f375446a.d("ViewPager2FixLayout", "actionDown allowInterceptTouchEvent，view pager don't intercept move event，but can consume at onTouch");
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L40
    L17:
        if (r110.getAction() != 2) goto L40;
        float r102 = r110.getX() - this.f294800c;
        float r103 = r110.getY() - this.f294801d;
        if (r100.getOrientation() != 0) goto L21;
        boolean r104 = true;
    L22:
        float r105 = Math.abs(r102);
        float r106 = Math.abs(r103);
        if (r104 == false) goto L32;
        if (r106 >= this.f294799b) goto L40;
        if (r105 <= this.f294798a) goto L40;
        if ((((double) r105) * 0.5d) <= r106) goto L40;
        FLogger.f375446a.d("ViewPager2FixLayout", "DisallowInterceptTouchEvent,ViewPager can consume move event");
        this.f294803f = true;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L40
    L32:
        if (r105 >= this.f294799b) goto L40;
        if (r106 <= this.f294798a) goto L40;
        if ((((double) r106) * 0.5d) <= r105) goto L40;
        FLogger.f375446a.d("ViewPager2FixLayout", "DisallowInterceptTouchEvent,ViewPager can consume move event");
        this.f294803f = true;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L40
    L21:
        r104 = false;
    L40:
        return super.onInterceptTouchEvent(r110);
    }

    public ViewPager2FixLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f294798a = ViewConfiguration.get(r100).getScaledPagingTouchSlop();
        this.f294799b = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f294802e = LazyKt.lazy(new f(this));
    }
}
