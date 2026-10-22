package com.larus.business.multitask_management.impl.spi;

import com.larus.im.IInstantMessenger;
import com.larus.im.bean.IMConnectState;
import com.larus.multitask_management.api.spi.IMultiTaskFrontierService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/larus/business/multitask_management/impl/spi/MultiTaskFrontierServiceImpl;", "Lcom/larus/multitask_management/api/spi/IMultiTaskFrontierService;", "<init>", "()V", "connectionState", "Lkotlinx/coroutines/flow/Flow;", "Lcom/larus/multitask_management/api/spi/IMConnectState;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiTaskFrontierServiceImpl implements IMultiTaskFrontierService {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f321127a = null;

        static {
            int[] r100 = new int[IMConnectState.values().length];
            r100[IMConnectState.CONNECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[IMConnectState.CONNECTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[IMConnectState.DISCONNECTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f321127a = r100;
        }
    }

    public MultiTaskFrontierServiceImpl() {
    }

    @Override // com.larus.multitask_management.api.spi.IMultiTaskFrontierService
    public final Flow<com.larus.multitask_management.api.spi.IMConnectState> c() {
        IInstantMessenger r100 = (IInstantMessenger) ServiceManager.get().getService(IInstantMessenger.class);
        if (r100 == null) goto L8;
        final StateFlowImpl r101 = r100.c();
        if (r101 == null) goto L8;
        return new MultiTaskFrontierServiceImpl$connectionState$$inlined$map$1(r101);
    L8:
        return j1.a(com.larus.multitask_management.api.spi.IMConnectState.DISCONNECTED);
    }
}
