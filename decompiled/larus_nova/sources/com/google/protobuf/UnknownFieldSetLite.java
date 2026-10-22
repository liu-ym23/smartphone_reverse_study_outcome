package com.google.protobuf;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes23.dex */
public final class UnknownFieldSetLite {
    private static final UnknownFieldSetLite DEFAULT_INSTANCE = null;
    private static final int MIN_CAPACITY = 8;
    private int count;
    private boolean isMutable;
    private int memoizedSerializedSize;
    private Object[] objects;
    private int[] tags;

    public void makeImmutable() {
        this.isMutable = false;
    }

    static {
        DEFAULT_INSTANCE = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
    }

    private UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    private void ensureCapacity() {
        int r100 = this.count;
        int[] r101 = this.tags;
        if (r100 == r101.length) goto L5;
        return;
    L5:
        if (r100 >= 4) goto L7;
        int r102 = 8;
    L8:
        int r103 = r100 + r102;
        this.tags = Arrays.copyOf(r101, r103);
        this.objects = Arrays.copyOf(this.objects, r103);
        return;
    L7:
        r102 = r100 >> 1;
        goto L8
    }

    public static UnknownFieldSetLite newInstance() {
        return new UnknownFieldSetLite();
    }

    public void checkMutable() {
        if (this.isMutable == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    public int getSerializedSize() {
        int r100 = this.memoizedSerializedSize;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        int r101 = 0;
        int r102 = 0;
    L7:
        if (r101 >= this.count) goto L26;
        int r103 = this.tags[r101];
        int r104 = WireFormat.getTagFieldNumber(r103);
        int r105 = WireFormat.getTagWireType(r103);
        if (r105 != 0) goto L11;
        int r106 = CodedOutputStream.computeUInt64Size(r104, ((Long) this.objects[r101]).longValue());
    L25:
        r102 = r102 + r106;
        r101 = r101 + 1;
        goto L7
    L11:
        if (r105 != 1) goto L13;
        r106 = CodedOutputStream.computeFixed64Size(r104, ((Long) this.objects[r101]).longValue());
        goto L25
    L13:
        if (r105 != 2) goto L15;
        r106 = CodedOutputStream.computeBytesSize(r104, (ByteString) this.objects[r101]);
        goto L25
    L15:
        if (r105 != 3) goto L17;
        r106 = (CodedOutputStream.computeTagSize(r104) * 2) + ((UnknownFieldSetLite) this.objects[r101]).getSerializedSize();
        goto L25
    L17:
        if (r105 != 5) goto L20;
        r106 = CodedOutputStream.computeFixed32Size(r104, ((Integer) this.objects[r101]).intValue());
        goto L25
    L20:
        throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
    L26:
        this.memoizedSerializedSize = r102;
        return r102;
    }

    public int getSerializedSizeAsMessageSet() {
        int r100 = this.memoizedSerializedSize;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        int r101 = 0;
        int r102 = 0;
    L7:
        if (r101 >= this.count) goto L9;
        r102 = r102 + CodedOutputStream.computeRawMessageSetExtensionSize(WireFormat.getTagFieldNumber(this.tags[r101]), (ByteString) this.objects[r101]);
        r101 = r101 + 1;
        goto L7
    L9:
        this.memoizedSerializedSize = r102;
        return r102;
    }

    public int hashCode() {
        return ((((TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER + this.count) * 31) + Arrays.hashCode(this.tags)) * 31) + Arrays.deepHashCode(this.objects);
    }

    public static UnknownFieldSetLite getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private UnknownFieldSetLite mergeFrom(CodedInputStream r100) throws IOException {
    L2:
        int r101 = r100.readTag();
        if (r101 == 0) goto L6;
        if (mergeFieldFrom(r101, r100) == true) goto L2;
    L6:
        return this;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if ((r100 instanceof UnknownFieldSetLite) == true) goto L11;
        return false;
    L11:
        UnknownFieldSetLite r101 = (UnknownFieldSetLite) r100;
        int r102 = this.count;
        if (r102 == r101.count) goto L14;
    L19:
        return false;
    L14:
        if (equals(this.tags, r101.tags, r102) == false) goto L19;
        if (equals(this.objects, r101.objects, this.count) == false) goto L19;
        return true;
    }

    public void writeAsMessageSetTo(CodedOutputStream r100) throws IOException {
        int r101 = 0;
    L4:
        if (r101 >= this.count) goto L6;
        r100.writeRawMessageSetExtension(WireFormat.getTagFieldNumber(this.tags[r101]), (ByteString) this.objects[r101]);
        r101 = r101 + 1;
        goto L4
    }

    public void writeTo(CodedOutputStream r100) throws IOException {
        int r101 = 0;
    L4:
        if (r101 >= this.count) goto L23;
        int r102 = this.tags[r101];
        int r103 = WireFormat.getTagFieldNumber(r102);
        int r104 = WireFormat.getTagWireType(r102);
        if (r104 != 0) goto L8;
        r100.writeUInt64(r103, ((Long) this.objects[r101]).longValue());
    L22:
        r101 = r101 + 1;
        goto L4
    L8:
        if (r104 != 1) goto L10;
        r100.writeFixed64(r103, ((Long) this.objects[r101]).longValue());
        goto L22
    L10:
        if (r104 != 2) goto L12;
        r100.writeBytes(r103, (ByteString) this.objects[r101]);
        goto L22
    L12:
        if (r104 != 3) goto L14;
        r100.writeTag(r103, 3);
        ((UnknownFieldSetLite) this.objects[r101]).writeTo(r100);
        r100.writeTag(r103, 4);
        goto L22
    L14:
        if (r104 != 5) goto L17;
        r100.writeFixed32(r103, ((Integer) this.objects[r101]).intValue());
        goto L22
    L17:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public static UnknownFieldSetLite mutableCopyOf(UnknownFieldSetLite r100, UnknownFieldSetLite r101) {
        int r102 = r100.count + r101.count;
        int[] r103 = Arrays.copyOf(r100.tags, r102);
        System.arraycopy(r101.tags, 0, r103, r100.count, r101.count);
        Object[] r104 = Arrays.copyOf(r100.objects, r102);
        System.arraycopy(r101.objects, 0, r104, r100.count, r101.count);
        return new UnknownFieldSetLite(r102, r103, r104, true);
    }

    public boolean mergeFieldFrom(int r100, CodedInputStream r101) throws IOException {
        checkMutable();
        int r102 = WireFormat.getTagFieldNumber(r100);
        int r103 = WireFormat.getTagWireType(r100);
        if (r103 == 0) goto L24;
        if (r103 != 1) goto L6;
        storeField(r100, Long.valueOf(r101.readFixed64()));
        return true;
    L6:
        if (r103 != 2) goto L8;
        storeField(r100, r101.readBytes());
        return true;
    L8:
        if (r103 == 3) goto L18;
        if (r103 != 4) goto L11;
        return false;
    L11:
        if (r103 != 5) goto L15;
        storeField(r100, Integer.valueOf(r101.readFixed32()));
        return true;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L18:
        UnknownFieldSetLite r104 = new UnknownFieldSetLite();
        r104.mergeFrom(r101);
        r101.checkLastTagWas(WireFormat.makeTag(r102, 4));
        storeField(r100, r104);
        return true;
    L24:
        storeField(r100, Long.valueOf(r101.readInt64()));
        return true;
    }

    public UnknownFieldSetLite mergeLengthDelimitedField(int r100, ByteString r101) {
        checkMutable();
        if (r100 == 0) goto L7;
        storeField(WireFormat.makeTag(r100, 2), r101);
        return this;
    L7:
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    public UnknownFieldSetLite mergeVarintField(int r100, int r101) {
        checkMutable();
        if (r100 == 0) goto L7;
        storeField(WireFormat.makeTag(r100, 0), Long.valueOf(r101));
        return this;
    L7:
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    public final void printWithIndent(StringBuilder r100, int r101) {
        int r102 = 0;
    L4:
        if (r102 >= this.count) goto L6;
        MessageLiteToString.printField(r100, r101, String.valueOf(WireFormat.getTagFieldNumber(this.tags[r102])), this.objects[r102]);
        r102 = r102 + 1;
        goto L4
    }

    public void storeField(int r100, Object r101) {
        checkMutable();
        ensureCapacity();
        int[] r102 = this.tags;
        int r103 = this.count;
        r102[r103] = r100;
        this.objects[r103] = r101;
        this.count = r103 + 1;
    }

    private static boolean equals(Object[] r100, Object[] r101, int r102) {
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (r100[r103].equals(r101[r103]) == false) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    private static boolean equals(int[] r100, int[] r101, int r102) {
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (r100[r103] != r101[r103]) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    private UnknownFieldSetLite(int r100, int[] r101, Object[] r102, boolean r103) {
        this.memoizedSerializedSize = -1;
        this.count = r100;
        this.tags = r101;
        this.objects = r102;
        this.isMutable = r103;
    }
}
