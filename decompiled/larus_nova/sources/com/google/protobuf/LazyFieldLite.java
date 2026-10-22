package com.google.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes23.dex */
public class LazyFieldLite {
    private static final ExtensionRegistryLite EMPTY_REGISTRY = null;
    private ByteString delayedBytes;
    private ExtensionRegistryLite extensionRegistry;
    private volatile ByteString memoizedBytes;
    protected volatile MessageLite value;

    public void clear() {
        this.delayedBytes = null;
        this.value = null;
        this.memoizedBytes = null;
    }

    public int hashCode() {
        return 1;
    }

    public boolean containsDefaultInstance() {
        ByteString r100 = this.memoizedBytes;
        ByteString r101 = ByteString.EMPTY;
        if (r100 != r101) goto L5;
    L11:
        return true;
    L5:
        if (this.value != null) goto L10;
        ByteString r102 = this.delayedBytes;
        if (r102 == null) goto L11;
        if (r102 == r101) goto L11;
    L10:
        return false;
    }

    public int getSerializedSize() {
        if (this.memoizedBytes != null) goto L5;
        ByteString r100 = this.delayedBytes;
        if (r100 == null) goto L11;
        return r100.size();
    L11:
        if (this.value != null) goto L13;
        return 0;
    L13:
        return this.value.getSerializedSize();
    L5:
        return this.memoizedBytes.size();
    }

    public ByteString toByteString() {
        if (this.memoizedBytes != null) goto L5;
        ByteString r100 = this.delayedBytes;
        if (r100 == null) goto L9;
        return r100;
    L9:
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L11:
        if (this.memoizedBytes == null) goto L16;
        ByteString r101 = this.memoizedBytes;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return r101;
    L16:
        if (this.value != null) goto L18;
        this.memoizedBytes = ByteString.EMPTY;     // Catch: Throwable -> L22
    L19:
        ByteString r102 = this.memoizedBytes;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return r102;
    L18:
        this.memoizedBytes = this.value.toByteString();     // Catch: Throwable -> L22
        goto L19
    L5:
        return this.memoizedBytes;
    }

    static {
        EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
    }

    public LazyFieldLite() {
    }

    public static LazyFieldLite fromValue(MessageLite r100) {
        LazyFieldLite r101 = new LazyFieldLite();
        r101.setValue(r100);
        return r101;
    }

    public void ensureInitialized(MessageLite r100) {
        if (this.value == null) goto L5;
        return;
    L5:
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (this.value == null) goto L23;
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L23:
    L15:
        this.value = r100;     // Catch: Throwable -> L18
        this.memoizedBytes = ByteString.EMPTY;     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L11:
        if (this.delayedBytes == null) goto L13;
        this.value = r100.getParserForType().parseFrom(this.delayedBytes, this.extensionRegistry);     // Catch: InvalidProtocolBufferException -> L15 Throwable -> L18
        this.memoizedBytes = this.delayedBytes;     // Catch: InvalidProtocolBufferException -> L15 Throwable -> L18
    L22:
    L13:
        this.value = r100;     // Catch: InvalidProtocolBufferException -> L15 Throwable -> L18
        this.memoizedBytes = ByteString.EMPTY;     // Catch: InvalidProtocolBufferException -> L15 Throwable -> L18
        goto L22
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LazyFieldLite) == true) goto L9;
        return false;
    L9:
        LazyFieldLite r101 = (LazyFieldLite) r100;
        MessageLite r102 = this.value;
        MessageLite r103 = r101.value;
        if (r102 != null) goto L14;
        if (r103 != null) goto L14;
        return toByteString().equals(r101.toByteString());
    L14:
        if (r102 == null) goto L18;
        if (r103 == null) goto L18;
        return r102.equals(r103);
    L18:
        if (r102 == null) goto L22;
        return r102.equals(r101.getValue(r102.getDefaultInstanceForType()));
    L22:
        return getValue(r103.getDefaultInstanceForType()).equals(r103);
    }

    public MessageLite getValue(MessageLite r100) {
        ensureInitialized(r100);
        return this.value;
    }

    public void merge(LazyFieldLite r100) {
        if (r100.containsDefaultInstance() == false) goto L6;
        return;
    L6:
        if (containsDefaultInstance() == false) goto L10;
        set(r100);
        return;
    L10:
        if (this.extensionRegistry != null) goto L12;
        this.extensionRegistry = r100.extensionRegistry;
    L12:
        ByteString r101 = this.delayedBytes;
        if (r101 == null) goto L19;
        ByteString r102 = r100.delayedBytes;
        if (r102 == null) goto L19;
        this.delayedBytes = r101.concat(r102);
        return;
    L19:
        if (this.value != null) goto L25;
        if (r100.value == null) goto L25;
        setValue(mergeValueAndBytes(r100.value, this.delayedBytes, this.extensionRegistry));
        return;
    L25:
        if (this.value != null) goto L27;
    L30:
        setValue(this.value.toBuilder().mergeFrom(r100.value).build());
        return;
    L27:
        if (r100.value != null) goto L30;
        setValue(mergeValueAndBytes(this.value, r100.delayedBytes, r100.extensionRegistry));
    }

    public void set(LazyFieldLite r100) {
        this.delayedBytes = r100.delayedBytes;
        this.value = r100.value;
        this.memoizedBytes = r100.memoizedBytes;
        ExtensionRegistryLite r101 = r100.extensionRegistry;
        if (r101 == null) goto L6;
        this.extensionRegistry = r101;
        return;
    }

    public MessageLite setValue(MessageLite r100) {
        MessageLite r101 = this.value;
        this.delayedBytes = null;
        this.memoizedBytes = null;
        this.value = r100;
        return r101;
    }

    public LazyFieldLite(ExtensionRegistryLite r100, ByteString r101) {
        checkArguments(r100, r101);
        this.extensionRegistry = r100;
        this.delayedBytes = r101;
    }

    private static void checkArguments(ExtensionRegistryLite r100, ByteString r101) {
        if (r100 == null) goto L8;
        if (r101 == null) goto L6;
        return;
    L6:
        throw new NullPointerException("found null ByteString");
    L8:
        throw new NullPointerException("found null ExtensionRegistry");
    }

    public void mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
        if (containsDefaultInstance() == false) goto L7;
        setByteString(r100.readBytes(), r101);
        return;
    L7:
        if (this.extensionRegistry != null) goto L9;
        this.extensionRegistry = r101;
    L9:
        ByteString r102 = this.delayedBytes;
        if (r102 == null) goto L16;
        setByteString(r102.concat(r100.readBytes()), this.extensionRegistry);
        return;
    L16:
        setValue(this.value.toBuilder().mergeFrom(r100, r101).build());     // Catch: InvalidProtocolBufferException -> L15
        return;
    }

    public void setByteString(ByteString r100, ExtensionRegistryLite r101) {
        checkArguments(r101, r100);
        this.delayedBytes = r100;
        this.extensionRegistry = r101;
        this.value = null;
        this.memoizedBytes = null;
    }

    private static MessageLite mergeValueAndBytes(MessageLite r100, ByteString r101, ExtensionRegistryLite r102) {
        return r100.toBuilder().mergeFrom(r101, r102).build();
    L7:
        return r100;
    }
}
