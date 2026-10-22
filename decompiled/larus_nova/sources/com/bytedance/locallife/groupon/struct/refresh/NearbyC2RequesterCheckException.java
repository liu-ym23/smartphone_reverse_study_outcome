package com.bytedance.locallife.groupon.struct.refresh;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/refresh/NearbyC2RequesterCheckException;", "Ljava/util/concurrent/CancellationException;", "Lkotlin/coroutines/cancellation/CancellationException;", "prefetchType", "Lcom/bytedance/locallife/groupon/struct/refresh/NearbyC2PrefetchType;", "interruptionReason", "", "(Lcom/bytedance/locallife/groupon/struct/refresh/NearbyC2PrefetchType;Ljava/lang/String;)V", "getInterruptionReason", "()Ljava/lang/String;", "getPrefetchType", "()Lcom/bytedance/locallife/groupon/struct/refresh/NearbyC2PrefetchType;", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class NearbyC2RequesterCheckException extends CancellationException {
    private final String interruptionReason;
    private final NearbyC2PrefetchType prefetchType;

    public final String getInterruptionReason() {
        return this.interruptionReason;
    }

    public final NearbyC2PrefetchType getPrefetchType() {
        return this.prefetchType;
    }

    public NearbyC2RequesterCheckException(NearbyC2PrefetchType r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "interruptionReason");
        this.prefetchType = r100;
        this.interruptionReason = r101;
    }
}
