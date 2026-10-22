package com.larus.avlink.activeSummary;

import com.larus.avlink.n1;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes24.dex */
public final class ChunkParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ChunkParser f291414a = null;

    static {
        f291414a = new ChunkParser();
    }

    public ChunkParser() {
    }

    public static a b(Function0 r110) {
    L2:
        String r100 = StringsKt.trim((String) r110.invoke()).toString();
        if ((!StringsKt.isBlank(r100)) == false) goto L2;
        a r101 = new a();
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
        r101.f291447b = r106;
    L36:
        if (Intrinsics.areEqual(r101.f291447b, "done") == true) goto L38;
        r100 = (String) r110.invoke();
        goto L6
    L25:
        if (r105.equals("data") == false) goto L36;
        String r108 = r101.f291448c + r106;
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r101.f291448c = r108;
        goto L36
    L29:
        if (r105.equals("id") == false) goto L36;
        Integer r109 = StringsKt.toIntOrNull(r106);
        if (r109 == null) goto L34;
        r104 = r109.intValue();
    L34:
        r101.f291446a = r104;
        goto L36
    L12:
        r100 = (String) r110.invoke();
    L38:
        Intrinsics.checkNotNullParameter(r102.toString(), "<set-?>");
        return r101;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0088 -> B:29:0x008a). Please report as a decompilation issue!!! */
    public final Object a(Function0<String> r100, Function0<Unit> r101, Function2<? super a, ? super Continuation<? super Unit>, ? extends Object> r102, Continuation<? super Unit> r110) {
        if ((r110 instanceof ChunkParser$parseStream$1) == false) goto L7;
        ChunkParser$parseStream$1 r103 = (ChunkParser$parseStream$1) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r111 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r111);
    L43:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        a r107 = (a) r103.L$3;
        Function2<? super a, ? super Continuation<? super Unit>, ? extends Object> r108 = (Function2) r103.L$2;
        Function0<Unit> r109 = (Function0) r103.L$1;
        Function0<String> r112 = (Function0) r103.L$0;
        ResultKt.throwOnFailure(r111);
        r102 = r108;
        r101 = r109;
    L30:
        if (Intrinsics.areEqual(r107.f291447b, "done") == true) goto L39;
        r100 = r112;
    L18:
        if (JobKt.isActive(r103.getContext()) == false) goto L39;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L21
        Object r114 = Result.m9449constructorimpl(b(r100));     // Catch: Throwable -> L21
    L23:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 != null) goto L44;
        a r116 = (a) r114;
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.L$2 = r102;
        r103.L$3 = r116;
        r103.label = 1;
        if (r102.invoke(r116, r103) != r105) goto L28;
        return r105;
    L28:
        r112 = r100;
        r107 = r116;
        goto L30
    L44:
        r101.invoke();     // Catch: Throwable -> L35
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L37:
        n1.a("ChunkParser", "ChunkParser.parseStream IllegalStateException " + r115);
        throw new IllegalStateException("read line exception", r115);
    L35:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L39:
        CoroutineDispatcher r119 = Dispatchers.getIO();
        ChunkParser$parseStream$2 r120 = new ChunkParser$parseStream$2(r101, null);
        r103.L$0 = null;
        r103.L$1 = null;
        r103.L$2 = null;
        r103.L$3 = null;
        r103.label = 2;
        if (BuildersKt.withContext(r119, r120, r103) != r105) goto L43;
        return r105;
    L16:
        ResultKt.throwOnFailure(r111);
    L7:
        r103 = new ChunkParser$parseStream$1(this, r110);
        goto L8
    }
}
