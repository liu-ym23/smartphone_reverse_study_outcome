package kotlin.reflect.jvm.internal.impl.protobuf;

import com.alipay.sdk.m.n.a;
import com.bytedance.mira.oat.ShareElfFile;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes5.dex */
public final class CodedOutputStream {
    private final byte[] buffer;
    private final int limit;
    private final OutputStream output;
    private int position;
    private int totalBytesWritten;

    /* JADX INFO: loaded from: classes42.dex */
    public static class OutOfSpaceException extends IOException {
        public OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public static int computeBoolSizeNoTag(boolean r100) {
        return 1;
    }

    public static int computeDoubleSizeNoTag(double r100) {
        return 8;
    }

    public static int computeFixed32SizeNoTag(int r100) {
        return 4;
    }

    public static int computeFixed64SizeNoTag(long r100) {
        return 8;
    }

    public static int computeFloatSizeNoTag(float r100) {
        return 4;
    }

    public static int computePreferredBufferSize(int r100) {
        if (r100 <= 4096) goto L5;
        return 4096;
    L5:
        return r100;
    }

    public static int computeRawVarint32Size(int r100) {
        if ((r100 & a.f25611g) != 0) goto L7;
        return 1;
    L7:
        if ((r100 & (-16384)) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r100) != 0) goto L15;
        return 3;
    L15:
        if ((r100 & ShareElfFile.SectionHeader.SHF_MASKPROC) != 0) goto L18;
        return 4;
    L18:
        return 5;
    }

