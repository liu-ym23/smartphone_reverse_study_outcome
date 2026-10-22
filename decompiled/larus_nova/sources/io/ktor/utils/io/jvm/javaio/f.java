package io.ktor.utils.io.jvm.javaio;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes41.dex */
public final class f extends CoroutineDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f492127a = null;

    static {
        f492127a = new f();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean isDispatchNeeded(CoroutineContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return true;
    }

    public f() {
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "block");
        r101.run();
    }
}
