package ida;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes32.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f489427a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f489428b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ExecutorService f489429c = null;

    static {
        f489427a = new Handler(Looper.getMainLooper());
        f489428b = new AtomicInteger();
        f489429c = PThreadExecutorsUtils.newSingleThreadExecutor(new m());
    }
}
