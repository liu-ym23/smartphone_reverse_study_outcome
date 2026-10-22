package com.larus.im.internal.network.sse;

import com.flow.kmp.common.util.CoroutineExtKt;
import com.larus.im.internal.delegate.d1;
import com.larus.im.internal.delegate.y0;
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
public final class SseChunkParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SseChunkParser f349505a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f349506b = false;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/im/internal/network/sse/SseChunkParser$ReadChunkException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getMessage", "()Ljava/lang/String;", "getCause", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "flow-im-plugin_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public SseChunkParser() {
    }

    static {
        f349505a = new SseChunkParser();
        f349506b = y0.d().f348558x;
    }

    public static com.larus.im.internal.network.chunk.data.b b(BufferedSource r110) {
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
        if (f349506b == false) goto L17;
        if (r102 != null) goto L17;
        com.larus.im.internal.delegate.a.f348188b.i("ChunkParser", "read line is null, break");
        throw new Exception("EOF Line is null");
    L17:
        if (r102 != null) goto L19;
    L21:
        boolean r103 = false;
    L22:
        if (r103 == false) goto L3;
        com.larus.im.internal.network.chunk.data.b r104 = new com.larus.im.internal.network.chunk.data.b();
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
        r102 = r110.readUtf8Line();
    L62:
        Intrinsics.checkNotNullParameter(r105.toString(), "<set-?>");
        com.larus.im.internal.delegate.a.f348188b.i("ChunkParser", "chunk data : " + r104);
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

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0095 -> B:17:0x0054). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00a0 -> B:17:0x0054). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00b2 -> B:40:0x00b4). Please report as a decompilation issue!!! */
    public final Object a(final BufferedSource r110, Function2<? super com.larus.im.internal.network.chunk.data.b, ? super Continuation<? super Unit>, ? extends Object> r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof SseChunkParser$parseStream$1) == false) goto L7;
        SseChunkParser$parseStream$1 r100 = (SseChunkParser$parseStream$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        com.larus.im.internal.network.chunk.data.b r114 = (com.larus.im.internal.network.chunk.data.b) r100.L$2;
        r111 = (Function2) r100.L$1;
        BufferedSource r104 = (BufferedSource) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L41:
        if (Intrinsics.areEqual(r114.f349103b, "done") == false) goto L43;
        com.larus.im.internal.delegate.a.f348188b.i("ChunkParser", "receive chunk end, ");
        r110 = r104;
    L44:
        r110.close();
        return Unit.INSTANCE;
    L43:
        r110 = r104;
    L18:
        if (JobKt.isActive(r100.getContext()) == false) goto L44;
        SseChunkParser$parseStream$chunkRet$1 r115 = new SseChunkParser$parseStream$chunkRet$1(null);
        Function1 r105 = new c(r110);
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.L$2 = null;
        r100.label = 1;
        r113 = CoroutineExtKt.d(60000, r115, r105, r100);
        if (r113 != r102) goto L22;
        return r102;
    L22:
        Object r116 = ((Result) r113).m9458unboximpl();
        if (Result.m9455isFailureimpl(r116) == false) goto L29;
        r110.close();
        Throwable r106 = Result.m9452exceptionOrNullimpl(r116);
        if (r106 == null) goto L29;
        throw r106;
    L29:
        if (Result.m9456isSuccessimpl(r116) == false) goto L18;
        if (Result.m9455isFailureimpl(r116) == false) goto L33;
        r116 = null;
    L33:
        com.larus.im.internal.network.chunk.data.b r117 = (com.larus.im.internal.network.chunk.data.b) r116;
        if (r117 == null) goto L18;
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.L$2 = r117;
        r100.label = 2;
        if (r111.invoke(r117, r100) != r102) goto L39;
        return r102;
    L39:
        r104 = r110;
        r114 = r117;
        goto L41
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Function2<? super com.larus.im.internal.network.chunk.data.b, ? super Continuation<? super Unit>, ? extends Object> r118 = (Function2) r100.L$1;
        BufferedSource r119 = (BufferedSource) r100.L$0;
        ResultKt.throwOnFailure(r113);
        r111 = r118;
        r110 = r119;
        goto L22
    L16:
        ResultKt.throwOnFailure(r113);
    L7:
        r100 = new SseChunkParser$parseStream$1(this, r112);
        goto L8
    }
}
