package kotlin.io.encoding;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J \u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J \u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0016J \u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkotlin/io/encoding/EncodeOutputStream;", "Ljava/io/OutputStream;", BdpAppEventConstant.PARAMS_OUTPUT, TTVideoEngineInterface.PLAY_API_KEY_BASE64, "Lkotlin/io/encoding/Base64;", "(Ljava/io/OutputStream;Lkotlin/io/encoding/Base64;)V", "byteBuffer", "", "byteBufferLength", "", "isClosed", "", "lineLength", "symbolBuffer", "checkOpen", "", "close", "copyIntoByteBuffer", "source", "startIndex", "endIndex", "encodeByteBufferIntoOutput", "encodeIntoOutput", "flush", "write", "offset", "length", "b", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class EncodeOutputStream extends OutputStream {
    private final Base64 base64;
    private final byte[] byteBuffer;
    private int byteBufferLength;
    private boolean isClosed;
    private int lineLength;
    private final OutputStream output;
    private final byte[] symbolBuffer;

    private final void checkOpen() {
        if (this.isClosed == true) goto L6;
        return;
    L6:
        throw new IOException("The output stream is closed.");
    }

    private final void encodeByteBufferIntoOutput() {
        if (encodeIntoOutput(this.byteBuffer, 0, this.byteBufferLength) != 4) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L10;
        this.byteBufferLength = 0;
        return;
    L10:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r100 = false;
        goto L6
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.isClosed == true) goto L9;
        this.isClosed = true;
        if (this.byteBufferLength == 0) goto L7;
        encodeByteBufferIntoOutput();
    L7:
        this.output.close();
        return;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        checkOpen();
        this.output.flush();
    }

    @Override // java.io.OutputStream
    public void write(int r100) {
        checkOpen();
        byte[] r101 = this.byteBuffer;
        int r102 = this.byteBufferLength;
        int r103 = r102 + 1;
        this.byteBufferLength = r103;
        r101[r102] = (byte) r100;
        if (r103 != 3) goto L6;
        encodeByteBufferIntoOutput();
        return;
    }

    public EncodeOutputStream(OutputStream r100, Base64 r101) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_OUTPUT);
        Intrinsics.checkNotNullParameter(r101, TTVideoEngineInterface.PLAY_API_KEY_BASE64);
        this.output = r100;
        this.base64 = r101;
        if (r101.isMimeScheme$kotlin_stdlib() == false) goto L5;
        int r102 = 76;
    L6:
        this.lineLength = r102;
        this.symbolBuffer = new byte[1024];
        this.byteBuffer = new byte[3];
        return;
    L5:
        r102 = -1;
        goto L6
    }

    private final int copyIntoByteBuffer(byte[] r100, int r101, int r102) {
        int r103 = Math.min(3 - this.byteBufferLength, r102 - r101);
        ArraysKt.copyInto(r100, this.byteBuffer, this.byteBufferLength, r101, r101 + r103);
        int r104 = this.byteBufferLength + r103;
        this.byteBufferLength = r104;
        if (r104 != 3) goto L5;
        encodeByteBufferIntoOutput();
    L5:
        return r103;
    }

    private final int encodeIntoOutput(byte[] r100, int r101, int r102) {
        int r103 = this.base64.encodeIntoByteArray(r100, this.symbolBuffer, 0, r101, r102);
        if (this.lineLength != 0) goto L12;
        this.output.write(Base64.Default.getMimeLineSeparatorSymbols$kotlin_stdlib());
        this.lineLength = 76;
        if (r103 > 76) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L12;
        throw new IllegalStateException("Check failed.".toString());
    L7:
        r104 = false;
    L12:
        this.output.write(this.symbolBuffer, 0, r103);
        this.lineLength -= r103;
        return r103;
    }

    @Override // java.io.OutputStream
    public void write(byte[] r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "source");
        checkOpen();
        if (r101 < 0) goto L38;
        if (r102 < 0) goto L38;
        int r103 = r101 + r102;
        if (r103 > r100.length) goto L38;
        if (r102 != 0) goto L9;
        return;
    L9:
        int r104 = this.byteBufferLength;
        if (r104 >= 3) goto L12;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L36;
        if (r104 == 0) goto L20;
        r101 = r101 + copyIntoByteBuffer(r100, r101, r103);
        if (this.byteBufferLength == 0) goto L20;
        return;
    L20:
        if ((r101 + 3) > r103) goto L33;
        if (this.base64.isMimeScheme$kotlin_stdlib() == false) goto L24;
        int r106 = this.lineLength;
    L25:
        int r107 = Math.min(r106 / 4, (r103 - r101) / 3);
        int r108 = (r107 * 3) + r101;
        if (encodeIntoOutput(r100, r101, r108) != (r107 * 4)) goto L28;
        boolean r109 = true;
    L29:
        if (r109 == false) goto L32;
        r101 = r108;
        goto L20
    L32:
        throw new IllegalStateException("Check failed.".toString());
    L28:
        r109 = false;
        goto L29
    L24:
        r106 = this.symbolBuffer.length;
        goto L25
    L33:
        ArraysKt.copyInto(r100, this.byteBuffer, 0, r101, r103);
        this.byteBufferLength = r103 - r101;
        return;
    L36:
        throw new IllegalStateException("Check failed.".toString());
    L12:
        r105 = false;
    L38:
        throw new IndexOutOfBoundsException("offset: " + r101 + ", length: " + r102 + ", source size: " + r100.length);
    }
}
