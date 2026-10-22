package com.larus.multitask_management.api.customize;

import com.ss.android.lark.utils.statistics.PerfLog;
import jl9.b;
import kotlin.Metadata;
import pd6.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u000b\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/larus/multitask_management/api/customize/ITaskUIFactory;", "Lcom/bytedance/kmp/spi/IKmpService;", "priority", "", "getPriority", "()I", "createTaskUI", "Lcom/larus/multitask_management/api/customize/ITaskView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/multitask_management/api/customize/TaskUIContext;", "Lcom/larus/multitask_management/api/customize/ITaskContext;", "taskUITemplate", "multitask_management_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ITaskUIFactory extends a {
    jl9.a P2(b r100, int r101);

    int getPriority();
}
