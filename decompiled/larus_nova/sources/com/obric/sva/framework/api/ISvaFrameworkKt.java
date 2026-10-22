package com.obric.sva.framework.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"svaFrameworkDelegate", "Lcom/obric/sva/framework/api/ISvaFramework;", "getSvaFrameworkDelegate", "()Lcom/obric/sva/framework/api/ISvaFramework;", "api_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ISvaFrameworkKt {
    public static final ISvaFramework getSvaFrameworkDelegate() {
        return (ISvaFramework) ServiceManager.get().getService(ISvaFramework.class);
    }
}
