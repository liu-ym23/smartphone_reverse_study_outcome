package com.heytap.mcssdk.utils;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes23.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExecutorService f276431a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Handler f276432b;

    static {
        f276431a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("cssdk/utils/f"));
        f276432b = new Handler(Looper.getMainLooper());
    }

    public f() {
    }

    public static void a(Runnable r100) {
        f276431a.execute(r100);
    }

    public static void b(Runnable r100) {
        f276432b.post(r100);
    }
}
