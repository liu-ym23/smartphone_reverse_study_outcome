package com.bytedance.caijing.sdk.infra.base.api.task;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import java.util.concurrent.Future;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J-\u0010\u0006\u001a\n\u0012\u0004\u0012\u0002H\b\u0018\u00010\u0007\"\u0004\b\u0000\u0010\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u0002H\bH&¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/task/CJThreadService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "executeCPU", "", "task", "Ljava/lang/Runnable;", "executeCPUFuture", "Ljava/util/concurrent/Future;", "R", "result", "(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurrent/Future;", "executeIO", "executeLogic", "removeCPU", "removeIO", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJThreadService extends ICJService {
    void executeCPU(Runnable r100);

    <R> Future<R> executeCPUFuture(Runnable r100, R r101);

    void executeIO(Runnable r100);

    void executeLogic(Runnable r100);

    void removeCPU(Runnable r100);

    void removeIO(Runnable r100);
}
