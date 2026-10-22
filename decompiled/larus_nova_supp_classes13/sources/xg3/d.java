package xg3;

import android.view.Choreographer;
import com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker;
import com.bytedance.android.ec.core.anchorv3.PdpMessageOpt;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.k;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.prepurchase.arch.container.aware.RenderLifecycleDispatcher;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.pref.StandardPrefService;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.pref.TaskScheduler;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import vg3.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends StandardPrefService<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> implements y {
    public static final /* synthetic */ int p = 0;
    public final com.bytedance.android.shopping.anchorv4.perf.monitor.c n;
    public final q73.a o;

    public static final class a implements com.bytedance.android.shopping.prepurchase.arch.standard.component.pref.b {
        public final /* synthetic */ d a;

        /* JADX INFO: renamed from: xg3.d$a$a, reason: collision with other inner class name */
        public static final class ChoreographerFrameCallbackC0243a implements Choreographer.FrameCallback {
            public final /* synthetic */ a a;

            public ChoreographerFrameCallbackC0243a(a r1) {
                this.a = r1;
            }

            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long r1) {
                int r2 = com.bytedance.android.shopping.base.event.c.a;
                d r3 = this.a.a;
                int r4 = d.p;
                com.bytedance.android.shopping.base.event.c.d(r3.c2(), true);
            }
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.pref.b
        public final void b() {
        }

        public a(d r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.pref.b
        public final void a(int r5) {
            if (r5 != 2) goto L6;
            int r0 = com.bytedance.android.shopping.base.event.c.a;
            com.bytedance.android.shopping.base.event.c.e(this.a.c2());
        L6:
            if (r5 != 3) goto L13;
            d r6 = this.a;
            com.bytedance.android.shopping.anchorv4.perf.monitor.c r1 = r6.n;
            if (r1 != null) goto L10;
            Choreographer.getInstance().postFrameCallback(new ChoreographerFrameCallbackC0243a(this));
        L11:
            int r7 = com.bytedance.android.shopping.base.event.c.a;
            com.bytedance.android.shopping.base.event.c.d(this.a.c2(), true);
            return;
        L10:
            CommonMeta r8 = r6.O1().d().getData().a().a();
            String r2 = this.a.c2();
            V4NativeParams r3 = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.a.O1())).a.getNativeParams();
            Intrinsics.checkNotNullParameter(r2, "sessionId");
            Intrinsics.checkNotNullParameter(r3, "param");
            Map r4 = k.a;
            k.f("ec_perf_duration_anchor_v3_detail", new com.bytedance.android.shopping.anchorv4.perf.monitor.d(r1, r3, r8, r2));
            goto L11
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.pref.StandardPrefService, com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        TaskScheduler r0 = b2();
        a r1 = new a(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "callback");
        r0.e = r1;
        AbsComponent.Y1(this, y.class, this, false, 12);
        boolean r2 = PdpMessageOpt.a;
        if (Intrinsics.areEqual(c2(), PdpMessageOpt.c) == false) goto L7;
        BasePdpMessageOptWorker r3 = PdpMessageOpt.d;
        if (r3 == null) goto L7;
        r3.b();
    L7:
        xg3.a r4 = new xg3.a(this);
        Intrinsics.checkNotNullParameter(r4, "task");
        TaskScheduler r5 = b2();
        int r6 = TaskScheduler.i;
        r5.b(1, r4, null);
        s1(new b(this));
        b2().b(4, new c(this), 0);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.pref.StandardPrefService, com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        boolean r0 = PdpMessageOpt.a;
        PdpMessageOpt.f(c2());
        jh.b.a r1 = jh.b.c;
        if (((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).a.getNativeParams().getFullMode() == false) goto L6;
        MonitorScenes r2 = MonitorScenes.FPS_SCENE_ANCHOR_V3_DETAIL_FULL_SCREEN;
    L9:
        String r3 = r2.getSceneName();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "sceneName");
        jh.b.a.remove(r3);
        return;
    L6:
        if (((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).a.getNativeParams().getFromLive() != true) goto L8;
        r2 = MonitorScenes.FPS_SCENE_ANCHOR_V3_DETAIL_HALF_SCREEN_LIVE;
        goto L9
    L8:
        r2 = MonitorScenes.FPS_SCENE_ANCHOR_V3_DETAIL_HALF_SCREEN_FEED;
        goto L9
    }

    public final String c2() {
        return O1().f().a.b;
    }

    @Override // vg3.y
    public final q73.a I0() {
        return this.o;
    }

    @Override // vg3.y
    public final com.bytedance.android.shopping.anchorv4.perf.monitor.c V() {
        return this.n;
    }

    @Override // vg3.y
    public final void z1(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        boolean r0 = PdpMessageOpt.a;
        PdpMessageOpt.a(c2(), r2);
    }

    public d(RenderLifecycleDispatcher r2, com.bytedance.android.shopping.prepurchase.business.pdp.f r3) {
        Intrinsics.checkNotNullParameter(r2, "renderListener");
        Intrinsics.checkNotNullParameter(r3, "provider");
        super(r2, r3);
        this.n = r3.b();
        this.o = new q73.a();
    }
}
