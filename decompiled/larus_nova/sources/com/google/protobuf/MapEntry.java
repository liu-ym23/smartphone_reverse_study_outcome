package com.google.protobuf;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes23.dex */
public final class MapEntry<K, V> extends AbstractMessage {
    private volatile int cachedSerializedSize;
    private final K key;
    private final Metadata<K, V> metadata;
    private final V value;

    /* JADX INFO: renamed from: com.google.protobuf.MapEntry$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder<K, V> extends AbstractMessage.Builder<Builder<K, V>> {
        private boolean hasKey;
        private boolean hasValue;
        private K key;
        private final Metadata<K, V> metadata;
        private V value;

        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> setUnknownFields(UnknownFieldSet r100) {
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MapEntry<K, V> buildPartial() {
            return new MapEntry(this.metadata, this.key, this.value, null);
        }

        public Builder<K, V> clearKey() {
            this.key = this.metadata.defaultKey;
            this.hasKey = false;
            return this;
        }

        public Builder<K, V> clearValue() {
            this.value = this.metadata.defaultValue;
            this.hasValue = false;
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder<K, V> clone() {
            return new Builder(this.metadata, this.key, this.value, this.hasKey, this.hasValue);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            TreeMap r100 = new TreeMap();
            Iterator<Descriptors.FieldDescriptor> r101 = this.metadata.descriptor.getFields().iterator();
        L4:
            if (r101.hasNext() == false) goto L9;
            Descriptors.FieldDescriptor r102 = r101.next();
            if (hasField(r102) == false) goto L4;
            r100.put(r102, getField(r102));
            goto L4
        L9:
            return Collections.unmodifiableMap(r100);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MapEntry<K, V> getDefaultInstanceForType() {
            Metadata<K, V> r100 = this.metadata;
            return new MapEntry(r100, r100.defaultKey, r100.defaultValue, null);
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return this.metadata.descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return MapEntry.access$600(this.metadata, this.value);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MapEntry<K, V> build() {
            MapEntry<K, V> r100 = buildPartial();
            if (r100.isInitialized() == false) goto L6;
            return r100;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r100);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public UnknownFieldSet getUnknownFields() {
            return UnknownFieldSet.getDefaultInstance();
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo8531clone() throws CloneNotSupportedException {
            return clone();
        }

        private Builder(Metadata<K, V> r100) {
            this(r100, r100.defaultKey, r100.defaultValue, false, false);
        }

        private void checkFieldDescriptor(Descriptors.FieldDescriptor r100) {
            if (r100.getContainingType() != this.metadata.descriptor) goto L6;
            return;
        L6:
            throw new RuntimeException("Wrong FieldDescriptor \"" + r100.getFullName() + "\" used in message \"" + this.metadata.descriptor.getFullName());
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> clearField(Descriptors.FieldDescriptor r100) {
            checkFieldDescriptor(r100);
            if (r100.getNumber() != 1) goto L5;
            clearKey();
        L6:
            return this;
        L5:
            clearValue();
            goto L6
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor r100) {
            checkFieldDescriptor(r100);
            if (r100.getNumber() != 1) goto L5;
            Object r101 = getKey();
        L7:
            if (r100.getType() == Descriptors.FieldDescriptor.Type.ENUM) goto L9;
            return r101;
        L9:
            return r100.getEnumType().findValueByNumberCreatingIfUnknown(((Integer) r101).intValue());
        L5:
            r101 = getValue();
            goto L7
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r100) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor r100) {
            checkFieldDescriptor(r100);
            if (r100.getNumber() != 1) goto L6;
            return this.hasKey;
        L6:
            return this.hasValue;
        }

        @Override // com.google.protobuf.Message.Builder
        public Message.Builder newBuilderForField(Descriptors.FieldDescriptor r100) {
            checkFieldDescriptor(r100);
            if (r100.getNumber() != 2) goto L9;
            if (r100.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L9;
            return ((Message) this.value).newBuilderForType();
        L9:
            throw new RuntimeException("\"" + r100.getFullName() + "\" is not a message value field.");
        }

        public Builder<K, V> setKey(K r100) {
            this.key = r100;
            this.hasKey = true;
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r100) {
            return setUnknownFields(r100);
        }

        public Builder<K, V> setValue(V r100) {
            this.value = r100;
            this.hasValue = true;
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r100) {
            return clearField(r100);
        }

        public /* synthetic */ Builder(Metadata r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r100, int r101) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> setField(Descriptors.FieldDescriptor r100, Object r101) {
            checkFieldDescriptor(r100);
            if (r100.getNumber() != 1) goto L6;
            setKey(r101);
        L15:
            return this;
        L6:
            if (r100.getType() != Descriptors.FieldDescriptor.Type.ENUM) goto L9;
            r101 = Integer.valueOf(((Descriptors.EnumValueDescriptor) r101).getNumber());
        L14:
            setValue(r101);
            goto L15
        L9:
            if (r100.getType() != Descriptors.FieldDescriptor.Type.MESSAGE) goto L14;
            if (r101 == null) goto L14;
            if (this.metadata.defaultValue.getClass().isInstance(r101) == true) goto L14;
            r101 = ((Message) this.metadata.defaultValue).toBuilder().mergeFrom((Message) r101).build();
            goto L14
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
            return addRepeatedField(r100, r101);
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
            return setField(r100, r101);
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
            return setRepeatedField(r100, r101, r102);
        }

        private Builder(Metadata<K, V> r100, K r101, V r102, boolean r103, boolean r104) {
            this.metadata = r100;
            this.key = r101;
            this.value = r102;
            this.hasKey = r103;
            this.hasValue = r104;
        }

