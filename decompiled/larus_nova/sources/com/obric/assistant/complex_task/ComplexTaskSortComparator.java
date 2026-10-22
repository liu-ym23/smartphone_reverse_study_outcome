package com.obric.assistant.complex_task;

import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.larus.multitask_management.api.data.TaskPriority;
import com.larus.multitask_management.api.spi.IMultiTaskSortComparator;
import java.util.Map;
import kl9.u;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/complex_task/ComplexTaskSortComparator;", "Lcom/larus/multitask_management/api/spi/IMultiTaskSortComparator;", "<init>", "()V", "getTaskPriority", "", "task", "Lcom/larus/multitask_management/api/data/TaskBasicInfo;", "compareTasks", "task1", "task2", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComplexTaskSortComparator implements IMultiTaskSortComparator {
    public ComplexTaskSortComparator() {
    }

    @Override // com.larus.multitask_management.api.spi.IMultiTaskSortComparator
    public final int x(u r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        if (Intrinsics.areEqual(r100.f503999u, "omni") == true) goto L6;
        return -1;
    L6:
        Map<String, String> r101 = r100.f503997s;
        String r102 = null;
        if (r101 == null) goto L9;
        String r103 = r101.get(DyVerifyEventConstants.EventParam.BIZ_SCENE);
    L11:
        if (Intrinsics.areEqual(r103, "clarify") == true) goto L21;
        Map<String, String> r104 = r100.f503997s;
        if (r104 == null) goto L16;
        r102 = r104.get(DyVerifyEventConstants.EventParam.BIZ_SCENE);
    L16:
        if (Intrinsics.areEqual(r102, "call_user") == true) goto L21;
        return TaskPriority.RUNNING_OMNI.getValue();
    L21:
        return TaskPriority.CALLING_OMNI.getValue();
    L9:
        r103 = null;
        goto L11
    }

    @Override // com.larus.multitask_management.api.spi.IMultiTaskSortComparator
    public final int u1(u r100, u r101) {
        Intrinsics.checkNotNullParameter(r100, "task1");
        Intrinsics.checkNotNullParameter(r101, "task2");
        return Intrinsics.compare(r100.f503992n, r101.f503992n);
    }
}
