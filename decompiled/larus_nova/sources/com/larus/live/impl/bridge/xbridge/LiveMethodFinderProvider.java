package com.larus.live.impl.bridge.xbridge;

import com.larus.ivykit.xbridge.IAnnieXMethodFinderProvider;
import com.larus.live.api.ILiveService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/live/impl/bridge/xbridge/LiveMethodFinderProvider;", "Lcom/larus/ivykit/xbridge/IAnnieXMethodFinderProvider;", "<init>", "()V", "createMethodFinderList", "", "", "contextProviderFactory", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveMethodFinderProvider implements IAnnieXMethodFinderProvider {
    public LiveMethodFinderProvider() {
    }

    @Override // com.larus.ivykit.xbridge.IAnnieXMethodFinderProvider
    public final List<Object> a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        ILiveService r101 = (ILiveService) ServiceManager.get().getService(ILiveService.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.d(r100);
    }
}
