package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum UnsignedArrayType extends Enum<UnsignedArrayType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ UnsignedArrayType[] $VALUES = null;
    public static final UnsignedArrayType UBYTEARRAY = null;
    public static final UnsignedArrayType UINTARRAY = null;
    public static final UnsignedArrayType ULONGARRAY = null;
    public static final UnsignedArrayType USHORTARRAY = null;
    private final ClassId classId;
    private final Name typeName;

    private static final /* synthetic */ UnsignedArrayType[] $values() {
        return new UnsignedArrayType[]{UBYTEARRAY, USHORTARRAY, UINTARRAY, ULONGARRAY};
    }

    static {
        ClassId.Companion r100 = ClassId.Companion;
        UBYTEARRAY = new UnsignedArrayType("UBYTEARRAY", 0, ClassId.Companion.fromString$default(r100, "kotlin/UByteArray", false, 2, null));
        USHORTARRAY = new UnsignedArrayType("USHORTARRAY", 1, ClassId.Companion.fromString$default(r100, "kotlin/UShortArray", false, 2, null));
        UINTARRAY = new UnsignedArrayType("UINTARRAY", 2, ClassId.Companion.fromString$default(r100, "kotlin/UIntArray", false, 2, null));
        ULONGARRAY = new UnsignedArrayType("ULONGARRAY", 3, ClassId.Companion.fromString$default(r100, "kotlin/ULongArray", false, 2, null));
        UnsignedArrayType[] r101 = $values();
        $VALUES = r101;
        $ENTRIES = EnumEntriesKt.enumEntries(r101);
    }

    public static UnsignedArrayType[] values() {
        return (UnsignedArrayType[]) $VALUES.clone();
    }

    public final Name getTypeName() {
        return this.typeName;
    }

    public static UnsignedArrayType valueOf(String r100) {
        return (UnsignedArrayType) a.a(UnsignedArrayType.class, r100);
    }

    private UnsignedArrayType(String r100, int r101, ClassId r102) {
        super(r100, r101);
        this.classId = r102;
        this.typeName = r102.getShortClassName();
    }
}
