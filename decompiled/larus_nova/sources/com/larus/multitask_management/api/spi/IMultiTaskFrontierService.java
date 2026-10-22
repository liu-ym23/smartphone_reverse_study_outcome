package com.larus.multitask_management.api.spi;

import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import pd6.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/larus/multitask_management/api/spi/IMultiTaskFrontierService;", "Lcom/bytedance/kmp/spi/IKmpService;", "connectionState", "Lkotlinx/coroutines/flow/Flow;", "Lcom/larus/multitask_management/api/spi/IMConnectState;", "multitask_management_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMultiTaskFrontierService extends a {
    Flow<IMConnectState> c();
}
