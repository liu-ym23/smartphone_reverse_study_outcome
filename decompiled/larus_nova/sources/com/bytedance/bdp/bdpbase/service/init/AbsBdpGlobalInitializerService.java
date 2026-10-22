package com.bytedance.bdp.bdpbase.service.init;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/bdp/bdpbase/service/init/AbsBdpGlobalInitializerService;", "Lcom/bytedance/bdp/bdpbase/service/init/BdpGlobalInitializerService;", "<init>", "()V", "bdp-base_release"}, k = 1, mv = {1, 4, 0})
public abstract class AbsBdpGlobalInitializerService implements BdpGlobalInitializerService {
    public AbsBdpGlobalInitializerService() {
        new AtomicBoolean(false);
    }
}
