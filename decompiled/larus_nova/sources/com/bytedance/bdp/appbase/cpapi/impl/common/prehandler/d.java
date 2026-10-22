package com.bytedance.bdp.appbase.cpapi.impl.common.prehandler;

import com.bytedance.bdp.appbase.service.protocol.forebackground.ForeBackgroundService;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes11.dex */
public final class d extends com.bytedance.bdp.appbase.cpapi.contextservice.base.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f200787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f200788d;

    public d(com.bytedance.bdp.appbase.cpapi.contextservice.base.b r100) {
        super(r100);
        this.f200787c = "ForeBackgroundPreHandler";
        new ArrayList();
        ForeBackgroundService r101 = (ForeBackgroundService) getContext().c(ForeBackgroundService.class);
        this.f200788d = LazyKt.lazy(new ForeBackgroundPreHandler$getBackgroundInvokeApiConfigs$2(this));
        if (q94.a.f532096b == false) goto L5;
        g94.b.a("ForeBackgroundPreHandler", new Object[]{"ForeBackgroundPreHandler init"});
    L5:
        r101.b();
        monitor-enter(this);
        r101.a();     // Catch: Throwable -> L10
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
