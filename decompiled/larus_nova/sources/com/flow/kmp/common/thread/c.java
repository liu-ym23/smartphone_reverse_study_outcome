package com.flow.kmp.common.thread;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final ExecutorCoroutineDispatcher a(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new b(r100)));
    }
}
