package zc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public interface e {
    ScheduledExecutorService a();

    ExecutorService b();

    ExecutorService c();

    ExecutorService getIOExecutor();
}
