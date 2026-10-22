package com.bytedance.pia.core.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes21.dex */
public final class StreamUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f266377a = 0;

    static {
    }

    public static Charset c(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(Charset.forName(r100));     // Catch: Throwable -> L4
    L6:
        Charset r103 = Charset.defaultCharset();
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = r103;
    L10:
        return (Charset) r102;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    @JvmStatic
    public static final String b(InputStream r100, String r101) throws Throwable {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r102 = TextStreamsKt.readText(new InputStreamReader(r100, c(r101)));     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r100, null);
        return r102;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r100, th);
        throw th;
    }

    @JvmStatic
    public static final Sequence<char[]> a(InputStream r100, String r101, int r102) throws Throwable {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Sequence<char[]> r103 = SequencesKt.sequence(new StreamUtils$asSequence$1$1(r102, new InputStreamReader(r100, c(r101)), null));     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r100, null);
        return r103;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r100, th);
        throw th;
    }
}
