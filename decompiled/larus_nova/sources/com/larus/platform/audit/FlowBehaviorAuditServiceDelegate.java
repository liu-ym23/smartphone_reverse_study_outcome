package com.larus.platform.audit;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/larus/platform/audit/FlowBehaviorAuditServiceDelegate;", "Lcom/larus/platform/audit/IFlowBehaviorAuditService;", "<init>", "()V", "service", "getService", "()Lcom/larus/platform/audit/IFlowBehaviorAuditService;", "service$delegate", "Lkotlin/Lazy;", "init", "", "api", "", "auditEvent", "event", "Lcom/larus/platform/audit/BehaviorAuditEvent;", "clearInit", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowBehaviorAuditServiceDelegate implements IFlowBehaviorAuditService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FlowBehaviorAuditServiceDelegate f365320a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365321b = null;

    private FlowBehaviorAuditServiceDelegate() {
    }

    static {
        f365320a = new FlowBehaviorAuditServiceDelegate();
        f365321b = LazyKt.lazy(new c());
    }

    @Override // com.larus.platform.audit.IFlowBehaviorAuditService
    public final void b() {
        IFlowBehaviorAuditService r100 = (IFlowBehaviorAuditService) f365321b.getValue();
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // com.larus.platform.audit.IFlowBehaviorAuditService
    public final void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        IFlowBehaviorAuditService r101 = (IFlowBehaviorAuditService) f365321b.getValue();
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.larus.platform.audit.IFlowBehaviorAuditService
    public final void init(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "api");
        IFlowBehaviorAuditService r101 = (IFlowBehaviorAuditService) f365321b.getValue();
        if (r101 == null) goto L6;
        r101.init(r100);
        return;
    }
}
