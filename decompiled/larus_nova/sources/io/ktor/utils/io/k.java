package io.ktor.utils.io;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes41.dex */
public final class k {
    public static final f a(CoroutineScope r110, CoroutineContext r111, boolean r112, Function2 r113) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "coroutineContext");
        Intrinsics.checkNotNullParameter(r113, "block");
        final ByteBufferChannel r100 = new ByteBufferChannel(r112, io.ktor.utils.io.internal.f.f492077c, 8);
        Job r114 = BuildersKt.launch$default(r110, r111, null, new CoroutinesKt$launchChannel$job$1(true, r100, r113, (CoroutineDispatcher) r110.getCoroutineContext().get(CoroutineDispatcher.Key), null), 2, null);
        r114.invokeOnCompletion(new CoroutinesKt$launchChannel$1(r100));
        return new f(r114, r100);
    }
}
