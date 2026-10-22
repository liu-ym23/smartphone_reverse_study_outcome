package com.bytedance.locallife.dito.performance;

import android.os.SystemClock;
import androidx.lifecycle.Observer;
import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.common.perf.session.DitoPerformanceModule;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.locallife.dito.data.FmpType;
import com.bytedance.locallife.dito.data.v;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/dito/performance/DitoComponentPerformancePlugin;", "Lcom/bytedance/locallife/dito/performance/AbsComponentLifecyclePlugin;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dito-performance-saas_release"}, k = 1, mv = {1, 4, 3})
public final class DitoComponentPerformancePlugin extends AbsComponentLifecyclePlugin {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f258516e = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FmpType f258517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, uq6.c> f258518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r f258519d;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DitoComponentPerformancePlugin f258520a;

        public b(DitoComponentPerformancePlugin r100) {
            this.f258520a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = null;
            if ((r100 instanceof l) == false) goto L5;
            l r102 = (l) r100;
        L6:
            if (r102 == null) goto L48;
            DitoComponentPerformancePlugin r103 = this.f258520a;
            if (r102.f258557a.L() == true) goto L13;
            rq6.a r104 = rq6.a.f538927a;
            StringBuilder r105 = new StringBuilder("==> info.view no meaningfulSize,");
            BaseDitoModel r106 = r102.f258557a.getModel();
            if (r106 == null) goto L12;
            r101 = r106.f258493b.f258222b;
        L12:
            r105.append(r101);
            r104.c(DitoPerformanceModule.NAME, r105.toString());
            return;
        L13:
            rq6.a r107 = rq6.a.f538927a;
            StringBuilder r108 = new StringBuilder("==>fmp ");
            BaseDitoModel r109 = r102.f258557a.getModel();
            if (r109 == null) goto L16;
            String r110 = r109.f258493b.f258222b;
        L17:
            r108.append(r110);
            r108.append(",sizeStable:");
            r108.append(r102.f258558b);
            r108.append(",positionStable:");
            r108.append(r102.f258559c);
            r107.c(DitoPerformanceModule.NAME, r108.toString());
            BaseDitoModel r111 = r102.f258557a.getModel();
            if (r111 != null) goto L20;
            return;
        L20:
            if (r103.f258518c.containsKey(o.f(r111)) == false) goto L22;
        L25:
            boolean r112 = true;
        L26:
            if (r112 == false) goto L53;
            String r113 = o.f(r111);
            DitoNode r114 = r111.f258493b.f258221a;
            if (r114 == null) goto L31;
            String r115 = r114.getSubType();
        L32:
            uq6.c r116 = r103.h(r113, r115, null);
            long r117 = System.currentTimeMillis() - (SystemClock.elapsedRealtime() - r102.f258561e);
            if (r102.f258558b == true) goto L36;
            r116.l(null);
        L39:
            if (r102.f258558b == true) goto L41;
        L46:
            r116.i(null);
            return;
        L41:
            if (r102.f258559c == false) goto L46;
            if (r116.b() != null) goto L51;
            r116.i(Long.valueOf(r117));
            return;
        L51:
            return;
        L36:
            if (r116.c() != null) goto L39;
            r116.l(Long.valueOf(r117));
            r111.f258498g.f258506f = r102.f258557a.getHeight();
            goto L39
        L31:
            r115 = null;
            goto L32
        L53:
            return;
        L22:
            if (r102.f258558b == true) goto L25;
            r112 = false;
            goto L26
        L16:
            r110 = null;
            goto L17
        L48:
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DitoComponentPerformancePlugin f258521a;

        public c(DitoComponentPerformancePlugin r100) {
            this.f258521a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            v r101 = (v) r100;
            String r102 = null;
            if (r101.f258263a == false) goto L10;
            com.bytedance.locallife.dito.data.m r103 = (com.bytedance.locallife.dito.data.m) v.a(r101, com.bytedance.locallife.dito.data.m.class);
            if (r103 == null) goto L17;
            DitoComponentPerformancePlugin r104 = this.f258521a;
            String r105 = o.e(r103);
            DitoNode r106 = r103.f258221a;
            if (r106 == null) goto L9;
            r102 = r106.getSubType();
        L9:
            DitoComponentPerformancePlugin$onPluginAttach$2$1$1 r107 = DitoComponentPerformancePlugin$onPluginAttach$2$1$1.INSTANCE;
            int r108 = DitoComponentPerformancePlugin.f258516e;
            r104.h(r105, r102, r107);
            return;
        L17:
            return;
        L10:
            com.bytedance.locallife.dito.data.m r109 = (com.bytedance.locallife.dito.data.m) v.a(r101, com.bytedance.locallife.dito.data.m.class);
            if (r109 == null) goto L19;
            DitoComponentPerformancePlugin r110 = this.f258521a;
            String r111 = o.e(r109);
            DitoNode r112 = r109.f258221a;
            if (r112 == null) goto L15;
            r102 = r112.getSubType();
        L15:
            DitoComponentPerformancePlugin$onPluginAttach$2$2$1 r113 = DitoComponentPerformancePlugin$onPluginAttach$2$2$1.INSTANCE;
            int r114 = DitoComponentPerformancePlugin.f258516e;
            r110.h(r111, r102, r113);
            return;
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DitoComponentPerformancePlugin f258522a;

        public d(DitoComponentPerformancePlugin r100) {
            this.f258522a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            BaseDitoView<?> r101 = ((com.bytedance.locallife.dito.data.b) r100).f258195a;
            DitoComponentPerformancePlugin r102 = this.f258522a;
            rq6.a.f538927a.a(DitoPerformanceModule.NAME, "==>fcp ditoTag:" + r101.K() + ",fcp:" + r101.getFcpTs());
            Long r103 = r101.getFcpTs();
            if (r103 == null) goto L12;
            final long r104 = r103.longValue();
            BaseDitoModel r105 = r101.getModel();
            if (r105 == null) goto L13;
            String r106 = o.f(r105);
            DitoNode r107 = r105.f258493b.f258221a;
            if (r107 == null) goto L9;
            String r108 = r107.getSubType();
        L10:
            Function1<uq6.c, Unit> r109 = new DitoComponentPerformancePlugin$onPluginAttach$3$1$1$1(r104);
            int r110 = DitoComponentPerformancePlugin.f258516e;
            r102.h(r106, r108, r109);
            return;
        L9:
            r108 = null;
            goto L10
        L13:
            return;
        }
    }

    static {
    }

    public DitoComponentPerformancePlugin() {
        this.f258518c = new ConcurrentHashMap();
        Dito r100 = Dito.f257280a;
        this.f258519d = (r) Dito.a().a(r.class);
    }

    @Override // com.bytedance.locallife.dito.performance.AbsPerformancePlugin
    public final void g(DitoViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "ditoViewMode");
        Intrinsics.checkNotNullParameter(r100, "ditoViewMode");
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f258510a = r100;
        d().k().observeForever(new com.bytedance.locallife.dito.performance.a(this));
        d().h().observeForever(new com.bytedance.locallife.dito.performance.b(this));
        d().p().observeForever(new com.bytedance.locallife.dito.performance.c(this));
        d().n().observeForever(new com.bytedance.locallife.dito.performance.d(this));
        d().r0("card_fmp_result", 1).observe(e(), new b(this));
        d().u().observe(e(), new c(this));
        d().m().observeForever(new d(this));
        d().k0().observeForever(new DitoComponentPerformancePlugin$onPluginAttach$4(this));
    }

    public final uq6.c h(String r100, String r101, Function1<? super uq6.c, Unit> r102) {
        ConcurrentHashMap<String, uq6.c> r103 = this.f258518c;
        uq6.c r104 = r103.get(r100);
        if (r104 != null) goto L8;
        r104 = new uq6.c(r101, 6);
        uq6.c r105 = r103.putIfAbsent(r100, r104);
        if (r105 == null) goto L8;
        r104 = r105;
    L8:
        uq6.c r106 = r104;
        if (r102 == null) goto L11;
        r102.invoke(r106);
    L11:
        rq6.a.f538927a.a(DitoPerformanceModule.NAME, "customTag:" + r100 + ",componentSubType:" + r101 + ",timingInfo:" + r106);
        return r106;
    }
}
