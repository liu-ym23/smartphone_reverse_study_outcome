package com.larus.im.internal.network.chunk.data;

import com.flow.kmp.common.util.CoroutineExtKt;
import com.larus.im.internal.delegate.d1;
import com.larus.im.internal.delegate.y0;
import com.larus.im.internal.network.chunk.handler.SseChunkHandler;
import com.larus.im.internal.utils.l;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.JobKt;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes30.dex */
public final class ChunkParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ChunkParser f349096a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f349097b = false;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/im/internal/network/chunk/data/ChunkParser$ReadChunkException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getMessage", "()Ljava/lang/String;", "getCause", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReadChunkException extends RuntimeException {
        private final Throwable cause;
        private final String message;

        public static /* synthetic */ ReadChunkException copy$default(ReadChunkException r100, String r101, Throwable r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.message;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.cause;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.message;
        }

        public final Throwable component2() {
            return this.cause;
        }

        public final ReadChunkException copy(String r100, Throwable r101) {
            return new ReadChunkException(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ReadChunkException) == true) goto L8;
            return false;
        L8:
            ReadChunkException r101 = (ReadChunkException) r100;
            if (Intrinsics.areEqual(this.message, r101.message) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.cause, r101.cause) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r100 = this.message;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Throwable r104 = this.cause;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "ReadChunkException(message=" + this.message + ", cause=" + this.cause + ')';
        }

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

    public ChunkParser() {
    }

    static {
        f349096a = new ChunkParser();
        f349097b = y0.d().f348558x;
    }

    public static b c(BufferedSource r110) {
        boolean r100 = true;
    L3:
        String r101 = r110.readUtf8Line();
        if (r101 == null) goto L6;
        String r102 = StringsKt.trim(r101).toString();
    L8:
        if (r100 == false) goto L12;
        if (r102 != null) goto L12;
        d1.f348206b.b("ChunkParser", "read line is null");
        r100 = false;
    L12:
        if (f349097b == false) goto L17;
        if (r102 != null) goto L17;
        com.larus.im.internal.delegate.a.f348188b.i("ChunkParser", "read line is null, break");
        throw new Exception("EOF Line is null");
    L17:
        if (r102 != null) goto L19;
    L21:
        boolean r103 = false;
    L22:
        if (r103 == false) goto L3;
        b r104 = new b();
        StringBuilder r105 = new StringBuilder();
    L24:
        if (r102 != null) goto L26;
    L28:
        boolean r106 = false;
    L30:
        if (r106 == false) goto L62;
        int r107 = StringsKt.indexOf$default(r102, ":", 0, false, 6, null);
        int r108 = -1;
        if (r107 == (-1)) goto L24;
        String r109 = StringsKt.trim(r102.substring(0, r107)).toString();
        String r111 = StringsKt.trim(r102.substring(r107 + 1)).toString();
        r105.append(r102);
        if (StringsKt.isBlank(r111) == true) goto L36;
        int r112 = r109.hashCode();
        if (r112 == 3355) goto L53;
        if (r112 == 3076010) goto L49;
        if (r112 != 96891546) goto L60;
        if (r109.equals("event") == false) goto L60;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r104.f349103b = r111;
    L60:
        if (Intrinsics.areEqual(r104.f349103b, "done") == true) goto L62;
        r102 = r110.readUtf8Line();
        goto L24
    L49:
        if (r109.equals("data") == false) goto L60;
        String r113 = r104.f349104c + r111;
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r104.f349104c = r113;
        goto L60
    L53:
        if (r109.equals("id") == false) goto L60;
        Integer r114 = StringsKt.toIntOrNull(r111);
        if (r114 == null) goto L58;
        r108 = r114.intValue();
    L58:
        r104.f349102a = r108;
        goto L60
    L36:
        r102 = r110.readUtf8LineStrict();
    L62:
        Intrinsics.checkNotNullParameter(r105.toString(), "<set-?>");
        int r115 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("ChunkParser", "chunk data : " + l.d(r104.toString()));
        return r104;
    L26:
        if ((!StringsKt.isBlank(r102)) != true) goto L28;
        r106 = true;
        goto L30
    L19:
        if ((!StringsKt.isBlank(r102)) != true) goto L21;
        r103 = true;
        goto L22
    L6:
        r102 = null;
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0077 -> B:27:0x0079). Please report as a decompilation issue!!! */
    public final Object b(BufferedSource r100, Function2<? super b, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof ChunkParser$parseStream$2) == false) goto L7;
        ChunkParser$parseStream$2 r103 = (ChunkParser$parseStream$2) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        b r108 = (b) r103.L$2;
        r101 = (Function2) r103.L$1;
        BufferedSource r109 = (BufferedSource) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L28:
        if (Intrinsics.areEqual(r108.f349103b, "done") == false) goto L30;
        r100 = r109;
    L33:
        r100.close();
        return Unit.INSTANCE;
    L30:
        r100 = r109;
    L16:
        if (JobKt.isActive(r103.getContext()) == false) goto L33;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L19
        Object r111 = Result.m9449constructorimpl(c(r100));     // Catch: Throwable -> L19
    L21:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 != null) goto L31;
        b r113 = (b) r111;
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.L$2 = r113;
        r103.label = 1;
        if (r101.invoke(r113, r103) != r106) goto L26;
        return r106;
    L26:
        r109 = r100;
        r108 = r113;
        goto L28
    L31:
        r100.close();
        throw new ReadChunkException(r112.getMessage(), r112);
    L19:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
    L7:
        r103 = new ChunkParser$parseStream$2(this, r102);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00e8 -> B:50:0x00ec). Please report as a decompilation issue!!! */
    public final Object a(BufferedSource r110, SseChunkHandler.b r111, Function2<? super b, ? super Continuation<? super Unit>, ? extends Object> r112, Continuation<? super Unit> r113) {
        if ((r113 instanceof ChunkParser$parseStream$1) == false) goto L7;
        ChunkParser$parseStream$1 r100 = (ChunkParser$parseStream$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        b r105 = (b) r100.L$3;
        Function2<? super b, ? super Continuation<? super Unit>, ? extends Object> r106 = (Function2) r100.L$2;
        SseChunkHandler.b r107 = (SseChunkHandler.b) r100.L$1;
        BufferedSource r114 = (BufferedSource) r100.L$0;
        ResultKt.throwOnFailure(r102);
        SseChunkHandler.b r108 = r107;
    L51:
        if (Intrinsics.areEqual(r105.f349103b, "done") == false) goto L53;
        int r109 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("ChunkParser", "receive chunk end, ");
        final BufferedSource r115 = r114;
    L55:
        r115.close();
        return Unit.INSTANCE;
    L53:
        r115 = r114;
    L27:
        if (JobKt.isActive(r100.getContext()) == false) goto L55;
        long r116 = r108.f349129d;
        ChunkParser$parseStream$chunkRet$1 r117 = new ChunkParser$parseStream$chunkRet$1(null);
        Function1 r118 = new c(r115);
        r100.L$0 = r115;
        r100.L$1 = r108;
        r100.L$2 = r106;
        r100.L$3 = null;
        r100.label = 2;
        Object r119 = CoroutineExtKt.d(r116, r117, r118, r100);
        if (r119 != r103) goto L31;
        return r103;
    L31:
        Function2<? super b, ? super Continuation<? super Unit>, ? extends Object> r120 = r106;
        SseChunkHandler.b r121 = r108;
        r102 = r119;
        Function2<? super b, ? super Continuation<? super Unit>, ? extends Object> r122 = r120;
    L32:
        Object r123 = ((Result) r102).m9458unboximpl();
        if (Result.m9455isFailureimpl(r123) == false) goto L39;
        r115.close();
        Throwable r124 = Result.m9452exceptionOrNullimpl(r123);
        if (r124 == null) goto L39;
        throw r124;
    L39:
        if (Result.m9456isSuccessimpl(r123) == false) goto L54;
        r108 = r121;
        r106 = r122;
        goto L27
    L41:
        if (Result.m9455isFailureimpl(r123) == false) goto L43;
        r123 = null;
    L43:
        b r125 = (b) r123;
        if (r125 == null) goto L54;
        r100.L$0 = r115;
        r100.L$1 = r121;
        r100.L$2 = r122;
        r100.L$3 = r125;
        r100.label = 3;
        if (r122.invoke(r125, r100) != r103) goto L49;
        return r103;
    L49:
        r114 = r115;
        r105 = r125;
        r108 = r121;
        r106 = r122;
        goto L51
    L54:
        r108 = r121;
        r106 = r122;
        goto L27
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Function2<? super b, ? super Continuation<? super Unit>, ? extends Object> r126 = (Function2) r100.L$2;
        r121 = (SseChunkHandler.b) r100.L$1;
        BufferedSource r127 = (BufferedSource) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r122 = r126;
        r115 = r127;
        goto L32
    L17:
        ResultKt.throwOnFailure(r102);
    L24:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r102);
        r108 = r111;
        if (r108.f349129d > 0) goto L25;
        r100.label = 1;
        if (b(r110, r112, r100) != r103) goto L24;
        return r103;
    L25:
        r115 = r110;
        r106 = r112;
    L7:
        r100 = new ChunkParser$parseStream$1(this, r113);
        goto L8
    }
}
