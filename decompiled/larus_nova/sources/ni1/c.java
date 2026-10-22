package ni1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.le;
import com.bytedance.android.livesdk.config.ms;
import com.bytedance.android.livesdk.config.vy0;
import com.bytedance.android.livesdk.config.yy0;
import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import com.bytedance.android.livesdk.utils.i5;
import com.bytedance.android.livesdkapi.service.IAcceleratedService;
import com.bytedance.android.livesdkapi.service.ISummerService;
import jc1.k;
import ls2.d;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends com.bytedance.android.livesdk.room.Task.base.a<d, ls2.c> {
    @Override // gs2.a
    public final String taskID() {
        return "ObjectAcceleratedOptInitTask";
    }

    @Override // gs2.a
    public final void run() {
        if (ms.f120779a.getValue().booleanValue() == false) goto L8;
        IAcceleratedService r100 = (IAcceleratedService) k.f(IAcceleratedService.class);
        if (r100 == null) goto L30;
        r100.getGlobalLiveLifecycle(1).onExit();
        return;
    L30:
        return;
    L8:
        if (i5.a("widget_preload") == false) goto L16;
        if (vy0.f121487a.getValue().booleanValue() == false) goto L16;
        if (k.f(ISummerService.class) == null) goto L14;
        ALogger.i("BDLog", "ObjectAcceleratedOptInitTask Async cancelTask");
        ((ISummerService) k.f(ISummerService.class)).cancelTask(1);
        goto L16
    L14:
        ALogger.e("BDLog", "ObjectAcceleratedOptInitTask Async cancelTask failed");
    L16:
        if (yy0.f121725a.getValue().booleanValue() == false) goto L22;
        if (k.f(ISummerService.class) == null) goto L20;
        ALogger.i("BDLog", "ObjectAcceleratedOptInitTask Sync cancelTask");
        ((ISummerService) k.f(ISummerService.class)).cancelTask(2);
        goto L22
    L20:
        ALogger.e("BDLog", "ObjectAcceleratedOptInitTask Sync cancelTask failed");
    L22:
        if (i5.a("assets_preload") == true) goto L24;
        return;
    L24:
        if (le.f120672a.getValue().booleanValue() == true) goto L26;
        return;
    L26:
        if (k.f(ISummerService.class) == null) goto L28;
        ALogger.i("BDLog", "ObjectAcceleratedOptInitTask Sync cancelTask");
        ((ISummerService) k.f(ISummerService.class)).cancelTask(4);
        return;
    L28:
        ALogger.e("BDLog", "ObjectAcceleratedOptInitTask Sync cancelTask failed");
    }

    public c() {
    }

    @Override // gs2.a
    public final LiveTaskType d() {
        return LiveTaskType.MAIN;
    }
}
