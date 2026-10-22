package com.squareup.wire;

import com.alipay.sdk.m.n.a;
import com.bytedance.mira.oat.ShareElfFile;
import java.io.IOException;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
public final class ProtoWriter {
    private final BufferedSink sink;

    public static int decodeZigZag32(int r100) {
        int r101 = r100 >>> 1;
        return (-(r100 & 1)) ^ r101;
    }

    public static long decodeZigZag64(long r100) {
        long r101 = r100 >>> 1;
        return (-(r100 & 1)) ^ r101;
    }

    public static int encodeZigZag32(int r100) {
        int r101 = r100 << 1;
        return (r100 >> 31) ^ r101;
    }

    public static long encodeZigZag64(long r100) {
        long r101 = r100 << 1;
        return (r100 >> 63) ^ r101;
    }

    public static int varint32Size(int r100) {
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

    public static int varint64Size(long r100) {
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

    public ProtoWriter(BufferedSink r100) {
        this.sink = r100;
    }

    public static int int32Size(int r100) {
        if (r100 >= 0) goto L4;
        return 10;
    L4:
        return varint32Size(r100);
    }

    public static int tagSize(int r100) {
        return varint32Size(makeTag(r100, FieldEncoding.VARINT));
    }

    public static int utf8Length(String r100) {
        int r101 = r100.length();
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L26;
        char r104 = r100.charAt(r102);
        if (r104 >= 128) goto L8;
    L6:
        r103 = r103 + 1;
    L25:
        r102 = r102 + 1;
        goto L3
    L8:
        if (r104 >= 2048) goto L11;
        r103 = r103 + 2;
        goto L25
    L11:
        if (r104 >= 55296) goto L13;
    L24:
        r103 = r103 + 3;
        goto L25
    L13:
        if (r104 > 57343) goto L24;
        if (r104 > 56319) goto L6;
        int r105 = r102 + 1;
        if (r105 >= r101) goto L6;
        if (r100.charAt(r105) < 56320) goto L6;
        if (r100.charAt(r105) > 57343) goto L6;
        r103 = r103 + 4;
        r102 = r105;
        goto L25
    L26:
        return r103;
    }

    public void writeBytes(ByteString r100) throws IOException {
        this.sink.write(r100);
    }

    public void writeFixed32(int r100) throws IOException {
        this.sink.writeIntLe(r100);
    }

    public void writeFixed64(long r100) throws IOException {
        this.sink.writeLongLe(r100);
    }

    public void writeSignedVarint32(int r100) throws IOException {
        if (r100 < 0) goto L4;
        writeVarint32(r100);
        return;
    L4:
        writeVarint64(r100);
    }

    public void writeString(String r100) throws IOException {
        this.sink.writeUtf8(r100);
    }

    public void writeVarint32(int r100) throws IOException {
    L3:
        if ((r100 & a.f25611g) == 0) goto L5;
        this.sink.writeByte((r100 & 127) | 128);
        r100 = r100 >>> 7;
        goto L3
    L5:
        this.sink.writeByte(r100);
    }

    public void writeVarint64(long r100) throws IOException {
    L3:
        if (((-128) & r100) == 0) goto L5;
        this.sink.writeByte((((int) r100) & 127) | 128);
        r100 = r100 >>> 7;
        goto L3
    L5:
        this.sink.writeByte((int) r100);
    }

    private static int makeTag(int r100, FieldEncoding r101) {
        return (r100 << 3) | r101.value;
    }

    public void writeTag(int r100, FieldEncoding r101) throws IOException {
        writeVarint32(makeTag(r100, r101));
    }
}
