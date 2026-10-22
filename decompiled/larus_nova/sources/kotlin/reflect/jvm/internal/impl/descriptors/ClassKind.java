package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public final enum ClassKind extends Enum<ClassKind> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ClassKind[] $VALUES = null;
    public static final ClassKind ANNOTATION_CLASS = null;
    public static final ClassKind CLASS = null;
    public static final ClassKind ENUM_CLASS = null;
    public static final ClassKind ENUM_ENTRY = null;
    public static final ClassKind INTERFACE = null;
    public static final ClassKind OBJECT = null;
    private final String codeRepresentation;

    private static final /* synthetic */ ClassKind[] $values() {
        return new ClassKind[]{CLASS, INTERFACE, ENUM_CLASS, ENUM_ENTRY, ANNOTATION_CLASS, OBJECT};
    }

    static {
        CLASS = new ClassKind("CLASS", 0, "class");
        INTERFACE = new ClassKind("INTERFACE", 1, "interface");
        ENUM_CLASS = new ClassKind("ENUM_CLASS", 2, "enum class");
        ENUM_ENTRY = new ClassKind("ENUM_ENTRY", 3, null);
        ANNOTATION_CLASS = new ClassKind("ANNOTATION_CLASS", 4, "annotation class");
        OBJECT = new ClassKind("OBJECT", 5, "object");
        ClassKind[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ClassKind[] values() {
        return (ClassKind[]) $VALUES.clone();
    }

    public final boolean isSingleton() {
        if (this != OBJECT) goto L5;
    L8:
        return true;
    L5:
        if (this == ENUM_ENTRY) goto L8;
        return false;
    }

    public static ClassKind valueOf(String r100) {
        return (ClassKind) a.a(ClassKind.class, r100);
    }

    private ClassKind(String r100, int r101, String r102) {
        super(r100, r101);
        this.codeRepresentation = r102;
    }
}
