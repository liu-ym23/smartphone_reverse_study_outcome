package com.bytedance.ee.bear.bitable.infoarch.nativeview.performance;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridRecyclerView;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.h;
import com.bytedance.ee.bear.bitable.statistic.i;
import com.bytedance.ee.bear.bitable.statistic.inner.BitableFpsTracer;
import com.bytedance.ee.bear.bitable.statistic.m;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableViewTracer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f213636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f213637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f213638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f213639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.statistic.c f213640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f213641f;

    public static final class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableViewTracer f213642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f213643b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f213644c;

        public a(BitableViewTracer r100, String r101, View r102) {
            this.f213642a = r100;
            this.f213643b = r101;
            this.f213644c = r102;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            if ((r103 - r101) > 0) goto L5;
            return;
        L5:
            if ((r104 - r102) > 0) goto L7;
            return;
        L7:
            if (this.f213642a.f213637b.compareAndSet(false, true) == false) goto L9;
            tu4.b.g(this.f213643b, "BITABLE_NATIVE_FIRST_SCREEN_SUCCESS", System.currentTimeMillis());
            String r109 = this.f213643b;
            long r110 = System.currentTimeMillis();
            Lazy r111 = com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.f215603a;
            Intrinsics.checkNotNullParameter(r109, "traceId");
            tu4.b.l(r109, r110, null);
        L9:
            this.f213644c.removeOnLayoutChangeListener(this);
        }
    }

    public static final class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableViewTracer f213645a;

        @Override // com.bytedance.ee.bear.bitable.statistic.h
        public final boolean d(i r100, BitableFpsTracer r101, HashMap r102, HashMap r103, HashMap r104, boolean r105, com.bytedance.ee.bear.bitable.statistic.a r106) {
            Intrinsics.checkNotNullParameter(r100, "agent");
            Intrinsics.checkNotNullParameter(r101, "trace");
            Intrinsics.checkNotNullParameter(r102, "dropFrames");
            Intrinsics.checkNotNullParameter(r103, "dropStateRatio");
            Intrinsics.checkNotNullParameter(r104, "dropDurRatio");
            Intrinsics.checkNotNullParameter(r106, "eventContext");
            return false;
        }

        public b(BitableViewTracer r100) {
            this.f213645a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.statistic.h
        public final void a(i r100, BitableFpsTracer r101, double r102, long r103) {
            Intrinsics.checkNotNullParameter(r100, "agent");
            Intrinsics.checkNotNullParameter(r101, "trace");
            BitableViewTracer r104 = this.f213645a;
            com.bytedance.ee.bear.bitable.infoarch.nativeview.performance.b r105 = r104.f213638c.f213682a;
            double r106 = r102 * r103;
            r105.f213670t += r106;
            r105.f213669s += r103;
            c r107 = r104.f213639d;
            if (r107 == null) goto L6;
            r107.f215615b += r106;
            r107.f215614a += r103;
            return;
        }
    }

    public final String c() {
        com.bytedance.ee.bear.bitable.statistic.c r100 = null;
        String r101 = ((m) this.f213636a.getValue()).createNormalTrace(null);
        com.bytedance.ee.bear.bitable.statistic.c r102 = this.f213640e;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("fpsTrace");
    L6:
        r100.g();
        e r103 = this.f213638c;
        r103.getClass();
        com.bytedance.ee.bear.bitable.infoarch.nativeview.performance.b r104 = new com.bytedance.ee.bear.bitable.infoarch.nativeview.performance.b();
        r103.f213682a = r104;
        r104.f213651a = System.currentTimeMillis();
        ((m) this.f213636a.getValue()).addNormalConsumer(r101, this.f213638c);
        return r101;
    L5:
        r100 = r102;
        goto L6
    }

    public final void d() {
        com.bytedance.ee.bear.bitable.statistic.c r100 = this.f213640e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("fpsTrace");
        r100 = null;
    L5:
        r100.g();
    }

    public BitableViewTracer() {
        this.f213636a = org.koin.java.a.d(m.class);
        this.f213637b = new AtomicBoolean(false);
        this.f213638c = new e();
    }

    public final void a(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        com.bytedance.ee.bear.bitable.statistic.c r101 = this.f213640e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("fpsTrace");
        r101 = null;
    L5:
        r101.f(r100);
    }

    public final void b(boolean r100) {
        this.f213638c.f213682a.f213662l = r100;
        c r101 = this.f213639d;
        if (r101 == null) goto L8;
        HashMap<String, Serializable> r102 = r101.f215616c;
        if (r102 == null) goto L9;
        Serializable r103 = r102.put("is_on_demand", Boolean.valueOf(r100));
        return;
    L9:
        return;
    }

    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        m r101 = (m) this.f213636a.getValue();
        BitableStatisticEventModel$NormalPointModel.a r102 = BitableStatisticEventModel$NormalPointModel.Companion;
        HashMap r103 = new HashMap();
        r102.getClass();
        BitableStatisticEventModel$NormalPointModel r104 = BitableStatisticEventModel$NormalPointModel.a.b("ccm_bitable_mobile_view_lifecycle", 0, true, r103);
        String r105 = this.f213641f;
        if (r105 == null) goto L5;
        r104.addExtra("viewType", r105);
    L5:
        r104.addExtra("reportScene", "nativeDestroy");
        Unit r106 = Unit.INSTANCE;
        r101.addNormalPoint(r100, r104);
    }

    public final void f(String r100, View r101) {
        Intrinsics.checkNotNullParameter(r101, "view");
        if (this.f213637b.get() == false) goto L6;
        return;
    L6:
        if (r100 == null) goto L8;
        Intrinsics.checkNotNullParameter("reportViewTTV.", "msg");
        tt5.a.h("NATIVE_VIEW_TAG", "reportViewTTV.");
        r101.addOnLayoutChangeListener(new a(this, r100, r101));
        return;
    L8:
        Intrinsics.checkNotNullParameter("error path. documentTraceId is null in nativeTTV.", "msg");
        tt5.a.h("NATIVE_VIEW_TAG", "error path. documentTraceId is null in nativeTTV.");
    }

    public final void g(GridRecyclerView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "rv");
        final com.bytedance.ee.bear.bitable.statistic.c r102 = ((m) this.f213636a.getValue()).createFpsTrace(r101);
        r100.setHorizontalScrollListener(new BitableViewTracer$traceGridHorizontalScroll$1(r102, this));
        r102.d(new b(this));
    }
}
