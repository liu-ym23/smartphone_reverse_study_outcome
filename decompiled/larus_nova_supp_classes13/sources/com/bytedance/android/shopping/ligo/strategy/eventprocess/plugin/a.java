package com.bytedance.android.shopping.ligo.strategy.eventprocess.plugin;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class a {
    public static final ExecutorService a = null;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.ligo.strategy.eventprocess.plugin.a$a, reason: collision with other inner class name */
    public static final class C0074a {
    }

    static {
        a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("AbsLigoEventProcessPlugin"));
    }
}
