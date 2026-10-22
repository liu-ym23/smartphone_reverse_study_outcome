package com.google.protobuf;

import com.alipay.sdk.m.n.a;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.mira.oat.ShareElfFile;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes23.dex */
public abstract class CodedOutputStream extends ByteOutput {
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = false;
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    private static final Logger logger = null;
    private boolean serializationDeterministic;

    /* JADX INFO: renamed from: com.google.protobuf.CodedOutputStream$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class AbstractBufferedEncoder extends CodedOutputStream {
        final byte[] buffer;
        final int limit;
        int position;
        int totalBytesWritten;

        @Override // com.google.protobuf.CodedOutputStream
        public final int spaceLeft() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.totalBytesWritten;
        }

        public AbstractBufferedEncoder(int r100) {
            super(null);
            if (r100 < 0) goto L7;
            byte[] r101 = new byte[Math.max(r100, 20)];
            this.buffer = r101;
            this.limit = r101.length;
            return;
        L7:
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        public final void buffer(byte r100) {
            byte[] r101 = this.buffer;
            int r102 = this.position;
            this.position = r102 + 1;
            r101[r102] = r100;
            this.totalBytesWritten++;
        }

        public final void bufferFixed32NoTag(int r100) {
            byte[] r101 = this.buffer;
            int r102 = this.position;
            int r103 = r102 + 1;
            r101[r102] = (byte) (r100 & 255);
            int r104 = r103 + 1;
            r101[r103] = (byte) ((r100 >> 8) & 255);
            int r105 = r104 + 1;
            r101[r104] = (byte) ((r100 >> 16) & 255);
            this.position = r105 + 1;
            r101[r105] = (byte) ((r100 >> 24) & 255);
            this.totalBytesWritten += 4;
        }

        public final void bufferFixed64NoTag(long r100) {
            byte[] r101 = this.buffer;
            int r102 = this.position;
            int r103 = r102 + 1;
            r101[r102] = (byte) (r100 & 255);
            int r104 = r103 + 1;
            r101[r103] = (byte) ((r100 >> 8) & 255);
            int r105 = r104 + 1;
            r101[r104] = (byte) ((r100 >> 16) & 255);
            int r106 = r105 + 1;
            r101[r105] = (byte) (255 & (r100 >> 24));
            int r107 = r106 + 1;
            r101[r106] = (byte) (((int) (r100 >> 32)) & 255);
            int r108 = r107 + 1;
            r101[r107] = (byte) (((int) (r100 >> 40)) & 255);
            int r109 = r108 + 1;
            r101[r108] = (byte) (((int) (r100 >> 48)) & 255);
            this.position = r109 + 1;
            r101[r109] = (byte) (((int) (r100 >> 56)) & 255);
            this.totalBytesWritten += 8;
        }

        public final void bufferInt32NoTag(int r100) {
            if (r100 < 0) goto L4;
            bufferUInt32NoTag(r100);
            return;
        L4:
            bufferUInt64NoTag(r100);
        }

        public final void bufferUInt32NoTag(int r100) {
            if (CodedOutputStream.access$100() == false) goto L11;
            long r101 = this.position;
        L6:
            if ((r100 & a.f25611g) == 0) goto L7;
            byte[] r102 = this.buffer;
            int r103 = this.position;
            this.position = r103 + 1;
            UnsafeUtil.putByte(r102, r103, (byte) ((r100 & 127) | 128));
            r100 = r100 >>> 7;
            goto L6
        L7:
            byte[] r104 = this.buffer;
            int r105 = this.position;
            this.position = r105 + 1;
            UnsafeUtil.putByte(r104, r105, (byte) r100);
            this.totalBytesWritten += (int) (((long) this.position) - r101);
            return;
        L11:
            if ((r100 & a.f25611g) == 0) goto L12;
            byte[] r106 = this.buffer;
            int r107 = this.position;
            this.position = r107 + 1;
            r106[r107] = (byte) ((r100 & 127) | 128);
            this.totalBytesWritten++;
            r100 = r100 >>> 7;
            goto L11
        L12:
            byte[] r108 = this.buffer;
            int r109 = this.position;
            this.position = r109 + 1;
            r108[r109] = (byte) r100;
            this.totalBytesWritten++;
        }

        public final void bufferUInt64NoTag(long r110) {
            if (CodedOutputStream.access$100() == false) goto L11;
            long r100 = this.position;
        L6:
            if ((r110 & (-128)) == 0) goto L7;
            byte[] r101 = this.buffer;
            int r102 = this.position;
            this.position = r102 + 1;
            UnsafeUtil.putByte(r101, r102, (byte) ((((int) r110) & 127) | 128));
            r110 = r110 >>> 7;
            goto L6
        L7:
            byte[] r103 = this.buffer;
            int r104 = this.position;
            this.position = r104 + 1;
            UnsafeUtil.putByte(r103, r104, (byte) r110);
            this.totalBytesWritten += (int) (((long) this.position) - r100);
            return;
        L11:
            if ((r110 & (-128)) == 0) goto L12;
            byte[] r105 = this.buffer;
            int r106 = this.position;
            this.position = r106 + 1;
            r105[r106] = (byte) ((((int) r110) & 127) | 128);
            this.totalBytesWritten++;
            r110 = r110 >>> 7;
            goto L11
        L12:
            byte[] r107 = this.buffer;
            int r108 = this.position;
            this.position = r108 + 1;
            r107[r108] = (byte) r110;
            this.totalBytesWritten++;
        }

        public final void bufferTag(int r100, int r101) {
            bufferUInt32NoTag(WireFormat.makeTag(r100, r101));
        }
    }

    public static class ArrayEncoder extends CodedOutputStream {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.position - this.offset;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int spaceLeft() {
            return this.limit - this.position;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(ByteBuffer r100) throws IOException {
            int r101 = r100.remaining();
            r100.get(this.buffer, this.position, r101);     // Catch: IndexOutOfBoundsException -> L5
            this.position += r101;     // Catch: IndexOutOfBoundsException -> L5
            return;
        L5:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(r101)}), e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytesNoTag(ByteString r100) throws IOException {
            writeUInt32NoTag(r100.size());
            r100.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32NoTag(int r100) throws IOException {
            byte[] r101 = this.buffer;     // Catch: IndexOutOfBoundsException -> L4
            int r102 = this.position;     // Catch: IndexOutOfBoundsException -> L4
            int r103 = r102 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r101[r102] = (byte) (r100 & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r104 = r103 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r101[r103] = (byte) ((r100 >> 8) & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r105 = r104 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r101[r104] = (byte) ((r100 >> 16) & 255);     // Catch: IndexOutOfBoundsException -> L4
            this.position = r105 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r101[r105] = (byte) ((r100 >> 24) & 255);     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64NoTag(long r100) throws IOException {
            byte[] r101 = this.buffer;     // Catch: IndexOutOfBoundsException -> L4
            int r102 = this.position;     // Catch: IndexOutOfBoundsException -> L4
            int r103 = r102 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r101[r102] = (byte) (((int) r100) & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r104 = r103 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r101[r103] = (byte) (((int) (r100 >> 8)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r105 = r104 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r101[r104] = (byte) (((int) (r100 >> 16)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r106 = r105 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r101[r105] = (byte) (((int) (r100 >> 24)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r107 = r106 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r101[r106] = (byte) (((int) (r100 >> 32)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r108 = r107 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r101[r107] = (byte) (((int) (r100 >> 40)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r109 = r108 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r101[r108] = (byte) (((int) (r100 >> 48)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            this.position = r109 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r101[r109] = (byte) (((int) (r100 >> 56)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32NoTag(int r100) throws IOException {
            if (r100 < 0) goto L4;
            writeUInt32NoTag(r100);
            return;
        L4:
            writeUInt64NoTag(r100);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(ByteBuffer r100) throws IOException {
            write(r100);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageNoTag(MessageLite r100) throws IOException {
            writeUInt32NoTag(r100.getSerializedSize());
            r100.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawBytes(ByteBuffer r100) throws IOException {
            if (r100.hasArray() == false) goto L5;
            write(r100.array(), r100.arrayOffset(), r100.capacity());
            return;
        L5:
            ByteBuffer r101 = r100.duplicate();
            r101.clear();
            write(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeStringNoTag(String r100) throws IOException {
            int r101 = this.position;
            int r102 = CodedOutputStream.computeUInt32SizeNoTag(r100.length() * 3);     // Catch: IndexOutOfBoundsException -> L8 Utf8.UnpairedSurrogateException -> L11
            int r103 = CodedOutputStream.computeUInt32SizeNoTag(r100.length());     // Catch: IndexOutOfBoundsException -> L8 Utf8.UnpairedSurrogateException -> L11
            if (r103 != r102) goto L6;
            int r104 = r101 + r103;     // Catch: IndexOutOfBoundsException -> L8 Utf8.UnpairedSurrogateException -> L11
            this.position = r104;     // Catch: IndexOutOfBoundsException -> L8 Utf8.UnpairedSurrogateException -> L11
            int r105 = Utf8.encode(r100, this.buffer, r104, spaceLeft());     // Catch: IndexOutOfBoundsException -> L8 Utf8.UnpairedSurrogateException -> L11
            this.position = r101;     // Catch: IndexOutOfBoundsException -> L8 Utf8.UnpairedSurrogateException -> L11
            writeUInt32NoTag((r105 - r101) - r103);     // Catch: IndexOutOfBoundsException -> L8 Utf8.UnpairedSurrogateException -> L11
            this.position = r105;     // Catch: IndexOutOfBoundsException -> L8 Utf8.UnpairedSurrogateException -> L11
        L14:
            return;
        L6:
            writeUInt32NoTag(Utf8.encodedLength(r100));     // Catch: IndexOutOfBoundsException -> L8 Utf8.UnpairedSurrogateException -> L11
            this.position = Utf8.encode(r100, this.buffer, this.position, spaceLeft());     // Catch: IndexOutOfBoundsException -> L8 Utf8.UnpairedSurrogateException -> L11
        L11:
            e = move-exception;
            this.position = r101;
            inefficientWriteStringNoTag(r100, e);
            return;
        L8:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32NoTag(int r100) throws IOException {
            if (CodedOutputStream.access$100() == false) goto L12;
            if (spaceLeft() < 10) goto L12;
        L7:
            if ((r100 & a.f25611g) == 0) goto L8;
            byte[] r101 = this.buffer;
            int r102 = this.position;
            this.position = r102 + 1;
            UnsafeUtil.putByte(r101, r102, (byte) ((r100 & 127) | 128));
            r100 = r100 >>> 7;
            goto L7
        L8:
            byte[] r103 = this.buffer;
            int r104 = this.position;
            this.position = r104 + 1;
            UnsafeUtil.putByte(r103, r104, (byte) r100);
            return;
        L12:
            if ((r100 & a.f25611g) == 0) goto L13;
            byte[] r105 = this.buffer;     // Catch: IndexOutOfBoundsException -> L17
            int r106 = this.position;     // Catch: IndexOutOfBoundsException -> L17
            this.position = r106 + 1;     // Catch: IndexOutOfBoundsException -> L17
            r105[r106] = (byte) ((r100 & 127) | 128);     // Catch: IndexOutOfBoundsException -> L17
            r100 = r100 >>> 7;
        L17:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
        L13:
            byte[] r107 = this.buffer;     // Catch: IndexOutOfBoundsException -> L17
            int r108 = this.position;     // Catch: IndexOutOfBoundsException -> L17
            this.position = r108 + 1;     // Catch: IndexOutOfBoundsException -> L17
            r107[r108] = (byte) r100;     // Catch: IndexOutOfBoundsException -> L17
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64NoTag(long r110) throws IOException {
            if (CodedOutputStream.access$100() == false) goto L12;
            if (spaceLeft() < 10) goto L12;
        L7:
            if ((r110 & (-128)) == 0) goto L8;
            byte[] r100 = this.buffer;
            int r101 = this.position;
            this.position = r101 + 1;
            UnsafeUtil.putByte(r100, r101, (byte) ((((int) r110) & 127) | 128));
            r110 = r110 >>> 7;
            goto L7
        L8:
            byte[] r102 = this.buffer;
            int r103 = this.position;
            this.position = r103 + 1;
            UnsafeUtil.putByte(r102, r103, (byte) r110);
            return;
        L12:
            if ((r110 & (-128)) == 0) goto L13;
            byte[] r104 = this.buffer;     // Catch: IndexOutOfBoundsException -> L17
            int r105 = this.position;     // Catch: IndexOutOfBoundsException -> L17
            this.position = r105 + 1;     // Catch: IndexOutOfBoundsException -> L17
            r104[r105] = (byte) ((((int) r110) & 127) | 128);     // Catch: IndexOutOfBoundsException -> L17
            r110 = r110 >>> 7;
        L17:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
        L13:
            byte[] r106 = this.buffer;     // Catch: IndexOutOfBoundsException -> L17
            int r107 = this.position;     // Catch: IndexOutOfBoundsException -> L17
            this.position = r107 + 1;     // Catch: IndexOutOfBoundsException -> L17
            r106[r107] = (byte) r110;     // Catch: IndexOutOfBoundsException -> L17
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(byte r100) throws IOException {
            byte[] r101 = this.buffer;     // Catch: IndexOutOfBoundsException -> L4
            int r102 = this.position;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r102 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r101[r102] = r100;     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBool(int r100, boolean r101) throws IOException {
            writeTag(r100, 0);
            write(r101 ? 1 : 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArray(int r100, byte[] r101) throws IOException {
            writeByteArray(r100, r101, 0, r101.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteBuffer(int r100, ByteBuffer r101) throws IOException {
            writeTag(r100, 2);
            writeUInt32NoTag(r101.capacity());
            writeRawBytes(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytes(int r100, ByteString r101) throws IOException {
            writeTag(r100, 2);
            writeBytesNoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32(int r100, int r101) throws IOException {
            writeTag(r100, 5);
            writeFixed32NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64(int r100, long r101) throws IOException {
            writeTag(r100, 1);
            writeFixed64NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32(int r100, int r101) throws IOException {
            writeTag(r100, 0);
            writeInt32NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessage(int r100, MessageLite r101) throws IOException {
            writeTag(r100, 2);
            writeMessageNoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageSetExtension(int r100, MessageLite r101) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, r100);
            writeMessage(3, r101);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawMessageSetExtension(int r100, ByteString r101) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, r100);
            writeBytes(3, r101);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeString(int r100, String r101) throws IOException {
            writeTag(r100, 2);
            writeStringNoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeTag(int r100, int r101) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(r100, r101));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32(int r100, int r101) throws IOException {
            writeTag(r100, 0);
            writeUInt32NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64(int r100, long r101) throws IOException {
            writeTag(r100, 0);
            writeUInt64NoTag(r101);
        }

        public ArrayEncoder(byte[] r100, int r101, int r102) {
            super(null);
            if (r100 == null) goto L11;
            int r103 = r101 + r102;
            if (((r101 | r102) | (r100.length - r103)) < 0) goto L9;
            this.buffer = r100;
            this.offset = r101;
            this.position = r101;
            this.limit = r103;
            return;
        L9:
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(r100.length), Integer.valueOf(r101), Integer.valueOf(r102)}));
        L11:
            throw new NullPointerException("buffer");
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(byte[] r100, int r101, int r102) throws IOException {
            System.arraycopy(r100, r101, this.buffer, this.position, r102);     // Catch: IndexOutOfBoundsException -> L4
            this.position += r102;     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(r102)}), e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArrayNoTag(byte[] r100, int r101, int r102) throws IOException {
            writeUInt32NoTag(r102);
            write(r100, r101, r102);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(byte[] r100, int r101, int r102) throws IOException {
            write(r100, r101, r102);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArray(int r100, byte[] r101, int r102, int r103) throws IOException {
            writeTag(r100, 2);
            writeByteArrayNoTag(r101, r102, r103);
        }
    }

    public static final class ByteOutputEncoder extends AbstractBufferedEncoder {
        private final ByteOutput out;

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() throws IOException {
            if (this.position <= 0) goto L6;
            doFlush();
            return;
        }

        private void flushIfNotAvailable(int r100) throws IOException {
            if ((this.limit - this.position) >= r100) goto L6;
            doFlush();
            return;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer r100) throws IOException {
            flush();
            int r101 = r100.remaining();
            this.out.write(r100);
            this.totalBytesWritten += r101;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString r100) throws IOException {
            writeUInt32NoTag(r100.size());
            r100.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int r100) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(r100);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long r100) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(r100);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int r100) throws IOException {
            if (r100 < 0) goto L4;
            writeUInt32NoTag(r100);
            return;
        L4:
            writeUInt64NoTag(r100);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r100) throws IOException {
            flush();
            int r101 = r100.remaining();
            this.out.writeLazy(r100);
            this.totalBytesWritten += r101;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite r100) throws IOException {
            writeUInt32NoTag(r100.getSerializedSize());
            r100.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer r100) throws IOException {
            if (r100.hasArray() == false) goto L5;
            write(r100.array(), r100.arrayOffset(), r100.capacity());
            return;
        L5:
            ByteBuffer r101 = r100.duplicate();
            r101.clear();
            write(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String r100) throws IOException {
            int r101 = r100.length() * 3;
            int r102 = CodedOutputStream.computeUInt32SizeNoTag(r101);
            int r103 = r102 + r101;
            int r104 = this.limit;
            if (r103 <= r104) goto L7;
            byte[] r105 = new byte[r101];
            int r106 = Utf8.encode(r100, r105, 0, r101);
            writeUInt32NoTag(r106);
            writeLazy(r105, 0, r106);
            return;
        L7:
            if (r103 <= (r104 - this.position)) goto L9;
            doFlush();
        L9:
            int r107 = this.position;
            int r108 = CodedOutputStream.computeUInt32SizeNoTag(r100.length());     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            if (r108 != r102) goto L13;
            int r109 = r107 + r108;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            this.position = r109;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            int r110 = Utf8.encode(r100, this.buffer, r109, this.limit - r109);     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            this.position = r107;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            int r111 = (r110 - r107) - r108;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            bufferUInt32NoTag(r111);     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            this.position = r110;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            this.totalBytesWritten += r111;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
        L21:
            return;
        L13:
            int r112 = Utf8.encodedLength(r100);     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            bufferUInt32NoTag(r112);     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            this.position = Utf8.encode(r100, this.buffer, this.position, r112);     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            this.totalBytesWritten += r112;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
        L18:
            e = move-exception;
            this.totalBytesWritten -= this.position - r107;
            this.position = r107;
            inefficientWriteStringNoTag(r100, e);
            return;
        L15:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int r100) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt32NoTag(r100);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long r100) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(r100);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte r100) throws IOException {
            if (this.position != this.limit) goto L5;
            doFlush();
        L5:
            buffer(r100);
        }

        public ByteOutputEncoder(ByteOutput r100, int r101) {
            super(r101);
            if (r100 == null) goto L7;
            this.out = r100;
            return;
        L7:
            throw new NullPointerException(Argument.OUT);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int r100, boolean r101) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(r100, 0);
            buffer(r101 ? 1 : 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r100, byte[] r101) throws IOException {
            writeByteArray(r100, r101, 0, r101.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int r100, ByteBuffer r101) throws IOException {
            writeTag(r100, 2);
            writeUInt32NoTag(r101.capacity());
            writeRawBytes(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int r100, ByteString r101) throws IOException {
            writeTag(r100, 2);
            writeBytesNoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int r100, int r101) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(r100, 5);
            bufferFixed32NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int r100, long r101) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(r100, 1);
            bufferFixed64NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int r100, int r101) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(r100, 0);
            bufferInt32NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int r100, MessageLite r101) throws IOException {
            writeTag(r100, 2);
            writeMessageNoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int r100, MessageLite r101) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, r100);
            writeMessage(3, r101);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int r100, ByteString r101) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, r100);
            writeBytes(3, r101);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int r100, String r101) throws IOException {
            writeTag(r100, 2);
            writeStringNoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int r100, int r101) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(r100, r101));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int r100, int r101) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(r100, 0);
            bufferUInt32NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int r100, long r101) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(r100, 0);
            bufferUInt64NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] r100, int r101, int r102) throws IOException {
            flush();
            this.out.write(r100, r101, r102);
            this.totalBytesWritten += r102;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] r100, int r101, int r102) throws IOException {
            writeUInt32NoTag(r102);
            write(r100, r101, r102);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r100, int r101, int r102) throws IOException {
            flush();
            this.out.writeLazy(r100, r101, r102);
            this.totalBytesWritten += r102;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r100, byte[] r101, int r102, int r103) throws IOException {
            writeTag(r100, 2);
            writeByteArrayNoTag(r101, r102, r103);
        }
    }

    public static final class HeapNioEncoder extends ArrayEncoder {
        private final ByteBuffer byteBuffer;
        private int initialPosition;

        @Override // com.google.protobuf.CodedOutputStream.ArrayEncoder, com.google.protobuf.CodedOutputStream
        public void flush() {
            this.byteBuffer.position(this.initialPosition + getTotalBytesWritten());
        }

        public HeapNioEncoder(ByteBuffer r100) {
            super(r100.array(), r100.arrayOffset() + r100.position(), r100.remaining());
            this.byteBuffer = r100;
            this.initialPosition = r100.position();
        }
    }

    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        public OutOfSpaceException() {
            super(MESSAGE);
        }

        public OutOfSpaceException(String r100) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + r100);
        }

        public OutOfSpaceException(Throwable r100) {
            super(MESSAGE, r100);
        }

        public OutOfSpaceException(String r100, Throwable r101) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + r100, r101);
        }
    }

    public static final class OutputStreamEncoder extends AbstractBufferedEncoder {
        private final OutputStream out;

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() throws IOException {
            if (this.position <= 0) goto L6;
            doFlush();
            return;
        }

        private void flushIfNotAvailable(int r100) throws IOException {
            if ((this.limit - this.position) >= r100) goto L6;
            doFlush();
            return;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer r100) throws IOException {
            int r101 = r100.remaining();
            int r102 = this.limit;
            int r103 = this.position;
            if ((r102 - r103) < r101) goto L5;
            r100.get(this.buffer, r103, r101);
            this.position += r101;
            this.totalBytesWritten += r101;
            return;
        L5:
            int r104 = r102 - r103;
            r100.get(this.buffer, r103, r104);
            int r105 = r101 - r104;
            this.position = this.limit;
            this.totalBytesWritten += r104;
            doFlush();
        L6:
            int r106 = this.limit;
            if (r105 <= r106) goto L9;
            r100.get(this.buffer, 0, r106);
            this.out.write(this.buffer, 0, this.limit);
            int r107 = this.limit;
            r105 = r105 - r107;
            this.totalBytesWritten += r107;
            goto L6
        L9:
            r100.get(this.buffer, 0, r105);
            this.position = r105;
            this.totalBytesWritten += r105;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString r100) throws IOException {
            writeUInt32NoTag(r100.size());
            r100.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int r100) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(r100);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long r100) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(r100);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int r100) throws IOException {
            if (r100 < 0) goto L4;
            writeUInt32NoTag(r100);
            return;
        L4:
            writeUInt64NoTag(r100);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r100) throws IOException {
            write(r100);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite r100) throws IOException {
            writeUInt32NoTag(r100.getSerializedSize());
            r100.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer r100) throws IOException {
            if (r100.hasArray() == false) goto L5;
            write(r100.array(), r100.arrayOffset(), r100.capacity());
            return;
        L5:
            ByteBuffer r101 = r100.duplicate();
            r101.clear();
            write(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String r100) throws IOException {
            int r101 = r100.length() * 3;     // Catch: Utf8.UnpairedSurrogateException -> L22
            int r102 = CodedOutputStream.computeUInt32SizeNoTag(r101);     // Catch: Utf8.UnpairedSurrogateException -> L22
            int r103 = r102 + r101;     // Catch: Utf8.UnpairedSurrogateException -> L22
            int r104 = this.limit;     // Catch: Utf8.UnpairedSurrogateException -> L22
            if (r103 <= r104) goto L7;
            byte[] r105 = new byte[r101];     // Catch: Utf8.UnpairedSurrogateException -> L22
            int r106 = Utf8.encode(r100, r105, 0, r101);     // Catch: Utf8.UnpairedSurrogateException -> L22
            writeUInt32NoTag(r106);     // Catch: Utf8.UnpairedSurrogateException -> L22
            writeLazy(r105, 0, r106);     // Catch: Utf8.UnpairedSurrogateException -> L22
            return;
        L7:
            if (r103 <= (r104 - this.position)) goto L9;
            doFlush();     // Catch: Utf8.UnpairedSurrogateException -> L22
        L9:
            int r107 = CodedOutputStream.computeUInt32SizeNoTag(r100.length());     // Catch: Utf8.UnpairedSurrogateException -> L22
            int r108 = this.position;     // Catch: Utf8.UnpairedSurrogateException -> L22
            if (r107 != r102) goto L13;
            int r109 = r108 + r107;
            this.position = r109;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            int r110 = Utf8.encode(r100, this.buffer, r109, this.limit - r109);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            this.position = r108;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            int r111 = (r110 - r108) - r107;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            bufferUInt32NoTag(r111);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            this.position = r110;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
        L14:
            this.totalBytesWritten += r111;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
        L28:
            return;
        L13:
            r111 = Utf8.encodedLength(r100);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            bufferUInt32NoTag(r111);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            this.position = Utf8.encode(r100, this.buffer, this.position, r111);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
        L19:
            e = move-exception;
            this.totalBytesWritten -= this.position - r108;     // Catch: Utf8.UnpairedSurrogateException -> L22
            this.position = r108;     // Catch: Utf8.UnpairedSurrogateException -> L22
            throw e;     // Catch: Utf8.UnpairedSurrogateException -> L22
        L16:
            e = move-exception;
            throw new OutOfSpaceException(e);     // Catch: Utf8.UnpairedSurrogateException -> L22
        L22:
            e = move-exception;
            inefficientWriteStringNoTag(r100, e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int r100) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt32NoTag(r100);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long r100) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(r100);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte r100) throws IOException {
            if (this.position != this.limit) goto L5;
            doFlush();
        L5:
            buffer(r100);
        }

        public OutputStreamEncoder(OutputStream r100, int r101) {
            super(r101);
            if (r100 == null) goto L7;
            this.out = r100;
            return;
        L7:
            throw new NullPointerException(Argument.OUT);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int r100, boolean r101) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(r100, 0);
            buffer(r101 ? 1 : 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r100, byte[] r101) throws IOException {
            writeByteArray(r100, r101, 0, r101.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int r100, ByteBuffer r101) throws IOException {
            writeTag(r100, 2);
            writeUInt32NoTag(r101.capacity());
            writeRawBytes(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int r100, ByteString r101) throws IOException {
            writeTag(r100, 2);
            writeBytesNoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int r100, int r101) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(r100, 5);
            bufferFixed32NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int r100, long r101) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(r100, 1);
            bufferFixed64NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int r100, int r101) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(r100, 0);
            bufferInt32NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int r100, MessageLite r101) throws IOException {
            writeTag(r100, 2);
            writeMessageNoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int r100, MessageLite r101) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, r100);
            writeMessage(3, r101);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int r100, ByteString r101) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, r100);
            writeBytes(3, r101);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int r100, String r101) throws IOException {
            writeTag(r100, 2);
            writeStringNoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int r100, int r101) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(r100, r101));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int r100, int r101) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(r100, 0);
            bufferUInt32NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int r100, long r101) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(r100, 0);
            bufferUInt64NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] r100, int r101, int r102) throws IOException {
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
            doFlush();
            if (r107 > this.limit) goto L8;
            System.arraycopy(r100, r106, this.buffer, 0, r107);
            this.position = r107;
        L9:
            this.totalBytesWritten += r107;
            return;
        L8:
            this.out.write(r100, r106, r107);
            goto L9
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] r100, int r101, int r102) throws IOException {
            writeUInt32NoTag(r102);
            write(r100, r101, r102);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r100, int r101, int r102) throws IOException {
            write(r100, r101, r102);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r100, byte[] r101, int r102, int r103) throws IOException {
            writeTag(r100, 2);
            writeByteArrayNoTag(r101, r102, r103);
        }
    }

    public static final class SafeDirectNioEncoder extends CodedOutputStream {
        private final ByteBuffer buffer;
        private final int initialPosition;
        private final ByteBuffer originalBuffer;

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
            this.originalBuffer.position(this.buffer.position());
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return this.buffer.position() - this.initialPosition;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int spaceLeft() {
            return this.buffer.remaining();
        }

        public SafeDirectNioEncoder(ByteBuffer r100) {
            super(null);
            this.originalBuffer = r100;
            this.buffer = r100.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.initialPosition = r100.position();
        }

        private void encode(String r100) throws IOException {
            Utf8.encodeUtf8(r100, this.buffer);     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte r100) throws IOException {
            this.buffer.put(r100);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString r100) throws IOException {
            writeUInt32NoTag(r100.size());
            r100.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int r100) throws IOException {
            this.buffer.putInt(r100);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long r100) throws IOException {
            this.buffer.putLong(r100);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int r100) throws IOException {
            if (r100 < 0) goto L4;
            writeUInt32NoTag(r100);
            return;
        L4:
            writeUInt64NoTag(r100);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r100) throws IOException {
            write(r100);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite r100) throws IOException {
            writeUInt32NoTag(r100.getSerializedSize());
            r100.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer r100) throws IOException {
            if (r100.hasArray() == false) goto L5;
            write(r100.array(), r100.arrayOffset(), r100.capacity());
            return;
        L5:
            ByteBuffer r101 = r100.duplicate();
            r101.clear();
            write(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String r100) throws IOException {
            int r101 = this.buffer.position();
            int r102 = CodedOutputStream.computeUInt32SizeNoTag(r100.length() * 3);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            int r103 = CodedOutputStream.computeUInt32SizeNoTag(r100.length());     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            if (r103 != r102) goto L6;
            int r104 = this.buffer.position() + r103;     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            this.buffer.position(r104);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            encode(r100);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            int r105 = this.buffer.position();     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            this.buffer.position(r101);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            writeUInt32NoTag(r105 - r104);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            this.buffer.position(r105);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
        L14:
            return;
        L6:
            writeUInt32NoTag(Utf8.encodedLength(r100));     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            encode(r100);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
        L11:
            e = move-exception;
            this.buffer.position(r101);
            inefficientWriteStringNoTag(r100, e);
            return;
        L8:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int r100) throws IOException {
        L3:
            if ((r100 & a.f25611g) == 0) goto L4;
            this.buffer.put((byte) ((r100 & 127) | 128));     // Catch: BufferOverflowException -> L8
            r100 = r100 >>> 7;
        L8:
            e = move-exception;
            throw new OutOfSpaceException(e);
        L4:
            this.buffer.put((byte) r100);     // Catch: BufferOverflowException -> L8
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long r100) throws IOException {
        L3:
            if (((-128) & r100) == 0) goto L4;
            this.buffer.put((byte) ((((int) r100) & 127) | 128));     // Catch: BufferOverflowException -> L8
            r100 = r100 >>> 7;
        L8:
            e = move-exception;
            throw new OutOfSpaceException(e);
        L4:
            this.buffer.put((byte) r100);     // Catch: BufferOverflowException -> L8
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer r100) throws IOException {
            this.buffer.put(r100);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int r100, boolean r101) throws IOException {
            writeTag(r100, 0);
            write(r101 ? 1 : 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r100, byte[] r101) throws IOException {
            writeByteArray(r100, r101, 0, r101.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int r100, ByteBuffer r101) throws IOException {
            writeTag(r100, 2);
            writeUInt32NoTag(r101.capacity());
            writeRawBytes(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int r100, ByteString r101) throws IOException {
            writeTag(r100, 2);
            writeBytesNoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int r100, int r101) throws IOException {
            writeTag(r100, 5);
            writeFixed32NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int r100, long r101) throws IOException {
            writeTag(r100, 1);
            writeFixed64NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int r100, int r101) throws IOException {
            writeTag(r100, 0);
            writeInt32NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int r100, MessageLite r101) throws IOException {
            writeTag(r100, 2);
            writeMessageNoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int r100, MessageLite r101) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, r100);
            writeMessage(3, r101);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int r100, ByteString r101) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, r100);
            writeBytes(3, r101);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int r100, String r101) throws IOException {
            writeTag(r100, 2);
            writeStringNoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int r100, int r101) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(r100, r101));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int r100, int r101) throws IOException {
            writeTag(r100, 0);
            writeUInt32NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int r100, long r101) throws IOException {
            writeTag(r100, 0);
            writeUInt64NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] r100, int r101, int r102) throws IOException {
            this.buffer.put(r100, r101, r102);     // Catch: BufferOverflowException -> L4 IndexOutOfBoundsException -> L7
            return;
        L7:
            e = move-exception;
            throw new OutOfSpaceException(e);
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] r100, int r101, int r102) throws IOException {
            writeUInt32NoTag(r102);
            write(r100, r101, r102);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r100, int r101, int r102) throws IOException {
            write(r100, r101, r102);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r100, byte[] r101, int r102, int r103) throws IOException {
            writeTag(r100, 2);
            writeByteArrayNoTag(r101, r102, r103);
        }
    }

    public static final class UnsafeDirectNioEncoder extends CodedOutputStream {
        private final long address;
        private final ByteBuffer buffer;
        private final long initialPosition;
        private final long limit;
        private final long oneVarintLimit;
        private final ByteBuffer originalBuffer;
        private long position;

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
            this.originalBuffer.position(bufferPos(this.position));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return (int) (this.position - this.initialPosition);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int spaceLeft() {
            return (int) (this.limit - this.position);
        }

        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        public UnsafeDirectNioEncoder(ByteBuffer r100) {
            super(null);
            this.originalBuffer = r100;
            this.buffer = r100.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long r101 = UnsafeUtil.addressOffset(r100);
            this.address = r101;
            long r102 = ((long) r100.position()) + r101;
            this.initialPosition = r102;
            long r103 = r101 + ((long) r100.limit());
            this.limit = r103;
            this.oneVarintLimit = r103 - 10;
            this.position = r102;
        }

        private int bufferPos(long r100) {
            return (int) (r100 - this.address);
        }

        private void repositionBuffer(long r100) {
            this.buffer.position(bufferPos(r100));
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte r100) throws IOException {
            long r101 = this.position;
            if (r101 >= this.limit) goto L7;
            this.position = 1 + r101;
            UnsafeUtil.putByte(r101, r100);
            return;
        L7:
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), 1}));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString r100) throws IOException {
            writeUInt32NoTag(r100.size());
            r100.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int r100) throws IOException {
            this.buffer.putInt(bufferPos(this.position), r100);
            this.position += 4;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long r100) throws IOException {
            this.buffer.putLong(bufferPos(this.position), r100);
            this.position += 8;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int r100) throws IOException {
            if (r100 < 0) goto L4;
            writeUInt32NoTag(r100);
            return;
        L4:
            writeUInt64NoTag(r100);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r100) throws IOException {
            write(r100);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite r100) throws IOException {
            writeUInt32NoTag(r100.getSerializedSize());
            r100.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer r100) throws IOException {
            if (r100.hasArray() == false) goto L5;
            write(r100.array(), r100.arrayOffset(), r100.capacity());
            return;
        L5:
            ByteBuffer r101 = r100.duplicate();
            r101.clear();
            write(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String r100) throws IOException {
            long r101 = this.position;
            int r102 = CodedOutputStream.computeUInt32SizeNoTag(r100.length() * 3);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            int r103 = CodedOutputStream.computeUInt32SizeNoTag(r100.length());     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            if (r103 != r102) goto L6;
            int r104 = bufferPos(this.position) + r103;     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            this.buffer.position(r104);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            Utf8.encodeUtf8(r100, this.buffer);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            int r105 = this.buffer.position() - r104;     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            writeUInt32NoTag(r105);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            this.position += (long) r105;     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
        L17:
            return;
        L6:
            int r106 = Utf8.encodedLength(r100);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            writeUInt32NoTag(r106);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            repositionBuffer(this.position);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            Utf8.encodeUtf8(r100, this.buffer);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            this.position += (long) r106;     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
        L14:
            e = move-exception;
            this.position = r101;
            repositionBuffer(r101);
            inefficientWriteStringNoTag(r100, e);
            return;
        L11:
            e = move-exception;
            throw new OutOfSpaceException(e);
        L8:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int r100) throws IOException {
            if (this.position <= this.oneVarintLimit) goto L5;
        L9:
            long r101 = this.position;
            if (r101 >= this.limit) goto L17;
            if ((r100 & a.f25611g) == 0) goto L13;
            this.position = r101 + 1;
            UnsafeUtil.putByte(r101, (byte) ((r100 & 127) | 128));
            r100 = r100 >>> 7;
            goto L9
        L13:
            this.position = 1 + r101;
            UnsafeUtil.putByte(r101, (byte) r100);
            return;
        L17:
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), 1}));
        L5:
            if ((r100 & a.f25611g) == 0) goto L6;
            long r102 = this.position;
            this.position = r102 + 1;
            UnsafeUtil.putByte(r102, (byte) ((r100 & 127) | 128));
            r100 = r100 >>> 7;
            goto L5
        L6:
            long r103 = this.position;
            this.position = 1 + r103;
            UnsafeUtil.putByte(r103, (byte) r100);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long r110) throws IOException {
            if (this.position <= this.oneVarintLimit) goto L5;
        L9:
            long r100 = this.position;
            if (r100 >= this.limit) goto L17;
            if ((r110 & (-128)) == 0) goto L13;
            this.position = r100 + 1;
            UnsafeUtil.putByte(r100, (byte) ((((int) r110) & 127) | 128));
            r110 = r110 >>> 7;
            goto L9
        L13:
            this.position = 1 + r100;
            UnsafeUtil.putByte(r100, (byte) r110);
            return;
        L17:
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), 1}));
        L5:
            if ((r110 & (-128)) == 0) goto L6;
            long r101 = this.position;
            this.position = r101 + 1;
            UnsafeUtil.putByte(r101, (byte) ((((int) r110) & 127) | 128));
            r110 = r110 >>> 7;
            goto L5
        L6:
            long r102 = this.position;
            this.position = 1 + r102;
            UnsafeUtil.putByte(r102, (byte) r110);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer r100) throws IOException {
            int r101 = r100.remaining();     // Catch: BufferOverflowException -> L4
            repositionBuffer(this.position);     // Catch: BufferOverflowException -> L4
            this.buffer.put(r100);     // Catch: BufferOverflowException -> L4
            this.position += (long) r101;     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int r100, boolean r101) throws IOException {
            writeTag(r100, 0);
            write(r101 ? 1 : 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r100, byte[] r101) throws IOException {
            writeByteArray(r100, r101, 0, r101.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int r100, ByteBuffer r101) throws IOException {
            writeTag(r100, 2);
            writeUInt32NoTag(r101.capacity());
            writeRawBytes(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int r100, ByteString r101) throws IOException {
            writeTag(r100, 2);
            writeBytesNoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int r100, int r101) throws IOException {
            writeTag(r100, 5);
            writeFixed32NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int r100, long r101) throws IOException {
            writeTag(r100, 1);
            writeFixed64NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int r100, int r101) throws IOException {
            writeTag(r100, 0);
            writeInt32NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int r100, MessageLite r101) throws IOException {
            writeTag(r100, 2);
            writeMessageNoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int r100, MessageLite r101) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, r100);
            writeMessage(3, r101);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int r100, ByteString r101) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, r100);
            writeBytes(3, r101);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int r100, String r101) throws IOException {
            writeTag(r100, 2);
            writeStringNoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int r100, int r101) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(r100, r101));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int r100, int r101) throws IOException {
            writeTag(r100, 0);
            writeUInt32NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int r100, long r101) throws IOException {
            writeTag(r100, 0);
            writeUInt64NoTag(r101);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] r110, int r111, int r112) throws IOException {
            if (r110 == null) goto L12;
            if (r111 < 0) goto L12;
            if (r112 < 0) goto L12;
            if ((r110.length - r112) < r111) goto L12;
            long r100 = r112;
            long r101 = this.limit - r100;
            long r102 = this.position;
            if (r101 < r102) goto L12;
            UnsafeUtil.copyMemory(r110, r111, r102, r100);
            this.position += r100;
            return;
        L12:
            if (r110 != null) goto L16;
            throw new NullPointerException("value");
        L16:
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), Integer.valueOf(r112)}));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] r100, int r101, int r102) throws IOException {
            writeUInt32NoTag(r102);
            write(r100, r101, r102);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r100, int r101, int r102) throws IOException {
            write(r100, r101, r102);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r100, byte[] r101, int r102, int r103) throws IOException {
            writeTag(r100, 2);
            writeByteArrayNoTag(r101, r102, r103);
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

    public static int computeSFixed32SizeNoTag(int r100) {
        return 4;
    }

    public static int computeSFixed64SizeNoTag(long r100) {
        return 8;
    }

    public static int computeUInt32SizeNoTag(int r100) {
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

    public static int computeUInt64SizeNoTag(long r100) {
        if (((-128) & r100) != 0) goto L7;
        return 1;
    L7:
        if (r100 >= 0) goto L11;
        return 10;
    L11:
        if (((-34359738368L) & r100) == 0) goto L13;
        r100 = r100 >>> 28;
        int r101 = 6;
    L15:
        if (((-2097152) & r100) == 0) goto L18;
        r101 = r101 + 2;
        r100 = r100 >>> 14;
    L18:
        if ((r100 & (-16384)) != 0) goto L20;
        return r101;
    L20:
        return r101 + 1;
    L13:
        r101 = 2;
        goto L15
    }

    public static int encodeZigZag32(int r100) {
        int r101 = r100 << 1;
        return (r100 >> 31) ^ r101;
    }

    public static long encodeZigZag64(long r100) {
        long r101 = r100 << 1;
        return (r100 >> 63) ^ r101;
    }

    public abstract void flush() throws IOException;

    public abstract int getTotalBytesWritten();

    public abstract int spaceLeft();

    public void useDeterministicSerialization() {
        this.serializationDeterministic = true;
    }

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(byte r100) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(ByteBuffer r100) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(byte[] r100, int r101, int r102) throws IOException;

    public abstract void writeBool(int r100, boolean r101) throws IOException;

    public abstract void writeByteArray(int r100, byte[] r101) throws IOException;

    public abstract void writeByteArray(int r100, byte[] r101, int r102, int r103) throws IOException;

    public abstract void writeByteArrayNoTag(byte[] r100, int r101, int r102) throws IOException;

    public abstract void writeByteBuffer(int r100, ByteBuffer r101) throws IOException;

    public abstract void writeBytes(int r100, ByteString r101) throws IOException;

    public abstract void writeBytesNoTag(ByteString r100) throws IOException;

    public abstract void writeFixed32(int r100, int r101) throws IOException;

    public abstract void writeFixed32NoTag(int r100) throws IOException;

    public abstract void writeFixed64(int r100, long r101) throws IOException;

    public abstract void writeFixed64NoTag(long r100) throws IOException;

    public abstract void writeInt32(int r100, int r101) throws IOException;

    public abstract void writeInt32NoTag(int r100) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void writeLazy(ByteBuffer r100) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void writeLazy(byte[] r100, int r101, int r102) throws IOException;

    public abstract void writeMessage(int r100, MessageLite r101) throws IOException;

    public abstract void writeMessageNoTag(MessageLite r100) throws IOException;

    public abstract void writeMessageSetExtension(int r100, MessageLite r101) throws IOException;

    public abstract void writeRawBytes(ByteBuffer r100) throws IOException;

    public abstract void writeRawMessageSetExtension(int r100, ByteString r101) throws IOException;

    public abstract void writeString(int r100, String r101) throws IOException;

    public abstract void writeStringNoTag(String r100) throws IOException;

    public abstract void writeTag(int r100, int r101) throws IOException;

    public abstract void writeUInt32(int r100, int r101) throws IOException;

    public abstract void writeUInt32NoTag(int r100) throws IOException;

    public abstract void writeUInt64(int r100, long r101) throws IOException;

    public abstract void writeUInt64NoTag(long r100) throws IOException;

    static {
        logger = Logger.getLogger(CodedOutputStream.class.getName());
        HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.hasUnsafeArrayOperations();
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() != 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    private CodedOutputStream() {
    }

    public static /* synthetic */ boolean access$100() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    public boolean isSerializationDeterministic() {
        return this.serializationDeterministic;
    }

