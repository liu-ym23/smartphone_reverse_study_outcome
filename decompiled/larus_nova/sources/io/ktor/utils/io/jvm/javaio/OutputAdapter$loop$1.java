package io.ktor.utils.io.jvm.javaio;

import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes41.dex */
public final class OutputAdapter$loop$1 extends BlockingAdapter {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ OutputAdapter f492123g;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [io.ktor.utils.io.jvm.javaio.BlockingAdapter, io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [io.ktor.utils.io.jvm.javaio.BlockingAdapter, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8, types: [io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0093 -> B:21:0x0048). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0097 -> B:21:0x0048). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00ae -> B:21:0x0048). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.jvm.javaio.BlockingAdapter
    public final Object b(Continuation<? super Unit> r110) {
        if ((r110 instanceof OutputAdapter$loop$1$loop$1) == false) goto L7;
        OutputAdapter$loop$1$loop$1 r100 = (OutputAdapter$loop$1$loop$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r103 = r100.label;
        if (r103 == 0) goto L20;
        if (r103 == 1) goto L17;
        if (r103 != 2) goto L16;
        OutputAdapter$loop$1 r104 = (OutputAdapter$loop$1) r100.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L48
        r103 = r104;
    L22:
        r103.result = 0;     // Catch: Throwable -> L48
        r100.L$0 = r103;     // Catch: Throwable -> L48
        r100.L$1 = r103;     // Catch: Throwable -> L48
        r100.label = 1;     // Catch: Throwable -> L48
        r111 = BlockingAdapter.a(r103, r100);     // Catch: Throwable -> L48
        if (r111 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended(r100);     // Catch: Throwable -> L48
    L25:
        if (r111 != r102) goto L28;
        return r102;
    L28:
        if (r111 != BlockingKt.f492113b) goto L38;
        if (io.ktor.utils.io.e.a(r103.f492123g.f492120a) == true) goto L36;
        Throwable r112 = r103.f492123g.f492120a.d();
        if (r112 == null) goto L36;
        throw r112;
    L36:
        return Unit.INSTANCE;
    L38:
        if (r111 != BlockingKt.f492114c) goto L43;
        r103.f492123g.f492120a.flush();     // Catch: Throwable -> L48
        Throwable r113 = r103.f492123g.f492120a.d();     // Catch: Throwable -> L48
        if (r113 != null) goto L42;
        r103 = r103;
        goto L22
    L42:
        throw r113;     // Catch: Throwable -> L48
    L43:
        r103 = r103;
        if ((r111 instanceof byte[]) == false) goto L22;
        int r105 = r103.f492108d;     // Catch: Throwable -> L48
        int r106 = r103.f492109e;     // Catch: Throwable -> L48
        r100.L$0 = r103;     // Catch: Throwable -> L48
        r100.L$1 = null;     // Catch: Throwable -> L48
        r100.label = 2;     // Catch: Throwable -> L48
        Object r114 = r103.f492123g.f492120a.t((byte[]) r111, r105, r106, r100);     // Catch: Throwable -> L48
        r103 = r103;
        if (r114 != r102) goto L22;
        return r102;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        BlockingAdapter r107 = (BlockingAdapter) r100.L$1;
        r103 = (OutputAdapter$loop$1) r100.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L48
        goto L28
    L20:
        ResultKt.throwOnFailure(r111);
        r103 = this;
    L48:
        th = move-exception;
    L53:
        th = move-exception;
        if (io.ktor.utils.io.e.a(r103.f492123g.f492120a) == true) goto L59;
        Throwable r108 = r103.f492123g.f492120a.d();
        if (r108 == null) goto L59;
        throw r108;
    L59:
        throw th;
    L50:
        if ((th instanceof CancellationException) == true) goto L52;
        r103.f492123g.f492120a.close(th);     // Catch: Throwable -> L53
    L52:
        throw th;     // Catch: Throwable -> L53
    L7:
        r100 = new OutputAdapter$loop$1$loop$1(this, r110);
        goto L8
    }

    public OutputAdapter$loop$1(Job r100, OutputAdapter r101) {
        this.f492123g = r101;
        super(r100);
    }
}
