package com.larus.init.task.obric;

import android.util.EventsUtils;
import bf6.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;
import uha.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/larus/init/task/obric/DoraCoWakeupTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "run", XmlPullParser.NO_NAMESPACE, "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class DoraCoWakeupTask extends d {
    public static void c() {
        if (ObricFeatureServiceDelegate.b.c() == true) goto L5;
        return;
    L5:
        FLogger.a.i("DORA_CO_WAKEUP_TASK", "must run in main process with delegate " + a.a());
        CoWakeupApi r0 = a.a();
        if (r0 == null) goto L9;
        r0.init(AppHost.a.getApplication());
        r0.start();
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public DoraCoWakeupTask() {
    }
}
