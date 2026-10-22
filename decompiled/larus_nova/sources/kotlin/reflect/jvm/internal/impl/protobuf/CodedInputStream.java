package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes5.dex */
public final class CodedInputStream {
    private final byte[] buffer;
    private final boolean bufferIsImmutable;
    private int bufferPos;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int currentLimit;
    private boolean enableAliasing;
    private final InputStream input;
    private int lastTag;
    private int recursionDepth;
    private int recursionLimit;
    private RefillCallback refillCallback;
    private int sizeLimit;
    private int totalBytesRetired;

    /* JADX INFO: loaded from: classes42.dex */
    public interface RefillCallback {
        void onRefill();
    }

    public static int decodeZigZag32(int r100) {
        int r101 = r100 >>> 1;
        return (-(r100 & 1)) ^ r101;
    }

    public static long decodeZigZag64(long r100) {
        long r101 = r100 >>> 1;
        return (-(r100 & 1)) ^ r101;
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

    public int getBytesUntilLimit() {
        int r100 = this.currentLimit;
        if (r100 != Integer.MAX_VALUE) goto L7;
        return -1;
    L7:
        return r100 - (this.totalBytesRetired + this.bufferPos);
    }

    public boolean isAtEnd() throws IOException {
        if (this.bufferPos == this.bufferSize) goto L5;
    L7:
        return false;
    L5:
        if (tryRefillBuffer(1) == true) goto L7;
        return true;
    }

    public byte readRawByte() throws IOException {
        if (this.bufferPos != this.bufferSize) goto L5;
        refillBuffer(1);
    L5:
        byte[] r100 = this.buffer;
        int r101 = this.bufferPos;
        this.bufferPos = r101 + 1;
        return r100[r101];
    }

    public int readRawLittleEndian32() throws IOException {
        int r100 = this.bufferPos;
        if ((this.bufferSize - r100) >= 4) goto L5;
        refillBuffer(4);
        r100 = this.bufferPos;
    L5:
        byte[] r101 = this.buffer;
        this.bufferPos = r100 + 4;
        int r102 = ((r101[r100] & UByte.MAX_VALUE) | ((r101[r100 + 1] & UByte.MAX_VALUE) << 8)) | ((r101[r100 + 2] & UByte.MAX_VALUE) << 16);
        return ((r101[r100 + 3] & UByte.MAX_VALUE) << 24) | r102;
    }

    public long readRawLittleEndian64() throws IOException {
        int r100 = this.bufferPos;
        if ((this.bufferSize - r100) >= 8) goto L5;
        refillBuffer(8);
        r100 = this.bufferPos;
    L5:
        byte[] r101 = this.buffer;
        this.bufferPos = r100 + 8;
        long r102 = ((((((((long) r101[r100]) & 255) | ((((long) r101[r100 + 1]) & 255) << 8)) | ((((long) r101[r100 + 2]) & 255) << 16)) | ((((long) r101[r100 + 3]) & 255) << 24)) | ((((long) r101[r100 + 4]) & 255) << 32)) | ((((long) r101[r100 + 5]) & 255) << 40)) | ((((long) r101[r100 + 6]) & 255) << 48);
        return ((((long) r101[r100 + 7]) & 255) << 56) | r102;
    }

    public int readRawVarint32() throws IOException {
        int r100 = this.bufferPos;
        int r101 = this.bufferSize;
        if (r101 == r100) goto L36;
        byte[] r102 = this.buffer;
        int r103 = r100 + 1;
        byte r104 = r102[r100];
        if (r104 < 0) goto L10;
        this.bufferPos = r103;
        return r104;
    L10:
        if ((r101 - r103) < 9) goto L36;
        int r105 = r103 + 1;
        int r106 = r104 ^ (r102[r103] << 7);
        long r107 = r106;
        if (r107 >= 0) goto L16;
        long r108 = -128;
    L15:
        int r109 = (int) (r107 ^ r108);
    L37:
        this.bufferPos = r105;
        return r109;
    L16:
        int r110 = r105 + 1;
        int r111 = r106 ^ (r102[r105] << 14);
        long r112 = r111;
        if (r112 < 0) goto L20;
        r109 = (int) (16256 ^ r112);
    L19:
        r105 = r110;
        goto L37
    L20:
        r105 = r110 + 1;
        int r113 = r111 ^ (r102[r110] << 21);
        r107 = r113;
        if (r107 >= 0) goto L23;
        r108 = -2080896;
        goto L15
    L23:
        r110 = r105 + 1;
        byte r114 = r102[r105];
        r109 = (int) (((long) (r113 ^ (r114 << 28))) ^ 266354560);
        if (r114 >= 0) goto L19;
        r105 = r110 + 1;
        if (r102[r110] >= 0) goto L37;
        r110 = r105 + 1;
        if (r102[r105] >= 0) goto L19;
        r105 = r110 + 1;
        if (r102[r110] >= 0) goto L37;
        r110 = r105 + 1;
        if (r102[r105] >= 0) goto L19;
        r105 = r110 + 1;
        if (r102[r110] >= 0) goto L37;
    L36:
        return (int) readRawVarint64SlowPath();
    }

    public long readRawVarint64() throws IOException {
        int r100 = this.bufferPos;
        int r101 = this.bufferSize;
        if (r101 == r100) goto L40;
        byte[] r102 = this.buffer;
        int r103 = r100 + 1;
        byte r104 = r102[r100];
        if (r104 < 0) goto L10;
        this.bufferPos = r103;
        return r104;
    L10:
        if ((r101 - r103) < 9) goto L40;
        int r105 = r103 + 1;
        long r106 = r104 ^ (r102[r103] << 7);
        if (r106 >= 0) goto L16;
        long r107 = -128;
    L15:
        long r108 = r106 ^ r107;
    L43:
        this.bufferPos = r105;
        return r108;
    L16:
        int r109 = r105 + 1;
        long r110 = r106 ^ ((long) (r102[r105] << 14));
        if (r110 < 0) goto L20;
        long r111 = 16256;
    L19:
        r108 = r110 ^ r111;
        r105 = r109;
        goto L43
    L20:
        r105 = r109 + 1;
        r106 = r110 ^ ((long) (r102[r109] << 21));
        if (r106 >= 0) goto L23;
        r107 = -2080896;
        goto L15
    L23:
        r109 = r105 + 1;
        r110 = r106 ^ (((long) r102[r105]) << 28);
        if (r110 < 0) goto L26;
        r111 = 266354560;
        goto L19
    L26:
        r105 = r109 + 1;
        r106 = r110 ^ (((long) r102[r109]) << 35);
        if (r106 >= 0) goto L29;
        r107 = -34093383808L;
        goto L15
    L29:
        r109 = r105 + 1;
        r110 = r106 ^ (((long) r102[r105]) << 42);
        if (r110 < 0) goto L32;
        r111 = 4363953127296L;
        goto L19
    L32:
        r105 = r109 + 1;
        r106 = r110 ^ (((long) r102[r109]) << 49);
        if (r106 >= 0) goto L35;
        r107 = -558586000294016L;
        goto L15
    L35:
        int r112 = r105 + 1;
        long r113 = (r106 ^ (((long) r102[r105]) << 56)) ^ 71499008037633920L;
        if (r113 >= 0) goto L41;
        r105 = r112 + 1;
        if (r102[r112] < 0) goto L40;
    L42:
        r108 = r113;
        goto L43
    L41:
        r105 = r112;
    L40:
        return readRawVarint64SlowPath();
    }

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

    public boolean readBool() throws IOException {
        if (readRawVarint64() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public ByteString readBytes() throws IOException {
        int r100 = readRawVarint32();
        int r101 = this.bufferSize;
        int r102 = this.bufferPos;
        if (r100 > (r101 - r102)) goto L13;
        if (r100 <= 0) goto L13;
        if (this.bufferIsImmutable == true) goto L8;
    L10:
        ByteString r103 = ByteString.copyFrom(this.buffer, r102, r100);
    L11:
        this.bufferPos += r100;
        return r103;
    L8:
        if (this.enableAliasing == false) goto L10;
        r103 = new BoundedByteString(this.buffer, this.bufferPos, r100);
    L13:
        if (r100 != 0) goto L17;
        return ByteString.EMPTY;
    L17:
        return new LiteralByteString(readRawBytesSlowPath(r100));
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    public int readEnum() throws IOException {
        return readRawVarint32();
    }

    public int readFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public int readInt32() throws IOException {
        return readRawVarint32();
    }

    public long readInt64() throws IOException {
        return readRawVarint64();
    }

    public int readSFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readSFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public int readSInt32() throws IOException {
        return decodeZigZag32(readRawVarint32());
    }

    public long readSInt64() throws IOException {
        return decodeZigZag64(readRawVarint64());
    }

    public String readString() throws IOException {
        int r100 = readRawVarint32();
        int r101 = this.bufferSize;
        int r102 = this.bufferPos;
        if (r100 > (r101 - r102)) goto L7;
        if (r100 <= 0) goto L7;
        String r103 = new String(this.buffer, r102, r100, "UTF-8");
        this.bufferPos += r100;
        return r103;
    L7:
        if (r100 != 0) goto L11;
        return "";
    L11:
        return new String(readRawBytesSlowPath(r100), "UTF-8");
    }

    public String readStringRequireUtf8() throws IOException {
        int r100 = readRawVarint32();
        int r101 = this.bufferPos;
        if (r100 > (this.bufferSize - r101)) goto L6;
        if (r100 <= 0) goto L6;
        byte[] r102 = this.buffer;
        this.bufferPos = r101 + r100;
    L11:
        if (Utf8.isValidUtf8(r102, r101, r101 + r100) == false) goto L15;
        return new String(r102, r101, r100, "UTF-8");
    L15:
        throw InvalidProtocolBufferException.invalidUtf8();
    L6:
        if (r100 != 0) goto L9;
        return "";
    L9:
        r102 = readRawBytesSlowPath(r100);
        r101 = 0;
        goto L11
    }

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

    public int readUInt32() throws IOException {
        return readRawVarint32();
    }

    public long readUInt64() throws IOException {
        return readRawVarint64();
    }

    private CodedInputStream(LiteralByteString r100) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.refillCallback = null;
        this.buffer = r100.bytes;
        int r101 = r100.getOffsetIntoBytes();
        this.bufferPos = r101;
        this.bufferSize = r101 + r100.size();
        this.totalBytesRetired = -this.bufferPos;
        this.input = null;
        this.bufferIsImmutable = true;
    }

    private void ensureAvailable(int r100) throws IOException {
        if ((this.bufferSize - this.bufferPos) >= r100) goto L6;
        refillBuffer(r100);
        return;
    }

    public static CodedInputStream newInstance(LiteralByteString r100) {
        CodedInputStream r101 = new CodedInputStream(r100);
        r101.pushLimit(r100.size());     // Catch: InvalidProtocolBufferException -> L5
        return r101;
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    private byte[] readRawBytesSlowPath(int r110) throws IOException {
        if (r110 > 0) goto L8;
        if (r110 != 0) goto L7;
        return Internal.EMPTY_BYTE_ARRAY;
    L7:
        throw InvalidProtocolBufferException.negativeSize();
    L8:
        int r100 = this.totalBytesRetired;
        int r101 = this.bufferPos;
        int r102 = (r100 + r101) + r110;
        int r103 = this.currentLimit;
        if (r102 <= r103) goto L11;
        skipRawBytes((r103 - r100) - r101);
        throw InvalidProtocolBufferException.truncatedMessage();
    L11:
        if (r110 >= 4096) goto L14;
        byte[] r104 = new byte[r110];
        int r105 = this.bufferSize - r101;
        System.arraycopy(this.buffer, r101, r104, 0, r105);
        this.bufferPos = this.bufferSize;
        int r111 = r110 - r105;
        ensureAvailable(r111);
        System.arraycopy(this.buffer, 0, r104, r105, r111);
        this.bufferPos = r111;
        return r104;
    L14:
        int r106 = this.bufferSize;
        this.totalBytesRetired = r100 + r106;
        this.bufferPos = 0;
        this.bufferSize = 0;
        int r107 = r106 - r101;
        int r108 = r110 - r107;
        ArrayList r109 = new ArrayList();
    L15:
        if (r108 <= 0) goto L27;
        int r112 = Math.min(r108, 4096);
        byte[] r113 = new byte[r112];
        int r114 = 0;
    L17:
        if (r114 >= r112) goto L26;
        InputStream r115 = this.input;
        if (r115 != null) goto L21;
        int r116 = -1;
    L22:
        if (r116 == (-1)) goto L25;
        this.totalBytesRetired += r116;
        r114 = r114 + r116;
        goto L17
    L25:
        throw InvalidProtocolBufferException.truncatedMessage();
    L21:
        r116 = r115.read(r113, r114, r112 - r114);
        goto L22
    L26:
        r108 = r108 - r112;
        r109.add(r113);
        goto L15
    L27:
        byte[] r117 = new byte[r110];
        System.arraycopy(this.buffer, r101, r117, 0, r107);
        Iterator r118 = r109.iterator();
    L29:
        if (r118.hasNext() == false) goto L31;
        byte[] r119 = (byte[]) r118.next();
        System.arraycopy(r119, 0, r117, r107, r119.length);
        r107 = r107 + r119.length;
        goto L29
    L31:
        return r117;
    }

    private void refillBuffer(int r100) throws IOException {
        if (tryRefillBuffer(r100) == false) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    private void skipRawBytesSlowPath(int r100) throws IOException {
        if (r100 < 0) goto L14;
        int r101 = this.totalBytesRetired;
        int r102 = this.bufferPos;
        int r103 = (r101 + r102) + r100;
        int r104 = this.currentLimit;
        if (r103 > r104) goto L11;
        int r105 = this.bufferSize;
        int r106 = r105 - r102;
        this.bufferPos = r105;
        refillBuffer(1);
    L6:
        int r107 = r100 - r106;
        int r108 = this.bufferSize;
        if (r107 <= r108) goto L9;
        r106 = r106 + r108;
        this.bufferPos = r108;
        refillBuffer(1);
        goto L6
    L9:
        this.bufferPos = r107;
        return;
    L11:
        skipRawBytes((r104 - r101) - r102);
        throw InvalidProtocolBufferException.truncatedMessage();
    L14:
        throw InvalidProtocolBufferException.negativeSize();
    }

    private boolean tryRefillBuffer(int r100) throws IOException {
        int r101 = this.bufferPos;
        if ((r101 + r100) > this.bufferSize) goto L5;
        StringBuilder r102 = new StringBuilder(77);
        r102.append("refillBuffer() called when ");
        r102.append(r100);
        r102.append(" bytes were already available in buffer");
        throw new IllegalStateException(r102.toString());
    L5:
        if (((this.totalBytesRetired + r101) + r100) <= this.currentLimit) goto L7;
        return false;
    L7:
        RefillCallback r103 = this.refillCallback;
        if (r103 == null) goto L11;
        r103.onRefill();
    L11:
        if (this.input == null) goto L36;
        int r104 = this.bufferPos;
        if (r104 <= 0) goto L18;
        int r105 = this.bufferSize;
        if (r105 <= r104) goto L17;
        byte[] r106 = this.buffer;
        System.arraycopy(r106, r104, r106, 0, r105 - r104);
    L17:
        this.totalBytesRetired += r104;
        this.bufferSize -= r104;
        this.bufferPos = 0;
    L18:
        InputStream r107 = this.input;
        byte[] r108 = this.buffer;
        int r109 = this.bufferSize;
        int r110 = r107.read(r108, r109, r108.length - r109);
        if (r110 != 0) goto L21;
    L34:
        StringBuilder r111 = new StringBuilder(102);
        r111.append("InputStream#read(byte[]) returned invalid result: ");
        r111.append(r110);
        r111.append("\nThe InputStream implementation is buggy.");
        throw new IllegalStateException(r111.toString());
    L21:
        if (r110 < (-1)) goto L34;
        if (r110 > this.buffer.length) goto L34;
        if (r110 <= 0) goto L36;
        this.bufferSize += r110;
        if (((this.totalBytesRetired + r100) - this.sizeLimit) > 0) goto L33;
        recomputeBufferSizeAfterLimit();
        if (this.bufferSize < r100) goto L31;
        return true;
    L31:
        return tryRefillBuffer(r100);
    L33:
        throw InvalidProtocolBufferException.sizeLimitExceeded();
    L36:
        return false;
    }

    public void checkLastTagWas(int r100) throws InvalidProtocolBufferException {
        if (this.lastTag != r100) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.invalidEndTag();
    }

    public void popLimit(int r100) {
        this.currentLimit = r100;
        recomputeBufferSizeAfterLimit();
    }

    public int pushLimit(int r100) throws InvalidProtocolBufferException {
        if (r100 < 0) goto L10;
        int r101 = r100 + (this.totalBytesRetired + this.bufferPos);
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

    public void skipMessage(CodedOutputStream r100) throws IOException {
    L2:
        int r101 = readTag();
        if (r101 == 0) goto L6;
        if (skipField(r101, r100) == true) goto L2;
        return;
    }

    public void skipRawBytes(int r100) throws IOException {
        int r101 = this.bufferSize;
        int r102 = this.bufferPos;
        if (r100 > (r101 - r102)) goto L6;
        if (r100 < 0) goto L6;
        this.bufferPos = r102 + r100;
        return;
    L6:
        skipRawBytesSlowPath(r100);
    }

    private CodedInputStream(InputStream r100) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.refillCallback = null;
        this.buffer = new byte[4096];
        this.bufferSize = 0;
        this.bufferPos = 0;
        this.totalBytesRetired = 0;
        this.input = r100;
        this.bufferIsImmutable = false;
    }

    public static CodedInputStream newInstance(InputStream r100) {
        return new CodedInputStream(r100);
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
