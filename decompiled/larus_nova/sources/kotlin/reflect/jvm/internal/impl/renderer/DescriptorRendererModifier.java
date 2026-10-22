package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public final enum DescriptorRendererModifier extends Enum<DescriptorRendererModifier> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DescriptorRendererModifier[] $VALUES = null;
    public static final DescriptorRendererModifier ACTUAL = null;
    public static final Set<DescriptorRendererModifier> ALL = null;
    public static final Set<DescriptorRendererModifier> ALL_EXCEPT_ANNOTATIONS = null;
    public static final DescriptorRendererModifier ANNOTATIONS = null;
    public static final DescriptorRendererModifier CONST = null;
    public static final Companion Companion = null;
    public static final DescriptorRendererModifier DATA = null;
    public static final DescriptorRendererModifier EXPECT = null;
    public static final DescriptorRendererModifier FUN = null;
    public static final DescriptorRendererModifier INLINE = null;
    public static final DescriptorRendererModifier INNER = null;
    public static final DescriptorRendererModifier LATEINIT = null;
    public static final DescriptorRendererModifier MEMBER_KIND = null;
    public static final DescriptorRendererModifier MODALITY = null;
    public static final DescriptorRendererModifier OVERRIDE = null;
    public static final DescriptorRendererModifier VALUE = null;
    public static final DescriptorRendererModifier VISIBILITY = null;
    private final boolean includeByDefault;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    private static final /* synthetic */ DescriptorRendererModifier[] $values() {
        return new DescriptorRendererModifier[]{VISIBILITY, MODALITY, OVERRIDE, ANNOTATIONS, INNER, MEMBER_KIND, DATA, INLINE, EXPECT, ACTUAL, CONST, LATEINIT, FUN, VALUE};
    }

    static {
        int r100 = 0;
        VISIBILITY = new DescriptorRendererModifier("VISIBILITY", 0, true);
        MODALITY = new DescriptorRendererModifier("MODALITY", 1, true);
        OVERRIDE = new DescriptorRendererModifier("OVERRIDE", 2, true);
        ANNOTATIONS = new DescriptorRendererModifier("ANNOTATIONS", 3, false);
        INNER = new DescriptorRendererModifier("INNER", 4, true);
        MEMBER_KIND = new DescriptorRendererModifier("MEMBER_KIND", 5, true);
        DATA = new DescriptorRendererModifier("DATA", 6, true);
        INLINE = new DescriptorRendererModifier("INLINE", 7, true);
        EXPECT = new DescriptorRendererModifier("EXPECT", 8, true);
        ACTUAL = new DescriptorRendererModifier("ACTUAL", 9, true);
        CONST = new DescriptorRendererModifier("CONST", 10, true);
        LATEINIT = new DescriptorRendererModifier("LATEINIT", 11, true);
        FUN = new DescriptorRendererModifier("FUN", 12, true);
        VALUE = new DescriptorRendererModifier("VALUE", 13, true);
        DescriptorRendererModifier[] r101 = $values();
        $VALUES = r101;
        $ENTRIES = EnumEntriesKt.enumEntries(r101);
        Companion = new Companion(null);
        DescriptorRendererModifier[] r102 = values();
        ArrayList r103 = new ArrayList();
        int r104 = r102.length;
    L3:
        if (r100 >= r104) goto L8;
        DescriptorRendererModifier r105 = r102[r100];
        if (r105.includeByDefault == false) goto L7;
        r103.add(r105);
    L7:
        r100 = r100 + 1;
        goto L3
    L8:
        ALL_EXCEPT_ANNOTATIONS = CollectionsKt.toSet(r103);
        ALL = ArraysKt.toSet(values());
    }

    public static DescriptorRendererModifier[] values() {
        return (DescriptorRendererModifier[]) $VALUES.clone();
    }

    public static DescriptorRendererModifier valueOf(String r100) {
        return (DescriptorRendererModifier) a.a(DescriptorRendererModifier.class, r100);
    }

    private DescriptorRendererModifier(String r100, int r101, boolean r102) {
        super(r100, r101);
        this.includeByDefault = r102;
    }
}
