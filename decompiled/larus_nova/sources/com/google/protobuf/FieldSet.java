package com.google.protobuf;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.protobuf.FieldSet.FieldDescriptorLite;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>> {
    private static final FieldSet DEFAULT_INSTANCE = null;
    private final SmallSortedMap<FieldDescriptorType, Object> fields;
    private boolean hasLazyField;
    private boolean isImmutable;

    /* JADX INFO: renamed from: com.google.protobuf.FieldSet$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType = null;

        static {
            int[] r100 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r100;
            r100[WireFormat.FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L40
        L81:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L41
        L97:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L42
        L105:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L43
        L109:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L44
        L69:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L45
        L71:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 7;     // Catch: NoSuchFieldError -> L46
        L89:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L47
        L91:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 9;     // Catch: NoSuchFieldError -> L48
        L111:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L49
        L115:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 11;     // Catch: NoSuchFieldError -> L50
        L73:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 12;     // Catch: NoSuchFieldError -> L51
        L79:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 13;     // Catch: NoSuchFieldError -> L52
        L95:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 14;     // Catch: NoSuchFieldError -> L53
        L101:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 15;     // Catch: NoSuchFieldError -> L54
        L119:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 16;     // Catch: NoSuchFieldError -> L55
        L67:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 17;     // Catch: NoSuchFieldError -> L56
        L83:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 18;     // Catch: NoSuchFieldError -> L57
        L29:
            int[] r101 = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = r101;
            r101[WireFormat.JavaType.INT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L58
        L103:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.LONG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L59
        L107:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.FLOAT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L60
        L117:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.DOUBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L61
        L75:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L62
        L85:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.STRING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L63
        L87:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;     // Catch: NoSuchFieldError -> L64
        L93:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 8;     // Catch: NoSuchFieldError -> L65
        L113:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.MESSAGE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L66
            return;
        }
    }

    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        Internal.EnumLiteMap<?> getEnumType();

        WireFormat.JavaType getLiteJavaType();

        WireFormat.FieldType getLiteType();

        int getNumber();

        MessageLite.Builder internalMergeFrom(MessageLite.Builder r100, MessageLite r101);

        boolean isPacked();

        boolean isRepeated();
    }

    public int getMessageSetSerializedSize() {
        int r100 = 0;
        int r101 = 0;
    L4:
        if (r100 >= this.fields.getNumArrayEntries()) goto L6;
        r101 = r101 + getMessageSetSerializedSize(this.fields.getArrayEntryAt(r100));
        r100 = r100 + 1;
        goto L4
    L6:
        Iterator r102 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r101 = r101 + getMessageSetSerializedSize((Map.Entry) r102.next());
        goto L8
    L10:
        return r101;
    }

    public int getSerializedSize() {
        int r100 = 0;
        int r101 = 0;
    L4:
        if (r100 >= this.fields.getNumArrayEntries()) goto L6;
        Map.Entry<K, Object> r102 = this.fields.getArrayEntryAt(r100);
        r101 = r101 + computeFieldSize((FieldDescriptorLite) r102.getKey(), r102.getValue());
        r100 = r100 + 1;
        goto L4
    L6:
        Iterator r103 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        Map.Entry r104 = (Map.Entry) r103.next();
        r101 = r101 + computeFieldSize((FieldDescriptorLite) r104.getKey(), r104.getValue());
        goto L8
    L10:
        return r101;
    }

    public boolean isInitialized() {
        int r100 = 0;
    L4:
        if (r100 >= this.fields.getNumArrayEntries()) goto L9;
        if (isInitialized(this.fields.getArrayEntryAt(r100)) == false) goto L7;
        r100 = r100 + 1;
        goto L4
    L7:
        return false;
    L9:
        Iterator r101 = this.fields.getOverflowEntries().iterator();
    L11:
        if (r101.hasNext() == false) goto L15;
        if (isInitialized((Map.Entry) r101.next()) == true) goto L11;
        return false;
    L15:
        return true;
    }

    static {
        DEFAULT_INSTANCE = new FieldSet(true);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet();
    }

    public void clear() {
        this.fields.clear();
        this.hasLazyField = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Map<FieldDescriptorType, Object> getAllFields() {
        if (this.hasLazyField == false) goto L17;
        SmallSortedMap r100 = SmallSortedMap.newFieldMap(16);
        int r101 = 0;
    L6:
        if (r101 >= this.fields.getNumArrayEntries()) goto L8;
        cloneFieldEntry(r100, this.fields.getArrayEntryAt(r101));
        r101 = r101 + 1;
        goto L6
    L8:
        Iterator r102 = this.fields.getOverflowEntries().iterator();
    L10:
        if (r102.hasNext() == false) goto L13;
        cloneFieldEntry(r100, (Map.Entry) r102.next());
        goto L10
    L13:
        if (this.fields.isImmutable() == false) goto L15;
        r100.makeImmutable();
    L15:
        return r100;
    L17:
        if (this.fields.isImmutable() == false) goto L20;
        return this.fields;
    L20:
        return Collections.unmodifiableMap(this.fields);
    }

    public int hashCode() {
        return this.fields.hashCode();
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        if (this.hasLazyField == false) goto L7;
        return new LazyField.LazyIterator(this.fields.entrySet().iterator());
    L7:
        return this.fields.entrySet().iterator();
    }

    public void makeImmutable() {
        if (this.isImmutable == false) goto L5;
        return;
    L5:
        this.fields.makeImmutable();
        this.isImmutable = true;
    }

    private FieldSet() {
        this.hasLazyField = false;
        this.fields = SmallSortedMap.newFieldMap(16);
    }

    public FieldSet<FieldDescriptorType> clone() {
        FieldSet<FieldDescriptorType> r100 = newFieldSet();
        int r101 = 0;
    L4:
        if (r101 >= this.fields.getNumArrayEntries()) goto L6;
        Map.Entry<K, Object> r102 = this.fields.getArrayEntryAt(r101);
        r100.setField((FieldDescriptorLite) r102.getKey(), r102.getValue());
        r101 = r101 + 1;
        goto L4
    L6:
        Iterator r103 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        Map.Entry r104 = (Map.Entry) r103.next();
        r100.setField((FieldDescriptorLite) r104.getKey(), r104.getValue());
        goto L8
    L10:
        r100.hasLazyField = this.hasLazyField;
        return r100;
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return DEFAULT_INSTANCE;
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8532clone() throws CloneNotSupportedException {
        return clone();
    }

    private FieldSet(boolean r100) {
        this.hasLazyField = false;
        this.fields = SmallSortedMap.newFieldMap(0);
        makeImmutable();
    }

    private Object cloneIfMutable(Object r100) {
        if ((r100 instanceof byte[]) == false) goto L6;
        byte[] r101 = (byte[]) r100;
        byte[] r102 = new byte[r101.length];
        System.arraycopy(r101, 0, r102, 0, r101.length);
        return r102;
    L6:
        return r100;
    }

    private int getMessageSetSerializedSize(Map.Entry<FieldDescriptorType, Object> r100) {
        FieldDescriptorType r101 = r100.getKey();
        Object r102 = r100.getValue();
        if (r101.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L15;
        if (r101.isRepeated() == true) goto L15;
        if (r101.isPacked() == true) goto L15;
        if ((r102 instanceof LazyField) == false) goto L13;
        return CodedOutputStream.computeLazyFieldMessageSetExtensionSize(r100.getKey().getNumber(), (LazyField) r102);
    L13:
        return CodedOutputStream.computeMessageSetExtensionSize(r100.getKey().getNumber(), (MessageLite) r102);
    L15:
        return computeFieldSize(r101, r102);
    }

    private boolean isInitialized(Map.Entry<FieldDescriptorType, Object> r100) {
        FieldDescriptorType r101 = r100.getKey();
        if (r101.getLiteJavaType() == WireFormat.JavaType.MESSAGE) goto L5;
    L22:
        return true;
    L5:
        if (r101.isRepeated() == false) goto L12;
        Iterator r102 = ((List) r100.getValue()).iterator();
    L8:
        if (r102.hasNext() == false) goto L22;
        if (((MessageLite) r102.next()).isInitialized() == true) goto L8;
        return false;
    L12:
        Object r103 = r100.getValue();
        if ((r103 instanceof MessageLite) == false) goto L18;
        if (((MessageLite) r103).isInitialized() == true) goto L22;
        return false;
    L18:
        if ((r103 instanceof LazyField) == false) goto L21;
        return true;
    L21:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private void mergeFromField(Map.Entry<FieldDescriptorType, Object> r100) {
        FieldDescriptorType r101 = r100.getKey();
        Object r102 = r100.getValue();
        if ((r102 instanceof LazyField) == false) goto L6;
        r102 = ((LazyField) r102).getValue();
    L6:
        if (r101.isRepeated() == false) goto L16;
        Object r103 = getField(r101);
        if (r103 != null) goto L10;
        r103 = new ArrayList();
    L10:
        Iterator r104 = ((List) r102).iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        ((List) r103).add(cloneIfMutable(r104.next()));
        goto L12
    L14:
        this.fields.put(r101, r103);
        return;
    L16:
        if (r101.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L21;
        Object r105 = getField(r101);
        if (r105 != null) goto L20;
        this.fields.put(r101, cloneIfMutable(r102));
        return;
    L20:
        MessageLite r106 = r101.internalMergeFrom(((MessageLite) r105).toBuilder(), (MessageLite) r102).build();
        this.fields.put(r101, r106);
        return;
    L21:
        this.fields.put(r101, cloneIfMutable(r102));
    }

    public void clearField(FieldDescriptorType r100) {
        this.fields.remove(r100);
        if (this.fields.isEmpty() == false) goto L6;
        this.hasLazyField = false;
        return;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FieldSet) == true) goto L10;
        return false;
    L10:
        return this.fields.equals(((FieldSet) r100).fields);
    }

    public Object getField(FieldDescriptorType r100) {
        Object r101 = this.fields.get(r100);
        if ((r101 instanceof LazyField) == true) goto L5;
        return r101;
    L5:
        return ((LazyField) r101).getValue();
    }

    public int getRepeatedFieldCount(FieldDescriptorType r100) {
        if (r100.isRepeated() == false) goto L11;
        Object r101 = getField(r100);
        if (r101 != null) goto L9;
        return 0;
    L9:
        return ((List) r101).size();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public boolean hasField(FieldDescriptorType r100) {
        if (r100.isRepeated() == true) goto L10;
        if (this.fields.get(r100) == null) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public void mergeFrom(FieldSet<FieldDescriptorType> r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.fields.getNumArrayEntries()) goto L6;
        mergeFromField(r100.fields.getArrayEntryAt(r101));
        r101 = r101 + 1;
        goto L4
    L6:
        Iterator r102 = r100.fields.getOverflowEntries().iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        mergeFromField((Map.Entry) r102.next());
        goto L8
    }

    public void writeMessageSetTo(CodedOutputStream r100) throws IOException {
        int r101 = 0;
    L4:
        if (r101 >= this.fields.getNumArrayEntries()) goto L6;
        writeMessageSetTo(this.fields.getArrayEntryAt(r101), r100);
        r101 = r101 + 1;
        goto L4
    L6:
        Iterator r102 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        writeMessageSetTo((Map.Entry) r102.next(), r100);
        goto L8
    }

    public void writeTo(CodedOutputStream r100) throws IOException {
        int r101 = 0;
    L4:
        if (r101 >= this.fields.getNumArrayEntries()) goto L6;
        Map.Entry<K, Object> r102 = this.fields.getArrayEntryAt(r101);
        writeField((FieldDescriptorLite) r102.getKey(), r102.getValue(), r100);
        r101 = r101 + 1;
        goto L4
    L6:
        Iterator r103 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        Map.Entry r104 = (Map.Entry) r103.next();
        writeField((FieldDescriptorLite) r104.getKey(), r104.getValue(), r100);
        goto L8
    }

    private void cloneFieldEntry(Map<FieldDescriptorType, Object> r100, Map.Entry<FieldDescriptorType, Object> r101) {
        FieldDescriptorType r102 = r101.getKey();
        Object r103 = r101.getValue();
        if ((r103 instanceof LazyField) == false) goto L5;
        r100.put(r102, ((LazyField) r103).getValue());
        return;
    L5:
        r100.put(r102, r103);
    }

    public static int computeElementSizeNoTag(WireFormat.FieldType r100, Object r101) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r100.ordinal()]) {
            case 1: goto L57;
            case 2: goto L55;
            case 3: goto L53;
            case 4: goto L51;
            case 5: goto L49;
            case 6: goto L47;
            case 7: goto L45;
            case 8: goto L43;
            case 9: goto L41;
            case 10: goto L35;
            case 11: goto L29;
            case 12: goto L23;
            case 13: goto L21;
            case 14: goto L19;
            case 15: goto L17;
            case 16: goto L15;
            case 17: goto L13;
            case 18: goto L7;
            default: goto L5;
        };
    L5:
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    L7:
        if ((r101 instanceof Internal.EnumLite) == false) goto L11;
        return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) r101).getNumber());
    L11:
        return CodedOutputStream.computeEnumSizeNoTag(((Integer) r101).intValue());
    L13:
        return CodedOutputStream.computeSInt64SizeNoTag(((Long) r101).longValue());
    L15:
        return CodedOutputStream.computeSInt32SizeNoTag(((Integer) r101).intValue());
    L17:
        return CodedOutputStream.computeSFixed64SizeNoTag(((Long) r101).longValue());
    L19:
        return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) r101).intValue());
    L21:
        return CodedOutputStream.computeUInt32SizeNoTag(((Integer) r101).intValue());
    L23:
        if ((r101 instanceof ByteString) == false) goto L27;
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) r101);
    L27:
        return CodedOutputStream.computeByteArraySizeNoTag((byte[]) r101);
    L29:
        if ((r101 instanceof ByteString) == false) goto L33;
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) r101);
    L33:
        return CodedOutputStream.computeStringSizeNoTag((String) r101);
    L35:
        if ((r101 instanceof LazyField) == false) goto L39;
        return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) r101);
    L39:
        return CodedOutputStream.computeMessageSizeNoTag((MessageLite) r101);
    L41:
        return CodedOutputStream.computeGroupSizeNoTag((MessageLite) r101);
    L43:
        return CodedOutputStream.computeBoolSizeNoTag(((Boolean) r101).booleanValue());
    L45:
        return CodedOutputStream.computeFixed32SizeNoTag(((Integer) r101).intValue());
    L47:
        return CodedOutputStream.computeFixed64SizeNoTag(((Long) r101).longValue());
    L49:
        return CodedOutputStream.computeInt32SizeNoTag(((Integer) r101).intValue());
    L51:
        return CodedOutputStream.computeUInt64SizeNoTag(((Long) r101).longValue());
    L53:
        return CodedOutputStream.computeInt64SizeNoTag(((Long) r101).longValue());
    L55:
        return CodedOutputStream.computeFloatSizeNoTag(((Float) r101).floatValue());
    L57:
        return CodedOutputStream.computeDoubleSizeNoTag(((Double) r101).doubleValue());
    }

    public static int computeFieldSize(FieldDescriptorLite<?> r100, Object r101) {
        WireFormat.FieldType r102 = r100.getLiteType();
        int r103 = r100.getNumber();
        if (r100.isRepeated() == false) goto L18;
        int r104 = 0;
        if (r100.isPacked() == false) goto L12;
        Iterator r105 = ((List) r101).iterator();
    L8:
        if (r105.hasNext() == false) goto L11;
        r104 = r104 + computeElementSizeNoTag(r102, r105.next());
        goto L8
    L11:
        return (CodedOutputStream.computeTagSize(r103) + r104) + CodedOutputStream.computeRawVarint32Size(r104);
    L12:
        Iterator r106 = ((List) r101).iterator();
    L14:
        if (r106.hasNext() == false) goto L16;
        r104 = r104 + computeElementSize(r102, r103, r106.next());
        goto L14
    L16:
        return r104;
    L18:
        return computeElementSize(r102, r103, r101);
    }

    public static int getWireFormatForFieldType(WireFormat.FieldType r100, boolean r101) {
        if (r101 == false) goto L6;
        return 2;
    L6:
        return r100.getWireType();
    }

    private static void verifyType(WireFormat.FieldType r100, Object r101) {
        Internal.checkNotNull(r101);
        boolean r102 = true;
        boolean r103 = false;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[r100.getJavaType().ordinal()]) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L16;
            case 8: goto L11;
            case 9: goto L6;
            default: goto L28;
        };
    L22:
        r103 = r101 instanceof String;
        goto L28
    L23:
        r103 = r101 instanceof Boolean;
        goto L28
    L24:
        r103 = r101 instanceof Double;
        goto L28
    L25:
        r103 = r101 instanceof Float;
        goto L28
    L26:
        r103 = r101 instanceof Long;
        goto L28
    L27:
        r103 = r101 instanceof Integer;
    L28:
        if (r103 == false) goto L31;
        return;
    L31:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    L6:
        if ((r101 instanceof MessageLite) == false) goto L8;
    L21:
        r103 = r102;
        goto L28
    L8:
        if ((r101 instanceof LazyField) == true) goto L21;
    L20:
        r102 = false;
        goto L21
    L11:
        if ((r101 instanceof Integer) == true) goto L21;
        if ((r101 instanceof Internal.EnumLite) == false) goto L20;
    L16:
        if ((r101 instanceof ByteString) == true) goto L21;
        if ((r101 instanceof byte[]) == false) goto L20;
        goto L20
    }

    private void writeMessageSetTo(Map.Entry<FieldDescriptorType, Object> r100, CodedOutputStream r101) throws IOException {
        FieldDescriptorType r102 = r100.getKey();
        if (r102.getLiteJavaType() == WireFormat.JavaType.MESSAGE) goto L5;
    L12:
        writeField(r102, r100.getValue(), r101);
        return;
    L5:
        if (r102.isRepeated() == true) goto L12;
        if (r102.isPacked() == true) goto L12;
        Object r103 = r100.getValue();
        if ((r103 instanceof LazyField) == false) goto L11;
        r103 = ((LazyField) r103).getValue();
    L11:
        r101.writeMessageSetExtension(r100.getKey().getNumber(), (MessageLite) r103);
    }

    public void addRepeatedField(FieldDescriptorType r100, Object r101) {
        if (r100.isRepeated() == false) goto L11;
        verifyType(r100.getLiteType(), r101);
        Object r102 = getField(r100);
        if (r102 != null) goto L7;
        List r103 = new ArrayList();
        this.fields.put(r100, r103);
    L8:
        r103.add(r101);
        return;
    L7:
        r103 = (List) r102;
        goto L8
    L11:
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public Object getRepeatedField(FieldDescriptorType r100, int r101) {
        if (r100.isRepeated() == false) goto L11;
        Object r102 = getField(r100);
        if (r102 == null) goto L9;
        return ListProtector.get((List) r102, r101);
    L9:
        throw new IndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void setField(FieldDescriptorType r100, Object r101) {
        if (r100.isRepeated() == true) goto L5;
        verifyType(r100.getLiteType(), r101);
    L15:
        if ((r101 instanceof LazyField) == false) goto L17;
        this.hasLazyField = true;
    L17:
        this.fields.put(r100, r101);
        return;
    L5:
        if ((r101 instanceof List) == false) goto L12;
        ArrayList r102 = new ArrayList();
        r102.addAll((List) r101);
        Iterator r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        Object r104 = r103.next();
        verifyType(r100.getLiteType(), r104);
        goto L8
    L10:
        r101 = r102;
        goto L15
    L12:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public static int computeElementSize(WireFormat.FieldType r100, int r101, Object r102) {
        int r103 = CodedOutputStream.computeTagSize(r101);
        if (r100 != WireFormat.FieldType.GROUP) goto L6;
        r103 = r103 * 2;
    L6:
        return r103 + computeElementSizeNoTag(r100, r102);
    }

    public static Object readPrimitiveField(CodedInputStream r100, WireFormat.FieldType r101, boolean r102) throws IOException {
        if (r102 == false) goto L6;
        return WireFormat.readPrimitiveField(r100, r101, WireFormat.Utf8Validation.STRICT);
    L6:
        return WireFormat.readPrimitiveField(r100, r101, WireFormat.Utf8Validation.LOOSE);
    }

    public static void writeElementNoTag(CodedOutputStream r100, WireFormat.FieldType r101, Object r102) throws IOException {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r101.ordinal()]) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L25;
            case 8: goto L24;
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L19;
            case 12: goto L15;
            case 13: goto L13;
            case 14: goto L12;
            case 15: goto L11;
            case 16: goto L10;
            case 17: goto L9;
            case 18: goto L6;
            default: goto L53;
        };
    L9:
        r100.writeSInt64NoTag(((Long) r102).longValue());
        return;
    L10:
        r100.writeSInt32NoTag(((Integer) r102).intValue());
        return;
    L11:
        r100.writeSFixed64NoTag(((Long) r102).longValue());
        return;
    L12:
        r100.writeSFixed32NoTag(((Integer) r102).intValue());
        return;
    L13:
        r100.writeUInt32NoTag(((Integer) r102).intValue());
        return;
    L22:
        r100.writeMessageNoTag((MessageLite) r102);
        return;
    L23:
        r100.writeGroupNoTag((MessageLite) r102);
        return;
    L24:
        r100.writeBoolNoTag(((Boolean) r102).booleanValue());
        return;
    L25:
        r100.writeFixed32NoTag(((Integer) r102).intValue());
        return;
    L26:
        r100.writeFixed64NoTag(((Long) r102).longValue());
        return;
    L27:
        r100.writeInt32NoTag(((Integer) r102).intValue());
        return;
    L28:
        r100.writeUInt64NoTag(((Long) r102).longValue());
        return;
    L29:
        r100.writeInt64NoTag(((Long) r102).longValue());
        return;
    L30:
        r100.writeFloatNoTag(((Float) r102).floatValue());
        return;
    L31:
        r100.writeDoubleNoTag(((Double) r102).doubleValue());
        return;
    L53:
        return;
    L6:
        if ((r102 instanceof Internal.EnumLite) == false) goto L8;
        r100.writeEnumNoTag(((Internal.EnumLite) r102).getNumber());
        return;
    L8:
        r100.writeEnumNoTag(((Integer) r102).intValue());
        return;
    L15:
        if ((r102 instanceof ByteString) == false) goto L17;
        r100.writeBytesNoTag((ByteString) r102);
        return;
    L17:
        r100.writeByteArrayNoTag((byte[]) r102);
        return;
    L19:
        if ((r102 instanceof ByteString) == false) goto L21;
        r100.writeBytesNoTag((ByteString) r102);
        return;
    L21:
        r100.writeStringNoTag((String) r102);
    }

    public static void writeField(FieldDescriptorLite<?> r100, Object r101, CodedOutputStream r102) throws IOException {
        WireFormat.FieldType r103 = r100.getLiteType();
        int r104 = r100.getNumber();
        if (r100.isRepeated() == false) goto L19;
        List r105 = (List) r101;
        if (r100.isPacked() == false) goto L14;
        r102.writeTag(r104, 2);
        Iterator r106 = r105.iterator();
        int r107 = 0;
    L8:
        if (r106.hasNext() == false) goto L10;
        r107 = r107 + computeElementSizeNoTag(r103, r106.next());
        goto L8
    L10:
        r102.writeRawVarint32(r107);
        Iterator r108 = r105.iterator();
    L12:
        if (r108.hasNext() == false) goto L27;
        writeElementNoTag(r102, r103, r108.next());
        goto L12
    L27:
        return;
    L14:
        Iterator r109 = r105.iterator();
    L16:
        if (r109.hasNext() == false) goto L28;
        writeElement(r102, r103, r104, r109.next());
        goto L16
    L28:
        return;
    L19:
        if ((r101 instanceof LazyField) == false) goto L21;
        writeElement(r102, r103, r104, ((LazyField) r101).getValue());
        return;
    L21:
        writeElement(r102, r103, r104, r101);
    }

    public void setRepeatedField(FieldDescriptorType r100, int r101, Object r102) {
        if (r100.isRepeated() == false) goto L11;
        Object r103 = getField(r100);
        if (r103 == null) goto L9;
        verifyType(r100.getLiteType(), r102);
        ListProtector.set((List) r103, r101, r102);
        return;
    L9:
        throw new IndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public static void writeElement(CodedOutputStream r100, WireFormat.FieldType r101, int r102, Object r103) throws IOException {
        if (r101 != WireFormat.FieldType.GROUP) goto L5;
        r100.writeGroup(r102, (MessageLite) r103);
        return;
    L5:
        r100.writeTag(r102, getWireFormatForFieldType(r101, false));
        writeElementNoTag(r100, r101, r103);
    }
}
