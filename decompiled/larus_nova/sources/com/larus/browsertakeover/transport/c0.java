package com.larus.browsertakeover.transport;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.nio.ByteBuffer;
import java.nio.charset.CodingErrorAction;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes26.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f319675a = null;

    static {
        f319675a = new c0();
    }

    public c0() {
    }

    public static String a(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        if (r100.length != 0) goto L5;
        boolean r101 = true;
    L6:
        Object r102 = null;
        if (r101 == false) goto L9;
        return null;
    L9:
        if (r100.length > 1048576) goto L24;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        Object r104 = Result.m9449constructorimpl(Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(r100)).toString());     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r104) == true) goto L20;
        r102 = r104;
    L20:
        return (String) r102;
    L13:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L24:
        return null;
    L5:
        r101 = false;
        goto L6
    }
}
