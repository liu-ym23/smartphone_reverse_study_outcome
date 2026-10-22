package com.google.protobuf;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final enum NullValue extends java.lang.Enum<NullValue> implements ProtocolMessageEnum {
    private static final /* synthetic */ NullValue[] $VALUES = null;
    public static final NullValue NULL_VALUE = null;
    public static final int NULL_VALUE_VALUE = 0;
    public static final NullValue UNRECOGNIZED = null;
    private static final NullValue[] VALUES = null;
    private static final Internal.EnumLiteMap<NullValue> internalValueMap = null;
    private final int value;

    static {
        NullValue r100 = new NullValue("NULL_VALUE", 0, 0);
        NULL_VALUE = r100;
        NullValue r101 = new NullValue("UNRECOGNIZED", 1, -1);
        UNRECOGNIZED = r101;
        $VALUES = new NullValue[]{r100, r101};
        internalValueMap = new AnonymousClass1();
        VALUES = values();
    }

    public static NullValue[] values() {
        return (NullValue[]) $VALUES.clone();
    }

    @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return (Descriptors.EnumDescriptor) ListProtector.get(StructProto.getDescriptor().getEnumTypes(), 0);
    }

    @Override // com.google.protobuf.ProtocolMessageEnum
    public final Descriptors.EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }

    @Override // com.google.protobuf.ProtocolMessageEnum
    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
        return (Descriptors.EnumValueDescriptor) ListProtector.get(getDescriptor().getValues(), ordinal());
    }

    public static Internal.EnumLiteMap<NullValue> internalGetValueMap() {
        return internalValueMap;
    }

    public static NullValue forNumber(int r100) {
        if (r100 == 0) goto L6;
        return null;
    L6:
        return NULL_VALUE;
    }

    public static NullValue valueOf(Descriptors.EnumValueDescriptor r100) {
        if (r100.getType() != getDescriptor()) goto L11;
        if (r100.getIndex() != (-1)) goto L9;
        return UNRECOGNIZED;
    L9:
        return VALUES[r100.getIndex()];
    L11:
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }

    public static NullValue valueOf(String r100) {
        return (NullValue) a.a(NullValue.class, r100);
    }

    public static NullValue valueOf(int r100) {
        return forNumber(r100);
    }

    private NullValue(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