    public /* synthetic */ CodedOutputStream(AnonymousClass1 r100) {
        this();
    }

    public static int computeByteArraySizeNoTag(byte[] r100) {
        return computeLengthDelimitedFieldSize(r100.length);
    }

    public static int computeByteBufferSizeNoTag(ByteBuffer r100) {
        return computeLengthDelimitedFieldSize(r100.capacity());
    }

    public static int computeBytesSizeNoTag(ByteString r100) {
        return computeLengthDelimitedFieldSize(r100.size());
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
        return computeUInt32SizeNoTag(r100);
    }

    public static int computeInt64SizeNoTag(long r100) {
        return computeUInt64SizeNoTag(r100);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite r100) {
        return computeLengthDelimitedFieldSize(r100.getSerializedSize());
    }

    public static int computeLengthDelimitedFieldSize(int r100) {
        return computeUInt32SizeNoTag(r100) + r100;
    }

    public static int computeMessageSizeNoTag(MessageLite r100) {
        return computeLengthDelimitedFieldSize(r100.getSerializedSize());
    }

    public static int computeRawVarint32Size(int r100) {
        return computeUInt32SizeNoTag(r100);
    }

    public static int computeRawVarint64Size(long r100) {
        return computeUInt64SizeNoTag(r100);
    }

