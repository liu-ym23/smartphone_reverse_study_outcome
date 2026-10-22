package com.google.protobuf;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class MapEntryLite<K, V> {
    private static final int KEY_FIELD_NUMBER = 1;
    private static final int VALUE_FIELD_NUMBER = 2;
    private final K key;
    private final Metadata<K, V> metadata;
    private final V value;

    /* JADX INFO: renamed from: com.google.protobuf.MapEntryLite$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r100 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r100;
            r100[WireFormat.FieldType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class Metadata<K, V> {
        public final K defaultKey;
        public final V defaultValue;
        public final WireFormat.FieldType keyType;
        public final WireFormat.FieldType valueType;

        public Metadata(WireFormat.FieldType r100, K r101, WireFormat.FieldType r102, V r103) {
            this.keyType = r100;
            this.defaultKey = r101;
            this.valueType = r102;
            this.defaultValue = r103;
        }
    }

    public K getKey() {
        return this.key;
    }

    public Metadata<K, V> getMetadata() {
        return this.metadata;
    }

    public V getValue() {
        return this.value;
    }

    public Map.Entry<K, V> parseEntry(ByteString r100, ExtensionRegistryLite r101) throws IOException {
        return parseEntry(r100.newCodedInput(), this.metadata, r101);
    }

    private MapEntryLite(Metadata<K, V> r100, K r101, V r102) {
        this.metadata = r100;
        this.key = r101;
        this.value = r102;
    }

    public static <K, V> int computeSerializedSize(Metadata<K, V> r100, K r101, V r102) {
        return FieldSet.computeElementSize(r100.keyType, 1, r101) + FieldSet.computeElementSize(r100.valueType, 2, r102);
    }

    public static <K, V> Map.Entry<K, V> parseEntry(CodedInputStream r100, Metadata<K, V> r101, ExtensionRegistryLite r102) throws IOException {
        Object r103 = r101.defaultKey;
        Object r104 = r101.defaultValue;
    L3:
        int r105 = r100.readTag();
        if (r105 == 0) goto L15;
        if (r105 == WireFormat.makeTag(1, r101.keyType.getWireType())) goto L8;
        if (r105 == WireFormat.makeTag(2, r101.valueType.getWireType())) goto L11;
        if (r100.skipField(r105) == true) goto L3;
    L11:
        r104 = parseField(r100, r102, r101.valueType, r104);
        goto L3
    L8:
        r103 = parseField(r100, r102, r101.keyType, r103);
    L15:
        return new AbstractMap.SimpleImmutableEntry(r103, r104);
    }

    public int computeMessageSize(int r100, K r101, V r102) {
        return CodedOutputStream.computeTagSize(r100) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSerializedSize(this.metadata, r101, r102));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void parseInto(MapFieldLite<K, V> r100, CodedInputStream r101, ExtensionRegistryLite r102) throws IOException {
        int r103 = r101.pushLimit(r101.readRawVarint32());
        Metadata<K, V> r104 = this.metadata;
        Object r105 = r104.defaultKey;
        Object r106 = r104.defaultValue;
    L3:
        int r107 = r101.readTag();
        if (r107 == 0) goto L14;
        if (r107 == WireFormat.makeTag(1, this.metadata.keyType.getWireType())) goto L8;
        if (r107 == WireFormat.makeTag(2, this.metadata.valueType.getWireType())) goto L11;
        if (r101.skipField(r107) == true) goto L3;
    L11:
        r106 = parseField(r101, r102, this.metadata.valueType, r106);
        goto L3
    L8:
        r105 = parseField(r101, r102, this.metadata.keyType, r105);
    L14:
        r101.checkLastTagWas(0);
        r101.popLimit(r103);
        r100.put(r105, r106);
    }

    private MapEntryLite(WireFormat.FieldType r100, K r101, WireFormat.FieldType r102, V r103) {
        this.metadata = new Metadata(r100, r101, r102, r103);
        this.key = r101;
        this.value = r103;
    }

    public static <K, V> MapEntryLite<K, V> newDefaultInstance(WireFormat.FieldType r100, K r101, WireFormat.FieldType r102, V r103) {
        return new MapEntryLite(r100, r101, r102, r103);
    }

    public static <T> T parseField(CodedInputStream r100, ExtensionRegistryLite r101, WireFormat.FieldType r102, T r103) throws IOException {
        int r104 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r102.ordinal()];
        if (r104 != 1) goto L5;
        MessageLite.Builder r105 = ((MessageLite) r103).toBuilder();
        r100.readMessage(r105, r101);
        return (T) r105.buildPartial();
    L5:
        if (r104 == 2) goto L13;
        if (r104 == 3) goto L11;
        return (T) FieldSet.readPrimitiveField(r100, r102, true);
    L11:
        throw new RuntimeException("Groups are not allowed in maps.");
    L13:
        return (T) Integer.valueOf(r100.readEnum());
    }

    public static <K, V> void writeTo(CodedOutputStream r100, Metadata<K, V> r101, K r102, V r103) throws IOException {
        FieldSet.writeElement(r100, r101.keyType, 1, r102);
        FieldSet.writeElement(r100, r101.valueType, 2, r103);
    }

    public void serializeTo(CodedOutputStream r100, int r101, K r102, V r103) throws IOException {
        r100.writeTag(r101, 2);
        r100.writeUInt32NoTag(computeSerializedSize(this.metadata, r102, r103));
        writeTo(r100, this.metadata, r102, r103);
    }
}
