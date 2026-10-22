package pk4;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f529656a = null;

    static {
        f529656a = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("s/ThreadUtils"));
    }

    public static void a(Runnable r100) {
        f529656a.execute(r100);
    }
}
