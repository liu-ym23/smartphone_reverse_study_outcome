package com.squareup.wire;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes34.dex */
public final class ProtoReader {
    private static final int FIELD_ENCODING_MASK = 7;
    private static final int RECURSION_LIMIT = 65;
    private static final int STATE_END_GROUP = 4;
    private static final int STATE_FIXED32 = 5;
    private static final int STATE_FIXED64 = 1;
    private static final int STATE_LENGTH_DELIMITED = 2;
    private static final int STATE_PACKED_TAG = 7;
    private static final int STATE_START_GROUP = 3;
    private static final int STATE_TAG = 6;
    private static final int STATE_VARINT = 0;
    static final int TAG_FIELD_ENCODING_BITS = 3;
    private long limit;
    private FieldEncoding nextFieldEncoding;
    private long pos;
    private long pushedLimit;
    private int recursionDepth;
    private final BufferedSource source;
    private int state;
    private int tag;

    private long beforeLengthDelimitedScalar() throws IOException {
        if (this.state != 2) goto L7;
        long r100 = this.limit - this.pos;
        this.source.require(r100);
        this.state = 6;
        this.pos = this.limit;
        this.limit = this.pushedLimit;
        this.pushedLimit = -1;
        return r100;
    L7:
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.state);
    }

    private int internalReadVarint32() throws IOException {
        this.source.require(1);
        this.pos++;
        byte r100 = this.source.readByte();
        if (r100 < 0) goto L5;
        return r100;
    L5:
        int r101 = r100 & ByteCompanionObject.MAX_VALUE;
        this.source.require(1);
        this.pos++;
        byte r102 = this.source.readByte();
        if (r102 < 0) goto L9;
        int r103 = r102 << 7;
    L26:
        return r101 | r103;
    L9:
        r101 = r101 | ((r102 & ByteCompanionObject.MAX_VALUE) << 7);
        this.source.require(1);
        this.pos++;
        byte r104 = this.source.readByte();
        if (r104 < 0) goto L12;
        r103 = r104 << 14;
        goto L26
    L12:
        r101 = r101 | ((r104 & ByteCompanionObject.MAX_VALUE) << 14);
        this.source.require(1);
        this.pos++;
        byte r105 = this.source.readByte();
        if (r105 < 0) goto L15;
        r103 = r105 << 21;
        goto L26
    L15:
        int r106 = r101 | ((r105 & ByteCompanionObject.MAX_VALUE) << 21);
        this.source.require(1);
        this.pos++;
        byte r107 = this.source.readByte();
        int r108 = r106 | (r107 << 28);
        if (r107 >= 0) goto L29;
        int r109 = 0;
    L19:
        if (r109 >= 5) goto L25;
        this.source.require(1);
        this.pos++;
        if (this.source.readByte() >= 0) goto L22;
        r109 = r109 + 1;
        goto L19
    L22:
        return r108;
    L25:
        throw new ProtocolException("Malformed VARINT");
    L29:
        return r108;
    }

    public long beginMessage() throws IOException {
        if (this.state != 2) goto L11;
        int r100 = this.recursionDepth + 1;
        this.recursionDepth = r100;
        if (r100 > 65) goto L9;
        long r101 = this.pushedLimit;
        this.pushedLimit = -1;
        this.state = 6;
        return r101;
    L9:
        throw new IOException("Wire recursion limit exceeded");
    L11:
        throw new IllegalStateException("Unexpected call to beginMessage()");
    }

    public int nextTag() throws IOException {
        int r100 = this.state;
        if (r100 != 7) goto L7;
        this.state = 2;
        return this.tag;
    L7:
        if (r100 != 6) goto L55;
    L9:
        if (this.pos >= this.limit) goto L52;
        if (this.source.exhausted() == true) goto L63;
        int r101 = internalReadVarint32();
        if (r101 == 0) goto L51;
        int r102 = r101 >> 3;
        this.tag = r102;
        int r103 = r101 & 7;
        if (r103 == 0) goto L48;
        if (r103 == 1) goto L46;
        if (r103 == 2) goto L32;
        if (r103 != 3) goto L22;
        skipGroup(r102);
        goto L9
    L22:
        if (r103 == 4) goto L30;
        if (r103 != 5) goto L28;
        this.nextFieldEncoding = FieldEncoding.FIXED32;
        this.state = 5;
        return r102;
    L28:
        throw new ProtocolException("Unexpected field encoding: " + r103);
    L30:
        throw new ProtocolException("Unexpected end group");
    L32:
        this.nextFieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        this.state = 2;
        int r104 = internalReadVarint32();
        if (r104 < 0) goto L45;
        if (this.pushedLimit != (-1)) goto L43;
        long r105 = this.limit;
        this.pushedLimit = r105;
        long r106 = this.pos + ((long) r104);
        this.limit = r106;
        if (r106 > r105) goto L41;
        return this.tag;
    L41:
        throw new EOFException();
    L43:
        throw new IllegalStateException();
    L45:
        throw new ProtocolException("Negative length: " + r104);
    L46:
        this.nextFieldEncoding = FieldEncoding.FIXED64;
        this.state = 1;
        return r102;
    L48:
        this.nextFieldEncoding = FieldEncoding.VARINT;
        this.state = 0;
        return r102;
    L51:
        throw new ProtocolException("Unexpected tag 0");
    L63:
        return -1;
    L52:
        return -1;
    L55:
        throw new IllegalStateException("Unexpected call to nextTag()");
    }

    public int readFixed32() throws IOException {
        int r100 = this.state;
        if (r100 != 5) goto L5;
    L9:
        this.source.require(4);
        this.pos += 4;
        int r101 = this.source.readIntLe();
        afterPackableScalar(5);
        return r101;
    L5:
        if (r100 == 2) goto L9;
        throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.state);
    }

    public long readFixed64() throws IOException {
        int r100 = this.state;
        if (r100 != 1) goto L5;
    L9:
        this.source.require(8);
        this.pos += 8;
        long r101 = this.source.readLongLe();
        afterPackableScalar(1);
        return r101;
    L5:
        if (r100 == 2) goto L9;
        throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.state);
    }

    public int readVarint32() throws IOException {
        int r100 = this.state;
        if (r100 != 0) goto L5;
    L9:
        int r101 = internalReadVarint32();
        afterPackableScalar(0);
        return r101;
    L5:
        if (r100 == 2) goto L9;
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
    }

    public long readVarint64() throws IOException {
        int r100 = this.state;
        if (r100 != 0) goto L5;
    L9:
        long r101 = 0;
        int r102 = 0;
    L11:
        if (r102 >= 64) goto L18;
        this.source.require(1);
        this.pos++;
        byte r103 = this.source.readByte();
        r101 = r101 | (((long) (r103 & ByteCompanionObject.MAX_VALUE)) << r102);
        if ((r103 & ByteCompanionObject.MIN_VALUE) == 0) goto L14;
        r102 = r102 + 7;
        goto L11
    L14:
        afterPackableScalar(0);
        return r101;
    L18:
        throw new ProtocolException("WireInput encountered a malformed varint");
    L5:
        if (r100 == 2) goto L9;
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
    }

    public void skip() throws IOException {
        int r100 = this.state;
        if (r100 != 0) goto L5;
        readVarint64();
        return;
    L5:
        if (r100 != 1) goto L7;
        readFixed64();
        return;
    L7:
        if (r100 != 2) goto L9;
        long r101 = beforeLengthDelimitedScalar();
        this.source.skip(r101);
        return;
    L9:
        if (r100 != 5) goto L12;
        readFixed32();
        return;
    L12:
        throw new IllegalStateException("Unexpected call to skip()");
    }

    public ByteString readBytes() throws IOException {
        long r100 = beforeLengthDelimitedScalar();
        this.source.require(r100);
        return this.source.readByteString(r100);
    }

    public String readString() throws IOException {
        long r100 = beforeLengthDelimitedScalar();
        this.source.require(r100);
        return this.source.readUtf8(r100);
    }

    public FieldEncoding peekFieldEncoding() {
        return this.nextFieldEncoding;
    }

    public ProtoReader(BufferedSource r100) {
        this.pos = 0;
        this.limit = Long.MAX_VALUE;
        this.state = 2;
        this.tag = -1;
        this.pushedLimit = -1;
        this.source = r100;
    }

    private void afterPackableScalar(int r100) throws IOException {
        if (this.state != r100) goto L5;
        this.state = 6;
        return;
    L5:
        long r101 = this.pos;
        long r102 = this.limit;
        if (r101 > r102) goto L13;
        if (r101 != r102) goto L10;
        this.limit = this.pushedLimit;
        this.pushedLimit = -1;
        this.state = 6;
        return;
    L10:
        this.state = 7;
        return;
    L13:
        throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
    }

    private void skipGroup(int r100) throws IOException {
    L3:
        if (this.pos >= this.limit) goto L34;
        if (this.source.exhausted() == true) goto L34;
        int r101 = internalReadVarint32();
        if (r101 == 0) goto L32;
        int r102 = r101 >> 3;
        int r103 = r101 & 7;
        if (r103 != 0) goto L11;
        this.state = 0;
        readVarint64();
        goto L3
    L11:
        if (r103 != 1) goto L13;
        this.state = 1;
        readFixed64();
        goto L3
    L13:
        if (r103 != 2) goto L15;
        long r104 = internalReadVarint32();
        this.pos += r104;
        this.source.skip(r104);
        goto L3
    L15:
        if (r103 != 3) goto L17;
        skipGroup(r102);
        goto L3
    L17:
        if (r103 == 4) goto L23;
        if (r103 != 5) goto L22;
        this.state = 5;
        readFixed32();
        goto L3
    L22:
        throw new ProtocolException("Unexpected field encoding: " + r103);
    L23:
        if (r102 != r100) goto L26;
        return;
    L26:
        throw new ProtocolException("Unexpected end group");
    L32:
        throw new ProtocolException("Unexpected tag 0");
    L34:
        throw new EOFException();
    }

    public void endMessage(long r100) throws IOException {
        if (this.state != 6) goto L19;
        int r101 = this.recursionDepth - 1;
        this.recursionDepth = r101;
        if (r101 < 0) goto L17;
        if (this.pushedLimit != (-1)) goto L17;
        if (this.pos == this.limit) goto L14;
        if (r101 == 0) goto L14;
        throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
    L14:
        this.limit = r100;
        return;
    L17:
        throw new IllegalStateException("No corresponding call to beginMessage()");
    L19:
        throw new IllegalStateException("Unexpected call to endMessage()");
    }
}
