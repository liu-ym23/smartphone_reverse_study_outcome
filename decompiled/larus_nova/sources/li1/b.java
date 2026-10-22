package li1;

import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import jc1.k;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends com.bytedance.android.livesdk.room.Task.base.a<ls2.d, com.bytedance.android.livesdk.chatroom.newcontainer.business.common.basecomponents.session.e> {
    @Override // gs2.a
    public final String taskID() {
        return "PerformanceMonitorReleaseTask";
    }

    @Override // gs2.a
    public final void run() {
        IFeatureService r100 = (IFeatureService) k.f(IFeatureService.class);
        if (r100 == null) goto L5;
        r100.onLiveRoomFragmentDestroy();
    L5:
        IPerformanceManager r101 = (IPerformanceManager) k.f(IPerformanceManager.class);
        if (r101 == null) goto L8;
        r101.onModuleStop("stream");
    L8:
        IPerformanceManager r102 = (IPerformanceManager) k.f(IPerformanceManager.class);
        if (r102 == null) goto L11;
        r102.onExitRoom();
    L11:
        ck1.d r103 = (ck1.d) h().a(ck1.d.class);
        IPerformanceManager r104 = (IPerformanceManager) k.f(IPerformanceManager.class);
        if (r104 == null) goto L14;
        r104.stopTimerMonitor(r103.ym());
    L14:
        IPerformanceManager r105 = (IPerformanceManager) k.f(IPerformanceManager.class);
        if (r105 == null) goto L17;
        r105.release(r103.ym());
    L17:
        int r106 = k60.b.g();
        if (r106 != 0) goto L24;
        if (k60.b.b() == false) goto L22;
        k60.b.i();
        return;
    L22:
        k60.b.j(g().f107211c);
        return;
    L24:
        if (r106 != 1) goto L27;
        k60.b.i();
        return;
    L27:
        if (r106 != 2) goto L30;
        int r107 = cu2.a.f465419a;
        cu2.a.C5589a.b();
        return;
    L30:
        if (r106 != 3) goto L33;
        k60.b.i();
        return;
    L33:
        if (r106 != 4) goto L41;
        k60.b.i();
        return;
    }

    public b() {
    }

    @Override // gs2.a
    public final LiveTaskType d() {
        return LiveTaskType.MAIN;
    }
}
