package com.bytedance.dataplatform;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ScheduledExecutorService f204370a = null;

    static {
        f204370a = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("atform/Worker"));
    }

    public static Future a(Runnable r100) {
        return f204370a.submit(r100);
    }
}
