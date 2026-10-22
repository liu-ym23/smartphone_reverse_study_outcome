package ku7;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Executor f506224a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Executor f506225b = null;

    static {
        f506224a = PThreadExecutorsUtils.newSingleThreadExecutor(new f());
        f506225b = PThreadExecutorsUtils.newSingleThreadExecutor(new g());
    }
}
