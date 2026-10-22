package com.larus.init.task;

import android.util.EventsUtils;
import bf6.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.utils.i2;
import com.larus.common.apphost.AppHost;
import com.larus.settings.value.e10;
import com.larus.settings.value.kw;
import com.larus.settings.value.rt;
import com.larus.ui.arch.component.external.api.receiver.Container;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.ui.arch.modulizer.di.IComponentRegistry;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/larus/init/task/InitComponentArchTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", XmlPullParser.NO_NAMESPACE, "getScene", "()Ljava/lang/String;", "runInternal", XmlPullParser.NO_NAMESPACE, "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitComponentArchTask extends d implements bg9.i {
    public final String a;

    public static final class a {
    }

    static {
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        FLogger.a.i("InitComponentArchTask", "[runInternal] start");
        boolean r0 = x1a.a.a;
        x1a.a.a = AppHost.a.isDebug();
        e10 r1 = e10.a;
        x1a.a.b = e10.W().e();
        boolean r2 = s1a.c.a;
        int r3 = l0.a;
        s1a.c.a = ((Boolean) l0.a(Boolean.FALSE, new kw())).booleanValue();
        x1a.a.c = new b();
        u1a.d r4 = u1a.d.a;
        u1a.d.e = ((Boolean) l0.a(Boolean.TRUE, new rt())).booleanValue();
        IComponentRegistry.a.getClass();
        IComponentRegistry.a.d();
        if (i2.a().f() == false) goto L21;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L12
        ContainerFilter r6 = ContainerFilter.DEFAULT;     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r6, "filter");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r6, "filter");     // Catch: Throwable -> L12
        monitor-enter(r4);     // Catch: Throwable -> L12
        Container r7 = u1a.d.b(r6);     // Catch: Throwable -> L9
        u1a.d.d.put(r6, r7);     // Catch: Throwable -> L9
        monitor-exit(r4);     // Catch: Throwable -> L12
        Object r8 = Result.m49constructorimpl(r7);     // Catch: Throwable -> L12
    L14:
        Throwable r9 = Result.m52exceptionOrNullimpl(r8);
        if (r9 == null) goto L22;
        FLogger.a.e("InitComponentArchTask", "preBuildDefaultContainer error", r9);
        return;
    L22:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public InitComponentArchTask() {
        this.a = "Message";
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
