package com.larus.im;

import kotlin.Metadata;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/larus/im/IInstantMessenger;", "", "connectionState", "Lkotlinx/coroutines/flow/Flow;", "Lcom/larus/im/bean/IMConnectState;", "cmdReceiveFlow", "Lcom/larus/im/bean/IMCmd;", "frontierConnected", "", "triggerConnectFrontier", "", "getFrontier", "Lcom/larus/im/IFrontierService;", "serviceId", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IInstantMessenger {
    com.larus.im.network.f a(int r100);

    boolean b();

    StateFlowImpl c();

    void d();

    MutableSharedFlow e();
}
