package com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes23.dex */
public class ExtensionRegistry extends ExtensionRegistryLite {
    static final ExtensionRegistry EMPTY_REGISTRY = null;
    private final Map<String, ExtensionInfo> immutableExtensionsByName;
    private final Map<DescriptorIntPair, ExtensionInfo> immutableExtensionsByNumber;
    private final Map<String, ExtensionInfo> mutableExtensionsByName;
    private final Map<DescriptorIntPair, ExtensionInfo> mutableExtensionsByNumber;

    /* JADX INFO: renamed from: com.google.protobuf.ExtensionRegistry$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Extension$ExtensionType = null;

        static {
            int[] r100 = new int[Extension.ExtensionType.values().length];
            $SwitchMap$com$google$protobuf$Extension$ExtensionType = r100;
            r100[Extension.ExtensionType.IMMUTABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$protobuf$Extension$ExtensionType[Extension.ExtensionType.MUTABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final class DescriptorIntPair {
        private final Descriptors.Descriptor descriptor;
        private final int number;

        public int hashCode() {
            return (this.descriptor.hashCode() * 65535) + this.number;
        }

        public static /* synthetic */ Descriptors.Descriptor access$000(DescriptorIntPair r100) {
            return r100.descriptor;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof DescriptorIntPair) == true) goto L5;
            return false;
        L5:
            DescriptorIntPair r101 = (DescriptorIntPair) r100;
            if (this.descriptor == r101.descriptor) goto L8;
            return false;
        L8:
            if (this.number != r101.number) goto L12;
            return true;
        L12:
            return false;
        }

        public DescriptorIntPair(Descriptors.Descriptor r100, int r101) {
            this.descriptor = r100;
            this.number = r101;
        }
    }

    public static final class ExtensionInfo {
        public final Message defaultInstance;
        public final Descriptors.FieldDescriptor descriptor;

        private ExtensionInfo(Descriptors.FieldDescriptor r100) {
            this.descriptor = r100;
            this.defaultInstance = null;
        }

        private ExtensionInfo(Descriptors.FieldDescriptor r100, Message r101) {
            this.descriptor = r100;
            this.defaultInstance = r101;
        }

        public /* synthetic */ ExtensionInfo(Descriptors.FieldDescriptor r100, Message r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    static {
        EMPTY_REGISTRY = new ExtensionRegistry(true);
    }

    public static ExtensionRegistry newInstance() {
        return new ExtensionRegistry();
    }

    @Override // com.google.protobuf.ExtensionRegistryLite
    public ExtensionRegistry getUnmodifiable() {
        return new ExtensionRegistry(this);
    }

    private ExtensionRegistry() {
        this.immutableExtensionsByName = new HashMap();
        this.mutableExtensionsByName = new HashMap();
        this.immutableExtensionsByNumber = new HashMap();
        this.mutableExtensionsByNumber = new HashMap();
    }

    public static ExtensionRegistry getEmptyRegistry() {
        return EMPTY_REGISTRY;
    }

    @Override // com.google.protobuf.ExtensionRegistryLite
    public /* bridge */ /* synthetic */ ExtensionRegistryLite getUnmodifiable() {
        return getUnmodifiable();
    }

    private ExtensionRegistry(ExtensionRegistry r100) {
        super(r100);
        this.immutableExtensionsByName = Collections.unmodifiableMap(r100.immutableExtensionsByName);
        this.mutableExtensionsByName = Collections.unmodifiableMap(r100.mutableExtensionsByName);
        this.immutableExtensionsByNumber = Collections.unmodifiableMap(r100.immutableExtensionsByNumber);
        this.mutableExtensionsByNumber = Collections.unmodifiableMap(r100.mutableExtensionsByNumber);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ExtensionInfo newExtensionInfo(Extension<?, ?> r100) {
        AnonymousClass1 r101 = null;
        Object[] r102 = 0;
        Object[] r103 = 0;
        if (r100.getDescriptor().getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L11;
        if (r100.getMessageDefaultInstance() == null) goto L9;
        return new ExtensionInfo(r100.getDescriptor(), (Message) r100.getMessageDefaultInstance(), r101);
    L9:
        throw new IllegalStateException("Registered message-type extension had null default instance: " + r100.getDescriptor().getFullName());
    L11:
        return new ExtensionInfo(r100.getDescriptor(), r103 == true ? 1 : 0, r102 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void add(Descriptors.FieldDescriptor r100) {
        if (r100.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L7;
        ExtensionInfo r101 = new ExtensionInfo(r100, null, 0 == true ? 1 : 0);
        add(r101, Extension.ExtensionType.IMMUTABLE);
        add(r101, Extension.ExtensionType.MUTABLE);
        return;
    L7:
        throw new IllegalArgumentException("ExtensionRegistry.add() must be provided a default instance when adding an embedded message extension.");
    }

    public ExtensionInfo findExtensionByName(String r100) {
        return findImmutableExtensionByName(r100);
    }

    public ExtensionInfo findImmutableExtensionByName(String r100) {
        return this.immutableExtensionsByName.get(r100);
    }

    public ExtensionInfo findMutableExtensionByName(String r100) {
        return this.mutableExtensionsByName.get(r100);
    }

    public Set<ExtensionInfo> getAllImmutableExtensionsByExtendedType(String r100) {
        HashSet r101 = new HashSet();
        Iterator<DescriptorIntPair> r102 = this.immutableExtensionsByNumber.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        DescriptorIntPair r103 = r102.next();
        if (DescriptorIntPair.access$000(r103).getFullName().equals(r100) == false) goto L4;
        r101.add(this.immutableExtensionsByNumber.get(r103));
        goto L4
    L8:
        return r101;
    }

    public Set<ExtensionInfo> getAllMutableExtensionsByExtendedType(String r100) {
        HashSet r101 = new HashSet();
        Iterator<DescriptorIntPair> r102 = this.mutableExtensionsByNumber.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        DescriptorIntPair r103 = r102.next();
        if (DescriptorIntPair.access$000(r103).getFullName().equals(r100) == false) goto L4;
        r101.add(this.mutableExtensionsByNumber.get(r103));
        goto L4
    L8:
        return r101;
    }

    public ExtensionRegistry(boolean r100) {
        super(ExtensionRegistryLite.EMPTY_REGISTRY_LITE);
        this.immutableExtensionsByName = Collections.emptyMap();
        this.mutableExtensionsByName = Collections.emptyMap();
        this.immutableExtensionsByNumber = Collections.emptyMap();
        this.mutableExtensionsByNumber = Collections.emptyMap();
    }

    public void add(Extension<?, ?> r100) {
        if (r100.getExtensionType() != Extension.ExtensionType.IMMUTABLE) goto L5;
    L7:
        add(newExtensionInfo(r100), r100.getExtensionType());
        return;
    L5:
        if (r100.getExtensionType() == Extension.ExtensionType.MUTABLE) goto L7;
    }

    public void add(GeneratedMessage.GeneratedExtension<?, ?> r100) {
        add(r100);
    }

    private void add(ExtensionInfo r100, Extension.ExtensionType r101) {
        if (r100.descriptor.isExtension() == false) goto L22;
        int r102 = AnonymousClass1.$SwitchMap$com$google$protobuf$Extension$ExtensionType[r101.ordinal()];
        if (r102 != 1) goto L7;
        Map<String, ExtensionInfo> r103 = this.immutableExtensionsByName;
        Map<DescriptorIntPair, ExtensionInfo> r104 = this.immutableExtensionsByNumber;
    L11:
        r103.put(r100.descriptor.getFullName(), r100);
        r104.put(new DescriptorIntPair(r100.descriptor.getContainingType(), r100.descriptor.getNumber()), r100);
        Descriptors.FieldDescriptor r105 = r100.descriptor;
        if (r105.getContainingType().getOptions().getMessageSetWireFormat() == true) goto L14;
        return;
    L14:
        if (r105.getType() == Descriptors.FieldDescriptor.Type.MESSAGE) goto L16;
        return;
    L16:
        if (r105.isOptional() == true) goto L18;
        return;
    L18:
        if (r105.getExtensionScope() != r105.getMessageType()) goto L26;
        r103.put(r105.getMessageType().getFullName(), r100);
        return;
    L26:
        return;
    L7:
        if (r102 == 2) goto L9;
        return;
    L9:
        r103 = this.mutableExtensionsByName;
        r104 = this.mutableExtensionsByNumber;
        goto L11
    L22:
        throw new IllegalArgumentException("ExtensionRegistry.add() was given a FieldDescriptor for a regular (non-extension) field.");
    }

    public ExtensionInfo findExtensionByNumber(Descriptors.Descriptor r100, int r101) {
        return findImmutableExtensionByNumber(r100, r101);
    }

    public ExtensionInfo findImmutableExtensionByNumber(Descriptors.Descriptor r100, int r101) {
        return this.immutableExtensionsByNumber.get(new DescriptorIntPair(r100, r101));
    }

    public ExtensionInfo findMutableExtensionByNumber(Descriptors.Descriptor r100, int r101) {
        return this.mutableExtensionsByNumber.get(new DescriptorIntPair(r100, r101));
    }

    public void add(Descriptors.FieldDescriptor r100, Message r101) {
        if (r100.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L7;
        add(new ExtensionInfo(r100, r101, null), Extension.ExtensionType.IMMUTABLE);
        return;
    L7:
        throw new IllegalArgumentException("ExtensionRegistry.add() provided a default instance for a non-message extension.");
    }
}
