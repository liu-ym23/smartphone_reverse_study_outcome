package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes23.dex */
public final class UnknownFieldSet implements MessageLite {
    private static final Parser PARSER = null;
    private static final UnknownFieldSet defaultInstance = null;
    private final Map<Integer, Field> fields;

    /* JADX INFO: renamed from: com.google.protobuf.UnknownFieldSet$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder implements MessageLite.Builder {
        private Map<Integer, Field> fields;
        private Field.Builder lastField;
        private int lastFieldNumber;

        private Builder() {
        }

        public Map<Integer, Field> asMap() {
            getFieldBuilder(0);
            return Collections.unmodifiableMap(this.fields);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public UnknownFieldSet build() {
            getFieldBuilder(0);
            if (this.fields.isEmpty() == false) goto L5;
            UnknownFieldSet r100 = UnknownFieldSet.getDefaultInstance();
        L6:
            this.fields = null;
            return r100;
        L5:
            r100 = new UnknownFieldSet(Collections.unmodifiableMap(this.fields), null);
            goto L6
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            getFieldBuilder(0);
            return UnknownFieldSet.newBuilder().mergeFrom(new UnknownFieldSet(this.fields, null));
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return true;
        }

        private static Builder create() {
            Builder r100 = new Builder();
            r100.reinitialize();
            return r100;
        }

        public static /* synthetic */ Builder access$000() {
            return create();
        }

