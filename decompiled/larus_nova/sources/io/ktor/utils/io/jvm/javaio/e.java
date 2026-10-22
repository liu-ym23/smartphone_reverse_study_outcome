package io.ktor.utils.io.jvm.javaio;

import com.ss.android.lark.utils.statistics.PerfLog;
import io.ktor.utils.io.k;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes41.dex */
public final class e {
    public static io.ktor.utils.io.b a(InputStream r100) {
        CoroutineDispatcher r101 = Dispatchers.getIO();
        io.ktor.utils.io.pool.a.C6314a r102 = io.ktor.utils.io.pool.a.f492133a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "pool");
        return k.a(GlobalScope.INSTANCE, r101, true, new ReadingKt$toByteReadChannel$2(r102, r100, null)).f492055b;
    }
}
