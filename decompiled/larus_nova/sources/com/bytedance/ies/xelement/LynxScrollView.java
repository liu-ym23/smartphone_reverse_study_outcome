package com.bytedance.ies.xelement;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.r0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll;
import com.lynx.tasm.event.EventsListener;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
@LynxBehavior(isCreateAsync = true, tagName = {"x-scroll-view"})
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0006\u0019\u001a\u001b\u001c\u001d\u001eJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\rH\u0007J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0012\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\rH\u0007J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0004H\u0007¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/xelement/LynxScrollView;", "Lcom/lynx/tasm/behavior/ui/scroll/AbsLynxUIScroll;", "Lcom/bytedance/ies/xelement/BounceLayout;", "Lcom/lynx/tasm/behavior/r0;", "", "enable", "", "enableLoadMore", "Lcom/lynx/react/bridge/ReadableMap;", "param", "Lcom/lynx/react/bridge/Callback;", "callback", "scrollToIndex", "", "id", "scrollToId", "text", "overflowText", "setBounces", "setPageEnable", "direction", "setLayoutDirection", "setUnifiedNotifyItemChanged", "value", "setEnableCustomHittest", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "e", "f", "x-element-scroll_release"}, k = 1, mv = {1, 6, 0})
public final class LynxScrollView extends AbsLynxUIScroll<BounceLayout> implements r0 {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f249655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f249656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f249657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f249658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f249659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f249660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f249661g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f249662h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f249663i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f249664j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LynxScrollView$createView$1$3 f249665k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LynxBounceView f249666l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f249667m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RecyclerItemStatusHelper f249668n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f249669o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f249670p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f249671q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f249672r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f249673s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f249674t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f249675u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f249676v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f249677w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ArrayList<LynxBaseUI> f249678x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final HashSet<Integer> f249679y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final HashSet<Integer> f249680z;

    public static final class a {
    }

