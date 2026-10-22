package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class DescriptorKindFilter {
    public static final DescriptorKindFilter ALL = null;
    private static final int ALL_KINDS_MASK = 0;
    public static final DescriptorKindFilter CALLABLES = null;
    private static final int CALLABLES_MASK = 0;
    public static final DescriptorKindFilter CLASSIFIERS = null;
    private static final int CLASSIFIERS_MASK = 0;
    public static final Companion Companion = null;
    private static final List<Companion.MaskToName> DEBUG_MASK_BIT_NAMES = null;
    private static final List<Companion.MaskToName> DEBUG_PREDEFINED_FILTERS_MASK_NAMES = null;
    public static final DescriptorKindFilter FUNCTIONS = null;
    private static final int FUNCTIONS_MASK = 0;
    public static final DescriptorKindFilter NON_SINGLETON_CLASSIFIERS = null;
    private static final int NON_SINGLETON_CLASSIFIERS_MASK = 0;
    public static final DescriptorKindFilter PACKAGES = null;
    private static final int PACKAGES_MASK = 0;
    public static final DescriptorKindFilter SINGLETON_CLASSIFIERS = null;
    private static final int SINGLETON_CLASSIFIERS_MASK = 0;
    public static final DescriptorKindFilter TYPE_ALIASES = null;
    private static final int TYPE_ALIASES_MASK = 0;
    public static final DescriptorKindFilter VALUES = null;
    private static final int VALUES_MASK = 0;
    public static final DescriptorKindFilter VARIABLES = null;
    private static final int VARIABLES_MASK = 0;
    private static int nextMaskValue;
    private final List<DescriptorKindExclude> excludes;
    private final int kindMask;

    public static final class Companion {

        public static final class MaskToName {
            private final int mask;
            private final String name;

            public final int getMask() {
                return this.mask;
            }

            public final String getName() {
                return this.name;
            }

            public MaskToName(int r100, String r101) {
                Intrinsics.checkNotNullParameter(r101, "name");
                this.mask = r100;
                this.name = r101;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final int nextMask() {
            int r100 = DescriptorKindFilter.access$getNextMaskValue$cp();
            DescriptorKindFilter.access$setNextMaskValue$cp(DescriptorKindFilter.access$getNextMaskValue$cp() << 1);
            return r100;
        }

        public final int getALL_KINDS_MASK() {
            return DescriptorKindFilter.access$getALL_KINDS_MASK$cp();
        }

        public final int getCLASSIFIERS_MASK() {
            return DescriptorKindFilter.access$getCLASSIFIERS_MASK$cp();
        }

        public final int getFUNCTIONS_MASK() {
            return DescriptorKindFilter.access$getFUNCTIONS_MASK$cp();
        }

        public final int getNON_SINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.access$getNON_SINGLETON_CLASSIFIERS_MASK$cp();
        }

        public final int getPACKAGES_MASK() {
            return DescriptorKindFilter.access$getPACKAGES_MASK$cp();
        }

        public final int getSINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.access$getSINGLETON_CLASSIFIERS_MASK$cp();
        }

        public final int getTYPE_ALIASES_MASK() {
            return DescriptorKindFilter.access$getTYPE_ALIASES_MASK$cp();
        }

        public final int getVARIABLES_MASK() {
            return DescriptorKindFilter.access$getVARIABLES_MASK$cp();
        }

        public static final /* synthetic */ int access$nextMask(Companion r100) {
            return r100.nextMask();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Companion r100 = new Companion(null);
        Companion = r100;
        nextMaskValue = 1;
        int r101 = Companion.access$nextMask(r100);
        NON_SINGLETON_CLASSIFIERS_MASK = r101;
        int r102 = Companion.access$nextMask(r100);
        SINGLETON_CLASSIFIERS_MASK = r102;
        int r103 = Companion.access$nextMask(r100);
        TYPE_ALIASES_MASK = r103;
        int r104 = Companion.access$nextMask(r100);
        PACKAGES_MASK = r104;
        int r105 = Companion.access$nextMask(r100);
        FUNCTIONS_MASK = r105;
        int r106 = Companion.access$nextMask(r100);
        VARIABLES_MASK = r106;
        int r107 = Companion.access$nextMask(r100) - 1;
        ALL_KINDS_MASK = r107;
        int r108 = (r101 | r102) | r103;
        CLASSIFIERS_MASK = r108;
        int r110 = (r102 | r105) | r106;
        VALUES_MASK = r110;
        int r111 = r105 | r106;
        CALLABLES_MASK = r111;
        int r112 = 2;
        ALL = new DescriptorKindFilter(r107, 0 == true ? 1 : 0, r112, 0 == true ? 1 : 0);
        CALLABLES = new DescriptorKindFilter(r111, 0 == true ? 1 : 0, r112, 0 == true ? 1 : 0);
        NON_SINGLETON_CLASSIFIERS = new DescriptorKindFilter(r101, 0 == true ? 1 : 0, r112, 0 == true ? 1 : 0);
        SINGLETON_CLASSIFIERS = new DescriptorKindFilter(r102, 0 == true ? 1 : 0, r112, 0 == true ? 1 : 0);
        TYPE_ALIASES = new DescriptorKindFilter(r103, 0 == true ? 1 : 0, r112, 0 == true ? 1 : 0);
        CLASSIFIERS = new DescriptorKindFilter(r108, 0 == true ? 1 : 0, r112, 0 == true ? 1 : 0);
        PACKAGES = new DescriptorKindFilter(r104, 0 == true ? 1 : 0, r112, 0 == true ? 1 : 0);
        FUNCTIONS = new DescriptorKindFilter(r105, 0 == true ? 1 : 0, r112, 0 == true ? 1 : 0);
        VARIABLES = new DescriptorKindFilter(r106, 0 == true ? 1 : 0, r112, 0 == true ? 1 : 0);
        VALUES = new DescriptorKindFilter(r110, 0 == true ? 1 : 0, r112, 0 == true ? 1 : 0);
        Field[] r109 = DescriptorKindFilter.class.getFields();
        ArrayList r113 = new ArrayList();
        int r114 = r109.length;
        int r115 = 0;
    L3:
        if (r115 >= r114) goto L8;
        Field r116 = r109[r115];
        if (Modifier.isStatic(r116.getModifiers()) == false) goto L7;
        r113.add(r116);
    L7:
        r115 = r115 + 1;
        goto L3
    L8:
        ArrayList r117 = new ArrayList();
        Iterator r118 = r113.iterator();
    L10:
        if (r118.hasNext() == false) goto L20;
        Field r119 = (Field) r118.next();
        Object r120 = r119.get(null);
        if ((r120 instanceof DescriptorKindFilter) == false) goto L14;
        DescriptorKindFilter r121 = (DescriptorKindFilter) r120;
    L15:
        if (r121 == null) goto L17;
        Companion.MaskToName r122 = new Companion.MaskToName(r121.kindMask, r119.getName());
    L18:
        if (r122 == null) goto L10;
        r117.add(r122);
        goto L10
    L17:
        r122 = null;
        goto L18
    L14:
        r121 = null;
        goto L15
    L20:
        DEBUG_PREDEFINED_FILTERS_MASK_NAMES = r117;
        Field[] r123 = DescriptorKindFilter.class.getFields();
        ArrayList r124 = new ArrayList();
        int r125 = r123.length;
        int r126 = 0;
    L21:
        if (r126 >= r125) goto L26;
        Field r127 = r123[r126];
        if (Modifier.isStatic(r127.getModifiers()) == false) goto L25;
        r124.add(r127);
    L25:
        r126 = r126 + 1;
        goto L21
    L26:
        ArrayList r128 = new ArrayList();
        Iterator r129 = r124.iterator();
    L28:
        if (r129.hasNext() == false) goto L32;
        Object r130 = r129.next();
        if (Intrinsics.areEqual(((Field) r130).getType(), Integer.TYPE) == false) goto L28;
        r128.add(r130);
        goto L28
    L32:
        ArrayList r131 = new ArrayList();
        Iterator r132 = r128.iterator();
    L34:
        if (r132.hasNext() == false) goto L44;
        Field r133 = (Field) r132.next();
        Object r134 = r133.get(null);
        Intrinsics.checkNotNull(r134, "null cannot be cast to non-null type kotlin.Int");
        int r135 = ((Integer) r134).intValue();
        if (r135 != ((-r135) & r135)) goto L38;
        boolean r136 = true;
    L39:
        if (r136 == false) goto L41;
        Companion.MaskToName r137 = new Companion.MaskToName(r135, r133.getName());
    L42:
        if (r137 == null) goto L34;
        r131.add(r137);
        goto L34
    L41:
        r137 = null;
        goto L42
    L38:
        r136 = false;
        goto L39
    L44:
        DEBUG_MASK_BIT_NAMES = r131;
    }

    public int hashCode() {
        return (this.excludes.hashCode() * 31) + this.kindMask;
    }

    public String toString() {
        Iterator<T> r100 = DEBUG_PREDEFINED_FILTERS_MASK_NAMES.iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((Companion.MaskToName) r101).getMask() != this.kindMask) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        Companion.MaskToName r103 = (Companion.MaskToName) r101;
        if (r103 == null) goto L15;
        String r104 = r103.getName();
    L16:
        if (r104 != null) goto L28;
        List<Companion.MaskToName> r105 = DEBUG_MASK_BIT_NAMES;
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r105.iterator();
    L19:
        if (r107.hasNext() == false) goto L26;
        Companion.MaskToName r108 = (Companion.MaskToName) r107.next();
        if (acceptsKinds(r108.getMask()) == false) goto L23;
        String r109 = r108.getName();
    L24:
        if (r109 == null) goto L19;
        r106.add(r109);
        goto L19
    L23:
        r109 = null;
        goto L24
    L26:
        r104 = CollectionsKt.joinToString$default(r106, " | ", null, null, 0, null, null, 62, null);
    L28:
        return "DescriptorKindFilter(" + r104 + ", " + this.excludes + ')';
    L15:
        r104 = null;
        goto L16
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public static final /* synthetic */ int access$getALL_KINDS_MASK$cp() {
        return ALL_KINDS_MASK;
    }

    public static final /* synthetic */ int access$getCLASSIFIERS_MASK$cp() {
        return CLASSIFIERS_MASK;
    }

    public static final /* synthetic */ int access$getFUNCTIONS_MASK$cp() {
        return FUNCTIONS_MASK;
    }

    public static final /* synthetic */ int access$getNON_SINGLETON_CLASSIFIERS_MASK$cp() {
        return NON_SINGLETON_CLASSIFIERS_MASK;
    }

    public static final /* synthetic */ int access$getNextMaskValue$cp() {
        return nextMaskValue;
    }

    public static final /* synthetic */ int access$getPACKAGES_MASK$cp() {
        return PACKAGES_MASK;
    }

    public static final /* synthetic */ int access$getSINGLETON_CLASSIFIERS_MASK$cp() {
        return SINGLETON_CLASSIFIERS_MASK;
    }

    public static final /* synthetic */ int access$getTYPE_ALIASES_MASK$cp() {
        return TYPE_ALIASES_MASK;
    }

    public static final /* synthetic */ int access$getVARIABLES_MASK$cp() {
        return VARIABLES_MASK;
    }

    public final List<DescriptorKindExclude> getExcludes() {
        return this.excludes;
    }

    public final int getKindMask() {
        return this.kindMask;
    }

    public static final /* synthetic */ void access$setNextMaskValue$cp(int r100) {
        nextMaskValue = r100;
    }

    public final boolean acceptsKinds(int r100) {
        if ((r100 & this.kindMask) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(DescriptorKindFilter.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
        DescriptorKindFilter r102 = (DescriptorKindFilter) r100;
        if (Intrinsics.areEqual(this.excludes, r102.excludes) == true) goto L16;
        return false;
    L16:
        if (this.kindMask == r102.kindMask) goto L18;
        return false;
    L18:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final DescriptorKindFilter restrictedToKindsOrNull(int r100) {
        int r101 = r100 & this.kindMask;
        if (r101 != 0) goto L7;
        return null;
    L7:
        return new DescriptorKindFilter(r101, this.excludes);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DescriptorKindFilter(int r100, List<? extends DescriptorKindExclude> r101) {
        Intrinsics.checkNotNullParameter(r101, "excludes");
        this.excludes = r101;
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r100 = r100 & (~((DescriptorKindExclude) r102.next()).getFullyExcludedDescriptorKinds());
        goto L4
    L6:
        this.kindMask = r100;
    }

    public /* synthetic */ DescriptorKindFilter(int r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        this(r100, r101);
    }
}