        private void reinitialize() {
            this.fields = Collections.emptyMap();
            this.lastFieldNumber = 0;
            this.lastField = null;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public UnknownFieldSet buildPartial() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            reinitialize();
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UnknownFieldSet getDefaultInstanceForType() {
            return UnknownFieldSet.getDefaultInstance();
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m8533clone() throws CloneNotSupportedException {
            return clone();
        }

        private Field.Builder getFieldBuilder(int r100) {
            Field.Builder r101 = this.lastField;
            if (r101 == null) goto L8;
            int r102 = this.lastFieldNumber;
            if (r100 != r102) goto L7;
            return r101;
        L7:
            addField(r102, r101.build());
        L8:
            if (r100 != 0) goto L11;
            return null;
        L11:
            Field r103 = this.fields.get(Integer.valueOf(r100));
            this.lastFieldNumber = r100;
            Field.Builder r104 = Field.newBuilder();
            this.lastField = r104;
            if (r103 == null) goto L15;
            r104.mergeFrom(r103);
        L15:
            return this.lastField;
        }

        public Builder clearField(int r100) {
            if (r100 == 0) goto L13;
            if (this.lastField == null) goto L9;
            if (this.lastFieldNumber != r100) goto L9;
            this.lastField = null;
            this.lastFieldNumber = 0;
        L9:
            if (this.fields.containsKey(Integer.valueOf(r100)) == false) goto L11;
            this.fields.remove(Integer.valueOf(r100));
        L11:
            return this;
        L13:
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public boolean hasField(int r100) {
            if (r100 == 0) goto L12;
            if (r100 != this.lastFieldNumber) goto L6;
        L9:
            return true;
        L6:
            if (this.fields.containsKey(Integer.valueOf(r100)) == true) goto L9;
            return false;
        L12:
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public boolean mergeDelimitedFrom(InputStream r100) throws IOException {
            int r101 = r100.read();
            if (r101 != (-1)) goto L6;
            return false;
        L6:
            mergeFrom(new AbstractMessageLite.Builder.LimitedInputStream(r100, CodedInputStream.readRawVarint32(r101, r100)));
            return true;
        }

        public Builder mergeFrom(UnknownFieldSet r100) {
            if (r100 == UnknownFieldSet.getDefaultInstance()) goto L8;
            Iterator r101 = UnknownFieldSet.access$100(r100).entrySet().iterator();
        L6:
            if (r101.hasNext() == false) goto L8;
            Map.Entry r102 = (Map.Entry) r101.next();
            mergeField(((Integer) r102.getKey()).intValue(), (Field) r102.getValue());
        L8:
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(ByteString r100) throws InvalidProtocolBufferException {
            CodedInputStream r101 = r100.newCodedInput();     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r101);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r101.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] r100) throws InvalidProtocolBufferException {
            CodedInputStream r101 = CodedInputStream.newInstance(r100);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r101);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r101.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public Builder mergeFrom(MessageLite r100) {
            if ((r100 instanceof UnknownFieldSet) == false) goto L7;
            return mergeFrom((UnknownFieldSet) r100);
        L7:
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r100) throws IOException {
        L2:
            int r101 = r100.readTag();
            if (r101 == 0) goto L6;
            if (mergeFieldFrom(r101, r100) == true) goto L2;
        L6:
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(InputStream r100) throws IOException {
            CodedInputStream r101 = CodedInputStream.newInstance(r100);
            mergeFrom(r101);
            r101.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r100) throws InvalidProtocolBufferException {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r100) throws IOException {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(MessageLite r100) {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r100) throws IOException {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r100) throws InvalidProtocolBufferException {
            return mergeFrom(r100);
        }

        public Builder addField(int r100, Field r101) {
            if (r100 == 0) goto L14;
            if (this.lastField == null) goto L9;
            if (this.lastFieldNumber != r100) goto L9;
            this.lastField = null;
            this.lastFieldNumber = 0;
        L9:
            if (this.fields.isEmpty() == false) goto L11;
            this.fields = new TreeMap();
        L11:
            this.fields.put(Integer.valueOf(r100), r101);
            return this;
        L14:
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public boolean mergeDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return mergeDelimitedFrom(r100);
        }

        public Builder mergeField(int r100, Field r101) {
            if (r100 == 0) goto L9;
            if (hasField(r100) == false) goto L6;
            getFieldBuilder(r100).mergeFrom(r101);
        L7:
            return this;
        L6:
            addField(r100, r101);
            goto L7
        L9:
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public boolean mergeFieldFrom(int r100, CodedInputStream r101) throws IOException {
            int r102 = WireFormat.getTagFieldNumber(r100);
            int r103 = WireFormat.getTagWireType(r100);
            if (r103 == 0) goto L25;
            if (r103 != 1) goto L6;
            getFieldBuilder(r102).addFixed64(r101.readFixed64());
            return true;
        L6:
            if (r103 != 2) goto L8;
            getFieldBuilder(r102).addLengthDelimited(r101.readBytes());
            return true;
        L8:
            if (r103 != 3) goto L10;
            Builder r104 = UnknownFieldSet.newBuilder();
            r101.readGroup(r102, r104, ExtensionRegistry.getEmptyRegistry());
            getFieldBuilder(r102).addGroup(r104.build());
            return true;
        L10:
            if (r103 != 4) goto L12;
            return false;
        L12:
            if (r103 != 5) goto L16;
            getFieldBuilder(r102).addFixed32(r101.readFixed32());
            return true;
        L16:
            throw InvalidProtocolBufferException.invalidWireType();
        L25:
            getFieldBuilder(r102).addVarint(r101.readInt64());
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return mergeFrom(r100, r101);
        }

        public Builder mergeLengthDelimitedField(int r100, ByteString r101) {
            if (r100 == 0) goto L6;
            getFieldBuilder(r100).addLengthDelimited(r101);
            return this;
        L6:
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public Builder mergeVarintField(int r100, int r101) {
            if (r100 == 0) goto L6;
            getFieldBuilder(r100).addVarint(r101);
            return this;
        L6:
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
            return mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] r100, int r101, int r102) throws InvalidProtocolBufferException {
            CodedInputStream r103 = CodedInputStream.newInstance(r100, r101, r102);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r103);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r103.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r100, int r101, int r102) throws InvalidProtocolBufferException {
            return mergeFrom(r100, r101, r102);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r100, int r101, int r102, ExtensionRegistryLite r103) throws InvalidProtocolBufferException {
            return mergeFrom(r100, r101, r102, r103);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] r100, int r101, int r102, ExtensionRegistryLite r103) throws InvalidProtocolBufferException {
            return mergeFrom(r100, r101, r102);
        }
    }

    public static final class Field {
        private static final Field fieldDefaultInstance = null;
        private List<Integer> fixed32;
        private List<Long> fixed64;
        private List<UnknownFieldSet> group;
        private List<ByteString> lengthDelimited;
        private List<Long> varint;

        public static final class Builder {
            private Field result;

            private Builder() {
            }

            private static Builder create() {
                Builder r100 = new Builder();
                r100.result = new Field(null);
                return r100;
            }

            public Field build() {
                if (Field.access$400(this.result) != null) goto L5;
                Field.access$402(this.result, Collections.emptyList());
            L7:
                if (Field.access$500(this.result) != null) goto L9;
                Field.access$502(this.result, Collections.emptyList());
            L11:
                if (Field.access$600(this.result) != null) goto L13;
                Field.access$602(this.result, Collections.emptyList());
            L15:
                if (Field.access$700(this.result) != null) goto L17;
                Field.access$702(this.result, Collections.emptyList());
            L19:
                if (Field.access$800(this.result) != null) goto L21;
                Field.access$802(this.result, Collections.emptyList());
            L22:
                Field r100 = this.result;
                this.result = null;
                return r100;
            L21:
                Field r101 = this.result;
                Field.access$802(r101, Collections.unmodifiableList(Field.access$800(r101)));
                goto L22
            L17:
                Field r102 = this.result;
                Field.access$702(r102, Collections.unmodifiableList(Field.access$700(r102)));
                goto L19
            L13:
                Field r103 = this.result;
                Field.access$602(r103, Collections.unmodifiableList(Field.access$600(r103)));
                goto L15
            L9:
                Field r104 = this.result;
                Field.access$502(r104, Collections.unmodifiableList(Field.access$500(r104)));
                goto L11
            L5:
                Field r105 = this.result;
                Field.access$402(r105, Collections.unmodifiableList(Field.access$400(r105)));
                goto L7
            }

            public Builder clear() {
                this.result = new Field(null);
                return this;
            }

            public static /* synthetic */ Builder access$200() {
                return create();
            }

            public Builder addFixed32(int r100) {
                if (Field.access$500(this.result) != null) goto L5;
                Field.access$502(this.result, new ArrayList());
            L5:
                Field.access$500(this.result).add(Integer.valueOf(r100));
                return this;
            }

            public Builder addFixed64(long r100) {
                if (Field.access$600(this.result) != null) goto L5;
                Field.access$602(this.result, new ArrayList());
            L5:
                Field.access$600(this.result).add(Long.valueOf(r100));
                return this;
            }

            public Builder addGroup(UnknownFieldSet r100) {
                if (Field.access$800(this.result) != null) goto L5;
                Field.access$802(this.result, new ArrayList());
            L5:
                Field.access$800(this.result).add(r100);
                return this;
            }

            public Builder addLengthDelimited(ByteString r100) {
                if (Field.access$700(this.result) != null) goto L5;
                Field.access$702(this.result, new ArrayList());
            L5:
                Field.access$700(this.result).add(r100);
                return this;
            }

            public Builder addVarint(long r100) {
                if (Field.access$400(this.result) != null) goto L5;
                Field.access$402(this.result, new ArrayList());
            L5:
                Field.access$400(this.result).add(Long.valueOf(r100));
                return this;
            }

            public Builder mergeFrom(Field r100) {
                if (Field.access$400(r100).isEmpty() == true) goto L9;
                if (Field.access$400(this.result) != null) goto L7;
                Field.access$402(this.result, new ArrayList());
            L7:
                Field.access$400(this.result).addAll(Field.access$400(r100));
            L9:
                if (Field.access$500(r100).isEmpty() == true) goto L15;
                if (Field.access$500(this.result) != null) goto L13;
                Field.access$502(this.result, new ArrayList());
            L13:
                Field.access$500(this.result).addAll(Field.access$500(r100));
            L15:
                if (Field.access$600(r100).isEmpty() == true) goto L21;
                if (Field.access$600(this.result) != null) goto L19;
                Field.access$602(this.result, new ArrayList());
            L19:
                Field.access$600(this.result).addAll(Field.access$600(r100));
            L21:
                if (Field.access$700(r100).isEmpty() == true) goto L27;
                if (Field.access$700(this.result) != null) goto L25;
                Field.access$702(this.result, new ArrayList());
            L25:
                Field.access$700(this.result).addAll(Field.access$700(r100));
            L27:
                if (Field.access$800(r100).isEmpty() == false) goto L29;
            L32:
                return this;
            L29:
                if (Field.access$800(this.result) != null) goto L31;
                Field.access$802(this.result, new ArrayList());
            L31:
                Field.access$800(this.result).addAll(Field.access$800(r100));
                goto L32
            }
        }

        private Field() {
        }

        private Object[] getIdentityArray() {
            return new Object[]{this.varint, this.fixed32, this.fixed64, this.lengthDelimited, this.group};
        }

        static {
            fieldDefaultInstance = newBuilder().build();
        }

        public static Builder newBuilder() {
            return Builder.access$200();
        }

        public int hashCode() {
            return Arrays.hashCode(getIdentityArray());
        }

        public static Field getDefaultInstance() {
            return fieldDefaultInstance;
        }

        public List<Integer> getFixed32List() {
            return this.fixed32;
        }

        public List<Long> getFixed64List() {
            return this.fixed64;
        }

        public List<UnknownFieldSet> getGroupList() {
            return this.group;
        }

        public List<ByteString> getLengthDelimitedList() {
            return this.lengthDelimited;
        }

        public List<Long> getVarintList() {
            return this.varint;
        }

        public /* synthetic */ Field(AnonymousClass1 r100) {
            this();
        }

        public static /* synthetic */ List access$400(Field r100) {
            return r100.varint;
        }

        public static /* synthetic */ List access$500(Field r100) {
            return r100.fixed32;
        }

        public static /* synthetic */ List access$600(Field r100) {
            return r100.fixed64;
        }

        public static /* synthetic */ List access$700(Field r100) {
            return r100.lengthDelimited;
        }

        public static /* synthetic */ List access$800(Field r100) {
            return r100.group;
        }

        public static Builder newBuilder(Field r100) {
            return newBuilder().mergeFrom(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Field) == true) goto L10;
            return false;
        L10:
            return Arrays.equals(getIdentityArray(), ((Field) r100).getIdentityArray());
        }

        public int getSerializedSize(int r100) {
            Iterator<Long> r101 = this.varint.iterator();
            int r102 = 0;
        L4:
            if (r101.hasNext() == false) goto L6;
            r102 = r102 + CodedOutputStream.computeUInt64Size(r100, r101.next().longValue());
            goto L4
        L6:
            Iterator<Integer> r103 = this.fixed32.iterator();
        L8:
            if (r103.hasNext() == false) goto L10;
            r102 = r102 + CodedOutputStream.computeFixed32Size(r100, r103.next().intValue());
            goto L8
        L10:
            Iterator<Long> r104 = this.fixed64.iterator();
        L12:
            if (r104.hasNext() == false) goto L14;
            r102 = r102 + CodedOutputStream.computeFixed64Size(r100, r104.next().longValue());
            goto L12
        L14:
            Iterator<ByteString> r105 = this.lengthDelimited.iterator();
        L16:
            if (r105.hasNext() == false) goto L18;
            r102 = r102 + CodedOutputStream.computeBytesSize(r100, r105.next());
            goto L16
        L18:
            Iterator<UnknownFieldSet> r106 = this.group.iterator();
        L20:
            if (r106.hasNext() == false) goto L22;
            r102 = r102 + CodedOutputStream.computeGroupSize(r100, r106.next());
            goto L20
        L22:
            return r102;
        }

        public int getSerializedSizeAsMessageSetExtension(int r100) {
            Iterator<ByteString> r101 = this.lengthDelimited.iterator();
            int r102 = 0;
        L4:
            if (r101.hasNext() == false) goto L6;
            r102 = r102 + CodedOutputStream.computeRawMessageSetExtensionSize(r100, r101.next());
            goto L4
        L6:
            return r102;
        }

        public static /* synthetic */ List access$402(Field r100, List r101) {
            r100.varint = r101;
            return r101;
        }

        public static /* synthetic */ List access$502(Field r100, List r101) {
            r100.fixed32 = r101;
            return r101;
        }

        public static /* synthetic */ List access$602(Field r100, List r101) {
            r100.fixed64 = r101;
            return r101;
        }

        public static /* synthetic */ List access$702(Field r100, List r101) {
            r100.lengthDelimited = r101;
            return r101;
        }

        public static /* synthetic */ List access$802(Field r100, List r101) {
            r100.group = r101;
            return r101;
        }

        public void writeAsMessageSetExtensionTo(int r100, CodedOutputStream r101) throws IOException {
            Iterator<ByteString> r102 = this.lengthDelimited.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r101.writeRawMessageSetExtension(r100, r102.next());
            goto L4
        }

        public void writeTo(int r100, CodedOutputStream r101) throws IOException {
            Iterator<Long> r102 = this.varint.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r101.writeUInt64(r100, r102.next().longValue());
            goto L4
        L6:
            Iterator<Integer> r103 = this.fixed32.iterator();
        L8:
            if (r103.hasNext() == false) goto L10;
            r101.writeFixed32(r100, r103.next().intValue());
            goto L8
        L10:
            Iterator<Long> r104 = this.fixed64.iterator();
        L12:
            if (r104.hasNext() == false) goto L14;
            r101.writeFixed64(r100, r104.next().longValue());
            goto L12
        L14:
            Iterator<ByteString> r105 = this.lengthDelimited.iterator();
        L16:
            if (r105.hasNext() == false) goto L18;
            r101.writeBytes(r100, r105.next());
            goto L16
        L18:
            Iterator<UnknownFieldSet> r106 = this.group.iterator();
        L20:
            if (r106.hasNext() == false) goto L22;
            r101.writeGroup(r100, r106.next());
            goto L20
        }
    }

    public static final class Parser extends AbstractParser<UnknownFieldSet> {
        public Parser() {
        }

        @Override // com.google.protobuf.Parser
        public UnknownFieldSet parsePartialFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            Builder r102 = UnknownFieldSet.newBuilder();
            r102.mergeFrom(r100);     // Catch: IOException -> L6 InvalidProtocolBufferException -> L9
        L5:
            return r102.buildPartial();
        L9:
            e = move-exception;
            throw e.setUnfinishedMessage(r102.buildPartial());
        L6:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(r102.buildPartial());
        }

        @Override // com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return parsePartialFrom(r100, r101);
        }
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        return true;
    }

