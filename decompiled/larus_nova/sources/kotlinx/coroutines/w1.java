package kotlinx.coroutines;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class w1 {
    public static final ExecutorCoroutineDispatcher a(final int r100, final String r101) {
        boolean r102 = true;
        if (r100 >= 1) goto L6;
        r102 = false;
    L6:
        if (r102 == false) goto L10;
        final AtomicInteger r103 = new AtomicInteger();
        return ExecutorsKt.from(PThreadExecutorsUtils.newScheduledThreadPool(r100, new x1(r100, r101, r103)));
    L10:
        throw new IllegalArgumentException(("Expected at least one thread, but " + r100 + " specified").toString());
    }
}
