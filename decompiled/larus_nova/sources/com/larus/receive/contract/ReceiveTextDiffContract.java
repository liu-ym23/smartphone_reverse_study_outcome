package com.larus.receive.contract;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\b"}, d2 = {"Lcom/larus/receive/contract/ReceiveTextDiffContract;", "Lcom/larus/receive/contract/IReceiveTextDiff;", "<init>", "()V", "resolveTextShare", "Lcom/larus/receive/contract/ReceiveTextDecision;", "request", "Lcom/larus/receive/contract/ReceiveTextRequest;", "receive_contract_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReceiveTextDiffContract implements IReceiveTextDiff {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReceiveTextDiffContract f367368b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IReceiveTextDiff f367369a;

    static {
        f367368b = new ReceiveTextDiffContract();
    }

    @Override // com.larus.receive.contract.IReceiveTextDiff
    public final a a(ps9.a r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        return this.f367369a.a(r100);
    }

    private ReceiveTextDiffContract() {
        IReceiveTextDiff r100 = (IReceiveTextDiff) ServiceManager.get().getService(IReceiveTextDiff.class);
        if (r100 != null) goto L5;
        r100 = new DefaultReceiveTextDiffImpl();
    L5:
        this.f367369a = r100;
    }
}
