package com.ss.cast.source;

import com.byted.cast.common.ContextManager;
import com.byted.cast.common.api.ICastSource;
import com.byted.cast.common.source.IClient;
import com.ss.cast.sourcecommon.monitor.SourceMonitor;

/* JADX INFO: loaded from: classes40.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ICastSource f456573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ICastSource f456574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IClient f456575c;

    public g(ContextManager.CastContext r100) {
        ContextManager.getMonitor(r100);
        ContextManager.getLogger(r100);
        SourceMonitor.b(r100);
    }
}
