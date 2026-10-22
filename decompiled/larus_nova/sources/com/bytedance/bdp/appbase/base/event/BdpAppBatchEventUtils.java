package com.bytedance.bdp.appbase.base.event;

import com.bytedance.bdp.appbase.base.bdptask.BdpTask;
import com.bytedance.bdp.appbase.base.bdptask.j;
import com.bytedance.bdp.bdpbase.ipc.r;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.util.i;
import com.bytedance.bdp.serviceapi.defaults.event.BdpEventService;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class BdpAppBatchEventUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BdpEventService f200537a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BdpTask f200538b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Queue<JSONObject> f200539c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Integer f200540d;

    public static class ICallHostBatchEventImpl implements r {
        public ICallHostBatchEventImpl() {
        }

        public void batchSendEventV3(String r100, String r101) {
            BdpAppBatchEventUtils.f200538b.newBuilder().runnable(new a(r101, r100)).start();
        }
    }

    static {
        i.d(z84.a.a());
        f200537a = (BdpEventService) BdpManager.getInst().getService(BdpEventService.class);
        f200538b = new BdpTask.Builder().group(new j(1)).onCPU().build();
        f200539c = new ConcurrentLinkedQueue();
        f200540d = null;
    }
}
