package com.larus.apm.impl;

import com.bytedance.apm.impl.LaunchTraceImpl;
import com.bytedance.services.apm.api.ILaunchTrace;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J)\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b2\u000e\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\bH\u0096\u0001J)\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\f2\u000e\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\b2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J)\u0010\u000f\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b2\u000e\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\bH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0005H\u0096\u0001¨\u0006\u0011"}, d2 = {"Lcom/larus/apm/impl/ILaunchTraceImpl;", "Lcom/bytedance/services/apm/api/ILaunchTrace;", "<init>", "()V", "cancelTrace", "", "endSpan", "p0", "", "kotlin.jvm.PlatformType", "p1", "endTrace", "", "p2", "", "startSpan", "startTrace", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ILaunchTraceImpl implements ILaunchTrace {
    private final /* synthetic */ LaunchTraceImpl $$delegate_0;

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void cancelTrace() {
        this.$$delegate_0.cancelTrace();
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void endSpan(String r100, String r101) {
        this.$$delegate_0.endSpan(r100, r101);
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void endTrace(int r100, String r101, long r102) {
        this.$$delegate_0.endTrace(r100, r101, r102);
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void startSpan(String r100, String r101) {
        this.$$delegate_0.startSpan(r100, r101);
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void startTrace() {
        this.$$delegate_0.startTrace();
    }

    public ILaunchTraceImpl() {
        this.$$delegate_0 = new LaunchTraceImpl();
    }
}
