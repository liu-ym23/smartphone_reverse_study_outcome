package com.larus.canvas.core.impl.sse;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes4.dex */
public final class CanvasSseChunkParser {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f322955b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f322956a;

    /* JADX INFO: loaded from: classes26.dex */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/larus/canvas/core/impl/sse/CanvasSseChunkParser$ReadChunkException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getMessage", "()Ljava/lang/String;", "getCause", "()Ljava/lang/Throwable;", "canvas_core_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReadChunkException extends RuntimeException {
        private final Throwable cause;
        private final String message;

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public ReadChunkException(String r100, Throwable r101) {
            super(r100, r101);
            this.message = r100;
            this.cause = r101;
        }
    }

    public static final class a {
    }

    static {
    }

    public CanvasSseChunkParser() {
        this.f322956a = 60000;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v11, types: [okio.Source] */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v24 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [okio.Source] */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.lang.Object, okio.BufferedSource] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.larus.canvas.core.impl.sse.CanvasSseChunkParser] */
    /* JADX WARN: Type inference failed for: r8v0, types: [okio.BufferedSource] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0094 -> B:35:0x0098). Please report as a decompilation issue!!! */
    public final Object a(BufferedSource r110, Function2<? super b, ? super Continuation<? super Unit>, ? extends Object> r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof CanvasSseChunkParser$parseStream$1) == false) goto L7;
        CanvasSseChunkParser$parseStream$1 r100 = (CanvasSseChunkParser$parseStream$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r103 = r100.label;
        if (r103 == 0) goto L24;
        if (r103 == 1) goto L17;
        if (r103 != 2) goto L16;
        b r114 = (b) r100.L$2;
        r111 = (Function2) r100.L$1;
        BufferedSource r104 = (BufferedSource) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L20 TimeoutCancellationException -> L22
        CanvasSseChunkParser r115 = this;
        ?? r105 = r104;
    L35:
        if (Intrinsics.areEqual(r114.f322960a, "done") == false) goto L38;
        ?? r116 = r105;
    L39:
        r116.close();
        return Unit.INSTANCE;
    L38:
        ?? r117 = r105;
    L52:
        r116 = r117;
        if (JobKt.isActive(r100.getContext()) == false) goto L39;
        long r106 = r115.f322956a;     // Catch: Throwable -> L41 TimeoutCancellationException -> L43
        CanvasSseChunkParser$parseStream$chunk$1 r107 = new CanvasSseChunkParser$parseStream$chunk$1(r115, r117, null);     // Catch: Throwable -> L41 TimeoutCancellationException -> L43
        r100.L$0 = r117;     // Catch: Throwable -> L41 TimeoutCancellationException -> L43
        r100.L$1 = r111;     // Catch: Throwable -> L41 TimeoutCancellationException -> L43
        r100.L$2 = null;     // Catch: Throwable -> L41 TimeoutCancellationException -> L43
        r100.label = 1;     // Catch: Throwable -> L41 TimeoutCancellationException -> L43
        Object r108 = r115.b(r106, r117, r107, r100);     // Catch: Throwable -> L41 TimeoutCancellationException -> L43
        if (r108 != r102) goto L30;
        return r102;
    L30:
        ?? r109 = r117;
        Function2<? super b, ? super Continuation<? super Unit>, ? extends Object> r118 = r111;
        CanvasSseChunkParser r119 = r115;
        r113 = r108;
    L31:
        b r120 = (b) r113;     // Catch: Throwable -> L20 TimeoutCancellationException -> L22
        r100.L$0 = r109;     // Catch: Throwable -> L20 TimeoutCancellationException -> L22
        r100.L$1 = r118;     // Catch: Throwable -> L20 TimeoutCancellationException -> L22
        r100.L$2 = r120;     // Catch: Throwable -> L20 TimeoutCancellationException -> L22
        r100.label = 2;     // Catch: Throwable -> L20 TimeoutCancellationException -> L22
        if (r118.invoke(r120, r100) != r102) goto L34;
        return r102;
    L34:
        CanvasSseChunkParser r121 = r119;
        r111 = r118;
        r114 = r120;
        r115 = r121;
        r105 = r109;
        goto L35
    L43:
        e = move-exception;
        e = e;
    L46:
        throw new ReadChunkException(e.getMessage(), e);     // Catch: Throwable -> L20
    L41:
        Throwable th10 = th;
    L48:
        r117.close();
        throw th10;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r118 = (Function2) r100.L$1;
        BufferedSource r122 = (BufferedSource) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L20 TimeoutCancellationException -> L22
        r119 = this;
        r109 = r122;
        goto L31
    L24:
        ResultKt.throwOnFailure(r113);
        r115 = this;
        r117 = r110;
    L20:
        th = move-exception;
        th10 = th;
        r117 = r103;
    L22:
        e = e;
    L7:
        r100 = new CanvasSseChunkParser$parseStream$1(this, r112);
        goto L8
    }

    public final <T> Object b(long r100, BufferedSource r101, Function1<? super Continuation<? super T>, ? extends Object> r102, Continuation<? super T> r103) {
        if ((r103 instanceof CanvasSseChunkParser$withTimeoutOrThrow$1) == false) goto L7;
        CanvasSseChunkParser$withTimeoutOrThrow$1 r104 = (CanvasSseChunkParser$withTimeoutOrThrow$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L16;
        if (r108 != 1) goto L15;
        r101 = (BufferedSource) r104.L$0;
        ResultKt.throwOnFailure(r106);     // Catch: TimeoutCancellationException -> L21
    L29:
        return r106;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r106);
        CanvasSseChunkParser$withTimeoutOrThrow$2 r109 = new CanvasSseChunkParser$withTimeoutOrThrow$2(r102, null);     // Catch: TimeoutCancellationException -> L21
        r104.L$0 = r101;     // Catch: TimeoutCancellationException -> L21
        r104.label = 1;     // Catch: TimeoutCancellationException -> L21
        r106 = TimeoutKt.b(r100, r109, r104);     // Catch: TimeoutCancellationException -> L21
        if (r106 != r107) goto L29;
        return r107;
    L21:
        e = move-exception;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L24
        r101.close();     // Catch: Throwable -> L24
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        throw e;
    L24:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r104 = new CanvasSseChunkParser$withTimeoutOrThrow$1(this, r103);
        goto L8
    }
}
