package com.ss.cast.source.api;

import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Dispatcher;
import com.byted.cast.common.TeaEventTrack;
import com.byted.cast.common.auth.AuthConstants;
import com.byted.cast.common.source.ServiceInfo;
import com.ss.cast.source.ByteCastSourceImpl;
import java.util.UUID;

/* JADX INFO: loaded from: classes40.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteCastSourceImpl f456561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ContextManager.CastContext f456562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CastMonitor f456563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TeaEventTrack f456564d;

    public i() {
        new ServiceInfo();
        ContextManager.CastContext r100 = new ContextManager.CastContext(AuthConstants.SERVICE_SOURCE_PROTOCOL_PREFIX + UUID.randomUUID().toString());
        this.f456562b = r100;
        ContextManager.getLogger(r100);
        this.f456563c = ContextManager.getMonitor(r100);
        TeaEventTrack r101 = ContextManager.getTeaEventTrack(r100);
        this.f456564d = r101;
        r101.isSource = Boolean.TRUE;
        Dispatcher.enableCompatibleConfig("source");
        this.f456561a = new ByteCastSourceImpl(this.f456562b);
    }
}
