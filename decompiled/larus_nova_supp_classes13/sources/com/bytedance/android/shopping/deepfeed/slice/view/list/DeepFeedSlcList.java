package com.bytedance.android.shopping.deepfeed.slice.view.list;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.deepfeed.slice.service.e;
import com.bytedance.android.shopping.deepfeed.slice.view.video.DeepFeedSliceVideoView;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductBannerIndicatorAnimator;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductOverScrollPagerSnapHelper;
import com.bytedance.android.shopping.feed.utils.f0;
import com.bytedance.android.shopping.inflow.cardui.product.header.layoutmanager.SmoothScrollLayoutManager;
import com.bytedance.android.shopping.widget.banner.PrimeHorizontalRecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/view/list/DeepFeedSlcList;", "Lcom/bytedance/android/shopping/widget/banner/PrimeHorizontalRecyclerView;", "Lcom/bytedance/android/shopping/deepfeed/ui/b;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedSlcList extends PrimeHorizontalRecyclerView implements com.bytedance.android.shopping.deepfeed.ui.b {
    public static final /* synthetic */ int p = 0;
    public final DeepFeedProductOverScrollPagerSnapHelper f;
    public final OrientationHelper g;
    public DeepFeedProductBannerIndicatorAnimator h;
    public boolean i;
    public int j;
    public SlcTemplateContext k;
    public boolean l;
    public boolean m;
    public c n;
    public final a o;

    public static final class a implements com.bytedance.android.shopping.deepfeed.slice.service.a {
        public final /* synthetic */ DeepFeedSlcList a;

        @Override // com.bytedance.android.shopping.deepfeed.slice.service.a
        public final void onDestroy() {
        }

        @Override // com.bytedance.android.shopping.deepfeed.slice.service.a
        public final void onPause() {
        }

        @Override // com.bytedance.android.shopping.deepfeed.slice.service.a
        public final void onResume() {
            if (this.a.isAttachedToWindow() == true) goto L5;
            return;
        L5:
            DeepFeedSlcList r0 = this.a;
            r0.f.e = false;
            if (r0.n.a == false) goto L9;
            r0.C();
            return;
        }

        @Override // com.bytedance.android.shopping.deepfeed.slice.service.a
        public final void onStop() {
            if (this.a.isAttachedToWindow() == true) goto L5;
            return;
        L5:
            DeepFeedSlcList r0 = this.a;
            int r2 = 0;
            if (r0.n.h == false) goto L39;
            r0.D();
            DeepFeedSlcList r1 = this.a;
            DeepFeedSlcListAdapter r3 = r1.v();
            if (r3 != null) goto L10;
            r2 = r1.j;
        L37:
            r1.B(r2);
            return;
        L10:
            int r4 = r3.a.size();
            if (r4 <= 0) goto L37;
            Integer r5 = null;
            View r6 = f0.a(r1, r1.g, null);
            if (r6 == null) goto L22;
            RecyclerView.LayoutManager r7 = r1.getLayoutManager();
            if ((r7 instanceof LinearLayoutManager) == true) goto L19;
            r7 = null;
        L19:
            LinearLayoutManager r8 = (LinearLayoutManager) r7;
            if (r8 == null) goto L22;
            r5 = Integer.valueOf(r8.getPosition(r6));
        L22:
            if (r5 == null) goto L35;
            int r9 = r5.intValue();
            int r10 = r3.a.size();
            if (r10 > 0) goto L27;
        L31:
            r9 = 0;
        L36:
            r2 = RangesKt.coerceIn(r9, 0, r4 - 1);
            goto L37
        L27:
            if (r3.f == true) goto L32;
            if (r9 < r10) goto L36;
            if (r9 == r10) goto L31;
        L34:
            r9 = r10 - 1;
            goto L36
        L32:
            if (r9 >= r10) goto L34;
        L35:
            r9 = r1.j;
            goto L36
        L39:
            r0.smoothScrollToPosition(0);
            this.a.A();
        }

        public a(DeepFeedSlcList r1) {
            this.a = r1;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ DeepFeedSlcList a;
        public final /* synthetic */ int b;

        public b(DeepFeedSlcList r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DeepFeedSlcList r0 = this.a;     // Catch: Throwable -> L4
            int r1 = this.b;     // Catch: Throwable -> L4
            int r2 = DeepFeedSlcList.p;     // Catch: Throwable -> L4
            r0.B(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public DeepFeedSlcList(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepFeedSlcList(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A() {
        this.j = 0;
        scrollToPosition(0);
        e r1 = x();
        if (r1 == null) goto L6;
        r1.reset();
    L6:
        if (this.n.g == false) goto L8;
        post(new com.bytedance.android.shopping.deepfeed.slice.view.list.b(this, u(0)));
    L8:
        D();
        RecyclerView.Adapter r2 = getAdapter();
        if ((r2 instanceof DeepFeedSlcListAdapter) == true) goto L11;
        r2 = null;
    L11:
        DeepFeedSlcListAdapter r3 = (DeepFeedSlcListAdapter) r2;
        if (r3 == null) goto L14;
        r3.f = false;
    L14:
        this.f.c = false;
    }

    public final void C() {
        if (this.m == false) goto L5;
        return;
    L5:
        DeepFeedProductBannerIndicatorAnimator r0 = this.h;
        if (r0 == null) goto L8;
        r0.b();
    L8:
        this.i = true;
        this.l = true;
    }

    public final void D() {
        DeepFeedProductBannerIndicatorAnimator r0 = this.h;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        this.i = false;
    }

    public final boolean t() {
        c r0 = this.n;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.b != true) goto L9;
        if (this.l == false) goto L9;
        return true;
    }

    public final com.bytedance.android.shopping.deepfeed.slice.service.b w() {
        SlcTemplateContext r0 = this.k;
        Object r1 = null;
        if (r0 == null) goto L10;
        Object r2 = r0.o(com.bytedance.android.shopping.deepfeed.slice.service.b.class);
        if ((r2 instanceof com.bytedance.android.shopping.deepfeed.slice.service.b) == false) goto L9;
        r1 = r2;
    L9:
        return (com.bytedance.android.shopping.deepfeed.slice.service.b) r1;
    L10:
        return null;
    }

    public final e x() {
        SlcTemplateContext r0 = this.k;
        Object r1 = null;
        if (r0 == null) goto L10;
        Object r2 = r0.o(e.class);
        if ((r2 instanceof e) == false) goto L9;
        r1 = r2;
    L9:
        return (e) r1;
    L10:
        return null;
    }

    public final DeepFeedSliceVideoView y() {
        RecyclerView.ViewHolder r0 = findViewHolderForAdapterPosition(this.j);
        Object r2 = null;
        if ((r0 instanceof DeepFeedSlcElementVH) == true) goto L5;
        r0 = null;
    L5:
        DeepFeedSlcElementVH r1 = (DeepFeedSlcElementVH) r0;
        if (r1 != null) goto L8;
        return null;
    L8:
        View r3 = z(r1.a);
        if ((r3 instanceof DeepFeedSliceVideoView) == false) goto L13;
        r2 = r3;
    L13:
        return (DeepFeedSliceVideoView) r2;
    }

    public final DeepFeedSlcListAdapter v() {
        RecyclerView.Adapter r0 = getAdapter();
        if ((r0 instanceof DeepFeedSlcListAdapter) == true) goto L6;
        r0 = null;
    L6:
        return (DeepFeedSlcListAdapter) r0;
    }

    public static View z(View r3) {
        if ((r3 instanceof ad3.b) == false) goto L5;
        return r3;
    L5:
        if ((r3 instanceof DeepFeedSliceVideoView) == false) goto L7;
        return r3;
    L7:
        if ((r3 instanceof com.bytedance.android.shopping.deepfeed.slice.view.live.b) == false) goto L10;
        return r3;
    L10:
        if ((r3 instanceof ViewGroup) == false) goto L17;
        ViewGroup r4 = (ViewGroup) r3;
        int r0 = r4.getChildCount();
        int r1 = 0;
    L12:
        if (r1 >= r0) goto L17;
        View r2 = z(r4.getChildAt(r1));
        if (r2 != null) goto L15;
        r1 = r1 + 1;
        goto L12
    L15:
        return r2;
    L17:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B(int r5) {
        DeepFeedSlcListAdapter r0 = v();
        if (r0 == null) goto L22;
        int r1 = r0.a.size();
        if (r1 > 0) goto L7;
        return;
    L7:
        int r2 = RangesKt.coerceIn(r5, 0, r1 - 1);
        int r3 = this.j;
        D();
        this.l = false;
        this.f.c = false;
        DeepFeedSlcListAdapter r4 = v();
        if (r4 == null) goto L10;
        r4.f = false;
    L10:
        this.j = r2;
        e r6 = x();
        if (r6 == null) goto L14;
        r6.k(r2, r3, false);
    L14:
        if (isComputingLayout() == false) goto L16;
    L20:
        post(new b(this, r5));
        return;
    L16:
        if (getScrollState() != 0) goto L20;
        scrollToPosition(r2);
        return;
    }

    public final void E(c r6) {
        Intrinsics.checkNotNullParameter(r6, "props");
        c r1 = this.n;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "props");
        if (r1.a == r6.a) goto L5;
    L19:
        boolean r0 = false;
    L20:
        if (r0 == false) goto L22;
        return;
    L22:
        c r2 = this.n;
        Integer r3 = r2.f;
        boolean r4 = r2.a;
        if (r4 == false) goto L25;
    L33:
        if (r4 == true) goto L35;
    L37:
        com.bytedance.android.shopping.deepfeed.slice.service.b r5 = w();
        if (r5 == null) goto L40;
        r5.K(this.o);
    L40:
        RecyclerView.Adapter r7 = getAdapter();
        if ((r7 instanceof DeepFeedSlcListAdapter) == true) goto L43;
        r7 = null;
    L43:
        DeepFeedSlcListAdapter r8 = (DeepFeedSlcListAdapter) r7;
        if (r8 == null) goto L46;
        boolean r9 = r6.b;
        boolean r10 = r6.c;
        r8.e = r9;
        r8.d = r10;
    L46:
        this.n = r6;
        Integer r11 = r6.f;
        if (r11 != null) goto L49;
        return;
    L49:
        if ((!Intrinsics.areEqual(r11, r3)) == false) goto L58;
        Integer r12 = r6.f;
        int r13 = this.j;
        if (r12 != null) goto L54;
    L55:
        B(r6.f.intValue());
        return;
    L54:
        if (r12.intValue() != r13) goto L55;
        return;
    L58:
        return;
    L35:
        if (r6.a == true) goto L37;
        A();
        goto L37
    L25:
        if (r6.a == false) goto L33;
        if (r6.b == true) goto L29;
        this.l = false;
        D();
        goto L37
    L29:
        if (this.h != null) goto L31;
        this.h = new DeepFeedProductBannerIndicatorAnimator(this);
    L31:
        this.l = true;
        C();
        goto L37
    L5:
        if (r1.b != r6.b) goto L19;
        if (r1.c != r6.c) goto L19;
        if (Intrinsics.areEqual(r1.d, r6.d) == false) goto L19;
        if (Intrinsics.areEqual(r1.e, r6.e) == false) goto L19;
        if (Intrinsics.areEqual(r1.f, r6.f) == false) goto L19;
        if (r1.g != r6.g) goto L19;
        if (r1.h != r6.h) goto L19;
        r0 = true;
        goto L20
    }

    public final Map<String, Object> u(int r6) {
        Pair[] r0 = new Pair[4];
        r0[0] = TuplesKt.to("multi_tab_scroll_to_index", Integer.valueOf(r6));
        r0[1] = TuplesKt.to("multi_tab_active_index", Integer.valueOf(r6));
        DeepFeedSlcListAdapter r1 = v();
        Object r2 = null;
        if (r1 == null) goto L22;
        DeepFeedSlcListAdapter.a r3 = (DeepFeedSlcListAdapter.a) CollectionsKt.getOrNull(r1.a, r6);
        if (r3 == null) goto L22;
        SlcElement r4 = r3.b;
        if (r4 == null) goto L22;
        Map r5 = r4.getProps();
        if (r5 == null) goto L13;
        Object r7 = r5.get("tab_type");
        if (r7 == null) goto L13;
    L18:
        if ((r7 instanceof String) == false) goto L21;
        r2 = r7;
    L21:
        r2 = (String) r2;
    L13:
        Map r8 = r4.getAttr();
        if (r8 == null) goto L16;
        r7 = r8.get("tab_type");
        goto L18
    L16:
        r7 = null;
    L22:
        r0[2] = TuplesKt.to("multi_tab_active_type", r2);
        r0[3] = TuplesKt.to("multi_tab_adapter_index", Integer.valueOf(r6));
        return MapsKt.mapOf(r0);
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.b
    public final void j(float r2, boolean r3) {
        e r0 = x();
        if (r0 == null) goto L5;
        r0.b(r2);
    L5:
        if (r3 == false) goto L8;
        smoothScrollToPosition(this.j + 1);
        return;
    }

    public DeepFeedSlcList(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        DeepFeedProductOverScrollPagerSnapHelper r6 = new DeepFeedProductOverScrollPagerSnapHelper();
        this.f = r6;
        this.n = new c(0);
        this.o = new a(this);
        SmoothScrollLayoutManager r7 = new SmoothScrollLayoutManager(r3);
        r7.setItemPrefetchEnabled(false);
        Resources r8 = th.a.f(r7.b);
        r7.a = WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).density * 0.15f;
        Unit r9 = Unit.INSTANCE;
        setLayoutManager(r7);
        r6.attachToRecyclerView(this);     // Catch: IllegalStateException -> L5
    L10:
        this.g = OrientationHelper.createOrientationHelper(getLayoutManager(), 0);
        setItemViewCacheSize(0);
        setTouchCallback(new DeepFeedSlcList$initMoveListener$1(this));
        addOnScrollListener(new DeepFeedSlcList$onScrollListener$1(this));
        setItemAnimator(null);
        return;
    L5:
        e = move-exception;
        String r10 = e.getMessage();
        if (r10 != null) goto L9;
        r10 = "";
    L9:
        ECExceptionMonitor.c(r10);
        goto L10
    }

    public /* synthetic */ DeepFeedSlcList(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
