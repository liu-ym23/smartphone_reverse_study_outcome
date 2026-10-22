package io.ktor.client.engine;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.ktor.util.i;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.a0;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
final class HttpClientEngineBase$coroutineContext$2 extends Lambda implements Function0<CoroutineContext> {
    final /* synthetic */ b this$0;

    public HttpClientEngineBase$coroutineContext$2(b r100) {
        this.this$0 = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CoroutineContext invoke2() {
        CoroutineContext r100 = SupervisorKt.SupervisorJob(null).plus(new i(CoroutineExceptionHandler.Key));
        this.this$0.getClass();
        CoroutineContext r101 = r100.plus(null);
        this.this$0.getClass();
        return r101.plus(new a0("null-context"));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ CoroutineContext invoke() {
        return invoke2();
    }
}