    public static int computeSInt32SizeNoTag(int r100) {
        return computeUInt32SizeNoTag(encodeZigZag32(r100));
    }

    public static int computeSInt64SizeNoTag(long r100) {
        return computeUInt64SizeNoTag(encodeZigZag64(r100));
    }

    public static int computeStringSizeNoTag(String r100) {
        int r101 = Utf8.encodedLength(r100);     // Catch: Utf8.UnpairedSurrogateException -> L4
    L6:
        return computeLengthDelimitedFieldSize(r101);
    L4:
        r101 = r100.getBytes(Internal.UTF_8).length;
        goto L6
    }

    public static int computeTagSize(int r100) {
        return computeUInt32SizeNoTag(WireFormat.makeTag(r100, 0));
    }

    public static CodedOutputStream newInstance(ByteBuffer r100) {
        if (r100.hasArray() == false) goto L7;
        return new HeapNioEncoder(r100);
    L7:
        if (r100.isDirect() == false) goto L16;
        if (r100.isReadOnly() == true) goto L16;
        if (UnsafeDirectNioEncoder.isSupported() == false) goto L14;
        return newUnsafeInstance(r100);
    L14:
        return newSafeInstance(r100);
    L16:
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    public static CodedOutputStream newSafeInstance(ByteBuffer r100) {
        return new SafeDirectNioEncoder(r100);
    }

    public static CodedOutputStream newUnsafeInstance(ByteBuffer r100) {
        return new UnsafeDirectNioEncoder(r100);
    }

    public final void writeBoolNoTag(boolean r100) throws IOException {
        write(r100 ? 1 : 0);
    }

    public final void writeByteArrayNoTag(byte[] r100) throws IOException {
        writeByteArrayNoTag(r100, 0, r100.length);
    }

    public final void writeDoubleNoTag(double r100) throws IOException {
        writeFixed64NoTag(Double.doubleToRawLongBits(r100));
    }

    public final void writeEnumNoTag(int r100) throws IOException {
        writeInt32NoTag(r100);
    }

    public final void writeFloatNoTag(float r100) throws IOException {
        writeFixed32NoTag(Float.floatToRawIntBits(r100));
    }

    public final void writeGroupNoTag(MessageLite r100) throws IOException {
        r100.writeTo(this);
    }

    public final void writeInt64NoTag(long r100) throws IOException {
        writeUInt64NoTag(r100);
    }

    public final void writeRawByte(int r100) throws IOException {
        write((byte) r100);
    }

    public final void writeRawBytes(byte[] r100) throws IOException {
        write(r100, 0, r100.length);
    }

    public final void writeRawLittleEndian32(int r100) throws IOException {
        writeFixed32NoTag(r100);
    }

    public final void writeRawLittleEndian64(long r100) throws IOException {
        writeFixed64NoTag(r100);
    }

    public final void writeRawVarint32(int r100) throws IOException {
        writeUInt32NoTag(r100);
    }

    public final void writeRawVarint64(long r100) throws IOException {
        writeUInt64NoTag(r100);
    }

    public final void writeSFixed32NoTag(int r100) throws IOException {
        writeFixed32NoTag(r100);
    }

    public final void writeSFixed64NoTag(long r100) throws IOException {
        writeFixed64NoTag(r100);
    }

    public final void writeSInt32NoTag(int r100) throws IOException {
        writeUInt32NoTag(encodeZigZag32(r100));
    }

    public final void writeSInt64NoTag(long r100) throws IOException {
        writeUInt64NoTag(encodeZigZag64(r100));
    }

    public static CodedOutputStream newInstance(OutputStream r100) {
        return newInstance(r100, 4096);
    }

    public final void writeRawByte(byte r100) throws IOException {
        write(r100);
    }

    public final void writeRawBytes(ByteString r100) throws IOException {
        r100.writeTo(this);
    }

    public static CodedOutputStream newInstance(byte[] r100) {
        return newInstance(r100, 0, r100.length);
    }

    public static int computeBoolSize(int r100, boolean r101) {
        return computeTagSize(r100) + computeBoolSizeNoTag(r101);
    }

    public static int computeByteArraySize(int r100, byte[] r101) {
        return computeTagSize(r100) + computeByteArraySizeNoTag(r101);
    }

    public static int computeByteBufferSize(int r100, ByteBuffer r101) {
        return computeTagSize(r100) + computeByteBufferSizeNoTag(r101);
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

    public static int computeFixed32Size(int r100, int r101) {
        return computeTagSize(r100) + computeFixed32SizeNoTag(r101);
    }

    public static int computeFixed64Size(int r100, long r101) {
        return computeTagSize(r100) + computeFixed64SizeNoTag(r101);
    }

    public static int computeFloatSize(int r100, float r101) {
        return computeTagSize(r100) + computeFloatSizeNoTag(r101);
    }

    public static int computeGroupSize(int r100, MessageLite r101) {
        return (computeTagSize(r100) * 2) + computeGroupSizeNoTag(r101);
    }

    public static int computeInt32Size(int r100, int r101) {
        return computeTagSize(r100) + computeInt32SizeNoTag(r101);
    }

    public static int computeInt64Size(int r100, long r101) {
        return computeTagSize(r100) + computeInt64SizeNoTag(r101);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int r100, LazyFieldLite r101) {
        return ((computeTagSize(1) * 2) + computeUInt32Size(2, r100)) + computeLazyFieldSize(3, r101);
    }

    public static int computeLazyFieldSize(int r100, LazyFieldLite r101) {
        return computeTagSize(r100) + computeLazyFieldSizeNoTag(r101);
    }

    public static int computeMessageSetExtensionSize(int r100, MessageLite r101) {
        return ((computeTagSize(1) * 2) + computeUInt32Size(2, r100)) + computeMessageSize(3, r101);
    }

    public static int computeMessageSize(int r100, MessageLite r101) {
        return computeTagSize(r100) + computeMessageSizeNoTag(r101);
    }

    public static int computeRawMessageSetExtensionSize(int r100, ByteString r101) {
        return ((computeTagSize(1) * 2) + computeUInt32Size(2, r100)) + computeBytesSize(3, r101);
    }

    public static int computeSFixed32Size(int r100, int r101) {
        return computeTagSize(r100) + computeSFixed32SizeNoTag(r101);
    }

    public static int computeSFixed64Size(int r100, long r101) {
        return computeTagSize(r100) + computeSFixed64SizeNoTag(r101);
    }

    public static int computeSInt32Size(int r100, int r101) {
        return computeTagSize(r100) + computeSInt32SizeNoTag(r101);
    }

    public static int computeSInt64Size(int r100, long r101) {
        return computeTagSize(r100) + computeSInt64SizeNoTag(r101);
    }

    public static int computeStringSize(int r100, String r101) {
        return computeTagSize(r100) + computeStringSizeNoTag(r101);
    }

    public static int computeUInt32Size(int r100, int r101) {
        return computeTagSize(r100) + computeUInt32SizeNoTag(r101);
    }

    public static int computeUInt64Size(int r100, long r101) {
        return computeTagSize(r100) + computeUInt64SizeNoTag(r101);
    }

    public static CodedOutputStream newInstance(ByteOutput r100, int r101) {
        if (r101 < 0) goto L6;
        return new ByteOutputEncoder(r100, r101);
    L6:
        throw new IllegalArgumentException("bufferSize must be positive");
    }

    public final void inefficientWriteStringNoTag(String r100, Utf8.UnpairedSurrogateException r101) throws IOException {
        logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", r101);
        byte[] r102 = r100.getBytes(Internal.UTF_8);
        writeUInt32NoTag(r102.length);     // Catch: OutOfSpaceException -> L5 IndexOutOfBoundsException -> L7
        writeLazy(r102, 0, r102.length);     // Catch: OutOfSpaceException -> L5 IndexOutOfBoundsException -> L7
        return;
    L5:
        e = move-exception;
        throw e;
    L7:
        e = move-exception;
        throw new OutOfSpaceException(e);
    }

    public final void writeDouble(int r100, double r101) throws IOException {
        writeFixed64(r100, Double.doubleToRawLongBits(r101));
    }

    public final void writeEnum(int r100, int r101) throws IOException {
        writeInt32(r100, r101);
    }

    public final void writeFloat(int r100, float r101) throws IOException {
        writeFixed32(r100, Float.floatToRawIntBits(r101));
    }

    public final void writeGroup(int r100, MessageLite r101) throws IOException {
        writeTag(r100, 3);
        writeGroupNoTag(r101);
        writeTag(r100, 4);
    }

    public final void writeInt64(int r100, long r101) throws IOException {
        writeUInt64(r100, r101);
    }

    public final void writeSFixed32(int r100, int r101) throws IOException {
        writeFixed32(r100, r101);
    }

    public final void writeSFixed64(int r100, long r101) throws IOException {
        writeFixed64(r100, r101);
    }

    public final void writeSInt32(int r100, int r101) throws IOException {
        writeUInt32(r100, encodeZigZag32(r101));
    }

    public final void writeSInt64(int r100, long r101) throws IOException {
        writeUInt64(r100, encodeZigZag64(r101));
    }

    public static CodedOutputStream newInstance(OutputStream r100, int r101) {
        return new OutputStreamEncoder(r100, r101);
    }

    public static CodedOutputStream newInstance(ByteBuffer r100, int r101) {
        return newInstance(r100);
    }

    public static CodedOutputStream newInstance(byte[] r100, int r101, int r102) {
        return new ArrayEncoder(r100, r101, r102);
    }

    public final void writeRawBytes(byte[] r100, int r101, int r102) throws IOException {
        write(r100, r101, r102);
    }
}
