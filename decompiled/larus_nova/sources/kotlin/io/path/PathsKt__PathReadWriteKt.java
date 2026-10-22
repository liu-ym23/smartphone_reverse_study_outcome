package kotlin.io.path;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.template.GXTemplateKey;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a%\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a%\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u001e\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a:\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010\u0015\u001a:\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010\u0018\u001a=\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00010\u001bH\u0087\bø\u0001\u0000\u001a&\u0010 \u001a\u00020!*\u00020\u00022\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010\"\u001a&\u0010#\u001a\u00020$*\u00020\u00022\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010%\u001a\r\u0010&\u001a\u00020\u0004*\u00020\u0002H\u0087\b\u001a\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0(*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0016\u0010)\u001a\u00020\u001c*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a0\u0010*\u001a\u00020+*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010,\u001aL\u0010-\u001a\u0002H.\"\u0004\b\u0000\u0010.*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0018\u0010/\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u000b\u0012\u0004\u0012\u0002H.0\u001bH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u00100\u001a.\u00101\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u00102\u001a>\u00103\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u00104\u001a>\u00103\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u00105\u001a7\u00106\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0007¢\u0006\u0002\u00107\u001a0\u00108\u001a\u000209*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010:\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006;"}, d2 = {"appendBytes", "", "Ljava/nio/file/Path;", "array", "", "appendLines", GXTemplateKey.STYLE_FONT_LINES, "", "", "charset", "Ljava/nio/charset/Charset;", "Lkotlin/sequences/Sequence;", "appendText", "text", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedReader;", "bufferedWriter", "Ljava/io/BufferedWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedWriter;", "forEachLine", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "line", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStream;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/InputStreamReader;", "useLines", ExifInterface.GPS_DIRECTION_TRUE, "block", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "(Ljava/nio/file/Path;[B[Ljava/nio/file/OpenOption;)V", "writeLines", "(Ljava/nio/file/Path;Ljava/lang/Iterable;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "(Ljava/nio/file/Path;Lkotlin/sequences/Sequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "writeText", "(Ljava/nio/file/Path;Ljava/lang/CharSequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)V", "writer", "Ljava/io/OutputStreamWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStreamWriter;", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
class PathsKt__PathReadWriteKt {
    public PathsKt__PathReadWriteKt() {
    }

    private static final byte[] readBytes(Path r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Files.readAllBytes(r100);
    }

    private static final void appendBytes(Path r100, byte[] r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "array");
        Files.write(r100, r101, new OpenOption[]{StandardOpenOption.APPEND});
    }

    private static final InputStream inputStream(Path r100, OpenOption... r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "options");
        return Files.newInputStream(r100, (OpenOption[]) Arrays.copyOf(r101, r101.length));
    }

    private static final OutputStream outputStream(Path r100, OpenOption... r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "options");
        return Files.newOutputStream(r100, (OpenOption[]) Arrays.copyOf(r101, r101.length));
    }

    private static final List<String> readLines(Path r100, Charset r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        return Files.readAllLines(r100, r101);
    }

    public static final String readText(Path r100, Charset r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        InputStreamReader r102 = new InputStreamReader(Files.newInputStream(r100, (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0)), r101);
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

    private static final Path appendLines(Path r100, Sequence<? extends CharSequence> r101, Charset r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.STYLE_FONT_LINES);
        Intrinsics.checkNotNullParameter(r102, "charset");
        return Files.write(r100, SequencesKt.asIterable(r101), r102, new OpenOption[]{StandardOpenOption.APPEND});
    }

    public static final void appendText(Path r100, CharSequence r101, Charset r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "charset");
        writeText(r100, r101, r102, new OpenOption[]{StandardOpenOption.APPEND});
    }

    private static final void forEachLine(Path r100, Charset r101, Function1<? super String, Unit> r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Intrinsics.checkNotNullParameter(r102, "action");
        BufferedReader r103 = Files.newBufferedReader(r100, r101);
        Iterator<String> r104 = TextStreamsKt.lineSequence(r103).iterator();     // Catch: Throwable -> L14
    L5:
        if (r104.hasNext() == false) goto L7;
        r102.invoke(r104.next());     // Catch: Throwable -> L14
        goto L5
    L7:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L14
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L11;
        CloseableKt.closeFinally(r103, null);
    L12:
        InlineMarker.finallyEnd(1);
        return;
    L11:
        r103.close();
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L29;
        CloseableKt.closeFinally(r103, th);
    L22:
        InlineMarker.finallyEnd(1);
        throw th;
    L29:
        r103.close();     // Catch: Throwable -> L24
        goto L22
    }

    private static final InputStreamReader reader(Path r100, Charset r101, OpenOption... r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Intrinsics.checkNotNullParameter(r102, "options");
        return new InputStreamReader(Files.newInputStream(r100, (OpenOption[]) Arrays.copyOf(r102, r102.length)), r101);
    }

    private static final <T> T useLines(Path r100, Charset r101, Function1<? super Sequence<String>, ? extends T> r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Intrinsics.checkNotNullParameter(r102, "block");
        BufferedReader r103 = Files.newBufferedReader(r100, r101);
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L11
        T r104 = r102.invoke(TextStreamsKt.lineSequence(r103));     // Catch: Throwable -> L11
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L7;
        CloseableKt.closeFinally(r103, null);
    L9:
        InlineMarker.finallyEnd(1);
        return r104;
    L7:
        if (r103 == null) goto L9;
        r103.close();
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L19;
        if (r103 != null) goto L27;
    L20:
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        r103.close();     // Catch: Throwable -> L22
        goto L20
    L19:
        CloseableKt.closeFinally(r103, th);
        goto L20
    }

    private static final void writeBytes(Path r100, byte[] r101, OpenOption... r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "array");
        Intrinsics.checkNotNullParameter(r102, "options");
        Files.write(r100, r101, (OpenOption[]) Arrays.copyOf(r102, r102.length));
    }

    private static final OutputStreamWriter writer(Path r100, Charset r101, OpenOption... r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Intrinsics.checkNotNullParameter(r102, "options");
        return new OutputStreamWriter(Files.newOutputStream(r100, (OpenOption[]) Arrays.copyOf(r102, r102.length)), r101);
    }

    private static final Path appendLines(Path r100, Iterable<? extends CharSequence> r101, Charset r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.STYLE_FONT_LINES);
        Intrinsics.checkNotNullParameter(r102, "charset");
        return Files.write(r100, r101, r102, new OpenOption[]{StandardOpenOption.APPEND});
    }

    private static final BufferedReader bufferedReader(Path r100, Charset r101, int r102, OpenOption... r103) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Intrinsics.checkNotNullParameter(r103, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(r100, (OpenOption[]) Arrays.copyOf(r103, r103.length)), r101), r102);
    }

    private static final BufferedWriter bufferedWriter(Path r100, Charset r101, int r102, OpenOption... r103) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Intrinsics.checkNotNullParameter(r103, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(r100, (OpenOption[]) Arrays.copyOf(r103, r103.length)), r101), r102);
    }

    public static /* synthetic */ List readLines$default(Path r100, Charset r101, int r102, Object r103) throws IOException {
        if ((r102 & 1) == 0) goto L5;
        r101 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        return Files.readAllLines(r100, r101);
    }

    public static /* synthetic */ String readText$default(Path r100, Charset r101, int r102, Object r103) throws IOException {
        if ((r102 & 1) == 0) goto L6;
        r101 = Charsets.UTF_8;
    L6:
        return readText(r100, r101);
    }

    private static final Path writeLines(Path r100, Sequence<? extends CharSequence> r101, Charset r102, OpenOption... r103) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.STYLE_FONT_LINES);
        Intrinsics.checkNotNullParameter(r102, "charset");
        Intrinsics.checkNotNullParameter(r103, "options");
        return Files.write(r100, SequencesKt.asIterable(r101), r102, (OpenOption[]) Arrays.copyOf(r103, r103.length));
    }

    public static final void writeText(Path r100, CharSequence r101, Charset r102, OpenOption... r103) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "charset");
        Intrinsics.checkNotNullParameter(r103, "options");
        OutputStream r104 = Files.newOutputStream(r100, (OpenOption[]) Arrays.copyOf(r103, r103.length));
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);
        throw th;
    L4:
        if ((r101 instanceof String) == false) goto L6;
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L21
        FilesKt.writeTextImpl(r104, (String) r101, r102);     // Catch: Throwable -> L21
    L18:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r104, null);
        return;
    L6:
        CharsetEncoder r106 = FilesKt.newReplaceEncoder(r102);     // Catch: Throwable -> L21
        if ((r101 instanceof CharBuffer) == false) goto L9;
        CharBuffer r107 = ((CharBuffer) r101).asReadOnlyBuffer();     // Catch: Throwable -> L21
    L10:
        int r108 = Math.min(r101.length(), 8192);     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L21
        ByteBuffer r109 = FilesKt.byteBufferForEncoding(r108, r106);     // Catch: Throwable -> L21
    L12:
        if (r107.hasRemaining() == false) goto L18;
        if ((true ^ r106.encode(r107, r109, true).isError()) == false) goto L17;
        r104.write(r109.array(), 0, r109.position());     // Catch: Throwable -> L21
        r109.clear();     // Catch: Throwable -> L21
        goto L12
    L17:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L21
    L9:
        r107 = CharBuffer.wrap(r101);     // Catch: Throwable -> L21
        goto L10
    }

    private static final Path writeLines(Path r100, Iterable<? extends CharSequence> r101, Charset r102, OpenOption... r103) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.STYLE_FONT_LINES);
        Intrinsics.checkNotNullParameter(r102, "charset");
        Intrinsics.checkNotNullParameter(r103, "options");
        return Files.write(r100, r101, r102, (OpenOption[]) Arrays.copyOf(r103, r103.length));
    }

    public static /* synthetic */ Path appendLines$default(Path r100, Sequence r101, Charset r102, int r103, Object r104) throws IOException {
        if ((r103 & 2) == 0) goto L5;
        r102 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.STYLE_FONT_LINES);
        Intrinsics.checkNotNullParameter(r102, "charset");
        return Files.write(r100, SequencesKt.asIterable(r101), r102, new OpenOption[]{StandardOpenOption.APPEND});
    }

    public static /* synthetic */ void appendText$default(Path r100, CharSequence r101, Charset r102, int r103, Object r104) throws IOException {
        if ((r103 & 2) == 0) goto L5;
        r102 = Charsets.UTF_8;
    L5:
        appendText(r100, r101, r102);
    }

    public static /* synthetic */ void forEachLine$default(Path r100, Charset r101, Function1 r102, int r103, Object r104) throws IOException {
        if ((r103 & 1) == 0) goto L5;
        r101 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Intrinsics.checkNotNullParameter(r102, "action");
        BufferedReader r105 = Files.newBufferedReader(r100, r101);
        Iterator<String> r106 = TextStreamsKt.lineSequence(r105).iterator();     // Catch: Throwable -> L17
    L8:
        if (r106.hasNext() == false) goto L10;
        r102.invoke(r106.next());     // Catch: Throwable -> L17
        goto L8
    L10:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L17
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L14;
        CloseableKt.closeFinally(r105, null);
    L15:
        InlineMarker.finallyEnd(1);
        return;
    L14:
        r105.close();
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L32;
        CloseableKt.closeFinally(r105, th);
    L25:
        InlineMarker.finallyEnd(1);
        throw th;
    L32:
        r105.close();     // Catch: Throwable -> L27
        goto L25
    }

    public static /* synthetic */ InputStreamReader reader$default(Path r100, Charset r101, OpenOption[] r102, int r103, Object r104) throws IOException {
        if ((r103 & 1) == 0) goto L5;
        r101 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Intrinsics.checkNotNullParameter(r102, "options");
        return new InputStreamReader(Files.newInputStream(r100, (OpenOption[]) Arrays.copyOf(r102, r102.length)), r101);
    }

    public static /* synthetic */ Object useLines$default(Path r100, Charset r101, Function1 r102, int r103, Object r104) throws IOException {
        if ((r103 & 1) == 0) goto L5;
        r101 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Intrinsics.checkNotNullParameter(r102, "block");
        BufferedReader r105 = Files.newBufferedReader(r100, r101);
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L14
        Object r106 = r102.invoke(TextStreamsKt.lineSequence(r105));     // Catch: Throwable -> L14
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L10;
        CloseableKt.closeFinally(r105, null);
    L12:
        InlineMarker.finallyEnd(1);
        return r106;
    L10:
        if (r105 == null) goto L12;
        r105.close();
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L22;
        if (r105 != null) goto L26;
    L23:
        InlineMarker.finallyEnd(1);
        throw th;
    L26:
        r105.close();     // Catch: Throwable -> L25
        goto L23
    L22:
        CloseableKt.closeFinally(r105, th);
        goto L23
    }

    public static /* synthetic */ OutputStreamWriter writer$default(Path r100, Charset r101, OpenOption[] r102, int r103, Object r104) throws IOException {
        if ((r103 & 1) == 0) goto L5;
        r101 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Intrinsics.checkNotNullParameter(r102, "options");
        return new OutputStreamWriter(Files.newOutputStream(r100, (OpenOption[]) Arrays.copyOf(r102, r102.length)), r101);
    }

    public static /* synthetic */ Path appendLines$default(Path r100, Iterable r101, Charset r102, int r103, Object r104) throws IOException {
        if ((r103 & 2) == 0) goto L5;
        r102 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.STYLE_FONT_LINES);
        Intrinsics.checkNotNullParameter(r102, "charset");
        return Files.write(r100, r101, r102, new OpenOption[]{StandardOpenOption.APPEND});
    }

    public static /* synthetic */ BufferedReader bufferedReader$default(Path r100, Charset r101, int r102, OpenOption[] r103, int r104, Object r105) throws IOException {
        if ((r104 & 1) == 0) goto L6;
        r101 = Charsets.UTF_8;
    L6:
        if ((r104 & 2) == 0) goto L8;
        r102 = 8192;
    L8:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Intrinsics.checkNotNullParameter(r103, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(r100, (OpenOption[]) Arrays.copyOf(r103, r103.length)), r101), r102);
    }

    public static /* synthetic */ BufferedWriter bufferedWriter$default(Path r100, Charset r101, int r102, OpenOption[] r103, int r104, Object r105) throws IOException {
        if ((r104 & 1) == 0) goto L6;
        r101 = Charsets.UTF_8;
    L6:
        if ((r104 & 2) == 0) goto L8;
        r102 = 8192;
    L8:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        Intrinsics.checkNotNullParameter(r103, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(r100, (OpenOption[]) Arrays.copyOf(r103, r103.length)), r101), r102);
    }

    public static /* synthetic */ Path writeLines$default(Path r100, Sequence r101, Charset r102, OpenOption[] r103, int r104, Object r105) throws IOException {
        if ((r104 & 2) == 0) goto L5;
        r102 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.STYLE_FONT_LINES);
        Intrinsics.checkNotNullParameter(r102, "charset");
        Intrinsics.checkNotNullParameter(r103, "options");
        return Files.write(r100, SequencesKt.asIterable(r101), r102, (OpenOption[]) Arrays.copyOf(r103, r103.length));
    }

    public static /* synthetic */ void writeText$default(Path r100, CharSequence r101, Charset r102, OpenOption[] r103, int r104, Object r105) throws IOException {
        if ((r104 & 2) == 0) goto L5;
        r102 = Charsets.UTF_8;
    L5:
        writeText(r100, r101, r102, r103);
    }

    public static /* synthetic */ Path writeLines$default(Path r100, Iterable r101, Charset r102, OpenOption[] r103, int r104, Object r105) throws IOException {
        if ((r104 & 2) == 0) goto L5;
        r102 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.STYLE_FONT_LINES);
        Intrinsics.checkNotNullParameter(r102, "charset");
        Intrinsics.checkNotNullParameter(r103, "options");
        return Files.write(r100, r101, r102, (OpenOption[]) Arrays.copyOf(r103, r103.length));
    }
}