    public final class b extends RecyclerView.Adapter<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashSet<Integer> f249681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LynxScrollView f249682b;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return LynxScrollView.P(this.f249682b).size();
        }

        public b(LynxScrollView r100) {
            this.f249682b = r100;
            this.f249681a = new HashSet();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int r100) {
            return ((LynxBaseUI) ListProtector.get(LynxScrollView.P(this.f249682b), r100)).hashCode();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
            c r101 = (c) r100;
            Intrinsics.checkNotNullParameter(r101, "holder");
            int r102 = r101.getAdapterPosition();
            if (r102 >= 0) goto L5;
            return;
        L5:
            if (r102 < LynxScrollView.P(this.f249682b).size()) goto L7;
            return;
        L7:
            if (this.f249681a.contains(Integer.valueOf(r102)) == true) goto L23;
            LynxBaseUI r103 = (LynxBaseUI) ListProtector.get(LynxScrollView.P(this.f249682b), r102);
            if (r103 != null) goto L11;
        L19:
            this.f249681a.add(Integer.valueOf(r102));
            int r104 = LynxImpressionView.f249604c;
            return;
        L11:
            if ((r103 instanceof LynxImpressionView) == false) goto L19;
            LynxImpressionView r105 = (LynxImpressionView) r103;
            if (r105.f249605a == false) goto L19;
            r105.hashCode();
            LynxContext r106 = r105.getLynxContext();
            if (r106 == null) goto L19;
            EventEmitter r107 = r106.getEventEmitter();
            if (r107 == null) goto L19;
            r107.sendCustomEvent(new com.lynx.tasm.event.a(r105.getSign(), "impression"));
            goto L19
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
            c r101 = (c) r100;
            Intrinsics.checkNotNullParameter(r101, "holder");
            int r102 = r101.getAdapterPosition();
            if (r102 >= 0) goto L5;
            return;
        L5:
            if (r102 < LynxScrollView.P(this.f249682b).size()) goto L7;
            return;
        L7:
            if (this.f249681a.contains(Integer.valueOf(r102)) == false) goto L23;
            LynxBaseUI r103 = (LynxBaseUI) ListProtector.get(LynxScrollView.P(this.f249682b), r102);
            if (r103 != null) goto L11;
        L19:
            this.f249681a.remove(Integer.valueOf(r102));
            int r104 = LynxImpressionView.f249604c;
            return;
        L11:
            if ((r103 instanceof LynxImpressionView) == false) goto L19;
            LynxImpressionView r105 = (LynxImpressionView) r103;
            if (r105.f249606b == false) goto L19;
            r105.hashCode();
            LynxContext r106 = r105.getLynxContext();
            if (r106 == null) goto L19;
            EventEmitter r107 = r106.getEventEmitter();
            if (r107 == null) goto L19;
            r107.sendCustomEvent(new com.lynx.tasm.event.a(r105.getSign(), "exit"));
            goto L19
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            c r102 = (c) r100;
            Intrinsics.checkNotNullParameter(r102, "viewHolder");
            LynxScrollView.R(this.f249682b, r102.itemView, r101);
            LynxScrollView r103 = this.f249682b;
            if (r103.f249677w == false) goto L27;
            if (r101 >= 0) goto L6;
            return;
        L6:
            if (r101 >= LynxScrollView.P(r103).size()) goto L29;
            View r104 = r102.itemView;
            ViewGroup r105 = null;
            if ((r104 instanceof ViewGroup) == false) goto L10;
            ViewGroup r106 = (ViewGroup) r104;
        L11:
            Object r107 = ListProtector.get(LynxScrollView.P(this.f249682b), r101);
            if ((r107 instanceof LynxUI) == false) goto L14;
            LynxUI r108 = (LynxUI) r107;
        L15:
            if (r108 == null) goto L17;
            View r109 = r108.getView();
        L18:
            if (r106 == null) goto L30;
            if (r109 == null) goto L31;
            r106.removeAllViews();
            ViewParent r110 = r109.getParent();
            if ((r110 instanceof ViewGroup) == false) goto L23;
            r105 = (ViewGroup) r110;
        L23:
            if (r105 == null) goto L25;
            r105.removeAllViews();
        L25:
            r106.addView(r109);
            return;
        L31:
            return;
        L30:
            return;
        L17:
            r109 = null;
            goto L18
        L14:
            r108 = null;
            goto L15
        L10:
            r106 = null;
            goto L11
        L29:
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "viewGroup");
            Iterator r102 = LynxScrollView.P(this.f249682b).iterator();
        L4:
            if (r102.hasNext() == false) goto L18;
            LynxBaseUI r103 = (LynxBaseUI) r102.next();
            if (r103.hashCode() != r101) goto L4;
            View r104 = ((LynxUI) r103).getView();
            if (this.f249682b.f249677w == false) goto L23;
            ViewParent r105 = r104.getParent();
            if ((r105 instanceof ViewGroup) == false) goto L12;
            ViewGroup r106 = (ViewGroup) r105;
        L13:
            if (r106 == null) goto L15;
            r106.removeView(r104);
        L15:
            FrameLayout r107 = new FrameLayout(this.f249682b.getLynxContext());
            r107.addView(r104, new FrameLayout.LayoutParams(-2, -2));
            return new c(r107);
        L12:
            r106 = null;
            goto L13
        L23:
            return new c(r104);
        L18:
            return new c(new FrameLayout(this.f249682b.getLynxContext().getContext()));
        }
    }

    public static final class c extends RecyclerView.ViewHolder {
        public c(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public final class d extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxScrollView f249685a;

        public d(LynxScrollView r100) {
            this.f249685a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrollStateChanged(RecyclerView r100, int r110) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            if (1 != r110) goto L5;
            this.f249685a.getLynxContext().getFluencyTraceHelper().b(this.f249685a.getSign(), this.f249685a.getScrollMonitorTag());
        L5:
            this.f249685a.recognizeGesturere();
            LynxScrollView r101 = this.f249685a;
            if (r101.f249662h == true) goto L8;
        L22:
            LynxScrollView r102 = this.f249685a;
            r102.f249667m = r110;
            if (r110 != 0) goto L47;
            r102.getLynxContext().getFluencyTraceHelper().c(this.f249685a.getSign());
            LynxScrollView r111 = this.f249685a;
            if (r111.f249663i == true) goto L28;
            return;
        L28:
            if (((BounceLayout) LynxScrollView.Q(r111)).getMScrollDirection() != BounceLayout.ScrollDirection.HORIZONTAL_LEFT) goto L30;
        L41:
            int r112 = r100.getMeasuredWidth();
            int r103 = r100.computeHorizontalScrollOffset() % r112;
            if ((r103 * 2) <= r112) goto L44;
            r100.smoothScrollBy(r112 - r103, 0);
            return;
        L44:
            r100.smoothScrollBy(-r103, 0);
            return;
        L30:
            if (((BounceLayout) LynxScrollView.Q(this.f249685a)).getMScrollDirection() == BounceLayout.ScrollDirection.HORIZONTAL_RIGHT) goto L41;
            if (((BounceLayout) LynxScrollView.Q(this.f249685a)).getMScrollDirection() != BounceLayout.ScrollDirection.VERTICAL_BOTTOM) goto L35;
        L36:
            int r113 = r100.getMeasuredHeight();
            int r104 = r100.computeVerticalScrollOffset() % r113;
            if ((r104 * 2) <= r113) goto L39;
            r100.smoothScrollBy(0, r113 - r104);
            return;
        L39:
            r100.smoothScrollBy(0, -r104);
            return;
        L35:
            if (((BounceLayout) LynxScrollView.Q(this.f249685a)).getMScrollDirection() == BounceLayout.ScrollDirection.VERTICAL_TOP) goto L36;
            return;
        L47:
            return;
        L8:
            if (r101.f249667m != 1) goto L22;
            if (r110 == 2) goto L13;
            if (r110 != 0) goto L22;
        L13:
            if (((BounceLayout) LynxScrollView.Q(r101)).getMScrollDirection() != BounceLayout.ScrollDirection.HORIZONTAL_LEFT) goto L15;
        L16:
            int r105 = r100.computeHorizontalScrollOffset();
            this.f249685a.V(r105, 0, r105, 0, "dragend");
        L18:
            if (((BounceLayout) LynxScrollView.Q(this.f249685a)).getMScrollDirection() != BounceLayout.ScrollDirection.VERTICAL_BOTTOM) goto L20;
        L21:
            int r106 = r100.computeVerticalScrollOffset();
            this.f249685a.V(0, r106, 0, r106, "dragend");
            goto L22
        L20:
            if (((BounceLayout) LynxScrollView.Q(this.f249685a)).getMScrollDirection() != BounceLayout.ScrollDirection.VERTICAL_TOP) goto L22;
        L15:
            if (((BounceLayout) LynxScrollView.Q(this.f249685a)).getMScrollDirection() != BounceLayout.ScrollDirection.HORIZONTAL_RIGHT) goto L18;
            goto L16
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrolled(RecyclerView r100, int r110, int r111) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            LynxScrollView r101 = this.f249685a;
            boolean r102 = false;
            if (r101.f249661g == false) goto L5;
        L10:
            int r103 = LynxScrollView.S(r101);
        L11:
            LynxScrollView r104 = this.f249685a;
            boolean r105 = r104.f249660f;
            if (r105 == true) goto L16;
            if (r104.f249659e == true) goto L16;
        L47:
            LynxScrollView r106 = this.f249685a;
            if (r106.f249661g == false) goto L54;
            if (r110 == 0) goto L51;
            int r107 = r106.f249673s;
            r106.V(r107, 0, r107 - r110, 0, GXViewKey.VIEW_TYPE_CONTAINER_SCROLL);
            return;
        L51:
            if (r111 == 0) goto L56;
            int r108 = r106.f249673s;
            r106.V(0, r108, 0, r108 - r111, GXViewKey.VIEW_TYPE_CONTAINER_SCROLL);
            return;
        L56:
            return;
        L54:
            return;
        L16:
            if (r105 == false) goto L32;
            if ((r103 & 2) == 0) goto L20;
            boolean r109 = true;
        L22:
            if ((r104.f249672r & 2) == 0) goto L24;
            boolean r112 = true;
        L26:
            if ((r109 & (!r112)) == false) goto L32;
            if (r110 == 0) goto L29;
            int r113 = r104.f249673s;
            r104.V(r113, 0, r113 - r110, 0, "scrolltolower");
        L46:
            this.f249685a.f249672r = r103;
            goto L47
        L29:
            if (r111 == 0) goto L46;
            int r114 = r104.f249673s;
            r104.V(0, r114, 0, r114 - r111, "scrolltolower");
            goto L46
        L24:
            r112 = false;
            goto L26
        L20:
            r109 = false;
        L32:
            if (r104.f249659e == false) goto L46;
            if ((r103 & 1) == 0) goto L36;
            boolean r115 = true;
        L38:
            if ((r104.f249672r & 1) == 0) goto L41;
            r102 = true;
        L41:
            if ((r115 & (!r102)) == false) goto L46;
            if (r110 == 0) goto L44;
            int r116 = r104.f249673s;
            r104.V(r116, 0, r116 - r110, 0, "scrolltoupper");
            goto L46
        L44:
            if (r111 == 0) goto L46;
            int r117 = r104.f249673s;
            r104.V(0, r117, 0, r117 - r111, "scrolltoupper");
            goto L46
        L36:
            r115 = false;
            goto L38
        L5:
            if (r101.f249660f == true) goto L10;
            if (r101.f249659e == true) goto L10;
            r103 = 0;
            goto L11
        }
    }

    public final class e extends LinearLayoutManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxScrollView f249686a;

        public final class a extends LinearSmoothScroller {
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public final int getHorizontalSnapPreference() {
                return -1;
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public final int getVerticalSnapPreference() {
                return -1;
            }

            public a(Context r100) {
                Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
                super(r100);
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public final float calculateSpeedPerPixel(DisplayMetrics r100) {
                if (r100 == null) goto L6;
                return 50.0f / r100.densityDpi;
            L6:
                return super.calculateSpeedPerPixel(r100);
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public final void onLayoutCompleted(RecyclerView.State r100) {
            super.onLayoutCompleted(r100);
            LynxScrollView r101 = this.f249686a;
            int r102 = r101.f249669o;
            if (r102 <= 0) goto L8;
            if (r101.T(r102, false) == false) goto L8;
            this.f249686a.f249669o = 0;
        L8:
            if (this.f249686a.f249670p <= 0) goto L14;
            final Ref.IntRef r103 = new Ref.IntRef();
            LynxScrollView r104 = this.f249686a;
            r103.element = r104.f249670p;
            r104.f249670p = 0;
            LynxScrollView$createView$1$3 r105 = r104.f249665k;
            if (r105 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            r105 = null;
        L12:
            final LynxScrollView r106 = this.f249686a;
            r105.post(new r(r106, r103));
            return;
        }

        public e(LynxScrollView r100, Context r101) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f249686a = r100;
            super(r101);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            Intrinsics.checkNotNullParameter(r101, "state");
            a r103 = new a(r100.getContext());
            r103.setTargetPosition(r102);
            startSmoothScroll(r103);
        }
    }

    public static final class f extends LinearSmoothScroller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f249687a;

        public f(LynxContext r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            this.f249687a = r101;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final int calculateDxToMakeVisible(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            RecyclerView.LayoutManager r102 = getLayoutManager();
            if (r102 != null) goto L5;
            return 0;
        L5:
            if (r102.canScrollHorizontally() == false) goto L14;
            ViewGroup.LayoutParams r103 = r100.getLayoutParams();
            if (r103 == null) goto L11;
            int r104 = r102.getDecoratedLeft(r100) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) r103)).leftMargin;
            return (r102.getPaddingLeft() - r104) + this.f249687a;
        L11:
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        L14:
            return 0;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final int calculateDyToMakeVisible(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            RecyclerView.LayoutManager r102 = getLayoutManager();
            if (r102 != null) goto L5;
            return 0;
        L5:
            if (r102.canScrollVertically() == false) goto L14;
            ViewGroup.LayoutParams r103 = r100.getLayoutParams();
            if (r103 == null) goto L11;
            int r104 = r102.getDecoratedTop(r100) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) r103)).topMargin;
            return (r102.getPaddingTop() - r104) + this.f249687a;
        L11:
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        L14:
            return 0;
        }
    }

    static {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean canHaveFlattenChild() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean needCustomLayout() {
        return true;
    }

    @LynxProp(name = "overflow-text")
    public final void overflowText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollTap(boolean r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollX() {
        LynxScrollView$createView$1$3 r100 = this.f249665k;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r100 = null;
    L6:
        return r100.computeHorizontalScrollOffset();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollY() {
        LynxScrollView$createView$1$3 r100 = this.f249665k;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r100 = null;
    L6:
        return r100.computeVerticalScrollOffset();
    }

    @Override // com.lynx.tasm.behavior.r0
    public final void onPatchFinish() {
        if (this.f249677w == true) goto L5;
        return;
    L5:
        ArrayList r100 = new ArrayList();
        r100.addAll(this.f249680z);
        CollectionsKt.sortWith(r100, new p());
        Iterator r101 = r100.iterator();
    L6:
        LynxScrollView$createView$1$3 r102 = null;
        if (r101.hasNext() == false) goto L17;
        Integer r103 = (Integer) r101.next();
        if (r103.intValue() < 0) goto L6;
        LLog.d(this.f249655a, "onPatchFinish: notifyItemRemoved = " + r103.intValue());
        LynxScrollView$createView$1$3 r104 = this.f249665k;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L14:
        RecyclerView.Adapter r105 = r102.getAdapter();
        if (r105 == null) goto L6;
        r105.notifyItemRemoved(r103.intValue());
        goto L6
    L13:
        r102 = r104;
        goto L14
    L17:
        ArrayList r106 = new ArrayList();
        r106.addAll(this.f249679y);
        CollectionsKt.sortWith(r106, new q());
        Iterator r107 = r106.iterator();
    L19:
        if (r107.hasNext() == false) goto L28;
        Integer r108 = (Integer) r107.next();
        if (r108.intValue() < 0) goto L19;
        LLog.d(this.f249655a, "onPatchFinish: notifyItemInserted = " + r108.intValue());
        LynxScrollView$createView$1$3 r109 = this.f249665k;
        if (r109 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r109 = null;
    L25:
        RecyclerView.Adapter r110 = r109.getAdapter();
        if (r110 == null) goto L19;
        r110.notifyItemInserted(r108.intValue());
        goto L19
    L28:
        this.f249678x.clear();
        this.f249678x.addAll(this.mChildren);
        this.f249679y.clear();
        this.f249680z.clear();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        if (this.f249677w == false) goto L6;
        this.f249678x.clear();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void measureChildren() {
        super.measureChildren();
        LynxBounceView r100 = this.f249666l;
        if (r100 == null) goto L5;
        r100.measure();
    L5:
        View r101 = ((BounceLayout) this.mView).getMBounceView();
        LinearLayoutManager r102 = null;
        if (r101 == null) goto L8;
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
    L9:
        if (r103 == null) goto L16;
        LynxBounceView r104 = this.f249666l;
        if (r104 == null) goto L14;
        Integer r105 = Integer.valueOf(r104.getWidth());
    L15:
        r103.width = r105.intValue();
        goto L16
    L14:
        r105 = null;
    L16:
        View r106 = ((BounceLayout) this.mView).getMBounceView();
        if (r106 == null) goto L19;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
    L20:
        if (r107 == null) goto L27;
        LynxBounceView r108 = this.f249666l;
        if (r108 == null) goto L25;
        Integer r109 = Integer.valueOf(r108.getHeight());
    L26:
        r107.height = r109.intValue();
        goto L27
    L25:
        r109 = null;
    L27:
        LynxBounceView r110 = this.f249666l;
        if (r110 == null) goto L30;
        r110.layout();
    L30:
        this.f249675u = getWidth();
        this.f249676v = getHeight();
        if (this.mChildren.isEmpty() == true) goto L48;
        LynxScrollView$createView$1$3 r111 = this.f249665k;
        if (r111 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r111 = null;
    L35:
        RecyclerView.LayoutManager r112 = r111.getLayoutManager();
        if ((r112 instanceof LinearLayoutManager) == false) goto L38;
        r102 = (LinearLayoutManager) r112;
    L38:
        Intrinsics.checkNotNull(r102);
        if (r102.canScrollHorizontally() == false) goto L45;
        if (this.mLynxDirection != 2) goto L43;
        int r113 = getWidth();
        List<LynxBaseUI> r114 = this.mChildren;
        int r115 = r113 - ((LynxBaseUI) ListProtector.get(r114, r114.size() - 1)).getLeft();
        List<LynxBaseUI> r116 = this.mChildren;
        this.f249675u = (r115 + ((LynxBaseUI) ListProtector.get(r116, r116.size() - 1)).getMarginLeft()) + this.mPaddingLeft;
        return;
    L43:
        List<LynxBaseUI> r117 = this.mChildren;
        int r118 = ((LynxBaseUI) ListProtector.get(r117, r117.size() - 1)).getLeft();
        List<LynxBaseUI> r119 = this.mChildren;
        int r120 = r118 + ((LynxBaseUI) ListProtector.get(r119, r119.size() - 1)).getWidth();
        List<LynxBaseUI> r121 = this.mChildren;
        this.f249675u = (r120 + ((LynxBaseUI) ListProtector.get(r121, r121.size() - 1)).getMarginRight()) + this.mPaddingLeft;
        return;
    L45:
        if (r102.canScrollVertically() == false) goto L51;
        List<LynxBaseUI> r122 = this.mChildren;
        int r123 = ((LynxBaseUI) ListProtector.get(r122, r122.size() - 1)).getTop();
        List<LynxBaseUI> r124 = this.mChildren;
        int r125 = r123 + ((LynxBaseUI) ListProtector.get(r124, r124.size() - 1)).getHeight();
        List<LynxBaseUI> r126 = this.mChildren;
        this.f249676v = (r125 + ((LynxBaseUI) ListProtector.get(r126, r126.size() - 1)).getMarginBottom()) + this.mPaddingBottom;
        return;
    L51:
        return;
    L48:
        return;
    L19:
        r107 = null;
        goto L20
    L8:
        r103 = null;
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        int r100 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r101 = this.mPaddingRight + this.mBorderRightWidth;
        int r102 = this.mPaddingTop + this.mBorderTopWidth;
        int r103 = this.mPaddingBottom + this.mBorderBottomWidth;
        LynxScrollView$createView$1$3 r104 = this.f249665k;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r104 = null;
    L5:
        r104.setPadding(r100, r102, r101, r103);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReload() {
        super.onNodeReload();
        U(0);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isCustomHittest() {
        return this.f249664j;
    }

    public LynxScrollView(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static final /* synthetic */ List P(LynxScrollView r100) {
        return r100.mChildren;
    }

    public static final /* synthetic */ View Q(LynxScrollView r100) {
        return r100.mView;
    }

    public static final int S(LynxScrollView r100) {
        LynxScrollView$createView$1$3 r101 = r100.f249665k;
        LinearLayoutManager r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r101 = null;
    L5:
        RecyclerView.LayoutManager r103 = r101.getLayoutManager();
        if ((r103 instanceof LinearLayoutManager) == false) goto L8;
        r102 = (LinearLayoutManager) r103;
    L8:
        int r104 = 0;
        if (r102 != null) goto L12;
    L58:
        return r104;
    L12:
        if (r100.mChildren.size() == 0) goto L58;
        int r105 = r102.findFirstVisibleItemPosition();
        if (r105 < 0) goto L58;
        if (r105 >= r100.mChildren.size()) goto L58;
        View r106 = r102.findViewByPosition(r105);
        if (r102.canScrollHorizontally() == false) goto L46;
        if (r100.mLynxDirection != 2) goto L34;
        int r107 = r100.getWidth();
        List<LynxBaseUI> r108 = r100.mChildren;
        int r109 = r107 - ((LynxBaseUI) ListProtector.get(r108, r108.size() - 1)).getLeft();
        List<LynxBaseUI> r110 = r100.mChildren;
        int r111 = (r109 + ((LynxBaseUI) ListProtector.get(r110, r110.size() - 1)).getMarginLeft()) + r100.mPaddingLeft;
        int r112 = (((((LynxBaseUI) ListProtector.get(r100.mChildren, 0)).getLeft() - ((LynxBaseUI) ListProtector.get(r100.mChildren, r105)).getLeft()) + ((LynxBaseUI) ListProtector.get(r100.mChildren, 0)).getWidth()) + ((LynxBaseUI) ListProtector.get(r100.mChildren, 0)).getMarginRight()) + r100.mPaddingRight;
        if (r106 == null) goto L26;
        int r113 = r100.getWidth() - r106.getLeft();
    L27:
        int r114 = r112 - r113;
        if (((r111 - r100.getWidth()) - r114) > r100.f249656b) goto L31;
        r104 = 2;
    L31:
        if (r114 > r100.f249657c) goto L33;
        r104 = r104 | 1;
    L33:
        r100.f249673s = r114;
        goto L58
    L26:
        r113 = 0;
        goto L27
    L34:
        List<LynxBaseUI> r115 = r100.mChildren;
        int r116 = ((LynxBaseUI) ListProtector.get(r115, r115.size() - 1)).getLeft();
        List<LynxBaseUI> r117 = r100.mChildren;
        int r118 = r116 + ((LynxBaseUI) ListProtector.get(r117, r117.size() - 1)).getWidth();
        List<LynxBaseUI> r119 = r100.mChildren;
        int r120 = (r118 + ((LynxBaseUI) ListProtector.get(r119, r119.size() - 1)).getMarginRight()) + r100.mPaddingLeft;
        int r121 = ((LynxBaseUI) ListProtector.get(r100.mChildren, r105)).getLeft() + 0;
        if (r106 == null) goto L37;
        int r122 = r106.getLeft();
    L38:
        int r123 = r121 - r122;
        int r124 = (r120 - r123) - r100.getWidth();
        if (r123 > r100.f249657c) goto L42;
        r104 = 1;
    L42:
        if (r124 > r100.f249656b) goto L44;
        r104 = r104 | 2;
    L44:
        r100.f249673s = r123;
        goto L58
    L37:
        r122 = 0;
        goto L38
    L46:
        if (r102.canScrollVertically() == false) goto L58;
        List<LynxBaseUI> r125 = r100.mChildren;
        int r126 = ((LynxBaseUI) ListProtector.get(r125, r125.size() - 1)).getTop();
        List<LynxBaseUI> r127 = r100.mChildren;
        int r128 = r126 + ((LynxBaseUI) ListProtector.get(r127, r127.size() - 1)).getHeight();
        List<LynxBaseUI> r129 = r100.mChildren;
        int r130 = (r128 + ((LynxBaseUI) ListProtector.get(r129, r129.size() - 1)).getMarginBottom()) + r100.mPaddingBottom;
        int r131 = ((LynxBaseUI) ListProtector.get(r100.mChildren, r105)).getTop();
        if (r106 == null) goto L50;
        int r132 = r106.getTop();
    L51:
        int r133 = r131 - r132;
        int r134 = (r130 - r100.getHeight()) - r133;
        if (r133 > r100.f249657c) goto L55;
        r104 = 1;
    L55:
        if (r134 > r100.f249656b) goto L57;
        r104 = r104 | 2;
    L57:
        r100.f249673s = r133;
        goto L58
    L50:
        r132 = 0;
        goto L51
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void N(boolean r100) {
        LinearLayoutManager r101 = null;
        if (r100 == false) goto L13;
        ((BounceLayout) this.mView).setMScrollDirection(BounceLayout.ScrollDirection.HORIZONTAL_RIGHT);
        LynxScrollView$createView$1$3 r102 = this.f249665k;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r102 = null;
    L7:
        RecyclerView.LayoutManager r103 = r102.getLayoutManager();
        if ((r103 instanceof LinearLayoutManager) == false) goto L10;
        r101 = (LinearLayoutManager) r103;
    L10:
        if (r101 == null) goto L24;
        r101.setOrientation(0);
        return;
    L24:
        return;
    L13:
        ((BounceLayout) this.mView).setMScrollDirection(BounceLayout.ScrollDirection.VERTICAL_BOTTOM);
        LynxScrollView$createView$1$3 r104 = this.f249665k;
        if (r104 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r104 = null;
    L16:
        RecyclerView.LayoutManager r105 = r104.getLayoutManager();
        if ((r105 instanceof LinearLayoutManager) == false) goto L19;
        r101 = (LinearLayoutManager) r105;
    L19:
        if (r101 == null) goto L25;
        r101.setOrientation(1);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void O(boolean r100) {
        LinearLayoutManager r101 = null;
        if (r100 == true) goto L13;
        ((BounceLayout) this.mView).setMScrollDirection(BounceLayout.ScrollDirection.HORIZONTAL_RIGHT);
        LynxScrollView$createView$1$3 r102 = this.f249665k;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r102 = null;
    L7:
        RecyclerView.LayoutManager r103 = r102.getLayoutManager();
        if ((r103 instanceof LinearLayoutManager) == false) goto L10;
        r101 = (LinearLayoutManager) r103;
    L10:
        if (r101 == null) goto L24;
        r101.setOrientation(0);
        return;
    L24:
        return;
    L13:
        ((BounceLayout) this.mView).setMScrollDirection(BounceLayout.ScrollDirection.VERTICAL_BOTTOM);
        LynxScrollView$createView$1$3 r104 = this.f249665k;
        if (r104 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r104 = null;
    L16:
        RecyclerView.LayoutManager r105 = r104.getLayoutManager();
        if ((r105 instanceof LinearLayoutManager) == false) goto L19;
        r101 = (LinearLayoutManager) r105;
    L19:
        if (r101 == null) goto L25;
        r101.setOrientation(1);
        return;
    }

    public final boolean U(int r100) {
        LynxScrollView$createView$1$3 r101 = this.f249665k;
        LynxScrollView$createView$1$3 r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r101 = null;
    L5:
        int r103 = r101.computeHorizontalScrollRange();
        LynxScrollView$createView$1$3 r104 = this.f249665k;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r104 = null;
    L8:
        int r105 = r104.computeVerticalScrollRange();
        if (r103 <= 0) goto L19;
        LynxScrollView$createView$1$3 r106 = this.f249665k;
        if (r106 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r106 = null;
    L13:
        int r107 = r100 - r106.computeHorizontalScrollOffset();
        LynxScrollView$createView$1$3 r108 = this.f249665k;
        if (r108 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L17:
        r102.scrollBy(r107, 0);
        return true;
    L16:
        r102 = r108;
        goto L17
    L19:
        if (r105 <= 0) goto L29;
        LynxScrollView$createView$1$3 r109 = this.f249665k;
        if (r109 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r109 = null;
    L23:
        int r110 = r100 - r109.computeVerticalScrollOffset();
        LynxScrollView$createView$1$3 r111 = this.f249665k;
        if (r111 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L27:
        r102.scrollBy(0, r110);
        return true;
    L26:
        r102 = r111;
        goto L27
    L29:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        BounceLayout r101 = new BounceLayout(r100);
        r101.setOnScrollToEndListener(new s(this));
        r101.setOnBounceScrollListener(new t(this));
        r101.setMScrollDirection(BounceLayout.ScrollDirection.VERTICAL_BOTTOM);
        LynxScrollView$createView$1$3 r102 = new LynxScrollView$createView$1$3(r100, this);
        r102.setAdapter(new b(this));
        r102.setLayoutDirection(0);
        e r103 = new e(this, r100);
        r103.setOrientation(1);
        r102.setLayoutManager(r103);
        r102.addOnScrollListener(new d(this));
        r102.setClipToPadding(false);
        this.f249665k = r102;
        r101.setMContentView(r102);
        LynxScrollView$createView$1$3 r104 = this.f249665k;
        LynxScrollView$createView$1$3 r105 = null;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r104 = null;
    L5:
        r104.setClipChildren(false);
        LynxScrollView$createView$1$3 r106 = this.f249665k;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L9:
        RecyclerItemStatusHelper r107 = new RecyclerItemStatusHelper();
        this.f249668n = r107;
        Intrinsics.checkNotNullParameter(r105, "recyclerView");
        r105.addOnScrollListener(r107.f249694d);
        Intrinsics.checkNotNullParameter(r105, "recyclerView");
        r107.f249693c = new RecyclerItemStatusHelper.b(r105, r107);
        ViewTreeObserver r108 = r105.getViewTreeObserver();
        if (r108 == null) goto L12;
        r108.addOnScrollChangedListener(r107.f249693c);
    L12:
        r101.setClipChildren(false);
        return r101;
    L8:
        r105 = r106;
        goto L9
    }

    @LynxProp(defaultBoolean = true, name = "enable-load-more")
    public final void enableLoadMore(boolean r100) {
        this.f249674t = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeChild(LynxBaseUI r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        LLog.d(this.f249655a, "removeChild " + r100 + " with unifiedNotifyItemChanged = " + this.f249677w);
        if (this.f249677w == false) goto L8;
        int r101 = this.f249678x.indexOf(r100);
        if (r101 < 0) goto L7;
        this.f249680z.add(Integer.valueOf(r101));
    L7:
        this.mChildren.remove(r100);
        return;
    L8:
        int r102 = this.mChildren.indexOf(r100);
        if (this.mChildren.remove(r100) == false) goto L18;
        LynxScrollView$createView$1$3 r103 = this.f249665k;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r103 = null;
    L13:
        RecyclerView.Adapter r104 = r103.getAdapter();
        if (r104 == null) goto L19;
        r104.notifyItemRemoved(r102);
        return;
    L19:
        return;
    }

    @LynxProp(name = "scroll-to-id")
    public final void scrollToId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Iterator<T> r101 = this.mChildren.iterator();
    L3:
        LynxScrollView$createView$1$3 r102 = null;
        if (r101.hasNext() == false) goto L8;
        Object r103 = r101.next();
        if (Intrinsics.areEqual(((LynxBaseUI) r103).getName(), r100) == false) goto L3;
    L9:
        LynxBaseUI r104 = (LynxBaseUI) r103;
        if (r104 == null) goto L32;
        int r105 = this.mChildren.indexOf(r104);
        LynxScrollView$createView$1$3 r106 = this.f249665k;
        if (r106 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r106 = null;
    L15:
        if (r106.getAdapter() != null) goto L17;
        return;
    L17:
        LynxScrollView$createView$1$3 r107 = this.f249665k;
        if (r107 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r107 = null;
    L20:
        RecyclerView.Adapter r108 = r107.getAdapter();
        Intrinsics.checkNotNull(r108);
        if (r108.getItemCount() > r105) goto L23;
        return;
    L23:
        LynxScrollView$createView$1$3 r109 = this.f249665k;
        if (r109 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L27:
        r102.smoothScrollToPosition(r105);
        return;
    L26:
        r102 = r109;
        goto L27
    L32:
        return;
    L8:
        r103 = null;
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void scrollToIndex(int r100) {
        if (T(r100, false) == true) goto L5;
        this.f249669o = r100;
        return;
    L5:
        this.f249669o = 0;
    }

    @LynxProp(defaultBoolean = false, name = "bounce")
    public final void setBounces(boolean r100) {
        ((BounceLayout) this.mView).setMEnableBounce(r100);
    }

    @LynxProp(name = "enable-custom-hittest")
    public final void setEnableCustomHittest(boolean r100) {
        this.f249664j = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, ? extends EventsListener> r100) {
        super.setEvents(r100);
        Objects.toString(r100);
        if (r100 == null) goto L6;
        this.f249660f = r100.containsKey("scrolltolower");
        this.f249659e = r100.containsKey("scrolltoupper");
        this.f249661g = r100.containsKey(GXViewKey.VIEW_TYPE_CONTAINER_SCROLL);
        this.f249658d = r100.containsKey("scrolltobounce");
        this.f249662h = r100.containsKey("dragend");
        return;
    }

    @LynxProp(name = "layout-direction")
    public final void setLayoutDirection(String r100) {
        Intrinsics.checkNotNullParameter(r100, "direction");
        LynxScrollView$createView$1$3 r101 = null;
        if (Intrinsics.areEqual(r100, "ltr") == false) goto L10;
        LynxScrollView$createView$1$3 r102 = this.f249665k;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L8:
        r101.setLayoutDirection(0);
        return;
    L7:
        r101 = r102;
        goto L8
    L10:
        if (Intrinsics.areEqual(r100, "rtl") == false) goto L18;
        LynxScrollView$createView$1$3 r103 = this.f249665k;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L15:
        r101.setLayoutDirection(1);
        return;
    L14:
        r101 = r103;
        goto L15
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setLowerThreshole(int r100) {
        if (r100 >= 0) goto L4;
        r100 = 0;
    L4:
        this.f249656b = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setLynxDirection(int r100) {
        this.mLynxDirection = r100;
        LynxScrollView$createView$1$3 r101 = null;
        if (r100 != 2) goto L9;
        LynxScrollView$createView$1$3 r102 = this.f249665k;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L8:
        r101.setLayoutDirection(1);
        return;
    L7:
        r101 = r102;
        goto L8
    L9:
        LynxScrollView$createView$1$3 r103 = this.f249665k;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L13:
        r101.setLayoutDirection(0);
        return;
    L12:
        r101 = r103;
        goto L13
    }

    @LynxProp(defaultBoolean = false, name = "page-enable")
    public final void setPageEnable(boolean r100) {
        this.f249663i = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollBarEnable(boolean r100) {
        LynxScrollView$createView$1$3 r101 = null;
        if (((BounceLayout) this.mView).getMScrollDirection() != BounceLayout.ScrollDirection.VERTICAL_BOTTOM) goto L5;
    L17:
        LynxScrollView$createView$1$3 r102 = this.f249665k;
        if (r102 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L21:
        r101.setVerticalScrollBarEnabled(r100);
        return;
    L20:
        r101 = r102;
        goto L21
    L5:
        if (((BounceLayout) this.mView).getMScrollDirection() == BounceLayout.ScrollDirection.VERTICAL_TOP) goto L17;
        if (((BounceLayout) this.mView).getMScrollDirection() != BounceLayout.ScrollDirection.HORIZONTAL_LEFT) goto L10;
    L11:
        LynxScrollView$createView$1$3 r103 = this.f249665k;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L15:
        r101.setHorizontalScrollBarEnabled(r100);
        return;
    L14:
        r101 = r103;
        goto L15
    L10:
        if (((BounceLayout) this.mView).getMScrollDirection() == BounceLayout.ScrollDirection.HORIZONTAL_RIGHT) goto L11;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollLeft(int r100) {
        this.f249670p = 0;
        if (U(r100) == true) goto L6;
        this.f249670p = r100;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollTop(int r100) {
        this.f249670p = 0;
        if (U(r100) == true) goto L6;
        this.f249670p = r100;
        return;
    }

    @LynxProp(defaultBoolean = false, name = "android-unified-notify-item-changed")
    public final void setUnifiedNotifyItemChanged(boolean r100) {
        this.f249677w = r100;
        if (r100 == false) goto L9;
        LynxScrollView$createView$1$3 r101 = this.f249665k;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r101 = null;
    L7:
        r101.setItemAnimator(null);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setUpperThreshole(int r100) {
        if (r100 >= 0) goto L4;
        r100 = 0;
    L4:
        this.f249657c = r100;
    }

    public LynxScrollView(LynxContext r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f249655a = "LynxScrollView";
        this.f249672r = 1;
        this.f249674t = true;
        this.f249678x = new ArrayList();
        this.f249679y = new HashSet();
        this.f249680z = new HashSet();
    }

    public final boolean T(int r100, boolean r101) {
        if (r100 >= 0) goto L5;
        return false;
    L5:
        LynxScrollView$createView$1$3 r102 = this.f249665k;
        LinearLayoutManager r103 = null;
        LynxScrollView$createView$1$3 r104 = null;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r102 = null;
    L9:
        if (r102.getAdapter() != null) goto L11;
        return false;
    L11:
        LynxScrollView$createView$1$3 r105 = this.f249665k;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r105 = null;
    L14:
        RecyclerView.Adapter r106 = r105.getAdapter();
        Intrinsics.checkNotNull(r106);
        if (r106.getItemCount() > r100) goto L17;
        return false;
    L17:
        if (r101 == false) goto L23;
        LynxScrollView$createView$1$3 r107 = this.f249665k;
        if (r107 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L22:
        r104.smoothScrollToPosition(r100);
        return true;
    L21:
        r104 = r107;
        goto L22
    L23:
        LynxScrollView$createView$1$3 r108 = this.f249665k;
        if (r108 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r108 = null;
    L26:
        RecyclerView.LayoutManager r109 = r108.getLayoutManager();
        if ((r109 instanceof LinearLayoutManager) == false) goto L29;
        r103 = (LinearLayoutManager) r109;
    L29:
        if (r103 == null) goto L34;
        r103.scrollToPositionWithOffset(r100, 0);
        return true;
    L34:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.view.View] */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        LLog.d(this.f249655a, "insertChild " + r100 + " at index = " + r101 + " withunifiedNotifyItemChanged = " + this.f249677w);
        if ((r100 instanceof LynxBounceView) == false) goto L24;
        LynxBounceView r102 = (LynxBounceView) r100;
        String r103 = r102.f249603a;
        switch(r103.hashCode()) {
            case -1383228885: goto L19;
            case 115029: goto L15;
            case 3317767: goto L11;
            case 108511772: goto L8;
            default: goto L22;
        };
    L22:
        this.f249666l = r102;
        ((BounceLayout) this.mView).setMBounceView(r102.getView());
    L34:
        r100.setParent(this);
        return;
    L8:
        if (r103.equals("right") == false) goto L22;
        ((BounceLayout) this.mView).setMScrollDirection(BounceLayout.ScrollDirection.HORIZONTAL_RIGHT);
        goto L22
    L11:
        if (r103.equals("left") == false) goto L22;
        ((BounceLayout) this.mView).setMScrollDirection(BounceLayout.ScrollDirection.HORIZONTAL_LEFT);
        goto L22
    L15:
        if (r103.equals("top") == false) goto L22;
        ((BounceLayout) this.mView).setMScrollDirection(BounceLayout.ScrollDirection.VERTICAL_TOP);
        goto L22
    L19:
        if (r103.equals("bottom") == false) goto L22;
        ((BounceLayout) this.mView).setMScrollDirection(BounceLayout.ScrollDirection.VERTICAL_BOTTOM);
        goto L22
    L24:
        if ((r100 instanceof LynxUI) == false) goto L34;
        ListProtector.add(this.mChildren, r101, r100);
        if (this.f249677w == false) goto L28;
        this.f249679y.add(Integer.valueOf(r101));
        goto L34
    L28:
        LynxScrollView$createView$1$3 r104 = this.f249665k;
        if (r104 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r104 = null;
    L31:
        RecyclerView.Adapter r105 = r104.getAdapter();
        if (r105 == null) goto L34;
        r105.notifyItemInserted(r101);
        goto L34
    }

    @LynxUIMethod
    public final void scrollToIndex(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "param");
        Intrinsics.checkNotNullParameter(r101, "callback");
        JavaOnlyMap r102 = new JavaOnlyMap();
    L8:
        th = move-exception;
        r102.put("error", th.getMessage());
        r101.invoke(new Object[]{4, r102});
        return;
    L4:
        if (T(r100.getInt("index", 0), r100.getBoolean("smooth", false)) == false) goto L6;
        r101.invoke(new Object[]{0, r102});     // Catch: Throwable -> L8
    L11:
        return;
    L6:
        r101.invoke(new Object[]{1, r102});     // Catch: Throwable -> L8
        goto L11
    }

    public static final void R(LynxScrollView r100, View r101, int r102) {
        r100.getClass();
        RecyclerView.LayoutParams r103 = new RecyclerView.LayoutParams(((LynxBaseUI) ListProtector.get(r100.mChildren, r102)).getWidth(), ((LynxBaseUI) ListProtector.get(r100.mChildren, r102)).getHeight());
        ((ViewGroup.MarginLayoutParams) r103).leftMargin = ((LynxBaseUI) ListProtector.get(r100.mChildren, r102)).getMarginLeft();
        ((ViewGroup.MarginLayoutParams) r103).rightMargin = ((LynxBaseUI) ListProtector.get(r100.mChildren, r102)).getMarginRight();
        ((ViewGroup.MarginLayoutParams) r103).topMargin = ((LynxBaseUI) ListProtector.get(r100.mChildren, r102)).getMarginTop();
        ((ViewGroup.MarginLayoutParams) r103).bottomMargin = ((LynxBaseUI) ListProtector.get(r100.mChildren, r102)).getMarginBottom();
        r101.setLayoutParams(r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void M(LynxBaseUI r110, boolean r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r112, "block");
        Intrinsics.checkNotNullParameter(r113, BrowserDependency.UrlClickType.INLINE);
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r112, "block");
        Intrinsics.checkNotNullParameter(r113, BrowserDependency.UrlClickType.INLINE);
        LynxBaseUI r100 = r110;
    L4:
        if (r100.getParent() == this) goto L10;
        com.lynx.tasm.behavior.ui.k r101 = r100.getParent();
        if (r101 == null) goto L9;
        r100 = (LynxBaseUI) r101;
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.behavior.ui.LynxBaseUI");
    L10:
        int r102 = this.mChildren.indexOf(r100);
        LynxScrollView$createView$1$3 r103 = this.f249665k;
        Integer r104 = null;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r103 = null;
    L13:
        RecyclerView.LayoutManager r105 = r103.getLayoutManager();
        if ((r105 instanceof LinearLayoutManager) == false) goto L16;
        LinearLayoutManager r106 = (LinearLayoutManager) r105;
    L17:
        if (r106 == null) goto L19;
        r104 = Integer.valueOf(r106.getOrientation());
    L19:
        int r107 = 0;
        if (r104 == null) goto L40;
        if (r104.intValue() != 1) goto L40;
        if (Intrinsics.areEqual("center", r112) == false) goto L28;
        int r114 = (((BounceLayout) getView()).getHeight() - r110.getHeight()) / 2;
    L30:
        int r115 = r114 + 0;
    L32:
        if (r110 == r100) goto L38;
        r115 = r115 - r110.getTop();
        com.lynx.tasm.behavior.ui.k r116 = r110.getParent();
        if (r116 == null) goto L37;
        r110 = (LynxBaseUI) r116;
        goto L32
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.behavior.ui.LynxBaseUI");
    L38:
        int r117 = r115 - 0;
    L53:
        if (r111 == true) goto L56;
        if (r106 == null) goto L68;
        r106.scrollToPositionWithOffset(r102, r117);
        return;
    L68:
        return;
    L56:
        f r118 = new f(this.mContext, r117);
        r118.setTargetPosition(r102);
        if (r106 == null) goto L70;
        r106.startSmoothScroll(r118);
        return;
    L70:
        return;
    L28:
        if (Intrinsics.areEqual("end", r112) == false) goto L31;
        r114 = ((BounceLayout) getView()).getHeight() - r110.getHeight();
        goto L30
    L31:
        r115 = 0;
    L40:
        if (Intrinsics.areEqual("center", r113) == false) goto L43;
        int r119 = (((BounceLayout) getView()).getWidth() - r110.getWidth()) / 2;
    L45:
        r107 = 0 + r119;
    L46:
        if (r110 == r100) goto L52;
        r107 = r107 - r110.getLeft();
        com.lynx.tasm.behavior.ui.k r120 = r110.getParent();
        if (r120 == null) goto L51;
        r110 = (LynxBaseUI) r120;
        goto L46
    L51:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.behavior.ui.LynxBaseUI");
    L52:
        r117 = r107;
        goto L53
    L43:
        if (Intrinsics.areEqual("end", r113) == false) goto L46;
        r119 = ((BounceLayout) getView()).getWidth() - r110.getWidth();
        goto L45
    L16:
        r106 = null;
        goto L17
    }

    public final void V(int r110, int r111, int r112, int r113, String r114) {
        Intrinsics.checkNotNullParameter(r114, "type");
        m7a.e r100 = new m7a.e(getSign(), r114);
        r100.d(r110, r111, this.f249676v, this.f249675u, r110 - r112, r111 - r113);
        LynxContext r115 = getLynxContext();
        if (r115 == null) goto L8;
        EventEmitter r116 = r115.getEventEmitter();
        if (r116 == null) goto L9;
        r116.sendCustomEvent(r100);
        return;
    L9:
        return;
    }
}
