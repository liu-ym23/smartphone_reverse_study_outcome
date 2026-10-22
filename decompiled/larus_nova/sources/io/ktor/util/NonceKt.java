package io.ktor.util;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.k1;

/* JADX INFO: loaded from: classes41.dex */
public final class NonceKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f491940a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Channel<String> f491941b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Job f491942c = null;

    static {
        f491940a = CollectionsKt.listOf(new String[]{"NativePRNGNonBlocking", "WINDOWS-PRNG", "DRBG"});
        f491941b = ChannelKt.Channel$default(1024, null, null, 6, null);
        a0 r100 = new a0("nonce-generator");
        f491942c = BuildersKt.launch(GlobalScope.INSTANCE, Dispatchers.getIO().plus(k1.f504992a).plus(r100), CoroutineStart.LAZY, new NonceKt$nonceGeneratorJob$1(null));
    }
}