        public /* synthetic */ Builder(Metadata r100, Object r101, Object r102, boolean r103, boolean r104, AnonymousClass1 r105) {
            this(r100, r101, r102, r103, r104);
        }
    }

    public static final class Metadata<K, V> extends MapEntryLite.Metadata<K, V> {
        public final Descriptors.Descriptor descriptor;
        public final Parser<MapEntry<K, V>> parser;

        public Metadata(Descriptors.Descriptor r100, MapEntry<K, V> r101, WireFormat.FieldType r102, WireFormat.FieldType r103) {
            super(r102, MapEntry.access$000(r101), r103, MapEntry.access$100(r101));
            this.descriptor = r100;
            this.parser = new AnonymousClass1(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageOrBuilder
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        TreeMap r100 = new TreeMap();
        Iterator<Descriptors.FieldDescriptor> r101 = this.metadata.descriptor.getFields().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Descriptors.FieldDescriptor r102 = r101.next();
        if (hasField(r102) == false) goto L4;
        r100.put(r102, getField(r102));
        goto L4
    L9:
        return Collections.unmodifiableMap(r100);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public MapEntry<K, V> getDefaultInstanceForType() {
        Metadata<K, V> r100 = this.metadata;
        return new MapEntry(r100, r100.defaultKey, r100.defaultValue);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Descriptors.Descriptor getDescriptorForType() {
        return this.metadata.descriptor;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<MapEntry<K, V>> getParserForType() {
        return this.metadata.parser;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        if (this.cachedSerializedSize != (-1)) goto L5;
        int r100 = MapEntryLite.computeSerializedSize(this.metadata, this.key, this.value);
        this.cachedSerializedSize = r100;
        return r100;
    L5:
        return this.cachedSerializedSize;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        return isInitialized(this.metadata, this.value);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder<K, V> newBuilderForType() {
        return new Builder(this.metadata, null);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder<K, V> toBuilder() {
        return new Builder(this.metadata, this.key, this.value, true, true, null);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    public K getKey() {
        return this.key;
    }

    public final Metadata<K, V> getMetadata() {
        return this.metadata;
    }

    public V getValue() {
        return this.value;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public static /* synthetic */ Object access$000(MapEntry r100) {
        return r100.key;
    }

    public static /* synthetic */ Object access$100(MapEntry r100) {
        return r100.value;
    }

    private void checkFieldDescriptor(Descriptors.FieldDescriptor r100) {
        if (r100.getContainingType() != this.metadata.descriptor) goto L6;
        return;
    L6:
        throw new RuntimeException("Wrong FieldDescriptor \"" + r100.getFullName() + "\" used in message \"" + this.metadata.descriptor.getFullName());
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getField(Descriptors.FieldDescriptor r100) {
        checkFieldDescriptor(r100);
        if (r100.getNumber() != 1) goto L5;
        Object r101 = getKey();
    L7:
        if (r100.getType() == Descriptors.FieldDescriptor.Type.ENUM) goto L9;
        return r101;
    L9:
        return r100.getEnumType().findValueByNumberCreatingIfUnknown(((Integer) r101).intValue());
    L5:
        r101 = getValue();
        goto L7
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor r100) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasField(Descriptors.FieldDescriptor r100) {
        checkFieldDescriptor(r100);
        return true;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r100) throws IOException {
        MapEntryLite.writeTo(r100, this.metadata, this.key, this.value);
    }

    public static /* synthetic */ boolean access$600(Metadata r100, Object r101) {
        return isInitialized(r100, r101);
    }

    private static <V> boolean isInitialized(Metadata r100, V r101) {
        if (r100.valueType.getJavaType() == WireFormat.JavaType.MESSAGE) goto L5;
        return true;
    L5:
        return ((MessageLite) r101).isInitialized();
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getRepeatedField(Descriptors.FieldDescriptor r100, int r101) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }

    private MapEntry(Metadata<K, V> r100, CodedInputStream r101, ExtensionRegistryLite r102) throws InvalidProtocolBufferException {
        this.cachedSerializedSize = -1;
        this.metadata = r100;     // Catch: IOException -> L5 InvalidProtocolBufferException -> L8
        Map.Entry r103 = MapEntryLite.parseEntry(r101, r100, r102);     // Catch: IOException -> L5 InvalidProtocolBufferException -> L8
        this.key = (K) r103.getKey();     // Catch: IOException -> L5 InvalidProtocolBufferException -> L8
        this.value = (V) r103.getValue();     // Catch: IOException -> L5 InvalidProtocolBufferException -> L8
        return;
    L8:
        e = move-exception;
        throw e.setUnfinishedMessage(this);
    L5:
        e = move-exception;
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
    }

    private MapEntry(Metadata r100, K r101, V r102) {
        this.cachedSerializedSize = -1;
        this.key = r101;
        this.value = r102;
        this.metadata = r100;
    }

    public /* synthetic */ MapEntry(Metadata r100, CodedInputStream r101, ExtensionRegistryLite r102, AnonymousClass1 r103) throws InvalidProtocolBufferException {
        this(r100, r101, r102);
    }

    public /* synthetic */ MapEntry(Metadata r100, Object r101, Object r102, AnonymousClass1 r103) {
        this(r100, r101, r102);
    }

    private MapEntry(Descriptors.Descriptor r100, WireFormat.FieldType r101, K r102, WireFormat.FieldType r103, V r104) {
        this.cachedSerializedSize = -1;
        this.key = r102;
        this.value = r104;
        this.metadata = new Metadata(r100, this, r101, r103);
    }

    public static <K, V> MapEntry<K, V> newDefaultInstance(Descriptors.Descriptor r100, WireFormat.FieldType r101, K r102, WireFormat.FieldType r110, V r111) {
        return new MapEntry(r100, r101, r102, r110, r111);
    }
}
