package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public final enum AnnotationArgumentsRenderingPolicy extends Enum<AnnotationArgumentsRenderingPolicy> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AnnotationArgumentsRenderingPolicy[] $VALUES = null;
    public static final AnnotationArgumentsRenderingPolicy ALWAYS_PARENTHESIZED = null;
    public static final AnnotationArgumentsRenderingPolicy NO_ARGUMENTS = null;
    public static final AnnotationArgumentsRenderingPolicy UNLESS_EMPTY = null;
    private final boolean includeAnnotationArguments;
    private final boolean includeEmptyAnnotationArguments;

    private static final /* synthetic */ AnnotationArgumentsRenderingPolicy[] $values() {
        return new AnnotationArgumentsRenderingPolicy[]{NO_ARGUMENTS, UNLESS_EMPTY, ALWAYS_PARENTHESIZED};
    }

    static {
        NO_ARGUMENTS = new AnnotationArgumentsRenderingPolicy("NO_ARGUMENTS", 0, false, false, 3, null);
        UNLESS_EMPTY = new AnnotationArgumentsRenderingPolicy("UNLESS_EMPTY", 1, true, false, 2, null);
        ALWAYS_PARENTHESIZED = new AnnotationArgumentsRenderingPolicy("ALWAYS_PARENTHESIZED", 2, true, true);
        AnnotationArgumentsRenderingPolicy[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static AnnotationArgumentsRenderingPolicy[] values() {
        return (AnnotationArgumentsRenderingPolicy[]) $VALUES.clone();
    }

    public final boolean getIncludeAnnotationArguments() {
        return this.includeAnnotationArguments;
    }

    public final boolean getIncludeEmptyAnnotationArguments() {
        return this.includeEmptyAnnotationArguments;
    }

    public static AnnotationArgumentsRenderingPolicy valueOf(String r100) {
        return (AnnotationArgumentsRenderingPolicy) a.a(AnnotationArgumentsRenderingPolicy.class, r100);
    }

    private AnnotationArgumentsRenderingPolicy(String r100, int r101, boolean r102, boolean r103) {
        super(r100, r101);
        this.includeAnnotationArguments = r102;
        this.includeEmptyAnnotationArguments = r103;
    }

    public /* synthetic */ AnnotationArgumentsRenderingPolicy(String r100, int r101, boolean r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 2) == 0) goto L8;
        r103 = false;
    L8:
        this(r100, r101, r102, r103);
    }
}
