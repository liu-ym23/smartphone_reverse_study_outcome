package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes5.dex */
public class JvmNameResolverBase implements NameResolver {
    public static final Companion Companion = null;
    private static final List<String> PREDEFINED_STRINGS = null;
    private static final Map<String, Integer> PREDEFINED_STRINGS_MAP = null;

    /* JADX INFO: renamed from: kotlin, reason: collision with root package name */
    private static final String f504582kotlin = null;
    private final Set<Integer> localNameIndices;
    private final List<JvmProtoBuf.StringTableTypes.Record> records;
    private final String[] strings;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            r100[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        Companion = new Companion(null);
        String r100 = CollectionsKt.joinToString$default(CollectionsKt.listOf(new Character[]{'k', 'o', Character.valueOf(OthersPermission.STICKY_E), Character.valueOf(Symlink.UNIX_ID), 'i', 'n'}), "", null, null, 0, null, null, 62, null);
        f504582kotlin = r100;
        List<String> r101 = CollectionsKt.listOf(new String[]{r100 + "/Any", r100 + "/Nothing", r100 + "/Unit", r100 + "/Throwable", r100 + "/Number", r100 + "/Byte", r100 + "/Double", r100 + "/Float", r100 + "/Int", r100 + "/Long", r100 + "/Short", r100 + "/Boolean", r100 + "/Char", r100 + "/CharSequence", r100 + "/String", r100 + "/Comparable", r100 + "/Enum", r100 + "/Array", r100 + "/ByteArray", r100 + "/DoubleArray", r100 + "/FloatArray", r100 + "/IntArray", r100 + "/LongArray", r100 + "/ShortArray", r100 + "/BooleanArray", r100 + "/CharArray", r100 + "/Cloneable", r100 + "/Annotation", r100 + "/collections/Iterable", r100 + "/collections/MutableIterable", r100 + "/collections/Collection", r100 + "/collections/MutableCollection", r100 + "/collections/List", r100 + "/collections/MutableList", r100 + "/collections/Set", r100 + "/collections/MutableSet", r100 + "/collections/Map", r100 + "/collections/MutableMap", r100 + "/collections/Map.Entry", r100 + "/collections/MutableMap.MutableEntry", r100 + "/collections/Iterator", r100 + "/collections/MutableIterator", r100 + "/collections/ListIterator", r100 + "/collections/MutableListIterator"});
        PREDEFINED_STRINGS = r101;
        Iterable r102 = CollectionsKt.withIndex(r101);
        LinkedHashMap r103 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r102, 10)), 16));
        Iterator r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        IndexedValue r105 = (IndexedValue) r104.next();
        r103.put((String) r105.getValue(), Integer.valueOf(r105.getIndex()));
        goto L4
    L6:
        PREDEFINED_STRINGS_MAP = r103;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int r100) {
        return getString(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getString(int r110) {
        JvmProtoBuf.StringTableTypes.Record r100 = (JvmProtoBuf.StringTableTypes.Record) ListProtector.get(this.records, r110);
        if (r100.hasString() == false) goto L6;
        String r111 = r100.getString();
    L16:
        if (r100.getSubstringIndexCount() < 2) goto L24;
        List<Integer> r101 = r100.getSubstringIndexList();
        Intrinsics.checkNotNull(r101);
        Integer r102 = (Integer) ListProtector.get(r101, 0);
        Integer r103 = (Integer) ListProtector.get(r101, 1);
        if (r102.intValue() < 0) goto L24;
        if (r102.intValue() > r103.intValue()) goto L24;
        if (r103.intValue() > r111.length()) goto L24;
        Intrinsics.checkNotNull(r111);
        Intrinsics.checkNotNull(r102);
        int r104 = r102.intValue();
        Intrinsics.checkNotNull(r103);
        r111 = r111.substring(r104, r103.intValue());
    L24:
        String r105 = r111;
        if (r100.getReplaceCharCount() < 2) goto L27;
        List<Integer> r112 = r100.getReplaceCharList();
        Intrinsics.checkNotNull(r112);
        Integer r106 = (Integer) ListProtector.get(r112, 0);
        Integer r113 = (Integer) ListProtector.get(r112, 1);
        Intrinsics.checkNotNull(r105);
        r105 = StringsKt.replace$default(r105, (char) r106.intValue(), (char) r113.intValue(), false, 4, null);
    L27:
        String r107 = r105;
        JvmProtoBuf.StringTableTypes.Record.Operation r114 = r100.getOperation();
        if (r114 != null) goto L30;
        r114 = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
    L30:
        int r115 = WhenMappings.$EnumSwitchMapping$0[r114.ordinal()];
        if (r115 == 1) goto L42;
        if (r115 != 2) goto L34;
        Intrinsics.checkNotNull(r107);
        r107 = StringsKt.replace$default(r107, Typography.dollar, '.', false, 4, null);
        goto L42
    L34:
        if (r115 != 3) goto L40;
        if (r107.length() < 2) goto L38;
        Intrinsics.checkNotNull(r107);
        r107 = r107.substring(1, r107.length() - 1);
    L38:
        String r108 = r107;
        Intrinsics.checkNotNull(r108);
        r107 = StringsKt.replace$default(r108, Typography.dollar, '.', false, 4, null);
        goto L42
    L40:
        throw new NoWhenBranchMatchedException();
    L42:
        Intrinsics.checkNotNull(r107);
        return r107;
    L6:
        if (r100.hasPredefinedIndex() == false) goto L14;
        List<String> r109 = PREDEFINED_STRINGS;
        int r116 = r109.size();
        int r117 = r100.getPredefinedIndex();
        if (r117 < 0) goto L11;
        if (r117 >= r116) goto L11;
        boolean r118 = true;
    L12:
        if (r118 == false) goto L14;
        r111 = (String) ListProtector.get(r109, r100.getPredefinedIndex());
    L11:
        r118 = false;
    L14:
        r111 = this.strings[r110];
        goto L16
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int r100) {
        return this.localNameIndices.contains(Integer.valueOf(r100));
    }

    public JvmNameResolverBase(String[] r100, Set<Integer> r101, List<JvmProtoBuf.StringTableTypes.Record> r102) {
        Intrinsics.checkNotNullParameter(r100, "strings");
        Intrinsics.checkNotNullParameter(r101, "localNameIndices");
        Intrinsics.checkNotNullParameter(r102, "records");
        this.strings = r100;
        this.localNameIndices = r101;
        this.records = r102;
    }
}
