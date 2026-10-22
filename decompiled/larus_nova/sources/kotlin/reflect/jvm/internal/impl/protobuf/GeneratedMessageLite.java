package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType = null;

        static {
            int[] r100 = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = r100;
            r100[WireFormat.JavaType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static abstract class Builder<MessageType extends GeneratedMessageLite, BuilderType extends Builder> extends AbstractMessageLite.Builder<BuilderType> {
        private ByteString unknownFields;

        public abstract MessageType getDefaultInstanceForType();

        public abstract BuilderType mergeFrom(MessageType r100);

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public Builder() {
            this.unknownFields = ByteString.EMPTY;
        }

        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public final ByteString getUnknownFields() {
            return this.unknownFields;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo10730clone() {
            return clone();
        }

        public final BuilderType setUnknownFields(ByteString r100) {
            this.unknownFields = r100;
            return this;
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
        private FieldSet<ExtensionDescriptor> extensions;
        private boolean extensionsIsMutable;

        private FieldSet<ExtensionDescriptor> buildExtensions() {
            this.extensions.makeImmutable();
            this.extensionsIsMutable = false;
            return this.extensions;
        }

        private void ensureExtensionsIsMutable() {
            if (this.extensionsIsMutable == true) goto L6;
            this.extensions = this.extensions.m10731clone();
            this.extensionsIsMutable = true;
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public ExtendableBuilder() {
            this.extensions = FieldSet.emptySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo10730clone() {
            return clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ Builder clone() {
            return clone();
        }

        public static /* synthetic */ FieldSet access$000(ExtendableBuilder r100) {
            return r100.buildExtensions();
        }

        public final void mergeExtensionFields(MessageType r100) {
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(ExtendableMessage.access$200(r100));
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite implements ExtendableMessageOrBuilder<MessageType> {
        private final FieldSet<ExtensionDescriptor> extensions;

        public class ExtensionWriter {
            private final Iterator<Map.Entry<ExtensionDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<ExtensionDescriptor, Object> next;
            final /* synthetic */ ExtendableMessage this$0;

            private ExtensionWriter(ExtendableMessage r100, boolean r101) {
                this.this$0 = r100;
                Iterator<Map.Entry<ExtensionDescriptor, Object>> r102 = ExtendableMessage.access$200(r100).iterator();
                this.iter = r102;
                if (r102.hasNext() == false) goto L5;
                this.next = r102.next();
            L5:
                this.messageSetWireFormat = r101;
            }

            public void writeUntil(int r100, CodedOutputStream r101) throws IOException {
            L2:
                Map.Entry<ExtensionDescriptor, Object> r102 = this.next;
                if (r102 == null) goto L18;
                if (r102.getKey().getNumber() >= r100) goto L26;
                ExtensionDescriptor r103 = this.next.getKey();
                if (this.messageSetWireFormat == true) goto L9;
            L13:
                FieldSet.writeField(r103, this.next.getValue(), r101);
            L15:
                if (this.iter.hasNext() == true) goto L16;
                this.next = null;
                goto L2
            L16:
                this.next = this.iter.next();
                goto L2
            L9:
                if (r103.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L13;
                if (r103.isRepeated() == true) goto L13;
                r101.writeMessageSetExtension(r103.getNumber(), (MessageLite) this.next.getValue());
                goto L15
            L26:
                return;
            }

            public /* synthetic */ ExtensionWriter(ExtendableMessage r100, boolean r101, AnonymousClass1 r102) {
                this(r100, r101);
            }
        }

        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        public void makeExtensionsImmutable() {
            this.extensions.makeImmutable();
        }

        public ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, null);
        }

        public ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        public ExtendableMessage(ExtendableBuilder<MessageType, ?> r100) {
            this.extensions = ExtendableBuilder.access$000(r100);
        }

        public static /* synthetic */ FieldSet access$200(ExtendableMessage r100) {
            return r100.extensions;
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> r100) {
            if (r100.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> r100) {
            verifyExtensionContainingType(r100);
            Object r101 = this.extensions.getField(r100.descriptor);
            if (r101 != null) goto L7;
            return r100.defaultValue;
        L7:
            return (Type) r100.fromFieldSetType(r101);
        }

        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> r100) {
            verifyExtensionContainingType(r100);
            return this.extensions.getRepeatedFieldCount(r100.descriptor);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> r100) {
            verifyExtensionContainingType(r100);
            return this.extensions.hasField(r100.descriptor);
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> r100, int r101) {
            verifyExtensionContainingType(r100);
            return (Type) r100.singularFromFieldSetType(this.extensions.getRepeatedField(r100.descriptor, r101));
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        public boolean parseUnknownField(CodedInputStream r100, CodedOutputStream r101, ExtensionRegistryLite r102, int r110) throws IOException {
            return GeneratedMessageLite.access$100(this.extensions, getDefaultInstanceForType(), r100, r101, r102, r110);
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageLiteOrBuilder {
    }

    public static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {
        final Internal.EnumLiteMap<?> enumTypeMap;
        final boolean isPacked;
        final boolean isRepeated;
        final int number;
        final WireFormat.FieldType type;

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return this.type.getJavaType();
        }

        public Internal.EnumLiteMap<?> getEnumType() {
            return this.enumTypeMap;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return this.type;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.number;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            return this.isPacked;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.isRepeated;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r100) {
            return compareTo((ExtensionDescriptor) r100);
        }

        public int compareTo(ExtensionDescriptor r100) {
            return this.number - r100.number;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder r100, MessageLite r101) {
            return ((Builder) r100).mergeFrom((GeneratedMessageLite) r101);
        }

        public ExtensionDescriptor(Internal.EnumLiteMap<?> r100, int r101, WireFormat.FieldType r102, boolean r103, boolean r104) {
            this.enumTypeMap = r100;
            this.number = r101;
            this.type = r102;
            this.isRepeated = r103;
            this.isPacked = r104;
        }
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> {
        final ContainingType containingTypeDefaultInstance;
        final Type defaultValue;
        final ExtensionDescriptor descriptor;
        final Method enumValueOf;
        final MessageLite messageDefaultInstance;
        final Class singularType;

        public int getNumber() {
            return this.descriptor.getNumber();
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.containingTypeDefaultInstance;
        }

        public MessageLite getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        public Object fromFieldSetType(Object r100) {
            if (this.descriptor.isRepeated() == false) goto L13;
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) goto L11;
            ArrayList r101 = new ArrayList();
            Iterator r102 = ((List) r100).iterator();
        L8:
            if (r102.hasNext() == false) goto L10;
            r101.add(singularFromFieldSetType(r102.next()));
            goto L8
        L10:
            return r101;
        L11:
            return r100;
        L13:
            return singularFromFieldSetType(r100);
        }

        public Object singularFromFieldSetType(Object r100) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) goto L5;
            return r100;
        L5:
            return GeneratedMessageLite.invokeOrDie(this.enumValueOf, null, new Object[]{(Integer) r100});
        }

        public Object singularToFieldSetType(Object r100) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) goto L5;
            return r100;
        L5:
            return Integer.valueOf(((Internal.EnumLite) r100).getNumber());
        }

        public GeneratedExtension(ContainingType r100, Type r101, MessageLite r102, ExtensionDescriptor r103, Class r104) {
            if (r100 == null) goto L16;
            if (r103.getLiteType() != WireFormat.FieldType.MESSAGE) goto L10;
            if (r102 != null) goto L10;
            throw new IllegalArgumentException("Null messageDefaultInstance");
        L10:
            this.containingTypeDefaultInstance = r100;
            this.defaultValue = r101;
            this.messageDefaultInstance = r102;
            this.descriptor = r103;
            this.singularType = r104;
            if (Internal.EnumLite.class.isAssignableFrom(r104) == false) goto L13;
            this.enumValueOf = GeneratedMessageLite.getMethodOrDie(r104, "valueOf", new Class[]{Integer.TYPE});
            return;
        L13:
            this.enumValueOf = null;
            return;
        L16:
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
    }

    public void makeExtensionsImmutable() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<? extends MessageLite> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public GeneratedMessageLite() {
    }

    public GeneratedMessageLite(Builder r100) {
    }

    static Method getMethodOrDie(Class r100, String r101, Class... r102) {
        return r100.getMethod(r101, r102);
    L4:
        e = move-exception;
        String r103 = r100.getName();
        String r104 = String.valueOf(r101);
        StringBuilder r105 = new StringBuilder((r103.length() + 45) + r104.length());
        r105.append("Generated message class \"");
        r105.append(r103);
        r105.append("\" missing method \"");
        r105.append(r104);
        r105.append("\".");
        throw new RuntimeException(r105.toString(), e);
    }

    static Object invokeOrDie(Method r100, Object r101, Object... r102) {
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

    public boolean parseUnknownField(CodedInputStream r100, CodedOutputStream r101, ExtensionRegistryLite r102, int r103) throws IOException {
        return r100.skipField(r103, r101);
    }

    public static /* synthetic */ boolean access$100(FieldSet r100, MessageLite r101, CodedInputStream r102, CodedOutputStream r103, ExtensionRegistryLite r104, int r105) throws IOException {
        return parseUnknownField(r100, r101, r102, r103, r104, r105);
    }

    private static <MessageType extends MessageLite> boolean parseUnknownField(FieldSet<ExtensionDescriptor> r100, MessageType r101, CodedInputStream r102, CodedOutputStream r103, ExtensionRegistryLite r104, int r110) throws IOException {
        int r105 = WireFormat.getTagWireType(r110);
        GeneratedExtension r106 = r104.findLiteExtensionByNumber(r101, WireFormat.getTagFieldNumber(r110));
        if (r106 != null) goto L7;
    L4:
        boolean r107 = true;
    L5:
        boolean r108 = false;
    L16:
        if (r107 == true) goto L18;
        if (r108 == false) goto L32;
        int r109 = r102.pushLimit(r102.readRawVarint32());
        if (r106.descriptor.getLiteType() != WireFormat.FieldType.ENUM) goto L29;
    L23:
        if (r102.getBytesUntilLimit() <= 0) goto L31;
        int r111 = r102.readEnum();
        Internal.EnumLite r112 = r106.descriptor.getEnumType().findValueByNumber(r111);
        if (r112 == null) goto L26;
        r100.addRepeatedField(r106.descriptor, r106.singularToFieldSetType(r112));
        goto L23
    L26:
        return true;
    L31:
        r102.popLimit(r109);
    L59:
        return true;
    L29:
        if (r102.getBytesUntilLimit() <= 0) goto L31;
        Object r113 = FieldSet.readPrimitiveField(r102, r106.descriptor.getLiteType(), false);
        r100.addRepeatedField(r106.descriptor, r113);
        goto L29
    L32:
        int r114 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[r106.descriptor.getLiteJavaType().ordinal()];
        if (r114 == 1) goto L43;
        if (r114 == 2) goto L37;
        Object r115 = FieldSet.readPrimitiveField(r102, r106.descriptor.getLiteType(), false);
    L56:
        if (r106.descriptor.isRepeated() == false) goto L58;
        r100.addRepeatedField(r106.descriptor, r106.singularToFieldSetType(r115));
        goto L59
    L58:
        r100.setField(r106.descriptor, r106.singularToFieldSetType(r115));
        goto L59
    L37:
        int r116 = r102.readEnum();
        Internal.EnumLite r117 = r106.descriptor.getEnumType().findValueByNumber(r116);
        if (r117 != null) goto L41;
        r103.writeRawVarint32(r110);
        r103.writeUInt32NoTag(r116);
        return true;
    L41:
        r115 = r117;
        goto L56
    L43:
        if (r106.descriptor.isRepeated() == true) goto L47;
        MessageLite r118 = (MessageLite) r100.getField(r106.descriptor);
        if (r118 == null) goto L47;
        MessageLite.Builder r119 = r118.toBuilder();
    L48:
        if (r119 != null) goto L51;
        r119 = r106.getMessageDefaultInstance().newBuilderForType();
    L51:
        if (r106.descriptor.getLiteType() != WireFormat.FieldType.GROUP) goto L53;
        r102.readGroup(r106.getNumber(), r119, r104);
    L54:
        r115 = r119.build();
        goto L56
    L53:
        r102.readMessage(r119, r104);
    L47:
        r119 = null;
        goto L48
    L18:
        return r102.skipField(r110, r103);
    L7:
        if (r105 != FieldSet.getWireFormatForFieldType(r106.descriptor.getLiteType(), false)) goto L9;
        r107 = false;
        goto L5
    L9:
        ExtensionDescriptor r120 = r106.descriptor;
        if (r120.isRepeated == false) goto L4;
        if (r120.type.isPackable() == false) goto L4;
        if (r105 != FieldSet.getWireFormatForFieldType(r106.descriptor.getLiteType(), true)) goto L4;
        r107 = false;
        r108 = true;
        goto L16
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType r110, MessageLite r111, Internal.EnumLiteMap<?> r112, int r113, WireFormat.FieldType r114, boolean r115, Class r116) {
        return new GeneratedExtension(r110, Collections.emptyList(), r111, new ExtensionDescriptor(r112, r113, r114, true, r115), r116);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType r100, Type r101, MessageLite r110, Internal.EnumLiteMap<?> r111, int r112, WireFormat.FieldType r113, Class r114) {
        return new GeneratedExtension(r100, r101, r110, new ExtensionDescriptor(r111, r112, r113, false, false), r114);
    }
}
