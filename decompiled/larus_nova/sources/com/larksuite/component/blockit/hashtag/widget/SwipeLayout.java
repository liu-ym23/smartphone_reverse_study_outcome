package com.larksuite.component.blockit.hashtag.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.log.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes24.dex */
public class SwipeLayout extends FrameLayout {
    public static final DragEdge B = null;
    public final GestureDetector A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View.OnClickListener f283059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnLongClickListener f283060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f283061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DragEdge f283062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewDragHelper f283063e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f283064f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashMap<DragEdge, View> f283065g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ShowMode f283066h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f283067i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<j> f283068j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<h> f283069k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<View, ArrayList<g>> f283070l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<View, Boolean> f283071m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<View, Rect> f283072n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f283073o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean[] f283074p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f283075q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f283076r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f283077s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f283078t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f283079u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List<f> f283080v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f283081w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f283082x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f283083y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Rect f283084z;

    public static final enum DragEdge extends Enum<DragEdge> {
        public static final DragEdge Bottom = null;
        public static final DragEdge Left = null;
        public static final DragEdge Right = null;
        public static final DragEdge Top = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DragEdge[] f283085a = null;

        static {
            DragEdge r100 = new DragEdge("Left", 0);
            Left = r100;
            DragEdge r101 = new DragEdge("Top", 1);
            Top = r101;
            DragEdge r102 = new DragEdge("Right", 2);
            Right = r102;
            DragEdge r103 = new DragEdge("Bottom", 3);
            Bottom = r103;
            f283085a = new DragEdge[]{r100, r101, r102, r103};
        }

        public static DragEdge[] values() {
            return (DragEdge[]) f283085a.clone();
        }

        public static DragEdge valueOf(String r100) {
            return (DragEdge) r27.a.a(DragEdge.class, r100);
        }

