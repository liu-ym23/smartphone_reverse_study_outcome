package com.google.protobuf;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes23.dex */
public abstract class GeneratedMessage extends AbstractMessage implements Serializable {
    protected static boolean alwaysUseFieldBuilders = false;
    private static final long serialVersionUID = 1;
    protected UnknownFieldSet unknownFields;

    /* JADX INFO: renamed from: com.google.protobuf.GeneratedMessage$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = null;

        static {
            int[] r100 = new int[Descriptors.FieldDescriptor.JavaType.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = r100;
            r100[Descriptors.FieldDescriptor.JavaType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.ENUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static abstract class Builder<BuilderType extends Builder<BuilderType>> extends AbstractMessage.Builder<BuilderType> {
        private BuilderParent builderParent;
        private boolean isClean;
        private Builder<BuilderType>.BuilderParentImpl meAsParent;
        private UnknownFieldSet unknownFields;

        public class BuilderParentImpl implements BuilderParent {
            final /* synthetic */ Builder this$0;

            @Override // com.google.protobuf.AbstractMessage.BuilderParent
            public void markDirty() {
                this.this$0.onChanged();
            }

            private BuilderParentImpl(Builder r100) {
                this.this$0 = r100;
            }

            public /* synthetic */ BuilderParentImpl(Builder r100, AnonymousClass1 r101) {
                this(r100);
            }
        }

        public Builder() {
            this(null);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder
        void dispose() {
            this.builderParent = null;
        }

        public abstract FieldAccessorTable internalGetFieldAccessorTable();

        @Override // com.google.protobuf.AbstractMessage.Builder
        public void markClean() {
            this.isClean = true;
        }

        private Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable() {
            TreeMap r100 = new TreeMap();
            List<Descriptors.FieldDescriptor> r101 = FieldAccessorTable.access$000(internalGetFieldAccessorTable()).getFields();
            int r102 = 0;
        L4:
            if (r102 >= r101.size()) goto L21;
            Descriptors.FieldDescriptor r103 = (Descriptors.FieldDescriptor) ListProtector.get(r101, r102);
            Descriptors.OneofDescriptor r104 = r103.getContainingOneof();
            if (r104 == null) goto L12;
            r102 = r102 + (r104.getFieldCount() - 1);
            if (hasOneof(r104) == false) goto L20;
            r103 = getOneofFieldDescriptor(r104);
        L19:
            r100.put(r103, getField(r103));
        L20:
            r102 = r102 + 1;
            goto L4
        L12:
            if (r103.isRepeated() == false) goto L17;
            List r105 = (List) getField(r103);
            if (r105.isEmpty() == true) goto L20;
            r100.put(r103, r105);
            goto L20
        L17:
            if (hasField(r103) == true) goto L19;
        L21:
            return r100;
        }

        public BuilderParent getParentForChildren() {
            if (this.meAsParent != null) goto L6;
            this.meAsParent = new BuilderParentImpl(this, null);
        L6:
            return this.meAsParent;
        }

        public void onBuilt() {
            if (this.builderParent == null) goto L6;
            markClean();
            return;
        }

        public final void onChanged() {
            if (this.isClean == false) goto L8;
            BuilderParent r100 = this.builderParent;
            if (r100 == null) goto L9;
            r100.markDirty();
            this.isClean = false;
            return;
        L9:
            return;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clear() {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clone() {
            BuilderType r100 = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            r100.mergeFrom(buildPartial());
            return r100;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            return Collections.unmodifiableMap(getAllFieldsMutable());
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return FieldAccessorTable.access$000(internalGetFieldAccessorTable());
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            Iterator<Descriptors.FieldDescriptor> r100 = getDescriptorForType().getFields().iterator();
        L4:
            if (r100.hasNext() == false) goto L25;
            Descriptors.FieldDescriptor r101 = r100.next();
            if (r101.isRequired() == false) goto L11;
            if (hasField(r101) == true) goto L11;
            return false;
        L11:
            if (r101.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L4;
            if (r101.isRepeated() == true) goto L14;
            if (hasField(r101) == false) goto L4;
            if (((Message) getField(r101)).isInitialized() == true) goto L4;
            return false;
        L14:
            Iterator r102 = ((List) getField(r101)).iterator();
        L16:
            if (r102.hasNext() == false) goto L4;
            if (((Message) r102.next()).isInitialized() == true) goto L16;
            return false;
        L25:
            return true;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public boolean isClean() {
            return this.isClean;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
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

        public Builder(BuilderParent r100) {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            this.builderParent = r100;
        }

        public static /* synthetic */ Map access$900(Builder r100) {
            return r100.getAllFieldsMutable();
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType clearField(Descriptors.FieldDescriptor r100) {
            FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r100).clear(this);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType clearOneof(Descriptors.OneofDescriptor r100) {
            FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r100).clear(this);
            return this;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor r100) {
            Object r101 = FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r100).get(this);
            if (r100.isRepeated() == true) goto L5;
            return r101;
        L5:
            return Collections.unmodifiableList((List) r101);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor r100) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r100).getBuilder(this);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r100) {
            return FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r100).get(this);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r100) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r100).getRepeatedCount(this);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor r100) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r100).has(this);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasOneof(Descriptors.OneofDescriptor r100) {
            return FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r100).has(this);
        }

        public MapField internalGetMapField(int r100) {
            throw new RuntimeException("No map fields found in ".concat(getClass().getName()));
        }

        public MapField internalGetMutableMapField(int r100) {
            throw new RuntimeException("No map fields found in ".concat(getClass().getName()));
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeUnknownFields(UnknownFieldSet r100) {
            this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(r100).build();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public Message.Builder newBuilderForField(Descriptors.FieldDescriptor r100) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r100).newBuilder();
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType setUnknownFields(UnknownFieldSet r100) {
            this.unknownFields = r100;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r100) {
            return clearField(r100);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r100) {
            return clearOneof(r100);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r100) {
            return mergeUnknownFields(r100);
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r100) {
            return setUnknownFields(r100);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r100) {
            return clearOneof(r100);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r100) {
            return mergeUnknownFields(r100);
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
            FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r100).addRepeated(this, r101);
            return this;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r100, int r101) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r100).getRepeated(this, r101);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor r100, int r101) {
            return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r100).getRepeatedBuilder(this, r101);
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType setField(Descriptors.FieldDescriptor r100, Object r101) {
            FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r100).set(this, r101);
            return this;
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
        public BuilderType setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
            FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r100).setRepeated(this, r101, r102);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
            return setRepeatedField(r100, r101, r102);
        }

        public boolean parseUnknownField(CodedInputStream r100, UnknownFieldSet.Builder r101, ExtensionRegistryLite r102, int r103) throws IOException {
            return r101.mergeFieldFrom(r103, r100);
        }
    }

    public interface BuilderParent extends AbstractMessage.BuilderParent {
    }

    public static abstract class CachedDescriptorRetriever implements ExtensionDescriptorRetriever {
        private volatile Descriptors.FieldDescriptor descriptor;

        private CachedDescriptorRetriever() {
        }

        public abstract Descriptors.FieldDescriptor loadDescriptor();

        @Override // com.google.protobuf.GeneratedMessage.ExtensionDescriptorRetriever
        public Descriptors.FieldDescriptor getDescriptor() {
            if (this.descriptor != null) goto L14;
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L6:
            if (this.descriptor != null) goto L8;
            this.descriptor = loadDescriptor();     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);     // Catch: Throwable -> L10
        L14:
            return this.descriptor;
        }

        public /* synthetic */ CachedDescriptorRetriever(AnonymousClass1 r100) {
            this();
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
        private FieldSet<Descriptors.FieldDescriptor> extensions;

        private FieldSet<Descriptors.FieldDescriptor> buildExtensions() {
            this.extensions.makeImmutable();
            return this.extensions;
        }

        private void ensureExtensionsIsMutable() {
            if (this.extensions.isImmutable() == false) goto L6;
            this.extensions = this.extensions.clone();
            return;
        }

        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public ExtendableBuilder() {
            this.extensions = FieldSet.emptySet();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clear() {
            this.extensions = FieldSet.emptySet();
            return (BuilderType) super.clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clone() {
            return (BuilderType) super.clone();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map r100 = Builder.access$900(this);
            r100.putAll(this.extensions.getAllFields());
            return Collections.unmodifiableMap(r100);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            if (super.isInitialized() == true) goto L5;
        L7:
            return false;
        L5:
            if (extensionsAreInitialized() == false) goto L7;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo8531clone() throws CloneNotSupportedException {
            return clone();
        }

        public ExtendableBuilder(BuilderParent r100) {
            super(r100);
            this.extensions = FieldSet.emptySet();
        }

        public static /* synthetic */ FieldSet access$400(ExtendableBuilder r100) {
            return r100.buildExtensions();
        }

        private void verifyContainingType(Descriptors.FieldDescriptor r100) {
            if (r100.getContainingType() != getDescriptorForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        private void verifyExtensionContainingType(Extension<MessageType, ?> r100) {
            if (r100.getDescriptor().getContainingType() != getDescriptorForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("Extension is for type \"" + r100.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
        }

        public final <Type> BuilderType clearExtension(ExtensionLite<MessageType, ?> r100) {
            Extension<MessageType, ?> r101 = GeneratedMessage.access$500(r100);
            verifyExtensionContainingType(r101);
            ensureExtensionsIsMutable();
            this.extensions.clearField(r101.getDescriptor());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType clearField(Descriptors.FieldDescriptor r100) {
            if (r100.isExtension() == false) goto L7;
            verifyContainingType(r100);
            ensureExtensionsIsMutable();
            this.extensions.clearField(r100);
            onChanged();
            return this;
        L7:
            return (BuilderType) super.clearField(r100);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> r100) {
            Extension<MessageType, ?> r101 = GeneratedMessage.access$500(r100);
            verifyExtensionContainingType(r101);
            Descriptors.FieldDescriptor r102 = r101.getDescriptor();
            Object r103 = this.extensions.getField(r102);
            if (r103 != null) goto L15;
            if (r102.isRepeated() == false) goto L9;
            return (Type) Collections.emptyList();
        L9:
            if (r102.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L13;
            return (Type) r101.getMessageDefaultInstance();
        L13:
            return (Type) r101.fromReflectionType(r102.getDefaultValue());
        L15:
            return (Type) r101.fromReflectionType(r103);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> r100) {
            Extension<MessageType, ?> r101 = GeneratedMessage.access$500(r100);
            verifyExtensionContainingType(r101);
            Descriptors.FieldDescriptor r102 = r101.getDescriptor();
            return this.extensions.getRepeatedFieldCount(r102);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor r100) {
            if (r100.isExtension() == false) goto L14;
            verifyContainingType(r100);
            Object r101 = this.extensions.getField(r100);
            if (r101 == null) goto L7;
            return r101;
        L7:
            if (r100.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L11;
            return DynamicMessage.getDefaultInstance(r100.getMessageType());
        L11:
            return r100.getDefaultValue();
        L14:
            return super.getField(r100);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r100) {
            if (r100.isExtension() == false) goto L7;
            verifyContainingType(r100);
            return this.extensions.getRepeatedFieldCount(r100);
        L7:
            return super.getRepeatedFieldCount(r100);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> r100) {
            Extension<MessageType, ?> r101 = GeneratedMessage.access$500(r100);
            verifyExtensionContainingType(r101);
            return this.extensions.hasField(r101.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor r100) {
            if (r100.isExtension() == false) goto L7;
            verifyContainingType(r100);
            return this.extensions.hasField(r100);
        L7:
            return super.hasField(r100);
        }

        public void internalSetExtensionSet(FieldSet<Descriptors.FieldDescriptor> r100) {
            this.extensions = r100;
        }

        public final void mergeExtensionFields(ExtendableMessage r100) {
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(ExtendableMessage.access$600(r100));
            onChanged();
        }

        public final <Type> BuilderType clearExtension(Extension<MessageType, ?> r100) {
            return (BuilderType) clearExtension(r100);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder clearField(Descriptors.FieldDescriptor r100) {
            return clearField(r100);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(Extension<MessageType, Type> r100) {
            return (Type) getExtension(r100);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(Extension<MessageType, List<Type>> r100) {
            return getExtensionCount(r100);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(Extension<MessageType, Type> r100) {
            return hasExtension(r100);
        }

        public <Type> BuilderType clearExtension(GeneratedExtension<MessageType, ?> r100) {
            return (BuilderType) clearExtension(r100);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r100) {
            return clearField(r100);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> r100) {
            return (Type) getExtension(r100);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> r100) {
            return getExtensionCount(r100);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> r100) {
            return hasExtension(r100);
        }

        public final <Type> BuilderType addExtension(ExtensionLite<MessageType, List<Type>> r100, Type r101) {
            Extension<MessageType, ?> r102 = GeneratedMessage.access$500(r100);
            verifyExtensionContainingType(r102);
            ensureExtensionsIsMutable();
            Descriptors.FieldDescriptor r103 = r102.getDescriptor();
            this.extensions.addRepeatedField(r103, r102.singularToReflectionType(r101));
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
            if (r100.isExtension() == false) goto L7;
            verifyContainingType(r100);
            ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(r100, r101);
            onChanged();
            return this;
        L7:
            return (BuilderType) super.addRepeatedField(r100, r101);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r100, int r101) {
            Extension<MessageType, ?> r102 = GeneratedMessage.access$500(r100);
            verifyExtensionContainingType(r102);
            Descriptors.FieldDescriptor r103 = r102.getDescriptor();
            return (Type) r102.singularFromReflectionType(this.extensions.getRepeatedField(r103, r101));
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r100, int r101) {
            if (r100.isExtension() == false) goto L7;
            verifyContainingType(r100);
            return this.extensions.getRepeatedField(r100, r101);
        L7:
            return super.getRepeatedField(r100, r101);
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, Type> r100, Type r101) {
            Extension<MessageType, ?> r102 = GeneratedMessage.access$500(r100);
            verifyExtensionContainingType(r102);
            ensureExtensionsIsMutable();
            Descriptors.FieldDescriptor r103 = r102.getDescriptor();
            this.extensions.setField(r103, r102.toReflectionType(r101));
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType setField(Descriptors.FieldDescriptor r100, Object r101) {
            if (r100.isExtension() == false) goto L7;
            verifyContainingType(r100);
            ensureExtensionsIsMutable();
            this.extensions.setField(r100, r101);
            onChanged();
            return this;
        L7:
            return (BuilderType) super.setField(r100, r101);
        }

        public final <Type> BuilderType addExtension(Extension<MessageType, List<Type>> r100, Type r101) {
            return (BuilderType) addExtension(r100, r101);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
            return addRepeatedField(r100, r101);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(Extension<MessageType, List<Type>> r100, int r101) {
            return (Type) getExtension(r100, r101);
        }

        public final <Type> BuilderType setExtension(Extension<MessageType, Type> r100, Type r101) {
            return (BuilderType) setExtension(r100, r101);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
            return setField(r100, r101);
        }

        public <Type> BuilderType addExtension(GeneratedExtension<MessageType, List<Type>> r100, Type r101) {
            return (BuilderType) addExtension(r100, r101);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
            return addRepeatedField(r100, r101);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> r100, int r101) {
            return (Type) getExtension(r100, r101);
        }

        public <Type> BuilderType setExtension(GeneratedExtension<MessageType, Type> r100, Type r101) {
            return (BuilderType) setExtension(r100, r101);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
            return setField(r100, r101);
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, List<Type>> r100, int r101, Type r102) {
            Extension<MessageType, ?> r103 = GeneratedMessage.access$500(r100);
            verifyExtensionContainingType(r103);
            ensureExtensionsIsMutable();
            Descriptors.FieldDescriptor r104 = r103.getDescriptor();
            this.extensions.setRepeatedField(r104, r101, r103.singularToReflectionType(r102));
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
            if (r100.isExtension() == false) goto L7;
            verifyContainingType(r100);
            ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(r100, r101, r102);
            onChanged();
            return this;
        L7:
            return (BuilderType) super.setRepeatedField(r100, r101, r102);
        }

        public final <Type> BuilderType setExtension(Extension<MessageType, List<Type>> r100, int r101, Type r102) {
            return (BuilderType) setExtension(r100, r101, r102);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
            return setRepeatedField(r100, r101, r102);
        }

        public <Type> BuilderType setExtension(GeneratedExtension<MessageType, List<Type>> r100, int r101, Type r102) {
            return (BuilderType) setExtension(r100, r101, r102);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
            return setRepeatedField(r100, r101, r102);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public boolean parseUnknownField(CodedInputStream r100, UnknownFieldSet.Builder r101, ExtensionRegistryLite r102, int r110) throws IOException {
            return MessageReflection.mergeFieldFrom(r100, r101, r102, getDescriptorForType(), new MessageReflection.BuilderAdapter(this), r110);
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage> extends GeneratedMessage implements ExtendableMessageOrBuilder<MessageType> {
        private static final long serialVersionUID = 1;
        private final FieldSet<Descriptors.FieldDescriptor> extensions;

        public class ExtensionWriter {
            private final Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<Descriptors.FieldDescriptor, Object> next;
            final /* synthetic */ ExtendableMessage this$0;

            private ExtensionWriter(ExtendableMessage r100, boolean r101) {
                this.this$0 = r100;
                Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r102 = ExtendableMessage.access$600(r100).iterator();
                this.iter = r102;
                if (r102.hasNext() == false) goto L5;
                this.next = r102.next();
            L5:
                this.messageSetWireFormat = r101;
            }

            public void writeUntil(int r100, CodedOutputStream r101) throws IOException {
            L2:
                Map.Entry<Descriptors.FieldDescriptor, Object> r102 = this.next;
                if (r102 == null) goto L21;
                if (r102.getKey().getNumber() >= r100) goto L29;
                Descriptors.FieldDescriptor r103 = this.next.getKey();
                if (this.messageSetWireFormat == true) goto L9;
            L16:
                FieldSet.writeField(r103, this.next.getValue(), r101);
            L18:
                if (this.iter.hasNext() == true) goto L19;
                this.next = null;
                goto L2
            L19:
                this.next = this.iter.next();
                goto L2
            L9:
                if (r103.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L16;
                if (r103.isRepeated() == true) goto L16;
                if ((this.next instanceof LazyField.LazyEntry) == false) goto L15;
                r101.writeRawMessageSetExtension(r103.getNumber(), ((LazyField.LazyEntry) this.next).getField().toByteString());
                goto L18
            L15:
                r101.writeMessageSetExtension(r103.getNumber(), (Message) this.next.getValue());
                goto L18
            L29:
                return;
            }

            public /* synthetic */ ExtensionWriter(ExtendableMessage r100, boolean r101, AnonymousClass1 r102) {
                this(r100, r101);
            }
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map r100 = GeneratedMessage.access$800(this, false);
            r100.putAll(getExtensionFields());
            return Collections.unmodifiableMap(r100);
        }

        @Override // com.google.protobuf.GeneratedMessage
        public Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
            Map r100 = GeneratedMessage.access$800(this, false);
            r100.putAll(getExtensionFields());
            return Collections.unmodifiableMap(r100);
        }

        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        public int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }

        public Map<Descriptors.FieldDescriptor, Object> getExtensionFields() {
            return this.extensions.getAllFields();
        }

        @Override // com.google.protobuf.GeneratedMessage
        public void makeExtensionsImmutable() {
            this.extensions.makeImmutable();
        }

        public ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, null);
        }

        public ExtendableMessage<MessageType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(this, true, null);
        }

        public ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            if (super.isInitialized() == true) goto L5;
        L7:
            return false;
        L5:
            if (extensionsAreInitialized() == false) goto L7;
            return true;
        }

        public ExtendableMessage(ExtendableBuilder<MessageType, ?> r100) {
            super(r100);
            this.extensions = ExtendableBuilder.access$400(r100);
        }

        public static /* synthetic */ FieldSet access$600(ExtendableMessage r100) {
            return r100.extensions;
        }

        private void verifyContainingType(Descriptors.FieldDescriptor r100) {
            if (r100.getContainingType() != getDescriptorForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        private void verifyExtensionContainingType(Extension<MessageType, ?> r100) {
            if (r100.getDescriptor().getContainingType() != getDescriptorForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("Extension is for type \"" + r100.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> r100) {
            Extension<MessageType, ?> r101 = GeneratedMessage.access$500(r100);
            verifyExtensionContainingType(r101);
            Descriptors.FieldDescriptor r102 = r101.getDescriptor();
            Object r103 = this.extensions.getField(r102);
            if (r103 != null) goto L15;
            if (r102.isRepeated() == false) goto L9;
            return (Type) Collections.emptyList();
        L9:
            if (r102.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L13;
            return (Type) r101.getMessageDefaultInstance();
        L13:
            return (Type) r101.fromReflectionType(r102.getDefaultValue());
        L15:
            return (Type) r101.fromReflectionType(r103);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> r100) {
            Extension<MessageType, ?> r101 = GeneratedMessage.access$500(r100);
            verifyExtensionContainingType(r101);
            Descriptors.FieldDescriptor r102 = r101.getDescriptor();
            return this.extensions.getRepeatedFieldCount(r102);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor r100) {
            if (r100.isExtension() == false) goto L18;
            verifyContainingType(r100);
            Object r101 = this.extensions.getField(r100);
            if (r101 == null) goto L7;
            return r101;
        L7:
            if (r100.isRepeated() == false) goto L11;
            return Collections.emptyList();
        L11:
            if (r100.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L15;
            return DynamicMessage.getDefaultInstance(r100.getMessageType());
        L15:
            return r100.getDefaultValue();
        L18:
            return super.getField(r100);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r100) {
            if (r100.isExtension() == false) goto L7;
            verifyContainingType(r100);
            return this.extensions.getRepeatedFieldCount(r100);
        L7:
            return super.getRepeatedFieldCount(r100);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> r100) {
            Extension<MessageType, ?> r101 = GeneratedMessage.access$500(r100);
            verifyExtensionContainingType(r101);
            return this.extensions.hasField(r101.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor r100) {
            if (r100.isExtension() == false) goto L7;
            verifyContainingType(r100);
            return this.extensions.hasField(r100);
        L7:
            return super.hasField(r100);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(Extension<MessageType, Type> r100) {
            return (Type) getExtension(r100);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(Extension<MessageType, List<Type>> r100) {
            return getExtensionCount(r100);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(Extension<MessageType, Type> r100) {
            return hasExtension(r100);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> r100) {
            return (Type) getExtension(r100);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> r100) {
            return getExtensionCount(r100);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> r100) {
            return hasExtension(r100);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r100, int r101) {
            Extension<MessageType, ?> r102 = GeneratedMessage.access$500(r100);
            verifyExtensionContainingType(r102);
            Descriptors.FieldDescriptor r103 = r102.getDescriptor();
            return (Type) r102.singularFromReflectionType(this.extensions.getRepeatedField(r103, r101));
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r100, int r101) {
            if (r100.isExtension() == false) goto L7;
            verifyContainingType(r100);
            return this.extensions.getRepeatedField(r100, r101);
        L7:
            return super.getRepeatedField(r100, r101);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(Extension<MessageType, List<Type>> r100, int r101) {
            return (Type) getExtension(r100, r101);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> r100, int r101) {
            return (Type) getExtension(r100, r101);
        }

        @Override // com.google.protobuf.GeneratedMessage
        public boolean parseUnknownField(CodedInputStream r100, UnknownFieldSet.Builder r101, ExtensionRegistryLite r102, int r110) throws IOException {
            return MessageReflection.mergeFieldFrom(r100, r101, r102, getDescriptorForType(), new MessageReflection.ExtensionAdapter(this.extensions), r110);
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageOrBuilder {
        @Override // com.google.protobuf.MessageOrBuilder
        Message getDefaultInstanceForType();

        <Type> Type getExtension(Extension<MessageType, Type> r100);

        <Type> Type getExtension(Extension<MessageType, List<Type>> r100, int r101);

        <Type> Type getExtension(ExtensionLite<MessageType, Type> r100);

        <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r100, int r101);

        <Type> Type getExtension(GeneratedExtension<MessageType, Type> r100);

        <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> r100, int r101);

        <Type> int getExtensionCount(Extension<MessageType, List<Type>> r100);

        <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> r100);

        <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> r100);

        <Type> boolean hasExtension(Extension<MessageType, Type> r100);

        <Type> boolean hasExtension(ExtensionLite<MessageType, Type> r100);

        <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> r100);
    }

    public interface ExtensionDescriptorRetriever {
        Descriptors.FieldDescriptor getDescriptor();
    }

    public static final class FieldAccessorTable {
        private String[] camelCaseNames;
        private final Descriptors.Descriptor descriptor;
        private final FieldAccessor[] fields;
        private volatile boolean initialized;
        private final OneofAccessor[] oneofs;

        public interface FieldAccessor {
            void addRepeated(Builder r100, Object r101);

            void clear(Builder r100);

            Object get(Builder r100);

            Object get(GeneratedMessage r100);

            Message.Builder getBuilder(Builder r100);

            Object getRaw(Builder r100);

            Object getRaw(GeneratedMessage r100);

            Object getRepeated(Builder r100, int r101);

            Object getRepeated(GeneratedMessage r100, int r101);

            Message.Builder getRepeatedBuilder(Builder r100, int r101);

            int getRepeatedCount(Builder r100);

            int getRepeatedCount(GeneratedMessage r100);

            Object getRepeatedRaw(Builder r100, int r101);

            Object getRepeatedRaw(GeneratedMessage r100, int r101);

            boolean has(Builder r100);

            boolean has(GeneratedMessage r100);

            Message.Builder newBuilder();

            void set(Builder r100, Object r101);

            void setRepeated(Builder r100, int r101, Object r102);
        }

        public static class MapFieldAccessor implements FieldAccessor {
            private final Descriptors.FieldDescriptor field;
            private final Message mapEntryMessageDefaultInstance;

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return this.mapEntryMessageDefaultInstance.newBuilderForType();
            }

            private MapField<?, ?> getMapField(Builder r100) {
                return r100.internalGetMapField(this.field.getNumber());
            }

            private MapField<?, ?> getMutableMapField(Builder r100) {
                return r100.internalGetMutableMapField(this.field.getNumber());
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(Builder r100) {
                getMutableMapField(r100).getMutableList().clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder r100) {
                ArrayList r101 = new ArrayList();
                int r102 = 0;
            L4:
                if (r102 >= getRepeatedCount(r100)) goto L7;
                r101.add(getRepeated(r100, r102));
                r102 = r102 + 1;
                goto L4
            L7:
                return Collections.unmodifiableList(r101);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder r100) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(Builder r100) {
                return get(r100);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder r100) {
                return getMapField(r100).getList().size();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder r100) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            private MapField<?, ?> getMapField(GeneratedMessage r100) {
                return r100.internalGetMapField(this.field.getNumber());
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage r100) {
                ArrayList r101 = new ArrayList();
                int r102 = 0;
            L4:
                if (r102 >= getRepeatedCount(r100)) goto L7;
                r101.add(getRepeated(r100, r102));
                r102 = r102 + 1;
                goto L4
            L7:
                return Collections.unmodifiableList(r101);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage r100) {
                return get(r100);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessage r100) {
                return getMapField(r100).getList().size();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessage r100) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder r100, Object r101) {
                getMutableMapField(r100).getMutableList().add((Message) r101);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder r100, int r101) {
                return ListProtector.get(getMapField(r100).getList(), r101);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder r100, int r101) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeatedRaw(Builder r100, int r101) {
                return getRepeated(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder r100, Object r101) {
                clear(r100);
                Iterator r102 = ((List) r101).iterator();
            L4:
                if (r102.hasNext() == false) goto L6;
                addRepeated(r100, r102.next());
                goto L4
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage r100, int r101) {
                return ListProtector.get(getMapField(r100).getList(), r101);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeatedRaw(GeneratedMessage r100, int r101) {
                return getRepeated(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder r100, int r101, Object r102) {
                ListProtector.set(getMutableMapField(r100).getMutableList(), r101, (Message) r102);
            }

            public MapFieldAccessor(Descriptors.FieldDescriptor r100, String r101, Class<? extends GeneratedMessage> r102, Class<? extends Builder> r103) {
                this.field = r100;
                this.mapEntryMessageDefaultInstance = getMapField((GeneratedMessage) GeneratedMessage.access$1200(GeneratedMessage.access$1100(r102, "getDefaultInstance", new Class[0]), null, new Object[0])).getMapEntryMessageDefaultInstance();
            }
        }

        public static class OneofAccessor {
            private final java.lang.reflect.Method caseMethod;
            private final java.lang.reflect.Method caseMethodBuilder;
            private final java.lang.reflect.Method clearMethod;
            private final Descriptors.Descriptor descriptor;

            public void clear(Builder r100) {
                GeneratedMessage.access$1200(this.clearMethod, r100, new Object[0]);
            }

            public Descriptors.FieldDescriptor get(Builder r100) {
                int r101 = ((Internal.EnumLite) GeneratedMessage.access$1200(this.caseMethodBuilder, r100, new Object[0])).getNumber();
                if (r101 > 0) goto L5;
                return null;
            L5:
                return this.descriptor.findFieldByNumber(r101);
            }

            public boolean has(Builder r100) {
                if (((Internal.EnumLite) GeneratedMessage.access$1200(this.caseMethodBuilder, r100, new Object[0])).getNumber() != 0) goto L5;
                return false;
            L5:
                return true;
            }

            public Descriptors.FieldDescriptor get(GeneratedMessage r100) {
                int r101 = ((Internal.EnumLite) GeneratedMessage.access$1200(this.caseMethod, r100, new Object[0])).getNumber();
                if (r101 > 0) goto L5;
                return null;
            L5:
                return this.descriptor.findFieldByNumber(r101);
            }

            public boolean has(GeneratedMessage r100) {
                if (((Internal.EnumLite) GeneratedMessage.access$1200(this.caseMethod, r100, new Object[0])).getNumber() != 0) goto L5;
                return false;
            L5:
                return true;
            }

            public OneofAccessor(Descriptors.Descriptor r100, String r101, Class<? extends GeneratedMessage> r102, Class<? extends Builder> r103) {
                this.descriptor = r100;
                this.caseMethod = GeneratedMessage.access$1100(r102, MonitorConstants.CONNECT_TYPE_GET + r101 + "Case", new Class[0]);
                this.caseMethodBuilder = GeneratedMessage.access$1100(r103, MonitorConstants.CONNECT_TYPE_GET + r101 + "Case", new Class[0]);
                StringBuilder r104 = new StringBuilder("clear");
                r104.append(r101);
                this.clearMethod = GeneratedMessage.access$1100(r103, r104.toString(), new Class[0]);
            }
        }

        public static final class RepeatedEnumFieldAccessor extends RepeatedFieldAccessor {
            private java.lang.reflect.Method addRepeatedValueMethod;
            private Descriptors.EnumDescriptor enumDescriptor;
            private java.lang.reflect.Method getRepeatedValueMethod;
            private java.lang.reflect.Method getRepeatedValueMethodBuilder;
            private final java.lang.reflect.Method getValueDescriptorMethod;
            private java.lang.reflect.Method setRepeatedValueMethod;
            private boolean supportUnknownEnumValue;
            private final java.lang.reflect.Method valueOfMethod;

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder r100) {
                ArrayList r101 = new ArrayList();
                int r102 = getRepeatedCount(r100);
                int r103 = 0;
            L3:
                if (r103 >= r102) goto L6;
                r101.add(getRepeated(r100, r103));
                r103 = r103 + 1;
                goto L3
            L6:
                return Collections.unmodifiableList(r101);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage r100) {
                ArrayList r101 = new ArrayList();
                int r102 = getRepeatedCount(r100);
                int r103 = 0;
            L3:
                if (r103 >= r102) goto L6;
                r101.add(getRepeated(r100, r103));
                r103 = r103 + 1;
                goto L3
            L6:
                return Collections.unmodifiableList(r101);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder r100, Object r101) {
                if (this.supportUnknownEnumValue == false) goto L6;
                GeneratedMessage.access$1200(this.addRepeatedValueMethod, r100, new Object[]{Integer.valueOf(((Descriptors.EnumValueDescriptor) r101).getNumber())});
                return;
            L6:
                super.addRepeated(r100, GeneratedMessage.access$1200(this.valueOfMethod, null, new Object[]{r101}));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder r100, int r101) {
                if (this.supportUnknownEnumValue == false) goto L7;
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((Integer) GeneratedMessage.access$1200(this.getRepeatedValueMethodBuilder, r100, new Object[]{Integer.valueOf(r101)})).intValue());
            L7:
                return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.getRepeated(r100, r101), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage r100, int r101) {
                if (this.supportUnknownEnumValue == false) goto L7;
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((Integer) GeneratedMessage.access$1200(this.getRepeatedValueMethod, r100, new Object[]{Integer.valueOf(r101)})).intValue());
            L7:
                return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.getRepeated(r100, r101), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder r100, int r101, Object r102) {
                if (this.supportUnknownEnumValue == false) goto L6;
                GeneratedMessage.access$1200(this.setRepeatedValueMethod, r100, new Object[]{Integer.valueOf(r101), Integer.valueOf(((Descriptors.EnumValueDescriptor) r102).getNumber())});
                return;
            L6:
                super.setRepeated(r100, r101, GeneratedMessage.access$1200(this.valueOfMethod, null, new Object[]{r102}));
            }

            public RepeatedEnumFieldAccessor(Descriptors.FieldDescriptor r100, String r101, Class<? extends GeneratedMessage> r102, Class<? extends Builder> r110) {
                super(r100, r101, r102, r110);
                this.enumDescriptor = r100.getEnumType();
                this.valueOfMethod = GeneratedMessage.access$1100(this.type, "valueOf", new Class[]{Descriptors.EnumValueDescriptor.class});
                this.getValueDescriptorMethod = GeneratedMessage.access$1100(this.type, "getValueDescriptor", new Class[0]);
                boolean r103 = r100.getFile().supportsUnknownEnumValue();
                this.supportUnknownEnumValue = r103;
                if (r103 == false) goto L6;
                String r104 = MonitorConstants.CONNECT_TYPE_GET + r101 + "Value";
                Class r105 = Integer.TYPE;
                this.getRepeatedValueMethod = GeneratedMessage.access$1100(r102, r104, new Class[]{r105});
                this.getRepeatedValueMethodBuilder = GeneratedMessage.access$1100(r110, MonitorConstants.CONNECT_TYPE_GET + r101 + "Value", new Class[]{r105});
                this.setRepeatedValueMethod = GeneratedMessage.access$1100(r110, "set" + r101 + "Value", new Class[]{r105, r105});
                this.addRepeatedValueMethod = GeneratedMessage.access$1100(r110, "add" + r101 + "Value", new Class[]{r105});
                return;
            }
        }

        public static class RepeatedFieldAccessor implements FieldAccessor {
            protected final java.lang.reflect.Method addRepeatedMethod;
            protected final java.lang.reflect.Method clearMethod;
            protected final java.lang.reflect.Method getCountMethod;
            protected final java.lang.reflect.Method getCountMethodBuilder;
            protected final java.lang.reflect.Method getMethod;
            protected final java.lang.reflect.Method getMethodBuilder;
            protected final java.lang.reflect.Method getRepeatedMethod;
            protected final java.lang.reflect.Method getRepeatedMethodBuilder;
            protected final java.lang.reflect.Method setRepeatedMethod;
            protected final Class type;

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(Builder r100) {
                GeneratedMessage.access$1200(this.clearMethod, r100, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder r100) {
                return GeneratedMessage.access$1200(this.getMethodBuilder, r100, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder r100) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(Builder r100) {
                return get(r100);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder r100) {
                return ((Integer) GeneratedMessage.access$1200(this.getCountMethodBuilder, r100, new Object[0])).intValue();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder r100) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage r100) {
                return GeneratedMessage.access$1200(this.getMethod, r100, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage r100) {
                return get(r100);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessage r100) {
                return ((Integer) GeneratedMessage.access$1200(this.getCountMethod, r100, new Object[0])).intValue();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessage r100) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder r100, Object r101) {
                GeneratedMessage.access$1200(this.addRepeatedMethod, r100, new Object[]{r101});
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder r100, int r101) {
                return GeneratedMessage.access$1200(this.getRepeatedMethodBuilder, r100, new Object[]{Integer.valueOf(r101)});
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder r100, int r101) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeatedRaw(Builder r100, int r101) {
                return getRepeated(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder r100, Object r101) {
                clear(r100);
                Iterator r102 = ((List) r101).iterator();
            L4:
                if (r102.hasNext() == false) goto L6;
                addRepeated(r100, r102.next());
                goto L4
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage r100, int r101) {
                return GeneratedMessage.access$1200(this.getRepeatedMethod, r100, new Object[]{Integer.valueOf(r101)});
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeatedRaw(GeneratedMessage r100, int r101) {
                return getRepeated(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder r100, int r101, Object r102) {
                GeneratedMessage.access$1200(this.setRepeatedMethod, r100, new Object[]{Integer.valueOf(r101), r102});
            }

            public RepeatedFieldAccessor(Descriptors.FieldDescriptor r100, String r101, Class<? extends GeneratedMessage> r102, Class<? extends Builder> r110) {
                this.getMethod = GeneratedMessage.access$1100(r102, MonitorConstants.CONNECT_TYPE_GET + r101 + "List", new Class[0]);
                this.getMethodBuilder = GeneratedMessage.access$1100(r110, MonitorConstants.CONNECT_TYPE_GET + r101 + "List", new Class[0]);
                StringBuilder r103 = new StringBuilder(MonitorConstants.CONNECT_TYPE_GET);
                r103.append(r101);
                String r104 = r103.toString();
                Class r105 = Integer.TYPE;
                java.lang.reflect.Method r106 = GeneratedMessage.access$1100(r102, r104, new Class[]{r105});
                this.getRepeatedMethod = r106;
                this.getRepeatedMethodBuilder = GeneratedMessage.access$1100(r110, MonitorConstants.CONNECT_TYPE_GET + r101, new Class[]{r105});
                Class<?> r107 = r106.getReturnType();
                this.type = r107;
                this.setRepeatedMethod = GeneratedMessage.access$1100(r110, "set" + r101, new Class[]{r105, r107});
                this.addRepeatedMethod = GeneratedMessage.access$1100(r110, "add" + r101, new Class[]{r107});
                this.getCountMethod = GeneratedMessage.access$1100(r102, MonitorConstants.CONNECT_TYPE_GET + r101 + "Count", new Class[0]);
                this.getCountMethodBuilder = GeneratedMessage.access$1100(r110, MonitorConstants.CONNECT_TYPE_GET + r101 + "Count", new Class[0]);
                StringBuilder r108 = new StringBuilder("clear");
                r108.append(r101);
                this.clearMethod = GeneratedMessage.access$1100(r110, r108.toString(), new Class[0]);
            }
        }

        public static final class RepeatedMessageFieldAccessor extends RepeatedFieldAccessor {
            private final java.lang.reflect.Method getBuilderMethodBuilder;
            private final java.lang.reflect.Method newBuilderMethod;

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return (Message.Builder) GeneratedMessage.access$1200(this.newBuilderMethod, null, new Object[0]);
            }

            private Object coerceType(Object r100) {
                if (this.type.isInstance(r100) == false) goto L6;
                return r100;
            L6:
                return ((Message.Builder) GeneratedMessage.access$1200(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message) r100).build();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder r100, Object r101) {
                super.addRepeated(r100, coerceType(r101));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder r100, int r101) {
                return (Message.Builder) GeneratedMessage.access$1200(this.getBuilderMethodBuilder, r100, new Object[]{Integer.valueOf(r101)});
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder r100, int r101, Object r102) {
                super.setRepeated(r100, r101, coerceType(r102));
            }

            public RepeatedMessageFieldAccessor(Descriptors.FieldDescriptor r100, String r101, Class<? extends GeneratedMessage> r102, Class<? extends Builder> r103) {
                super(r100, r101, r102, r103);
                this.newBuilderMethod = GeneratedMessage.access$1100(this.type, "newBuilder", new Class[0]);
                this.getBuilderMethodBuilder = GeneratedMessage.access$1100(r103, MonitorConstants.CONNECT_TYPE_GET + r101 + "Builder", new Class[]{Integer.TYPE});
            }
        }

        public static final class SingularEnumFieldAccessor extends SingularFieldAccessor {
            private Descriptors.EnumDescriptor enumDescriptor;
            private java.lang.reflect.Method getValueDescriptorMethod;
            private java.lang.reflect.Method getValueMethod;
            private java.lang.reflect.Method getValueMethodBuilder;
            private java.lang.reflect.Method setValueMethod;
            private boolean supportUnknownEnumValue;
            private java.lang.reflect.Method valueOfMethod;

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder r100) {
                if (this.supportUnknownEnumValue == false) goto L7;
                int r101 = ((Integer) GeneratedMessage.access$1200(this.getValueMethodBuilder, r100, new Object[0])).intValue();
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(r101);
            L7:
                return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.get(r100), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage r100) {
                if (this.supportUnknownEnumValue == false) goto L7;
                int r101 = ((Integer) GeneratedMessage.access$1200(this.getValueMethod, r100, new Object[0])).intValue();
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(r101);
            L7:
                return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.get(r100), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder r100, Object r101) {
                if (this.supportUnknownEnumValue == false) goto L6;
                GeneratedMessage.access$1200(this.setValueMethod, r100, new Object[]{Integer.valueOf(((Descriptors.EnumValueDescriptor) r101).getNumber())});
                return;
            L6:
                super.set(r100, GeneratedMessage.access$1200(this.valueOfMethod, null, new Object[]{r101}));
            }

            public SingularEnumFieldAccessor(Descriptors.FieldDescriptor r100, String r101, Class<? extends GeneratedMessage> r102, Class<? extends Builder> r103, String r104) {
                super(r100, r101, r102, r103, r104);
                this.enumDescriptor = r100.getEnumType();
                this.valueOfMethod = GeneratedMessage.access$1100(this.type, "valueOf", new Class[]{Descriptors.EnumValueDescriptor.class});
                this.getValueDescriptorMethod = GeneratedMessage.access$1100(this.type, "getValueDescriptor", new Class[0]);
                boolean r105 = r100.getFile().supportsUnknownEnumValue();
                this.supportUnknownEnumValue = r105;
                if (r105 == false) goto L6;
                this.getValueMethod = GeneratedMessage.access$1100(r102, MonitorConstants.CONNECT_TYPE_GET + r101 + "Value", new Class[0]);
                this.getValueMethodBuilder = GeneratedMessage.access$1100(r103, MonitorConstants.CONNECT_TYPE_GET + r101 + "Value", new Class[0]);
                this.setValueMethod = GeneratedMessage.access$1100(r103, "set" + r101 + "Value", new Class[]{Integer.TYPE});
                return;
            }
        }

        public static class SingularFieldAccessor implements FieldAccessor {
            protected final java.lang.reflect.Method caseMethod;
            protected final java.lang.reflect.Method caseMethodBuilder;
            protected final java.lang.reflect.Method clearMethod;
            protected final Descriptors.FieldDescriptor field;
            protected final java.lang.reflect.Method getMethod;
            protected final java.lang.reflect.Method getMethodBuilder;
            protected final boolean hasHasMethod;
            protected final java.lang.reflect.Method hasMethod;
            protected final java.lang.reflect.Method hasMethodBuilder;
            protected final boolean isOneofField;
            protected final java.lang.reflect.Method setMethod;
            protected final Class<?> type;

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            private int getOneofFieldNumber(Builder r100) {
                return ((Internal.EnumLite) GeneratedMessage.access$1200(this.caseMethodBuilder, r100, new Object[0])).getNumber();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(Builder r100) {
                GeneratedMessage.access$1200(this.clearMethod, r100, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder r100) {
                return GeneratedMessage.access$1200(this.getMethodBuilder, r100, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder r100) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(Builder r100) {
                return get(r100);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder r100) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder r100) {
                if (this.hasHasMethod == true) goto L13;
                if (this.isOneofField == false) goto L11;
                if (getOneofFieldNumber(r100) != this.field.getNumber()) goto L14;
                return true;
            L14:
                return false;
            L11:
                return !get(r100).equals(this.field.getDefaultValue());
            L13:
                return ((Boolean) GeneratedMessage.access$1200(this.hasMethodBuilder, r100, new Object[0])).booleanValue();
            }

            private int getOneofFieldNumber(GeneratedMessage r100) {
                return ((Internal.EnumLite) GeneratedMessage.access$1200(this.caseMethod, r100, new Object[0])).getNumber();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage r100) {
                return GeneratedMessage.access$1200(this.getMethod, r100, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage r100) {
                return get(r100);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessage r100) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessage r100) {
                if (this.hasHasMethod == true) goto L13;
                if (this.isOneofField == false) goto L11;
                if (getOneofFieldNumber(r100) != this.field.getNumber()) goto L14;
                return true;
            L14:
                return false;
            L11:
                return !get(r100).equals(this.field.getDefaultValue());
            L13:
                return ((Boolean) GeneratedMessage.access$1200(this.hasMethod, r100, new Object[0])).booleanValue();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder r100, Object r101) {
                throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder r100, int r101) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder r100, int r101) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeatedRaw(Builder r100, int r101) {
                throw new UnsupportedOperationException("getRepeatedFieldRaw() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder r100, Object r101) {
                GeneratedMessage.access$1200(this.setMethod, r100, new Object[]{r101});
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage r100, int r101) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeatedRaw(GeneratedMessage r100, int r101) {
                throw new UnsupportedOperationException("getRepeatedFieldRaw() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder r100, int r101, Object r102) {
                throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
            }

            public SingularFieldAccessor(Descriptors.FieldDescriptor r100, String r101, Class<? extends GeneratedMessage> r110, Class<? extends Builder> r111, String r112) {
                this.field = r100;
                if (r100.getContainingOneof() == null) goto L5;
                boolean r102 = true;
            L6:
                this.isOneofField = r102;
                if (FieldAccessorTable.access$1300(r100.getFile()) == true) goto L13;
                if (r102 == false) goto L10;
            L12:
                boolean r103 = false;
            L14:
                this.hasHasMethod = r103;
                java.lang.reflect.Method r104 = GeneratedMessage.access$1100(r110, MonitorConstants.CONNECT_TYPE_GET + r101, new Class[0]);
                this.getMethod = r104;
                this.getMethodBuilder = GeneratedMessage.access$1100(r111, MonitorConstants.CONNECT_TYPE_GET + r101, new Class[0]);
                Class<?> r105 = r104.getReturnType();
                this.type = r105;
                this.setMethod = GeneratedMessage.access$1100(r111, "set" + r101, new Class[]{r105});
                java.lang.reflect.Method r106 = null;
                if (r103 == false) goto L17;
                java.lang.reflect.Method r107 = GeneratedMessage.access$1100(r110, "has" + r101, new Class[0]);
            L18:
                this.hasMethod = r107;
                if (r103 == false) goto L21;
                java.lang.reflect.Method r108 = GeneratedMessage.access$1100(r111, "has" + r101, new Class[0]);
            L22:
                this.hasMethodBuilder = r108;
                this.clearMethod = GeneratedMessage.access$1100(r111, "clear" + r101, new Class[0]);
                if (r102 == false) goto L25;
                java.lang.reflect.Method r109 = GeneratedMessage.access$1100(r110, MonitorConstants.CONNECT_TYPE_GET + r112 + "Case", new Class[0]);
            L26:
                this.caseMethod = r109;
                if (r102 == false) goto L29;
                r106 = GeneratedMessage.access$1100(r111, MonitorConstants.CONNECT_TYPE_GET + r112 + "Case", new Class[0]);
            L29:
                this.caseMethodBuilder = r106;
                return;
            L25:
                r109 = null;
                goto L26
            L21:
                r108 = null;
                goto L22
            L17:
                r107 = null;
                goto L18
            L10:
                if (r100.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L12;
            L13:
                r103 = true;
                goto L14
            L5:
                r102 = false;
                goto L6
            }
        }

        public static final class SingularMessageFieldAccessor extends SingularFieldAccessor {
            private final java.lang.reflect.Method getBuilderMethodBuilder;
            private final java.lang.reflect.Method newBuilderMethod;

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return (Message.Builder) GeneratedMessage.access$1200(this.newBuilderMethod, null, new Object[0]);
            }

            private Object coerceType(Object r100) {
                if (this.type.isInstance(r100) == false) goto L6;
                return r100;
            L6:
                return ((Message.Builder) GeneratedMessage.access$1200(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message) r100).buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder r100) {
                return (Message.Builder) GeneratedMessage.access$1200(this.getBuilderMethodBuilder, r100, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder r100, Object r101) {
                super.set(r100, coerceType(r101));
            }

            public SingularMessageFieldAccessor(Descriptors.FieldDescriptor r100, String r101, Class<? extends GeneratedMessage> r102, Class<? extends Builder> r103, String r104) {
                super(r100, r101, r102, r103, r104);
                this.newBuilderMethod = GeneratedMessage.access$1100(this.type, "newBuilder", new Class[0]);
                this.getBuilderMethodBuilder = GeneratedMessage.access$1100(r103, MonitorConstants.CONNECT_TYPE_GET + r101 + "Builder", new Class[0]);
            }
        }

        public static final class SingularStringFieldAccessor extends SingularFieldAccessor {
            private final java.lang.reflect.Method getBytesMethod;
            private final java.lang.reflect.Method getBytesMethodBuilder;
            private final java.lang.reflect.Method setBytesMethodBuilder;

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(Builder r100) {
                return GeneratedMessage.access$1200(this.getBytesMethodBuilder, r100, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage r100) {
                return GeneratedMessage.access$1200(this.getBytesMethod, r100, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder r100, Object r101) {
                if ((r101 instanceof ByteString) == false) goto L5;
                GeneratedMessage.access$1200(this.setBytesMethodBuilder, r100, new Object[]{r101});
                return;
            L5:
                super.set(r100, r101);
            }

            public SingularStringFieldAccessor(Descriptors.FieldDescriptor r100, String r101, Class<? extends GeneratedMessage> r102, Class<? extends Builder> r103, String r104) {
                super(r100, r101, r102, r103, r104);
                this.getBytesMethod = GeneratedMessage.access$1100(r102, MonitorConstants.CONNECT_TYPE_GET + r101 + "Bytes", new Class[0]);
                this.getBytesMethodBuilder = GeneratedMessage.access$1100(r103, MonitorConstants.CONNECT_TYPE_GET + r101 + "Bytes", new Class[0]);
                this.setBytesMethodBuilder = GeneratedMessage.access$1100(r103, "set" + r101 + "Bytes", new Class[]{ByteString.class});
            }
        }

        private boolean isMapFieldEnabled(Descriptors.FieldDescriptor r100) {
            return true;
        }

        public static /* synthetic */ Descriptors.Descriptor access$000(FieldAccessorTable r100) {
            return r100.descriptor;
        }

        public static /* synthetic */ boolean access$1300(Descriptors.FileDescriptor r100) {
            return supportFieldPresence(r100);
        }

        private FieldAccessor getField(Descriptors.FieldDescriptor r100) {
            if (r100.getContainingType() != this.descriptor) goto L11;
            if (r100.isExtension() == true) goto L9;
            return this.fields[r100.getIndex()];
        L9:
            throw new IllegalArgumentException("This type does not have extensions.");
        L11:
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        private OneofAccessor getOneof(Descriptors.OneofDescriptor r100) {
            if (r100.getContainingType() != this.descriptor) goto L7;
            return this.oneofs[r100.getIndex()];
        L7:
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }

        private static boolean supportFieldPresence(Descriptors.FileDescriptor r100) {
            if (r100.getSyntax() != Descriptors.FileDescriptor.Syntax.PROTO2) goto L5;
            return true;
        L5:
            return false;
        }

        public FieldAccessorTable(Descriptors.Descriptor r100, String[] r101) {
            this.descriptor = r100;
            this.camelCaseNames = r101;
            this.fields = new FieldAccessor[r100.getFields().size()];
            this.oneofs = new OneofAccessor[r100.getOneofs().size()];
            this.initialized = false;
        }

        public static /* synthetic */ OneofAccessor access$100(FieldAccessorTable r100, Descriptors.OneofDescriptor r101) {
            return r100.getOneof(r101);
        }

        public static /* synthetic */ FieldAccessor access$200(FieldAccessorTable r100, Descriptors.FieldDescriptor r101) {
            return r100.getField(r101);
        }

        public FieldAccessorTable ensureFieldAccessorsInitialized(Class<? extends GeneratedMessage> r110, Class<? extends Builder> r111) {
            if (this.initialized == false) goto L5;
            return this;
        L5:
            monitor-enter(this);
        L47:
            th = move-exception;
            throw th;
        L7:
            if (this.initialized == false) goto L10;
            monitor-exit(this);     // Catch: Throwable -> L47
            return this;
        L10:
            int r100 = this.fields.length;     // Catch: Throwable -> L47
            int r101 = 0;
            int r102 = 0;
        L11:
            String r103 = null;
            if (r102 >= r100) goto L41;
            Descriptors.FieldDescriptor r104 = this.descriptor.getFields().get(r102);     // Catch: Throwable -> L47
            if (r104.getContainingOneof() == null) goto L16;
            r103 = this.camelCaseNames[r104.getContainingOneof().getIndex() + r100];     // Catch: Throwable -> L47
        L16:
            String r112 = r103;
            if (r104.isRepeated() == false) goto L31;
            if (r104.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L27;
            if (r104.isMapField() == true) goto L23;
        L25:
            this.fields[r102] = new RepeatedMessageFieldAccessor(r104, this.camelCaseNames[r102], r110, r111);     // Catch: Throwable -> L47
        L40:
            r102 = r102 + 1;     // Catch: Throwable -> L47
            goto L11
        L23:
            if (isMapFieldEnabled(r104) == false) goto L25;
            this.fields[r102] = new MapFieldAccessor(r104, this.camelCaseNames[r102], r110, r111);     // Catch: Throwable -> L47
            goto L40
        L27:
            if (r104.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) goto L29;
            this.fields[r102] = new RepeatedEnumFieldAccessor(r104, this.camelCaseNames[r102], r110, r111);     // Catch: Throwable -> L47
            goto L40
        L29:
            this.fields[r102] = new RepeatedFieldAccessor(r104, this.camelCaseNames[r102], r110, r111);     // Catch: Throwable -> L47
            goto L40
        L31:
            if (r104.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L34;
            this.fields[r102] = new SingularMessageFieldAccessor(r104, this.camelCaseNames[r102], r110, r111, r112);     // Catch: Throwable -> L47
            goto L40
        L34:
            if (r104.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) goto L37;
            this.fields[r102] = new SingularEnumFieldAccessor(r104, this.camelCaseNames[r102], r110, r111, r112);     // Catch: Throwable -> L47
            goto L40
        L37:
            if (r104.getJavaType() != Descriptors.FieldDescriptor.JavaType.STRING) goto L39;
            this.fields[r102] = new SingularStringFieldAccessor(r104, this.camelCaseNames[r102], r110, r111, r112);     // Catch: Throwable -> L47
            goto L40
        L39:
            this.fields[r102] = new SingularFieldAccessor(r104, this.camelCaseNames[r102], r110, r111, r112);     // Catch: Throwable -> L47
            goto L40
        L41:
            int r105 = this.oneofs.length;     // Catch: Throwable -> L47
        L42:
            if (r101 >= r105) goto L44;
            this.oneofs[r101] = new OneofAccessor(this.descriptor, this.camelCaseNames[r101 + r100], r110, r111);     // Catch: Throwable -> L47
            r101 = r101 + 1;     // Catch: Throwable -> L47
            goto L42
        L44:
            this.initialized = true;     // Catch: Throwable -> L47
            this.camelCaseNames = null;     // Catch: Throwable -> L47
            monitor-exit(this);     // Catch: Throwable -> L47
            return this;
        }

        public FieldAccessorTable(Descriptors.Descriptor r100, String[] r101, Class<? extends GeneratedMessage> r102, Class<? extends Builder> r103) {
            this(r100, r101);
            ensureFieldAccessorsInitialized(r102, r103);
        }
    }

    public static class GeneratedExtension<ContainingType extends Message, Type> extends Extension<ContainingType, Type> {
        private ExtensionDescriptorRetriever descriptorRetriever;
        private final java.lang.reflect.Method enumGetValueDescriptor;
        private final java.lang.reflect.Method enumValueOf;
        private final Extension.ExtensionType extensionType;
        private final Message messageDefaultInstance;
        private final Class singularType;

        @Override // com.google.protobuf.Extension
        public Descriptors.FieldDescriptor getDescriptor() {
            ExtensionDescriptorRetriever r100 = this.descriptorRetriever;
            if (r100 == null) goto L7;
            return r100.getDescriptor();
        L7:
            throw new IllegalStateException("getDescriptor() called before internalInit()");
        }

        @Override // com.google.protobuf.ExtensionLite
        public Type getDefaultValue() {
            if (isRepeated() == false) goto L7;
            return (Type) Collections.emptyList();
        L7:
            if (getDescriptor().getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L11;
            return (Type) this.messageDefaultInstance;
        L11:
            return (Type) singularFromReflectionType(getDescriptor().getDefaultValue());
        }

        @Override // com.google.protobuf.ExtensionLite
        public WireFormat.FieldType getLiteType() {
            return getDescriptor().getLiteType();
        }

        @Override // com.google.protobuf.ExtensionLite
        public /* bridge */ /* synthetic */ MessageLite getMessageDefaultInstance() {
            return getMessageDefaultInstance();
        }

        @Override // com.google.protobuf.ExtensionLite
        public int getNumber() {
            return getDescriptor().getNumber();
        }

        @Override // com.google.protobuf.ExtensionLite
        public boolean isRepeated() {
            return getDescriptor().isRepeated();
        }

        @Override // com.google.protobuf.Extension
        public Extension.ExtensionType getExtensionType() {
            return this.extensionType;
        }

        @Override // com.google.protobuf.ExtensionLite
        public Message getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        @Override // com.google.protobuf.Extension
        public Object fromReflectionType(Object r100) {
            Descriptors.FieldDescriptor r101 = getDescriptor();
            if (r101.isRepeated() == false) goto L16;
            if (r101.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L7;
        L10:
            ArrayList r102 = new ArrayList();
            Iterator r103 = ((List) r100).iterator();
        L12:
            if (r103.hasNext() == false) goto L14;
            r102.add(singularFromReflectionType(r103.next()));
            goto L12
        L14:
            return r102;
        L7:
            if (r101.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) goto L10;
            return r100;
        L16:
            return singularFromReflectionType(r100);
        }

        public void internalInit(final Descriptors.FieldDescriptor r100) {
            if (this.descriptorRetriever != null) goto L7;
            this.descriptorRetriever = new AnonymousClass1(this, r100);
            return;
        L7:
            throw new IllegalStateException("Already initialized.");
        }

        @Override // com.google.protobuf.Extension
        public Object singularFromReflectionType(Object r100) {
            int r101 = AnonymousClass5.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[getDescriptor().getJavaType().ordinal()];
            if (r101 == 1) goto L10;
            if (r101 == 2) goto L8;
            return r100;
        L8:
            return GeneratedMessage.access$1200(this.enumValueOf, null, new Object[]{(Descriptors.EnumValueDescriptor) r100});
        L10:
            if (this.singularType.isInstance(r100) == false) goto L13;
            return r100;
        L13:
            return this.messageDefaultInstance.newBuilderForType().mergeFrom((Message) r100).build();
        }

        @Override // com.google.protobuf.Extension
        public Object singularToReflectionType(Object r100) {
            Descriptors.FieldDescriptor r101 = getDescriptor();
            if (AnonymousClass5.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[r101.getJavaType().ordinal()] == 2) goto L6;
            return r100;
        L6:
            return GeneratedMessage.access$1200(this.enumGetValueDescriptor, r100, new Object[0]);
        }

        @Override // com.google.protobuf.Extension
        public Object toReflectionType(Object r100) {
            Descriptors.FieldDescriptor r101 = getDescriptor();
            if (r101.isRepeated() == false) goto L13;
            if (r101.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) goto L11;
            ArrayList r102 = new ArrayList();
            Iterator r103 = ((List) r100).iterator();
        L8:
            if (r103.hasNext() == false) goto L10;
            r102.add(singularToReflectionType(r103.next()));
            goto L8
        L10:
            return r102;
        L11:
            return r100;
        L13:
            return singularToReflectionType(r100);
        }

        public GeneratedExtension(ExtensionDescriptorRetriever r100, Class r101, Message r102, Extension.ExtensionType r103) {
            if (Message.class.isAssignableFrom(r101) == true) goto L5;
        L9:
            this.descriptorRetriever = r100;
            this.singularType = r101;
            this.messageDefaultInstance = r102;
            if (ProtocolMessageEnum.class.isAssignableFrom(r101) == false) goto L12;
            this.enumValueOf = GeneratedMessage.access$1100(r101, "valueOf", new Class[]{Descriptors.EnumValueDescriptor.class});
            this.enumGetValueDescriptor = GeneratedMessage.access$1100(r101, "getValueDescriptor", new Class[0]);
        L13:
            this.extensionType = r103;
            return;
        L12:
            this.enumValueOf = null;
            this.enumGetValueDescriptor = null;
            goto L13
        L5:
            if (r101.isInstance(r102) == true) goto L9;
            throw new IllegalArgumentException("Bad messageDefaultInstance for ".concat(r101.getName()));
        }
    }

    public static void enableAlwaysUseFieldBuildersForTesting() {
        alwaysUseFieldBuilders = true;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        return Collections.unmodifiableMap(getAllFieldsMutable(false));
    }

    public Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
        return Collections.unmodifiableMap(getAllFieldsMutable(true));
    }

    public abstract FieldAccessorTable internalGetFieldAccessorTable();

    public void makeExtensionsImmutable() {
    }

    public abstract Message.Builder newBuilderForType(BuilderParent r100);

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<? extends GeneratedMessage> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r100 = this.memoizedSize;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        int r101 = MessageReflection.getSerializedSize(this, getAllFieldsRaw());
        this.memoizedSize = r101;
        return r101;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public UnknownFieldSet getUnknownFields() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public Object writeReplace() throws ObjectStreamException {
        return new GeneratedMessageLite.SerializedForm(this);
    }

    public GeneratedMessage() {
        this.unknownFields = UnknownFieldSet.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Descriptors.Descriptor getDescriptorForType() {
        return FieldAccessorTable.access$000(internalGetFieldAccessorTable());
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        Iterator<Descriptors.FieldDescriptor> r100 = getDescriptorForType().getFields().iterator();
    L4:
        if (r100.hasNext() == false) goto L25;
        Descriptors.FieldDescriptor r101 = r100.next();
        if (r101.isRequired() == false) goto L11;
        if (hasField(r101) == true) goto L11;
        return false;
    L11:
        if (r101.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L4;
        if (r101.isRepeated() == true) goto L14;
        if (hasField(r101) == false) goto L4;
        if (((Message) getField(r101)).isInitialized() == true) goto L4;
        return false;
    L14:
        Iterator r102 = ((List) getField(r101)).iterator();
    L16:
        if (r102.hasNext() == false) goto L4;
        if (((Message) r102.next()).isInitialized() == true) goto L16;
        return false;
    L25:
        return true;
    }

    public GeneratedMessage(Builder<?> r100) {
        this.unknownFields = r100.getUnknownFields();
    }

    public static /* synthetic */ Extension access$500(ExtensionLite r100) {
        return checkNotLite(r100);
    }

    private static <MessageType extends ExtendableMessage<MessageType>, T> Extension<MessageType, T> checkNotLite(ExtensionLite<MessageType, T> r100) {
        if (r100.isLite() == true) goto L7;
        return (Extension) r100;
    L7:
        throw new IllegalArgumentException("Expected non-lite extension.");
    }

    public static int computeStringSizeNoTag(Object r100) {
        if ((r100 instanceof String) == false) goto L7;
        return CodedOutputStream.computeStringSizeNoTag((String) r100);
    L7:
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) r100);
    }

    private Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable(boolean r100) {
        TreeMap r101 = new TreeMap();
        List<Descriptors.FieldDescriptor> r102 = FieldAccessorTable.access$000(internalGetFieldAccessorTable()).getFields();
        int r103 = 0;
    L4:
        if (r103 >= r102.size()) goto L25;
        Descriptors.FieldDescriptor r104 = (Descriptors.FieldDescriptor) ListProtector.get(r102, r103);
        Descriptors.OneofDescriptor r105 = r104.getContainingOneof();
        if (r105 == null) goto L12;
        r103 = r103 + (r105.getFieldCount() - 1);
        if (hasOneof(r105) == false) goto L24;
        r104 = getOneofFieldDescriptor(r105);
    L19:
        if (r100 == true) goto L21;
    L23:
        r101.put(r104, getField(r104));
        goto L24
    L21:
        if (r104.getJavaType() != Descriptors.FieldDescriptor.JavaType.STRING) goto L23;
        r101.put(r104, getFieldRaw(r104));
    L24:
        r103 = r103 + 1;
        goto L4
    L12:
        if (r104.isRepeated() == false) goto L17;
        List r106 = (List) getField(r104);
        if (r106.isEmpty() == true) goto L24;
        r101.put(r104, r106);
        goto L24
    L17:
        if (hasField(r104) == true) goto L19;
    L25:
        return r101;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getField(Descriptors.FieldDescriptor r100) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r100).get(this);
    }

    public Object getFieldRaw(Descriptors.FieldDescriptor r100) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r100).getRaw(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r100) {
        return FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r100).get(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor r100) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r100).getRepeatedCount(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasField(Descriptors.FieldDescriptor r100) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r100).has(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public boolean hasOneof(Descriptors.OneofDescriptor r100) {
        return FieldAccessorTable.access$100(internalGetFieldAccessorTable(), r100).has(this);
    }

    public MapField internalGetMapField(int r100) {
        throw new RuntimeException("No map fields found in ".concat(getClass().getName()));
    }

    @Override // com.google.protobuf.AbstractMessage
    public Message.Builder newBuilderForType(final AbstractMessage.BuilderParent r100) {
        return newBuilderForType(new AnonymousClass1(this, r100));
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r100) throws IOException {
        MessageReflection.writeMessageTo(this, getAllFieldsRaw(), r100, false);
    }

    public static /* synthetic */ Map access$800(GeneratedMessage r100, boolean r101) {
        return r100.getAllFieldsMutable(r101);
    }

    public static int computeStringSize(int r100, Object r101) {
        if ((r101 instanceof String) == false) goto L7;
        return CodedOutputStream.computeStringSize(r100, (String) r101);
    L7:
        return CodedOutputStream.computeBytesSize(r100, (ByteString) r101);
    }

    public static <ContainingType extends Message, Type> GeneratedExtension<ContainingType, Type> newFileScopedGeneratedExtension(Class r100, Message r101) {
        return new GeneratedExtension(null, r100, r101, Extension.ExtensionType.IMMUTABLE);
    }

    public static <M extends Message> M parseDelimitedWithIOException(Parser<M> r100, InputStream r101) throws IOException {
        return r100.parseDelimitedFrom(r101);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }

    public static <M extends Message> M parseWithIOException(Parser<M> r100, CodedInputStream r101) throws IOException {
        return r100.parseFrom(r101);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }

    public static void writeStringNoTag(CodedOutputStream r100, Object r101) throws IOException {
        if ((r101 instanceof String) == false) goto L5;
        r100.writeStringNoTag((String) r101);
        return;
    L5:
        r100.writeBytesNoTag((ByteString) r101);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getRepeatedField(Descriptors.FieldDescriptor r100, int r101) {
        return FieldAccessorTable.access$200(internalGetFieldAccessorTable(), r100).getRepeated(this, r101);
    }

    public static <M extends Message> M parseWithIOException(Parser<M> r100, InputStream r101) throws IOException {
        return r100.parseFrom(r101);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }

    public static /* synthetic */ java.lang.reflect.Method access$1100(Class r100, String r101, Class[] r102) {
        return getMethodOrDie(r100, r101, r102);
    }

    public static /* synthetic */ Object access$1200(java.lang.reflect.Method r100, Object r101, Object[] r102) {
        return invokeOrDie(r100, r101, r102);
    }

    private static java.lang.reflect.Method getMethodOrDie(Class r100, String r101, Class... r102) {
        return r100.getMethod(r101, r102);
    L4:
        e = move-exception;
        throw new RuntimeException("Generated message class \"" + r100.getName() + "\" missing method \"" + r101 + "\".", e);
    }

    private static Object invokeOrDie(java.lang.reflect.Method r100, Object r101, Object... r102) {
        return r100.invoke(r101, r102);
    L15:
        e = move-exception;
        throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
    L4:
        e = move-exception;
        Throwable r103 = e.getCause();
        if ((r103 instanceof RuntimeException) == true) goto L14;
        if ((r103 instanceof Error) == false) goto L12;
        throw ((Error) r103);
    L12:
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", r103);
    L14:
        throw ((RuntimeException) r103);
    }

    public static <M extends Message> M parseDelimitedWithIOException(Parser<M> r100, InputStream r101, ExtensionRegistryLite r102) throws IOException {
        return r100.parseDelimitedFrom(r101, r102);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }

    public static <M extends Message> M parseWithIOException(Parser<M> r100, CodedInputStream r101, ExtensionRegistryLite r102) throws IOException {
        return r100.parseFrom(r101, r102);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }

    public static void writeString(CodedOutputStream r100, int r101, Object r102) throws IOException {
        if ((r102 instanceof String) == false) goto L5;
        r100.writeString(r101, (String) r102);
        return;
    L5:
        r100.writeBytes(r101, (ByteString) r102);
    }

    public static <M extends Message> M parseWithIOException(Parser<M> r100, InputStream r101, ExtensionRegistryLite r102) throws IOException {
        return r100.parseFrom(r101, r102);
    L4:
        e = move-exception;
        throw e.unwrapIOException();
    }

    public static <ContainingType extends Message, Type> GeneratedExtension<ContainingType, Type> newFileScopedGeneratedExtension(final Class r100, Message r101, final String r102, final String r103) {
        return new GeneratedExtension(new AnonymousClass4(r100, r102, r103), r100, r101, Extension.ExtensionType.MUTABLE);
    }

    public static <ContainingType extends Message, Type> GeneratedExtension<ContainingType, Type> newMessageScopedGeneratedExtension(final Message r100, final int r101, Class r102, Message r103) {
        return new GeneratedExtension(new AnonymousClass2(r100, r101), r102, r103, Extension.ExtensionType.IMMUTABLE);
    }

    public boolean parseUnknownField(CodedInputStream r100, UnknownFieldSet.Builder r101, ExtensionRegistryLite r102, int r103) throws IOException {
        return r101.mergeFieldFrom(r103, r100);
    }

    public static <ContainingType extends Message, Type> GeneratedExtension<ContainingType, Type> newMessageScopedGeneratedExtension(final Message r100, final String r101, Class r102, Message r103) {
        return new GeneratedExtension(new AnonymousClass3(r100, r101), r102, r103, Extension.ExtensionType.MUTABLE);
    }
}
