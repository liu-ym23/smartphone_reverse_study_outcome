package com.larus.livetutor.impl.utils;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.larus.utils.logger.FLogger;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class RVExposureUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2<? super Boolean, ? super Integer, Unit> f356644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f356645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f356646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RVExposureUtil$onScrollListener$1 f356647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f356648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f356649f;

    public static final class a {
    }

    public static final class b implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RVExposureUtil f356650a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        }

        public b(RVExposureUtil r100) {
            this.f356650a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f356650a.b();
        }
    }

    static {
    }

    public final void b() {
        RecyclerView r100 = this.f356645b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getVisibility() == 0) goto L7;
        return;
    L7:
        if (r100.isShown() == true) goto L9;
        return;
    L9:
        if (r100.getGlobalVisibleRect(new Rect()) == true) goto L49;
        return;
    L49:
        int[] r101 = new int[2];     // Catch: Exception -> L46
        RecyclerView.LayoutManager r102 = r100.getLayoutManager();     // Catch: Exception -> L46
        if ((r102 instanceof GridLayoutManager) == false) goto L17;
        GridLayoutManager r103 = (GridLayoutManager) r102;     // Catch: Exception -> L46
        int[] r104 = {r103.findFirstVisibleItemPosition(), r103.findLastVisibleItemPosition()};     // Catch: Exception -> L46
        int r105 = ((GridLayoutManager) r102).getOrientation();     // Catch: Exception -> L46
    L15:
        int[] r110 = r104;
        int r106 = r105;
        r101 = r110;
    L36:
        if (r101.length >= 2) goto L38;
        return;
    L38:
        int r107 = r101[0];     // Catch: Exception -> L46
        int r108 = r101[1];     // Catch: Exception -> L46
        if (r107 > r108) goto L61;
    L40:
        if (r102 == null) goto L42;
        View r109 = r102.findViewByPosition(r107);     // Catch: Exception -> L46
    L43:
        a(r109, r107, r106);     // Catch: Exception -> L46
        if (r107 == r108) goto L63;
        r107 = r107 + 1;
        goto L40
    L63:
        return;
    L42:
        r109 = null;
        goto L43
    L61:
        return;
    L17:
        if ((r102 instanceof LinearLayoutManager) == false) goto L20;
        LinearLayoutManager r111 = (LinearLayoutManager) r102;     // Catch: Exception -> L46
        r104 = new int[]{r111.findFirstVisibleItemPosition(), r111.findLastVisibleItemPosition()};     // Catch: Exception -> L46
        r105 = ((LinearLayoutManager) r102).getOrientation();     // Catch: Exception -> L46
        goto L15
    L20:
        if ((r102 instanceof StaggeredGridLayoutManager) == false) goto L34;
        StaggeredGridLayoutManager r112 = (StaggeredGridLayoutManager) r102;     // Catch: Exception -> L46
        int r113 = r112.getSpanCount();     // Catch: Exception -> L46
        int[] r114 = new int[r113];     // Catch: Exception -> L46
        int r115 = r112.getSpanCount();     // Catch: Exception -> L46
        int[] r116 = new int[r115];     // Catch: Exception -> L46
        r112.findFirstVisibleItemPositions(r114);     // Catch: Exception -> L46
        r112.findLastVisibleItemPositions(r116);     // Catch: Exception -> L46
        int r117 = r114[0];     // Catch: Exception -> L46
        int r118 = r116[0];     // Catch: Exception -> L46
        int r119 = 1;
    L22:
        if (r119 >= r113) goto L27;
        int r120 = r114[r119];     // Catch: Exception -> L46
        if (r117 <= r120) goto L26;
        r117 = r120;
    L26:
        r119 = r119 + 1;     // Catch: Exception -> L46
        goto L22
    L27:
        int r121 = 1;
    L28:
        if (r121 >= r115) goto L33;
        int r122 = r116[r121];     // Catch: Exception -> L46
        if (r118 >= r122) goto L32;
        r118 = r122;
    L32:
        r121 = r121 + 1;     // Catch: Exception -> L46
        goto L28
    L33:
        r104 = new int[]{r117, r118};     // Catch: Exception -> L46
        r105 = ((StaggeredGridLayoutManager) r102).getOrientation();     // Catch: Exception -> L46
        goto L15
    L34:
        r106 = -1;
    L46:
        e = move-exception;
        e.printStackTrace();
        FLogger.f375446a.e("ExposureUtil", e.getMessage());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.livetutor.impl.utils.RVExposureUtil$onScrollListener$1] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.livetutor.impl.utils.k] */
    public RVExposureUtil() {
        this.f356647d = new RVExposureUtil$onScrollListener$1(this);
        this.f356648e = new k(this);
        this.f356649f = new b(this);
    }

    public final void c(RecyclerView r100, Function2 r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "onExposeListener");
        this.f356645b = r100;
        this.f356644a = r101;
        this.f356646c = 10;
        if (r100 == null) goto L6;
        r100.removeOnScrollListener(this.f356647d);
        r100.addOnScrollListener(this.f356647d);
        r100.removeOnLayoutChangeListener(this.f356648e);
        r100.addOnLayoutChangeListener(this.f356648e);
        r100.removeOnAttachStateChangeListener(this.f356649f);
        r100.addOnAttachStateChangeListener(this.f356649f);
        return;
    }

    public final void a(View r100, int r101, int r110) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getVisibility() == 0) goto L6;
        return;
    L6:
        if (r100.isShown() == true) goto L8;
        return;
    L8:
        if (r100.getGlobalVisibleRect(new Rect()) == false) goto L39;
        Rect r102 = new Rect();
        boolean r103 = r100.getGlobalVisibleRect(r102);
        boolean r104 = false;
        if (r110 == 1) goto L13;
    L15:
        boolean r105 = false;
    L16:
        if (r110 == 0) goto L18;
    L20:
        boolean r106 = false;
    L21:
        if (r105 == true) goto L23;
        if (r106 == true) goto L23;
    L24:
        if (r103 == false) goto L29;
        if (r104 == false) goto L29;
        Function2<? super Boolean, ? super Integer, Unit> r107 = this.f356644a;
        if (r107 == null) goto L36;
        r107.invoke(Boolean.TRUE, Integer.valueOf(r101));
        return;
    L36:
        return;
    L29:
        Function2<? super Boolean, ? super Integer, Unit> r108 = this.f356644a;
        if (r108 == null) goto L38;
        r108.invoke(Boolean.FALSE, Integer.valueOf(r101));
        return;
    L38:
        return;
    L23:
        r104 = true;
        goto L24
    L18:
        if (r102.width() <= ((r100.getMeasuredWidth() * this.f356646c) / 100)) goto L20;
        r106 = true;
        goto L21
    L13:
        if (r102.height() <= ((r100.getMeasuredHeight() * this.f356646c) / 100)) goto L15;
        r105 = true;
        goto L16
    }
}
