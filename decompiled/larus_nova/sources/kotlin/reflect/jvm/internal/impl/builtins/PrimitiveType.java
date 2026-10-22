package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public final enum PrimitiveType extends Enum<PrimitiveType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PrimitiveType[] $VALUES = null;
    public static final PrimitiveType BOOLEAN = null;
    public static final PrimitiveType BYTE = null;
    public static final PrimitiveType CHAR = null;
    public static final Companion Companion = null;
    public static final PrimitiveType DOUBLE = null;
    public static final PrimitiveType FLOAT = null;
    public static final PrimitiveType INT = null;
    public static final PrimitiveType LONG = null;
    public static final Set<PrimitiveType> NUMBER_TYPES = null;
    public static final PrimitiveType SHORT = null;
    private final Lazy arrayTypeFqName$delegate;
    private final Name arrayTypeName;
    private final Lazy typeFqName$delegate;
    private final Name typeName;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    private static final /* synthetic */ PrimitiveType[] $values() {
        return new PrimitiveType[]{BOOLEAN, CHAR, BYTE, SHORT, INT, FLOAT, LONG, DOUBLE};
    }

    public static /* synthetic */ FqName accessor$PrimitiveType$lambda0(PrimitiveType r100) {
        return typeFqName_delegate$lambda$0(r100);
    }

    public static /* synthetic */ FqName accessor$PrimitiveType$lambda1(PrimitiveType r100) {
        return arrayTypeFqName_delegate$lambda$1(r100);
    }

    static {
        BOOLEAN = new PrimitiveType("BOOLEAN", 0, "Boolean");
        PrimitiveType r100 = new PrimitiveType("CHAR", 1, "Char");
        CHAR = r100;
        PrimitiveType r101 = new PrimitiveType("BYTE", 2, "Byte");
        BYTE = r101;
        PrimitiveType r102 = new PrimitiveType("SHORT", 3, "Short");
        SHORT = r102;
        PrimitiveType r103 = new PrimitiveType("INT", 4, "Int");
        INT = r103;
        PrimitiveType r104 = new PrimitiveType("FLOAT", 5, "Float");
        FLOAT = r104;
        PrimitiveType r105 = new PrimitiveType("LONG", 6, "Long");
        LONG = r105;
        PrimitiveType r110 = new PrimitiveType("DOUBLE", 7, "Double");
        DOUBLE = r110;
        PrimitiveType[] r111 = $values();
        $VALUES = r111;
        $ENTRIES = EnumEntriesKt.enumEntries(r111);
        Companion = new Companion(null);
        NUMBER_TYPES = SetsKt.setOf(new PrimitiveType[]{r100, r101, r102, r103, r104, r105, r110});
    }

    public static PrimitiveType[] values() {
        return (PrimitiveType[]) $VALUES.clone();
    }

    public final FqName getArrayTypeFqName() {
        return (FqName) this.arrayTypeFqName$delegate.getValue();
    }

    public final FqName getTypeFqName() {
        return (FqName) this.typeFqName$delegate.getValue();
    }

    public final Name getArrayTypeName() {
        return this.arrayTypeName;
    }

    public final Name getTypeName() {
        return this.typeName;
    }

    private static final FqName arrayTypeFqName_delegate$lambda$1(PrimitiveType r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        return StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(r100.arrayTypeName);
    }

    private static final FqName typeFqName_delegate$lambda$0(PrimitiveType r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        return StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(r100.typeName);
    }

    public static PrimitiveType valueOf(String r100) {
        return (PrimitiveType) a.a(PrimitiveType.class, r100);
    }

    private PrimitiveType(String r100, int r101, String r102) {
        super(r100, r101);
        this.typeName = Name.identifier(r102);
        this.arrayTypeName = Name.identifier(r102 + "Array");
        LazyThreadSafetyMode r103 = LazyThreadSafetyMode.PUBLICATION;
        this.typeFqName$delegate = LazyKt.lazy(r103, new PrimitiveType$$Lambda$0(this));
        this.arrayTypeFqName$delegate = LazyKt.lazy(r103, new PrimitiveType$$Lambda$1(this));
    }
}
