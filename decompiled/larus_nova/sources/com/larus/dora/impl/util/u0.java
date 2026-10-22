package com.larus.dora.impl.util;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes4.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f338159a = null;

    static {
        f338159a = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("l/ThreadUtils"));
    }
}
