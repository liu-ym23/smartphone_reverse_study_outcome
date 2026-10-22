package com.larus.multitask_management.api.spi;

import kl9.u;
import kotlin.Metadata;
import pd6.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"Lcom/larus/multitask_management/api/spi/IMultiTaskSortComparator;", "Lcom/bytedance/kmp/spi/IKmpService;", "getTaskPriority", "", "task", "Lcom/larus/multitask_management/api/data/TaskBasicInfo;", "compareTasks", "task1", "task2", "multitask_management_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMultiTaskSortComparator extends a {
    int u1(u r100, u r101);

    int x(u r100);
}
