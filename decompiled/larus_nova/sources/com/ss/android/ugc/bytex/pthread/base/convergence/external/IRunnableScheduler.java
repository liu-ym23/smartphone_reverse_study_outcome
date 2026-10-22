package com.ss.android.ugc.bytex.pthread.base.convergence.external;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.dumper.Scraps;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J5\u0010\b\u001a\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\t\"\u0004\b\u0000\u0010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u0002H\n2\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\rJ.\u0010\b\u001a\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\t\"\u0004\b\u0000\u0010\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H&J2\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0006\u001a\u00020\u0007H&J@\u0010\u0010\u001a\n\u0012\u0004\u0012\u0002H\u0016\u0018\u00010\u0011\"\u0004\b\u0000\u0010\u00162\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u0002H\u0016\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0006\u001a\u00020\u0007H&J:\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0006\u001a\u00020\u0007H&J:\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u001b"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/external/IRunnableScheduler;", "", "execute", "", "command", "Ljava/lang/Runnable;", "threadPoolExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "newTaskFor", "Ljava/util/concurrent/RunnableFuture;", ExifInterface.GPS_DIRECTION_TRUE, "runnable", "value", "(Ljava/lang/Runnable;Ljava/lang/Object;Ljava/util/concurrent/ThreadPoolExecutor;)Ljava/util/concurrent/RunnableFuture;", "callable", "Ljava/util/concurrent/Callable;", MonitorConstants.SCHEDULE, "Ljava/util/concurrent/ScheduledFuture;", "delay", "", Scraps.INNER_UNIT, "Ljava/util/concurrent/TimeUnit;", "V", "scheduleAtFixedRate", "initialDelay", "period", "scheduleWithFixedDelay", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public interface IRunnableScheduler {
    boolean execute(Runnable r100, ThreadPoolExecutor r101);

    <T> RunnableFuture<T> newTaskFor(Runnable r100, T r101, ThreadPoolExecutor r102);

    <T> RunnableFuture<T> newTaskFor(Callable<T> r100, ThreadPoolExecutor r101);

    ScheduledFuture<?> schedule(Runnable r100, long r101, TimeUnit r102, ThreadPoolExecutor r103);

    <V> ScheduledFuture<V> schedule(Callable<V> r100, long r101, TimeUnit r102, ThreadPoolExecutor r103);

    ScheduledFuture<?> scheduleAtFixedRate(Runnable r100, long r101, long r102, TimeUnit r103, ThreadPoolExecutor r104);

    ScheduledFuture<?> scheduleWithFixedDelay(Runnable r100, long r101, long r102, TimeUnit r103, ThreadPoolExecutor r104);
}
