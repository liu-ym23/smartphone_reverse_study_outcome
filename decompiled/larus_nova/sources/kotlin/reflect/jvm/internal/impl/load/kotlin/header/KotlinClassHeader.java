package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public final class KotlinClassHeader {
    private final String[] data;
    private final int extraInt;
    private final String extraString;
    private final String[] incompatibleData;
    private final Kind kind;
    private final JvmMetadataVersion metadataVersion;
    private final String packageName;
    private final byte[] serializedIr;
    private final String[] strings;

    public static final enum Kind extends Enum<Kind> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind CLASS = null;
        public static final Companion Companion = null;
        public static final Kind FILE_FACADE = null;
        public static final Kind MULTIFILE_CLASS = null;
        public static final Kind MULTIFILE_CLASS_PART = null;
        public static final Kind SYNTHETIC_CLASS = null;
        public static final Kind UNKNOWN = null;
        private static final Map<Integer, Kind> entryById = null;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final int f504580id;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            @JvmStatic
            public final Kind getById(int r100) {
                Kind r101 = (Kind) Kind.access$getEntryById$cp().get(Integer.valueOf(r100));
                if (r101 == null) goto L5;
                return r101;
            L5:
                return Kind.UNKNOWN;
            }
        }

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{UNKNOWN, CLASS, FILE_FACADE, SYNTHETIC_CLASS, MULTIFILE_CLASS, MULTIFILE_CLASS_PART};
        }

        @JvmStatic
        public static final Kind getById(int r100) {
            return Companion.getById(r100);
        }

        static {
            int r100 = 0;
            UNKNOWN = new Kind("UNKNOWN", 0, 0);
            CLASS = new Kind("CLASS", 1, 1);
            FILE_FACADE = new Kind("FILE_FACADE", 2, 2);
            SYNTHETIC_CLASS = new Kind("SYNTHETIC_CLASS", 3, 3);
            MULTIFILE_CLASS = new Kind("MULTIFILE_CLASS", 4, 4);
            MULTIFILE_CLASS_PART = new Kind("MULTIFILE_CLASS_PART", 5, 5);
            Kind[] r101 = $values();
            $VALUES = r101;
            $ENTRIES = EnumEntriesKt.enumEntries(r101);
            Companion = new Companion(null);
            Kind[] r102 = values();
            LinkedHashMap r103 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r102.length), 16));
            int r104 = r102.length;
        L3:
            if (r100 >= r104) goto L5;
            Kind r105 = r102[r100];
            r103.put(Integer.valueOf(r105.f504580id), r105);
            r100 = r100 + 1;
            goto L3
        L5:
            entryById = r103;
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }

        public static final /* synthetic */ Map access$getEntryById$cp() {
            return entryById;
        }

        public static Kind valueOf(String r100) {
            return (Kind) a.a(Kind.class, r100);
        }

        private Kind(String r100, int r101, int r102) {
            super(r100, r101);
            this.f504580id = r102;
        }
    }

    private final boolean has(int r100, int r101) {
        if ((r100 & r101) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getMultifileClassName() {
        String r100 = this.extraString;
        if (this.kind != Kind.MULTIFILE_CLASS_PART) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L10;
        return null;
    L10:
        return r100;
    L5:
        r101 = false;
        goto L6
    }

    public final List<String> getMultifilePartNames() {
        String[] r100 = this.data;
        if (this.kind != Kind.MULTIFILE_CLASS) goto L5;
        boolean r101 = true;
    L6:
        List<String> r102 = null;
        if (r101 == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L12;
        r102 = ArraysKt.asList(r100);
    L12:
        if (r102 == null) goto L14;
        return r102;
    L14:
        return CollectionsKt.emptyList();
    L5:
        r101 = false;
        goto L6
    }

    public final boolean isPreRelease() {
        return has(this.extraInt, 2);
    }

    public final boolean isUnstableJvmIrBinary() {
        if (has(this.extraInt, 16) == true) goto L5;
    L7:
        return false;
    L5:
        if (has(this.extraInt, 32) == true) goto L7;
        return true;
    }

    public String toString() {
        return this.kind + " version=" + this.metadataVersion;
    }

    public final String[] getData() {
        return this.data;
    }

    public final String[] getIncompatibleData() {
        return this.incompatibleData;
    }

    public final Kind getKind() {
        return this.kind;
    }

    public final JvmMetadataVersion getMetadataVersion() {
        return this.metadataVersion;
    }

    public final String[] getStrings() {
        return this.strings;
    }

    public KotlinClassHeader(Kind r100, JvmMetadataVersion r101, String[] r102, String[] r103, String[] r104, String r105, int r106, String r107, byte[] r110) {
        Intrinsics.checkNotNullParameter(r100, "kind");
        Intrinsics.checkNotNullParameter(r101, "metadataVersion");
        this.kind = r100;
        this.metadataVersion = r101;
        this.data = r102;
        this.incompatibleData = r103;
        this.strings = r104;
        this.extraString = r105;
        this.extraInt = r106;
        this.packageName = r107;
        this.serializedIr = r110;
    }
}
