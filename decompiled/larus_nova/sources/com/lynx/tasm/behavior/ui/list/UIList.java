package com.lynx.tasm.behavior.ui.list;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.camera.video.AudioStats;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.accessibility.LynxNodeProvider;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.BorderRadius;
import com.lynx.tasm.behavior.ui.utils.h;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.utils.DeviceUtils;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.i;
import com.lynx.tasm.utils.n;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import e7a.g;
import e7a.j;
import e7a.k;
import e7a.l;
import e7a.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public class UIList extends AbsLynxList<RecyclerView> {
    public static final /* synthetic */ int L0 = 0;
    public ReadableMap A;
    public final ArrayList<String> B;
    public final HashMap<String, ArrayList<LynxNodeProvider.b>> C;
    public ReadableMap D;
    public boolean E;
    public boolean F;
    public boolean G;
    public int H;
    public boolean H0;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f382631J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public com.lynx.tasm.behavior.ui.list.a P;
    public int Q;
    public boolean R;
    public GapItemDecoration S;
    public int T;
    public float U;
    public m V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public UIListAdapter f382632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f382633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f382634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f382635f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f382636g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f382637h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ListEventManager f382638i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.lynx.tasm.behavior.ui.list.b f382639j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f382640k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public l f382641k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f382642l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PagerSnapHelper f382643m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public FactoredPagerSnapHelper f382644n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f382645o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f382646p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f382647p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ListStickyManager.b f382648q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ListStickyManager f382649r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public e7a.a f382650s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f382651t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f382652u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f382653v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f382654w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f382655x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Map<String, Object> f382656y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Map<String, HashSet<String>> f382657z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f382658a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f382658a.requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(View r100) {
            this.f382658a = r100;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UIList f382659a;

        public b(UIList r100) {
            this.f382659a = r100;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UIList f382660a;

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            ListStickyManager r100 = this.f382660a.f382649r;
            int r101 = 0;
            if (r100 != null) goto L5;
        L35:
            UIList r102 = this.f382660a;
            if (r102.f382654w == false) goto L139;
            ListEventManager r103 = r102.f382638i;
            UIListAdapter r104 = r102.f382632c;
            RecyclerView.LayoutManager r105 = ((RecyclerView) r104.f382674c.getView()).getLayoutManager();
            if (r104.B.isEmpty() == false) goto L41;
        L108:
            r103.f382595l = r101;
            ListEventManager r106 = this.f382660a.f382638i;
            int r107 = r106.f382595l;
            r106.n(GXViewKey.VIEW_TYPE_CONTAINER_SCROLL, 1, r107, r107, 0, 0);
            return;
        L41:
            if ((r105 instanceof ListLayoutManager.ListLinearLayoutManager) == false) goto L55;
            ListLayoutManager.ListLinearLayoutManager r108 = (ListLayoutManager.ListLinearLayoutManager) r105;
            int r109 = r108.findFirstVisibleItemPosition();
            View r110 = r108.findViewByPosition(r109);
            if (r110 == null) goto L45;
            int r111 = -((int) r110.getY());
        L46:
            HashMap r112 = (HashMap) ListProtector.get(r104.B, 0);
            int r113 = 0;
        L47:
            if (r113 >= r109) goto L53;
            if (r112.get(Integer.valueOf(r113)) != null) goto L51;
            int r114 = 0;
        L52:
            r111 = r111 + r114;
            r113 = r113 + 1;
            goto L47
        L51:
            r114 = ((Integer) r112.get(Integer.valueOf(r113))).intValue();
            goto L52
        L53:
            r101 = r111;
            goto L108
        L45:
            r111 = 0;
            goto L46
        L55:
            if ((r105 instanceof ListLayoutManager.ListGridLayoutManager) == true) goto L110;
            int r115 = r104.f382674c.f382633d;
            int[] r116 = new int[r115];
            View[] r117 = new View[r115];
            ((ListLayoutManager.b) r105).findFirstVisibleItemPositions(r116);
            int r118 = 0;
        L75:
            if (r118 >= r115) goto L90;
            int r119 = 0;
        L78:
            if (r119 >= ((RecyclerView) r104.f382674c.getView()).getChildCount()) goto L89;
            View r120 = ((RecyclerView) r104.f382674c.getView()).getChildAt(r119);
            if (r120 == null) goto L88;
            ListViewHolder r121 = (ListViewHolder) ((RecyclerView) r104.f382674c.getView()).getChildViewHolder(r120);
            if (r121 == null) goto L88;
            if (r116[r118] != r121.getAdapterPosition()) goto L88;
            r117[r118] = r120;
        L88:
            r119 = r119 + 1;
        L89:
            r118 = r118 + 1;
            goto L75
        L90:
            int r122 = 0;
            int r123 = 0;
        L91:
            if (r122 >= r115) goto L107;
            if (r122 >= r104.B.size()) goto L107;
            View r124 = r117[r122];
            if (r124 == null) goto L106;
            int r125 = -((int) r124.getY());
            HashMap r126 = (HashMap) ListProtector.get(r104.B, r122);
            int r127 = 0;
        L99:
            if (r127 >= r116[r122]) goto L105;
            if (r126.get(Integer.valueOf(r127)) != null) goto L103;
            int r128 = 0;
        L104:
            r125 = r125 + r128;
            r127 = r127 + 1;
            goto L99
        L103:
            r128 = ((Integer) r126.get(Integer.valueOf(r127))).intValue();
            goto L104
        L105:
            r123 = Math.max(r123, r125);
        L106:
            r122 = r122 + 1;
        L107:
            r101 = r123;
            goto L108
        L110:
            ListLayoutManager.ListGridLayoutManager r129 = (ListLayoutManager.ListGridLayoutManager) r105;     // Catch: Exception -> L72
            int r130 = 0;
            int r131 = 0;
        L57:
            if (r130 >= r104.B.size()) goto L71;
            View r132 = r129.getChildAt(r130);     // Catch: Exception -> L72
            if (r132 == null) goto L70;
            int r133 = r129.getPosition(r132);     // Catch: Exception -> L72
            int r134 = -((int) r132.getY());
            HashMap r135 = (HashMap) ListProtector.get(r104.B, r130);     // Catch: Exception -> L72
            int r136 = 0;
        L63:
            if (r136 >= r133) goto L69;
            if (r135.get(Integer.valueOf(r136)) != null) goto L67;
            int r137 = 0;
        L68:
            r134 = r134 + r137;     // Catch: Exception -> L72
            r136 = r136 + 1;     // Catch: Exception -> L72
            goto L63
        L67:
            r137 = ((Integer) r135.get(Integer.valueOf(r136))).intValue();     // Catch: Exception -> L72
            goto L68
        L69:
            r131 = Math.max(r131, r134);     // Catch: Exception -> L72
        L70:
            r130 = r130 + 1;
            goto L57
        L71:
            r101 = r131;
        L72:
            e = move-exception;
            e.printStackTrace();
            goto L108
        L139:
            return;
        L5:
            if (r100.f382614h == true) goto L35;
            UIListAdapter r138 = r100.f382607a.f382632c;
            int r139 = r100.f382613g.f382619b;
            if (r139 != (-1)) goto L10;
        L13:
            int r140 = r100.f382612f.f382619b;
            if (r140 == (-1)) goto L35;
            if (r138.f382681j.contains(Integer.valueOf(r140)) == false) goto L34;
            RecyclerView r141 = (RecyclerView) r100.f382607a.getView();
            int r142 = Integer.MAX_VALUE;
            int r143 = Integer.MIN_VALUE;
            int r144 = 0;
        L19:
            if (r144 >= r141.getChildCount()) goto L31;
            View r145 = r141.getChildAt(r144);
            if (r145.getTop() > r100.f382610d) goto L26;
            if (r145.getBottom() <= r100.f382610d) goto L26;
            r142 = ((ListViewHolder) r141.getChildViewHolder(r145)).getAdapterPosition();
        L26:
            if (r145.getTop() >= (r141.getHeight() - r100.f382610d)) goto L30;
            if (r145.getBottom() < (r141.getHeight() - r100.f382610d)) goto L30;
            r143 = ((ListViewHolder) r141.getChildViewHolder(r145)).getAdapterPosition();
        L30:
            r144 = r144 + 1;
            goto L19
        L31:
            int r146 = r138.D2(r142);
            r138.C2(r143);
            ListStickyManager.c r147 = r100.f382612f;
            if (r146 == r147.f382619b) goto L35;
            r100.l(r147, true, false);
            r100.q((RecyclerView) r100.f382607a.getView(), 0);
            goto L35
        L34:
            r100.l(r100.f382612f, true, false);
            goto L35
        L10:
            if (r138.f382682k.contains(Integer.valueOf(r139)) == false) goto L12;
            r100.k(r100.f382613g);
            goto L13
        L12:
            r100.l(r100.f382613g, false, false);
            r100.q((RecyclerView) r100.f382607a.getView(), 0);
            goto L13
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(UIList r100) {
            this.f382660a = r100;
        }
    }

    public static class d extends RecyclerView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<LynxContext> f382661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<UIList> f382662b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f382663c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f382664d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f382665e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final g f382666f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Boolean f382667g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Boolean f382668h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f382669i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f382670j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f382671k;

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public final void onAttachedToWindow() {
            LLog.i("UIList", "PrivateRecyclerView onAttachedToWindow");
            super.onAttachedToWindow();
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public final void onDetachedFromWindow() {
            LLog.i("UIList", "PrivateRecyclerView onDetachedFromWindow");
            super.onDetachedFromWindow();
        }

        @Override // android.view.View
        public final void computeScroll() {
            super.computeScroll();
            UIList r100 = this.f382662b.get();
            if (r100 != null) goto L6;
            return;
        L6:
            if (r100.isEnableNewGesture() == true) goto L8;
            return;
        L8:
            q7a.b r101 = r100.getGestureArenaManager();
            if (r101 == null) goto L12;
            r101.b();
            return;
        }

        @Override // android.view.View
        public final boolean canScrollHorizontally(int r100) {
            UIList r101 = this.f382662b.get();
            if (r101 == null) goto L20;
            if (r101.W == false) goto L20;
            if (r100 < 0) goto L9;
            if (r100 <= 0) goto L20;
            if (UIList.Q(r101) < (getAdapter().getItemCount() - 1)) goto L18;
            return false;
        L18:
            return super.canScrollHorizontally(r100);
        L9:
            if (UIList.P(r101) != 0) goto L12;
            return false;
        L12:
            return super.canScrollHorizontally(r100);
        L20:
            return super.canScrollHorizontally(r100);
        }

        @Override // android.view.View
        public final boolean canScrollVertically(int r100) {
            UIList r101 = this.f382662b.get();
            if (r101 == null) goto L22;
            if (r101.W == false) goto L22;
            if (r100 < 0) goto L9;
            if (r100 <= 0) goto L22;
            int r102 = UIList.Q(r101);
            if (getAdapter() == null) goto L22;
            if (r102 < (getAdapter().getItemCount() - 1)) goto L20;
            return false;
        L20:
            return super.canScrollVertically(r100);
        L9:
            if (UIList.P(r101) != 0) goto L12;
            return false;
        L12:
            return super.canScrollVertically(r100);
        L22:
            return super.canScrollVertically(r100);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void dispatchDraw(Canvas r110) {
            if (this.f382665e == true) goto L6;
            super.dispatchDraw(r110);
            return;
        L6:
            g r100 = this.f382666f;
            r100.getClass();
            Path r101 = new Path();
            Drawable r102 = getBackground();
            int r103 = getScrollX();
            int r104 = getScrollY();
            int r105 = getWidth();
            int r106 = getHeight();
            if ((r102 instanceof BackgroundDrawable) == false) goto L15;
            BackgroundDrawable r107 = (BackgroundDrawable) r102;
            RectF r108 = r107.b();
            BorderRadius r109 = r107.A;
            Rect r111 = r100.f471251a;
            if (r111 != null) goto L11;
            r111 = r102.getBounds();
        L11:
            RectF r112 = new RectF((r111.left + r103) + r108.left, (r111.top + r104) + r108.top, (r103 + r111.right) - r108.right, (r104 + r111.bottom) - r108.bottom);
            if (r109 != null) goto L14;
            r101.addRect(r112, Path.Direction.CW);
        L20:
            int r113 = r110.save();
            r110.clipPath(r101);
            super.dispatchDraw(r110);
            r110.restoreToCount(r113);
            return;
        L14:
            r101.addRoundRect(r112, BackgroundDrawable.RoundRectPath.c(r109.a(), r108, 1.0f), Path.Direction.CW);
            goto L20
        L15:
            Rect r114 = r100.f471251a;
            if (r114 != null) goto L19;
            r114 = new Rect(0, 0, r105, r106);
        L19:
            r101.addRect(new RectF(r114.left + r103, r114.top + r104, r103 + r114.right, r104 + r114.bottom), Path.Direction.CW);
            goto L20
        }

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchTouchEvent(MotionEvent r100) {
            UIList r101 = this.f382662b.get();
            if (r101 != null) goto L7;
            return super.dispatchTouchEvent(r100);
        L7:
            if (r101.isEnableNewGesture() == false) goto L19;
            if (Boolean.FALSE.equals(this.f382667g) == false) goto L12;
            return true;
        L12:
            if (r100.getActionMasked() != 2) goto L19;
            if (this.f382667g == null) goto L19;
            if (this.f382669i == true) goto L19;
            r100.setAction(0);
            this.f382669i = true;
        L19:
            return super.dispatchTouchEvent(r100);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public final boolean onInterceptTouchEvent(MotionEvent r100) {
            boolean r101 = true;
            if (this.f382671k == false) goto L6;
            return true;
        L6:
            if (this.f382664d == false) goto L8;
            requestDisallowInterceptTouchEvent(true);
        L8:
            UIList r102 = this.f382662b.get();
            if (r102 != null) goto L13;
            return super.onInterceptTouchEvent(r100);
        L13:
            if (r102.isEnableNewGesture() == true) goto L15;
        L17:
            boolean r103 = false;
        L18:
            if (r103 == false) goto L21;
            return false;
        L21:
            if (r102.isEnableNewGesture() == false) goto L29;
            Boolean r104 = this.f382667g;
            if (r104 == null) goto L29;
            if (r104.booleanValue() == true) goto L29;
            if (r100.getActionMasked() == 0) goto L29;
            boolean r105 = true;
        L30:
            if (r105 == false) goto L33;
            return false;
        L33:
            if (r102.isEnableNewGesture() == true) goto L35;
        L37:
            boolean r106 = false;
        L38:
            if (r106 == true) goto L40;
        L42:
            r101 = false;
        L43:
            if (r101 == false) goto L47;
            return this.f382668h.booleanValue();
        L47:
            return super.onInterceptTouchEvent(r100);
        L40:
            if (this.f382668h.booleanValue() == false) goto L42;
        L35:
            if (this.f382668h == null) goto L37;
            r106 = true;
        L29:
            r105 = false;
            goto L30
        L15:
            if (r102.getIncludeNativeGesture() == true) goto L17;
            r103 = true;
            goto L18
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public final boolean onTouchEvent(MotionEvent r100) {
            UIList r101 = this.f382662b.get();
            if (r101 == null) goto L5;
            boolean r102 = false;
            if (this.f382670j == false) goto L10;
            return false;
        L10:
            if (r101.isEnableNewGesture() == true) goto L12;
        L14:
            boolean r103 = false;
        L15:
            if (r103 == false) goto L18;
            return false;
        L18:
            if (r101.isEnableNewGesture() == false) goto L26;
            Boolean r104 = this.f382667g;
            if (r104 == null) goto L26;
            if (r104.booleanValue() == true) goto L26;
            if (r100.getActionMasked() == 0) goto L26;
            boolean r105 = true;
        L27:
            if (r105 == false) goto L30;
            return false;
        L30:
            if (r101.isEnableNewGesture() == true) goto L32;
        L34:
            if (r102 == false) goto L50;
            if (r100.getAction() != 0) goto L39;
            getParent().requestDisallowInterceptTouchEvent(true);
            goto L50
        L39:
            if (r100.getAction() != 2) goto L45;
            getParent().requestDisallowInterceptTouchEvent(this.f382668h.booleanValue());
            boolean r106 = this.f382668h.booleanValue();
            if (this.f382668h.booleanValue() == false) goto L43;
            return r106;
        L43:
            return super.onTouchEvent(r100);
        L45:
            if (r100.getAction() != 1) goto L47;
        L48:
            this.f382668h = null;
            goto L50
        L47:
            if (r100.getAction() == 3) goto L48;
        L50:
            if (this.f382663c == true) goto L52;
            return true;
        L52:
            return super.onTouchEvent(r100);
        L32:
            if (this.f382668h == null) goto L34;
            r102 = true;
        L26:
            r105 = false;
            goto L27
        L12:
            if (r101.getIncludeNativeGesture() == true) goto L14;
            r103 = true;
            goto L15
        L5:
            return super.onTouchEvent(r100);
        }

        public final void r(boolean r100) {
            WeakReference<LynxContext> r101 = this.f382661a;
            if (r101 != null) goto L5;
            return;
        L5:
            if (this.f382662b == null) goto L17;
            LynxContext r102 = r101.get();
            UIList r103 = this.f382662b.get();
            if (r100 == false) goto L14;
            if (r102 == null) goto L15;
            if (r103 == null) goto L16;
            r102.onGestureRecognized(r103);
            return;
        L16:
            return;
        L15:
            return;
        L14:
            return;
        }

        @Override // android.view.View
        public final void setClipBounds(Rect r100) {
            if (this.f382665e == true) goto L6;
            super.setClipBounds(r100);
            return;
        L6:
            this.f382666f.f471251a = r100;
        }

        public d(Context r100, UIList r101) {
            super(r100);
            this.f382661a = null;
            this.f382662b = null;
            this.f382663c = true;
            this.f382664d = false;
            this.f382665e = false;
            this.f382666f = new g();
            this.f382667g = null;
            this.f382668h = null;
            this.f382669i = true;
            this.f382670j = false;
            this.f382671k = false;
            if (r100 != null) goto L5;
            return;
        L5:
            if ((r100 instanceof LynxContext) == false) goto L9;
            this.f382661a = new WeakReference((LynxContext) r100);
            this.f382662b = new WeakReference(r101);
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView
        public final boolean fling(int r100, int r101) {
            UIList r102 = this.f382662b.get();
            if (r102 != null) goto L5;
            super.fling(r100, r101);
        L5:
            float r103 = r102.U;
            if (r103 <= 0.0f) goto L14;
            if (r103 >= 1.0f) goto L14;
            if (r102.f382655x == false) goto L12;
            r101 = (int) MathUtils.clamp(r101, (-getMaxFlingVelocity()) * r102.U, getMaxFlingVelocity() * r102.U);
            goto L14
        L12:
            r100 = (int) MathUtils.clamp(r100, (-getMaxFlingVelocity()) * r102.U, getMaxFlingVelocity() * r102.U);
        L14:
            return super.fling(r100, r101);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
        public final View focusSearch(View r100, int r101) {
            WeakReference<UIList> r102 = this.f382662b;
            if (r102 == null) goto L14;
            if (r102.get() == null) goto L14;
            if (this.f382662b.get().X == true) goto L14;
            if (r101 != 130) goto L11;
        L12:
            return r100;
        L11:
            if (r101 == 33) goto L12;
        L14:
            return super.focusSearch(r100, r101);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
        public final boolean requestChildRectangleOnScreen(View r100, Rect r101, boolean r102) {
            WeakReference<LynxContext> r103 = this.f382661a;
            if (r103 == null) goto L13;
            if (r103.get() == null) goto L13;
            com.lynx.tasm.behavior.ui.accessibility.d r104 = this.f382661a.get().getLynxAccessibilityWrapper();
            if (r104 == null) goto L13;
            if (r104.e() == false) goto L13;
            return super.requestChildRectangleOnScreen(r100, r101, false);
        L13:
            return super.requestChildRectangleOnScreen(r100, r101, r102);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View, androidx.core.view.NestedScrollingChild
        public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103) {
            boolean r104 = super.dispatchNestedPreScroll(r100, r101, r102, r103);
            r(r104);
            return r104;
        }

        @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
        public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103, int r104) {
            boolean r105 = super.dispatchNestedPreScroll(r100, r101, r102, r103, r104);
            r(r105);
            return r105;
        }
    }

    public UIList() {
        throw null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityHostUI() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isScrollContainer() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList, com.lynx.tasm.behavior.ui.UIGroup
    public final void onInsertChild(LynxBaseUI r100, int r101) {
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setCacheQueueRatio(f6a.a r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setScrollStateChangeEventThrottle(String r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setScrollX(f6a.a r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setScrollY(f6a.a r100) {
    }

    public final boolean W() {
        LynxContext r100 = this.mContext;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getLynxView() == null) goto L15;
        ThreadStrategyForRendering r101 = this.mContext.getLynxView().getThreadStrategyForRendering();
        if (r101 != ThreadStrategyForRendering.MOST_ON_TASM) goto L10;
    L11:
        return true;
    L10:
        if (r101 == ThreadStrategyForRendering.MULTI_THREADS) goto L11;
        return false;
    L15:
        return false;
    }

    public final boolean X() {
        LynxContext r100 = this.mContext;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getLynxView() != null) goto L8;
        return false;
    L8:
        if (this.mContext.getLynxView().getThreadStrategyForRendering() != ThreadStrategyForRendering.PART_ON_LAYOUT) goto L12;
        return true;
    L12:
        return false;
    }

    public final void Y() {
        LLog.i("UIList", "onLayoutCompleted " + this.f382632c.f382679h.size());
        if (this.f382642l == true) goto L5;
        return;
    L5:
        if (((RecyclerView) this.mView).getChildCount() <= 0) goto L16;
        ListEventManager r100 = this.f382638i;
        JavaOnlyArray r101 = this.f382632c.f382679h;
        if ((r100.f382586c & 16) == 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        m7a.a r103 = new m7a.a(r100.f382593j.getSign(), "layoutcomplete");
        r103.a("timestamp", Long.valueOf(new Date().getTime()));
        r103.a("cells", r101);
        r100.f382584a.sendCustomEvent(r103);
    L13:
        this.f382642l = false;
        return;
    L9:
        r102 = false;
        goto L10
    }

    public final void Z() {
        if (this.f382641k0 == null) goto L6;
        Choreographer.getInstance().removeFrameCallback(this.f382641k0);
        this.f382641k0 = null;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        if (this.V == null) goto L5;
        ((RecyclerView) getView()).removeOnScrollListener(this.V);
    L5:
        com.lynx.tasm.behavior.ui.list.a r100 = this.P;
        if (r100 == null) goto L12;
        r100.f382710c.clear();
        r100.f382711d.clear();
        UIList r101 = r100.f382708a;
        if (r101 == null) goto L12;
        if (r101.getView() == 0) goto L12;
        ((RecyclerView) r100.f382708a.getView()).removeOnScrollListener(r100.f382712e);
    L12:
        super.destroy();
        Z();
        ((HashMap) this.f382656y).clear();
        e7a.a r102 = this.f382650s;
        if (r102 == null) goto L16;
        r102.dispose();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Rect getBoundRectForOverflow() {
        if (this.H0 == true) goto L7;
        return super.getBoundRectForOverflow();
    L7:
        return super.getClipBounds();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final int getMemberScrollX() {
        if (this.f382655x == false) goto L7;
        return 0;
    L7:
        return this.f382638i.f382595l;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final int getMemberScrollY() {
        if (this.f382655x == true) goto L5;
        return 0;
    L5:
        return this.f382638i.f382595l;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final int getScrollContainerDirection() {
        if (this.f382655x == false) goto L5;
        return 1;
    L5:
        return -1;
    }

    @LynxUIMethod
    public void initCache() {
        com.lynx.tasm.behavior.ui.list.a r100 = this.P;
        if (r100 == null) goto L6;
        r100.f382710c.clear();
        r100.f382711d.clear();
        this.P.c();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void layout() {
        TraceEvent.beginSection("UIList.layout");
        ViewGroup r100 = this.f382648q;
        if (r100 != null) goto L7;
        r100 = (RecyclerView) this.mView;
    L7:
        if (r100.isLayoutRequested() == true) goto L10;
        TraceEvent.endSection("UIList.layout");
        return;
    L10:
        layoutChildren();
        ListStickyManager.b r101 = this.f382648q;
        if (r101 == null) goto L13;
        r101.layout(getLeft(), getTop(), getLeft() + getWidth(), getTop() + getHeight());
    L15:
        if (this.H0 == false) goto L36;
        ViewGroup r102 = this.f382648q;
        if (r102 != null) goto L21;
        r102 = (RecyclerView) this.mView;
    L21:
        ViewParent r103 = r102.getParent();
        if (getOverflow() == 0) goto L24;
        boolean r104 = true;
    L25:
        if (r104 == true) goto L27;
    L29:
        if (r104 == false) goto L34;
        ListStickyManager.b r105 = this.f382648q;
        if (r105 == null) goto L34;
        r105.setClipChildren(false);
    L34:
        if (this.mOverflow == 0) goto L36;
        ((RecyclerView) this.mView).setOverScrollMode(2);
        goto L36
    L27:
        if ((r103 instanceof ViewGroup) == false) goto L29;
        ((ViewGroup) r103).setClipChildren(false);
        goto L29
    L24:
        r104 = false;
    L36:
        ViewCompat.setClipBounds(this.mView, getBoundRectForOverflow());
        this.f382650s.b();
        TraceEvent.endSection("UIList.layout");
        return;
    L13:
        ((RecyclerView) this.mView).layout(getLeft(), getTop(), getLeft() + getWidth(), getTop() + getHeight());
        goto L15
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void layoutChildren() {
        if (this.f382631J == true) goto L5;
    L12:
        super.layoutChildren();
        return;
    L5:
        if (this.f382648q == null) goto L12;
        UIComponent r100 = this.f382649r.f382612f.f382618a;
        if (r100 == null) goto L9;
        r100.performLayoutChildrenUI();
    L9:
        UIComponent r101 = this.f382649r.f382613g.f382618a;
        if (r101 == null) goto L12;
        r101.performLayoutChildrenUI();
        goto L12
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void measure() {
        TraceEvent.beginSection("UIList.measure");
        ViewGroup r100 = this.f382648q;
        if (r100 != null) goto L7;
        r100 = (RecyclerView) this.mView;
    L7:
        if (r100.isLayoutRequested() == true) goto L10;
        TraceEvent.endSection("UIList.measure");
        return;
    L10:
        measureChildren();
        setLayoutParamsInternal();
        int r101 = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824);
        if (this.f382640k == false) goto L13;
        int r102 = View.MeasureSpec.makeMeasureSpec((int) this.mMaxHeight, Integer.MIN_VALUE);
    L14:
        ListStickyManager.b r103 = this.f382648q;
        if (r103 == null) goto L17;
        r103.measure(r101, r102);
    L17:
        ((RecyclerView) this.mView).measure(r101, r102);
        this.f382632c.f382676e = true;
        TraceEvent.endSection("UIList.measure");
        return;
    L13:
        r102 = View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824);
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onPropsUpdated() {
        UIList r100 = this;
        super.onPropsUpdated();
        if (r100.f382646p == false) goto L7;
        r100.f382646p = false;
        return;
    L7:
        if (((RecyclerView) r100.mView).getAdapter() != null) goto L10;
        ((RecyclerView) r100.mView).setAdapter(r100.f382632c);
    L10:
        if (W() == true) goto L12;
    L17:
        boolean r101 = true;
    L18:
        if (r101 == true) goto L31;
        if (r100.A == null) goto L22;
    L23:
        LynxContext r102 = r100.mContext;
        if (r102 != null) goto L26;
        return;
    L26:
        if (r102.getLynxView() == null) goto L327;
        r100.mContext.handleLynxError(new LynxError(220207, "Multi thread strategy can not be used by default.", "Please set the attribute of enable-async-list to true at LynxSDK 2.10+ .", "error"));
        return;
    L327:
        return;
    L22:
        if (r100.D != null) goto L23;
        return;
    L31:
        if (r100.E == false) goto L182;
        r100.f382632c.f382678g = W();
        int r103 = r100.f382647p0;
        if (r103 >= 0) goto L35;
    L37:
        ReadableMap r104 = r100.D;
        if (r104 == null) goto L165;
        UIListAdapter r105 = r100.f382632c;
        r105.f382675d = true;
        ReadableArray r106 = r104.getArray("updateAction");
        ReadableArray r107 = r104.getArray("insertAction");
        ReadableArray r108 = r104.getArray("removeAction");
        if (r106 != null) goto L45;
        if (r107 != null) goto L45;
        if (r108 != null) goto L45;
        ReadableMap r109 = null;
    L163:
        r100.D = r109;
    L184:
        if (r100.f382637h == false) goto L228;
        UIListAdapter r110 = r100.f382632c;
        r110.B.clear();
        int r111 = 0;
    L187:
        if (r111 >= r110.f382674c.f382633d) goto L189;
        r110.B.add(new HashMap());
        r111 = r111 + 1;
        goto L187
    L189:
        new WeakReference(r100);
        if (TextUtils.equals(r100.f382636g, "single") == false) goto L195;
        ListLayoutManager.ListLinearLayoutManager r112 = new ListLayoutManager.ListLinearLayoutManager(r100.mContext, r100);
        r112.setOrientation(r100.f382655x ? 1 : 0);
        RecyclerView.LayoutManager r113 = r112;
        if (r100.K == true) goto L211;
        r112.setInitialPrefetchItemCount(0);
        r113 = r112;
    L211:
        ListStickyManager r114 = r100.f382649r;
        if (r114 == null) goto L220;
        ListStickyManager.c r115 = r114.f382612f;
        if (r115.f382619b == (-1)) goto L216;
        r114.j(r115);
    L216:
        ListStickyManager.c r116 = r114.f382613g;
        if (r116.f382619b == (-1)) goto L220;
        r114.j(r116);
    L220:
        if (r100.K == true) goto L223;
        if (r113 == null) goto L223;
        boolean r117 = false;
        r113.setItemPrefetchEnabled(false);
    L225:
        if (r100.P == null) goto L227;
        ((RecyclerView) r100.mView).setItemViewCacheSize(r117 ? 1 : 0);
    L227:
        ((RecyclerView) r100.mView).setLayoutManager(r113);
    L229:
        r100.f382637h = r117;
        if ((((RecyclerView) r100.mView).getLayoutManager() instanceof ListLayoutManager.ListLinearLayoutManager) == false) goto L235;
        ListLayoutManager.ListLinearLayoutManager r118 = (ListLayoutManager.ListLinearLayoutManager) ((RecyclerView) r100.mView).getLayoutManager();
        boolean r119 = r118.getStackFromEnd();
        boolean r120 = r100.Y;
        if (r119 == r120) goto L235;
        r118.setStackFromEnd(r120);
    L235:
        if ((((RecyclerView) r100.mView).getLayoutManager() instanceof GridLayoutManager) == false) goto L238;
        GridLayoutManager r121 = (GridLayoutManager) ((RecyclerView) r100.mView).getLayoutManager();
        r121.setSpanSizeLookup(new k(r100, r121));
    L238:
        if (r100.N == true) goto L240;
    L242:
        int r122 = 0;
    L243:
        ((RecyclerView) r100.mView).setLayoutDirection(r122);
        JavaOnlyArray r123 = r100.f382632c.f382679h;
        if (r123 != null) goto L246;
        int r124 = 0;
    L247:
        int r125 = r100.f382651t;
        if (r124 > r125) goto L250;
    L252:
        LLog.i("UIList", "onPropsUpdated viewNames " + r124);
        if ((r100.f382638i.f382586c & 16) == 0) goto L255;
        boolean r126 = true;
    L256:
        if (r126 == true) goto L258;
    L265:
        ListStickyManager r127 = r100.f382649r;
        if (r127 == null) goto L268;
        r127.k(r127.f382613g);
        r127.k(r127.f382612f);
        r100.f382649r.f382614h = r100.f382653v;
    L268:
        r100.f382639j.f382716b.f382726j = r100.f382655x;
        if (r100.F == false) goto L274;
        ListEventManager r128 = r100.f382638i;
        if (r128 == null) goto L274;
        r128.f382596m = 0;
    L274:
        T r129 = r100.mView;
        if (r129 != 0) goto L277;
    L294:
        LLog.e("UIList", "Fail to update gap item decoration because mView == null or LayoutManager == null");
        return;
    L277:
        if (((RecyclerView) r129).getLayoutManager() == null) goto L294;
        if (r100.R == true) goto L282;
        GapItemDecoration r130 = r100.S;
        if (r130 == null) goto L329;
        ((RecyclerView) r100.mView).removeItemDecoration(r130);
        return;
    L329:
        return;
    L282:
        if (r100.S != null) goto L284;
        GapItemDecoration r131 = new GapItemDecoration();
        r100.S = r131;
        ((RecyclerView) r100.mView).addItemDecoration(r131);
    L284:
        GapItemDecoration r132 = r100.S;
        r132.f382579a = r100.f382655x;
        if (r100.N == true) goto L287;
    L289:
        boolean r133 = false;
    L290:
        r132.f382580b = r133;
        GapItemDecoration r134 = r100.S;
        r134.f382581c = r100.f382633d;
        r134.f382582d = r100.f382634e;
        r134.f382583e = r100.f382635f;
        ((RecyclerView) r100.mView).invalidateItemDecorations();
        return;
    L287:
        if (isRtl() == false) goto L289;
        r133 = true;
        goto L290
    L258:
        if (r100.Z == true) goto L260;
    L263:
        boolean r135 = true;
    L264:
        r100.f382642l = r135;
        goto L265
    L260:
        if (((RecyclerView) r100.mView).isLayoutRequested() == true) goto L263;
        r135 = false;
        goto L264
    L255:
        r126 = false;
        goto L256
    L250:
        if (r125 <= (-1)) goto L252;
        r100.f382639j.a(r125, 0, null);
        r100.f382651t = -1;
        goto L252
    L246:
        r124 = r123.size();
        goto L247
    L240:
        if (isRtl() == false) goto L242;
        r122 = 1;
    L223:
        r117 = false;
        goto L225
    L195:
        if (TextUtils.equals(r100.f382636g, BytedCertConstant.CertKey.FLOW) == false) goto L204;
        LynxContext r136 = r100.mContext;
        int r137 = r100.f382633d;
        if (r100.R == false) goto L199;
        int r138 = 0;
    L200:
        ListLayoutManager.ListGridLayoutManager r139 = new ListLayoutManager.ListGridLayoutManager(r136, r137, r138, r100);
        r139.setOrientation(r100.f382655x ? 1 : 0);
        r113 = r139;
        if (r100.K == true) goto L211;
        r139.setInitialPrefetchItemCount(0);
        r113 = r139;
        goto L211
    L199:
        r138 = r100.f382635f;
        goto L200
    L204:
        if (TextUtils.equals(r100.f382636g, "waterfall") == false) goto L210;
        int r140 = r100.f382633d;
        if (r100.R == false) goto L208;
        int r141 = 0;
    L209:
        ListLayoutManager.b r142 = new ListLayoutManager.b(r140, r141, r100);
        r142.setOrientation(r100.f382655x ? 1 : 0);
        r113 = r142;
        goto L211
    L208:
        r141 = r100.f382635f;
        goto L209
    L210:
        r113 = null;
        goto L211
    L228:
        r117 = false;
    L45:
        if (r105.f382691t != null) goto L48;
        r105.f382691t = new JavaOnlyArray();
    L48:
        if (r105.f382679h != null) goto L51;
        r105.f382679h = new JavaOnlyArray();
    L51:
        if (r105.f382680i != null) goto L54;
        r105.f382680i = new JavaOnlyArray();
    L54:
        if (r105.f382685n != null) goto L57;
        r105.f382685n = new JavaOnlyArray();
    L57:
        if (r105.f382686o != null) goto L60;
        r105.f382686o = new JavaOnlyArray();
    L60:
        if (r105.f382681j != null) goto L63;
        r105.f382681j = new JavaOnlyArray();
    L63:
        if (r105.f382687p != null) goto L66;
        r105.f382687p = new JavaOnlyArray();
    L66:
        if (r105.f382682k != null) goto L69;
        r105.f382682k = new JavaOnlyArray();
    L69:
        if (r105.f382684m != null) goto L71;
        r105.f382684m = new JavaOnlyArray();
    L71:
        UIListAdapter.d r143 = r105.f382688q;
        r143.getClass();
        if (r108 == null) goto L80;
        int r144 = r108.size() - 1;
    L74:
        if (r144 < 0) goto L80;
        int r145 = r108.getInt(r144);
        if (r145 < 0) goto L79;
        r143.f382707g.f382691t.remove(r145);
        r143.f382707g.f382679h.remove(r145);
        r143.f382707g.f382684m.remove(r145);
        r143.f382707g.f382685n.remove(r145);
        r143.f382707g.f382686o.remove(r145);
        r143.f382707g.f382687p.remove(r145);
    L79:
        r144 = r144 - 1;
    L80:
        String r146 = "position";
        String r147 = "type";
        String r148 = "item-key";
        if (r107 == null) goto L93;
        int r149 = 0;
    L84:
        if (r149 >= r107.size()) goto L93;
        ReadableMap r150 = r107.getMap(r149);
        if (r150 == null) goto L92;
        int r151 = r150.getInt(r146);
        String r152 = r150.getString("item-key");
        String r153 = r150.getString("type");
        boolean r154 = r150.getBoolean("full-span", false);
        boolean r210 = r150.getBoolean("sticky-top", false);
        boolean r211 = r150.getBoolean("sticky-bottom", false);
        int r155 = r150.getInt("estimated-height-px", -1);
        r143.f382707g.f382691t.add(r151, r152);
        r143.f382707g.f382679h.add(r151, r153);
        if (r143.f382707g.f382672a.containsKey(r153) == true) goto L91;
        HashMap<String, Integer> r156 = r143.f382707g.f382672a;
        r156.put(r153, Integer.valueOf(r156.size()));
    L91:
        r143.f382707g.f382685n.add(r151, Boolean.valueOf(r154));
        r143.f382707g.f382686o.add(r151, Boolean.valueOf(r210));
        r143.f382707g.f382687p.add(r151, Boolean.valueOf(r211));
        r143.f382707g.f382684m.add(r151, Integer.valueOf(r155));
    L92:
        r149 = r149 + 1;
        r146 = r146;
        r107 = r107;
        r108 = r108;
    L93:
        ReadableArray r157 = r107;
        ReadableArray r158 = r108;
        String r159 = r146;
        if (r106 == null) goto L106;
        int r160 = 0;
    L97:
        if (r160 >= r106.size()) goto L106;
        ReadableMap r161 = r106.getMap(r160);
        if (r161 == null) goto L105;
        int r162 = r161.getInt("from");
        r161.getInt(RemoteMessageConst.TO);
        String r163 = r161.getString(r148);
        String r164 = r161.getString(r147);
        boolean r212 = r161.getBoolean("full-span", false);
        boolean r213 = r161.getBoolean("sticky-top", false);
        boolean r214 = r161.getBoolean("sticky-bottom", false);
        int r165 = r161.getInt("estimated-height-px", -1);
        r143.f382707g.f382691t.set(r162, r163);
        r143.f382707g.f382679h.set(r162, r164);
        if (r143.f382707g.f382672a.containsKey(r164) == true) goto L104;
        HashMap<String, Integer> r166 = r143.f382707g.f382672a;
        r166.put(r164, Integer.valueOf(r166.size()));
    L104:
        r143.f382707g.f382685n.set(r162, Boolean.valueOf(r212));
        r143.f382707g.f382686o.set(r162, Boolean.valueOf(r213));
        r143.f382707g.f382687p.set(r162, Boolean.valueOf(r214));
        r143.f382707g.f382684m.set(r162, Integer.valueOf(r165));
    L105:
        r160 = r160 + 1;
        r148 = r148;
        r147 = r147;
    L106:
        UIListAdapter.d r167 = r105.f382688q;
        r167.f382707g.f382680i.clear();
        int r168 = 0;
    L108:
        if (r168 >= r167.f382707g.f382685n.size()) goto L113;
        if (r167.f382707g.f382685n.getBoolean(r168) == false) goto L112;
        r167.f382707g.f382680i.add(Integer.valueOf(r168));
    L112:
        r168 = r168 + 1;
        goto L108
    L113:
        r167.f382707g.f382681j.clear();
        int r169 = 0;
    L115:
        if (r169 >= r167.f382707g.f382686o.size()) goto L120;
        if (r167.f382707g.f382686o.getBoolean(r169) == false) goto L119;
        r167.f382707g.f382681j.add(Integer.valueOf(r169));
    L119:
        r169 = r169 + 1;
        goto L115
    L120:
        r167.f382707g.f382682k.clear();
        int r170 = 0;
    L122:
        if (r170 >= r167.f382707g.f382687p.size()) goto L128;
        if (r167.f382707g.f382687p.getBoolean(r170) == false) goto L126;
        r167.f382707g.f382682k.add(Integer.valueOf(r170));
    L126:
        r170 = r170 + 1;
        goto L122
    L128:
        if (r104.getBoolean("reloadAll", false) == true) goto L130;
        UIListAdapter.d r171 = r105.f382688q;
        r171.getClass();
        if (r158 == null) goto L143;
        int r172 = r158.size() - 1;
    L137:
        if (r172 < 0) goto L143;
        ReadableArray r173 = r158;
        int r174 = r173.getInt(r172);
        if (r174 < 0) goto L142;
        r171.f382707g.notifyItemRemoved(r174);
    L142:
        r172 = r172 - 1;
        r158 = r173;
    L143:
        if (r157 == null) goto L152;
        int r175 = 0;
    L146:
        if (r175 >= r157.size()) goto L152;
        ReadableArray r176 = r157;
        ReadableMap r177 = r176.getMap(r175);
        if (r177 != null) goto L150;
        String r178 = r159;
    L151:
        r175 = r175 + 1;
        r157 = r176;
        r159 = r178;
        goto L146
    L150:
        r178 = r159;
        r171.f382707g.notifyItemInserted(r177.getInt(r178));
    L152:
        if (r106 != null) goto L153;
    L133:
        r109 = null;
        r100 = this;
        goto L163
    L153:
        int r179 = 0;
    L155:
        if (r179 >= r106.size()) goto L133;
        ReadableMap r180 = r106.getMap(r179);
        if (r180 == null) goto L162;
        int r181 = r180.getInt("from");
        int r182 = r180.getInt(RemoteMessageConst.TO);
        if (r180.getBoolean("flush", false) == false) goto L162;
        r171.f382707g.notifyItemChanged(r181, Integer.valueOf(r182));
    L162:
        r179 = r179 + 1;
        goto L155
    L130:
        if (r105.L2() == false) goto L132;
        UIThreadUtils.runOnUiThread(r105.A);
        goto L133
    L132:
        r105.A.run();
        goto L133
    L165:
        if ((r100.A instanceof ReadableMap) == false) goto L184;
        if (r100.Q > 0) goto L169;
    L181:
        r100.f382632c.M2((JavaOnlyMap) r100.A);
        r100.A = null;
        goto L184
    L169:
        if (W() == false) goto L181;
        if (r100.P != null) goto L174;
        r100.P = new com.lynx.tasm.behavior.ui.list.a(r100, r100.Q);
    L174:
        if (r100.Q > 0) goto L176;
        com.lynx.tasm.behavior.ui.list.a r183 = r100.P;
        if (r183 == null) goto L181;
        r183.f382710c.clear();
        r183.f382711d.clear();
        goto L181
    L176:
        if (r100.V != null) goto L181;
        r100.V = new m(r100);
        ((RecyclerView) getView()).addOnScrollListener(r100.V);
        goto L181
    L35:
        if (r103 >= r100.f382632c.getItemCount()) goto L37;
        ((RecyclerView) getView()).scrollToPosition(r100.f382647p0);
        r100.f382647p0 = -1;
        goto L37
    L182:
        r100.f382632c.M2(((com.lynx.tasm.l) r100.f382571a).b(getSign()));
        goto L184
    L12:
        if (r100.E == true) goto L14;
    L16:
        r101 = false;
        goto L18
    L14:
        if (r100.M == false) goto L16;
        goto L16
    }

    @LynxUIMethod
    public void removeStickyView() {
        ListStickyManager r100 = this.f382649r;
        if (r100 == null) goto L6;
        r100.l(r100.f382612f, true, true);
        r100.l(r100.f382613g, false, true);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.k
    public final void requestLayout() {
        ((RecyclerView) this.mView).requestLayout();
        if (((RecyclerView) this.mView).isLayoutRequested() == true) goto L6;
        T r100 = this.mView;
        ((RecyclerView) r100).post(new a(r100));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int T() {
        RecyclerView.LayoutManager r100 = ((RecyclerView) getView()).getLayoutManager();
        if ((r100 instanceof LinearLayoutManager) == false) goto L6;
        return ((LinearLayoutManager) r100).findFirstVisibleItemPosition();
    L6:
        if ((r100 instanceof StaggeredGridLayoutManager) == false) goto L13;
        int r101 = this.f382633d;
        if (r101 <= 0) goto L13;
        int[] r102 = new int[r101];
        ((StaggeredGridLayoutManager) r100).findFirstVisibleItemPositions(r102);
        int r103 = r102[0];
        int r104 = 1;
    L11:
        if (r104 >= this.f382633d) goto L17;
        r103 = Math.min(r103, r102[r104]);
        r104 = r104 + 1;
        goto L11
    L17:
        return r103;
    L13:
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int U() {
        RecyclerView.LayoutManager r100 = ((RecyclerView) getView()).getLayoutManager();
        if ((r100 instanceof LinearLayoutManager) == true) goto L17;
        int r101 = -1;
        if ((r100 instanceof StaggeredGridLayoutManager) == false) goto L14;
        int r102 = this.f382633d;
        if (r102 <= 0) goto L14;
        int[] r103 = new int[r102];
        ((StaggeredGridLayoutManager) r100).findLastVisibleItemPositions(r103);
        int r104 = 0;
    L11:
        if (r104 >= this.f382633d) goto L18;
        r101 = Math.max(r101, r103[r104]);
        r104 = r104 + 1;
        goto L11
    L18:
        return r101;
    L14:
        return -1;
    L17:
        return ((LinearLayoutManager) r100).findLastVisibleItemPosition();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final RecyclerView V() {
        return (RecyclerView) getView();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final Map<Integer, t7a.a> getGestureHandlers() {
        return super.getGestureHandlers();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final void onInvalidate() {
        if (isEnableNewGesture() == false) goto L9;
        T r100 = this.mView;
        if (r100 == 0) goto L10;
        ViewCompat.postInvalidateOnAnimation(r100);
        return;
    L10:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        int r100 = this.mPaddingTop + this.mBorderTopWidth;
        int r101 = this.mPaddingBottom + this.mBorderBottomWidth;
        int r102 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r103 = this.mPaddingRight + this.mBorderRightWidth;
        if (1 != ((RecyclerView) this.mView).getLayoutDirection()) goto L5;
        ((RecyclerView) this.mView).setPadding(r103, r100, r102, r101);
        return;
    L5:
        ((RecyclerView) this.mView).setPadding(r102, r100, r103, r101);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityDirectionVertical() {
        return this.f382655x;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int P(UIList r100) {
        if (r100.getView() == 0) goto L17;
        RecyclerView.LayoutManager r101 = ((RecyclerView) r100.getView()).getLayoutManager();
        if ((r101 instanceof LinearLayoutManager) == false) goto L8;
        return ((LinearLayoutManager) r101).findFirstCompletelyVisibleItemPosition();
    L8:
        if ((r101 instanceof StaggeredGridLayoutManager) == false) goto L17;
        int r102 = r100.f382633d;
        if (r102 <= 0) goto L17;
        int[] r103 = new int[r102];
        ((StaggeredGridLayoutManager) r101).findFirstCompletelyVisibleItemPositions(r103);
        int r104 = r103[0];
        int r105 = 1;
    L14:
        if (r105 >= r100.f382633d) goto L21;
        r104 = Math.min(r104, r103[r105]);
        r105 = r105 + 1;
        goto L14
    L21:
        return r104;
    L17:
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int Q(UIList r100) {
        int r101 = -1;
        if (r100.getView() == 0) goto L16;
        RecyclerView.LayoutManager r102 = ((RecyclerView) r100.getView()).getLayoutManager();
        if ((r102 instanceof LinearLayoutManager) == false) goto L8;
        return ((LinearLayoutManager) r102).findLastCompletelyVisibleItemPosition();
    L8:
        if ((r102 instanceof StaggeredGridLayoutManager) == false) goto L19;
        int r103 = r100.f382633d;
        if (r103 <= 0) goto L20;
        int[] r104 = new int[r103];
        ((StaggeredGridLayoutManager) r102).findLastCompletelyVisibleItemPositions(r104);
        int r105 = 0;
    L14:
        if (r105 >= r100.f382633d) goto L21;
        r101 = Math.max(r101, r104[r105]);
        r105 = r105 + 1;
        goto L14
    L21:
        return r101;
    L20:
        return -1;
    L19:
        return -1;
    L16:
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean R(int r100) {
        if (this.f382655x == false) goto L7;
        return ((RecyclerView) getView()).canScrollVertically(r100);
    L7:
        return ((RecyclerView) getView()).canScrollHorizontally(r100);
    }

    public RecyclerView S(Context r100) {
        return new d(r100, this);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void consumeGesture(boolean r100) {
        T r101 = this.mView;
        if ((r101 instanceof d) == false) goto L8;
        d r102 = (d) r101;
        r102.f382667g = Boolean.valueOf(r100);
        if (r100 == false) goto L9;
        r102.f382669i = false;
        return;
    L9:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        RecyclerView r101 = S(r100);
        r101.setClipToPadding(false);
        r101.setRecycledViewPool(new j(this));
        this.f382638i = new ListEventManager(getLynxContext().getEventEmitter(), r101, this);
        this.f382650s = new e7a.a(getLynxContext().getEventEmitter(), r101);
        r101.setItemAnimator(null);
        this.f382632c = new UIListAdapter(this, this.f382650s);
        this.f382639j = new com.lynx.tasm.behavior.ui.list.b(r100, r101);
        r101.setOverScrollMode(2);
        if (W() == false) goto L5;
        LynxFeatureCounter.a(88, this.mContext.getInstanceId());
    L5:
        return r101;
    }

    @LynxProp(defaultBoolean = true, name = "enable-nested-scroll")
    public void enableNestedScroll(boolean r100) {
        T r101 = this.mView;
        if (r101 != 0) goto L5;
        return;
    L5:
        ((RecyclerView) r101).setNestedScrollingEnabled(r100);
    }

    @LynxProp(defaultBoolean = false, name = "enable-rtl")
    public void enableRtl(boolean r100) {
        this.N = r100;
    }

    @LynxUIMethod
    public void getScrollInfo(Callback r100) {
        int r101 = getMemberScrollX();
        int r102 = getMemberScrollY();
        JavaOnlyMap r103 = new JavaOnlyMap();
        r103.putInt("scrollX", h.h(this.mContext, r101));
        r103.putInt("scrollY", h.h(this.mContext, r102));
        r100.invoke(new Object[]{0, r103});
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Object getValueFromNativeStorage(String r100) {
        Map<String, Object> r101 = this.f382656y;
        if (r101 != null) goto L5;
        return null;
    L5:
        return ((HashMap) r101).get(r100);
    }

    @LynxUIMethod
    public void getVisibleCells(Callback r100) {
        if (r100 != null) goto L5;
        LLog.i("UIList", "getVisibleCells with null callback");
        return;
    L5:
        r100.invoke(new Object[]{0, this.f382638i.l()});
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void interceptGesture(boolean r100) {
        T r101 = this.mView;
        if ((r101 instanceof d) == false) goto L6;
        Boolean r102 = Boolean.valueOf(r100);
        ((d) r101).f382668h = r102;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final boolean isAtBorder(boolean r100) {
        if (isEnableNewGesture() == true) goto L7;
        return false;
    L7:
        if (r100 == false) goto L11;
        return !R(-1);
    L11:
        return !R(1);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeKeyFromNativeStorage(String r100) {
        Map<String, Object> r101 = this.f382656y;
        if (r101 == null) goto L6;
        ((HashMap) r101).remove(r100);
        return;
    }

    @LynxProp(defaultBoolean = false, name = "android-ignore-attach-for-binding")
    public void setAndroidIgnoreAttachForBinding(boolean r100) {
        this.L = r100;
    }

    @LynxProp(customType = "false", name = "auto-measure")
    public void setAutoMeasure(f6a.a r100) {
        this.f382640k = ListEventManager.j(r100, false);
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setColumnCount(int r100) {
        if (this.f382633d != r100) goto L5;
        return;
    L5:
        this.f382633d = r100;
        RecyclerView.LayoutManager r101 = ((RecyclerView) this.mView).getLayoutManager();
        if ((r101 instanceof GridLayoutManager) == false) goto L9;
        ((GridLayoutManager) r101).setSpanCount(this.f382633d);
        return;
    L9:
        if ((r101 instanceof StaggeredGridLayoutManager) == false) goto L13;
        ((StaggeredGridLayoutManager) r101).setSpanCount(this.f382633d);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setComponentInitMeasure(boolean r100) {
        UIListAdapter r101 = this.f382632c;
        if (r101 == null) goto L6;
        r101.f382677f = r100;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setCrossAxisGap(float r100) {
        this.f382635f = Math.round(r100);
        RecyclerView.LayoutManager r101 = ((RecyclerView) this.mView).getLayoutManager();
        int r102 = 0;
        if ((r101 instanceof ListLayoutManager.ListGridLayoutManager) == false) goto L10;
        ListLayoutManager.ListGridLayoutManager r103 = (ListLayoutManager.ListGridLayoutManager) r101;
        if (this.R == true) goto L8;
        r102 = this.f382635f;
    L8:
        r103.f382599b = r102;
        return;
    L10:
        if ((r101 instanceof ListLayoutManager.b) == false) goto L18;
        ListLayoutManager.b r104 = (ListLayoutManager.b) r101;
        if (this.R == true) goto L15;
        r102 = this.f382635f;
    L15:
        r104.f382606b = r102;
        return;
    }

    @LynxProp(customType = "true", name = "android-diffable")
    public void setDiffable(f6a.a r100) {
        if (((RecyclerView) this.mView).getAdapter() != null) goto L6;
        this.f382632c.setHasStableIds(!ListEventManager.j(r100, true));
        return;
    }

    @LynxProp(defaultBoolean = false, name = "enable-async-list")
    public void setEnableAsyncList(boolean r100) {
        this.M = r100;
    }

    @LynxProp(defaultBoolean = false, name = "enable-disappear")
    public void setEnableDisappear(boolean r100) {
        e7a.d r101 = this.f382650s.f471208c;
        if ((r101 instanceof e7a.b) == false) goto L6;
        ((e7a.b) r101).f471215f = r100;
        return;
    }

    @LynxProp(defaultBoolean = true, name = "android-enable-focus-search")
    public void setEnableFocusSearch(boolean r100) {
        this.X = r100;
    }

    @LynxProp(defaultBoolean = false, name = "android-enable-gap-item-decoration")
    public void setEnableGapItemDecoration(boolean r100) {
        this.R = r100;
    }

    @LynxProp(defaultBoolean = true, name = "android-enable-item-prefetch")
    public void setEnableItemPrefetch(boolean r100) {
        this.K = r100;
    }

    @LynxProp(defaultBoolean = false, name = "android-enable-overflow")
    public void setEnableOverflow(boolean r100) {
        this.H0 = r100;
        T r101 = this.mView;
        if ((r101 instanceof d) == false) goto L6;
        ((d) r101).f382665e = r100;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setEnablePagerSnap(f6a.a r100) {
        if (ListEventManager.j(r100, false) == true) goto L5;
    L10:
        PagerSnapHelper r101 = this.f382643m;
        if (r101 == null) goto L15;
        r101.attachToRecyclerView(null);
        this.f382643m = null;
        return;
    L15:
        return;
    L5:
        if (this.f382644n != null) goto L10;
        if (this.f382643m != null) goto L9;
        this.f382643m = new PagerSnapHelper();
    L9:
        this.f382643m.attachToRecyclerView((RecyclerView) this.mView);
    }

    @LynxProp(defaultBoolean = false, name = "enable-size-cache")
    public void setEnableSizeCache(boolean r100) {
        this.O = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setEnableSticky(f6a.a r100) {
        if (ListEventManager.j(r100, false) == true) goto L5;
        return;
    L5:
        if (this.f382648q != null) goto L9;
        ListStickyManager r101 = new ListStickyManager(this);
        this.f382649r = r101;
        this.f382648q = r101.f382608b;
        r101.f382610d = this.f382652u;
        return;
    }

    @LynxProp(defaultBoolean = false, name = "android-enable-strict-scrollable")
    public void setEnableStrictScrollable(boolean r100) {
        this.W = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r100) {
        super.setEvents(r100);
        ListEventManager r101 = this.f382638i;
        r101.f382586c = 0;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.containsKey(GXViewKey.VIEW_TYPE_CONTAINER_SCROLL) == false) goto L8;
        int r102 = r101.f382586c | 1;
    L9:
        r101.f382586c = r102;
        if (r100.containsKey("scrolltoupper") == false) goto L12;
        int r103 = r101.f382586c | 2;
    L13:
        r101.f382586c = r103;
        if (r100.containsKey("scrolltolower") == false) goto L16;
        int r104 = r101.f382586c | 4;
    L17:
        r101.f382586c = r104;
        if (r100.containsKey("scrollstatechange") == false) goto L20;
        int r105 = r101.f382586c | 8;
    L21:
        r101.f382586c = r105;
        if (r100.containsKey("layoutcomplete") == false) goto L24;
        int r106 = r101.f382586c | 16;
    L25:
        r101.f382586c = r106;
        return;
    L24:
        r106 = r101.f382586c;
        goto L25
    L20:
        r105 = r101.f382586c;
        goto L21
    L16:
        r104 = r101.f382586c;
        goto L17
    L12:
        r103 = r101.f382586c;
        goto L13
    L8:
        r102 = r101.f382586c;
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setGestureDetectors(Map<Integer, s7a.a> r100) {
        super.setGestureDetectors(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setInitialScrollIndex(f6a.a r100) {
        this.f382651t = ListEventManager.k(r100, -1);
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setInternalCellAppearNotification(boolean r100) {
        super.setInternalCellAppearNotification(r100);
        UIListAdapter r101 = this.f382632c;
        if (r101 == null) goto L6;
        r101.f382693v = r100;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setInternalCellDisappearNotification(boolean r100) {
        super.setInternalCellDisappearNotification(r100);
        UIListAdapter r101 = this.f382632c;
        if (r101 == null) goto L6;
        r101.f382694w = r100;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setInternalCellPrepareForReuseNotification(boolean r100) {
        super.setInternalCellPrepareForReuseNotification(r100);
        UIListAdapter r101 = this.f382632c;
        if (r101 == null) goto L6;
        r101.f382695x = r100;
        return;
    }

    @LynxProp(defaultInt = 0, name = "item-holder-type")
    public void setItemHolderType(f6a.a r100) {
        this.T = ListEventManager.k(r100, 0);
    }

    @LynxProp(defaultBoolean = false, name = "android-new-scroll-top")
    public void setListNewScrollTopSwitch(boolean r100) {
        this.f382654w = r100;
    }

    @LynxProp(defaultBoolean = true, name = "use-old-sticky")
    public void setListOldStickySwitch(boolean r100) {
        this.f382653v = r100;
    }

    @LynxProp(name = "list-platform-info")
    public void setListPlatformInfo(ReadableMap r100) {
        this.E = true;
        this.A = r100;
        this.D = null;
        this.Z = false;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setListType(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = "single";
    L6:
        if (TextUtils.equals(r100, this.f382636g) == true) goto L9;
        this.f382637h = true;
        this.f382636g = r100;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setLowerThreshold(f6a.a r100) {
        ListEventManager r101 = this.f382638i;
        r101.getClass();
        r101.f382589f = ListEventManager.k(r100, 50);
        r101.f382591h = 0;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setLowerThresholdItemCount(f6a.a r100) {
        ListEventManager r101 = this.f382638i;
        r101.getClass();
        r101.f382591h = ListEventManager.k(r100, 0);
        r101.f382589f = 0;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setMainAxisGap(float r100) {
        this.f382634e = Math.round(r100);
    }

    @LynxProp(defaultDouble = 1.0d, name = "max-fling-velocity-percent")
    public void setMaxFlingVelocityPercent(float r100) {
        this.U = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setNeedVisibleCells(boolean r100) {
        this.f382638i.f382597n = r100;
    }

    @LynxProp(defaultBoolean = false, name = "enable-new-exposure-strategy")
    public void setNewAppear(boolean r100) {
        e7a.a r101 = this.f382650s;
        if (r100 == r101.f471209d) goto L14;
        e7a.d r102 = r101.f471208c;
        if (r102 == null) goto L8;
        r102.dispose();
    L8:
        r101.f471209d = r100;
        if (r100 == false) goto L11;
        r101.f471208c = new e7a.c(r101.f471206a, r101.f471207b);
        return;
    L11:
        r101.f471208c = new e7a.b(r101.f471206a);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setNoInvalidate(boolean r100) {
        this.f382646p = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setPagingAlignment(ReadableMap r100) {
        if ((r100 instanceof JavaOnlyMap) == true) goto L5;
    L16:
        FactoredPagerSnapHelper r101 = this.f382644n;
        if (r101 == null) goto L20;
        r101.attachToRecyclerView(null);
        this.f382644n = null;
        return;
    L20:
        return;
    L5:
        if (((JavaOnlyMap) r100).size() == 0) goto L16;
        double r102 = r100.getDouble("factor");
        if (r102 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
    L10:
        getLynxContext().handleLynxError(new LynxError(220205, "item-snap invalid!", "The factor should be constrained to the range of [0,1].", "warn"));
        r102 = 0.0d;
    L11:
        int r103 = r100.getInt("offset", 0);
        if (this.f382644n != null) goto L14;
        FactoredPagerSnapHelper r104 = new FactoredPagerSnapHelper();
        this.f382644n = r104;
        r104.attachToRecyclerView((RecyclerView) this.mView);
        this.f382644n.f382573a = new b(this);
    L14:
        FactoredPagerSnapHelper r105 = this.f382644n;
        r105.f382575c = r102;
        r105.f382576d = r103;
        return;
    L9:
        if (r102 <= 1.0d) goto L11;
        goto L10
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final void setPanInterceptAncestors(boolean r100) {
        T r101 = this.mView;
        if ((r101 instanceof d) == false) goto L6;
        ((d) r101).getClass();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final void setPanInterceptDescendants(boolean r100) {
        T r101 = this.mView;
        if ((r101 instanceof d) == false) goto L6;
        ((d) r101).f382671k = r100;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final void setPanInterceptSelf(boolean r100) {
        T r101 = this.mView;
        if ((r101 instanceof d) == false) goto L6;
        ((d) r101).f382670j = r100;
        return;
    }

    @LynxProp(defaultBoolean = false, name = "android-preference-consume-gesture")
    public void setPreferenceConsumeGesture(boolean r100) {
        T r101 = this.mView;
        if ((r101 instanceof d) == false) goto L6;
        ((d) r101).f382664d = r100;
        return;
    }

    @LynxProp(defaultInt = 0, name = "preload-buffer-count")
    public void setPreloadBufferCount(f6a.a r100) {
        this.Q = ListEventManager.k(r100, 0);
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setScrollEnable(f6a.a r100) {
        this.f382645o = ListEventManager.j(r100, true);
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setScrollEventThrottle(f6a.a r100) {
        ListEventManager r101 = this.f382638i;
        r101.getClass();
        r101.f382587d = ListEventManager.k(r100, 200);
    }

    @LynxProp(defaultInt = -1, name = "scroll-index")
    public void setScrollIndex(int r100) {
        this.f382647p0 = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setShouldRequestStateRestore(boolean r100) {
        super.setInternalCellAppearNotification(r100);
        UIListAdapter r101 = this.f382632c;
        if (r101 == null) goto L6;
        r101.f382693v = r100;
        r101.f382694w = r100;
        r101.f382695x = r100;
        return;
    }

    @LynxProp(defaultBoolean = false, name = "android-stack-from-end")
    public void setStackFromEnd(boolean r100) {
        this.Y = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setStickyOffset(f6a.a r100) {
        int r101 = (int) i.b(ListEventManager.k(r100, 0), 0.0f);
        ListStickyManager r102 = this.f382649r;
        if (r102 != null) goto L5;
        this.f382652u = r101;
        return;
    L5:
        r102.f382610d = r101;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setTouchScroll(f6a.a r100) {
        T r101 = this.mView;
        if ((r101 instanceof d) == false) goto L6;
        boolean r102 = ListEventManager.j(r100, true);
        ((d) r101).f382663c = r102;
        return;
    }

    @LynxProp(defaultBoolean = false, name = "android-trigger-sticky-layout")
    public void setTriggerStickyLayout(boolean r100) {
        this.f382631J = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setUpdateAnimation(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L6:
        ((RecyclerView) this.mView).setItemAnimator(null);
    L8:
        if (TextUtils.equals(r100, "default") == false) goto L11;
        ((RecyclerView) this.mView).setItemAnimator(new DefaultItemAnimator());
        return;
    L11:
        return;
    L5:
        if (TextUtils.equals(r100, "none") == false) goto L8;
        goto L6
    }

    @LynxProp(defaultBoolean = false, name = "scroll-upper-lower-switch")
    public void setUpperLowerSwitch(boolean r100) {
        this.F = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setUpperThreshold(f6a.a r100) {
        ListEventManager r101 = this.f382638i;
        r101.getClass();
        r101.f382588e = ListEventManager.k(r100, 50);
        r101.f382590g = 0;
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList
    public final void setUpperThresholdItemCount(f6a.a r100) {
        ListEventManager r101 = this.f382638i;
        r101.getClass();
        r101.f382590g = ListEventManager.k(r100, 0);
        r101.f382588e = 0;
    }

    @LynxProp(defaultBoolean = true, name = "vertical-orientation")
    public void setVerticalOrientation(boolean r100) {
        this.f382655x = r100;
    }

    @LynxProp(name = "update-list-info")
    public void updateListActionInfo(ReadableMap r100) {
        this.E = true;
        this.D = r100;
        this.A = null;
        this.Z = true;
    }

    public UIList(LynxContext r100, Object r101) {
        super(r100, r101);
        this.f382633d = 1;
        this.f382634e = 0;
        this.f382635f = 0;
        this.f382636g = "single";
        this.f382637h = true;
        this.f382640k = false;
        this.f382642l = false;
        this.f382645o = true;
        this.f382646p = false;
        this.f382651t = -1;
        this.f382652u = 0;
        this.f382653v = true;
        this.f382654w = false;
        this.f382655x = true;
        this.f382656y = new HashMap();
        this.f382657z = new HashMap();
        this.B = new ArrayList();
        this.C = new HashMap();
        this.F = false;
        this.G = false;
        this.H = 0;
        this.I = true;
        this.f382631J = false;
        this.K = true;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.Q = 0;
        this.R = false;
        this.S = null;
        this.T = 0;
        this.U = 1.0f;
        this.V = null;
        this.W = false;
        this.X = true;
        this.Y = false;
        this.Z = false;
        this.f382641k0 = null;
        this.f382647p0 = -1;
        this.H0 = false;
    }

    @LynxUIMethod
    public void autoScroll(ReadableMap r100, Callback r101) {
        String r102 = r100.getString("rate", "");
        this.G = r100.getBoolean("start", true);
        this.I = r100.getBoolean("autoStop", true);
        if (this.G == false) goto L19;
        int r103 = (int) n.d(r102, 0.0f, 0.0f, this.mContext.getScreenMetrics());
        if (r103 != 0) goto L8;
        r101.invoke(new Object[]{1, "rate is not right"});
        return;
    L8:
        LynxContext r104 = getLynxContext();
        if (r104 != null) goto L11;
        float r105 = 60.0f;
    L12:
        int r106 = (int) r105;
        if (r106 > 0) goto L15;
        r106 = 60;
    L15:
        if (r103 <= 0) goto L17;
        int r107 = Math.max(r103 / r106, 1);
    L18:
        this.H = r107;
        Z();
        this.f382641k0 = new l(this);
        Choreographer.getInstance().postFrameCallback(this.f382641k0);
    L20:
        r101.invoke(new Object[]{0});
        return;
    L17:
        r107 = Math.min(r103 / r106, -1);
        goto L18
    L11:
        r105 = DeviceUtils.c(r104.getContext());
        goto L12
    L19:
        Z();
        goto L20
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final boolean canConsumeGesture(float r100, float r101) {
        if (isEnableNewGesture() == true) goto L6;
        return false;
    L6:
        if (this.f382655x == false) goto L18;
        if (isAtBorder(true) == false) goto L12;
        if (r101 >= 0.0f) goto L12;
        return false;
    L12:
        if (isAtBorder(false) == true) goto L14;
    L15:
        return true;
    L14:
        if (r101 <= 0.0f) goto L15;
        return false;
    L18:
        if (isAtBorder(true) == false) goto L22;
        if (r100 >= 0.0f) goto L22;
        return false;
    L22:
        if (isAtBorder(false) == true) goto L24;
    L25:
        return true;
    L24:
        if (r100 <= 0.0f) goto L25;
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget hitTest(float r100, float r101) {
        return hitTest(r100, r101, false);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean initialPropsFlushed(String r100, String r101) {
        if (this.f382656y == null) goto L10;
        HashSet r102 = (HashSet) ((HashMap) this.f382657z).get(r100);
        if (r102 != null) goto L7;
        return false;
    L7:
        if (r102.contains(r100) == false) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final void onGestureScrollBy(final float r100, final float r101) {
        if (isEnableNewGesture() == true) goto L5;
        return;
    L5:
        UIThreadUtils.runOnUiThreadImmediately(new e7a.h(this, r100, r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v9, types: [android.view.View] */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutFinish(long r100, LynxBaseUI r110) {
        boolean r101 = true;
        if (W() == true) goto L5;
        UIListAdapter r111 = this.f382632c;
        r111.getClass();
        if (r111.f382678g == true) goto L102;
        ListViewHolder r102 = r111.f382673b.remove(Long.valueOf(r100));
        if (r102 == null) goto L103;
        UIComponent r112 = r102.f382620a.f382623b;
        if (r112 == null) goto L87;
        r112.setTop(0);
        r112.setLeft(0);
        r112.requestLayout();
        if (r112.getWidth() == r102.itemView.getWidth()) goto L74;
        boolean r103 = true;
    L76:
        if (r112.getHeight() != r102.itemView.getHeight()) goto L79;
        r101 = false;
    L79:
        if (r103 == true) goto L81;
        if (r101 == true) goto L81;
    L82:
        UIList r104 = r111.f382674c;
        if (r104.O == false) goto L87;
        if (r104.X() == false) goto L87;
        r111.O2(r112);
    L81:
        r102.itemView.requestLayout();
        goto L82
    L74:
        r103 = false;
    L87:
        r102.f382620a.f382622a = 2;
        return;
    L103:
        return;
    L102:
        return;
    L5:
        if ((r110 instanceof UIComponent) == false) goto L62;
        UIListAdapter r105 = this.f382632c;
        UIComponent r113 = (UIComponent) r110;
        ListViewHolder r106 = r105.f382673b.get(Long.valueOf(r100));
        r105.O2(r113);
        if (r106 != null) goto L9;
    L31:
        UIList r107 = r105.f382674c;
        if (r107.P == null) goto L61;
        int r108 = r107.T();
        int r114 = r105.f382674c.U();
        HashMap<String, Integer> r109 = r105.f382692u;
        if (r109 != null) goto L36;
    L60:
        r105.I2(r113);
        return;
    L36:
        if (r109.containsKey(r113.f383173b) == false) goto L60;
        int r115 = r105.f382692u.get(r113.f383173b).intValue();
        if (r108 == (-1)) goto L42;
        if (r115 > r108) goto L42;
        boolean r116 = true;
    L43:
        if (r116 == true) goto L47;
        if (r114 == (-1)) goto L47;
        if (r115 < r114) goto L47;
        boolean r117 = true;
    L48:
        UIList r118 = r105.f382674c;
        int r119 = r118.Q;
        if (r115 >= (r108 - r119)) goto L51;
        return;
    L51:
        if (r115 > (r114 + r119)) goto L93;
        if (r116 == true) goto L54;
        if (r117 == true) goto L58;
        return;
    L58:
        if (r118.P.b(r113.f383173b) == true) goto L97;
        r105.f382674c.P.a(r113, false);
        return;
    L97:
        return;
    L54:
        if (r118.P.b(r113.f383173b) == true) goto L94;
        r105.f382674c.P.a(r113, true);
        return;
    L94:
        return;
    L93:
        return;
    L47:
        r117 = false;
    L42:
        r116 = false;
        goto L43
    L61:
        r105.I2(r113);
        return;
    L9:
        if (r106.f382621b != r100) goto L31;
        r105.f382673b.remove(Long.valueOf(r100));
        if (r105.f382674c.P == null) goto L21;
        if (r106.f382620a.f382623b != r113) goto L24;
        if (r113.getView() == 0) goto L24;
        if (r106.itemView != ((com.lynx.tasm.behavior.ui.view.a) r113.getView()).getParent()) goto L24;
        r105.f382690s.c(r106);
        r106.f382620a.f382622a = 2;
        r106.itemView.requestLayout();
        return;
    L24:
        if (r106.f382620a.f382623b == null) goto L26;
        r105.H2(r106);
    L26:
        if (r113 != null) goto L28;
    L30:
        r106.f382620a.f382622a = 2;
        r106.U3(r113);
        r105.f382690s.c(r106);
        r113.setTop(0);
        r113.setLeft(0);
        r113.requestLayout();
        r105.O2(r113);
        r106.itemView.requestLayout();
        return;
    L28:
        if (((com.lynx.tasm.behavior.ui.view.a) r113.getView()).getParent() == null) goto L30;
        ((ViewGroup) ((com.lynx.tasm.behavior.ui.view.a) r113.getView()).getParent()).removeView(r113.getView());
        goto L30
    L21:
        if (r106.f382620a.f382623b != r113) goto L24;
        r105.f382690s.c(r106);
        r106.f382620a.f382622a = 2;
        r106.itemView.requestLayout();
        return;
    L62:
        LLog.e("UIList", "component is null! the operationId is " + r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final float[] scrollBy(float r100, float r101) {
        float[] r102 = new float[4];
        ((RecyclerView) this.mView).scrollBy((int) r100, (int) r101);
        if (Math.abs(r100) <= Float.MIN_VALUE) goto L5;
    L6:
        recognizeGesturere();
    L8:
        if ((((RecyclerView) this.mView).getLayoutManager() instanceof ListLayoutManager.a) == true) goto L10;
        r102[0] = 0.0f;
        r102[1] = 0.0f;
        r102[2] = r100;
        r102[3] = r101;
    L14:
        return r102;
    L10:
        if (this.f382655x == false) goto L12;
        r102[0] = 0.0f;
        float r103 = ((ListLayoutManager.a) ((RecyclerView) this.mView).getLayoutManager()).g();
        r102[1] = r103;
        r102[2] = r100;
        r102[3] = r101 - r103;
        goto L14
    L12:
        float r104 = ((ListLayoutManager.a) ((RecyclerView) this.mView).getLayoutManager()).f();
        r102[0] = r104;
        r102[1] = 0.0f;
        r102[2] = r100 - r104;
        r102[3] = r101;
        goto L14
    L5:
        if (Math.abs(r101) <= Float.MIN_VALUE) goto L8;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxUIMethod
    public void scrollToPosition(ReadableMap r110, Callback r111) {
        if (this.f382632c != null) goto L6;
        r111.invoke(new Object[]{1, "scrollToPosition before init"});
        return;
    L6:
        int r100 = r110.getInt("index", r110.getInt("position", 0));
        int r101 = (int) i.a(r110.getDouble("offset", AudioStats.AUDIO_AMPLITUDE_NONE));
        boolean r102 = r110.getBoolean("smooth", false);
        int r103 = (int) i.a(r110.getDouble("itemHeight", AudioStats.AUDIO_AMPLITUDE_NONE));
        String r104 = "none";
        String r112 = r110.getString("alignTo", "none");
        if (r100 >= 0) goto L9;
    L39:
        r111.invoke(new Object[]{4, "position < 0 or position >= data count"});
        return;
    L9:
        if (r100 > this.f382632c.getItemCount()) goto L39;
        if (r102 == false) goto L31;
        com.lynx.tasm.behavior.ui.list.b r105 = this.f382639j;
        r105.getClass();
        StringBuilder r106 = new StringBuilder("ListScroller scrollToPositionSmoothly: position=");
        r106.append(r100);
        r106.append(", offset=");
        r106.append(r101);
        r106.append(", alignTo: ");
        if (r112 == null) goto L15;
        r104 = r112;
    L15:
        r106.append(r104);
        LLog.i("UIList", r106.toString());
        com.lynx.tasm.behavior.ui.list.b.a r107 = r105.f382716b;
        RecyclerView r108 = r107.f382717a.get();
        if (r108 != null) goto L18;
    L28:
        r107.f382725i = false;
        r111.invoke(new Object[]{4, "can not scroll before init"});
        return;
    L18:
        if (r108.getLayoutManager() == null) goto L28;
        if (r108.getChildCount() == 0) goto L28;
        if (r108.isAttachedToWindow() == true) goto L25;
        r107.f382725i = false;
        LLog.e("UIList", "ListScroller start: early return due to view is not attached to window.");
        r111.invoke(new Object[]{7, "can not invoke scroll when the view is not attached to window."});
        return;
    L25:
        r107.f382718b = r111;
        r107.f382719c = r100;
        r107.f382720d = r112;
        r107.f382721e = r101;
        r107.f382724h = null;
        if (r107.f382725i == true) goto L42;
        r107.f382725i = true;
        r108.stopScroll();
        r108.stopNestedScroll();
        r108.addOnItemTouchListener(r107.f382727k);
        r108.post(r107);
        return;
    L42:
        return;
    L31:
        if (TextUtils.equals(r112, "middle") == false) goto L34;
        int r113 = (((RecyclerView) getView()).getHeight() - r103) / 2;
    L36:
        r101 = r101 + r113;
    L37:
        this.f382639j.a(r100, r101, r111);
        ((RecyclerView) this.mView).post(new c(this));
        return;
    L34:
        if (TextUtils.equals(r112, "bottom") == false) goto L37;
        r113 = ((RecyclerView) getView()).getHeight() - r103;
        goto L36
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setInitialPropsHasFlushed(String r100, String r101) {
        if (this.f382656y != null) goto L5;
        return;
    L5:
        if (((HashMap) this.f382657z).containsKey(r101) == false) goto L7;
        HashSet r102 = (HashSet) ((HashMap) this.f382657z).get(r101);
    L8:
        r102.add(r100);
        ((HashMap) this.f382656y).put(r101, r102);
        return;
    L7:
        r102 = new HashSet();
        goto L8
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void storeKeyToNativeStorage(String r100, Object r101) {
        Map<String, Object> r102 = this.f382656y;
        if (r102 == null) goto L6;
        ((HashMap) r102).put(r100, r101);
        return;
    }

    @LynxUIMethod
    public void scrollBy(ReadableMap r100, final Callback r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r100 != null) goto L6;
    L10:
        r101.invoke(new Object[]{4, "Invoke scrollBy failed due to index param is null"});
        return;
    L6:
        if (r100.hasKey("offset") == false) goto L10;
        final double r102 = i.a(r100.getDouble("offset", AudioStats.AUDIO_AMPLITUDE_NONE));
        UIThreadUtils.runOnUiThreadImmediately(new e7a.i(this, r102, r101));
    }

    public static /* synthetic */ void O(UIList r100, float r101, float r102) {
        T r103 = r100.mView;
        if (r103 == 0) goto L7;
        ((RecyclerView) r103).scrollBy((int) r101, (int) r102);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget hitTest(float r100, float r101, boolean r102) {
        if (this.f382632c != null) goto L5;
        return this;
    L5:
        ListStickyManager r103 = this.f382649r;
        EventTarget r104 = null;
        if (r103 == null) goto L18;
        int r105 = (int) r100;
        int r106 = (int) r101;
        if (r103.f382612f.f382618a == null) goto L14;
        Rect r107 = new Rect();
        ((com.lynx.tasm.behavior.ui.view.a) r103.f382612f.f382618a.getView()).getHitRect(r107);
        if (r107.contains(r105, r106) == false) goto L14;
        UIComponent r108 = r103.f382612f.f382618a;
        EventTarget r109 = r108.hitTest(r105 - ((com.lynx.tasm.behavior.ui.view.a) r108.getView()).getLeft(), r106 - ((com.lynx.tasm.behavior.ui.view.a) r103.f382612f.f382618a.getView()).getTop(), r102);
    L12:
        r104 = r109;
    L14:
        if (r103.f382613g.f382618a == null) goto L18;
        Rect r110 = new Rect();
        ((com.lynx.tasm.behavior.ui.view.a) r103.f382613g.f382618a.getView()).getHitRect(r110);
        if (r110.contains(r105, r106) == false) goto L18;
        UIComponent r111 = r103.f382613g.f382618a;
        r109 = r111.hitTest(r105 - ((com.lynx.tasm.behavior.ui.view.a) r111.getView()).getLeft(), r106 - ((com.lynx.tasm.behavior.ui.view.a) r103.f382613g.f382618a.getView()).getTop(), r102);
    L18:
        if (r104 == null) goto L20;
        return r104;
    L20:
        int r112 = ((RecyclerView) this.mView).getChildCount() - 1;
    L21:
        if (r112 < 0) goto L33;
        View r113 = ((RecyclerView) this.mView).getChildAt(r112);
        RecyclerView.ViewHolder r114 = ((RecyclerView) this.mView).getChildViewHolder(r113);
        if ((r114 instanceof ListViewHolder) == false) goto L32;
        ListViewHolder r115 = (ListViewHolder) r114;
        if (r115 == null) goto L32;
        UIComponent r116 = r115.f382620a.f382623b;
        if (r116 == null) goto L32;
        if (r116.containsPoint(r100 - r113.getLeft(), r101 - r113.getTop(), r102) == false) goto L32;
        return r116.hitTest(r100 - r113.getLeft(), r101 - r113.getTop(), r102);
    L32:
        r112 = r112 - 1;
        goto L21
    L33:
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean requestChildUIRectangleOnScreen(LynxBaseUI r100, Rect r101, boolean r110) {
        if (this.f382645o == true) goto L5;
    L14:
        return false;
    L5:
        if ((r100 instanceof UIComponent) == false) goto L14;
        UIComponent r102 = (UIComponent) r100;
        if (r102.getView() == 0) goto L14;
        Object r103 = ((com.lynx.tasm.behavior.ui.view.a) r102.getView()).getParent();
        if ((r103 instanceof ListViewHolder.b) == true) goto L12;
        return false;
    L12:
        View r104 = (View) r103;
        return ((RecyclerView) this.mView).getLayoutManager().requestChildRectangleOnScreen((RecyclerView) this.mView, r104, r101, false, false);
    }

    public final void a0(int r100, int r101, int r102, int r103, int r104) {
        boolean r105 = this.f382655x;
        if (r105 == true) goto L6;
        r101 = this.f382638i.f382595l;
    L6:
        if (r105 == false) goto L8;
        r102 = this.f382638i.f382595l;
    L8:
        int r106 = r103 + r101;
        int r107 = r104 + r102;
        if (r101 != r106) goto L11;
        if (r102 != r107) goto L11;
        return;
    L11:
        m7a.a r108 = new m7a.a(getSign(), "snap");
        r108.a("position", Integer.valueOf(r100));
        r108.a("currentScrollLeft", Float.valueOf(i.c(r101)));
        r108.a("currentScrollTop", Float.valueOf(i.c(r102)));
        r108.a("targetScrollLeft", Float.valueOf(i.c(r106)));
        r108.a("targetScrollTop", Float.valueOf(i.c(r107)));
        this.mContext.getEventEmitter().sendCustomEvent(r108);
    }
}
