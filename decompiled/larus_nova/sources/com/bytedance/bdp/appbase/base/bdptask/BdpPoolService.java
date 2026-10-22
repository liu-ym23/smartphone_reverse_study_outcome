package com.bytedance.bdp.appbase.base.bdptask;

import com.bytedance.bdp.bdpbase.service.IBdpService;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/BdpPoolService;", "Lcom/bytedance/bdp/bdpbase/service/IBdpService;", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public interface BdpPoolService extends IBdpService {
    void H0(int r100, boolean r101);

    void T();

    Object U(int r100, long r101, TimeUnit r102) throws ExecutionException, InterruptedException;

    Object V1(int r100) throws ExecutionException, InterruptedException;

    void a0(TaskExecuteStatusListener r100);

    void d1();

    PoolStatus f1(BdpTask.TaskType r100);

    void h1(int r100);

    BdpTask j1();

    void k0(int r100, boolean r101);

    int m(int r100);

    int m1(BdpTask.TaskType r100);

    Thread.UncaughtExceptionHandler n2();

    void o1(Runnable r100, boolean r101);

    int s1(BdpTask r100);

    void setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler r100);

    <T> void y1(List<? extends Future<T>> r100);
}
