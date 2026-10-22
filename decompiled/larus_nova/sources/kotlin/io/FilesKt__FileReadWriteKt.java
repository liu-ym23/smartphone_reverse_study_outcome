package kotlin.io;

import androidx.collection.SieveCacheKt;
import androidx.exifinterface.media.ExifInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u001c\u0010\u000b\u001a\u00020\u0007*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a!\u0010\u0010\u001a\u00020\u0011*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0003H\u0087\b\u001a!\u0010\u0013\u001a\u00020\u0014*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0003H\u0087\b\u001aB\u0010\u0015\u001a\u00020\u0007*\u00020\b26\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00070\u0017\u001aJ\u0010\u0015\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000326\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00070\u0017\u001a7\u0010\u001d\u001a\u00020\u0007*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00070\u001e\u001a\r\u0010 \u001a\u00020!*\u00020\bH\u0087\b\u001a\u0014\u0010\"\u001a\n #*\u0004\u0018\u00010\u00050\u0005*\u00020\u000fH\u0000\u001a\r\u0010$\u001a\u00020%*\u00020\bH\u0087\b\u001a\u0017\u0010&\u001a\u00020'*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001a\n\u0010(\u001a\u00020\n*\u00020\b\u001a\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0**\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a\u0014\u0010+\u001a\u00020\r*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a\u0017\u0010,\u001a\u00020-*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001aL\u0010.\u001a\u0002H/\"\u0004\b\u0000\u0010/*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0018\u00100\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r01\u0012\u0004\u0012\u0002H/0\u001eH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u00102\u001a\u0012\u00103\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u001c\u00104\u001a\u00020\u0007*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a\u001c\u00105\u001a\u00020\u0007*\u0002062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0017\u00107\u001a\u000208*\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00069"}, d2 = {"byteBufferForEncoding", "Ljava/nio/ByteBuffer;", "chunkSize", "", "encoder", "Ljava/nio/charset/CharsetEncoder;", "appendBytes", "", "Ljava/io/File;", "array", "", "appendText", "text", "", "charset", "Ljava/nio/charset/Charset;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "bufferedWriter", "Ljava/io/BufferedWriter;", "forEachBlock", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "buffer", "bytesRead", "blockSize", "forEachLine", "Lkotlin/Function1;", "line", "inputStream", "Ljava/io/FileInputStream;", "newReplaceEncoder", "kotlin.jvm.PlatformType", "outputStream", "Ljava/io/FileOutputStream;", "printWriter", "Ljava/io/PrintWriter;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "useLines", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/sequences/Sequence;", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "writeText", "writeTextImpl", "Ljava/io/OutputStream;", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/FilesKt")
class FilesKt__FileReadWriteKt extends FilesKt__FilePathComponentsKt {
    public FilesKt__FileReadWriteKt() {
    }

    private static final FileInputStream inputStream(File r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new FileInputStream(r100);
    }

    public static CharsetEncoder newReplaceEncoder(Charset r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    private static final FileOutputStream outputStream(File r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new FileOutputStream(r100);
    }

    public static byte[] readBytes(File r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        FileInputStream r101 = new FileInputStream(r100);
        long r102 = r100.length();     // Catch: Throwable -> L27
        if (r102 > SieveCacheKt.NodeLinkMask) goto L26;
        int r103 = (int) r102;
        byte[] r104 = new byte[r103];     // Catch: Throwable -> L27
        int r105 = r103;
        int r106 = 0;
    L8:
        if (r105 <= 0) goto L13;
        int r107 = r101.read(r104, r106, r105);     // Catch: Throwable -> L27
        if (r107 < 0) goto L13;
        r105 = r105 - r107;     // Catch: Throwable -> L27
        r106 = r106 + r107;     // Catch: Throwable -> L27
    L13:
        if (r105 <= 0) goto L15;
        r104 = Arrays.copyOf(r104, r106);     // Catch: Throwable -> L27
    L21:
        CloseableKt.closeFinally(r101, null);
        return r104;
    L15:
        int r108 = r101.read();     // Catch: Throwable -> L27
        if (r108 == (-1)) goto L21;
        ExposingBufferByteArrayOutputStream r109 = new ExposingBufferByteArrayOutputStream(8193);     // Catch: Throwable -> L27
        r109.write(r108);     // Catch: Throwable -> L27
        ByteStreamsKt.copyTo$default(r101, r109, 0, 2, null);     // Catch: Throwable -> L27
        int r110 = r109.size() + r103;     // Catch: Throwable -> L27
        if (r110 < 0) goto L24;
        r104 = ArraysKt.copyInto(r109.getBuffer(), Arrays.copyOf(r104, r110), r103, 0, r109.size());     // Catch: Throwable -> L27
        goto L21
    L24:
        throw new OutOfMemoryError("File " + r100 + " is too big to fit in memory.");     // Catch: Throwable -> L27
    L26:
        throw new OutOfMemoryError("File " + r100 + " is too big (" + r102 + " bytes) to fit in memory.");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);
        throw th;
    }

