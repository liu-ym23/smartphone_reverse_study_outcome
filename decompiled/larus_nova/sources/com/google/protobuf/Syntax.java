package com.google.protobuf;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final enum Syntax extends java.lang.Enum<Syntax> implements ProtocolMessageEnum {
    private static final /* synthetic */ Syntax[] $VALUES = null;
    public static final Syntax SYNTAX_PROTO2 = null;
    public static final int SYNTAX_PROTO2_VALUE = 0;
    public static final Syntax SYNTAX_PROTO3 = null;
    public static final int SYNTAX_PROTO3_VALUE = 1;
    public static final Syntax UNRECOGNIZED = null;
    private static final Syntax[] VALUES = null;
    private static final Internal.EnumLiteMap<Syntax> internalValueMap = null;
    private final int value;

    static {
        Syntax r100 = new Syntax("SYNTAX_PROTO2", 0, 0);
        SYNTAX_PROTO2 = r100;
        Syntax r101 = new Syntax("SYNTAX_PROTO3", 1, 1);
        SYNTAX_PROTO3 = r101;
        Syntax r102 = new Syntax("UNRECOGNIZED", 2, -1);
        UNRECOGNIZED = r102;
        $VALUES = new Syntax[]{r100, r101, r102};
        internalValueMap = new AnonymousClass1();
        VALUES = values();
    }

    public static Syntax[] values() {
        return (Syntax[]) $VALUES.clone();
    }

    @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return (Descriptors.EnumDescriptor) ListProtector.get(TypeProto.getDescriptor().getEnumTypes(), 0);
    }

    @Override // com.google.protobuf.ProtocolMessageEnum
    public final Descriptors.EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }

    @Override // com.google.protobuf.ProtocolMessageEnum
    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
        return (Descriptors.EnumValueDescriptor) ListProtector.get(getDescriptor().getValues(), ordinal());
    }

    public static Internal.EnumLiteMap<Syntax> internalGetValueMap() {
        return internalValueMap;
    }

    public static Syntax forNumber(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return SYNTAX_PROTO3;
    L10:
        return SYNTAX_PROTO2;
    }

    public static Syntax valueOf(Descriptors.EnumValueDescriptor r100) {
        if (r100.getType() != getDescriptor()) goto L11;
        if (r100.getIndex() != (-1)) goto L9;
        return UNRECOGNIZED;
    L9:
        return VALUES[r100.getIndex()];
    L11:
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }

    public static Syntax valueOf(String r100) {
        return (Syntax) a.a(Syntax.class, r100);
    }

    public static Syntax valueOf(int r100) {
        return forNumber(r100);
    }

    private Syntax(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
