package fpa;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f478390a = null;

    static {
        f478390a = PThreadExecutorsUtils.newFixedThreadPool(10, new DefaultThreadFactory("GlobalThreadExecutor"));
    }
}
