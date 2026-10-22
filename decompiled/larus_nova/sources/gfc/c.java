package gfc;

import android.content.Intent;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.trace.Constants;
import com.bytedance.android.service.manager.push.trace.PushTraceSceneType;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.t;
import com.bytedance.push.third.g;
import com.bytedance.push.utils.f;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f481086a;

    public final void a() {
        PushServiceManager.get().getPushTraceExternalService().getTraceScene(PushTraceSceneType.ALLIANCE_WAKEUP).enterNode(Constants.NODE_PUSH_PROCESS_STARTED, "The push process is started");     // Catch: Exception -> L5
        f.b("NotifyService", "onServiceStart");     // Catch: Exception -> L5
        t.b().d(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication);     // Catch: Exception -> L5
        g.g().d(this.f481086a);     // Catch: Throwable -> L8
        return;
    L14:
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(Intent r100) {
        this.f481086a = r100;
    }
}
