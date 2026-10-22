package com.larus.reach.api;

import java.util.Set;
import kotlin.Metadata;
import ns9.t;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/larus/reach/api/ReachPresentationCapabilityProvider;", "", "pushScene", "", "getPushScene", "()Ljava/lang/String;", "requiredCapabilities", "", "Lcom/larus/reach/api/ReachPresentationCapability;", "request", "Lcom/larus/reach/api/ReachRequest;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ReachPresentationCapabilityProvider {
    String a();

    Set<ReachPresentationCapability> e(t r100);
}
