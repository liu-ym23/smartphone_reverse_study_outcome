package com.ss.android.ugc.aweme.search.vision.util;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/util/ThreadUtils;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ThreadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ExecutorService f454047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadUtils f454048b = null;

    private ThreadUtils() {
    }

    static {
        f454048b = new ThreadUtils();
    }

    public static ExecutorService a() {
        if (f454047a != null) goto L16;
        monitor-enter(ThreadUtils.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f454047a != null) goto L9;
        f454047a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("l/ThreadUtils"));     // Catch: Throwable -> L12
    L9:
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(ThreadUtils.class);
    L16:
        return f454047a;
    }
}