    public static int computeRawVarint64Size(long r100) {
        if (((-128) & r100) != 0) goto L7;
        return 1;
    L7:
        if (((-16384) & r100) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r100) != 0) goto L15;
        return 3;
    L15:
        if (((-268435456) & r100) != 0) goto L19;
        return 4;
    L19:
        if (((-34359738368L) & r100) != 0) goto L23;
        return 5;
    L23:
        if (((-4398046511104L) & r100) != 0) goto L27;
        return 6;
    L27:
        if (((-562949953421312L) & r100) != 0) goto L31;
        return 7;
    L31:
        if (((-72057594037927936L) & r100) != 0) goto L35;
        return 8;
    L35:
        if ((r100 & Long.MIN_VALUE) != 0) goto L38;
        return 9;
    L38:
        return 10;
    }

    public static int computeSFixed32SizeNoTag(int r100) {
        return 4;
    }

    public static int computeSFixed64SizeNoTag(long r100) {
        return 8;
    }

    public static int encodeZigZag32(int r100) {
        int r101 = r100 << 1;
        return (r100 >> 31) ^ r101;
    }

    public static long encodeZigZag64(long r100) {
        long r101 = r100 << 1;
        return (r100 >> 63) ^ r101;
    }

    private void refreshBuffer() throws IOException {
        OutputStream r100 = this.output;
        if (r100 == null) goto L7;
        r100.write(this.buffer, 0, this.position);
        this.position = 0;
        return;
    L7:
        throw new OutOfSpaceException();
    }

    public void flush() throws IOException {
        if (this.output == null) goto L6;
        refreshBuffer();
        return;
    }

    public static int computeByteArraySizeNoTag(byte[] r100) {
        return computeRawVarint32Size(r100.length) + r100.length;
    }

    public static int computeBytesSizeNoTag(ByteString r100) {
        return computeRawVarint32Size(r100.size()) + r100.size();
    }

    public static int computeEnumSizeNoTag(int r100) {
        return computeInt32SizeNoTag(r100);
    }

    public static int computeGroupSizeNoTag(MessageLite r100) {
        return r100.getSerializedSize();
    }

    public static int computeInt32SizeNoTag(int r100) {
        if (r100 >= 0) goto L4;
        return 10;
    L4:
        return computeRawVarint32Size(r100);
    }

    public static int computeInt64SizeNoTag(long r100) {
        return computeRawVarint64Size(r100);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite r100) {
        int r101 = r100.getSerializedSize();
        return computeRawVarint32Size(r101) + r101;
    }

    public static int computeMessageSizeNoTag(MessageLite r100) {
        int r101 = r100.getSerializedSize();
        return computeRawVarint32Size(r101) + r101;
    }

    public static int computeSInt32SizeNoTag(int r100) {
        return computeRawVarint32Size(encodeZigZag32(r100));
    }

    public static int computeSInt64SizeNoTag(long r100) {
        return computeRawVarint64Size(encodeZigZag64(r100));
    }

    public static int computeStringSizeNoTag(String r100) {
        byte[] r101 = r100.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L5
        return computeRawVarint32Size(r101.length) + r101.length;
    L5:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported.", e);
    }

    public static int computeTagSize(int r100) {
        return computeRawVarint32Size(WireFormat.makeTag(r100, 0));
    }

    public static int computeUInt32SizeNoTag(int r100) {
        return computeRawVarint32Size(r100);
    }

    public static int computeUInt64SizeNoTag(long r100) {
        return computeRawVarint64Size(r100);
    }

    public void writeBoolNoTag(boolean r100) throws IOException {
        writeRawByte(r100 ? 1 : 0);
    }

    public void writeByteArrayNoTag(byte[] r100) throws IOException {
        writeRawVarint32(r100.length);
        writeRawBytes(r100);
    }

    public void writeBytesNoTag(ByteString r100) throws IOException {
        writeRawVarint32(r100.size());
        writeRawBytes(r100);
    }

    public void writeDoubleNoTag(double r100) throws IOException {
        writeRawLittleEndian64(Double.doubleToRawLongBits(r100));
    }

    public void writeEnumNoTag(int r100) throws IOException {
        writeInt32NoTag(r100);
    }

    public void writeFixed32NoTag(int r100) throws IOException {
        writeRawLittleEndian32(r100);
    }

    public void writeFixed64NoTag(long r100) throws IOException {
        writeRawLittleEndian64(r100);
    }

    public void writeFloatNoTag(float r100) throws IOException {
        writeRawLittleEndian32(Float.floatToRawIntBits(r100));
    }

    public void writeGroupNoTag(MessageLite r100) throws IOException {
        r100.writeTo(this);
    }

    public void writeInt32NoTag(int r100) throws IOException {
        if (r100 < 0) goto L4;
        writeRawVarint32(r100);
        return;
    L4:
        writeRawVarint64(r100);
    }

    public void writeInt64NoTag(long r100) throws IOException {
        writeRawVarint64(r100);
    }

    public void writeMessageNoTag(MessageLite r100) throws IOException {
        writeRawVarint32(r100.getSerializedSize());
        r100.writeTo(this);
    }

    public void writeRawByte(byte r100) throws IOException {
        if (this.position != this.limit) goto L5;
        refreshBuffer();
    L5:
        byte[] r101 = this.buffer;
        int r102 = this.position;
        this.position = r102 + 1;
        r101[r102] = r100;
        this.totalBytesWritten++;
    }

    public void writeRawBytes(ByteString r100) throws IOException {
        writeRawBytes(r100, 0, r100.size());
    }

    public void writeRawLittleEndian32(int r100) throws IOException {
        writeRawByte(r100 & 255);
        writeRawByte((r100 >> 8) & 255);
        writeRawByte((r100 >> 16) & 255);
        writeRawByte((r100 >> 24) & 255);
    }

    public void writeRawLittleEndian64(long r100) throws IOException {
        writeRawByte(((int) r100) & 255);
        writeRawByte(((int) (r100 >> 8)) & 255);
        writeRawByte(((int) (r100 >> 16)) & 255);
        writeRawByte(((int) (r100 >> 24)) & 255);
        writeRawByte(((int) (r100 >> 32)) & 255);
        writeRawByte(((int) (r100 >> 40)) & 255);
        writeRawByte(((int) (r100 >> 48)) & 255);
        writeRawByte(((int) (r100 >> 56)) & 255);
    }

    public void writeRawVarint32(int r100) throws IOException {
    L3:
        if ((r100 & a.f25611g) == 0) goto L4;
        writeRawByte((r100 & 127) | 128);
        r100 = r100 >>> 7;
        goto L3
    L4:
        writeRawByte(r100);
    }

    public void writeRawVarint64(long r100) throws IOException {
    L3:
        if (((-128) & r100) == 0) goto L4;
        writeRawByte((((int) r100) & 127) | 128);
        r100 = r100 >>> 7;
        goto L3
    L4:
        writeRawByte((int) r100);
    }

    public void writeSFixed32NoTag(int r100) throws IOException {
        writeRawLittleEndian32(r100);
    }

    public void writeSFixed64NoTag(long r100) throws IOException {
        writeRawLittleEndian64(r100);
    }

    public void writeSInt32NoTag(int r100) throws IOException {
        writeRawVarint32(encodeZigZag32(r100));
    }

    public void writeSInt64NoTag(long r100) throws IOException {
        writeRawVarint64(encodeZigZag64(r100));
    }

    public void writeStringNoTag(String r100) throws IOException {
        byte[] r101 = r100.getBytes("UTF-8");
        writeRawVarint32(r101.length);
        writeRawBytes(r101);
    }

    public void writeUInt32NoTag(int r100) throws IOException {
        writeRawVarint32(r100);
    }

    public void writeUInt64NoTag(long r100) throws IOException {
        writeRawVarint64(r100);
    }

    public void writeRawByte(int r100) throws IOException {
        writeRawByte((byte) r100);
    }

    public void writeRawBytes(byte[] r100) throws IOException {
        writeRawBytes(r100, 0, r100.length);
    }

    private CodedOutputStream(OutputStream r100, byte[] r101) {
        this.totalBytesWritten = 0;
        this.output = r100;
        this.buffer = r101;
        this.position = 0;
        this.limit = r101.length;
    }

    public static int computeBoolSize(int r100, boolean r101) {
        return computeTagSize(r100) + computeBoolSizeNoTag(r101);
    }

    public static int computeBytesSize(int r100, ByteString r101) {
        return computeTagSize(r100) + computeBytesSizeNoTag(r101);
    }

    public static int computeDoubleSize(int r100, double r101) {
        return computeTagSize(r100) + computeDoubleSizeNoTag(r101);
    }

    public static int computeEnumSize(int r100, int r101) {
        return computeTagSize(r100) + computeEnumSizeNoTag(r101);
    }

    public static int computeFloatSize(int r100, float r101) {
        return computeTagSize(r100) + computeFloatSizeNoTag(r101);
    }

    public static int computeInt32Size(int r100, int r101) {
        return computeTagSize(r100) + computeInt32SizeNoTag(r101);
    }

    public static int computeMessageSize(int r100, MessageLite r101) {
        return computeTagSize(r100) + computeMessageSizeNoTag(r101);
    }

    public static int computeSInt64Size(int r100, long r101) {
        return computeTagSize(r100) + computeSInt64SizeNoTag(r101);
    }

    public static CodedOutputStream newInstance(OutputStream r100, int r101) {
        return new CodedOutputStream(r100, new byte[r101]);
    }

    public void writeBool(int r100, boolean r101) throws IOException {
        writeTag(r100, 0);
        writeBoolNoTag(r101);
    }

    public void writeBytes(int r100, ByteString r101) throws IOException {
        writeTag(r100, 2);
        writeBytesNoTag(r101);
    }

    public void writeDouble(int r100, double r101) throws IOException {
        writeTag(r100, 1);
        writeDoubleNoTag(r101);
    }

    public void writeEnum(int r100, int r101) throws IOException {
        writeTag(r100, 0);
        writeEnumNoTag(r101);
    }

    public void writeFloat(int r100, float r101) throws IOException {
        writeTag(r100, 5);
        writeFloatNoTag(r101);
    }

    public void writeGroup(int r100, MessageLite r101) throws IOException {
        writeTag(r100, 3);
        writeGroupNoTag(r101);
        writeTag(r100, 4);
    }

    public void writeInt32(int r100, int r101) throws IOException {
        writeTag(r100, 0);
        writeInt32NoTag(r101);
    }

    public void writeMessage(int r100, MessageLite r101) throws IOException {
        writeTag(r100, 2);
        writeMessageNoTag(r101);
    }

    public void writeMessageSetExtension(int r100, MessageLite r101) throws IOException {
        writeTag(1, 3);
        writeUInt32(2, r100);
        writeMessage(3, r101);
        writeTag(1, 4);
    }

    public void writeSInt64(int r100, long r101) throws IOException {
        writeTag(r100, 0);
        writeSInt64NoTag(r101);
    }

    public void writeTag(int r100, int r101) throws IOException {
        writeRawVarint32(WireFormat.makeTag(r100, r101));
    }

    public void writeUInt32(int r100, int r101) throws IOException {
        writeTag(r100, 0);
        writeUInt32NoTag(r101);
    }

    public void writeRawBytes(ByteString r100, int r101, int r102) throws IOException {
        int r103 = this.limit;
        int r104 = this.position;
        if ((r103 - r104) < r102) goto L5;
        r100.copyTo(this.buffer, r101, r104, r102);
        this.position += r102;
        this.totalBytesWritten += r102;
        return;
    L5:
        int r105 = r103 - r104;
        r100.copyTo(this.buffer, r101, r104, r105);
        int r106 = r101 + r105;
        int r107 = r102 - r105;
        this.position = this.limit;
        this.totalBytesWritten += r105;
        refreshBuffer();
        if (r107 > this.limit) goto L8;
        r100.copyTo(this.buffer, r106, 0, r107);
        this.position = r107;
    L9:
        this.totalBytesWritten += r107;
        return;
    L8:
        r100.writeTo(this.output, r106, r107);
        goto L9
    }

    public void writeRawBytes(byte[] r100, int r101, int r102) throws IOException {
        int r103 = this.limit;
        int r104 = this.position;
        if ((r103 - r104) < r102) goto L5;
        System.arraycopy(r100, r101, this.buffer, r104, r102);
        this.position += r102;
        this.totalBytesWritten += r102;
        return;
    L5:
        int r105 = r103 - r104;
        System.arraycopy(r100, r101, this.buffer, r104, r105);
        int r106 = r101 + r105;
        int r107 = r102 - r105;
        this.position = this.limit;
        this.totalBytesWritten += r105;
        refreshBuffer();
        if (r107 > this.limit) goto L8;
        System.arraycopy(r100, r106, this.buffer, 0, r107);
        this.position = r107;
    L9:
        this.totalBytesWritten += r107;
        return;
    L8:
        this.output.write(r100, r106, r107);
        goto L9
    }
}