    static {
        defaultInstance = new UnknownFieldSet(Collections.emptyMap(), Collections.emptyMap());
        PARSER = new Parser();
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        Iterator<Map.Entry<Integer, Field>> r100 = this.fields.entrySet().iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        Map.Entry<Integer, Field> r102 = r100.next();
        r101 = r101 + r102.getValue().getSerializedSize(r102.getKey().intValue());
        goto L4
    L6:
        return r101;
    }

    public int getSerializedSizeAsMessageSet() {
        Iterator<Map.Entry<Integer, Field>> r100 = this.fields.entrySet().iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        Map.Entry<Integer, Field> r102 = r100.next();
        r101 = r101 + r102.getValue().getSerializedSizeAsMessageSetExtension(r102.getKey().intValue());
        goto L4
    L6:
        return r101;
    }

    public int hashCode() {
        return this.fields.hashCode();
    }

    private UnknownFieldSet() {
        this.fields = null;
    }

    public static Builder newBuilder() {
        return Builder.access$000();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ com.google.protobuf.Parser getParserForType() {
        return getParserForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return newBuilder().mergeFrom(this);
    }

    @Override // com.google.protobuf.MessageLite
    public byte[] toByteArray() {
        byte[] r100 = new byte[getSerializedSize()];     // Catch: IOException -> L4
        CodedOutputStream r101 = CodedOutputStream.newInstance(r100);     // Catch: IOException -> L4
        writeTo(r101);     // Catch: IOException -> L4
        r101.checkNoSpaceLeft();     // Catch: IOException -> L4
        return r100;
    L4:
        e = move-exception;
        throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
    }

    @Override // com.google.protobuf.MessageLite
    public ByteString toByteString() {
        ByteString.CodedBuilder r100 = ByteString.newCodedBuilder(getSerializedSize());     // Catch: IOException -> L4
        writeTo(r100.getCodedOutput());     // Catch: IOException -> L4
        return r100.build();
    L4:
        e = move-exception;
        throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e);
    }

