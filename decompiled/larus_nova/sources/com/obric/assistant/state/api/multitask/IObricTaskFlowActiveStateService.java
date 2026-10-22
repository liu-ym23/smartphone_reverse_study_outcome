package com.obric.assistant.state.api.multitask;

import com.obric.assistant.util.r;
import kotlin.Metadata;
import zga.d;
import zga.e;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0003H&J$\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/state/api/multitask/IObricTaskFlowActiveStateService;", "", "isActive", "", "filter", "Lcom/obric/assistant/state/api/multitask/ObricTaskFlowActiveStateFilter;", "getActiveStates", "", "Lcom/obric/assistant/state/multitask/core/TaskStateEnvelope;", "Lcom/obric/assistant/state/multitask/core/TaskState;", "registerObserver", "", "observer", "Lcom/obric/assistant/state/api/multitask/ObricTaskFlowActiveStateObserver;", "sticky", "registerSyncObserver", "unregisterObserver", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricTaskFlowActiveStateService {
    void a(e r100);

    boolean b(r r100);

    void c(e r100, d r101);
}
