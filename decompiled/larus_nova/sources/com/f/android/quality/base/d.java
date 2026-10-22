package com.f.android.quality.base;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Executor f274066a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Executor f274067b = null;

    static {
        f274066a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("ThreadManager"));
        f274067b = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("ThreadManager"));
    }
}