        public DragEdge(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum ShowMode extends Enum<ShowMode> {
        public static final ShowMode LayDown = null;
        public static final ShowMode PullOut = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ShowMode[] f283086a = null;

        static {
            ShowMode r100 = new ShowMode("LayDown", 0);
            LayDown = r100;
            ShowMode r101 = new ShowMode("PullOut", 1);
            PullOut = r101;
            f283086a = new ShowMode[]{r100, r101};
        }

        public static ShowMode[] values() {
            return (ShowMode[]) f283086a.clone();
        }

        public static ShowMode valueOf(String r100) {
            return (ShowMode) r27.a.a(ShowMode.class, r100);
        }

        public ShowMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum Status extends Enum<Status> {
        public static final Status Close = null;
        public static final Status Middle = null;
        public static final Status Open = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f283087a = null;

        static {
            Status r100 = new Status("Middle", 0);
            Middle = r100;
            Status r101 = new Status("Open", 1);
            Open = r101;
            Status r102 = new Status("Close", 2);
            Close = r102;
            f283087a = new Status[]{r100, r101, r102};
        }

        public static Status[] values() {
            return (Status[]) f283087a.clone();
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public Status(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a extends ViewDragHelper.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f283088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SwipeLayout f283089b;

        public a(SwipeLayout r100) {
            this.f283089b = r100;
            this.f283088a = true;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int getViewHorizontalDragRange(View r100) {
            Log.d("SwipeLayout", "getViewHorizontalDragRange  mDragDistance=" + this.f283089b.f283064f);
            return this.f283089b.f283064f;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int getViewVerticalDragRange(View r100) {
            return this.f283089b.f283064f;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final boolean tryCaptureView(View r100, int r101) {
            boolean r102 = false;
            if (r100 != this.f283089b.getSurfaceView()) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == true) goto L11;
        L14:
            return r103;
        L11:
            if (this.f283089b.getOpenStatus() != Status.Close) goto L13;
            r102 = true;
        L13:
            this.f283088a = r102;
            goto L14
        L5:
            if (this.f283089b.getBottomViews().contains(r100) == true) goto L8;
            r103 = false;
            goto L9
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionHorizontal(View r100, int r101, int r102) {
            if (r100 != this.f283089b.getSurfaceView()) goto L30;
            Log.d("SwipeLayout", "clampViewPositionHorizontal child == getSurfaceView()");
            int r103 = d.f283092a[this.f283089b.f283062d.ordinal()];
            if (r103 == 1) goto L28;
            if (r103 == 2) goto L28;
            if (r103 == 3) goto L19;
            if (r103 != 4) goto L51;
            Log.d("SwipeLayout", "clampViewPositionHorizontal Left: left=" + r101);
            Log.d("SwipeLayout", "clampViewPositionHorizontal Right: getPaddingLeft()=" + this.f283089b.getPaddingLeft());
            Log.d("SwipeLayout", "clampViewPositionHorizontal Right: mDragDistance=" + this.f283089b.f283064f);
            Log.d("SwipeLayout", "clampViewPositionHorizontal Right: getPaddingLeft() - mDragDistance=" + (this.f283089b.getPaddingLeft() - this.f283089b.f283064f));
            if (r101 > this.f283089b.getPaddingLeft()) goto L14;
            int r104 = this.f283089b.getPaddingLeft();
            SwipeLayout r105 = this.f283089b;
            if (r101 >= (r104 - r105.f283064f)) goto L51;
            return r105.getPaddingLeft() - this.f283089b.f283064f;
        L14:
            return this.f283089b.getPaddingLeft();
        L51:
            return r101;
        L19:
            Log.d("SwipeLayout", "clampViewPositionHorizontal Left: left=" + r101);
            Log.d("SwipeLayout", "clampViewPositionHorizontal Left: mDragDistance=" + this.f283089b.f283064f);
            Log.d("SwipeLayout", "clampViewPositionHorizontal Left: getPaddingLeft()=" + this.f283089b.getPaddingLeft());
            if (r101 < this.f283089b.getPaddingLeft()) goto L22;
            int r106 = this.f283089b.getPaddingLeft();
            SwipeLayout r107 = this.f283089b;
            if (r101 <= (r106 + r107.f283064f)) goto L51;
            return r107.getPaddingLeft() + this.f283089b.f283064f;
        L22:
            return this.f283089b.getPaddingLeft();
        L28:
            return this.f283089b.getPaddingLeft();
        L30:
            if (this.f283089b.getCurrentBottomView() != r100) goto L51;
            Log.d("SwipeLayout", "clampViewPositionHorizontal  getCurrentBottomView() == child");
            int r108 = d.f283092a[this.f283089b.f283062d.ordinal()];
            if (r108 == 1) goto L50;
            if (r108 == 2) goto L50;
            if (r108 == 3) goto L43;
            if (r108 != 4) goto L51;
            SwipeLayout r109 = this.f283089b;
            if (r109.f283066h != ShowMode.PullOut) goto L51;
            int r110 = r109.getMeasuredWidth();
            SwipeLayout r111 = this.f283089b;
            if (r101 >= (r110 - r111.f283064f)) goto L51;
            return r111.getMeasuredWidth() - this.f283089b.f283064f;
        L43:
            SwipeLayout r112 = this.f283089b;
            if (r112.f283066h != ShowMode.PullOut) goto L51;
            if (r101 <= r112.getPaddingLeft()) goto L51;
            return this.f283089b.getPaddingLeft();
        L50:
            return this.f283089b.getPaddingLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionVertical(View r100, int r101, int r102) {
            if (r100 != this.f283089b.getSurfaceView()) goto L28;
            int r103 = d.f283092a[this.f283089b.f283062d.ordinal()];
            if (r103 == 1) goto L21;
            if (r103 == 2) goto L12;
            if (r103 == 3) goto L11;
            if (r103 == 4) goto L11;
        L68:
            return r101;
        L11:
            return this.f283089b.getPaddingTop();
        L12:
            int r104 = this.f283089b.getPaddingTop();
            SwipeLayout r105 = this.f283089b;
            if (r101 >= (r104 - r105.f283064f)) goto L17;
            return r105.getPaddingTop() - this.f283089b.f283064f;
        L17:
            if (r101 <= r105.getPaddingTop()) goto L68;
            return this.f283089b.getPaddingTop();
        L21:
            if (r101 < this.f283089b.getPaddingTop()) goto L23;
            int r106 = this.f283089b.getPaddingTop();
            SwipeLayout r107 = this.f283089b;
            if (r101 <= (r106 + r107.f283064f)) goto L68;
            return r107.getPaddingTop() + this.f283089b.f283064f;
        L23:
            return this.f283089b.getPaddingTop();
        L28:
            View r108 = this.f283089b.getSurfaceView();
            if (r108 != null) goto L31;
            int r109 = 0;
        L32:
            int r110 = d.f283092a[this.f283089b.f283062d.ordinal()];
            if (r110 == 1) goto L54;
            if (r110 == 2) goto L40;
            if (r110 == 3) goto L39;
            if (r110 != 4) goto L68;
        L39:
            return this.f283089b.getPaddingTop();
        L40:
            SwipeLayout r111 = this.f283089b;
            if (r111.f283066h != ShowMode.PullOut) goto L46;
            int r112 = r111.getMeasuredHeight();
            SwipeLayout r113 = this.f283089b;
            if (r101 >= (r112 - r113.f283064f)) goto L68;
            return r113.getMeasuredHeight() - this.f283089b.f283064f;
        L46:
            int r114 = r109 + r102;
            if (r114 >= r111.getPaddingTop()) goto L49;
            int r115 = this.f283089b.getPaddingTop();
            SwipeLayout r116 = this.f283089b;
            if (r114 > (r115 - r116.f283064f)) goto L68;
            return r116.getPaddingTop() - this.f283089b.f283064f;
        L49:
            return this.f283089b.getPaddingTop();
        L54:
            SwipeLayout r117 = this.f283089b;
            if (r117.f283066h == ShowMode.PullOut) goto L57;
            int r118 = r109 + r102;
            if (r118 < r117.getPaddingTop()) goto L63;
            int r119 = this.f283089b.getPaddingTop();
            SwipeLayout r120 = this.f283089b;
            if (r118 <= (r119 + r120.f283064f)) goto L68;
            return r120.getPaddingTop() + this.f283089b.f283064f;
        L63:
            return this.f283089b.getPaddingTop();
        L57:
            if (r101 <= r117.getPaddingTop()) goto L68;
            return this.f283089b.getPaddingTop();
        L31:
            r109 = r108.getTop();
            goto L32
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewReleased(View r100, float r101, float r102) {
            super.onViewReleased(r100, r101, r102);
            SwipeLayout r103 = this.f283089b;
            boolean r104 = this.f283088a;
            float r105 = r103.f283063e.getMinVelocity();
            View r106 = r103.getSurfaceView();
            DragEdge r107 = r103.f283062d;
            if (r107 == null) goto L57;
            if (r106 == null) goto L57;
            if (r104 == false) goto L8;
            float r108 = r103.f283077s;
        L10:
            if (r107 != DragEdge.Left) goto L22;
            if (r101 <= r105) goto L15;
            r103.i(true, true);
            goto L57
        L15:
            if (r101 >= (-r105)) goto L18;
            r103.b(true, true);
            goto L57
        L18:
            if (((r103.getSurfaceView().getLeft() * 1.0f) / r103.f283064f) <= r108) goto L20;
            r103.i(true, true);
            goto L57
        L20:
            r103.b(true, true);
            goto L57
        L22:
            if (r107 != DragEdge.Right) goto L34;
            if (r101 <= r105) goto L27;
            r103.b(true, true);
            goto L57
        L27:
            if (r101 >= (-r105)) goto L30;
            r103.i(true, true);
            goto L57
        L30:
            if ((((-r103.getSurfaceView().getLeft()) * 1.0f) / r103.f283064f) <= r108) goto L32;
            r103.i(true, true);
            goto L57
        L32:
            r103.b(true, true);
            goto L57
        L34:
            if (r107 != DragEdge.Top) goto L46;
            if (r102 <= r105) goto L39;
            r103.i(true, true);
            goto L57
        L39:
            if (r102 >= (-r105)) goto L42;
            r103.b(true, true);
            goto L57
        L42:
            if (((r103.getSurfaceView().getTop() * 1.0f) / r103.f283064f) <= r108) goto L44;
            r103.i(true, true);
            goto L57
        L44:
            r103.b(true, true);
            goto L57
        L46:
            if (r107 != DragEdge.Bottom) goto L57;
            if (r102 <= r105) goto L51;
            r103.b(true, true);
            goto L57
        L51:
            if (r102 >= (-r105)) goto L54;
            r103.i(true, true);
            goto L57
        L54:
            if ((((-r103.getSurfaceView().getTop()) * 1.0f) / r103.f283064f) <= r108) goto L56;
            r103.i(true, true);
            goto L57
        L56:
            r103.b(true, true);
            goto L57
        L8:
            r108 = r103.f283076r;
        L57:
            Iterator r109 = ((ArrayList) this.f283089b.f283068j).iterator();
        L59:
            if (r109.hasNext() == false) goto L61;
            ((j) r109.next()).b();
            goto L59
        L61:
            this.f283089b.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewPositionChanged(View r110, int r111, int r112, int r210, int r211) {
            View r100 = this.f283089b.getSurfaceView();
            if (r100 != null) goto L5;
            return;
        L5:
            View r101 = this.f283089b.getCurrentBottomView();
            int r102 = r100.getLeft();
            int r103 = r100.getRight();
            int r104 = r100.getTop();
            int r105 = r100.getBottom();
            if (r110 != r100) goto L18;
            SwipeLayout r106 = this.f283089b;
            if (r106.f283066h != ShowMode.PullOut) goto L59;
            if (r101 == null) goto L59;
            DragEdge r107 = r106.f283062d;
            if (r107 != DragEdge.Left) goto L13;
        L16:
            r101.offsetLeftAndRight(r210);
            goto L59
        L13:
            if (r107 == DragEdge.Right) goto L16;
            r101.offsetTopAndBottom(r211);
        L59:
            this.f283089b.e(r102, r104, r103, r105);
            this.f283089b.f(r102, r104, r210, r211);
            this.f283089b.invalidate();
            SwipeLayout r108 = this.f283089b;
            if (r108.f283079u == false) goto L75;
            View r109 = r108.getCurrentBottomView();
            if (r108.getOpenStatus() != Status.Close) goto L65;
            ((HashMap) r108.f283072n).remove(r109);
            return;
        L65:
            int r113 = 0;
            View[] r114 = {r108.getSurfaceView(), r109};
        L66:
            if (r113 >= 2) goto L76;
            View r115 = r114[r113];
            Rect r116 = (Rect) ((HashMap) r108.f283072n).get(r115);
            if (r116 != null) goto L70;
            r116 = new Rect();
            ((HashMap) r108.f283072n).put(r115, r116);
        L70:
            r116.left = r115.getLeft();
            r116.top = r115.getTop();
            r116.right = r115.getRight();
            r116.bottom = r115.getBottom();
            r113 = r113 + 1;
            goto L66
        L76:
            return;
        L75:
            return;
        L18:
            if (this.f283089b.getBottomViews().contains(r110) == false) goto L59;
            SwipeLayout r117 = this.f283089b;
            if (r117.f283066h != ShowMode.PullOut) goto L22;
            r100.offsetLeftAndRight(r210);
            r100.offsetTopAndBottom(r211);
            goto L59
        L22:
            DragEdge r118 = r117.f283062d;
            int r119 = r117.getPaddingLeft();
            int r120 = r117.getPaddingTop();
            DragEdge r121 = DragEdge.Right;
            if (r118 != r121) goto L26;
            r119 = r117.getMeasuredWidth() - r117.f283064f;
        L28:
            DragEdge r122 = DragEdge.Left;
            if (r118 == r122) goto L33;
            if (r118 == r121) goto L33;
            int r123 = r117.getMeasuredWidth() + r119;
            int r124 = r117.f283064f;
        L34:
            Log.d("SwipeLayout", "computeBottomLayDown bl=" + r119 + ";br=" + r123);
            Rect r125 = new Rect(r119, r120, r123, r124 + r120);
            if (r101 == null) goto L37;
            r101.layout(r125.left, r125.top, r125.right, r125.bottom);
        L37:
            int r126 = r100.getLeft() + r210;
            int r127 = r100.getTop() + r211;
            SwipeLayout r128 = this.f283089b;
            if (r128.f283062d == r122) goto L40;
        L42:
            SwipeLayout r129 = this.f283089b;
            if (r129.f283062d == r121) goto L45;
        L47:
            SwipeLayout r130 = this.f283089b;
            if (r130.f283062d == DragEdge.Top) goto L50;
        L52:
            SwipeLayout r131 = this.f283089b;
            if (r131.f283062d == DragEdge.Bottom) goto L55;
        L57:
            r100.layout(r126, r127, this.f283089b.getMeasuredWidth() + r126, this.f283089b.getMeasuredHeight() + r127);
            goto L59
        L55:
            if (r127 <= r131.getPaddingTop()) goto L57;
            r127 = this.f283089b.getPaddingTop();
            goto L57
        L50:
            if (r127 >= r130.getPaddingTop()) goto L52;
            r127 = this.f283089b.getPaddingTop();
            goto L57
        L45:
            if (r126 <= r129.getPaddingLeft()) goto L47;
            r126 = this.f283089b.getPaddingLeft();
            goto L57
        L40:
            if (r126 >= r128.getPaddingLeft()) goto L42;
            r126 = this.f283089b.getPaddingLeft();
        L33:
            r123 = r117.f283064f + r119;
            r124 = r117.getMeasuredHeight();
            goto L34
        L26:
            if (r118 != DragEdge.Bottom) goto L28;
            r120 = r117.getMeasuredHeight() - r117.f283064f;
            goto L28
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeLayout f283090a;

        public b(SwipeLayout r100) {
            this.f283090a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SwipeLayout r101 = this.f283090a;
            DragEdge r102 = SwipeLayout.B;
            if (r101.getOpenStatus() != Status.Close) goto L13;
            ViewParent r103 = r101.getParent();
            if ((r103 instanceof AdapterView) == false) goto L11;
            AdapterView r104 = (AdapterView) r103;
            int r105 = r104.getPositionForView(r101);
            if (r105 == (-1)) goto L12;
            r104.performItemClick(r104.getChildAt(r105 - r104.getFirstVisiblePosition()), r105, r104.getAdapter().getItemId(r105));
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public class c implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeLayout f283091a;

        public c(SwipeLayout r100) {
            this.f283091a = r100;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r110) {
            SwipeLayout r100 = this.f283091a;
            DragEdge r111 = SwipeLayout.B;
            if (r100.getOpenStatus() != Status.Close) goto L20;
            ViewParent r112 = r100.getParent();
            if ((r112 instanceof AdapterView) == false) goto L20;
            AdapterView<?> r113 = (AdapterView) r112;
            int r101 = r113.getPositionForView(r100);
            if (r101 == (-1)) goto L20;
            long r102 = r113.getItemIdAtPosition(r101);
            Method r103 = AbsListView.class.getDeclaredMethod("performLongPress", new Class[]{View.class, Integer.TYPE, Long.TYPE});     // Catch: Exception -> L13
            r103.setAccessible(true);     // Catch: Exception -> L13
            ((Boolean) r103.invoke(r113, new Object[]{r100, Integer.valueOf(r101), Long.valueOf(r102)})).booleanValue();     // Catch: Exception -> L13
        L13:
            e = move-exception;
            e.printStackTrace();
            if (r113.getOnItemLongClickListener() == null) goto L17;
            boolean r104 = r113.getOnItemLongClickListener().onItemLongClick(r113, r100, r101, r102);
        L18:
            if (r104 == false) goto L20;
            r113.performHapticFeedback(0);
            goto L20
        L17:
            r104 = false;
        L20:
            return true;
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f283092a = null;

        static {
            int[] r100 = new int[DragEdge.values().length];
            f283092a = r100;
            r100[DragEdge.Top.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f283092a[DragEdge.Bottom.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f283092a[DragEdge.Left.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f283092a[DragEdge.Right.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public interface e {
    }

    public interface f {
        void a(SwipeLayout r100);
    }

    public interface g {
        void a();
    }

    public interface h {
        boolean a();
    }

    public class i extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeLayout f283093a;

        public i(SwipeLayout r100) {
            this.f283093a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r100) {
            SwipeLayout r101 = this.f283093a;
            DragEdge r102 = SwipeLayout.B;
            r101.getClass();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            SwipeLayout r101 = this.f283093a;
            if (r101.f283075q == false) goto L8;
            if (r101.h(r100) == false) goto L8;
            this.f283093a.b(true, true);
        L8:
            return super.onSingleTapUp(r100);
        }
    }

    public interface j {
        void a();

        void b();

        void c(SwipeLayout r100);

        void d(SwipeLayout r100);

        void onClose();

        void onUpdate(int r100);
    }

    public void setOnDoubleClickListener(e r100) {
    }

    static {
        B = DragEdge.Right;
    }

    private float getCurrentOffset() {
        DragEdge r100 = this.f283062d;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return this.f283067i[r100.ordinal()];
    }

    public List<View> getBottomViews() {
        ArrayList r100 = new ArrayList();
        DragEdge[] r101 = DragEdge.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        DragEdge r104 = r101[r103];
        r100.add(this.f283065g.get(r104));
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    public List<DragEdge> getDragEdges() {
        return new ArrayList(this.f283065g.keySet());
    }

    private AdapterView getAdapterView() {
        ViewParent r100 = getParent();
        if ((r100 instanceof AdapterView) == true) goto L5;
        return null;
    L5:
        return (AdapterView) r100;
    }

    @Override // android.view.View
    public final void computeScroll() {
        super.computeScroll();
        if (this.f283063e.continueSettling(true) == false) goto L6;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    public View getCurrentBottomView() {
        List<View> r100 = getBottomViews();
        if (this.f283062d.ordinal() < r100.size()) goto L5;
        return null;
    L5:
        return (View) ListProtector.get(r100, this.f283062d.ordinal());
    }

    public Status getOpenStatus() {
        View r100 = getSurfaceView();
        if (r100 == null) goto L5;
        int r101 = r100.getLeft();
        int r102 = r100.getTop();
        if (r101 != getPaddingLeft()) goto L13;
        if (r102 != getPaddingTop()) goto L13;
        return Status.Close;
    L13:
        if (r101 == (getPaddingLeft() - this.f283064f)) goto L24;
        if (r101 == (getPaddingLeft() + this.f283064f)) goto L24;
        if (r102 == (getPaddingTop() - this.f283064f)) goto L24;
        if (r102 == (getPaddingTop() + this.f283064f)) goto L24;
        return Status.Middle;
    L24:
        return Status.Open;
    L5:
        return Status.Close;
    }

    public View getSurfaceView() {
        if (getChildCount() != 0) goto L7;
        return null;
    L7:
        return getChildAt(getChildCount() - 1);
    }

    public final void j() {
        Status r100 = getOpenStatus();
        List<View> r101 = getBottomViews();
        if (r100 != Status.Close) goto L12;
        Iterator<View> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L27;
        View r103 = r102.next();
        if (r103 == null) goto L6;
        if (r103.getVisibility() == 4) goto L6;
        r103.setVisibility(4);
        goto L6
    L27:
        return;
    L12:
        View r104 = getCurrentBottomView();
        if (r104 != null) goto L15;
        return;
    L15:
        if (r104.getVisibility() == 0) goto L26;
        r104.setVisibility(0);
        return;
    }

    public final void k() {
        View r100 = getCurrentBottomView();
        if (r100 == null) goto L12;
        DragEdge r101 = this.f283062d;
        if (r101 != DragEdge.Left) goto L7;
    L10:
        this.f283064f = r100.getMeasuredWidth() - g(getCurrentOffset());
    L11:
        Log.d("SwipeLayout", "mDragDistance = " + this.f283064f);
        goto L12
    L7:
        if (r101 == DragEdge.Right) goto L10;
        this.f283064f = r100.getMeasuredHeight() - g(getCurrentOffset());
    L12:
        ShowMode r102 = this.f283066h;
        ShowMode r103 = ShowMode.PullOut;
        Rect r104 = null;
        if (r102 != r103) goto L29;
        View r105 = getSurfaceView();
        if (this.f283079u == false) goto L17;
        Rect r106 = (Rect) ((HashMap) this.f283072n).get(r105);
    L18:
        if (r106 != null) goto L20;
        r106 = d(false);
    L20:
        if (r105 == null) goto L22;
        r105.layout(r106.left, r106.top, r106.right, r106.bottom);
        bringChildToFront(r105);
    L22:
        View r107 = getCurrentBottomView();
        if (this.f283079u == false) goto L25;
        r104 = (Rect) ((HashMap) this.f283072n).get(r107);
    L25:
        if (r104 != null) goto L27;
        r104 = c(r103, r106);
    L27:
        if (r107 == null) goto L49;
        r107.layout(r104.left, r104.top, r104.right, r104.bottom);
    L49:
        j();
        return;
    L17:
        r106 = null;
        goto L18
    L29:
        ShowMode r108 = ShowMode.LayDown;
        if (r102 != r108) goto L49;
        View r109 = getSurfaceView();
        if (this.f283079u == false) goto L34;
        Rect r110 = (Rect) ((HashMap) this.f283072n).get(r109);
    L35:
        if (r110 != null) goto L37;
        r110 = d(false);
    L37:
        if (r109 != null) goto L39;
    L42:
        View r111 = getCurrentBottomView();
        if (this.f283079u == false) goto L45;
        r104 = (Rect) ((HashMap) this.f283072n).get(r111);
    L45:
        if (r104 != null) goto L47;
        r104 = c(r108, r110);
    L47:
        if (r111 == null) goto L49;
        r111.layout(r104.left, r104.top, r104.right, r104.bottom);
        Log.d("SwipeLayout", "currentBottomView  bottomViewRect.left= " + r104.left + ";bottomViewRect.right=" + r104.right);
        goto L49
    L39:
        if (r110.left >= 0) goto L41;
        r110.left = 0;
        r110.right = getMeasuredWidth() + 0;
    L41:
        r109.layout(r110.left, r110.top, r110.right, r110.bottom);
        bringChildToFront(r109);
        Log.d("SwipeLayout", "surfaceView  surfaceRect.left= " + r110.left + ";surfaceRect.right=" + r110.right);
        goto L42
    L34:
        r110 = null;
        goto L35
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getAdapterView() == null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        return;
    L8:
        if (this.f283059a != null) goto L11;
        setOnClickListener(new b(this));
    L11:
        if (this.f283060b != null) goto L15;
        setOnLongClickListener(new c(this));
        return;
    L15:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public int getDragDistance() {
        return this.f283064f;
    }

    public DragEdge getDragEdge() {
        return this.f283062d;
    }

    public Map<DragEdge, View> getDragEdgeMap() {
        return this.f283065g;
    }

    public ShowMode getShowMode() {
        return this.f283066h;
    }

    public float getWillOpenPercentAfterClose() {
        return this.f283077s;
    }

    public float getWillOpenPercentAfterOpen() {
        return this.f283076r;
    }

    public SwipeLayout(Context r100) {
        this(r100, null);
    }

    private void setCurrentDragEdge(DragEdge r100) {
        this.f283062d = r100;
        k();
    }

    public final void a(MotionEvent r110) {
        if (this.f283081w == false) goto L5;
        return;
    L5:
        Status r100 = getOpenStatus();
        Status r101 = Status.Middle;
        if (r100 != r101) goto L9;
        this.f283081w = true;
        return;
    L9:
        Status r102 = getOpenStatus();
        float r103 = r110.getRawX() - this.f283082x;
        float r111 = r110.getRawY() - this.f283083y;
        float r104 = (float) Math.toDegrees(Math.atan(Math.abs(r111 / r103)));
        Log.d("SwipeLayout", "checkCanDrag  angle =" + r104);
        Status r105 = getOpenStatus();
        Status r106 = Status.Close;
        boolean r107 = false;
        if (r105 != r106) goto L72;
        if (r104 >= 45.0f) goto L43;
        if (r103 <= 0.0f) goto L28;
        LinkedHashMap<DragEdge, View> r108 = this.f283065g;
        DragEdge r112 = DragEdge.Left;
        View r109 = r108.get(r112);
        if (r109 != null) goto L18;
    L24:
        boolean r113 = false;
    L25:
        if (r113 == false) goto L28;
    L69:
        setCurrentDragEdge(r112);
        goto L72
    L18:
        if (r109.getParent() != this) goto L24;
        if (r109 == getSurfaceView()) goto L24;
        if (this.f283074p[r112.ordinal()] == false) goto L24;
        r113 = true;
    L28:
        if (r103 >= 0.0f) goto L41;
        LinkedHashMap<DragEdge, View> r114 = this.f283065g;
        r112 = DragEdge.Right;
        View r115 = r114.get(r112);
        if (r115 != null) goto L32;
    L38:
        boolean r116 = false;
    L39:
        if (r116 == true) goto L69;
        return;
    L32:
        if (r115.getParent() != this) goto L38;
        if (r115 == getSurfaceView()) goto L38;
        if (this.f283074p[r112.ordinal()] == false) goto L38;
        r116 = true;
        goto L39
    L41:
        return;
    L43:
        if (r111 <= 0.0f) goto L57;
        LinkedHashMap<DragEdge, View> r117 = this.f283065g;
        r112 = DragEdge.Top;
        View r118 = r117.get(r112);
        if (r118 != null) goto L47;
    L53:
        boolean r119 = false;
    L54:
        if (r119 == false) goto L57;
    L47:
        if (r118.getParent() != this) goto L53;
        if (r118 == getSurfaceView()) goto L53;
        if (this.f283074p[r112.ordinal()] == false) goto L53;
        r119 = true;
    L57:
        if (r111 >= 0.0f) goto L70;
        LinkedHashMap<DragEdge, View> r120 = this.f283065g;
        r112 = DragEdge.Bottom;
        View r121 = r120.get(r112);
        if (r121 != null) goto L61;
    L67:
        boolean r122 = false;
    L68:
        if (r122 == true) goto L69;
        return;
    L61:
        if (r121.getParent() != this) goto L67;
        if (r121 == getSurfaceView()) goto L67;
        if (this.f283074p[r112.ordinal()] == false) goto L67;
        r122 = true;
        goto L68
    L70:
        return;
    L72:
        if (this.f283062d == DragEdge.Right) goto L74;
    L92:
        boolean r123 = false;
    L94:
        if (this.f283062d == DragEdge.Left) goto L96;
    L114:
        DragEdge r124 = this.f283062d;
        if (r124 != DragEdge.Top) goto L135;
        if (r102 == Status.Open) goto L119;
    L120:
        if (r102 == r106) goto L122;
    L124:
        boolean r125 = false;
    L125:
        if (r125 == true) goto L129;
        if (r102 == r101) goto L129;
        boolean r126 = false;
    L131:
        if (r104 < 60.0f) goto L133;
        if (r126 == true) goto L135;
    L133:
        r123 = true;
    L129:
        r126 = true;
        goto L131
    L122:
        if (r111 <= this.f283061c) goto L124;
    L123:
        r125 = true;
        goto L125
    L119:
        if (r111 < (-this.f283061c)) goto L123;
    L135:
        if (r124 == DragEdge.Bottom) goto L137;
    L152:
        this.f283081w = !r123;
        Log.d("SwipeLayout", "checkCanDrag  mIsBeingDragged= " + this.f283081w);
        return;
    L137:
        if (r102 == Status.Open) goto L139;
    L140:
        if (r102 == r106) goto L142;
    L144:
        boolean r127 = false;
    L145:
        if (r127 == true) goto L147;
        if (r102 == r101) goto L147;
    L149:
        if (r104 < 60.0f) goto L151;
        if (r107 == true) goto L152;
    L151:
        r123 = true;
    L147:
        r107 = true;
        goto L149
    L142:
        if (r111 >= (-this.f283061c)) goto L144;
    L143:
        r127 = true;
        goto L145
    L139:
        if (r111 > this.f283061c) goto L143;
    L96:
        if (r102 == Status.Open) goto L98;
    L99:
        if (r102 == r106) goto L101;
    L103:
        boolean r128 = false;
    L104:
        Log.d("SwipeLayout", "checkCanDrag  mCurrentDragEdge == DragEdge.Left suitable1 =" + r128);
        if (r128 == true) goto L109;
        if (r102 == r101) goto L109;
        boolean r129 = false;
    L110:
        Log.d("SwipeLayout", "checkCanDrag  mCurrentDragEdge == DragEdge.Left suitable2 =" + r129);
        if (r104 > 30.0f) goto L113;
        if (r129 == true) goto L114;
    L113:
        Log.d("SwipeLayout", "checkCanDrag  mCurrentDragEdge == DragEdge.Left doNothing = true");
        r123 = true;
    L109:
        r129 = true;
        goto L110
    L101:
        if (r103 <= this.f283061c) goto L103;
    L102:
        r128 = true;
        goto L104
    L98:
        if (r103 < (-this.f283061c)) goto L102;
    L74:
        if (r102 == Status.Open) goto L76;
    L77:
        if (r102 == r106) goto L79;
    L81:
        boolean r130 = false;
    L82:
        Log.d("SwipeLayout", "checkCanDrag  mCurrentDragEdge == DragEdge.Right suitable1 =" + r130);
        if (r130 == true) goto L87;
        if (r102 == r101) goto L87;
        boolean r131 = false;
    L88:
        Log.d("SwipeLayout", "checkCanDrag  mCurrentDragEdge == DragEdge.Right suitable2 =" + r131);
        if (r104 > 30.0f) goto L91;
        if (r131 == true) goto L92;
    L91:
        Log.d("SwipeLayout", "checkCanDrag  mCurrentDragEdge == DragEdge.Right doNothing = true");
        r123 = true;
    L87:
        r131 = true;
        goto L88
    L79:
        if (r103 >= (-this.f283061c)) goto L81;
    L80:
        r130 = true;
        goto L82
    L76:
        if (r103 > this.f283061c) goto L80;
        goto L77
    }

    public final Rect d(boolean r100) {
        int r101 = getPaddingLeft();
        int r102 = getPaddingTop();
        if (r100 == false) goto L14;
        DragEdge r103 = this.f283062d;
        if (r103 != DragEdge.Left) goto L8;
        r101 = this.f283064f + getPaddingLeft();
        goto L14
    L8:
        if (r103 != DragEdge.Right) goto L11;
        r101 = getPaddingLeft() - this.f283064f;
        goto L14
    L11:
        if (r103 != DragEdge.Top) goto L13;
        r102 = this.f283064f + getPaddingTop();
        goto L14
    L13:
        r102 = getPaddingTop() - this.f283064f;
    L14:
        Log.d("SwipeLayout", "computeSurfaceLayoutArea l=" + r101 + ";l + getMeasuredWidth()=" + (getMeasuredWidth() + r101));
        return new Rect(r101, r102, getMeasuredWidth() + r101, getMeasuredHeight() + r102);
    }

    public final int g(float r100) {
        Resources r101 = getContext().getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public final boolean h(MotionEvent r100) {
        View r101 = getSurfaceView();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (this.f283084z != null) goto L9;
        this.f283084z = new Rect();
    L9:
        r101.getHitRect(this.f283084z);
        return this.f283084z.contains((int) r100.getX(), (int) r100.getY());
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f283073o == true) goto L6;
        return false;
    L6:
        if (this.f283075q == true) goto L8;
    L12:
        Iterator r101 = ((ArrayList) this.f283069k).iterator();
    L14:
        if (r101.hasNext() == false) goto L20;
        h r102 = (h) r101.next();
        if (r102 == null) goto L14;
        if (r102.a() == false) goto L14;
        return false;
    L20:
        Log.d("SwipeLayout", "onInterceptTouchEvent ev.getAction() =" + r100.getAction());
        int r103 = r100.getAction();
        if (r103 == 0) goto L39;
        if (r103 != 1) goto L24;
    L38:
        this.f283081w = false;
        this.f283063e.processTouchEvent(r100);
    L44:
        return this.f283081w;
    L24:
        if (r103 != 2) goto L26;
        Log.d("SwipeLayout", "onInterceptTouchEvent MotionEvent.ACTION_MOVE  mIsBeingDragged= " + this.f283081w);
        boolean r104 = this.f283081w;
        Log.d("SwipeLayout", "onInterceptTouchEvent MotionEvent.ACTION_MOVE  beforeCheck=" + r104);
        a(r100);
        if (this.f283081w == false) goto L33;
        ViewParent r105 = getParent();
        if (r105 == null) goto L33;
        r105.requestDisallowInterceptTouchEvent(true);
    L33:
        if (r104 == true) goto L44;
        if (this.f283081w == false) goto L44;
        Log.d("SwipeLayout", "onInterceptTouchEvent MotionEvent.ACTION_MOVE  return false");
        return false;
    L26:
        if (r103 == 3) goto L38;
        this.f283063e.processTouchEvent(r100);
        goto L44
    L39:
        this.f283063e.processTouchEvent(r100);
        this.f283081w = false;
        this.f283082x = r100.getRawX();
        this.f283083y = r100.getRawY();
        if (getOpenStatus() != Status.Middle) goto L42;
        this.f283081w = true;
    L42:
        Log.d("SwipeLayout", "onInterceptTouchEvent MotionEvent.ACTION_DOWN  mIsBeingDragged= " + this.f283081w);
        goto L44
    L8:
        if (getOpenStatus() != Status.Open) goto L12;
        if (h(r100) == false) goto L12;
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f283073o == false) goto L5;
        int r101 = r100.getActionMasked();
        this.A.onTouchEvent(r100);
        if (r101 == 0) goto L18;
        if (r101 != 1) goto L10;
    L17:
        this.f283081w = false;
        this.f283063e.processTouchEvent(r100);
    L20:
        if (super.onTouchEvent(r100) == false) goto L22;
    L24:
        return true;
    L22:
        if (this.f283081w == true) goto L24;
        if (r101 == 0) goto L24;
        return false;
    L10:
        if (r101 != 2) goto L12;
        a(r100);
        if (this.f283081w == false) goto L20;
        Log.d("SwipeLayout", "onTouchEvent getParent().requestDisallowInterceptTouchEvent(true);");
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f283063e.processTouchEvent(r100);
        goto L20
    L12:
        if (r101 == 3) goto L17;
        this.f283063e.processTouchEvent(r100);
        goto L20
    L18:
        this.f283063e.processTouchEvent(r100);
        this.f283082x = r100.getRawX();
        this.f283083y = r100.getRawY();
        goto L20
    L5:
        return super.onTouchEvent(r100);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View r100) {
        Iterator r101 = new HashMap(this.f283065g).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Map.Entry r102 = (Map.Entry) r101.next();
        if (r102.getValue() != r100) goto L4;
        this.f283065g.remove(r102.getKey());
        goto L4
    }

    public void setBottomSwipeEnabled(boolean r100) {
        this.f283074p[DragEdge.Bottom.ordinal()] = r100;
    }

    public void setClickToClose(boolean r100) {
        this.f283075q = r100;
    }

    public void setDragDistance(int r100) {
        if (r100 >= 0) goto L4;
        r100 = 0;
    L4:
        this.f283064f = g(r100);
        requestLayout();
    }

    public void setDragEdge(DragEdge r100) {
        this.f283065g.clear();
        if (getChildCount() < 2) goto L5;
        this.f283065g.put(r100, getChildAt(getChildCount() - 2));
    L5:
        setCurrentDragEdge(r100);
    }

    public void setDragEdges(List<DragEdge> r100) {
        this.f283065g.clear();
        int r101 = Math.min(r100.size(), getChildCount() - 1);
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L6;
        this.f283065g.put((DragEdge) ListProtector.get(r100, r102), getChildAt(r102));
        r102 = r102 + 1;
        goto L3
    L6:
        if (r100.size() != 0) goto L8;
    L11:
        setCurrentDragEdge(B);
        return;
    L8:
        if (r100.contains(B) == true) goto L11;
        setCurrentDragEdge((DragEdge) ListProtector.get(r100, 0));
    }

    public void setIsUseBoundCache(boolean r100) {
        this.f283079u = r100;
    }

    public void setLeftSwipeEnabled(boolean r100) {
        this.f283074p[DragEdge.Left.ordinal()] = r100;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        super.setOnClickListener(r100);
        this.f283059a = r100;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r100) {
        super.setOnLongClickListener(r100);
        this.f283060b = r100;
    }

    public void setRightSwipeEnabled(boolean r100) {
        this.f283074p[DragEdge.Right.ordinal()] = r100;
    }

    public void setShowMode(ShowMode r100) {
        this.f283066h = r100;
        requestLayout();
    }

    public void setSwipeEnabled(boolean r100) {
        this.f283073o = r100;
    }

    public void setTopSwipeEnabled(boolean r100) {
        this.f283074p[DragEdge.Top.ordinal()] = r100;
    }

    public void setWillOpenPercentAfterClose(float r100) {
        this.f283077s = r100;
    }

    public void setWillOpenPercentAfterOpen(float r100) {
        this.f283076r = r100;
    }

    public void setDragEdges(DragEdge... r100) {
        this.f283065g.clear();
        setDragEdges(Arrays.asList(r100));
    }

    public SwipeLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void b(boolean r100, boolean r101) {
        View r102 = getSurfaceView();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        this.f283063e.smoothSlideViewTo(getSurfaceView(), getPaddingLeft(), getPaddingTop());
    L11:
        invalidate();
        return;
    L7:
        Rect r103 = d(false);
        int r104 = r103.left - r102.getLeft();
        int r105 = r103.top - r102.getTop();
        r102.layout(r103.left, r103.top, r103.right, r103.bottom);
        if (r101 == false) goto L10;
        e(r103.left, r103.top, r103.right, r103.bottom);
        f(r103.left, r103.top, r104, r105);
        goto L11
    L10:
        j();
        goto L11
    }

    public final Rect c(ShowMode r100, Rect r101) {
        View r102 = getCurrentBottomView();
        int r103 = r101.left;
        int r104 = r101.top;
        int r105 = r101.right;
        int r106 = r101.bottom;
        if (r100 != ShowMode.PullOut) goto L28;
        DragEdge r107 = this.f283062d;
        DragEdge r108 = DragEdge.Left;
        if (r107 != r108) goto L8;
        r103 = r103 - this.f283064f;
    L14:
        int r109 = 0;
        if (r107 != r108) goto L17;
    L23:
        if (r102 == null) goto L26;
        r109 = r102.getMeasuredWidth();
    L26:
        r105 = r109 + r103;
    L39:
        Log.d("SwipeLayout", "computeBottomLayoutAreaViaSurface bl=" + r103 + ";br=" + r105);
        return new Rect(r103, r104, r105, r106);
    L17:
        if (r107 == DragEdge.Right) goto L23;
        if (r102 == null) goto L22;
        r109 = r102.getMeasuredHeight();
    L22:
        r106 = r104 + r109;
        r105 = r101.right;
        goto L39
    L8:
        if (r107 != DragEdge.Right) goto L11;
        r103 = r105;
        goto L14
    L11:
        if (r107 != DragEdge.Top) goto L13;
        r104 = r104 - this.f283064f;
        goto L14
    L13:
        r104 = r106;
        goto L14
    L28:
        if (r100 != ShowMode.LayDown) goto L39;
        DragEdge r110 = this.f283062d;
        if (r110 != DragEdge.Left) goto L33;
        r105 = r103 + this.f283064f;
        goto L39
    L33:
        if (r110 != DragEdge.Right) goto L36;
        r103 = r105 - this.f283064f;
        goto L39
    L36:
        if (r110 != DragEdge.Top) goto L38;
        r106 = r104 + this.f283064f;
        goto L39
    L38:
        r104 = r106 - this.f283064f;
        goto L39
    }

    public final void i(boolean r100, boolean r110) {
        View r101 = getSurfaceView();
        View r102 = getCurrentBottomView();
        if (r101 != null) goto L5;
        return;
    L5:
        Rect r103 = d(true);
        if (r100 == false) goto L8;
        this.f283063e.smoothSlideViewTo(r101, r103.left, r103.top);
    L16:
        invalidate();
        return;
    L8:
        int r104 = r103.left - r101.getLeft();
        int r105 = r103.top - r101.getTop();
        r101.layout(r103.left, r103.top, r103.right, r103.bottom);
        ShowMode r106 = getShowMode();
        ShowMode r107 = ShowMode.PullOut;
        if (r106 != r107) goto L13;
        Rect r108 = c(r107, r103);
        if (r102 == null) goto L13;
        r102.layout(r108.left, r108.top, r108.right, r108.bottom);
    L13:
        if (r110 == false) goto L15;
        e(r103.left, r103.top, r103.right, r103.bottom);
        f(r103.left, r103.top, r104, r105);
        goto L16
    L15:
        j();
        goto L16
    }

    public SwipeLayout(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.f283062d = B;
        this.f283064f = 0;
        LinkedHashMap<DragEdge, View> r100 = new LinkedHashMap();
        this.f283065g = r100;
        float[] r101 = new float[4];
        this.f283067i = r101;
        this.f283068j = new ArrayList();
        this.f283069k = new ArrayList();
        this.f283070l = new HashMap();
        this.f283071m = new HashMap();
        this.f283072n = new HashMap();
        this.f283073o = true;
        this.f283074p = new boolean[]{true, true, true, true};
        this.f283075q = false;
        this.f283076r = 0.75f;
        this.f283077s = 0.25f;
        this.f283078t = 0;
        this.f283079u = true;
        a r102 = new a(this);
        this.f283082x = -1.0f;
        this.f283083y = -1.0f;
        this.A = new GestureDetector(getContext(), new i(this));
        this.f283063e = ViewDragHelper.create(this, r102);
        this.f283061c = ViewConfiguration.get(r110).getScaledTouchSlop();
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.bottomEdgeSwipeOffset, R.attr.clickToClose, R.attr.drag_edge, R.attr.leftEdgeSwipeOffset, R.attr.rightEdgeSwipeOffset, R.attr.show_mode, R.attr.topEdgeSwipeOffset});
        int r103 = r113.getInt(2, 2);
        DragEdge r104 = DragEdge.Left;
        r101[r104.ordinal()] = r113.getDimension(3, 0.0f);
        DragEdge r105 = DragEdge.Right;
        r101[r105.ordinal()] = r113.getDimension(4, 0.0f);
        DragEdge r106 = DragEdge.Top;
        r101[r106.ordinal()] = r113.getDimension(6, 0.0f);
        DragEdge r107 = DragEdge.Bottom;
        r101[r107.ordinal()] = r113.getDimension(0, 0.0f);
        setClickToClose(r113.getBoolean(1, this.f283075q));
        if ((r103 & 1) != 1) goto L6;
        r100.put(r104, null);
    L6:
        if ((r103 & 4) != 4) goto L9;
        r100.put(r106, null);
    L9:
        if ((r103 & 2) != 2) goto L12;
        r100.put(r105, null);
    L12:
        if ((r103 & 8) != 8) goto L14;
        r100.put(r107, null);
    L14:
        int r114 = r113.getInt(5, ShowMode.PullOut.ordinal());
        this.f283066h = ShowMode.values()[r114];
        r113.recycle();
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        if (r100 != null) goto L32;
        return;
    L32:
        int r103 = ((Integer) r102.getClass().getField(GXTemplateKey.GAIAX_LAYER_GRAVITY).get(r102)).intValue();     // Catch: Exception -> L6
    L8:
        if (r103 <= 0) goto L21;
        int r104 = GravityCompat.getAbsoluteGravity(r103, ViewCompat.getLayoutDirection(this));
        if ((r104 & 3) != 3) goto L13;
        this.f283065g.put(DragEdge.Left, r100);
    L13:
        if ((r104 & 5) != 5) goto L16;
        this.f283065g.put(DragEdge.Right, r100);
    L16:
        if ((r104 & 48) != 48) goto L19;
        this.f283065g.put(DragEdge.Top, r100);
    L19:
        if ((r104 & 80) != 80) goto L28;
        this.f283065g.put(DragEdge.Bottom, r100);
    L28:
        if (r100.getParent() != this) goto L30;
        return;
    L30:
        super.addView(r100, r101, r102);
        return;
    L21:
        Iterator<Map.Entry<DragEdge, View>> r105 = this.f283065g.entrySet().iterator();
    L23:
        if (r105.hasNext() == false) goto L28;
        Map.Entry<DragEdge, View> r106 = r105.next();
        if (r106.getValue() != null) goto L23;
        this.f283065g.put(r106.getKey(), r100);
    L6:
        e = move-exception;
        e.printStackTrace();
        r103 = 0;
        goto L8
    }

    public final void e(int r110, int r111, int r210, int r211) {
        if (((HashMap) this.f283070l).isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r100 = ((HashMap) this.f283070l).entrySet().iterator();
    L7:
        if (r100.hasNext() == false) goto L163;
        Map.Entry r101 = (Map.Entry) r100.next();
        View r102 = (View) r101.getKey();
        Rect r103 = new Rect(r102.getLeft(), r102.getTop(), 0, 0);
        View r104 = r102;
    L10:
        if (r104.getParent() == null) goto L17;
        if (r104 == getRootView()) goto L17;
        r104 = (View) r104.getParent();
        if (r104 == this) goto L17;
        r103.left += r104.getLeft();
        r103.top += r104.getTop();
    L17:
        r103.right = r103.left + r102.getMeasuredWidth();
        int r105 = r103.top + r102.getMeasuredHeight();
        r103.bottom = r105;
        DragEdge r112 = this.f283062d;
        int r113 = r103.left;
        int r114 = r103.right;
        int r115 = r103.top;
        ShowMode r116 = getShowMode();
        ShowMode r117 = ShowMode.LayDown;
        Iterator r118 = r100;
        boolean r106 = true;
        if (r116 != r117) goto L41;
        int r119 = d.f283092a[r112.ordinal()];
        if (r119 != 1) goto L22;
        if (r111 < r115) goto L71;
        if (r111 >= r105) goto L71;
    L72:
        if (r106 == false) goto L113;
        ((HashMap) this.f283071m).put(r102, Boolean.FALSE);
        float r107 = 0.0f;
        if (getShowMode() != r117) goto L91;
        int r108 = d.f283092a[this.f283062d.ordinal()];
        if (r108 != 1) goto L78;
        float r109 = r103.top - r111;
        int r120 = r102.getHeight();
    L88:
        r107 = r109 / r120;
    L106:
        Iterator r121 = ((ArrayList) r101.getValue()).iterator();
    L108:
        if (r121.hasNext() == false) goto L113;
        g r122 = (g) r121.next();
        Math.abs(r107);
        r122.a();
        if (Math.abs(r107) != 1.0f) goto L108;
        ((HashMap) this.f283071m).put(r102, Boolean.TRUE);
        goto L108
    L78:
        if (r108 != 2) goto L80;
        r109 = r103.bottom - r211;
        r120 = r102.getHeight();
        goto L88
    L80:
        if (r108 != 3) goto L82;
        r109 = r103.left - r110;
        r120 = r102.getWidth();
        goto L88
    L82:
        if (r108 != 4) goto L106;
        r109 = r103.right - r210;
        r120 = r102.getWidth();
        goto L88
    L91:
        if (getShowMode() != ShowMode.PullOut) goto L106;
        int r123 = d.f283092a[this.f283062d.ordinal()];
        if (r123 != 1) goto L95;
        float r124 = r103.bottom - getPaddingTop();
        int r125 = r102.getHeight();
    L105:
        r107 = r124 / r125;
        goto L106
    L95:
        if (r123 != 2) goto L97;
        r124 = r103.top - getHeight();
        r125 = r102.getHeight();
        goto L105
    L97:
        if (r123 != 3) goto L99;
        r124 = r103.right - getPaddingLeft();
        r125 = r102.getWidth();
        goto L105
    L99:
        if (r123 != 4) goto L106;
        r124 = r103.left - getWidth();
        r125 = r102.getWidth();
    L113:
        DragEdge r126 = this.f283062d;
        if (((Boolean) ((HashMap) this.f283071m).get(r102)).booleanValue() == true) goto L150;
        int r127 = r103.left;
        int r128 = r103.right;
        int r129 = r103.top;
        int r130 = r103.bottom;
        if (getShowMode() != ShowMode.LayDown) goto L132;
        if (r126 != DragEdge.Right) goto L122;
        if (r210 > r127) goto L122;
    L149:
        boolean r131 = true;
    L151:
        if (r131 == false) goto L162;
        ((HashMap) this.f283071m).put(r102, Boolean.TRUE);
        Iterator r132 = ((ArrayList) r101.getValue()).iterator();
    L154:
        if (r132.hasNext() == false) goto L162;
        g r133 = (g) r132.next();
        DragEdge r134 = this.f283062d;
        if (r134 == DragEdge.Left) goto L161;
        if (r134 == DragEdge.Right) goto L161;
        r102.getHeight();
        r133.a();
    L161:
        r102.getWidth();
        r133.a();
    L162:
        r100 = r118;
    L122:
        if (r126 != DragEdge.Left) goto L125;
        if (r110 >= r128) goto L149;
    L125:
        if (r126 != DragEdge.Top) goto L128;
        if (r111 >= r130) goto L149;
    L128:
        if (r126 != DragEdge.Bottom) goto L150;
        if (r211 > r129) goto L150;
    L132:
        if (getShowMode() != ShowMode.PullOut) goto L150;
        if (r126 != DragEdge.Right) goto L138;
        if (r128 <= getWidth()) goto L149;
    L138:
        if (r126 != DragEdge.Left) goto L142;
        if (r127 >= getPaddingLeft()) goto L149;
    L142:
        if (r126 != DragEdge.Top) goto L146;
        if (r129 >= getPaddingTop()) goto L149;
    L146:
        if (r126 != DragEdge.Bottom) goto L150;
        if (r130 <= getHeight()) goto L149;
    L150:
        r131 = false;
    L71:
        r106 = false;
        goto L72
    L22:
        if (r119 != 2) goto L24;
        if (r211 <= r115) goto L71;
        if (r211 > r105) goto L71;
    L24:
        if (r119 != 3) goto L26;
        if (r110 >= r114) goto L71;
        if (r110 < r113) goto L71;
    L26:
        if (r119 != 4) goto L71;
        if (r210 <= r113) goto L71;
        if (r210 > r114) goto L71;
    L41:
        if (getShowMode() != ShowMode.PullOut) goto L71;
        int r135 = d.f283092a[r112.ordinal()];
        if (r135 == 1) goto L67;
        if (r135 == 2) goto L62;
        if (r135 == 3) goto L57;
        if (r135 != 4) goto L71;
        if (r113 > getWidth()) goto L71;
        if (r114 <= getWidth()) goto L71;
    L70:
        r106 = true;
        goto L72
    L57:
        if (r114 < getPaddingLeft()) goto L71;
        if (r113 >= getPaddingLeft()) goto L71;
    L62:
        if (r115 >= getHeight()) goto L71;
        if (r115 < getPaddingTop()) goto L71;
    L67:
        if (r115 >= getPaddingTop()) goto L71;
        if (r105 < getPaddingTop()) goto L71;
    }

    public final void f(int r100, int r101, int r102, int r103) {
        DragEdge r104 = getDragEdge();
        if (r104 != DragEdge.Left) goto L7;
        if (r102 < 0) goto L17;
    L18:
        boolean r105 = true;
    L19:
        j();
        Status r106 = getOpenStatus();
        if (((ArrayList) this.f283068j).isEmpty() == true) goto L54;
        this.f283078t++;
        Iterator r107 = ((ArrayList) this.f283068j).iterator();
    L23:
        if (r107.hasNext() == false) goto L31;
        j r108 = (j) r107.next();
        if (this.f283078t != 1) goto L29;
        if (r105 == false) goto L28;
        r108.d(this);
        goto L29
    L28:
        r108.a();
    L29:
        int r109 = r100 - getPaddingLeft();
        getPaddingTop();
        r108.onUpdate(r109);
        goto L23
    L31:
        if (r106 != Status.Close) goto L38;
        Iterator r110 = ((ArrayList) this.f283068j).iterator();
    L34:
        if (r110.hasNext() == false) goto L36;
        ((j) r110.next()).onClose();
        goto L34
    L36:
        this.f283078t = 0;
    L38:
        if (r106 != Status.Open) goto L55;
        View r111 = getCurrentBottomView();
        if (r111 == null) goto L42;
        r111.setEnabled(true);
    L42:
        Iterator r112 = ((ArrayList) this.f283068j).iterator();
    L44:
        if (r112.hasNext() == false) goto L46;
        ((j) r112.next()).c(this);
        goto L44
    L46:
        this.f283078t = 0;
        return;
    L55:
        return;
    L54:
        return;
    L17:
        r105 = false;
        goto L19
    L7:
        if (r104 != DragEdge.Right) goto L11;
        if (r102 <= 0) goto L18;
    L11:
        if (r104 != DragEdge.Top) goto L15;
        if (r103 >= 0) goto L18;
    L15:
        if (r104 != DragEdge.Bottom) goto L18;
        if (r103 <= 0) goto L18;
        goto L17
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        k();
        if (this.f283080v == null) goto L8;
        int r105 = 0;
    L6:
        if (r105 >= ((ArrayList) this.f283080v).size()) goto L10;
        ((f) ListProtector.get(this.f283080v, r105)).a(this);
        r105 = r105 + 1;
        goto L6
    L10:
        return;
    }
}
