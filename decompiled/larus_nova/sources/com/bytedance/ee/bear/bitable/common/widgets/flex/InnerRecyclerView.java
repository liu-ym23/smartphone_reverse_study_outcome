package com.bytedance.ee.bear.bitable.common.widgets.flex;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.n;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0003:;<B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010,\u001a\u00020-2\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\bH\u0014J\u0010\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u00020\u0012H\u0016J\b\u00107\u001a\u00020\u0012H\u0016J\u0010\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020\u0012H\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010'\u001a\u00060(R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010$\u001a\u0004\b)\u0010*¨\u0006="}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/widgets/flex/InnerRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/bytedance/ee/bear/bitable/common/widgets/flex/InnerScrollController$InnerScrollerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxHeightDp", "", "getMaxHeightDp", "()F", "setMaxHeightDp", "(F)V", "limitMaxHeightWithFlex", "", "getLimitMaxHeightWithFlex", "()Z", "setLimitMaxHeightWithFlex", "(Z)V", "openInnerScroll", "getOpenInnerScroll", "setOpenInnerScroll", "useOriginWidthSpecInFlexbox", "getUseOriginWidthSpecInFlexbox", "setUseOriginWidthSpecInFlexbox", "clickListener", "Landroid/view/View$OnClickListener;", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "gestureDetector$delegate", "Lkotlin/Lazy;", "scrollController", "Lcom/bytedance/ee/bear/bitable/common/widgets/flex/InnerScrollController;", "flexboxHelper", "Lcom/bytedance/ee/bear/bitable/common/widgets/flex/InnerRecyclerView$FlexboxHelper;", "getFlexboxHelper", "()Lcom/bytedance/ee/bear/bitable/common/widgets/flex/InnerRecyclerView$FlexboxHelper;", "flexboxHelper$delegate", "limitMaxHeight", "", "setOnClickListener", "listener", "onMeasure", "widthSpec", "heightSpec", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "canScrollUp", "canScrollBottom", "interceptTouchEvent", "intercept", "Detector", "FlexboxHelper", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class InnerRecyclerView extends RecyclerView implements com.bytedance.ee.bear.bitable.common.widgets.flex.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f209942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f209943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f209944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f209945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View.OnClickListener f209946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f209947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.common.widgets.flex.c f209948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f209949h;

    public static final class a {
    }

    public final class b extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InnerRecyclerView f209950a;

        public b(InnerRecyclerView r100) {
            this.f209950a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            InnerRecyclerView r101 = this.f209950a;
            View.OnClickListener r102 = r101.f209946e;
            if (r102 == null) goto L7;
            r102.onClick(r101);
            return false;
        L7:
            return false;
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InnerRecyclerView f209951a;

        public c(InnerRecyclerView r100) {
            this.f209951a = r100;
        }
    }

    public static final class d implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InnerRecyclerView f209952a;

        public d(InnerRecyclerView r100) {
            this.f209952a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            if ((r100 instanceof RecyclerView) == false) goto L7;
            InnerRecyclerView.r(this.f209952a).onTouchEvent(r101);
            return false;
        L7:
            return false;
        }
    }

    static {
    }

    public InnerRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InnerRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final c getFlexboxHelper() {
        return (c) this.f209949h.getValue();
    }

    private final GestureDetector getGestureDetector() {
        return (GestureDetector) this.f209947f.getValue();
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

    public final boolean getLimitMaxHeightWithFlex() {
        return this.f209943b;
    }

    public final float getMaxHeightDp() {
        return this.f209942a;
    }

    public final boolean getOpenInnerScroll() {
        return this.f209944c;
    }

    public final boolean getUseOriginWidthSpecInFlexbox() {
        return this.f209945d;
    }

    public static final /* synthetic */ GestureDetector r(InnerRecyclerView r100) {
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
        if (this.f209944c == false) goto L6;
        this.f209948g.a(r100);
    L6:
        return super.dispatchTouchEvent(r100);
    }

    public final void setLimitMaxHeightWithFlex(boolean r100) {
        this.f209943b = r100;
    }

    public final void setMaxHeightDp(float r100) {
        this.f209942a = r100;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        if (r100 == null) goto L4;
        this.f209946e = r100;
        setOnTouchListener(new d(this));
        return;
    L4:
        this.f209946e = null;
        setOnTouchListener(null);
    }

    public final void setOpenInnerScroll(boolean r100) {
        this.f209944c = r100;
    }

    public final void setUseOriginWidthSpecInFlexbox(boolean r100) {
        this.f209945d = r100;
    }

    public final void t(float r100) {
        this.f209942a = r100;
        this.f209944c = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int r100, int r101) {
        boolean r102 = true;
        int r103 = Integer.MIN_VALUE;
        boolean r104 = false;
        if ((getLayoutManager() instanceof FlexboxLayoutManager) == true) goto L5;
        float r105 = this.f209942a;
        if (r105 == 0.0f) goto L34;
        r102 = false;
    L34:
        if (r102 == true) goto L36;
        r101 = View.MeasureSpec.makeMeasureSpec(n.d((int) r105), Integer.MIN_VALUE);
    L36:
        super.onMeasure(r100, r101);
        return;
    L5:
        if (this.f209943b == false) goto L12;
        float r106 = this.f209942a;
        if (r106 == 0.0f) goto L10;
        r102 = false;
    L10:
        if (r102 == true) goto L12;
        r101 = View.MeasureSpec.makeMeasureSpec(n.d((int) r106), Integer.MIN_VALUE);
    L12:
        c r107 = getFlexboxHelper();
        Object r108 = r107.f209951a.getAdapter();
        if ((r108 instanceof com.bytedance.ee.bear.bitable.common.widgets.flex.b) == false) goto L23;
        com.bytedance.ee.bear.bitable.common.widgets.flex.b r109 = (com.bytedance.ee.bear.bitable.common.widgets.flex.b) r108;
        if (r109.M1() == true) goto L18;
        r104 = r109.R();
    L18:
        int r110 = View.MeasureSpec.getSize(r100);
        if (r104 == false) goto L21;
        r103 = 1073741824;
    L21:
        int r111 = View.MeasureSpec.makeMeasureSpec(r110, r103);
    L26:
        Object r112 = getFlexboxHelper().f209951a.getAdapter();
        if ((r112 instanceof com.bytedance.ee.bear.bitable.common.widgets.flex.b) == false) goto L29;
        r101 = ((com.bytedance.ee.bear.bitable.common.widgets.flex.b) r112).k0(r100, r101);
        tt5.a.b("InnerRecyclerView", "FlexboxHelper>>>getMeasureHeight=" + View.MeasureSpec.getSize(r101));
    L29:
        super.onMeasure(r111, r101);
        return;
    L23:
        if (r107.f209951a.getUseOriginWidthSpecInFlexbox() == false) goto L25;
        r111 = r100;
        goto L26
    L25:
        r111 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r100), 1073741824);
        goto L26
    }

    public InnerRecyclerView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f209947f = LazyKt.lazy(new InnerRecyclerView$gestureDetector$2(r100, this));
        this.f209948g = new com.bytedance.ee.bear.bitable.common.widgets.flex.c(this);
        this.f209949h = LazyKt.lazy(new InnerRecyclerView$flexboxHelper$2(this));
    }

    public /* synthetic */ InnerRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
