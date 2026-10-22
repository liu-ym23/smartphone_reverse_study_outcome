package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum UnsignedType extends Enum<UnsignedType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ UnsignedType[] $VALUES = null;
    public static final UnsignedType UBYTE = null;
    public static final UnsignedType UINT = null;
    public static final UnsignedType ULONG = null;
    public static final UnsignedType USHORT = null;
    private final ClassId arrayClassId;
    private final ClassId classId;
    private final Name typeName;

    private static final /* synthetic */ UnsignedType[] $values() {
        return new UnsignedType[]{UBYTE, USHORT, UINT, ULONG};
    }

    static {
        ClassId.Companion r100 = ClassId.Companion;
        UBYTE = new UnsignedType("UBYTE", 0, ClassId.Companion.fromString$default(r100, "kotlin/UByte", false, 2, null));
        USHORT = new UnsignedType("USHORT", 1, ClassId.Companion.fromString$default(r100, "kotlin/UShort", false, 2, null));
        UINT = new UnsignedType("UINT", 2, ClassId.Companion.fromString$default(r100, "kotlin/UInt", false, 2, null));
        ULONG = new UnsignedType("ULONG", 3, ClassId.Companion.fromString$default(r100, "kotlin/ULong", false, 2, null));
        UnsignedType[] r101 = $values();
        $VALUES = r101;
        $ENTRIES = EnumEntriesKt.enumEntries(r101);
    }

    public static UnsignedType[] values() {
        return (UnsignedType[]) $VALUES.clone();
    }

    public final ClassId getArrayClassId() {
        return this.arrayClassId;
    }

    public final ClassId getClassId() {
        return this.classId;
    }

    public final Name getTypeName() {
        return this.typeName;
    }

    public static UnsignedType valueOf(String r100) {
        return (UnsignedType) a.a(UnsignedType.class, r100);
    }

    private UnsignedType(String r100, int r101, ClassId r102) {
        super(r100, r101);
        this.classId = r102;
        Name r103 = r102.getShortClassName();
        this.typeName = r103;
        this.arrayClassId = new ClassId(r102.getPackageFqName(), Name.identifier(r103.asString() + "Array"));
    }
}
