package kotlin.io;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r\u001a\u0010\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010*\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0013\u001a\u0010\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015*\u00020\u0002\u001a\n\u0010\u0016\u001a\u00020\u000e*\u00020\u0002\u001a\u0017\u0010\u0016\u001a\u00020\u000e*\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u001a*\u00020\u000eH\u0087\b\u001aB\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c*\u00020\u00022\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0010\u0012\u0004\u0012\u0002H\u001c0\rH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"buffered", "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", "", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "copyTo", "", Argument.OUT, "forEachLine", "", "action", "Lkotlin/Function1;", "", "lineSequence", "Lkotlin/sequences/Sequence;", "readBytes", "", "Ljava/net/URL;", "readLines", "", "readText", "charset", "Ljava/nio/charset/Charset;", "reader", "Ljava/io/StringReader;", "useLines", ExifInterface.GPS_DIRECTION_TRUE, "block", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class TextStreamsKt {
    public static final Sequence<String> lineSequence(BufferedReader r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return SequencesKt.constrainOnce(new LinesSequence(r100));
    }

    public static final byte[] readBytes(URL r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        InputStream r101 = r100.openStream();
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L6
        byte[] r102 = ByteStreamsKt.readBytes(r101);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r101, null);
        return r102;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);
        throw th;
    }

    public static final List<String> readLines(Reader r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        final ArrayList r101 = new ArrayList();
        forEachLine(r100, new AnonymousClass1(r101));
        return r101;
    }

    public static final String readText(Reader r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        StringWriter r101 = new StringWriter();
        copyTo$default(r100, r101, 0, 2, null);
        return r101.toString();
    }

    private static final StringReader reader(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new StringReader(r100);
    }

    private static final BufferedReader buffered(Reader r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof BufferedReader) == false) goto L6;
        return (BufferedReader) r100;
    L6:
        return new BufferedReader(r100, r101);
    }

    public static final void forEachLine(Reader r100, Function1<? super String, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "action");
        if ((r100 instanceof BufferedReader) == false) goto L5;
        BufferedReader r102 = (BufferedReader) r100;
    L18:
        Iterator<String> r103 = lineSequence(r102).iterator();     // Catch: Throwable -> L13
    L8:
        if (r103.hasNext() == false) goto L10;
        r101.invoke(r103.next());     // Catch: Throwable -> L13
        goto L8
    L10:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r102, null);
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    L5:
        r102 = new BufferedReader(r100, 8192);
        goto L18
    }

    private static final String readText(URL r100, Charset r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        return new String(readBytes(r100), r101);
    }

    public static final <T> T useLines(Reader r100, Function1<? super Sequence<String>, ? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "block");
        if ((r100 instanceof BufferedReader) == false) goto L5;
        BufferedReader r102 = (BufferedReader) r100;
    L25:
        T r103 = r101.invoke(lineSequence(r102));     // Catch: Throwable -> L14
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L11;
        CloseableKt.closeFinally(r102, null);
    L12:
        InlineMarker.finallyEnd(1);
        return r103;
    L11:
        r102.close();
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L29;
        CloseableKt.closeFinally(r102, th);
    L22:
        InlineMarker.finallyEnd(1);
        throw th;
    L29:
        r102.close();     // Catch: Throwable -> L24
        goto L22
    L5:
        r102 = new BufferedReader(r100, 8192);
        goto L25
    }

    private static final BufferedWriter buffered(Writer r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof BufferedWriter) == false) goto L6;
        return (BufferedWriter) r100;
    L6:
        return new BufferedWriter(r100, r101);
    }

    public static final long copyTo(Reader r100, Writer r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, Argument.OUT);
        char[] r103 = new char[r102];
        int r104 = r100.read(r103);
        long r105 = 0;
    L3:
        if (r104 < 0) goto L5;
        r101.write(r103, 0, r104);
        r105 = r105 + ((long) r104);
        r104 = r100.read(r103);
        goto L3
    L5:
        return r105;
    }

    public static /* synthetic */ BufferedReader buffered$default(Reader r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = 8192;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof BufferedReader) == false) goto L9;
        return (BufferedReader) r100;
    L9:
        return new BufferedReader(r100, r101);
    }

    public static /* synthetic */ String readText$default(URL r100, Charset r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        return new String(readBytes(r100), r101);
    }

    public static /* synthetic */ BufferedWriter buffered$default(Writer r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = 8192;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof BufferedWriter) == false) goto L9;
        return (BufferedWriter) r100;
    L9:
        return new BufferedWriter(r100, r101);
    }

    public static /* synthetic */ long copyTo$default(Reader r100, Writer r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 8192;
    L6:
        return copyTo(r100, r101, r102);
    }
}
