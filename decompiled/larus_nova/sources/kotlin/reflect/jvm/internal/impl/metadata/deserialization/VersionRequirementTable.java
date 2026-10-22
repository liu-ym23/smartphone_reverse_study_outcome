package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.larus.trace.CopyContentTypeString;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* JADX INFO: loaded from: classes5.dex */
public final class VersionRequirementTable {
    public static final Companion Companion = null;
    private static final VersionRequirementTable EMPTY = null;
    private final List<ProtoBuf.VersionRequirement> infos;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final VersionRequirementTable getEMPTY() {
            return VersionRequirementTable.access$getEMPTY$cp();
        }

        public final VersionRequirementTable create(ProtoBuf.VersionRequirementTable r100) {
            Intrinsics.checkNotNullParameter(r100, CopyContentTypeString.TABLE);
            if (r100.getRequirementCount() != 0) goto L6;
            return getEMPTY();
        L6:
            return new VersionRequirementTable(r100.getRequirementList(), null);
        }
    }

    public /* synthetic */ VersionRequirementTable(List r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    static {
        Companion = new Companion(null);
        EMPTY = new VersionRequirementTable(CollectionsKt.emptyList());
    }

    public static final /* synthetic */ VersionRequirementTable access$getEMPTY$cp() {
        return EMPTY;
    }

    private VersionRequirementTable(List<ProtoBuf.VersionRequirement> r100) {
        this.infos = r100;
    }
}
