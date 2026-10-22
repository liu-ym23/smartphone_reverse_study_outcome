package kotlin.io;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ByteIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\u000b\u001a\u00020\f*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\r\u001a\u00020\u000e*\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\r\u0010\u0013\u001a\u00020\u000e*\u00020\u0014H\u0087\b\u001a\u001d\u0010\u0013\u001a\u00020\u000e*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0018*\u00020\u0001H\u0086\u0002\u001a\f\u0010\u0019\u001a\u00020\u0014*\u00020\u0002H\u0007\u001a\u0016\u0010\u0019\u001a\u00020\u0014*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u0004H\u0007\u001a\u0017\u0010\u001b\u001a\u00020\u001c*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\u001d\u001a\u00020\u001e*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b¨\u0006\u001f"}, d2 = {"buffered", "Ljava/io/BufferedInputStream;", "Ljava/io/InputStream;", "bufferSize", "", "Ljava/io/BufferedOutputStream;", "Ljava/io/OutputStream;", "bufferedReader", "Ljava/io/BufferedReader;", "charset", "Ljava/nio/charset/Charset;", "bufferedWriter", "Ljava/io/BufferedWriter;", "byteInputStream", "Ljava/io/ByteArrayInputStream;", "", "copyTo", "", Argument.OUT, "inputStream", "", "offset", "length", "iterator", "Lkotlin/collections/ByteIterator;", "readBytes", "estimatedSize", "reader", "Ljava/io/InputStreamReader;", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ByteStreamsKt {
    private static final ByteArrayInputStream inputStream(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new ByteArrayInputStream(r100);
    }

    public static final ByteIterator iterator(final BufferedInputStream r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new AnonymousClass1(r100);
    }

    public static final byte[] readBytes(InputStream r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ByteArrayOutputStream r101 = new ByteArrayOutputStream(Math.max(8192, r100.available()));
        copyTo$default(r100, r101, 0, 2, null);
        return r101.toByteArray();
    }

    private static final BufferedInputStream buffered(InputStream r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof BufferedInputStream) == false) goto L6;
        return (BufferedInputStream) r100;
    L6:
        return new BufferedInputStream(r100, r101);
    }

    private static final BufferedReader bufferedReader(InputStream r100, Charset r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Reader r102 = new InputStreamReader(r100, r101);
        if ((r102 instanceof BufferedReader) == false) goto L6;
        return (BufferedReader) r102;
    L6:
        return new BufferedReader(r102, 8192);
    }

    private static final BufferedWriter bufferedWriter(OutputStream r100, Charset r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Writer r102 = new OutputStreamWriter(r100, r101);
        if ((r102 instanceof BufferedWriter) == false) goto L6;
        return (BufferedWriter) r102;
    L6:
        return new BufferedWriter(r102, 8192);
    }

    private static final ByteArrayInputStream byteInputStream(String r100, Charset r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        return new ByteArrayInputStream(r100.getBytes(r101));
    }

    @Deprecated(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @ReplaceWith(expression = "readBytes()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", warningSince = "1.3")
    public static final byte[] readBytes(InputStream r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ByteArrayOutputStream r102 = new ByteArrayOutputStream(Math.max(r101, r100.available()));
        copyTo$default(r100, r102, 0, 2, null);
        return r102.toByteArray();
    }

    private static final InputStreamReader reader(InputStream r100, Charset r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        return new InputStreamReader(r100, r101);
    }

    private static final OutputStreamWriter writer(OutputStream r100, Charset r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        return new OutputStreamWriter(r100, r101);
    }

    private static final BufferedOutputStream buffered(OutputStream r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof BufferedOutputStream) == false) goto L6;
        return (BufferedOutputStream) r100;
    L6:
        return new BufferedOutputStream(r100, r101);
    }

    public static final long copyTo(InputStream r100, OutputStream r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, Argument.OUT);
        byte[] r103 = new byte[r102];
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

    private static final ByteArrayInputStream inputStream(byte[] r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new ByteArrayInputStream(r100, r101, r102);
    }

    public static /* synthetic */ BufferedInputStream buffered$default(InputStream r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = 8192;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof BufferedInputStream) == false) goto L9;
        return (BufferedInputStream) r100;
    L9:
        return new BufferedInputStream(r100, r101);
    }

    public static /* synthetic */ BufferedReader bufferedReader$default(InputStream r100, Charset r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Reader r104 = new InputStreamReader(r100, r101);
        if ((r104 instanceof BufferedReader) == false) goto L9;
        return (BufferedReader) r104;
    L9:
        return new BufferedReader(r104, 8192);
    }

    public static /* synthetic */ BufferedWriter bufferedWriter$default(OutputStream r100, Charset r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Writer r104 = new OutputStreamWriter(r100, r101);
        if ((r104 instanceof BufferedWriter) == false) goto L9;
        return (BufferedWriter) r104;
    L9:
        return new BufferedWriter(r104, 8192);
    }

    public static /* synthetic */ ByteArrayInputStream byteInputStream$default(String r100, Charset r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        return new ByteArrayInputStream(r100.getBytes(r101));
    }

    public static /* synthetic */ byte[] readBytes$default(InputStream r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = 8192;
    L6:
        return readBytes(r100, r101);
    }

    public static /* synthetic */ InputStreamReader reader$default(InputStream r100, Charset r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        return new InputStreamReader(r100, r101);
    }

    public static /* synthetic */ OutputStreamWriter writer$default(OutputStream r100, Charset r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        return new OutputStreamWriter(r100, r101);
    }

    public static /* synthetic */ BufferedOutputStream buffered$default(OutputStream r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = 8192;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof BufferedOutputStream) == false) goto L9;
        return (BufferedOutputStream) r100;
    L9:
        return new BufferedOutputStream(r100, r101);
    }

    public static /* synthetic */ long copyTo$default(InputStream r100, OutputStream r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 8192;
    L6:
        return copyTo(r100, r101, r102);
    }
}