    public static void appendBytes(File r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "array");
        FileOutputStream r102 = new FileOutputStream(r100, true);
        r102.write(r101);     // Catch: Throwable -> L6
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r102, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    }

    public static ByteBuffer byteBufferForEncoding(int r100, CharsetEncoder r101) {
        Intrinsics.checkNotNullParameter(r101, "encoder");
        return ByteBuffer.allocate(r100 * ((int) Math.ceil(r101.maxBytesPerChar())));
    }

    public static final void forEachBlock(File r100, Function2<? super byte[], ? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "action");
        forEachBlock(r100, 4096, r101);
    }

    private static final PrintWriter printWriter(File r100, Charset r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Writer r102 = new OutputStreamWriter(new FileOutputStream(r100), r101);
        if ((r102 instanceof BufferedWriter) == false) goto L5;
        BufferedWriter r103 = (BufferedWriter) r102;
    L7:
        return new PrintWriter(r103);
    L5:
        r103 = new BufferedWriter(r102, 8192);
        goto L7
    }

    public static final List<String> readLines(File r100, Charset r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        final ArrayList r102 = new ArrayList();
        forEachLine(r100, r101, new AnonymousClass1(r102));
        return r102;
    }

    public static String readText(File r100, Charset r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        InputStreamReader r102 = new InputStreamReader(new FileInputStream(r100), r101);
        String r103 = TextStreamsKt.readText(r102);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r102, null);
        return r103;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    }

    private static final InputStreamReader reader(File r100, Charset r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        return new InputStreamReader(new FileInputStream(r100), r101);
    }

    public static void writeBytes(File r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "array");
        FileOutputStream r102 = new FileOutputStream(r100);
        r102.write(r101);     // Catch: Throwable -> L6
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r102, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    }

    private static final OutputStreamWriter writer(File r100, Charset r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        return new OutputStreamWriter(new FileOutputStream(r100), r101);
    }

    public static final void appendText(File r100, String r101, Charset r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "charset");
        FileOutputStream r103 = new FileOutputStream(r100, true);
        FilesKt.writeTextImpl(r103, r101, r102);     // Catch: Throwable -> L6
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r103, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    }

    private static final BufferedReader bufferedReader(File r100, Charset r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Reader r103 = new InputStreamReader(new FileInputStream(r100), r101);
        if ((r103 instanceof BufferedReader) == false) goto L6;
        return (BufferedReader) r103;
    L6:
        return new BufferedReader(r103, r102);
    }

    private static final BufferedWriter bufferedWriter(File r100, Charset r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Writer r103 = new OutputStreamWriter(new FileOutputStream(r100), r101);
        if ((r103 instanceof BufferedWriter) == false) goto L6;
        return (BufferedWriter) r103;
    L6:
        return new BufferedWriter(r103, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [byte[], java.lang.Object] */
    public static final void forEachBlock(File r100, int r101, Function2<? super byte[], ? super Integer, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "action");
        ?? r103 = new byte[RangesKt.coerceAtLeast(r101, 512)];
        FileInputStream r104 = new FileInputStream(r100);
    L15:
        int r105 = r104.read(r103);     // Catch: Throwable -> L10
        if (r105 <= 0) goto L5;
        r102.invoke(r103, Integer.valueOf(r105));     // Catch: Throwable -> L10
        goto L15
    L5:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r104, null);
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);
        throw th;
    }

    public static final void forEachLine(File r100, Charset r101, Function1<? super String, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Intrinsics.checkNotNullParameter(r102, "action");
        TextStreamsKt.forEachLine(new BufferedReader(new InputStreamReader(new FileInputStream(r100), r101)), r102);
    }

    public static final <T> T useLines(File r100, Charset r101, Function1<? super Sequence<String>, ? extends T> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Intrinsics.checkNotNullParameter(r102, "block");
        Reader r103 = new InputStreamReader(new FileInputStream(r100), r101);
        if ((r103 instanceof BufferedReader) == false) goto L5;
        BufferedReader r104 = (BufferedReader) r103;
    L25:
        T r105 = r102.invoke(TextStreamsKt.lineSequence(r104));     // Catch: Throwable -> L14
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L11;
        CloseableKt.closeFinally(r104, null);
    L12:
        InlineMarker.finallyEnd(1);
        return r105;
    L11:
        r104.close();
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L29;
        CloseableKt.closeFinally(r104, th);
    L22:
        InlineMarker.finallyEnd(1);
        throw th;
    L29:
        r104.close();     // Catch: Throwable -> L24
        goto L22
    L5:
        r104 = new BufferedReader(r103, 8192);
        goto L25
    }

    public static void writeText(File r100, String r101, Charset r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "charset");
        FileOutputStream r103 = new FileOutputStream(r100);
        FilesKt.writeTextImpl(r103, r101, r102);     // Catch: Throwable -> L6
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r103, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    }

    public static void writeTextImpl(OutputStream r100, String r101, Charset r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r110, "charset");
        if (r101.length() >= 16384) goto L6;
        r100.write(r101.getBytes(r110));
        return;
    L6:
        CharsetEncoder r111 = FilesKt.newReplaceEncoder(r110);
        CharBuffer r102 = CharBuffer.allocate(8192);
        Intrinsics.checkNotNull(r111);
        ByteBuffer r103 = FilesKt.byteBufferForEncoding(8192, r111);
        int r104 = 0;
        int r105 = 0;
    L8:
        if (r104 >= r101.length()) goto L22;
        int r106 = Math.min(8192 - r105, r101.length() - r104);
        int r107 = r104 + r106;
        r101.getChars(r104, r107, r102.array(), r105);
        r102.limit(r106 + r105);
        r105 = 1;
        if (r107 != r101.length()) goto L12;
        boolean r108 = true;
    L14:
        if (r111.encode(r102, r103, r108).isUnderflow() == false) goto L21;
        r100.write(r103.array(), 0, r103.position());
        if (r102.position() == r102.limit()) goto L18;
        r102.put(0, r102.get());
    L19:
        r102.clear();
        r103.clear();
        r104 = r107;
        goto L8
    L18:
        r105 = 0;
        goto L19
    L21:
        throw new IllegalStateException("Check failed.".toString());
    L12:
        r108 = false;
        goto L14
    }

    public static /* synthetic */ PrintWriter printWriter$default(File r100, Charset r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Writer r104 = new OutputStreamWriter(new FileOutputStream(r100), r101);
        if ((r104 instanceof BufferedWriter) == false) goto L8;
        BufferedWriter r105 = (BufferedWriter) r104;
    L10:
        return new PrintWriter(r105);
    L8:
        r105 = new BufferedWriter(r104, 8192);
        goto L10
    }

    public static /* synthetic */ List readLines$default(File r100, Charset r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = Charsets.UTF_8;
    L6:
        return readLines(r100, r101);
    }

    public static /* synthetic */ String readText$default(File r100, Charset r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = Charsets.UTF_8;
    L6:
        return FilesKt.readText(r100, r101);
    }

    public static /* synthetic */ InputStreamReader reader$default(File r100, Charset r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        return new InputStreamReader(new FileInputStream(r100), r101);
    }

    public static /* synthetic */ OutputStreamWriter writer$default(File r100, Charset r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        return new OutputStreamWriter(new FileOutputStream(r100), r101);
    }

    public static /* synthetic */ void appendText$default(File r100, String r101, Charset r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = Charsets.UTF_8;
    L5:
        appendText(r100, r101, r102);
    }

    public static /* synthetic */ BufferedReader bufferedReader$default(File r100, Charset r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = Charsets.UTF_8;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = 8192;
    L8:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Reader r105 = new InputStreamReader(new FileInputStream(r100), r101);
        if ((r105 instanceof BufferedReader) == false) goto L12;
        return (BufferedReader) r105;
    L12:
        return new BufferedReader(r105, r102);
    }

    public static /* synthetic */ BufferedWriter bufferedWriter$default(File r100, Charset r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = Charsets.UTF_8;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = 8192;
    L8:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Writer r105 = new OutputStreamWriter(new FileOutputStream(r100), r101);
        if ((r105 instanceof BufferedWriter) == false) goto L12;
        return (BufferedWriter) r105;
    L12:
        return new BufferedWriter(r105, r102);
    }

    public static /* synthetic */ void forEachLine$default(File r100, Charset r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = Charsets.UTF_8;
    L5:
        forEachLine(r100, r101, r102);
    }

    public static /* synthetic */ Object useLines$default(File r100, Charset r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Intrinsics.checkNotNullParameter(r102, "block");
        Reader r105 = new InputStreamReader(new FileInputStream(r100), r101);
        if ((r105 instanceof BufferedReader) == false) goto L8;
        BufferedReader r106 = (BufferedReader) r105;
    L28:
        Object r107 = r102.invoke(TextStreamsKt.lineSequence(r106));     // Catch: Throwable -> L17
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L14;
        CloseableKt.closeFinally(r106, null);
    L15:
        InlineMarker.finallyEnd(1);
        return r107;
    L14:
        r106.close();
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L32;
        CloseableKt.closeFinally(r106, th);
    L25:
        InlineMarker.finallyEnd(1);
        throw th;
    L32:
        r106.close();     // Catch: Throwable -> L27
        goto L25
    L8:
        r106 = new BufferedReader(r105, 8192);
        goto L28
    }

    public static /* synthetic */ void writeText$default(File r100, String r101, Charset r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = Charsets.UTF_8;
    L5:
        FilesKt.writeText(r100, r101, r102);
    }
}