    public String toString() {
        return TextFormat.printToString(this);
    }

    public static UnknownFieldSet getDefaultInstance() {
        return defaultInstance;
    }

    public Map<Integer, Field> asMap() {
        return this.fields;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public UnknownFieldSet getDefaultInstanceForType() {
        return defaultInstance;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public final Parser getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public static /* synthetic */ Map access$100(UnknownFieldSet r100) {
        return r100.fields;
    }

    public static Builder newBuilder(UnknownFieldSet r100) {
        return newBuilder().mergeFrom(r100);
    }

    public static UnknownFieldSet parseFrom(ByteString r100) throws InvalidProtocolBufferException {
        return newBuilder().mergeFrom(r100).build();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UnknownFieldSet) == true) goto L8;
    L10:
        return false;
    L8:
        if (this.fields.equals(((UnknownFieldSet) r100).fields) == false) goto L10;
        return true;
    }

    public Field getField(int r100) {
        Field r101 = this.fields.get(Integer.valueOf(r100));
        if (r101 == null) goto L5;
        return r101;
    L5:
        return Field.getDefaultInstance();
    }

    public boolean hasField(int r100) {
        return this.fields.containsKey(Integer.valueOf(r100));
    }

    public void writeAsMessageSetTo(CodedOutputStream r100) throws IOException {
        Iterator<Map.Entry<Integer, Field>> r101 = this.fields.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<Integer, Field> r102 = r101.next();
        r102.getValue().writeAsMessageSetExtensionTo(r102.getKey().intValue(), r100);
        goto L4
    }

