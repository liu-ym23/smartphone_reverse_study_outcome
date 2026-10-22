package kotlin.io.encoding;

import com.bytedance.android.ec.core.event.a;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0002J(\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\b\u0010\u001d\u001a\u00020\tH\u0016J \u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020\tH\u0002J\b\u0010!\u001a\u00020\u0014H\u0002J\b\u0010\"\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lkotlin/io/encoding/DecodeInputStream;", "Ljava/io/InputStream;", "input", TTVideoEngineInterface.PLAY_API_KEY_BASE64, "Lkotlin/io/encoding/Base64;", "(Ljava/io/InputStream;Lkotlin/io/encoding/Base64;)V", "byteBuffer", "", "byteBufferEndIndex", "", "byteBufferLength", "getByteBufferLength", "()I", "byteBufferStartIndex", "isClosed", "", "isEOF", "singleByteBuffer", "symbolBuffer", "close", "", "copyByteBufferInto", "dst", "dstOffset", "length", "decodeSymbolBufferInto", "dstEndIndex", "symbolBufferLength", "handlePaddingSymbol", "read", a.KEY_DESTINATION, "offset", "readNextSymbol", "resetByteBufferIfEmpty", "shiftByteBufferToStartIfNeeded", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class DecodeInputStream extends InputStream {
    private final Base64 base64;
    private final byte[] byteBuffer;
    private int byteBufferEndIndex;
    private int byteBufferStartIndex;
    private final InputStream input;
    private boolean isClosed;
    private boolean isEOF;
    private final byte[] singleByteBuffer;
    private final byte[] symbolBuffer;

    private final int getByteBufferLength() {
        return this.byteBufferEndIndex - this.byteBufferStartIndex;
    }

    private final int readNextSymbol() {
        if (this.base64.isMimeScheme$kotlin_stdlib() == false) goto L5;
    L6:
        int r100 = this.input.read();
        if (r100 == (-1)) goto L10;
        if (Base64Kt.isInMimeAlphabet(r100) == false) goto L6;
    L10:
        return r100;
    L5:
        return this.input.read();
    }

    private final void resetByteBufferIfEmpty() {
        if (this.byteBufferStartIndex != this.byteBufferEndIndex) goto L6;
        this.byteBufferStartIndex = 0;
        this.byteBufferEndIndex = 0;
        return;
    }

    private final void shiftByteBufferToStartIfNeeded() {
        byte[] r100 = this.byteBuffer;
        int r101 = r100.length;
        int r102 = this.byteBufferEndIndex;
        if (((this.symbolBuffer.length / 4) * 3) <= (r101 - r102)) goto L6;
        ArraysKt.copyInto(r100, r100, 0, this.byteBufferStartIndex, r102);
        this.byteBufferEndIndex -= this.byteBufferStartIndex;
        this.byteBufferStartIndex = 0;
        return;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.isClosed == true) goto L6;
        this.isClosed = true;
        this.input.close();
        return;
    }

    @Override // java.io.InputStream
    public int read() {
        int r100 = this.byteBufferStartIndex;
        if (r100 >= this.byteBufferEndIndex) goto L6;
        int r101 = this.byteBuffer[r100] & UByte.MAX_VALUE;
        this.byteBufferStartIndex = r100 + 1;
        resetByteBufferIfEmpty();
        return r101;
    L6:
        int r102 = read(this.singleByteBuffer, 0, 1);
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L11;
        return this.singleByteBuffer[0] & UByte.MAX_VALUE;
    L11:
        throw new IllegalStateException("Unreachable".toString());
    L12:
        return -1;
    }

    private final int handlePaddingSymbol(int r100) {
        this.symbolBuffer[r100] = Base64.padSymbol;
        if ((r100 & 3) != 2) goto L9;
        int r101 = readNextSymbol();
        if (r101 < 0) goto L10;
        this.symbolBuffer[r100 + 1] = (byte) r101;
    L10:
        return r100 + 2;
    L9:
        return r100 + 1;
    }

    public DecodeInputStream(InputStream r100, Base64 r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, TTVideoEngineInterface.PLAY_API_KEY_BASE64);
        this.input = r100;
        this.base64 = r101;
        this.singleByteBuffer = new byte[1];
        this.symbolBuffer = new byte[1024];
        this.byteBuffer = new byte[1024];
    }

    private final void copyByteBufferInto(byte[] r100, int r101, int r102) {
        byte[] r103 = this.byteBuffer;
        int r104 = this.byteBufferStartIndex;
        ArraysKt.copyInto(r103, r100, r101, r104, r104 + r102);
        this.byteBufferStartIndex += r102;
        resetByteBufferIfEmpty();
    }

    @Override // java.io.InputStream
    public int read(byte[] r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, a.KEY_DESTINATION);
        if (r111 < 0) goto L51;
        if (r112 < 0) goto L51;
        int r100 = r111 + r112;
        if (r100 > r110.length) goto L51;
        if (this.isClosed == true) goto L49;
        if (this.isEOF == false) goto L13;
        return -1;
    L13:
        if (r112 != 0) goto L16;
        return 0;
    L16:
        if (getByteBufferLength() < r112) goto L19;
        copyByteBufferInto(r110, r111, r112);
        return r112;
    L19:
        int r113 = ((((r112 - getByteBufferLength()) + 3) - 1) / 3) * 4;
        int r101 = r111;
    L20:
        boolean r102 = this.isEOF;
        if (r102 == true) goto L43;
        if (r113 <= 0) goto L43;
        int r103 = Math.min(this.symbolBuffer.length, r113);
        int r104 = 0;
    L24:
        boolean r105 = this.isEOF;
        if (r105 == true) goto L34;
        if (r104 >= r103) goto L34;
        int r106 = readNextSymbol();
        if (r106 != (-1)) goto L30;
        this.isEOF = true;
        goto L24
    L30:
        if (r106 != 61) goto L31;
        r104 = handlePaddingSymbol(r104);
        this.isEOF = true;
        goto L24
    L31:
        this.symbolBuffer[r104] = (byte) r106;
        r104 = r104 + 1;
    L34:
        if (r105 == true) goto L38;
        if (r104 == r103) goto L38;
        boolean r107 = false;
    L39:
        if (r107 == false) goto L42;
        r113 = r113 - r104;
        r101 = r101 + decodeSymbolBufferInto(r110, r101, r100, r104);
        goto L20
    L42:
        throw new IllegalStateException("Check failed.".toString());
    L38:
        r107 = true;
    L43:
        if (r101 != r111) goto L47;
        if (r102 == false) goto L47;
        return -1;
    L47:
        return r101 - r111;
    L49:
        throw new IOException("The input stream is closed.");
    L51:
        throw new IndexOutOfBoundsException("offset: " + r111 + ", length: " + r112 + ", buffer size: " + r110.length);
    }

    private final int decodeSymbolBufferInto(byte[] r100, int r101, int r110, int r111) {
        int r102 = this.byteBufferEndIndex;
        this.byteBufferEndIndex = r102 + this.base64.decodeIntoByteArray(this.symbolBuffer, this.byteBuffer, r102, 0, r111);
        int r112 = Math.min(getByteBufferLength(), r110 - r101);
        copyByteBufferInto(r100, r101, r112);
        shiftByteBufferToStartIfNeeded();
        return r112;
    }
}
