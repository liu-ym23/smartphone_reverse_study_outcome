package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;

/* JADX INFO: loaded from: classes5.dex */
public final class JvmNameResolver extends JvmNameResolverBase {
    private final JvmProtoBuf.StringTableTypes types;

    public JvmNameResolver(JvmProtoBuf.StringTableTypes r100, String[] r101) {
        Intrinsics.checkNotNullParameter(r100, "types");
        Intrinsics.checkNotNullParameter(r101, "strings");
        List<Integer> r102 = r100.getLocalNameList();
        if (r102.isEmpty() == false) goto L5;
        Set r103 = SetsKt.emptySet();
    L6:
        super(r101, r103, JvmNameResolverKt.toExpandedRecordsList(r100.getRecordList()));
        this.types = r100;
        return;
    L5:
        Intrinsics.checkNotNull(r102);
        r103 = CollectionsKt.toSet(r102);
        goto L6
    }
}
