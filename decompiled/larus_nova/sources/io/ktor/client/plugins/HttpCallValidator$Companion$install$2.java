package io.ktor.client.plugins;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import io.ktor.client.call.HttpClientCall;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\u008a@"}, d2 = {"Lio/ktor/util/pipeline/b;", "Lio/ktor/client/statement/c;", "Lio/ktor/client/call/HttpClientCall;", KtvSubElement.CONTAINER, "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidator$Companion$install$2", f = "HttpCallValidator.kt", i = {0, 1}, l = {142, 145}, m = "invokeSuspend", n = {"$this$intercept", "unwrappedCause"}, s = {"L$0", "L$0"})
final class HttpCallValidator$Companion$install$2 extends SuspendLambda implements Function3<io.ktor.util.pipeline.b<io.ktor.client.statement.c, HttpClientCall>, io.ktor.client.statement.c, Continuation<? super Unit>, Object> {
    final /* synthetic */ g $plugin;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public HttpCallValidator$Companion$install$2(g r100, Continuation<? super HttpCallValidator$Companion$install$2> r101) {
        this.$plugin = r100;
        super(3, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(io.ktor.util.pipeline.b<io.ktor.client.statement.c, HttpClientCall> r100, io.ktor.client.statement.c r101, Continuation<? super Unit> r102) {
        HttpCallValidator$Companion$install$2 r103 = new HttpCallValidator$Companion$install$2(this.$plugin, r102);
        r103.L$0 = r100;
        r103.L$1 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(io.ktor.util.pipeline.b<io.ktor.client.statement.c, HttpClientCall> r100, io.ktor.client.statement.c r101, Continuation<? super Unit> r102) {
        return invoke2(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [io.ktor.util.pipeline.b] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v8 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r102 = this.label;
        if (r102 == 0) goto L12;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L7;
        Throwable r103 = (Throwable) this.L$0;
        ResultKt.throwOnFailure(r100);
        throw r103;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        io.ktor.util.pipeline.b r104 = (io.ktor.util.pipeline.b) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L18
        r102 = r104;
    L16:
        return Unit.INSTANCE;
    L12:
        ResultKt.throwOnFailure(r100);
        io.ktor.util.pipeline.b r105 = (io.ktor.util.pipeline.b) this.L$0;
        io.ktor.client.statement.c r106 = (io.ktor.client.statement.c) this.L$1;
        this.L$0 = r105;     // Catch: Throwable -> L18
        this.label = 1;     // Catch: Throwable -> L18
        Object r107 = r105.e(r106, this);     // Catch: Throwable -> L18
        r102 = r105;
        if (r107 != r101) goto L16;
        return r101;
    L18:
        th = move-exception;
        Throwable r108 = io.ktor.client.utils.d.a(th);
        g r109 = this.$plugin;
        io.ktor.client.request.b r110 = ((HttpClientCall) r102.getContext()).c();
        this.L$0 = r108;
        this.label = 2;
        if (g.a(r109, r108, r110, this) != r101) goto L23;
        return r101;
    L23:
        throw r108;
    }
}
