package com.larus.agents.impl.webfetch;

import com.larus.agents.api.ILocalWebFetchService;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/larus/agents/impl/webfetch/LocalWebFetchServiceImpl;", "Lcom/larus/agents/api/ILocalWebFetchService;", "<init>", "()V", "initialize", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalWebFetchServiceImpl implements ILocalWebFetchService {
    public LocalWebFetchServiceImpl() {
    }

    @Override // com.larus.agents.api.ILocalWebFetchService
    public final void initialize() {
        c r100 = c.f286844a;
        monitor-enter(r100);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (c.f286849f == null) goto L10;
        FLogger.f375446a.i("WebPageFetch", "runtime_initialize_skipped reason=already_initialized");     // Catch: Throwable -> L17
        monitor-exit(r100);
        return;
    L10:
        if (c.f286848e == false) goto L14;
        FLogger.f375446a.i("WebPageFetch", "runtime_initialize_skipped reason=already_scheduled");     // Catch: Throwable -> L17
        monitor-exit(r100);
        return;
    L14:
        c.f286848e = c.f286845b.post(c.f286846c);     // Catch: Throwable -> L17
        FLogger.f375446a.i("WebPageFetch", "runtime_initialize_scheduled accepted=" + c.f286848e);     // Catch: Throwable -> L17
        monitor-exit(r100);
    }
}
