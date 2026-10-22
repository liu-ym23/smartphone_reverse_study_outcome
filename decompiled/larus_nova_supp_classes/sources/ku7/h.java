package ku7;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class h {
    public static final Executor a = null;
    public static final Executor b = null;

    static {
        a = PThreadExecutorsUtils.newSingleThreadExecutor(new f());
        b = PThreadExecutorsUtils.newSingleThreadExecutor(new g());
    }
}
