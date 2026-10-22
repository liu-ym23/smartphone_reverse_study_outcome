package com.larus.init.task;

import com.larus.network.http.ServiceType;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/larus/init/task/InitObservePollingConfigTask;", "Lcom/larus/init/task/firstframe/IFirstFrameTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitObservePollingConfigTask implements com.larus.init.task.firstframe.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351070a;

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
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        IUgcAIGCService.f373945a.f();     // Catch: Throwable -> L4
        FLogger.f375446a.i("InitObservePollingConfigTask", "[runInternal] InitObservePollingConfigTask execute.");     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public InitObservePollingConfigTask() {
        this.f351070a = ServiceType.UGC;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.f351070a;
    }

    @Override // bg9.i, java.lang.Runnable
    public final void run() {
        bg9.i.a.a(this);
    }
}
