package com.bytedance.ee.bear.bitable.common.widgets.flex;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.common.CastMonitor;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u00012\u00020\u0002:\u000223B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0014J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0002J0\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0014J\u0012\u0010)\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\fH\u0016J\b\u0010/\u001a\u00020\fH\u0016J\u0010\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\fH\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0012\u0010\u001d\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001c¨\u00064"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/widgets/flex/FixedSizeDebounceInnerRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/bytedance/ee/bear/bitable/common/widgets/flex/InnerScrollController$InnerScrollerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "openInnerScroll", "", "getOpenInnerScroll", "()Z", "setOpenInnerScroll", "(Z)V", "clickListener", "Landroid/view/View$OnClickListener;", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "gestureDetector$delegate", "Lkotlin/Lazy;", "scrollController", "Lcom/bytedance/ee/bear/bitable/common/widgets/flex/InnerScrollController;", "preWidthSpec", "Ljava/lang/Integer;", "preHeightSpec", "onMeasure", "", "widthSpec", "heightSpec", "onMeasureDefault", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "l", "t", "r", "b", "setOnClickListener", "listener", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "canScrollUp", "canScrollBottom", "interceptTouchEvent", "intercept", "Companion", "Detector", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FixedSizeDebounceInnerRecyclerView extends RecyclerView implements com.bytedance.ee.bear.bitable.common.widgets.flex.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f209934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnClickListener f209935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f209936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.common.widgets.flex.c f209937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f209938e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f209939f;

    public static final class a {
    }

    public final class b extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FixedSizeDebounceInnerRecyclerView f209940a;

        public b(FixedSizeDebounceInnerRecyclerView r100) {
            this.f209940a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            FixedSizeDebounceInnerRecyclerView r101 = this.f209940a;
            View.OnClickListener r102 = r101.f209935b;
            if (r102 == null) goto L7;
            r102.onClick(r101);
            return false;
        L7:
            return false;
        }
    }

    public static final class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FixedSizeDebounceInnerRecyclerView f209941a;

        public c(FixedSizeDebounceInnerRecyclerView r100) {
            this.f209941a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            if ((r100 instanceof RecyclerView) == false) goto L7;
            FixedSizeDebounceInnerRecyclerView.r(this.f209941a).onTouchEvent(r101);
            return false;
        L7:
            return false;
        }
    }

    static {
    }

    public FixedSizeDebounceInnerRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FixedSizeDebounceInnerRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final GestureDetector getGestureDetector() {
        return (GestureDetector) this.f209936c.getValue();
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.c.b
    public final boolean p() {
        RecyclerView.LayoutManager r100 = getLayoutManager();
        if ((r100 instanceof FlexboxLayoutManager) == false) goto L17;
        FlexboxLayoutManager r101 = (FlexboxLayoutManager) r100;
        int r102 = -1;
        View r103 = r101.v(r101.getChildCount() - 1, -1, true);
        if (r103 == null) goto L8;
        r102 = r101.getPosition(r103);
    L8:
        RecyclerView.Adapter r104 = getAdapter();
        if (r104 == null) goto L11;
        int r105 = r104.getItemCount();
    L13:
        if (r102 != (r105 - 1)) goto L19;
        return false;
    L19:
        return true;
    L11:
        r105 = 0;
        goto L13
    L17:
        return canScrollVertically(1);
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.c.b
    public final boolean s() {
        RecyclerView.LayoutManager r100 = getLayoutManager();
        int r101 = -1;
        if ((r100 instanceof FlexboxLayoutManager) == false) goto L11;
        FlexboxLayoutManager r102 = (FlexboxLayoutManager) r100;
        View r103 = r102.v(0, r102.getChildCount(), true);
        if (r103 == null) goto L8;
        r101 = r102.getPosition(r103);
    L8:
        if (r101 == 0) goto L12;
        return true;
    L12:
        return false;
    L11:
        return canScrollVertically(-1);
    }

    public final boolean getOpenInnerScroll() {
        return this.f209934a;
    }

    public static final /* synthetic */ GestureDetector r(FixedSizeDebounceInnerRecyclerView r100) {
        return r100.getGestureDetector();
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.c.b
    public final void a(boolean r100) {
        ViewParent r101 = getParent();
        if (r101 == null) goto L6;
        r101.requestDisallowInterceptTouchEvent(r100);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f209934a == false) goto L6;
        this.f209937d.a(r100);
    L6:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        if (r100 == null) goto L4;
        this.f209935b = r100;
        setOnTouchListener(new c(this));
        return;
    L4:
        this.f209935b = null;
        setOnTouchListener(null);
    }

    public final void setOpenInnerScroll(boolean r100) {
        this.f209934a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int r100, int r101) {
        tt5.a.b("FSDI_RV", "(" + hashCode() + ") onMeasure " + View.MeasureSpec.getMode(r100) + ' ' + View.MeasureSpec.getSize(r100) + ' ' + View.MeasureSpec.getMode(r101) + ' ' + View.MeasureSpec.getSize(r101));
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getMode(r101);
        if (r102 != 1073741824) goto L19;
        if (r103 != 1073741824) goto L19;
        Integer r104 = this.f209938e;
        if (r104 != null) goto L9;
    L17:
        tt5.a.h("FSDI_RV", "onMeasure valid");
        super.onMeasure(r100, r101);
    L18:
        this.f209938e = Integer.valueOf(r100);
        this.f209939f = Integer.valueOf(r101);
        return;
    L9:
        if (r100 != r104.intValue()) goto L17;
        Integer r105 = this.f209939f;
        if (r105 == null) goto L17;
        if (r101 != r105.intValue()) goto L17;
        tt5.a.b("FSDI_RV", "onMeasure debounce");
        setMeasuredDimension(RecyclerView.LayoutManager.chooseSize(r100, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), RecyclerView.LayoutManager.chooseSize(r101, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
    L19:
        tt5.a.b("FSDI_RV", "onMeasure normal");
        super.onMeasure(r100, r101);
    }

    public FixedSizeDebounceInnerRecyclerView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f209936c = LazyKt.lazy(new FixedSizeDebounceInnerRecyclerView$gestureDetector$2(r100, this));
        this.f209937d = new com.bytedance.ee.bear.bitable.common.widgets.flex.c(this);
    }

    public /* synthetic */ FixedSizeDebounceInnerRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r110, int r111, int r112, int r113) {
        tt5.a.b("FSDI_RV", "(" + hashCode() + ") onLayout " + r100 + ' ' + r110 + ' ' + r111 + ' ' + r112 + ' ' + r113 + " hasPendingUpdates=" + hasPendingAdapterUpdates());
        if (r100 == false) goto L5;
    L8:
        tt5.a.h("FSDI_RV", "onLayout valid");
        super.onLayout(true, r110, r111, r112, r113);
        return;
    L5:
        if (hasPendingAdapterUpdates() == true) goto L8;
        tt5.a.b("FSDI_RV", "onLayout debounce");
    }
}
