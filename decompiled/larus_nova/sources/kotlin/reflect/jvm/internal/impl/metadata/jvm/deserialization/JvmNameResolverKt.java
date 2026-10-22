package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;

/* JADX INFO: loaded from: classes5.dex */
public final class JvmNameResolverKt {
    public static final List<JvmProtoBuf.StringTableTypes.Record> toExpandedRecordsList(List<JvmProtoBuf.StringTableTypes.Record> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ArrayList r101 = new ArrayList();
        r101.ensureCapacity(r100.size());
        Iterator<JvmProtoBuf.StringTableTypes.Record> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        JvmProtoBuf.StringTableTypes.Record r103 = r102.next();
        int r104 = r103.getRange();
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L4;
        r101.add(r103);
        r105 = r105 + 1;
        goto L6
    L8:
        r101.trimToSize();
        return r101;
    }
}
