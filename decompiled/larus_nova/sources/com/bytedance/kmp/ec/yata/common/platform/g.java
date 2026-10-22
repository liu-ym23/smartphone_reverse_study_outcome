package com.bytedance.kmp.ec.yata.common.platform;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements x96.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f251539a;

    public g() {
        this.f251539a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("YataPlatformExpectUtils$createSingleThread$1"));
    }

    @Override // x96.b
    public final void a(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        this.f251539a.execute(new f(r100));
    }
}
