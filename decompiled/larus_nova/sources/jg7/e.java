package jg7;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import xf7.n;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f499041a = null;

    public static class a extends n<ExecutorService> {
        public a() {
        }

        @Override // xf7.n
        public final ExecutorService a(Object[] r100) {
            return PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("NetThreadPool$1"));
        }
    }

    static {
        f499041a = new a();
    }
}
