package com.obric.oui.swipeaction;

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
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.layout.OUIFrameLayout;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class OSwipeLayout extends OUIFrameLayout {
    public static final DragEdge N = null;
    public float A;
    public float B;
    public int C;
    public boolean D;
    public int E;
    public boolean F;
    public boolean G;
    public float H;
    public float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public View.OnClickListener f403089J;
    public View.OnLongClickListener K;
    public Rect L;
    public final GestureDetector M;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f403090h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DragEdge f403091i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewDragHelper f403092j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f403093k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f403094l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedHashMap<DragEdge, View> f403095m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ShowMode f403096n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float[] f403097o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<j> f403098p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<h> f403099q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Map<View, ArrayList<f>> f403100r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<View, Boolean> f403101s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Map<View, Rect> f403102t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f403103u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean[] f403104v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f403105w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f403106x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f403107y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f403108z;

    public static final enum DragEdge extends Enum<DragEdge> {
        public static final DragEdge Bottom = null;
        public static final DragEdge Left = null;
        public static final DragEdge Right = null;
        public static final DragEdge Top = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DragEdge[] f403109a = null;

        static {
            DragEdge r100 = new DragEdge("Left", 0);
            Left = r100;
            DragEdge r101 = new DragEdge("Top", 1);
            Top = r101;
            DragEdge r102 = new DragEdge("Right", 2);
            Right = r102;
            DragEdge r103 = new DragEdge("Bottom", 3);
            Bottom = r103;
            f403109a = new DragEdge[]{r100, r101, r102, r103};
        }

        public static DragEdge[] values() {
            return (DragEdge[]) f403109a.clone();
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
        public static final /* synthetic */ ShowMode[] f403110a = null;

        static {
            ShowMode r100 = new ShowMode("LayDown", 0);
            LayDown = r100;
            ShowMode r101 = new ShowMode("PullOut", 1);
            PullOut = r101;
            f403110a = new ShowMode[]{r100, r101};
        }

        public static ShowMode[] values() {
            return (ShowMode[]) f403110a.clone();
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
        public static final /* synthetic */ Status[] f403111a = null;

        static {
            Status r100 = new Status("Middle", 0);
            Middle = r100;
            Status r101 = new Status("Open", 1);
            Open = r101;
            Status r102 = new Status("Close", 2);
            Close = r102;
            f403111a = new Status[]{r100, r101, r102};
        }

        public static Status[] values() {
            return (Status[]) f403111a.clone();
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
        public boolean f403112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OSwipeLayout f403113b;

        public a(OSwipeLayout r100) {
            this.f403113b = r100;
            this.f403112a = true;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int getViewHorizontalDragRange(View r100) {
            OSwipeLayout r101 = this.f403113b;
            int r102 = r101.C;
            if (r102 <= 0) goto L7;
            return (int) ((r102 * r101.B) * 2.0f);
        L7:
            return r101.f403094l;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int getViewVerticalDragRange(View r100) {
            return this.f403113b.f403094l;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final boolean tryCaptureView(View r100, int r101) {
            boolean r102 = false;
            if (r100 != this.f403113b.getSurfaceView()) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == true) goto L11;
        L14:
            return r103;
        L11:
            if (this.f403113b.getOpenStatus() != Status.Close) goto L13;
            r102 = true;
        L13:
            this.f403112a = r102;
            this.f403113b.f403093k = r100.getLeft();
            goto L14
        L5:
            if (this.f403113b.getBottomViews().contains(r100) == true) goto L8;
            r103 = false;
            goto L9
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionHorizontal(View r100, int r101, int r102) {
            if (r100 != this.f403113b.getSurfaceView()) goto L45;
            int r103 = d.f403116a[this.f403113b.f403091i.ordinal()];
            if (r103 == 1) goto L43;
            if (r103 == 2) goto L43;
            if (r103 == 3) goto L35;
            if (r103 == 4) goto L11;
        L66:
            return r101;
        L11:
            if (r101 > this.f403113b.getPaddingLeft()) goto L13;
            OSwipeLayout r104 = this.f403113b;
            int r105 = r104.C;
            if (r105 > 0) goto L18;
            r105 = r104.f403094l;
        L18:
            int r106 = r104.getPaddingLeft() - r105;
            OSwipeLayout r107 = this.f403113b;
            if (r107.f403108z == false) goto L32;
            int r108 = r107.getPaddingLeft();
            float r109 = r105;
            OSwipeLayout r110 = this.f403113b;
            int r111 = r108 - ((int) (r110.A * r109));
            int r112 = r110.getPaddingLeft();
            OSwipeLayout r113 = this.f403113b;
            int r114 = r112 - ((int) (r109 * r113.B));
            if (r113.f403092j.getViewDragState() != 1) goto L28;
            OSwipeLayout r115 = this.f403113b;
            float r116 = r115.f403093k + r102;
            r115.f403093k = r116;
            float r117 = r111;
            if (r116 >= r117) goto L27;
            int r118 = oma.a.f524314a;
            return (int) oma.a.C7071a.a(r117, r114, r100.getLeft(), this.f403113b.f403093k);
        L27:
            return (int) r116;
        L28:
            if (r101 >= r111) goto L31;
            int r119 = oma.a.f524314a;
            return (int) oma.a.C7071a.a(r111, r114, r100.getLeft(), r101);
        L31:
            return r101;
        L32:
            if (r101 >= r106) goto L66;
            return r106;
        L13:
            return this.f403113b.getPaddingLeft();
        L35:
            if (r101 < this.f403113b.getPaddingLeft()) goto L37;
            int r120 = this.f403113b.getPaddingLeft();
            OSwipeLayout r121 = this.f403113b;
            if (r101 <= (r120 + r121.f403094l)) goto L66;
            return r121.getPaddingLeft() + this.f403113b.f403094l;
        L37:
            return this.f403113b.getPaddingLeft();
        L43:
            return this.f403113b.getPaddingLeft();
        L45:
            if (this.f403113b.getCurrentBottomView() != r100) goto L66;
            int r122 = d.f403116a[this.f403113b.f403091i.ordinal()];
            if (r122 == 1) goto L65;
            if (r122 == 2) goto L65;
            if (r122 == 3) goto L58;
            if (r122 != 4) goto L66;
            OSwipeLayout r123 = this.f403113b;
            if (r123.f403096n != ShowMode.PullOut) goto L66;
            int r124 = r123.getMeasuredWidth();
            OSwipeLayout r125 = this.f403113b;
            if (r101 >= (r124 - r125.f403094l)) goto L66;
            return r125.getMeasuredWidth() - this.f403113b.f403094l;
        L58:
            OSwipeLayout r126 = this.f403113b;
            if (r126.f403096n != ShowMode.PullOut) goto L66;
            if (r101 <= r126.getPaddingLeft()) goto L66;
            return this.f403113b.getPaddingLeft();
        L65:
            return this.f403113b.getPaddingLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionVertical(View r100, int r101, int r102) {
            if (r100 != this.f403113b.getSurfaceView()) goto L28;
            int r103 = d.f403116a[this.f403113b.f403091i.ordinal()];
            if (r103 == 1) goto L21;
            if (r103 == 2) goto L12;
            if (r103 == 3) goto L11;
            if (r103 == 4) goto L11;
        L68:
            return r101;
        L11:
            return this.f403113b.getPaddingTop();
        L12:
            int r104 = this.f403113b.getPaddingTop();
            OSwipeLayout r105 = this.f403113b;
            if (r101 >= (r104 - r105.f403094l)) goto L17;
            return r105.getPaddingTop() - this.f403113b.f403094l;
        L17:
            if (r101 <= r105.getPaddingTop()) goto L68;
            return this.f403113b.getPaddingTop();
        L21:
            if (r101 < this.f403113b.getPaddingTop()) goto L23;
            int r106 = this.f403113b.getPaddingTop();
            OSwipeLayout r107 = this.f403113b;
            if (r101 <= (r106 + r107.f403094l)) goto L68;
            return r107.getPaddingTop() + this.f403113b.f403094l;
        L23:
            return this.f403113b.getPaddingTop();
        L28:
            View r108 = this.f403113b.getSurfaceView();
            if (r108 != null) goto L31;
            int r109 = 0;
        L32:
            int r110 = d.f403116a[this.f403113b.f403091i.ordinal()];
            if (r110 == 1) goto L54;
            if (r110 == 2) goto L40;
            if (r110 == 3) goto L39;
            if (r110 != 4) goto L68;
        L39:
            return this.f403113b.getPaddingTop();
        L40:
            OSwipeLayout r111 = this.f403113b;
            if (r111.f403096n != ShowMode.PullOut) goto L46;
            int r112 = r111.getMeasuredHeight();
            OSwipeLayout r113 = this.f403113b;
            if (r101 >= (r112 - r113.f403094l)) goto L68;
            return r113.getMeasuredHeight() - this.f403113b.f403094l;
        L46:
            int r114 = r109 + r102;
            if (r114 >= r111.getPaddingTop()) goto L49;
            int r115 = this.f403113b.getPaddingTop();
            OSwipeLayout r116 = this.f403113b;
            if (r114 > (r115 - r116.f403094l)) goto L68;
            return r116.getPaddingTop() - this.f403113b.f403094l;
        L49:
            return this.f403113b.getPaddingTop();
        L54:
            OSwipeLayout r117 = this.f403113b;
            if (r117.f403096n == ShowMode.PullOut) goto L57;
            int r118 = r109 + r102;
            if (r118 < r117.getPaddingTop()) goto L63;
            int r119 = this.f403113b.getPaddingTop();
            OSwipeLayout r120 = this.f403113b;
            if (r118 <= (r119 + r120.f403094l)) goto L68;
            return r120.getPaddingTop() + this.f403113b.f403094l;
        L63:
            return this.f403113b.getPaddingTop();
        L57:
            if (r101 <= r117.getPaddingTop()) goto L68;
            return this.f403113b.getPaddingTop();
        L31:
            r109 = r108.getTop();
            goto L32
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewReleased(View r100, float r101, float r102) {
            super.onViewReleased(r100, r101, r102);
            OSwipeLayout r103 = this.f403113b;
            if (r103.f403108z == true) goto L5;
        L15:
            OSwipeLayout r104 = this.f403113b;
            boolean r105 = this.f403112a;
            float r106 = r104.f403092j.getMinVelocity();
            View r107 = r104.getSurfaceView();
            DragEdge r108 = r104.f403091i;
            if (r108 == null) goto L75;
            if (r107 == null) goto L75;
            if (r104.f403108z == true) goto L22;
        L24:
            if (r105 == false) goto L26;
            float r109 = r104.f403107y;
        L28:
            if (r108 != DragEdge.Left) goto L40;
            if (r101 <= r106) goto L33;
            r104.n();
            goto L75
        L33:
            if (r101 >= (-r106)) goto L36;
            r104.g(true);
            goto L75
        L36:
            if (((r104.getSurfaceView().getLeft() * 1.0f) / r104.f403094l) <= r109) goto L38;
            r104.n();
            goto L75
        L38:
            r104.g(true);
            goto L75
        L40:
            if (r108 != DragEdge.Right) goto L52;
            if (r101 <= r106) goto L45;
            r104.g(true);
            goto L75
        L45:
            if (r101 >= (-r106)) goto L48;
            r104.n();
            goto L75
        L48:
            if ((((-r104.getSurfaceView().getLeft()) * 1.0f) / r104.f403094l) <= r109) goto L50;
            r104.n();
            goto L75
        L50:
            r104.g(true);
            goto L75
        L52:
            if (r108 != DragEdge.Top) goto L64;
            if (r102 <= r106) goto L57;
            r104.n();
            goto L75
        L57:
            if (r102 >= (-r106)) goto L60;
            r104.g(true);
            goto L75
        L60:
            if (((r104.getSurfaceView().getTop() * 1.0f) / r104.f403094l) <= r109) goto L62;
            r104.n();
            goto L75
        L62:
            r104.g(true);
            goto L75
        L64:
            if (r108 != DragEdge.Bottom) goto L75;
            if (r102 <= r106) goto L69;
            r104.g(true);
            goto L75
        L69:
            if (r102 >= (-r106)) goto L72;
            r104.n();
            goto L75
        L72:
            if ((((-r104.getSurfaceView().getTop()) * 1.0f) / r104.f403094l) <= r109) goto L74;
            r104.n();
            goto L75
        L74:
            r104.g(true);
            goto L75
        L26:
            r109 = r104.f403106x;
            goto L28
        L22:
            if (r104.D == false) goto L24;
        L75:
            Iterator r110 = ((ArrayList) this.f403113b.f403098p).iterator();
        L77:
            if (r110.hasNext() == false) goto L79;
            ((j) r110.next()).b();
            goto L77
        L79:
            this.f403113b.invalidate();
            return;
        L5:
            if (r103.f403091i != DragEdge.Right) goto L15;
            int r111 = r103.C;
            if (r111 > 0) goto L10;
            r111 = r103.f403094l;
        L10:
            int r112 = r103.getPaddingLeft();
            OSwipeLayout r113 = this.f403113b;
            int r114 = r112 - ((int) (r111 * r113.A));
            View r115 = r113.getSurfaceView();
            if (r115 == null) goto L15;
            if (r115.getLeft() >= r114) goto L15;
            this.f403113b.getClass();
            goto L15
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewPositionChanged(View r110, int r111, int r112, int r113, int r114) {
            View r115 = this.f403113b.getSurfaceView();
            if (r115 != null) goto L5;
            return;
        L5:
            View r116 = this.f403113b.getCurrentBottomView();
            int r100 = r115.getLeft();
            int r101 = r115.getRight();
            int r102 = r115.getTop();
            int r103 = r115.getBottom();
            if (r110 != r115) goto L18;
            OSwipeLayout r117 = this.f403113b;
            if (r117.f403096n != ShowMode.PullOut) goto L58;
            if (r116 == null) goto L58;
            DragEdge r118 = r117.f403091i;
            if (r118 != DragEdge.Left) goto L13;
        L16:
            r116.offsetLeftAndRight(r113);
            goto L58
        L13:
            if (r118 == DragEdge.Right) goto L16;
            r116.offsetTopAndBottom(r114);
        L58:
            this.f403113b.j(r100, r102, r101, r103);
            this.f403113b.k(r100, r102, r113, r114);
            OSwipeLayout r119 = this.f403113b;
            if (r119.f403108z == true) goto L61;
        L67:
            this.f403113b.invalidate();
            OSwipeLayout r120 = this.f403113b;
            View r121 = r120.getCurrentBottomView();
            View r122 = r120.getSurfaceView();
            if (r120.getOpenStatus() != Status.Close) goto L70;
            ((HashMap) r120.f403102t).remove(r121);
            ((HashMap) r120.f403102t).remove(r122);
            return;
        L70:
            int r104 = 0;
            View[] r123 = {r122, r121};
        L71:
            if (r104 >= 2) goto L80;
            View r124 = r123[r104];
            Rect r125 = (Rect) ((HashMap) r120.f403102t).get(r124);
            if (r125 != null) goto L75;
            r125 = new Rect();
            ((HashMap) r120.f403102t).put(r124, r125);
        L75:
            r125.left = r124.getLeft();
            r125.top = r124.getTop();
            r125.right = r124.getRight();
            r125.bottom = r124.getBottom();
            r104 = r104 + 1;
            goto L71
        L80:
            return;
        L61:
            if (r119.f403091i != DragEdge.Right) goto L67;
            if (r119.C > 0) goto L66;
            int r126 = r119.f403094l;
        L66:
            r119.getPaddingLeft();
            OSwipeLayout r127 = this.f403113b;
            float r128 = r127.A;
            r127.getClass();
            goto L67
        L18:
            if (this.f403113b.getBottomViews().contains(r110) == false) goto L58;
            OSwipeLayout r129 = this.f403113b;
            if (r129.f403096n != ShowMode.PullOut) goto L22;
            r115.offsetLeftAndRight(r113);
            r115.offsetTopAndBottom(r114);
            goto L58
        L22:
            DragEdge r105 = r129.f403091i;
            int r106 = r129.getPaddingLeft();
            int r107 = r129.getPaddingTop();
            DragEdge r108 = DragEdge.Right;
            if (r105 != r108) goto L26;
            r106 = r129.getMeasuredWidth() - r129.f403094l;
        L28:
            DragEdge r109 = DragEdge.Left;
            if (r105 == r109) goto L33;
            if (r105 == r108) goto L33;
            int r130 = r129.getMeasuredWidth() + r106;
            int r131 = r129.f403094l;
        L34:
            Rect r132 = new Rect(r106, r107, r130, r131 + r107);
            if (r116 == null) goto L37;
            r116.layout(r132.left, r132.top, r132.right, r132.bottom);
        L37:
            int r133 = r115.getLeft() + r113;
            int r134 = r115.getTop() + r114;
            OSwipeLayout r135 = this.f403113b;
            if (r135.f403091i == r109) goto L40;
        L42:
            OSwipeLayout r136 = this.f403113b;
            if (r136.f403091i == r108) goto L45;
        L47:
            OSwipeLayout r137 = this.f403113b;
            if (r137.f403091i == DragEdge.Top) goto L50;
        L52:
            OSwipeLayout r138 = this.f403113b;
            if (r138.f403091i == DragEdge.Bottom) goto L55;
        L57:
            r115.layout(r133, r134, this.f403113b.getMeasuredWidth() + r133, this.f403113b.getMeasuredHeight() + r134);
            goto L58
        L55:
            if (r134 <= r138.getPaddingTop()) goto L57;
            r134 = this.f403113b.getPaddingTop();
            goto L57
        L50:
            if (r134 >= r137.getPaddingTop()) goto L52;
            r134 = this.f403113b.getPaddingTop();
            goto L57
        L45:
            if (r133 <= r136.getPaddingLeft()) goto L47;
            r133 = this.f403113b.getPaddingLeft();
            goto L57
        L40:
            if (r133 >= r135.getPaddingLeft()) goto L42;
            r133 = this.f403113b.getPaddingLeft();
        L33:
            r130 = r129.f403094l + r106;
            r131 = r129.getMeasuredHeight();
            goto L34
        L26:
            if (r105 != DragEdge.Bottom) goto L28;
            r107 = r129.getMeasuredHeight() - r129.f403094l;
            goto L28
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OSwipeLayout f403114a;

        public b(OSwipeLayout r100) {
            this.f403114a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            OSwipeLayout.d(this.f403114a);
        }
    }

    public class c implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OSwipeLayout f403115a;

        public c(OSwipeLayout r100) {
            this.f403115a = r100;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            OSwipeLayout.e(this.f403115a);
            return true;
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f403116a = null;

        static {
            int[] r100 = new int[DragEdge.values().length];
            f403116a = r100;
            r100[DragEdge.Top.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f403116a[DragEdge.Bottom.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f403116a[DragEdge.Left.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f403116a[DragEdge.Right.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public interface e {
    }

    public interface f {
        void a();
    }

    public interface g {
    }

    public interface h {
        boolean a();
    }

    public class i extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OSwipeLayout f403117a;

        public i(OSwipeLayout r100) {
            this.f403117a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r100) {
            OSwipeLayout r101 = this.f403117a;
            DragEdge r102 = OSwipeLayout.N;
            r101.getClass();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            OSwipeLayout r101 = this.f403117a;
            if (r101.f403105w == false) goto L8;
            if (r101.m(r100) == false) goto L8;
            this.f403117a.g(true);
        L8:
            return super.onSingleTapUp(r100);
        }
    }

    public interface j {
        void a();

        void b();

        void c(OSwipeLayout r100);

        void onClose();

        void onOpen();

        void onUpdate(int r100);
    }

    public void setOnDoubleClickListener(e r100) {
    }

    public void setQuickDeleteListener(g r100) {
    }

    static {
        N = DragEdge.Right;
    }

    private float getCurrentOffset() {
        DragEdge r100 = this.f403091i;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return this.f403097o[r100.ordinal()];
    }

    public List<View> getBottomViews() {
        ArrayList r100 = new ArrayList();
        DragEdge[] r101 = DragEdge.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        DragEdge r104 = r101[r103];
        r100.add(this.f403095m.get(r104));
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    public List<DragEdge> getDragEdges() {
        return new ArrayList(this.f403095m.keySet());
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
        if (this.f403092j.continueSettling(true) == false) goto L6;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    public View getCurrentBottomView() {
        List<View> r100 = getBottomViews();
        if (this.f403091i.ordinal() < r100.size()) goto L5;
        return null;
    L5:
        return (View) ListProtector.get(r100, this.f403091i.ordinal());
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
        if (r101 == (getPaddingLeft() - this.f403094l)) goto L24;
        if (r101 == (getPaddingLeft() + this.f403094l)) goto L24;
        if (r102 == (getPaddingTop() - this.f403094l)) goto L24;
        if (r102 == (getPaddingTop() + this.f403094l)) goto L24;
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

    public final void n() {
        View r100 = getSurfaceView();
        getCurrentBottomView();
        if (r100 == null) goto L10;
        ViewDragHelper r101 = this.f403092j;
        if (r101 == null) goto L8;
        r101.abort();
    L8:
        Rect r102 = i(true);
        this.f403092j.smoothSlideViewTo(r100, r102.left, r102.top);
        invalidate();
        return;
    }

    public final void o() {
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

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getAdapterView() == null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        return;
    L8:
        if (this.f403089J != null) goto L11;
        setOnClickListener(new b(this));
    L11:
        if (this.K != null) goto L15;
        setOnLongClickListener(new c(this));
        return;
    L15:
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewDragHelper r100 = this.f403092j;
        if (r100 == null) goto L6;
        r100.abort();
    L6:
        if (getOpenStatus() == Status.Close) goto L9;
        g(false);
        return;
    }

    public final void p() {
        View r100 = getCurrentBottomView();
        if (r100 == null) goto L11;
        DragEdge r101 = this.f403091i;
        if (r101 != DragEdge.Left) goto L7;
    L10:
        this.f403094l = r100.getMeasuredWidth() - l(getCurrentOffset());
        goto L11
    L7:
        if (r101 == DragEdge.Right) goto L10;
        this.f403094l = r100.getMeasuredHeight() - l(getCurrentOffset());
    L11:
        ShowMode r102 = this.f403096n;
        ShowMode r103 = ShowMode.PullOut;
        boolean r104 = false;
        if (r102 != r103) goto L26;
        View r105 = getSurfaceView();
        Rect r106 = (Rect) ((HashMap) this.f403102t).get(r105);
        if (r106 == null) goto L16;
    L19:
        if (r105 == null) goto L21;
        r105.layout(r106.left, r106.top, r106.right, r106.bottom);
        bringChildToFront(r105);
    L21:
        View r107 = getCurrentBottomView();
        Rect r108 = (Rect) ((HashMap) this.f403102t).get(r107);
        if (r108 != null) goto L24;
        r108 = h(r103, r106);
    L24:
        if (r107 == null) goto L38;
        r107.layout(r108.left, r108.top, r108.right, r108.bottom);
    L38:
        o();
        return;
    L16:
        if (getOpenStatus() == Status.Close) goto L18;
        r104 = true;
    L18:
        r106 = i(r104);
        goto L19
    L26:
        ShowMode r109 = ShowMode.LayDown;
        if (r102 != r109) goto L38;
        View r110 = getSurfaceView();
        Rect r111 = (Rect) ((HashMap) this.f403102t).get(r110);
        if (r111 != null) goto L31;
        r111 = i(false);
    L31:
        if (r110 == null) goto L33;
        r110.layout(r111.left, r111.top, r111.right, r111.bottom);
        bringChildToFront(r110);
    L33:
        View r112 = getCurrentBottomView();
        Rect r113 = (Rect) ((HashMap) this.f403102t).get(r112);
        if (r113 != null) goto L36;
        r113 = h(r109, r111);
    L36:
        if (r112 == null) goto L38;
        r112.layout(r113.left, r113.top, r113.right, r113.bottom);
        goto L38
    }

    public int getDragDistance() {
        return this.f403094l;
    }

    public DragEdge getDragEdge() {
        return this.f403091i;
    }

    public Map<DragEdge, View> getDragEdgeMap() {
        return this.f403095m;
    }

    public boolean getIsBeingDragged() {
        return this.G;
    }

    public ShowMode getShowMode() {
        return this.f403096n;
    }

    public float getWillOpenPercentAfterClose() {
        return this.f403107y;
    }

    public float getWillOpenPercentAfterOpen() {
        return this.f403106x;
    }

    public OSwipeLayout(Context r100) {
        this(r100, null);
    }

    public static void d(OSwipeLayout r100) {
        if (r100.getOpenStatus() != Status.Close) goto L13;
        AdapterView r101 = r100.getAdapterView();
        if (r101 == null) goto L11;
        int r102 = r101.getPositionForView(r100);
        if (r102 == (-1)) goto L12;
        r101.performItemClick(r101.getChildAt(r102 - r101.getFirstVisiblePosition()), r102, r101.getAdapter().getItemId(r102));
        return;
    L12:
        return;
    L11:
        return;
    }

    public static void e(OSwipeLayout r110) {
        if (r110.getOpenStatus() != Status.Close) goto L25;
        AdapterView<?> r100 = r110.getAdapterView();
        if (r100 == null) goto L23;
        int r101 = r100.getPositionForView(r110);
        if (r101 == (-1)) goto L26;
        long r102 = r100.getItemIdAtPosition(r101);
        Method r103 = AbsListView.class.getDeclaredMethod("performLongPress", new Class[]{View.class, Integer.TYPE, Long.TYPE});     // Catch: Exception -> L13
        r103.setAccessible(true);     // Catch: Exception -> L13
        ((Boolean) r103.invoke(r100, new Object[]{r110, Integer.valueOf(r101), Long.valueOf(r102)})).booleanValue();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        if (r100.getOnItemLongClickListener() == null) goto L17;
        boolean r111 = r100.getOnItemLongClickListener().onItemLongClick(r100, r110, r101, r102);
    L18:
        if (r111 == false) goto L24;
        r100.performHapticFeedback(0);
        return;
    L24:
        return;
    L17:
        r111 = false;
        goto L18
    L26:
        return;
    L23:
        return;
    }

    private void setCurrentDragEdge(DragEdge r100) {
        this.f403091i = r100;
        p();
    }

    public final void f(MotionEvent r110) {
        if (this.G == true) goto L5;
    L7:
        Status r100 = getOpenStatus();
        Status r101 = Status.Middle;
        if (r100 != r101) goto L11;
        this.G = true;
        return;
    L11:
        Status r102 = getOpenStatus();
        float r103 = r110.getRawX() - this.H;
        float r111 = r110.getRawY() - this.I;
        float r104 = (float) Math.toDegrees(Math.atan(Math.abs(r111 / r103)));
        Status r105 = getOpenStatus();
        Status r106 = Status.Close;
        boolean r107 = false;
        if (r105 == r106) goto L14;
    L73:
        DragEdge r108 = this.f403091i;
        if (r108 != DragEdge.Right) goto L99;
        Status r109 = Status.Open;
        if (r102 == r109) goto L78;
    L79:
        if (r102 == r106) goto L81;
    L83:
        boolean r112 = false;
    L85:
        if (this.f403108z == false) goto L90;
        if (r102 != r109) goto L90;
        if (r103 >= (-this.f403090h)) goto L90;
        r112 = true;
    L90:
        if (r112 == true) goto L94;
        if (r102 == r101) goto L94;
        boolean r113 = false;
    L96:
        if (r104 > 30.0f) goto L98;
        if (r113 == true) goto L99;
    L98:
        boolean r114 = true;
    L101:
        if (r108 != DragEdge.Left) goto L121;
        if (r102 == Status.Open) goto L105;
    L106:
        if (r102 == r106) goto L108;
    L110:
        boolean r115 = false;
    L111:
        if (r115 == true) goto L115;
        if (r102 == r101) goto L115;
        boolean r116 = false;
    L117:
        if (r104 > 30.0f) goto L119;
        if (r116 == true) goto L121;
    L119:
        r114 = true;
    L115:
        r116 = true;
        goto L117
    L108:
        if (r103 <= this.f403090h) goto L110;
    L109:
        r115 = true;
        goto L111
    L105:
        if (r103 < (-this.f403090h)) goto L109;
    L121:
        if (r108 != DragEdge.Top) goto L141;
        if (r102 == Status.Open) goto L125;
    L126:
        if (r102 == r106) goto L128;
    L130:
        boolean r117 = false;
    L131:
        if (r117 == true) goto L135;
        if (r102 == r101) goto L135;
        boolean r118 = false;
    L137:
        if (r104 < 60.0f) goto L139;
        if (r118 == true) goto L141;
    L139:
        r114 = true;
    L135:
        r118 = true;
        goto L137
    L128:
        if (r111 <= this.f403090h) goto L130;
    L129:
        r117 = true;
        goto L131
    L125:
        if (r111 < (-this.f403090h)) goto L129;
    L141:
        if (r108 == DragEdge.Bottom) goto L143;
    L158:
        this.G = !r114;
        return;
    L143:
        if (r102 == Status.Open) goto L145;
    L146:
        if (r102 == r106) goto L148;
    L150:
        boolean r119 = false;
    L151:
        if (r119 == true) goto L153;
        if (r102 == r101) goto L153;
    L155:
        if (r104 < 60.0f) goto L157;
        if (r107 == true) goto L158;
    L157:
        r114 = true;
    L153:
        r107 = true;
        goto L155
    L148:
        if (r111 >= (-this.f403090h)) goto L150;
    L149:
        r119 = true;
        goto L151
    L145:
        if (r111 > this.f403090h) goto L149;
    L94:
        r113 = true;
        goto L96
    L81:
        if (r103 >= (-this.f403090h)) goto L83;
    L82:
        r112 = true;
        goto L85
    L78:
        if (r103 > this.f403090h) goto L82;
    L99:
        r114 = false;
        goto L101
    L14:
        if (r104 >= 45.0f) goto L45;
        if (r103 <= 0.0f) goto L30;
        LinkedHashMap<DragEdge, View> r120 = this.f403095m;
        DragEdge r121 = DragEdge.Left;
        View r122 = r120.get(r121);
        if (r122 != null) goto L20;
    L26:
        boolean r123 = false;
    L27:
        if (r123 == false) goto L30;
    L71:
        setCurrentDragEdge(r121);
        goto L73
    L20:
        if (r122.getParent() != this) goto L26;
        if (r122 == getSurfaceView()) goto L26;
        if (this.f403104v[r121.ordinal()] == false) goto L26;
        r123 = true;
    L30:
        if (r103 >= 0.0f) goto L43;
        LinkedHashMap<DragEdge, View> r124 = this.f403095m;
        r121 = DragEdge.Right;
        View r125 = r124.get(r121);
        if (r125 != null) goto L34;
    L40:
        boolean r126 = false;
    L41:
        if (r126 == true) goto L71;
        return;
    L34:
        if (r125.getParent() != this) goto L40;
        if (r125 == getSurfaceView()) goto L40;
        if (this.f403104v[r121.ordinal()] == false) goto L40;
        r126 = true;
        goto L41
    L43:
        return;
    L45:
        if (r111 <= 0.0f) goto L59;
        LinkedHashMap<DragEdge, View> r127 = this.f403095m;
        r121 = DragEdge.Top;
        View r128 = r127.get(r121);
        if (r128 != null) goto L49;
    L55:
        boolean r129 = false;
    L56:
        if (r129 == false) goto L59;
    L49:
        if (r128.getParent() != this) goto L55;
        if (r128 == getSurfaceView()) goto L55;
        if (this.f403104v[r121.ordinal()] == false) goto L55;
        r129 = true;
    L59:
        if (r111 >= 0.0f) goto L72;
        LinkedHashMap<DragEdge, View> r130 = this.f403095m;
        r121 = DragEdge.Bottom;
        View r131 = r130.get(r121);
        if (r131 != null) goto L63;
    L69:
        boolean r132 = false;
    L70:
        if (r132 == true) goto L71;
        return;
    L63:
        if (r131.getParent() != this) goto L69;
        if (r131 == getSurfaceView()) goto L69;
        if (this.f403104v[r121.ordinal()] == false) goto L69;
        r132 = true;
        goto L70
    L72:
        return;
    L5:
        if (this.F == true) goto L7;
    }

    public final void g(boolean r100) {
        View r101 = getSurfaceView();
        if (r101 != null) goto L5;
        return;
    L5:
        ViewDragHelper r102 = this.f403092j;
        if (r102 == null) goto L8;
        r102.abort();
    L8:
        if (r100 == false) goto L10;
        this.f403092j.smoothSlideViewTo(getSurfaceView(), getPaddingLeft(), getPaddingTop());
    L14:
        invalidate();
        return;
    L10:
        Rect r103 = i(false);
        ((HashMap) this.f403102t).remove(r101);
        Map<View, Rect> r104 = this.f403102t;
        HashMap r105 = (HashMap) r104;
        if (((Rect) r105.get(getCurrentBottomView())) == null) goto L13;
        Map<View, Rect> r106 = this.f403102t;
        HashMap r107 = (HashMap) r106;
        r107.remove(getCurrentBottomView());
    L13:
        int r108 = r103.left - r101.getLeft();
        int r109 = r103.top - r101.getTop();
        r101.layout(r103.left, r103.top, r103.right, r103.bottom);
        j(r103.left, r103.top, r103.right, r103.bottom);
        k(r103.left, r103.top, r108, r109);
        goto L14
    }

    public final Rect i(boolean r100) {
        int r101 = getPaddingLeft();
        int r102 = getPaddingTop();
        if (r100 == false) goto L15;
        DragEdge r103 = this.f403091i;
        if (r103 != DragEdge.Left) goto L8;
        int r104 = getPaddingLeft();
        r101 = this.f403094l + r104;
        goto L15
    L8:
        if (r103 != DragEdge.Right) goto L11;
        r101 = getPaddingLeft() - this.f403094l;
        goto L15
    L11:
        if (r103 != DragEdge.Top) goto L13;
        int r105 = getPaddingTop();
        r102 = this.f403094l + r105;
        goto L15
    L13:
        r102 = getPaddingTop() - this.f403094l;
    L15:
        return new Rect(r101, r102, getMeasuredWidth() + r101, getMeasuredHeight() + r102);
    }

    public final int l(float r100) {
        Resources r101 = getContext().getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public final boolean m(MotionEvent r100) {
        View r101 = getSurfaceView();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (this.L != null) goto L9;
        this.L = new Rect();
    L9:
        r101.getHitRect(this.L);
        return this.L.contains((int) r100.getX(), (int) r100.getY());
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        boolean r101 = false;
        if (this.f403103u == true) goto L6;
        return false;
    L6:
        if (this.f403105w == true) goto L8;
    L12:
        Iterator r102 = ((ArrayList) this.f403099q).iterator();
    L14:
        if (r102.hasNext() == false) goto L20;
        h r103 = (h) r102.next();
        if (r103 == null) goto L14;
        if (r103.a() == false) goto L14;
        return false;
    L20:
        int r104 = r100.getAction();
        if (r104 == 0) goto L40;
        if (r104 != 1) goto L24;
    L39:
        this.F = false;
        this.G = false;
        this.f403092j.processTouchEvent(r100);
    L60:
        return this.G;
    L24:
        if (r104 != 2) goto L26;
        boolean r105 = this.G;
        f(r100);
        if (this.G == true) goto L31;
    L35:
        if (r105 == true) goto L60;
        if (this.G == false) goto L60;
        return false;
    L31:
        if (this.F == true) goto L35;
        ViewParent r106 = getParent();
        if (r106 == null) goto L35;
        r106.requestDisallowInterceptTouchEvent(true);
        goto L35
    L26:
        if (r104 == 3) goto L39;
        this.f403092j.processTouchEvent(r100);
        goto L60
    L40:
        this.f403092j.processTouchEvent(r100);
        this.F = false;
        this.G = false;
        this.H = r100.getRawX();
        this.I = r100.getRawY();
        if (getOpenStatus() != Status.Middle) goto L44;
        this.G = true;
    L44:
        if (this.f403108z == false) goto L60;
        View r107 = getSurfaceView();
        if (r107 == null) goto L57;
        int r108 = (int) r100.getX();
        int r109 = (int) r100.getY();
        if (r108 < r107.getLeft()) goto L57;
        if (r108 > r107.getRight()) goto L57;
        if (r109 < r107.getTop()) goto L57;
        if (r109 > r107.getBottom()) goto L57;
        r101 = true;
    L57:
        if (r101 == true) goto L60;
        this.F = true;
        goto L60
    L8:
        if (getOpenStatus() != Status.Open) goto L12;
        if (m(r100) == false) goto L12;
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f403103u == false) goto L5;
        int r101 = r100.getActionMasked();
        this.M.onTouchEvent(r100);
        if (r101 == 0) goto L20;
        if (r101 != 1) goto L10;
    L19:
        this.G = false;
        this.f403092j.processTouchEvent(r100);
    L22:
        if (super.onTouchEvent(r100) == false) goto L24;
    L26:
        return true;
    L24:
        if (this.G == true) goto L26;
        if (r101 == 0) goto L26;
        return false;
    L10:
        if (r101 != 2) goto L12;
        f(r100);
        if (this.G == false) goto L22;
        if (this.F == true) goto L22;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f403092j.processTouchEvent(r100);
        goto L22
    L12:
        if (r101 == 3) goto L19;
        this.f403092j.processTouchEvent(r100);
        goto L22
    L20:
        this.f403092j.processTouchEvent(r100);
        this.H = r100.getRawX();
        this.I = r100.getRawY();
        goto L22
    L5:
        return super.onTouchEvent(r100);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View r100) {
        Iterator r101 = new HashMap(this.f403095m).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Map.Entry r102 = (Map.Entry) r101.next();
        if (r102.getValue() != r100) goto L4;
        this.f403095m.remove(r102.getKey());
        goto L4
    }

    public void setBottomSwipeEnabled(boolean r100) {
        this.f403104v[DragEdge.Bottom.ordinal()] = r100;
    }

    public void setClickToClose(boolean r100) {
        this.f403105w = r100;
    }

    public void setDragDistance(int r100) {
        if (r100 >= 0) goto L4;
        r100 = 0;
    L4:
        this.f403094l = l(r100);
        requestLayout();
    }

    public void setDragEdge(DragEdge r100) {
        this.f403095m.clear();
        if (getChildCount() < 2) goto L5;
        this.f403095m.put(r100, getChildAt(getChildCount() - 2));
    L5:
        setCurrentDragEdge(r100);
    }

    public void setDragEdges(List<DragEdge> r100) {
        this.f403095m.clear();
        int r101 = Math.min(r100.size(), getChildCount() - 1);
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L6;
        this.f403095m.put((DragEdge) ListProtector.get(r100, r102), getChildAt(r102));
        r102 = r102 + 1;
        goto L3
    L6:
        if (r100.size() != 0) goto L8;
    L11:
        setCurrentDragEdge(N);
        return;
    L8:
        if (r100.contains(N) == true) goto L11;
        setCurrentDragEdge((DragEdge) ListProtector.get(r100, 0));
    }

    public void setLeftSwipeEnabled(boolean r100) {
        this.f403104v[DragEdge.Left.ordinal()] = r100;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        super.setOnClickListener(r100);
        this.f403089J = r100;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r100) {
        super.setOnLongClickListener(r100);
        this.K = r100;
    }

    public void setOverrideDragDistance(int r100) {
        this.C = r100;
    }

    public void setQuickDeleteEnabled(boolean r100) {
        this.f403108z = r100;
    }

    public void setQuickDeleteMax(float r100) {
        this.B = r100;
    }

    public void setQuickDeleteThreshold(float r100) {
        this.A = r100;
    }

    public void setRightSwipeEnabled(boolean r100) {
        this.f403104v[DragEdge.Right.ordinal()] = r100;
    }

    public void setShowMode(ShowMode r100) {
        this.f403096n = r100;
        requestLayout();
    }

    public void setSwipeEnabled(boolean r100) {
        this.f403103u = r100;
    }

    public void setTopSwipeEnabled(boolean r100) {
        this.f403104v[DragEdge.Top.ordinal()] = r100;
    }

    public void setWillOpenPercentAfterClose(float r100) {
        this.f403107y = r100;
    }

    public void setWillOpenPercentAfterOpen(float r100) {
        this.f403106x = r100;
    }

    public void setDragEdges(DragEdge... r100) {
        this.f403095m.clear();
        setDragEdges(Arrays.asList(r100));
    }

    public OSwipeLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final Rect h(ShowMode r100, Rect r101) {
        View r102 = getCurrentBottomView();
        int r103 = r101.left;
        int r104 = r101.top;
        int r105 = r101.right;
        int r106 = r101.bottom;
        if (r100 != ShowMode.PullOut) goto L28;
        DragEdge r107 = this.f403091i;
        DragEdge r108 = DragEdge.Left;
        if (r107 != r108) goto L8;
        r103 = r103 - this.f403094l;
    L14:
        int r109 = 0;
        if (r107 != r108) goto L17;
    L23:
        if (r102 == null) goto L26;
        r109 = r102.getMeasuredWidth();
    L26:
        r105 = r109 + r103;
    L40:
        return new Rect(r103, r104, r105, r106);
    L17:
        if (r107 == DragEdge.Right) goto L23;
        if (r102 == null) goto L22;
        r109 = r102.getMeasuredHeight();
    L22:
        r106 = r104 + r109;
        r105 = r101.right;
        goto L40
    L8:
        if (r107 != DragEdge.Right) goto L11;
        r103 = r105;
        goto L14
    L11:
        if (r107 != DragEdge.Top) goto L13;
        r104 = r104 - this.f403094l;
        goto L14
    L13:
        r104 = r106;
        goto L14
    L28:
        if (r100 != ShowMode.LayDown) goto L40;
        DragEdge r110 = this.f403091i;
        if (r110 != DragEdge.Left) goto L33;
        r105 = r103 + this.f403094l;
        goto L40
    L33:
        if (r110 != DragEdge.Right) goto L36;
        r103 = r105 - this.f403094l;
        goto L40
    L36:
        if (r110 != DragEdge.Top) goto L38;
        r106 = r104 + this.f403094l;
        goto L40
    L38:
        r104 = r106 - this.f403094l;
        goto L40
    }

    public OSwipeLayout(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.f403091i = N;
        this.f403094l = 0;
        LinkedHashMap<DragEdge, View> r100 = new LinkedHashMap();
        this.f403095m = r100;
        float[] r101 = new float[4];
        this.f403097o = r101;
        this.f403098p = new ArrayList();
        this.f403099q = new ArrayList();
        this.f403100r = new HashMap();
        this.f403101s = new HashMap();
        this.f403102t = new HashMap();
        this.f403103u = true;
        this.f403104v = new boolean[]{true, true, true, true};
        this.f403105w = false;
        this.f403106x = 0.75f;
        this.f403107y = 0.25f;
        this.f403108z = false;
        this.A = 1.5f;
        this.B = 2.0f;
        this.C = -1;
        this.D = false;
        a r102 = new a(this);
        this.E = 0;
        this.H = -1.0f;
        this.I = -1.0f;
        this.M = new GestureDetector(getContext(), new i(this));
        this.f403092j = ViewDragHelper.create(this, r102);
        this.f403090h = ViewConfiguration.get(r110).getScaledTouchSlop();
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.oui_bottomEdgeSwipeOffset, R.attr.oui_clickToClose, R.attr.oui_drag_edge, R.attr.oui_leftEdgeSwipeOffset, R.attr.oui_rightEdgeSwipeOffset, R.attr.oui_show_mode, R.attr.oui_topEdgeSwipeOffset});
        int r103 = r113.getInt(2, 2);
        DragEdge r104 = DragEdge.Left;
        r101[r104.ordinal()] = r113.getDimension(3, 0.0f);
        DragEdge r105 = DragEdge.Right;
        r101[r105.ordinal()] = r113.getDimension(4, 0.0f);
        DragEdge r106 = DragEdge.Top;
        r101[r106.ordinal()] = r113.getDimension(6, 0.0f);
        DragEdge r107 = DragEdge.Bottom;
        r101[r107.ordinal()] = r113.getDimension(0, 0.0f);
        setClickToClose(r113.getBoolean(1, this.f403105w));
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
        this.f403096n = ShowMode.values()[r114];
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
        this.f403095m.put(DragEdge.Left, r100);
    L13:
        if ((r104 & 5) != 5) goto L16;
        this.f403095m.put(DragEdge.Right, r100);
    L16:
        if ((r104 & 48) != 48) goto L19;
        this.f403095m.put(DragEdge.Top, r100);
    L19:
        if ((r104 & 80) != 80) goto L28;
        this.f403095m.put(DragEdge.Bottom, r100);
    L28:
        if (r100.getParent() != this) goto L30;
        return;
    L30:
        super.addView(r100, r101, r102);
        return;
    L21:
        Iterator<Map.Entry<DragEdge, View>> r105 = this.f403095m.entrySet().iterator();
    L23:
        if (r105.hasNext() == false) goto L28;
        Map.Entry<DragEdge, View> r106 = r105.next();
        if (r106.getValue() != null) goto L23;
        this.f403095m.put(r106.getKey(), r100);
    L6:
        e = move-exception;
        e.printStackTrace();
        r103 = 0;
        goto L8
    }

    public final void j(int r110, int r111, int r210, int r211) {
        if (((HashMap) this.f403100r).isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r100 = ((HashMap) this.f403100r).entrySet().iterator();
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
        DragEdge r112 = this.f403091i;
        int r113 = r103.left;
        int r114 = r103.right;
        int r115 = r103.top;
        ShowMode r116 = getShowMode();
        ShowMode r117 = ShowMode.LayDown;
        Iterator r118 = r100;
        boolean r106 = true;
        if (r116 != r117) goto L41;
        int r119 = d.f403116a[r112.ordinal()];
        if (r119 != 1) goto L22;
        if (r111 < r115) goto L71;
        if (r111 >= r105) goto L71;
    L72:
        if (r106 == false) goto L113;
        ((HashMap) this.f403101s).put(r102, Boolean.FALSE);
        float r107 = 0.0f;
        if (getShowMode() != r117) goto L91;
        int r108 = d.f403116a[this.f403091i.ordinal()];
        if (r108 != 1) goto L78;
        float r109 = r103.top - r111;
        int r120 = r102.getHeight();
    L88:
        r107 = r109 / r120;
    L106:
        Iterator r121 = ((ArrayList) r101.getValue()).iterator();
    L108:
        if (r121.hasNext() == false) goto L113;
        f r122 = (f) r121.next();
        Math.abs(r107);
        r122.a();
        if (Math.abs(r107) != 1.0f) goto L108;
        ((HashMap) this.f403101s).put(r102, Boolean.TRUE);
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
        int r123 = d.f403116a[this.f403091i.ordinal()];
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
        DragEdge r126 = this.f403091i;
        if (((Boolean) ((HashMap) this.f403101s).get(r102)).booleanValue() == true) goto L150;
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
        ((HashMap) this.f403101s).put(r102, Boolean.TRUE);
        Iterator r132 = ((ArrayList) r101.getValue()).iterator();
    L154:
        if (r132.hasNext() == false) goto L162;
        f r133 = (f) r132.next();
        DragEdge r134 = this.f403091i;
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
        int r135 = d.f403116a[r112.ordinal()];
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

    public final void k(int r100, int r101, int r102, int r103) {
        DragEdge r104 = getDragEdge();
        if (r104 != DragEdge.Left) goto L7;
        if (r102 < 0) goto L17;
    L18:
        boolean r105 = true;
    L19:
        o();
        Status r106 = getOpenStatus();
        if (((ArrayList) this.f403098p).isEmpty() == true) goto L54;
        this.E++;
        Iterator r107 = ((ArrayList) this.f403098p).iterator();
    L23:
        if (r107.hasNext() == false) goto L31;
        j r108 = (j) r107.next();
        if (this.E != 1) goto L29;
        if (r105 == false) goto L28;
        r108.c(this);
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
        Iterator r110 = ((ArrayList) this.f403098p).iterator();
    L34:
        if (r110.hasNext() == false) goto L36;
        ((j) r110.next()).onClose();
        goto L34
    L36:
        this.E = 0;
    L38:
        if (r106 != Status.Open) goto L55;
        View r111 = getCurrentBottomView();
        if (r111 == null) goto L42;
        r111.setEnabled(true);
    L42:
        Iterator r112 = ((ArrayList) this.f403098p).iterator();
    L44:
        if (r112.hasNext() == false) goto L46;
        ((j) r112.next()).onOpen();
        goto L44
    L46:
        this.E = 0;
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
        p();
    }
}
