package com.google.protobuf;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AbstractMessage extends AbstractMessageLite implements Message {
    protected int memoizedSize;

    public static abstract class Builder<BuilderType extends Builder<BuilderType>> extends AbstractMessageLite.Builder implements Message.Builder {
        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clone() {
            throw new UnsupportedOperationException("clone() should be implemented in subclasses.");
        }

        void dispose() {
            throw new IllegalStateException("Should be overridden by subclasses.");
        }

        public void markClean() {
            throw new IllegalStateException("Should be overridden by subclasses.");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clear() {
            Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r100 = getAllFields().entrySet().iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            clearField(r100.next().getKey());
            goto L4
        L6:
            return this;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public List<String> findInitializationErrors() {
            return MessageReflection.findMissingFields(this);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public String getInitializationErrorString() {
            return MessageReflection.delimitWithCommas(findInitializationErrors());
        }

        public String toString() {
            return TextFormat.printToString(this);
        }

        public Builder() {
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object mo8531clone() throws CloneNotSupportedException {
            return clone();
        }

        public static UninitializedMessageException newUninitializedMessageException(Message r100) {
            return new UninitializedMessageException(MessageReflection.findMissingFields(r100));
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType clearOneof(Descriptors.OneofDescriptor r100) {
            throw new UnsupportedOperationException("clearOneof() is not implemented.");
        }

        @Override // com.google.protobuf.Message.Builder
        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor r100) {
            throw new UnsupportedOperationException("getFieldBuilder() called on an unsupported message type.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r100) {
            throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasOneof(Descriptors.OneofDescriptor r100) {
            throw new UnsupportedOperationException("hasOneof() is not implemented.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.AbstractMessageLite.Builder
        public BuilderType internalMergeFrom(AbstractMessageLite r100) {
            return (BuilderType) mergeFrom((Message) r100);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public boolean mergeDelimitedFrom(InputStream r100) throws IOException {
            return super.mergeDelimitedFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(CodedInputStream r100) throws IOException {
            return (BuilderType) mergeFrom(r100, ExtensionRegistry.getEmptyRegistry());
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType mergeUnknownFields(UnknownFieldSet r100) {
            setUnknownFields(UnknownFieldSet.newBuilder(getUnknownFields()).mergeFrom(r100).build());
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r100) {
            return clearOneof(r100);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite r100) {
            return internalMergeFrom(r100);
        }

        public BuilderType mergeFrom(Message r100) {
            return (BuilderType) mergeFrom(r100, r100.getAllFields());
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r100) {
            return mergeUnknownFields(r100);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(ByteString r100) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(InputStream r100) throws IOException {
            return (BuilderType) super.mergeFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r100) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(ByteString r100) throws InvalidProtocolBufferException {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r100) throws IOException {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(InputStream r100) throws IOException {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r100) throws InvalidProtocolBufferException {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(ByteString r100) throws InvalidProtocolBufferException {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r100) throws IOException {
            return mergeFrom(r100);
        }

        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r100) {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(InputStream r100) throws IOException {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(byte[] r100) throws InvalidProtocolBufferException {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r100) throws InvalidProtocolBufferException {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r100) throws IOException {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r100) throws IOException {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r100) throws InvalidProtocolBufferException {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.Message.Builder
        public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor r100, int r101) {
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on an unsupported message type.");
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public boolean mergeDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return super.mergeDelimitedFrom(r100, r101);
        }

        public BuilderType mergeFrom(Message r100, Map<Descriptors.FieldDescriptor, Object> r101) {
            if (r100.getDescriptorForType() != getDescriptorForType()) goto L23;
            Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r102 = r101.entrySet().iterator();
        L6:
            if (r102.hasNext() == false) goto L20;
            Map.Entry<Descriptors.FieldDescriptor, Object> r103 = r102.next();
            Descriptors.FieldDescriptor r104 = r103.getKey();
            if (r104.isRepeated() == true) goto L9;
            if (r104.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L15;
            setField(r104, r103.getValue());
            goto L6
        L15:
            Message r105 = (Message) getField(r104);
            if (r105 == r105.getDefaultInstanceForType()) goto L17;
            setField(r104, r105.newBuilderForType().mergeFrom(r105).mergeFrom((Message) r103.getValue()).build());
            goto L6
        L17:
            setField(r104, r103.getValue());
            goto L6
        L9:
            Iterator r106 = ((List) r103.getValue()).iterator();
        L11:
            if (r106.hasNext() == false) goto L6;
            addRepeatedField(r104, r106.next());
            goto L11
        L20:
            mergeUnknownFields(r100.getUnknownFields());
            return this;
        L23:
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
            if (getDescriptorForType().getFile().getSyntax() != Descriptors.FileDescriptor.Syntax.PROTO3) goto L5;
            boolean r102 = r100.shouldDiscardUnknownFieldsProto3();
        L6:
            if (r102 == false) goto L8;
            UnknownFieldSet.Builder r103 = null;
        L9:
            int r104 = r100.readTag();
            if (r104 == 0) goto L14;
            MessageReflection.BuilderAdapter r105 = new MessageReflection.BuilderAdapter(this);
            UnknownFieldSet.Builder r106 = r103;
            if (MessageReflection.mergeFieldFrom(r100, r106, r101, getDescriptorForType(), r105, r104) == true) goto L9;
        L14:
            if (r103 == null) goto L16;
            setUnknownFields(r103.build());
        L16:
            return this;
        L8:
            r103 = UnknownFieldSet.newBuilder(getUnknownFields());
            goto L9
        L5:
            r102 = r100.shouldDiscardUnknownFields();
            goto L6
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (BuilderType) super.mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
            return mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
            return mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
            return mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r100, int r101, int r102) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(r100, r101, r102);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r100, int r101, int r102) throws InvalidProtocolBufferException {
            return mergeFrom(r100, r101, r102);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(byte[] r100, int r101, int r102) throws InvalidProtocolBufferException {
            return mergeFrom(r100, r101, r102);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r100, int r101, int r102) throws InvalidProtocolBufferException {
            return mergeFrom(r100, r101, r102);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r100, int r101, int r102, ExtensionRegistryLite r103) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(r100, r101, r102, r103);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r100, int r101, int r102, ExtensionRegistryLite r103) throws InvalidProtocolBufferException {
            return mergeFrom(r100, r101, r102, r103);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(byte[] r100, int r101, int r102, ExtensionRegistryLite r103) throws InvalidProtocolBufferException {
            return mergeFrom(r100, r101, r102, r103);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r100, int r101, int r102, ExtensionRegistryLite r103) throws InvalidProtocolBufferException {
            return mergeFrom(r100, r101, r102, r103);
        }
    }

    public interface BuilderParent {
        void markDirty();
    }

    public static int hashBoolean(boolean r100) {
        if (r100 == false) goto L4;
        return 1231;
    L4:
        return 1237;
    }

    public static int hashLong(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r100 = this.memoizedSize;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        int r101 = MessageReflection.getSerializedSize(this, getAllFields());
        this.memoizedSize = r101;
        return r101;
    }

    public int hashCode() {
        int r100 = this.memoizedHashCode;
        if (r100 != 0) goto L6;
        int r101 = (hashFields(779 + getDescriptorForType().hashCode(), getAllFields()) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r101;
        return r101;
    L6:
        return r100;
    }

    public AbstractMessage() {
        this.memoizedSize = -1;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public List<String> findInitializationErrors() {
        return MessageReflection.findMissingFields(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public String getInitializationErrorString() {
        return MessageReflection.delimitWithCommas(findInitializationErrors());
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        return MessageReflection.isInitialized(this);
    }

    @Override // com.google.protobuf.AbstractMessageLite
    public UninitializedMessageException newUninitializedMessageException() {
        return Builder.newUninitializedMessageException(this);
    }

    @Override // com.google.protobuf.Message
    public final String toString() {
        return TextFormat.printToString(this);
    }

    private static Map convertMapEntryListToMap(List r100) {
        if (r100.isEmpty() == true) goto L5;
        HashMap r101 = new HashMap();
        Iterator r102 = r100.iterator();
        Message r103 = (Message) r102.next();
        Descriptors.Descriptor r104 = r103.getDescriptorForType();
        Descriptors.FieldDescriptor r105 = r104.findFieldByName("key");
        Descriptors.FieldDescriptor r106 = r104.findFieldByName("value");
        Object r107 = r103.getField(r106);
        if ((r107 instanceof Descriptors.EnumValueDescriptor) == false) goto L9;
        r107 = Integer.valueOf(((Descriptors.EnumValueDescriptor) r107).getNumber());
    L9:
        r101.put(r103.getField(r105), r107);
    L11:
        if (r102.hasNext() == false) goto L16;
        Message r108 = (Message) r102.next();
        Object r109 = r108.getField(r106);
        if ((r109 instanceof Descriptors.EnumValueDescriptor) == false) goto L15;
        r109 = Integer.valueOf(((Descriptors.EnumValueDescriptor) r109).getNumber());
    L15:
        r101.put(r108.getField(r105), r109);
        goto L11
    L16:
        return r101;
    L5:
        return Collections.emptyMap();
    }

    public static int hashEnum(Internal.EnumLite r100) {
        return r100.getNumber();
    }

    public static int hashEnumList(List<? extends Internal.EnumLite> r100) {
        Iterator<? extends Internal.EnumLite> r101 = r100.iterator();
        int r102 = 1;
    L4:
        if (r101.hasNext() == false) goto L6;
        r102 = (r102 * 31) + hashEnum(r101.next());
        goto L4
    L6:
        return r102;
    }

    private static int hashMapField(Object r100) {
        return MapFieldLite.calculateHashCodeForMap(convertMapEntryListToMap((List) r100));
    }

    private static ByteString toByteString(Object r100) {
        if ((r100 instanceof byte[]) == false) goto L7;
        return ByteString.copyFrom((byte[]) r100);
    L7:
        return (ByteString) r100;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof Message) == true) goto L8;
        return false;
    L8:
        Message r101 = (Message) r100;
        if (getDescriptorForType() == r101.getDescriptorForType()) goto L12;
        return false;
    L12:
        if (compareFields(getAllFields(), r101.getAllFields()) == true) goto L14;
    L16:
        return false;
    L14:
        if (getUnknownFields().equals(r101.getUnknownFields()) == false) goto L16;
        return true;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r100) {
        throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasOneof(Descriptors.OneofDescriptor r100) {
        throw new UnsupportedOperationException("hasOneof() is not implemented.");
    }

    public Message.Builder newBuilderForType(BuilderParent r100) {
        throw new UnsupportedOperationException("Nested builder is not supported for this type.");
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r100) throws IOException {
        MessageReflection.writeMessageTo(this, getAllFields(), r100, false);
    }

    private static boolean compareBytes(Object r100, Object r101) {
        if ((r100 instanceof byte[]) == false) goto L9;
        if ((r101 instanceof byte[]) == false) goto L9;
        return Arrays.equals((byte[]) r100, (byte[]) r101);
    L9:
        return toByteString(r100).equals(toByteString(r101));
    }

    public static boolean compareFields(Map<Descriptors.FieldDescriptor, Object> r100, Map<Descriptors.FieldDescriptor, Object> r101) {
        if (r100.size() == r101.size()) goto L5;
        return false;
    L5:
        Iterator<Descriptors.FieldDescriptor> r102 = r100.keySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L36;
        Descriptors.FieldDescriptor r103 = r102.next();
        if (r101.containsKey(r103) == false) goto L10;
        Object r104 = r100.get(r103);
        Object r105 = r101.get(r103);
        if (r103.getType() == Descriptors.FieldDescriptor.Type.BYTES) goto L14;
        if (r103.isMapField() == true) goto L31;
        if (r104.equals(r105) == true) goto L7;
        return false;
    L31:
        if (compareMapField(r104, r105) == true) goto L7;
        return false;
    L14:
        if (r103.isRepeated() == true) goto L15;
        if (compareBytes(r104, r105) == true) goto L7;
        return false;
    L15:
        List r106 = (List) r104;
        List r107 = (List) r105;
        if (r106.size() != r107.size()) goto L17;
        int r108 = 0;
    L20:
        if (r108 >= r106.size()) goto L7;
        if (compareBytes(ListProtector.get(r106, r108), ListProtector.get(r107, r108)) == false) goto L23;
        r108 = r108 + 1;
        goto L20
    L23:
        return false;
    L17:
        return false;
    L10:
        return false;
    L36:
        return true;
    }

    private static boolean compareMapField(Object r100, Object r101) {
        return MapFieldLite.equals(convertMapEntryListToMap((List) r100), convertMapEntryListToMap((List) r101));
    }

    public static int hashFields(int r100, Map<Descriptors.FieldDescriptor, Object> r101) {
        Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r102 = r101.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L16;
        Map.Entry<Descriptors.FieldDescriptor, Object> r103 = r102.next();
        Descriptors.FieldDescriptor r104 = r103.getKey();
        Object r105 = r103.getValue();
        int r106 = (r100 * 37) + r104.getNumber();
        if (r104.isMapField() == false) goto L10;
        int r107 = r106 * 53;
        int r108 = hashMapField(r105);
    L8:
        r100 = r107 + r108;
        goto L4
    L10:
        if (r104.getType() == Descriptors.FieldDescriptor.Type.ENUM) goto L13;
        r107 = r106 * 53;
        r108 = r105.hashCode();
        goto L8
    L13:
        if (r104.isRepeated() == false) goto L15;
        r107 = r106 * 53;
        r108 = Internal.hashEnumList((List) r105);
        goto L8
    L15:
        r107 = r106 * 53;
        r108 = Internal.hashEnum((Internal.EnumLite) r105);
        goto L8
    L16:
        return r100;
    }
}
