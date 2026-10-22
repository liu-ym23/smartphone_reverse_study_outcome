package e97;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ExecutorService f471515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ExecutorService f471516b;

    public c() {
    }

    public static ExecutorService a() {
        if (f471515a != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f471515a != null) goto L9;
        f471515a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("ExecutorServiceUtils"));     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f471515a;
    }

    public static ExecutorService b() {
        if (f471516b != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f471516b != null) goto L9;
        f471516b = PThreadExecutorsUtils.newScheduledThreadPool(1, new h());     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f471516b;
    }
}
