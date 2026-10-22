package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public final enum AnnotatedCallableKind extends Enum<AnnotatedCallableKind> {
    private static final /* synthetic */ AnnotatedCallableKind[] $VALUES = null;
    public static final AnnotatedCallableKind FUNCTION = null;
    public static final AnnotatedCallableKind PROPERTY = null;
    public static final AnnotatedCallableKind PROPERTY_GETTER = null;
    public static final AnnotatedCallableKind PROPERTY_SETTER = null;

    static {
        AnnotatedCallableKind r100 = new AnnotatedCallableKind("FUNCTION", 0);
        FUNCTION = r100;
        AnnotatedCallableKind r101 = new AnnotatedCallableKind("PROPERTY", 1);
        PROPERTY = r101;
        AnnotatedCallableKind r102 = new AnnotatedCallableKind("PROPERTY_GETTER", 2);
        PROPERTY_GETTER = r102;
        AnnotatedCallableKind r103 = new AnnotatedCallableKind("PROPERTY_SETTER", 3);
        PROPERTY_SETTER = r103;
        $VALUES = new AnnotatedCallableKind[]{r100, r101, r102, r103};
    }

    public static AnnotatedCallableKind[] values() {
        return (AnnotatedCallableKind[]) $VALUES.clone();
    }

    public static AnnotatedCallableKind valueOf(String r100) {
        return (AnnotatedCallableKind) a.a(AnnotatedCallableKind.class, r100);
    }

    private AnnotatedCallableKind(String r100, int r101) {
        super(r100, r101);
    }
}
