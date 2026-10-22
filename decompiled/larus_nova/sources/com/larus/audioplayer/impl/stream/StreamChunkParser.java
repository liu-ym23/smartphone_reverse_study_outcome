package com.larus.audioplayer.impl.stream;

import android.os.SystemClock;
import com.larus.common.apphost.AppHost;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.BufferedReader;
import java.io.IOException;
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
public final class StreamChunkParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StreamChunkParser f290406a = null;

    static {
        f290406a = new StreamChunkParser();
    }

    public StreamChunkParser() {
    }

    public static w b(BufferedReader r110) {
    L2:
        String r100 = r110.readLine();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        String r101 = StringsKt.trim(r100).toString();
        if ((!StringsKt.isBlank(r101)) == false) goto L2;
        w r102 = new w();
        StringBuilder r103 = new StringBuilder();
    L9:
        if ((!StringsKt.isBlank(r101)) == false) goto L45;
        int r104 = StringsKt.indexOf$default(r101, ":", 0, false, 6, null);
        int r105 = -1;
        if (r104 == (-1)) goto L9;
        String r106 = StringsKt.trim(r101.substring(0, r104)).toString();
        String r107 = StringsKt.trim(r101.substring(r104 + 1)).toString();
        r103.append(r101);
        if (StringsKt.isBlank(r107) == true) goto L15;
        int r108 = r106.hashCode();
        if (r108 == 3355) goto L34;
        if (r108 == 3076010) goto L30;
        if (r108 != 96891546) goto L41;
        if (r106.equals("event") == false) goto L41;
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r102.f290460b = r107;
    L41:
        if (Intrinsics.areEqual(r102.f290460b, "done") == true) goto L45;
        r101 = r110.readLine();
        if (r101 != null) goto L9;
    L44:
        r101 = "";
        goto L9
    L30:
        if (r106.equals("data") == false) goto L41;
        String r109 = r102.f290461c + r107;
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r102.f290461c = r109;
        goto L41
    L34:
        if (r106.equals("id") == false) goto L41;
        Integer r111 = StringsKt.toIntOrNull(r107);
        if (r111 == null) goto L39;
        r105 = r111.intValue();
    L39:
        r102.f290459a = r105;
        goto L41
    L15:
        r101 = r110.readLine();
        if (r101 != null) goto L9;
    L45:
        Intrinsics.checkNotNullParameter(r103.toString(), "<set-?>");
        return r102;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x011d -> B:50:0x0120). Please report as a decompilation issue!!! */
    public final Object a(BufferedReader r210, Function2<? super w, ? super Continuation<? super Unit>, ? extends Object> r211, Function0<Boolean> r212, Continuation<? super Unit> r213) {
        if ((r213 instanceof StreamChunkParser$parseStream$1) == false) goto L7;
        StreamChunkParser$parseStream$1 r100 = (StreamChunkParser$parseStream$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ResultKt.throwOnFailure(r102);
    L60:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r105 = r100.J$0;
        w r106 = (w) r100.L$3;
        Function0<Boolean> r110 = (Function0) r100.L$2;
        Function2<? super w, ? super Continuation<? super Unit>, ? extends Object> r111 = (Function2) r100.L$1;
        BufferedReader r112 = (BufferedReader) r100.L$0;
        ResultKt.throwOnFailure(r102);
        StreamChunkParser$parseStream$1 r107 = r100;
        BufferedReader r108 = r112;
        Object r109 = r103;
        String r113 = "StreamChunkParser";
        Function2<? super w, ? super Continuation<? super Unit>, ? extends Object> r114 = r111;
        long r115 = r105;
    L51:
        if (Intrinsics.areEqual(r106.f290460b, "done") == false) goto L53;
        FLogger.f375446a.i(r113, "receive done pkg，finish the chunk request normally");
    L56:
        FLogger.f375446a.i(r113, "parseStream() exec finished");
        CoroutineDispatcher r116 = Dispatchers.getIO();
        StreamChunkParser$parseStream$2 r117 = new StreamChunkParser$parseStream$2(r108, null);
        r107.L$0 = null;
        r107.L$1 = null;
        r107.L$2 = null;
        r107.L$3 = null;
        r107.label = 2;
        if (BuildersKt.withContext(r116, r117, r107) != r109) goto L60;
        return r109;
    L53:
        Function0<Boolean> r118 = r110;
        long r119 = r115;
    L18:
        if (JobKt.isActive(r107.getContext()) == false) goto L56;
        if (r118.invoke().booleanValue() == false) goto L61;
        FLogger.f375446a.i(r113, "Conditional judgment is over, stop parseStream");
        goto L56
    L61:
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L24
        Object r121 = Result.m9449constructorimpl(b(r108));     // Catch: Throwable -> L24
    L26:
        Throwable r122 = Result.m9452exceptionOrNullimpl(r121);
        if (r122 != null) goto L54;
        w r123 = (w) r121;
        if (AppHost.f326268a.isTestChannel() == false) goto L46;
        IFlowSdkDepend r124 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r124 == null) goto L33;
        r124.a0();
        Integer r125 = com.larus.home.impl.sdk.g.f346177a.b();
    L34:
        if (r125 != null) goto L37;
    L43:
        if (r125 == null) goto L46;
        FLogger.f375446a.i(r113, "finish the StreamChunkParser#parseStrea() for debug index=" + r125);
        if (r123.f290459a >= r125.intValue()) goto L56;
    L37:
        if (r125.intValue() != 20) goto L43;
        if (r123.f290459a < r125.intValue()) goto L43;
        throw new IOException("test demo");
    L33:
        r125 = null;
    L46:
        r107.L$0 = r108;
        r107.L$1 = r114;
        r107.L$2 = r118;
        r107.L$3 = r123;
        r107.J$0 = r119;
        r107.label = 1;
        if (r114.invoke(r123, r107) != r109) goto L49;
        return r109;
    L49:
        r115 = r119;
        r110 = r118;
        r106 = r123;
        goto L51
    L54:
        r108.close();
        FLogger.f375446a.e(r113, "parse chunk error。total cost duration=" + (SystemClock.elapsedRealtime() - r119) + "ms err=" + r122);
        throw r122;
    L24:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L16:
        ResultKt.throwOnFailure(r102);
        r118 = r212;
        r119 = SystemClock.elapsedRealtime();
        r109 = r103;
        r113 = "StreamChunkParser";
        r114 = r211;
        r107 = r100;
        r108 = r210;
    L7:
        r100 = new StreamChunkParser$parseStream$1(this, r213);
        goto L8
    }
}
