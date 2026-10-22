package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: loaded from: classes5.dex */
public final class ProtoBasedClassDataFinder implements ClassDataFinder {
    private final Map<ClassId, ProtoBuf.Class> classIdToProto;
    private final Function1<ClassId, SourceElement> classSource;
    private final BinaryVersion metadataVersion;
    private final NameResolver nameResolver;

    public final Collection<ClassId> getAllClassIds() {
        return this.classIdToProto.keySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public ClassData findClassData(ClassId r100) {
        Intrinsics.checkNotNullParameter(r100, "classId");
        ProtoBuf.Class r101 = this.classIdToProto.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return new ClassData(this.nameResolver, r101, this.metadataVersion, this.classSource.invoke(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBasedClassDataFinder(ProtoBuf.PackageFragment r100, NameResolver r101, BinaryVersion r102, Function1<? super ClassId, ? extends SourceElement> r103) {
        Intrinsics.checkNotNullParameter(r100, "proto");
        Intrinsics.checkNotNullParameter(r101, "nameResolver");
        Intrinsics.checkNotNullParameter(r102, "metadataVersion");
        Intrinsics.checkNotNullParameter(r103, "classSource");
        this.nameResolver = r101;
        this.metadataVersion = r102;
        this.classSource = r103;
        List<ProtoBuf.Class> r104 = r100.getClass_List();
        LinkedHashMap r105 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r104, 10)), 16));
        Iterator<T> r106 = r104.iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        Object r107 = r106.next();
        r105.put(NameResolverUtilKt.getClassId(this.nameResolver, ((ProtoBuf.Class) r107).getFqName()), r107);
        goto L4
    L6:
        this.classIdToProto = r105;
    }
}
