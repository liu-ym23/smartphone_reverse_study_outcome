package li1;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.performance.TimeCostUtil;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.HashMap;
import jc1.k;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends com.bytedance.android.livesdk.room.Task.base.a<ls2.d, com.bytedance.android.livesdk.chatroom.newcontainer.business.common.basecomponents.session.e> {
    @Override // gs2.a
    public final String taskID() {
        return "PerformanceMonitorInitTask";
    }

    @Override // gs2.a
    public final void run() {
        ls2.d r100 = h();
        if (r100 == null) goto L24;
        IFeatureService r101 = (IFeatureService) k.f(IFeatureService.class);
        if (r101 == null) goto L7;
        r101.onLiveRoomFragmentCreate(r100.f510526o);
    L7:
        IPerformanceManager r102 = (IPerformanceManager) k.f(IPerformanceManager.class);
        if (r102 == null) goto L10;
        r102.startLoadStallMonitor(r100.f510515d);
    L10:
        IPerformanceManager r103 = (IPerformanceManager) k.f(IPerformanceManager.class);
        if (r103 == null) goto L14;
        r103.startMkStallMonitor(r100.f510515d);
    L14:
        if (r100.f510525n == null) goto L24;
        com.bytedance.android.live.core.performance.a r104 = com.bytedance.android.live.core.performance.a.f65108a;
        TimeCostUtil.Tag r105 = TimeCostUtil.Tag.StartLivePlay;
        r105.name();
        Object r106 = r100.f510525n;
        Object r107 = null;
        if ((r106 instanceof LifecycleOwner) == true) goto L18;
        r106 = null;
    L18:
        r104.getClass();
        ((LifecycleOwner) r106).getLifecycle();
        r105.name();
        Context r108 = r100.f510525n;
        if ((r108 instanceof LifecycleOwner) == false) goto L22;
        r107 = r108;
    L22:
        r104.getClass();
        ((LifecycleOwner) r107).getLifecycle();
    L24:
        if (com.bytedance.android.livesdk.config.setting.a.a() == true) goto L26;
    L30:
        TimeCostUtil.Tag r109 = TimeCostUtil.Tag.LiveFeedInit;
        int r110 = TimeCostUtil.f65106a;
        HashMap r111 = new HashMap();
        r111.put("page_name", "live room pager");
        b0.o().b("ttlive_page", r111);
        return;
    L26:
        if (k.f(IPerformanceManager.class) == null) goto L30;
        IPerformanceManager r112 = (IPerformanceManager) k.f(IPerformanceManager.class);
        if (r112 == null) goto L30;
        r112.setIsAnchor(false);
        goto L30
    }

    public a() {
    }

    @Override // gs2.a
    public final LiveTaskType d() {
        return LiveTaskType.MAIN;
    }
}
