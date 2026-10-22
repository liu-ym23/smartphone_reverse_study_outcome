package com.larus.canvas.service.internal.sse;

import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.io.BufferedReader;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes26.dex */
public final class CanvasChunkParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CanvasChunkParser f323841a = null;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/canvas/service/internal/sse/CanvasChunkParser$ReadChunkException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getMessage", "()Ljava/lang/String;", "getCause", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    static {
        f323841a = new CanvasChunkParser();
    }

    public CanvasChunkParser() {
    }

    public static b b(BufferedReader r110) {
    L2:
        String r100 = StringsKt.trim(r110.readLine()).toString();
        if ((!StringsKt.isBlank(r100)) == false) goto L2;
        b r101 = new b();
        StringBuilder r102 = new StringBuilder();
    L6:
        if ((!StringsKt.isBlank(r100)) == false) goto L38;
        int r103 = StringsKt.indexOf$default(r100, ":", 0, false, 6, null);
        int r104 = -1;
        if (r103 == (-1)) goto L6;
        String r105 = StringsKt.trim(r100.substring(0, r103)).toString();
        String r106 = StringsKt.trim(r100.substring(r103 + 1)).toString();
        r102.append(r100);
        if (StringsKt.isBlank(r106) == true) goto L12;
        int r107 = r105.hashCode();
        if (r107 == 3355) goto L29;
        if (r107 == 3076010) goto L25;
        if (r107 != 96891546) goto L36;
        if (r105.equals("event") == false) goto L36;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r101.f323860b = r106;
    L36:
        if (Intrinsics.areEqual(r101.f323860b, "done") == true) goto L38;
        r100 = r110.readLine();
        goto L6
    L25:
        if (r105.equals("data") == false) goto L36;
        String r108 = r101.f323861c + r106;
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r101.f323861c = r108;
        goto L36
    L29:
        if (r105.equals("id") == false) goto L36;
        Integer r109 = StringsKt.toIntOrNull(r106);
        if (r109 == null) goto L34;
        r104 = r109.intValue();
    L34:
        r101.f323859a = r104;
        goto L36
    L12:
        r100 = r110.readLine();
    L38:
        Intrinsics.checkNotNullParameter(r102.toString(), "<set-?>");
        FLogger.f375446a.i("CanvasChunkParser", "chunk data : " + r101);
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.canvas.service.internal.sse.c] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00d2 -> B:41:0x00d5). Please report as a decompilation issue!!! */
    public final Object a(BufferedReader r110, Function2<? super b, ? super Continuation<? super Unit>, ? extends Object> r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof CanvasChunkParser$parseStream$1) == false) goto L7;
        CanvasChunkParser$parseStream$1 r100 = (CanvasChunkParser$parseStream$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
        CanvasChunkParser r102 = this;
    L8:
        Object r103 = r100.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r100.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        b r106 = (b) r100.L$2;
        Function2<? super b, ? super Continuation<? super Unit>, ? extends Object> r107 = (Function2) r100.L$1;
        BufferedReader r108 = (BufferedReader) r100.L$0;
        ResultKt.throwOnFailure(r103);
        CanvasChunkParser r113 = r102;
        final BufferedReader r109 = r108;
        CanvasChunkParser$parseStream$1 r114 = r100;
        Function2<? super b, ? super Continuation<? super Unit>, ? extends Object> r115 = r107;
        b r116 = r106;
        Object r117 = r104;
    L42:
        if (Intrinsics.areEqual(r116.f323860b, "done") == false) goto L45;
        FLogger.f375446a.i("CanvasChunkParser", "receive chunk end");
    L48:
        r109.close();
        return Unit.INSTANCE;
    L45:
        if (Intrinsics.areEqual(r116.f323860b, "error") == false) goto L18;
        FLogger.f375446a.i("CanvasChunkParser", "receive chunk error");
    L18:
        if (JobKt.isActive(r114.getContext()) == false) goto L48;
        long r118 = z2.f365865a.getCreationCanvasClientConfig().f486754c;
        CanvasChunkParser$parseStream$chunkRet$1 r119 = new CanvasChunkParser$parseStream$chunkRet$1(null);
        ?? r120 = new c(r109);
        r114.L$0 = r109;
        r114.L$1 = r115;
        r114.L$2 = null;
        r114.label = 1;
        Object r121 = r113.c(r118, r119, r120, r114);
        if (r121 != r117) goto L22;
        return r117;
    L22:
        BufferedReader r122 = r109;
        r103 = r121;
    L23:
        Object r123 = ((Result) r103).m9458unboximpl();
        if (Result.m9455isFailureimpl(r123) == false) goto L30;
        r122.close();
        Throwable r124 = Result.m9452exceptionOrNullimpl(r123);
        if (r124 == null) goto L30;
        throw r124;
    L30:
        if (Result.m9456isSuccessimpl(r123) == false) goto L47;
        r109 = r122;
        goto L18
    L32:
        if (Result.m9455isFailureimpl(r123) == false) goto L34;
        r123 = null;
    L34:
        b r125 = (b) r123;
        if (r125 == null) goto L47;
        r114.L$0 = r122;
        r114.L$1 = r115;
        r114.L$2 = r125;
        r114.label = 2;
        if (r115.invoke(r125, r114) != r117) goto L40;
        return r117;
    L40:
        BufferedReader r126 = r122;
        r116 = r125;
        r109 = r126;
        goto L42
    L47:
        r109 = r122;
        goto L18
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Function2<? super b, ? super Continuation<? super Unit>, ? extends Object> r127 = (Function2) r100.L$1;
        r122 = (BufferedReader) r100.L$0;
        ResultKt.throwOnFailure(r103);
        r113 = r102;
        r114 = r100;
        r115 = r127;
        r117 = r104;
        goto L23
    L16:
        ResultKt.throwOnFailure(r103);
        r109 = r110;
        r113 = r102;
        r117 = r104;
        r114 = r100;
        r115 = r111;
    L7:
        r102 = this;
        r100 = new CanvasChunkParser$parseStream$1(r102, r112);
        goto L8
    }

    public final Object c(long r100, Function3 r101, c r110, Continuation r111) {
        if ((r111 instanceof CanvasChunkParser$waitOrTimeout$1) == false) goto L7;
        CanvasChunkParser$waitOrTimeout$1 r102 = (CanvasChunkParser$waitOrTimeout$1) r111;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r112 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r112);
    L26:
        return r112;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r101 = (Function3) r102.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L22
    L27:
        goto L26
    L18:
        ResultKt.throwOnFailure(r112);
        CanvasChunkParser$waitOrTimeout$2 r113 = new CanvasChunkParser$waitOrTimeout$2(r110, null);     // Catch: Throwable -> L22
        r102.L$0 = r101;     // Catch: Throwable -> L22
        r102.label = 1;     // Catch: Throwable -> L22
        r112 = TimeoutKt.b(r100, r113, r102);     // Catch: Throwable -> L22
        if (r112 != r104) goto L27;
        return r104;
    L22:
        th = move-exception;
        CoroutineContext.Element r106 = r102.getContext().get(Job.Key);
        r102.L$0 = null;
        r102.label = 2;
        r112 = r101.invoke(th, r106, r102);
        if (r112 != r104) goto L26;
        return r104;
    L7:
        r102 = new CanvasChunkParser$waitOrTimeout$1(this, r111);
        goto L8
    }
}
