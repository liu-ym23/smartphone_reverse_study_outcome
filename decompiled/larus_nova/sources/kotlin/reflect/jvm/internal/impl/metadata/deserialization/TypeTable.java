package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* JADX INFO: loaded from: classes5.dex */
public final class TypeTable {
    private final List<ProtoBuf.Type> types;

    public TypeTable(ProtoBuf.TypeTable r100) {
        Intrinsics.checkNotNullParameter(r100, "typeTable");
        List<ProtoBuf.Type> r101 = r100.getTypeList();
        if (r100.hasFirstNullable() == false) goto L15;
        int r102 = r100.getFirstNullable();
        List<ProtoBuf.Type> r103 = r100.getTypeList();
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
        int r106 = 0;
    L6:
        if (r105.hasNext() == false) goto L14;
        Object r107 = r105.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        ProtoBuf.Type r109 = (ProtoBuf.Type) r107;
        if (r106 < r102) goto L13;
        r109 = r109.toBuilder().setNullable(true).build();
    L13:
        r104.add(r109);
        r106 = r108;
        goto L6
    L14:
        r101 = r104;
    L15:
        this.types = r101;
    }

    public final ProtoBuf.Type get(int r100) {
        return (ProtoBuf.Type) ListProtector.get(this.types, r100);
    }
}
