package com.google.protobuf;

import com.alipay.sdk.m.n.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes23.dex */
public abstract class CodedInputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int DEFAULT_RECURSION_LIMIT = 100;
    private static final int DEFAULT_SIZE_LIMIT = Integer.MAX_VALUE;
    private static volatile boolean proto3DiscardUnknownFieldsDefault;
    private boolean explicitDiscardUnknownFields;
    int recursionDepth;
    int recursionLimit;
    int sizeLimit;

    /* JADX INFO: renamed from: com.google.protobuf.CodedInputStream$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class ArrayDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private int limit;
        private int pos;
        private int startPos;

        private void skipRawVarintFastPath() throws IOException {
            int r100 = 0;
        L4:
            if (r100 >= 10) goto L10;
            byte[] r101 = this.buffer;
            int r102 = this.pos;
            this.pos = r102 + 1;
            if (r101[r102] >= 0) goto L7;
            r100 = r100 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            int r100 = 0;
        L4:
            if (r100 >= 10) goto L10;
            if (readRawByte() >= 0) goto L7;
            r100 = r100 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void recomputeBufferSizeAfterLimit() {
            int r100 = this.limit + this.bufferSizeAfterLimit;
            this.limit = r100;
            int r101 = r100 - this.startPos;
            int r102 = this.currentLimit;
            if (r101 <= r102) goto L5;
            int r103 = r101 - r102;
            this.bufferSizeAfterLimit = r103;
            this.limit = r100 - r103;
            return;
        L5:
            this.bufferSizeAfterLimit = 0;
        }

        private void skipRawVarint() throws IOException {
            if ((this.limit - this.pos) < 10) goto L5;
            skipRawVarintFastPath();
            return;
        L5:
            skipRawVarintSlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int r100 = this.currentLimit;
            if (r100 != Integer.MAX_VALUE) goto L7;
            return -1;
        L7:
            return r100 - getTotalBytesRead();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.pos - this.startPos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            if (this.pos != this.limit) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            int r100 = this.pos;
            if (r100 == this.limit) goto L7;
            byte[] r101 = this.buffer;
            this.pos = r100 + 1;
            return r101[r100];
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            int r100 = this.pos;
            if ((this.limit - r100) < 4) goto L7;
            byte[] r101 = this.buffer;
            this.pos = r100 + 4;
            int r102 = ((r101[r100] & UByte.MAX_VALUE) | ((r101[r100 + 1] & UByte.MAX_VALUE) << 8)) | ((r101[r100 + 2] & UByte.MAX_VALUE) << 16);
            return ((r101[r100 + 3] & UByte.MAX_VALUE) << 24) | r102;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            int r100 = this.pos;
            if ((this.limit - r100) < 8) goto L7;
            byte[] r101 = this.buffer;
            this.pos = r100 + 8;
            long r102 = ((((((((long) r101[r100]) & 255) | ((((long) r101[r100 + 1]) & 255) << 8)) | ((((long) r101[r100 + 2]) & 255) << 16)) | ((((long) r101[r100 + 3]) & 255) << 24)) | ((((long) r101[r100 + 4]) & 255) << 32)) | ((((long) r101[r100 + 5]) & 255) << 40)) | ((((long) r101[r100 + 6]) & 255) << 48);
            return ((((long) r101[r100 + 7]) & 255) << 56) | r102;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawVarint32() throws IOException {
            int r100 = this.pos;
            int r101 = this.limit;
            if (r101 == r100) goto L35;
            byte[] r102 = this.buffer;
            int r103 = r100 + 1;
            byte r104 = r102[r100];
            if (r104 < 0) goto L10;
            this.pos = r103;
            return r104;
        L10:
            if ((r101 - r103) < 9) goto L35;
            int r105 = r103 + 1;
            int r106 = r104 ^ (r102[r103] << 7);
            if (r106 >= 0) goto L15;
            int r107 = r106 ^ a.f25611g;
        L36:
            this.pos = r105;
            return r107;
        L15:
            int r108 = r105 + 1;
            int r109 = r106 ^ (r102[r105] << 14);
            if (r109 < 0) goto L19;
            r107 = r109 ^ 16256;
        L18:
            r105 = r108;
            goto L36
        L19:
            r105 = r108 + 1;
            int r110 = r109 ^ (r102[r108] << 21);
            if (r110 >= 0) goto L22;
            r107 = r110 ^ (-2080896);
            goto L36
        L22:
            r108 = r105 + 1;
            byte r111 = r102[r105];
            r107 = (r110 ^ (r111 << 28)) ^ 266354560;
            if (r111 >= 0) goto L18;
            r105 = r108 + 1;
            if (r102[r108] >= 0) goto L36;
            r108 = r105 + 1;
            if (r102[r105] >= 0) goto L18;
            r105 = r108 + 1;
            if (r102[r108] >= 0) goto L36;
            r108 = r105 + 1;
            if (r102[r105] >= 0) goto L18;
            r105 = r108 + 1;
            if (r102[r108] >= 0) goto L36;
        L35:
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            int r100 = this.pos;
            int r101 = this.limit;
            if (r101 == r100) goto L41;
            byte[] r102 = this.buffer;
            int r103 = r100 + 1;
            byte r104 = r102[r100];
            if (r104 < 0) goto L10;
            this.pos = r103;
            return r104;
        L10:
            if ((r101 - r103) < 9) goto L41;
            int r105 = r103 + 1;
            int r106 = r104 ^ (r102[r103] << 7);
            if (r106 >= 0) goto L16;
            int r107 = r106 ^ a.f25611g;
        L15:
            long r108 = r107;
        L44:
            this.pos = r105;
            return r108;
        L16:
            int r109 = r105 + 1;
            int r110 = r106 ^ (r102[r105] << 14);
            if (r110 < 0) goto L19;
            r105 = r109;
            r108 = r110 ^ 16256;
            goto L44
        L19:
            r105 = r109 + 1;
            int r111 = r110 ^ (r102[r109] << 21);
            if (r111 >= 0) goto L22;
            r107 = r111 ^ (-2080896);
            goto L15
        L22:
            long r112 = r111;
            int r113 = r105 + 1;
            long r114 = r112 ^ (((long) r102[r105]) << 28);
            if (r114 < 0) goto L26;
            long r115 = 266354560;
        L25:
            r108 = r114 ^ r115;
            r105 = r113;
            goto L44
        L26:
            r105 = r113 + 1;
            long r116 = r114 ^ (((long) r102[r113]) << 35);
            if (r116 >= 0) goto L30;
            long r117 = -34093383808L;
        L29:
            r108 = r116 ^ r117;
            goto L44
        L30:
            r113 = r105 + 1;
            r114 = r116 ^ (((long) r102[r105]) << 42);
            if (r114 < 0) goto L33;
            r115 = 4363953127296L;
            goto L25
        L33:
            r105 = r113 + 1;
            r116 = r114 ^ (((long) r102[r113]) << 49);
            if (r116 >= 0) goto L36;
            r117 = -558586000294016L;
            goto L29
        L36:
            int r118 = r105 + 1;
            long r119 = (r116 ^ (((long) r102[r105]) << 56)) ^ 71499008037633920L;
            if (r119 >= 0) goto L42;
            r105 = r118 + 1;
            if (r102[r118] < 0) goto L41;
        L43:
            r108 = r119;
            goto L44
        L42:
            r105 = r118;
        L41:
            return readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64SlowPath() throws IOException {
            long r100 = 0;
            int r101 = 0;
        L4:
            if (r101 >= 64) goto L10;
            byte r102 = readRawByte();
            r100 = r100 | (((long) (r102 & ByteCompanionObject.MAX_VALUE)) << r101);
            if ((r102 & ByteCompanionObject.MIN_VALUE) == 0) goto L7;
            r101 = r101 + 7;
            goto L4
        L7:
            return r100;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            if (readRawVarint64() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int r100 = readRawVarint32();
            if (r100 <= 0) goto L14;
            int r101 = this.limit;
            int r102 = this.pos;
            if (r100 > (r101 - r102)) goto L14;
            if (this.immutable == false) goto L9;
        L11:
            ByteBuffer r103 = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, r102, r102 + r100));
        L12:
            this.pos += r100;
            return r103;
        L9:
            if (this.enableAliasing == false) goto L11;
            r103 = ByteBuffer.wrap(this.buffer, r102, r100).slice();
        L14:
            if (r100 == 0) goto L16;
            if (r100 >= 0) goto L21;
            throw InvalidProtocolBufferException.negativeSize();
        L21:
            throw InvalidProtocolBufferException.truncatedMessage();
        L16:
            return Internal.EMPTY_BYTE_BUFFER;
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int r100 = readRawVarint32();
            if (r100 <= 0) goto L14;
            int r101 = this.limit;
            int r102 = this.pos;
            if (r100 > (r101 - r102)) goto L14;
            if (this.immutable == true) goto L9;
        L11:
            ByteString r103 = ByteString.copyFrom(this.buffer, r102, r100);
        L12:
            this.pos += r100;
            return r103;
        L9:
            if (this.enableAliasing == false) goto L11;
            r103 = ByteString.wrap(this.buffer, r102, r100);
        L14:
            if (r100 != 0) goto L18;
            return ByteString.EMPTY;
        L18:
            return ByteString.wrap(readRawBytes(r100));
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() throws IOException {
            int r100 = readRawVarint32();
            if (r100 <= 0) goto L8;
            int r101 = this.limit;
            int r102 = this.pos;
            if (r100 > (r101 - r102)) goto L8;
            String r103 = new String(this.buffer, r102, r100, Internal.UTF_8);
            this.pos += r100;
            return r103;
        L8:
            if (r100 != 0) goto L11;
            return "";
        L11:
            if (r100 >= 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int r100 = readRawVarint32();
            if (r100 <= 0) goto L12;
            int r101 = this.limit;
            int r102 = this.pos;
            if (r100 > (r101 - r102)) goto L12;
            if (Utf8.isValidUtf8(this.buffer, r102, r102 + r100) == false) goto L11;
            int r103 = this.pos;
            this.pos = r103 + r100;
            return new String(this.buffer, r103, r100, Internal.UTF_8);
        L11:
            throw InvalidProtocolBufferException.invalidUtf8();
        L12:
            if (r100 != 0) goto L15;
            return "";
        L15:
            if (r100 > 0) goto L19;
            throw InvalidProtocolBufferException.negativeSize();
        L19:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd() == false) goto L6;
            this.lastTag = 0;
            return 0;
        L6:
            int r100 = readRawVarint32();
            this.lastTag = r100;
            if (WireFormat.getTagFieldNumber(r100) == 0) goto L11;
            return this.lastTag;
        L11:
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
        L2:
            int r100 = readTag();
            if (r100 == 0) goto L6;
            if (skipField(r100) == true) goto L2;
            return;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int r100) throws InvalidProtocolBufferException {
            if (this.lastTag != r100) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean r100) {
            this.enableAliasing = r100;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int r100) {
            this.currentLimit = r100;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int r100) throws InvalidProtocolBufferException {
            if (r100 < 0) goto L10;
            int r101 = r100 + getTotalBytesRead();
            int r102 = this.currentLimit;
            if (r101 > r102) goto L8;
            this.currentLimit = r101;
            recomputeBufferSizeAfterLimit();
            return r102;
        L8:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int r100) throws IOException {
            if (r100 <= 0) goto L7;
            int r101 = this.limit;
            int r102 = this.pos;
            if (r100 > (r101 - r102)) goto L7;
            int r103 = r100 + r102;
            this.pos = r103;
            return Arrays.copyOfRange(this.buffer, r102, r103);
        L7:
            if (r100 > 0) goto L14;
            if (r100 != 0) goto L12;
            return Internal.EMPTY_BYTE_ARRAY;
        L12:
            throw InvalidProtocolBufferException.negativeSize();
        L14:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r100) throws IOException {
            int r101 = WireFormat.getTagWireType(r100);
            if (r101 == 0) goto L24;
            if (r101 != 1) goto L6;
            skipRawBytes(8);
            return true;
        L6:
            if (r101 != 2) goto L8;
            skipRawBytes(readRawVarint32());
            return true;
        L8:
            if (r101 == 3) goto L18;
            if (r101 != 4) goto L11;
            return false;
        L11:
            if (r101 != 5) goto L15;
            skipRawBytes(4);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(r100), 4));
            return true;
        L24:
            skipRawVarint();
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream r100) throws IOException {
        L2:
            int r101 = readTag();
            if (r101 == 0) goto L6;
            if (skipField(r101, r100) == true) goto L2;
            return;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int r100) throws IOException {
            if (r100 < 0) goto L7;
            int r101 = this.limit;
            int r102 = this.pos;
            if (r100 > (r101 - r102)) goto L7;
            this.pos = r102 + r100;
            return;
        L7:
            if (r100 >= 0) goto L11;
            throw InvalidProtocolBufferException.negativeSize();
        L11:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> r100, ExtensionRegistryLite r101) throws IOException {
            int r102 = readRawVarint32();
            if (this.recursionDepth >= this.recursionLimit) goto L7;
            int r103 = pushLimit(r102);
            this.recursionDepth++;
            T r104 = r100.parsePartialFrom(this, r101);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(r103);
            return r104;
        L7:
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readUnknownGroup(int r100, MessageLite.Builder r101) throws IOException {
            readGroup(r100, r101, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r100, CodedOutputStream r101) throws IOException {
            int r102 = WireFormat.getTagWireType(r100);
            if (r102 == 0) goto L24;
            if (r102 != 1) goto L6;
            long r103 = readRawLittleEndian64();
            r101.writeRawVarint32(r100);
            r101.writeFixed64NoTag(r103);
            return true;
        L6:
            if (r102 != 2) goto L8;
            ByteString r104 = readBytes();
            r101.writeRawVarint32(r100);
            r101.writeBytesNoTag(r104);
            return true;
        L8:
            if (r102 == 3) goto L18;
            if (r102 != 4) goto L11;
            return false;
        L11:
            if (r102 != 5) goto L15;
            int r105 = readRawLittleEndian32();
            r101.writeRawVarint32(r100);
            r101.writeFixed32NoTag(r105);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            r101.writeRawVarint32(r100);
            skipMessage(r101);
            int r106 = WireFormat.makeTag(WireFormat.getTagFieldNumber(r100), 4);
            checkLastTagWas(r106);
            r101.writeRawVarint32(r106);
            return true;
        L24:
            long r107 = readInt64();
            r101.writeRawVarint32(r100);
            r101.writeUInt64NoTag(r107);
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder r100, ExtensionRegistryLite r101) throws IOException {
            int r102 = readRawVarint32();
            if (this.recursionDepth >= this.recursionLimit) goto L7;
            int r103 = pushLimit(r102);
            this.recursionDepth++;
            r100.mergeFrom(this, r101);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(r103);
            return;
        L7:
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int r100, Parser<T> r101, ExtensionRegistryLite r102) throws IOException {
            int r103 = this.recursionDepth;
            if (r103 >= this.recursionLimit) goto L7;
            this.recursionDepth = r103 + 1;
            T r104 = r101.parsePartialFrom(this, r102);
            checkLastTagWas(WireFormat.makeTag(r100, 4));
            this.recursionDepth--;
            return r104;
        L7:
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int r100, MessageLite.Builder r101, ExtensionRegistryLite r102) throws IOException {
            int r103 = this.recursionDepth;
            if (r103 >= this.recursionLimit) goto L7;
            this.recursionDepth = r103 + 1;
            r101.mergeFrom(this, r102);
            checkLastTagWas(WireFormat.makeTag(r100, 4));
            this.recursionDepth--;
            return;
        L7:
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        private ArrayDecoder(byte[] r100, int r101, int r102, boolean r103) {
            super(null);
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = r100;
            this.limit = r102 + r101;
            this.pos = r101;
            this.startPos = r101;
            this.immutable = r103;
        }

        public /* synthetic */ ArrayDecoder(byte[] r100, int r101, int r102, boolean r103, AnonymousClass1 r104) {
            this(r100, r101, r102, r103);
        }
    }

    public static final class IterableDirectByteBufferDecoder extends CodedInputStream {
        private int bufferSizeAfterCurrentLimit;
        private long currentAddress;
        private ByteBuffer currentByteBuffer;
        private long currentByteBufferLimit;
        private long currentByteBufferPos;
        private long currentByteBufferStartPos;
        private int currentLimit;
        private boolean enableAliasing;
        private boolean immutable;
        private Iterable<ByteBuffer> input;
        private Iterator<ByteBuffer> iterator;
        private int lastTag;
        private int startOffset;
        private int totalBufferSize;
        private int totalBytesRead;

        private void skipRawVarint() throws IOException {
            int r100 = 0;
        L4:
            if (r100 >= 10) goto L10;
            if (readRawByte() >= 0) goto L7;
            r100 = r100 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private long currentRemaining() {
            return this.currentByteBufferLimit - this.currentByteBufferPos;
        }

        private void getNextByteBuffer() throws InvalidProtocolBufferException {
            if (this.iterator.hasNext() == false) goto L7;
            tryGetNextByteBuffer();
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private void recomputeBufferSizeAfterLimit() {
            int r100 = this.totalBufferSize + this.bufferSizeAfterCurrentLimit;
            this.totalBufferSize = r100;
            int r101 = r100 - this.startOffset;
            int r102 = this.currentLimit;
            if (r101 <= r102) goto L5;
            int r103 = r101 - r102;
            this.bufferSizeAfterCurrentLimit = r103;
            this.totalBufferSize = r100 - r103;
            return;
        L5:
            this.bufferSizeAfterCurrentLimit = 0;
        }

        private int remaining() {
            return (int) ((((long) (this.totalBufferSize - this.totalBytesRead)) - this.currentByteBufferPos) + this.currentByteBufferStartPos);
        }

        private void tryGetNextByteBuffer() {
            ByteBuffer r100 = this.iterator.next();
            this.currentByteBuffer = r100;
            this.totalBytesRead += (int) (this.currentByteBufferPos - this.currentByteBufferStartPos);
            long r101 = r100.position();
            this.currentByteBufferPos = r101;
            this.currentByteBufferStartPos = r101;
            this.currentByteBufferLimit = this.currentByteBuffer.limit();
            long r102 = UnsafeUtil.addressOffset(this.currentByteBuffer);
            this.currentAddress = r102;
            this.currentByteBufferPos += r102;
            this.currentByteBufferStartPos += r102;
            this.currentByteBufferLimit += r102;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int r100 = this.currentLimit;
            if (r100 != Integer.MAX_VALUE) goto L7;
            return -1;
        L7:
            return r100 - getTotalBytesRead();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) ((((long) (this.totalBytesRead - this.startOffset)) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            if (((((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos) != this.totalBufferSize) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawVarint32() throws IOException {
            long r100 = this.currentByteBufferPos;
            if (this.currentByteBufferLimit == r100) goto L35;
            long r101 = r100 + 1;
            byte r102 = UnsafeUtil.getByte(r100);
            if (r102 < 0) goto L10;
            this.currentByteBufferPos++;
            return r102;
        L10:
            if ((this.currentByteBufferLimit - this.currentByteBufferPos) < 10) goto L35;
            long r103 = r101 + 1;
            int r104 = r102 ^ (UnsafeUtil.getByte(r101) << 7);
            if (r104 >= 0) goto L15;
            int r105 = r104 ^ a.f25611g;
        L36:
            this.currentByteBufferPos = r103;
            return r105;
        L15:
            long r106 = r103 + 1;
            int r107 = r104 ^ (UnsafeUtil.getByte(r103) << 14);
            if (r107 < 0) goto L19;
            r105 = r107 ^ 16256;
        L18:
            r103 = r106;
            goto L36
        L19:
            r103 = r106 + 1;
            int r108 = r107 ^ (UnsafeUtil.getByte(r106) << 21);
            if (r108 >= 0) goto L22;
            r105 = r108 ^ (-2080896);
            goto L36
        L22:
            r106 = r103 + 1;
            byte r109 = UnsafeUtil.getByte(r103);
            r105 = (r108 ^ (r109 << 28)) ^ 266354560;
            if (r109 >= 0) goto L18;
            r103 = r106 + 1;
            if (UnsafeUtil.getByte(r106) >= 0) goto L36;
            r106 = r103 + 1;
            if (UnsafeUtil.getByte(r103) >= 0) goto L18;
            r103 = r106 + 1;
            if (UnsafeUtil.getByte(r106) >= 0) goto L36;
            r106 = r103 + 1;
            if (UnsafeUtil.getByte(r103) >= 0) goto L18;
            r103 = r106 + 1;
            if (UnsafeUtil.getByte(r106) >= 0) goto L36;
        L35:
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            long r100 = this.currentByteBufferPos;
            if (this.currentByteBufferLimit == r100) goto L42;
            long r101 = r100 + 1;
            byte r102 = UnsafeUtil.getByte(r100);
            if (r102 < 0) goto L10;
            this.currentByteBufferPos++;
            return r102;
        L10:
            if ((this.currentByteBufferLimit - this.currentByteBufferPos) < 10) goto L42;
            long r103 = r101 + 1;
            int r104 = r102 ^ (UnsafeUtil.getByte(r101) << 7);
            if (r104 >= 0) goto L16;
            int r105 = r104 ^ a.f25611g;
        L15:
            long r106 = r105;
        L44:
            this.currentByteBufferPos = r103;
            return r106;
        L16:
            long r107 = r103 + 1;
            int r108 = r104 ^ (UnsafeUtil.getByte(r103) << 14);
            if (r108 < 0) goto L20;
            r106 = r108 ^ 16256;
        L19:
            r103 = r107;
            goto L44
        L20:
            r103 = r107 + 1;
            int r109 = r108 ^ (UnsafeUtil.getByte(r107) << 21);
            if (r109 >= 0) goto L23;
            r105 = r109 ^ (-2080896);
            goto L15
        L23:
            r107 = r103 + 1;
            long r110 = ((long) r109) ^ (((long) UnsafeUtil.getByte(r103)) << 28);
            if (r110 < 0) goto L27;
            long r111 = 266354560;
        L26:
            r106 = r110 ^ r111;
            goto L19
        L27:
            long r112 = r107 + 1;
            long r113 = r110 ^ (((long) UnsafeUtil.getByte(r107)) << 35);
            if (r113 >= 0) goto L31;
            long r114 = -34093383808L;
        L30:
            r106 = r113 ^ r114;
            r103 = r112;
            goto L44
        L31:
            r107 = r112 + 1;
            r110 = r113 ^ (((long) UnsafeUtil.getByte(r112)) << 42);
            if (r110 < 0) goto L34;
            r111 = 4363953127296L;
            goto L26
        L34:
            r112 = r107 + 1;
            r113 = r110 ^ (((long) UnsafeUtil.getByte(r107)) << 49);
            if (r113 >= 0) goto L37;
            r114 = -558586000294016L;
            goto L30
        L37:
            r107 = r112 + 1;
            r106 = (r113 ^ (((long) UnsafeUtil.getByte(r112)) << 56)) ^ 71499008037633920L;
            if (r106 >= 0) goto L19;
            long r115 = 1 + r107;
            if (UnsafeUtil.getByte(r107) < 0) goto L42;
            r103 = r115;
        L42:
            return readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64SlowPath() throws IOException {
            long r100 = 0;
            int r101 = 0;
        L4:
            if (r101 >= 64) goto L10;
            byte r102 = readRawByte();
            r100 = r100 | (((long) (r102 & ByteCompanionObject.MAX_VALUE)) << r101);
            if ((r102 & ByteCompanionObject.MIN_VALUE) == 0) goto L7;
            r101 = r101 + 7;
            goto L4
        L7:
            return r100;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startOffset = (int) ((((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            if (readRawVarint64() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int r100 = readRawVarint32();
            if (r100 <= 0) goto L14;
            long r101 = r100;
            if (r101 > currentRemaining()) goto L14;
            if (this.immutable == false) goto L9;
        L12:
            byte[] r102 = new byte[r100];
            UnsafeUtil.copyMemory(this.currentByteBufferPos, r102, 0, r101);
            this.currentByteBufferPos += r101;
            return ByteBuffer.wrap(r102);
        L9:
            if (this.enableAliasing == false) goto L12;
            long r103 = this.currentByteBufferPos + r101;
            this.currentByteBufferPos = r103;
            long r104 = this.currentAddress;
            return slice((int) ((r103 - r104) - r101), (int) (r103 - r104));
        L14:
            if (r100 > 0) goto L16;
        L19:
            if (r100 == 0) goto L21;
            if (r100 >= 0) goto L26;
            throw InvalidProtocolBufferException.negativeSize();
        L26:
            throw InvalidProtocolBufferException.truncatedMessage();
        L21:
            return Internal.EMPTY_BYTE_BUFFER;
        L16:
            if (r100 > remaining()) goto L19;
            byte[] r105 = new byte[r100];
            readRawBytesTo(r105, 0, r100);
            return ByteBuffer.wrap(r105);
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int r100 = readRawVarint32();
            if (r100 <= 0) goto L14;
            long r101 = r100;
            long r102 = this.currentByteBufferLimit;
            long r103 = this.currentByteBufferPos;
            if (r101 > (r102 - r103)) goto L14;
            if (this.immutable == true) goto L9;
        L12:
            byte[] r104 = new byte[r100];
            UnsafeUtil.copyMemory(r103, r104, 0, r101);
            this.currentByteBufferPos += r101;
            return ByteString.wrap(r104);
        L9:
            if (this.enableAliasing == false) goto L12;
            int r105 = (int) (r103 - this.currentAddress);
            ByteString r106 = ByteString.wrap(slice(r105, r100 + r105));
            this.currentByteBufferPos += r101;
            return r106;
        L14:
            if (r100 > 0) goto L16;
        L19:
            if (r100 == 0) goto L21;
            if (r100 >= 0) goto L26;
            throw InvalidProtocolBufferException.negativeSize();
        L26:
            throw InvalidProtocolBufferException.truncatedMessage();
        L21:
            return ByteString.EMPTY;
        L16:
            if (r100 > remaining()) goto L19;
            byte[] r107 = new byte[r100];
            readRawBytesTo(r107, 0, r100);
            return ByteString.wrap(r107);
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            if (currentRemaining() != 0) goto L5;
            getNextByteBuffer();
        L5:
            long r100 = this.currentByteBufferPos;
            this.currentByteBufferPos = 1 + r100;
            return UnsafeUtil.getByte(r100);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            if (currentRemaining() < 4) goto L7;
            long r100 = this.currentByteBufferPos;
            this.currentByteBufferPos = 4 + r100;
            int r101 = ((UnsafeUtil.getByte(r100) & UByte.MAX_VALUE) | ((UnsafeUtil.getByte(1 + r100) & UByte.MAX_VALUE) << 8)) | ((UnsafeUtil.getByte(2 + r100) & UByte.MAX_VALUE) << 16);
            return ((UnsafeUtil.getByte(r100 + 3) & UByte.MAX_VALUE) << 24) | r101;
        L7:
            return (((readRawByte() & UByte.MAX_VALUE) | ((readRawByte() & UByte.MAX_VALUE) << 8)) | ((readRawByte() & UByte.MAX_VALUE) << 16)) | ((readRawByte() & UByte.MAX_VALUE) << 24);
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            if (currentRemaining() < 8) goto L7;
            long r100 = this.currentByteBufferPos;
            this.currentByteBufferPos = 8 + r100;
            long r110 = (((long) UnsafeUtil.getByte(r100)) & 255) | ((((long) UnsafeUtil.getByte(1 + r100)) & 255) << 8);
            long r101 = ((((((((long) UnsafeUtil.getByte(2 + r100)) & 255) << 16) | r110) | ((((long) UnsafeUtil.getByte(3 + r100)) & 255) << 24)) | ((((long) UnsafeUtil.getByte(4 + r100)) & 255) << 32)) | ((((long) UnsafeUtil.getByte(5 + r100)) & 255) << 40)) | ((((long) UnsafeUtil.getByte(6 + r100)) & 255) << 48);
            return ((((long) UnsafeUtil.getByte(r100 + 7)) & 255) << 56) | r101;
        L7:
            return (((((((((long) readRawByte()) & 255) | ((((long) readRawByte()) & 255) << 8)) | ((((long) readRawByte()) & 255) << 16)) | ((((long) readRawByte()) & 255) << 24)) | ((((long) readRawByte()) & 255) << 32)) | ((((long) readRawByte()) & 255) << 40)) | ((((long) readRawByte()) & 255) << 48)) | ((((long) readRawByte()) & 255) << 56);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() throws IOException {
            int r100 = readRawVarint32();
            if (r100 <= 0) goto L8;
            long r101 = r100;
            long r102 = this.currentByteBufferLimit;
            long r103 = this.currentByteBufferPos;
            if (r101 > (r102 - r103)) goto L8;
            byte[] r104 = new byte[r100];
            UnsafeUtil.copyMemory(r103, r104, 0, r101);
            String r105 = new String(r104, Internal.UTF_8);
            this.currentByteBufferPos += r101;
            return r105;
        L8:
            if (r100 > 0) goto L10;
        L13:
            if (r100 != 0) goto L16;
            return "";
        L16:
            if (r100 >= 0) goto L20;
            throw InvalidProtocolBufferException.negativeSize();
        L20:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            if (r100 > remaining()) goto L13;
            byte[] r106 = new byte[r100];
            readRawBytesTo(r106, 0, r100);
            return new String(r106, Internal.UTF_8);
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int r100 = readRawVarint32();
            if (r100 <= 0) goto L12;
            long r101 = r100;
            long r102 = this.currentByteBufferLimit;
            long r103 = this.currentByteBufferPos;
            if (r101 > (r102 - r103)) goto L12;
            byte[] r104 = new byte[r100];
            UnsafeUtil.copyMemory(r103, r104, 0, r101);
            if (Utf8.isValidUtf8(r104) == false) goto L11;
            String r105 = new String(r104, Internal.UTF_8);
            this.currentByteBufferPos += r101;
            return r105;
        L11:
            throw InvalidProtocolBufferException.invalidUtf8();
        L12:
            if (r100 >= 0) goto L14;
        L21:
            if (r100 != 0) goto L24;
            return "";
        L24:
            if (r100 > 0) goto L28;
            throw InvalidProtocolBufferException.negativeSize();
        L28:
            throw InvalidProtocolBufferException.truncatedMessage();
        L14:
            if (r100 > remaining()) goto L21;
            byte[] r106 = new byte[r100];
            readRawBytesTo(r106, 0, r100);
            if (Utf8.isValidUtf8(r106) == false) goto L20;
            return new String(r106, Internal.UTF_8);
        L20:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd() == false) goto L6;
            this.lastTag = 0;
            return 0;
        L6:
            int r100 = readRawVarint32();
            this.lastTag = r100;
            if (WireFormat.getTagFieldNumber(r100) == 0) goto L11;
            return this.lastTag;
        L11:
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
        L2:
            int r100 = readTag();
            if (r100 == 0) goto L6;
            if (skipField(r100) == true) goto L2;
            return;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int r100) throws InvalidProtocolBufferException {
            if (this.lastTag != r100) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean r100) {
            this.enableAliasing = r100;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int r100) {
            this.currentLimit = r100;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int r100) throws InvalidProtocolBufferException {
            if (r100 < 0) goto L10;
            int r101 = r100 + getTotalBytesRead();
            int r102 = this.currentLimit;
            if (r101 > r102) goto L8;
            this.currentLimit = r101;
            recomputeBufferSizeAfterLimit();
            return r102;
        L8:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int r110) throws IOException {
            if (r110 < 0) goto L7;
            long r100 = r110;
            if (r100 > currentRemaining()) goto L7;
            byte[] r111 = new byte[r110];
            UnsafeUtil.copyMemory(this.currentByteBufferPos, r111, 0, r100);
            this.currentByteBufferPos += r100;
            return r111;
        L7:
            if (r110 >= 0) goto L9;
        L12:
            if (r110 > 0) goto L19;
            if (r110 != 0) goto L17;
            return Internal.EMPTY_BYTE_ARRAY;
        L17:
            throw InvalidProtocolBufferException.negativeSize();
        L19:
            throw InvalidProtocolBufferException.truncatedMessage();
        L9:
            if (r110 > remaining()) goto L12;
            byte[] r101 = new byte[r110];
            readRawBytesTo(r101, 0, r110);
            return r101;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r100) throws IOException {
            int r101 = WireFormat.getTagWireType(r100);
            if (r101 == 0) goto L24;
            if (r101 != 1) goto L6;
            skipRawBytes(8);
            return true;
        L6:
            if (r101 != 2) goto L8;
            skipRawBytes(readRawVarint32());
            return true;
        L8:
            if (r101 == 3) goto L18;
            if (r101 != 4) goto L11;
            return false;
        L11:
            if (r101 != 5) goto L15;
            skipRawBytes(4);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(r100), 4));
            return true;
        L24:
            skipRawVarint();
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream r100) throws IOException {
        L2:
            int r101 = readTag();
            if (r101 == 0) goto L6;
            if (skipField(r101, r100) == true) goto L2;
            return;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int r100) throws IOException {
            if (r100 >= 0) goto L4;
        L11:
            if (r100 >= 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (r100 > ((((long) (this.totalBufferSize - this.totalBytesRead)) - this.currentByteBufferPos) + this.currentByteBufferStartPos)) goto L11;
        L5:
            if (r100 <= 0) goto L10;
            if (currentRemaining() != 0) goto L9;
            getNextByteBuffer();
        L9:
            int r101 = Math.min(r100, (int) currentRemaining());
            r100 = r100 - r101;
            this.currentByteBufferPos += (long) r101;
            goto L5
        }

        private ByteBuffer slice(int r100, int r101) throws IOException {
            int r102 = this.currentByteBuffer.position();
            int r103 = this.currentByteBuffer.limit();
            this.currentByteBuffer.position(r100);     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            this.currentByteBuffer.limit(r101);     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            ByteBuffer r104 = this.currentByteBuffer.slice();     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            this.currentByteBuffer.position(r102);
            this.currentByteBuffer.limit(r103);
            return r104;
        L6:
            th = move-exception;
            this.currentByteBuffer.position(r102);
            this.currentByteBuffer.limit(r103);
            throw th;
        L9:
            throw InvalidProtocolBufferException.truncatedMessage();     // Catch: Throwable -> L6
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> r100, ExtensionRegistryLite r101) throws IOException {
            int r102 = readRawVarint32();
            if (this.recursionDepth >= this.recursionLimit) goto L7;
            int r103 = pushLimit(r102);
            this.recursionDepth++;
            T r104 = r100.parsePartialFrom(this, r101);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(r103);
            return r104;
        L7:
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readUnknownGroup(int r100, MessageLite.Builder r101) throws IOException {
            readGroup(r100, r101, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r100, CodedOutputStream r101) throws IOException {
            int r102 = WireFormat.getTagWireType(r100);
            if (r102 == 0) goto L24;
            if (r102 != 1) goto L6;
            long r103 = readRawLittleEndian64();
            r101.writeRawVarint32(r100);
            r101.writeFixed64NoTag(r103);
            return true;
        L6:
            if (r102 != 2) goto L8;
            ByteString r104 = readBytes();
            r101.writeRawVarint32(r100);
            r101.writeBytesNoTag(r104);
            return true;
        L8:
            if (r102 == 3) goto L18;
            if (r102 != 4) goto L11;
            return false;
        L11:
            if (r102 != 5) goto L15;
            int r105 = readRawLittleEndian32();
            r101.writeRawVarint32(r100);
            r101.writeFixed32NoTag(r105);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            r101.writeRawVarint32(r100);
            skipMessage(r101);
            int r106 = WireFormat.makeTag(WireFormat.getTagFieldNumber(r100), 4);
            checkLastTagWas(r106);
            r101.writeRawVarint32(r106);
            return true;
        L24:
            long r107 = readInt64();
            r101.writeRawVarint32(r100);
            r101.writeUInt64NoTag(r107);
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder r100, ExtensionRegistryLite r101) throws IOException {
            int r102 = readRawVarint32();
            if (this.recursionDepth >= this.recursionLimit) goto L7;
            int r103 = pushLimit(r102);
            this.recursionDepth++;
            r100.mergeFrom(this, r101);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(r103);
            return;
        L7:
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        private IterableDirectByteBufferDecoder(Iterable<ByteBuffer> r100, int r101, boolean r102) {
            super(null);
            this.currentLimit = Integer.MAX_VALUE;
            this.totalBufferSize = r101;
            this.input = r100;
            this.iterator = r100.iterator();
            this.immutable = r102;
            this.totalBytesRead = 0;
            this.startOffset = 0;
            if (r101 != 0) goto L5;
            this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
            this.currentByteBufferPos = 0;
            this.currentByteBufferStartPos = 0;
            this.currentByteBufferLimit = 0;
            this.currentAddress = 0;
            return;
        L5:
            tryGetNextByteBuffer();
        }

        private void readRawBytesTo(byte[] r110, int r111, int r112) throws IOException {
            if (r112 >= 0) goto L4;
        L12:
            if (r112 > 0) goto L18;
            if (r112 != 0) goto L16;
            return;
        L16:
            throw InvalidProtocolBufferException.negativeSize();
        L18:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (r112 > remaining()) goto L12;
            int r100 = r112;
        L6:
            if (r100 <= 0) goto L11;
            if (currentRemaining() != 0) goto L10;
            getNextByteBuffer();
        L10:
            int r101 = Math.min(r100, (int) currentRemaining());
            long r102 = r101;
            UnsafeUtil.copyMemory(this.currentByteBufferPos, r110, (r112 - r100) + r111, r102);
            r100 = r100 - r101;
            this.currentByteBufferPos += r102;
            goto L6
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int r100, Parser<T> r101, ExtensionRegistryLite r102) throws IOException {
            int r103 = this.recursionDepth;
            if (r103 >= this.recursionLimit) goto L7;
            this.recursionDepth = r103 + 1;
            T r104 = r101.parsePartialFrom(this, r102);
            checkLastTagWas(WireFormat.makeTag(r100, 4));
            this.recursionDepth--;
            return r104;
        L7:
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int r100, MessageLite.Builder r101, ExtensionRegistryLite r102) throws IOException {
            int r103 = this.recursionDepth;
            if (r103 >= this.recursionLimit) goto L7;
            this.recursionDepth = r103 + 1;
            r101.mergeFrom(this, r102);
            checkLastTagWas(WireFormat.makeTag(r100, 4));
            this.recursionDepth--;
            return;
        L7:
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        public /* synthetic */ IterableDirectByteBufferDecoder(Iterable r100, int r101, boolean r102, AnonymousClass1 r103) {
            this(r100, r101, r102);
        }
    }

    public static final class StreamDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSize;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private final InputStream input;
        private int lastTag;
        private int pos;
        private RefillCallback refillCallback;
        private int totalBytesRetired;

        public interface RefillCallback {
            void onRefill();
        }

        public class SkippedDataSink implements RefillCallback {
            private ByteArrayOutputStream byteArrayStream;
            private int lastPos;
            final /* synthetic */ StreamDecoder this$0;

            public ByteBuffer getSkippedData() {
                ByteArrayOutputStream r100 = this.byteArrayStream;
                if (r100 == null) goto L5;
                r100.write(StreamDecoder.access$600(this.this$0), this.lastPos, StreamDecoder.access$500(this.this$0));
                return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
            L5:
                return ByteBuffer.wrap(StreamDecoder.access$600(this.this$0), this.lastPos, StreamDecoder.access$500(this.this$0) - this.lastPos);
            }

            @Override // com.google.protobuf.CodedInputStream.StreamDecoder.RefillCallback
            public void onRefill() {
                if (this.byteArrayStream != null) goto L5;
                this.byteArrayStream = new ByteArrayOutputStream();
            L5:
                this.byteArrayStream.write(StreamDecoder.access$600(this.this$0), this.lastPos, StreamDecoder.access$500(this.this$0) - this.lastPos);
                this.lastPos = 0;
            }

            private SkippedDataSink(StreamDecoder r100) {
                this.this$0 = r100;
                this.lastPos = StreamDecoder.access$500(r100);
            }
        }

        private void skipRawVarintFastPath() throws IOException {
            int r100 = 0;
        L4:
            if (r100 >= 10) goto L10;
            byte[] r101 = this.buffer;
            int r102 = this.pos;
            this.pos = r102 + 1;
            if (r101[r102] >= 0) goto L7;
            r100 = r100 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            int r100 = 0;
        L4:
            if (r100 >= 10) goto L10;
            if (readRawByte() >= 0) goto L7;
            r100 = r100 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean r100) {
        }

        private void recomputeBufferSizeAfterLimit() {
            int r100 = this.bufferSize + this.bufferSizeAfterLimit;
            this.bufferSize = r100;
            int r101 = this.totalBytesRetired + r100;
            int r102 = this.currentLimit;
            if (r101 <= r102) goto L5;
            int r103 = r101 - r102;
            this.bufferSizeAfterLimit = r103;
            this.bufferSize = r100 - r103;
            return;
        L5:
            this.bufferSizeAfterLimit = 0;
        }

        private void skipRawVarint() throws IOException {
            if ((this.bufferSize - this.pos) < 10) goto L5;
            skipRawVarintFastPath();
            return;
        L5:
            skipRawVarintSlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int r100 = this.currentLimit;
            if (r100 != Integer.MAX_VALUE) goto L7;
            return -1;
        L7:
            return r100 - (this.totalBytesRetired + this.pos);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.totalBytesRetired + this.pos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            if (this.pos == this.bufferSize) goto L5;
        L7:
            return false;
        L5:
            if (tryRefillBuffer(1) == true) goto L7;
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            if (this.pos != this.bufferSize) goto L5;
            refillBuffer(1);
        L5:
            byte[] r100 = this.buffer;
            int r101 = this.pos;
            this.pos = r101 + 1;
            return r100[r101];
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            int r100 = this.pos;
            if ((this.bufferSize - r100) >= 4) goto L5;
            refillBuffer(4);
            r100 = this.pos;
        L5:
            byte[] r101 = this.buffer;
            this.pos = r100 + 4;
            int r102 = ((r101[r100] & UByte.MAX_VALUE) | ((r101[r100 + 1] & UByte.MAX_VALUE) << 8)) | ((r101[r100 + 2] & UByte.MAX_VALUE) << 16);
            return ((r101[r100 + 3] & UByte.MAX_VALUE) << 24) | r102;
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            int r100 = this.pos;
            if ((this.bufferSize - r100) >= 8) goto L5;
            refillBuffer(8);
            r100 = this.pos;
        L5:
            byte[] r101 = this.buffer;
            this.pos = r100 + 8;
            long r102 = ((((((((long) r101[r100]) & 255) | ((((long) r101[r100 + 1]) & 255) << 8)) | ((((long) r101[r100 + 2]) & 255) << 16)) | ((((long) r101[r100 + 3]) & 255) << 24)) | ((((long) r101[r100 + 4]) & 255) << 32)) | ((((long) r101[r100 + 5]) & 255) << 40)) | ((((long) r101[r100 + 6]) & 255) << 48);
            return ((((long) r101[r100 + 7]) & 255) << 56) | r102;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawVarint32() throws IOException {
            int r100 = this.pos;
            int r101 = this.bufferSize;
            if (r101 == r100) goto L35;
            byte[] r102 = this.buffer;
            int r103 = r100 + 1;
            byte r104 = r102[r100];
            if (r104 < 0) goto L10;
            this.pos = r103;
            return r104;
        L10:
            if ((r101 - r103) < 9) goto L35;
            int r105 = r103 + 1;
            int r106 = r104 ^ (r102[r103] << 7);
            if (r106 >= 0) goto L15;
            int r107 = r106 ^ a.f25611g;
        L36:
            this.pos = r105;
            return r107;
        L15:
            int r108 = r105 + 1;
            int r109 = r106 ^ (r102[r105] << 14);
            if (r109 < 0) goto L19;
            r107 = r109 ^ 16256;
        L18:
            r105 = r108;
            goto L36
        L19:
            r105 = r108 + 1;
            int r110 = r109 ^ (r102[r108] << 21);
            if (r110 >= 0) goto L22;
            r107 = r110 ^ (-2080896);
            goto L36
        L22:
            r108 = r105 + 1;
            byte r111 = r102[r105];
            r107 = (r110 ^ (r111 << 28)) ^ 266354560;
            if (r111 >= 0) goto L18;
            r105 = r108 + 1;
            if (r102[r108] >= 0) goto L36;
            r108 = r105 + 1;
            if (r102[r105] >= 0) goto L18;
            r105 = r108 + 1;
            if (r102[r108] >= 0) goto L36;
            r108 = r105 + 1;
            if (r102[r105] >= 0) goto L18;
            r105 = r108 + 1;
            if (r102[r108] >= 0) goto L36;
        L35:
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            int r100 = this.pos;
            int r101 = this.bufferSize;
            if (r101 == r100) goto L41;
            byte[] r102 = this.buffer;
            int r103 = r100 + 1;
            byte r104 = r102[r100];
            if (r104 < 0) goto L10;
            this.pos = r103;
            return r104;
        L10:
            if ((r101 - r103) < 9) goto L41;
            int r105 = r103 + 1;
            int r106 = r104 ^ (r102[r103] << 7);
            if (r106 >= 0) goto L16;
            int r107 = r106 ^ a.f25611g;
        L15:
            long r108 = r107;
        L44:
            this.pos = r105;
            return r108;
        L16:
            int r109 = r105 + 1;
            int r110 = r106 ^ (r102[r105] << 14);
            if (r110 < 0) goto L19;
            r105 = r109;
            r108 = r110 ^ 16256;
            goto L44
        L19:
            r105 = r109 + 1;
            int r111 = r110 ^ (r102[r109] << 21);
            if (r111 >= 0) goto L22;
            r107 = r111 ^ (-2080896);
            goto L15
        L22:
            long r112 = r111;
            int r113 = r105 + 1;
            long r114 = r112 ^ (((long) r102[r105]) << 28);
            if (r114 < 0) goto L26;
            long r115 = 266354560;
        L25:
            r108 = r114 ^ r115;
            r105 = r113;
            goto L44
        L26:
            r105 = r113 + 1;
            long r116 = r114 ^ (((long) r102[r113]) << 35);
            if (r116 >= 0) goto L30;
            long r117 = -34093383808L;
        L29:
            r108 = r116 ^ r117;
            goto L44
        L30:
            r113 = r105 + 1;
            r114 = r116 ^ (((long) r102[r105]) << 42);
            if (r114 < 0) goto L33;
            r115 = 4363953127296L;
            goto L25
        L33:
            r105 = r113 + 1;
            r116 = r114 ^ (((long) r102[r113]) << 49);
            if (r116 >= 0) goto L36;
            r117 = -558586000294016L;
            goto L29
        L36:
            int r118 = r105 + 1;
            long r119 = (r116 ^ (((long) r102[r105]) << 56)) ^ 71499008037633920L;
            if (r119 >= 0) goto L42;
            r105 = r118 + 1;
            if (r102[r118] < 0) goto L41;
        L43:
            r108 = r119;
            goto L44
        L42:
            r105 = r118;
        L41:
            return readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64SlowPath() throws IOException {
            long r100 = 0;
            int r101 = 0;
        L4:
            if (r101 >= 64) goto L10;
            byte r102 = readRawByte();
            r100 = r100 | (((long) (r102 & ByteCompanionObject.MAX_VALUE)) << r101);
            if ((r102 & ByteCompanionObject.MIN_VALUE) == 0) goto L7;
            r101 = r101 + 7;
            goto L4
        L7:
            return r100;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.totalBytesRetired = -this.pos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            if (readRawVarint64() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            int r100 = readRawVarint32();
            int r101 = this.bufferSize;
            int r102 = this.pos;
            if (r100 > (r101 - r102)) goto L8;
            if (r100 <= 0) goto L8;
            byte[] r103 = Arrays.copyOfRange(this.buffer, r102, r102 + r100);
            this.pos += r100;
            return r103;
        L8:
            return readRawBytesSlowPath(r100);
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int r100 = readRawVarint32();
            int r101 = this.bufferSize;
            int r102 = this.pos;
            if (r100 > (r101 - r102)) goto L7;
            if (r100 <= 0) goto L7;
            ByteBuffer r103 = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, r102, r102 + r100));
            this.pos += r100;
            return r103;
        L7:
            if (r100 != 0) goto L11;
            return Internal.EMPTY_BYTE_BUFFER;
        L11:
            return ByteBuffer.wrap(readRawBytesSlowPath(r100));
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int r100 = readRawVarint32();
            int r101 = this.bufferSize;
            int r102 = this.pos;
            if (r100 > (r101 - r102)) goto L7;
            if (r100 <= 0) goto L7;
            ByteString r103 = ByteString.copyFrom(this.buffer, r102, r100);
            this.pos += r100;
            return r103;
        L7:
            if (r100 != 0) goto L11;
            return ByteString.EMPTY;
        L11:
            return readBytesSlowPath(r100);
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() throws IOException {
            int r100 = readRawVarint32();
            if (r100 <= 0) goto L8;
            int r101 = this.bufferSize;
            int r102 = this.pos;
            if (r100 > (r101 - r102)) goto L8;
            String r103 = new String(this.buffer, r102, r100, Internal.UTF_8);
            this.pos += r100;
            return r103;
        L8:
            if (r100 != 0) goto L12;
            return "";
        L12:
            if (r100 > this.bufferSize) goto L16;
            refillBuffer(r100);
            String r104 = new String(this.buffer, this.pos, r100, Internal.UTF_8);
            this.pos += r100;
            return r104;
        L16:
            return new String(readRawBytesSlowPath(r100), Internal.UTF_8);
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int r100 = readRawVarint32();
            int r101 = this.pos;
            int r102 = this.bufferSize;
            if (r100 > (r102 - r101)) goto L6;
            if (r100 <= 0) goto L6;
            byte[] r103 = this.buffer;
            this.pos = r101 + r100;
        L14:
            if (Utf8.isValidUtf8(r103, r101, r101 + r100) == false) goto L18;
            return new String(r103, r101, r100, Internal.UTF_8);
        L18:
            throw InvalidProtocolBufferException.invalidUtf8();
        L6:
            if (r100 != 0) goto L9;
            return "";
        L9:
            r101 = 0;
            if (r100 > r102) goto L12;
            refillBuffer(r100);
            r103 = this.buffer;
            this.pos = r100 + 0;
            goto L14
        L12:
            r103 = readRawBytesSlowPath(r100);
            goto L14
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd() == false) goto L6;
            this.lastTag = 0;
            return 0;
        L6:
            int r100 = readRawVarint32();
            this.lastTag = r100;
            if (WireFormat.getTagFieldNumber(r100) == 0) goto L11;
            return this.lastTag;
        L11:
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
        L2:
            int r100 = readTag();
            if (r100 == 0) goto L6;
            if (skipField(r100) == true) goto L2;
            return;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        public static /* synthetic */ int access$500(StreamDecoder r100) {
            return r100.pos;
        }

        public static /* synthetic */ byte[] access$600(StreamDecoder r100) {
            return r100.buffer;
        }

        private ByteString readBytesSlowPath(int r100) throws IOException {
            byte[] r101 = readRawBytesSlowPathOneChunk(r100);
            if (r101 != null) goto L5;
            int r102 = this.pos;
            int r103 = this.bufferSize;
            int r104 = r103 - r102;
            this.totalBytesRetired += r103;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> r105 = readRawBytesSlowPathRemainingChunks(r100 - r104);
            ArrayList r106 = new ArrayList(r105.size() + 1);
            r106.add(ByteString.copyFrom(this.buffer, r102, r104));
            Iterator<byte[]> r107 = r105.iterator();
        L8:
            if (r107.hasNext() == false) goto L11;
            r106.add(ByteString.wrap(r107.next()));
            goto L8
        L11:
            return ByteString.copyFrom(r106);
        L5:
            return ByteString.wrap(r101);
        }

        private byte[] readRawBytesSlowPath(int r100) throws IOException {
            byte[] r101 = readRawBytesSlowPathOneChunk(r100);
            if (r101 == null) goto L5;
            return r101;
        L5:
            int r102 = this.pos;
            int r103 = this.bufferSize;
            int r104 = r103 - r102;
            this.totalBytesRetired += r103;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> r105 = readRawBytesSlowPathRemainingChunks(r100 - r104);
            byte[] r106 = new byte[r100];
            System.arraycopy(this.buffer, r102, r106, 0, r104);
            Iterator<byte[]> r107 = r105.iterator();
        L7:
            if (r107.hasNext() == false) goto L9;
            byte[] r108 = r107.next();
            System.arraycopy(r108, 0, r106, r104, r108.length);
            r104 = r104 + r108.length;
            goto L7
        L9:
            return r106;
        }

        private byte[] readRawBytesSlowPathOneChunk(int r100) throws IOException {
            if (r100 == 0) goto L4;
            if (r100 < 0) goto L30;
            int r101 = this.totalBytesRetired;
            int r102 = this.pos;
            int r103 = (r101 + r102) + r100;
            if ((r103 - this.sizeLimit) > 0) goto L28;
            int r104 = this.currentLimit;
            if (r103 > r104) goto L25;
            int r105 = this.bufferSize - r102;
            int r106 = r100 - r105;
            if (r106 >= 4096) goto L13;
        L17:
            byte[] r107 = new byte[r100];
            System.arraycopy(this.buffer, this.pos, r107, 0, r105);
            this.totalBytesRetired += this.bufferSize;
            this.pos = 0;
            this.bufferSize = 0;
        L18:
            if (r105 >= r100) goto L24;
            int r108 = this.input.read(r107, r105, r100 - r105);
            if (r108 == (-1)) goto L23;
            this.totalBytesRetired += r108;
            r105 = r105 + r108;
            goto L18
        L23:
            throw InvalidProtocolBufferException.truncatedMessage();
        L24:
            return r107;
        L13:
            if (r106 <= this.input.available()) goto L17;
            return null;
        L25:
            skipRawBytes((r104 - r101) - r102);
            throw InvalidProtocolBufferException.truncatedMessage();
        L28:
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        L30:
            throw InvalidProtocolBufferException.negativeSize();
        L4:
            return Internal.EMPTY_BYTE_ARRAY;
        }

        private List<byte[]> readRawBytesSlowPathRemainingChunks(int r100) throws IOException {
            ArrayList r101 = new ArrayList();
        L3:
            if (r100 <= 0) goto L12;
            int r102 = Math.min(r100, 4096);
            byte[] r103 = new byte[r102];
            int r104 = 0;
        L5:
            if (r104 >= r102) goto L11;
            int r105 = this.input.read(r103, r104, r102 - r104);
            if (r105 == (-1)) goto L10;
            this.totalBytesRetired += r105;
            r104 = r104 + r105;
            goto L5
        L10:
            throw InvalidProtocolBufferException.truncatedMessage();
        L11:
            r100 = r100 - r102;
            r101.add(r103);
            goto L3
        L12:
            return r101;
        }

        private void refillBuffer(int r100) throws IOException {
            if (tryRefillBuffer(r100) == false) goto L5;
            return;
        L5:
            if (r100 <= ((this.sizeLimit - this.totalBytesRetired) - this.pos)) goto L9;
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        L9:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private void skipRawBytesSlowPath(int r100) throws IOException {
            if (r100 < 0) goto L14;
            int r101 = this.totalBytesRetired;
            int r102 = this.pos;
            int r103 = (r101 + r102) + r100;
            int r104 = this.currentLimit;
            if (r103 > r104) goto L11;
            int r105 = this.bufferSize;
            int r106 = r105 - r102;
            this.pos = r105;
            refillBuffer(1);
        L6:
            int r107 = r100 - r106;
            int r108 = this.bufferSize;
            if (r107 <= r108) goto L9;
            r106 = r106 + r108;
            this.pos = r108;
            refillBuffer(1);
            goto L6
        L9:
            this.pos = r107;
            return;
        L11:
            skipRawBytes((r104 - r101) - r102);
            throw InvalidProtocolBufferException.truncatedMessage();
        L14:
            throw InvalidProtocolBufferException.negativeSize();
        }

        private boolean tryRefillBuffer(int r100) throws IOException {
            int r101 = this.pos;
            if ((r101 + r100) <= this.bufferSize) goto L35;
            int r102 = this.sizeLimit;
            int r103 = this.totalBytesRetired;
            if (r100 <= ((r102 - r103) - r101)) goto L8;
            return false;
        L8:
            if (((r103 + r101) + r100) <= this.currentLimit) goto L10;
            return false;
        L10:
            RefillCallback r104 = this.refillCallback;
            if (r104 == null) goto L13;
            r104.onRefill();
        L13:
            int r105 = this.pos;
            if (r105 <= 0) goto L19;
            int r106 = this.bufferSize;
            if (r106 <= r105) goto L18;
            byte[] r107 = this.buffer;
            System.arraycopy(r107, r105, r107, 0, r106 - r105);
        L18:
            this.totalBytesRetired += r105;
            this.bufferSize -= r105;
            this.pos = 0;
        L19:
            InputStream r108 = this.input;
            byte[] r109 = this.buffer;
            int r110 = this.bufferSize;
            int r111 = r108.read(r109, r110, Math.min(r109.length - r110, (this.sizeLimit - this.totalBytesRetired) - r110));
            if (r111 == 0) goto L33;
            if (r111 < (-1)) goto L33;
            if (r111 > this.buffer.length) goto L33;
            if (r111 <= 0) goto L31;
            this.bufferSize += r111;
            recomputeBufferSizeAfterLimit();
            if (this.bufferSize < r100) goto L30;
            return true;
        L30:
            return tryRefillBuffer(r100);
        L31:
            return false;
        L33:
            throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + r111 + "\nThe InputStream implementation is buggy.");
        L35:
            throw new IllegalStateException("refillBuffer() called when " + r100 + " bytes were already available in buffer");
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int r100) throws InvalidProtocolBufferException {
            if (this.lastTag != r100) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int r100) {
            this.currentLimit = r100;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int r100) throws InvalidProtocolBufferException {
            if (r100 < 0) goto L10;
            int r101 = r100 + (this.totalBytesRetired + this.pos);
            int r102 = this.currentLimit;
            if (r101 > r102) goto L8;
            this.currentLimit = r101;
            recomputeBufferSizeAfterLimit();
            return r102;
        L8:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int r100) throws IOException {
            int r101 = this.pos;
            if (r100 > (this.bufferSize - r101)) goto L8;
            if (r100 <= 0) goto L8;
            int r102 = r100 + r101;
            this.pos = r102;
            return Arrays.copyOfRange(this.buffer, r101, r102);
        L8:
            return readRawBytesSlowPath(r100);
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r100) throws IOException {
            int r101 = WireFormat.getTagWireType(r100);
            if (r101 == 0) goto L24;
            if (r101 != 1) goto L6;
            skipRawBytes(8);
            return true;
        L6:
            if (r101 != 2) goto L8;
            skipRawBytes(readRawVarint32());
            return true;
        L8:
            if (r101 == 3) goto L18;
            if (r101 != 4) goto L11;
            return false;
        L11:
            if (r101 != 5) goto L15;
            skipRawBytes(4);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(r100), 4));
            return true;
        L24:
            skipRawVarint();
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream r100) throws IOException {
        L2:
            int r101 = readTag();
            if (r101 == 0) goto L6;
            if (skipField(r101, r100) == true) goto L2;
            return;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int r100) throws IOException {
            int r101 = this.bufferSize;
            int r102 = this.pos;
            if (r100 > (r101 - r102)) goto L6;
            if (r100 < 0) goto L6;
            this.pos = r102 + r100;
            return;
        L6:
            skipRawBytesSlowPath(r100);
        }

        private StreamDecoder(InputStream r100, int r101) {
            super(null);
            this.currentLimit = Integer.MAX_VALUE;
            this.refillCallback = null;
            Internal.checkNotNull(r100, "input");
            this.input = r100;
            this.buffer = new byte[r101];
            this.bufferSize = 0;
            this.pos = 0;
            this.totalBytesRetired = 0;
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> r100, ExtensionRegistryLite r101) throws IOException {
            int r102 = readRawVarint32();
            if (this.recursionDepth >= this.recursionLimit) goto L7;
            int r103 = pushLimit(r102);
            this.recursionDepth++;
            T r104 = r100.parsePartialFrom(this, r101);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(r103);
            return r104;
        L7:
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readUnknownGroup(int r100, MessageLite.Builder r101) throws IOException {
            readGroup(r100, r101, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r100, CodedOutputStream r101) throws IOException {
            int r102 = WireFormat.getTagWireType(r100);
            if (r102 == 0) goto L24;
            if (r102 != 1) goto L6;
            long r103 = readRawLittleEndian64();
            r101.writeRawVarint32(r100);
            r101.writeFixed64NoTag(r103);
            return true;
        L6:
            if (r102 != 2) goto L8;
            ByteString r104 = readBytes();
            r101.writeRawVarint32(r100);
            r101.writeBytesNoTag(r104);
            return true;
        L8:
            if (r102 == 3) goto L18;
            if (r102 != 4) goto L11;
            return false;
        L11:
            if (r102 != 5) goto L15;
            int r105 = readRawLittleEndian32();
            r101.writeRawVarint32(r100);
            r101.writeFixed32NoTag(r105);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            r101.writeRawVarint32(r100);
            skipMessage(r101);
            int r106 = WireFormat.makeTag(WireFormat.getTagFieldNumber(r100), 4);
            checkLastTagWas(r106);
            r101.writeRawVarint32(r106);
            return true;
        L24:
            long r107 = readInt64();
            r101.writeRawVarint32(r100);
            r101.writeUInt64NoTag(r107);
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder r100, ExtensionRegistryLite r101) throws IOException {
            int r102 = readRawVarint32();
            if (this.recursionDepth >= this.recursionLimit) goto L7;
            int r103 = pushLimit(r102);
            this.recursionDepth++;
            r100.mergeFrom(this, r101);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(r103);
            return;
        L7:
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        public /* synthetic */ StreamDecoder(InputStream r100, int r101, AnonymousClass1 r102) {
            this(r100, r101);
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int r100, Parser<T> r101, ExtensionRegistryLite r102) throws IOException {
            int r103 = this.recursionDepth;
            if (r103 >= this.recursionLimit) goto L7;
            this.recursionDepth = r103 + 1;
            T r104 = r101.parsePartialFrom(this, r102);
            checkLastTagWas(WireFormat.makeTag(r100, 4));
            this.recursionDepth--;
            return r104;
        L7:
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int r100, MessageLite.Builder r101, ExtensionRegistryLite r102) throws IOException {
            int r103 = this.recursionDepth;
            if (r103 >= this.recursionLimit) goto L7;
            this.recursionDepth = r103 + 1;
            r101.mergeFrom(this, r102);
            checkLastTagWas(WireFormat.makeTag(r100, 4));
            this.recursionDepth--;
            return;
        L7:
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
    }

    public static final class UnsafeDirectNioDecoder extends CodedInputStream {
        private final long address;
        private final ByteBuffer buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private long limit;
        private long pos;
        private long startPos;

        private void skipRawVarintFastPath() throws IOException {
            int r100 = 0;
        L4:
            if (r100 >= 10) goto L10;
            long r101 = this.pos;
            this.pos = 1 + r101;
            if (UnsafeUtil.getByte(r101) >= 0) goto L7;
            r100 = r100 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            int r100 = 0;
        L4:
            if (r100 >= 10) goto L10;
            if (readRawByte() >= 0) goto L7;
            r100 = r100 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void recomputeBufferSizeAfterLimit() {
            long r100 = this.limit + ((long) this.bufferSizeAfterLimit);
            this.limit = r100;
            int r101 = (int) (r100 - this.startPos);
            int r102 = this.currentLimit;
            if (r101 <= r102) goto L5;
            int r103 = r101 - r102;
            this.bufferSizeAfterLimit = r103;
            this.limit = r100 - ((long) r103);
            return;
        L5:
            this.bufferSizeAfterLimit = 0;
        }

        private int remaining() {
            return (int) (this.limit - this.pos);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int r100 = this.currentLimit;
            if (r100 != Integer.MAX_VALUE) goto L7;
            return -1;
        L7:
            return r100 - getTotalBytesRead();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) (this.pos - this.startPos);
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            if (this.pos != this.limit) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            long r100 = this.pos;
            if (r100 == this.limit) goto L7;
            this.pos = 1 + r100;
            return UnsafeUtil.getByte(r100);
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            long r100 = this.pos;
            if ((this.limit - r100) < 4) goto L7;
            this.pos = 4 + r100;
            int r101 = ((UnsafeUtil.getByte(r100) & UByte.MAX_VALUE) | ((UnsafeUtil.getByte(1 + r100) & UByte.MAX_VALUE) << 8)) | ((UnsafeUtil.getByte(2 + r100) & UByte.MAX_VALUE) << 16);
            return ((UnsafeUtil.getByte(r100 + 3) & UByte.MAX_VALUE) << 24) | r101;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            long r100 = this.pos;
            if ((this.limit - r100) < 8) goto L7;
            this.pos = 8 + r100;
            long r101 = ((((((((long) UnsafeUtil.getByte(r100)) & 255) | ((((long) UnsafeUtil.getByte(1 + r100)) & 255) << 8)) | ((((long) UnsafeUtil.getByte(2 + r100)) & 255) << 16)) | ((((long) UnsafeUtil.getByte(3 + r100)) & 255) << 24)) | ((((long) UnsafeUtil.getByte(4 + r100)) & 255) << 32)) | ((((long) UnsafeUtil.getByte(5 + r100)) & 255) << 40)) | ((((long) UnsafeUtil.getByte(6 + r100)) & 255) << 48);
            return ((((long) UnsafeUtil.getByte(r100 + 7)) & 255) << 56) | r101;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawVarint32() throws IOException {
            long r100 = this.pos;
            if (this.limit == r100) goto L35;
            long r101 = r100 + 1;
            byte r102 = UnsafeUtil.getByte(r100);
            if (r102 < 0) goto L10;
            this.pos = r101;
            return r102;
        L10:
            if ((this.limit - r101) < 9) goto L35;
            long r103 = r101 + 1;
            int r104 = r102 ^ (UnsafeUtil.getByte(r101) << 7);
            if (r104 >= 0) goto L15;
            int r105 = r104 ^ a.f25611g;
        L36:
            this.pos = r103;
            return r105;
        L15:
            long r106 = r103 + 1;
            int r107 = r104 ^ (UnsafeUtil.getByte(r103) << 14);
            if (r107 < 0) goto L19;
            r105 = r107 ^ 16256;
        L18:
            r103 = r106;
            goto L36
        L19:
            r103 = r106 + 1;
            int r108 = r107 ^ (UnsafeUtil.getByte(r106) << 21);
            if (r108 >= 0) goto L22;
            r105 = r108 ^ (-2080896);
            goto L36
        L22:
            r106 = r103 + 1;
            byte r109 = UnsafeUtil.getByte(r103);
            r105 = (r108 ^ (r109 << 28)) ^ 266354560;
            if (r109 >= 0) goto L18;
            r103 = r106 + 1;
            if (UnsafeUtil.getByte(r106) >= 0) goto L36;
            r106 = r103 + 1;
            if (UnsafeUtil.getByte(r103) >= 0) goto L18;
            r103 = r106 + 1;
            if (UnsafeUtil.getByte(r106) >= 0) goto L36;
            r106 = r103 + 1;
            if (UnsafeUtil.getByte(r103) >= 0) goto L18;
            r103 = r106 + 1;
            if (UnsafeUtil.getByte(r106) >= 0) goto L36;
        L35:
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            long r100 = this.pos;
            if (this.limit == r100) goto L42;
            long r101 = r100 + 1;
            byte r102 = UnsafeUtil.getByte(r100);
            if (r102 < 0) goto L10;
            this.pos = r101;
            return r102;
        L10:
            if ((this.limit - r101) < 9) goto L42;
            long r103 = r101 + 1;
            int r104 = r102 ^ (UnsafeUtil.getByte(r101) << 7);
            if (r104 >= 0) goto L16;
            int r105 = r104 ^ a.f25611g;
        L15:
            long r106 = r105;
        L44:
            this.pos = r103;
            return r106;
        L16:
            long r107 = r103 + 1;
            int r108 = r104 ^ (UnsafeUtil.getByte(r103) << 14);
            if (r108 < 0) goto L20;
            r106 = r108 ^ 16256;
        L19:
            r103 = r107;
            goto L44
        L20:
            r103 = r107 + 1;
            int r109 = r108 ^ (UnsafeUtil.getByte(r107) << 21);
            if (r109 >= 0) goto L23;
            r105 = r109 ^ (-2080896);
            goto L15
        L23:
            r107 = r103 + 1;
            long r110 = ((long) r109) ^ (((long) UnsafeUtil.getByte(r103)) << 28);
            if (r110 < 0) goto L27;
            long r111 = 266354560;
        L26:
            r106 = r110 ^ r111;
            goto L19
        L27:
            long r112 = r107 + 1;
            long r113 = r110 ^ (((long) UnsafeUtil.getByte(r107)) << 35);
            if (r113 >= 0) goto L31;
            long r114 = -34093383808L;
        L30:
            r106 = r113 ^ r114;
            r103 = r112;
            goto L44
        L31:
            r107 = r112 + 1;
            r110 = r113 ^ (((long) UnsafeUtil.getByte(r112)) << 42);
            if (r110 < 0) goto L34;
            r111 = 4363953127296L;
            goto L26
        L34:
            r112 = r107 + 1;
            r113 = r110 ^ (((long) UnsafeUtil.getByte(r107)) << 49);
            if (r113 >= 0) goto L37;
            r114 = -558586000294016L;
            goto L30
        L37:
            r107 = r112 + 1;
            r106 = (r113 ^ (((long) UnsafeUtil.getByte(r112)) << 56)) ^ 71499008037633920L;
            if (r106 >= 0) goto L19;
            long r115 = 1 + r107;
            if (UnsafeUtil.getByte(r107) < 0) goto L42;
            r103 = r115;
        L42:
            return readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64SlowPath() throws IOException {
            long r100 = 0;
            int r101 = 0;
        L4:
            if (r101 >= 64) goto L10;
            byte r102 = readRawByte();
            r100 = r100 | (((long) (r102 & ByteCompanionObject.MAX_VALUE)) << r101);
            if ((r102 & ByteCompanionObject.MIN_VALUE) == 0) goto L7;
            r101 = r101 + 7;
            goto L4
        L7:
            return r100;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void skipRawVarint() throws IOException {
            if (remaining() < 10) goto L5;
            skipRawVarintFastPath();
            return;
        L5:
            skipRawVarintSlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            if (readRawVarint64() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int r100 = readRawVarint32();
            if (r100 > 0) goto L5;
        L14:
            if (r100 == 0) goto L16;
            if (r100 >= 0) goto L21;
            throw InvalidProtocolBufferException.negativeSize();
        L21:
            throw InvalidProtocolBufferException.truncatedMessage();
        L16:
            return Internal.EMPTY_BYTE_BUFFER;
        L5:
            if (r100 > remaining()) goto L14;
            if (this.immutable == false) goto L9;
        L12:
            byte[] r101 = new byte[r100];
            long r110 = r100;
            UnsafeUtil.copyMemory(this.pos, r101, 0, r110);
            this.pos += r110;
            return ByteBuffer.wrap(r101);
        L9:
            if (this.enableAliasing == false) goto L12;
            long r102 = this.pos;
            long r103 = r100;
            ByteBuffer r104 = slice(r102, r102 + r103);
            this.pos += r103;
            return r104;
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int r100 = readRawVarint32();
            if (r100 > 0) goto L5;
        L14:
            if (r100 == 0) goto L16;
            if (r100 >= 0) goto L21;
            throw InvalidProtocolBufferException.negativeSize();
        L21:
            throw InvalidProtocolBufferException.truncatedMessage();
        L16:
            return ByteString.EMPTY;
        L5:
            if (r100 > remaining()) goto L14;
            if (this.immutable == true) goto L9;
        L12:
            byte[] r101 = new byte[r100];
            long r102 = r100;
            UnsafeUtil.copyMemory(this.pos, r101, 0, r102);
            this.pos += r102;
            return ByteString.wrap(r101);
        L9:
            if (this.enableAliasing == false) goto L12;
            long r103 = this.pos;
            long r104 = r100;
            ByteBuffer r105 = slice(r103, r103 + r104);
            this.pos += r104;
            return ByteString.wrap(r105);
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() throws IOException {
            int r100 = readRawVarint32();
            if (r100 > 0) goto L5;
        L8:
            if (r100 != 0) goto L11;
            return "";
        L11:
            if (r100 >= 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        L5:
            if (r100 > remaining()) goto L8;
            byte[] r101 = new byte[r100];
            long r102 = r100;
            UnsafeUtil.copyMemory(this.pos, r101, 0, r102);
            String r103 = new String(r101, Internal.UTF_8);
            this.pos += r102;
            return r103;
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int r100 = readRawVarint32();
            if (r100 >= 0) goto L5;
        L12:
            if (r100 != 0) goto L15;
            return "";
        L15:
            if (r100 > 0) goto L19;
            throw InvalidProtocolBufferException.negativeSize();
        L19:
            throw InvalidProtocolBufferException.truncatedMessage();
        L5:
            if (r100 > remaining()) goto L12;
            byte[] r101 = new byte[r100];
            long r102 = r100;
            UnsafeUtil.copyMemory(this.pos, r101, 0, r102);
            if (Utf8.isValidUtf8(r101) == false) goto L11;
            String r103 = new String(r101, Internal.UTF_8);
            this.pos += r102;
            return r103;
        L11:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd() == false) goto L6;
            this.lastTag = 0;
            return 0;
        L6:
            int r100 = readRawVarint32();
            this.lastTag = r100;
            if (WireFormat.getTagFieldNumber(r100) == 0) goto L11;
            return this.lastTag;
        L11:
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
        L2:
            int r100 = readTag();
            if (r100 == 0) goto L6;
            if (skipField(r100) == true) goto L2;
            return;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        private int bufferPos(long r100) {
            return (int) (r100 - this.address);
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int r100) throws InvalidProtocolBufferException {
            if (this.lastTag != r100) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean r100) {
            this.enableAliasing = r100;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int r100) {
            this.currentLimit = r100;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int r100) throws InvalidProtocolBufferException {
            if (r100 < 0) goto L10;
            int r101 = r100 + getTotalBytesRead();
            int r102 = this.currentLimit;
            if (r101 > r102) goto L8;
            this.currentLimit = r101;
            recomputeBufferSizeAfterLimit();
            return r102;
        L8:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int r100) throws IOException {
            if (r100 >= 0) goto L4;
        L7:
            if (r100 > 0) goto L14;
            if (r100 != 0) goto L12;
            return Internal.EMPTY_BYTE_ARRAY;
        L12:
            throw InvalidProtocolBufferException.negativeSize();
        L14:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (r100 > remaining()) goto L7;
            byte[] r101 = new byte[r100];
            long r102 = this.pos;
            long r103 = r100;
            slice(r102, r102 + r103).get(r101);
            this.pos += r103;
            return r101;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r100) throws IOException {
            int r101 = WireFormat.getTagWireType(r100);
            if (r101 == 0) goto L24;
            if (r101 != 1) goto L6;
            skipRawBytes(8);
            return true;
        L6:
            if (r101 != 2) goto L8;
            skipRawBytes(readRawVarint32());
            return true;
        L8:
            if (r101 == 3) goto L18;
            if (r101 != 4) goto L11;
            return false;
        L11:
            if (r101 != 5) goto L15;
            skipRawBytes(4);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(r100), 4));
            return true;
        L24:
            skipRawVarint();
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream r100) throws IOException {
        L2:
            int r101 = readTag();
            if (r101 == 0) goto L6;
            if (skipField(r101, r100) == true) goto L2;
            return;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int r100) throws IOException {
            if (r100 >= 0) goto L4;
        L7:
            if (r100 >= 0) goto L11;
            throw InvalidProtocolBufferException.negativeSize();
        L11:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (r100 > remaining()) goto L7;
            this.pos += (long) r100;
        }

        private UnsafeDirectNioDecoder(ByteBuffer r100, boolean r101) {
            super(null);
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = r100;
            long r102 = UnsafeUtil.addressOffset(r100);
            this.address = r102;
            this.limit = ((long) r100.limit()) + r102;
            long r103 = r102 + ((long) r100.position());
            this.pos = r103;
            this.startPos = r103;
            this.immutable = r101;
        }

        private ByteBuffer slice(long r100, long r101) throws IOException {
            int r102 = this.buffer.position();
            int r103 = this.buffer.limit();
            this.buffer.position(bufferPos(r100));     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            this.buffer.limit(bufferPos(r101));     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            ByteBuffer r104 = this.buffer.slice();     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            this.buffer.position(r102);
            this.buffer.limit(r103);
            return r104;
        L6:
            th = move-exception;
            this.buffer.position(r102);
            this.buffer.limit(r103);
            throw th;
        L9:
            throw InvalidProtocolBufferException.truncatedMessage();     // Catch: Throwable -> L6
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> r100, ExtensionRegistryLite r101) throws IOException {
            int r102 = readRawVarint32();
            if (this.recursionDepth >= this.recursionLimit) goto L7;
            int r103 = pushLimit(r102);
            this.recursionDepth++;
            T r104 = r100.parsePartialFrom(this, r101);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(r103);
            return r104;
        L7:
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readUnknownGroup(int r100, MessageLite.Builder r101) throws IOException {
            readGroup(r100, r101, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r100, CodedOutputStream r101) throws IOException {
            int r102 = WireFormat.getTagWireType(r100);
            if (r102 == 0) goto L24;
            if (r102 != 1) goto L6;
            long r103 = readRawLittleEndian64();
            r101.writeRawVarint32(r100);
            r101.writeFixed64NoTag(r103);
            return true;
        L6:
            if (r102 != 2) goto L8;
            ByteString r104 = readBytes();
            r101.writeRawVarint32(r100);
            r101.writeBytesNoTag(r104);
            return true;
        L8:
            if (r102 == 3) goto L18;
            if (r102 != 4) goto L11;
            return false;
        L11:
            if (r102 != 5) goto L15;
            int r105 = readRawLittleEndian32();
            r101.writeRawVarint32(r100);
            r101.writeFixed32NoTag(r105);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            r101.writeRawVarint32(r100);
            skipMessage(r101);
            int r106 = WireFormat.makeTag(WireFormat.getTagFieldNumber(r100), 4);
            checkLastTagWas(r106);
            r101.writeRawVarint32(r106);
            return true;
        L24:
            long r107 = readInt64();
            r101.writeRawVarint32(r100);
            r101.writeUInt64NoTag(r107);
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder r100, ExtensionRegistryLite r101) throws IOException {
            int r102 = readRawVarint32();
            if (this.recursionDepth >= this.recursionLimit) goto L7;
            int r103 = pushLimit(r102);
            this.recursionDepth++;
            r100.mergeFrom(this, r101);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(r103);
            return;
        L7:
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        public /* synthetic */ UnsafeDirectNioDecoder(ByteBuffer r100, boolean r101, AnonymousClass1 r102) {
            this(r100, r101);
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int r100, Parser<T> r101, ExtensionRegistryLite r102) throws IOException {
            int r103 = this.recursionDepth;
            if (r103 >= this.recursionLimit) goto L7;
            this.recursionDepth = r103 + 1;
            T r104 = r101.parsePartialFrom(this, r102);
            checkLastTagWas(WireFormat.makeTag(r100, 4));
            this.recursionDepth--;
            return r104;
        L7:
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int r100, MessageLite.Builder r101, ExtensionRegistryLite r102) throws IOException {
            int r103 = this.recursionDepth;
            if (r103 >= this.recursionLimit) goto L7;
            this.recursionDepth = r103 + 1;
            r101.mergeFrom(this, r102);
            checkLastTagWas(WireFormat.makeTag(r100, 4));
            this.recursionDepth--;
            return;
        L7:
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
    }

    public static int decodeZigZag32(int r100) {
        int r101 = r100 >>> 1;
        return (-(r100 & 1)) ^ r101;
    }

    public static long decodeZigZag64(long r100) {
        long r101 = r100 >>> 1;
        return (-(r100 & 1)) ^ r101;
    }

    public static void setProto3DiscardUnknownsByDefaultForTest() {
        proto3DiscardUnknownFieldsDefault = true;
    }

    public static void setProto3KeepUnknownsByDefaultForTest() {
        proto3DiscardUnknownFieldsDefault = false;
    }

    public abstract void checkLastTagWas(int r100) throws InvalidProtocolBufferException;

    public final void discardUnknownFields() {
        this.explicitDiscardUnknownFields = true;
    }

    public abstract void enableAliasing(boolean r100);

    public abstract int getBytesUntilLimit();

    public abstract int getLastTag();

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd() throws IOException;

    public abstract void popLimit(int r100);

    public abstract int pushLimit(int r100) throws InvalidProtocolBufferException;

    public abstract boolean readBool() throws IOException;

    public abstract byte[] readByteArray() throws IOException;

    public abstract ByteBuffer readByteBuffer() throws IOException;

    public abstract ByteString readBytes() throws IOException;

    public abstract double readDouble() throws IOException;

    public abstract int readEnum() throws IOException;

    public abstract int readFixed32() throws IOException;

    public abstract long readFixed64() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract <T extends MessageLite> T readGroup(int r100, Parser<T> r101, ExtensionRegistryLite r102) throws IOException;

    public abstract void readGroup(int r100, MessageLite.Builder r101, ExtensionRegistryLite r102) throws IOException;

    public abstract int readInt32() throws IOException;

    public abstract long readInt64() throws IOException;

    public abstract <T extends MessageLite> T readMessage(Parser<T> r100, ExtensionRegistryLite r101) throws IOException;

    public abstract void readMessage(MessageLite.Builder r100, ExtensionRegistryLite r101) throws IOException;

    public abstract byte readRawByte() throws IOException;

    public abstract byte[] readRawBytes(int r100) throws IOException;

    public abstract int readRawLittleEndian32() throws IOException;

    public abstract long readRawLittleEndian64() throws IOException;

    public abstract int readRawVarint32() throws IOException;

    public abstract long readRawVarint64() throws IOException;

    public abstract long readRawVarint64SlowPath() throws IOException;

    public abstract int readSFixed32() throws IOException;

    public abstract long readSFixed64() throws IOException;

    public abstract int readSInt32() throws IOException;

    public abstract long readSInt64() throws IOException;

    public abstract String readString() throws IOException;

    public abstract String readStringRequireUtf8() throws IOException;

    public abstract int readTag() throws IOException;

    public abstract int readUInt32() throws IOException;

    public abstract long readUInt64() throws IOException;

    public abstract void readUnknownGroup(int r100, MessageLite.Builder r101) throws IOException;

    public abstract void resetSizeCounter();

    public abstract boolean skipField(int r100) throws IOException;

    public abstract boolean skipField(int r100, CodedOutputStream r101) throws IOException;

    public abstract void skipMessage() throws IOException;

    public abstract void skipMessage(CodedOutputStream r100) throws IOException;

    public abstract void skipRawBytes(int r100) throws IOException;

    public final void unsetDiscardUnknownFields() {
        this.explicitDiscardUnknownFields = false;
    }

    public final boolean shouldDiscardUnknownFieldsProto3() {
        if (this.explicitDiscardUnknownFields == false) goto L6;
        return true;
    L6:
        return proto3DiscardUnknownFieldsDefault;
    }

    private CodedInputStream() {
        this.recursionLimit = 100;
        this.sizeLimit = Integer.MAX_VALUE;
        this.explicitDiscardUnknownFields = false;
    }

    public static boolean getProto3DiscardUnknownFieldsDefault() {
        return proto3DiscardUnknownFieldsDefault;
    }

    public final boolean shouldDiscardUnknownFields() {
        return this.explicitDiscardUnknownFields;
    }

    public /* synthetic */ CodedInputStream(AnonymousClass1 r100) {
        this();
    }

    public static CodedInputStream newInstance(Iterable<ByteBuffer> r100) {
        if (UnsafeDirectNioDecoder.isSupported() == true) goto L7;
        return newInstance(new IterableByteBufferInputStream(r100));
    L7:
        return newInstance(r100, false);
    }

    public static int readRawVarint32(InputStream r100) throws IOException {
        int r101 = r100.read();
        if (r101 == (-1)) goto L7;
        return readRawVarint32(r101, r100);
    L7:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public final int setRecursionLimit(int r100) {
        if (r100 < 0) goto L6;
        int r101 = this.recursionLimit;
        this.recursionLimit = r100;
        return r101;
    L6:
        throw new IllegalArgumentException("Recursion limit cannot be negative: " + r100);
    }

    public final int setSizeLimit(int r100) {
        if (r100 < 0) goto L6;
        int r101 = this.sizeLimit;
        this.sizeLimit = r100;
        return r101;
    L6:
        throw new IllegalArgumentException("Size limit cannot be negative: " + r100);
    }

    public static CodedInputStream newInstance(InputStream r100) {
        return newInstance(r100, 4096);
    }

    public static CodedInputStream newInstance(byte[] r100) {
        return newInstance(r100, 0, r100.length);
    }

    public static CodedInputStream newInstance(ByteBuffer r100) {
        return newInstance(r100, false);
    }

    public static CodedInputStream newInstance(ByteBuffer r100, boolean r101) {
        if (r100.hasArray() == false) goto L7;
        return newInstance(r100.array(), r100.arrayOffset() + r100.position(), r100.remaining(), r101);
    L7:
        if (r100.isDirect() == true) goto L9;
    L12:
        int r102 = r100.remaining();
        byte[] r103 = new byte[r102];
        r100.duplicate().get(r103);
        return newInstance(r103, 0, r102, true);
    L9:
        if (UnsafeDirectNioDecoder.isSupported() == false) goto L12;
        return new UnsafeDirectNioDecoder(r100, r101, null);
    }

    public static int readRawVarint32(int r100, InputStream r101) throws IOException {
        if ((r100 & 128) != 0) goto L5;
        return r100;
    L5:
        int r102 = r100 & 127;
        int r103 = 7;
    L7:
        if (r103 >= 32) goto L17;
        int r104 = r101.read();
        if (r104 == (-1)) goto L15;
        r102 = r102 | ((r104 & 127) << r103);
        if ((r104 & 128) == 0) goto L12;
        r103 = r103 + 7;
        goto L7
    L12:
        return r102;
    L15:
        throw InvalidProtocolBufferException.truncatedMessage();
    L17:
        if (r103 >= 64) goto L27;
        int r105 = r101.read();
        if (r105 == (-1)) goto L25;
        if ((r105 & 128) == 0) goto L22;
        r103 = r103 + 7;
        goto L17
    L22:
        return r102;
    L25:
        throw InvalidProtocolBufferException.truncatedMessage();
    L27:
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public static CodedInputStream newInstance(Iterable<ByteBuffer> r100, boolean r101) {
        Iterator<ByteBuffer> r102 = r100.iterator();
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r102.hasNext() == false) goto L13;
        ByteBuffer r105 = r102.next();
        r104 = r104 + r105.remaining();
        if (r105.hasArray() == true) goto L7;
        if (r105.isDirect() == true) goto L10;
        r103 = r103 | 4;
        goto L4
    L10:
        r103 = r103 | 2;
        goto L4
    L7:
        r103 = r103 | 1;
        goto L4
    L13:
        if (r103 != 2) goto L17;
        return new IterableDirectByteBufferDecoder(r100, r104, r101, null);
    L17:
        return newInstance(new IterableByteBufferInputStream(r100));
    }

    public static CodedInputStream newInstance(InputStream r100, int r101) {
        if (r100 != null) goto L6;
        return newInstance(Internal.EMPTY_BYTE_ARRAY);
    L6:
        return new StreamDecoder(r100, r101, null);
    }

    public static CodedInputStream newInstance(byte[] r100, int r101, int r102) {
        return newInstance(r100, r101, r102, false);
    }

    public static CodedInputStream newInstance(byte[] r100, int r101, int r102, boolean r110) {
        ArrayDecoder r103 = new ArrayDecoder(r100, r101, r102, r110, null);
        r103.pushLimit(r102);     // Catch: InvalidProtocolBufferException -> L5
        return r103;
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }
}
