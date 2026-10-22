package io.ktor.client.utils;

import com.ss.android.lark.utils.statistics.PerfLog;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.k;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes41.dex */
public final class a {
    public static final io.ktor.utils.io.b a(ByteReadChannel r100, CoroutineContext r101, Long r102, Function3 r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "listener");
        return k.a(GlobalScope.INSTANCE, r101, true, new ByteChannelUtilsKt$observable$1(r102, r100, r103, null)).f492055b;
    }
}
