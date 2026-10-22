package com.larus.init.task;

import android.util.EventsUtils;
import bf6.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.platform.spi.IAIChatService;
import fq9.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import xp9.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/larus/init/task/InitMarkdownTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", XmlPullParser.NO_NAMESPACE, "getScene", "()Ljava/lang/String;", "runInternal", XmlPullParser.NO_NAMESPACE, "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitMarkdownTask extends d implements bg9.i {
    public final String a;

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        int r0 = xp9.m.a;
        gw8.c.a r1 = gw8.c.a;
        xp9.k r2 = new xp9.k();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "logger");
        gw8.c.a.d = r2;
        l r3 = new l();
        Intrinsics.checkNotNullParameter(r3, "ensureManager");
        gw8.c.a.e = r3;
        gw8.c r4 = gw8.c.a.b();
        if (r4 == null) goto L7;
        r r5 = new r();
        r4.init(AppHost.a.getApplication(), r5);
        if (((Boolean) r5.r.getValue()).booleanValue() == false) goto L7;
        r4.registerInjectParser(gq9.c.a);
    L7:
        IAIChatService.a.j7();
    }

    public InitMarkdownTask() {
        this.a = "Basic";
    }

    @Override // java.lang.Runnable, bg9.i
    public final void run() {
        bg9.i.a.a(this);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.a;
    }
}
