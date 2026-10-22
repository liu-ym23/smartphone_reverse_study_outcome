package im2;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes11.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f490513a;

    public final void a() {
        this.f490513a.shutdownNow();
    }

    public n() {
        this.f490513a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("SingleTaskExecutorServiceProvider"));
    }
}
