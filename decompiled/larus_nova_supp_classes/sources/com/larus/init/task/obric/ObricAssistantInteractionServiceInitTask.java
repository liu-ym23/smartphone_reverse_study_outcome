package com.larus.init.task.obric;

import android.util.EventsUtils;
import bf6.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.lifecycle.ILifecycleService;
import java.util.Iterator;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/larus/init/task/obric/ObricAssistantInteractionServiceInitTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "run", XmlPullParser.NO_NAMESPACE, "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ObricAssistantInteractionServiceInitTask extends d {

    public static final class a {
    }

    static {
    }

    public static void c() {
        if (ObricFeatureServiceDelegate.b.c() == true) goto L5;
        return;
    L5:
        FLogger.a.d("ObricAssistantInteractionServiceInitTask", "run----------> with " + AppHost.a.getApplication());
        Iterator r0 = IAssistantInteractionServiceKt.getAssistantInteractionServiceProxy().getLifecycleServices().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ILifecycleService r1 = (ILifecycleService) r0.next();
        r1.init(AppHost.a.getApplication());
        r1.start();
        goto L7
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

    public ObricAssistantInteractionServiceInitTask() {
    }
}
