package com.obric.assistant.component.task;

import com.larus.multitask_management.api.customize.ITaskUIFactory;
import com.larus.multitask_management.api.data.TaskUITemplate;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u0004\u0018\u00010\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/component/task/MultiComplexTaskUIFactory;", "Lcom/larus/multitask_management/api/customize/ITaskUIFactory;", "<init>", "()V", "priority", "", "getPriority", "()I", "createTaskUI", "Lcom/larus/multitask_management/api/customize/ITaskView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/multitask_management/api/customize/TaskUIContext;", "Lcom/larus/multitask_management/api/customize/ITaskContext;", "taskUITemplate", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiComplexTaskUIFactory implements ITaskUIFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f388782b;

    public MultiComplexTaskUIFactory() {
        this.f388782b = 1;
    }

    @Override // com.larus.multitask_management.api.customize.ITaskUIFactory
    public final int getPriority() {
        return this.f388782b;
    }

    @Override // com.larus.multitask_management.api.customize.ITaskUIFactory
    public final jl9.a P2(jl9.b r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == TaskUITemplate.OMNI_WAITING.getValue()) goto L5;
        return null;
    L5:
        return e.f388860a;
    }
}
