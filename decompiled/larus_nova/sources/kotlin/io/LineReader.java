package kotlin.io;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lkotlin/io/LineReader;", "", "()V", "BUFFER_SIZE", "", "byteBuf", "Ljava/nio/ByteBuffer;", HTTP.CONTENT_RANGE_BYTES, "", "charBuf", "Ljava/nio/CharBuffer;", "chars", "", "decoder", "Ljava/nio/charset/CharsetDecoder;", "directEOL", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "compactBytes", "decode", "endOfInput", "decodeEndOfInput", "nBytes", "nChars", "readLine", "", "inputStream", "Ljava/io/InputStream;", "charset", "Ljava/nio/charset/Charset;", "resetAll", "", "trimStringBuilder", "updateCharset", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LineReader {
    private static final int BUFFER_SIZE = 32;
    public static final LineReader INSTANCE = null;
    private static final ByteBuffer byteBuf = null;
    private static final byte[] bytes = null;
    private static final CharBuffer charBuf = null;
    private static final char[] chars = null;
    private static CharsetDecoder decoder;
    private static boolean directEOL;

    /* JADX INFO: renamed from: sb, reason: collision with root package name */
    private static final StringBuilder f504560sb = null;

    private LineReader() {
    }

    static {
        INSTANCE = new LineReader();
        byte[] r100 = new byte[32];
        bytes = r100;
        char[] r101 = new char[32];
        chars = r101;
        byteBuf = ByteBuffer.wrap(r100);
        charBuf = CharBuffer.wrap(r101);
        f504560sb = new StringBuilder();
    }

    private final int compactBytes() {
        ByteBuffer r100 = byteBuf;
        r100.compact();
        int r101 = r100.position();
        r100.position(0);
        return r101;
    }

    private final void resetAll() {
        CharsetDecoder r100 = decoder;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoder");
        r100 = null;
    L5:
        r100.reset();
        byteBuf.position(0);
        f504560sb.setLength(0);
    }

    private final void trimStringBuilder() {
        StringBuilder r100 = f504560sb;
        r100.setLength(32);
        r100.trimToSize();
    }

    private final int decode(boolean r100) {
    L2:
        CharsetDecoder r101 = decoder;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoder");
        r101 = null;
    L5:
        ByteBuffer r102 = byteBuf;
        CharBuffer r103 = charBuf;
        CoderResult r104 = r101.decode(r102, r103, r100);
        if (r104.isError() == false) goto L8;
        resetAll();
        r104.throwException();
    L8:
        int r105 = r103.position();
        if (r104.isOverflow() == false) goto L10;
        StringBuilder r106 = f504560sb;
        char[] r107 = chars;
        int r108 = r105 - 1;
        r106.append(r107, 0, r108);
        r103.position(0);
        r103.limit(32);
        r103.put(r107[r108]);
        goto L2
    L10:
        return r105;
    }

    private final void updateCharset(Charset r100) {
        decoder = r100.newDecoder();
        ByteBuffer r101 = byteBuf;
        r101.clear();
        CharBuffer r102 = charBuf;
        r102.clear();
        r101.put((byte) 10);
        r101.flip();
        CharsetDecoder r103 = decoder;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoder");
        r103 = null;
    L5:
        boolean r104 = false;
        r103.decode(r101, r102, false);
        if (r102.position() == 1) goto L8;
    L10:
        directEOL = r104;
        resetAll();
        return;
    L8:
        if (r102.get(0) != '\n') goto L10;
        r104 = true;
        goto L10
    }

    private final int decodeEndOfInput(int r100, int r101) {
        ByteBuffer r102 = byteBuf;
        r102.limit(r100);
        charBuf.position(r101);
        int r103 = decode(true);
        CharsetDecoder r104 = decoder;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoder");
        r104 = null;
    L5:
        r104.reset();
        r102.position(0);
        return r103;
    }

    public final synchronized String readLine(InputStream r110, Charset r111) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r110, "inputStream");     // Catch: Throwable -> L59
        Intrinsics.checkNotNullParameter(r111, "charset");     // Catch: Throwable -> L59
        CharsetDecoder r100 = decoder;     // Catch: Throwable -> L59
        if (r100 == null) goto L9;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("decoder");     // Catch: Throwable -> L59
        r100 = null;
    L8:
        if (Intrinsics.areEqual(r100.charset(), r111) == false) goto L9;
    L10:
        int r101 = 0;
        int r102 = 0;
    L11:
        int r103 = r110.read();     // Catch: Throwable -> L59
        boolean r104 = true;
        if (r103 == (-1)) goto L14;
        int r105 = r101 + 1;     // Catch: Throwable -> L59
        bytes[r101] = (byte) r103;     // Catch: Throwable -> L59
        if (r103 == 10) goto L30;
        if (r105 == 32) goto L30;
        if (directEOL == false) goto L30;
        r101 = r105;
    L30:
        ByteBuffer r106 = byteBuf;     // Catch: Throwable -> L59
        r106.limit(r105);     // Catch: Throwable -> L59
        charBuf.position(r102);     // Catch: Throwable -> L59
        r102 = decode(false);     // Catch: Throwable -> L59
        if (r102 > 0) goto L33;
    L57:
        r101 = compactBytes();     // Catch: Throwable -> L59
        goto L11
    L33:
        if (chars[r102 - 1] != '\n') goto L57;
        r106.position(0);     // Catch: Throwable -> L59
        int r112 = r102;
    L35:
        if (r112 <= 0) goto L43;
        char[] r107 = chars;     // Catch: Throwable -> L59
        if (r107[r112 - 1] != '\n') goto L43;
        r112 = r112 - 1;     // Catch: Throwable -> L59
        if (r112 <= 0) goto L43;
        if (r107[r112 - 1] != '\r') goto L43;
        r112 = r112 - 1;     // Catch: Throwable -> L59
    L43:
        StringBuilder r108 = f504560sb;     // Catch: Throwable -> L59
        if (r108.length() == 0) goto L47;
        r104 = false;
    L47:
        if (r104 == false) goto L51;
        String r109 = new String(chars, 0, r112);     // Catch: Throwable -> L59
        monitor-exit(this);
        return r109;
    L51:
        r108.append(chars, 0, r112);     // Catch: Throwable -> L59
        String r113 = r108.toString();     // Catch: Throwable -> L59
        if (r108.length() <= 32) goto L54;
        trimStringBuilder();     // Catch: Throwable -> L59
    L54:
        r108.setLength(0);     // Catch: Throwable -> L59
        monitor-exit(this);
        return r113;
    L14:
        if (f504560sb.length() != 0) goto L16;
        boolean r114 = true;
    L17:
        if (r114 == false) goto L22;
        if (r101 != 0) goto L22;
        if (r102 != 0) goto L22;
        monitor-exit(this);
        return null;
    L22:
        r112 = decodeEndOfInput(r101, r102);     // Catch: Throwable -> L59
        goto L35
    L16:
        r114 = false;
    L9:
        updateCharset(r111);     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        throw th;
    }
}
