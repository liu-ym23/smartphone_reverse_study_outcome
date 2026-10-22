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
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import vg3.y;

/* JADX INFO: loaded from: classes13.dex */
public final class d extends StandardPrefService<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> implements y {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f563603p = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.perf.monitor.c f563604n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final q73.a f563605o;

    public static final class a implements com.bytedance.android.shopping.prepurchase.arch.standard.component.pref.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f563606a;

        /* JADX INFO: renamed from: xg3.d$a$a, reason: collision with other inner class name */
        public static final class ChoreographerFrameCallbackC8231a implements Choreographer.FrameCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f563607a;

            public ChoreographerFrameCallbackC8231a(a r100) {
                this.f563607a = r100;
            }

            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long r100) {
                int r101 = com.bytedance.android.shopping.base.event.c.f170705a;
                d r102 = this.f563607a.f563606a;
                int r103 = d.f563603p;
                com.bytedance.android.shopping.base.event.c.d(r102.c2(), true);
            }
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.pref.b
        public final void b() {
        }

        public a(d r100) {
            this.f563606a = r100;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.pref.b
        public final void a(int r100) {
            if (r100 != 2) goto L6;
            int r101 = com.bytedance.android.shopping.base.event.c.f170705a;
            com.bytedance.android.shopping.base.event.c.e(this.f563606a.c2());
        L6:
            if (r100 != 3) goto L13;
            d r102 = this.f563606a;
            com.bytedance.android.shopping.anchorv4.perf.monitor.c r103 = r102.f563604n;
            if (r103 != null) goto L10;
            Choreographer.getInstance().postFrameCallback(new ChoreographerFrameCallbackC8231a(this));
        L11:
            int r104 = com.bytedance.android.shopping.base.event.c.f170705a;
            com.bytedance.android.shopping.base.event.c.d(this.f563606a.c2(), true);
            return;
        L10:
            CommonMeta r105 = r102.O1().d().getData().a().a();
            String r106 = this.f563606a.c2();
            V4NativeParams r107 = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.f563606a.O1())).f181848a.getNativeParams();
            Intrinsics.checkNotNullParameter(r106, "sessionId");
            Intrinsics.checkNotNullParameter(r107, "param");
            Map<String, String> r108 = k.f45162a;
            k.f("ec_perf_duration_anchor_v3_detail", new com.bytedance.android.shopping.anchorv4.perf.monitor.d(r103, r107, r105, r106));
            goto L11
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.pref.StandardPrefService, com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        TaskScheduler r100 = b2();
        a r101 = new a(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "callback");
        r100.f181000e = r101;
        AbsComponent.Y1(this, y.class, this, false, 12);
        boolean r102 = PdpMessageOpt.f43751a;
        if (Intrinsics.areEqual(c2(), PdpMessageOpt.f43753c) == false) goto L7;
        BasePdpMessageOptWorker r103 = PdpMessageOpt.f43754d;
        if (r103 == null) goto L7;
        r103.b();
    L7:
        xg3.a r104 = new xg3.a(this);
        Intrinsics.checkNotNullParameter(r104, "task");
        TaskScheduler r105 = b2();
        int r106 = TaskScheduler.f180995i;
        r105.b(1, r104, null);
        s1(new b(this));
        b2().b(4, new c(this), 0);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.pref.StandardPrefService, com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        boolean r100 = PdpMessageOpt.f43751a;
        PdpMessageOpt.f(c2());
        jh.b.a r101 = jh.b.f499064c;
        if (((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).f181848a.getNativeParams().getFullMode() == false) goto L6;
        MonitorScenes r102 = MonitorScenes.FPS_SCENE_ANCHOR_V3_DETAIL_FULL_SCREEN;
    L9:
        String r103 = r102.getSceneName();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r103, "sceneName");
        jh.b.f499062a.remove(r103);
        return;
    L6:
        if (((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).f181848a.getNativeParams().getFromLive() != true) goto L8;
        r102 = MonitorScenes.FPS_SCENE_ANCHOR_V3_DETAIL_HALF_SCREEN_LIVE;
        goto L9
    L8:
        r102 = MonitorScenes.FPS_SCENE_ANCHOR_V3_DETAIL_HALF_SCREEN_FEED;
        goto L9
    }

    public final String c2() {
        return O1().f().f523187a.f523190b;
    }

    @Override // vg3.y
    public final q73.a I0() {
        return this.f563605o;
    }

    @Override // vg3.y
    public final com.bytedance.android.shopping.anchorv4.perf.monitor.c V() {
        return this.f563604n;
    }

    @Override // vg3.y
    public final void z1(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        boolean r101 = PdpMessageOpt.f43751a;
        PdpMessageOpt.a(c2(), r100);
    }

    public d(RenderLifecycleDispatcher r100, com.bytedance.android.shopping.prepurchase.business.pdp.f r101) {
        Intrinsics.checkNotNullParameter(r100, "renderListener");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        super(r100, r101);
        this.f563604n = r101.b();
        this.f563605o = new q73.a();
    }
}
