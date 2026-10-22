package com.bytedance.bdp.appbase.base.bdptask;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/PoolStatus;", "", "type", "Lcom/bytedance/bdp/appbase/base/bdptask/BdpTask$TaskType;", "runningCount", "", "queueCount", "(Lcom/bytedance/bdp/appbase/base/bdptask/BdpTask$TaskType;II)V", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
public final class PoolStatus {
    public final int queueCount;
    public final int runningCount;
    public final BdpTask.TaskType type;

    public PoolStatus(BdpTask.TaskType r100, int r101, int r102) {
        this.type = r100;
        this.runningCount = r101;
        this.queueCount = r102;
    }
}
