package pl.droidsonroids.gif;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes41.dex */
public final class h extends PThreadScheduledThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f529731a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f529732a = null;

        static {
            f529732a = new h();
        }
    }

    public h() {
        super(1, new DefaultThreadFactory("GifRenderingExecutor"), new ThreadPoolExecutor.DiscardPolicy());
    }
}
