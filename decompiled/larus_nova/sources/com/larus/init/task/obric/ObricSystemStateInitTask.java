package com.larus.init.task.obric;

import bf6.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/larus/init/task/obric/ObricSystemStateInitTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "run", "", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSystemStateInitTask extends d {
    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    L14:
        return;
    L3:
        if (ObricFeatureServiceDelegate.f387839b.c() == false) goto L10;
        FLogger.f375446a.i("ObricSystemStateInitTask", "systemStateInit");     // Catch: Throwable -> L7
        IAssistantInteractionServiceKt.getAssistantInteractionServiceProxy().systemStateInit();     // Catch: Throwable -> L7
        return;
    }

    public ObricSystemStateInitTask() {
    }
}