    @Override // com.google.protobuf.MessageLite
    public void writeDelimitedTo(OutputStream r100) throws IOException {
        CodedOutputStream r101 = CodedOutputStream.newInstance(r100);
        r101.writeRawVarint32(getSerializedSize());
        writeTo(r101);
        r101.flush();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r100) throws IOException {
        Iterator<Map.Entry<Integer, Field>> r101 = this.fields.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<Integer, Field> r102 = r101.next();
        r102.getValue().writeTo(r102.getKey().intValue(), r100);
        goto L4
    }

    public static UnknownFieldSet parseFrom(CodedInputStream r100) throws IOException {
        return newBuilder().mergeFrom(r100).build();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(OutputStream r100) throws IOException {
        CodedOutputStream r101 = CodedOutputStream.newInstance(r100);
        writeTo(r101);
        r101.flush();
    }

    public static UnknownFieldSet parseFrom(InputStream r100) throws IOException {
        return newBuilder().mergeFrom(r100).build();
    }

    public static UnknownFieldSet parseFrom(byte[] r100) throws InvalidProtocolBufferException {
        return newBuilder().mergeFrom(r100).build();
    }

    public UnknownFieldSet(Map<Integer, Field> r100, Map<Integer, Field> r101) {
        this.fields = r100;
    }
}
